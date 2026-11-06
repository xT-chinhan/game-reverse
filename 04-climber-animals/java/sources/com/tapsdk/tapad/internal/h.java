package com.tapsdk.tapad.internal;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes3.dex */
public class h {
    public static boolean a(Context context, String str, String str2, String str3, int i) {
        try {
            Class<?> cls = Class.forName("com.tencent.mm.opensdk.openapi.IWXAPI");
            Class<?> cls2 = Class.forName("com.tencent.mm.opensdk.modelbase.BaseReq");
            Class<?> cls3 = Class.forName("com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram$Req");
            Object objInvoke = Class.forName("com.tencent.mm.opensdk.openapi.WXAPIFactory").getDeclaredMethod("createWXAPI", Context.class, String.class).invoke(null, context, str);
            if (objInvoke == null || !((Boolean) cls.getDeclaredMethod("isWXAppInstalled", new Class[0]).invoke(objInvoke, new Object[0])).booleanValue()) {
                return false;
            }
            cls.getDeclaredMethod("sendReq", cls2);
            Object objNewInstance = cls3.newInstance();
            cls3.getDeclaredField("userName").set(objNewInstance, str2);
            cls3.getDeclaredField("path").set(objNewInstance, str3);
            Field declaredField = cls3.getDeclaredField("miniprogramType");
            if (i > 2 || i < 0) {
                i = 0;
            }
            declaredField.setInt(objNewInstance, i);
            cls.getDeclaredMethod("sendReq", cls2).invoke(objInvoke, objNewInstance);
            return true;
        } catch (Exception e) {
            Log.e("tapadn", "launch miniProgram is error, no wechat opensdk:" + e.getMessage());
            return false;
        }
    }
}
