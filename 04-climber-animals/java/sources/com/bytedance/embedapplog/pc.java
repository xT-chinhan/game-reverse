package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class pc {
    private volatile JSONObject ab;
    private final SharedPreferences ah;
    private volatile JSONObject c;
    private final SharedPreferences d;
    private final SharedPreferences ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Context f513ms;
    private final x xr;

    public boolean ms(ArrayList<tz> arrayList) {
        return true;
    }

    String w() {
        return null;
    }

    public pc(Context context, x xVar) {
        this.f513ms = context;
        this.xr = xVar;
        this.ka = com.bytedance.sdk.openadsdk.api.plugin.xr.xr(context, "embed_applog_stats", 0);
        this.ah = com.bytedance.sdk.openadsdk.api.plugin.xr.xr(context, "embed_header_custom", 0);
        this.d = com.bytedance.sdk.openadsdk.api.plugin.xr.xr(context, "embed_last_sp_session", 0);
    }

    String ms() {
        return this.xr.x();
    }

    public String xr() {
        return this.d.getString("session_last_day", "");
    }

    public void ms(String str, int i) {
        this.d.edit().putString("session_last_day", str).putInt("session_order", i).apply();
    }

    public int ah() {
        return this.d.getInt("session_order", 0);
    }

    public SharedPreferences d() {
        return this.ka;
    }

    public boolean ka() {
        return this.xr.xr();
    }

    public JSONObject c() {
        return this.ab;
    }

    public void ms(JSONObject jSONObject) {
        if (oh.xr) {
            oh.ms("setConfig, " + jSONObject.toString(), null);
        }
        this.ab = jSONObject;
        long jCurrentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor editorEdit = this.ka.edit();
        long jOptInt = jSONObject.optInt("session_interval", 0);
        if (jOptInt > 0 && jOptInt <= 604800) {
            editorEdit.putLong("session_interval", jOptInt * 1000);
        } else {
            editorEdit.remove("session_interval");
        }
        long jOptInt2 = jSONObject.optInt("batch_event_interval", 0);
        if (jOptInt2 > 0 && jOptInt2 <= 604800) {
            editorEdit.putLong("batch_event_interval", jOptInt2 * 1000);
        } else {
            editorEdit.remove("batch_event_interval");
        }
        int iOptInt = jSONObject.optInt("send_launch_timely", 0);
        if (iOptInt > 0 && iOptInt <= 604800) {
            editorEdit.putInt("send_launch_timely", iOptInt);
        } else {
            editorEdit.remove("send_launch_timely");
        }
        long jOptInt3 = jSONObject.optInt("abtest_fetch_interval", 0);
        if (jOptInt3 > 20 && jOptInt3 <= 604800) {
            editorEdit.putLong("abtest_fetch_interval", jOptInt3 * 1000);
        } else {
            editorEdit.remove("abtest_fetch_interval");
        }
        boolean zOptBoolean = jSONObject.optBoolean("bav_log_collect", true);
        if (zOptBoolean) {
            editorEdit.putBoolean("bav_log_collect", true);
        } else {
            editorEdit.remove("bav_log_collect");
        }
        oh.f511ms = zOptBoolean;
        if (jSONObject.optBoolean("bav_ab_config", false)) {
            editorEdit.putBoolean("bav_ab_config", true);
        } else {
            editorEdit.remove("bav_ab_config");
        }
        int iOptInt2 = jSONObject.optInt("bav_monitor_rate", 0);
        if (iOptInt2 > 0 && iOptInt2 <= 100) {
            editorEdit.putInt("bav_monitor_rate", iOptInt2);
            jy.ms(true);
        } else {
            editorEdit.remove("bav_monitor_rate");
            jy.ms(false);
        }
        editorEdit.putLong("app_log_last_config_time", jCurrentTimeMillis);
        editorEdit.apply();
    }

    public long ab() {
        return this.ka.getLong("app_log_last_config_time", 0L);
    }

    public int x() {
        return this.ka.getInt("bav_monitor_rate", 0);
    }

    public String ny() {
        return this.xr.ah();
    }

    String ch() {
        return this.xr.d();
    }

    String hi() {
        return this.xr.ka();
    }

    String sl() {
        return this.xr.c();
    }

    String zb() {
        return this.xr.ab();
    }

    void xr(JSONObject jSONObject) {
        this.ah.edit().putString("header_custom_info", jSONObject != null ? jSONObject.toString() : "").apply();
    }

    String u() {
        return this.ah.getString("header_custom_info", null);
    }

    String ub() {
        return this.ah.getString("ab_sdk_version", "");
    }

    String ao() {
        return this.ah.getString("user_unique_id", null);
    }

    public boolean h() {
        if (this.xr.ny() == 0) {
            String strMs = zd.ms(this.f513ms);
            if (!TextUtils.isEmpty(strMs)) {
                this.xr.ms(strMs.contains(":") ? 2 : 1);
            } else {
                this.xr.ms(0);
            }
        }
        return this.xr.ny() == 1;
    }

    public long qv() {
        return this.ka.getLong("abtest_fetch_interval", 0L);
    }

    void ah(JSONObject jSONObject) {
        oh.ms("setAbConfig, " + jSONObject.toString(), null);
        this.ah.edit().putString("ab_configure", jSONObject.toString()).apply();
        this.c = null;
    }

    public String y() {
        if (!TextUtils.isEmpty(this.xr.y())) {
            return this.xr.y();
        }
        return this.ah.getString("ab_version", null);
    }

    public JSONObject t() {
        JSONObject jSONObject = this.c;
        if (jSONObject == null) {
            synchronized (this) {
                try {
                    if (nw()) {
                        jSONObject = new JSONObject(this.ah.getString("ab_configure", ""));
                    }
                } catch (JSONException unused) {
                }
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                this.c = jSONObject;
            }
        }
        return jSONObject;
    }

    public boolean nw() {
        return this.ka.getBoolean("bav_ab_config", false);
    }

    public boolean b() {
        return this.ka.getBoolean("bav_log_collect", false);
    }

    public long re() {
        return this.ka.getLong("session_interval", 30000L);
    }

    public long i() {
        return this.ka.getLong("batch_event_interval", 30000L);
    }

    String yu() {
        return this.xr.ms();
    }

    String op() {
        return this.ka.getString("user_agent", null);
    }

    public String le() {
        return this.xr.sl();
    }

    public int cv() {
        return this.xr.ub();
    }

    public int g() {
        return this.xr.ao();
    }

    public int of() {
        return this.xr.h();
    }

    public String p() {
        return this.xr.zb();
    }

    public String pc() {
        return this.xr.u();
    }

    public String jw() {
        return this.xr.qv();
    }

    public String f() {
        return this.xr.t();
    }

    public String ul() {
        return this.xr.nw();
    }

    public String az() {
        return this.xr.b();
    }

    public String m() {
        return this.xr.le() == null ? "" : this.xr.le();
    }

    public String lm() {
        return this.xr.cv() == null ? "" : this.xr.cv();
    }

    public boolean e() {
        return this.xr.i();
    }

    public boolean k() {
        return this.xr.w();
    }

    public String eg() {
        return this.xr.op();
    }

    public x fm() {
        return this.xr;
    }

    public CharSequence xn() {
        return this.xr.re();
    }
}
