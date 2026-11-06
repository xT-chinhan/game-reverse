package com.smartdigimkt.a0;

import android.content.Context;
import android.text.TextUtils;
import com.smartdigimkt.z.c0;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends b {
    public com.smartdigimkt.p3.i h;
    public long i;
    public WeakReference j;
    public g k;

    public k(a aVar) {
        super(aVar);
        this.i = 0L;
    }

    /* JADX WARN: Code duplicated, block: B:57:0x00d4  */
    public final s b() {
        boolean z;
        boolean z2;
        s sVarA;
        r rVar;
        r rVar2 = this.e;
        if (rVar2 == null) {
            return new s(false);
        }
        com.smartdigimkt.h0.m mVar = rVar2.b;
        if (mVar == null) {
            return new s(false);
        }
        mVar.i = new com.smartdigimkt.h0.b();
        com.smartdigimkt.h0.f fVarA = a();
        mVar.i.a = fVarA != null ? fVarA.b : "";
        com.smartdigimkt.z.s.a(23, this.c, mVar);
        Context context = this.b;
        String str = this.c.m;
        if (context == null || TextUtils.isEmpty(str)) {
            z = false;
        } else {
            try {
                context.getPackageManager().getApplicationInfo(str, 8192);
                z = true;
            } catch (Throwable unused) {
                z = false;
            }
        }
        if (TextUtils.isEmpty(this.c.m) || this.c.o != 1) {
            z2 = false;
        } else {
            s sVarA2 = a(mVar);
            if (sVarA2 != null) {
                return sVarA2;
            }
            z2 = true;
        }
        if (!z2 && z && (TextUtils.isEmpty(this.c.k) || com.smartdigimkt.z.k.a(this.c.k))) {
            s sVarA3 = a(mVar);
            if (sVarA3 != null) {
                return sVarA3;
            }
            z2 = true;
        }
        if (!TextUtils.isEmpty(this.c.k)) {
            String str2 = this.c.k;
            String str3 = this.d.g;
            String strReplaceAll = str2.replaceAll("\\{req_id\\}", str3 != null ? str3 : "");
            com.smartdigimkt.s2.a.a().getClass();
            com.smartdigimkt.z.j jVarA = com.smartdigimkt.c0.h.a(this.b, this.d, this.c, strReplaceAll);
            int i = jVarA.a;
            boolean z3 = i == 5;
            if (i == 0) {
                mVar.i.b = 1;
            } else if (i == 1) {
                mVar.i.b = 2;
            } else if (i != 5) {
                mVar.i.b = 3;
            } else {
                mVar.i.b = 1;
            }
            if (i == 0 || z3) {
                com.smartdigimkt.b3.c cVar = this.c;
                if (cVar.o == 1 || z3) {
                    com.smartdigimkt.z.s.a(this.b, cVar);
                }
                com.smartdigimkt.b3.e eVar = this.c.w;
                boolean z4 = eVar == null || eVar.F1 != 1;
                r rVar3 = this.e;
                if (rVar3 != null) {
                    rVar3.a();
                }
                com.smartdigimkt.q3.f.a().a(new l(new m(this.c, this.d, strReplaceAll, mVar, this.e)), 1000L, 2);
                com.smartdigimkt.n3.k.a(this.d, this.c, strReplaceAll, "1", 0, 0, jVarA.b);
                e eVar2 = this.f;
                if (eVar2 != null) {
                    eVar2.b();
                    this.f.a();
                    this.f.a(true);
                    this.f.c();
                }
                com.smartdigimkt.x.j.a().j = new h(this);
                if (z4 && (rVar = this.e) != null) {
                    rVar.b();
                }
                if (c0.j(this.c, this.d) != 1 && !z3) {
                    com.smartdigimkt.b3.c cVar2 = this.c;
                    String str4 = cVar2.l;
                    int i2 = cVar2.o;
                    this.i = System.currentTimeMillis();
                    com.smartdigimkt.x.j jVarA2 = com.smartdigimkt.x.j.a();
                    jVarA2.k = new j(this, str4, strReplaceAll, i2);
                    jVarA2.l = false;
                }
                return new s(true);
            }
            com.smartdigimkt.s2.a.a().getClass();
            if (i == 1) {
                com.smartdigimkt.z.s.a(29, this.c, mVar);
            } else {
                com.smartdigimkt.z.s.a(28, this.c, mVar);
            }
            com.smartdigimkt.n3.k.a(this.d, this.c, strReplaceAll, "0", 0, i, jVarA.b);
        }
        return (!z || z2 || (sVarA = a(mVar)) == null) ? new s(false) : sVarA;
    }
}
