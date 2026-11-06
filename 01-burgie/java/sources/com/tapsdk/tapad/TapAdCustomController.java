package com.tapsdk.tapad;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TapAdCustomController {
    public boolean alist() {
        return true;
    }

    public String getDevImei() {
        return null;
    }

    public String getDevOaid() {
        return null;
    }

    public TapAdLocation getTapAdLocation() {
        return null;
    }

    public boolean isCanUseAndroidId() {
        return true;
    }

    public boolean isCanUseBssid() {
        return true;
    }

    public boolean isCanUseLocation() {
        return true;
    }

    public boolean isCanUsePhoneMacAddress() {
        return true;
    }

    public boolean isCanUsePhoneState() {
        return true;
    }

    public boolean isCanUseSensor() {
        return true;
    }

    public boolean isCanUseSsid() {
        return true;
    }

    public boolean isCanUseWifiState() {
        return true;
    }

    public boolean isCanUseWriteExternal() {
        return true;
    }

    public CustomUser provideCustomUser() {
        return null;
    }
}
