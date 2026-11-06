package com.bytedance.sdk.openadsdk;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AdSlot implements SlotType {
    private boolean ab;
    private int ah;
    private int[] ao;
    private String b;
    private int c;
    private String ch;
    private float d;
    private int h;
    private String hi;
    private TTAdLoadType i;
    private float ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f1631ms;
    private String nw;
    private boolean ny;
    private String op;
    private String qv;
    private String re;
    private int sl;
    private String t;
    private int u;
    private boolean ub;
    private IMediationAdSlot w;
    private boolean x;
    private int xr;
    private String y;
    private int yu;
    private int zb;

    private AdSlot() {
        this.sl = 2;
        this.ub = true;
    }

    public String getAdId() {
        return this.t;
    }

    public String getCreativeId() {
        return this.nw;
    }

    public String getExt() {
        return this.b;
    }

    public String getCodeId() {
        return this.f1631ms;
    }

    public boolean isAutoPlay() {
        return this.ub;
    }

    public int getImgAcceptedWidth() {
        return this.xr;
    }

    public int getImgAcceptedHeight() {
        return this.ah;
    }

    public float getExpressViewAcceptedWidth() {
        return this.d;
    }

    public float getExpressViewAcceptedHeight() {
        return this.ka;
    }

    public boolean isSupportDeepLink() {
        return this.ab;
    }

    public boolean isSupportRenderConrol() {
        return this.x;
    }

    public int getAdCount() {
        return this.c;
    }

    public void setAdCount(int i) {
        this.c = i;
    }

    public String getMediaExtra() {
        return this.ch;
    }

    public String getUserID() {
        return this.hi;
    }

    public int getOrientation() {
        return this.sl;
    }

    @Deprecated
    public int getNativeAdType() {
        return this.u;
    }

    public void setNativeAdType(int i) {
        this.u = i;
    }

    public int[] getExternalABVid() {
        return this.ao;
    }

    public void setExternalABVid(int... iArr) {
        this.ao = iArr;
    }

    public int getAdloadSeq() {
        return this.h;
    }

    public String getPrimeRit() {
        String str = this.qv;
        return str == null ? "" : str;
    }

    public int getAdType() {
        return this.zb;
    }

    public String getBidAdm() {
        return this.y;
    }

    public void setUserData(String str) {
        this.re = str;
    }

    public String getUserData() {
        return this.re;
    }

    public TTAdLoadType getAdLoadType() {
        return this.i;
    }

    public void setAdLoadType(TTAdLoadType tTAdLoadType) {
        this.i = tTAdLoadType;
    }

    public String getRewardName() {
        return this.op;
    }

    public int getRewardAmount() {
        return this.yu;
    }

    public boolean isSupportIconStyle() {
        return this.ny;
    }

    public IMediationAdSlot getMediationAdSlot() {
        return this.w;
    }

    public String toString() {
        return "AdSlot{mCodeId='" + this.f1631ms + "', mImgAcceptedWidth=" + this.xr + ", mImgAcceptedHeight=" + this.ah + ", mExpressViewAcceptedWidth=" + this.d + ", mExpressViewAcceptedHeight=" + this.ka + ", mAdCount=" + this.c + ", mSupportDeepLink=" + this.ab + ", mSupportRenderControl=" + this.x + ", mSupportIconStyle=" + this.ny + ", mMediaExtra='" + this.ch + "', mUserID='" + this.hi + "', mOrientation=" + this.sl + ", mNativeAdType=" + this.u + ", mIsAutoPlay=" + this.ub + ", mPrimeRit" + this.qv + ", mAdloadSeq" + this.h + ", mAdId" + this.t + ", mCreativeId" + this.nw + ", mExt" + this.b + ", mUserData" + this.re + ", mAdLoadType" + this.i + AbstractJsonLexerKt.END_OBJ;
    }

    public JSONObject toJsonObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mCodeId", this.f1631ms);
            jSONObject.put("mIsAutoPlay", this.ub);
            jSONObject.put("mImgAcceptedWidth", this.xr);
            jSONObject.put("mImgAcceptedHeight", this.ah);
            jSONObject.put("mExpressViewAcceptedWidth", this.d);
            jSONObject.put("mExpressViewAcceptedHeight", this.ka);
            jSONObject.put("mAdCount", this.c);
            jSONObject.put("mSupportDeepLink", this.ab);
            jSONObject.put("mSupportRenderControl", this.x);
            jSONObject.put("mSupportIconStyle", this.ny);
            jSONObject.put("mMediaExtra", this.ch);
            jSONObject.put("mUserID", this.hi);
            jSONObject.put("mOrientation", this.sl);
            jSONObject.put("mNativeAdType", this.u);
            jSONObject.put("mAdloadSeq", this.h);
            jSONObject.put("mPrimeRit", this.qv);
            jSONObject.put("mAdId", this.t);
            jSONObject.put("mCreativeId", this.nw);
            jSONObject.put("mExt", this.b);
            jSONObject.put("mBidAdm", this.y);
            jSONObject.put("mUserData", this.re);
            jSONObject.put("mAdLoadType", this.i);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static class Builder {
        private int[] ao;
        private String b;
        private int h;
        private int hi;
        private String i;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private String f1632ms;
        private String op;
        private String qv;
        private String re;
        private int sl;
        private String t;
        private float u;
        private IMediationAdSlot w;
        private String x;
        private String y;
        private int yu;
        private float zb;
        private int xr = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK;
        private int ah = MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME;
        private boolean d = true;
        private boolean ka = false;
        private boolean c = false;
        private int ab = 1;
        private String ny = "defaultUser";
        private int ch = 2;
        private boolean ub = true;
        private TTAdLoadType nw = TTAdLoadType.UNKNOWN;

        public Builder setAdType(int i) {
            this.sl = i;
            return this;
        }

        public Builder setAdId(String str) {
            this.b = str;
            return this;
        }

        public Builder setCreativeId(String str) {
            this.re = str;
            return this;
        }

        public Builder setExt(String str) {
            this.i = str;
            return this;
        }

        public Builder setIsAutoPlay(boolean z) {
            this.ub = z;
            return this;
        }

        public Builder setCodeId(String str) {
            this.f1632ms = str;
            return this;
        }

        public Builder setImageAcceptedSize(int i, int i2) {
            this.xr = i;
            this.ah = i2;
            return this;
        }

        public Builder setExpressViewAcceptedSize(float f, float f2) {
            this.zb = f;
            this.u = f2;
            return this;
        }

        public Builder setSupportDeepLink(boolean z) {
            this.d = z;
            return this;
        }

        public Builder supportRenderControl() {
            this.ka = true;
            return this;
        }

        public Builder supportIconStyle() {
            this.c = true;
            return this;
        }

        public Builder setAdCount(int i) {
            if (i <= 0) {
                i = 1;
            }
            if (i > 20) {
                i = 20;
            }
            this.ab = i;
            return this;
        }

        public Builder setMediaExtra(String str) {
            this.x = str;
            return this;
        }

        public Builder setUserID(String str) {
            this.ny = str;
            return this;
        }

        public Builder setOrientation(int i) {
            this.ch = i;
            return this;
        }

        @Deprecated
        public Builder setNativeAdType(int i) {
            this.hi = i;
            return this;
        }

        public Builder setAdloadSeq(int i) {
            this.h = i;
            return this;
        }

        public Builder setPrimeRit(String str) {
            this.qv = str;
            return this;
        }

        public Builder setExternalABVid(int... iArr) {
            this.ao = iArr;
            return this;
        }

        public Builder setUserData(String str) {
            this.t = str;
            return this;
        }

        public Builder setAdLoadType(TTAdLoadType tTAdLoadType) {
            this.nw = tTAdLoadType;
            return this;
        }

        public Builder withBid(String str) {
            if (str == null) {
                return this;
            }
            this.y = str;
            return this;
        }

        public Builder setMediationAdSlot(IMediationAdSlot iMediationAdSlot) {
            this.w = iMediationAdSlot;
            return this;
        }

        public Builder setRewardName(String str) {
            this.op = str;
            return this;
        }

        public Builder setRewardAmount(int i) {
            this.yu = i;
            return this;
        }

        public AdSlot build() {
            AdSlot adSlot = new AdSlot();
            adSlot.f1631ms = this.f1632ms;
            adSlot.c = this.ab;
            adSlot.ab = this.d;
            adSlot.x = this.ka;
            adSlot.ny = this.c;
            adSlot.xr = this.xr;
            adSlot.ah = this.ah;
            adSlot.d = this.zb;
            adSlot.ka = this.u;
            adSlot.ch = this.x;
            adSlot.hi = this.ny;
            adSlot.sl = this.ch;
            adSlot.u = this.hi;
            adSlot.ub = this.ub;
            adSlot.ao = this.ao;
            adSlot.h = this.h;
            adSlot.qv = this.qv;
            adSlot.t = this.b;
            adSlot.nw = this.re;
            adSlot.b = this.i;
            adSlot.zb = this.sl;
            adSlot.y = this.y;
            adSlot.re = this.t;
            adSlot.i = this.nw;
            adSlot.op = this.op;
            adSlot.yu = this.yu;
            adSlot.w = this.w;
            return adSlot;
        }
    }
}
