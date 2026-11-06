package com.byazt.uk;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import com.byazt.fi.BaseConstants;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mar.sdk.MARCode;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_REUSE_SOCKET, 37})
public class pr {
    public static String pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.byazt.bak.hn.pr(new File(str));
    }

    public static int pr(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return 5;
        }
        return com.byazt.bak.hn.pr(str, new File(str2));
    }

    public static String hw(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = com.byazt.eld.k.getContext().getPackageManager().getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return applicationInfo.sourceDir;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static void pr() {
        if (com.byazt.eld.k.aj().optInt("hook", 0) != 1) {
            return;
        }
        com.byazt.cvl.c.pr().pr(new Runnable() { // from class: com.byazt.uk.pr.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.now.c.zo();
                pr.hn();
            }
        }, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hn() {
        Field declaredField;
        Class<?> cls;
        try {
            if (Build.VERSION.SDK_INT < 26) {
                declaredField = Class.forName("android.app.ActivityManagerNative").getDeclaredField("gDefault");
            } else {
                declaredField = Class.forName("android.app.ActivityManager").getDeclaredField("IActivityManagerSingleton");
            }
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            Field declaredField2 = Class.forName("android.util.Singleton").getDeclaredField("mInstance");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            if (obj2 == null || (cls = Class.forName("android.app.IActivityManager")) == null) {
                return;
            }
            declaredField2.set(obj, Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, new C0208pr(obj2)));
        } catch (Throwable th) {
        }
    }

    public static void pr(Object[] objArr) {
        if (com.byazt.eld.k.aj().optInt("hook", 0) == 1 && (objArr[1] instanceof String)) {
            Object obj = objArr[2];
            if (obj instanceof Intent) {
                Intent intent = (Intent) obj;
                if ("android.intent.action.VIEW".equals(intent.getAction()) && com.byazt.mrs.c.pr.equals(intent.getType())) {
                    if (com.byazt.now.c.x()) {
                        String strOptString = com.byazt.eld.k.aj().optString("hook_vivo_arg", "com.android.settings");
                        if (!AbstractJsonLexerKt.NULL.equals(strOptString)) {
                            objArr[1] = strOptString;
                            return;
                        }
                        return;
                    }
                    if (!com.byazt.now.c.c()) {
                        if (com.byazt.now.c.pr()) {
                            String strOptString2 = com.byazt.eld.k.aj().optString("hook_huawei_arg1", "com.huawei.appmarket");
                            if (!AbstractJsonLexerKt.NULL.equals(strOptString2)) {
                                objArr[1] = strOptString2;
                            }
                            intent.putExtra("caller_package", com.byazt.eld.k.aj().optString("hook_huawei_arg2", "com.huawei.appmarket"));
                            return;
                        }
                        return;
                    }
                    String strOptString3 = com.byazt.eld.k.aj().optString("hook_kllk_arg1", "com." + com.byazt.mrs.c.hn + ".market");
                    if (!AbstractJsonLexerKt.NULL.equals(strOptString3)) {
                        objArr[1] = strOptString3;
                    }
                    String strOptString4 = com.byazt.eld.k.aj().optString("hook_kllk_arg2", BaseConstants.KLLK_PROMOTION_NORMAL_PKG_INFO);
                    String strOptString5 = com.byazt.eld.k.aj().optString("hook_kllk_arg3", "m.store." + com.byazt.mrs.c.hn + "mobile.com");
                    intent.putExtra(com.byazt.mrs.c.hn + "_extra_pkg_name", strOptString4);
                    intent.putExtra("refererHost", strOptString5);
                    if (com.byazt.eld.k.aj().optInt("hook_kllk_arg4", 0) == 1) {
                        Intent intent2 = new Intent();
                        intent2.putExtra(com.byazt.mrs.c.hn + "_extra_pkg_name", strOptString4);
                        intent2.putExtra("refererHost", strOptString5);
                        intent.putExtra("android.intent.extra.INTENT", intent2);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.byazt.uk.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_REUSE_SOCKET, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    private static class C0208pr implements InvocationHandler {
        public Object pr;

        private C0208pr(Object obj) {
            this.pr = obj;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                if ("startActivity".contains(method.getName())) {
                    pr.pr(objArr);
                }
            } catch (Throwable th) {
            }
            return method.invoke(this.pr, objArr);
        }
    }
}
