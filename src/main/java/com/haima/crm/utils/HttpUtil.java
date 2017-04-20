package com.haima.crm.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.LoggerFactory;

/**
 * 发送http请求
 */
public class HttpUtil {
	
//	public static void main(String[] args) throws Exception {
//		Map<String, String> params = new ConcurrentHashMap<String, String>();
//		params.put("act", "get_usercansee_dept");
//		params.put("username", "user1");
//		params.put("ticket", "41b99d404b74f5f8bcaa224fa4e40135");
//		String res = HttpUtil.sendHttpPost("https://ums.tongter.com:8443/ums2/api", params);
//		System.out.println(res);
//	}
	
    public static String sendHttpPost(String url, Map<String, String> params) throws Exception {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        httpclient = (CloseableHttpClient) wrapClient(httpclient);
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");

        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        for (String key : params.keySet()) {
            nvps.add(new BasicNameValuePair(key, params.get(key)));
        }
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
        CloseableHttpResponse response2 = httpclient.execute(httpPost);
        String res = "";
        try {
            HttpEntity entity2 = response2.getEntity();
            // do something useful with the response body
            // and ensure it is fully consumed
            res = readRes(entity2.getContent());
            EntityUtils.consume(entity2);
        } catch (Exception e) {
            throw e;
        } finally {
            response2.close();
        }
        return res;
    }

    public static String sendHttpGet(String url) throws Exception {
        URL urls = new URL(url);
        HttpURLConnection uc = (HttpURLConnection) urls.openConnection();
        uc.setRequestMethod("GET");
        uc.setRequestProperty("content-type",
                "text/plain");
        uc.setRequestProperty("charset", "UTF-8");
        uc.setDoInput(true);
        uc.setReadTimeout(30000);
        uc.setConnectTimeout(30000);
        BufferedReader in = new BufferedReader(new InputStreamReader(uc
                .getInputStream(), "utf-8"));
        String readLine = "";
        StringBuilder sb = new StringBuilder();
        while ((readLine = in.readLine()) != null) {
            sb.append(readLine);
        }
        in.close();
        return sb.toString();
    }

    static String readRes(java.io.InputStream inputStream) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
        String readLine = "";
        StringBuilder sb = new StringBuilder();
        while ((readLine = in.readLine()) != null) {
            sb.append(readLine);
        }
        in.close();
        return sb.toString();
    }


    /**
     * 避免HttpClient的”SSLPeerUnverifiedException: peer not authenticated”异常
     * 不用导入SSL证书
     *
     * @param base
     * @return
     */
    public static HttpClient wrapClient(HttpClient base) {
        try {
            SSLContext ctx = SSLContext.getInstance("TLS");


            X509TrustManager tm = new X509TrustManager() {
                @Override
                public void checkClientTrusted(java.security.cert.X509Certificate[] x509Certificates, String s) throws CertificateException {

                }

                @Override
                public void checkServerTrusted(java.security.cert.X509Certificate[] x509Certificates, String s) throws CertificateException {

                }

                @Override
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return new java.security.cert.X509Certificate[0];
                }
            };
            ctx.init(null, new TrustManager[]{tm}, null);
            SSLConnectionSocketFactory ssf = new SSLConnectionSocketFactory(ctx, NoopHostnameVerifier.INSTANCE);
            CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(ssf).build();
            return httpclient;
        } catch (Exception ex) {
            LoggerFactory.getLogger(HttpUtil.class).error("error", ex);
            return HttpClients.createDefault();
        }
    }
}
