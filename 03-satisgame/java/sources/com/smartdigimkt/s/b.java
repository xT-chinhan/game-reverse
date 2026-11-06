package com.smartdigimkt.s;

import android.content.Context;
import android.content.Intent;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public final String a = "b";

    public final void a(Context context, com.smartdigimkt.q.a aVar) {
        if (context == null && aVar != null) {
            aVar.a("context is null");
        }
        a aVar2 = new a(this, aVar);
        try {
            g.a(context);
            Intent intent = new Intent("com.bun.msa.action.bindto.service");
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
            intent.putExtra("com.bun.msa.param.pkgname", context.getPackageName());
            h hVar = new h(context, aVar2, new f());
            try {
                if (!hVar.a.bindService(intent, hVar, 1)) {
                    throw new RuntimeException("Service binding failed");
                }
                Objects.toString(intent);
            } catch (Exception e) {
                hVar.b.a(e.getMessage());
            }
        } catch (Exception e2) {
            aVar2.a(e2.getMessage());
        }
    }
}
