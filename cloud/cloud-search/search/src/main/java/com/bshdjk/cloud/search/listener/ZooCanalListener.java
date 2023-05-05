package com.bshdjk.cloud.search.listener;

import cn.throwx.canal.gule.model.CanalBinLogResult;
import cn.throwx.canal.gule.support.processor.BaseCanalBinlogEventProcessor;
import com.bshdjk.cloud.common.exception.BshCloudException;
import com.bshdjk.cloud.common.response.Result;
import com.bshdjk.cloud.common.util.Json;
import com.bshdjk.cloud.demo.api.dto.ZooDTO;
import com.bshdjk.cloud.demo.api.feign.ZooFeignClient;
import com.bshdjk.cloud.search.bo.ZooBO;
import com.bshdjk.cloud.search.constant.EsIndexEnum;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Objects;

/**
 * @author YXF
 * @date 2021/01/21
 */
@Component
@Slf4j
public class ZooCanalListener extends BaseCanalBinlogEventProcessor<ZooBO> {

    @Resource
    private ZooFeignClient zooFeignClient;

    @Resource
    private MapperFacade mapperFacade;

    @Resource
    private RestHighLevelClient restHighLevelClient;

    /**
     * 新增动物园
     */
    @Override
    protected void processInsertInternal(CanalBinLogResult<ZooBO> result) {
        Long zooId = result.getPrimaryKey();
        Result<ZooDTO> zooDTO = zooFeignClient.getZooById(zooId);
        if (!zooDTO.isSucc()) {
            throw new BshCloudException("获取 zoo 信息异常",zooId);
        }

        if (Objects.nonNull(zooDTO.getData())) {
            ZooBO zooBO = mapperFacade.map(zooDTO.getData(), ZooBO.class);
            IndexRequest request = new IndexRequest(EsIndexEnum.ZOO.value());
            request.id(String.valueOf(zooId));
            request.source(Json.toJsonString(zooBO), XContentType.JSON);
            try {
                IndexResponse indexResponse = restHighLevelClient.index(request, RequestOptions.DEFAULT);
                log.info(indexResponse.toString());

            } catch (IOException e) {
                log.error(e.toString());
                throw new BshCloudException("保存es信息异常", e);
            }
        }
    }

    /**
     * 更新动物园
     * @param result
     */
    @Override
    protected void processUpdateInternal(CanalBinLogResult<ZooBO> result) {
        Long zooId = result.getPrimaryKey();

        Result<ZooDTO> zooDTO = zooFeignClient.getZooById(zooId);
        if (!zooDTO.isSucc()) {
            throw new BshCloudException("获取 zoo 信息异常",zooId);
        }
        if (Objects.nonNull(zooDTO.getData())) {
            ZooBO zooBO = mapperFacade.map(zooDTO.getData(), ZooBO.class);
            UpdateRequest request = new UpdateRequest(EsIndexEnum.ZOO.value(), String.valueOf(zooId));
            request.doc(Json.toJsonString(zooBO), XContentType.JSON);
            request.docAsUpsert(true);
            try {
                UpdateResponse updateResponse = restHighLevelClient.update(request, RequestOptions.DEFAULT);
                log.info(updateResponse.toString());
            } catch (IOException e) {
                log.error(e.toString());
                throw new BshCloudException("更新 zoo es信息异常", e);
            }
        }else {
            DeleteRequest deleteRequest =  new DeleteRequest(EsIndexEnum.ZOO.value(), String.valueOf(zooId));
            try {
                DeleteResponse deleteResponse = restHighLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
                log.info(deleteResponse.toString());
            } catch (IOException e) {
                log.error(e.toString());
                throw new BshCloudException("删除 zoo es信息异常", e);
            }
        }
    }
}
