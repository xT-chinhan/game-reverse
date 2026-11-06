package com.byazt.yb;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public final class rv implements hd {
    public static final qg<Boolean> qg = new qg<Boolean>() { // from class: com.byazt.yb.rv.1
        @Override // com.byazt.yb.qg
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public Boolean n(Object... objArr) {
            return Boolean.valueOf(fs.n((Context) objArr[0]));
        }
    };
    public String n;

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 160})
    static class n extends hd.n {
        public long n = 0;
    }

    private boolean l(Context context) {
        if (context == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                this.n = "com.huawei.hwid";
            } else if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) != null) {
                this.n = "com.huawei.hwid.tv";
            } else {
                this.n = "com.huawei.hms";
                if (packageManager.getPackageInfo("com.huawei.hms", 0) == null) {
                    return false;
                }
            }
            return true;
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return false;
        }
    }

    public static boolean n(Context context) {
        if (context == null) {
            return false;
        }
        return qg.qg(context).booleanValue();
    }

    @Override // com.byazt.yb.hd
    public boolean qg(Context context) {
        return l(context);
    }

    @Override // com.byazt.yb.hd
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public n s(Context context) {
        n nVar = new n();
        try {
            String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
            String string2 = Settings.Global.getString(context.getContentResolver(), "pps_track_limit");
            if (!TextUtils.isEmpty(string)) {
                nVar.qg = string;
                nVar.s = Boolean.parseBoolean(string2);
                nVar.n = 202003021704L;
                return nVar;
            }
        } catch (Throwable th) {
            com.byazt.km.cp.n(th);
        }
        Pair<String, Boolean> pairW = w(context);
        if (pairW != null) {
            nVar.qg = (String) pairW.first;
            nVar.s = ((Boolean) pairW.second).booleanValue();
            nVar.n = n(context, this.n);
        }
        return nVar;
    }

    private static int n(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (PackageManager.NameNotFoundException e) {
            com.byazt.km.cp.n(e);
            return 0;
        }
    }

    private Pair<String, Boolean> w(Context context) {
        if (TextUtils.isEmpty(this.n)) {
            return null;
        }
        return (Pair) new hu(context, new Intent("com.uodis.opendevice.OPENIDS_SERVICE").setPackage(this.n), new hu.qg<wm, Pair<String, Boolean>>() { // from class: com.byazt.yb.rv.2
            @Override // com.byazt.yb.hu.qg
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public wm qg(IBinder iBinder) {
                return wm.n.n(iBinder);
            }

            @Override // com.byazt.yb.hu.qg
            public Pair<String, Boolean> n(wm wmVar) throws Exception {
                if (wmVar == null) {
                    return null;
                }
                return new Pair<>(wmVar.n(), Boolean.valueOf(wmVar.qg()));
            }
        }).n();
    }
}
