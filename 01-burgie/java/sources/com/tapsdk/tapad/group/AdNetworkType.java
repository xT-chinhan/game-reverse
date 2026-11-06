package com.tapsdk.tapad.group;

import com.qq.e.comm.managers.setting.GlobalSetting;

/* JADX INFO: loaded from: classes2.dex */
public enum AdNetworkType {
    AD_UNKOWN(0, ""),
    AD_TAP(3, "TapADN"),
    AD_TT(1, "CSJ"),
    AD_GDT(2, "GDT"),
    AD_IQY(4, "IQY"),
    AD_BD(5, GlobalSetting.BD_SDK_WRAPPER);

    final String name;
    final int value;

    AdNetworkType(int i, String str) {
        this.value = i;
        this.name = str;
    }

    public static AdNetworkType getAdNetworkForValue(int i) {
        AdNetworkType adNetworkType = AD_UNKOWN;
        for (AdNetworkType adNetworkType2 : values()) {
            if (i == adNetworkType2.value) {
                return adNetworkType2;
            }
        }
        return adNetworkType;
    }

    public String getName() {
        return this.name;
    }

    public int getValue() {
        return this.value;
    }
}
