package com.byazt.xev;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 75, 5})
public class uc extends hn<com.byazt.otj.pr> {
    public final Context pr;

    @Override // com.byazt.xev.hn, com.byazt.xev.yb
    public /* bridge */ /* synthetic */ boolean hw(Context context) {
        return super.hw(context);
    }

    public uc(Context context) {
        super("com.coolpad.deviceidsupport");
        this.pr = context;
    }

    @Override // com.byazt.xev.hn
    public z.hw<com.byazt.otj.pr, String> pr() {
        return new z.hw<com.byazt.otj.pr, String>() { // from class: com.byazt.xev.uc.1
            @Override // com.byazt.xev.z.hw
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public com.byazt.otj.pr hw(IBinder iBinder) {
                return com.byazt.otj.pr.AbstractBinderC0155pr.pr(iBinder);
            }

            @Override // com.byazt.xev.z.hw
            public String pr(com.byazt.otj.pr prVar) throws Exception {
                if (prVar != null) {
                    return prVar.hw(uc.this.pr.getPackageName());
                }
                return null;
            }
        };
    }

    @Override // com.byazt.xev.hn
    public Intent pr(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        return intent;
    }

    @Override // com.byazt.xev.hn, com.byazt.xev.yb
    public yb.pr hn(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                String string = Settings.Global.getString(context.getContentResolver(), "coolos.oaid");
                if (!TextUtils.isEmpty(string)) {
                    yb.pr prVar = new yb.pr();
                    prVar.hw = string;
                    return prVar;
                }
            }
        } catch (Throwable th) {
        }
        return super.hn(context);
    }
}
