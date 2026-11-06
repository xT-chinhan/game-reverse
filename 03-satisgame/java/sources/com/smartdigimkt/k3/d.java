package com.smartdigimkt.k3;

import android.os.SystemClock;
import android.text.TextUtils;
import com.smartdigimkt.b3.j;
import com.smartdigimkt.b3.k;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d {
    public final String b;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;
    public String i;
    public String j;
    public final String a = getClass().getSimpleName();
    public final CopyOnWriteArrayList c = new CopyOnWriteArrayList();

    public d(String str) {
        this.b = str;
    }

    public static void d(d dVar) {
        dVar.getClass();
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0021  */
    public static void e(d dVar) {
        long j;
        dVar.getClass();
        try {
            long j2 = dVar.e - dVar.d;
            if (j2 < 0) {
                j2 = 0;
            }
            long j3 = dVar.h;
            if (j3 > 0) {
                long j4 = dVar.g;
                if (j4 <= 0 || j3 < j4) {
                    j = 0;
                } else {
                    j = j3 - j4;
                }
            } else {
                j = 0;
            }
            if (TextUtils.isEmpty(dVar.i) || TextUtils.isEmpty(dVar.j)) {
                return;
            }
            com.smartdigimkt.n3.b bVarA = com.smartdigimkt.n3.b.a();
            String str = dVar.i;
            bVarA.getClass();
            k kVar = TextUtils.isEmpty(str) ? null : (k) bVarA.b.get(str);
            if (kVar != null) {
                j jVar = new j();
                jVar.a = dVar.j;
                jVar.b = j2;
                jVar.c = j;
                long j5 = dVar.f;
                jVar.d = j5 > 0 ? j5 / com.anythink.china.a.c.k : 0L;
                kVar.l.add(jVar);
            }
        } catch (Throwable unused) {
        }
    }

    public static void f(d dVar) {
        dVar.getClass();
    }

    public abstract void a();

    public abstract void a(c cVar);

    public abstract void a(String str);

    public boolean a(int i) {
        return i == 200;
    }

    public abstract boolean a(InputStream inputStream);

    public abstract Map b();

    public final void c() {
        this.g = SystemClock.elapsedRealtime();
        a(new c(this));
    }

    public void a(HttpURLConnection httpURLConnection, int i) {
        this.f = httpURLConnection.getContentLength();
    }
}
