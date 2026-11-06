package com.bytedance.sdk.openadsdk;

import android.os.SystemClock;
import com.byazt.cp.n;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 55, 56, 57, 2537})
public final class TTAdConfig extends CSJConfig {
    private TTAdConfig(CSJConfig.n nVar) {
        super(nVar);
    }

    @n(n = {0, 55, 56, 57, 2268})
    public static class Builder {
        private CSJConfig.n n = new CSJConfig.n();
        private final long qg = SystemClock.elapsedRealtime();

        public Builder appId(String str) {
            this.n.n(str);
            return this;
        }

        public Builder appName(String str) {
            this.n.qg(str);
            return this;
        }

        public Builder paid(boolean z) {
            this.n.n(z);
            return this;
        }

        public Builder keywords(String str) {
            this.n.s(str);
            return this;
        }

        public Builder data(String str) {
            this.n.q(str);
            return this;
        }

        public Builder titleBarTheme(int i) {
            this.n.n(i);
            return this;
        }

        public Builder allowShowNotify(boolean z) {
            this.n.qg(z);
            return this;
        }

        public Builder debug(boolean z) {
            this.n.s(z);
            return this;
        }

        public Builder directDownloadNetworkType(int... iArr) {
            this.n.n(iArr);
            return this;
        }

        public Builder supportMultiProcess(boolean z) {
            this.n.q(z);
            return this;
        }

        public Builder customController(TTCustomController tTCustomController) {
            this.n.n(tTCustomController);
            return this;
        }

        public Builder themeStatus(int i) {
            this.n.qg(i);
            return this;
        }

        public Builder setPluginUpdateConfig(int i) {
            this.n.s(i);
            return this;
        }

        public Builder setAgeGroup(int i) {
            this.n.q(i);
            return this;
        }

        public Builder addExtra(String str, Object obj) {
            this.n.n(str, obj);
            return this;
        }

        public Builder useMediation(boolean z) {
            this.n.l(z);
            return this;
        }

        public Builder setMediationConfig(IMediationConfig iMediationConfig) {
            this.n.n(iMediationConfig);
            return this;
        }

        public TTAdConfig build() {
            this.n.n("csj_b_st_ts", Long.valueOf(this.qg));
            return new TTAdConfig(this.n);
        }
    }
}
