package com.anythink.core.common.h;

import android.os.SystemClock;
import com.anythink.core.basead.adx.api.ATAdxSetting;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public final class cb {
    private final String a = getClass().getSimpleName();
    private com.anythink.core.d.l b;
    private ar c;
    private boolean d;
    private long e;
    private boolean f;
    private int g;
    private int h;
    private int i;
    private long j;
    private int k;
    private long l;

    public cb(ar arVar, com.anythink.core.d.l lVar) {
        int i = arVar.c;
        this.c = arVar;
        this.b = lVar;
        boolean z = false;
        this.d = (ATAdxSetting.getInstance().isAdxNetworkMode(lVar.i()) || lVar.F() != 1 || i == 8 || i == 16) ? false : true;
        this.e = lVar.r();
        if (lVar.p() != 1 && lVar.F() == 1) {
            z = true;
        }
        this.f = z;
        this.g = i == 9 ? lVar.n() : lVar.G();
        this.h = i == 9 ? lVar.o() : lVar.au();
        this.i = lVar.c();
        this.j = lVar.a();
        this.k = lVar.b();
        this.l = -1L;
        toString();
    }

    public final com.anythink.core.d.l a() {
        return this.b;
    }

    public final boolean b() {
        return this.d;
    }

    public final long c() {
        return this.e;
    }

    public final boolean d() {
        return this.f;
    }

    public final int e() {
        return this.g;
    }

    public final int f() {
        return this.h;
    }

    public final int g() {
        return this.b.aG();
    }

    private long q() {
        return this.b.K();
    }

    public final long h() {
        return this.b.al();
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
        return this.b.I();
    }

    public final int j() {
        return this.b.y();
    }

    public final long k() {
        return this.b.ab();
    }

    public final long l() {
        return this.b.V();
    }

    public final long m() {
        return this.b.am();
    }

    public final long n() {
        return this.b.P();
    }

    public final boolean o() {
        com.anythink.core.d.l lVar = this.b;
        return lVar != null && lVar.bb() == 1;
    }

    public final String toString() {
        return "WaterfallSetting{canLoadFailRetry=" + this.d + ", loadFailRetryDelayTime=" + this.e + ", cannBiddingFailRetry=" + this.f + ", requestType=" + this.g + ", requestNum=" + this.h + ", cacheNum:" + this.b.aG() + AbstractJsonLexerKt.END_OBJ;
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
