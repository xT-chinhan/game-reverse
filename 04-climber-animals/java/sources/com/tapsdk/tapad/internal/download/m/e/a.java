package com.tapsdk.tapad.internal.download.m.e;

import android.net.Uri;
import com.tapsdk.tapad.internal.download.core.cause.ResumeFailedCause;
import com.tapsdk.tapad.internal.download.i;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    private boolean a;
    boolean b;
    boolean c;
    boolean d;
    private final com.tapsdk.tapad.internal.download.f e;
    private final com.tapsdk.tapad.internal.download.core.breakpoint.c f;
    private final long g;

    public a(com.tapsdk.tapad.internal.download.f fVar, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar, long j) {
        this.e = fVar;
        this.f = cVar;
        this.g = j;
    }

    public void a() {
        this.b = d();
        this.c = e();
        boolean zF = f();
        this.d = zF;
        this.a = (this.c && this.b && zF) ? false : true;
    }

    public ResumeFailedCause b() {
        if (!this.c) {
            return ResumeFailedCause.INFO_DIRTY;
        }
        if (!this.b) {
            return ResumeFailedCause.FILE_NOT_EXIST;
        }
        if (this.d) {
            throw new IllegalStateException("No cause find with dirty: " + this.a);
        }
        return ResumeFailedCause.OUTPUT_STREAM_NOT_SUPPORT;
    }

    public boolean c() {
        return this.a;
    }

    public boolean d() {
        Uri uriX = this.e.x();
        if (com.tapsdk.tapad.internal.download.m.c.c(uriX)) {
            return com.tapsdk.tapad.internal.download.m.c.b(uriX) > 0;
        }
        File fileH = this.e.h();
        return fileH != null && fileH.exists();
    }

    public boolean e() {
        int iB = this.f.b();
        if (iB <= 0 || this.f.k() || this.f.d() == null) {
            return false;
        }
        if (!this.f.d().equals(this.e.h()) || this.f.d().length() > this.f.h()) {
            return false;
        }
        if (this.g > 0 && this.f.h() != this.g) {
            return false;
        }
        for (int i = 0; i < iB; i++) {
            if (this.f.b(i).b() <= 0) {
                return false;
            }
        }
        return true;
    }

    public boolean f() {
        if (i.j().h().a()) {
            return true;
        }
        return this.f.b() == 1 && !i.j().i().b(this.e);
    }

    public String toString() {
        return "fileExist[" + this.b + "] infoRight[" + this.c + "] outputStreamSupport[" + this.d + "] " + super.toString();
    }
}
