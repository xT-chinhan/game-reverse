package com.bytedance.embedapplog;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ec extends nn<sl> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Context f485ms;

    @Override // com.bytedance.embedapplog.nn, com.bytedance.embedapplog.pl
    public /* bridge */ /* synthetic */ boolean ms(Context context) {
        return super.ms(context);
    }

    ec(Context context) {
        super("com.coolpad.deviceidsupport");
        this.f485ms = context;
    }

    @Override // com.bytedance.embedapplog.nn
    protected ch.xr<sl, String> ms() {
        return new ch.xr<sl, String>() { // from class: com.bytedance.embedapplog.ec.1
            @Override // com.bytedance.embedapplog.ch.xr
            /* JADX INFO: renamed from: xr, reason: merged with bridge method [inline-methods] */
            public sl ms(IBinder iBinder) {
                return sl.ms.ms(iBinder);
            }

            @Override // com.bytedance.embedapplog.ch.xr
            public String ms(sl slVar) {
                if (slVar == null) {
                    return null;
                }
                return slVar.xr(ec.this.f485ms.getPackageName());
            }
        };
    }

    @Override // com.bytedance.embedapplog.nn
    protected Intent ah(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        return intent;
    }

    @Override // com.bytedance.embedapplog.nn, com.bytedance.embedapplog.pl
    public pl.ms xr(Context context) {
        try {
            String string = Settings.Global.getString(context.getContentResolver(), "coolos.oaid");
            if (!TextUtils.isEmpty(string)) {
                pl.ms msVar = new pl.ms();
                msVar.xr = string;
                return msVar;
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms(th);
        }
        return super.xr(context);
    }
}
