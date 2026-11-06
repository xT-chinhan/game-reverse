package com.smartdigimkt.s;

import android.content.Context;
import android.content.Intent;
import android.os.Build;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g {
    public static void a(Context context) throws Exception {
        try {
            Intent intent = new Intent("com.bun.msa.action.start.service");
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
            intent.putExtra("com.bun.msa.param.pkgname", context.getPackageName());
            intent.putExtra("com.bun.msa.param.runinset", true);
            if (Build.VERSION.SDK_INT < 26) {
                context.startService(intent);
            } else {
                context.startForegroundService(intent);
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
