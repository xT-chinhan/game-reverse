package com.bytedance.sdk.openadsdk.mediation.init;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class MediationConfig implements IMediationConfig {
    private boolean ab;
    private MediationConfigUserInfoForSegment ah;
    private JSONObject c;
    private boolean ch;
    private Map<String, Object> d;
    private String hi;
    private boolean ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f3988ms;
    private boolean ny;
    private String x;
    private boolean xr;

    private MediationConfig() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String getPublisherDid() {
        return this.f3988ms;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isOpenAdnTest() {
        return this.xr;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public MediationConfigUserInfoForSegment getMediationConfigUserInfoForSegment() {
        return this.ah;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public Map<String, Object> getLocalExtra() {
        return this.d;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean getHttps() {
        return this.ka;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public JSONObject getCustomLocalConfig() {
        return this.c;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String getOpensdkVer() {
        return this.x;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isWxInstalled() {
        return this.ab;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isSupportH265() {
        return this.ny;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isSupportSplashZoomout() {
        return this.ch;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String wxAppId() {
        return this.hi;
    }

    public static class Builder {
        private boolean ab;
        private MediationConfigUserInfoForSegment ah;
        private JSONObject c;
        private boolean ch;
        private Map<String, Object> d;
        private String hi;
        private boolean ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private String f3989ms;
        private boolean ny;
        private String x;
        private boolean xr;

        public Builder setPublisherDid(String str) {
            this.f3989ms = str;
            return this;
        }

        public Builder setOpenAdnTest(boolean z) {
            this.xr = z;
            return this;
        }

        public Builder setMediationConfigUserInfoForSegment(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
            this.ah = mediationConfigUserInfoForSegment;
            return this;
        }

        @Deprecated
        public Builder setLocalExtra(Map<String, Object> map) {
            this.d = map;
            return this;
        }

        public Builder setHttps(boolean z) {
            this.ka = z;
            return this;
        }

        public Builder setCustomLocalConfig(JSONObject jSONObject) {
            this.c = jSONObject;
            return this;
        }

        public Builder setWxInstalled(boolean z) {
            this.ab = z;
            return this;
        }

        public Builder setOpensdkVer(String str) {
            this.x = str;
            return this;
        }

        public Builder setSupportH265(boolean z) {
            this.ny = z;
            return this;
        }

        public Builder setSupportSplashZoomout(boolean z) {
            this.ch = z;
            return this;
        }

        public Builder setWxAppId(String str) {
            this.hi = str;
            return this;
        }

        public MediationConfig build() {
            MediationConfig mediationConfig = new MediationConfig();
            mediationConfig.f3988ms = this.f3989ms;
            mediationConfig.xr = this.xr;
            mediationConfig.ah = this.ah;
            mediationConfig.d = this.d;
            mediationConfig.ka = this.ka;
            mediationConfig.c = this.c;
            mediationConfig.ab = this.ab;
            mediationConfig.x = this.x;
            mediationConfig.ny = this.ny;
            mediationConfig.ch = this.ch;
            mediationConfig.hi = this.hi;
            return mediationConfig;
        }
    }
}
