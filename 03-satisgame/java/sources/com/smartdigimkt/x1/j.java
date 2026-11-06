package com.smartdigimkt.x1;

import android.view.View;
import com.smartdigimkt.n1.c1;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements View.OnClickListener {
    public final /* synthetic */ k a;

    public j(k kVar) {
        this.a = kVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        c1 c1Var = this.a.h;
        if (c1Var != null) {
            c1Var.a.A();
        }
    }
}
