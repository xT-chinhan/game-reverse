package com.tapsdk.tapad.internal.q.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class e implements b {
    private static final int h = 10;
    private static final String i = "WIFI";
    private static final String j = "mobile";
    private static final String k = "unknown";
    private final com.tapsdk.tapad.internal.q.h.c a;
    final Set<c> b;
    private int c;
    private int d;
    private final com.tapsdk.tapad.internal.q.h.b e;
    private float f;
    private final ConnectivityManager g;

    public e(Context context) {
        this.b = new HashSet();
        this.c = 0;
        com.tapsdk.tapad.internal.q.h.c cVar = new com.tapsdk.tapad.internal.q.h.c(context);
        this.a = cVar;
        this.d = 10;
        this.g = (ConnectivityManager) context.getSystemService("connectivity");
        this.e = new com.tapsdk.tapad.internal.q.h.b();
        this.f = cVar.a(a(a()));
    }

    e(Context context, com.tapsdk.tapad.internal.q.h.c cVar) {
        this.b = new HashSet();
        this.c = 0;
        this.a = cVar;
        this.d = 10;
        this.g = (ConnectivityManager) context.getSystemService("connectivity");
        this.e = new com.tapsdk.tapad.internal.q.h.b();
        this.f = cVar.a(a(a()));
    }

    public NetworkInfo a() {
        ConnectivityManager connectivityManager = this.g;
        if (connectivityManager != null) {
            return connectivityManager.getActiveNetworkInfo();
        }
        return null;
    }

    String a(NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.getTypeName() != null) {
            if (networkInfo.getTypeName().equals(i)) {
                return "WIFI_0";
            }
            if (networkInfo.getTypeName().equals(j)) {
                return "mobile_" + networkInfo.getSubtypeName();
            }
        }
        return "unknown";
    }

    public void a(int i2) {
        this.d = i2;
    }

    public void a(c cVar) {
        Set<c> set = this.b;
        if (set != null) {
            set.add(cVar);
        }
    }

    @Override // com.tapsdk.tapad.internal.q.c.b
    public void a(com.tapsdk.tapad.internal.q.e.a aVar) {
        if (com.tapsdk.tapad.internal.q.h.d.a) {
            Log.d("Response Received : ", aVar + " ");
        }
        for (c cVar : this.b) {
            if (cVar != null) {
                cVar.a(a(), aVar);
            }
        }
        synchronized (this) {
            int i2 = this.c + 1;
            this.c = i2;
            if (i2 >= this.d) {
                this.f = (float) ((((double) this.f) + this.e.b) / 2.0d);
                this.a.a(a(a()), this.f);
                this.c = 0;
            }
        }
        this.e.a(aVar);
    }

    @Override // com.tapsdk.tapad.internal.q.c.b
    public void a(com.tapsdk.tapad.internal.q.e.a aVar, IOException iOException) {
        if (com.tapsdk.tapad.internal.q.h.d.a) {
            Log.d("Response Http Error :", aVar + "");
        }
        for (c cVar : this.b) {
            if (cVar != null) {
                cVar.a(a(), aVar, iOException);
            }
        }
    }

    @Override // com.tapsdk.tapad.internal.q.c.b
    public void a(com.tapsdk.tapad.internal.q.e.a aVar, Exception exc) {
        if (com.tapsdk.tapad.internal.q.h.d.a) {
            Log.d("Response InputStream : ", aVar + "");
        }
        for (c cVar : this.b) {
            if (cVar != null) {
                cVar.a(a(), aVar, exc);
            }
        }
    }

    public float b() {
        return this.f;
    }

    public void b(c cVar) {
        Set<c> set = this.b;
        if (set != null) {
            set.remove(cVar);
        }
    }
}
