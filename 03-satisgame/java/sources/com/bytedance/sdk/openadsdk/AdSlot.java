package com.bytedance.sdk.openadsdk;

import com.byazt.cp.n;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 55, 56, 57, 709})
public class AdSlot implements SlotType {
    private String a;
    private String cd;
    private String cp;
    private int[] cy;
    private int d;
    private boolean fs;
    private int h;
    private int hd;
    private IMediationAdSlot hu;
    private boolean k;
    private float l;
    private TTAdLoadType m;
    private String n;
    private int oa;
    private String ou;
    private String py;
    private float q;
    private int qg;
    private boolean rv;
    private int s;
    private int sz;
    private String t;
    private String tj;
    private String um;
    private int w;
    private String wm;
    private boolean x;

    private AdSlot() {
        this.d = 2;
        this.k = true;
    }

    public String getAdId() {
        return this.a;
    }

    public String getCreativeId() {
        return this.py;
    }

    public String getExt() {
        return this.ou;
    }

    public String getCodeId() {
        return this.n;
    }

    public boolean isAutoPlay() {
        return this.k;
    }

    public int getImgAcceptedWidth() {
        return this.qg;
    }

    public int getImgAcceptedHeight() {
        return this.s;
    }

    public float getExpressViewAcceptedWidth() {
        return this.q;
    }

    public float getExpressViewAcceptedHeight() {
        return this.l;
    }

    public boolean isSupportDeepLink() {
        return this.x;
    }

    public boolean isSupportRenderConrol() {
        return this.fs;
    }

    public int getAdCount() {
        return this.w;
    }

    public void setAdCount(int i) {
        this.w = i;
    }

    public String getMediaExtra() {
        return this.tj;
    }

    public String getUserID() {
        return this.cp;
    }

    public int getOrientation() {
        return this.d;
    }

    @Deprecated
    public int getNativeAdType() {
        return this.sz;
    }

    public void setNativeAdType(int i) {
        this.sz = i;
    }

    public int[] getExternalABVid() {
        return this.cy;
    }

    public void setExternalABVid(int... iArr) {
        this.cy = iArr;
    }

    public int getAdloadSeq() {
        return this.hd;
    }

    public String getPrimeRit() {
        String str = this.cd;
        return str == null ? "" : str;
    }

    public int getAdType() {
        return this.oa;
    }

    public String getBidAdm() {
        return this.um;
    }

    public void setUserData(String str) {
        this.wm = str;
    }

    public String getUserData() {
        return this.wm;
    }

    public TTAdLoadType getAdLoadType() {
        return this.m;
    }

    public void setAdLoadType(TTAdLoadType tTAdLoadType) {
        this.m = tTAdLoadType;
    }

    public String getRewardName() {
        return this.t;
    }

    public int getRewardAmount() {
        return this.h;
    }

    public boolean isSupportIconStyle() {
        return this.rv;
    }

    public IMediationAdSlot getMediationAdSlot() {
        return this.hu;
    }

    public String toString() {
        return "AdSlot{mCodeId='" + this.n + "', mImgAcceptedWidth=" + this.qg + ", mImgAcceptedHeight=" + this.s + ", mExpressViewAcceptedWidth=" + this.q + ", mExpressViewAcceptedHeight=" + this.l + ", mAdCount=" + this.w + ", mSupportDeepLink=" + this.x + ", mSupportRenderControl=" + this.fs + ", mSupportIconStyle=" + this.rv + ", mMediaExtra='" + this.tj + "', mUserID='" + this.cp + "', mOrientation=" + this.d + ", mNativeAdType=" + this.sz + ", mIsAutoPlay=" + this.k + ", mPrimeRit" + this.cd + ", mAdloadSeq" + this.hd + ", mAdId" + this.a + ", mCreativeId" + this.py + ", mExt" + this.ou + ", mUserData" + this.wm + ", mAdLoadType" + this.m + AbstractJsonLexerKt.END_OBJ;
    }

