package com.bytedance.sdk.openadsdk.mediation.init;

import com.byazt.cp.n;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 55, 56, 57, 58, 59, 1830})
public class MediationConfig implements IMediationConfig {
    private String cp;
    private String fs;
    private boolean l;
    private String n;
    private Map<String, Object> q;
    private boolean qg;
    private boolean rv;
    private MediationConfigUserInfoForSegment s;
    private boolean tj;
    private JSONObject w;
    private boolean x;

    private MediationConfig() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String getPublisherDid() {
        return this.n;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isOpenAdnTest() {
        return this.qg;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public MediationConfigUserInfoForSegment getMediationConfigUserInfoForSegment() {
        return this.s;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public Map<String, Object> getLocalExtra() {
        return this.q;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean getHttps() {
        return this.l;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public JSONObject getCustomLocalConfig() {
        return this.w;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String getOpensdkVer() {
        return this.fs;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isWxInstalled() {
        return this.x;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isSupportH265() {
        return this.rv;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isSupportSplashZoomout() {
        return this.tj;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String wxAppId() {
        return this.cp;
    }

    @n(n = {0, 55, 56, 57, 58, 59, 2002})
    public static class Builder {
        private String cp;
        private String fs;
        private boolean l;
        private String n;
        private Map<String, Object> q;
        private boolean qg;
        private boolean rv;
        private MediationConfigUserInfoForSegment s;
        private boolean tj;
        private JSONObject w;
        private boolean x;

        public Builder setPublisherDid(String str) {
            this.n = str;
            return this;
        }

        public Builder setOpenAdnTest(boolean z) {
            this.qg = z;
            return this;
        }

        public Builder setMediationConfigUserInfoForSegment(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
            this.s = mediationConfigUserInfoForSegment;
            return this;
        }

        @Deprecated
        public Builder setLocalExtra(Map<String, Object> map) {
            this.q = map;
            return this;
        }

        public Builder setHttps(boolean z) {
            this.l = z;
            return this;
        }

        public Builder setCustomLocalConfig(JSONObject jSONObject) {
            this.w = jSONObject;
            return this;
        }

        public Builder setWxInstalled(boolean z) {
            this.x = z;
            return this;
        }

        public Builder setOpensdkVer(String str) {
            this.fs = str;
            return this;
        }

        public Builder setSupportH265(boolean z) {
            this.rv = z;
            return this;
        }

        public Builder setSupportSplashZoomout(boolean z) {
            this.tj = z;
            return this;
        }

        public Builder setWxAppId(String str) {
            this.cp = str;
            return this;
        }

        public MediationConfig build() {
            MediationConfig mediationConfig = new MediationConfig();
            mediationConfig.n = this.n;
            mediationConfig.qg = this.qg;
            mediationConfig.s = this.s;
            mediationConfig.q = this.q;
            mediationConfig.l = this.l;
            mediationConfig.w = this.w;
            mediationConfig.x = this.x;
            mediationConfig.fs = this.fs;
            mediationConfig.rv = this.rv;
            mediationConfig.tj = this.tj;
            mediationConfig.cp = this.cp;
            return mediationConfig;
        }
    }
}
