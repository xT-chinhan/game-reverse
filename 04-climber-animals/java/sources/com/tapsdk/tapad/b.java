package com.tapsdk.tapad;

import com.tapsdk.tapad.internal.logging.HttpLoggingInterceptor;
import com.tapsdk.tapad.model.entities.TapAdResp;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    private static volatile boolean a = false;
    private static volatile String b = "";
    private static PublishSubject<com.tapsdk.tapad.internal.tracker.experiment.entities.c> c;
    private static volatile List<InterfaceC0578b> d;
    private static volatile HttpLoggingInterceptor.b e = new a();
    private static volatile HttpLoggingInterceptor.Level f = HttpLoggingInterceptor.Level.NONE;

    static class a implements HttpLoggingInterceptor.b {
        a() {
        }

        @Override // com.tapsdk.tapad.internal.logging.HttpLoggingInterceptor.b
        public void a(String str, Map<String, String> map) {
        }
    }

    /* JADX INFO: renamed from: com.tapsdk.tapad.b$b, reason: collision with other inner class name */
    public interface InterfaceC0578b {
        TapAdResp.h a(TapAdResp.h hVar);
    }

    public static void a(PublishSubject<com.tapsdk.tapad.internal.tracker.experiment.entities.c> publishSubject) {
        c = publishSubject;
    }

    public static void a(String str) {
        if (com.tapsdk.tapad.internal.network.c.a.c(str)) {
            b = str;
        }
    }

    public static void a(List<InterfaceC0578b> list) {
        d = list;
    }

    public static void a(boolean z, HttpLoggingInterceptor.b bVar, HttpLoggingInterceptor.Level level) {
        a = z;
        e = bVar;
        f = level;
    }

    public static boolean a() {
        return false;
    }

    public static String b() {
        return b;
    }

    public static List<InterfaceC0578b> c() {
        return d;
    }

    public static boolean d() {
        return a;
    }

    public static PublishSubject<com.tapsdk.tapad.internal.tracker.experiment.entities.c> e() {
        return c;
    }

    public static HttpLoggingInterceptor.Level f() {
        return f;
    }

    public static HttpLoggingInterceptor.b g() {
        return e;
    }
}
