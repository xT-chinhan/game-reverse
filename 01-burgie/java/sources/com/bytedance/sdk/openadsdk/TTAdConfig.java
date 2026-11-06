package com.bytedance.sdk.openadsdk;

import android.os.SystemClock;
import com.byazt.vzx.pr;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig;

/* JADX INFO: loaded from: classes2.dex */
@pr(pr = {0, 78, 79, 80, 2346})
public final class TTAdConfig extends CSJConfig {
    private TTAdConfig(CSJConfig.pr prVar) {
        super(prVar);
    }

    @pr(pr = {0, 78, 79, 80, 2037})
    public static class Builder {
        private CSJConfig.pr pr = new CSJConfig.pr();
        private final long hw = SystemClock.elapsedRealtime();

        public Builder appId(String str) {
            this.pr.pr(str);
            return this;
        }

        public Builder appName(String str) {
            this.pr.hw(str);
            return this;
        }

        public Builder paid(boolean z) {
            this.pr.pr(z);
            return this;
        }

        public Builder keywords(String str) {
            this.pr.hn(str);
            return this;
        }

        public Builder data(String str) {
            this.pr.x(str);
            return this;
        }

        public Builder titleBarTheme(int i) {
            this.pr.pr(i);
            return this;
        }

        public Builder allowShowNotify(boolean z) {
            this.pr.hw(z);
            return this;
        }

        public Builder debug(boolean z) {
            this.pr.hn(z);
            return this;
        }

        public Builder directDownloadNetworkType(int... iArr) {
            this.pr.pr(iArr);
            return this;
        }

        public Builder supportMultiProcess(boolean z) {
            this.pr.x(z);
            return this;
        }

        public Builder customController(TTCustomController tTCustomController) {
            this.pr.pr(tTCustomController);
            return this;
        }

        public Builder themeStatus(int i) {
            this.pr.hw(i);
            return this;
        }

        public Builder setPluginUpdateConfig(int i) {
            this.pr.hn(i);
            return this;
        }

        public Builder setAgeGroup(int i) {
            this.pr.x(i);
            return this;
        }

        public Builder addExtra(String str, Object obj) {
            this.pr.pr(str, obj);
            return this;
        }

        public Builder useMediation(boolean z) {
            this.pr.c(z);
            return this;
        }

        public Builder setMediationConfig(IMediationConfig iMediationConfig) {
            this.pr.pr(iMediationConfig);
            return this;
        }

        public TTAdConfig build() {
            this.pr.pr("csj_b_st_ts", Long.valueOf(this.hw));
            return new TTAdConfig(this.pr);
        }
    }
}
