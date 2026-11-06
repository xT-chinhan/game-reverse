package com.mcto.sspsdk;

import com.qq.e.comm.managers.setting.GlobalSetting;

/* JADX INFO: loaded from: classes2.dex */
public enum QyBannerStyle {
    QYBANNER_FULL("1", "H,2:1", "H,16:9"),
    QYBANNER_TITLEIN("2", "H,2:1", "H,16:9"),
    QYBANNER_TITLEBELOW(GlobalSetting.SPLASH_AD, "H,2:1", "H,16:9"),
    QYBANNER_TITLEABOVE(GlobalSetting.NATIVE_EXPRESS_AD, "H,2:1", "H,16:9"),
    QYBANNER_STRIP(GlobalSetting.REWARD_VIDEO_AD, "H,16:3", "H,16:9"),
    QYBANNER_TITLEBUTTON(GlobalSetting.NATIVE_UNIFIED_AD, "H,2:1", "H,16:9"),
    QYBANNER_FULL_DETAIL_PAGE("1", "H,2:1", "H,16:9");

    private final String imageRadio;
    private final String value;
    private final String videoRadio;

    QyBannerStyle(String str, String str2, String str3) {
        this.value = str;
        this.imageRadio = str2;
        this.videoRadio = str3;
    }

    public String getImageRadio() {
        return this.imageRadio;
    }

    public String getValue() {
        return this.value;
    }

    public String getVideoRadio() {
        return this.videoRadio;
    }
}
