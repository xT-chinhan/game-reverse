package com.smartdigimkt.x1;

import android.view.View;
import com.smartdigimkt.n1.c1;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ g a;

    public f(g gVar) {
        this.a = gVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        c1 c1Var = this.a.h;
        if (c1Var != null) {
            c1Var.a.A();
        }
    }
}
