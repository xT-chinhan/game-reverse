package com.mcto.sspsdk;

/* JADX INFO: loaded from: classes2.dex */
public abstract class QyCustomMade {
    public boolean alist() {
        return true;
    }

    public boolean canListeningBackground() {
        return true;
    }

    public boolean canUseNotification() {
        return true;
    }

    public String getAdxAdSwitch() {
        return "1";
    }

    public int getAppMode() {
        return 0;
    }

    public String getChannelId() {
        return null;
    }

    public String getDevAndroidId() {
        return null;
    }

    public String getDevImei() {
        return null;
    }

    public String getDevMac() {
        return null;
    }

    public String getDeviceFingerprint() {
        return null;
    }

    public String getIqid() {
        return null;
    }

    public abstract String getOaid();

    public String getPersonalAdSwitch() {
        return "0";
    }

    public QyLocation getQyLocation() {
        return null;
    }

    public String getQyid() {
        return null;
    }

    public String getUserCookie() {
        return null;
    }

    public String getUserId() {
        return null;
    }

    public String getUserType() {
        return null;
    }

    public String getWifiSSID() {
        return null;
    }

    public boolean isCanUsePhoneAndroidId() {
        return true;
    }

    public boolean isCanUsePhoneIMEI() {
        return true;
    }

    public boolean isCanUsePhoneMacAddress() {
        return true;
    }

    public boolean isCanUsePhoneWifiSSID() {
        return true;
    }

    public boolean registration(String str) {
        return false;
    }
}
