package com.smartdigimkt.x0;

import com.smartdigimkt.i0.f0;
import com.smartdigimkt.z0.u;

/* JADX INFO: loaded from: classes3.dex */
public final class m {
    public final int a;
    public final f0[] b;
    public final k c;
    public final Object d;

    public m(f0[] f0VarArr, h[] hVarArr, i iVar) {
        this.b = f0VarArr;
        this.c = new k(hVarArr);
        this.d = iVar;
        this.a = f0VarArr.length;
    }

    public final boolean a(int i) {
        return this.b[i] != null;
    }

    public final boolean a(m mVar, int i) {
        return mVar != null && u.a(this.b[i], mVar.b[i]) && u.a(this.c.b[i], mVar.c.b[i]);
    }
}
