package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import android.view.View;
import android.webkit.JavascriptInterface;
import androidx.core.app.NotificationCompat;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.nw.ce;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.umeng.analytics.pro.ek;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class pc implements com.bytedance.sdk.component.adexpress.ka.xr, com.bytedance.sdk.component.utils.le.ms, com.bytedance.sdk.openadsdk.core.ao.xr {
    private static final Map<String, Boolean> ah;
    private static volatile boolean l;
    private com.bytedance.sdk.openadsdk.core.ao.ah ab;
    private AtomicBoolean am;
    private boolean az;
    private WeakReference<com.bytedance.sdk.openadsdk.core.qv.d> b;
    private final WeakReference<Context> c;
    private String ch;
    private WeakReference<SSWebView> d;
    private com.bytedance.sdk.openadsdk.core.ugeno.xr eg;
    private JSONObject fm;
    private SoftReference<com.bytedance.sdk.component.adexpress.xr.hi> h;
    private int hi;
    private JSONObject i;
    private WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.ab.xr> il;
    private com.bytedance.sdk.openadsdk.core.widget.ms.ms jw;
    private com.bytedance.sdk.openadsdk.core.widget.ab.ms k;
    private HashMap<String, hi> le;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected Map<String, Object> f3256ms;
    private WeakReference<com.bytedance.sdk.openadsdk.core.qv.ms> nw;
    private WeakReference<View> ny;
    private com.bytedance.sdk.openadsdk.c.ms of;
    private List<lm> op;
    private com.bytedance.sdk.component.ms.h p;
    private String pc;
    private WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ny> qf;
    private WeakReference<com.bytedance.sdk.openadsdk.ch.ms> re;
    private WeakReference<com.bytedance.sdk.openadsdk.core.qv.ka> sa;
    private String sl;
    private WeakReference<com.bytedance.sdk.openadsdk.core.ao.d> t;
    private boolean ul;
    private WeakReference<com.bytedance.sdk.openadsdk.core.qv.xr> w;
    private String x;
    private List<JSONObject> xn;
    private JSONObject y;
    private WeakReference<com.bytedance.sdk.openadsdk.core.qv.c> yu;
    private lm zb;
    boolean xr = false;
    private boolean u = false;
    private boolean ub = true;
    private boolean ao = true;
    private final com.bytedance.sdk.openadsdk.core.nativeexpress.sl qv = new com.bytedance.sdk.openadsdk.core.nativeexpress.sl();
    private boolean cv = false;
    private boolean g = false;
    private boolean f = false;
    private boolean m = false;
    private boolean lm = false;
    private boolean e = false;
    private com.bytedance.sdk.component.utils.le ka = new com.bytedance.sdk.component.utils.le(Looper.getMainLooper(), this);

    public static class ms {
        public String ah;
        public JSONObject d;
        public int ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public String f3269ms;
        public String xr;
    }

    @Override // com.bytedance.sdk.component.adexpress.ka.xr
    @JavascriptInterface
    public void adAnalysisData(String str) {
    }

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        ah = concurrentHashMap;
        concurrentHashMap.put("log_event", Boolean.TRUE);
        concurrentHashMap.put("private", Boolean.TRUE);
        concurrentHashMap.put("dispatch_message", Boolean.TRUE);
        concurrentHashMap.put("custom_event", Boolean.TRUE);
        concurrentHashMap.put("log_event_v3", Boolean.TRUE);
        l = false;
    }

    public pc(Context context) {
        this.c = new WeakReference<>(context);
        com.bytedance.sdk.openadsdk.ms.ah.ah.ms();
    }

    public Context getContext() {
        return this.c.get();
    }

    public static JSONArray ms(List<lm> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null) {
            return jSONArray;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(list.get(i).rm());
        }
        return jSONArray;
    }

    public pc ms(String str) {
        this.pc = str;
        return this;
    }

    public pc ms(boolean z) {
        this.m = z;
        return this;
    }

    public pc ms(SSWebView sSWebView) {
        com.bytedance.sdk.component.utils.sl.d("webviewpool", "===useJsb2 webView hashCode:" + sSWebView.hashCode());
        if (sSWebView == null) {
            return this;
        }
        com.bytedance.sdk.component.ms.h hVarXr = com.bytedance.sdk.component.ms.h.ms(sSWebView).ms(new com.bytedance.sdk.openadsdk.ny.ms()).ms("ToutiaoJSBridge").ms(new com.bytedance.sdk.component.ms.sl() { // from class: com.bytedance.sdk.openadsdk.core.pc.1
            @Override // com.bytedance.sdk.component.ms.sl
            public <T> T ms(String str, Type type) {
                return null;
            }

            @Override // com.bytedance.sdk.component.ms.sl
            public <T> String ms(T t) {
                return null;
            }
        }).ms(ch.ub().fm()).xr(true).ms().xr();
        this.p = hVarXr;
        com.bytedance.sdk.openadsdk.core.h.ms.t.ms(hVarXr, this);
        com.bytedance.sdk.openadsdk.core.h.ms.ka.ms(this.p, this);
        com.bytedance.sdk.openadsdk.core.h.ms.c.ms(this.p, this, this.zb);
        com.bytedance.sdk.openadsdk.core.h.ms.u.ms(this.p);
        com.bytedance.sdk.openadsdk.core.h.ms.re.ms(this.p, sSWebView);
        com.bytedance.sdk.openadsdk.core.h.ms.ab.ms(this.p, this);
        com.bytedance.sdk.openadsdk.core.h.ms.hi.ms(this.p, this);
        com.bytedance.sdk.openadsdk.core.h.ms.p.ms(this.p, this);
        com.bytedance.sdk.openadsdk.ny.ms.d.ms(this.p, this);
        com.bytedance.sdk.openadsdk.core.h.ms.qv.ms(this.p, this);
        com.bytedance.sdk.openadsdk.core.h.ms.h.ms(this.p, this);
        com.bytedance.sdk.openadsdk.ny.ms.ah.ms(this.p, this);
        com.bytedance.sdk.openadsdk.ny.ms.ms.ms(this.p, this);
        com.bytedance.sdk.openadsdk.ny.ms.ka.ms(this.p, this);
        com.bytedance.sdk.openadsdk.ny.ms.c.ms(this.p, this);
        com.bytedance.sdk.openadsdk.ny.ms.xr.ms(this.p, this);
        jw();
        com.bytedance.sdk.openadsdk.core.h.ms.ah.ms(this.p, this.d.get(), this.x);
        com.bytedance.sdk.openadsdk.core.h.ms.w.ms(this.p, this.d.get(), this.x);
        com.bytedance.sdk.openadsdk.core.h.ms.xr.ms(this.p, this.d.get(), this.x);
        com.bytedance.sdk.openadsdk.core.h.ms.i.ms(this.p, this.d.get(), this.x);
        com.bytedance.sdk.openadsdk.core.h.ms.cv.ms(this.p, this);
        com.bytedance.sdk.openadsdk.core.h.ms.y.ms(this.p, this);
        com.bytedance.sdk.openadsdk.core.h.ms.of.ms(this.p, this);
        com.bytedance.sdk.openadsdk.core.h.ms.ao.ms(this.p, this);
        com.bytedance.sdk.openadsdk.core.h.ms.ub.ms(this.p, this.zb);
        com.bytedance.sdk.openadsdk.core.h.ms.nw.ms(this.p, this.c.get(), this.zb);
        com.bytedance.sdk.openadsdk.core.h.ms.ch.ms(this.p, this.zb, this.xn);
        com.bytedance.sdk.openadsdk.core.h.ms.b.ms(this.p, this, this.il);
        com.bytedance.sdk.openadsdk.core.h.ms.le.ms(this.p, this, this.il);
        com.bytedance.sdk.openadsdk.core.h.ms.f.ms(this.p, sSWebView, this);
        com.bytedance.sdk.openadsdk.core.h.ms.ny.ms(this.p, this.zb, this);
        com.bytedance.sdk.openadsdk.core.h.ms.zb.ms(this.p, this.zb, this);
        com.bytedance.sdk.openadsdk.core.h.ms.jw.ms(this.p, this.k);
        com.bytedance.sdk.openadsdk.core.h.ms.pc.ms(this.p, this);
        com.bytedance.sdk.openadsdk.core.h.ms.yu.ms(this.p, this.eg);
        com.bytedance.sdk.openadsdk.core.h.ms.op.ms(this.p, this, this.zb);
        com.bytedance.sdk.openadsdk.core.h.ms.sl.ms(this.p, this.y);
        com.bytedance.sdk.openadsdk.core.h.ms.x.ms(this.p, this.zb, this);
        com.bytedance.sdk.openadsdk.core.h.ms.ms.ms(this.p, this.c.get());
        com.bytedance.sdk.openadsdk.core.h.ms.g.ms(this.p, this.zb);
        com.bytedance.sdk.openadsdk.core.h.ms.d.ms(this.p, this);
        return this;
    }

    private void jw() {
        lm lmVar;
        WeakReference<SSWebView> weakReference = this.d;
        if (weakReference == null || weakReference.get() == null || (lmVar = this.zb) == null) {
            return;
        }
        int iOn = lmVar.on();
        int iIw = this.zb.iw();
        int iIa = this.zb.ia();
        int iN = this.zb.n();
        int iEc = this.zb.ec();
        JSONObject jSONObjectAx = this.zb.ax();
        JSONObject jSONObjectWr = this.zb.wr();
        JSONObject jSONObjectRg = this.zb.rg();
        this.d.get().setShakeValue(iOn);
        this.d.get().setDeepShakeValue(iIw);
        this.d.get().setWriggleValue(iIa);
        this.d.get().setTwistConfig(jSONObjectAx);
        this.d.get().setShakeInteractConf(jSONObjectWr);
        this.d.get().setTwistInteractConf(jSONObjectRg);
        this.d.get().setCalculationMethod(iN);
        this.d.get().setCalculationTwistMethod(iEc);
    }

    public JSONObject ms() {
        WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ny> weakReference = this.qf;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.qf.get().getContainerInfo();
    }

    public JSONObject xr() {
        WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ny> weakReference = this.qf;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.qf.get().getCreativeVideoViewInfo();
    }

    public void ms(SSWebView.xr xrVar) {
        WeakReference<SSWebView> weakReference = this.d;
        if (weakReference == null || weakReference.get() == null || xrVar == null) {
            return;
        }
        this.d.get().setOnShakeListener(xrVar);
    }

    public pc ms(com.bytedance.sdk.openadsdk.core.ugeno.ab.xr xrVar) {
        this.il = new WeakReference<>(xrVar);
        return this;
    }

    public pc ms(com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ny nyVar) {
        this.qf = new WeakReference<>(nyVar);
        return this;
    }

    public com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ny ah() {
        WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ny> weakReference = this.qf;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public boolean d() {
        WeakReference<SSWebView> weakReference = this.d;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        return this.d.get().I_();
    }

    public static void xr(boolean z) {
        l = z;
    }

    public void ms(int i) {
        if (l) {
            com.bytedance.sdk.component.utils.sl.xr("TTAndroidObject", "blocked Twist");
            return;
        }
        if (i != 1) {
            if (i == 2) {
                ms("twist_callback", (JSONObject) null);
            }
        } else {
            if (this.zb != null && d()) {
                com.bytedance.sdk.openadsdk.core.hi.ah.ah.c.d = true;
            }
            ms("wobble_callback", (JSONObject) null);
        }
    }

    public void ah(boolean z) {
        this.ul = z;
    }

    public void d(boolean z) {
        this.az = z;
    }

    public int ka(boolean z) {
        if (com.bytedance.sdk.openadsdk.core.nw.p.ms(this.zb) != 0 && z) {
            return 2;
        }
        if (this.ul) {
            return 1;
        }
        if (this.az) {
            return com.bytedance.sdk.openadsdk.core.nw.p.ms(this.zb) == 2 ? 2 : 1;
        }
        return com.bytedance.sdk.openadsdk.core.nw.p.ms(this.zb) == 0 ? 1 : 2;
    }

    public void ka() {
        com.bytedance.sdk.component.ms.h hVar = this.p;
        if (hVar == null) {
            return;
        }
        hVar.ms();
        this.p = null;
    }

    public com.bytedance.sdk.component.ms.h c() {
        return this.p;
    }

    private com.bytedance.sdk.component.zb.ah f() {
        WeakReference<SSWebView> weakReference = this.d;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public pc xr(SSWebView sSWebView) {
        this.d = new WeakReference<>(sSWebView);
        return this;
    }

    public pc ms(com.bytedance.sdk.openadsdk.c.ms msVar) {
        this.of = msVar;
        return this;
    }

    public pc c(boolean z) {
        this.g = z;
        return this;
    }

    public pc xr(String str) {
        this.x = str;
        return this;
    }

    public pc ms(View view) {
        this.ny = new WeakReference<>(view);
        return this;
    }

    public pc xr(List<JSONObject> list) {
        this.xn = list;
        return this;
    }

    public pc xr(int i) {
        this.u = true;
        return this;
    }

    public boolean ab() {
        return this.lm;
    }

    public void ab(boolean z) {
        this.lm = z;
    }

    public void x(boolean z) {
        this.e = z;
    }

    private JSONObject ul() {
        try {
            View view = this.ny.get();
            SSWebView sSWebView = this.d.get();
            if (view == null || sSWebView == null) {
                com.bytedance.sdk.component.utils.sl.d("TTAndroidObject", "setCloseButtonInfo error closeButton is null");
                return null;
            }
            int[] iArrXr = com.bytedance.sdk.openadsdk.core.jw.ul.xr(view);
            int[] iArrXr2 = com.bytedance.sdk.openadsdk.core.jw.ul.xr(sSWebView);
            if (iArrXr != null && iArrXr2 != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", com.bytedance.sdk.openadsdk.core.jw.ul.d(re.getContext(), iArrXr[0] - iArrXr2[0]));
                jSONObject.put("y", com.bytedance.sdk.openadsdk.core.jw.ul.d(re.getContext(), iArrXr[1] - iArrXr2[1]));
                jSONObject.put(IAdInterListener.AdReqParam.WIDTH, com.bytedance.sdk.openadsdk.core.jw.ul.d(re.getContext(), view.getWidth()));
                jSONObject.put("h", com.bytedance.sdk.openadsdk.core.jw.ul.d(re.getContext(), view.getHeight()));
                jSONObject.put("isExist", true);
                return jSONObject;
            }
            com.bytedance.sdk.component.utils.sl.d("TTAndroidObject", "setCloseButtonInfo error position or webViewPosition is null");
            return null;
        } catch (Throwable unused) {
        }
    }

    public pc ms(com.bytedance.sdk.openadsdk.core.qv.xr xrVar) {
        this.w = new WeakReference<>(xrVar);
        return this;
    }

    public pc ms(com.bytedance.sdk.openadsdk.core.qv.c cVar) {
        this.yu = new WeakReference<>(cVar);
        return this;
    }

    public lm x() {
        return this.zb;
    }

    public pc ms(lm lmVar) {
        this.zb = lmVar;
        return this;
    }

    public boolean ny() {
        lm lmVar = this.zb;
        return lmVar != null && lmVar.il();
    }

    public pc ah(String str) {
        this.ch = str;
        return this;
    }

    public pc ah(int i) {
        this.hi = i;
        return this;
    }

    public pc d(String str) {
        this.sl = str;
        return this;
    }

    public pc ms(com.bytedance.sdk.component.adexpress.xr.hi hiVar) {
        this.h = new SoftReference<>(hiVar);
        return this;
    }

    public pc ms(com.bytedance.sdk.openadsdk.core.nativeexpress.hi hiVar) {
        this.qv.ms(hiVar);
        return this;
    }

    public pc ms(com.bytedance.sdk.openadsdk.core.ao.d dVar) {
        this.t = new WeakReference<>(dVar);
        return this;
    }

    public pc ms(JSONObject jSONObject) {
        this.i = jSONObject;
        return this;
    }

    public pc ms(Map<String, Object> map) {
        this.f3256ms = map;
        return this;
    }

    public pc ms(com.bytedance.sdk.openadsdk.core.qv.ms msVar) {
        this.nw = new WeakReference<>(msVar);
        return this;
    }

    public pc ms(com.bytedance.sdk.openadsdk.core.qv.d dVar) {
        this.b = new WeakReference<>(dVar);
        return this;
    }

    public pc ms(com.bytedance.sdk.openadsdk.ch.ms msVar) {
        this.re = new WeakReference<>(msVar);
        return this;
    }

    public pc ah(List<lm> list) {
        this.op = list;
        return this;
    }

    public boolean ch() {
        return this.xr;
    }

    public void ny(boolean z) {
        this.xr = z;
    }

    public void ms(com.bytedance.sdk.openadsdk.core.widget.ab.ms msVar) {
        this.k = msVar;
    }

    public void ms(com.bytedance.sdk.openadsdk.core.ugeno.xr xrVar) {
        this.eg = xrVar;
    }

    public void xr(JSONObject jSONObject) {
        this.fm = jSONObject;
    }

    public JSONObject hi() {
        return this.fm;
    }

    private static List<String> az() {
        return Arrays.asList("appInfo", "adInfo", "getTemplateInfo", "getTeMaiAds");
    }

    public static void ah(JSONObject jSONObject) throws Exception {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = az().iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        jSONObject.put("appName", com.bytedance.sdk.openadsdk.core.x.ms.ms());
        jSONObject.put("innerAppName", com.bytedance.sdk.openadsdk.core.x.ms.ka());
        jSONObject.put("aid", com.bytedance.sdk.openadsdk.core.x.ms.xr());
        jSONObject.put("sdkEdition", com.bytedance.sdk.openadsdk.core.x.ms.ah());
        jSONObject.put("appVersion", com.bytedance.sdk.openadsdk.core.x.ms.d());
        jSONObject.put("netType", com.bytedance.sdk.openadsdk.core.x.ms.c());
        jSONObject.put("supportList", jSONArray);
        jSONObject.put("deviceId", com.bytedance.sdk.openadsdk.core.x.ms.ab());
        jSONObject.put("themeStatus", ch.ub().l());
    }

    public void d(JSONObject jSONObject) throws Exception {
        if (!TextUtils.isEmpty(this.x)) {
            jSONObject.put("cid", this.x);
        }
        if (!TextUtils.isEmpty(this.ch)) {
            jSONObject.put("log_extra", this.ch);
        }
        if (!TextUtils.isEmpty(this.sl)) {
            jSONObject.put("download_url", this.sl);
        }
        lm lmVar = this.zb;
        if (lmVar != null) {
            jSONObject.put("isDirectDownload", lmVar.ub());
        }
        if (com.bytedance.sdk.openadsdk.core.nw.t.hi(this.zb)) {
            jSONObject.put("voice_btn_position", com.bytedance.sdk.openadsdk.core.nw.t.ub(this.zb));
        }
    }

    /* JADX WARN: Code duplicated, block: B:163:0x0264 A[PHI: r3
      0x0264: PHI (r3v22 org.json.JSONObject) = (r3v17 org.json.JSONObject), (r3v23 org.json.JSONObject) binds: [B:162:0x0262, B:151:0x0234] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public JSONObject ms(ms msVar, int i) throws Exception {
        byte b;
        Context context;
        JSONObject jSONObjectUl;
        if (!NotificationCompat.CATEGORY_CALL.equals(msVar.f3269ms)) {
            return null;
        }
        ch.ub().fm();
        JSONObject jSONObject = new JSONObject();
        String str = msVar.ah;
        str.hashCode();
        switch (str.hashCode()) {
            case -2036781162:
                b = !str.equals("subscribe_app_ad") ? (byte) -1 : (byte) 0;
                break;
            case -1752549500:
                b = !str.equals("adInfoStash") ? (byte) -1 : (byte) 1;
                break;
            case -1423303823:
                b = !str.equals("adInfo") ? (byte) -1 : (byte) 2;
                break;
            case -1330994877:
                b = !str.equals("pauseWebView") ? (byte) -1 : (byte) 3;
                break;
            case -1169135450:
                b = !str.equals("changeVideoState") ? (byte) -1 : (byte) 4;
                break;
            case -844321441:
                b = !str.equals("webview_time_track") ? (byte) -1 : (byte) 5;
                break;
            case -800853518:
                b = !str.equals("clickEvent") ? (byte) -1 : (byte) 6;
                break;
            case -794273169:
                b = !str.equals("appInfo") ? (byte) -1 : (byte) 7;
                break;
            case -715147645:
                b = !str.equals("getScreenSize") ? (byte) -1 : (byte) 8;
                break;
            case -489318846:
                b = !str.equals("getMaterialMeta") ? (byte) -1 : (byte) 9;
                break;
            case -278382602:
                b = !str.equals("send_temai_product_ids") ? (byte) -1 : (byte) 10;
                break;
            case -173752734:
                b = !str.equals("getTeMaiAds") ? (byte) -1 : (byte) 11;
                break;
            case 27837080:
                b = !str.equals("download_app_ad") ? (byte) -1 : (byte) 12;
                break;
            case 105049135:
                b = !str.equals("unsubscribe_app_ad") ? (byte) -1 : ek.k;
                break;
            case 352242576:
                b = !str.equals("getDownloadStatus") ? (byte) -1 : ek.l;
                break;
            case 399543522:
                b = !str.equals("getCloseButtonInfo") ? (byte) -1 : ek.m;
                break;
            case 402955465:
                b = !str.equals("isViewable") ? (byte) -1 : ek.n;
                break;
            case 442647767:
                b = !str.equals("sendReward") ? (byte) -1 : (byte) 17;
                break;
            case 571273292:
                b = !str.equals("dynamicTrack") ? (byte) -1 : (byte) 18;
                break;
            case 650209982:
                b = !str.equals("getTemplateInfo") ? (byte) -1 : (byte) 19;
                break;
            case 672928467:
                b = !str.equals("cancel_download_app_ad") ? (byte) -1 : (byte) 20;
                break;
            case 711635577:
                b = !str.equals("getCurrentVideoState") ? (byte) -1 : (byte) 21;
                break;
            case 885131792:
                b = !str.equals("getVolume") ? (byte) -1 : (byte) 22;
                break;
            case 1107374321:
                b = !str.equals("pauseWebViewTimers") ? (byte) -1 : (byte) 23;
                break;
            case 1151744482:
                b = !str.equals("muteVideo") ? (byte) -1 : (byte) 24;
                break;
            case 1237100796:
                b = !str.equals("renderDidFinish") ? (byte) -1 : (byte) 25;
                break;
            case 1634511418:
                b = !str.equals("endcard_load") ? (byte) -1 : (byte) 26;
                break;
            case 1713585602:
                b = !str.equals("getNetworkData") ? (byte) -1 : (byte) 27;
                break;
            case 2086000188:
                b = !str.equals("skipVideo") ? (byte) -1 : (byte) 28;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                xn();
                WeakReference<Context> weakReference = this.c;
                if (weakReference != null && (context = weakReference.get()) != null) {
                    this.ab.ms(context, msVar.d, this.ch, this.hi, this.u, this.e);
                }
                break;
            case 1:
                ub(msVar.d);
                break;
            case 2:
                d(jSONObject);
                break;
            case 3:
                m();
                break;
            case 4:
                x(msVar.d);
                break;
            case 5:
                ka(msVar.d);
                break;
            case 6:
                hi(msVar.d);
                break;
            case 7:
                ah(jSONObject);
                break;
            case 8:
                WeakReference<com.bytedance.sdk.openadsdk.core.qv.ms> weakReference2 = this.nw;
                com.bytedance.sdk.openadsdk.core.qv.ms msVar2 = weakReference2 != null ? weakReference2.get() : null;
                if (msVar2 != null) {
                    int iXr = msVar2.xr();
                    int iMs = msVar2.ms();
                    jSONObject.put("width", iXr);
                    jSONObject.put("height", iMs);
                }
                break;
            case 9:
                u(jSONObject);
                break;
            case 10:
                y(msVar.d);
                break;
            case 11:
                jSONObjectUl = this.i;
                if (jSONObjectUl != null) {
                    jSONObject = jSONObjectUl;
                }
                break;
            case 12:
                ch(true);
                ms(msVar.d, msVar.d != null ? msVar.d.optBoolean("is_compliant_download") : false);
                break;
            case 13:
                com.bytedance.sdk.openadsdk.core.ao.ah ahVar = this.ab;
                if (ahVar != null) {
                    ahVar.ms(msVar.d);
                }
                break;
            case 14:
                jSONObject = com.bytedance.sdk.openadsdk.core.h.ms.u.ms(msVar.d);
                break;
            case 15:
                jSONObjectUl = ul();
                if (jSONObjectUl != null) {
                    jSONObject = jSONObjectUl;
                }
                break;
            case 16:
                jSONObject.put("viewStatus", this.g ? 1 : 0);
                break;
            case 17:
                this.xr = true;
                WeakReference<com.bytedance.sdk.openadsdk.core.qv.d> weakReference3 = this.b;
                if (weakReference3 != null && weakReference3.get() != null) {
                    this.b.get().ms();
                }
                break;
            case 18:
                zb(msVar.d);
                break;
            case 19:
                sl();
                jSONObject = this.y;
                break;
            case 20:
                com.bytedance.sdk.openadsdk.core.ao.ah ahVar2 = this.ab;
                if (ahVar2 != null) {
                    ahVar2.xr(msVar.d);
                }
                break;
            case 21:
                h(jSONObject);
                break;
            case 22:
                AudioManager audioManager = (AudioManager) re.getContext().getSystemService("audio");
                jSONObject.put("endcard_mute", (audioManager != null ? audioManager.getStreamVolume(3) : -1) <= 0);
                break;
            case 23:
                lm();
                break;
            case 24:
                ab(msVar.d);
                break;
            case 25:
                sl(msVar.d);
                break;
            case 26:
                ao(msVar.d);
                break;
            case 27:
                ms(msVar, jSONObject);
                break;
            case 28:
                zb();
                break;
        }
        if (i == 1 && !TextUtils.isEmpty(msVar.xr)) {
            ah(msVar.xr, jSONObject);
            ch.ub().fm();
        }
        return jSONObject;
    }

    public void ka(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.c.ms msVar;
        if (jSONObject == null || (msVar = this.of) == null) {
            return;
        }
        msVar.ah(jSONObject);
    }

    private void xr(String str, boolean z) {
        if (this.of == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (z) {
            this.of.c(str);
        } else {
            this.of.ab(str);
        }
    }

    private void m() {
        WeakReference<com.bytedance.sdk.openadsdk.core.qv.c> weakReference = this.yu;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.yu.get().ms();
    }

    private void lm() {
        WeakReference<com.bytedance.sdk.openadsdk.core.qv.c> weakReference = this.yu;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.yu.get().xr();
    }

    private void ao(JSONObject jSONObject) {
        WeakReference<com.bytedance.sdk.openadsdk.core.qv.xr> weakReference = this.w;
        if (weakReference == null || jSONObject == null || weakReference.get() == null) {
            return;
        }
        this.w.get().ms(jSONObject.optBoolean("isRenderSuc", false), jSONObject.optInt("code", -1), jSONObject.optString("msg", ""));
    }

    @Override // com.bytedance.sdk.component.adexpress.ka.xr
    @JavascriptInterface
    public String adInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            d(jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.component.adexpress.ka.xr
    @JavascriptInterface
    public String appInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            ah(jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.component.adexpress.ka.xr
    @JavascriptInterface
    public String getTemplateInfo() {
        xr("getTemplateInfo", true);
        try {
            sl();
            xr("getTemplateInfo", false);
            return this.y.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public pc c(JSONObject jSONObject) {
        this.y = jSONObject;
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x000e A[Catch: Exception -> 0x0022, TRY_LEAVE, TryCatch #0 {Exception -> 0x0022, blocks: (B:4:0x0004, B:5:0x000a, B:7:0x000e), top: B:11:0x0004 }] */
    public JSONObject sl() {
        JSONObject jSONObject = this.y;
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
                if (this.zb != null) {
                    jSONObject.put("setting", e());
                    jSONObject.put("extension", this.zb.uc());
                }
            } catch (Exception unused) {
            }
        } else if (this.zb != null) {
            jSONObject.put("setting", e());
            jSONObject.put("extension", this.zb.uc());
        }
        this.y = jSONObject;
        return jSONObject;
    }

    @Override // com.bytedance.sdk.component.adexpress.ka.xr
    @JavascriptInterface
    public void renderDidFinish(String str) {
        try {
            sl(new JSONObject(str));
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ka.xr
    @JavascriptInterface
    public void muteVideo(final String str) {
        com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.pc.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    pc.this.ab(new JSONObject(str));
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.sl.ms(e);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.ka.xr
    @JavascriptInterface
    public void dynamicTrack(String str) {
        try {
            zb(new JSONObject(str));
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ka.xr
    @JavascriptInterface
    public void changeVideoState(final String str) {
        com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.pc.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    pc.this.x(new JSONObject(str));
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.sl.ms(e);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.ka.xr
    @JavascriptInterface
    public void clickEvent(final String str) {
        com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.pc.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    pc.this.hi(new JSONObject(str));
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.sl.ms(e);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.ka.xr
    @JavascriptInterface
    public void skipVideo() {
        com.bytedance.sdk.openadsdk.core.t.u.ms().ah(this.zb, "stats_reward_full_call_skip_video");
        com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.pc.8
            @Override // java.lang.Runnable
            public void run() {
                pc.this.zb();
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.ka.xr
    @JavascriptInterface
    public String getCurrentVideoState() {
        JSONObject jSONObject = new JSONObject();
        h(jSONObject);
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.component.adexpress.ka.xr
    @JavascriptInterface
    public void initRenderFinish() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.pc.9
            @Override // java.lang.Runnable
            public void run() {
                if (pc.this.jw != null) {
                    com.bytedance.sdk.openadsdk.core.widget.ms.ms unused = pc.this.jw;
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.ka.xr
    @JavascriptInterface
    public void requestPauseVideo(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.qv.ms(jSONObject.optInt("time"), jSONObject.optString("flag"));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("state_type", 2);
            jSONObject2.put("jsb_name", "requestPauseVideo");
            com.bytedance.sdk.openadsdk.core.t.u.ms().ms(this.zb, jSONObject2);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ka.xr
    @JavascriptInterface
    public String getData(String str) {
        if (TextUtils.isEmpty(str)) {
            return this.y.toString();
        }
        try {
            JSONObject jSONObjectMs = com.bytedance.sdk.openadsdk.core.nativeexpress.xr.xr.ms(this.y, new JSONObject(str));
            if (jSONObjectMs == null) {
                return this.y.toString();
            }
            return jSONObjectMs.toString();
        } catch (Exception unused) {
            return this.y.toString();
        }
    }

    public void zb() {
        com.bytedance.sdk.openadsdk.core.t.u.ms().ah(this.zb, "stats_reward_full_deal_skip_video");
        this.qv.ab();
    }

    public void u() {
        this.qv.x();
    }

    public void ab(JSONObject jSONObject) {
        if (this.qv.sl() == null || jSONObject == null) {
            return;
        }
        try {
            this.qv.sl().ms(jSONObject.optBoolean("mute", false));
        } catch (Exception unused) {
        }
    }

    public void x(JSONObject jSONObject) {
        if (this.qv.sl() == null || jSONObject == null) {
            return;
        }
        try {
            int iOptInt = jSONObject.optInt("stateType", -1);
            this.qv.sl().ms(iOptInt);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("jsb_name", "changeVideoState");
            jSONObject2.put("state_type", iOptInt);
            com.bytedance.sdk.openadsdk.core.t.u.ms().ms(this.zb, jSONObject2);
        } catch (Exception unused) {
        }
    }

    public void ms(float f) {
        if (this.qv.sl() == null) {
            return;
        }
        try {
            this.qv.sl().ms(f);
        } catch (Exception unused) {
        }
    }

    public void ub() {
        this.qv.d();
    }

    public void ao() {
        this.qv.ka();
    }

    public void d(int i) {
        this.qv.xr(i);
    }

    public void h() {
        WeakReference<com.bytedance.sdk.openadsdk.ch.ms> weakReference = this.re;
        if (weakReference != null && weakReference.get() != null) {
            this.re.get().ms();
        } else {
            this.qv.hi();
        }
    }

    public void ms(float f, float f2, float f3, float f4, int i) {
        this.qv.ms(f, f2, f3, f4, i);
    }

    private boolean h(JSONObject jSONObject) {
        if (this.qv.sl() != null && jSONObject != null) {
            double dMs = this.qv.sl().ms();
            int iXr = this.qv.sl().xr();
            try {
                jSONObject.put("currentTime", dMs / 1000.0d);
                jSONObject.put("state", iXr);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private JSONObject e() {
        return ms(this.zb, this.am);
    }

    public static JSONObject ms(lm lmVar, AtomicBoolean atomicBoolean) {
        boolean zMs;
        JSONObject jSONObject = new JSONObject();
        if (re.xr() == null) {
            return jSONObject;
        }
        try {
            int iNy = com.bytedance.sdk.openadsdk.core.jw.f.ny(lmVar);
            int iX = com.bytedance.sdk.openadsdk.core.jw.f.x(lmVar);
            boolean z = true;
            int iKa = com.bytedance.sdk.openadsdk.core.nw.of.xr(true, lmVar, true) ? 0 : re.xr().ka(iNy);
            int iC = (ms(iX, lmVar) || com.bytedance.sdk.openadsdk.core.nw.of.xr(false, lmVar, true)) ? 0 : re.xr().c(iNy);
            boolean zKa = re.xr().ka(String.valueOf(iNy));
            if (atomicBoolean != null) {
                zMs = atomicBoolean.get();
            } else if (iX == 7 || iX == 8) {
                zMs = re.xr().ms(lmVar, iNy);
            } else {
                zMs = re.xr().d(iNy);
            }
            jSONObject.put("ad_slot_type", iX);
            jSONObject.put("voice_control", zMs);
            jSONObject.put("rv_skip_time", iKa);
            jSONObject.put("fv_skip_show", zKa);
            jSONObject.put("iv_skip_time", iC);
            if (lmVar == null || !lmVar.rk()) {
                z = false;
            }
            jSONObject.put("show_dislike", z);
            jSONObject.put("video_adaptation", lmVar != null ? lmVar.v() : 0);
            jSONObject.put("h5_cache_resources_enable", com.bytedance.sdk.openadsdk.core.nw.cv.f3041ms);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static boolean ms(int i, lm lmVar) {
        com.bytedance.sdk.openadsdk.core.nw.le leVarFi;
        if (i == 8 && com.bytedance.sdk.openadsdk.core.nw.le.ms(lmVar) && (leVarFi = lmVar.fi()) != null) {
            return leVarFi.d();
        }
        return false;
    }

    public int ny(JSONObject jSONObject) {
        if (jSONObject.optBoolean("interactShowDownloadDialog", false)) {
            this.zb.ah(true);
            return 2;
        }
        if (jSONObject.optInt("downloadDialogStatus") != 1) {
            return 0;
        }
        if (this.zb.mh().ms() == 2) {
            this.zb.ah(true);
        }
        return 1;
    }

    public void ch(JSONObject jSONObject) {
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        double dOptDouble;
        double d7;
        double d8;
        if (jSONObject == null) {
            return;
        }
        try {
            String strOptString = jSONObject.optString("adId");
            int iOptInt = jSONObject.optInt("areaType", 1);
            String strOptString2 = jSONObject.optString("subConvertLinkTag");
            int iOptInt2 = jSONObject.optInt("dpaPosition", -1);
            String strOptString3 = jSONObject.optString("clickAreaType");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("clickInfo");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("is_compliant_download", jSONObject.optBoolean("is_compliant_download"));
            jSONObject2.put("convertActionType", jSONObject.optInt("convertActionType", Integer.MIN_VALUE));
            double d9 = -1.0d;
            if (jSONObjectOptJSONObject != null) {
                double dOptDouble2 = jSONObjectOptJSONObject.optDouble("down_x", -1.0d);
                double dOptDouble3 = jSONObjectOptJSONObject.optDouble("down_y", -1.0d);
                double dOptDouble4 = jSONObjectOptJSONObject.optDouble("up_x", -1.0d);
                double dOptDouble5 = jSONObjectOptJSONObject.optDouble("up_y", -1.0d);
                double dOptDouble6 = jSONObjectOptJSONObject.optDouble("down_time", -1.0d);
                double dOptDouble7 = jSONObjectOptJSONObject.optDouble("up_time", -1.0d);
                double dOptDouble8 = jSONObjectOptJSONObject.optDouble("button_x", -1.0d);
                double dOptDouble9 = jSONObjectOptJSONObject.optDouble("button_y", -1.0d);
                double dOptDouble10 = jSONObjectOptJSONObject.optDouble("button_width", -1.0d);
                dOptDouble = jSONObjectOptJSONObject.optDouble("button_height", -1.0d);
                d9 = dOptDouble2;
                d = dOptDouble3;
                d7 = dOptDouble4;
                d2 = dOptDouble6;
                d3 = dOptDouble7;
                d4 = dOptDouble8;
                d5 = dOptDouble9;
                d6 = dOptDouble10;
                d8 = dOptDouble5;
            } else {
                d = -1.0d;
                d2 = -1.0d;
                d3 = -1.0d;
                d4 = -1.0d;
                d5 = -1.0d;
                d6 = -1.0d;
                dOptDouble = -1.0d;
                d7 = -1.0d;
                d8 = -1.0d;
            }
            com.bytedance.sdk.openadsdk.core.nw.i iVarMs = new com.bytedance.sdk.openadsdk.core.nw.i.ms().d((int) d9).ah((int) d).xr((int) d7).ms((int) d8).xr((long) d2).ms((long) d3).ms((int) d4).xr((int) d5).ah((int) d6).d((int) dOptDouble).ms(strOptString3).ms(true).ms(jSONObject2).ms((SparseArray<com.bytedance.sdk.openadsdk.core.xr.d.ms>) null).ka(strOptString2).ka(iOptInt2).ms();
            SoftReference<com.bytedance.sdk.component.adexpress.xr.hi> softReference = this.h;
            if (softReference != null && softReference.get() != null) {
                this.h.get().ms(null, iOptInt, iVarMs, ny(jSONObject));
            }
            ms(strOptString, iOptInt, iVarMs);
        } catch (Exception unused) {
            SoftReference<com.bytedance.sdk.component.adexpress.xr.hi> softReference2 = this.h;
            if (softReference2 == null || softReference2.get() == null) {
                return;
            }
            this.h.get().ms(null, -1, null, 0);
        }
    }

    public void hi(JSONObject jSONObject) {
        pc pcVar;
        double d;
        double d2;
        double d3;
        double d4;
        double dOptDouble;
        double d5;
        double d6;
        double d7;
        double d8;
        SoftReference<com.bytedance.sdk.component.adexpress.xr.hi> softReference;
        if (jSONObject == null) {
            return;
        }
        try {
            String strOptString = jSONObject.optString("adId");
            int iOptInt = jSONObject.optInt("areaType", 1);
            String strOptString2 = jSONObject.optString("clickAreaType");
            String strOptString3 = jSONObject.optString("clickAreaId");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("clickInfo");
            String strOptString4 = jSONObject.optString("subConvertLinkTag");
            int iOptInt2 = jSONObject.optInt("dpaPosition", -1);
            JSONObject jSONObject2 = new JSONObject();
            com.bytedance.sdk.openadsdk.core.nw.h.ms(jSONObject.optString("clickScene"));
            jSONObject2.put("convertActionType", jSONObject.optInt("convertActionType", Integer.MIN_VALUE));
            jSONObject2.put("live_saas_param_interaction_type", jSONObject.optInt("live_saas_param_interaction_type", -1));
            jSONObject2.put("is_compliant_download", jSONObject.optBoolean("is_compliant_download"));
            double d9 = -1.0d;
            if (jSONObjectOptJSONObject != null) {
                double dOptDouble2 = jSONObjectOptJSONObject.optDouble("down_x", -1.0d);
                double dOptDouble3 = jSONObjectOptJSONObject.optDouble("down_y", -1.0d);
                double dOptDouble4 = jSONObjectOptJSONObject.optDouble("up_x", -1.0d);
                double dOptDouble5 = jSONObjectOptJSONObject.optDouble("up_y", -1.0d);
                double dOptDouble6 = jSONObjectOptJSONObject.optDouble("down_time", -1.0d);
                double dOptDouble7 = jSONObjectOptJSONObject.optDouble("up_time", -1.0d);
                double dOptDouble8 = jSONObjectOptJSONObject.optDouble("button_x", -1.0d);
                double dOptDouble9 = jSONObjectOptJSONObject.optDouble("button_y", -1.0d);
                double dOptDouble10 = jSONObjectOptJSONObject.optDouble("button_width", -1.0d);
                dOptDouble = jSONObjectOptJSONObject.optDouble("button_height", -1.0d);
                d9 = dOptDouble2;
                d = dOptDouble3;
                d2 = dOptDouble4;
                d3 = dOptDouble9;
                d4 = dOptDouble10;
                d7 = dOptDouble5;
                d6 = dOptDouble6;
                d5 = dOptDouble7;
                d8 = dOptDouble8;
            } else {
                d = -1.0d;
                d2 = -1.0d;
                d3 = -1.0d;
                d4 = -1.0d;
                dOptDouble = -1.0d;
                d5 = -1.0d;
                d6 = -1.0d;
                d7 = -1.0d;
                d8 = -1.0d;
            }
            try {
                com.bytedance.sdk.openadsdk.core.nw.i iVarMs = new com.bytedance.sdk.openadsdk.core.nw.i.ms().d((float) d9).ah((float) d).xr((float) d2).ms((float) d7).xr((long) d6).ms((long) d5).ms((int) d8).xr((int) d3).ah((int) d4).d((int) dOptDouble).ms(strOptString2).xr(strOptString3).ms(true).ms((SparseArray<com.bytedance.sdk.openadsdk.core.xr.d.ms>) null).ms(jSONObject2).ka(strOptString4).ka(iOptInt2).ms();
                pcVar = this;
                try {
                    if (!pcVar.ms(strOptString, iOptInt, iVarMs) && (softReference = pcVar.h) != null && softReference.get() != null) {
                        pcVar.h.get().ms(null, iOptInt, iVarMs);
                    } else {
                        k();
                    }
                } catch (Exception unused) {
                    SoftReference<com.bytedance.sdk.component.adexpress.xr.hi> softReference2 = pcVar.h;
                    if (softReference2 != null && softReference2.get() != null) {
                        pcVar.h.get().ms(null, -1, null);
                    } else {
                        k();
                    }
                }
            } catch (Exception unused2) {
                pcVar = this;
            }
        } catch (Exception unused3) {
            pcVar = this;
        }
    }

    private void k() {
        ce ceVarJs;
        Context context;
        lm lmVar = this.zb;
        if (lmVar != null && (ceVarJs = lmVar.js()) != null && ceVarJs.xr() == 1 && ceVarJs.c() == 1) {
            xn();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("data", new JSONObject());
            } catch (Throwable unused) {
            }
            WeakReference<Context> weakReference = this.c;
            if (weakReference == null || (context = weakReference.get()) == null) {
                return;
            }
            this.ab.ms(context, jSONObject, this.ch, this.hi, this.u, true);
            ms(jSONObject, false);
        }
    }

    public void sl(final JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.c.ms msVar = this.of;
        if (msVar != null) {
            msVar.ub();
        }
        com.bytedance.sdk.component.ch.ab.xr(new com.bytedance.sdk.component.ch.ny("renderDidFinish") { // from class: com.bytedance.sdk.openadsdk.core.pc.10
            @Override // java.lang.Runnable
            public void run() {
                int i;
                double dOptDouble;
                double dOptDouble2;
                boolean z;
                double d;
                double d2;
                double d3;
                double d4;
                double d5;
                if (pc.this.h == null || pc.this.h.get() == null || jSONObject == null || pc.this.c == null) {
                    return;
                }
                com.bytedance.sdk.component.adexpress.xr.u uVar = new com.bytedance.sdk.component.adexpress.xr.u();
                uVar.ms(1);
                try {
                    boolean zOptBoolean = jSONObject.optBoolean("isRenderSuc");
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("AdSize");
                    if (jSONObjectOptJSONObject != null) {
                        dOptDouble = jSONObjectOptJSONObject.optDouble("width");
                        dOptDouble2 = jSONObjectOptJSONObject.optDouble("height");
                    } else {
                        dOptDouble = 0.0d;
                        dOptDouble2 = 0.0d;
                    }
                    JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("videoInfo");
                    if (jSONObjectOptJSONObject2 != null) {
                        float f = ((Context) pc.this.c.get()).getResources().getDisplayMetrics().density;
                        float f2 = Resources.getSystem().getDisplayMetrics().density;
                        double dOptDouble3 = jSONObjectOptJSONObject2.optDouble("x");
                        z = zOptBoolean;
                        double dOptDouble4 = jSONObjectOptJSONObject2.optDouble("y");
                        d2 = dOptDouble2;
                        double dOptDouble5 = jSONObjectOptJSONObject2.optDouble("width");
                        double dOptDouble6 = jSONObjectOptJSONObject2.optDouble("height");
                        if (pc.this.qv(jSONObjectOptJSONObject2)) {
                            d = dOptDouble;
                            double dOptDouble7 = jSONObjectOptJSONObject2.optDouble("borderRadiusTopLeft");
                            d4 = dOptDouble6;
                            double dOptDouble8 = jSONObjectOptJSONObject2.optDouble("borderRadiusTopRight");
                            d5 = dOptDouble5;
                            double dOptDouble9 = jSONObjectOptJSONObject2.optDouble("borderRadiusBottomLeft");
                            d3 = dOptDouble4;
                            double dOptDouble10 = jSONObjectOptJSONObject2.optDouble("borderRadiusBottomRight");
                            if (re.xr().zm()) {
                                uVar.ms(com.bytedance.sdk.openadsdk.core.jw.ul.xr(f, com.bytedance.sdk.openadsdk.core.jw.ul.ms(f2, (float) dOptDouble7)));
                                uVar.xr(com.bytedance.sdk.openadsdk.core.jw.ul.xr(f, com.bytedance.sdk.openadsdk.core.jw.ul.ms(f2, (float) dOptDouble8)));
                                uVar.ah(com.bytedance.sdk.openadsdk.core.jw.ul.xr(f, com.bytedance.sdk.openadsdk.core.jw.ul.ms(f2, (float) dOptDouble9)));
                                uVar.d(com.bytedance.sdk.openadsdk.core.jw.ul.xr(f, com.bytedance.sdk.openadsdk.core.jw.ul.ms(f2, (float) dOptDouble10)));
                            } else {
                                uVar.ms((float) dOptDouble7);
                                uVar.xr((float) dOptDouble8);
                                uVar.ah((float) dOptDouble9);
                                uVar.d((float) dOptDouble10);
                            }
                        } else {
                            d3 = dOptDouble4;
                            d4 = dOptDouble6;
                            d = dOptDouble;
                            d5 = dOptDouble5;
                        }
                        if (re.xr().zm()) {
                            uVar.ah(com.bytedance.sdk.openadsdk.core.jw.ul.xr(f, com.bytedance.sdk.openadsdk.core.jw.ul.ms(f2, (float) dOptDouble3)));
                            uVar.d(com.bytedance.sdk.openadsdk.core.jw.ul.xr(f, com.bytedance.sdk.openadsdk.core.jw.ul.ms(f2, (float) d3)));
                            uVar.ka(com.bytedance.sdk.openadsdk.core.jw.ul.xr(f, com.bytedance.sdk.openadsdk.core.jw.ul.ms(f2, (float) d5)));
                            uVar.c(com.bytedance.sdk.openadsdk.core.jw.ul.xr(f, com.bytedance.sdk.openadsdk.core.jw.ul.ms(f2, (float) d4)));
                        } else {
                            uVar.ah(dOptDouble3);
                            uVar.d(d3);
                            uVar.ka(d5);
                            uVar.c(d4);
                        }
                    } else {
                        z = zOptBoolean;
                        d = dOptDouble;
                        d2 = dOptDouble2;
                    }
                    try {
                        String strOptString = jSONObject.optString("msg", ny.ms(101));
                        int iOptInt = jSONObject.optInt("code", 101);
                        uVar.ms(z);
                        uVar.ms(d);
                        uVar.xr(d2);
                        uVar.ms(strOptString);
                        uVar.xr(iOptInt);
                        ((com.bytedance.sdk.component.adexpress.xr.hi) pc.this.h.get()).ms(uVar);
                    } catch (Exception unused) {
                        i = 101;
                        uVar.xr(i);
                        uVar.ms(ny.ms(i));
                        ((com.bytedance.sdk.component.adexpress.xr.hi) pc.this.h.get()).ms(uVar);
                    }
                } catch (Exception unused2) {
                    i = 101;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qv(JSONObject jSONObject) {
        return jSONObject.has("borderRadiusTopLeft") && jSONObject.has("borderRadiusBottomLeft") && jSONObject.has("borderRadiusTopRight") && jSONObject.has("borderRadiusBottomRight");
    }

    public void zb(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            Uri uri = Uri.parse(jSONObject.optString("trackData"));
            if ("bytedance".equals(uri.getScheme().toLowerCase())) {
                com.bytedance.sdk.openadsdk.core.jw.t.ms(uri, this);
            }
        } catch (Exception unused) {
        }
    }

    private void y(JSONObject jSONObject) {
        WeakReference<com.bytedance.sdk.openadsdk.core.ao.d> weakReference;
        com.bytedance.sdk.openadsdk.core.ao.d dVar;
        if (jSONObject == null || (weakReference = this.t) == null || (dVar = weakReference.get()) == null) {
            return;
        }
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("temaiProductIds");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                dVar.ms(true, jSONArrayOptJSONArray);
            } else {
                dVar.ms(false, null);
            }
        } catch (Exception unused) {
            dVar.ms(false, null);
        }
    }

    public boolean u(JSONObject jSONObject) {
        try {
            jSONObject.put("creatives", ms(this.op));
        } catch (Exception unused) {
        }
        return true;
    }

    private void ms(final ms msVar, final JSONObject jSONObject) {
        if (msVar == null) {
            return;
        }
        try {
            ms(msVar.d, new com.bytedance.sdk.openadsdk.core.qv.ah() { // from class: com.bytedance.sdk.openadsdk.core.pc.11
                @Override // com.bytedance.sdk.openadsdk.core.qv.ah
                public void ms(boolean z, List<lm> list, boolean z2) {
                    if (!z) {
                        pc.this.ah(msVar.xr, jSONObject);
                        return;
                    }
                    try {
                        jSONObject.put("creatives", pc.ms(list));
                        pc.this.ah(msVar.xr, jSONObject);
                    } catch (Exception unused) {
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    public void qv() {
        ms((JSONObject) null, new com.bytedance.sdk.openadsdk.core.qv.ah() { // from class: com.bytedance.sdk.openadsdk.core.pc.12
            @Override // com.bytedance.sdk.openadsdk.core.qv.ah
            public void ms(boolean z, List<lm> list, boolean z2) {
                pc.this.op = list;
                pc.this.eg();
                pc.this.y();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eg() {
        Context context;
        List<lm> list = this.op;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.le = new HashMap<>();
        WeakReference<SSWebView> weakReference = this.d;
        SSWebView sSWebView = weakReference != null ? weakReference.get() : null;
        WeakReference<Context> weakReference2 = this.c;
        if (weakReference2 == null || (context = weakReference2.get()) == null) {
            return;
        }
        for (lm lmVar : this.op) {
            this.le.put(lmVar.df(), new hi(context, lmVar, sSWebView, this.pc));
        }
    }

    private boolean ms(String str, int i, com.bytedance.sdk.openadsdk.core.nw.i iVar) {
        HashMap<String, hi> map;
        hi hiVar;
        if (TextUtils.isEmpty(str) || (map = this.le) == null || (hiVar = map.get(str)) == null) {
            return false;
        }
        hiVar.ms(i, iVar);
        return true;
    }

    public void ms(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.qv.ah ahVar) {
        com.bytedance.sdk.openadsdk.core.re.xr.ms(this.zb, jSONObject, ahVar, (com.bytedance.sdk.openadsdk.ao.xr.ah.xr) null);
    }

    public void y() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("material", ms(this.op));
            ms("materialMeta", jSONObject);
        } catch (Exception unused) {
        }
    }

    private boolean fm() {
        lm lmVar = this.zb;
        if (lmVar == null || lmVar.vt() == null || com.bytedance.sdk.openadsdk.core.jw.nw.xr(this.zb) || this.cv || this.zb.vt().optInt("parent_type") != 2) {
            return false;
        }
        int iX = com.bytedance.sdk.openadsdk.core.jw.f.x(this.zb);
        if (iX != 8 && iX != 7) {
            return false;
        }
        this.cv = true;
        return true;
    }

    public void ch(boolean z) {
        this.f = z;
    }

    public boolean t() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(String str, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__msg_type", "callback");
            jSONObject2.put("__callback_id", str);
            if (jSONObject != null) {
                jSONObject2.put("__params", jSONObject);
            }
            t(jSONObject2);
        } catch (Exception unused) {
        }
    }

    private void t(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            nw(jSONObject);
        } else {
            nw.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.pc.2
                @Override // java.lang.Runnable
                public void run() {
                    pc.this.nw(jSONObject);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nw(JSONObject jSONObject) {
        com.bytedance.sdk.component.zb.ah ahVarF = f();
        if (ahVarF != null) {
            com.bytedance.sdk.component.utils.hi.ms(ahVarF, "javascript:ToutiaoJSBridge._handleMessageFromToutiao(" + jSONObject.toString() + ")");
        }
    }

    private void d(String str, JSONObject jSONObject) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__msg_type", NotificationCompat.CATEGORY_EVENT);
            jSONObject2.put("__event_id", str);
            if (jSONObject != null) {
                jSONObject2.put("__params", jSONObject);
            }
            t(jSONObject2);
        } catch (Exception unused) {
        }
    }

    private void ka(String str) {
        try {
            JSONArray jSONArray = new JSONArray(new String(Base64.decode(str, 2)));
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                ms msVar = new ms();
                try {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        msVar.f3269ms = jSONObjectOptJSONObject.optString("__msg_type", null);
                        msVar.xr = jSONObjectOptJSONObject.optString("__callback_id", null);
                        msVar.ah = jSONObjectOptJSONObject.optString("func");
                        msVar.d = jSONObjectOptJSONObject.optJSONObject("params");
                        msVar.ka = jSONObjectOptJSONObject.optInt("JSSDK");
                    }
                } catch (Throwable unused) {
                }
                if (!TextUtils.isEmpty(msVar.f3269ms) && !TextUtils.isEmpty(msVar.ah)) {
                    Message messageObtainMessage = this.ka.obtainMessage(11);
                    messageObtainMessage.obj = msVar;
                    this.ka.sendMessage(messageObtainMessage);
                }
            }
        } catch (Exception unused2) {
            if (com.bytedance.sdk.component.utils.sl.ms()) {
                com.bytedance.sdk.component.utils.sl.xr("TTAndroidObject", "failed to parse jsbridge msg queue " + str);
            } else {
                com.bytedance.sdk.component.utils.sl.xr("TTAndroidObject", "failed to parse jsbridge msg queue");
            }
        }
    }

    public boolean ms(Uri uri) {
        if (uri == null) {
            return false;
        }
        try {
            if (!"bytedance".equals(uri.getScheme())) {
                return false;
            }
            if (ah.containsKey(uri.getHost())) {
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public void xr(final Uri uri) {
        long j;
        JSONObject jSONObjectB;
        try {
            String host = uri.getHost();
            if (!"log_event".equals(host) && !"custom_event".equals(host) && !"log_event_v3".equals(host)) {
                if (!"private".equals(host) && !"dispatch_message".equals(host)) {
                    com.bytedance.sdk.component.utils.sl.xr("TTAndroidObject", "handlrUir: not match schema host");
                    return;
                }
                com.bytedance.sdk.component.utils.x.xr().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.pc.3
                    @Override // java.lang.Runnable
                    public void run() {
                        pc.this.ab(uri.toString());
                    }
                });
                return;
            }
            String queryParameter = uri.getQueryParameter("category");
            String queryParameter2 = uri.getQueryParameter(TTDownloadField.TT_TAG);
            String queryParameter3 = uri.getQueryParameter(TTDownloadField.TT_LABEL);
            if (c(queryParameter3)) {
                if (com.bytedance.sdk.openadsdk.core.nw.pc.xr(this.zb) && TextUtils.equals(queryParameter3, "track")) {
                    return;
                }
                long j2 = 0;
                try {
                    j = Long.parseLong(uri.getQueryParameter(com.anythink.core.common.e.f.a.d));
                } catch (Exception unused) {
                    j = 0;
                }
                try {
                    j2 = Long.parseLong(uri.getQueryParameter("ext_value"));
                } catch (Exception unused2) {
                }
                long j3 = j2;
                JSONObject jSONObject = new JSONObject();
                String queryParameter4 = uri.getQueryParameter("extra");
                if (!TextUtils.isEmpty(queryParameter4)) {
                    try {
                        jSONObject = new JSONObject(queryParameter4);
                    } catch (Exception unused3) {
                    }
                }
                ka(queryParameter3, jSONObject);
                if ("click".equals(queryParameter3)) {
                    jSONObjectB = b(jSONObject);
                    WeakReference<com.bytedance.sdk.openadsdk.core.qv.d> weakReference = this.b;
                    if (weakReference != null && weakReference.get() != null) {
                        this.b.get().ah();
                    }
                } else {
                    jSONObjectB = jSONObject;
                }
                com.bytedance.sdk.openadsdk.core.zb.ah.ms(queryParameter, ms(queryParameter2, queryParameter3), queryParameter3, j, j3, jSONObjectB);
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.xr("TTAndroidObject", "handleUri exception: ", e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void ms(lm lmVar, int i) {
        WeakReference<Context> weakReference = this.c;
        if (weakReference == null || lmVar == null || weakReference.get() == null) {
            return;
        }
        Context context = this.c.get();
        com.bytedance.sdk.openadsdk.core.xr.ms msVar = new com.bytedance.sdk.openadsdk.core.xr.ms(context, lmVar, this.pc, this.hi);
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms) msVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class)).xr(true);
        ((com.bytedance.sdk.openadsdk.core.xr.ms.xr.c) msVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.xr.c.class)).ms(i);
        com.bytedance.sdk.component.hi.ka.ms.ms().ms(lmVar.hashCode() + lmVar.eu()).put("live_saas_interaction_type", Integer.valueOf(i));
        final String strDf = lmVar.df();
        com.bytedance.sdk.openadsdk.core.hi.xr.d dVarXr = com.bytedance.sdk.openadsdk.core.hi.ka.xr(context, lmVar, this.pc, false);
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) msVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms((com.bytedance.sdk.openadsdk.core.hi.xr.ah) dVarXr);
        msVar.ms(null, new com.bytedance.sdk.openadsdk.core.nw.hi());
        if (dVarXr != null) {
            dVarXr.ms(new com.bytedance.sdk.openadsdk.core.hi.xr.ms() { // from class: com.bytedance.sdk.openadsdk.core.pc.4
                @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
                public void ms() {
                    com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(strDf, 1, 0);
                }

                @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
                public void ms(long j, long j2, String str, String str2) {
                    if (j > 0) {
                        com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(strDf, 3, (int) ((j2 * 100) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
                public void xr(long j, long j2, String str, String str2) {
                    if (j > 0) {
                        com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(strDf, 2, (int) ((j2 * 100) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
                public void ah(long j, long j2, String str, String str2) {
                    if (j > 0) {
                        com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(strDf, 4, (int) ((j2 * 100) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
                public void ms(long j, String str, String str2) {
                    com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(strDf, 5, 100);
                }

                @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
                public void ms(String str, String str2) {
                    com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(strDf, 6, 100);
                }
            });
        }
        if (il()) {
            WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ny> weakReference2 = this.qf;
            if (weakReference2 == null || weakReference2.get() == null) {
                return;
            }
            this.qf.get().d();
            return;
        }
        if (context instanceof com.bytedance.sdk.openadsdk.core.x.xr) {
            ((com.bytedance.sdk.openadsdk.core.x.xr) context).ms(1);
        }
    }

    private boolean c(String str) {
        return TextUtils.isEmpty(str) || !"click_other".equals(str) || nw();
    }

    boolean nw() {
        lm lmVar = this.zb;
        return lmVar != null && com.bytedance.sdk.openadsdk.core.nw.nw.hi(lmVar) == 1;
    }

    private JSONObject b(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVarRt;
        if (this.f3256ms != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                String strOptString = jSONObject.optString("ad_extra_data", null);
                if (strOptString != null) {
                    jSONObject2 = new JSONObject(strOptString);
                }
                if (g.c()) {
                    try {
                        lm lmVar = this.zb;
                        if (lmVar != null && (xrVarRt = lmVar.rt()) != null) {
                            String strZb = xrVarRt.zb();
                            if (!TextUtils.isEmpty(strZb)) {
                                jSONObject2.putOpt("media_extra", strZb);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
                for (Map.Entry<String, Object> entry : this.f3256ms.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.sl.xr(e.toString());
            }
        }
        return jSONObject;
    }

    private void ka(String str, JSONObject jSONObject) {
        JSONArray jSONArray;
        String strOptString;
        String strOptString2;
        String strOptString3;
        String strOptString4;
        String str2 = "click";
        String strXr = "";
        try {
            if ("show".equals(str)) {
                jSONArray = jSONObject.optJSONArray("show_url");
                str2 = "show";
            } else if ("click".equals(str)) {
                jSONArray = jSONObject.getJSONArray(com.anythink.basead.c.b.a.p);
            } else {
                str2 = null;
                jSONArray = null;
            }
            if (jSONArray != null && jSONArray.length() != 0) {
                String strAh = t.ah();
                if (TextUtils.isEmpty(strAh)) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
                String strOptString5 = jSONObject.optString("log_extra");
                try {
                    JSONObject jSONObject2 = new JSONObject(strOptString5);
                    strOptString = jSONObject2.optString("ad_id");
                    try {
                        strOptString2 = jSONObject2.optString("creative_id");
                        try {
                            strOptString3 = jSONObject2.optString("req_id");
                            try {
                                strOptString4 = jSONObject2.optString("customer_id");
                                try {
                                    strXr = com.bytedance.sdk.openadsdk.core.jw.f.xr(jSONObject2.optInt("ad_slot_type"));
                                } catch (Throwable unused) {
                                }
                            } catch (Throwable unused2) {
                                strOptString4 = "";
                            }
                        } catch (Throwable unused3) {
                            strOptString3 = "";
                            strOptString4 = strOptString3;
                        }
                    } catch (Throwable unused4) {
                        strOptString2 = "";
                        strOptString3 = strOptString2;
                        strOptString4 = strOptString3;
                        HashMap map = new HashMap();
                        map.put("aid", strOptString);
                        map.put("cid", strOptString2);
                        map.put("req_id", strOptString3);
                        map.put("customer_id", strOptString4);
                        com.bytedance.sdk.openadsdk.core.t.xr.ms(strAh, arrayList, true, map, com.bytedance.sdk.openadsdk.core.zb.ah.ms(strOptString5, strOptString, strOptString3, strXr, str2));
                    }
                } catch (Throwable unused5) {
                    strOptString = "";
                    strOptString2 = strOptString;
                }
                HashMap map2 = new HashMap();
                map2.put("aid", strOptString);
                map2.put("cid", strOptString2);
                map2.put("req_id", strOptString3);
                map2.put("customer_id", strOptString4);
                com.bytedance.sdk.openadsdk.core.t.xr.ms(strAh, arrayList, true, map2, com.bytedance.sdk.openadsdk.core.zb.ah.ms(strOptString5, strOptString, strOptString3, strXr, str2));
            }
        } catch (Throwable unused6) {
        }
    }

    public void b() {
        lm lmVar = this.zb;
        if (lmVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.jw.c.xr(lmVar, this.c.get(), w());
    }

    public void re() {
        lm lmVar = this.zb;
        if (lmVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.jw.c.ah(lmVar, this.c.get(), w());
    }

    public JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        lm lmVar = this.zb;
        if (lmVar == null) {
            return jSONObject;
        }
        String strZx = lmVar.zx();
        if (TextUtils.isEmpty(strZx)) {
            return jSONObject;
        }
        try {
            return new JSONObject(strZx);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
            return jSONObject;
        }
    }

    public String w() {
        return com.bytedance.sdk.openadsdk.core.jw.f.ms(this.hi);
    }

    private String ms(String str, String str2) {
        return ((("landing_perf_stats".equals(str2) || "landing_perf_exception".equals(str2)) && "landingpage".equals(str)) || this.h != null || il()) ? str : com.bytedance.sdk.openadsdk.core.jw.f.ms(this.hi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(String str) {
        int iIndexOf;
        if (str != null && str.startsWith("bytedance://")) {
            try {
                if (str.equals("bytedance://dispatch_message/")) {
                    com.bytedance.sdk.component.zb.ah ahVarF = f();
                    if (ahVarF != null) {
                        com.bytedance.sdk.component.utils.hi.ms(ahVarF, "javascript:ToutiaoJSBridge._fetchQueue()");
                        return;
                    }
                    return;
                }
                if (!str.startsWith("bytedance://private/setresult/") || (iIndexOf = str.indexOf(38, 30)) <= 0) {
                    return;
                }
                String strSubstring = str.substring(30, iIndexOf);
                String strSubstring2 = str.substring(iIndexOf + 1);
                if (!strSubstring.equals("SCENE_FETCHQUEUE") || strSubstring2.length() <= 0) {
                    return;
                }
                ka(strSubstring2);
            } catch (Exception unused) {
            }
        }
    }

    public void yu() {
        com.bytedance.sdk.openadsdk.core.ao.ah ahVar = this.ab;
        if (ahVar != null) {
            ahVar.ms();
        }
        if (fm()) {
            qv();
        }
    }

    public void op() {
        com.bytedance.sdk.openadsdk.core.ao.ah ahVar = this.ab;
        if (ahVar != null) {
            ahVar.xr();
        }
    }

    public void le() {
        ka();
        com.bytedance.sdk.openadsdk.core.ao.ah ahVar = this.ab;
        if (ahVar != null) {
            ahVar.ah();
        }
        WeakReference<SSWebView> weakReference = this.d;
        if (weakReference != null) {
            weakReference.clear();
        }
        WeakReference<View> weakReference2 = this.ny;
        if (weakReference2 != null) {
            weakReference2.clear();
        }
        WeakReference<Context> weakReference3 = this.c;
        if (weakReference3 != null) {
            weakReference3.clear();
        }
        this.jw = null;
        this.eg = null;
    }

    @Override // com.bytedance.sdk.component.utils.le.ms
    public void ms(Message message) {
        if (message != null && message.what == 11 && (message.obj instanceof ms)) {
            try {
                ms((ms) message.obj, 1);
            } catch (Exception unused) {
            }
        }
    }

    public void ub(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.x = jSONObject.optString("cid");
        this.ch = jSONObject.optString("log_extra");
    }

    private void xn() {
        if (this.ab == null) {
            this.ab = com.bytedance.sdk.openadsdk.core.ao.ms.ms(this, this.zb, this.m);
        }
    }

    public void ms(String str, boolean z) {
        com.bytedance.sdk.openadsdk.core.ao.ah ahVar = this.ab;
        if (ahVar != null) {
            ahVar.ms(str, z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ao.xr
    public void ms(String str, JSONObject jSONObject) {
        ch.ub().fm();
        d(str, jSONObject);
    }

    public void xr(String str, JSONObject jSONObject) {
        try {
            com.bytedance.sdk.component.ms.h hVar = this.p;
            if (hVar != null) {
                hVar.ms(str, jSONObject);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ah("TTAndroidObject", "sendJsMsg2020 error", th);
        }
    }

    public void cv() {
        WeakReference<com.bytedance.sdk.openadsdk.core.qv.d> weakReference = this.b;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.b.get().xr();
    }

    public void ms(JSONObject jSONObject, boolean z) {
        WeakReference<Context> weakReference;
        if (this.ab == null || (weakReference = this.c) == null || weakReference.get() == null) {
            return;
        }
        this.ab.ms(this.ao && this.ub);
        this.ab.xr(z);
        this.ab.ms(this.c.get(), jSONObject, this.pc, this.ch);
    }

    public int g() {
        if (this.qv.sl() == null) {
            return 0;
        }
        return this.qv.sl().ah();
    }

    public void ms(com.bytedance.sdk.openadsdk.core.qv.ka kaVar) {
        this.sa = new WeakReference<>(kaVar);
    }

    public void hi(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("visibleState", z ? 0 : 1);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.d("TTAndroidObject", e.getMessage());
        }
        d("visibleStateChange", jSONObject);
    }

    public void of() {
        WeakReference<com.bytedance.sdk.openadsdk.core.qv.ka> weakReference = this.sa;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.sa.get().ms();
    }

    private boolean il() {
        return this.qf != null;
    }

    public void ms(int i, int i2) {
        int iAh = com.bytedance.sdk.openadsdk.core.jw.ul.ah(re.getContext(), i);
        int iAh2 = com.bytedance.sdk.openadsdk.core.jw.ul.ah(re.getContext(), i2);
        WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ny> weakReference = this.qf;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.qf.get().ms(Integer.MIN_VALUE, Integer.MIN_VALUE, iAh, iAh2);
    }

    public void ms(int i, int i2, int i3, int i4) {
        int iAh;
        int iAh2;
        int iAh3;
        int iAh4 = Integer.MIN_VALUE;
        if (i == Integer.MAX_VALUE || i2 == Integer.MAX_VALUE) {
            iAh = Integer.MIN_VALUE;
            iAh2 = Integer.MIN_VALUE;
        } else {
            iAh = com.bytedance.sdk.openadsdk.core.jw.ul.ah(re.getContext(), i);
            iAh2 = com.bytedance.sdk.openadsdk.core.jw.ul.ah(re.getContext(), i2);
        }
        if (i3 == Integer.MAX_VALUE || i4 == Integer.MAX_VALUE) {
            iAh3 = Integer.MIN_VALUE;
        } else {
            iAh4 = com.bytedance.sdk.openadsdk.core.jw.ul.ah(re.getContext(), i3);
            iAh3 = com.bytedance.sdk.openadsdk.core.jw.ul.ah(re.getContext(), i4);
        }
        WeakReference<com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ny> weakReference = this.qf;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.qf.get().ms(iAh, iAh2, iAh4, iAh3);
    }

    public void sl(boolean z) {
        this.am = new AtomicBoolean(z);
    }

    public void p() {
        if (this.qv.sl() != null) {
            this.qv.sl().ny();
        }
    }

    public void pc() {
        this.qv.c();
    }
}
