package com.smartdigimkt.z0;

import android.os.SystemClock;
import com.smartdigimkt.i0.a0;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements h {
    public boolean b;
    public long c;
    public long d;
    public final c a = c.a;
    public a0 e = a0.e;

    public final void a(long j) {
        this.c = j;
        if (this.b) {
            ((p) this.a).getClass();
            this.d = SystemClock.elapsedRealtime();
        }
    }

    @Override // com.smartdigimkt.z0.h
    public final long b() {
        long j = this.c;
        if (!this.b) {
            return j;
        }
        ((p) this.a).getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.d;
        a0 a0Var = this.e;
        return j + (a0Var.a == 1.0f ? com.smartdigimkt.i0.b.a(jElapsedRealtime) : jElapsedRealtime * ((long) a0Var.d));
    }

    @Override // com.smartdigimkt.z0.h
    public final a0 a(a0 a0Var) {
        if (this.b) {
            a(b());
        }
        this.e = a0Var;
        return a0Var;
    }

    @Override // com.smartdigimkt.z0.h
    public final a0 a() {
        return this.e;
    }
}
