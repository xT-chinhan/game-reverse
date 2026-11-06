package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;

/* JADX INFO: loaded from: classes2.dex */
final class gs implements pl {
    private static final ce<Boolean> xr = new ce<Boolean>() { // from class: com.bytedance.embedapplog.gs.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.embedapplog.ce
        /* JADX INFO: renamed from: ah, reason: merged with bridge method [inline-methods] */
        public Boolean ms(Object... objArr) {
            return Boolean.valueOf(kl.ms((Context) objArr[0]));
        }
    };

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f487ms;

    gs() {
    }

    private boolean ka(Context context) {
        if (context == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                this.f487ms = "com.huawei.hwid";
            } else if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) != null) {
                this.f487ms = "com.huawei.hwid.tv";
            } else {
                this.f487ms = "com.huawei.hms";
                if (packageManager.getPackageInfo("com.huawei.hms", 0) == null) {
                    return false;
                }
            }
            return true;
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return false;
        }
    }

    static boolean ah(Context context) {
        if (context == null) {
            return false;
        }
        return xr.xr(context).booleanValue();
    }

    @Override // com.bytedance.embedapplog.pl
    public boolean ms(Context context) {
        return ka(context);
    }

    @Override // com.bytedance.embedapplog.pl
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public ms xr(Context context) {
        ms msVar = new ms();
        try {
            String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
            String string2 = Settings.Global.getString(context.getContentResolver(), "pps_track_limit");
            if (!TextUtils.isEmpty(string)) {
                msVar.xr = string;
                msVar.ah = Boolean.parseBoolean(string2);
                msVar.f489ms = 202003021704L;
                return msVar;
            }
        } catch (Throwable th) {
            oh.ms(th);
        }
        Pair<String, Boolean> pairC = c(context);
        if (pairC != null) {
            msVar.xr = (String) pairC.first;
            msVar.ah = ((Boolean) pairC.second).booleanValue();
            msVar.f489ms = ms(context, this.f487ms);
        }
        return msVar;
    }

    private static int ms(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (PackageManager.NameNotFoundException e) {
            oh.ms(e);
            return 0;
        }
    }

    private Pair<String, Boolean> c(Context context) {
        if (TextUtils.isEmpty(this.f487ms)) {
            return null;
        }
        return (Pair) new ch(context, new Intent("com.uodis.opendevice.OPENIDS_SERVICE").setPackage(this.f487ms), new ch.xr<ph, Pair<String, Boolean>>() { // from class: com.bytedance.embedapplog.gs.2
            @Override // com.bytedance.embedapplog.ch.xr
            /* JADX INFO: renamed from: xr, reason: merged with bridge method [inline-methods] */
            public ph ms(IBinder iBinder) {
                return ph.ms.ms(iBinder);
            }

            @Override // com.bytedance.embedapplog.ch.xr
            public Pair<String, Boolean> ms(ph phVar) {
                if (phVar == null) {
                    return null;
                }
                return new Pair<>(phVar.ms(), Boolean.valueOf(phVar.xr()));
            }
        }).ms();
    }

    static class ms extends pl.ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        long f489ms = 0;

        ms() {
        }
    }
}
