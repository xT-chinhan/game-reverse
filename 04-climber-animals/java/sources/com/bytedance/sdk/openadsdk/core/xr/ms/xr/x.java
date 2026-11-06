package com.bytedance.sdk.openadsdk.core.xr.ms.xr;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.component.utils.op;
import com.bytedance.sdk.component.utils.yu;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.ce;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.t.u;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class x {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile x f3791ms;
    private Object ah;
    private boolean xr;
    private AtomicBoolean d = new AtomicBoolean(false);
    private AtomicInteger ka = new AtomicInteger(3);
    private AtomicBoolean c = new AtomicBoolean(false);

    private x() {
        this.xr = false;
        try {
            Object obj = Class.forName("com.tencent.mm.opensdk.constants.Build").getDeclaredField("SDK_VERSION_NAME").get(null);
            if (obj instanceof String) {
                this.xr = "android 5.3.1".toLowerCase(Locale.ROOT).compareTo(((String) obj).toLowerCase(Locale.ROOT)) <= 0;
            }
        } catch (Throwable unused) {
            this.xr = false;
        }
    }

    public boolean ms() {
        return this.xr;
    }

    public int xr() {
        return this.xr ? 1 : 0;
    }

    public static x ah() {
        if (f3791ms == null) {
            synchronized (x.class) {
                if (f3791ms == null) {
                    f3791ms = new x();
                }
            }
        }
        return f3791ms;
    }

    private void ms(String str) {
        Method methodMs;
        if (!this.d.get() && this.ka.getAndDecrement() > 0) {
            if (TextUtils.isEmpty(str)) {
                ms("wc_init_fail", "error_appid");
                return;
            }
            if (!d()) {
                ms("wc_init_fail", "error_no_wechat");
                return;
            }
            if (!this.xr) {
                ms("wc_init_fail", "error_no_sdk");
                return;
            }
            try {
                Method methodMs2 = yu.ms("com.tencent.mm.opensdk.openapi.WXAPIFactory", "createWXAPI", Context.class, String.class);
                if (methodMs2 != null) {
                    Bridge bridgeAm = com.bytedance.sdk.openadsdk.core.ch.ub().am();
                    Object objCall = bridgeAm != null ? bridgeAm.call(3, null, Context.class) : null;
                    if (objCall == null) {
                        objCall = re.getContext();
                    }
                    if (objCall == null && (methodMs = yu.ms("com.bytedance.sdk.openadsdk.TTAppContextHolder", "getContext", new Class[0])) != null) {
                        objCall = methodMs.invoke(null, new Object[0]);
                    }
                    if (objCall == null) {
                        ms("wc_init_fail", "error_sdk");
                        return;
                    }
                    this.ah = methodMs2.invoke(null, objCall, str);
                    ms("wc_init_suc", "");
                    this.d.set(true);
                }
            } catch (Throwable th) {
                ms("wc_init_fail", "error_sdk_" + th.getMessage());
            }
        }
    }

    private boolean d() {
        Context context = re.getContext();
        if (context == null) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage("com.tencent.mm");
        if (packageManager.queryIntentActivities(intent, 0).size() > 0) {
            return true;
        }
        if (f.xr(context)) {
            return false;
        }
        return f.ms("com.tencent.mm");
    }

    private void ms(String str, String str2) {
        try {
            final com.bytedance.sdk.openadsdk.core.t.ms.xr<com.bytedance.sdk.openadsdk.core.t.ms.xr> xrVarXr = com.bytedance.sdk.openadsdk.core.t.ms.xr.xr();
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("error_message", str2);
                xrVarXr.xr(jSONObject.toString());
            }
            xrVarXr.ms(str);
            u.ms().xr(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.xr.ms.xr.x.1
                @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
                public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() {
                    return xrVarXr;
                }
            }, str);
        } catch (Throwable unused) {
        }
    }

    private void ka() {
        com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.xr.ms.xr.x.2
            @Override // java.lang.Runnable
            public void run() {
                op.xr(re.getContext(), "跳转微信失败。", 1, 17, 0, 0);
            }
        });
    }

    public void ms(lm lmVar, String str, String str2, final ch.ms msVar, String str3, boolean z) {
        try {
            if (lmVar == null) {
                msVar.xr();
                ka();
                return;
            }
            ce ceVarJs = lmVar.js();
            if (ceVarJs == null) {
                ms("wc_init_fail", "wechat data is null");
                msVar.xr();
                ka();
                return;
            }
            ms(ceVarJs.x());
            if (this.ah == null) {
                msVar.xr();
                ka();
                return;
            }
            Class<?> cls = Class.forName("com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram$Req");
            Object objNewInstance = cls.newInstance();
            Field declaredField = cls.getDeclaredField("userName");
            declaredField.setAccessible(true);
            declaredField.set(objNewInstance, str);
            Field declaredField2 = cls.getDeclaredField("path");
            declaredField2.setAccessible(true);
            declaredField2.set(objNewInstance, str2);
            Field declaredField3 = cls.getDeclaredField("miniprogramType");
            declaredField3.setAccessible(true);
            try {
                declaredField3.set(objNewInstance, cls.getDeclaredField("MINIPTOGRAM_TYPE_RELEASE").get(null));
            } catch (Throwable unused) {
                declaredField3.set(objNewInstance, 0);
            }
            Method method = this.ah.getClass().getMethod("sendReq", cls.getSuperclass());
            ceVarJs.xr(2);
            com.bytedance.sdk.openadsdk.core.zb.ah.ms(lmVar, str3, "deeplink_success_realtime", (Throwable) null);
            HashMap map = new HashMap();
            map.put("source", "WeChatOpenSdkProcessor");
            com.bytedance.sdk.openadsdk.core.zb.ah.x(lmVar, str3, "open_url_app", map);
            com.bytedance.sdk.openadsdk.core.zb.c.ms().ms(lmVar, str3, z);
            method.invoke(this.ah, objNewInstance);
            com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.xr.ms.xr.x.3
                @Override // java.lang.Runnable
                public void run() {
                    msVar.ms();
                }
            });
        } catch (Throwable th) {
            ms("wc_init_fail", "invoke:" + th.getMessage());
            msVar.xr();
            ka();
        }
    }
}
