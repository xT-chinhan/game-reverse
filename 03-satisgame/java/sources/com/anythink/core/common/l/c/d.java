package com.anythink.core.common.l.c;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    private String a = "";
    private String b = "";
    private boolean c = false;

    private d() {
    }

    private static d d() {
        return new d();
    }

    public static d a(String str) {
        d dVar = new d();
        dVar.a = str;
        return dVar;
    }

    public static d a(String str, String str2) {
        d dVar = new d();
        dVar.a = str;
        dVar.b = str2;
        return dVar;
    }

    public final String a() {
        return this.b;
    }

    public final String b() {
        return this.a;
    }

    private void b(String str) {
        this.b = str;
    }

    public final boolean c() {
        return this.c;
    }

    public final void a(boolean z) {
        this.c = z;
    }

    public final String toString() {
        return "HttpReqEntity{urlType='" + this.a + "', interceptKey='" + this.b + "', fromTcpFallback=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }
}
