package com.smartdigimkt.j0;

import com.smartdigimkt.i0.k0;
import com.smartdigimkt.i0.m0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public b c;
    public b d;
    public boolean f;
    public final ArrayList a = new ArrayList();
    public final k0 b = new k0();
    public m0 e = m0.a;

    public final b a(b bVar, m0 m0Var) {
        int iA;
        return (m0Var.c() || this.e.c() || (iA = m0Var.a(this.e.a(bVar.b.a, this.b, true).a)) == -1) ? bVar : new b(m0Var.a(iA, this.b, false).b, bVar.b.a(iA));
    }
}
