package com.byazt.gcl;

import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import android.view.View;
import android.webkit.JavascriptInterface;
import androidx.core.app.NotificationCompat;
import com.byazt.cf.cy;
import com.byazt.cf.d;
import com.byazt.gct.dw;
import com.byazt.gct.pk;
import com.byazt.gct.su;
import com.byazt.gct.wv;
import com.byazt.ho.BaseConstants;
import com.byazt.kfh.SSWebView;
import com.byazt.pmn.AppDownloadListener;
import com.byazt.pmn.ITTInnerDownloadAdapter;
import com.byazt.rg.x;
import com.byazt.tk.k;
import com.byazt.tk.t;
import com.byazt.udb.cp;
import com.byazt.uv.fs;
import com.byazt.uv.l;
import com.byazt.uv.w;
import com.byazt.vf.wo;
import com.byazt.vs.a;
import com.byazt.vs.ae;
import com.byazt.vs.an;
import com.byazt.vs.b;
import com.byazt.vs.bb;
import com.byazt.vs.cd;
import com.byazt.vs.df;
import com.byazt.vs.dg;
import com.byazt.vs.dh;
import com.byazt.vs.e;
import com.byazt.vs.f;
import com.byazt.vs.fi;
import com.byazt.vs.h;
import com.byazt.vs.hu;
import com.byazt.vs.j;
import com.byazt.vs.lh;
import com.byazt.vs.ln;
import com.byazt.vs.m;
import com.byazt.vs.nf;
import com.byazt.vs.oj;
import com.byazt.vs.ou;
import com.byazt.vs.pe;
import com.byazt.vs.py;
import com.byazt.vs.rf;
import com.byazt.vs.ri;
import com.byazt.vs.rv;
import com.byazt.vs.sh;
import com.byazt.vs.sz;
import com.byazt.vs.tj;
import com.byazt.vs.u;
import com.byazt.vs.um;
import com.byazt.vs.ur;
import com.byazt.vs.v;
import com.byazt.vs.wm;
import com.byazt.vs.y;
import com.byazt.za.hd;
import com.byazt.za.oa;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.JProtect;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.google.android.gms.common.internal.ImagesContract;
import com.smartdigimkt.sdk.api.SDMAdConst;
import com.taptap.sdk.login.internal.handlers.web.WebLoginFragment;
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

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 61, 8})
public class s implements com.byazt.gjp.qg, wo.n, com.byazt.ll.s {
    public static final Map<String, Boolean> n;
    public static volatile boolean nf;
    public JSONObject a;
    public String ae;
    public cy an;
    public WeakReference<hd> b;
    public List<pk> bb;
    public SoftReference<cp> cd;
    public WeakReference<com.byazt.vhv.s> ci;
    public int cp;
    public String d;
    public WeakReference<com.byazt.ozc.qg> dh;
    public AtomicBoolean e;
    public boolean fi;
    public String fs;
    public WeakReference<com.byazt.uv.qg> h;
    public JSONObject hu;
    public com.byazt.vgn.q j;
    public HashMap<String, qg> ln;
    public WeakReference<l> m;
    public pk oa;
    public boolean oj;
    public WeakReference<com.byazt.uv.n> ou;
    public WeakReference<com.byazt.ll.l> py;
    public WeakReference<SSWebView> q;
    public Map<String, Object> qg;
    public List<JSONObject> rf;
    public WeakReference<x> ri;
    public WeakReference<View> rv;
    public com.byazt.ep.qg sh;
    public String sz;
    public WeakReference<com.byazt.uv.s> t;
    public String tj;
    public WeakReference<fs> ur;
    public final WeakReference<Context> w;
    public WeakReference<w> wm;
    public com.byazt.mr.x.n wo;
    public com.byazt.ll.q x;
    public JSONObject y;
    public WeakReference<com.byazt.uv.x> z;
    public boolean s = false;
    public boolean k = false;
    public boolean cy = true;
    public boolean hd = true;
    public final oa um = new oa();
    public boolean lh = false;
    public boolean v = false;
    public boolean f = false;
    public boolean df = false;
    public boolean dg = false;
    public boolean u = false;
    public boolean pk = false;
    public byte pe = -1;
    public final AtomicBoolean yw = new AtomicBoolean(false);
    public final Map<String, Integer> cx = new ConcurrentHashMap();
    public final AtomicBoolean lq = new AtomicBoolean(false);
    public final Map<String, ITTInnerDownloadAdapter> ic = new ConcurrentHashMap();
    public int[] hf = null;
    public boolean kc = false;
    public t l = new t(Looper.getMainLooper(), this);

    @com.byazt.cp.n(n = {0, 1, 61, 546})
    public static class n {
        public int l;
        public String n;
        public JSONObject q;
        public String qg;
        public String s;
    }

    @Override // com.byazt.gjp.qg
    @JavascriptInterface
    public void adAnalysisData(String str) {
    }

