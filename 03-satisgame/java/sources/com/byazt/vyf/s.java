package com.byazt.vyf;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.anythink.core.common.d.i;
import com.anythink.core.common.f.e;
import com.byazt.ehw.DeviceUtils;
import com.byazt.gct.pk;
import com.byazt.iz.rv;
import com.byazt.nf.tj;
import com.byazt.qyu.PluginConstants;
import com.byazt.tk.cd;
import com.byazt.tk.k;
import com.byazt.vf.wo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.compilance.constants.ComplianceMessage;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT, 8})
public class s {
    public static final com.byazt.zq.q n = new n();
    public volatile boolean a;
    public volatile boolean ae;
    public C0380s an;
    public int bb;
    public volatile boolean cd;
    public final Set<Integer> cp;
    public String cy;
    public volatile boolean d;
    public volatile com.byazt.gwu.s df;
    public String dg;
    public boolean f;
    public boolean fi;
    public volatile com.byazt.xb.n fs;
    public volatile Function<SparseArray<Object>, Object> h;
    public volatile boolean hd;
    public boolean hu;
    public volatile String j;
    public volatile com.byazt.zq.q k;
    public volatile String l;
    public com.byazt.ot.q lh;
    public long ln;
    public boolean m;
    public Bitmap oa;
    public com.byazt.pa.qg oj;
    public volatile JSONObject ou;
    public volatile int py;
    public volatile boolean q;
    public volatile String qg;
    public volatile int rv;
    public volatile String s;
    public volatile com.byazt.ot.n sz;
    public int t;
    public volatile boolean tj;
    public Function<SparseArray<Object>, Object> um;
    public int ur;
    public boolean v;
    public volatile String w;
    public HashMap<String, Object> wm;
    public volatile String x;

    public boolean n() {
        return this.sz != null && this.sz.qg();
    }

    public boolean n(boolean z) {
        return this.sz != null && this.sz.n(z);
    }

    public void n(String str) {
        this.j = str;
    }

    public String n(pk pkVar) {
        if (TextUtils.isEmpty(this.j)) {
            this.j = rv.n(pkVar, false);
        }
        return this.j;
    }

    public boolean qg() {
        if (!this.hu && Build.VERSION.SDK_INT >= 26) {
            this.hu = true;
            try {
                ShortcutManager shortcutManager = (ShortcutManager) com.byazt.nf.rv.getContext().getSystemService(ShortcutManager.class);
                if (shortcutManager != null) {
                    this.m = shortcutManager.isRequestPinShortcutSupported();
                }
            } catch (Throwable unused) {
            }
        }
        return this.m;
    }

    public boolean n(Activity activity) {
        return this.sz != null && this.sz.n(activity);
    }

    public com.byazt.ot.n s() {
        if (this.sz == null) {
            s(com.byazt.nf.rv.getContext());
        }
        return this.sz;
    }

    public boolean q() {
        return com.byazt.hnb.s.n().w();
    }

    public String l() {
        return com.byazt.hnb.s.n().qg();
    }

    public boolean w() {
        return this.ae;
    }

    public boolean x() {
        return com.byazt.hnb.s.n().x();
    }

    public boolean fs() {
        return rv() && com.byazt.gv.n.s();
    }

    public boolean rv() {
        return !tj() && x();
    }

    public boolean tj() {
        return com.byazt.hnb.s.n().fs();
    }

    public boolean cp() {
        return com.byazt.hnb.s.n().rv();
    }

    public void d() {
        com.byazt.hnb.s.n().l();
    }

    public boolean oa() {
        return com.byazt.hnb.s.n().s();
    }

    private s() {
        this.fs = new com.byazt.xb.n(2);
        this.rv = 0;
        this.tj = true;
        this.cp = Collections.synchronizedSet(new HashSet());
        this.d = false;
        this.oa = null;
        this.hd = false;
        this.cd = true;
        this.a = true;
        this.py = 0;
        this.ou = new JSONObject();
        this.wm = new HashMap<>();
        this.m = false;
        this.hu = false;
        this.h = null;
        this.t = -1;
        this.ur = -1;
        this.bb = -1;
        this.ln = -1L;
        this.f = false;
        this.fi = false;
        this.dg = null;
    }

