package com.smartdigimkt.x1;

import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ g a;

    public e(g gVar) {
        this.a = gVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        g gVar = this.a;
        a aVar = gVar.e;
        if (aVar != null) {
            aVar.a(14, 26);
        } else {
            gVar.a();
        }
    }
}
