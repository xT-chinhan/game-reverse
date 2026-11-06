package com.byazt.qt;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.byazt.jp.sz;
import com.byazt.jp.w;
import com.byazt.ng.q;
import com.byazt.vy.cd;
import com.byazt.ya.l;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_STREAM_RECEIVED_WINDOW, 19})
public class n {
    public static final n dg = new n();
    public com.byazt.mt.s ae;
    public boolean bb;
    public Map<String, String> cp;
    public String d;
    public final Map<String, Integer> df;
    public Object f;
    public long fi;
    public String fs;
    public boolean h;
    public JSONObject hu;
    public PluginValueSet j;
    public com.byazt.vv.n lh;
    public String ln;
    public boolean m;
    public String oa;
    public final Map<String, Float> oj;
    public sz pk;
    public String q;
    public String[] qg;
    public boolean rv;
    public String s;
    public String t;
    public String tj;
    public int[] u;
    public w um;
    public boolean ur;
    public boolean v;
    public List<String> wm;
    public int n = 0;
    public boolean l = true;
    public boolean w = false;
    public boolean x = false;
    public Set<String> sz = new HashSet();
    public Map<String, Map<String, String>> k = new HashMap();
    public Map<String, Map<String, String>> cy = new HashMap();
    public boolean hd = false;
    public final Map<String, Object> cd = new com.byazt.vy.sz();
    public long a = -1;
    public Map<String, Object> py = new ConcurrentHashMap();
    public Map<String, Object> ou = new ConcurrentHashMap();
    public int an = -1;

    public void n(boolean z) {
        this.hd = z;
    }

    public boolean n() {
        return this.hd;
    }

    public com.byazt.mt.s qg() {
        if (this.ae == null) {
            com.byazt.of.qg qgVarN = com.byazt.of.qg.n();
            l.n(qgVarN);
            this.ae = com.byazt.mt.s.n(qgVarN.qg());
        }
        return this.ae;
    }

    public void n(String str, float f) {
        this.oj.put(str, Float.valueOf(f));
    }

    public float n(String str) {
        return this.oj.get(str).floatValue();
    }

    public void n(long j) {
        com.byazt.gi.n.n().n(j);
    }

    public long s() {
        long j = this.a;
        if (j != -1) {
            return j;
        }
        long jQg = com.byazt.gi.n.n().qg();
        this.a = jQg;
        return jQg;
    }

    private n() {
        HashMap map = new HashMap();
        this.df = map;
        this.oj = new ConcurrentHashMap();
        if (qg.n().b()) {
            map.put(MediationConstant.KEY_USE_POLICY_AD_GAP, 1);
            map.put(MediationConstant.KEY_USE_POLICY_AD_LOAD, 1);
            map.put(MediationConstant.KEY_USE_POLICY_SECTION_ID, 1);
            map.put(MediationConstant.KEY_USE_POLICY_PAGE_ID, 1);
            map.put("custom", 1);
        }
    }

    public Map<String, Integer> q() {
        return this.df;
    }

    public long l() {
        return this.fi;
    }

    public void qg(long j) {
        this.fi = j;
    }

    public String w() {
        return this.ln;
    }

    public void qg(String str) {
        this.ln = str;
    }

    public boolean x() {
        return this.rv;
    }

    public void qg(boolean z) {
        this.rv = z;
    }

