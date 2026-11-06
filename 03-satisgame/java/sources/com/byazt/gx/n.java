package com.byazt.gx;

import android.app.Activity;
import android.content.res.Resources;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.activity.IPluginActivity;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FILE_FORMAT, 19})
public class n {
    public static void n(com.byazt.uh.n nVar, Activity activity) {
        try {
            FieldUtils.writeField(nVar, "mTheme", (Object) null);
            FieldUtils.writeField((Object) nVar, "mThemeResource", (Object) 0);
            int[] iArrN = n(activity);
            if (iArrN == null) {
                return;
            }
            for (int i : iArrN) {
                if (i != 0) {
                    nVar.setWrapperActivityTheme(i);
                }
            }
        } catch (Exception e) {
            com.byazt.vx.w.n(e);
        }
    }

    private static int[] n(Activity activity) {
        Resources.Theme theme = activity.getTheme();
        if (theme == null) {
            return null;
        }
        try {
            if (rv.tj()) {
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
                Object objInvoke = com.byazt.hx.n.n(field.getClass(), "getKey", new Class[0]).invoke(field, new Object[0]);
                if (objInvoke == null) {
                    ZeusLogger.d(ZeusLogger.TAG_ACTIVITY, "getKey failed!");
                    return null;
                }
                ZeusLogger.d(ZeusLogger.TAG_ACTIVITY, "getKey success by doubleReflector!");
                return (int[]) com.byazt.hx.n.n(objInvoke.getClass(), "mResId").get(objInvoke);
            }
            if (rv.qg()) {
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

    public static void n(IPluginActivity iPluginActivity, Activity activity) {
        try {
            FieldUtils.writeField(iPluginActivity, "mTheme", (Object) null);
            FieldUtils.writeField((Object) iPluginActivity, "mThemeResource", (Object) 0);
            int[] iArrN = n(activity);
            if (iArrN == null) {
                return;
            }
            for (int i : iArrN) {
                if (i != 0) {
                    iPluginActivity.setProxyTheme2Plugin(i);
                }
            }
        } catch (Exception e) {
            com.byazt.vx.w.n(e);
        }
    }
}
