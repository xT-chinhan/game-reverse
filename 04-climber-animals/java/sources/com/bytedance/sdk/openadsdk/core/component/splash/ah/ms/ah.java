package com.bytedance.sdk.openadsdk.core.component.splash.ah.ms;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends ms {
    private String ab;
    private Context c;
    private com.bytedance.sdk.openadsdk.ao.xr.ah.xr ch;
    public x d;
    private boolean hi;
    private c ka;
    private int ny;
    private int x = 1;

    public ah(Context context, String str, c cVar, x xVar, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        this.c = context;
        this.ab = str;
        this.ka = cVar;
        this.hi = cVar.ka();
        this.xr = cVar.xr();
        this.d = xVar;
        this.ch = xrVar;
    }

    public c d() {
        return this.ka;
    }

    public x ka() {
        return this.d;
    }

    public Context getContext() {
        return this.c;
    }

    public String c() {
        return this.ab;
    }

    public com.bytedance.sdk.openadsdk.ao.xr.ah.xr ab() {
        return this.ch;
    }

    public int x() {
        return this.ny;
    }

    public boolean ny() {
        return this.hi;
    }
}
