package ru.netology;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.ArrayType;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static ObjectMapper mapper = new ObjectMapper();


    public static void main( String[] args ) throws IOException {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)
                        .setSocketTimeout(30000)
                        .setRedirectsEnabled(false)
                        .build())
                .build();

        HttpGet request = new HttpGet("https://cat-fact.herokuapp.com/facts");
        CloseableHttpResponse response = httpClient.execute(request);

        List<FactsAboutCats> factsAboutCats = mapper.readValue(response.getEntity().getContent(),
                new TypeReference<List<FactsAboutCats>>() {});

        factsAboutCats.stream().filter(value -> value.getType().equals("cat"))
                .forEach(System.out::println);
    }
}
