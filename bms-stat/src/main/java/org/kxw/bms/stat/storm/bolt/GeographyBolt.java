package org.kxw.bms.stat.storm.bolt;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Tuple;
import org.kxw.bms.stat.storm.util.HttpIpResolver;

import java.util.Map;

/**
 * Create by kangxiongwei on 2018/1/2 20:42.
 */
public class GeographyBolt extends BaseRichBolt {

    private HttpIpResolver resolver;

    public GeographyBolt(HttpIpResolver resolver) {
        this.resolver = resolver;
    }

    @Override
    public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {

    }

    @Override
    public void execute(Tuple input) {

    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {

    }
}
