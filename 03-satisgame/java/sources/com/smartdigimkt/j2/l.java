package com.smartdigimkt.j2;

import android.content.DialogInterface;
import android.text.TextUtils;
import com.smartdigimkt.sdk.basead.ui.web.WebLandPageActivity;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements DialogInterface.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;
    public final /* synthetic */ WebLandPageActivity c;

    public l(int i, WebLandPageActivity webLandPageActivity, String str) {
        this.c = webLandPageActivity;
        this.a = i;
        this.b = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2 = this.a;
        if (i2 == 7) {
            this.c.C = 2;
        }
        WebLandPageActivity webLandPageActivity = this.c;
        String str = this.b;
        int i3 = WebLandPageActivity.E;
        webLandPageActivity.getClass();
        if (!TextUtils.isEmpty(str)) {
            com.smartdigimkt.s4.e.a(str);
            webLandPageActivity.g = i2;
        }
        WebLandPageActivity webLandPageActivity2 = this.c;
        webLandPageActivity2.n = 2;
        com.smartdigimkt.b3.c cVar = webLandPageActivity2.s;
        com.smartdigimkt.n3.k.a(3, 1, webLandPageActivity2.t, cVar, this.b, webLandPageActivity2.D > 0);
        this.c.a();
    }
}
