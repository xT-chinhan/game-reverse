package com.bytedance.sdk.openadsdk.core.ah;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.anythink.core.common.e.f;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.re;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    protected volatile String ab;
    protected volatile String ah;
    private volatile String b;
    protected volatile String c;
    protected volatile String ch;
    protected volatile String d;
    private volatile String g;
    private volatile String h;
    private volatile String i;
    protected volatile String ka;
    private volatile String le;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected volatile String f1970ms;
    private volatile String nw;
    protected volatile String ny;
    private volatile String op;
    private volatile String qv;
    private volatile String re;
    private volatile String u;
    private volatile JSONArray w;
    protected volatile String x;
    protected volatile String xr;
    private volatile String yu;
    private volatile String zb;
    private volatile int sl = -1;
    private volatile int ub = -1;
    private volatile int ao = -1;
    private volatile int y = -1;
    private volatile int t = -1;
    private volatile int cv = -1;
    private volatile SharedPreferences hi = com.bytedance.sdk.openadsdk.api.plugin.xr.xr(re.getContext(), "sp_exec_getad_config", 0);

    public boolean ab(int i) {
        return i == 3 || i == 4;
    }

    private static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private static d f1971ms = new d();
    }

    public static d ms() {
        return ms.f1971ms;
    }

    public SharedPreferences xr() {
        return this.hi;
    }

    public int ah() {
        if (this.sl == -1) {
            this.sl = xr("live_ad_clk_cnt", 0);
        }
        return this.sl;
    }

    public void ms(int i) {
        if (this.sl == i) {
            return;
        }
        this.sl = i;
        ms("live_ad_clk_cnt", i);
    }

    public String d() {
        if (this.zb == null) {
            this.zb = ah("app_id", "");
        }
        return this.zb;
    }

    public void ms(String str) {
        if (str == null || !str.equals(this.zb)) {
            this.zb = str;
            xr("app_id", str);
        }
    }

    public String ka() {
        if (this.u == null) {
            this.u = ah("app_name", "");
        }
        return this.u;
    }

    public void xr(String str) {
        if (str == null || !str.equals(this.u)) {
            this.u = str;
            xr("app_name", str);
        }
    }

    public boolean ms(boolean z) {
        if (this.ub == -1) {
            this.ub = xr("is_paid", z ? 1 : 2);
        }
        return this.ub == 1;
    }

    public void xr(boolean z) {
        this.ub = z ? 1 : 2;
        ms("is_paid", this.ub);
    }

    public String ah(String str) {
        if (this.h == null) {
            this.h = ah("dev03", str);
        }
        return this.h;
    }

    public void d(String str) {
        this.h = str;
        xr("dev03", str);
    }

    public void ka(String str) {
        if (str == null || !str.equals(this.qv)) {
            this.qv = str;
            xr("keywords", str);
        }
    }

    public String c(String str) {
        if (this.qv == null) {
            this.qv = ah("keywords", str);
        }
        return this.qv;
    }

    public void xr(int i) {
        if (i == this.y) {
            return;
        }
        this.y = i;
        ms("age_group", i);
    }

    public int c() {
        if (this.y == -1) {
            this.y = xr("age_group", Integer.MIN_VALUE);
        }
        return this.y;
    }

    public String ms(String str, String str2) {
        return ah("code_group_rit_".concat(String.valueOf(str)), str2);
    }

    public void ah(int i) {
        if (i == this.t) {
            return;
        }
        this.t = i;
        ms("sdk_theme_status", i);
    }

    public int d(int i) {
        if (this.t == -1) {
            this.t = xr("sdk_theme_status", i);
        }
        return this.t;
    }

    public void ab(String str) {
        if (str == null || !str.equals(this.nw)) {
            this.nw = str;
            xr("extra_data", str);
        }
    }

    public String x(String str) {
        if (this.nw == null) {
            this.nw = ah("extra_data", str);
        }
        return this.nw;
    }

    public void ny(String str) {
        if (str == null || !str.equals(this.b)) {
            this.b = str;
            xr("extra_internal_data", str);
        }
    }

    public String ch(String str) {
        if (this.b == null) {
            this.b = ah("extra_internal_data", str);
        }
        return this.b;
    }

    public String ka(int i) {
        if (TextUtils.isEmpty(this.re)) {
            try {
                String strAh = ah("logsdk_version", "");
                if (!TextUtils.isEmpty(strAh)) {
                    JSONObject jSONObject = new JSONObject(strAh);
                    int iOptInt = jSONObject.optInt(PluginConstants.KEY_PLUGIN_VERSION);
                    this.re = jSONObject.optString("log_version");
                    if (iOptInt != 6923 || TextUtils.isEmpty(this.re)) {
                        i();
                    }
                } else {
                    i();
                }
            } catch (Exception unused) {
            }
        }
        return this.re;
    }

    private void i() {
        try {
            this.re = com.bytedance.sdk.openadsdk.core.c.ms().ka();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, 6923);
            jSONObject.put("log_version", this.re);
            xr("logsdk_version", jSONObject.toString());
        } catch (JSONException unused) {
        }
    }

    public String hi(String str) {
        if (this.f1970ms == null) {
            this.f1970ms = ah("dev01", str);
        }
        return this.f1970ms;
    }

    public String ab() {
        if (this.xr == null) {
            this.xr = com.bytedance.sdk.component.utils.ms.ah(ah("dev02", (String) null));
        }
        return this.xr;
    }

    public String x() {
        if (this.ah == null) {
            this.ah = ah("dev04", (String) null);
        }
        return this.ah;
    }

    public String ny() {
        if (this.d == null) {
            this.d = ah("dev05", (String) null);
        }
        return this.d;
    }

    public String ch() {
        if (this.ka == null) {
            this.ka = ah("dev07", (String) null);
        }
        return this.ka;
    }

    public String hi() {
        if (this.c == null) {
            this.c = ah("dev08", (String) null);
        }
        return this.c;
    }

    public String sl() {
        if (this.ab == null) {
            this.ab = ah("dev17", (String) null);
        }
        return this.ab;
    }

    public String zb() {
        if (this.x == null) {
            this.x = ah("dev18", (String) null);
        }
        return this.x;
    }

    public String u() {
        if (this.ny == null) {
            this.ny = ah("dev09", (String) null);
        }
        return this.ny;
    }

    public void sl(String str) {
        if (str == null || str.equals(this.i)) {
            return;
        }
        this.i = str;
        xr("dev10", str);
    }

    public String ub() {
        if (this.i == null) {
            this.i = ah("dev10", (String) null);
        }
        return this.i;
    }

    public String ao() {
        if (this.ch == null) {
            this.ch = ah("dev11", (String) null);
        }
        return this.ch;
    }

    public void ms(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        if (jSONArray.toString().equals(this.w == null ? null : this.w.toString())) {
            return;
        }
        this.w = jSONArray;
        xr("dev12", jSONArray.toString());
    }

    public JSONArray h() {
        String strAh;
        if (this.w == null && (strAh = ah("dev12", (String) null)) != null) {
            try {
                this.w = new JSONArray(strAh);
            } catch (JSONException e) {
                sl.ms(e);
            }
        }
        return this.w;
    }

    public void zb(String str) {
        if (str == null || str.equals(this.yu)) {
            return;
        }
        this.yu = str;
        d("dev13", str);
    }

    public String qv() {
        if (this.yu == null) {
            this.yu = ah("dev13", (String) null);
        }
        return this.yu;
    }

    public void u(String str) {
        if (str == null || str.equals(this.op)) {
            return;
        }
        this.op = str;
        d("dev15", str);
    }

    public String y() {
        if (this.op == null) {
            this.op = ah("dev15", (String) null);
        }
        return this.op;
    }

    public int t() {
        return xr("sp_device_app_direction", -1);
    }

    public void c(int i) {
        ms("sp_device_app_direction", i);
    }

    public String nw() {
        if (this.le == null) {
            this.le = ah("dev16", "");
        }
        return this.le;
    }

    public void ub(String str) {
        if (str == null || !str.equals(this.le)) {
            this.le = str;
            xr("dev16", str);
        }
    }

    public boolean ah(boolean z) {
        if (this.ao == -1) {
            this.ao = xr("is_use_mediation", z ? 1 : 2);
        }
        return this.ao == 1;
    }

    public void d(boolean z) {
        int i = z ? 1 : 2;
        if (this.ao != i) {
            this.ao = i;
            ms("is_use_mediation", i);
        }
    }

    public void x(int i) {
        if (this.cv == i) {
            return;
        }
        this.cv = i;
        ms("dev_level", i);
    }

    public String b() {
        if (this.g == null) {
            this.g = ah("spl_strategy", "");
        }
        return this.g;
    }

    public void ao(String str) {
        if (str == null || !str.equals(this.g)) {
            this.g = str;
            xr("spl_strategy", this.g);
        }
    }

    public void ms(String str, long j) {
        try {
            if (ah.ms().xr()) {
                com.bytedance.sdk.component.ab.ah.ms.xr.ms("sp_exec_getad_config", str, Long.valueOf(j));
                return;
            }
            SharedPreferences.Editor editorEdit = xr().edit();
            editorEdit.putLong(str, j);
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }

    public long xr(String str, long j) {
        try {
            if (ah.ms().xr()) {
                return com.bytedance.sdk.component.ab.ah.ms.xr.ms("sp_exec_getad_config", str, j);
            }
            return xr().getLong(str, j);
        } catch (Throwable unused) {
            return j;
        }
    }

    public void ms(String str, int i) {
        try {
            if (ah.ms().xr()) {
                com.bytedance.sdk.component.ab.ah.ms.xr.ms("sp_exec_getad_config", str, Integer.valueOf(i));
                return;
            }
            SharedPreferences.Editor editorEdit = xr().edit();
            editorEdit.putInt(str, i);
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }

    public int xr(String str, int i) {
        try {
            if (ah.ms().xr()) {
                return com.bytedance.sdk.component.ab.ah.ms.xr.ms("sp_exec_getad_config", str, i);
            }
            return xr().getInt(str, i);
        } catch (Throwable unused) {
            return i;
        }
    }

    public void xr(String str, String str2) {
        try {
            if (ah.ms().xr()) {
                com.bytedance.sdk.component.ab.ah.ms.xr.ms("sp_exec_getad_config", str, str2);
                return;
            }
            SharedPreferences.Editor editorEdit = xr().edit();
            editorEdit.putString(str, str2);
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }

    public String ah(String str, String str2) {
        try {
            if (ah.ms().xr()) {
                return com.bytedance.sdk.component.ab.ah.ms.xr.xr("sp_exec_getad_config", str, str2);
            }
            return xr().getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public String ah(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String strAh = ah(str, "");
            if (TextUtils.isEmpty(strAh)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(strAh);
            if (System.currentTimeMillis() - jSONObject.getLong("time") <= j) {
                return jSONObject.getString(f.a.d);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public String d(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String strAh = ah(str, "");
            if (TextUtils.isEmpty(strAh)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(strAh);
            if (System.currentTimeMillis() - jSONObject.getLong("time") <= j) {
                return jSONObject.getString(f.a.d);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public void d(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(f.a.d, str2);
            jSONObject.put("time", System.currentTimeMillis());
            jSONObject.put("p_version", 6923);
            xr(str, jSONObject.toString());
        } catch (JSONException e) {
            sl.ms(e);
        }
    }

    public void re() {
        try {
            SharedPreferences.Editor editorEdit = xr().edit();
            editorEdit.clear();
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }

    public static class xr {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private Map<String, Object> f1972ms = new HashMap();

        public xr ms(String str) {
            if (str == null || str.equals(d.ms().f1970ms)) {
                return this;
            }
            d.ms().f1970ms = str;
            this.f1972ms.put("dev01", str);
            return this;
        }

        public xr xr(String str) {
            if (str == null || str.equals(d.ms().xr)) {
                return this;
            }
            d.ms().xr = str;
            this.f1972ms.put("dev02", com.bytedance.sdk.component.utils.ms.xr(str));
            return this;
        }

        public xr ah(String str) {
            if (str == null || str.equals(d.ms().ah)) {
                return this;
            }
            d.ms().ah = str;
            this.f1972ms.put("dev04", str);
            return this;
        }

        public xr d(String str) {
            if (str == null || str.equals(d.ms().d)) {
                return this;
            }
            d.ms().d = str;
            this.f1972ms.put("dev05", str);
            return this;
        }

        public xr ka(String str) {
            if (str == null || str.equals(d.ms().ch)) {
                return this;
            }
            d.ms().ch = str;
            this.f1972ms.put("dev11", str);
            return this;
        }

        public xr c(String str) {
            if (str == null || str.equals(d.ms().ka)) {
                return this;
            }
            d.ms().ka = str;
            this.f1972ms.put("dev07", str);
            return this;
        }

        public xr ab(String str) {
            if (str == null || str.equals(d.ms().c)) {
                return this;
            }
            d.ms().c = str;
            this.f1972ms.put("dev08", str);
            return this;
        }

        public xr x(String str) {
            if (str == null || str.equals(d.ms().ab)) {
                return this;
            }
            d.ms().ab = str;
            this.f1972ms.put("dev17", str);
            return this;
        }

        public xr ny(String str) {
            if (str == null || str.equals(d.ms().x)) {
                return this;
            }
            d.ms().x = str;
            this.f1972ms.put("dev18", str);
            return this;
        }

        public xr ch(String str) {
            if (str == null || str.equals(d.ms().ny)) {
                return this;
            }
            d.ms().ny = str;
            this.f1972ms.put("dev09", str);
            return this;
        }

        public void ms() {
            try {
                if (ah.ms().xr()) {
                    for (Map.Entry<String, Object> entry : this.f1972ms.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (value instanceof Boolean) {
                            com.bytedance.sdk.component.ab.ah.ms.xr.ms("sp_exec_getad_config", key, (Boolean) value);
                        } else if (value instanceof Long) {
                            com.bytedance.sdk.component.ab.ah.ms.xr.ms("sp_exec_getad_config", key, (Long) value);
                        } else if (value instanceof Float) {
                            com.bytedance.sdk.component.ab.ah.ms.xr.ms("sp_exec_getad_config", key, (Float) value);
                        } else if (value instanceof Integer) {
                            com.bytedance.sdk.component.ab.ah.ms.xr.ms("sp_exec_getad_config", key, (Integer) value);
                        } else if (value instanceof String) {
                            com.bytedance.sdk.component.ab.ah.ms.xr.ms("sp_exec_getad_config", key, (String) value);
                        }
                    }
                    return;
                }
                SharedPreferences.Editor editorEdit = d.ms().xr().edit();
                for (Map.Entry<String, Object> entry2 : this.f1972ms.entrySet()) {
                    String key2 = entry2.getKey();
                    Object value2 = entry2.getValue();
                    if (value2 instanceof Boolean) {
                        editorEdit.putBoolean(key2, ((Boolean) value2).booleanValue());
                    } else if (value2 instanceof Long) {
                        editorEdit.putLong(key2, ((Long) value2).longValue());
                    } else if (value2 instanceof Float) {
                        editorEdit.putFloat(key2, ((Float) value2).floatValue());
                    } else if (value2 instanceof Integer) {
                        editorEdit.putInt(key2, ((Integer) value2).intValue());
                    } else if (value2 instanceof String) {
                        editorEdit.putString(key2, (String) value2);
                    }
                }
                editorEdit.apply();
            } catch (Exception e) {
                sl.ms(e);
            }
        }
    }
}
