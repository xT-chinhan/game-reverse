package com.bytedance.sdk.openadsdk;

import com.byazt.vzx.pr;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@pr(pr = {0, 78, 79, 80, 589})
public class AdSlot implements SlotType {
    private String a;
    private boolean aj;
    private int b;
    private float c;
    private String cz;
    private String fo;
    private boolean fw;
    private int g;
    private int hn;
    private boolean ho;
    private int hw;
    private String iu;
    private int k;
    private String lb;
    private int m;
    private int[] nt;
    private String ny;
    private String pr;
    private String qa;
    private TTAdLoadType rc;
    private int uc;
    private String vk;
    private String w;
    private float x;
    private int yb;
    private IMediationAdSlot z;
    private boolean zo;

    private AdSlot() {
        this.k = 2;
        this.ho = true;
    }

    public String getAdId() {
        return this.a;
    }

    public String getCreativeId() {
        return this.cz;
    }

    public String getExt() {
        return this.ny;
    }

    public String getCodeId() {
        return this.pr;
    }

    public boolean isAutoPlay() {
        return this.ho;
    }

    public int getImgAcceptedWidth() {
        return this.hw;
    }

    public int getImgAcceptedHeight() {
        return this.hn;
    }

    public float getExpressViewAcceptedWidth() {
        return this.x;
    }

    public float getExpressViewAcceptedHeight() {
        return this.c;
    }

    public boolean isSupportDeepLink() {
        return this.fw;
    }

    public boolean isSupportRenderConrol() {
        return this.zo;
    }

    public int getAdCount() {
        return this.uc;
    }

    public void setAdCount(int i) {
        this.uc = i;
    }

    public String getMediaExtra() {
        return this.vk;
    }

    public String getUserID() {
        return this.w;
    }

    public int getOrientation() {
        return this.k;
    }

    @Deprecated
    public int getNativeAdType() {
        return this.g;
    }

    public void setNativeAdType(int i) {
        this.g = i;
    }

    public int[] getExternalABVid() {
        return this.nt;
    }

    public void setExternalABVid(int... iArr) {
        this.nt = iArr;
    }

    public int getAdloadSeq() {
        return this.yb;
    }

    public String getPrimeRit() {
        String str = this.lb;
        return str == null ? "" : str;
    }

    public int getAdType() {
        return this.m;
    }

    public String getBidAdm() {
        return this.qa;
    }

    public void setUserData(String str) {
        this.fo = str;
    }

    public String getUserData() {
        return this.fo;
    }

    public TTAdLoadType getAdLoadType() {
        return this.rc;
    }

    public void setAdLoadType(TTAdLoadType tTAdLoadType) {
        this.rc = tTAdLoadType;
    }

    public String getRewardName() {
        return this.iu;
    }

    public int getRewardAmount() {
        return this.b;
    }

    public boolean isSupportIconStyle() {
        return this.aj;
    }

    public IMediationAdSlot getMediationAdSlot() {
        return this.z;
    }

    public String toString() {
        return "AdSlot{mCodeId='" + this.pr + "', mImgAcceptedWidth=" + this.hw + ", mImgAcceptedHeight=" + this.hn + ", mExpressViewAcceptedWidth=" + this.x + ", mExpressViewAcceptedHeight=" + this.c + ", mAdCount=" + this.uc + ", mSupportDeepLink=" + this.fw + ", mSupportRenderControl=" + this.zo + ", mSupportIconStyle=" + this.aj + ", mMediaExtra='" + this.vk + "', mUserID='" + this.w + "', mOrientation=" + this.k + ", mNativeAdType=" + this.g + ", mIsAutoPlay=" + this.ho + ", mPrimeRit" + this.lb + ", mAdloadSeq" + this.yb + ", mAdId" + this.a + ", mCreativeId" + this.cz + ", mExt" + this.ny + ", mUserData" + this.fo + ", mAdLoadType" + this.rc + AbstractJsonLexerKt.END_OBJ;
    }

