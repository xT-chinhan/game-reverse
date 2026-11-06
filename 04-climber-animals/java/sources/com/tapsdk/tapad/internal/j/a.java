package com.tapsdk.tapad.internal.j;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    private static final String c = "AdExperiment";
    static final /* synthetic */ boolean d = true;
    com.tapsdk.tapad.internal.u.a a;
    ConcurrentHashMap<String, Object> b;

    static class b {
        static a a = new a();

        b() {
        }
    }

    private a() {
        this.b = new ConcurrentHashMap<>();
        if (com.tapsdk.tapad.c.a != null) {
            if (!com.tapsdk.tapad.internal.u.a.b()) {
                com.tapsdk.tapad.internal.u.a.a(com.tapsdk.tapad.c.a);
            }
            this.a = com.tapsdk.tapad.internal.u.a.b(c);
        }
    }

    public static a b() {
        return b.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T a(String str, Class<T> cls, T t) {
        if (com.tapsdk.tapad.c.a == null) {
            return t;
        }
        if (this.b.containsKey(str)) {
            return cls.cast(this.b.get(str));
        }
        com.tapsdk.tapad.internal.u.a aVar = this.a;
        if (aVar == null) {
            return t;
        }
        try {
            if (aVar.a(str)) {
                if (Integer.class.equals(cls)) {
                    if (!d && !(t instanceof Integer)) {
                        throw new AssertionError();
                    }
                    Integer numValueOf = Integer.valueOf(this.a.a(str, ((Integer) t).intValue()));
                    this.b.put(str, numValueOf);
                    return cls.cast(numValueOf);
                }
                if (String.class.equals(cls)) {
                    if (!d && !(t instanceof String)) {
                        throw new AssertionError();
                    }
                    String strA = this.a.a(str, String.valueOf(t));
                    this.b.put(str, strA);
                    return cls.cast(strA);
                }
                if (Long.class.equals(cls)) {
                    if (!d && !(t instanceof Long)) {
                        throw new AssertionError();
                    }
                    Long lA = this.a.a(str, ((Long) t).longValue());
                    this.b.put(str, lA);
                    return cls.cast(lA);
                }
            }
        } catch (Throwable unused) {
        }
        return t;
    }

    public void a() {
        this.b.clear();
        com.tapsdk.tapad.internal.u.a aVar = this.a;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> void a(String str, T t) {
        if (com.tapsdk.tapad.c.a == null || str == null || str.length() == 0) {
            return;
        }
        this.b.put(str, t);
        try {
            if (this.a == null) {
                return;
            }
            Class<?> cls = t.getClass();
            if (cls.equals(Integer.class)) {
                if (!d && !(t instanceof Integer)) {
                    throw new AssertionError();
                }
                this.a.b(str, ((Integer) t).intValue());
                return;
            }
            if (cls.equals(String.class)) {
                if (!d && !(t instanceof String)) {
                    throw new AssertionError();
                }
                this.a.b(str, String.valueOf(t));
                return;
            }
            if (cls.equals(Long.class)) {
                if (!d && !(t instanceof Long)) {
                    throw new AssertionError();
                }
                this.a.b(str, ((Long) t).longValue());
            }
        } catch (NullPointerException unused) {
        }
    }
}
