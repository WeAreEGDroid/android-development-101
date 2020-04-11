
package com.yehia.buseet.egdroid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Torrent {

    @SerializedName("date_uploaded")
    private String dateUploaded;
    @SerializedName("date_uploaded_unix")
    private Long dateUploadedUnix;
    @Expose
    private String hash;
    @Expose
    private Long peers;
    @Expose
    private String quality;
    @Expose
    private Long seeds;
    @Expose
    private String size;
    @SerializedName("size_bytes")
    private Long sizeBytes;
    @Expose
    private String type;
    @Expose
    private String url;

    public String getDateUploaded() {
        return dateUploaded;
    }

    public void setDateUploaded(String dateUploaded) {
        this.dateUploaded = dateUploaded;
    }

    public Long getDateUploadedUnix() {
        return dateUploadedUnix;
    }

    public void setDateUploadedUnix(Long dateUploadedUnix) {
        this.dateUploadedUnix = dateUploadedUnix;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Long getPeers() {
        return peers;
    }

    public void setPeers(Long peers) {
        this.peers = peers;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public Long getSeeds() {
        return seeds;
    }

    public void setSeeds(Long seeds) {
        this.seeds = seeds;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Long getSizeBytes() {
        return sizeBytes;
    }

    public void setSizeBytes(Long sizeBytes) {
        this.sizeBytes = sizeBytes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
