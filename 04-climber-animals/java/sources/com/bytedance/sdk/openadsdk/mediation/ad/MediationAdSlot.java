package com.bytedance.sdk.openadsdk.mediation.ad;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MediationAdSlot implements IMediationAdSlot {
    private boolean ab;
    private String ah;
    private MediationSplashRequestInfo ao;
    private boolean c;
    private String ch;
    private int d;
    private boolean hi;
    private float ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private boolean f3951ms;
    private boolean ny;
    private MediationNativeToBannerListener sl;
    private float u;
    private String ub;
    private Map<String, Object> x;
    private boolean xr;
    private float zb;

    private MediationAdSlot() {
        this.ah = "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isSplashShakeButton() {
        return this.f3951ms;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isAllowShowCloseBtn() {
        return this.hi;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public MediationNativeToBannerListener getMediationNativeToBannerListener() {
        return this.sl;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public float getShakeViewWidth() {
        return this.zb;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public float getShakeViewHeight() {
        return this.u;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public String getWxAppId() {
        return this.ub;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public MediationSplashRequestInfo getMediationSplashRequestInfo() {
        return this.ao;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isSplashPreLoad() {
        return this.xr;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isMuted() {
        return this.ab;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public float getVolume() {
        return this.ka;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isUseSurfaceView() {
        return this.c;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public Map<String, Object> getExtraObject() {
        return this.x;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isBidNotify() {
        return this.ny;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public String getScenarioId() {
        return this.ch;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public String getRewardName() {
        return this.ah;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public int getRewardAmount() {
        return this.d;
    }

    public static class Builder {
        private boolean ab;
        private boolean ah;
        private MediationSplashRequestInfo ao;
        private int ch;
        private float d;
        private boolean hi;
        private boolean ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private boolean f3952ms;
        private MediationNativeToBannerListener sl;
        private String ub;
        private String x;
        private boolean xr;
        private Map<String, Object> c = new HashMap();
        private String ny = "";
        private float zb = 80.0f;
        private float u = 80.0f;

        public Builder setSplashShakeButton(boolean z) {
            this.f3952ms = z;
            return this;
        }

        public Builder setSplashPreLoad(boolean z) {
            this.xr = z;
            return this;
        }

        public Builder setMuted(boolean z) {
            this.ah = z;
            return this;
        }

        public Builder setVolume(float f) {
            this.d = f;
            return this;
        }

        public Builder setUseSurfaceView(boolean z) {
            this.ka = z;
            return this;
        }

        public Builder setExtraObject(String str, Object obj) {
            Map<String, Object> map = this.c;
            if (map != null) {
                map.put(str, obj);
            }
            return this;
        }

        public Builder setBidNotify(boolean z) {
            this.ab = z;
            return this;
        }

        public Builder setScenarioId(String str) {
            this.x = str;
            return this;
        }

        public Builder setAllowShowCloseBtn(boolean z) {
            this.hi = z;
            return this;
        }

        public Builder setMediationNativeToBannerListener(MediationNativeToBannerListener mediationNativeToBannerListener) {
            this.sl = mediationNativeToBannerListener;
            return this;
        }

        public Builder setShakeViewSize(float f, float f2) {
            this.zb = f;
            this.u = f2;
            return this;
        }

        public Builder setWxAppId(String str) {
            this.ub = str;
            return this;
        }

        public Builder setMediationSplashRequestInfo(MediationSplashRequestInfo mediationSplashRequestInfo) {
            this.ao = mediationSplashRequestInfo;
            return this;
        }

        @Deprecated
        public Builder setRewardName(String str) {
            this.ny = str;
            return this;
        }

        @Deprecated
        public Builder setRewardAmount(int i) {
            this.ch = i;
            return this;
        }

        public MediationAdSlot build() {
            MediationAdSlot mediationAdSlot = new MediationAdSlot();
            mediationAdSlot.f3951ms = this.f3952ms;
            mediationAdSlot.xr = this.xr;
            mediationAdSlot.ab = this.ah;
            mediationAdSlot.ka = this.d;
            mediationAdSlot.c = this.ka;
            mediationAdSlot.x = this.c;
            mediationAdSlot.ny = this.ab;
            mediationAdSlot.ch = this.x;
            mediationAdSlot.ah = this.ny;
            mediationAdSlot.d = this.ch;
            mediationAdSlot.hi = this.hi;
            mediationAdSlot.sl = this.sl;
            mediationAdSlot.zb = this.zb;
            mediationAdSlot.u = this.u;
            mediationAdSlot.ub = this.ub;
            mediationAdSlot.ao = this.ao;
            return mediationAdSlot;
        }
    }
}
