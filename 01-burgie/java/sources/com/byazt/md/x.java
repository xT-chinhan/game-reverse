package com.byazt.md;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.af.k;
import com.byazt.ca.b;
import com.byazt.ca.z;
import com.byazt.hg.of;
import com.byazt.hg.u;
import com.byazt.pj.fw;
import com.byazt.sd.a;
import com.byazt.sd.iu;
import com.byazt.sd.zo;
import com.byazt.wb.uc;
import com.byazt.wt.aj;
import com.byazt.wt.ls;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 238, 121})
public final class x {
    public static volatile x pr;
    public Object hn;
    public boolean hw;
    public AtomicBoolean x = new AtomicBoolean(false);
    public AtomicInteger c = new AtomicInteger(3);
    public AtomicBoolean uc = new AtomicBoolean(false);

    private x() {
        this.hw = false;
        try {
            Object obj = Class.forName("com.tencent.mm.opensdk.constants.Build").getDeclaredField("SDK_VERSION_NAME").get(null);
            if (obj instanceof String) {
                this.hw = "android 5.3.1".toLowerCase(Locale.ROOT).compareTo(((String) obj).toLowerCase(Locale.ROOT)) <= 0;
            }
        } catch (Throwable th) {
            this.hw = false;
        }
    }

    public boolean pr() {
        return this.hw;
    }

    public int hw() {
        return this.hw ? 1 : 0;
    }

    public static x hn() {
        if (pr == null) {
            synchronized (x.class) {
                if (pr == null) {
                    pr = new x();
                }
            }
        }
        return pr;
    }

    private void pr(String str) {
        Object objInvoke;
        Method methodPr;
        Method methodPr2;
        if (this.x.get() || this.c.getAndDecrement() <= 0) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            pr("wc_init_fail", "error_appid");
            return;
        }
        if (!x()) {
            pr("wc_init_fail", "error_no_wechat");
            return;
        }
        if (!this.hw) {
            pr("wc_init_fail", "error_no_sdk");
            return;
        }
        try {
            Method methodPr3 = z.pr("com.tencent.mm.opensdk.openapi.WXAPIFactory", "createWXAPI", Context.class, String.class);
            if (methodPr3 != null) {
                Function<SparseArray<Object>, Object> functionIe = zo.nt().ie();
                if (functionIe == null) {
                    objInvoke = null;
                } else {
                    objInvoke = functionIe.apply(com.byazt.xi.hw.pr().pr(3).pr(Context.class).hw());
                }
                if (objInvoke == null) {
                    objInvoke = a.getContext();
                }
                boolean zEquals = "oppo".equals(iu.zo);
                if (!zEquals && objInvoke == null && (methodPr2 = z.pr("com.bytedance.sdk.openadsdk.TTAppContextHolder", "getContext", new Class[0])) != null) {
                    objInvoke = methodPr2.invoke(null, new Object[0]);
                }
                if (zEquals && objInvoke == null && (methodPr = z.pr("com.bykv.vk.openvk.TTAppContextHolder", "getContext", new Class[0])) != null) {
                    objInvoke = methodPr.invoke(null, new Object[0]);
                }
                if (objInvoke != null) {
                    this.hn = methodPr3.invoke(null, objInvoke, str);
                    pr("wc_init_suc", "");
                    this.x.set(true);
                    return;
                }
                pr("wc_init_fail", "error_sdk");
            }
        } catch (Throwable th) {
            pr("wc_init_fail", "error_sdk_" + th.getMessage());
        }
    }

    private boolean x() {
        if (a.getContext() == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage("com.tencent.mm");
        if (aj.pr(intent, 0).size() > 0) {
            return true;
        }
        if (ls.b()) {
            return false;
        }
        return ls.hn("com.tencent.mm");
    }

    private void pr(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("error_message", str2);
            }
            com.byazt.xk.hw.pr().pr(str, jSONObject);
        } catch (Throwable th) {
        }
    }

    private void c() {
        com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.md.x.1
            @Override // java.lang.Runnable
            public void run() {
                b.hw(a.getContext(), "跳转微信失败。", 1, 17, 0, 0);
            }
        });
    }

    public void pr(k kVar, String str, String str2, final c.pr prVar, String str3, boolean z, Map<String, Object> map) {
        try {
            if (kVar == null) {
                prVar.pr(uc.x);
                c();
                return;
            }
            u uVarF_ = kVar.F_();
            if (uVarF_ == null) {
                pr("wc_init_fail", "wechat data is null");
                prVar.pr(uc.x);
                c();
                return;
            }
            pr(uVarF_.zo());
            if (this.hn == null) {
                prVar.pr(uc.w);
                c();
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
            } catch (Throwable th) {
                declaredField3.set(objNewInstance, 0);
            }
            Method method = this.hn.getClass().getMethod("sendReq", cls.getSuperclass());
            uVarF_.hw(2);
            of ofVarPr = com.byazt.lx.hw.pr(kVar, map);
            HashMap map2 = new HashMap();
            map2.put("source", "WeChatOpenSdkProcessor");
            com.byazt.pj.pr.pr(ofVarPr, str3, (Map<String, Object>) map2, false);
            com.byazt.pj.pr.pr(ofVarPr, str3, (Throwable) null, false, true);
            com.byazt.pj.c.pr().pr(ofVarPr, str3, z, false, new fw.pr() { // from class: com.byazt.md.x.2
                @Override // com.byazt.pj.fw.pr
                public void pr(long j) {
                    x.this.pr(false, prVar);
                }

                @Override // com.byazt.pj.fw.pr
                public void pr(String str4) {
                }

                @Override // com.byazt.pj.fw.pr
                public void pr(boolean z2) {
                    x.this.pr(true, prVar);
                }
            });
            method.invoke(this.hn, objNewInstance);
        } catch (Throwable th2) {
            pr("wc_init_fail", "invoke:" + th2.getMessage());
            prVar.pr(uc.k);
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(final boolean z, final c.pr prVar) {
        com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.md.x.3
            @Override // java.lang.Runnable
            public void run() {
                if (!z) {
                    prVar.pr(uc.zo);
                }
            }
        });
    }
}
