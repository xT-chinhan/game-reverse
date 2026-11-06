package com.smartdigimkt.j2;

import android.content.DialogInterface;
import com.smartdigimkt.sdk.basead.ui.web.WebLandPageActivity;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements DialogInterface.OnClickListener {
    public final /* synthetic */ String a;
    public final /* synthetic */ WebLandPageActivity b;

    public k(WebLandPageActivity webLandPageActivity, String str) {
        this.b = webLandPageActivity;
        this.a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        WebLandPageActivity webLandPageActivity = this.b;
        com.smartdigimkt.b3.c cVar = webLandPageActivity.s;
        com.smartdigimkt.n3.k.a(3, 2, webLandPageActivity.t, cVar, this.a, webLandPageActivity.D > 0);
    }
}
