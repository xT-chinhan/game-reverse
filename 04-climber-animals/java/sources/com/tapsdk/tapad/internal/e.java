package com.tapsdk.tapad.internal;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class e {
    private static final ConcurrentHashMap<Integer, a> a = new ConcurrentHashMap<>();

    public interface a {
        void a(Throwable th);

        void onAdClose();

        void onAdShow();

        void onAdValidShow();
    }

    public static a a(Integer num) {
        return a.get(num);
    }

    public static void a(Integer num, a aVar) {
        a.put(num, aVar);
    }

    public static void b(Integer num) {
        a.remove(num);
    }
}
