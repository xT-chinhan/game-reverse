package com.byazt.ed;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.anythink.core.common.f.e;
import com.byazt.qyu.PluginConstants;
import com.byazt.vf.k;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 854, 8})
public class s {
    public volatile String a;
    public volatile String cd;
    public volatile String fs;
    public volatile String hd;
    public volatile String l;
    public volatile String n;
    public volatile String oa;
    public volatile String ou;
    public volatile JSONArray py;
    public volatile String q;
    public volatile String qg;
    public volatile String rv;
    public volatile String s;
    public volatile String sz;
    public volatile String tj;
    public volatile String um;
    public volatile String w;
    public volatile String wm;
    public volatile String x;
    public volatile int cp = -1;
    public volatile int d = -1;
    public volatile int k = -1;
    public volatile int cy = -1;
    public volatile int m = -1;

    public String cd() {
        return "sp_exec_getad_config";
    }

    public boolean x(int i) {
        return i == 3 || i == 4;
    }

    @com.byazt.cp.n(n = {0, 1, 854, 546})
    private static class n {
        public static s n = new s();
    }

    public static s n() {
        return n.n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.gwu.s um() {
        return com.byazt.lk.l.qg(com.byazt.vyf.s.cy().ou(), cd(), 1, com.byazt.p001if.n.qg());
    }

    public int qg() {
        if (this.cp == -1) {
            this.cp = qg("live_ad_clk_cnt", 0);
        }
        return this.cp;
    }

    public void n(int i) {
        if (this.cp == i) {
            return;
        }
        this.cp = i;
        n("live_ad_clk_cnt", i);
    }

    public String n(String str) {
        if (this.oa == null) {
            this.oa = qg("dev03", str);
        }
        return this.oa;
    }

    public void qg(String str) {
        this.oa = str;
        n("dev03", str);
    }

    public void s(String str) {
        if (str == null || !str.equals(this.sz)) {
            this.sz = str;
            n("keywords", str);
        }
    }

    public String q(String str) {
        if (this.sz == null) {
            this.sz = qg("keywords", str);
        }
        return this.sz;
    }

    public void qg(int i) {
        if (i == this.k) {
            return;
        }
        this.k = i;
        n("age_group", i);
    }

    public int s() {
        if (this.k == -1) {
            this.k = qg("age_group", Integer.MIN_VALUE);
        }
        return this.k;
    }

    public void s(int i) {
        if (i == this.cy) {
            return;
        }
        this.cy = i;
        n("sdk_theme_status", i);
    }

    public int q(int i) {
        if (this.cy == -1) {
            this.cy = qg("sdk_theme_status", i);
        }
        return this.cy;
    }

    public void l(String str) {
        if (str == null || !str.equals(this.hd)) {
            this.hd = str;
            n("extra_data", str);
        }
    }

    public String w(String str) {
        if (this.hd == null) {
            this.hd = qg("extra_data", str);
        }
        return this.hd;
    }

    public void x(String str) {
        if (str == null || !str.equals(this.cd)) {
            this.cd = str;
            n("extra_internal_data", str);
        }
    }

    public String fs(String str) {
        if (this.cd == null) {
            this.cd = qg("extra_internal_data", str);
        }
        return this.cd;
    }

    public String l(int i) {
        if (TextUtils.isEmpty(this.um)) {
            try {
                String strQg = qg("logsdk_version", "");
                if (!TextUtils.isEmpty(strQg)) {
                    JSONObject jSONObject = new JSONObject(strQg);
                    int iOptInt = jSONObject.optInt(PluginConstants.KEY_PLUGIN_VERSION);
                    this.um = jSONObject.optString("log_version");
                    if (iOptInt != 7814 || TextUtils.isEmpty(this.um)) {
                        a();
                    }
                } else {
                    a();
                }
            } catch (Exception unused) {
            }
        }
        return this.um;
    }

    private void a() {
        try {
            this.um = com.byazt.yu.n.n().q();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, 7814);
            jSONObject.put("log_version", this.um);
            n("logsdk_version", jSONObject.toString());
        } catch (JSONException unused) {
        }
    }

