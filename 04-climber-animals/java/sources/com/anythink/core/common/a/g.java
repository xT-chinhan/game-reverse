package com.anythink.core.common.a;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class g {
    private String a;
    private String b;
    private String c;
    private int d;
    private String e;

    public final String a() {
        return TextUtils.isEmpty(this.a) ? "" : this.a;
    }

    public final void a(String str) {
        this.a = str;
    }

    public final String b() {
        return TextUtils.isEmpty(this.b) ? "" : this.b;
    }

    public final void b(String str) {
        this.b = str;
    }

    public final String c() {
        return TextUtils.isEmpty(this.c) ? "" : this.c;
    }

    public final void c(String str) {
        this.c = str;
    }

    public final int d() {
        return this.d;
    }

    public final void a(int i) {
        this.d = i;
    }

    public final String e() {
        return TextUtils.isEmpty(this.e) ? "" : this.e;
    }

    public final void d(String str) {
        this.e = str;
    }

    public final String toString() {
        return "AdxOfferTrackingRecordBean{placementId='" + this.a + "', dspId='" + this.b + "', offerId='" + this.c + "', tkType=" + this.d + ", extraInfo='" + this.e + "'}";
    }
}
