package org.kxw.bms.stat.storm.bolt;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;
import org.kxw.bms.stat.storm.constants.FieldConstants;
import org.kxw.bms.stat.storm.constants.RedisConstants;
import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * Create by kangxiongwei on 2018/1/2 19:32.
 */
public class RepeatVisitBolt extends BaseRichBolt {

    private OutputCollector collector;
    private Jedis jedis;
    private String host;
    private int port;

    @Override
    public void prepare(Map conf, TopologyContext context, OutputCollector collector) {
        this.collector = collector;
        host = conf.get(RedisConstants.REDIS_HOST_KEY).toString();
        port = Integer.valueOf(conf.get(RedisConstants.REDIS_PORT_KEY).toString());
        jedis = new Jedis(host, port);
    }

    @Override
    public void execute(Tuple input) {
        String ip = input.getStringByField(FieldConstants.IP);
        String clientKey = input.getStringByField(FieldConstants.CLIENT_KEY);
        String url = input.getStringByField(FieldConstants.URL);
        String key = url + ":" + clientKey;
        String value = jedis.get(key);
        if (value == null) {
            jedis.set(key, "visited");
            collector.emit(new Values(clientKey, url, Boolean.TRUE.toString()));
        } else {
            collector.emit(new Values(clientKey, url, Boolean.FALSE.toString()));
        }
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields(FieldConstants.CLIENT_KEY, FieldConstants.URL, FieldConstants.VISITED));
    }
}
