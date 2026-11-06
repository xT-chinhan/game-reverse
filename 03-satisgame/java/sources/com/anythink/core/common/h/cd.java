package com.anythink.core.common.h;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public class cd {
    public String a;
    public String b;
    public int c;
    private final String d;
    private final double e;
    private final by f;

    public final void a(double d) {
        by byVar = this.f;
        if (byVar != null) {
            byVar.ag(2);
            this.f.j(d);
        }
    }

    public final void a(String str) {
        by byVar = this.f;
        if (byVar != null) {
            byVar.q(str);
        }
    }

    public cd(int i, String str, String str2, double d, String str3, by byVar) {
        this.c = i;
        this.a = str;
        this.b = str3;
        this.e = d;
        this.d = str2;
        this.f = byVar;
    }

    private String c() {
        return this.a;
    }

    private String d() {
        return this.b;
    }

    public final double a() {
        return this.e;
    }

    public final String b() {
        return this.d;
    }

    private int e() {
        return this.c;
    }

    public String toString() {
        return "{channelId='" + this.a + "', bidType='" + this.d + "', price=" + this.e + ", adnPlacementId='" + this.b + "', filterType=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }
}