    public String fs() {
        Context context = qg.getContext();
        if (context == null) {
            return null;
        }
        if ((!"com.union_test.toutiao".equals(context.getPackageName()) || !"5001121".equals(this.s)) && (!"com.bytedance.mediation_demo".equals(context.getPackageName()) || !"5001121".equals(this.s))) {
            return null;
        }
        try {
            return com.byazt.lk.l.n(null, "gm_tt_mediation_ppe_info").getString("tt_ppe_content", "");
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean rv() {
        Context context = qg.getContext();
        return context != null && "com.bytedance.mediation_demo_csj".equals(context.getPackageName()) && cp();
    }

    public boolean tj() {
        try {
            return "com.msdk.qa.monkey".equals(qg.getContext().getPackageName()) && "5001121".equals(this.s);
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean cp() {
        String path = com.byazt.tk.w.q(qg.getContext(), false, null).getPath();
        if (this.an < 0) {
            if (new File(path + "/e2e.text").exists()) {
                this.an = 1;
            } else {
                this.an = 0;
            }
        }
        return this.an > 0;
    }

    public static n d() {
        return dg;
    }

    public String oa() {
        return this.s;
    }

    public void s(String str) {
        rv(str);
        this.s = str;
    }

    public void s(boolean z) {
        this.v = z;
    }

    public boolean sz() {
        return this.v;
    }

    public boolean k() {
        return this.x;
    }

    public void q(boolean z) {
        this.x = z;
    }

    public void q(String str) {
        this.fs = str;
    }

    public String cy() {
        return this.tj;
    }

    public void l(String str) {
        this.tj = str;
    }

    public Map<String, String> hd() {
        return this.cp;
    }

    public void n(Map<String, String> map) {
        this.cp = map;
    }

    public String cd() {
        return this.fs;
    }

    public void l(boolean z) {
        this.l = z;
    }

    public void n(int... iArr) {
        this.u = iArr;
    }

    public void w(boolean z) {
        this.w = z;
    }

    public String um() {
        return this.q;
    }

    public static String n(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getApplicationInfo().packageName, 0);
            String str = (String) (applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo) : "");
            return str;
        } catch (Throwable unused) {
            return "";
        }
    }

    public void w(String str) {
        if (TextUtils.isEmpty(str)) {
            str = n(qg.getContext());
        }
        this.q = str;
    }

    public void n(int i) {
        this.n = i;
    }

    public void n(String[] strArr) {
        this.qg = strArr;
    }

    private static void rv(String str) {
        cd.n(str, "appid不能为空");
    }

    public String a() {
        if (!TextUtils.isEmpty(this.oa)) {
            return this.oa;
        }
        com.byazt.gwu.s sVarN = com.byazt.lk.l.n(null, "gm_tt_ad_mediation_sdk_sp");
        String string = sVarN.getString("any_door_id", "");
        this.oa = string;
        if (!TextUtils.isEmpty(string)) {
            return this.oa;
        }
        String strValueOf = String.valueOf(System.currentTimeMillis());
        sVarN.n("any_door_id", strValueOf);
        this.oa = strValueOf;
        return strValueOf;
    }

    public void x(String str) {
        this.d = str;
    }

    public w py() {
        return this.um;
    }

    public void n(w wVar, boolean z) {
        boolean zEquals;
        if (!z) {
            w wVar2 = this.um;
            if (wVar2 == null && wVar == null) {
                zEquals = true;
            } else {
                zEquals = (wVar2 == null || wVar == null) ? false : wVar2.equals(wVar);
            }
            this.um = wVar;
            if (zEquals) {
                return;
            }
            q.n(qg.n()).n().n(3, (JSONObject) null);
            return;
        }
        this.um = wVar;
    }

    public sz ou() {
        if (this.pk == null) {
            this.pk = sz.n(d().qg());
        }
        return this.pk;
    }

    public void wm() {
        this.pk = sz.n(d().qg());
    }

    public Map<String, Object> m() {
        return this.py;
    }

    public void qg(Map<String, Object> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        this.py.putAll(map);
    }

    public Map<String, Object> hu() {
        return this.ou;
    }

    public void s(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        this.ou.putAll(map);
    }

    public List<String> h() {
        return this.wm;
    }

    public void n(List<String> list) {
        this.wm = list;
    }

    public boolean t() {
        return this.m;
    }

    public void x(boolean z) {
        this.m = z;
    }

    public JSONObject ur() {
        return this.hu;
    }

    public void n(JSONObject jSONObject) {
        this.hu = jSONObject;
    }

    public boolean bb() {
        return this.h;
    }

    public void fs(boolean z) {
        this.h = z;
    }

    public String ln() {
        return this.t;
    }

    public void fs(String str) {
        this.t = str;
    }

    public boolean lh() {
        return this.ur;
    }

    public void rv(boolean z) {
        this.ur = z;
    }

    public boolean v() {
        return this.bb;
    }

    public void tj(boolean z) {
        this.bb = z;
    }

    public Map<String, Object> j() {
        this.cd.put(MediationConstant.KEY_GM_USB, com.byazt.cby.l.l());
        return this.cd;
    }

    public PluginValueSet an() {
        PluginValueSet pluginValueSet = this.j;
        return pluginValueSet != null ? pluginValueSet : com.byazt.qvu.n.n().qg();
    }

    public void n(PluginValueSet pluginValueSet) {
        this.j = pluginValueSet;
    }

    public com.byazt.vv.n ae() {
        return this.lh;
    }

    public void n(com.byazt.vv.n nVar) {
        this.lh = nVar;
    }

    public Object f() {
        return this.f;
    }

    public void n(Object obj) {
        this.f = obj;
    }
}
