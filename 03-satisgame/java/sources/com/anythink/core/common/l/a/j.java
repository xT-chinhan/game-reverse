package com.anythink.core.common.l.a;

import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public final class j {
    public i a;
    public int b;
    public String c;
    public Throwable d;
    public k e;
    public Map<String, List<String>> f;

    /* synthetic */ j(byte b) {
        this();
    }

    private j() {
    }

    public final String toString() {
        return "NetBridgeResponse{request=" + this.a + ", code=" + this.b + ", errorMsg='" + this.c + "', exception=" + this.d + ", responseBody=" + this.e + ", responseHeader=" + this.f + AbstractJsonLexerKt.END_OBJ;
    }

    private boolean a() {
        int i = this.b;
        return i == 200 || i == 201 || i == 204;
    }

    public static class a {
        private i a;
        private int b;
        private String c;
        private Throwable d;
        private k e;
        private Map<String, List<String>> f;

        public final a a(i iVar) {
            this.a = iVar;
            return this;
        }

        public final a a(int i) {
            this.b = i;
            return this;
        }

        public final a a(String str) {
            this.c = str;
            return this;
        }

        public final a a(Throwable th) {
            this.d = th;
            return this;
        }

        public final a a(k kVar) {
            this.e = kVar;
            return this;
        }

        public final a a(Map<String, List<String>> map) {
            this.f = map;
            return this;
        }

        public final j a() {
            j jVar = new j((byte) 0);
            jVar.a = this.a;
            jVar.b = this.b;
            jVar.c = this.c;
            jVar.d = this.d;
            jVar.e = this.e;
            jVar.f = this.f;
            return jVar;
        }
    }
}
