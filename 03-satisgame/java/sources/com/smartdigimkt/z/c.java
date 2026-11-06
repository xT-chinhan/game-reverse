package com.smartdigimkt.z;

import com.smartdigimkt.sdk.basead.ui.BaseATActivity;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Runnable {
    public final /* synthetic */ String a = "1";
    public final /* synthetic */ Object b;
    public final /* synthetic */ d c;

    public c(d dVar, com.smartdigimkt.h0.j jVar) {
        this.c = dVar;
        this.b = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.smartdigimkt.b3.c cVar;
        synchronized (this.c) {
            List<com.smartdigimkt.n1.b0> list = (List) this.c.a.get(this.a);
            if (list == null) {
                return;
            }
            for (com.smartdigimkt.n1.b0 b0Var : list) {
                if (b0Var != null) {
                    Object obj = this.b;
                    if ((obj instanceof com.smartdigimkt.h0.j) && (cVar = b0Var.a.d) != null) {
                        com.smartdigimkt.h0.j jVar = (com.smartdigimkt.h0.j) obj;
                        if (jVar.a.m.equals(cVar.m)) {
                            BaseATActivity baseATActivity = b0Var.a;
                            if (baseATActivity.o) {
                                jVar.a(baseATActivity);
                            } else {
                                baseATActivity.p = jVar;
                            }
                        }
                    }
                }
            }
        }
    }
}
