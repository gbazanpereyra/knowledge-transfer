package com.configuration.https.httpsProperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
@ConfigurationProperties("quartz")
public class QuartzProperties {

    private Resource certificate;
    private String password;
    private String ipAddress;
    private String port;
    private String protocol;

    public Resource getCertificate() {
        return certificate;
    }

    public void setCertificate(Resource certificate) {
        this.certificate = certificate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getUrl() {
        return this.protocol + "://" + this.ipAddress + ":" + this.port + "/api-quartz";
    }
}
