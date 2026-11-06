package com.anythink.core.basead.a;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    private final int a;
    private final String b;

    /* synthetic */ d(a aVar, byte b) {
        this(aVar);
    }

    private d(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
    }

    public final int a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public static class a {
        private int a;
        private String b;

        public final a a(int i) {
            this.a = i;
            return this;
        }

        public final a a(String str) {
            this.b = str;
            return this;
        }

        public final d a() {
            return new d(this, (byte) 0);
        }
    }
}
