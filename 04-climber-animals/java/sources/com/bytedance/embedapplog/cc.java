package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: loaded from: classes2.dex */
final class cc extends nn<u> {
    cc() {
        super("com.zui.deviceidservice");
    }

    @Override // com.bytedance.embedapplog.nn
    protected ch.xr<u, String> ms() {
        return new ch.xr<u, String>() { // from class: com.bytedance.embedapplog.cc.1
            @Override // com.bytedance.embedapplog.ch.xr
            /* JADX INFO: renamed from: xr, reason: merged with bridge method [inline-methods] */
            public u ms(IBinder iBinder) {
                return u.ms.ms(iBinder);
            }

            @Override // com.bytedance.embedapplog.ch.xr
            public String ms(u uVar) {
                if (uVar == null) {
                    return null;
                }
                return uVar.ms();
            }
        };
    }

    @Override // com.bytedance.embedapplog.nn
    protected Intent ah(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        return intent;
    }
}
