package com.smartdigimkt.y1;

import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public final class u implements View.OnClickListener {
    public final /* synthetic */ v a;

    public u(v vVar) {
        this.a = vVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        v vVar = this.a;
        if (vVar != null) {
            ((c) vVar).a.a();
        }
    }
}
