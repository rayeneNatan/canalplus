package com.canalplus.blueprint.stepDefinition;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.put;
import static com.github.tomakehurst.wiremock.client.WireMock.putRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.client.WireMock.verify;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.tomakehurst.wiremock.WireMockServer;

public class StepDefinition {
    protected final Logger log = LogManager.getLogger(getClass());

    private static final String DELIMITER = "\\Z";
    private static final String CREATE_PATH = "/test/subscriber";
    private static final String APPLICATION_JSON = "application/json";
    private static final String HEADER_ACCEPT = "accept";
    private static final String UTF8 = "UTF-8";
    
    private static final String ADDRESS_JSON = "address.json";
    private static final String SUBSCRIBER_JSON = "subscriber.json";
    private static final String CONTRACT_JSON = "contract.json";
    private static final String UPDATED_SUBSCRIBER_JSON = "updatedSubscriber.json";
    
    /* create WireMock server */
    private final WireMockServer wireMockServer = new WireMockServer(options().dynamicPort());

    /* create HttpClient API to represent the client to connect to the server */
    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    
    
    /**
     * call post webservice to add subscriber with advisor connected at FACE
     * @throws Throwable
     */
    protected void saveSubscriber() throws Throwable {
	wireMockServer.start();
	final String jsonString = getResource(SUBSCRIBER_JSON);
	configureFor("localhost", wireMockServer.port());
	createPostMockStub(CREATE_PATH + "/save", jsonString, "content-type", APPLICATION_JSON);
	HttpResponse response = getPostResponse(jsonString, CREATE_PATH + "/save", "content-type", APPLICATION_JSON);

	assertEquals(201, response.getStatusLine().getStatusCode());
	verify(postRequestedFor(urlEqualTo(CREATE_PATH + "/save")).withHeader("content-type",
		equalTo(APPLICATION_JSON)));
	wireMockServer.stop();
    }    

    /**
     * call put webservice to update address of the created subscriber 
     * @throws Throwable
     */
    protected void updateAddress() throws Throwable {
	wireMockServer.start();

	final String jsonString = getResource(ADDRESS_JSON);
	configureFor("localhost", wireMockServer.port());
	createPutMockStub(CREATE_PATH + "/1", jsonString, "content-type", APPLICATION_JSON, "country");
	HttpResponse response = getPutResponse(jsonString, CREATE_PATH + "/1", "content-type", APPLICATION_JSON);

	assertEquals(200, response.getStatusLine().getStatusCode());
	verify(putRequestedFor(urlEqualTo(CREATE_PATH + "/1")).withHeader("content-type", equalTo(APPLICATION_JSON)));

	wireMockServer.stop();
    }

    /**
     * call get webservice to get contracts of the subscriber with the update address
     * @throws Throwable
     */
    protected void getSubscriberContracts() throws Throwable {
	wireMockServer.start();

	final String jsonString = getResource(CONTRACT_JSON);
	configureFor("localhost", wireMockServer.port());
	createGetMockStub(CREATE_PATH + "/1/contract", jsonString, HEADER_ACCEPT, APPLICATION_JSON);
	HttpResponse response = getGetResponse(CREATE_PATH + "/1/contract", HEADER_ACCEPT, APPLICATION_JSON);
	String responseString = convertResponseToString(response);
	log.info("Contracts: {}", responseString);
	
	assertEquals(200, response.getStatusLine().getStatusCode());
	verify(getRequestedFor(urlEqualTo(CREATE_PATH + "/1/contract")).withHeader(HEADER_ACCEPT,
		equalTo(APPLICATION_JSON)));

	wireMockServer.stop();
    }

