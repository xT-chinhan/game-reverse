package com.smartdigimkt.i0;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends Handler {
    public final /* synthetic */ k a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(k kVar, Looper looper) {
        super(looper);
        this.a = kVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        k kVar = this.a;
        kVar.getClass();
        int i = message.what;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException();
                }
                g gVar = (g) message.obj;
                Iterator it = kVar.g.iterator();
                while (it.hasNext()) {
                    ((c0) it.next()).a(gVar);
                }
                return;
            }
            a0 a0Var = (a0) message.obj;
            if (kVar.o.equals(a0Var)) {
                return;
            }
            kVar.o = a0Var;
            Iterator it2 = kVar.g.iterator();
            while (it2.hasNext()) {
                ((c0) it2.next()).b();
            }
            return;
        }
        z zVar = (z) message.obj;
        int i2 = message.arg1;
        int i3 = message.arg2;
        boolean z = i3 != -1;
        int i4 = kVar.l - i2;
        kVar.l = i4;
        if (i4 == 0) {
            z zVarA = zVar.f == -9223372036854775807L ? zVar.a(zVar.e, 0L, zVar.g) : zVar;
            if ((!kVar.p.c.c() || kVar.m) && zVarA.c.c()) {
                kVar.r = 0;
                kVar.q = 0;
                kVar.s = 0L;
            }
            int i5 = kVar.m ? 0 : 2;
            boolean z2 = kVar.n;
            kVar.m = false;
            kVar.n = false;
            kVar.a(zVarA, z, i3, i5, z2, false);
        }
    }
}
