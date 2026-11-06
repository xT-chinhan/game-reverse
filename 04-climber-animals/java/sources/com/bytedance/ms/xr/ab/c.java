package com.bytedance.ms.xr.ab;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    private JSONObject ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final int f549ms;
    private String xr;

    public c(int i) {
        this.f549ms = i;
    }

    public c(int i, Throwable th) {
        this.f549ms = i;
        if (th != null) {
            this.xr = th.getMessage();
        }
    }

    public c(int i, String str) {
        this.f549ms = i;
        this.xr = str;
    }

    public c(int i, JSONObject jSONObject) {
        this.f549ms = i;
        this.ah = jSONObject;
    }

    public boolean ms() {
        return this.f549ms == 0;
    }
}
