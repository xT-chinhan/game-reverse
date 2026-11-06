package com.smartdigimkt.x1;

import android.view.View;
import com.smartdigimkt.n1.c1;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements View.OnClickListener {
    public final /* synthetic */ o a;

    public n(o oVar) {
        this.a = oVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        o oVar = this.a;
        if (oVar.t || oVar.r != 4) {
            c1 c1Var = oVar.h;
            if (c1Var != null) {
                c1Var.a.A();
                return;
            }
            return;
        }
        a aVar = oVar.e;
        if (aVar != null) {
            aVar.a(1, 39);
        }
    }
}
