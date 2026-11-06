package com.umeng.crash;

import android.app.Application;
import android.content.Context;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: UCrash */
/* JADX INFO: loaded from: classes4.dex */
final class f {

    /* JADX INFO: compiled from: UCrash */
    interface a {
        void a(String str, OutputStream outputStream) throws IOException;

        void a(String str, String str2);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0052 A[Catch: all -> 0x005c, TRY_LEAVE, TryCatch #1 {, blocks: (B:8:0x0008, B:10:0x0012, B:12:0x0016, B:17:0x0027, B:19:0x002b, B:23:0x003c, B:24:0x0047, B:26:0x004b, B:30:0x0052, B:14:0x001a, B:16:0x001e, B:20:0x0037), top: B:38:0x0008, inners: #0 }] */
    static synchronized int a(Context context, b bVar) {
        int iA;
        if (context == null) {
            return -1;
        }
        com.umeng.crash.a.a().a = bVar;
        if ((bVar.b || bVar.g || bVar.l) && (context instanceof Application)) {
            ((Application) context).registerActivityLifecycleCallbacks(e.a());
        }
        if (bVar.b) {
            d dVarA = d.a();
            dVarA.a = bVar;
            dVarA.b = Thread.getDefaultUncaughtExceptionHandler();
            try {
                Thread.setDefaultUncaughtExceptionHandler(dVarA);
            } catch (Throwable th) {
                UCrash.a().a("UCrash.Java", "setDefaultUncaughtExceptionHandler failed", th);
            }
            if (!bVar.g || bVar.l) {
                iA = i.a().a(bVar);
            } else {
                iA = 0;
            }
            return iA;
        }
        if (bVar.g) {
            iA = i.a().a(bVar);
        } else {
            iA = i.a().a(bVar);
        }
        return iA;
        throw th;
    }

    /* JADX INFO: compiled from: UCrash */
    static class b {
        a a;
        boolean b;
        boolean c;
        boolean d;
        boolean e;
        boolean g;
        boolean h;
        boolean j;
        boolean l;
        boolean m;
        boolean q;
        boolean f = true;
        boolean i = true;
        boolean k = true;
        boolean n = true;
        boolean o = true;
        boolean p = true;

        b() {
        }
    }
}
