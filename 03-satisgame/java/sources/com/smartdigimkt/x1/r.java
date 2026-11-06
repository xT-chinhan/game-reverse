package com.smartdigimkt.x1;

import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public final class r implements View.OnClickListener {
    public final /* synthetic */ v a;

    public r(v vVar) {
        this.a = vVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        a aVar = this.a.e;
        if (aVar != null) {
            aVar.a(14, 32);
        }
    }
}
