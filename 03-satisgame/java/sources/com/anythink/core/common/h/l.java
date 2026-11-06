package com.anythink.core.common.h;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class l {
    private static final int a = 10;
    private int b;
    private int c;
    private int d;
    private long e;
    private int f;
    private int g;
    private long h;

    public interface a {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
    }

    private l() {
    }

    public static l a(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return null;
        }
        long jOptLong = jSONObject.optLong("req_pacing");
        if (jOptLong <= 0) {
            return null;
        }
        l lVar = new l();
        int iOptInt = jSONObject.optInt("id");
        if (iOptInt == 1) {
            lVar.c = jSONObject.optInt("req_no_fill_nc");
        } else if (iOptInt == 2) {
            lVar.d = jSONObject.optInt("req_no_fill_s");
            lVar.e = jSONObject.optLong("req_no_fill_sgt");
        } else {
            if (iOptInt != 3) {
                return null;
            }
            lVar.f = jSONObject.optInt("req_no_fill_sr");
            lVar.e = jSONObject.optLong("req_no_fill_sgt");
            lVar.g = jSONObject.optInt(com.anythink.core.common.f.a.C0017a.n, 10);
        }
        lVar.b = iOptInt;
        lVar.h = jOptLong;
        if (lVar.c > 0 || lVar.d > 0 || lVar.e > 0 || lVar.f > 0 || jOptLong > 0) {
            return lVar;
        }
        return null;
    }

    public final int a() {
        return this.b;
    }

    private void a(int i) {
        this.b = i;
    }

    public final int b() {
        return this.c;
    }

    private void b(int i) {
        this.c = i;
    }

    public final int c() {
        return this.d;
    }

    private void c(int i) {
        this.d = i;
    }

    public final long d() {
        return this.e;
    }

    private void a(long j) {
        this.e = j;
    }

    public final int e() {
        return this.f;
    }

    private void d(int i) {
        this.f = i;
    }

    public final long f() {
        return this.h;
    }

    private void b(long j) {
        this.h = j;
    }

    public final int g() {
        return this.g;
    }

    private void e(int i) {
        this.g = i;
    }

    public final String toString() {
        return "AdSourceFltRuleEntity{id=" + this.b + ", reqNoFillNc=" + this.c + ", reqNoFillS=" + this.d + ", reqNoFillSgtTime=" + this.e + ", reqNoFillSr=" + this.f + ", reqPacingTime=" + this.h + AbstractJsonLexerKt.END_OBJ;
    }
}
