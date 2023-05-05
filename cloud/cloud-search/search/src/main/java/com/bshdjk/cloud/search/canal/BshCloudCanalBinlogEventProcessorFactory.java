package com.bshdjk.cloud.search.canal;

import cn.throwx.canal.gule.model.ModelTable;
import cn.throwx.canal.gule.support.processor.BaseCanalBinlogEventProcessor;
import cn.throwx.canal.gule.support.processor.CanalBinlogEventProcessorFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author zhouxd
 * @since 2023/5/4
 */
public class BshCloudCanalBinlogEventProcessorFactory implements CanalBinlogEventProcessorFactory {

    private final ConcurrentMap<ModelTable, List<BaseCanalBinlogEventProcessor<?>>> cache = new ConcurrentHashMap<>(16);

    @Override
    public void register(ModelTable modelTable, BaseCanalBinlogEventProcessor<?> processor) {
        synchronized(this.cache) {
            this.cache.putIfAbsent(modelTable, new LinkedList<>());
            this.cache.get(modelTable).add(processor);
        }
    }

    @Override
    public List<BaseCanalBinlogEventProcessor<?>> get(ModelTable modelTable) {
        return this.cache.get(modelTable);
    }

    private BshCloudCanalBinlogEventProcessorFactory() {
    }

    public static BshCloudCanalBinlogEventProcessorFactory of() {
        return new BshCloudCanalBinlogEventProcessorFactory();
    }
}
