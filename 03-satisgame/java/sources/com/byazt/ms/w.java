package com.byazt.ms;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.anythink.china.b.c;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 238, 13})
public class w {
    public static void n(Activity activity, final String[] strArr, final ITTPermissionCallback iTTPermissionCallback) {
        boolean z;
        com.byazt.zq.q qVarA;
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                } else {
                    if (c.b.equalsIgnoreCase(strArr[i])) {
                        z = true;
                        break;
                    }
                    i++;
                }
            }
            if (z && (qVarA = com.byazt.vyf.s.cy().a()) != null && iTTPermissionCallback != null && !qVarA.fs()) {
                iTTPermissionCallback.onDenied(c.b);
                return;
            }
        }
        if (com.byazt.ges.qg.n(activity) < 23) {
            if (iTTPermissionCallback != null) {
                iTTPermissionCallback.onGranted();
                return;
            }
            return;
        }
        if (strArr == null || strArr.length <= 0) {
            if (iTTPermissionCallback != null) {
                iTTPermissionCallback.onGranted();
                return;
            }
            return;
        }
        long jHashCode = activity.hashCode();
        for (String str : strArr) {
            jHashCode += (long) str.hashCode();
        }
        if (activity.getApplicationInfo().targetSdkVersion >= 33 && Build.VERSION.SDK_INT >= 33 && strArr.length == 1) {
            String str2 = strArr[0];
            if (TextUtils.equals(str2, "android.permission.READ_EXTERNAL_STORAGE") || TextUtils.equals(str2, c.b)) {
                if (iTTPermissionCallback != null) {
                    iTTPermissionCallback.onDenied(str2);
                }
                com.byazt.eji.s.n().n(false, new String[]{str2});
                return;
            }
        }
        com.byazt.af.n.n(String.valueOf(jHashCode), strArr, new com.byazt.af.n.InterfaceC0121n() { // from class: com.byazt.ms.w.1
            @Override // com.byazt.af.n.InterfaceC0121n
            public void n() {
                ITTPermissionCallback iTTPermissionCallback2 = iTTPermissionCallback;
                if (iTTPermissionCallback2 != null) {
                    iTTPermissionCallback2.onGranted();
                }
                com.byazt.eji.s.n().n(true, strArr);
            }

            @Override // com.byazt.af.n.InterfaceC0121n
            public void n(String str3) {
                ITTPermissionCallback iTTPermissionCallback2 = iTTPermissionCallback;
                if (iTTPermissionCallback2 != null) {
                    iTTPermissionCallback2.onDenied(str3);
                }
                com.byazt.eji.s.n().n(false, new String[]{str3});
            }
        });
    }

    public static boolean n(Context context, String str) {
        com.byazt.af.rv rvVarHd;
        if (c.b.equalsIgnoreCase(str) && (rvVarHd = com.byazt.vyf.s.cy().hd()) != null && !rvVarHd.fs()) {
            return false;
        }
        if (context == null) {
            context = com.byazt.nf.rv.getContext();
        }
        return com.byazt.af.x.n().n(context, str);
    }
}
