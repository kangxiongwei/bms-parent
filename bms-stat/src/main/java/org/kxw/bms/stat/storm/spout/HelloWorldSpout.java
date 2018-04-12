package org.kxw.bms.stat.storm.spout;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;
import org.apache.storm.utils.Utils;

import java.util.Map;
import java.util.Random;

/**
 * Create by kangxiongwei on 2018/1/2 12:00.
 */
public class HelloWorldSpout extends BaseRichSpout {

    private SpoutOutputCollector collector;
    private int referenceRandom;
    private static final int MAX_RANDOM = 10;

    public HelloWorldSpout() {
        final Random rand = new Random();
        referenceRandom = rand.nextInt(MAX_RANDOM);
    }


    @Override
    public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
        this.collector = collector;
    }

    @Override
    public void nextTuple() {
        Utils.sleep(100);
        final Random rand = new Random();
        int instanceRandom = rand.nextInt(MAX_RANDOM);
        if (instanceRandom == referenceRandom) {
            collector.emit(new Values("Hello World"), "HelloWorld" + instanceRandom);
        } else {
            collector.emit(new Values("Other Random Word"), "OtherRandomWorld" + instanceRandom);
        }
    }

    @Override
    public void ack(Object msgId) {
        System.out.println(msgId + "调用成功");
    }

    @Override
    public void fail(Object msgId) {
        System.out.println(msgId + "调用失败");
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("sentence"));
    }
}
