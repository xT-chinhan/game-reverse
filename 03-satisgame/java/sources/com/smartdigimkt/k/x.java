package com.smartdigimkt.k;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes3.dex */
public final class x extends Handler {
    public final /* synthetic */ y a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(y yVar, Looper looper) {
        super(looper);
        this.a = yVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message.what == 100) {
            long j = 0;
            for (int i = 0; i < this.a.h.size(); i++) {
                try {
                    j += (long) this.a.h.get(i);
                } catch (Throwable th) {
                    th.getMessage();
                    return;
                }
            }
            z zVar = this.a.k;
            c0 c0Var = zVar.j;
            if (c0Var != null) {
                long j2 = zVar.f;
                d0 d0Var = c0Var.a;
                r rVar = d0Var.a;
                if (rVar != null) {
                    rVar.g = j;
                }
                a aVar = d0Var.d;
                if (aVar != null) {
                    aVar.a(rVar, j, j2);
                }
            }
            y yVar = this.a;
            x xVar = yVar.j;
            if (xVar == null || j > yVar.k.f) {
                return;
            }
            this.a.j.sendMessageDelayed(xVar.obtainMessage(100), 500L);
        }
    }
}
