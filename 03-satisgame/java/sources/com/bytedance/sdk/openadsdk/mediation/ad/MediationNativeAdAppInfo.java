package com.bytedance.sdk.openadsdk.mediation.ad;

import com.byazt.cp.n;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 55, 56, 57, 58, 763, 1945})
public class MediationNativeAdAppInfo {
    private String fs;
    private Map<String, String> l;
    private String n;
    private String q;
    private String qg;
    private Map<String, Object> rv;
    private long s;
    private String tj;
    private String w;
    private String x;

    public String getAppName() {
        return this.n;
    }

    public void setAppName(String str) {
        this.n = str;
    }

    public String getAuthorName() {
        return this.qg;
    }

    public void setAuthorName(String str) {
        this.qg = str;
    }

    public long getPackageSizeBytes() {
        return this.s;
    }

    public void setPackageSizeBytes(long j) {
        this.s = j;
    }

    public String getPermissionsUrl() {
        return this.q;
    }

    public void setPermissionsUrl(String str) {
        this.q = str;
    }

    public Map<String, String> getPermissionsMap() {
        return this.l;
    }

    public void setPermissionsMap(Map<String, String> map) {
        this.l = map;
    }

    public String getPrivacyAgreement() {
        return this.w;
    }

    public void setPrivacyAgreement(String str) {
        this.w = str;
    }

    public String getVersionName() {
        return this.x;
    }

    public void setVersionName(String str) {
        this.x = str;
    }

    public String getFunctionDescUrl() {
        return this.fs;
    }

    public void setFunctionDescUrl(String str) {
        this.fs = str;
    }

    public Map<String, Object> getAppInfoExtra() {
        return this.rv;
    }

    public void setAppInfoExtra(Map<String, Object> map) {
        this.rv = map;
    }

    public String getRegUrl() {
        return this.tj;
    }

    public void setRegUrl(String str) {
        this.tj = str;
    }
}
