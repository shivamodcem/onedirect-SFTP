package com.onedirect.sftp.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

public class HttpClientUtil {
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    private static final ObjectMapper mapper = new ObjectMapper();

    private static Logger LOG = LogManager.getLogger(HttpClientUtil.class);

    /**
     * Util method to send get request and map the result with desired class type.
     */
    public static <T> T get(String url, List<NameValuePair> urlParams, Class<T> responseType,
                            Map<String, Object> headers) throws IOException {

        if (urlParams != null && !urlParams.isEmpty()) {
            url = url + "?" + URLEncodedUtils.format(urlParams, "UTF-8").toString();
        }
        HttpGet getRequest = new HttpGet(url);
        getRequest.setHeader("Accept", "application/json");
        if (headers != null) {
            for (String key : headers.keySet()) {
                getRequest.setHeader(key, headers.get(key).toString());
            }
        }
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        CloseableHttpResponse httpResponse = httpClient.execute(getRequest);
        verifyResponse(httpResponse);
        String responseString = EntityUtils.toString(httpResponse.getEntity());
        T response = null;
        if (responseString != null && responseType != null) {
            response = mapper.readValue(responseString, responseType);
        }
        return response;
    }

    /**
     * Util method to send post request and map the result with desired class.
     */
    public static <U, V> V post(String url, U requestBody, Class<V> responseType,
                                Map<String, String> headers) throws IOException {
        HttpPost postRequest = new HttpPost(url);
        postRequest.setHeader("Content-Type", "application/json");
        postRequest.setHeader("Accept", "application/json");
        if (headers != null) {
            for (String key : headers.keySet()) {
                postRequest.setHeader(key, headers.get(key));
            }
        }
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        LOG.info("String Entity is {}",requestBody);
        StringEntity stringEntity = new StringEntity(mapper.writeValueAsString(requestBody), UTF_8);
        LOG.info("String Entity is {}",stringEntity.getContent());
        postRequest.setEntity(stringEntity);
        CloseableHttpResponse httpResponse = httpClient.execute(postRequest);
        LOG.info("Recieved Data is {}",EntityUtils.toString(httpResponse.getEntity()));
        verifyResponse(httpResponse);
        String responseString = EntityUtils.toString(httpResponse.getEntity());
        if (responseType == String.class) {
            return (V) responseString;
        }
        V response = null;
        if (!StringUtils.isEmpty(responseString) && responseType != null) {
            response = mapper.readValue(responseString, responseType);
        }
        return response;
    }

    /**
     * This method will call HTTP.Post with named Value params.
     */
    public static <V> V post(String url, List<NameValuePair> nameValuePairs, Class<V> responseType,
                             Map<String, String> headers) throws IOException {
        HttpPost postRequest = new HttpPost(url);
        postRequest.setHeader("Accept", "application/json");
        if (headers != null) {
            for (String key : headers.keySet()) {
                postRequest.setHeader(key, headers.get(key));
            }
        }
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpEntity formEntity = new UrlEncodedFormEntity(nameValuePairs, UTF_8);
        postRequest.setEntity(formEntity);
        CloseableHttpResponse httpResponse = httpClient.execute(postRequest);
        String responseString = EntityUtils.toString(httpResponse.getEntity());
        LOG.info("Recieved Data is {}",responseString);
        verifyResponse(httpResponse);

        if (responseType == String.class) {
            return (V) responseString;
        }
        V response = null;
        if (!StringUtils.isEmpty(responseString) && responseType != null) {
            response = mapper.readValue(responseString, responseType);
        }
        return response;
    }

    public static Object put() {
        return null;
    }

    public static Object patch() {
        return null;
    }

    public static Object delete() {
        return null;
    }

    private static void verifyResponse(HttpResponse httpResponse) throws HttpResponseException {
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        LOG.info("Received status code : {} ", httpResponse.getStatusLine().getStatusCode());
        if (statusCode == 500) {
            LOG.info("Failed Http call due to {}",httpResponse.getEntity());
            throw new HttpResponseException(statusCode, "Internal Server Error");
        }
        if (statusCode < 200 || statusCode >= 299) {
            throw new HttpResponseException(statusCode, "Failed Http Request");
        }
    }

}

