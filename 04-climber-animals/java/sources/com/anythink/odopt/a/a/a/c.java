package com.anythink.odopt.a.a.a;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public final void a(Context context, com.anythink.odopt.a.a aVar) {
        boolean zA;
        try {
            zA = a(context);
        } catch (Exception e) {
            aVar.a(e.getMessage());
            zA = false;
        }
        if (zA) {
            Intent intent = new Intent("com.bun.msa.action.bindto.service");
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
            intent.putExtra("com.bun.msa.param.pkgname", context.getPackageName());
            d.a(context, intent, aVar, new d.a() { // from class: com.anythink.odopt.a.a.a.c.1
                @Override // com.anythink.odopt.a.a.a.d.a
                public final String a(IBinder iBinder) {
                    b bVarA = b.AbstractBinderC0134b.a(iBinder);
                    if (bVarA == null) {
                        throw new RuntimeException("MsaIdInterface is null");
                    }
                    if (!bVarA.a()) {
                        throw new RuntimeException("MsaIdInterface#isSupported return false");
                    }
                    return bVarA.c();
                }
            });
        }
    }

    private static boolean a(Context context) throws Exception {
        try {
            Intent intent = new Intent("com.bun.msa.action.start.service");
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
            intent.putExtra("com.bun.msa.param.pkgname", context.getPackageName());
            intent.putExtra("com.bun.msa.param.runinset", true);
            context.startForegroundService(intent);
            return true;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
