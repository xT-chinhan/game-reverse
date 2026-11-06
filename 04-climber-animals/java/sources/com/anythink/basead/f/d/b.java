package com.anythink.basead.f.d;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final String a = "262";
    private static volatile a b;

    private static boolean b() {
        try {
            return b != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void a(a aVar) {
        b = aVar;
    }

    public static a a() {
        return b;
    }
}
