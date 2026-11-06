package com.byazt.qam;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import com.byazt.ca.ho;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1745, 20})
public final class hn {
    public static final String pr = hn.class.getSimpleName();

    private hn() {
    }

    public static boolean pr(Context context, String str) {
        return hw(context, str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:5:0x001a  */
    private static boolean hw(Context context, String str) {
        String lowerCase;
        String str2 = pr;
        ho.hw(str2, "checkPermissinKITKATNew，permission：".concat(String.valueOf(str)));
        boolean z = false;
        try {
            switch (str) {
                case "android.permission.ACCESS_COARSE_LOCATION":
                    lowerCase = "android:coarse_location";
                    break;
                case "android.permission.ACCESS_FINE_LOCATION":
                    lowerCase = "android:fine_location";
                    break;
                case "android.permission.READ_PHONE_STATE":
                    lowerCase = "android:read_phone_state";
                    break;
                default:
                    lowerCase = str.replaceFirst("android.permission.", "android:").toLowerCase();
                    break;
            }
            int iCheckOp = ((AppOpsManager) context.getSystemService("appops")).checkOp(lowerCase, Binder.getCallingUid(), context.getPackageName());
            ho.hw(str2, "checkPermissinKITKATNew，locationOp,permission：" + iCheckOp + "," + lowerCase);
            if (iCheckOp == 0) {
                return true;
            }
            try {
                ho.hw(str2, "checkPermissinKITKATNew，false,permission：".concat(String.valueOf(lowerCase)));
                return false;
            } catch (Exception e) {
                e = e;
                ho.pr(pr, "权限检查出错时默认返回有权限，异常代码：".concat(String.valueOf(e)), e);
                return z;
            }
        } catch (Exception e2) {
            e = e2;
            z = true;
        }
    }
}