    /**
     * call get webservice to get created movement of the changed address
     * @throws Throwable
     */
    protected void getCreatedMovement() throws Throwable {
	wireMockServer.start();

	final String jsonString = getResource(UPDATED_SUBSCRIBER_JSON);
	configureFor("localhost", wireMockServer.port());
	createGetMockStub(CREATE_PATH + "/1", jsonString, HEADER_ACCEPT, APPLICATION_JSON);
	HttpResponse response = getGetResponse(CREATE_PATH + "/1", HEADER_ACCEPT, APPLICATION_JSON);
	  
	String responseString = convertResponseToString(response);
	 
	log.info("Updated subscriber: {}", responseString);

	assertEquals(200, response.getStatusLine().getStatusCode());
	verify(getRequestedFor(urlEqualTo(CREATE_PATH + "/1")).withHeader(HEADER_ACCEPT,
		equalTo(APPLICATION_JSON)));

	wireMockServer.stop();
    }
    /**
     * 
     * @param jsonString
     * @return
     * @throws UnsupportedEncodingException
     * @throws IOException
     * @throws ClientProtocolException
     */
    private HttpResponse getPostResponse(final String jsonString, String path, String headerKey, String headerPattern)
	    throws UnsupportedEncodingException, IOException, ClientProtocolException {
	HttpPost request = new HttpPost("http://localhost:" + wireMockServer.port() + path);
	StringEntity entity = new StringEntity(jsonString);
	request.addHeader(headerKey, headerPattern);
	request.setEntity(entity);
	return httpClient.execute(request);
    }
    /**
     * 
     * @param jsonString
     * @param path
     * @param headerKey
     * @param headerPattern
     * @return
     * @throws UnsupportedEncodingException
     * @throws IOException
     * @throws ClientProtocolException
     */
    private HttpResponse getPutResponse(final String jsonString, String path, String headerKey, String headerPattern)
	    throws UnsupportedEncodingException, IOException, ClientProtocolException {
	HttpPut request = new HttpPut("http://localhost:" + wireMockServer.port() + path);
	StringEntity entity = new StringEntity(jsonString);
	request.addHeader(headerKey, headerPattern);
	request.setEntity(entity);
	return httpClient.execute(request);
    }
    /**
     * 
     * @param path
     * @param headerKey
     * @param headerPattern
     * @return
     * @throws IOException
     * @throws ClientProtocolException
     */
    private HttpResponse getGetResponse(String path, String headerKey, String headerPattern)
	    throws IOException, ClientProtocolException {
	HttpGet request = new HttpGet("http://localhost:" + wireMockServer.port() + path);
	request.addHeader(headerKey, headerPattern);
	return httpClient.execute(request);
    }

    /**
     * 
     * @param response
     * @return
     * @throws IOException
     */
    private String convertResponseToString(HttpResponse response) throws IOException {
	InputStream responseStream = response.getEntity().getContent();
	Scanner scanner = new Scanner(responseStream, UTF8);
	String responseString = scanner.useDelimiter(DELIMITER).next();
	scanner.close();
	return responseString;
    }

    /**
     * 
     * @param path
     * @param jsonString
     * @param headerKey
     * @param headerPattern
     */
    private void createGetMockStub(String path, String jsonString, String headerKey, String headerPattern) {
	stubFor(get(urlEqualTo(path)).withHeader(headerKey, equalTo(headerPattern))
		.willReturn(aResponse().withStatus(200).withBody(jsonString)));
    }

    /**
     * 
     * @param path
     * @param jsonString
     * @param headerKey
     * @param headerPattern
     */
    private void createPostMockStub(String path, String jsonString, String headerKey, String headerPattern) {
	stubFor(post(urlEqualTo(path)).withHeader(headerKey, equalTo(headerPattern))
		.willReturn(aResponse().withStatus(201).withBody(jsonString)));
    }

    /**
     * 
     * @param path
     * @param jsonString
     * @param headerKey
     * @param headerPattern
     * @param containing
     */
    private void createPutMockStub(String path, String jsonString, String headerKey, String headerPattern,
	    String containing) {
	stubFor(put(path).withHeader(headerKey, equalTo(headerPattern)).withRequestBody(containing(containing))
		.willReturn(aResponse().withStatus(200)));
    }

    /**
     * 
     * @param path
     * @return string from json input
     */
    private String getResource(String path) {
	final InputStream jsonInputStream = this.getClass().getClassLoader().getResourceAsStream(path);
	Scanner scanner = new Scanner(jsonInputStream, UTF8);
	final String jsonString = scanner.useDelimiter(DELIMITER).next();
	scanner.close();
	return jsonString;
    }
    
   
}
