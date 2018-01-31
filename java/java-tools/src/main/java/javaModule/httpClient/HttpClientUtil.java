package javaModule.httpClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;

/**
 * 使用httpClient方式进行跨网站的数据请求
 */
public class HttpClientUtil {
	public static void main(String[] a) {
		System.err.println(getHttpResponseByGet("http://www.baidu.com/s?wd=httpClient"));

	}

	/**
	 * 根据url,以GET方式,获得HttpResponse
	 * 
	 * @param url
	 * @return
	 */
	public static String getHttpResponseByGet(String url) {
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		String ret = "";
		HttpResponse response = null;
		try {
			response = httpClient.execute(httpGet);
			ret = EntityUtils.toString(response.getEntity());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			/* 断开连接 */
			httpGet.releaseConnection();
		}
		return ret;
	}

	/**
	 * 根据url和参数map，封装为form形式["name":"","passwd":""]，以POST方式获取请求
	 * 
	 * @param url
	 * @param map
	 * @return
	 */
	public static String getHttpResponseByPostInForm(String url, Map<String, String> map) {
		HttpClient client = new DefaultHttpClient();
		String ret = "";
		HttpResponse response = null;
		HttpPost post = new HttpPost(url);
		List<NameValuePair> pairs = new ArrayList<>();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			pairs.add(new BasicNameValuePair(entry.getKey(), (String) entry.getValue()));
		}
		try {
			post.setEntity(new UrlEncodedFormEntity(pairs));
			response = client.execute(post);
			ret = EntityUtils.toString(response.getEntity());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			post.releaseConnection();
		}
		return ret;
	}

	/**
	 * 根据url和参数map，封装为json形式{"name":"","passwd":""}，以POST方式获取请求
	 * 
	 * @param url
	 * @param map
	 * @return
	 */
	public static String getHttpResponseByPostInJson(String url, Map<String, String> map) {
		HttpClient client = new DefaultHttpClient();
		String ret = "";
		HttpResponse response = null;
		HttpPost post = new HttpPost(url);
		JSONObject jsonObject = new JSONObject();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			jsonObject.put(entry.getKey(), (String) entry.getValue());
		}
		StringEntity entity = new StringEntity(jsonObject.toString(), "utf-8");// 解决中文乱码问题
		entity.setContentEncoding("UTF-8");
		entity.setContentType("application/json");
		try {
			post.setEntity(entity);
			response = client.execute(post);
			ret = EntityUtils.toString(response.getEntity());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			post.releaseConnection();
		}
		return ret;
	}
}
