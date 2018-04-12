package org.kxw.bms.stat.storm.util;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.StormSubmitter;
import org.apache.storm.generated.AlreadyAliveException;
import org.apache.storm.generated.AuthorizationException;
import org.apache.storm.generated.InvalidTopologyException;
import org.apache.storm.generated.StormTopology;
import org.apache.storm.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * storm的拓扑运行器
 * Create by kangxiongwei on 2018/1/2 12:08.
 */
public class TopologyRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(TopologyRunner.class);

    /**
     * 本地运行拓扑
     *
     * @param topologyName 拓扑名称
     * @param config       拓扑配置
     * @param topology     拓扑
     * @param millis       运行的毫秒数
     */
    public static void runLocalTopology(String topologyName, Config config, StormTopology topology, Long millis) {
        config.setDebug(true);
        LocalCluster local = new LocalCluster();
        local.submitTopology(topologyName, config, topology);
        Utils.sleep(millis);
        local.killTopology(topologyName);
        local.shutdown();
    }

    /**
     * 在集群上运行拓扑
     *
     * @param topologyName
     * @param config
     * @param topology
     */
    public static void runRemoteTopology(String topologyName, Config config, StormTopology topology) {
        try {
            StormSubmitter.submitTopology(topologyName, config, topology);
        } catch (AlreadyAliveException | InvalidTopologyException | AuthorizationException e) {
            LOGGER.error("run topology {} on cluster failed, ", topologyName, e);
        }
    }

}
