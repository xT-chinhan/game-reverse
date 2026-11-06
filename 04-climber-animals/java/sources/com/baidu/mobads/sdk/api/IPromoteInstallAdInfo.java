package com.baidu.mobads.sdk.api;

/* JADX INFO: loaded from: classes.dex */
public interface IPromoteInstallAdInfo {
    String getAppPublisher();

    String getAppVersion();

    String getBrandName();

    String getECPMLevel();

    String getFunctionUrl();

    String getIconUrl();

    String getPECPM();

    String getPermissionUrl();

    String getPrivacyUrl();

    String getUnionLogoUrl();

    void handleAdInstall();
}
