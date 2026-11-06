package com.bytedance.sdk.openadsdk.downloadnew.core;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TTDownloadEventModel {
    private JSONObject ah;
    private JSONObject d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f3911ms;
    private String xr;

    public static TTDownloadEventModel builder() {
        return new TTDownloadEventModel();
    }

    public TTDownloadEventModel setMaterialMeta(JSONObject jSONObject) {
        this.d = jSONObject;
        return this;
    }

    public TTDownloadEventModel setTag(String str) {
        this.f3911ms = str;
        return this;
    }

    public TTDownloadEventModel setLabel(String str) {
        this.xr = str;
        return this;
    }

    public TTDownloadEventModel setExtJson(JSONObject jSONObject) {
        this.ah = jSONObject;
        return this;
    }

    public String getTag() {
        return this.f3911ms;
    }

    public String getLabel() {
        return this.xr;
    }

    public JSONObject getExtJson() {
        return this.ah;
    }

    public JSONObject getMaterialMeta() {
        return this.d;
    }
}
