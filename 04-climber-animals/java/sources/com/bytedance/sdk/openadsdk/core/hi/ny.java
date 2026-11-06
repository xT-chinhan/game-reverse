package com.bytedance.sdk.openadsdk.core.hi;

import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.t.u;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback;

/* JADX INFO: loaded from: classes2.dex */
public class ny {
    public static void ms(Activity activity, final String[] strArr, final ITTPermissionCallback iTTPermissionCallback) {
        boolean z;
        com.bytedance.sdk.openadsdk.core.f.ka kaVarQv;
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                } else {
                    if ("android.permission.WRITE_EXTERNAL_STORAGE".equalsIgnoreCase(strArr[i])) {
                        z = true;
                        break;
                    }
                    i++;
                }
            }
            if (z && (kaVarQv = com.bytedance.sdk.openadsdk.core.ch.ub().qv()) != null && iTTPermissionCallback != null && !kaVarQv.ka()) {
                iTTPermissionCallback.onDenied("android.permission.WRITE_EXTERNAL_STORAGE");
                return;
            }
        }
        if (com.bytedance.sdk.openadsdk.core.x.ms.ah(activity) < 23) {
            if (iTTPermissionCallback != null) {
                iTTPermissionCallback.onGranted();
            }
        } else if (strArr == null || strArr.length <= 0) {
            if (iTTPermissionCallback != null) {
                iTTPermissionCallback.onGranted();
            }
        } else {
            long jHashCode = activity.hashCode();
            for (String str : strArr) {
                jHashCode += (long) str.hashCode();
            }
            com.bytedance.sdk.openadsdk.core.jw.ab.ms(String.valueOf(jHashCode), strArr, new com.bytedance.sdk.openadsdk.core.jw.ab.ms() { // from class: com.bytedance.sdk.openadsdk.core.hi.ny.1
                @Override // com.bytedance.sdk.openadsdk.core.jw.ab.ms
                public void ms() {
                    ITTPermissionCallback iTTPermissionCallback2 = iTTPermissionCallback;
                    if (iTTPermissionCallback2 != null) {
                        iTTPermissionCallback2.onGranted();
                    }
                    u.ms().ms(true, strArr);
                }

                @Override // com.bytedance.sdk.openadsdk.core.jw.ab.ms
                public void ms(String str2) {
                    ITTPermissionCallback iTTPermissionCallback2 = iTTPermissionCallback;
                    if (iTTPermissionCallback2 != null) {
                        iTTPermissionCallback2.onDenied(str2);
                    }
                    u.ms().ms(false, new String[]{str2});
                }
            });
        }
    }

    public static boolean ms(Context context, String str) {
        com.bytedance.sdk.openadsdk.core.f.ka kaVarAo;
        if ("android.permission.WRITE_EXTERNAL_STORAGE".equalsIgnoreCase(str) && (kaVarAo = com.bytedance.sdk.openadsdk.core.ch.ub().ao()) != null && !kaVarAo.ka()) {
            return false;
        }
        if (context == null) {
            context = re.getContext();
        }
        return com.bytedance.sdk.openadsdk.core.i.ka.ms().ms(context, str);
    }
}
