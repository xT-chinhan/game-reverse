package com.smartdigimkt.f0;

import android.content.Context;
import android.text.TextUtils;
import com.smartdigimkt.r4.y;
import com.smartdigimkt.sdk.api.AdError;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements com.smartdigimkt.a4.b {
    public final /* synthetic */ String a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ e c;

    public b(e eVar, String str, Context context) {
        this.c = eVar;
        this.a = str;
        this.b = context;
    }

    @Override // com.smartdigimkt.a4.b
    public final void a(int i) {
    }

    @Override // com.smartdigimkt.a4.b
    public final void a(int i, Object obj) {
        String string = obj != null ? obj.toString() : "";
        if (!TextUtils.isEmpty(string)) {
            e eVar = this.c;
            String str = eVar.a;
            eVar.b = string;
            e eVar2 = this.c;
            eVar2.getClass();
            com.smartdigimkt.q3.f.a().c(new c(eVar2, string));
            y.a(this.b, "sdm_adx_rp_sdk", "tracker_mapping", this.a);
            e eVar3 = this.c;
            eVar3.a(eVar3.b);
        }
        this.c.f = false;
    }

    @Override // com.smartdigimkt.a4.b
    public final void a(int i, String str, AdError adError) {
        this.c.f = false;
    }
}
