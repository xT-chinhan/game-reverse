package com.bytedance.sdk.openadsdk.mediation.ad;

import com.byazt.cp.n;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 55, 56, 57, 58, 763, 1644})
public class MediationAdSlot implements IMediationAdSlot {
    private boolean cp;
    private MediationSplashRequestInfo cy;
    private MediationNativeToBannerListener d;
    private Map<String, Object> fs;
    private String k;
    private float l;
    private boolean n;
    private float oa;
    private int q;
    private boolean qg;
    private boolean rv;
    private String s;
    private float sz;
    private String tj;
    private boolean w;
    private boolean x;

    private MediationAdSlot() {
        this.s = "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isSplashShakeButton() {
        return this.n;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isAllowShowCloseBtn() {
        return this.cp;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public MediationNativeToBannerListener getMediationNativeToBannerListener() {
        return this.d;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public float getShakeViewWidth() {
        return this.oa;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public float getShakeViewHeight() {
        return this.sz;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public String getWxAppId() {
        return this.k;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public MediationSplashRequestInfo getMediationSplashRequestInfo() {
        return this.cy;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isSplashPreLoad() {
        return this.qg;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isMuted() {
        return this.x;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public float getVolume() {
        return this.l;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isUseSurfaceView() {
        return this.w;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public Map<String, Object> getExtraObject() {
        return this.fs;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isBidNotify() {
        return this.rv;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public String getScenarioId() {
        return this.tj;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public String getRewardName() {
        return this.s;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public int getRewardAmount() {
        return this.q;
    }

    @n(n = {0, 55, 56, 57, 58, 763, 1142})
    public static class Builder {
        private boolean cp;
        private MediationSplashRequestInfo cy;
        private MediationNativeToBannerListener d;
        private String fs;
        private String k;
        private boolean l;
        private boolean n;
        private float q;
        private boolean qg;
        private boolean s;
        private int tj;
        private boolean x;
        private Map<String, Object> w = new HashMap();
        private String rv = "";
        private float oa = 80.0f;
        private float sz = 80.0f;

        public Builder setSplashShakeButton(boolean z) {
            this.n = z;
            return this;
        }

        public Builder setSplashPreLoad(boolean z) {
            this.qg = z;
            return this;
        }

        public Builder setMuted(boolean z) {
            this.s = z;
            return this;
        }

        public Builder setVolume(float f) {
            this.q = f;
            return this;
        }

        public Builder setUseSurfaceView(boolean z) {
            this.l = z;
            return this;
        }

        public Builder setExtraObject(String str, Object obj) {
            Map<String, Object> map = this.w;
            if (map != null) {
                map.put(str, obj);
            }
            return this;
        }

        public Builder setBidNotify(boolean z) {
            this.x = z;
            return this;
        }

        public Builder setScenarioId(String str) {
            this.fs = str;
            return this;
        }

        public Builder setAllowShowCloseBtn(boolean z) {
            this.cp = z;
            return this;
        }

        public Builder setMediationNativeToBannerListener(MediationNativeToBannerListener mediationNativeToBannerListener) {
            this.d = mediationNativeToBannerListener;
            return this;
        }

        public Builder setShakeViewSize(float f, float f2) {
            this.oa = f;
            this.sz = f2;
            return this;
        }

        public Builder setWxAppId(String str) {
            this.k = str;
            return this;
        }

        public Builder setMediationSplashRequestInfo(MediationSplashRequestInfo mediationSplashRequestInfo) {
            this.cy = mediationSplashRequestInfo;
            return this;
        }

        @Deprecated
        public Builder setRewardName(String str) {
            this.rv = str;
            return this;
        }

        @Deprecated
        public Builder setRewardAmount(int i) {
            this.tj = i;
            return this;
        }

        public MediationAdSlot build() {
            MediationAdSlot mediationAdSlot = new MediationAdSlot();
            mediationAdSlot.n = this.n;
            mediationAdSlot.qg = this.qg;
            mediationAdSlot.x = this.s;
            mediationAdSlot.l = this.q;
            mediationAdSlot.w = this.l;
            mediationAdSlot.fs = this.w;
            mediationAdSlot.rv = this.x;
            mediationAdSlot.tj = this.fs;
            mediationAdSlot.s = this.rv;
            mediationAdSlot.q = this.tj;
            mediationAdSlot.cp = this.cp;
            mediationAdSlot.d = this.d;
            mediationAdSlot.oa = this.oa;
            mediationAdSlot.sz = this.sz;
            mediationAdSlot.k = this.k;
            mediationAdSlot.cy = this.cy;
            return mediationAdSlot;
        }
    }
}