    public String rv(String str) {
        if (this.n == null) {
            this.n = qg("dev01", str);
        }
        return this.n;
    }

    public String q() {
        if (this.qg == null) {
            this.qg = ((k) com.byazt.qp.q.n("encrypt_service")).q(qg("dev02", (String) null));
        }
        return this.qg;
    }

    public String l() {
        if (this.s == null) {
            this.s = qg("dev04", (String) null);
        }
        return this.s;
    }

    public String w() {
        if (this.q == null) {
            this.q = qg("dev05", (String) null);
        }
        return this.q;
    }

    public String x() {
        if (this.l == null) {
            this.l = qg("dev07", (String) null);
        }
        return this.l;
    }

    public String fs() {
        if (this.w == null) {
            this.w = qg("dev08", (String) null);
        }
        return this.w;
    }

    public String rv() {
        if (this.x == null) {
            this.x = qg("dev17", (String) null);
        }
        return this.x;
    }

    public String tj() {
        if (this.fs == null) {
            this.fs = qg("dev18", (String) null);
        }
        return this.fs;
    }

    public String cp() {
        if (this.rv == null) {
            this.rv = qg("dev09", (String) null);
        }
        return this.rv;
    }

    public void tj(String str) {
        if (str == null || str.equals(this.a)) {
            return;
        }
        this.a = str;
        n("dev10", str);
    }

    public String d() {
        if (this.a == null) {
            this.a = qg("dev10", (String) null);
        }
        return this.a;
    }

    public String oa() {
        if (this.tj == null) {
            this.tj = qg("dev11", (String) null);
        }
        return this.tj;
    }

    public void n(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        try {
            String string = jSONArray.toString();
            if (TextUtils.equals(string, this.ou)) {
                return;
            }
            this.py = jSONArray;
            this.ou = string;
            n("dev12", string);
        } catch (Throwable unused) {
        }
    }

    public JSONArray sz() {
        String strQg;
        if (this.py == null && (strQg = qg("dev12", (String) null)) != null) {
            try {
                this.py = new JSONArray(strQg);
                this.ou = strQg;
            } catch (JSONException unused) {
            }
        }
        return this.py;
    }

    public int k() {
        return qg("sp_device_app_direction", -1);
    }

    public void w(int i) {
        n("sp_device_app_direction", i);
    }

    public String cy() {
        if (this.wm == null) {
            this.wm = qg("dev16", "");
        }
        return this.wm;
    }

    public void cp(String str) {
        if (str == null || !str.equals(this.wm)) {
            this.wm = str;
            n("dev16", str);
        }
    }

    public boolean n(boolean z) {
        if (this.d == -1) {
            this.d = qg("is_use_mediation", z ? 1 : 2);
        }
        return this.d == 1;
    }

    public void qg(boolean z) {
        int i = z ? 1 : 2;
        if (this.d != i) {
            this.d = i;
            n("is_use_mediation", i);
        }
    }

    public void fs(int i) {
        if (this.m == i) {
            return;
        }
        this.m = i;
        n("dev_level", i);
    }

    public void n(String str, long j) {
        try {
            um().n(str, j);
        } catch (Throwable unused) {
        }
    }

    public long qg(String str, long j) {
        try {
            return um().getLong(str, j);
        } catch (Throwable unused) {
            return j;
        }
    }

    public void n(String str, int i) {
        try {
            um().n(str, i);
        } catch (Throwable unused) {
        }
    }

    public int qg(String str, int i) {
        try {
            return um().getInt(str, i);
        } catch (Throwable unused) {
            return i;
        }
    }

    public void n(String str, String str2) {
        try {
            um().n(str, str2);
        } catch (Throwable unused) {
        }
    }

