package com.smartdigimkt.v0;

import android.net.Uri;
import com.smartdigimkt.i0.m0;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class j {
    public com.smartdigimkt.i0.h c;
    public m0 d;
    public Object e;
    public final Uri f;
    public final com.smartdigimkt.y0.h g;
    public final com.smartdigimkt.n0.g h;
    public boolean n;
    public final ArrayList a = new ArrayList(1);
    public final x b = new x(new CopyOnWriteArrayList(), null);
    public final int i = -1;
    public final String j = null;
    public final int k = 1048576;
    public long m = -9223372036854775807L;
    public final Object l = null;

    public j(Uri uri, com.smartdigimkt.y0.h hVar, com.smartdigimkt.n0.g gVar) {
        this.f = uri;
        this.g = hVar;
        this.h = gVar;
    }

    public final void a(com.smartdigimkt.j0.c cVar) {
        x xVar = this.b;
        for (w wVar : xVar.c) {
            if (wVar.b == cVar) {
                xVar.c.remove(wVar);
            }
        }
    }

    public final void a(l lVar) {
        long jA;
        i iVar = (i) lVar;
        if (iVar.t) {
            for (e0 e0Var : iVar.q) {
                b0 b0Var = e0Var.c;
                synchronized (b0Var) {
                    int i = b0Var.i;
                    if (i == 0) {
                        jA = -1;
                    } else {
                        jA = b0Var.a(i);
                    }
                }
                e0Var.a(jA);
            }
        }
        com.smartdigimkt.y0.a0 a0Var = iVar.i;
        com.smartdigimkt.y0.w wVar = a0Var.b;
        if (wVar != null) {
            wVar.a(true);
        }
        a0Var.a.execute(new com.smartdigimkt.y0.y(iVar));
        a0Var.a.shutdown();
        iVar.n.removeCallbacksAndMessages(null);
        iVar.o = null;
        iVar.L = true;
        x xVar = iVar.d;
        if (xVar.b != null) {
            for (w wVar2 : xVar.c) {
                x.a(wVar2.a, new p(xVar, wVar2.b));
            }
            return;
        }
        throw new IllegalStateException();
    }
}
