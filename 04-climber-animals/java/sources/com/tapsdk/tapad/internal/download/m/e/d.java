package com.tapsdk.tapad.internal.download.m.e;

import com.tapsdk.tapad.internal.download.core.cause.ResumeFailedCause;
import com.tapsdk.tapad.internal.download.m.f.i;
import java.io.IOException;
import java.net.SocketException;

/* JADX INFO: loaded from: classes3.dex */
public class d {
    private String a;
    private final com.tapsdk.tapad.internal.download.m.g.d b;
    private volatile boolean c;
    private volatile boolean d;
    private volatile boolean e;
    private volatile boolean f;
    private volatile boolean g;
    private volatile boolean h;
    private volatile IOException i;

    static class a extends d {
        a(IOException iOException) {
            super(null);
            e(iOException);
        }
    }

    private d() {
        this.b = null;
    }

    d(com.tapsdk.tapad.internal.download.m.g.d dVar) {
        this.b = dVar;
    }

    com.tapsdk.tapad.internal.download.m.g.d a() {
        com.tapsdk.tapad.internal.download.m.g.d dVar = this.b;
        if (dVar != null) {
            return dVar;
        }
        throw new IllegalArgumentException();
    }

    public void a(IOException iOException) {
        if (k()) {
            return;
        }
        if (iOException instanceof com.tapsdk.tapad.internal.download.m.f.f) {
            c(iOException);
            return;
        }
        if (iOException instanceof i) {
            d(iOException);
            return;
        }
        if (iOException == com.tapsdk.tapad.internal.download.m.f.b.a) {
            l();
            return;
        }
        if (iOException instanceof com.tapsdk.tapad.internal.download.m.f.e) {
            b(iOException);
        } else if (iOException != com.tapsdk.tapad.internal.download.m.f.c.a) {
            e(iOException);
            if (iOException instanceof SocketException) {
                return;
            }
            com.tapsdk.tapad.internal.download.m.c.a("DownloadCache", "catch unknown error " + iOException);
        }
    }

    void a(String str) {
        this.a = str;
    }

    IOException b() {
        return this.i;
    }

    public void b(IOException iOException) {
        this.h = true;
        this.i = iOException;
    }

    String c() {
        return this.a;
    }

    public void c(IOException iOException) {
        this.c = true;
        this.i = iOException;
    }

    ResumeFailedCause d() {
        return ((com.tapsdk.tapad.internal.download.m.f.f) this.i).a();
    }

    public void d(IOException iOException) {
        this.e = true;
        this.i = iOException;
    }

    public void e(IOException iOException) {
        this.f = true;
        this.i = iOException;
    }

    boolean e() {
        return this.g;
    }

    public boolean f() {
        return this.c || this.d || this.e || this.f || this.g || this.h;
    }

    public boolean g() {
        return this.h;
    }

    boolean h() {
        return this.c;
    }

    boolean i() {
        return this.e;
    }

    boolean j() {
        return this.f;
    }

    public boolean k() {
        return this.d;
    }

    public void l() {
        this.g = true;
    }

    void m() {
        this.d = true;
    }
}
