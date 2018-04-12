package org.kxw.bms.stat.storm.topology;

import org.apache.storm.Config;
import org.apache.storm.topology.TopologyBuilder;
import org.kxw.bms.stat.storm.bolt.HelloWorldBolt;
import org.kxw.bms.stat.storm.spout.HelloWorldSpout;
import org.kxw.bms.stat.storm.util.TopologyRunner;

/**
 * Create by kangxiongwei on 2018/1/2 12:07.
 */
public class HelloWorldTopology {

    public static void main(String[] args) {
        TopologyBuilder builder = new TopologyBuilder();

        builder.setSpout("randomHelloWorld", new HelloWorldSpout(), 10);
        builder.setBolt("HelloWorldBolt", new HelloWorldBolt(), 2).shuffleGrouping("randomHelloWorld");

        Config config = new Config();

        if (args != null && args.length > 0) {
            config.setNumWorkers(3);
            TopologyRunner.runRemoteTopology(args[0], config, builder.createTopology());
        } else {
            TopologyRunner.runLocalTopology("HelloWorldTopology", config, builder.createTopology(), 10000L);
        }

    }


}
