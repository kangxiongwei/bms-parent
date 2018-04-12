package org.kxw.bms.stat.storm.spout;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;
import org.apache.storm.utils.Utils;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.kxw.bms.stat.storm.constants.FieldConstants;
import org.kxw.bms.stat.storm.constants.RedisConstants;
import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * Create by kangxiongwei on 2018/1/2 14:24.
 */
public class ClickSpout extends BaseRichSpout {

    private SpoutOutputCollector collector;
    private Jedis jedis;
    private String host;
    private int port;


    @Override
    public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
        this.collector = collector;
        host = conf.get(RedisConstants.REDIS_HOST_KEY).toString();
        port = Integer.valueOf(conf.get(RedisConstants.REDIS_PORT_KEY).toString());
        jedis = new Jedis(host, port);
    }

    @Override
    public void nextTuple() {
        String content = jedis.rpop("count");
        if (content == null || "nil".equals(content)) {
            Utils.sleep(300);
        } else {
            JSONObject obj = (JSONObject) JSONValue.parse(content);
            String ip = obj.get(FieldConstants.IP).toString();
            String url = obj.get(FieldConstants.URL).toString();
            String clientKey = obj.get(FieldConstants.CLIENT_KEY).toString();
            collector.emit(new Values(ip, url, clientKey));
        }
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields(FieldConstants.IP, FieldConstants.URL, FieldConstants.CLIENT_KEY));
    }
}
