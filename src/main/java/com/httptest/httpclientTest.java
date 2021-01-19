package com.httptest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class httpclientTest {
	public static void main(String[] args) throws URISyntaxException {
		URI uri = new URIBuilder().setScheme("https").setHost("api.seniverse.com")
				.setPath("/v3/weather/now.json").setParameter("key", "w99tf57ghc86thhv")
                .setParameter("language", "zh-Hans")
                .setParameter("location", "beijing")
                .build();
		//1.创建httpclient对象
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		// 2.创建一个httpGet对象
		HttpGet httpGet = new HttpGet(uri);
		CloseableHttpResponse response = null;
		// 3.执行请求调用httpclient的execute(),传入httpGet对象，返回CloseableHttpResponse
		try {
			response = httpClient.execute(httpGet);
			// 4.取得响应结果并处理
			HttpEntity entity = response.getEntity();
			System.out.println(entity);
			String responseString = EntityUtils.toString(entity);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
