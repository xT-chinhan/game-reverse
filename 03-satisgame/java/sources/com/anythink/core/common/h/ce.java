package com.anythink.core.common.h;

import android.os.SystemClock;
import com.anythink.core.basead.adx.api.ATAdxSetting;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public final class ce {
    private final String a = getClass().getSimpleName();
    private com.anythink.core.e.l b;
    private as c;
    private boolean d;
    private long e;
    private boolean f;
    private int g;
    private int h;
    private int i;
    private long j;
    private int k;
    private long l;

    public ce(as asVar, com.anythink.core.e.l lVar) {
        int i = asVar.c;
        this.c = asVar;
        this.b = lVar;
        boolean z = false;
        this.d = (ATAdxSetting.getInstance().isAdxNetworkMode(lVar.i()) || lVar.G() != 1 || i == 8 || i == 16) ? false : true;
        this.e = lVar.s();
        if (lVar.q() != 1 && lVar.G() == 1) {
            z = true;
        }
        this.f = z;
        this.g = i == 9 ? lVar.o() : lVar.H();
        this.h = i == 9 ? lVar.p() : lVar.at();
        this.i = lVar.c();
        this.j = lVar.a();
        this.k = lVar.b();
        this.l = -1L;
    }

    public final com.anythink.core.e.l a() {
        return this.b;
    }

    public final boolean b() {
        return com.anythink.core.common.b.e.c(this.b, this.d);
    }

    public final long c() {
        return this.e;
    }

    public final boolean d() {
        return com.anythink.core.common.b.e.c(this.b, this.f);
    }

    public final int e() {
        return this.g;
    }

    public final int f() {
        return com.anythink.core.common.b.e.a(this.b, this.h);
    }

    public final int g() {
        return this.b.aF();
    }

    private long q() {
        return this.b.L();
    }

    public final long h() {
        return this.b.ak();
    }

    public final long i() {
        if (this.c.j) {
            long j = this.l;
            if (j >= 0) {
                return j;
            }
            long jElapsedRealtime = (((long) this.c.h) - (SystemClock.elapsedRealtime() - this.c.k)) - 100;
            this.l = jElapsedRealtime;
            if (jElapsedRealtime < 0) {
                this.l = 0L;
            }
            return this.l;
        }
        return this.b.J();
    }

    public final int j() {
        return this.b.z();
    }

    public final long k() {
        return this.b.aa();
    }

    public final long l() {
        return this.b.W();
    }

    public final long m() {
        return this.b.al();
    }

    public final long n() {
        return this.b.Q();
    }

    public final boolean o() {
        com.anythink.core.e.l lVar = this.b;
        return lVar != null && lVar.aW() == 1;
    }

    public final String toString() {
        return "WaterfallSetting{canLoadFailRetry=" + this.d + ", loadFailRetryDelayTime=" + this.e + ", cannBiddingFailRetry=" + this.f + ", requestType=" + this.g + ", requestNum=" + this.h + ", cacheNum:" + this.b.aF() + AbstractJsonLexerKt.END_OBJ;
    }

    public final int p() {
        return this.i;
    }

    private long r() {
        return this.j;
    }

    private long s() {
        return this.k;
    }
}
