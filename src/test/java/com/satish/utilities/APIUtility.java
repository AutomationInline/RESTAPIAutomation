package com.satish.utilities;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class APIUtility {


    public static String BaseURI = "http://dummy.restapiexample.com/api/v1/";
    static HttpClient client;
    static HttpGet GETRequest;
    static HttpPost POSTRequest;
    static HttpPut PutRequest;
    static HttpDelete DELETERequest;



    public static HttpResponse getRequest(String URI) throws Exception {
        GETRequest = new HttpGet(BaseURI + URI);
        GETRequest.addHeader("Content-Type", "text/html");
        client = HttpClientBuilder.create().build();
        HttpResponse hrp = client.execute(GETRequest);
        return hrp;
    }


    public static HttpResponse PostRequest(String URI, List<NameValuePair> urlParameters) throws Exception {
        HttpClient client = HttpClientBuilder.create().build();
        POSTRequest = new HttpPost(BaseURI+URI);
        POSTRequest.setHeader("Content-Type", "text/html");
        POSTRequest.setEntity(new UrlEncodedFormEntity(urlParameters));
        HttpResponse response = client.execute(POSTRequest);
        return response;

    }

    public static HttpResponse PutRequest(String URI, List<NameValuePair> urlParameters) throws Exception {
        HttpClient client = HttpClientBuilder.create().build();
        PutRequest = new HttpPut(BaseURI+URI);
        PutRequest.setHeader("Content-Type", "text/html");
        PutRequest.setEntity(new UrlEncodedFormEntity(urlParameters));
        HttpResponse response = client.execute(PutRequest);
        return response;

    }

    public static HttpResponse DeleteRequest(String URI) throws Exception {
        HttpClient client = HttpClientBuilder.create().build();
        DELETERequest = new HttpDelete(BaseURI+URI);
        DELETERequest.setHeader("Content-Type", "text/html");
        HttpResponse response = client.execute(DELETERequest);
        return response;

    }
}
