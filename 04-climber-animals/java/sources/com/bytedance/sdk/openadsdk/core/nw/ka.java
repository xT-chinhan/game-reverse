package com.bytedance.sdk.openadsdk.core.nw;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ka {
    private String ab;
    private String ah;
    private int c;
    private int d;
    private int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f3062ms;
    private String xr;

    public String ms() {
        return this.ab;
    }

    public void ms(String str) {
        this.ab = str;
    }

    public String xr() {
        return this.f3062ms;
    }

    public void xr(String str) {
        this.f3062ms = str;
    }

    public String ah() {
        return this.xr;
    }

    public void ah(String str) {
        this.xr = str;
    }

    public String d() {
        return this.ah;
    }

    public void d(String str) {
        this.ah = str;
    }

    public int ka() {
        return this.d;
    }

    public void ms(int i) {
        this.d = i;
    }

    public int c() {
        return this.ka;
    }

    public void xr(int i) {
        this.ka = i;
    }

    public int ab() {
        return this.c;
    }

    public void ah(int i) {
        this.c = i;
    }

    public JSONObject x() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_name", ah());
            jSONObject.put("app_size", ab());
            jSONObject.put("comment_num", c());
            jSONObject.put("download_url", xr());
            jSONObject.put("package_name", d());
            jSONObject.put("score", ka());
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.xr(e.toString());
        }
        return jSONObject;
    }
}
