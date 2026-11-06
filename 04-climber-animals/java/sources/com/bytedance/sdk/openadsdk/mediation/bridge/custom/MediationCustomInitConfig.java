package com.bytedance.sdk.openadsdk.mediation.bridge.custom;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* JADX INFO: loaded from: classes2.dex */
public class MediationCustomInitConfig {
    private String ab;
    private String ah;
    private String c;
    private String ch;
    private String d;
    private String hi;
    private String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f3973ms;
    private String ny;
    private String x;
    private String xr;

    public MediationCustomInitConfig(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.ah = str;
        this.f3973ms = str2;
        this.xr = str3;
        this.d = str4;
        this.ka = str5;
        this.c = str6;
        this.ab = str7;
        this.x = str8;
        this.ny = str9;
        this.ch = str10;
        this.hi = str11;
    }

    public MediationCustomInitConfig(ValueSet valueSet) {
        if (valueSet != null) {
            this.ah = valueSet.stringValue(AVMDLDataLoader.KeyIsLiveGetPlayCacheSec);
            this.f3973ms = valueSet.stringValue(8534);
            this.xr = valueSet.stringValue(8535);
            this.d = valueSet.stringValue(8536);
            this.ka = valueSet.stringValue(8537);
            this.c = valueSet.stringValue(8538);
            this.ab = valueSet.stringValue(8539);
            this.x = valueSet.stringValue(8540);
            this.ny = valueSet.stringValue(8541);
            this.ch = valueSet.stringValue(8542);
            this.hi = valueSet.stringValue(8543);
        }
    }

    public String getAppId() {
        return this.f3973ms;
    }

    public String getAppKey() {
        return this.xr;
    }

    public String getADNName() {
        return this.ah;
    }

    public String getAdnInitClassName() {
        return this.d;
    }

    public String getBannerClassName() {
        return this.ka;
    }

    public String getInterstitialClassName() {
        return this.c;
    }

    public String getRewardClassName() {
        return this.ab;
    }

    public String getFullVideoClassName() {
        return this.x;
    }

    public String getSplashClassName() {
        return this.ny;
    }

    public String getFeedClassName() {
        return this.ch;
    }

    public String getDrawClassName() {
        return this.hi;
    }

    public String toString() {
        return "MediationCustomInitConfig{mAppId='" + this.f3973ms + "', mAppKey='" + this.xr + "', mADNName='" + this.ah + "', mAdnInitClassName='" + this.d + "', mBannerClassName='" + this.ka + "', mInterstitialClassName='" + this.c + "', mRewardClassName='" + this.ab + "', mFullVideoClassName='" + this.x + "', mSplashClassName='" + this.ny + "', mFeedClassName='" + this.ch + "', mDrawClassName='" + this.hi + "'}";
    }
}
