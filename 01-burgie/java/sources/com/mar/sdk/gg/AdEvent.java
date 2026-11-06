package com.mar.sdk.gg;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class AdEvent {
    public InstType instType = InstType.unknow;
    public AdType type = AdType.AdTypeUnknown;
    public boolean isReward = false;
    public String adId = "";
    public String adPlacementId = "";
    public String error = "";
    public String gameEvent = "";
    public double ecpm = 0.0d;
    public double revenue = 0.0d;
    public String adPlugName = "";
    public String adNetworkName = "";
    public String adSourceId = "";
    public String adGroupid = "";
    public String adCurrencyType = "CNY";
    public int adIsbidding = 0;
    public String adLoadId = "";
    public String adScene = this.gameEvent;

    public enum AdType {
        AdTypeUnknown,
        AdTypeSplash,
        AdTypeBanner,
        AdTypeInters,
        AdTypeVideo,
        AdTypeNativeBig,
        AdTypeFolatIcon,
        AdTypeLucency
    }

    public enum InstType {
        unknow,
        banner,
        nativeBanner,
        nativeBig,
        inters,
        intersVideo,
        nativeInters,
        splash,
        video,
        nativeTmpBanner,
        nativeTmpInters,
        nativeTmpBig,
        nativeTmpLucency,
        floatIcon,
        nativeLucency,
        nativeSplash
    }

    public enum LoadState {
        UNLOAD,
        LOADING,
        LOADED
    }

    public String toString() {
        return "AdEvent{instType=" + this.instType + ", type=" + this.type + ", isReward=" + this.isReward + ", ecpm=" + this.ecpm + ", adId=" + this.adId + ", adPlugName=" + this.adPlugName + ", adNetworkName=" + this.adNetworkName + ", adPlacementId=" + this.adPlacementId + ", adSourceId=" + this.adSourceId + ", adGroupid=" + this.adGroupid + ", adCurrencyType=" + this.adCurrencyType + ", adIsbidding=" + this.adIsbidding + ", adLoadId=" + this.adLoadId + ", revenue=" + this.revenue + ", error='" + this.error + "', adScene=" + this.adScene + ", gameEvent='" + this.gameEvent + '\'' + AbstractJsonLexerKt.END_OBJ;
    }
}