    public void sz() {
        k();
        Context context = com.byazt.nf.rv.getContext();
        this.cp.add(4);
        s(context);
    }

    public void k() {
        this.ae = com.byazt.gv.n.qg();
    }

    private void s(Context context) {
        if (this.sz != null) {
            return;
        }
        this.sz = new com.byazt.ot.n();
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(this.sz);
        } else {
            if (context == null || context.getApplicationContext() == null) {
                return;
            }
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(this.sz);
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT, 782})
    private static class qg {
        public static s n = new s();
    }

    public static s cy() {
        return qg.n;
    }

    public void n(com.byazt.zq.q qVar) {
        this.k = qVar;
    }

    public com.byazt.af.rv hd() {
        return new com.byazt.af.rv(a(), false);
    }

    public com.byazt.af.q cd() {
        return new com.byazt.af.rv(a(), true);
    }

    public String um() {
        return this.dg;
    }

    public void qg(String str) {
        this.dg = str;
    }

    public com.byazt.zq.q a() {
        if (this.k == null || this.k.k()) {
            this.k = pk() ? n : i();
        }
        return this.k;
    }

    private com.byazt.gwu.s fl() {
        if (this.df == null) {
            synchronized (this) {
                if (this.df == null) {
                    this.df = com.byazt.lk.l.n(this.qg, "sp_global_info");
                }
            }
        }
        return this.df;
    }

    public boolean py() {
        return fl().qg("sdk_activate_init", true);
    }

    public void qg(boolean z) {
        fl().n("sdk_activate_init", z);
    }

    public String ou() {
        return this.qg;
    }

    public void s(String str) {
        k(str);
        this.qg = str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_id", str);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.8.1.4");
            jSONObject.put("sdk_version", tj.w);
            this.ou.put("com.byted.pangle", jSONObject);
        } catch (Exception unused) {
        }
    }

    public String wm() {
        return this.s;
    }

    public void q(String str) {
        cy(str);
        this.s = str;
    }

    public boolean m() {
        return this.q;
    }

    public void s(boolean z) {
        this.q = z;
    }

    public String hu() {
        if (!TextUtils.isEmpty(this.l)) {
            return this.l;
        }
        return com.byazt.ed.s.n().q("");
    }

    public void l(String str) {
        hd(str);
        this.l = str;
    }

    public void n(int i) {
        this.fs = new com.byazt.xb.n(i, true);
    }

    public com.byazt.xb.n h() {
        return this.fs;
    }

    public String t() {
        if (!TextUtils.isEmpty(this.w)) {
            return this.w;
        }
        return com.byazt.ed.s.n().w("");
    }

    public Map<String, Object> ur() {
        if (!this.wm.isEmpty()) {
            return this.wm;
        }
        String strFs = com.byazt.ed.s.n().fs("");
        this.wm.putAll(TextUtils.isEmpty(strFs) ? sz(strFs) : new HashMap<>());
        return this.wm;
    }

    public void w(final String str) {
        cd(str);
        ((wo) com.byazt.qp.q.n("thread_service")).n(new Runnable() { // from class: com.byazt.vyf.s.1
            @Override // java.lang.Runnable
            public void run() {
                s.this.oa(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oa(String str) {
        JSONArray jSONArray;
        try {
            jSONArray = TextUtils.isEmpty(str) ? new JSONArray() : new JSONArray(str);
        } catch (Exception unused) {
            jSONArray = new JSONArray();
        }
        HashMap map = new HashMap();
        JSONArray jSONArray2 = new JSONArray();
        boolean z = false;
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                if (!jSONObjectOptJSONObject.isNull("__name__")) {
                    String strOptString = jSONObjectOptJSONObject.optString("__name__");
                    String strOptString2 = jSONObjectOptJSONObject.optString(e.a.d);
                    if (!TextUtils.isEmpty(strOptString)) {
                        map.put(strOptString, strOptString2);
                    }
                } else if ("csj_rit_list".equals(jSONObjectOptJSONObject.optString(TapEventParamConstants.PARAM_NAME))) {
                    rv(jSONObjectOptJSONObject.optString(e.a.d));
                    jSONArray.remove(i);
                    z = true;
                } else {
                    jSONArray2.put(jSONObjectOptJSONObject);
                }
            }
        }
        if (z) {
            this.w = jSONArray.toString();
        } else {
            this.w = str;
        }
        if ((jSONArray2.length() == 0 && map.isEmpty()) || jSONArray2.length() != 0) {
            this.w = jSONArray2.toString();
        }
        if (map.isEmpty()) {
            return;
        }
        this.wm.putAll(map);
    }

    public void qg(int i) {
        this.rv = i;
    }

    public int bb() {
        if (com.byazt.byp.qg.n()) {
            return fl().qg("title_bar_theme", 0);
        }
        return this.rv;
    }

    public void q(boolean z) {
        this.tj = z;
    }

    public boolean ln() {
        if (com.byazt.byp.qg.n()) {
            return fl().qg("allow_show_notify", true);
        }
        return this.tj;
    }

    public void l(boolean z) {
        s(z);
    }

    public void x(String str) {
        w(str);
        if (com.byazt.byp.qg.n()) {
            com.byazt.ed.s.n().l(str);
            com.byazt.ed.s.n().x(n(this.wm));
        }
    }

    public void fs(String str) {
        l(str);
        com.byazt.ed.s.n().s(str);
    }

    public void n(boolean z, SparseArray<Object> sparseArray) {
        k.qg("bstsdk", "bst(true) stat-quit, run new pl");
        this.hd = z;
        com.byazt.gv.n.n(true);
        ((wo) com.byazt.qp.q.n("thread_service")).s(new Runnable() { // from class: com.byazt.vyf.s.2
            @Override // java.lang.Runnable
            public void run() {
                s.unregisterReceiver();
                com.byazt.gjp.l.n().qg();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void unregisterReceiver() {
        DeviceUtils.cp();
        DeviceUtils.d();
    }

    public boolean lh() {
        return this.hd;
    }

    public void v() {
        com.byazt.ed.s.n().qg(this.py);
        com.byazt.ed.s.n().s(this.l);
        com.byazt.ed.s.n().l(this.w);
        com.byazt.ed.s.n().x(n(this.wm));
        fl().n("title_bar_theme", this.rv);
        fl().n("allow_show_notify", this.tj);
        com.byazt.ed.s.n().qg(this.d);
        Set<Integer> set = this.cp;
        if (set != null && !set.isEmpty()) {
            Iterator<Integer> it = this.cp.iterator();
            StringBuilder sb = new StringBuilder();
            while (it.hasNext()) {
                sb.append(it.next()).append(",");
            }
            fl().n("network_state", sb.toString());
            return;
        }
        fl().n("network_state");
    }

    public void w(boolean z) {
        this.f = z;
    }

    public boolean j() {
        return this.f;
    }

    public boolean an() {
        return this.fi;
    }

    public void x(boolean z) {
        this.fi = z;
    }

    public JSONObject ae() {
        return this.ou;
    }

    public void n(String str, String str2) {
        try {
            JSONObject jSONObjectOptJSONObject = this.ou.optJSONObject(str);
            if (jSONObjectOptJSONObject != null) {
                jSONObjectOptJSONObject.putOpt(PluginConstants.KEY_PLUGIN_VERSION, str2);
            }
        } catch (JSONException unused) {
            k.qg("GlobalInfo", "JSONObject not found for name " + str + " when update plugin config.");
        }
    }

    public void n(String str, String str2, String str3, String str4) {
        try {
            JSONObject jSONObjectOptJSONObject = this.ou.optJSONObject(str);
            if (TextUtils.isEmpty(str4)) {
                str4 = this.qg;
            }
            if (jSONObjectOptJSONObject == null) {
                jSONObjectOptJSONObject = new JSONObject();
            }
            jSONObjectOptJSONObject.put("app_id", str4);
            jSONObjectOptJSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, str3);
            jSONObjectOptJSONObject.put("sdk_version", str2);
            this.ou.put(str, jSONObjectOptJSONObject);
        } catch (JSONException e) {
            e.getMessage();
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0060  */
    public void f() {
        String string;
        JSONObject jSONObject = new JSONObject();
        try {
            String strX = com.byazt.zh.l.x();
            if (TextUtils.isEmpty(strX)) {
                strX = "2.0.0";
            }
            jSONObject.put("gdt_version", strX);
        } catch (JSONException unused) {
        }
        com.byazt.wl.l.n();
        int iRv = com.byazt.zh.l.rv();
        if (iRv != 0) {
            String string2 = new StringBuilder().append(iRv).toString();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < string2.length(); i++) {
                sb.append(string2.charAt(i));
                if (i != string2.length() - 1) {
                    sb.append(i.E);
                }
            }
            if (TextUtils.isEmpty(sb.toString())) {
                string = "0.0.0.0";
            } else {
                string = sb.toString();
            }
        } else {
            string = "0.0.0.0";
        }
        if (jSONObject.has("gdt_version")) {
            try {
                com.byazt.zh.l.n("dex_status", 1);
                jSONObject.put("app_id", this.qg);
                jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, string);
                jSONObject.put("sdk_version", "2.0.0.0");
                jSONObject.put("plugin_update_network", "2");
                this.ou.put("com.byted.mixed", jSONObject);
            } catch (JSONException unused2) {
            }
        }
    }

    public void n(Bundle bundle) {
        if (bundle == null || bundle.keySet().size() <= 0) {
            return;
        }
        for (String str : bundle.keySet()) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    Bundle bundle2 = bundle.getBundle(str);
                    if (bundle2 == null) {
                        return;
                    }
                    String string = bundle2.getString("app_id", this.qg);
                    n(str, bundle2.getString("sdk_version"), bundle2.getString(PluginConstants.KEY_PLUGIN_VERSION), string);
                } catch (Exception unused) {
                    continue;
                }
            }
        }
    }

    public Function<SparseArray<Object>, Object> fi() {
        Function<SparseArray<Object>, Object> function = this.um;
        if (function != null) {
            return function;
        }
        com.byazt.ms.tj tjVarN = com.byazt.ms.tj.n(com.byazt.nf.rv.getContext());
        this.um = tjVarN;
        return tjVarN;
    }

    public boolean s(int i) {
        if (com.byazt.byp.qg.n()) {
            String strQg = fl().qg("network_state", "");
            if (!TextUtils.isEmpty(strQg)) {
                String[] strArrSplit = strQg.split(",");
                if (strArrSplit.length > 0) {
                    for (String str : strArrSplit) {
                        if (!TextUtils.isEmpty(str) && String.valueOf(i).equals(str)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        Set<Integer> set = this.cp;
        return set != null && set.contains(Integer.valueOf(i));
    }

    public void n(int... iArr) {
        if (iArr == null) {
            return;
        }
        try {
            this.cp.clear();
            for (int i : iArr) {
                this.cp.add(Integer.valueOf(i));
            }
        } catch (Throwable unused) {
        }
    }

    private static final String n(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey())) {
                try {
                    jSONObject.putOpt(entry.getKey(), entry.getValue());
                } catch (Exception unused) {
                }
            }
        }
        return jSONObject.toString();
    }

    private static final HashMap<String, Object> sz(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap<>();
        }
        HashMap<String, Object> map = new HashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!TextUtils.isEmpty(next)) {
                    map.put(next, jSONObject.opt(next));
                }
            }
            return map;
        } catch (Exception unused) {
            return new HashMap<>();
        }
    }

    private static void k(String str) {
        cd.n(str, "appid不能为空");
    }

    private static void cy(String str) {
        cd.n(str, "name不能为空");
    }

    private static void hd(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        cd.n(str.length() <= 1000, "keyword超长, 最长为1000");
    }

    private static void cd(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        cd.n(str.length() <= 20000, "data超长, 最长为20000");
    }

    public com.byazt.pa.qg df() {
        if (this.oj == null) {
            this.oj = new com.byazt.pa.qg(10, 8);
        }
        return this.oj;
    }

    public boolean oj() {
        if (com.byazt.ed.qg.n().qg()) {
            return com.byazt.ed.s.n().n(false);
        }
        return this.d;
    }

    public void fs(boolean z) {
        tj.tj = z;
        this.d = z;
    }

    public Bitmap dg() {
        if (com.byazt.byp.qg.n()) {
            return com.byazt.tk.s.n(fl().qg("pause_icon", ""));
        }
        return this.oa;
    }

    public void n(Bitmap bitmap) {
        if (com.byazt.byp.qg.n()) {
            String strN = com.byazt.tk.s.n(bitmap);
            if (!TextUtils.isEmpty(strN)) {
                fl().n("pause_icon", strN);
            }
        }
        this.oa = bitmap;
    }

    public int u() {
        if (com.byazt.ed.qg.n().qg()) {
            int iS = com.byazt.ed.s.n().s();
            return iS == Integer.MIN_VALUE ? this.py : iS;
        }
        return this.py;
    }

    public void q(int i) {
        if (i < 0 || i > 2) {
            i = 0;
        }
        try {
            this.py = i;
        } catch (Throwable unused) {
        }
    }

    private static com.byazt.zq.q i() {
        return new com.byazt.zq.q.n().qg(true).n(true).n((com.byazt.zq.s) null).s(true).n((String) null).q(true).qg((String) null).l(true).s((String) null).w(true).q((String) null).x(false).n();
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT, 546})
    public static final class n extends com.byazt.zq.q {
        @Override // com.byazt.zq.q
        public boolean k() {
            return true;
        }

        @Override // com.byazt.zq.q
        public boolean sz() {
            return false;
        }

        public n() {
            super(null);
        }

        @Override // com.byazt.zq.q
        public boolean n() {
            return "1".equals(com.byazt.lq.s.n(7, "1"));
        }

        @Override // com.byazt.zq.q
        public boolean s() {
            return "1".equals(com.byazt.lq.s.n(17, "1"));
        }

        @Override // com.byazt.zq.q
        public boolean q() {
            return "1".equals(com.byazt.lq.s.n(9, "1"));
        }

        @Override // com.byazt.zq.q
        public boolean w() {
            return "1".equals(com.byazt.lq.s.n(11, "1"));
        }

        @Override // com.byazt.zq.q
        public boolean fs() {
            return "1".equals(com.byazt.lq.s.n(12, "1"));
        }

        @Override // com.byazt.zq.q
        public boolean tj() {
            return "1".equals(com.byazt.lq.s.n(22, "1"));
        }

        @Override // com.byazt.zq.q
        public boolean oa() {
            return "1".equals(com.byazt.lq.s.n(24, "1"));
        }

        @Override // com.byazt.zq.q
        public com.byazt.zq.s qg() {
            String[] strArrSplit;
            String strN = com.byazt.lq.s.n(8, "");
            if (TextUtils.isEmpty(strN) || (strArrSplit = strN.split(",")) == null) {
                return null;
            }
            String str = strArrSplit.length > 0 ? strArrSplit[0] : "";
            String str2 = strArrSplit.length > 1 ? strArrSplit[1] : "";
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                return null;
            }
            return new com.byazt.zq.s.n().n(Double.valueOf(str).doubleValue()).qg(Double.valueOf(str2).doubleValue()).n();
        }

        @Override // com.byazt.zq.q
        public String l() {
            return com.byazt.lq.s.n(10, "");
        }

        @Override // com.byazt.zq.q
        public String x() {
            return com.byazt.lq.s.n(18, "");
        }

        @Override // com.byazt.zq.q
        public String rv() {
            return com.byazt.lq.s.n(13, "");
        }
    }

    public boolean pk() {
        return "5001121".equals(this.qg) && "com.union_test.toutiao".equals(com.byazt.vgx.w.fs());
    }

    public boolean wo() {
        return "5001121".equals(this.qg);
    }

    public boolean sh() {
        try {
            if ("com.union_test.toutiao".equals(com.byazt.nf.rv.getContext().getPackageName()) && "5001121".equals(this.qg)) {
                return true;
            }
            if ("com.pangolin_demo.toutiao".equals(com.byazt.nf.rv.getContext().getPackageName()) && "5001121".equals(this.qg)) {
                return true;
            }
            if ("com.bytedance.mediation_demo".equals(com.byazt.nf.rv.getContext().getPackageName()) && "5001121".equals(this.qg)) {
                return true;
            }
            if ("com.msdk.qa.monkey".equals(com.byazt.nf.rv.getContext().getPackageName()) && "5001121".equals(this.qg)) {
                return true;
            }
            return com.byazt.nf.rv.getContext().getPackageName().contains("com.bytedance.mediation_demo_csj") && "5001121".equals(this.qg);
        } catch (Throwable unused) {
            return false;
        }
    }

    public String y() {
        if (!TextUtils.isEmpty(this.cy)) {
            return this.cy;
        }
        com.byazt.gwu.s sVarN = com.byazt.ikv.n.n();
        String strQg = sVarN.qg("any_door_id", (String) null);
        this.cy = strQg;
        if (!TextUtils.isEmpty(strQg)) {
            return this.cy;
        }
        String strValueOf = String.valueOf(System.currentTimeMillis());
        sVarN.n("any_door_id", strValueOf);
        this.cy = strValueOf;
        return strValueOf;
    }

    public boolean rf() {
        return this.cd;
    }

    public void rv(boolean z) {
        this.cd = z;
    }

    public void l(int i) {
        com.byazt.ed.s.n().s(i);
    }

    public int dh() {
        return com.byazt.ed.s.n().q(0);
    }

    public Function<SparseArray<Object>, Object> b() {
        return this.h;
    }

    public Function<SparseArray<Object>, Object> w(int i) {
        if (this.h == null) {
            return null;
        }
        return (Function) this.h.apply(com.byazt.of.qg.n().n(10).n(Object.class).n(0, Integer.valueOf(i)).qg());
    }

    public void n(Function<SparseArray<Object>, Object> function) {
        if (this.h != null) {
            return;
        }
        this.h = function;
    }

    public boolean ri() {
        return this.v;
    }

    public void tj(boolean z) {
        this.v = z;
    }

    public String nf() {
        return this.x;
    }

    public void rv(String str) {
        this.x = str;
        com.byazt.ivn.q.n((com.byazt.ivn.qg) null).n(true);
    }

    public boolean n(Context context) {
        if (com.byazt.hnb.qg.n().l()) {
            this.t = 2;
        } else {
            this.t = 1;
        }
        return this.t == 1;
    }

    public boolean qg(Context context) {
        if (com.byazt.hnb.qg.n().l()) {
            this.ur = 2;
        } else {
            this.ur = 1;
        }
        return this.ur == 1;
    }

    public void x(int i) {
        this.bb = i;
    }

    public int pe() {
        return this.bb;
    }

    public void n(long j) {
        this.ln = j;
    }

    public long e() {
        return this.ln;
    }

    public void n(com.byazt.ot.n.qg qgVar) {
        if (this.h != null) {
            if (this.lh == null) {
                com.byazt.ot.q qVar = new com.byazt.ot.q();
                this.lh = qVar;
                qVar.n(this.h);
            }
            this.lh.n(qgVar);
        }
    }

    public void qg(com.byazt.ot.n.qg qgVar) {
        com.byazt.ot.q qVar = this.lh;
        if (qVar != null) {
            qVar.qg(qgVar);
        }
    }

    public String yw() {
        try {
            if ((com.byazt.nf.rv.qg().jw() & 1) == 1) {
                return com.byazt.ed.q.n().l();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public Object cx() {
        Object objApply;
        WeakReference<Activity> weakReferenceN = this.sz.n();
        if (weakReferenceN != null) {
            return weakReferenceN.get();
        }
        if (this.h != null) {
            objApply = this.h.apply(com.byazt.of.qg.n().n(14).n(Activity.class).qg());
        } else {
            objApply = null;
        }
        return objApply == null ? el() : objApply;
    }

    public void cp(boolean z) {
        fl().n("update_advance_preview_mode", z);
        fl().n("update_advance_preview_mode_time", System.currentTimeMillis());
    }

    public boolean lq() {
        if (fl().qg("update_advance_preview_mode", false)) {
            long jQg = fl().qg("update_advance_preview_mode_time", -1L);
            if (jQg != -1) {
                if (System.currentTimeMillis() - jQg <= 3600000) {
                    return true;
                }
                cp(false);
            }
        }
        return false;
    }

    public void tj(String str) {
        fl().n("toolsQueryHost", str);
    }

    public String ic() {
        return fl().qg("toolsQueryHost", "api-access.pangolin-sdk-toutiao.com");
    }

    public void cp(String str) {
        fl().n("toolsAdPreviewUrl", str);
    }

    public String ci() {
        return fl().qg("toolsAdPreviewUrl", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/test-tool/0.0.4/html/ad_preview.html");
    }

    public void d(String str) {
        fl().n("toolsBasicInfUrl", str);
    }

    public String hf() {
        return fl().qg("toolsBasicInfUrl", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/test-tool/0.0.4/html/basic_info.html");
    }

    public String kc() {
        return fl().qg("adnDetailUrl", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/test-tool/0.0.4/html/adn_detail.html");
    }

    public String z() {
        return fl().qg("ritDetailUrl", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/test-tool/0.0.4/html/rit_detail.html");
    }

    public String dn() {
        return fl().qg("codeidDetailUrl", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/test-tool/0.0.4/html/codeid_detail.html");
    }

    public C0380s he() {
        return this.an;
    }

    public void n(C0380s c0380s) {
        this.an = c0380s;
    }

    public static Object el() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object objInvoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            Map map = (Map) declaredField.get(objInvoke);
            if (map != null && !map.isEmpty()) {
                for (Object obj : map.values()) {
                    Class<?> cls2 = obj.getClass();
                    Field declaredField2 = cls2.getDeclaredField("isTopResumedActivity");
                    declaredField2.setAccessible(true);
                    if (declaredField2.getBoolean(obj)) {
                        Field declaredField3 = cls2.getDeclaredField("activity");
                        declaredField3.setAccessible(true);
                        return declaredField3.get(obj);
                    }
                }
                return null;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: com.byazt.vyf.s$s, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT, ComplianceMessage.INVALID_CLIENT_OR_NETWORK_ERROR})
    public static class C0380s {
        public Map<String, Object> n;
        public String qg;

        public C0380s(Map<String, Object> map, String str) {
            this.n = map;
            this.qg = str;
        }

        public void n(JSONObject jSONObject) throws JSONException {
            Map<String, Object> map;
            if (jSONObject == null || (map = this.n) == null || map.size() == 0 || TextUtils.isEmpty(this.qg)) {
                return;
            }
            for (Map.Entry<String, Object> entry : this.n.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            jSONObject.put("preview_ads", new JSONObject(this.qg));
        }
    }
}
