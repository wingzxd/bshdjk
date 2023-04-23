package com.bshdjk.cloud.search.listener;

import cn.hutool.core.util.StrUtil;
import cn.throwx.canal.gule.model.CanalBinLogResult;
import cn.throwx.canal.gule.support.processor.BaseCanalBinlogEventProcessor;
import com.bshdjk.cloud.search.bo.ZooBO;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.xcontent.XContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * @author YXF
 * @date 2021/01/21
 */
@Component
public class ZooCanalListener extends BaseCanalBinlogEventProcessor<BrandBO> {

    private static final Logger log = LoggerFactory.getLogger(BrandCanalListener.class);

    @Autowired
    private ProductUpdateManager productUpdateManager;
    @Autowired
    private ZooF productFeignClient;

    /**
     * 新增品牌
     */
    @Override
    protected void processInsertInternal(CanalBinLogResult<ZooBO> zooResult) {
            Long zooId = zooResult.getPrimaryKey();
            ServerResponseEntity<EsProductBO> esProductBO = productFeignClient.loadEsProductBO(spuId);
            if (!esProductBO.isSuccess()) {
                throw new Mall4cloudException("创建索引异常");
            }

            IndexRequest request = new IndexRequest(EsIndexEnum.PRODUCT.value());
            request.id(String.valueOf(spuId));
            request.source(Json.toJsonString(esProductBO.getData()), XContentType.JSON);
            try {
                IndexResponse indexResponse = restHighLevelClient.index(request, RequestOptions.DEFAULT);
                log.info(indexResponse.toString());

            } catch (IOException e) {
                log.error(e.toString());
                throw new Mall4cloudException("保存es信息异常", e);
            }
        }
    }

    /**
     * 更新品牌
     * @param result
     */
    @Override
    protected void processUpdateInternal(CanalBinLogResult<ZooBO> result) {
        ZooBO beforeData = result.getBeforeData();
        if (Objects.isNull(beforeData.getName())) {
            return;
        }
        ZooBO afterData = result.getAfterData();
        EsProductBO esProductBO = new EsProductBO();
        if (StrUtil.isNotBlank(beforeData.getName())) {
            esProductBO.setBrandName(afterData.getName());
        }
        if (Objects.nonNull(beforeData.getImgUrl())) {
            esProductBO.setBrandImg(afterData.getImgUrl());
        }
        ServerResponseEntity<List<Long>> responseData = productFeignClient.getSpuIdsByBrandId(afterData.getBrandId());
        productUpdateManager.esUpdateSpuBySpuIds(responseData.getData(), esProductBO);
    }
}
