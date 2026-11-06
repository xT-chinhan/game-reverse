package com.bytedance.sdk.openadsdk.mediation.init;

import com.byazt.vzx.pr;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@pr(pr = {0, 78, 79, 80, 81, 82, 1669})
public class MediationConfig implements IMediationConfig {
    private boolean aj;
    private boolean c;
    private boolean fw;
    private MediationConfigUserInfoForSegment hn;
    private boolean hw;
    private String pr;
    private JSONObject uc;
    private boolean vk;
    private String w;
    private Map<String, Object> x;
    private String zo;

    private MediationConfig() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String getPublisherDid() {
        return this.pr;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isOpenAdnTest() {
        return this.hw;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public MediationConfigUserInfoForSegment getMediationConfigUserInfoForSegment() {
        return this.hn;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public Map<String, Object> getLocalExtra() {
        return this.x;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean getHttps() {
        return this.c;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public JSONObject getCustomLocalConfig() {
        return this.uc;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String getOpensdkVer() {
        return this.zo;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isWxInstalled() {
        return this.fw;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isSupportH265() {
        return this.aj;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isSupportSplashZoomout() {
        return this.vk;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String wxAppId() {
        return this.w;
    }

    @pr(pr = {0, 78, 79, 80, 81, 82, 1846})
    public static class Builder {
        private boolean aj;
        private boolean c;
        private boolean fw;
        private MediationConfigUserInfoForSegment hn;
        private boolean hw;
        private String pr;
        private JSONObject uc;
        private boolean vk;
        private String w;
        private Map<String, Object> x;
        private String zo;

        public Builder setPublisherDid(String str) {
            this.pr = str;
            return this;
        }

        public Builder setOpenAdnTest(boolean z) {
            this.hw = z;
            return this;
        }

        public Builder setMediationConfigUserInfoForSegment(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
            this.hn = mediationConfigUserInfoForSegment;
            return this;
        }

        @Deprecated
        public Builder setLocalExtra(Map<String, Object> map) {
            this.x = map;
            return this;
        }

        public Builder setHttps(boolean z) {
            this.c = z;
            return this;
        }

        public Builder setCustomLocalConfig(JSONObject jSONObject) {
            this.uc = jSONObject;
            return this;
        }

        public Builder setWxInstalled(boolean z) {
            this.fw = z;
            return this;
        }

        public Builder setOpensdkVer(String str) {
            this.zo = str;
            return this;
        }

        public Builder setSupportH265(boolean z) {
            this.aj = z;
            return this;
        }

        public Builder setSupportSplashZoomout(boolean z) {
            this.vk = z;
            return this;
        }

        public Builder setWxAppId(String str) {
            this.w = str;
            return this;
        }

        public MediationConfig build() {
            MediationConfig mediationConfig = new MediationConfig();
            mediationConfig.pr = this.pr;
            mediationConfig.hw = this.hw;
            mediationConfig.hn = this.hn;
            mediationConfig.x = this.x;
            mediationConfig.c = this.c;
            mediationConfig.uc = this.uc;
            mediationConfig.fw = this.fw;
            mediationConfig.zo = this.zo;
            mediationConfig.aj = this.aj;
            mediationConfig.vk = this.vk;
            mediationConfig.w = this.w;
            return mediationConfig;
        }
    }
}
