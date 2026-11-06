package com.bytedance.sdk.component.ms;

import android.content.Context;
import android.text.TextUtils;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class ch {
    boolean ab;
    hi.xr ao;
    boolean c;
    u ch;
    x d;
    Context ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    com.bytedance.sdk.component.zb.ah f1255ms;
    zb ny;
    boolean u;
    boolean ub;
    boolean x;
    ms xr;
    String ah = "IESJSBridge";
    String hi = "host";
    final Set<String> sl = new LinkedHashSet();
    final Set<String> zb = new LinkedHashSet();

    ch(com.bytedance.sdk.component.zb.ah ahVar) {
        this.f1255ms = ahVar;
    }

    ch() {
    }

    public ch ms(ms msVar) {
        this.xr = msVar;
        return this;
    }

    public ch ms(String str) {
        this.ah = str;
        return this;
    }

    public ch ms(sl slVar) {
        this.d = x.ms(slVar);
        return this;
    }

    public ch ms(boolean z) {
        this.c = z;
        return this;
    }

    public ch xr(boolean z) {
        this.ab = z;
        return this;
    }

    public ch ms() {
        this.ub = true;
        return this;
    }

    public h xr() {
        ah();
        return new h(this);
    }

    public Context getContext() {
        return this.ka;
    }

    private void ah() {
        if ((this.f1255ms == null && !this.u && this.xr == null) || ((TextUtils.isEmpty(this.ah) && this.f1255ms != null) || this.d == null)) {
            throw new IllegalArgumentException("Requested arguments aren't set properly when building JsBridge.");
        }
    }
}
