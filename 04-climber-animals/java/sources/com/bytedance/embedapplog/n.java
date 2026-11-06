package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: loaded from: classes2.dex */
final class n extends nn<h> {
    n() {
        super("com.mdid.msa");
    }

    @Override // com.bytedance.embedapplog.nn, com.bytedance.embedapplog.pl
    public pl.ms xr(Context context) {
        ms(context, context.getPackageName());
        return super.xr(context);
    }

    @Override // com.bytedance.embedapplog.nn
    protected ch.xr<h, String> ms() {
        return new ch.xr<h, String>() { // from class: com.bytedance.embedapplog.n.1
            @Override // com.bytedance.embedapplog.ch.xr
            /* JADX INFO: renamed from: xr, reason: merged with bridge method [inline-methods] */
            public h ms(IBinder iBinder) {
                return h.ms.ms(iBinder);
            }

            @Override // com.bytedance.embedapplog.ch.xr
            public String ms(h hVar) {
                if (hVar == null) {
                    return null;
                }
                return hVar.ms();
            }
        };
    }

    @Override // com.bytedance.embedapplog.nn
    protected Intent ah(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.setAction("com.bun.msa.action.bindto.service");
        intent.putExtra("com.bun.msa.param.pkgname", context.getPackageName());
        return intent;
    }

    private void ms(Context context, String str) {
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
        intent.setAction("com.bun.msa.action.start.service");
        intent.putExtra("com.bun.msa.param.pkgname", str);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            context.startService(intent);
        } catch (Exception e) {
            oh.ms(e);
        }
    }
}