    @Override // com.byazt.gjp.qg
    @JavascriptInterface
    public void initRenderFinish() {
    }

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        n = concurrentHashMap;
        concurrentHashMap.put("log_event", Boolean.TRUE);
        concurrentHashMap.put("private", Boolean.TRUE);
        concurrentHashMap.put("dispatch_message", Boolean.TRUE);
        concurrentHashMap.put("custom_event", Boolean.TRUE);
        concurrentHashMap.put("log_event_v3", Boolean.TRUE);
        nf = false;
    }

    public s(Context context) {
        this.w = new WeakReference<>(context);
        com.byazt.vgx.w.w();
    }

    public Context getContext() {
        return this.w.get();
    }

    public static JSONArray n(List<pk> list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null) {
            return jSONArray;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put(list.get(i).pv());
        }
        return jSONArray;
    }

    public s n(String str) {
        this.ae = str;
        return this;
    }

    public s n(boolean z) {
        this.dg = z;
        return this;
    }

    private boolean fi() {
        return com.byazt.vyf.s.cy().pk();
    }

    public s n(SSWebView sSWebView) {
        k.qg("webviewpool", "===useJsb2 webView hashCode:" + sSWebView.hashCode());
        if (sSWebView == null) {
            return this;
        }
        cy cyVarQg = cy.n(sSWebView).n(new com.byazt.gcl.n()).n("ToutiaoJSBridge").n(new d() { // from class: com.byazt.gcl.s.1
            @Override // com.byazt.cf.d
            public <T> T n(String str, Type type) {
                return null;
            }

            @Override // com.byazt.cf.d
            public <T> String n(T t) {
                return null;
            }
        }).n(fi()).qg(true).n().qg();
        this.an = cyVarQg;
        h.n(cyVarQg, this);
        com.byazt.vs.w.n(this.an, this);
        com.byazt.vs.fs.n(this.an, this, this.oa);
        com.byazt.vs.hd.n(this.an);
        v.n(this.an, sSWebView);
        tj.n(this.an, this);
        sz.n(this.an, this);
        dh.n(this.an, this);
        rf.n(this.an, this);
        m.n(this.an, this);
        py.n(this.an, this);
        oj.n(this.an, this);
        rv.n(this.an, this);
        b.n(this.an, this);
        nf.n(this.an, this);
        df.n(this.an, this);
        df();
        com.byazt.vs.s.n(this.an, this.q.get(), this.fs);
        an.n(this.an, this.q.get(), this.fs);
        com.byazt.vs.qg.n(this.an, this.q.get(), this.fs);
        j.n(this.an, this.q.get(), this.fs);
        com.byazt.vs.x.n(this.an, this);
        hu.n(this.an, this);
        y.n(this.an, this);
        um.n(this.an, this);
        cd.n(this.an, this.oa);
        bb.n(this.an, this.w.get(), this.oa);
        com.byazt.vs.t.n(this.an, this.w.get());
        com.byazt.vs.oa.n(this.an, this.oa, this.rf);
        sh.n(this.an, this);
        lh.n(this.an, this, this.dh);
        fi.n(this.an, this, this.dh);
        e.n(this.an, sSWebView, this);
        com.byazt.vs.d.n(this.an, this.oa, this);
        com.byazt.vs.cy.n(this.an, this.oa, this);
        pe.n(this.an, this.wo);
        ri.n(this.an, this);
        ae.n(this.an, this.sh);
        f.n(this.an, this, this.oa);
        com.byazt.vs.k.n(this.an, this.a);
        com.byazt.vs.cp.n(this.an, this.oa, this);
        com.byazt.vs.n.n(this.an, this.w.get());
        com.byazt.vs.pk.n(this.an, this.oa);
        com.byazt.vs.q.n(this.an, this);
        ln.n(this.an, this);
        wm.n(this.an, this, this.w.get(), this.oa);
        com.byazt.vs.l.n(this.an);
        ou.n(this.an);
        ur.n(this.an, this, this.oa);
        com.byazt.vs.wo.n(this.an, this);
        a.n(this.an, this.oa);
        dg.n(this.an, this.oa);
        u.n(this, this.an, this.oa);
        return this;
    }

    private void df() {
        pk pkVar;
        WeakReference<SSWebView> weakReference = this.q;
        if (weakReference == null || weakReference.get() == null || (pkVar = this.oa) == null) {
            return;
        }
        int iMp = pkVar.mp();
        int iIm = this.oa.im();
        int iEu = this.oa.eu();
        int iQd = this.oa.qd();
        int iOn = this.oa.on();
        JSONObject jSONObjectKv = this.oa.kv();
        JSONObject jSONObjectRk = this.oa.rk();
        JSONObject jSONObjectBs = this.oa.bs();
        this.q.get().setShakeValue(iMp);
        this.q.get().setDeepShakeValue(iIm);
        this.q.get().setWriggleValue(iEu);
        this.q.get().setTwistConfig(jSONObjectKv);
        this.q.get().setShakeInteractConf(jSONObjectRk);
        this.q.get().setTwistInteractConf(jSONObjectBs);
        this.q.get().setCalculationMethod(iQd);
        this.q.get().setCalculationTwistMethod(iOn);
    }

    public JSONObject n() {
        WeakReference<x> weakReference = this.ri;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.ri.get().getContainerInfo();
    }

    public JSONObject qg() {
        WeakReference<x> weakReference = this.ri;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.ri.get().getCreativeVideoViewInfo();
    }

    public void n(SSWebView.qg qgVar) {
        WeakReference<SSWebView> weakReference = this.q;
        if (weakReference == null || weakReference.get() == null || qgVar == null) {
            return;
        }
        this.q.get().setOnShakeListener(qgVar);
    }

    public s n(hd hdVar) {
        this.b = new WeakReference<>(hdVar);
        return this;
    }

    public s n(com.byazt.ozc.qg qgVar) {
        this.dh = new WeakReference<>(qgVar);
        return this;
    }

    public s n(x xVar) {
        this.ri = new WeakReference<>(xVar);
        return this;
    }

    public x s() {
        WeakReference<x> weakReference = this.ri;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public boolean q() {
        WeakReference<SSWebView> weakReference = this.q;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        return this.q.get().T_();
    }

    public static void qg(boolean z) {
        nf = z;
    }

    public void n(int i) {
        if (nf) {
            return;
        }
        if (i != 1) {
            if (i == 2) {
                qg("twist_callback", (JSONObject) null);
            }
        } else {
            if (this.oa != null && q()) {
                com.byazt.wif.w.q = true;
            }
            qg("wobble_callback", (JSONObject) null);
        }
    }

    public void s(boolean z) {
        this.fi = z;
        this.df = z;
    }

    public void q(boolean z) {
        this.oj = z;
    }

    public int l(boolean z) {
        if (!this.df && com.byazt.gct.ae.n(this.oa) != 0 && z) {
            return 2;
        }
        if (this.fi) {
            return 1;
        }
        if (this.oj) {
            return com.byazt.gct.ae.n(this.oa) == 2 ? 2 : 1;
        }
        return com.byazt.gct.ae.n(this.oa) == 0 ? 1 : 2;
    }

    public void l() {
        sh();
        cy cyVar = this.an;
        if (cyVar == null) {
            return;
        }
        cyVar.n();
        this.an = null;
    }

    public cy w() {
        return this.an;
    }

    private com.byazt.uad.q oj() {
        WeakReference<SSWebView> weakReference = this.q;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public s qg(SSWebView sSWebView) {
        this.q = new WeakReference<>(sSWebView);
        return this;
    }

    public s n(com.byazt.vgn.q qVar) {
        this.j = qVar;
        return this;
    }

    public s w(boolean z) {
        this.v = z;
        return this;
    }

    public s qg(String str) {
        this.fs = str;
        return this;
    }

    public s n(View view) {
        this.rv = new WeakReference<>(view);
        return this;
    }

    public s qg(List<JSONObject> list) {
        this.rf = list;
        return this;
    }

    public s qg(int i) {
        this.k = true;
        return this;
    }

    public boolean x() {
        return this.u;
    }

    public void x(boolean z) {
        this.u = z;
    }

    public void fs(boolean z) {
        this.pk = z;
    }

    private JSONObject dg() {
        try {
            View view = this.rv.get();
            SSWebView sSWebView = this.q.get();
            if (view == null || sSWebView == null) {
                k.qg("TTAndroidObject", "setCloseButtonInfo error closeButton is null");
                return null;
            }
            int[] iArrQg = com.byazt.okk.s.qg(view);
            int[] iArrQg2 = com.byazt.okk.s.qg(sSWebView);
            if (iArrQg != null && iArrQg2 != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(com.byazt.af.x.n, com.byazt.okk.s.q(com.byazt.nf.rv.getContext(), iArrQg[0] - iArrQg2[0]));
                jSONObject.put("y", com.byazt.okk.s.q(com.byazt.nf.rv.getContext(), iArrQg[1] - iArrQg2[1]));
                jSONObject.put("w", com.byazt.okk.s.q(com.byazt.nf.rv.getContext(), view.getWidth()));
                jSONObject.put("h", com.byazt.okk.s.q(com.byazt.nf.rv.getContext(), view.getHeight()));
                jSONObject.put("isExist", true);
                return jSONObject;
            }
            k.qg("TTAndroidObject", "setCloseButtonInfo error position or webViewPosition is null");
            return null;
        } catch (Throwable unused) {
        }
    }

    public s n(com.byazt.uv.qg qgVar) {
        this.h = new WeakReference<>(qgVar);
        return this;
    }

    public s n(com.byazt.uv.s sVar) {
        this.t = new WeakReference<>(sVar);
        return this;
    }

    public s n(fs fsVar) {
        this.ur = new WeakReference<>(fsVar);
        return this;
    }

    public pk fs() {
        return this.oa;
    }

    public s n(pk pkVar) {
        this.oa = pkVar;
        return this;
    }

    public s s(String str) {
        this.sz = str;
        return this;
    }

    public boolean rv() {
        pk pkVar = this.oa;
        return pkVar != null && pkVar.vo();
    }

    public s q(String str) {
        this.tj = str;
        return this;
    }

    public s s(int i) {
        this.cp = i;
        return this;
    }

    public s l(String str) {
        this.d = str;
        return this;
    }

    public s n(cp cpVar) {
        this.cd = new SoftReference<>(cpVar);
        return this;
    }

    public s n(com.byazt.za.d dVar) {
        this.um.n(dVar);
        return this;
    }

    public s n(com.byazt.ll.l lVar) {
        this.py = new WeakReference<>(lVar);
        return this;
    }

    public s n(JSONObject jSONObject) {
        this.hu = jSONObject;
        return this;
    }

    public s n(Map<String, Object> map) {
        this.qg = map;
        return this;
    }

    public s n(com.byazt.uv.n nVar) {
        this.ou = new WeakReference<>(nVar);
        return this;
    }

    public s n(w wVar) {
        this.wm = new WeakReference<>(wVar);
        return this;
    }

    public WeakReference<w> tj() {
        return this.wm;
    }

    public s n(l lVar) {
        this.m = new WeakReference<>(lVar);
        return this;
    }

    public s s(List<pk> list) {
        this.bb = list;
        return this;
    }

    public boolean cp() {
        return this.s;
    }

    public void rv(boolean z) {
        this.s = z;
    }

    public void n(com.byazt.mr.x.n nVar) {
        this.wo = nVar;
    }

    public void n(com.byazt.ep.qg qgVar) {
        this.sh = qgVar;
    }

    public void qg(JSONObject jSONObject) {
        this.y = jSONObject;
    }

    public JSONObject d() {
        return this.y;
    }

    public boolean qg(pk pkVar) {
        WeakReference<hd> weakReference;
        hd hdVar;
        if (pkVar != null && (weakReference = this.b) != null && (hdVar = weakReference.get()) != null) {
            hdVar.qg(pkVar);
        }
        return false;
    }

    private static List<String> u() {
        return Arrays.asList("appInfo", "adInfo", "getTemplateInfo", "getTeMaiAds");
    }

    public static void n(JSONObject jSONObject, int i) throws Exception {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = u().iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        jSONObject.put("appName", com.byazt.ges.qg.n());
        jSONObject.put("innerAppName", com.byazt.ges.qg.w());
        jSONObject.put("aid", com.byazt.ges.qg.qg());
        jSONObject.put("sdkEdition", com.byazt.ges.qg.s());
        jSONObject.put("sdkApiVersion", com.byazt.ges.qg.q());
        jSONObject.put("appVersion", com.byazt.ges.qg.l());
        jSONObject.put("netType", com.byazt.ges.qg.x());
        jSONObject.put("supportList", jSONArray);
        jSONObject.put("deviceId", com.byazt.ges.qg.fs());
        jSONObject.put("osVersion", Build.VERSION.SDK_INT);
        jSONObject.put("appId", com.byazt.vyf.s.cy().ou());
        if (com.byazt.gct.nf.n(i)) {
            jSONObject.put("themeStatus", com.byazt.vyf.s.cy().dh());
        }
    }

    public JSONObject oa() throws Exception {
        return com.byazt.ns.qg.n(this.oa, this.sz);
    }

    /* JADX WARN: Code duplicated, block: B:170:0x0274 A[PHI: r1
      0x0274: PHI (r1v21 org.json.JSONObject) = (r1v15 org.json.JSONObject), (r1v22 org.json.JSONObject) binds: [B:169:0x0272, B:158:0x0244] A[DONT_GENERATE, DONT_INLINE]] */
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
    public JSONObject n(n nVar, int i) throws Exception {
        Context context;
        JSONObject jSONObjectDg;
        if (!NotificationCompat.CATEGORY_CALL.equals(nVar.n)) {
            return null;
        }
        if (i == 1) {
            fs(nVar.s);
        }
        fi();
        JSONObject jSONObject = new JSONObject();
        String str = nVar.s;
        str.hashCode();
        switch (str) {
            case "subscribe_app_ad":
                ri();
                WeakReference<Context> weakReference = this.w;
                if (weakReference != null && (context = weakReference.get()) != null) {
                    this.x.n(context, nVar.q, this.tj, this.cp, this.k, this.pk);
                    break;
                }
                break;
            case "adInfoStash":
                sz(nVar.q);
                break;
            case "adInfo":
                jSONObject = oa();
                break;
            case "pauseWebView":
                pk();
                break;
            case "changeVideoState":
                w(nVar.q);
                break;
            case "webview_time_track":
                s(nVar.q);
                break;
            case "clickEvent":
                rv(nVar.q);
                break;
            case "appInfo":
                n(jSONObject, com.byazt.vgx.w.d(this.oa));
                break;
            case "getScreenSize":
                WeakReference<com.byazt.uv.n> weakReference2 = this.ou;
                com.byazt.uv.n nVar2 = weakReference2 != null ? weakReference2.get() : null;
                if (nVar2 != null) {
                    int iQg = nVar2.qg();
                    int iN = nVar2.n();
                    jSONObject.put("width", iQg);
                    jSONObject.put("height", iN);
                    break;
                }
                break;
            case "getMaterialMeta":
                d(jSONObject);
                break;
            case "send_temai_product_ids":
                um(nVar.q);
                break;
            case "getTeMaiAds":
                jSONObjectDg = this.hu;
                if (jSONObjectDg != null) {
                    jSONObject = jSONObjectDg;
                    break;
                }
                break;
            case "download_app_ad":
                tj(true);
                n(nVar.q, nVar.q != null ? nVar.q.optBoolean("is_compliant_download") : false);
                break;
            case "unsubscribe_app_ad":
                com.byazt.ll.q qVar = this.x;
                if (qVar != null) {
                    qVar.n(nVar.q);
                    break;
                }
                break;
            case "getDownloadStatus":
                jSONObject = com.byazt.vs.hd.n(nVar.q);
                break;
            case "getCloseButtonInfo":
                jSONObjectDg = dg();
                if (jSONObjectDg != null) {
                    jSONObject = jSONObjectDg;
                    break;
                }
                break;
            case "isViewable":
                jSONObject.put("viewStatus", this.v ? 1 : 0);
                break;
            case "sendReward":
                this.s = true;
                int iOptInt = nVar.q != null ? nVar.q.optInt(MediationConstant.KEY_REWARD_TYPE) : 0;
                WeakReference<w> weakReference3 = this.wm;
                if (weakReference3 != null && weakReference3.get() != null) {
                    this.wm.get().n(iOptInt);
                }
                this.um.s(iOptInt);
                break;
            case "dynamicTrack":
                cp(nVar.q);
                break;
            case "getTemplateInfo":
                k();
                jSONObject = this.a;
                break;
            case "cancel_download_app_ad":
                com.byazt.ll.q qVar2 = this.x;
                if (qVar2 != null) {
                    qVar2.qg(nVar.q);
                    break;
                }
                break;
            case "getCurrentVideoState":
                cy(jSONObject);
                break;
            case "getVolume":
                AudioManager audioManager = (AudioManager) com.byazt.nf.rv.getContext().getSystemService(MediaFormat.KEY_AUDIO);
                jSONObject.put("endcard_mute", (audioManager != null ? audioManager.getStreamVolume(3) : -1) <= 0);
                break;
            case "pauseWebViewTimers":
                wo();
                break;
            case "muteVideo":
                l(nVar.q);
                break;
            case "renderDidFinish":
                tj(nVar.q);
                break;
            case "endcard_load":
                k(nVar.q);
                break;
            case "getNetworkData":
                n(nVar, jSONObject);
                break;
            case "skipVideo":
                cy();
                break;
        }
        if (i == 1 && !TextUtils.isEmpty(nVar.qg)) {
            q(nVar.qg, jSONObject);
            fi();
        }
        return jSONObject;
    }

    public void s(JSONObject jSONObject) {
        com.byazt.vgn.q qVar;
        if (jSONObject == null || (qVar = this.j) == null) {
            return;
        }
        qVar.s(jSONObject);
    }

    private void qg(String str, boolean z) {
        if (this.j == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (z) {
            this.j.w(str);
        } else {
            this.j.x(str);
        }
    }

    private void pk() {
        WeakReference<fs> weakReference = this.ur;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.ur.get().n();
    }

    private void wo() {
        WeakReference<fs> weakReference = this.ur;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.ur.get().qg();
    }

    private void k(JSONObject jSONObject) {
        WeakReference<com.byazt.uv.qg> weakReference = this.h;
        if (weakReference == null || jSONObject == null || weakReference.get() == null) {
            return;
        }
        this.h.get().n(jSONObject.optBoolean("isRenderSuc", false), jSONObject.optInt("code", -1), jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE, ""));
    }

    public void sz() {
        WeakReference<com.byazt.uv.s> weakReference = this.t;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.t.get().n();
    }

    @Override // com.byazt.gjp.qg
    @JavascriptInterface
    public String adInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject = oa();
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.byazt.gjp.qg
    @JavascriptInterface
    public String appInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            n(jSONObject, com.byazt.vgx.w.d(this.oa));
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.byazt.gjp.qg
    @JavascriptInterface
    public String getTemplateInfo() {
        qg("getTemplateInfo", true);
        try {
            k();
            qg("getTemplateInfo", false);
            return this.a.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public s q(JSONObject jSONObject) {
        this.a = jSONObject;
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x000e A[Catch: Exception -> 0x0022, TRY_LEAVE, TryCatch #0 {Exception -> 0x0022, blocks: (B:4:0x0004, B:5:0x000a, B:7:0x000e), top: B:11:0x0004 }] */
    public JSONObject k() {
        JSONObject jSONObject = this.a;
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
                if (this.oa != null) {
                    jSONObject.put("setting", y());
                    jSONObject.put("extension", this.oa.it());
                }
            } catch (Exception unused) {
            }
        } else if (this.oa != null) {
            jSONObject.put("setting", y());
            jSONObject.put("extension", this.oa.it());
        }
        this.a = jSONObject;
        return jSONObject;
    }

    @Override // com.byazt.gjp.qg
    @JavascriptInterface
    public void renderDidFinish(String str) {
        try {
            tj(new JSONObject(str));
        } catch (Exception unused) {
        }
    }

    @Override // com.byazt.gjp.qg
    @JavascriptInterface
    public void muteVideo(final String str) {
        com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.gcl.s.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    s.this.l(new JSONObject(str));
                } catch (Exception unused) {
                }
            }
        });
    }

    @Override // com.byazt.gjp.qg
    @JavascriptInterface
    public void dynamicTrack(String str) {
        try {
            cp(new JSONObject(str));
        } catch (Exception unused) {
        }
    }

    @Override // com.byazt.gjp.qg
    @JavascriptInterface
    public void changeVideoState(final String str) {
        com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.gcl.s.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    s.this.w(new JSONObject(str));
                } catch (Exception unused) {
                }
            }
        });
    }

    @Override // com.byazt.gjp.qg
    @JavascriptInterface
    public void clickEvent(final String str) {
        com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.gcl.s.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    s.this.rv(new JSONObject(str));
                } catch (Exception unused) {
                }
            }
        });
    }

    @Override // com.byazt.gjp.qg
    @JavascriptInterface
    public void skipVideo() {
        com.byazt.eji.s.n().q(this.oa, "stats_reward_full_call_skip_video");
        com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.gcl.s.8
            @Override // java.lang.Runnable
            public void run() {
                s.this.cy();
            }
        });
    }

    @Override // com.byazt.gjp.qg
    @JavascriptInterface
    public String getCurrentVideoState() {
        JSONObject jSONObject = new JSONObject();
        cy(jSONObject);
        return jSONObject.toString();
    }

    @Override // com.byazt.gjp.qg
    @JavascriptInterface
    public void requestPauseVideo(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.um.n(jSONObject.optInt("time"), jSONObject.optString("flag"));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("state_type", 2);
            jSONObject2.put("jsb_name", "requestPauseVideo");
            com.byazt.eji.s.n().n(this.oa, jSONObject2);
        } catch (JSONException unused) {
        }
    }

    @Override // com.byazt.gjp.qg
    @JavascriptInterface
    public String getData(String str) {
        if (TextUtils.isEmpty(str)) {
            return this.a.toString();
        }
        try {
            JSONObject jSONObjectN = com.byazt.ns.qg.n(this.a, new JSONObject(str));
            if (jSONObjectN == null) {
                return this.a.toString();
            }
            return jSONObjectN.toString();
        } catch (Exception unused) {
            return this.a.toString();
        }
    }

    @JavascriptInterface
    public void reportJsbBridgeMissing(String str) {
        if (this.yw.compareAndSet(false, true)) {
            final JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(str)) {
                    JSONObject jSONObject2 = new JSONObject(str);
                    jSONObject.putOpt(MediationConstant.KEY_REASON, jSONObject2.optString(MediationConstant.KEY_REASON));
                    jSONObject.putOpt("msg_type", jSONObject2.optString("msg_type"));
                    jSONObject.putOpt("event_id", jSONObject2.optString("event_id"));
                }
                jSONObject.putOpt("tag", this.ae);
                com.byazt.uad.q qVarOj = oj();
                if (qVarOj != null) {
                    jSONObject.putOpt(ImagesContract.URL, qVarOj.getUrl());
                }
            } catch (Throwable unused) {
            }
            com.byazt.eji.s sVarN = com.byazt.eji.s.n();
            pk pkVar = this.oa;
            sVarN.n("jsb_bridge_missing", pkVar == null ? null : pkVar.ou(), new com.byazt.rs.n() { // from class: com.byazt.gcl.s.9
                @Override // com.byazt.rs.n
                public JSONObject n(JSONObject jSONObject3) throws JSONException {
                    return jSONObject;
                }
            });
        }
    }

    private void fs(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Integer num = this.cx.get(str);
        this.cx.put(str, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    private void sh() {
        if (!this.cx.isEmpty() && this.lq.compareAndSet(false, true)) {
            JSONObject jSONObject = new JSONObject();
            try {
                String strN = com.byazt.vgx.w.n(this.cp);
                if (TextUtils.isEmpty(strN)) {
                    strN = String.valueOf(this.cp);
                }
                jSONObject.putOpt("scene", strN);
                jSONObject.putOpt("tag", this.ae);
                pk pkVar = this.oa;
                if (pkVar != null) {
                    dw dwVarX = com.byazt.gct.nf.x(pkVar);
                    if (dwVarX != null) {
                        jSONObject.putOpt("dynamic_layout_id", dwVarX.qg());
                    }
                    su suVarFs = com.byazt.gct.nf.fs(this.oa);
                    if (suVarFs != null) {
                        jSONObject.putOpt("dynamic_v3_id", suVarFs.n());
                    }
                    jSONObject.putOpt("target_url", this.oa.fs());
                    jSONObject.putOpt("direct_landing_url", com.byazt.gct.cd.fs(this.oa));
                }
                JSONObject jSONObject2 = new JSONObject();
                int i = 0;
                for (Map.Entry<String, Integer> entry : this.cx.entrySet()) {
                    int iIntValue = entry.getValue() == null ? 0 : entry.getValue().intValue();
                    jSONObject2.put(entry.getKey(), iIntValue);
                    i += iIntValue;
                }
                jSONObject.putOpt("jsb_calls", jSONObject2);
                jSONObject.putOpt("total_count", Integer.valueOf(i));
            } catch (Throwable unused) {
            }
            com.byazt.eji.s.n().qg(this.oa, "jsb1_call_stats", jSONObject);
        }
    }

    public void cy() {
        com.byazt.eji.s.n().q(this.oa, "stats_reward_full_deal_skip_video");
        this.um.w();
    }

    public void hd() {
        this.um.x();
    }

    public void s(pk pkVar) {
        this.um.n(pkVar);
    }

    public void l(JSONObject jSONObject) {
        if (this.um.cp() == null || jSONObject == null) {
            return;
        }
        try {
            this.um.cp().n(jSONObject.optBoolean("mute", false));
        } catch (Exception unused) {
        }
    }

    public void w(JSONObject jSONObject) {
        if (this.um.cp() == null || jSONObject == null) {
            return;
        }
        try {
            int iOptInt = jSONObject.optInt("stateType", -1);
            this.um.cp().n(iOptInt);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("jsb_name", "changeVideoState");
            jSONObject2.put("state_type", iOptInt);
            com.byazt.eji.s.n().n(this.oa, jSONObject2);
        } catch (Exception unused) {
        }
    }

    public void n(float f) {
        if (this.um.cp() == null) {
            return;
        }
        try {
            this.um.cp().n(f);
        } catch (Exception unused) {
        }
    }

    public void cd() {
        this.um.q();
    }

    public void um() {
        this.um.l();
    }

    public void q(int i) {
        this.um.qg(i);
    }

    public void a() {
        WeakReference<l> weakReference = this.m;
        if (weakReference != null && weakReference.get() != null) {
            this.m.get().n();
        } else {
            this.um.tj();
        }
    }

    public void l(int i) {
        this.um.q(i);
    }

    public void n(float f, float f2, float f3, float f4, int i) {
        this.um.n(f, f2, f3, f4, i);
    }

    private boolean cy(JSONObject jSONObject) {
        if (this.um.cp() != null && jSONObject != null) {
            double dN = this.um.cp().n();
            int iQg = this.um.cp().qg();
            try {
                jSONObject.put("currentTime", dN / 1000.0d);
                jSONObject.put(WebLoginFragment.QUERY_KEY_ID, iQg);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private JSONObject y() {
        return n(this.oa, this.e);
    }

    public static JSONObject n(pk pkVar, AtomicBoolean atomicBoolean) {
        boolean z;
        JSONObject jSONObject = new JSONObject();
        if (com.byazt.nf.rv.qg() == null) {
            return jSONObject;
        }
        try {
            int iCy = com.byazt.vgx.w.cy(pkVar);
            int iD = com.byazt.vgx.w.d(pkVar);
            boolean z2 = true;
            int iS = com.byazt.gct.j.qg(true, pkVar, true) ? 0 : com.byazt.nf.rv.qg().s(iCy);
            int iQ = (com.byazt.gct.j.qg(false, pkVar, true) || (com.byazt.gct.ur.n(pkVar) && com.byazt.gct.ur.qg(pkVar) > 0)) ? 0 : com.byazt.nf.rv.qg().q(iCy);
            boolean zL = com.byazt.nf.rv.qg().l(String.valueOf(iCy));
            if (atomicBoolean != null) {
                z = atomicBoolean.get();
            } else {
                z = pkVar.kj() == 1;
            }
            jSONObject.put("ad_slot_type", iD);
            jSONObject.put("voice_control", z);
            jSONObject.put("rv_skip_time", iS);
            jSONObject.put("fv_skip_show", zL);
            jSONObject.put("iv_skip_time", iQ);
            if (pkVar == null || !pkVar.yv()) {
                z2 = false;
            }
            jSONObject.put("show_dislike", z2);
            jSONObject.put("video_adaptation", pkVar != null ? pkVar.qh() : 0);
            jSONObject.put("h5_cache_resources_enable", com.byazt.gct.ln.n);
            jSONObject.put("dark_mode_config", com.byazt.gct.nf.n());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public int x(JSONObject jSONObject) {
        if (jSONObject.optBoolean("interactShowDownloadDialog", false)) {
            this.oa.l(true);
            return 2;
        }
        if (jSONObject.optInt("downloadDialogStatus") != 1) {
            return 0;
        }
        if (this.oa.D_().n() == 2) {
            this.oa.l(true);
        }
        return 1;
    }

    private int hd(JSONObject jSONObject) {
        if (jSONObject == null) {
            return -1;
        }
        return jSONObject.optInt("forceShowDownloadDialog", -1);
    }

    @JProtect
    public void fs(JSONObject jSONObject) {
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
            com.byazt.gct.wm wmVarN = new com.byazt.gct.wm.n().q((int) d9).s((int) d).qg((int) d7).n((int) d8).qg((long) d2).n((long) d3).n((int) d4).qg((int) d5).s((int) d6).q((int) dOptDouble).n(strOptString3).n(true).n(jSONObject2).n((SparseArray<com.byazt.ys.l.n>) null).l(strOptString2).l(iOptInt2).n();
            SoftReference<cp> softReference = this.cd;
            if (softReference != null && softReference.get() != null) {
                this.cd.get().qg(null, iOptInt, wmVarN, x(jSONObject));
            }
            n(strOptString, iOptInt, wmVarN);
        } catch (Exception unused) {
            SoftReference<cp> softReference2 = this.cd;
            if (softReference2 == null || softReference2.get() == null) {
                return;
            }
            this.cd.get().qg(null, -1, null, 0);
        }
    }

    @JProtect
    public void rv(JSONObject jSONObject) {
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        double dOptDouble;
        double d7;
        double d8;
        SoftReference<cp> softReference;
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
            com.byazt.gct.hd.n(jSONObject.optString("clickScene"));
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
            com.byazt.gct.wm wmVarN = new com.byazt.gct.wm.n().q((float) d9).s((float) d).qg((float) d7).n((float) d8).qg((long) d2).n((long) d3).n((int) d4).qg((int) d5).s((int) d6).q((int) dOptDouble).n(strOptString2).qg(strOptString3).n(true).n((SparseArray<com.byazt.ys.l.n>) null).n(jSONObject2).l(strOptString4).l(iOptInt2).n();
            if (!n(strOptString, iOptInt, wmVarN) && (softReference = this.cd) != null && softReference.get() != null) {
                this.cd.get().n(null, iOptInt, wmVarN, hd(jSONObject));
            } else {
                rf();
            }
        } catch (Exception unused) {
            SoftReference<cp> softReference2 = this.cd;
            if (softReference2 != null && softReference2.get() != null) {
                this.cd.get().n(null, -1, null, -1);
            } else {
                rf();
            }
        }
    }

    private void rf() {
        wv wvVarJ_;
        Context context;
        pk pkVar = this.oa;
        if (pkVar != null && (wvVarJ_ = pkVar.J_()) != null && wvVarJ_.qg() == 1 && wvVarJ_.w() == 1) {
            ri();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(com.anythink.core.common.l.f.R, new JSONObject());
            } catch (Throwable unused) {
            }
            WeakReference<Context> weakReference = this.w;
            if (weakReference == null || (context = weakReference.get()) == null) {
                return;
            }
            this.x.n(context, jSONObject, this.tj, this.cp, this.k, true);
            n(jSONObject, false);
        }
    }

    public void tj(final JSONObject jSONObject) {
        com.byazt.vgn.q qVar = this.j;
        if (qVar != null) {
            qVar.qg(jSONObject);
        }
        com.byazt.qit.l.qg(new com.byazt.qit.x("renderDidFinish") { // from class: com.byazt.gcl.s.10
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
                if (s.this.cd == null || s.this.cd.get() == null || jSONObject == null || s.this.w == null) {
                    return;
                }
                com.byazt.udb.sz szVar = new com.byazt.udb.sz();
                szVar.n(1);
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
                        float f = ((Context) s.this.w.get()).getResources().getDisplayMetrics().density;
                        float f2 = Resources.getSystem().getDisplayMetrics().density;
                        double dOptDouble3 = jSONObjectOptJSONObject2.optDouble(com.byazt.af.x.n);
                        z = zOptBoolean;
                        double dOptDouble4 = jSONObjectOptJSONObject2.optDouble("y");
                        d2 = dOptDouble2;
                        double dOptDouble5 = jSONObjectOptJSONObject2.optDouble("width");
                        double dOptDouble6 = jSONObjectOptJSONObject2.optDouble("height");
                        if (s.this.cd(jSONObjectOptJSONObject2)) {
                            d = dOptDouble;
                            double dOptDouble7 = jSONObjectOptJSONObject2.optDouble("borderRadiusTopLeft");
                            d4 = dOptDouble6;
                            double dOptDouble8 = jSONObjectOptJSONObject2.optDouble("borderRadiusTopRight");
                            d5 = dOptDouble5;
                            double dOptDouble9 = jSONObjectOptJSONObject2.optDouble("borderRadiusBottomLeft");
                            d3 = dOptDouble4;
                            double dOptDouble10 = jSONObjectOptJSONObject2.optDouble("borderRadiusBottomRight");
                            if (com.byazt.nf.rv.qg().yj()) {
                                szVar.n(com.byazt.okk.s.qg(f, com.byazt.okk.s.n(f2, (float) dOptDouble7)));
                                szVar.qg(com.byazt.okk.s.qg(f, com.byazt.okk.s.n(f2, (float) dOptDouble8)));
                                szVar.s(com.byazt.okk.s.qg(f, com.byazt.okk.s.n(f2, (float) dOptDouble9)));
                                szVar.q(com.byazt.okk.s.qg(f, com.byazt.okk.s.n(f2, (float) dOptDouble10)));
                            } else {
                                szVar.n((float) dOptDouble7);
                                szVar.qg((float) dOptDouble8);
                                szVar.s((float) dOptDouble9);
                                szVar.q((float) dOptDouble10);
                            }
                        } else {
                            d3 = dOptDouble4;
                            d4 = dOptDouble6;
                            d = dOptDouble;
                            d5 = dOptDouble5;
                        }
                        if (com.byazt.nf.rv.qg().yj()) {
                            szVar.s(com.byazt.okk.s.qg(f, com.byazt.okk.s.n(f2, (float) dOptDouble3)));
                            szVar.q(com.byazt.okk.s.qg(f, com.byazt.okk.s.n(f2, (float) d3)));
                            szVar.l(com.byazt.okk.s.qg(f, com.byazt.okk.s.n(f2, (float) d5)));
                            szVar.w(com.byazt.okk.s.qg(f, com.byazt.okk.s.n(f2, (float) d4)));
                        } else {
                            szVar.s(dOptDouble3);
                            szVar.q(d3);
                            szVar.l(d5);
                            szVar.w(d4);
                        }
                    } else {
                        z = zOptBoolean;
                        d = dOptDouble;
                        d2 = dOptDouble2;
                    }
                    try {
                        String strOptString = jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE, com.byazt.bxg.n.n(101));
                        int iOptInt = jSONObject.optInt("code", 101);
                        szVar.n(z);
                        szVar.n(d);
                        szVar.qg(d2);
                        szVar.n(strOptString);
                        szVar.qg(iOptInt);
                        ((cp) s.this.cd.get()).n(szVar);
                    } catch (Exception unused) {
                        i = 101;
                        szVar.qg(i);
                        szVar.n(com.byazt.bxg.n.n(i));
                        ((cp) s.this.cd.get()).n(szVar);
                    }
                } catch (Exception unused2) {
                    i = 101;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cd(JSONObject jSONObject) {
        return jSONObject.has("borderRadiusTopLeft") && jSONObject.has("borderRadiusBottomLeft") && jSONObject.has("borderRadiusTopRight") && jSONObject.has("borderRadiusBottomRight");
    }

    public void cp(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            Uri uri = Uri.parse(jSONObject.optString("trackData"));
            if ("bytedance".equals(uri.getScheme().toLowerCase())) {
                com.byazt.qq.n.n(uri, this);
            }
        } catch (Exception unused) {
        }
    }

    private void um(JSONObject jSONObject) {
        WeakReference<com.byazt.ll.l> weakReference;
        com.byazt.ll.l lVar;
        if (jSONObject == null || (weakReference = this.py) == null || (lVar = weakReference.get()) == null) {
            return;
        }
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("temaiProductIds");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                lVar.n(true, jSONArrayOptJSONArray);
            } else {
                lVar.n(false, null);
            }
        } catch (Exception unused) {
            lVar.n(false, null);
        }
    }

    public boolean d(JSONObject jSONObject) {
        try {
            jSONObject.put("creatives", n(this.bb));
        } catch (Exception unused) {
        }
        return true;
    }

    private void n(final n nVar, final JSONObject jSONObject) {
        if (nVar == null) {
            return;
        }
        try {
            n(nVar.q, new com.byazt.uv.q() { // from class: com.byazt.gcl.s.11
                @Override // com.byazt.uv.q
                public void n(boolean z, List<pk> list, boolean z2) {
                    if (!z) {
                        s.this.q(nVar.qg, jSONObject);
                        return;
                    }
                    try {
                        jSONObject.put("creatives", s.n(list));
                        s.this.q(nVar.qg, jSONObject);
                    } catch (Exception unused) {
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    public void py() {
        n((JSONObject) null, new com.byazt.uv.q() { // from class: com.byazt.gcl.s.12
            @Override // com.byazt.uv.q
            public void n(boolean z, List<pk> list, boolean z2) {
                s.this.bb = list;
                s.this.dh();
                s.this.ou();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dh() {
        Context context;
        List<pk> list = this.bb;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.ln = new HashMap<>();
        WeakReference<SSWebView> weakReference = this.q;
        SSWebView sSWebView = weakReference != null ? weakReference.get() : null;
        WeakReference<Context> weakReference2 = this.w;
        if (weakReference2 == null || (context = weakReference2.get()) == null) {
            return;
        }
        for (pk pkVar : this.bb) {
            this.ln.put(pkVar.q(), new qg(context, pkVar, sSWebView, this.ae));
        }
    }

    private boolean n(String str, int i, com.byazt.gct.wm wmVar) {
        HashMap<String, qg> map;
        qg qgVar;
        if (TextUtils.isEmpty(str) || (map = this.ln) == null || (qgVar = map.get(str)) == null) {
            return false;
        }
        qgVar.n(i, wmVar);
        return true;
    }

    public void n(JSONObject jSONObject, com.byazt.uv.q qVar) {
        com.byazt.jc.q.n(this.oa, jSONObject, qVar, (com.byazt.zq.qg) null);
    }

    public void ou() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("material", n(this.bb));
            qg("materialMeta", jSONObject);
        } catch (Exception unused) {
        }
    }

    private boolean b() {
        pk pkVar = this.oa;
        if (pkVar == null || pkVar.vh() == null || com.byazt.qq.qg.qg(this.oa) || this.lh || this.oa.vh().optInt("parent_type") != 2) {
            return false;
        }
        int iD = com.byazt.vgx.w.d(this.oa);
        if (iD != 8 && iD != 7) {
            return false;
        }
        this.lh = true;
        return true;
    }

    public void tj(boolean z) {
        this.f = z;
    }

    public boolean wm() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(String str, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__msg_type", "callback");
            jSONObject2.put("__callback_id", str);
            if (jSONObject != null) {
                jSONObject2.put("__params", jSONObject);
            }
            a(jSONObject2);
        } catch (Exception unused) {
        }
    }

    private void a(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        com.byazt.vyf.l.q().post(new Runnable() { // from class: com.byazt.gcl.s.2
            @Override // java.lang.Runnable
            public void run() {
                s.this.py(jSONObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void py(JSONObject jSONObject) {
        com.byazt.uad.q qVarOj = oj();
        if (qVarOj != null) {
            com.byazt.tk.oa.n(qVarOj, "javascript:(function(){var __msg=" + jSONObject.toString() + ";var b=window.ToutiaoJSBridge;if(b&&typeof b._handleMessageFromToutiao==='function'){b._handleMessageFromToutiao(__msg);}else{var r=b?'handle_not_function':'bridge_null';var g=window.SDK_INJECT_GLOBAL;if(g&&typeof g.reportJsbBridgeMissing==='function'){g.reportJsbBridgeMissing(JSON.stringify({reason:r,msg_type:__msg.__msg_type,event_id:__msg.__event_id}));}}})();");
        }
    }

    private void l(String str, JSONObject jSONObject) {
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
        } catch (Exception unused) {
        }
    }

    private void rv(String str) {
        try {
            JSONArray jSONArray = new JSONArray(new String(Base64.decode(str, 2)));
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                n nVar = new n();
                try {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        nVar.n = jSONObjectOptJSONObject.optString("__msg_type", null);
                        nVar.qg = jSONObjectOptJSONObject.optString("__callback_id", null);
                        nVar.s = jSONObjectOptJSONObject.optString("func");
                        nVar.q = jSONObjectOptJSONObject.optJSONObject("params");
                        nVar.l = jSONObjectOptJSONObject.optInt("JSSDK");
                    }
                } catch (Throwable unused) {
                }
                if (!TextUtils.isEmpty(nVar.n) && !TextUtils.isEmpty(nVar.s)) {
                    Message messageObtainMessage = this.l.obtainMessage(11);
                    messageObtainMessage.obj = nVar;
                    this.l.sendMessage(messageObtainMessage);
                }
            }
        } catch (Exception unused2) {
        }
    }

    public boolean n(Uri uri) {
        if (uri == null) {
            return false;
        }
        try {
            if (!"bytedance".equals(uri.getScheme())) {
                return false;
            }
            if (n.containsKey(uri.getHost())) {
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public void qg(final Uri uri) {
        long j;
        JSONObject jSONObjectOa;
        pk pkVar;
        try {
            String host = uri.getHost();
            if (!"log_event".equals(host) && !"custom_event".equals(host) && !"log_event_v3".equals(host)) {
                if ("private".equals(host) || "dispatch_message".equals(host)) {
                    com.byazt.tk.rv.qg().post(new Runnable() { // from class: com.byazt.gcl.s.3
                        @Override // java.lang.Runnable
                        public void run() {
                            s.this.tj(uri.toString());
                        }
                    });
                    return;
                }
                return;
            }
            String queryParameter = uri.getQueryParameter("category");
            String queryParameter2 = uri.getQueryParameter("tag");
            String queryParameter3 = uri.getQueryParameter("label");
            if (w(queryParameter3)) {
                if (com.byazt.gct.f.qg(this.oa) && TextUtils.equals(queryParameter3, "track")) {
                    return;
                }
                long j2 = 0;
                try {
                    j = Long.parseLong(uri.getQueryParameter(com.anythink.core.common.f.e.a.d));
                } catch (Exception unused) {
                    j = 0;
                }
                if (j == 0 && (pkVar = this.oa) != null) {
                    try {
                        j = Long.parseLong(pkVar.q());
                    } catch (Exception unused2) {
                    }
                }
                try {
                    j2 = Long.parseLong(uri.getQueryParameter("ext_value"));
                } catch (Exception unused3) {
                }
                long j3 = j2;
                JSONObject jSONObject = new JSONObject();
                String queryParameter4 = uri.getQueryParameter("extra");
                if (!TextUtils.isEmpty(queryParameter4)) {
                    try {
                        jSONObject = new JSONObject(queryParameter4);
                    } catch (Exception unused4) {
                    }
                }
                n(queryParameter3, jSONObject);
                if ("click".equals(queryParameter3)) {
                    jSONObjectOa = oa(jSONObject);
                    WeakReference<w> weakReference = this.wm;
                    if (weakReference != null && weakReference.get() != null) {
                        this.wm.get().qg();
                    }
                } else {
                    jSONObjectOa = jSONObject;
                }
                String strN = n(queryParameter2, queryParameter3);
                if (TextUtils.isEmpty(strN)) {
                    strN = queryParameter2;
                }
                String strOptString = jSONObjectOa.optString("log_extra");
                if (this.oa != null && queryParameter3.contains("sanfang") && TextUtils.isEmpty(strOptString)) {
                    jSONObjectOa.putOpt("log_extra", this.oa.F_());
                }
                com.byazt.hm.n.n(queryParameter, strN, queryParameter3, j, j3, jSONObjectOa, this.pe);
            }
        } catch (Exception unused5) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void n(int i, pk pkVar, int i2, int i3) {
        WeakReference<Context> weakReference = this.w;
        if (weakReference == null || pkVar == null || weakReference.get() == null) {
            return;
        }
        Context context = this.w.get();
        com.byazt.ys.n nVar = new com.byazt.ys.n(context, pkVar, this.ae, this.cp);
        com.byazt.wu.n.n().n(pkVar.hashCode() + pkVar.ou()).put("live_saas_interaction_type", Integer.valueOf(i2));
        if (i == 0) {
            ((com.byazt.fq.n) nVar.n(com.byazt.fq.n.class)).qg(true);
        }
        final String strQ = pkVar.q();
        ITTInnerDownloadAdapter iTTInnerDownloadAdapterQg = this.ic.get(strQ);
        if (iTTInnerDownloadAdapterQg == null) {
            if (i3 == 1) {
                if (pkVar.rv() == 4) {
                    iTTInnerDownloadAdapterQg = com.byazt.iz.fs.n(context, pkVar, this.ae);
                }
            } else {
                iTTInnerDownloadAdapterQg = com.byazt.iz.fs.qg(context, pkVar, this.ae);
            }
            if (iTTInnerDownloadAdapterQg != null) {
                iTTInnerDownloadAdapterQg.addAppDownloadListener(new AppDownloadListener() { // from class: com.byazt.gcl.s.4
                    @Override // com.byazt.pmn.AppDownloadListener
                    public void onIdle() {
                        com.byazt.ll.n.n(strQ);
                    }

                    @Override // com.byazt.pmn.AppDownloadListener
                    public void onDownloadActive(long j, long j2, String str, String str2) {
                        com.byazt.ll.n.n(strQ, j, j2);
                    }

                    @Override // com.byazt.pmn.AppDownloadListener
                    public void onDownloadPaused(long j, long j2, String str, String str2) {
                        com.byazt.ll.n.qg(strQ, j, j2);
                    }

                    @Override // com.byazt.pmn.AppDownloadListener
                    public void onDownloadFailed(long j, long j2, String str, String str2) {
                        com.byazt.ll.n.s(strQ, j, j2);
                    }

                    @Override // com.byazt.pmn.AppDownloadListener
                    public void onDownloadFinished(long j, String str, String str2) {
                        com.byazt.ll.n.qg(strQ);
                    }

                    @Override // com.byazt.pmn.AppDownloadListener
                    public void onInstalled(String str, String str2) {
                        com.byazt.ll.n.s(strQ);
                    }
                });
                n(strQ, iTTInnerDownloadAdapterQg);
            }
        }
        if (iTTInnerDownloadAdapterQg != null) {
            ((com.byazt.zct.n) nVar.n(com.byazt.zct.n.class)).n(iTTInnerDownloadAdapterQg);
        }
        nVar.n(null, new com.byazt.gct.tj());
        if (nf()) {
            WeakReference<x> weakReference2 = this.ri;
            if (weakReference2 == null || weakReference2.get() == null) {
                return;
            }
            this.ri.get().q();
            return;
        }
        if (context instanceof com.byazt.rv.n) {
            ((com.byazt.rv.n) context).n(1);
        }
    }

    public boolean w(String str) {
        return TextUtils.isEmpty(str) || !"click_other".equals(str) || m();
    }

    public boolean m() {
        pk pkVar = this.oa;
        return pkVar != null && com.byazt.gct.um.fs(pkVar) == 1;
    }

    public JSONObject oa(JSONObject jSONObject) {
        com.byazt.zq.qg qgVarXd;
        if (this.qg != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                String strOptString = jSONObject.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, null);
                if (strOptString != null) {
                    jSONObject2 = new JSONObject(strOptString);
                }
                if (com.byazt.nf.tj.fs()) {
                    try {
                        pk pkVar = this.oa;
                        if (pkVar != null && (qgVarXd = pkVar.xd()) != null) {
                            String strOa = qgVarXd.oa();
                            if (!TextUtils.isEmpty(strOa)) {
                                jSONObject2.putOpt("media_extra", strOa);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
                for (Map.Entry<String, Object> entry : this.qg.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            } catch (Exception e) {
                k.n(e.toString());
            }
        }
        return jSONObject;
    }

    public void n(String str, JSONObject jSONObject) {
        JSONArray jSONArray;
        String strOptString;
        String strOptString2;
        String strOptString3;
        String strOptString4;
        String str2 = "click";
        String strQg = "";
        try {
            if ("show".equals(str)) {
                jSONArray = jSONObject.optJSONArray("show_url");
                str2 = "show";
            } else if ("click".equals(str)) {
                jSONArray = jSONObject.getJSONArray(SDMAdConst.NETWORK_CUSTOM_KEY.CLICK_URL);
            } else {
                str2 = null;
                jSONArray = null;
            }
            if (jSONArray != null && jSONArray.length() != 0) {
                String strN = com.byazt.ehw.l.n();
                if (TextUtils.isEmpty(strN)) {
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
                                    strQg = com.byazt.vgx.w.qg(jSONObject2.optInt("ad_slot_type"));
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
                        com.byazt.cw.n.n(com.byazt.vyf.s.cy().ou()).n(strN, arrayList, true, map, com.byazt.hm.n.n(strOptString5, strOptString, strOptString3, strQg, str2));
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
                com.byazt.cw.n.n(com.byazt.vyf.s.cy().ou()).n(strN, arrayList, true, map2, com.byazt.hm.n.n(strOptString5, strOptString, strOptString3, strQg, str2));
            }
        } catch (Throwable unused6) {
        }
    }

    public void hu() {
        pk pkVar = this.oa;
        if (pkVar == null) {
            return;
        }
        com.byazt.okk.n.qg(pkVar, this.w.get(), ur());
    }

    public void h() {
        pk pkVar = this.oa;
        if (pkVar == null) {
            return;
        }
        com.byazt.okk.n.s(pkVar, this.w.get(), ur());
    }

    public JSONObject t() {
        JSONObject jSONObject = new JSONObject();
        pk pkVar = this.oa;
        if (pkVar == null) {
            return jSONObject;
        }
        String strNn = pkVar.nn();
        if (TextUtils.isEmpty(strNn)) {
            return jSONObject;
        }
        try {
            return new JSONObject(strNn);
        } catch (Exception unused) {
            return jSONObject;
        }
    }

    public String ur() {
        return com.byazt.vgx.w.n(this.cp);
    }

    public String n(String str, String str2) {
        return ((("landing_perf_stats".equals(str2) || "landing_perf_exception".equals(str2)) && "landingpage".equals(str)) || this.cd != null || nf()) ? str : com.byazt.vgx.w.n(this.cp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tj(String str) {
        int iIndexOf;
        if (str != null && str.startsWith("bytedance://")) {
            try {
                if (str.equals("bytedance://dispatch_message/")) {
                    com.byazt.uad.q qVarOj = oj();
                    if (qVarOj != null) {
                        com.byazt.tk.oa.n(qVarOj, "javascript:ToutiaoJSBridge._fetchQueue()");
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
                rv(strSubstring2);
            } catch (Exception unused) {
            }
        }
    }

    public void bb() {
        com.byazt.ll.q qVar = this.x;
        if (qVar != null) {
            qVar.n();
        }
        if (b()) {
            py();
        }
    }

    public void ln() {
        com.byazt.ll.q qVar = this.x;
        if (qVar != null) {
            qVar.qg();
        }
        this.df = false;
    }

    public void lh() {
        l();
        com.byazt.ll.q qVar = this.x;
        if (qVar != null) {
            qVar.s();
        }
        for (ITTInnerDownloadAdapter iTTInnerDownloadAdapter : this.ic.values()) {
            if (iTTInnerDownloadAdapter != null) {
                iTTInnerDownloadAdapter.onDestroy();
            }
        }
        this.ic.clear();
        WeakReference<SSWebView> weakReference = this.q;
        if (weakReference != null) {
            weakReference.clear();
        }
        WeakReference<View> weakReference2 = this.rv;
        if (weakReference2 != null) {
            weakReference2.clear();
        }
        WeakReference<Context> weakReference3 = this.w;
        if (weakReference3 != null) {
            weakReference3.clear();
        }
        this.sh = null;
    }

    @Override // com.byazt.vf.wo.n
    public void n(Message message) {
        if (message != null && message.what == 11 && (message.obj instanceof n)) {
            try {
                n((n) message.obj, 1);
            } catch (Exception unused) {
            }
        }
    }

    public void sz(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.fs = jSONObject.optString("cid");
        this.tj = jSONObject.optString("log_extra");
    }

    private void ri() {
        if (this.x == null) {
            this.x = com.byazt.ll.qg.n(this, this.oa, this.dg);
        }
    }

    public void n(String str, boolean z) {
        com.byazt.ll.q qVar = this.x;
        if (qVar != null) {
            qVar.n(str, z);
        }
    }

    public void n(String str, ITTInnerDownloadAdapter iTTInnerDownloadAdapter) {
        this.ic.put(str, iTTInnerDownloadAdapter);
    }

    public ITTInnerDownloadAdapter x(String str) {
        return this.ic.get(str);
    }

    @Override // com.byazt.ll.s
    public void qg(String str, JSONObject jSONObject) {
        fi();
        l(str, jSONObject);
    }

    public void s(String str, JSONObject jSONObject) {
        try {
            cy cyVar = this.an;
            if (cyVar != null) {
                cyVar.n(str, jSONObject);
            }
        } catch (Throwable th) {
            k.n("TTAndroidObject", "sendJsMsg2020 error", th);
        }
    }

    public void v() {
        WeakReference<w> weakReference = this.wm;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.wm.get().n();
    }

    public void n(JSONObject jSONObject, boolean z) {
        WeakReference<Context> weakReference;
        if (this.x == null || (weakReference = this.w) == null || weakReference.get() == null) {
            return;
        }
        this.x.n(this.hd && this.cy);
        this.x.qg(z);
        this.x.s(this.pe == 3);
        this.x.n(this.w.get(), jSONObject, this.ae, this.tj);
    }

    public int j() {
        if (this.um.cp() == null) {
            return 0;
        }
        return this.um.cp().s();
    }

    public void n(com.byazt.uv.x xVar) {
        this.z = new WeakReference<>(xVar);
    }

    public void cp(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("visibleState", z ? 0 : 1);
        } catch (Exception e) {
            k.qg("TTAndroidObject", e.getMessage());
        }
        l("visibleStateChange", jSONObject);
    }

    public void an() {
        WeakReference<com.byazt.uv.x> weakReference = this.z;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.z.get().n();
    }

    private boolean nf() {
        return this.ri != null;
    }

    public void n(int i, int i2) {
        int iS = com.byazt.okk.s.s(com.byazt.nf.rv.getContext(), i);
        int iS2 = com.byazt.okk.s.s(com.byazt.nf.rv.getContext(), i2);
        WeakReference<x> weakReference = this.ri;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.ri.get().n(Integer.MIN_VALUE, Integer.MIN_VALUE, iS, iS2);
    }

    public void n(int i, int i2, int i3, int i4) {
        int iS;
        int iS2;
        int iS3;
        int iS4 = Integer.MIN_VALUE;
        if (i == Integer.MAX_VALUE || i2 == Integer.MAX_VALUE) {
            iS = Integer.MIN_VALUE;
            iS2 = Integer.MIN_VALUE;
        } else {
            iS = com.byazt.okk.s.s(com.byazt.nf.rv.getContext(), i);
            iS2 = com.byazt.okk.s.s(com.byazt.nf.rv.getContext(), i2);
        }
        if (i3 == Integer.MAX_VALUE || i4 == Integer.MAX_VALUE) {
            iS3 = Integer.MIN_VALUE;
        } else {
            iS4 = com.byazt.okk.s.s(com.byazt.nf.rv.getContext(), i3);
            iS3 = com.byazt.okk.s.s(com.byazt.nf.rv.getContext(), i4);
        }
        WeakReference<x> weakReference = this.ri;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.ri.get().n(iS, iS2, iS4, iS3);
    }

    public void d(boolean z) {
        this.e = new AtomicBoolean(z);
    }

    public void ae() {
        if (this.um.cp() != null) {
            this.um.cp().fs();
        }
    }

    public void qg(int i, int i2) {
        this.um.n(i, i2);
    }

    public void n(byte b) {
        this.pe = b;
    }

    public byte f() {
        return this.pe;
    }

    public void n(int i, int i2, int i3, int i4, boolean z) {
        this.kc = z;
        WeakReference<com.byazt.vhv.s> weakReference = this.ci;
        if (weakReference != null && weakReference.get() != null) {
            this.ci.get().n(i, i2, i3, i4, z);
        } else {
            this.hf = new int[]{i, i2, i3, i4};
        }
    }

    public void n(com.byazt.vhv.s sVar) {
        if (sVar == null) {
            this.ci = null;
            return;
        }
        int[] iArr = this.hf;
        if (iArr != null && iArr.length == 4) {
            sVar.n(iArr[0], iArr[1], iArr[2], iArr[3], this.kc);
        } else {
            this.ci = new WeakReference<>(sVar);
        }
    }
}
