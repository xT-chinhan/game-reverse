package com.anythink.core.basead.a;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    private final String a;
    private final boolean b;
    private final String c;

    /* synthetic */ c(a aVar, byte b) {
        this(aVar);
    }

    private c(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
    }

    public final String a() {
        return this.a;
    }

    public final boolean b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public static class a {
        private String a;
        private boolean b;
        private String c;

        public final a a(String str) {
            this.a = str;
            return this;
        }

        public final a a(boolean z) {
            this.b = z;
            return this;
        }

        public final a b(String str) {
            this.c = str;
            return this;
        }

        public final c a() {
            return new c(this, (byte) 0);
        }
    }
}
