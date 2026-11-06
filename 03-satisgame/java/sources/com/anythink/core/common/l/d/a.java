package com.anythink.core.common.l.d;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.u.ad;

/* JADX INFO: loaded from: classes.dex */
public final class a extends d {
    public a(Context context) {
        super(context);
    }

    @Override // com.anythink.core.common.l.d.d, com.anythink.core.common.l.d.i
    public final com.anythink.core.common.l.c.f a(com.anythink.core.common.l.c.d dVar) {
        if (!b(dVar)) {
            return null;
        }
        com.anythink.core.common.l.c.f fVarA = super.a(dVar);
        if (fVarA != null && fVarA.e()) {
            fVarA.b(com.anythink.core.common.l.b.d);
        }
        return fVarA;
    }

    @Override // com.anythink.core.common.l.d.i
    public final void a(com.anythink.core.common.l.c.f fVar, com.anythink.core.common.l.c.d dVar) {
        if (!b(dVar) || fVar == null) {
            return;
        }
        int iC = fVar.c();
        String strB = fVar.b();
        long jD = fVar.d();
        if (iC != 699 || jD <= 0) {
            return;
        }
        synchronized (this.d) {
            if (this.c != null) {
                this.c.put(strB, Long.valueOf(jD));
            }
            ad.a(this.b, "anythink_app_pl_cl_retry", strB, jD);
        }
    }

    @Override // com.anythink.core.common.l.d.d
    protected final boolean b(com.anythink.core.common.l.c.d dVar) {
        if (this.b != null && dVar != null) {
            String strB = dVar.b();
            String strA = dVar.a();
            if (("app_strategy".equals(strB) || "placement_strategy".equals(strB) || "get_plugin".equals(strB)) && !TextUtils.isEmpty(strA)) {
                return true;
            }
        }
        return false;
    }

    private void a(String str, long j) {
        if (this.c != null) {
            this.c.put(str, Long.valueOf(j));
        }
        ad.a(this.b, "anythink_app_pl_cl_retry", str, j);
    }
}
