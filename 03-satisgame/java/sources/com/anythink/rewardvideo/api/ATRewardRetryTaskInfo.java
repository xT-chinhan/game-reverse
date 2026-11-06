package com.anythink.rewardvideo.api;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public class ATRewardRetryTaskInfo implements Serializable {
    public static final int CONVERT_TYPE_ACTIVATION_RETENTION = 6006101;
    public static final int CONVERT_TYPE_ECOMMERCE_ORDER = 6006103;
    public static final int CONVERT_TYPE_PAYMENT = 6006102;
    private static final long serialVersionUID = 1;
    private String adDescription;
    private String adSource;
    private String appIconUrl;
    private String appName;
    private int convertType;
    private long creativeId;
    private String firmId;
    private List<String> imageUrlArray;
    private int interactionType;
    private int materialType;
    private String productName;
    private String requestId;
    private String videoCoverImageUrl;
    private String videoUrl;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ConvertType {
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public String getAdDescription() {
        return this.adDescription;
    }

    public void setAdDescription(String str) {
        this.adDescription = str;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String str) {
        this.productName = str;
    }

    public String getAdSource() {
        return this.adSource;
    }

    public void setAdSource(String str) {
        this.adSource = str;
    }

    public List<String> getImageUrlArray() {
        return this.imageUrlArray;
    }

    public void setImageUrlArray(List<String> list) {
        this.imageUrlArray = list;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public void setVideoUrl(String str) {
        this.videoUrl = str;
    }

    public String getVideoCoverImageUrl() {
        return this.videoCoverImageUrl;
    }

    public void setVideoCoverImageUrl(String str) {
        this.videoCoverImageUrl = str;
    }

    public int getMaterialType() {
        return this.materialType;
    }

    public void setMaterialType(int i) {
        this.materialType = i;
    }

    public String getAppIconUrl() {
        return this.appIconUrl;
    }

    public void setAppIconUrl(String str) {
        this.appIconUrl = str;
    }

    public String getAppName() {
        return this.appName;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public int getInteractionType() {
        return this.interactionType;
    }

    public void setInteractionType(int i) {
        this.interactionType = i;
    }

    public int getConvertType() {
        return this.convertType;
    }

    public void setConvertType(int i) {
        this.convertType = i;
    }

    public long getCreativeId() {
        return this.creativeId;
    }

    public void setCreativeId(long j) {
        this.creativeId = j;
    }

    public String getFirmId() {
        return this.firmId;
    }

    public void setFirmId(String str) {
        this.firmId = str;
    }

    public String toString() {
        return "ATRewardRetryTaskInfo{requestId='" + this.requestId + "', adDescription='" + this.adDescription + "', productName='" + this.productName + "', adSource='" + this.adSource + "', imageUrlArray=" + this.imageUrlArray + ", videoUrl='" + this.videoUrl + "', videoCoverImageUrl='" + this.videoCoverImageUrl + "', materialType=" + this.materialType + ", appIconUrl='" + this.appIconUrl + "', appName='" + this.appName + "', interactionType=" + this.interactionType + ", convertType=" + this.convertType + ", creativeId=" + this.creativeId + ", firmId=" + this.firmId + AbstractJsonLexerKt.END_OBJ;
    }
}
