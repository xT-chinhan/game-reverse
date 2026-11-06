package com.anythink.core.api;

import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public class ATSharedPlacementConfig {
    Map<String, Object> bannerLocalExtra;
    Map<String, Object> interstitialLocalExtra;
    Map<String, Object> nativeLocalExtra;
    Map<String, Object> rewardVideoLocalExtra;
    Map<String, Object> splashLocalExtra;

    private ATSharedPlacementConfig(Builder builder) {
        this.rewardVideoLocalExtra = builder.rewardVideoLocalExtra;
        this.interstitialLocalExtra = builder.interstitialLocalExtra;
        this.splashLocalExtra = builder.splashLocalExtra;
        this.bannerLocalExtra = builder.bannerLocalExtra;
        this.nativeLocalExtra = builder.nativeLocalExtra;
    }

    public static class Builder {
        Map<String, Object> bannerLocalExtra;
        Map<String, Object> interstitialLocalExtra;
        Map<String, Object> nativeLocalExtra;
        Map<String, Object> rewardVideoLocalExtra;
        Map<String, Object> splashLocalExtra;

        public Builder rewardVideoLocalExtra(Map<String, Object> map) {
            this.rewardVideoLocalExtra = map;
            return this;
        }

        public Builder interstitialLocalExtra(Map<String, Object> map) {
            this.interstitialLocalExtra = map;
            return this;
        }

        public Builder splashLocalExtra(Map<String, Object> map) {
            this.splashLocalExtra = map;
            return this;
        }

        public Builder bannerLocalExtra(Map<String, Object> map) {
            this.bannerLocalExtra = map;
            return this;
        }

        public Builder nativeLocalExtra(Map<String, Object> map) {
            this.nativeLocalExtra = map;
            return this;
        }

        public ATSharedPlacementConfig build() {
            return new ATSharedPlacementConfig(this);
        }
    }

    public Map<String, Object> getRewardVideoLocalExtra() {
        return this.rewardVideoLocalExtra;
    }

    public Map<String, Object> getInterstitialLocalExtra() {
        return this.interstitialLocalExtra;
    }

    public Map<String, Object> getSplashLocalExtra() {
        return this.splashLocalExtra;
    }

    public Map<String, Object> getBannerLocalExtra() {
        return this.bannerLocalExtra;
    }

    public Map<String, Object> getNativeLocalExtra() {
        return this.nativeLocalExtra;
    }

    public String toString() {
        return "ATSharedPlacementConfig{rewardVideoLocalExtra=" + this.rewardVideoLocalExtra + ", interstitialLocalExtra=" + this.interstitialLocalExtra + ", splashLocalExtra=" + this.splashLocalExtra + ", bannerLocalExtra=" + this.bannerLocalExtra + ", nativeLocalExtra=" + this.nativeLocalExtra + AbstractJsonLexerKt.END_OBJ;
    }
}
