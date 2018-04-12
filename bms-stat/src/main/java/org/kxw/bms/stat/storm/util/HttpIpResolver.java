package org.kxw.bms.stat.storm.util;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Create by kangxiongwei on 2018/1/2 19:42.
 */
public class HttpIpResolver {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpIpResolver.class);

    private static final String url = "http://api.hostip.info/get_json.php";

    /**
     * 解析IP地址
     *
     * @param ip
     * @return
     */
    public JSONObject resolveIp(String ip) {
        BufferedReader in = null;
        try {
            URL geoUrl = new URL(url + "?ip=" + ip);
            HttpURLConnection connection = (HttpURLConnection) geoUrl.openConnection();
            connection.setRequestProperty("Connection", "keep-alive");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36");
            connection.setRequestMethod("GET");
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            JSONObject json = (JSONObject) JSONValue.parse(in);
            in.close();
            return json;
        } catch (Exception e) {
            LOGGER.error("解析IP={}地址出错，", ip, e);
        } finally {
            try {
                if (in != null) in.close();
            } catch (IOException e) {
                LOGGER.error("解析IP={}时关闭流出错，", ip, e);
            }
        }
        return null;
    }


}
