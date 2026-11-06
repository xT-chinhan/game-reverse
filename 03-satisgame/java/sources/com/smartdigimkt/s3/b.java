package com.smartdigimkt.s3;

import com.smartdigimkt.sdk.api.SDMSDK;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements SDMSDK.InitCallBack {
    public final /* synthetic */ c a;

    public b(c cVar) {
        this.a = cVar;
    }

    @Override // com.smartdigimkt.sdk.api.SDMSDK.InitCallBack
    public final void fail(String str) {
        this.a.getClass();
        this.a.getClass();
        Object obj = j.a;
        this.a.getClass();
        com.smartdigimkt.q3.f.a().c(new i(this.a.d, ""));
    }

    @Override // com.smartdigimkt.sdk.api.SDMSDK.InitCallBack
    public final void success() {
        this.a.a.k();
        this.a.getClass();
        Object obj = j.a;
        c cVar = this.a;
        String str = cVar.b;
        Map map = cVar.c;
        com.smartdigimkt.q3.f.a().c(new d(str, null, cVar.d, map));
    }
}
