package com.bytedance.sdk.openadsdk.mediation.ad;

import com.byazt.vzx.pr;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@pr(pr = {0, 78, 79, 80, 81, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TOTAL_CACHED_LEN, AVMDLDataLoader.KeyIsIsEncryptVersion})
public class MediationAdSlot implements IMediationAdSlot {
    private boolean aj;
    private float c;
    private boolean fw;
    private float g;
    private String hn;
    private String ho;
    private boolean hw;
    private MediationNativeToBannerListener k;
    private float m;
    private MediationSplashRequestInfo nt;
    private boolean pr;
    private boolean uc;
    private String vk;
    private boolean w;
    private int x;
    private Map<String, Object> zo;

    private MediationAdSlot() {
        this.hn = "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isSplashShakeButton() {
        return this.pr;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isAllowShowCloseBtn() {
        return this.w;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public MediationNativeToBannerListener getMediationNativeToBannerListener() {
        return this.k;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public float getShakeViewWidth() {
        return this.m;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public float getShakeViewHeight() {
        return this.g;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public String getWxAppId() {
        return this.ho;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public MediationSplashRequestInfo getMediationSplashRequestInfo() {
        return this.nt;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isSplashPreLoad() {
        return this.hw;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isMuted() {
        return this.fw;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public float getVolume() {
        return this.c;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isUseSurfaceView() {
        return this.uc;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public Map<String, Object> getExtraObject() {
        return this.zo;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isBidNotify() {
        return this.aj;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public String getScenarioId() {
        return this.vk;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public String getRewardName() {
        return this.hn;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public int getRewardAmount() {
        return this.x;
    }

    @pr(pr = {0, 78, 79, 80, 81, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TOTAL_CACHED_LEN, 1047})
    public static class Builder {
        private boolean c;
        private boolean fw;
        private boolean hn;
        private String ho;
        private boolean hw;
        private MediationNativeToBannerListener k;
        private MediationSplashRequestInfo nt;
        private boolean pr;
        private int vk;
        private boolean w;
        private float x;
        private String zo;
        private Map<String, Object> uc = new HashMap();
        private String aj = "";
        private float m = 80.0f;
        private float g = 80.0f;

        public Builder setSplashShakeButton(boolean z) {
            this.pr = z;
            return this;
        }

        public Builder setSplashPreLoad(boolean z) {
            this.hw = z;
            return this;
        }

        public Builder setMuted(boolean z) {
            this.hn = z;
            return this;
        }

        public Builder setVolume(float f) {
            this.x = f;
            return this;
        }

        public Builder setUseSurfaceView(boolean z) {
            this.c = z;
            return this;
        }

        public Builder setExtraObject(String str, Object obj) {
            Map<String, Object> map = this.uc;
            if (map != null) {
                map.put(str, obj);
            }
            return this;
        }

        public Builder setBidNotify(boolean z) {
            this.fw = z;
            return this;
        }

        public Builder setScenarioId(String str) {
            this.zo = str;
            return this;
        }

        public Builder setAllowShowCloseBtn(boolean z) {
            this.w = z;
            return this;
        }

        public Builder setMediationNativeToBannerListener(MediationNativeToBannerListener mediationNativeToBannerListener) {
            this.k = mediationNativeToBannerListener;
            return this;
        }

        public Builder setShakeViewSize(float f, float f2) {
            this.m = f;
            this.g = f2;
            return this;
        }

        public Builder setWxAppId(String str) {
            this.ho = str;
            return this;
        }

        public Builder setMediationSplashRequestInfo(MediationSplashRequestInfo mediationSplashRequestInfo) {
            this.nt = mediationSplashRequestInfo;
            return this;
        }

        @Deprecated
        public Builder setRewardName(String str) {
            this.aj = str;
            return this;
        }

        @Deprecated
        public Builder setRewardAmount(int i) {
            this.vk = i;
            return this;
        }

        public MediationAdSlot build() {
            MediationAdSlot mediationAdSlot = new MediationAdSlot();
            mediationAdSlot.pr = this.pr;
            mediationAdSlot.hw = this.hw;
            mediationAdSlot.fw = this.hn;
            mediationAdSlot.c = this.x;
            mediationAdSlot.uc = this.c;
            mediationAdSlot.zo = this.uc;
            mediationAdSlot.aj = this.fw;
            mediationAdSlot.vk = this.zo;
            mediationAdSlot.hn = this.aj;
            mediationAdSlot.x = this.vk;
            mediationAdSlot.w = this.w;
            mediationAdSlot.k = this.k;
            mediationAdSlot.m = this.m;
            mediationAdSlot.g = this.g;
            mediationAdSlot.ho = this.ho;
            mediationAdSlot.nt = this.nt;
            return mediationAdSlot;
        }
    }
}
