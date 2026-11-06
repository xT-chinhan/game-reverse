package com.bytedance.pangle.util;

import android.app.Activity;
import android.content.res.Resources;
import com.bytedance.pangle.activity.IPluginActivity;
import com.bytedance.pangle.log.ZeusLogger;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    public static void ms(com.bytedance.pangle.wrapper.ms msVar, Activity activity) {
        try {
            FieldUtils.writeField(msVar, "mTheme", (Object) null);
            FieldUtils.writeField((Object) msVar, "mThemeResource", (Object) 0);
            int[] iArrMs = ms(activity);
            if (iArrMs == null) {
                return;
            }
            for (int i : iArrMs) {
                if (i != 0) {
                    msVar.setWrapperActivityTheme(i);
                }
            }
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }

    private static int[] ms(Activity activity) {
        Resources.Theme theme = activity.getTheme();
        if (theme == null) {
            return null;
        }
        try {
            if (ny.hi()) {
                Object field = FieldUtils.readField(theme, "mThemeImpl");
                if (field == null) {
                    return null;
                }
                try {
                    Object objInvokeMethod = MethodUtils.invokeMethod(field, "getKey", new Object[0]);
                    if (objInvokeMethod != null) {
                        return (int[]) FieldUtils.readField(objInvokeMethod, "mResId");
                    }
                } catch (Exception unused) {
                }
                Object objInvoke = com.bytedance.pangle.xr.xr.ms.ms(field.getClass(), "getKey", new Class[0]).invoke(field, new Object[0]);
                if (objInvoke == null) {
                    ZeusLogger.d(ZeusLogger.TAG_ACTIVITY, "getKey failed!");
                    return null;
                }
                ZeusLogger.d(ZeusLogger.TAG_ACTIVITY, "getKey success by doubleReflector!");
                return (int[]) com.bytedance.pangle.xr.xr.ms.ms(objInvoke.getClass(), "mResId").get(objInvoke);
            }
            if (ny.xr()) {
                Object objInvokeMethod2 = MethodUtils.invokeMethod(theme, "getKey", new Object[0]);
                if (objInvokeMethod2 == null) {
                    return null;
                }
                return (int[]) FieldUtils.readField(objInvokeMethod2, "mResId");
            }
            String str = (String) MethodUtils.invokeMethod(theme, "getKey", new Object[0]);
            if (str == null) {
                return null;
            }
            String[] strArrSplit = str.trim().replace("!", "").split(" ");
            int[] iArr = new int[strArrSplit.length];
            for (int i = 0; i < strArrSplit.length; i++) {
                iArr[i] = Integer.parseInt(strArrSplit[i], 16);
            }
            return iArr;
        } catch (Throwable th) {
            ZeusLogger.d(ZeusLogger.TAG_ACTIVITY, "getKey exception!" + th.getMessage());
            return null;
        }
    }

    public static void ms(IPluginActivity iPluginActivity, Activity activity) {
        try {
            FieldUtils.writeField(iPluginActivity, "mTheme", (Object) null);
            FieldUtils.writeField((Object) iPluginActivity, "mThemeResource", (Object) 0);
            int[] iArrMs = ms(activity);
            if (iArrMs == null) {
                return;
            }
            for (int i : iArrMs) {
                if (i != 0) {
                    iPluginActivity.setProxyTheme2Plugin(i);
                }
            }
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
    }
}
