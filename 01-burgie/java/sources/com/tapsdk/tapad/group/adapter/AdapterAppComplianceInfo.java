package com.tapsdk.tapad.group.adapter;

/* JADX INFO: loaded from: classes2.dex */
public final class AdapterAppComplianceInfo {
    public static final AdapterAppComplianceInfo EMPTY = new AdapterAppComplianceInfo("", "", "", "", "", "", "");
    private final String adLogoUrl;
    private final String appName;
    private final String appVersion;
    private final String developerName;
    private final String functionDescriptionUrl;
    private final String permissionUrl;
    private final String privacyUrl;

    public AdapterAppComplianceInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.appName = safe(str);
        this.appVersion = safe(str2);
        this.developerName = safe(str3);
        this.privacyUrl = safe(str4);
        this.functionDescriptionUrl = safe(str5);
        this.permissionUrl = safe(str6);
        this.adLogoUrl = safe(str7);
    }

    private static String safe(String str) {
        return str == null ? "" : str;
    }

    public String getAdLogoUrl() {
        return this.adLogoUrl;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getDeveloperName() {
        return this.developerName;
    }

    public String getFunctionDescriptionUrl() {
        return this.functionDescriptionUrl;
    }

    public String getPermissionUrl() {
        return this.permissionUrl;
    }

    public String getPrivacyUrl() {
        return this.privacyUrl;
    }
}
