package com.bytedance.sdk.openadsdk.mediation.bridge.custom;

import com.byazt.vzx.pr;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@pr(pr = {0, 78, 79, 80, 81, 232, 233, 234})
public class MediationCustomInitConfig {
    private String aj;
    private String c;
    private String fw;
    private String hn;
    private String hw;
    private String pr;
    private String uc;
    private String vk;
    private String w;
    private String x;
    private String zo;

    public MediationCustomInitConfig(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.hn = str;
        this.pr = str2;
        this.hw = str3;
        this.x = str4;
        this.c = str5;
        this.uc = str6;
        this.fw = str7;
        this.zo = str8;
        this.aj = str9;
        this.vk = str10;
        this.w = str11;
    }

    public MediationCustomInitConfig(ValueSet valueSet) {
        if (valueSet != null) {
            this.hn = valueSet.stringValue(AVMDLDataLoader.KeyIsLiveGetPlayCacheSec);
            this.pr = valueSet.stringValue(8534);
            this.hw = valueSet.stringValue(8535);
            this.x = valueSet.stringValue(8536);
            this.c = valueSet.stringValue(8537);
            this.uc = valueSet.stringValue(8538);
            this.fw = valueSet.stringValue(8539);
            this.zo = valueSet.stringValue(8540);
            this.aj = valueSet.stringValue(8541);
            this.vk = valueSet.stringValue(8542);
            this.w = valueSet.stringValue(8543);
        }
    }

    public String getAppId() {
        return this.pr;
    }

    public String getAppKey() {
        return this.hw;
    }

    public String getADNName() {
        return this.hn;
    }

    public String getAdnInitClassName() {
        return this.x;
    }

    public String getBannerClassName() {
        return this.c;
    }

    public String getInterstitialClassName() {
        return this.uc;
    }

    public String getRewardClassName() {
        return this.fw;
    }

    public String getFullVideoClassName() {
        return this.zo;
    }

    public String getSplashClassName() {
        return this.aj;
    }

    public String getFeedClassName() {
        return this.vk;
    }

    public String getDrawClassName() {
        return this.w;
    }

    public String toString() {
        return "MediationCustomInitConfig{mAppId='" + this.pr + "', mAppKey='" + this.hw + "', mADNName='" + this.hn + "', mAdnInitClassName='" + this.x + "', mBannerClassName='" + this.c + "', mInterstitialClassName='" + this.uc + "', mRewardClassName='" + this.fw + "', mFullVideoClassName='" + this.zo + "', mSplashClassName='" + this.aj + "', mFeedClassName='" + this.vk + "', mDrawClassName='" + this.w + '\'' + AbstractJsonLexerKt.END_OBJ;
    }
}
