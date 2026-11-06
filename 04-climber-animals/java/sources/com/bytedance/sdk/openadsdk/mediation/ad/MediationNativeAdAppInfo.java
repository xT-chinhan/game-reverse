package com.bytedance.sdk.openadsdk.mediation.ad;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MediationNativeAdAppInfo {
    private String ab;
    private long ah;
    private String c;
    private String ch;
    private String d;
    private Map<String, String> ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f3953ms;
    private Map<String, Object> ny;
    private String x;
    private String xr;

    public String getAppName() {
        return this.f3953ms;
    }

    public void setAppName(String str) {
        this.f3953ms = str;
    }

    public String getAuthorName() {
        return this.xr;
    }

    public void setAuthorName(String str) {
        this.xr = str;
    }

    public long getPackageSizeBytes() {
        return this.ah;
    }

    public void setPackageSizeBytes(long j) {
        this.ah = j;
    }

    public String getPermissionsUrl() {
        return this.d;
    }

    public void setPermissionsUrl(String str) {
        this.d = str;
    }

    public Map<String, String> getPermissionsMap() {
        return this.ka;
    }

    public void setPermissionsMap(Map<String, String> map) {
        this.ka = map;
    }

    public String getPrivacyAgreement() {
        return this.c;
    }

    public void setPrivacyAgreement(String str) {
        this.c = str;
    }

    public String getVersionName() {
        return this.ab;
    }

    public void setVersionName(String str) {
        this.ab = str;
    }

    public String getFunctionDescUrl() {
        return this.x;
    }

    public void setFunctionDescUrl(String str) {
        this.x = str;
    }

    public Map<String, Object> getAppInfoExtra() {
        return this.ny;
    }

    public void setAppInfoExtra(Map<String, Object> map) {
        this.ny = map;
    }

    public String getRegUrl() {
        return this.ch;
    }

    public void setRegUrl(String str) {
        this.ch = str;
    }
}
