package com.smartdigimkt.j2;

import android.content.DialogInterface;
import com.smartdigimkt.sdk.basead.ui.web.WebLandPageActivity;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements DialogInterface.OnClickListener {
    public final /* synthetic */ WebLandPageActivity a;

    public f(WebLandPageActivity webLandPageActivity) {
        this.a = webLandPageActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        WebLandPageActivity webLandPageActivity = this.a;
        com.smartdigimkt.a3.a aVar = webLandPageActivity.t;
        int iE = webLandPageActivity.s.e();
        WebLandPageActivity webLandPageActivity2 = this.a;
        String str = webLandPageActivity2.s.a;
        JSONArray jSONArray = webLandPageActivity2.A;
        String str2 = webLandPageActivity2.m;
        com.smartdigimkt.f3.c cVar = new com.smartdigimkt.f3.c(null, null);
        cVar.a = "1004700";
        cVar.a(aVar);
        cVar.l = str;
        cVar.m = String.valueOf(iE);
        cVar.n = jSONArray != null ? jSONArray.toString() : "";
        cVar.o = str2;
        cVar.p = String.valueOf(0);
        com.smartdigimkt.n3.k.a(cVar);
    }
}
