package com.bshdjk.cloud.search.canal;

import cn.hutool.core.collection.CollectionUtil;
import cn.throwx.canal.gule.CanalGlue;
import cn.throwx.canal.gule.model.CanalBinLogEvent;
import cn.throwx.canal.gule.model.ModelTable;
import cn.throwx.canal.gule.support.adapter.SourceAdapterFacade;
import cn.throwx.canal.gule.support.processor.BaseCanalBinlogEventProcessor;
import cn.throwx.canal.gule.support.processor.CanalBinlogEventProcessorFactory;

import java.util.List;

/**
 * @author FrozenWatermelon
 */
public class BshCloudCanalGlue implements CanalGlue {

    private final CanalBinlogEventProcessorFactory canalBinlogEventProcessorFactory;

    @Override
    public void process(String content) {
        CanalBinLogEvent event = (CanalBinLogEvent) SourceAdapterFacade.X.adapt(CanalBinLogEvent.class, content);
        ModelTable modelTable = ModelTable.of(event.getDatabase(), event.getTable());
        List<BaseCanalBinlogEventProcessor<?>> baseCanalBinlogEventProcessors = this.canalBinlogEventProcessorFactory.get(modelTable);
        if (CollectionUtil.isEmpty(baseCanalBinlogEventProcessors)) {
            return;
        }
        baseCanalBinlogEventProcessors.forEach((processor) -> {
            processor.process(event);
        });
    }


    private BshCloudCanalGlue(CanalBinlogEventProcessorFactory canalBinlogEventProcessorFactory) {
        this.canalBinlogEventProcessorFactory = canalBinlogEventProcessorFactory;
    }

    public static BshCloudCanalGlue of(CanalBinlogEventProcessorFactory canalBinlogEventProcessorFactory) {
        return new BshCloudCanalGlue(canalBinlogEventProcessorFactory);
    }
}
