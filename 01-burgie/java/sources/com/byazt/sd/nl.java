package com.byazt.sd;

import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import android.view.View;
import android.webkit.JavascriptInterface;
import com.byazt.fi.BaseConstants;
import com.byazt.fj.SSWebView;
import com.byazt.gm.er;
import com.byazt.gm.hs;
import com.byazt.gm.i;
import com.byazt.gm.ii;
import com.byazt.gm.qn;
import com.byazt.gm.r;
import com.byazt.gm.s;
import com.byazt.gm.v;
import com.byazt.hg.ie;
import com.byazt.hg.of;
import com.byazt.hg.u;
import com.byazt.mg.PluginConstants;
import com.byazt.vkw.qi;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.JProtect;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import com.umeng.analytics.pro.an;
import com.umeng.analytics.pro.cc;
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
@com.byazt.vzx.pr(pr = {0, 1, 23, 574})
public class nl implements com.byazt.kq.hw, qi.pr, com.byazt.dp.hn {
    public static final Map<String, Boolean> hn;
    public static volatile boolean jn;
    public JSONObject a;
    public WeakReference<View> aj;
    public WeakReference<com.byazt.ap.hw> b;
    public WeakReference<com.byazt.uq.aj> bm;
    public WeakReference<com.byazt.dp.c> cz;
    public com.byazt.ee.yb e;
    public WeakReference<com.byazt.qx.nt> f;
    public WeakReference<com.byazt.ap.c> fo;
    public com.byazt.dp.x fw;
    public String g;
    public WeakReference<com.byazt.ap.uc> gu;
    public List<of> gz;
    public com.byazt.ea.hw hs;
    public List<JSONObject> ie;
    public WeakReference<com.byazt.ap.hn> iu;
    public String k;
    public SoftReference<com.byazt.mq.w> lb;
    public com.byazt.lz.pr ls;
    public AtomicBoolean lv;
    public of m;
    public WeakReference<com.byazt.ak.hn> mw;
    public com.byazt.ko.pr n;
    public HashMap<String, aj> nl;
    public JSONObject nw;
    public WeakReference<com.byazt.ap.pr> ny;
    public WeakReference<com.byazt.sa.hw> o;
    public Map<String, Object> pr;
    public boolean qn;
    public com.byazt.nc.fw.pr r;
    public WeakReference<com.byazt.oy.pr> rc;
    public String s;
    public final WeakReference<Context> uc;
    public boolean v;
    public WeakReference<com.byazt.ap.fw> ve;
    public String vk;
    public int w;
    public WeakReference<SSWebView> x;
    public JSONObject z;
    public String zo;
    public boolean hw = false;
    public boolean ho = false;
    public boolean nt = true;
    public boolean yb = true;
    public final com.byazt.qx.k qa = new com.byazt.qx.k();
    public boolean y = false;
    public boolean ww = false;
    public boolean er = false;
    public boolean qi = false;
    public boolean of = false;
    public boolean ii = false;
    public boolean i = false;
    public byte l = -1;
    public final AtomicBoolean od = new AtomicBoolean(false);
    public final Map<String, com.byazt.nv.hn> vj = new ConcurrentHashMap();
    public int[] sv = null;
    public com.byazt.ca.iu c = new com.byazt.ca.iu(Looper.getMainLooper(), this);

