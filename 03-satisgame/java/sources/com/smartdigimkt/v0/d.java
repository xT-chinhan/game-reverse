package com.smartdigimkt.v0;

import com.bykv.vk.component.ttvideo.player.MediaFormat;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Runnable {
    public final /* synthetic */ i a;

    public d(i iVar) {
        this.a = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar = this.a;
        if (iVar.L || iVar.t || iVar.p == null || !iVar.s) {
            return;
        }
        for (e0 e0Var : iVar.q) {
            if (e0Var.c() == null) {
                return;
            }
        }
        com.smartdigimkt.z0.e eVar = iVar.k;
        synchronized (eVar) {
            eVar.a = false;
        }
        int length = iVar.q.length;
        i0[] i0VarArr = new i0[length];
        iVar.C = new boolean[length];
        iVar.B = new boolean[length];
        iVar.D = new boolean[length];
        iVar.A = iVar.p.b();
        int i = 0;
        while (true) {
            boolean z = true;
            if (i >= length) {
                break;
            }
            com.smartdigimkt.i0.s sVarC = iVar.q[i].c();
            i0VarArr[i] = new i0(sVarC);
            String str = sVarC.f;
            if (!MediaFormat.KEY_VIDEO.equals(com.smartdigimkt.z0.i.b(str)) && !MediaFormat.KEY_AUDIO.equals(com.smartdigimkt.z0.i.b(str))) {
                z = false;
            }
            iVar.C[i] = z;
            iVar.E = z | iVar.E;
            i++;
        }
        iVar.z = new k0(i0VarArr);
        if (iVar.c == -1 && iVar.F == -1 && iVar.p.b() == -9223372036854775807L) {
            iVar.u = 6;
        }
        iVar.t = true;
        j jVar = iVar.e;
        long j = iVar.A;
        boolean zA = iVar.p.a();
        if (j == -9223372036854775807L) {
            j = jVar.m;
        }
        if (jVar.m != j || jVar.n != zA) {
            jVar.m = j;
            jVar.n = zA;
            g0 g0Var = new g0(j, zA, jVar.l);
            jVar.d = g0Var;
            jVar.e = null;
            Iterator it = jVar.a.iterator();
            while (it.hasNext()) {
                ((com.smartdigimkt.i0.p) ((n) it.next())).f.a.obtainMessage(8, new com.smartdigimkt.i0.m(jVar, g0Var, null)).sendToTarget();
            }
        }
        iVar.o.b(iVar);
    }
}
