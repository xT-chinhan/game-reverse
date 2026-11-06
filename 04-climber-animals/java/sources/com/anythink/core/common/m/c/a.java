package com.anythink.core.common.m.c;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.v.af;

/* JADX INFO: loaded from: classes.dex */
public class a extends d {
    public a(Context context) {
        super(context);
    }

    @Override // com.anythink.core.common.m.c.d, com.anythink.core.common.m.c.i
    public final com.anythink.core.common.m.b.f a(com.anythink.core.common.m.b.d dVar) {
        if (!b(dVar)) {
            return null;
        }
        com.anythink.core.common.m.b.f fVarA = super.a(dVar);
        if (fVarA != null && fVarA.e()) {
            fVarA.b(com.anythink.core.common.m.a.m);
        }
        return fVarA;
    }

    @Override // com.anythink.core.common.m.c.i
    public final void a(com.anythink.core.common.m.b.f fVar, com.anythink.core.common.m.b.d dVar) {
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
            Object[] objArr = new Object[2];
            Long.valueOf(jD);
            if (this.c != null) {
                this.c.put(strB, Long.valueOf(jD));
            }
            af.a(this.b, "anythink_app_pl_cl_retry", strB, jD);
        }
    }

    @Override // com.anythink.core.common.m.c.d
    protected final boolean b(com.anythink.core.common.m.b.d dVar) {
        if (this.b != null && dVar != null) {
            String strB = dVar.b();
            String strA = dVar.a();
            if ((com.anythink.core.common.m.b.g.b.equals(strB) || com.anythink.core.common.m.b.g.a.equals(strB) || com.anythink.core.common.m.b.g.e.equals(strB)) && !TextUtils.isEmpty(strA)) {
                return true;
            }
        }
        return false;
    }

    private void a(String str, long j) {
        Object[] objArr = new Object[2];
        Long.valueOf(j);
        if (this.c != null) {
            this.c.put(str, Long.valueOf(j));
        }
        af.a(this.b, "anythink_app_pl_cl_retry", str, j);
    }
}