    @com.byazt.vzx.pr(pr = {0, 1, 23, 957})
    public static class pr {
        public int c;
        public String hn;
        public String hw;
        public String pr;
        public JSONObject x;
    }

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        hn = concurrentHashMap;
        concurrentHashMap.put("log_event", Boolean.TRUE);
        concurrentHashMap.put("private", Boolean.TRUE);
        concurrentHashMap.put("dispatch_message", Boolean.TRUE);
        concurrentHashMap.put("custom_event", Boolean.TRUE);
        concurrentHashMap.put("log_event_v3", Boolean.TRUE);
        jn = false;
    }

    public nl(Context context) {
        this.uc = new WeakReference<>(context);
        ls.uc();
    }

    public Context getContext() {
        return this.uc.get();
    }

    public static JSONArray pr(List<of> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null) {
            return jSONArray;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(list.get(i).to());
        }
        return jSONArray;
    }

    public nl pr(String str) {
        this.s = str;
        return this;
    }

    public nl pr(boolean z) {
        this.of = z;
        return this;
    }

    private boolean er() {
        return zo.nt().of();
    }

    public nl pr(SSWebView sSWebView) {
        com.byazt.ca.ho.hw("webviewpool", "===useJsb2 webView hashCode:" + sSWebView.hashCode());
        if (sSWebView == null) {
            return this;
        }
        com.byazt.ee.yb ybVarHw = com.byazt.ee.yb.pr(sSWebView).pr(new com.byazt.hq.pr()).pr("ToutiaoJSBridge").pr(new com.byazt.ee.k() { // from class: com.byazt.sd.nl.1
            @Override // com.byazt.ee.k
            public <T> T pr(String str, Type type) {
                return null;
            }

            @Override // com.byazt.ee.k
            public <T> String pr(T t) {
                return null;
            }
        }).pr(er()).hw(true).pr().hw();
        this.e = ybVarHw;
        com.byazt.gm.z.pr(ybVarHw, this);
        com.byazt.gm.uc.pr(this.e, this);
        com.byazt.gm.zo.pr(this.e, this, this.m);
        com.byazt.gm.nt.pr(this.e);
        com.byazt.gm.nl.pr(this.e, sSWebView);
        com.byazt.gm.aj.pr(this.e, this);
        com.byazt.gm.m.pr(this.e, this);
        ii.pr(this.e, this);
        com.byazt.izk.x.pr(this.e, this);
        com.byazt.gm.fo.pr(this.e, this);
        com.byazt.gm.a.pr(this.e, this);
        com.byazt.izk.hn.pr(this.e, this);
        com.byazt.izk.pr.pr(this.e, this);
        com.byazt.izk.c.pr(this.e, this);
        com.byazt.izk.uc.pr(this.e, this);
        com.byazt.izk.hw.pr(this.e, this);
        v();
        com.byazt.gm.hn.pr(this.e, this.x.get(), this.zo);
        com.byazt.gm.ww.pr(this.e, this.x.get(), this.zo);
        com.byazt.gm.hw.pr(this.e, this.x.get(), this.zo);
        com.byazt.gm.y.pr(this.e, this.x.get(), this.zo);
        com.byazt.gm.fw.pr(this.e, this);
        com.byazt.gm.rc.pr(this.e, this);
        com.byazt.gm.of.pr(this.e, this);
        com.byazt.gm.lb.pr(this.e, this);
        com.byazt.gm.yb.pr(this.e, this.m);
        com.byazt.gm.iu.pr(this.e, this.uc.get(), this.m);
        com.byazt.br.pr.pr(this.e, this.uc.get());
        com.byazt.gm.k.pr(this.e, this.m, this.ie);
        qn.pr(this.e, this);
        com.byazt.gm.gz.pr(this.e, this, this.o);
        s.pr(this.e, this, this.o);
        hs.pr(this.e, sSWebView, this);
        com.byazt.gm.w.pr(this.e, this.m, this);
        com.byazt.gm.ho.pr(this.e, this.m, this);
        r.pr(this.e, this.r);
        i.pr(this.e, this);
        com.byazt.gm.n.pr(this.e, this.hs);
        com.byazt.gm.e.pr(this.e, this, this.m);
        com.byazt.gm.g.pr(this.e, this.a);
        com.byazt.gm.vk.pr(this.e, this.m, this);
        com.byazt.gm.pr.pr(this.e, this.uc.get());
        v.pr(this.e, this.m);
        com.byazt.gm.x.pr(this.e, this);
        com.byazt.gm.ve.pr(this.e, this);
        com.byazt.gm.ny.pr(this.e, this, this.uc.get(), this.m);
        com.byazt.gm.c.pr(this.e);
        com.byazt.gm.cz.pr(this.e);
        com.byazt.gm.b.pr(this.e, this, this.m);
        com.byazt.gm.qi.pr(this.e, this);
        com.byazt.gm.qa.pr(this.e, this.m);
        com.byazt.gm.ls.pr(this.e, this.m);
        er.pr(this, this.e, this.m);
        return this;
    }

    private void v() {
        of ofVar;
        WeakReference<SSWebView> weakReference = this.x;
        if (weakReference == null || weakReference.get() == null || (ofVar = this.m) == null) {
            return;
        }
        int iTm = ofVar.tm();
        int iFu = this.m.fu();
        int iQz = this.m.qz();
        int iGg = this.m.gg();
        int iKl = this.m.kl();
        JSONObject jSONObjectGv = this.m.gv();
        JSONObject jSONObjectDj = this.m.dj();
        JSONObject jSONObjectYd = this.m.yd();
        this.x.get().setShakeValue(iTm);
        this.x.get().setDeepShakeValue(iFu);
        this.x.get().setWriggleValue(iQz);
        this.x.get().setTwistConfig(jSONObjectGv);
        this.x.get().setShakeInteractConf(jSONObjectDj);
        this.x.get().setTwistInteractConf(jSONObjectYd);
        this.x.get().setCalculationMethod(iGg);
        this.x.get().setCalculationTwistMethod(iKl);
    }

    public JSONObject pr() {
        WeakReference<com.byazt.uq.aj> weakReference = this.bm;
        if (weakReference != null && weakReference.get() != null) {
            return this.bm.get().getContainerInfo();
        }
        return null;
    }

    public JSONObject hw() {
        WeakReference<com.byazt.uq.aj> weakReference = this.bm;
        if (weakReference != null && weakReference.get() != null) {
            return this.bm.get().getCreativeVideoViewInfo();
        }
        return null;
    }

    public void pr(SSWebView.hw hwVar) {
        WeakReference<SSWebView> weakReference = this.x;
        if (weakReference == null || weakReference.get() == null || hwVar == null) {
            return;
        }
        this.x.get().setOnShakeListener(hwVar);
    }

    public nl pr(com.byazt.qx.nt ntVar) {
        this.f = new WeakReference<>(ntVar);
        return this;
    }

    public nl pr(com.byazt.sa.hw hwVar) {
        this.o = new WeakReference<>(hwVar);
        return this;
    }

    public nl pr(com.byazt.uq.aj ajVar) {
        this.bm = new WeakReference<>(ajVar);
        return this;
    }

    public com.byazt.uq.aj hn() {
        WeakReference<com.byazt.uq.aj> weakReference = this.bm;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public boolean x() {
        WeakReference<SSWebView> weakReference = this.x;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        return this.x.get().T_();
    }

    public static void hw(boolean z) {
        jn = z;
    }

    public void pr(int i) {
        if (jn) {
            return;
        }
        if (i == 1) {
            if (this.m != null && x()) {
                com.byazt.wr.uc.x = true;
            }
            hw("wobble_callback", (JSONObject) null);
            return;
        }
        if (i == 2) {
            hw("twist_callback", (JSONObject) null);
        }
    }

    public void hn(boolean z) {
        this.v = z;
        this.qi = z;
    }

    public void x(boolean z) {
        this.qn = z;
    }

    public int c(boolean z) {
        if (!this.qi && com.byazt.hg.e.pr(this.m) != 0 && z) {
            return 2;
        }
        if (this.v) {
            return 1;
        }
        if (this.qn) {
            return com.byazt.hg.e.pr(this.m) == 2 ? 2 : 1;
        }
        return com.byazt.hg.e.pr(this.m) == 0 ? 1 : 2;
    }

    public void c() {
        com.byazt.ee.yb ybVar = this.e;
        if (ybVar == null) {
            return;
        }
        ybVar.pr();
        this.e = null;
    }

    public com.byazt.ee.yb uc() {
        return this.e;
    }

    private com.byazt.son.x qi() {
        WeakReference<SSWebView> weakReference = this.x;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public nl hw(SSWebView sSWebView) {
        this.x = new WeakReference<>(sSWebView);
        return this;
    }

    public nl pr(com.byazt.ko.pr prVar) {
        this.n = prVar;
        return this;
    }

    public nl uc(boolean z) {
        this.ww = z;
        return this;
    }

    public nl hw(String str) {
        this.zo = str;
        return this;
    }

    public nl pr(View view) {
        this.aj = new WeakReference<>(view);
        return this;
    }

    public nl hw(List<JSONObject> list) {
        this.ie = list;
        return this;
    }

    public nl hw(int i) {
        this.ho = true;
        return this;
    }

    public boolean fw() {
        return this.ii;
    }

    public void fw(boolean z) {
        this.ii = z;
    }

    public void zo(boolean z) {
        this.i = z;
    }

    private JSONObject qn() {
        try {
            View view = this.aj.get();
            SSWebView sSWebView = this.x.get();
            if (view == null || sSWebView == null) {
                com.byazt.ca.ho.hw("TTAndroidObject", "setCloseButtonInfo error closeButton is null");
                return null;
            }
            int[] iArrHw = com.byazt.wt.er.hw(view);
            int[] iArrHw2 = com.byazt.wt.er.hw(sSWebView);
            if (iArrHw != null && iArrHw2 != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", com.byazt.wt.er.x(a.getContext(), iArrHw[0] - iArrHw2[0]));
                jSONObject.put("y", com.byazt.wt.er.x(a.getContext(), iArrHw[1] - iArrHw2[1]));
                jSONObject.put("w", com.byazt.wt.er.x(a.getContext(), view.getWidth()));
                jSONObject.put(an.aG, com.byazt.wt.er.x(a.getContext(), view.getHeight()));
                jSONObject.put("isExist", true);
                return jSONObject;
            }
            com.byazt.ca.ho.hw("TTAndroidObject", "setCloseButtonInfo error position or webViewPosition is null");
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    public nl pr(com.byazt.ap.hw hwVar) {
        this.b = new WeakReference<>(hwVar);
        return this;
    }

    public nl pr(com.byazt.ap.hn hnVar) {
        this.iu = new WeakReference<>(hnVar);
        return this;
    }

    public nl pr(com.byazt.ap.fw fwVar) {
        this.ve = new WeakReference<>(fwVar);
        return this;
    }

    public of zo() {
        return this.m;
    }

    public nl pr(of ofVar) {
        this.m = ofVar;
        return this;
    }

    public nl hn(String str) {
        this.g = str;
        return this;
    }

    public boolean aj() {
        of ofVar = this.m;
        return ofVar != null && ofVar.eh();
    }

    public nl x(String str) {
        this.vk = str;
        return this;
    }

    public nl hn(int i) {
        this.w = i;
        return this;
    }

    public nl c(String str) {
        this.k = str;
        return this;
    }

    public nl pr(com.byazt.mq.w wVar) {
        this.lb = new SoftReference<>(wVar);
        return this;
    }

    public nl pr(com.byazt.qx.w wVar) {
        this.qa.pr(wVar);
        return this;
    }

    public nl pr(com.byazt.dp.c cVar) {
        this.cz = new WeakReference<>(cVar);
        return this;
    }

    public nl pr(JSONObject jSONObject) {
        this.z = jSONObject;
        return this;
    }

    public nl pr(Map<String, Object> map) {
        this.pr = map;
        return this;
    }

    public nl pr(com.byazt.ap.pr prVar) {
        this.ny = new WeakReference<>(prVar);
        return this;
    }

    public nl pr(com.byazt.ap.c cVar) {
        this.fo = new WeakReference<>(cVar);
        return this;
    }

    public WeakReference<com.byazt.ap.c> vk() {
        return this.fo;
    }

    public nl pr(com.byazt.oy.pr prVar) {
        this.rc = new WeakReference<>(prVar);
        return this;
    }

    public nl hn(List<of> list) {
        this.gz = list;
        return this;
    }

    public boolean w() {
        return this.hw;
    }

    public void aj(boolean z) {
        this.hw = z;
    }

    public void pr(com.byazt.nc.fw.pr prVar) {
        this.r = prVar;
    }

    public void pr(com.byazt.ea.hw hwVar) {
        this.hs = hwVar;
    }

    public void hw(JSONObject jSONObject) {
        this.nw = jSONObject;
    }

    public JSONObject k() {
        return this.nw;
    }

    public boolean hw(of ofVar) {
        WeakReference<com.byazt.qx.nt> weakReference;
        com.byazt.qx.nt ntVar;
        if (ofVar != null && (weakReference = this.f) != null && (ntVar = weakReference.get()) != null) {
            ntVar.hw(ofVar);
        }
        return false;
    }

    private static List<String> of() {
        return Arrays.asList("appInfo", "adInfo", "getTemplateInfo", "getTeMaiAds");
    }

    public static void pr(JSONObject jSONObject, int i) throws Exception {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = of().iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        jSONObject.put("appName", com.byazt.hb.pr.pr());
        jSONObject.put("innerAppName", com.byazt.hb.pr.uc());
        jSONObject.put("aid", com.byazt.hb.pr.hw());
        jSONObject.put("sdkEdition", com.byazt.hb.pr.hn());
        jSONObject.put("sdkApiVersion", com.byazt.hb.pr.x());
        jSONObject.put("appVersion", com.byazt.hb.pr.c());
        jSONObject.put("netType", com.byazt.hb.pr.fw());
        jSONObject.put("supportList", jSONArray);
        jSONObject.put("deviceId", com.byazt.hb.pr.zo());
        jSONObject.put("osVersion", Build.VERSION.SDK_INT);
        jSONObject.put("appId", zo.nt().ny());
        if (ie.pr(i)) {
            jSONObject.put("themeStatus", zo.nt().nw());
        }
    }

    public JSONObject m() throws Exception {
        return com.byazt.hc.hw.pr(this.m, this.g);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public JSONObject pr(pr prVar, int i) throws Exception {
        byte b;
        Context context;
        if (!NotificationCompat.CATEGORY_CALL.equals(prVar.pr)) {
            return null;
        }
        er();
        JSONObject jSONObject = new JSONObject();
        String str = prVar.hn;
        switch (str.hashCode()) {
            case -2036781162:
                b = !str.equals("subscribe_app_ad") ? (byte) -1 : (byte) 9;
                break;
            case -1752549500:
                b = !str.equals("adInfoStash") ? (byte) -1 : (byte) 28;
                break;
            case -1423303823:
                b = !str.equals("adInfo") ? (byte) -1 : (byte) 1;
                break;
            case -1330994877:
                b = !str.equals("pauseWebView") ? (byte) -1 : (byte) 24;
                break;
            case -1169135450:
                b = !str.equals("changeVideoState") ? (byte) -1 : (byte) 18;
                break;
            case -844321441:
                b = !str.equals("webview_time_track") ? (byte) -1 : (byte) 26;
                break;
            case -800853518:
                b = !str.equals("clickEvent") ? (byte) -1 : cc.k;
                break;
            case -794273169:
                b = !str.equals("appInfo") ? (byte) -1 : (byte) 0;
                break;
            case -715147645:
                b = !str.equals("getScreenSize") ? (byte) -1 : (byte) 5;
                break;
            case -489318846:
                b = !str.equals("getMaterialMeta") ? (byte) -1 : (byte) 21;
                break;
            case -278382602:
                b = !str.equals("send_temai_product_ids") ? (byte) -1 : (byte) 20;
                break;
            case -173752734:
                b = !str.equals("getTeMaiAds") ? (byte) -1 : (byte) 3;
                break;
            case 27837080:
                b = !str.equals("download_app_ad") ? (byte) -1 : (byte) 10;
                break;
            case 105049135:
                b = !str.equals("unsubscribe_app_ad") ? (byte) -1 : (byte) 12;
                break;
            case 352242576:
                b = !str.equals("getDownloadStatus") ? (byte) -1 : (byte) 27;
                break;
            case 399543522:
                b = !str.equals("getCloseButtonInfo") ? (byte) -1 : (byte) 6;
                break;
            case 402955465:
                b = !str.equals("isViewable") ? (byte) -1 : (byte) 4;
                break;
            case 442647767:
                b = !str.equals("sendReward") ? (byte) -1 : (byte) 8;
                break;
            case 571273292:
                b = !str.equals("dynamicTrack") ? (byte) -1 : cc.m;
                break;
            case 650209982:
                b = !str.equals("getTemplateInfo") ? (byte) -1 : (byte) 2;
                break;
            case 672928467:
                b = !str.equals("cancel_download_app_ad") ? (byte) -1 : (byte) 11;
                break;
            case 711635577:
                b = !str.equals("getCurrentVideoState") ? (byte) -1 : (byte) 19;
                break;
            case 885131792:
                b = !str.equals("getVolume") ? (byte) -1 : (byte) 7;
                break;
            case 1107374321:
                b = !str.equals("pauseWebViewTimers") ? (byte) -1 : (byte) 25;
                break;
            case 1151744482:
                b = !str.equals("muteVideo") ? (byte) -1 : (byte) 17;
                break;
            case 1237100796:
                b = !str.equals("renderDidFinish") ? (byte) -1 : cc.l;
                break;
            case 1634511418:
                b = !str.equals("endcard_load") ? (byte) -1 : (byte) 23;
                break;
            case 1713585602:
                b = !str.equals("getNetworkData") ? (byte) -1 : (byte) 22;
                break;
            case 2086000188:
                b = !str.equals("skipVideo") ? (byte) -1 : cc.n;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                pr(jSONObject, ls.k(this.m));
                break;
            case 1:
                jSONObject = m();
                break;
            case 2:
                ho();
                jSONObject = this.a;
                break;
            case 3:
                JSONObject jSONObject2 = this.z;
                if (jSONObject2 != null) {
                    jSONObject = jSONObject2;
                }
                break;
            case 4:
                jSONObject.put("viewStatus", this.ww ? 1 : 0);
                break;
            case 5:
                WeakReference<com.byazt.ap.pr> weakReference = this.ny;
                com.byazt.ap.pr prVar2 = weakReference != null ? weakReference.get() : null;
                if (prVar2 != null) {
                    int iHw = prVar2.hw();
                    int iPr = prVar2.pr();
                    jSONObject.put("width", iHw);
                    jSONObject.put("height", iPr);
                }
                break;
            case 6:
                JSONObject jSONObjectQn = qn();
                if (jSONObjectQn != null) {
                    jSONObject = jSONObjectQn;
                }
                break;
            case 7:
                AudioManager audioManager = (AudioManager) a.getContext().getSystemService(MediaFormat.KEY_AUDIO);
                jSONObject.put("endcard_mute", (audioManager != null ? audioManager.getStreamVolume(3) : -1) <= 0);
                break;
            case 8:
                this.hw = true;
                int iOptInt = prVar.x != null ? prVar.x.optInt(MediationConstant.KEY_REWARD_TYPE) : 0;
                WeakReference<com.byazt.ap.c> weakReference2 = this.fo;
                if (weakReference2 != null && weakReference2.get() != null) {
                    this.fo.get().pr(iOptInt);
                }
                this.qa.hn(iOptInt);
                break;
            case 9:
                o();
                WeakReference<Context> weakReference3 = this.uc;
                if (weakReference3 != null && (context = weakReference3.get()) != null) {
                    this.fw.pr(context, prVar.x, this.vk, this.w, this.ho, this.i);
                }
                break;
            case 10:
                vk(true);
                pr(prVar.x, prVar.x != null ? prVar.x.optBoolean("is_compliant_download") : false);
                break;
            case 11:
                com.byazt.dp.x xVar = this.fw;
                if (xVar != null) {
                    xVar.hw(prVar.x);
                }
                break;
            case 12:
                com.byazt.dp.x xVar2 = this.fw;
                if (xVar2 != null) {
                    xVar2.pr(prVar.x);
                }
                break;
            case 13:
                aj(prVar.x);
                break;
            case 14:
                vk(prVar.x);
                break;
            case 15:
                w(prVar.x);
                break;
            case 16:
                nt();
                break;
            case 17:
                c(prVar.x);
                break;
            case 18:
                uc(prVar.x);
                break;
            case 19:
                nt(jSONObject);
                break;
            case 20:
                qa(prVar.x);
                break;
            case 21:
                k(jSONObject);
                break;
            case 22:
                pr(prVar, jSONObject);
                break;
            case 23:
                ho(prVar.x);
                break;
            case 24:
                ii();
                break;
            case 25:
                i();
                break;
            case 26:
                hn(prVar.x);
                break;
            case 27:
                jSONObject = com.byazt.gm.nt.pr(prVar.x);
                break;
            case 28:
                g(prVar.x);
                break;
        }
        if (i == 1 && !TextUtils.isEmpty(prVar.hw)) {
            x(prVar.hw, jSONObject);
            er();
        }
        return jSONObject;
    }

    public void hn(JSONObject jSONObject) {
        com.byazt.ko.pr prVar;
        if (jSONObject == null || (prVar = this.n) == null) {
            return;
        }
        prVar.x(jSONObject);
    }

    private void hw(String str, boolean z) {
        if (this.n == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (z) {
            this.n.uc(str);
        } else {
            this.n.fw(str);
        }
    }

    private void ii() {
        WeakReference<com.byazt.ap.fw> weakReference = this.ve;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.ve.get().pr();
    }

    private void i() {
        WeakReference<com.byazt.ap.fw> weakReference = this.ve;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.ve.get().hw();
    }

    private void ho(JSONObject jSONObject) {
        WeakReference<com.byazt.ap.hw> weakReference = this.b;
        if (weakReference == null || jSONObject == null || weakReference.get() == null) {
            return;
        }
        this.b.get().pr(jSONObject.optBoolean("isRenderSuc", false), jSONObject.optInt(PluginConstants.KEY_ERROR_CODE, -1), jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE, ""));
    }

    public void g() {
        WeakReference<com.byazt.ap.hn> weakReference = this.iu;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.iu.get().pr();
    }

    @Override // com.byazt.kq.hw
    @JavascriptInterface
    public String adInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject = m();
        } catch (Exception e) {
        }
        return jSONObject.toString();
    }

    @Override // com.byazt.kq.hw
    @JavascriptInterface
    public String appInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            pr(jSONObject, ls.k(this.m));
        } catch (Exception e) {
        }
        return jSONObject.toString();
    }

    @Override // com.byazt.kq.hw
    @JavascriptInterface
    public String getTemplateInfo() {
        hw("getTemplateInfo", true);
        try {
            ho();
            hw("getTemplateInfo", false);
            return this.a.toString();
        } catch (Exception e) {
            return "";
        }
    }

    public nl x(JSONObject jSONObject) {
        this.a = jSONObject;
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0011 A[Catch: Exception -> 0x000b, TRY_LEAVE, TryCatch #0 {Exception -> 0x000b, blocks: (B:4:0x0004, B:7:0x000d, B:9:0x0011), top: B:12:0x0004 }] */
    public JSONObject ho() {
        JSONObject jSONObject = this.a;
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
                if (this.m != null) {
                    jSONObject.put("setting", r());
                    jSONObject.put("extension", this.m.iq());
                }
            } catch (Exception e) {
            }
        } else if (this.m != null) {
            jSONObject.put("setting", r());
            jSONObject.put("extension", this.m.iq());
        }
        this.a = jSONObject;
        return jSONObject;
    }

    @Override // com.byazt.kq.hw
    @JavascriptInterface
    public void renderDidFinish(String str) {
        try {
            vk(new JSONObject(str));
        } catch (Exception e) {
        }
    }

    @Override // com.byazt.kq.hw
    @JavascriptInterface
    public void adAnalysisData(String str) {
    }

    @Override // com.byazt.kq.hw
    @JavascriptInterface
    public void muteVideo(final String str) {
        com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.sd.nl.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    nl.this.c(new JSONObject(str));
                } catch (Exception e) {
                }
            }
        });
    }

    @Override // com.byazt.kq.hw
    @JavascriptInterface
    public void dynamicTrack(String str) {
        try {
            w(new JSONObject(str));
        } catch (Exception e) {
        }
    }

    @Override // com.byazt.kq.hw
    @JavascriptInterface
    public void changeVideoState(final String str) {
        com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.sd.nl.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    nl.this.uc(new JSONObject(str));
                } catch (Exception e) {
                }
            }
        });
    }

    @Override // com.byazt.kq.hw
    @JavascriptInterface
    public void clickEvent(final String str) {
        com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.sd.nl.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    nl.this.aj(new JSONObject(str));
                } catch (Exception e) {
                }
            }
        });
    }

    @Override // com.byazt.kq.hw
    @JavascriptInterface
    public void skipVideo() {
        com.byazt.xk.hw.pr().x(this.m, "stats_reward_full_call_skip_video");
        com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.sd.nl.9
            @Override // java.lang.Runnable
            public void run() {
                nl.this.nt();
            }
        });
    }

    @Override // com.byazt.kq.hw
    @JavascriptInterface
    public String getCurrentVideoState() {
        JSONObject jSONObject = new JSONObject();
        nt(jSONObject);
        return jSONObject.toString();
    }

    @Override // com.byazt.kq.hw
    @JavascriptInterface
    public void initRenderFinish() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.byazt.sd.nl.10
            @Override // java.lang.Runnable
            public void run() {
                if (nl.this.ls != null) {
                    com.byazt.lz.pr unused = nl.this.ls;
                }
            }
        });
    }

    @Override // com.byazt.kq.hw
    @JavascriptInterface
    public void requestPauseVideo(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.qa.pr(jSONObject.optInt("time"), jSONObject.optString("flag"));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("state_type", 2);
            jSONObject2.put("jsb_name", "requestPauseVideo");
            com.byazt.xk.hw.pr().pr(this.m, jSONObject2);
        } catch (JSONException e) {
        }
    }

    @Override // com.byazt.kq.hw
    @JavascriptInterface
    public String getData(String str) {
        if (TextUtils.isEmpty(str)) {
            return this.a.toString();
        }
        try {
            JSONObject jSONObjectPr = com.byazt.hc.hw.pr(this.a, new JSONObject(str));
            if (jSONObjectPr == null) {
                return this.a.toString();
            }
            return jSONObjectPr.toString();
        } catch (Exception e) {
            return this.a.toString();
        }
    }

    @JavascriptInterface
    public void reportJsbBridgeMissing(String str) {
        if (!this.od.compareAndSet(false, true)) {
            return;
        }
        final JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject2 = new JSONObject(str);
                jSONObject.putOpt(MediationConstant.KEY_REASON, jSONObject2.optString(MediationConstant.KEY_REASON));
                jSONObject.putOpt("msg_type", jSONObject2.optString("msg_type"));
                jSONObject.putOpt("event_id", jSONObject2.optString("event_id"));
            }
            jSONObject.putOpt("tag", this.s);
            com.byazt.son.x xVarQi = qi();
            if (xVarQi != null) {
                jSONObject.putOpt(BreakpointSQLiteKey.URL, xVarQi.getUrl());
            }
        } catch (Throwable th) {
        }
        com.byazt.xk.hw hwVarPr = com.byazt.xk.hw.pr();
        of ofVar = this.m;
        hwVarPr.pr("jsb_bridge_missing", ofVar == null ? null : ofVar.ny(), new com.byazt.ttf.pr() { // from class: com.byazt.sd.nl.11
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject3) throws JSONException {
                return jSONObject;
            }
        });
    }

    public void nt() {
        com.byazt.xk.hw.pr().x(this.m, "stats_reward_full_deal_skip_video");
        this.qa.uc();
    }

    public void yb() {
        this.qa.fw();
    }

    public void hn(of ofVar) {
        this.qa.pr(ofVar);
    }

    public void c(JSONObject jSONObject) {
        if (this.qa.w() == null || jSONObject == null) {
            return;
        }
        try {
            this.qa.w().pr(jSONObject.optBoolean("mute", false));
        } catch (Exception e) {
        }
    }

    public void uc(JSONObject jSONObject) {
        if (this.qa.w() == null || jSONObject == null) {
            return;
        }
        try {
            int iOptInt = jSONObject.optInt("stateType", -1);
            this.qa.w().pr(iOptInt);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("jsb_name", "changeVideoState");
            jSONObject2.put("state_type", iOptInt);
            com.byazt.xk.hw.pr().pr(this.m, jSONObject2);
        } catch (Exception e) {
        }
    }

    public void pr(float f) {
        if (this.qa.w() == null) {
            return;
        }
        try {
            this.qa.w().pr(f);
        } catch (Exception e) {
        }
    }

    public void lb() {
        this.qa.x();
    }

    public void qa() {
        this.qa.c();
    }

    public void x(int i) {
        this.qa.hw(i);
    }

    public void a() {
        WeakReference<com.byazt.oy.pr> weakReference = this.rc;
        if (weakReference != null && weakReference.get() != null) {
            this.rc.get().pr();
        } else {
            this.qa.vk();
        }
    }

    public void c(int i) {
        this.qa.x(i);
    }

    public void pr(float f, float f2, float f3, float f4, int i) {
        this.qa.pr(f, f2, f3, f4, i);
    }

    private boolean nt(JSONObject jSONObject) {
        if (this.qa.w() == null || jSONObject == null) {
            return false;
        }
        double dPr = this.qa.w().pr();
        int iHw = this.qa.w().hw();
        try {
            jSONObject.put("currentTime", dPr / 1000.0d);
            jSONObject.put("state", iHw);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private JSONObject r() {
        return pr(this.m, this.lv);
    }

    public static JSONObject pr(of ofVar, AtomicBoolean atomicBoolean) {
        int iX;
        int iC;
        boolean z;
        JSONObject jSONObject = new JSONObject();
        if (a.hw() == null) {
            return jSONObject;
        }
        try {
            int iM = ls.m(ofVar);
            int iK = ls.k(ofVar);
            boolean z2 = true;
            if (com.byazt.hg.ww.hw(true, ofVar, true)) {
                iX = 0;
            } else {
                iX = a.hw().x(iM);
            }
            if (com.byazt.hg.ww.hw(false, ofVar, true) || (com.byazt.hg.ve.pr(ofVar) && com.byazt.hg.ve.hw(ofVar) > 0)) {
                iC = 0;
            } else {
                iC = a.hw().c(iM);
            }
            boolean zC = a.hw().c(String.valueOf(iM));
            if (atomicBoolean == null) {
                z = ofVar.ax() == 1;
            } else {
                z = atomicBoolean.get();
            }
            jSONObject.put("ad_slot_type", iK);
            jSONObject.put("voice_control", z);
            jSONObject.put("rv_skip_time", iX);
            jSONObject.put("fv_skip_show", zC);
            jSONObject.put("iv_skip_time", iC);
            if (ofVar == null || !ofVar.zz()) {
                z2 = false;
            }
            jSONObject.put("show_dislike", z2);
            jSONObject.put("video_adaptation", ofVar != null ? ofVar.sr() : 0);
            jSONObject.put("h5_cache_resources_enable", com.byazt.hg.gz.pr);
            jSONObject.put("dark_mode_config", ie.pr());
            return jSONObject;
        } catch (Exception e) {
            return jSONObject;
        }
    }

    public int fw(JSONObject jSONObject) {
        if (jSONObject.optBoolean("interactShowDownloadDialog", false)) {
            this.m.hn(true);
            return 2;
        }
        if (jSONObject.optInt("downloadDialogStatus") != 1) {
            return 0;
        }
        if (this.m.z_().pr() == 2) {
            this.m.hn(true);
        }
        return 1;
    }

    private int yb(JSONObject jSONObject) {
        if (jSONObject == null) {
            return -1;
        }
        return jSONObject.optInt("forceShowDownloadDialog", -1);
    }

    @JProtect
    public void zo(JSONObject jSONObject) {
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
            com.byazt.hg.fo foVarPr = new com.byazt.hg.fo.pr().x((int) d9).hn((int) d).hw((int) d7).pr((int) d8).hw((long) d2).pr((long) d3).pr((int) d4).hw((int) d5).hn((int) d6).x((int) dOptDouble).pr(strOptString3).pr(true).pr(jSONObject2).pr((SparseArray<com.byazt.az.x.pr>) null).c(strOptString2).c(iOptInt2).pr();
            SoftReference<com.byazt.mq.w> softReference = this.lb;
            if (softReference != null && softReference.get() != null) {
                this.lb.get().hw(null, iOptInt, foVarPr, fw(jSONObject));
            }
            pr(strOptString, iOptInt, foVarPr);
        } catch (Exception e) {
            SoftReference<com.byazt.mq.w> softReference2 = this.lb;
            if (softReference2 != null && softReference2.get() != null) {
                this.lb.get().hw(null, -1, null, 0);
            }
        }
    }

    @JProtect
    public void aj(JSONObject jSONObject) {
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        double dOptDouble;
        double d7;
        double d8;
        SoftReference<com.byazt.mq.w> softReference;
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
            com.byazt.hg.yb.pr(jSONObject.optString("clickScene"));
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
                d2 = dOptDouble6;
                d3 = dOptDouble7;
                d4 = dOptDouble8;
                d5 = dOptDouble9;
                d6 = dOptDouble10;
                d7 = dOptDouble4;
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
            com.byazt.hg.fo foVarPr = new com.byazt.hg.fo.pr().x((float) d9).hn((float) d).hw((float) d7).pr((float) d8).hw((long) d2).pr((long) d3).pr((int) d4).hw((int) d5).hn((int) d6).x((int) dOptDouble).pr(strOptString2).hw(strOptString3).pr(true).pr((SparseArray<com.byazt.az.x.pr>) null).pr(jSONObject2).c(strOptString4).c(iOptInt2).pr();
            if (!pr(strOptString, iOptInt, foVarPr) && (softReference = this.lb) != null && softReference.get() != null) {
                this.lb.get().pr(null, iOptInt, foVarPr, yb(jSONObject));
            } else {
                hs();
            }
        } catch (Exception e) {
            SoftReference<com.byazt.mq.w> softReference2 = this.lb;
            if (softReference2 != null && softReference2.get() != null) {
                this.lb.get().pr(null, -1, null, -1);
            } else {
                hs();
            }
        }
    }

    private void hs() {
        u uVarF_;
        Context context;
        of ofVar = this.m;
        if (ofVar == null || (uVarF_ = ofVar.F_()) == null || uVarF_.hw() != 1 || uVarF_.uc() != 1) {
            return;
        }
        o();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", new JSONObject());
        } catch (Throwable th) {
        }
        WeakReference<Context> weakReference = this.uc;
        if (weakReference == null || (context = weakReference.get()) == null) {
            return;
        }
        this.fw.pr(context, jSONObject, this.vk, this.w, this.ho, true);
        pr(jSONObject, false);
    }

    public void vk(final JSONObject jSONObject) {
        com.byazt.ko.pr prVar = this.n;
        if (prVar != null) {
            prVar.hn(jSONObject);
        }
        com.byazt.xlm.c.hw(new com.byazt.xlm.fw("renderDidFinish") { // from class: com.byazt.sd.nl.12
            @Override // java.lang.Runnable
            public void run() {
                double dOptDouble;
                double d;
                double d2;
                boolean z;
                double d3;
                AnonymousClass12 anonymousClass12 = this;
                if (nl.this.lb == null || nl.this.lb.get() == null || jSONObject == null || nl.this.uc == null) {
                    return;
                }
                com.byazt.mq.g gVar = new com.byazt.mq.g();
                gVar.pr(1);
                try {
                    boolean zOptBoolean = jSONObject.optBoolean("isRenderSuc");
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("AdSize");
                    double dOptDouble2 = 0.0d;
                    if (jSONObjectOptJSONObject == null) {
                        dOptDouble = 0.0d;
                    } else {
                        dOptDouble2 = jSONObjectOptJSONObject.optDouble("width");
                        dOptDouble = jSONObjectOptJSONObject.optDouble("height");
                    }
                    JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("videoInfo");
                    if (jSONObjectOptJSONObject2 != null) {
                        try {
                            float f = ((Context) nl.this.uc.get()).getResources().getDisplayMetrics().density;
                            float f2 = Resources.getSystem().getDisplayMetrics().density;
                            double dOptDouble3 = jSONObjectOptJSONObject2.optDouble("x");
                            d = dOptDouble;
                            double dOptDouble4 = jSONObjectOptJSONObject2.optDouble("y");
                            d2 = dOptDouble2;
                            double dOptDouble5 = jSONObjectOptJSONObject2.optDouble("width");
                            double dOptDouble6 = jSONObjectOptJSONObject2.optDouble("height");
                            if (!nl.this.lb(jSONObjectOptJSONObject2)) {
                                z = zOptBoolean;
                                d3 = dOptDouble6;
                            } else {
                                double dOptDouble7 = jSONObjectOptJSONObject2.optDouble("borderRadiusTopLeft");
                                z = zOptBoolean;
                                double dOptDouble8 = jSONObjectOptJSONObject2.optDouble("borderRadiusTopRight");
                                d3 = dOptDouble6;
                                double dOptDouble9 = jSONObjectOptJSONObject2.optDouble("borderRadiusBottomLeft");
                                double dOptDouble10 = jSONObjectOptJSONObject2.optDouble("borderRadiusBottomRight");
                                if (a.hw().kq()) {
                                    gVar.pr(com.byazt.wt.er.hw(f, com.byazt.wt.er.pr(f2, (float) dOptDouble7)));
                                    gVar.hw(com.byazt.wt.er.hw(f, com.byazt.wt.er.pr(f2, (float) dOptDouble8)));
                                    gVar.hn(com.byazt.wt.er.hw(f, com.byazt.wt.er.pr(f2, (float) dOptDouble9)));
                                    gVar.x(com.byazt.wt.er.hw(f, com.byazt.wt.er.pr(f2, (float) dOptDouble10)));
                                } else {
                                    gVar.pr((float) dOptDouble7);
                                    gVar.hw((float) dOptDouble8);
                                    gVar.hn((float) dOptDouble9);
                                    gVar.x((float) dOptDouble10);
                                }
                            }
                            if (a.hw().kq()) {
                                gVar.hn(com.byazt.wt.er.hw(f, com.byazt.wt.er.pr(f2, (float) dOptDouble3)));
                                gVar.x(com.byazt.wt.er.hw(f, com.byazt.wt.er.pr(f2, (float) dOptDouble4)));
                                gVar.c(com.byazt.wt.er.hw(f, com.byazt.wt.er.pr(f2, (float) dOptDouble5)));
                                gVar.uc(com.byazt.wt.er.hw(f, com.byazt.wt.er.pr(f2, (float) d3)));
                            } else {
                                gVar.hn(dOptDouble3);
                                gVar.x(dOptDouble4);
                                gVar.c(dOptDouble5);
                                gVar.uc(d3);
                            }
                        } catch (Exception e) {
                            anonymousClass12 = this;
                            gVar.hw(101);
                            gVar.pr(fw.pr(101));
                            ((com.byazt.mq.w) nl.this.lb.get()).pr(gVar);
                            return;
                        }
                    } else {
                        z = zOptBoolean;
                        d2 = dOptDouble2;
                        d = dOptDouble;
                    }
                    anonymousClass12 = this;
                    String strOptString = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE, fw.pr(101));
                    int iOptInt = jSONObject.optInt(PluginConstants.KEY_ERROR_CODE, 101);
                    gVar.pr(z);
                    gVar.pr(d2);
                    gVar.hw(d);
                    gVar.pr(strOptString);
                    gVar.hw(iOptInt);
                    ((com.byazt.mq.w) nl.this.lb.get()).pr(gVar);
                } catch (Exception e2) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean lb(JSONObject jSONObject) {
        return jSONObject.has("borderRadiusTopLeft") && jSONObject.has("borderRadiusBottomLeft") && jSONObject.has("borderRadiusTopRight") && jSONObject.has("borderRadiusBottomRight");
    }

    public void w(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            Uri uri = Uri.parse(jSONObject.optString("trackData"));
            if ("bytedance".equals(uri.getScheme().toLowerCase())) {
                com.byazt.wt.cz.pr(uri, this);
            }
        } catch (Exception e) {
        }
    }

    private void qa(JSONObject jSONObject) {
        WeakReference<com.byazt.dp.c> weakReference;
        com.byazt.dp.c cVar;
        if (jSONObject == null || (weakReference = this.cz) == null || (cVar = weakReference.get()) == null) {
            return;
        }
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("temaiProductIds");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                cVar.pr(true, jSONArrayOptJSONArray);
            } else {
                cVar.pr(false, null);
            }
        } catch (Exception e) {
            cVar.pr(false, null);
        }
    }

    public boolean k(JSONObject jSONObject) {
        try {
            jSONObject.put("creatives", pr(this.gz));
            return true;
        } catch (Exception e) {
            return true;
        }
    }

    private void pr(final pr prVar, final JSONObject jSONObject) {
        if (prVar == null) {
            return;
        }
        try {
            pr(prVar.x, new com.byazt.ap.x() { // from class: com.byazt.sd.nl.13
                @Override // com.byazt.ap.x
                public void pr(boolean z, List<of> list, boolean z2) {
                    if (!z) {
                        nl.this.x(prVar.hw, jSONObject);
                        return;
                    }
                    try {
                        jSONObject.put("creatives", nl.pr(list));
                        nl.this.x(prVar.hw, jSONObject);
                    } catch (Exception e) {
                    }
                }
            });
        } catch (Exception e) {
        }
    }

    public void cz() {
        pr((JSONObject) null, new com.byazt.ap.x() { // from class: com.byazt.sd.nl.2
            @Override // com.byazt.ap.x
            public void pr(boolean z, List<of> list, boolean z2) {
                nl.this.gz = list;
                nl.this.nw();
                nl.this.ny();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nw() {
        Context context;
        List<of> list = this.gz;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.nl = new HashMap<>();
        SSWebView sSWebView = null;
        WeakReference<SSWebView> weakReference = this.x;
        if (weakReference != null) {
            sSWebView = weakReference.get();
        }
        WeakReference<Context> weakReference2 = this.uc;
        if (weakReference2 == null || (context = weakReference2.get()) == null) {
            return;
        }
        for (of ofVar : this.gz) {
            this.nl.put(ofVar.x(), new aj(context, ofVar, sSWebView, this.s));
        }
    }

    private boolean pr(String str, int i, com.byazt.hg.fo foVar) {
        HashMap<String, aj> map;
        aj ajVar;
        if (TextUtils.isEmpty(str) || (map = this.nl) == null || (ajVar = map.get(str)) == null) {
            return false;
        }
        ajVar.pr(i, foVar);
        return true;
    }

    public void pr(JSONObject jSONObject, com.byazt.ap.x xVar) {
        com.byazt.pk.hn.pr(this.m, jSONObject, xVar, (com.byazt.qe.hw) null);
    }

    public void ny() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("material", pr(this.gz));
            hw("materialMeta", jSONObject);
        } catch (Exception e) {
        }
    }

    private boolean ie() {
        of ofVar = this.m;
        if (ofVar == null || ofVar.cg() == null || com.byazt.wt.ny.hw(this.m) || this.y || this.m.cg().optInt("parent_type") != 2) {
            return false;
        }
        int iK = ls.k(this.m);
        if (iK != 8 && iK != 7) {
            return false;
        }
        this.y = true;
        return true;
    }

    public void vk(boolean z) {
        this.er = z;
    }

    public boolean fo() {
        return this.er;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String str, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__msg_type", "callback");
            jSONObject2.put("__callback_id", str);
            if (jSONObject != null) {
                jSONObject2.put("__params", jSONObject);
            }
            a(jSONObject2);
        } catch (Exception e) {
        }
    }

    private void a(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            cz(jSONObject);
        } else {
            lb.uc().post(new Runnable() { // from class: com.byazt.sd.nl.3
                @Override // java.lang.Runnable
                public void run() {
                    nl.this.cz(jSONObject);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cz(JSONObject jSONObject) {
        com.byazt.son.x xVarQi = qi();
        if (xVarQi != null) {
            com.byazt.ca.m.pr(xVarQi, "javascript:(function(){var __msg=" + jSONObject.toString() + ";var b=window.ToutiaoJSBridge;if(b&&typeof b._handleMessageFromToutiao==='function'){b._handleMessageFromToutiao(__msg);}else{var r=b?'handle_not_function':'bridge_null';var g=window.SDK_INJECT_GLOBAL;if(g&&typeof g.reportJsbBridgeMissing==='function'){g.reportJsbBridgeMissing(JSON.stringify({reason:r,msg_type:__msg.__msg_type,event_id:__msg.__event_id}));}}})();");
        }
    }

    private void c(String str, JSONObject jSONObject) {
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
            a(jSONObject2);
        } catch (Exception e) {
        }
    }

    private void zo(String str) {
        try {
            JSONArray jSONArray = new JSONArray(new String(Base64.decode(str, 2)));
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                pr prVar = new pr();
                try {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        prVar.pr = jSONObjectOptJSONObject.optString("__msg_type", null);
                        prVar.hw = jSONObjectOptJSONObject.optString("__callback_id", null);
                        prVar.hn = jSONObjectOptJSONObject.optString("func");
                        prVar.x = jSONObjectOptJSONObject.optJSONObject("params");
                        prVar.c = jSONObjectOptJSONObject.optInt("JSSDK");
                    }
                } catch (Throwable th) {
                }
                if (!TextUtils.isEmpty(prVar.pr) && !TextUtils.isEmpty(prVar.hn)) {
                    Message messageObtainMessage = this.c.obtainMessage(11);
                    messageObtainMessage.obj = prVar;
                    this.c.sendMessage(messageObtainMessage);
                }
            }
        } catch (Exception e) {
        }
    }

    public boolean pr(Uri uri) {
        if (uri == null) {
            return false;
        }
        try {
            if (!"bytedance".equals(uri.getScheme())) {
                return false;
            }
            if (hn.containsKey(uri.getHost())) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public void hw(final Uri uri) {
        long j;
        long j2;
        JSONObject jSONObjectM;
        of ofVar;
        try {
            String host = uri.getHost();
            if (!"log_event".equals(host) && !"custom_event".equals(host) && !"log_event_v3".equals(host)) {
                if ("private".equals(host) || "dispatch_message".equals(host)) {
                    com.byazt.ca.aj.hw().post(new Runnable() { // from class: com.byazt.sd.nl.4
                        @Override // java.lang.Runnable
                        public void run() {
                            nl.this.aj(uri.toString());
                        }
                    });
                    return;
                }
                return;
            }
            String queryParameter = uri.getQueryParameter("category");
            String queryParameter2 = uri.getQueryParameter("tag");
            String queryParameter3 = uri.getQueryParameter("label");
            if (!uc(queryParameter3)) {
                return;
            }
            if (com.byazt.hg.s.hw(this.m) && TextUtils.equals(queryParameter3, "track")) {
                return;
            }
            try {
                j = Long.parseLong(uri.getQueryParameter(Constants.VALUE_FIELD));
            } catch (Exception e) {
                j = 0;
            }
            if (j == 0 && (ofVar = this.m) != null) {
                try {
                    j = Long.parseLong(ofVar.x());
                } catch (Exception e2) {
                }
            }
            try {
                j2 = Long.parseLong(uri.getQueryParameter("ext_value"));
            } catch (Exception e3) {
                j2 = 0;
            }
            JSONObject jSONObject = new JSONObject();
            String queryParameter4 = uri.getQueryParameter("extra");
            if (!TextUtils.isEmpty(queryParameter4)) {
                try {
                    jSONObject = new JSONObject(queryParameter4);
                } catch (Exception e4) {
                }
            }
            pr(queryParameter3, jSONObject);
            if (!"click".equals(queryParameter3)) {
                jSONObjectM = jSONObject;
            } else {
                jSONObjectM = m(jSONObject);
                WeakReference<com.byazt.ap.c> weakReference = this.fo;
                if (weakReference != null && weakReference.get() != null) {
                    this.fo.get().hw();
                }
            }
            String strPr = pr(queryParameter2, queryParameter3);
            if (TextUtils.isEmpty(strPr)) {
                strPr = queryParameter2;
            }
            String strOptString = jSONObjectM.optString("log_extra");
            if (this.m != null && queryParameter3.contains("sanfang") && TextUtils.isEmpty(strOptString)) {
                jSONObjectM.putOpt("log_extra", this.m.B_());
            }
            com.byazt.pj.pr.pr(queryParameter, strPr, queryParameter3, j, j2, jSONObjectM, this.l);
        } catch (Exception e5) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void pr(int i, of ofVar, int i2, int i3) {
        WeakReference<Context> weakReference = this.uc;
        if (weakReference == null || ofVar == null || weakReference.get() == null) {
            return;
        }
        Context context = this.uc.get();
        com.byazt.az.pr prVar = new com.byazt.az.pr(context, ofVar, this.s, this.w);
        com.byazt.lxw.pr.pr().pr(ofVar.hashCode() + ofVar.ny()).put("live_saas_interaction_type", Integer.valueOf(i2));
        if (i == 0) {
            ((com.byazt.yx.pr) prVar.pr(com.byazt.yx.pr.class)).hw(true);
        }
        final String strX = ofVar.x();
        com.byazt.nv.hn hnVarHw = this.vj.get(strX);
        if (hnVarHw == null) {
            if (i3 == 1) {
                if (ofVar.aj() == 4) {
                    hnVarHw = com.byazt.jx.zo.pr(context, ofVar, this.s);
                }
            } else {
                hnVarHw = com.byazt.jx.zo.hw(context, ofVar, this.s);
            }
            if (hnVarHw != null) {
                hnVarHw.pr(new com.byazt.nv.pr() { // from class: com.byazt.sd.nl.5
                    @Override // com.byazt.nv.pr
                    public void pr() {
                        com.byazt.dp.pr.pr(strX);
                    }

                    @Override // com.byazt.nv.pr
                    public void pr(long j, long j2, String str, String str2) {
                        com.byazt.dp.pr.pr(strX, j, j2);
                    }

                    @Override // com.byazt.nv.pr
                    public void hw(long j, long j2, String str, String str2) {
                        com.byazt.dp.pr.hw(strX, j, j2);
                    }

                    @Override // com.byazt.nv.pr
                    public void hn(long j, long j2, String str, String str2) {
                        com.byazt.dp.pr.hn(strX, j, j2);
                    }

                    @Override // com.byazt.nv.pr
                    public void pr(long j, String str, String str2) {
                        com.byazt.dp.pr.hw(strX);
                    }

                    @Override // com.byazt.nv.pr
                    public void pr(String str, String str2) {
                        com.byazt.dp.pr.hn(strX);
                    }
                });
                pr(strX, hnVarHw);
            }
        }
        if (hnVarHw != null) {
            ((com.byazt.dl.pr) prVar.pr(com.byazt.dl.pr.class)).pr(hnVarHw);
        }
        prVar.pr(null, new com.byazt.hg.vk());
        if (f()) {
            WeakReference<com.byazt.uq.aj> weakReference2 = this.bm;
            if (weakReference2 != null && weakReference2.get() != null) {
                this.bm.get().x();
                return;
            }
            return;
        }
        if (context instanceof com.byazt.hb.hw) {
            ((com.byazt.hb.hw) context).pr(1);
        }
    }

    public boolean uc(String str) {
        return TextUtils.isEmpty(str) || !"click_other".equals(str) || rc();
    }

    public boolean rc() {
        of ofVar = this.m;
        return ofVar != null && com.byazt.hg.qa.zo(ofVar) == 1;
    }

    public JSONObject m(JSONObject jSONObject) {
        com.byazt.qe.hw hwVarP;
        if (this.pr != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                String strOptString = jSONObject.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, null);
                if (strOptString != null) {
                    jSONObject2 = new JSONObject(strOptString);
                }
                if (iu.fw()) {
                    try {
                        of ofVar = this.m;
                        if (ofVar != null && (hwVarP = ofVar.p()) != null) {
                            String strM = hwVarP.m();
                            if (!TextUtils.isEmpty(strM)) {
                                jSONObject2.putOpt("media_extra", strM);
                            }
                        }
                    } catch (Exception e) {
                    }
                }
                for (Map.Entry<String, Object> entry : this.pr.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            } catch (Exception e2) {
                com.byazt.ca.ho.pr(e2.toString());
            }
        }
        return jSONObject;
    }

    public void pr(String str, JSONObject jSONObject) {
        String strOptString;
        String strOptString2;
        String strOptString3;
        String strOptString4;
        String str2 = "show";
        String strHw = "";
        try {
            JSONArray jSONArray = null;
            if ("show".equals(str)) {
                jSONArray = jSONObject.optJSONArray("show_url");
            } else if (!"click".equals(str)) {
                str2 = null;
            } else {
                jSONArray = jSONObject.getJSONArray("click_url");
                str2 = "click";
            }
            if (jSONArray != null && jSONArray.length() != 0) {
                String strPr = com.byazt.wt.nt.pr();
                if (TextUtils.isEmpty(strPr)) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
                String strOptString5 = jSONObject.optString("log_extra");
                try {
                    JSONObject jSONObject2 = new JSONObject(strOptString5);
                    strOptString = jSONObject2.optString(MediationConstant.EXTRA_ADID);
                    try {
                        strOptString2 = jSONObject2.optString("creative_id");
                        try {
                            strOptString3 = jSONObject2.optString("req_id");
                            try {
                                strOptString4 = jSONObject2.optString("customer_id");
                                try {
                                    strHw = ls.hw(jSONObject2.optInt("ad_slot_type"));
                                } catch (Throwable th) {
                                }
                            } catch (Throwable th2) {
                                strOptString4 = "";
                            }
                        } catch (Throwable th3) {
                            strOptString3 = "";
                            strOptString4 = strOptString3;
                        }
                    } catch (Throwable th4) {
                        strOptString2 = "";
                        strOptString3 = strOptString2;
                        strOptString4 = strOptString3;
                        HashMap map = new HashMap();
                        map.put("aid", strOptString);
                        map.put("cid", strOptString2);
                        map.put("req_id", strOptString3);
                        map.put("customer_id", strOptString4);
                        com.byazt.lg.pr.pr(zo.nt().ny()).pr(strPr, arrayList, true, map, com.byazt.pj.pr.pr(strOptString5, strOptString, strOptString3, strHw, str2));
                    }
                } catch (Throwable th5) {
                    strOptString = "";
                    strOptString2 = strOptString;
                }
                HashMap map2 = new HashMap();
                map2.put("aid", strOptString);
                map2.put("cid", strOptString2);
                map2.put("req_id", strOptString3);
                map2.put("customer_id", strOptString4);
                com.byazt.lg.pr.pr(zo.nt().ny()).pr(strPr, arrayList, true, map2, com.byazt.pj.pr.pr(strOptString5, strOptString, strOptString3, strHw, str2));
            }
        } catch (Throwable th6) {
        }
    }

    public void z() {
        of ofVar = this.m;
        if (ofVar == null) {
            return;
        }
        com.byazt.wt.c.hw(ofVar, this.uc.get(), ve());
    }

    public void b() {
        of ofVar = this.m;
        if (ofVar == null) {
            return;
        }
        com.byazt.wt.c.hn(ofVar, this.uc.get(), ve());
    }

    public JSONObject iu() {
        JSONObject jSONObject = new JSONObject();
        of ofVar = this.m;
        if (ofVar == null) {
            return jSONObject;
        }
        String strXy = ofVar.xy();
        if (!TextUtils.isEmpty(strXy)) {
            try {
                return new JSONObject(strXy);
            } catch (Exception e) {
                return jSONObject;
            }
        }
        return jSONObject;
    }

    public String ve() {
        return ls.pr(this.w);
    }

    public String pr(String str, String str2) {
        if (((!"landing_perf_stats".equals(str2) && !"landing_perf_exception".equals(str2)) || !"landingpage".equals(str)) && this.lb == null && !f()) {
            return ls.pr(this.w);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj(String str) {
        int length;
        int iIndexOf;
        if (str == null || !str.startsWith("bytedance://")) {
            return;
        }
        try {
            if (!str.equals("bytedance://dispatch_message/")) {
                if (!str.startsWith("bytedance://private/setresult/") || (iIndexOf = str.indexOf(38, (length = "bytedance://private/setresult/".length()))) <= 0) {
                    return;
                }
                String strSubstring = str.substring(length, iIndexOf);
                String strSubstring2 = str.substring(iIndexOf + 1);
                if (strSubstring.equals("SCENE_FETCHQUEUE") && strSubstring2.length() > 0) {
                    zo(strSubstring2);
                    return;
                }
                return;
            }
            com.byazt.son.x xVarQi = qi();
            if (xVarQi != null) {
                com.byazt.ca.m.pr(xVarQi, "javascript:ToutiaoJSBridge._fetchQueue()");
            }
        } catch (Exception e) {
        }
    }

    public void gz() {
        com.byazt.dp.x xVar = this.fw;
        if (xVar != null) {
            xVar.pr();
        }
        if (ie()) {
            cz();
        }
    }

    public void nl() {
        com.byazt.dp.x xVar = this.fw;
        if (xVar != null) {
            xVar.hw();
        }
        this.qi = false;
    }

    public void y() {
        c();
        com.byazt.dp.x xVar = this.fw;
        if (xVar != null) {
            xVar.hn();
        }
        for (com.byazt.nv.hn hnVar : this.vj.values()) {
            if (hnVar != null) {
                hnVar.hn();
            }
        }
        this.vj.clear();
        WeakReference<SSWebView> weakReference = this.x;
        if (weakReference != null) {
            weakReference.clear();
        }
        WeakReference<View> weakReference2 = this.aj;
        if (weakReference2 != null) {
            weakReference2.clear();
        }
        WeakReference<Context> weakReference3 = this.uc;
        if (weakReference3 != null) {
            weakReference3.clear();
        }
        this.ls = null;
        this.hs = null;
    }

    @Override // com.byazt.vkw.qi.pr
    public void pr(Message message) {
        if (message == null) {
        }
        switch (message.what) {
            case 11:
                if (message.obj instanceof pr) {
                    try {
                        pr((pr) message.obj, 1);
                    } catch (Exception e) {
                        return;
                    }
                }
                break;
        }
    }

    public void g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.zo = jSONObject.optString("cid");
        this.vk = jSONObject.optString("log_extra");
    }

    private void o() {
        if (this.fw == null) {
            this.fw = com.byazt.dp.hw.pr(this, this.m, this.of);
        }
    }

    public void pr(String str, boolean z) {
        com.byazt.dp.x xVar = this.fw;
        if (xVar != null) {
            xVar.pr(str, z);
        }
    }

    public void pr(String str, com.byazt.nv.hn hnVar) {
        this.vj.put(str, hnVar);
    }

    public com.byazt.nv.hn fw(String str) {
        return this.vj.get(str);
    }

    @Override // com.byazt.dp.hn
    public void hw(String str, JSONObject jSONObject) {
        er();
        c(str, jSONObject);
    }

    public void hn(String str, JSONObject jSONObject) {
        try {
            com.byazt.ee.yb ybVar = this.e;
            if (ybVar != null) {
                ybVar.pr(str, jSONObject);
            }
        } catch (Throwable th) {
            com.byazt.ca.ho.pr("TTAndroidObject", "sendJsMsg2020 error", th);
        }
    }

    public void ww() {
        WeakReference<com.byazt.ap.c> weakReference = this.fo;
        if (weakReference != null && weakReference.get() != null) {
            this.fo.get().pr();
        }
    }

    public void pr(JSONObject jSONObject, boolean z) {
        WeakReference<Context> weakReference;
        if (this.fw != null && (weakReference = this.uc) != null && weakReference.get() != null) {
            this.fw.pr(this.yb && this.nt);
            this.fw.hw(z);
            this.fw.hn(this.l == 3);
            this.fw.pr(this.uc.get(), jSONObject, this.s, this.vk);
        }
    }

    public int n() {
        if (this.qa.w() == null) {
            return 0;
        }
        return this.qa.w().hn();
    }

    public void pr(com.byazt.ap.uc ucVar) {
        this.gu = new WeakReference<>(ucVar);
    }

    public void w(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("visibleState", z ? 0 : 1);
        } catch (Exception e) {
            com.byazt.ca.ho.hw("TTAndroidObject", e.getMessage());
        }
        c("visibleStateChange", jSONObject);
    }

    public void e() {
        WeakReference<com.byazt.ap.uc> weakReference = this.gu;
        if (weakReference != null && weakReference.get() != null) {
            this.gu.get().pr();
        }
    }

    private boolean f() {
        if (this.bm != null) {
            return true;
        }
        return false;
    }

    public void pr(int i, int i2) {
        int iHn = com.byazt.wt.er.hn(a.getContext(), i);
        int iHn2 = com.byazt.wt.er.hn(a.getContext(), i2);
        WeakReference<com.byazt.uq.aj> weakReference = this.bm;
        if (weakReference != null && weakReference.get() != null) {
            this.bm.get().pr(Integer.MIN_VALUE, Integer.MIN_VALUE, iHn, iHn2);
        }
    }

    public void pr(int i, int i2, int i3, int i4) {
        int iHn;
        int iHn2;
        int iHn3;
        int iHn4 = Integer.MIN_VALUE;
        if (i != Integer.MAX_VALUE && i2 != Integer.MAX_VALUE) {
            iHn = com.byazt.wt.er.hn(a.getContext(), i);
            iHn2 = com.byazt.wt.er.hn(a.getContext(), i2);
        } else {
            iHn = Integer.MIN_VALUE;
            iHn2 = Integer.MIN_VALUE;
        }
        if (i3 != Integer.MAX_VALUE && i4 != Integer.MAX_VALUE) {
            iHn4 = com.byazt.wt.er.hn(a.getContext(), i3);
            iHn3 = com.byazt.wt.er.hn(a.getContext(), i4);
        } else {
            iHn3 = Integer.MIN_VALUE;
        }
        WeakReference<com.byazt.uq.aj> weakReference = this.bm;
        if (weakReference != null && weakReference.get() != null) {
            this.bm.get().pr(iHn, iHn2, iHn4, iHn3);
        }
    }

    public void k(boolean z) {
        this.lv = new AtomicBoolean(z);
    }

    public void s() {
        if (this.qa.w() != null) {
            this.qa.w().zo();
        }
    }

    public void hw(int i, int i2) {
        this.qa.pr(i, i2);
    }

    public void pr(byte b) {
        this.l = b;
    }

    public byte ls() {
        return this.l;
    }

    public void hw(int i, int i2, int i3, int i4) {
        WeakReference<com.byazt.ak.hn> weakReference = this.mw;
        if (weakReference != null && weakReference.get() != null) {
            this.mw.get().pr(i, i2, i3, i4);
        } else {
            this.sv = new int[]{i, i2, i3, i4};
        }
    }

    public void pr(com.byazt.ak.hn hnVar) {
        if (hnVar == null) {
            this.mw = null;
            return;
        }
        int[] iArr = this.sv;
        if (iArr != null && iArr.length == 4) {
            hnVar.pr(iArr[0], iArr[1], iArr[2], iArr[3]);
        } else {
            this.mw = new WeakReference<>(hnVar);
        }
    }
}
