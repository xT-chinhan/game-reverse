package com.tapsdk.tapad;

/* JADX INFO: loaded from: classes3.dex */
public interface CustomController {
    boolean alist();

    String getDevImei();

    String getDevOaid();

    TapAdLocation getTapAdLocation();

    boolean isCanUseAndroidId();

    boolean isCanUseLocation();

    boolean isCanUsePhoneState();

    boolean isCanUseWifiState();

    boolean isCanUseWriteExternal();

    CustomUser provideCustomUser();
}
