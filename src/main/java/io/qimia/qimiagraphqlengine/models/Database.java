package io.qimia.qimiagraphqlengine.models;

public class Database {

    private String envUrl;
    private String username;
    private String password;

    Database(){}

    Database(String envUrl,String username,String password) {
        this.envUrl = envUrl;
        this.username = username;
        this.password = password;
    }

    public String getEnvUrl() {
        return envUrl;
    }

    public void setEnvUrl(String envUrl) {
        this.envUrl = envUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
