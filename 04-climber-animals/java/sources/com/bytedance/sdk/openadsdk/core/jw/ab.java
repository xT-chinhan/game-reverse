package com.bytedance.sdk.openadsdk.core.jw;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ab {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final Map<String, ms> f2669ms = Collections.synchronizedMap(new HashMap());
    private static com.bytedance.sdk.openadsdk.core.ao xr;

    public interface ms {
        void ms();

        void ms(String str);
    }

    public static void ms(String str, String[] strArr, ms msVar) {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            return;
        }
        ms(str, msVar);
        TTDelegateActivity.ms(str, strArr);
    }

    public static void ms(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
            com.bytedance.sdk.component.ch.ab.ah().execute(new com.bytedance.sdk.component.ch.ny("handleYes", 5) { // from class: com.bytedance.sdk.openadsdk.core.jw.ab.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ab.xr().xr(str, (String) null);
                    } catch (Throwable unused) {
                    }
                }
            });
            return;
        }
        ms msVarXr = xr(str);
        if (msVarXr == null) {
            return;
        }
        msVarXr.ms();
    }

    public static void ms(final String str, final String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
            com.bytedance.sdk.component.ch.ab.ah().execute(new com.bytedance.sdk.component.ch.ny("handleNo", 5) { // from class: com.bytedance.sdk.openadsdk.core.jw.ab.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ab.xr().xr(str, str2);
                    } catch (Throwable unused) {
                    }
                }
            });
            return;
        }
        ms msVarXr = xr(str);
        if (msVarXr == null) {
            return;
        }
        msVarXr.ms(str2);
    }

    private static void ms(final String str, final ms msVar) {
        if (TextUtils.isEmpty(str) || msVar == null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
            com.bytedance.sdk.component.ch.ab.xr(new com.bytedance.sdk.component.ch.ny("addListener") { // from class: com.bytedance.sdk.openadsdk.core.jw.ab.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.bytedance.sdk.component.utils.sl.d("MultiProcess", "getListenerManager().registerPermissionListener...");
                        ab.xr().ms(str, new com.bytedance.sdk.openadsdk.core.multipro.aidl.xr.xr(msVar));
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.sl.ms(th);
                        com.bytedance.sdk.component.utils.sl.d("MultiProcess", th.toString());
                    }
                }
            }, 5);
        } else {
            f2669ms.put(str, msVar);
        }
    }

    private static ms xr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f2669ms.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.bytedance.sdk.openadsdk.core.ao xr() {
        if (xr == null) {
            xr = com.bytedance.sdk.openadsdk.core.multipro.aidl.ms.d.ms(com.bytedance.sdk.openadsdk.core.multipro.aidl.ms.ms(com.bytedance.sdk.openadsdk.core.re.getContext()).ms(4));
        }
        return xr;
    }
}
