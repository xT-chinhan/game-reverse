package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig;

/* JADX INFO: loaded from: classes2.dex */
public final class TTAdConfig extends CSJConfig {
    private TTAdConfig(CSJConfig.ms msVar) {
        super(msVar);
    }

    public static class Builder {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private CSJConfig.ms f1636ms = new CSJConfig.ms();

        public Builder appId(String str) {
            this.f1636ms.ms(str);
            return this;
        }

        public Builder appName(String str) {
            this.f1636ms.xr(str);
            return this;
        }

        public Builder paid(boolean z) {
            this.f1636ms.ms(z);
            return this;
        }

        public Builder keywords(String str) {
            this.f1636ms.ah(str);
            return this;
        }

        public Builder data(String str) {
            this.f1636ms.d(str);
            return this;
        }

        public Builder titleBarTheme(int i) {
            this.f1636ms.ms(i);
            return this;
        }

        public Builder allowShowNotify(boolean z) {
            this.f1636ms.xr(z);
            return this;
        }

        public Builder debug(boolean z) {
            this.f1636ms.ah(z);
            return this;
        }

        public Builder directDownloadNetworkType(int... iArr) {
            this.f1636ms.ms(iArr);
            return this;
        }

        public Builder supportMultiProcess(boolean z) {
            this.f1636ms.d(z);
            return this;
        }

        public Builder customController(TTCustomController tTCustomController) {
            this.f1636ms.ms(tTCustomController);
            return this;
        }

        public Builder themeStatus(int i) {
            this.f1636ms.xr(i);
            return this;
        }

        public Builder setPluginUpdateConfig(int i) {
            this.f1636ms.ah(i);
            return this;
        }

        public Builder setAgeGroup(int i) {
            this.f1636ms.d(i);
            return this;
        }

        public Builder addExtra(String str, Object obj) {
            this.f1636ms.ms(str, obj);
            return this;
        }

        public Builder useMediation(boolean z) {
            this.f1636ms.ka(z);
            return this;
        }

        public Builder setMediationConfig(IMediationConfig iMediationConfig) {
            this.f1636ms.ms(iMediationConfig);
            return this;
        }

        public TTAdConfig build() {
            return new TTAdConfig(this.f1636ms);
        }
    }
}
