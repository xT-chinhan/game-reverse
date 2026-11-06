package com.byazt.cxa;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 228, 1673})
public class DeepLink {
    public long id;
    public JSONObject json;
    public String mCloudGameUrl;
    public String mOpenUrl;
    public String mWebTitle;
    public String mWebUrl;
    public String packageName;

    public DeepLink(String str, String str2, String str3) {
        this.mOpenUrl = str;
        this.mWebUrl = str2;
        this.mWebTitle = str3;
    }

    public DeepLink() {
    }

    public String getWebUrl() {
        return this.mWebUrl;
    }

    public void setWebUrl(String str) {
        this.mWebUrl = str;
    }

    public String getOpenUrl() {
        return this.mOpenUrl;
    }

    public void setOpenUrl(String str) {
        this.mOpenUrl = str;
    }

    public void setCloudGameUrl(String str) {
        this.mCloudGameUrl = str;
    }

    public String getCloudGameUrl() {
        return this.mCloudGameUrl;
    }

    public String getWebTitle() {
        return this.mWebTitle;
    }

    public void setWebTitle(String str) {
        this.mWebTitle = str;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setJson(JSONObject jSONObject) {
        this.json = jSONObject;
    }

    public JSONObject getJson() {
        return this.json;
    }
}
