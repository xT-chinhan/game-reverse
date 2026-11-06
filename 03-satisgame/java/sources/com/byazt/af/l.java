package com.byazt.af;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import com.anythink.china.b.c;
import com.byazt.tk.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SAVED_HOST_TIME, 18})
public final class l {
    public static final String n = "l";

    private l() {
    }

    public static boolean n(Context context, String str) {
        return qg(context, str);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0044  */
    private static boolean qg(Context context, String str) {
        byte b;
        String lowerCase;
        String str2 = n;
        k.qg(str2, "checkPermissinKITKATNew，permission：".concat(String.valueOf(str)));
        boolean z = true;
        try {
            int iHashCode = str.hashCode();
            if (iHashCode != -1888586689) {
                if (iHashCode != -63024214) {
                    if (iHashCode == -5573545 && str.equals(c.a)) {
                        b = 2;
                    } else {
                        b = -1;
                    }
                } else if (str.equals("android.permission.ACCESS_COARSE_LOCATION")) {
                    b = 0;
                } else {
                    b = -1;
                }
            } else if (str.equals("android.permission.ACCESS_FINE_LOCATION")) {
                b = 1;
            } else {
                b = -1;
            }
            if (b == 0) {
                lowerCase = "android:coarse_location";
            } else if (b != 1) {
                lowerCase = b != 2 ? str.replaceFirst("android.permission.", "android:").toLowerCase() : "android:read_phone_state";
            } else {
                lowerCase = "android:fine_location";
            }
            int iCheckOp = ((AppOpsManager) context.getSystemService("appops")).checkOp(lowerCase, Binder.getCallingUid(), context.getPackageName());
            k.qg(str2, "checkPermissinKITKATNew，locationOp,permission：" + iCheckOp + "," + lowerCase);
            if (iCheckOp == 0) {
                return true;
            }
            try {
                k.qg(str2, "checkPermissinKITKATNew，false,permission：".concat(String.valueOf(lowerCase)));
                return false;
            } catch (Exception e) {
                e = e;
                z = false;
                k.n(n, "权限检查出错时默认返回有权限，异常代码：".concat(String.valueOf(e)), e);
                return z;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }
}
