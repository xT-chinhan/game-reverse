package com.byazt.soz;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.gct.pk;
import com.byazt.gct.wv;
import com.byazt.llp.d;
import com.byazt.nf.rv;
import com.byazt.nf.tj;
import com.byazt.tk.h;
import com.byazt.tk.hu;
import com.byazt.vgx.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
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
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_STREAM_INFO, 5})
public final class q {
    public static volatile q n;
    public boolean qg;
    public Object s;
    public AtomicBoolean q = new AtomicBoolean(false);
    public AtomicInteger l = new AtomicInteger(3);
    public AtomicBoolean w = new AtomicBoolean(false);

    private q() {
        this.qg = false;
        try {
            Object obj = Class.forName("com.tencent.mm.opensdk.constants.Build").getDeclaredField("SDK_VERSION_NAME").get(null);
            if (obj instanceof String) {
                this.qg = "android 5.3.1".toLowerCase(Locale.ROOT).compareTo(((String) obj).toLowerCase(Locale.ROOT)) <= 0;
            }
        } catch (Throwable unused) {
            this.qg = false;
        }
    }

    public boolean n() {
        return this.qg;
    }

    public int qg() {
        return this.qg ? 1 : 0;
    }

    public static q s() {
        if (n == null) {
            synchronized (q.class) {
                if (n == null) {
                    n = new q();
                }
            }
        }
        return n;
    }

    private void n(String str) {
        Method methodN;
        Method methodN2;
        if (!this.q.get() && this.l.getAndDecrement() > 0) {
            if (TextUtils.isEmpty(str)) {
                n("wc_init_fail", "error_appid");
                return;
            }
            if (!q()) {
                n("wc_init_fail", "error_no_wechat");
                return;
            }
            if (!this.qg) {
                n("wc_init_fail", "error_no_sdk");
                return;
            }
            try {
                Method methodN3 = hu.n("com.tencent.mm.opensdk.openapi.WXAPIFactory", "createWXAPI", Context.class, String.class);
                if (methodN3 != null) {
                    Function<SparseArray<Object>, Object> functionB = com.byazt.vyf.s.cy().b();
                    Object objApply = functionB != null ? functionB.apply(com.byazt.of.qg.n().n(3).n(Context.class).qg()) : null;
                    if (objApply == null) {
                        objApply = rv.getContext();
                    }
                    boolean zEquals = "oppo".equals(tj.rv);
                    if (!zEquals && objApply == null && (methodN2 = hu.n("com.bytedance.sdk.openadsdk.TTAppContextHolder", "getContext", new Class[0])) != null) {
                        objApply = methodN2.invoke(null, new Object[0]);
                    }
                    if (zEquals && objApply == null && (methodN = hu.n("com.bykv.vk.openvk.TTAppContextHolder", "getContext", new Class[0])) != null) {
                        objApply = methodN.invoke(null, new Object[0]);
                    }
                    if (objApply == null) {
                        n("wc_init_fail", "error_sdk");
                        return;
                    }
                    this.s = methodN3.invoke(null, objApply, str);
                    n("wc_init_suc", "");
                    this.q.set(true);
                }
            } catch (Throwable th) {
                n("wc_init_fail", "error_sdk_" + th.getMessage());
            }
        }
    }

    private boolean q() {
        if (rv.getContext() == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage("com.tencent.mm");
        if (com.byazt.ehw.n.n(intent, 0).size() > 0) {
            return true;
        }
        if (w.h()) {
            return false;
        }
        return w.s("com.tencent.mm");
    }

    private void n(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("error_message", str2);
            }
            com.byazt.eji.s.n().n(str, jSONObject);
        } catch (Throwable unused) {
        }
    }

    private void l() {
        com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.soz.q.1
            @Override // java.lang.Runnable
            public void run() {
                h.qg(rv.getContext(), "跳转微信失败。", 1, 17, 0, 0);
            }
        });
    }

    public void n(d dVar, String str, String str2, final l.n nVar, String str3, boolean z, Map<String, Object> map) {
        try {
            if (dVar == null) {
                nVar.n(com.byazt.wr.w.q);
                l();
                return;
            }
            wv wvVarJ_ = dVar.J_();
            if (wvVarJ_ == null) {
                n("wc_init_fail", "wechat data is null");
                nVar.n(com.byazt.wr.w.q);
                l();
                return;
            }
            n(wvVarJ_.fs());
            if (this.s == null) {
                nVar.n(com.byazt.wr.w.cp);
                l();
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
            Method method = this.s.getClass().getMethod("sendReq", cls.getSuperclass());
            wvVarJ_.qg(2);
            pk pkVarN = com.byazt.ukb.qg.n(dVar, map);
            HashMap map2 = new HashMap();
            map2.put("source", "WeChatOpenSdkProcessor");
            com.byazt.hm.n.n(pkVarN, str3, (Map<String, Object>) map2, false);
            com.byazt.hm.n.n(pkVarN, str3, (Throwable) null, false, true);
            com.byazt.hm.l.n().n(pkVarN, str3, z, false, new com.byazt.okk.qg.n() { // from class: com.byazt.soz.q.2
                @Override // com.byazt.okk.qg.n
                public void n(String str4) {
                }

                @Override // com.byazt.okk.qg.n
                public void n(long j) {
                    q.this.n(false, nVar);
                }

                @Override // com.byazt.okk.qg.n
                public void n(boolean z2) {
                    q.this.n(true, nVar);
                }
            });
            method.invoke(this.s, objNewInstance);
        } catch (Throwable th) {
            n("wc_init_fail", "invoke:" + th.getMessage());
            nVar.n(com.byazt.wr.w.d);
            l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final boolean z, final l.n nVar) {
        com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.soz.q.3
            @Override // java.lang.Runnable
            public void run() {
                if (z) {
                    nVar.n();
                } else {
                    nVar.n(com.byazt.wr.w.fs);
                }
            }
        });
    }
}
