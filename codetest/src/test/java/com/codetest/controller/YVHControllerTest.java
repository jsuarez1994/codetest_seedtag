package com.codetest.controller;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;

import com.codetest.model.Coordinates;
import com.codetest.model.Request;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * The Class YVHControllerTest.
 */
@SpringBootTest
public class YVHControllerTest {

	/** The filtro controller. */
	@Autowired
	private YVHController controller;

	@Value(value = "classpath:requests/request-1.json")
	private Resource request1;

	@Value(value = "classpath:requests/request-2.json")
	private Resource request2;

	@Value(value = "classpath:requests/request-3.json")
	private Resource request3;

	@Value(value = "classpath:requests/request-4.json")
	private Resource request4;

	@Value(value = "classpath:requests/request-5.json")
	private Resource request5;

	@Value(value = "classpath:requests/request-6.json")
	private Resource request6;

	@Value(value = "classpath:requests/request-7.json")
	private Resource request7;

	@Value(value = "classpath:requests/request-8.json")
	private Resource request8;

	@Value(value = "classpath:requests/request-9.json")
	private Resource request9;

	@Value(value = "classpath:requests/request-10.json")
	private Resource request10;

	@Value(value = "classpath:requests/request-11.json")
	private Resource request11;

	@Value(value = "classpath:requests/request-12.json")
	private Resource request12;

	@Value(value = "classpath:requests/request-13.json")
	private Resource request13;

	@Value(value = "classpath:responses/response-1.json")
	private Resource response1;

	@Value(value = "classpath:responses/response-2.json")
	private Resource response2;

	@Value(value = "classpath:responses/response-3.json")
	private Resource response3;

	@Value(value = "classpath:responses/response-4.json")
	private Resource response4;

	@Value(value = "classpath:responses/response-5.json")
	private Resource response5;

	@Value(value = "classpath:responses/response-6.json")
	private Resource response6;

	@Value(value = "classpath:responses/response-7.json")
	private Resource response7;

	@Value(value = "classpath:responses/response-8.json")
	private Resource response8;

	@Value(value = "classpath:responses/response-9.json")
	private Resource response9;

	@Value(value = "classpath:responses/response-10.json")
	private Resource response10;

	@Value(value = "classpath:responses/response-11.json")
	private Resource response11;

	@Value(value = "classpath:responses/response-12.json")
	private Resource response12;

	@Value(value = "classpath:responses/response-13.json")
	private Resource response13;

	@Test
	public void radar_1_OK() throws Exception {

		String jsonRequest = getJSON(request1);
		Type targetRequest = new TypeToken<Request>() {
		}.getType();
		Request tRequest = new Gson().fromJson(jsonRequest, targetRequest);

		String jsonResponse = getJSON(response1);
		Type targetResponse = new TypeToken<Coordinates>() {
		}.getType();
		Coordinates tResponse = new Gson().fromJson(jsonResponse, targetResponse);

		Coordinates response = controller.radar(tRequest).getBody();

		Assert.assertEquals(response, tResponse);
	}
	
	@Test
	public void radar_2_OK() throws Exception {

		String jsonRequest = getJSON(request2);
		Type targetRequest = new TypeToken<Request>() {
		}.getType();
		Request tRequest = new Gson().fromJson(jsonRequest, targetRequest);

		String jsonResponse = getJSON(response2);
		Type targetResponse = new TypeToken<Coordinates>() {
		}.getType();
		Coordinates tResponse = new Gson().fromJson(jsonResponse, targetResponse);

		Coordinates response = controller.radar(tRequest).getBody();

		Assert.assertEquals(response, tResponse);
	}
	
	@Test
	public void radar_3_OK() throws Exception {

		String jsonRequest = getJSON(request3);
		Type targetRequest = new TypeToken<Request>() {
		}.getType();
		Request tRequest = new Gson().fromJson(jsonRequest, targetRequest);

		String jsonResponse = getJSON(response3);
		Type targetResponse = new TypeToken<Coordinates>() {
		}.getType();
		Coordinates tResponse = new Gson().fromJson(jsonResponse, targetResponse);

		Coordinates response = controller.radar(tRequest).getBody();

		Assert.assertEquals(response, tResponse);
	}
	
	@Test
	public void radar_4_OK() throws Exception {

		String jsonRequest = getJSON(request4);
		Type targetRequest = new TypeToken<Request>() {
		}.getType();
		Request tRequest = new Gson().fromJson(jsonRequest, targetRequest);

		String jsonResponse = getJSON(response4);
		Type targetResponse = new TypeToken<Coordinates>() {
		}.getType();
		Coordinates tResponse = new Gson().fromJson(jsonResponse, targetResponse);

		Coordinates response = controller.radar(tRequest).getBody();

		Assert.assertEquals(response, tResponse);
	}
	
	@Test
	public void radar_5_OK() throws Exception {

		String jsonRequest = getJSON(request5);
		Type targetRequest = new TypeToken<Request>() {
		}.getType();
		Request tRequest = new Gson().fromJson(jsonRequest, targetRequest);

		String jsonResponse = getJSON(response5);
		Type targetResponse = new TypeToken<Coordinates>() {
		}.getType();
		Coordinates tResponse = new Gson().fromJson(jsonResponse, targetResponse);

		Coordinates response = controller.radar(tRequest).getBody();

		Assert.assertEquals(response, tResponse);
	}
	
