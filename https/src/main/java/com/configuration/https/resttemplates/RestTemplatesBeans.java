package com.configuration.https.resttemplates;

import com.configuration.https.httpsProperties.QuartzProperties;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;

@Configuration
public class RestTemplatesBeans {

    @Autowired
    private QuartzProperties quartzProperties;

    @Bean("quartz")
    public RestTemplate restTemplateQuartz() {
        return build(quartzProperties.getCertificate(), quartzProperties.getPassword());
    }

    protected RestTemplate build(Resource trustStore, String trustStorePassword) {
        SSLContext sslContext = null;
        try {
            sslContext = new SSLContextBuilder()
                    .loadTrustMaterial(trustStore.getURL(), trustStorePassword.toCharArray())
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }

        SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sslContext, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

        HttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(socketFactory)
                .build();

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);

        return new RestTemplate(factory);
    }

}
