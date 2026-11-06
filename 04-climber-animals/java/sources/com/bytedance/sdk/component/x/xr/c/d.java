package com.bytedance.sdk.component.x.xr.c;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class d {
    private boolean ah;
    private int c;
    private int d;
    private JSONObject ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f1551ms;
    private String xr;

    d(String str, String str2, boolean z, int i, JSONObject jSONObject, int i2) {
        this.f1551ms = str;
        this.xr = str2;
        this.ah = z;
        this.d = i;
        this.ka = jSONObject;
        this.c = i2;
    }

    public JSONObject ms() {
        if (this.ka == null) {
            this.ka = new JSONObject();
        }
        return this.ka;
    }

    public String xr() {
        return this.f1551ms;
    }

    public String ah() {
        return this.xr;
    }

    public boolean d() {
        return this.ah;
    }

    public int ka() {
        return this.d;
    }

    public void ms(int i) {
        this.d = i;
    }
}