    public String qg(String str, String str2) {
        try {
            return um().getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public String s(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String strQg = qg(str, "");
            if (TextUtils.isEmpty(strQg)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(strQg);
            if (System.currentTimeMillis() - jSONObject.getLong("time") <= j) {
                return jSONObject.getString(e.a.d);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public void s(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(e.a.d, str2);
            jSONObject.put("time", System.currentTimeMillis());
            jSONObject.put("p_version", 7814);
            n(str, jSONObject.toString());
        } catch (JSONException unused) {
        }
    }

    public void hd() {
        try {
            um().n();
        } catch (Throwable unused) {
        }
    }

    @com.byazt.cp.n(n = {0, 1, 854, 782})
    public static class qg {
        public Map<String, Object> n = new HashMap();

        public qg n(String str) {
            if (str == null || str.equals(s.n().n)) {
                return this;
            }
            s.n().n = str;
            this.n.put("dev01", str);
            return this;
        }

        public qg qg(String str) {
            if (str == null || str.equals(s.n().qg)) {
                return this;
            }
            s.n().qg = str;
            this.n.put("dev02", ((k) com.byazt.qp.q.n("encrypt_service")).s(str));
            return this;
        }

        public qg s(String str) {
            if (str == null || str.equals(s.n().s)) {
                return this;
            }
            s.n().s = str;
            this.n.put("dev04", str);
            return this;
        }

        public qg q(String str) {
            if (str == null || str.equals(s.n().q)) {
                return this;
            }
            s.n().q = str;
            this.n.put("dev05", str);
            return this;
        }

        public qg l(String str) {
            if (str == null || str.equals(s.n().tj)) {
                return this;
            }
            s.n().tj = str;
            this.n.put("dev11", str);
            return this;
        }

        public qg w(String str) {
            if (str == null || str.equals(s.n().l)) {
                return this;
            }
            s.n().l = str;
            this.n.put("dev07", str);
            return this;
        }

        public qg x(String str) {
            if (str == null || str.equals(s.n().w)) {
                return this;
            }
            s.n().w = str;
            this.n.put("dev08", str);
            return this;
        }

        public qg fs(String str) {
            if (str == null || str.equals(s.n().x)) {
                return this;
            }
            s.n().x = str;
            this.n.put("dev17", str);
            return this;
        }

        public qg rv(String str) {
            if (str == null || str.equals(s.n().fs)) {
                return this;
            }
            s.n().fs = str;
            this.n.put("dev18", str);
            return this;
        }

        public qg tj(String str) {
            if (str == null || str.equals(s.n().rv)) {
                return this;
            }
            s.n().rv = str;
            this.n.put("dev09", str);
            return this;
        }

        public void n() {
            try {
                com.byazt.gwu.s sVarUm = s.n().um();
                SharedPreferences.Editor editorEdit = sVarUm.edit();
                if (editorEdit != null) {
                    for (Map.Entry<String, Object> entry : this.n.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (value instanceof Boolean) {
                            editorEdit.putBoolean(key, ((Boolean) value).booleanValue());
                        } else if (value instanceof Long) {
                            editorEdit.putLong(key, ((Long) value).longValue());
                        } else if (value instanceof Float) {
                            editorEdit.putFloat(key, ((Float) value).floatValue());
                        } else if (value instanceof Integer) {
                            editorEdit.putInt(key, ((Integer) value).intValue());
                        } else if (value instanceof String) {
                            editorEdit.putString(key, (String) value);
                        }
                    }
                    editorEdit.apply();
                    return;
                }
                for (Map.Entry<String, Object> entry2 : this.n.entrySet()) {
                    String key2 = entry2.getKey();
                    Object value2 = entry2.getValue();
                    if (value2 instanceof Boolean) {
                        sVarUm.n(key2, ((Boolean) value2).booleanValue());
                    } else if (value2 instanceof Long) {
                        sVarUm.n(key2, ((Long) value2).longValue());
                    } else if (value2 instanceof Float) {
                        sVarUm.n(key2, ((Float) value2).floatValue());
                    } else if (value2 instanceof Integer) {
                        sVarUm.n(key2, ((Integer) value2).intValue());
                    } else if (value2 instanceof String) {
                        sVarUm.n(key2, (String) value2);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }
}
