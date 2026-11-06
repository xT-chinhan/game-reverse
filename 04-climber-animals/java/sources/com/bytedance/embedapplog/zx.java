package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: loaded from: classes2.dex */
final class zx extends nn<zb> {
    zx() {
        super("com.samsung.android.deviceidservice");
    }

    @Override // com.bytedance.embedapplog.nn
    protected ch.xr<zb, String> ms() {
        return new ch.xr<zb, String>() { // from class: com.bytedance.embedapplog.zx.1
            @Override // com.bytedance.embedapplog.ch.xr
            /* JADX INFO: renamed from: xr, reason: merged with bridge method [inline-methods] */
            public zb ms(IBinder iBinder) {
                return zb.ms.ms(iBinder);
            }

            @Override // com.bytedance.embedapplog.ch.xr
            public String ms(zb zbVar) {
                return zbVar.ms();
            }
        };
    }

    @Override // com.bytedance.embedapplog.nn
    protected Intent ah(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        return intent;
    }
}
