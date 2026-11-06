package com.efs.sdk.base.core.c;

import android.support.annotation.NonNull;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.http.HttpResponse;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements c {
    @Override // com.efs.sdk.base.core.c.c
    @NonNull
    public final HttpResponse a(com.efs.sdk.base.core.d.b bVar, boolean z) {
        HttpResponse httpResponseA;
        com.efs.sdk.base.core.a.c cVarA = com.efs.sdk.base.core.a.c.a();
        cVarA.d = bVar.a.d;
        cVarA.e = bVar.a.e;
        cVarA.g = bVar.a.b;
        cVarA.h = bVar.a.a;
        cVarA.m = bVar.a();
        String strA = com.efs.sdk.base.core.config.a.c.a().a(false);
        if (bVar.a.c == 0) {
            com.efs.sdk.base.core.a.a aVarA = com.efs.sdk.base.core.a.a.a();
            byte[] bArr = bVar.c;
            boolean z2 = bVar.b.b;
            String strB = cVarA.b();
            String strA2 = com.efs.sdk.base.core.a.a.a(strA, cVarA);
            if (aVarA.a) {
                Log.i("efs.px.api", "upload buffer file, url is ".concat(String.valueOf(strA2)));
            }
            HashMap map = new HashMap(1);
            map.put("wpk-header", strB);
            com.efs.sdk.base.core.util.a.d dVarA = new com.efs.sdk.base.core.util.a.d(strA2).a(map);
            dVarA.a.c = bArr;
            dVarA.a.g = true;
            com.efs.sdk.base.core.util.a.d dVarA2 = dVarA.a("type", cVarA.h);
            StringBuilder sb = new StringBuilder();
            sb.append(cVarA.m);
            httpResponseA = dVarA2.a("size", sb.toString()).a("flow_limit", Boolean.toString(z2)).a(com.efs.sdk.base.core.a.d.a()).a().b();
        } else {
            httpResponseA = 1 == bVar.a.c ? com.efs.sdk.base.core.a.a.a().a(strA, cVarA, bVar.d, bVar.b.b) : new HttpResponse();
        }
        if (httpResponseA.succ && z) {
            com.efs.sdk.base.core.util.b.b(bVar.d);
        }
        return httpResponseA;
    }
}