    public JSONObject toJsonObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mCodeId", this.pr);
            jSONObject.put("mIsAutoPlay", this.ho);
            jSONObject.put("mImgAcceptedWidth", this.hw);
            jSONObject.put("mImgAcceptedHeight", this.hn);
            jSONObject.put("mExpressViewAcceptedWidth", this.x);
            jSONObject.put("mExpressViewAcceptedHeight", this.c);
            jSONObject.put("mAdCount", this.uc);
            jSONObject.put("mSupportDeepLink", this.fw);
            jSONObject.put("mSupportRenderControl", this.zo);
            jSONObject.put("mSupportIconStyle", this.aj);
            jSONObject.put("mMediaExtra", this.vk);
            jSONObject.put("mUserID", this.w);
            jSONObject.put("mOrientation", this.k);
            jSONObject.put("mNativeAdType", this.g);
            jSONObject.put("mAdloadSeq", this.yb);
            jSONObject.put("mPrimeRit", this.lb);
            jSONObject.put("mAdId", this.a);
            jSONObject.put("mCreativeId", this.cz);
            jSONObject.put("mExt", this.ny);
            jSONObject.put("mBidAdm", this.qa);
            jSONObject.put("mUserData", this.fo);
            jSONObject.put("mAdLoadType", this.rc);
        } catch (Exception e) {
        }
        return jSONObject;
    }

    @pr(pr = {0, 78, 79, 80, AVMDLDataLoader.KeyIsMaxIpCountEachDomain})
    public static class Builder {
        private String a;
        private int b;
        private String fo;
        private float g;
        private String iu;
        private int k;
        private String lb;
        private float m;
        private int[] nt;
        private String ny;
        private String pr;
        private String qa;
        private String rc;
        private int w;
        private int yb;
        private IMediationAdSlot z;
        private String zo;
        private int hw = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK;
        private int hn = MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME;
        private boolean x = true;
        private boolean c = false;
        private boolean uc = false;
        private int fw = 1;
        private String aj = "defaultUser";
        private int vk = 2;
        private boolean ho = true;
        private TTAdLoadType cz = TTAdLoadType.UNKNOWN;

        public Builder setAdType(int i) {
            this.k = i;
            return this;
        }

        public Builder setAdId(String str) {
            this.ny = str;
            return this;
        }

        public Builder setCreativeId(String str) {
            this.fo = str;
            return this;
        }

        public Builder setExt(String str) {
            this.rc = str;
            return this;
        }

        public Builder setIsAutoPlay(boolean z) {
            this.ho = z;
            return this;
        }

        public Builder setCodeId(String str) {
            this.pr = str;
            return this;
        }

        public Builder setImageAcceptedSize(int i, int i2) {
            this.hw = i;
            this.hn = i2;
            return this;
        }

        public Builder setExpressViewAcceptedSize(float f, float f2) {
            this.m = f;
            this.g = f2;
            return this;
        }

        public Builder setSupportDeepLink(boolean z) {
            this.x = z;
            return this;
        }

        public Builder supportRenderControl() {
            this.c = true;
            return this;
        }

        public Builder supportIconStyle() {
            this.uc = true;
            return this;
        }

        public Builder setAdCount(int i) {
            if (i <= 0) {
                i = 1;
            }
            if (i > 20) {
                i = 20;
            }
            this.fw = i;
            return this;
        }

        public Builder setMediaExtra(String str) {
            this.zo = str;
            return this;
        }

        public Builder setUserID(String str) {
            this.aj = str;
            return this;
        }

        public Builder setOrientation(int i) {
            this.vk = i;
            return this;
        }

        @Deprecated
        public Builder setNativeAdType(int i) {
            this.w = i;
            return this;
        }

        public Builder setAdloadSeq(int i) {
            this.yb = i;
            return this;
        }

        public Builder setPrimeRit(String str) {
            this.lb = str;
            return this;
        }

        public Builder setExternalABVid(int... iArr) {
            this.nt = iArr;
            return this;
        }

        public Builder setUserData(String str) {
            this.a = str;
            return this;
        }

        public Builder setAdLoadType(TTAdLoadType tTAdLoadType) {
            this.cz = tTAdLoadType;
            return this;
        }

        public Builder withBid(String str) {
            if (str == null) {
                return this;
            }
            this.qa = str;
            return this;
        }

        public Builder setMediationAdSlot(IMediationAdSlot iMediationAdSlot) {
            this.z = iMediationAdSlot;
            return this;
        }

        public Builder setRewardName(String str) {
            this.iu = str;
            return this;
        }

        public Builder setRewardAmount(int i) {
            this.b = i;
            return this;
        }

        public AdSlot build() {
            AdSlot adSlot = new AdSlot();
            adSlot.pr = this.pr;
            adSlot.uc = this.fw;
            adSlot.fw = this.x;
            adSlot.zo = this.c;
            adSlot.aj = this.uc;
            adSlot.hw = this.hw;
            adSlot.hn = this.hn;
            adSlot.x = this.m;
            adSlot.c = this.g;
            adSlot.vk = this.zo;
            adSlot.w = this.aj;
            adSlot.k = this.vk;
            adSlot.g = this.w;
            adSlot.ho = this.ho;
            adSlot.nt = this.nt;
            adSlot.yb = this.yb;
            adSlot.lb = this.lb;
            adSlot.a = this.ny;
            adSlot.cz = this.fo;
            adSlot.ny = this.rc;
            adSlot.m = this.k;
            adSlot.qa = this.qa;
            adSlot.fo = this.a;
            adSlot.rc = this.cz;
            adSlot.iu = this.iu;
            adSlot.b = this.b;
            adSlot.z = this.z;
            return adSlot;
        }
    }
}
