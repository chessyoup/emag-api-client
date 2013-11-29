package com.flow.emag.api.client;

import static com.flow.emag.api.client.Util.sha1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.flow.emag.api.model.Brand;
import com.flow.emag.api.model.Category;
import com.flow.emag.api.model.Order;
import com.flow.emag.api.model.ProductOffer;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class EmagAPIClient {

	private static final Logger LOG = Logger.getLogger(EmagAPIClient.class
			.getName());

	private static final EmagAPIClient instance = new EmagAPIClient();

	private Properties config;

	private CloseableHttpClient httpclient = HttpClients.createDefault();

	private static Gson GSON = new GsonBuilder().setFieldNamingPolicy(
			FieldNamingPolicy.UPPER_CAMEL_CASE).create();

	private EmagAPIClient() {
		this.config = new Properties();
		this.httpclient = HttpClients.createDefault();

		try {
			config.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("resources/config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static EmagAPIClient getClient() {
		return EmagAPIClient.instance;
	}

	public String saveResource(Object resource) throws Exception {
		HttpPost post = buildPost(
				Util.getEmagResourceName(resource.getClass()), resource, null,
				EmagAction.SAVE);
		HttpResponse response = httpclient.execute(post);
		String json = Util.getJsonFromReponse(response);
		LOG.info("Http reponse :" + response.getStatusLine());
		LOG.info("Reponse json :" + json);
		return json;
	}

	public <T> ApiResponse<T> readResourceByEmagId(Class<T> resourceClass,
			String emagId) throws Exception {
		Map<String, String> data = new HashMap<String, String>();
		data.put("emag_id", emagId);
		HttpPost post = buildPost(Util.getEmagResourceName(resourceClass),
				data, null, EmagAction.READ);
		HttpResponse response = httpclient.execute(post);
		String json = Util.getJsonFromReponse(response);
		LOG.info("Http reponse :" + response.getStatusLine() + " , json :"
				+ json);
		return GSON.fromJson(json, getType(resourceClass.getSimpleName()));
	}

	public <T> ApiResponse<T> readResources(Class<T> resourceClass,
			ResourceFilter filter) throws Exception {
		HttpPost post = buildPost(Util.getEmagResourceName(resourceClass),
				null, filter, EmagAction.READ);
		HttpResponse response = httpclient.execute(post);
		String json = Util.getJsonFromReponse(response);
		LOG.info("Http reponse :" + response.getStatusLine() + " , json :"
				+ json);
		return GSON.fromJson(json, getType(resourceClass.getSimpleName()));
	}

	public ApiCountResponse countResource(Class resourceClass) throws Exception {
		HttpPost post = buildPost(Util.getEmagResourceName(resourceClass),
				null, null, EmagAction.COUNT);
		HttpResponse response = httpclient.execute(post);
		String json = Util.getJsonFromReponse(response);
		LOG.info("Http reponse :" + response.getStatusLine());
		LOG.info("Reponse json :" + json);
		return GSON.fromJson(json.toString(), ApiCountResponse.class);
	}

	private HttpPost buildPost(String resource, Object inputData,
			ResourceFilter filter, EmagAction action)
			throws URISyntaxException, UnsupportedEncodingException {
		LOG.info("buildPost :: resource=[" + resource + "],inputData=["
				+ inputData + "], filter=[" + filter + "], action=[" + action
				+ "]");
		HttpPost post = new HttpPost(new URI(config.getProperty("api_url")
				+ resource + "/" + action.toString()));

		Map<String, Object> extraDataParams = new HashMap<String, Object>();

		if (filter != null) {
			extraDataParams.put("currentPage",
					String.valueOf(filter.getCurrentPage()));
			extraDataParams.put("itemsPerPage",
					String.valueOf(filter.getItemsPerPage()));
		}

		String data = Util.serializePostData(inputData, extraDataParams);
		String hash = sha1(data + sha1(config.getProperty("password")));

		Map<String, Object> postDataParams = new HashMap<String, Object>();
		postDataParams.put("code", config.getProperty("code"));
		postDataParams.put("username", config.getProperty("username"));
		postDataParams.put("hash", hash);

		String entityData = inputData != null ? Util.serialize(inputData,
				postDataParams, extraDataParams) : Util.serialize(
				postDataParams, extraDataParams);
		LOG.info("post entity =[" + entityData + "]");
		StringEntity entity = new StringEntity(entityData,
				ContentType.APPLICATION_FORM_URLENCODED);
		post.setEntity(entity);
		return post;
	}

	private Type getType(String resource) {
		if (resource.equals("Category")) {
			return new TypeToken<ApiResponse<Category>>() {
			}.getType();
		} else if (resource.equals("Brand")) {
			return new TypeToken<ApiResponse<Brand>>() {
			}.getType();
		} else if (resource.equals("Product")) {
			return new TypeToken<ApiResponse<Brand>>() {
			}.getType();
		} else if (resource.equals("ProductOffer")) {
			return new TypeToken<ApiResponse<ProductOffer>>() {
			}.getType();
		} else if (resource.equals("Order")) {
			return new TypeToken<ApiResponse<Order>>() {
			}.getType();
		} else {
			return null;
		}
	}

	public static void main(String[] args) throws Exception {
		// EmagClient.getClient().getCategories();

		// EmagClient.getClient().getBrands();
//		 System.out.println(EmagAPIClient.getClient().readResourceByEmagId(Brand.class,
		// "604").getResults().get(0));
		// EmagAPIClient.getClient().countResource(Brand.class);
//		System.out.println(EmagAPIClient.getClient()
//				.readResources(Category.class, new ResourceFilter(1, 1))
//				.getResults().get(0).toString());
//		System.out.println(EmagAPIClient.getClient().countResource(Category.class));
		 
//		System.out.println(EmagAPIClient.getClient().readResources(Category.class, new ResourceFilter(1,100)).getResults().size());

		 BufferedReader bf = new BufferedReader(new FileReader(new
		 File("/home/leo/temp/cat.json")));
		 String line = bf.readLine();
		 bf.close();
		 ApiResponse<Category> cat = GSON.fromJson(line, new
		 TypeToken<ApiResponse<Category>>() {}.getType());
		 System.out.println(cat.getResults().size());
	}
}
