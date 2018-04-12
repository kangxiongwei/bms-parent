package org.kxw.bms.stat.storm.bolt;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Tuple;

import java.util.Map;

/**
 * Create by kangxiongwei on 2018/1/2 12:05.
 */
public class HelloWorldBolt extends BaseRichBolt {

    private int myCount;
    private OutputCollector collector;

    @Override
    public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
        this.collector = collector;
    }

    @Override
    public void execute(Tuple input) {
        String test = input.getStringByField("sentence");
        if ("Hello World".equals(test)) {
            myCount++;
            System.out.println("Found a Hello World! Now My Count is :" + myCount);
        }
        collector.ack(input);
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {

    }
}
