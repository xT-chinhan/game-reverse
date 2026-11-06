package com.bytedance.sdk.openadsdk.core.i;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import com.bytedance.sdk.component.utils.sl;
import com.kuaishou.weapon.p0.g;

/* JADX INFO: loaded from: classes2.dex */
public final class ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final String f2657ms = "ah";

    private ah() {
    }

    public static boolean ms(Context context, String str) {
        return xr(context, str);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0044  */
    private static boolean xr(Context context, String str) {
        byte b;
        String lowerCase;
        String str2 = f2657ms;
        sl.d(str2, "checkPermissinKITKATNew，permission：".concat(String.valueOf(str)));
        boolean z = true;
        try {
            int iHashCode = str.hashCode();
            if (iHashCode != -1888586689) {
                if (iHashCode != -63024214) {
                    if (iHashCode == -5573545 && str.equals("android.permission.READ_PHONE_STATE")) {
                        b = 2;
                    } else {
                        b = -1;
                    }
                } else if (str.equals(g.h)) {
                    b = 0;
                } else {
                    b = -1;
                }
            } else if (str.equals(g.g)) {
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
            sl.d(str2, "checkPermissinKITKATNew，locationOp,permission：" + iCheckOp + "," + lowerCase);
            if (iCheckOp == 0) {
                return true;
            }
            try {
                sl.d(str2, "checkPermissinKITKATNew，false,permission：".concat(String.valueOf(lowerCase)));
                return false;
            } catch (Exception e) {
                e = e;
                z = false;
                sl.d(f2657ms, "权限检查出错时默认返回有权限，异常代码：".concat(String.valueOf(e)));
                return z;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    private static boolean ah(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }
}