    public JSONObject toJsonObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mCodeId", this.n);
            jSONObject.put("mIsAutoPlay", this.k);
            jSONObject.put("mImgAcceptedWidth", this.qg);
            jSONObject.put("mImgAcceptedHeight", this.s);
            jSONObject.put("mExpressViewAcceptedWidth", this.q);
            jSONObject.put("mExpressViewAcceptedHeight", this.l);
            jSONObject.put("mAdCount", this.w);
            jSONObject.put("mSupportDeepLink", this.x);
            jSONObject.put("mSupportRenderControl", this.fs);
            jSONObject.put("mSupportIconStyle", this.rv);
            jSONObject.put("mMediaExtra", this.tj);
            jSONObject.put("mUserID", this.cp);
            jSONObject.put("mOrientation", this.d);
            jSONObject.put("mNativeAdType", this.sz);
            jSONObject.put("mAdloadSeq", this.hd);
            jSONObject.put("mPrimeRit", this.cd);
            jSONObject.put("mAdId", this.a);
            jSONObject.put("mCreativeId", this.py);
            jSONObject.put("mExt", this.ou);
            jSONObject.put("mBidAdm", this.um);
            jSONObject.put("mUserData", this.wm);
            jSONObject.put("mAdLoadType", this.m);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    @n(n = {0, 55, 56, 57, 948})
    public static class Builder {
        private String a;
        private String cd;
        private int cp;
        private int[] cy;
        private int d;
        private String fs;
        private int h;
        private int hd;
        private IMediationAdSlot hu;
        private String m;
        private String n;
        private float oa;
        private String ou;
        private float sz;
        private String t;
        private String um;
        private String wm;
        private int qg = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK;
        private int s = MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME;
        private boolean q = true;
        private boolean l = false;
        private boolean w = false;
        private int x = 1;
        private String rv = "defaultUser";
        private int tj = 2;
        private boolean k = true;
        private TTAdLoadType py = TTAdLoadType.UNKNOWN;

        public Builder setAdType(int i) {
            this.d = i;
            return this;
        }

        public Builder setAdId(String str) {
            this.ou = str;
            return this;
        }

        public Builder setCreativeId(String str) {
            this.wm = str;
            return this;
        }

        public Builder setExt(String str) {
            this.m = str;
            return this;
        }

        public Builder setIsAutoPlay(boolean z) {
            this.k = z;
            return this;
        }

        public Builder setCodeId(String str) {
            this.n = str;
            return this;
        }

        public Builder setImageAcceptedSize(int i, int i2) {
            this.qg = i;
            this.s = i2;
            return this;
        }

        public Builder setExpressViewAcceptedSize(float f, float f2) {
            this.oa = f;
            this.sz = f2;
            return this;
        }

        public Builder setSupportDeepLink(boolean z) {
            this.q = z;
            return this;
        }

        public Builder supportRenderControl() {
            this.l = true;
            return this;
        }

        public Builder supportIconStyle() {
            this.w = true;
            return this;
        }

        public Builder setAdCount(int i) {
            if (i <= 0) {
                i = 1;
            }
            if (i > 20) {
                i = 20;
            }
            this.x = i;
            return this;
        }

        public Builder setMediaExtra(String str) {
            this.fs = str;
            return this;
        }

        public Builder setUserID(String str) {
            this.rv = str;
            return this;
        }

        public Builder setOrientation(int i) {
            this.tj = i;
            return this;
        }

        @Deprecated
        public Builder setNativeAdType(int i) {
            this.cp = i;
            return this;
        }

        public Builder setAdloadSeq(int i) {
            this.hd = i;
            return this;
        }

        public Builder setPrimeRit(String str) {
            this.cd = str;
            return this;
        }

        public Builder setExternalABVid(int... iArr) {
            this.cy = iArr;
            return this;
        }

        public Builder setUserData(String str) {
            this.a = str;
            return this;
        }

        public Builder setAdLoadType(TTAdLoadType tTAdLoadType) {
            this.py = tTAdLoadType;
            return this;
        }

        public Builder withBid(String str) {
            if (str == null) {
                return this;
            }
            this.um = str;
            return this;
        }

        public Builder setMediationAdSlot(IMediationAdSlot iMediationAdSlot) {
            this.hu = iMediationAdSlot;
            return this;
        }

        public Builder setRewardName(String str) {
            this.t = str;
            return this;
        }

        public Builder setRewardAmount(int i) {
            this.h = i;
            return this;
        }

        public AdSlot build() {
            AdSlot adSlot = new AdSlot();
            adSlot.n = this.n;
            adSlot.w = this.x;
            adSlot.x = this.q;
            adSlot.fs = this.l;
            adSlot.rv = this.w;
            adSlot.qg = this.qg;
            adSlot.s = this.s;
            adSlot.q = this.oa;
            adSlot.l = this.sz;
            adSlot.tj = this.fs;
            adSlot.cp = this.rv;
            adSlot.d = this.tj;
            adSlot.sz = this.cp;
            adSlot.k = this.k;
            adSlot.cy = this.cy;
            adSlot.hd = this.hd;
            adSlot.cd = this.cd;
            adSlot.a = this.ou;
            adSlot.py = this.wm;
            adSlot.ou = this.m;
            adSlot.oa = this.d;
            adSlot.um = this.um;
            adSlot.wm = this.a;
            adSlot.m = this.py;
            adSlot.t = this.t;
            adSlot.h = this.h;
            adSlot.hu = this.hu;
            return adSlot;
        }
    }
}
