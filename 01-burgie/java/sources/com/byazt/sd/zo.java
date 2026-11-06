package com.byazt.sd;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.hg.of;
import com.byazt.mg.PluginConstants;
import com.byazt.ol.TTDownloadField;
import com.byazt.vkw.qi;
import com.byazt.wt.DeviceUtils;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.db.constant.Common;
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
@com.byazt.vzx.pr(pr = {0, 1, 23, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo {
    public static final com.byazt.qe.x pr = new pr();
    public volatile boolean a;
    public volatile int aj;
    public volatile Function<SparseArray<Object>, Object> b;
    public volatile String c;
    public volatile int cz;
    public hn e;
    public boolean er;
    public HashMap<String, Object> fo;
    public volatile String fw;
    public volatile com.byazt.wt.pr g;
    public int gz;
    public volatile String hn;
    public volatile com.byazt.qe.x ho;
    public volatile String hw;
    public int iu;
    public volatile boolean k;
    public volatile boolean lb;
    public boolean ls;
    public Bitmap m;
    public volatile String n;
    public long nl;
    public String nt;
    public volatile JSONObject ny;
    public Function<SparseArray<Object>, Object> qa;
    public com.byazt.sb.x qi;
    public String qn;
    public boolean rc;
    public volatile boolean s;
    public volatile String uc;
    public volatile com.byazt.zq.hn v;
    public int ve;
    public volatile boolean vk;
    public final Set<Integer> w;
    public boolean ww;
    public volatile boolean x;
    public c y;
    public volatile boolean yb;
    public boolean z;
    public volatile com.byazt.qw.pr zo;

    public boolean pr() {
        return this.g != null && this.g.hw();
    }

    public boolean pr(boolean z) {
        return this.g != null && this.g.pr(z);
    }

    public void pr(String str) {
        this.n = str;
    }

    public String pr(of ofVar) {
        if (TextUtils.isEmpty(this.n)) {
            this.n = com.byazt.jx.aj.pr(ofVar, false);
        }
        return this.n;
    }

    public boolean hw() {
        if (!this.z && Build.VERSION.SDK_INT >= 26) {
            this.z = true;
            try {
                ShortcutManager shortcutManager = (ShortcutManager) a.getContext().getSystemService(ShortcutManager.class);
                if (shortcutManager != null) {
                    this.rc = shortcutManager.isRequestPinShortcutSupported();
                }
            } catch (Throwable th) {
            }
        }
        return this.rc;
    }

    public boolean pr(Activity activity) {
        return this.g != null && this.g.pr(activity);
    }

    public com.byazt.wt.pr hn() {
        if (this.g == null) {
            hn(a.getContext());
        }
        return this.g;
    }

    public boolean x() {
        return com.byazt.igw.hn.pr().uc();
    }

    public String c() {
        return com.byazt.igw.hn.pr().hw();
    }

    public boolean uc() {
        return this.s;
    }

    public boolean fw() {
        return com.byazt.igw.hn.pr().fw();
    }

    public boolean zo() {
        return aj() && com.byazt.iq.pr.hn();
    }

    public boolean aj() {
        return !vk() && fw();
    }

    public boolean vk() {
        return com.byazt.igw.hn.pr().zo();
    }

    public boolean w() {
        return com.byazt.igw.hn.pr().aj();
    }

    public void k() {
        com.byazt.igw.hn.pr().c();
    }

    public boolean m() {
        return com.byazt.igw.hn.pr().hn();
    }

    private zo() {
        this.zo = new com.byazt.qw.pr(2);
        this.aj = 0;
        this.vk = true;
        this.w = Collections.synchronizedSet(new HashSet());
        this.k = false;
        this.m = null;
        this.yb = false;
        this.lb = true;
        this.a = true;
        this.cz = 0;
        this.ny = new JSONObject();
        this.fo = new HashMap<>();
        this.rc = false;
        this.z = false;
        this.b = null;
        this.iu = -1;
        this.ve = -1;
        this.gz = -1;
        this.nl = -1L;
        this.ls = false;
        this.er = false;
        this.qn = null;
    }

    public void g() {
        ho();
        Context context = a.getContext();
        this.w.add(4);
        hn(context);
    }

    public void ho() {
        this.s = com.byazt.iq.pr.hw();
    }

    private void hn(Context context) {
        if (this.g != null) {
            return;
        }
        this.g = new com.byazt.wt.pr();
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(this.g);
        } else if (context != null && context.getApplicationContext() != null) {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(this.g);
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 23, MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_CREATE_TIME})
    private static class hw {
        public static zo pr = new zo();
    }

    public static zo nt() {
        return hw.pr;
    }

    public void pr(com.byazt.qe.x xVar) {
        this.ho = xVar;
    }

    public com.byazt.qam.fw yb() {
        return new com.byazt.qam.fw(a(), false);
    }

    public z lb() {
        return new com.byazt.qam.fw(a(), true);
    }

    public String qa() {
        return this.qn;
    }

    public void hw(String str) {
        this.qn = str;
    }

    public com.byazt.qe.x a() {
        if (this.ho == null || this.ho.m()) {
            this.ho = of() ? pr : cr();
        }
        return this.ho;
    }

    private com.byazt.zq.hn iy() {
        if (this.v == null) {
            synchronized (this) {
                if (this.v == null) {
                    this.v = com.byazt.qn.x.pr(this.hw, "sp_global_info");
                }
            }
        }
        return this.v;
    }

    public boolean cz() {
        return iy().hw("sdk_activate_init", true);
    }

    public void hw(boolean z) {
        iy().pr("sdk_activate_init", z);
    }

    public String ny() {
        return this.hw;
    }

    public void hn(String str) {
        ho(str);
        this.hw = str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PluginConstants.KEY_APP_ID, str);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.7.1.4");
            jSONObject.put("sdk_version", iu.c);
            this.ny.put("com.byted.pangle", jSONObject);
        } catch (Exception e) {
        }
    }

    public String fo() {
        return this.hn;
    }

    public void x(String str) {
        nt(str);
        this.hn = str;
    }

    public boolean rc() {
        return this.x;
    }

    public void hn(boolean z) {
        this.x = z;
    }

    public String z() {
        if (!TextUtils.isEmpty(this.c)) {
            return this.c;
        }
        return com.byazt.mp.x.pr().x("");
    }

    public void c(String str) {
        yb(str);
        this.c = str;
    }

    public void pr(int i) {
        this.zo = new com.byazt.qw.pr(i, true);
    }

    public com.byazt.qw.pr b() {
        return this.zo;
    }

    public String iu() {
        if (!TextUtils.isEmpty(this.uc)) {
            return this.uc;
        }
        return com.byazt.mp.x.pr().uc("");
    }

    public Map<String, Object> ve() {
        if (!this.fo.isEmpty()) {
            return this.fo;
        }
        String strZo = com.byazt.mp.x.pr().zo("");
        this.fo.putAll(TextUtils.isEmpty(strZo) ? g(strZo) : new HashMap<>());
        return this.fo;
    }

    public void uc(final String str) {
        lb(str);
        ((qi) com.byazt.zs.uc.pr("thread_service")).pr(new Runnable() { // from class: com.byazt.sd.zo.1
            @Override // java.lang.Runnable
            public void run() {
                zo.this.m(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(String str) {
        JSONArray jSONArray;
        try {
            jSONArray = TextUtils.isEmpty(str) ? new JSONArray() : new JSONArray(str);
        } catch (Exception e) {
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
                    String strOptString2 = jSONObjectOptJSONObject.optString(Constants.VALUE_FIELD);
                    if (!TextUtils.isEmpty(strOptString)) {
                        map.put(strOptString, strOptString2);
                    }
                } else if ("csj_rit_list".equals(jSONObjectOptJSONObject.optString(Common.System.NAME))) {
                    aj(jSONObjectOptJSONObject.optString(Constants.VALUE_FIELD));
                    jSONArray.remove(i);
                    z = true;
                } else {
                    jSONArray2.put(jSONObjectOptJSONObject);
                }
            }
        }
        if (z) {
            this.uc = jSONArray.toString();
        } else {
            this.uc = str;
        }
        if ((jSONArray2.length() == 0 && map.isEmpty()) || jSONArray2.length() != 0) {
            this.uc = jSONArray2.toString();
        }
        if (!map.isEmpty()) {
            this.fo.putAll(map);
        }
    }

    public void hw(int i) {
        this.aj = i;
    }

    public int gz() {
        if (com.byazt.iy.hw.pr()) {
            return iy().hw("title_bar_theme", 0);
        }
        return this.aj;
    }

    public void x(boolean z) {
        this.vk = z;
    }

    public boolean nl() {
        if (com.byazt.iy.hw.pr()) {
            return iy().hw("allow_show_notify", true);
        }
        return this.vk;
    }

    public void c(boolean z) {
        hn(z);
    }

    public void fw(String str) {
        uc(str);
        if (com.byazt.iy.hw.pr()) {
            com.byazt.mp.x.pr().c(str);
            com.byazt.mp.x.pr().fw(pr(this.fo));
        }
    }

    public void zo(String str) {
        c(str);
        com.byazt.mp.x.pr().hn(str);
    }

    public void pr(boolean z, SparseArray<Object> sparseArray) {
        com.byazt.ca.ho.hw("bstsdk", "bst(true) stat-quit, run new pl");
        this.yb = z;
        com.byazt.iq.pr.pr(true);
        ((qi) com.byazt.zs.uc.pr("thread_service")).hn(new Runnable() { // from class: com.byazt.sd.zo.2
            @Override // java.lang.Runnable
            public void run() {
                zo.unregisterReceiver();
                com.byazt.kq.c.pr().hw();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void unregisterReceiver() {
        DeviceUtils.w();
        DeviceUtils.k();
    }

    public boolean y() {
        return this.yb;
    }

    public void ww() {
        com.byazt.mp.x.pr().hw(this.cz);
        com.byazt.mp.x.pr().hn(this.c);
        com.byazt.mp.x.pr().c(this.uc);
        com.byazt.mp.x.pr().fw(pr(this.fo));
        iy().pr("title_bar_theme", this.aj);
        iy().pr("allow_show_notify", this.vk);
        com.byazt.mp.x.pr().hw(this.k);
        Set<Integer> set = this.w;
        if (set != null && !set.isEmpty()) {
            Iterator<Integer> it = this.w.iterator();
            StringBuilder sb = new StringBuilder();
            while (it.hasNext()) {
                sb.append(it.next()).append(",");
            }
            iy().pr("network_state", sb.toString());
            return;
        }
        iy().pr("network_state");
    }

    public boolean n() {
        return this.er;
    }

    public JSONObject e() {
        return this.ny;
    }

    public void pr(String str, String str2) {
        try {
            JSONObject jSONObjectOptJSONObject = this.ny.optJSONObject(str);
            if (jSONObjectOptJSONObject != null) {
                jSONObjectOptJSONObject.putOpt(PluginConstants.KEY_PLUGIN_VERSION, str2);
            }
        } catch (JSONException e) {
            com.byazt.ca.ho.hw("GlobalInfo", "JSONObject not found for name " + str + " when update plugin config.");
        }
    }

    public void pr(String str, String str2, String str3, String str4) {
        try {
            JSONObject jSONObjectOptJSONObject = this.ny.optJSONObject(str);
            if (TextUtils.isEmpty(str4)) {
                str4 = this.hw;
            }
            if (jSONObjectOptJSONObject == null) {
                jSONObjectOptJSONObject = new JSONObject();
            }
            jSONObjectOptJSONObject.put(PluginConstants.KEY_APP_ID, str4);
            jSONObjectOptJSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, str3);
            jSONObjectOptJSONObject.put("sdk_version", str2);
            this.ny.put(str, jSONObjectOptJSONObject);
        } catch (JSONException e) {
            e.getMessage();
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0063  */
    public void s() {
        String string;
        JSONObject jSONObject = new JSONObject();
        try {
            String strX = com.byazt.da.c.x();
            if (TextUtils.isEmpty(strX)) {
                strX = "2.0.0";
            }
            jSONObject.put("gdt_version", strX);
        } catch (JSONException e) {
        }
        com.byazt.zp.m.pr();
        int iC = com.byazt.da.c.c();
        if (iC != 0) {
            String string2 = new StringBuilder().append(iC).toString();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < string2.length(); i++) {
                sb.append(string2.charAt(i));
                if (i != string2.length() - 1) {
                    sb.append(".");
                }
            }
            if (!TextUtils.isEmpty(sb.toString())) {
                string = sb.toString();
            } else {
                string = "0.0.0.0";
            }
        } else {
            string = "0.0.0.0";
        }
        if (jSONObject.has("gdt_version")) {
            try {
                com.byazt.da.c.pr("dex_status", 1);
                jSONObject.put(PluginConstants.KEY_APP_ID, this.hw);
                jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, string);
                jSONObject.put("sdk_version", "2.0.0.0");
                jSONObject.put("plugin_update_network", "2");
                this.ny.put("com.byted.mixed", jSONObject);
            } catch (JSONException e2) {
            }
        }
    }

    public void pr(Bundle bundle) {
        if (bundle != null && bundle.keySet().size() > 0) {
            for (String str : bundle.keySet()) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        Bundle bundle2 = bundle.getBundle(str);
                        if (bundle2 == null) {
                            return;
                        }
                        String string = bundle2.getString(PluginConstants.KEY_APP_ID, this.hw);
                        pr(str, bundle2.getString("sdk_version"), bundle2.getString(PluginConstants.KEY_PLUGIN_VERSION), string);
                    } catch (Exception e) {
                    }
                }
            }
        }
    }

    public Function<SparseArray<Object>, Object> ls() {
        Function<SparseArray<Object>, Object> function = this.qa;
        if (function != null) {
            return function;
        }
        com.byazt.lm.nt ntVarPr = com.byazt.lm.nt.pr(a.getContext());
        this.qa = ntVarPr;
        return ntVarPr;
    }

    public boolean hn(int i) {
        if (com.byazt.iy.hw.pr()) {
            String strHw = iy().hw("network_state", "");
            if (!TextUtils.isEmpty(strHw)) {
                String[] strArrSplit = strHw.split(",");
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
        Set<Integer> set = this.w;
        return set != null && set.contains(Integer.valueOf(i));
    }

    public void pr(int... iArr) {
        if (iArr == null) {
            return;
        }
        try {
            this.w.clear();
            for (int i : iArr) {
                this.w.add(Integer.valueOf(i));
            }
        } catch (Throwable th) {
        }
    }

    private static final String pr(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey())) {
                try {
                    jSONObject.putOpt(entry.getKey(), entry.getValue());
                } catch (Exception e) {
                }
            }
        }
        return jSONObject.toString();
    }

    private static final HashMap<String, Object> g(String str) {
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
        } catch (Exception e) {
            return new HashMap<>();
        }
    }

    private static void ho(String str) {
        com.byazt.ca.lb.pr(str, "appid不能为空");
    }

    private static void nt(String str) {
        com.byazt.ca.lb.pr(str, "name不能为空");
    }

    private static void yb(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.byazt.ca.lb.pr(str.length() <= 1000, "keyword超长, 最长为1000");
        }
    }

    private static void lb(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.byazt.ca.lb.pr(str.length() <= 20000, "data超长, 最长为20000");
        }
    }

    public com.byazt.sb.x er() {
        if (this.qi == null) {
            this.qi = new com.byazt.sb.x(10, 8);
        }
        return this.qi;
    }

    public boolean v() {
        if (com.byazt.mp.hn.pr().hw()) {
            return com.byazt.mp.x.pr().pr(false);
        }
        return this.k;
    }

    public void uc(boolean z) {
        iu.aj = z;
        this.k = z;
    }

    public Bitmap qi() {
        if (com.byazt.iy.hw.pr()) {
            return com.byazt.ca.hn.pr(iy().hw("pause_icon", ""));
        }
        return this.m;
    }

    public void pr(Bitmap bitmap) {
        if (com.byazt.iy.hw.pr()) {
            String strPr = com.byazt.ca.hn.pr(bitmap);
            if (!TextUtils.isEmpty(strPr)) {
                iy().pr("pause_icon", strPr);
            }
        }
        this.m = bitmap;
    }

    public int qn() {
        if (com.byazt.mp.hn.pr().hw()) {
            int iX = com.byazt.mp.x.pr().x();
            if (iX == Integer.MIN_VALUE) {
                return this.cz;
            }
            return iX;
        }
        return this.cz;
    }

    public void x(int i) {
        if (i < 0 || i > 2) {
            i = 0;
        }
        try {
            this.cz = i;
        } catch (Throwable th) {
        }
    }

    private static com.byazt.qe.x cr() {
        return new com.byazt.qe.x.pr().hw(true).pr(true).pr((com.byazt.qe.hn) null).hn(true).pr((String) null).x(true).hw((String) null).c(true).hn((String) null).uc(true).x((String) null).fw(false).pr();
    }

    @com.byazt.vzx.pr(pr = {0, 1, 23, 673})
    public static final class pr extends com.byazt.qe.x {
        public pr() {
            super(null);
        }

        @Override // com.byazt.qe.x
        public boolean pr() {
            return "1".equals(com.byazt.hs.hn.pr(7, "1"));
        }

        @Override // com.byazt.qe.x
        public boolean hw() {
            return "1".equals(com.byazt.hs.hn.pr(17, "1"));
        }

        @Override // com.byazt.qe.x
        public boolean hn() {
            return "1".equals(com.byazt.hs.hn.pr(9, "1"));
        }

        @Override // com.byazt.qe.x
        public boolean x() {
            return "1".equals(com.byazt.hs.hn.pr(11, "1"));
        }

        @Override // com.byazt.qe.x
        public boolean c() {
            return "1".equals(com.byazt.hs.hn.pr(12, "1"));
        }

        @Override // com.byazt.qe.x
        public boolean uc() {
            return "1".equals(com.byazt.hs.hn.pr(22, "1"));
        }

        @Override // com.byazt.qe.x
        public boolean fw() {
            return false;
        }

        @Override // com.byazt.qe.x
        public boolean zo() {
            return "1".equals(com.byazt.hs.hn.pr(24, "1"));
        }

        @Override // com.byazt.qe.x
        public com.byazt.qe.hn aj() {
            String[] strArrSplit;
            String strPr = com.byazt.hs.hn.pr(8, "");
            if (TextUtils.isEmpty(strPr) || (strArrSplit = strPr.split(",")) == null) {
                return null;
            }
            String str = strArrSplit.length > 0 ? strArrSplit[0] : "";
            String str2 = strArrSplit.length > 1 ? strArrSplit[1] : "";
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                return null;
            }
            return new com.byazt.qe.hn.pr().pr(Double.valueOf(str).doubleValue()).hw(Double.valueOf(str2).doubleValue()).pr();
        }

        @Override // com.byazt.qe.x
        public String vk() {
            return com.byazt.hs.hn.pr(10, "");
        }

        @Override // com.byazt.qe.x
        public String w() {
            return com.byazt.hs.hn.pr(18, "");
        }

        @Override // com.byazt.qe.x
        public String k() {
            return com.byazt.hs.hn.pr(13, "");
        }

        @Override // com.byazt.qe.x
        public boolean m() {
            return true;
        }
    }

    public boolean of() {
        return "5001121".equals(this.hw) && "com.union_test.toutiao".equals(ls.zo());
    }

    public boolean ii() {
        return "5001121".equals(this.hw);
    }

    public boolean i() {
        try {
            if (!"com.union_test.toutiao".equals(a.getContext().getPackageName()) || !"5001121".equals(this.hw)) {
                if (!"com.pangolin_demo.toutiao".equals(a.getContext().getPackageName()) || !"5001121".equals(this.hw)) {
                    if (!"com.bytedance.mediation_demo".equals(a.getContext().getPackageName()) || !"5001121".equals(this.hw)) {
                        if (!"com.msdk.qa.monkey".equals(a.getContext().getPackageName()) || !"5001121".equals(this.hw)) {
                            if (a.getContext().getPackageName().contains("com.bytedance.mediation_demo_csj") && "5001121".equals(this.hw)) {
                                return true;
                            }
                            return false;
                        }
                        return true;
                    }
                    return true;
                }
                return true;
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public String r() {
        if (!TextUtils.isEmpty(this.nt)) {
            return this.nt;
        }
        com.byazt.zq.hn hnVarPr = com.byazt.sd.hw.pr();
        String strHw = hnVarPr.hw("any_door_id", (String) null);
        this.nt = strHw;
        if (!TextUtils.isEmpty(strHw)) {
            return this.nt;
        }
        String strValueOf = String.valueOf(System.currentTimeMillis());
        hnVarPr.pr("any_door_id", strValueOf);
        this.nt = strValueOf;
        return strValueOf;
    }

    public boolean hs() {
        return this.lb;
    }

    public void fw(boolean z) {
        this.lb = z;
    }

    public void c(int i) {
        com.byazt.mp.x.pr().hn(i);
    }

    public int nw() {
        return com.byazt.mp.x.pr().x(0);
    }

    public Function<SparseArray<Object>, Object> ie() {
        return this.b;
    }

    public Function<SparseArray<Object>, Object> uc(int i) {
        if (this.b == null) {
            return null;
        }
        return (Function) this.b.apply(com.byazt.xi.hw.pr().pr(10).pr(Object.class).pr(0, Integer.valueOf(i)).hw());
    }

    public void pr(Function<SparseArray<Object>, Object> function) {
        if (this.b != null) {
            return;
        }
        this.b = function;
    }

    public boolean o() {
        return this.ww;
    }

    public void zo(boolean z) {
        this.ww = z;
    }

    public String f() {
        return this.fw;
    }

    public void aj(String str) {
        this.fw = str;
        com.byazt.is.zo.pr((com.byazt.is.c) null).pr(true);
    }

    public boolean pr(Context context) {
        if (com.byazt.na.pr.pr().c()) {
            this.iu = 2;
        } else {
            this.iu = 1;
        }
        return this.iu == 1;
    }

    public boolean hw(Context context) {
        if (com.byazt.na.pr.pr().c()) {
            this.ve = 2;
        } else {
            this.ve = 1;
        }
        return this.ve == 1;
    }

    public void fw(int i) {
        this.gz = i;
    }

    public int bm() {
        return this.gz;
    }

    public void pr(long j) {
        this.nl = j;
    }

    public long jn() {
        return this.nl;
    }

    public void pr(com.byazt.wt.pr.hw hwVar) {
        if (this.b != null) {
            if (this.y == null) {
                c cVar = new c();
                this.y = cVar;
                cVar.pr(this.b);
            }
            this.y.pr(hwVar);
        }
    }

    public void hw(com.byazt.wt.pr.hw hwVar) {
        c cVar = this.y;
        if (cVar != null) {
            cVar.hw(hwVar);
        }
    }

    public String l() {
        try {
            if ((a.hw().kl() & 1) == 1) {
                return com.byazt.mp.c.pr().c();
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    public Object lv() {
        WeakReference<Activity> weakReferencePr = this.g.pr();
        if (weakReferencePr != null) {
            return weakReferencePr.get();
        }
        Object objApply = null;
        if (this.b != null) {
            objApply = this.b.apply(com.byazt.xi.hw.pr().pr(14).pr(Activity.class).hw());
        }
        if (objApply == null) {
            return wt();
        }
        return objApply;
    }

    public void aj(boolean z) {
        iy().pr("update_advance_preview_mode", z);
        iy().pr("update_advance_preview_mode_time", System.currentTimeMillis());
    }

    public boolean od() {
        if (iy().hw("update_advance_preview_mode", false)) {
            long jHw = iy().hw("update_advance_preview_mode_time", -1L);
            if (jHw != -1) {
                if (System.currentTimeMillis() - jHw > 3600000) {
                    aj(false);
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public void vk(String str) {
        iy().pr("toolsQueryHost", str);
    }

    public String vj() {
        return iy().hw("toolsQueryHost", "api-access.pangolin-sdk-toutiao.com");
    }

    public void w(String str) {
        iy().pr("toolsAdPreviewUrl", str);
    }

    public String mw() {
        return iy().hw("toolsAdPreviewUrl", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/test-tool/0.0.4/html/ad_preview.html");
    }

    public void k(String str) {
        iy().pr("toolsBasicInfUrl", str);
    }

    public String sv() {
        return iy().hw("toolsBasicInfUrl", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/test-tool/0.0.4/html/basic_info.html");
    }

    public String gu() {
        return iy().hw("adnDetailUrl", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/test-tool/0.0.4/html/adn_detail.html");
    }

    public String d() {
        return iy().hw("ritDetailUrl", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/test-tool/0.0.4/html/rit_detail.html");
    }

    public String pq() {
        return iy().hw("codeidDetailUrl", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/test-tool/0.0.4/html/codeid_detail.html");
    }

    public hn jw() {
        return this.e;
    }

    public void pr(hn hnVar) {
        this.e = hnVar;
    }

    public static Object wt() {
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
                        Field declaredField3 = cls2.getDeclaredField(TTDownloadField.TT_ACTIVITY);
                        declaredField3.setAccessible(true);
                        return declaredField3.get(obj);
                    }
                }
                return null;
            }
            return null;
        } catch (Exception e) {
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 23, 498})
    public static class hn {
        public String hw;
        public Map<String, Object> pr;

        public hn(Map<String, Object> map, String str) {
            this.pr = map;
            this.hw = str;
        }

        public void pr(JSONObject jSONObject) throws JSONException {
            Map<String, Object> map;
            if (jSONObject == null || (map = this.pr) == null || map.size() == 0 || TextUtils.isEmpty(this.hw)) {
                return;
            }
            for (Map.Entry<String, Object> entry : this.pr.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            jSONObject.put("preview_ads", new JSONObject(this.hw));
        }
    }
}
