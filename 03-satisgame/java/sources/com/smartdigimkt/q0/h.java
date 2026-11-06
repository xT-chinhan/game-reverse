package com.smartdigimkt.q0;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.smartdigimkt.i0.h0;
import com.smartdigimkt.i0.s;
import com.smartdigimkt.i0.t;
import com.smartdigimkt.s0.n;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends com.smartdigimkt.i0.a implements Handler.Callback {
    public final e i;
    public final g j;
    public final Handler k;
    public final t l;
    public final f m;
    public final c[] n;
    public final long[] o;
    public int p;
    public int q;
    public d r;
    public boolean s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(h0 h0Var, Looper looper) {
        super(4);
        e eVar = e.a;
        this.j = h0Var;
        this.k = looper == null ? null : new Handler(looper, this);
        this.i = eVar;
        this.l = new t();
        this.m = new f();
        this.n = new c[5];
        this.o = new long[5];
    }

    @Override // com.smartdigimkt.i0.a
    public final int a(s sVar) {
        this.i.getClass();
        String str = sVar.f;
        if ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str)) {
            return sVar.i == null ? 4 : 2;
        }
        return 0;
    }

    @Override // com.smartdigimkt.i0.a
    public final boolean d() {
        return this.s;
    }

    @Override // com.smartdigimkt.i0.a
    public final boolean e() {
        return true;
    }

    @Override // com.smartdigimkt.i0.a
    public final void f() {
        Arrays.fill(this.n, (Object) null);
        this.p = 0;
        this.q = 0;
        this.r = null;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        this.j.a((c) message.obj);
        return true;
    }

    @Override // com.smartdigimkt.i0.a
    public final void a(s[] sVarArr, long j) {
        d nVar;
        e eVar = this.i;
        byte b = 0;
        s sVar = sVarArr[0];
        eVar.getClass();
        String str = sVar.f;
        str.getClass();
        str.hashCode();
        switch (str.hashCode()) {
            case -1248341703:
                if (!str.equals("application/id3")) {
                    b = -1;
                }
                break;
            case 1154383568:
                b = !str.equals("application/x-emsg") ? (byte) -1 : (byte) 1;
                break;
            case 1652648887:
                b = !str.equals("application/x-scte35") ? (byte) -1 : (byte) 2;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                nVar = new n();
                break;
            case 1:
                nVar = new com.smartdigimkt.r0.c();
                break;
            case 2:
                nVar = new com.smartdigimkt.t0.d();
                break;
            default:
                throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
        }
        this.r = nVar;
    }

    @Override // com.smartdigimkt.i0.a
    public final void a(long j, long j2) {
        if (!this.s && this.q < 5) {
            this.m.a();
            if (a(this.l, this.m, false) == -4) {
                if (this.m.b(4)) {
                    this.s = true;
                } else if (!this.m.b(Integer.MIN_VALUE)) {
                    f fVar = this.m;
                    fVar.f = this.l.a.j;
                    fVar.b.flip();
                    int i = (this.p + this.q) % 5;
                    this.n[i] = this.r.a(this.m);
                    this.o[i] = this.m.c;
                    this.q++;
                }
            }
        }
        if (this.q > 0) {
            long[] jArr = this.o;
            int i2 = this.p;
            if (jArr[i2] <= j) {
                c cVar = this.n[i2];
                Handler handler = this.k;
                if (handler != null) {
                    handler.obtainMessage(0, cVar).sendToTarget();
                } else {
                    this.j.a(cVar);
                }
                c[] cVarArr = this.n;
                int i3 = this.p;
                cVarArr[i3] = null;
                this.p = (i3 + 1) % 5;
                this.q--;
            }
        }
    }

    @Override // com.smartdigimkt.i0.a
    public final void a(long j, boolean z) {
        Arrays.fill(this.n, (Object) null);
        this.p = 0;
        this.q = 0;
        this.s = false;
    }
}
