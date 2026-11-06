package com.tapsdk.tapad;

/* JADX INFO: loaded from: classes2.dex */
public interface CustomController {
    boolean alist();

    String getDevImei();

    String getDevOaid();

    TapAdLocation getTapAdLocation();

    boolean isCanUseAndroidId();

    default boolean isCanUseBssid() {
        return true;
    }

    boolean isCanUseLocation();

    default boolean isCanUsePhoneMacAddress() {
        return true;
    }

    boolean isCanUsePhoneState();

    default boolean isCanUseSensor() {
        return true;
    }

    default boolean isCanUseSsid() {
        return true;
    }

    boolean isCanUseWifiState();

    boolean isCanUseWriteExternal();

    CustomUser provideCustomUser();
}
