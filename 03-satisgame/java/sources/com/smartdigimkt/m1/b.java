package com.smartdigimkt.m1;

import android.content.Context;
import android.text.TextUtils;
import com.smartdigimkt.n3.k;
import com.smartdigimkt.q3.f;
import com.smartdigimkt.r4.y;
import com.smartdigimkt.sdk.api.AdError;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements com.smartdigimkt.a4.b {
    public final /* synthetic */ Context a;
    public final /* synthetic */ d b;

    public b(d dVar, Context context) {
        this.b = dVar;
        this.a = context;
    }

    @Override // com.smartdigimkt.a4.b
    public final void a(int i) {
    }

    @Override // com.smartdigimkt.a4.b
    public final void a(int i, Object obj) {
        String string = obj != null ? obj.toString() : "";
        String str = this.b.a;
        string.getClass();
        if (!TextUtils.isEmpty(string)) {
            d dVar = this.b;
            Context context = this.a;
            String str2 = dVar.c;
            synchronized (dVar) {
                dVar.h = str2;
                y.a(context, "sdm_adx_rp_sdk", "adx_optional_res_url", str2);
            }
            d dVar2 = this.b;
            dVar2.g = dVar2.a(string);
            d dVar3 = this.b;
            if (dVar3.d != null) {
                f.a().c(new c(dVar3, string));
            }
        }
        this.b.e = false;
    }

    @Override // com.smartdigimkt.a4.b
    public final void a(int i, String str, AdError adError) {
        d dVar = this.b;
        String str2 = dVar.c;
        dVar.i = str2;
        dVar.e = false;
        String errorInfo = adError.getErrorInfo();
        com.smartdigimkt.f3.c cVar = new com.smartdigimkt.f3.c("", "");
        cVar.a = "1004765";
        cVar.l = String.valueOf(3);
        cVar.m = str2;
        cVar.n = errorInfo;
        k.a(cVar);
    }
}
