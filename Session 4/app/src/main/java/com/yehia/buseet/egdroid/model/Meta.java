
package com.yehia.buseet.egdroid.model;

import com.google.gson.annotations.SerializedName;

public class Meta {

    @SerializedName("api_version")
    private Long apiVersion;
    @SerializedName("execution_time")
    private String executionTime;
    @SerializedName("server_time")
    private Long serverTime;
    @SerializedName("server_timezone")
    private String serverTimezone;

    public Long getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(Long apiVersion) {
        this.apiVersion = apiVersion;
    }

    public String getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(String executionTime) {
        this.executionTime = executionTime;
    }

    public Long getServerTime() {
        return serverTime;
    }

    public void setServerTime(Long serverTime) {
        this.serverTime = serverTime;
    }

    public String getServerTimezone() {
        return serverTimezone;
    }

    public void setServerTimezone(String serverTimezone) {
        this.serverTimezone = serverTimezone;
    }

}
