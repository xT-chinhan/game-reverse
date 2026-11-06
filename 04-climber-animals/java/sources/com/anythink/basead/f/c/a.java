package com.anythink.basead.f.c;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static volatile b a;

    public static boolean a() {
        try {
            return a != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void a(b bVar) {
        a = bVar;
    }

    public static b b() {
        return a;
    }
}
