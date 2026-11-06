package com.anythink.core.c.c;

import android.text.TextUtils;
import com.anythink.core.api.ATBidRequestInfo;
import com.anythink.core.common.h.by;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    by a;
    String b;
    JSONObject c;
    boolean d;
    long e;

    public final String toString() {
        return "";
    }

    public a(by byVar, JSONObject jSONObject) {
        this.a = byVar;
        this.c = jSONObject;
    }

    public a(by byVar, String str) {
        this.a = byVar;
        this.b = str;
    }

    public final JSONObject a() {
        return this.c;
    }

    public final by b() {
        return this.a;
    }

    public final void a(by byVar) {
        this.a = byVar;
    }

    public final boolean c() {
        return this.d;
    }

    public final void a(boolean z) {
        this.d = z;
    }

    public final void a(long j) {
        this.e = j;
    }

    public final boolean d() {
        return System.currentTimeMillis() >= this.e;
    }

    public final String e() {
        return this.b;
    }

    public final boolean f() {
        return TextUtils.equals(this.b, ATBidRequestInfo.NO_ADAPTER_ERROR_TYPE) || TextUtils.equals(this.b, ATBidRequestInfo.NO_SUPPORT_BIDDING_TYPE);
    }
}
