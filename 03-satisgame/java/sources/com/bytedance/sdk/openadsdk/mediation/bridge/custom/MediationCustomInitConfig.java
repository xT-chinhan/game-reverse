package com.bytedance.sdk.openadsdk.mediation.bridge.custom;

import com.byazt.cp.n;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 55, 56, 57, 58, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FFMPEG_LOG_LEVEL, MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS, MediaPlayer.MEDIA_PLAYER_OPTION_GET_CUR_UI_FPS})
public class MediationCustomInitConfig {
    private String cp;
    private String fs;
    private String l;
    private String n;
    private String q;
    private String qg;
    private String rv;
    private String s;
    private String tj;
    private String w;
    private String x;

    public MediationCustomInitConfig(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.s = str;
        this.n = str2;
        this.qg = str3;
        this.q = str4;
        this.l = str5;
        this.w = str6;
        this.x = str7;
        this.fs = str8;
        this.rv = str9;
        this.tj = str10;
        this.cp = str11;
    }

    public MediationCustomInitConfig(ValueSet valueSet) {
        if (valueSet != null) {
            this.s = valueSet.stringValue(AVMDLDataLoader.KeyIsLiveGetPlayCacheSec);
            this.n = valueSet.stringValue(8534);
            this.qg = valueSet.stringValue(8535);
            this.q = valueSet.stringValue(8536);
            this.l = valueSet.stringValue(8537);
            this.w = valueSet.stringValue(8538);
            this.x = valueSet.stringValue(8539);
            this.fs = valueSet.stringValue(8540);
            this.rv = valueSet.stringValue(8541);
            this.tj = valueSet.stringValue(8542);
            this.cp = valueSet.stringValue(8543);
        }
    }

    public String getAppId() {
        return this.n;
    }

    public String getAppKey() {
        return this.qg;
    }

    public String getADNName() {
        return this.s;
    }

    public String getAdnInitClassName() {
        return this.q;
    }

    public String getBannerClassName() {
        return this.l;
    }

    public String getInterstitialClassName() {
        return this.w;
    }

    public String getRewardClassName() {
        return this.x;
    }

    public String getFullVideoClassName() {
        return this.fs;
    }

    public String getSplashClassName() {
        return this.rv;
    }

    public String getFeedClassName() {
        return this.tj;
    }

    public String getDrawClassName() {
        return this.cp;
    }

    public String toString() {
        return "MediationCustomInitConfig{mAppId='" + this.n + "', mAppKey='" + this.qg + "', mADNName='" + this.s + "', mAdnInitClassName='" + this.q + "', mBannerClassName='" + this.l + "', mInterstitialClassName='" + this.w + "', mRewardClassName='" + this.x + "', mFullVideoClassName='" + this.fs + "', mSplashClassName='" + this.rv + "', mFeedClassName='" + this.tj + "', mDrawClassName='" + this.cp + "'}";
    }
}
