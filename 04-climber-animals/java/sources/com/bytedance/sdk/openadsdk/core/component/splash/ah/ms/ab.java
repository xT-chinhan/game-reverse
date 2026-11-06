package com.bytedance.sdk.openadsdk.core.component.splash.ah.ms;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ab extends ms {
    private int ab;
    private boolean c;
    private long ch;
    private int d;
    private int hi;
    private String ka;
    private com.bytedance.sdk.openadsdk.ao.xr.xr.xr ny;
    private boolean x;

    public ab() {
        this.d = -1;
        this.ka = "unknown";
        this.c = false;
        this.x = false;
        this.hi = -1;
    }

    public ab(int i, String str, boolean z) {
        this.c = false;
        this.hi = -1;
        this.d = i;
        this.ka = str;
        this.x = z;
    }

    public int d() {
        return this.d;
    }

    public void xr(int i) {
        this.d = i;
    }

    public void ah(int i) {
        this.hi = i;
    }

    public String ka() {
        return TextUtils.isEmpty(this.ka) ? "unknown" : this.ka;
    }

    public void ms(String str) {
        this.ka = str;
    }

    public boolean c() {
        return this.c;
    }

    public void ms(boolean z) {
        this.c = z;
    }

    public int ab() {
        return this.ab;
    }

    public void d(int i) {
        this.ab = i;
    }

    public boolean x() {
        return this.x;
    }

    public void xr(boolean z) {
        this.x = z;
    }

    public com.bytedance.sdk.openadsdk.ao.xr.xr.xr ny() {
        return this.ny;
    }

    public void ms(com.bytedance.sdk.openadsdk.ao.xr.xr.xr xrVar) {
        this.ny = xrVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ms
    public long ah() {
        return this.ch;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.ah.ms.ms
    public void ms(long j) {
        this.ch = j;
    }
}
