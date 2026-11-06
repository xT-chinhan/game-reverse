package com.smartdigimkt.b2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends f {
    public boolean i = false;
    public com.smartdigimkt.y1.o j;

    @Override // com.smartdigimkt.b2.f
    public final void a(Context context, com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar, ViewGroup viewGroup, RelativeLayout relativeLayout, View view, int i, e eVar) {
        super.a(context, cVar, aVar, viewGroup, relativeLayout, view, i, eVar);
        this.j = new com.smartdigimkt.y1.o(context, cVar, aVar, i, relativeLayout, view, eVar);
    }

    @Override // com.smartdigimkt.b2.f
    public final void a(int i, HashMap map) {
        com.smartdigimkt.y1.o oVar;
        int i2;
        com.smartdigimkt.y1.e0 e0Var;
        int i3;
        com.smartdigimkt.y1.o oVar2;
        if (i == 107 || i == 108) {
            if (this.e != 1 || (oVar = this.j) == null) {
                return;
            }
            com.smartdigimkt.y1.e0 e0Var2 = oVar.h;
            if (e0Var2 != null) {
                e0Var2.a();
            }
            oVar.a();
            ConcurrentLinkedQueue concurrentLinkedQueue = oVar.g;
            if (concurrentLinkedQueue != null) {
                concurrentLinkedQueue.clear();
            }
            this.j = null;
            return;
        }
        if (i == 110) {
            com.smartdigimkt.y1.o oVar3 = this.j;
            if (oVar3 != null) {
                if (this.i || (i2 = this.e) == 1 || i2 == 2) {
                    oVar3.b();
                    return;
                }
                return;
            }
            return;
        }
        if (i == 111) {
            com.smartdigimkt.y1.o oVar4 = this.j;
            if (oVar4 != null) {
                if ((this.i || (i3 = this.e) == 1 || i3 == 2) && (e0Var = oVar4.h) != null) {
                    e0Var.a();
                    return;
                }
                return;
            }
            return;
        }
        if (i == 113) {
            com.smartdigimkt.y1.o oVar5 = this.j;
            if (oVar5 != null) {
                com.smartdigimkt.y1.e0 e0Var3 = oVar5.h;
                if (e0Var3 != null) {
                    e0Var3.a();
                }
                oVar5.a();
                ConcurrentLinkedQueue concurrentLinkedQueue2 = oVar5.g;
                if (concurrentLinkedQueue2 != null) {
                    concurrentLinkedQueue2.clear();
                }
                this.j = null;
                return;
            }
            return;
        }
        if (i == 114) {
            this.i = true;
            com.smartdigimkt.y1.o oVar6 = this.j;
            if (oVar6 != null) {
                oVar6.j = map;
                oVar6.b();
                return;
            }
            return;
        }
        if (i == 119 && (oVar2 = this.j) != null) {
            com.smartdigimkt.y1.e0 e0Var4 = oVar2.h;
            if (e0Var4 != null) {
                e0Var4.a();
            }
            oVar2.a();
            ConcurrentLinkedQueue concurrentLinkedQueue3 = oVar2.g;
            if (concurrentLinkedQueue3 != null) {
                concurrentLinkedQueue3.clear();
            }
            this.j = null;
        }
    }
}
