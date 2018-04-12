package org.kxw.bms.stat.storm.topology;

import org.apache.storm.topology.TopologyBuilder;
import org.kxw.bms.stat.storm.bolt.GeographyBolt;
import org.kxw.bms.stat.storm.bolt.RepeatVisitBolt;
import org.kxw.bms.stat.storm.spout.ClickSpout;
import org.kxw.bms.stat.storm.util.HttpIpResolver;

/**
 * 点击统计
 * Create by kangxiongwei on 2018/1/2 14:11.
 */
public class ClickTopology {

    public static void main(String[] args) {
        TopologyBuilder builder = new TopologyBuilder();
        builder.setSpout("clickSpout", new ClickSpout(), 10);
        //Bolt的第一层
        builder.setBolt("repeatsBolt", new RepeatVisitBolt(), 10).shuffleGrouping("clickSpout");
        builder.setBolt("geographyBolt", new GeographyBolt(new HttpIpResolver()), 10).shuffleGrouping("clickSpout");
        //Bolt的第二层
        //builder.setBolt("totalStats", new VisitStatsBolt(), 1).globalGrouping("repeatsBolt");
        //builder.setBolt("geoStats", new GeoStatsBolt(), 10).fieldsGrouping("geographyBolt", new Fields(FieldConstants.COUNTRY));

    }


}
