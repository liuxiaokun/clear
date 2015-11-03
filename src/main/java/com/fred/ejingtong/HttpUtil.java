package com.fred.ejingtong;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

/**
 * @author Fred Liu(liuxiaokun0410@gmail.com)
 * @version 1.7
 * @since 2015/7/8
 */
public class HttpUtil {

    private static int count = 0;

    public static void get(String sql, String clientId) {

        CloseableHttpClient httpClient = HttpClients.createDefault();

        StringBuffer url = new StringBuffer("http://super.lvmama.com/broker/monitor/excuteSql.do?sql=");
        url.append(sql);
        url.append("&clientId=");
        url.append(clientId);

        HttpGet httpGet = new HttpGet(url.toString().replace(" ", "%20"));
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000).build();//设置请求和传输超时时间
        httpGet.setConfig(requestConfig);

        try {
            HttpResponse response = httpClient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println("code:" + statusCode + "-------- - count:" + count++);

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}