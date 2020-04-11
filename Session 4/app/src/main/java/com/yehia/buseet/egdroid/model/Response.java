
package com.yehia.buseet.egdroid.model;

import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("data")
    private Data data;

    @SerializedName("@meta")
    private Meta meta;

    private String status;

    @SerializedName("status_message")
    private String statusMessage;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

}