	@Test
	public void radar_6_OK() throws Exception {

		String jsonRequest = getJSON(request6);
		Type targetRequest = new TypeToken<Request>() {
		}.getType();
		Request tRequest = new Gson().fromJson(jsonRequest, targetRequest);

		String jsonResponse = getJSON(response6);
		Type targetResponse = new TypeToken<Coordinates>() {
		}.getType();
		Coordinates tResponse = new Gson().fromJson(jsonResponse, targetResponse);

		Coordinates response = controller.radar(tRequest).getBody();

		Assert.assertEquals(response, tResponse);
	}
	
	@Test
	public void radar_7_OK() throws Exception {

		String jsonRequest = getJSON(request7);
		Type targetRequest = new TypeToken<Request>() {
		}.getType();
		Request tRequest = new Gson().fromJson(jsonRequest, targetRequest);

		String jsonResponse = getJSON(response7);
		Type targetResponse = new TypeToken<Coordinates>() {
		}.getType();
		Coordinates tResponse = new Gson().fromJson(jsonResponse, targetResponse);

		Coordinates response = controller.radar(tRequest).getBody();

		Assert.assertEquals(response, tResponse);
	}
	
	@Test
	public void radar_8_OK() throws Exception {

		String jsonRequest = getJSON(request8);
		Type targetRequest = new TypeToken<Request>() {
		}.getType();
		Request tRequest = new Gson().fromJson(jsonRequest, targetRequest);

		String jsonResponse = getJSON(response8);
		Type targetResponse = new TypeToken<Coordinates>() {
		}.getType();
		Coordinates tResponse = new Gson().fromJson(jsonResponse, targetResponse);

		Coordinates response = controller.radar(tRequest).getBody();

		Assert.assertEquals(response, tResponse);
	}
	
	@Test
	public void radar_9_OK() throws Exception {

		String jsonRequest = getJSON(request9);
		Type targetRequest = new TypeToken<Request>() {
		}.getType();
		Request tRequest = new Gson().fromJson(jsonRequest, targetRequest);

		String jsonResponse = getJSON(response9);
		Type targetResponse = new TypeToken<Coordinates>() {
		}.getType();
		Coordinates tResponse = new Gson().fromJson(jsonResponse, targetResponse);

		Coordinates response = controller.radar(tRequest).getBody();

		Assert.assertEquals(response, tResponse);
	}
	
	@Test
	public void radar_10_OK() throws Exception {

		String jsonRequest = getJSON(request10);
		Type targetRequest = new TypeToken<Request>() {
		}.getType();
		Request tRequest = new Gson().fromJson(jsonRequest, targetRequest);

		String jsonResponse = getJSON(response10);
		Type targetResponse = new TypeToken<Coordinates>() {
		}.getType();
		Coordinates tResponse = new Gson().fromJson(jsonResponse, targetResponse);

		Coordinates response = controller.radar(tRequest).getBody();

		Assert.assertEquals(response, tResponse);
	}
	
	@Test
	public void radar_11_OK() throws Exception {

		String jsonRequest = getJSON(request11);
		Type targetRequest = new TypeToken<Request>() {
		}.getType();
		Request tRequest = new Gson().fromJson(jsonRequest, targetRequest);

		String jsonResponse = getJSON(response11);
		Type targetResponse = new TypeToken<Coordinates>() {
		}.getType();
		Coordinates tResponse = new Gson().fromJson(jsonResponse, targetResponse);

		Coordinates response = controller.radar(tRequest).getBody();

		Assert.assertEquals(response, tResponse);
	}
	
	@Test
	public void radar_12_OK() throws Exception {

		String jsonRequest = getJSON(request12);
		Type targetRequest = new TypeToken<Request>() {
		}.getType();
		Request tRequest = new Gson().fromJson(jsonRequest, targetRequest);

		String jsonResponse = getJSON(response12);
		Type targetResponse = new TypeToken<Coordinates>() {
		}.getType();
		Coordinates tResponse = new Gson().fromJson(jsonResponse, targetResponse);

		Coordinates response = controller.radar(tRequest).getBody();

		Assert.assertEquals(response, tResponse);
	}
	
	@Test
	public void radar_13_OK() throws Exception {

		String jsonRequest = getJSON(request13);
		Type targetRequest = new TypeToken<Request>() {
		}.getType();
		Request tRequest = new Gson().fromJson(jsonRequest, targetRequest);

		String jsonResponse = getJSON(response13);
		Type targetResponse = new TypeToken<Coordinates>() {
		}.getType();
		Coordinates tResponse = new Gson().fromJson(jsonResponse, targetResponse);

		Coordinates response = controller.radar(tRequest).getBody();

		Assert.assertEquals(response, tResponse);
	}

	private String getJSON(Resource resource) throws IOException {
		File file = resource.getFile();
		ObjectMapper jsonMapper = new ObjectMapper();
		JsonNode node = jsonMapper.readTree(file);
		Object json = jsonMapper.readValue(node.toString(), Object.class);
		return jsonMapper.writeValueAsString(json);
	}
}
