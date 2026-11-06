package com.anythink.core.common.h;

import android.os.Looper;
import android.util.Log;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.BaseAd;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public class c implements Comparable<c> {
    private int b;
    private long c;
    private ATBaseAdAdapter d;
    private BaseAd e;
    private int f;
    private long g;
    private int h;
    private long i;
    private boolean j;
    private String a = getClass().getSimpleName();
    private String k = "1";

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(c cVar) {
        c cVar2 = cVar;
        bv unitGroupInfo = this.d.getUnitGroupInfo();
        bv unitGroupInfo2 = cVar2.d.getUnitGroupInfo();
        int iB = com.anythink.core.common.v.l.b(unitGroupInfo, unitGroupInfo2);
        if (iB < 0) {
            return -1;
        }
        if (iB > 0) {
            return 1;
        }
        if (unitGroupInfo.m < unitGroupInfo2.m) {
            return -1;
        }
        if (unitGroupInfo.m != unitGroupInfo2.m) {
            return 1;
        }
        if (b() < cVar2.b()) {
            return -1;
        }
        return b() != cVar2.b() ? 1 : 0;
    }

    public final boolean a() {
        return this.h == 1 && System.currentTimeMillis() - this.c < this.i;
    }

    public final long b() {
        return this.c + this.i;
    }

    public final void a(long j) {
        this.i = j;
    }

    private long q() {
        return this.g;
    }

    public final void b(long j) {
        this.g = j;
    }

    public final int c() {
        return this.f;
    }

    public final void a(int i) {
        bv unitGroupInfo;
        ad adVarR;
        this.f = i;
        if (i > 0) {
            this.h = 0;
            ATBaseAdAdapter aTBaseAdAdapter = this.d;
            if (aTBaseAdAdapter == null || (unitGroupInfo = aTBaseAdAdapter.getUnitGroupInfo()) == null || (adVarR = unitGroupInfo.R()) == null) {
                return;
            }
            String str = adVarR.token;
            adVarR.q();
        }
    }

    public final long d() {
        return this.c;
    }

    public final void c(long j) {
        this.h = 1;
        this.c = j;
    }

    public final ATBaseAdAdapter e() {
        return this.d;
    }

    public final void a(ATBaseAdAdapter aTBaseAdAdapter) {
        this.d = aTBaseAdAdapter;
    }

    public final BaseAd f() {
        return this.e;
    }

    public final void a(BaseAd baseAd) {
        this.e = baseAd;
        ATBaseAdAdapter aTBaseAdAdapter = this.d;
        if ((!(aTBaseAdAdapter != null) || !(aTBaseAdAdapter.getUnitGroupInfo() != null)) || this.d.getUnitGroupInfo().aX() != null) {
            return;
        }
        this.d.getUnitGroupInfo().a(baseAd);
    }

    public final boolean g() {
        BaseAd baseAd;
        try {
            if (this.j || this.f > 0) {
                return false;
            }
            if (this.d != null && (baseAd = this.e) != null && baseAd.isValid()) {
                return true;
            }
            try {
                if (Looper.myLooper() == null) {
                    Looper.prepare();
                }
            } catch (Throwable unused) {
            }
            ATBaseAdAdapter aTBaseAdAdapter = this.d;
            if (aTBaseAdAdapter != null) {
                return aTBaseAdAdapter.internalIsAdReady();
            }
        } catch (Exception e) {
            Log.e("AdCacheInfo", "isNetworkAdReady()  >>> " + e.getMessage());
        }
        return false;
    }

    public final boolean h() {
        return this.j;
    }

    public final n i() {
        BaseAd baseAd = this.e;
        return baseAd != null ? baseAd.getDetail() : this.d.getTrackingInfo();
    }

    public final boolean j() {
        return this.c + this.g > System.currentTimeMillis();
    }

    public final boolean k() {
        return j() && g();
    }

    public final void a(String str) {
        this.k = str;
    }

    public final String l() {
        return this.k;
    }

    public final synchronized void m() {
        if (this.j) {
            return;
        }
        this.j = true;
        if (this.f <= 0) {
            com.anythink.core.common.d.t.b().b(new Runnable() { // from class: com.anythink.core.common.h.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        if (c.this.f <= 0) {
                            if (c.this.d != null) {
                                c.this.d.internalDestory();
                            }
                            if (c.this.e != null) {
                                c.this.e.destroy();
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    public final double n() {
        return com.anythink.core.common.v.p.a(this.d.getUnitGroupInfo());
    }

    public final bv o() {
        return this.d.getUnitGroupInfo();
    }

    public String toString() {
        return "AdCacheInfo{UnitGroupInfo:" + this.d.getUnitGroupInfo().toString() + ", showTime=" + this.f + ", cacheTime=" + this.g + ", upStatus=" + this.h + ", upStatusOutDateTime=" + (this.c + this.i) + ", hasDestroy=" + this.j + AbstractJsonLexerKt.END_OBJ;
    }

    private int d(c cVar) {
        bv unitGroupInfo = this.d.getUnitGroupInfo();
        bv unitGroupInfo2 = cVar.d.getUnitGroupInfo();
        int iB = com.anythink.core.common.v.l.b(unitGroupInfo, unitGroupInfo2);
        if (iB < 0) {
            return -1;
        }
        if (iB > 0) {
            return 1;
        }
        if (unitGroupInfo.m < unitGroupInfo2.m) {
            return -1;
        }
        if (unitGroupInfo.m != unitGroupInfo2.m) {
            return 1;
        }
        if (b() < cVar.b()) {
            return -1;
        }
        return b() != cVar.b() ? 1 : 0;
    }

    public final ATAdInfo p() {
        BaseAd baseAd = this.e;
        ATBaseAdAdapter aTBaseAdAdapter = this.d;
        if (baseAd != null) {
            return com.anythink.core.common.d.l.a(baseAd, aTBaseAdAdapter, 4);
        }
        if (aTBaseAdAdapter != null) {
            return com.anythink.core.common.d.l.a(aTBaseAdAdapter, 4);
        }
        return null;
    }
}
