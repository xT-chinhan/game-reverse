package com.byazt.xev;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 75, 61})
public final class aj implements yb {
    public static final hw<Boolean> hw = new hw<Boolean>() { // from class: com.byazt.xev.aj.1
        @Override // com.byazt.xev.hw
        /* JADX INFO: renamed from: hn, reason: merged with bridge method [inline-methods] */
        public Boolean pr(Object... objArr) {
            return Boolean.valueOf(zo.pr((Context) objArr[0]));
        }
    };
    public String pr;

    @com.byazt.vzx.pr(pr = {0, 1, 75, MediaPlayer.MEDIA_PLAYER_OPTION_GET_RES_HEADERS})
    static class pr extends yb.pr {
        public long pr = 0;
    }

    private boolean c(Context context) {
        boolean z = false;
        if (context == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                this.pr = "com.huawei.hwid";
                z = true;
            } else if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) != null) {
                this.pr = "com.huawei.hwid.tv";
                z = true;
            } else {
                this.pr = "com.huawei.hms";
                if (packageManager.getPackageInfo("com.huawei.hms", 0) != null) {
                    z = true;
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
        } catch (Exception e2) {
        }
        return z;
    }

    public static boolean pr(Context context) {
        if (context == null) {
            return false;
        }
        return hw.hw(context).booleanValue();
    }

    @Override // com.byazt.xev.yb
    public boolean hw(Context context) {
        return c(context);
    }

    @Override // com.byazt.xev.yb
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public pr hn(Context context) {
        pr prVar = new pr();
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
                String string2 = Settings.Global.getString(context.getContentResolver(), "pps_track_limit");
                if (!TextUtils.isEmpty(string)) {
                    prVar.hw = string;
                    prVar.hn = Boolean.parseBoolean(string2);
                    prVar.pr = 202003021704L;
                    return prVar;
                }
            } catch (Throwable th) {
                com.byazt.ec.w.pr(th);
            }
        }
        Pair<String, Boolean> pairUc = uc(context);
        if (pairUc != null) {
            prVar.hw = (String) pairUc.first;
            prVar.hn = ((Boolean) pairUc.second).booleanValue();
            prVar.pr = pr(context, this.pr);
        }
        return prVar;
    }

    private static int pr(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return 0;
            }
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            com.byazt.ec.w.pr(e);
            return 0;
        }
    }

    private Pair<String, Boolean> uc(Context context) {
        if (TextUtils.isEmpty(this.pr)) {
            return null;
        }
        return (Pair) new z(context, new Intent("com.uodis.opendevice.OPENIDS_SERVICE").setPackage(this.pr), new z.hw<fo, Pair<String, Boolean>>() { // from class: com.byazt.xev.aj.2
            @Override // com.byazt.xev.z.hw
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public fo hw(IBinder iBinder) {
                return fo.pr.pr(iBinder);
            }

            @Override // com.byazt.xev.z.hw
            public Pair<String, Boolean> pr(fo foVar) throws Exception {
                if (foVar == null) {
                    return null;
                }
                return new Pair<>(foVar.pr(), Boolean.valueOf(foVar.hw()));
            }
        }).pr();
    }
}
