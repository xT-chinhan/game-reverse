package com.smartdigimkt.sdk.api;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class SDMAdRequest {
    private int adHeight;
    private int adWidth;
    private boolean bannerRefresh;
    private Map<String, Object> customEventMap;
    private Map<String, Object> extraMap;
    private String nativeVideoAutoPlay;

    public static class Builder {
        private int adHeight;
        private int adWidth;
        private boolean bannerRefresh = true;
        private Map<String, Object> customEventMap;
        private Map<String, Object> extraMap;
        private String nativeVideoAutoPlay;

        public SDMAdRequest build() {
            SDMAdRequest sDMAdRequest = new SDMAdRequest();
            sDMAdRequest.extraMap = this.extraMap;
            sDMAdRequest.customEventMap = this.customEventMap;
            sDMAdRequest.adWidth = this.adWidth;
            sDMAdRequest.adHeight = this.adHeight;
            sDMAdRequest.bannerRefresh = this.bannerRefresh;
            sDMAdRequest.nativeVideoAutoPlay = this.nativeVideoAutoPlay;
            return sDMAdRequest;
        }

        public Builder setAdHeight(int i) {
            this.adHeight = i;
            return this;
        }

        public Builder setAdWidth(int i) {
            this.adWidth = i;
            return this;
        }

        public Builder setBannerRefresh(boolean z) {
            this.bannerRefresh = z;
            return this;
        }

        public Builder setCustomEventMap(Map<String, Object> map) {
            this.customEventMap = map;
            return this;
        }

        public Builder setExtraMap(Map<String, Object> map) {
            this.extraMap = map;
            return this;
        }

        public Builder setNativeVideoAutoPlay(String str) {
            this.nativeVideoAutoPlay = str;
            return this;
        }
    }

    public int getAdHeight() {
        return this.adHeight;
    }

    public int getAdWidth() {
        return this.adWidth;
    }

    public boolean getBannerRefresh() {
        return this.bannerRefresh;
    }

    public Map<String, Object> getCustomEventMap() {
        return this.customEventMap;
    }

    public Map<String, Object> getExtraMap() {
        return this.extraMap;
    }

    public String getNativeVideoAutoPlay() {
        return this.nativeVideoAutoPlay;
    }

    private SDMAdRequest() {
    }
}
