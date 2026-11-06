package com.anythink.core.api;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class ATAdAppInfo {
    @Deprecated
    public boolean canHandleFunctionClick() {
        return false;
    }

    @Deprecated
    public void functionUrlClick() {
    }

    public abstract String getAppName();

    public abstract String getAppPackageName();

    public abstract String getAppPermissonUrl();

    public abstract String getAppPrivacyUrl();

    public abstract long getAppSize();

    public abstract String getAppVersion();

    public abstract String getDownloadCount();

    public String getFunctionUrl() {
        return "";
    }

    public abstract String getPublisher();

    public String toString() {
        return "Publisher: " + (TextUtils.isEmpty(getPublisher()) ? "" : getPublisher()) + " | AppVersion: " + (TextUtils.isEmpty(getAppVersion()) ? "" : getAppVersion()) + " | AppPrivacyUrl: " + (TextUtils.isEmpty(getAppPrivacyUrl()) ? "" : getAppPrivacyUrl()) + " | AppPermissonUrl: " + (TextUtils.isEmpty(getAppPermissonUrl()) ? "" : getAppPermissonUrl()) + " | AppName: " + (TextUtils.isEmpty(getAppName()) ? "" : getAppName()) + " | AppPackageName: " + (TextUtils.isEmpty(getAppPackageName()) ? "" : getAppPackageName()) + " | AppSize: " + getAppSize() + " | DownloadCount: " + getDownloadCount() + " | DescriptionUrl: " + getFunctionUrl();
    }
}
