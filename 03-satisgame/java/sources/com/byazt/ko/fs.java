package com.byazt.ko;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2319, 101})
public class fs {
    public final SharedPreferences l;
    public final Context n;
    public final SharedPreferences q;
    public final com.byazt.wv.x qg;
    public final SharedPreferences s;
    public volatile JSONObject w;
    public volatile JSONObject x;

    public static String n() {
        return "embed_applog_stats";
    }

    public String hu() {
        return null;
    }

    public boolean n(ArrayList<com.byazt.yi.n> arrayList) {
        return true;
    }

    public fs(Context context, com.byazt.wv.x xVar) {
        this.n = context;
        this.qg = xVar;
        this.l = com.byazt.qyu.qg.qg(context, "embed_applog_stats", 0);
        this.s = com.byazt.qyu.qg.qg(context, "embed_header_custom", 0);
        this.q = com.byazt.qyu.qg.qg(context, "embed_last_sp_session", 0);
    }

    public String qg() {
        return this.qg.x();
    }

    public String s() {
        return this.q.getString("session_last_day", "");
    }

    public void n(String str, int i) {
        this.q.edit().putString("session_last_day", str).putInt("session_order", i).apply();
    }

    public int q() {
        return this.q.getInt("session_order", 0);
    }

    public SharedPreferences l() {
        return this.l;
    }

    public boolean w() {
        return this.qg.qg();
    }

    public JSONObject x() {
        return this.x;
    }

    public void n(JSONObject jSONObject) {
        if (com.byazt.km.cp.qg) {
            com.byazt.km.cp.n("setConfig, " + jSONObject.toString(), null);
        }
        this.x = jSONObject;
        long jCurrentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor editorEdit = this.l.edit();
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
        com.byazt.km.cp.n = zOptBoolean;
        if (jSONObject.optBoolean("bav_ab_config", false)) {
            editorEdit.putBoolean("bav_ab_config", true);
        } else {
            editorEdit.remove("bav_ab_config");
        }
        int iOptInt2 = jSONObject.optInt("bav_monitor_rate", 0);
        if (iOptInt2 > 0 && iOptInt2 <= 100) {
            editorEdit.putInt("bav_monitor_rate", iOptInt2);
            com.byazt.km.fs.n(true);
        } else {
            editorEdit.remove("bav_monitor_rate");
            com.byazt.km.fs.n(false);
        }
        editorEdit.putLong("app_log_last_config_time", jCurrentTimeMillis);
        editorEdit.apply();
    }

    public long fs() {
        return this.l.getLong("app_log_last_config_time", 0L);
    }

    public int rv() {
        return this.l.getInt("bav_monitor_rate", 0);
    }

    public String tj() {
        return this.qg.s();
    }

    public String cp() {
        return this.qg.q();
    }

    public String d() {
        return this.qg.l();
    }

    public String oa() {
        return this.qg.w();
    }

    public void qg(JSONObject jSONObject) {
        this.s.edit().putString("header_custom_info", jSONObject != null ? jSONObject.toString() : "").apply();
    }

    public String sz() {
        return this.s.getString("header_custom_info", null);
    }

    public String k() {
        return this.s.getString("ab_sdk_version", "");
    }

    public String cy() {
        return this.s.getString("user_unique_id", null);
    }

    public boolean hd() {
        if (this.qg.fs() == 0) {
            String strN = com.byazt.km.sz.n(this.n);
            if (!TextUtils.isEmpty(strN)) {
                this.qg.n(strN.contains(":") ? 2 : 1);
            } else {
                this.qg.n(0);
            }
        }
        return this.qg.fs() == 1;
    }

    public long cd() {
        return this.l.getLong("abtest_fetch_interval", 0L);
    }

    public void s(JSONObject jSONObject) {
        com.byazt.km.cp.n("setAbConfig, " + jSONObject.toString(), null);
        this.s.edit().putString("ab_configure", jSONObject.toString()).apply();
        this.w = null;
    }

    public String um() {
        if (!TextUtils.isEmpty(this.qg.um())) {
            return this.qg.um();
        }
        return this.s.getString("ab_version", null);
    }

    public JSONObject a() {
        JSONObject jSONObject = this.w;
        if (jSONObject == null) {
            synchronized (this) {
                try {
                    if (py()) {
                        jSONObject = new JSONObject(this.s.getString("ab_configure", ""));
                    }
                } catch (JSONException unused) {
                }
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                this.w = jSONObject;
            }
        }
        return jSONObject;
    }

    public boolean py() {
        return this.l.getBoolean("bav_ab_config", false);
    }

    public boolean ou() {
        return this.l.getBoolean("bav_log_collect", false);
    }

    public long wm() {
        return this.l.getLong("session_interval", 30000L);
    }

    public long m() {
        return this.l.getLong("batch_event_interval", 30000L);
    }

    public String h() {
        return this.qg.n();
    }

    public String t() {
        return this.l.getString("user_agent", null);
    }

    public String ur() {
        return this.qg.cp();
    }

    public int bb() {
        return this.qg.sz();
    }

    public int ln() {
        return this.qg.k();
    }

    public int lh() {
        return this.qg.cy();
    }

    public String v() {
        return this.qg.d();
    }

    public String j() {
        return this.qg.oa();
    }

    public String an() {
        return this.qg.cd();
    }

    public String ae() {
        return this.qg.a();
    }

    public String f() {
        return this.qg.py();
    }

    public String fi() {
        return this.qg.ou();
    }

    public String df() {
        return this.qg.ln() == null ? "" : this.qg.ln();
    }

    public String oj() {
        return this.qg.lh() == null ? "" : this.qg.lh();
    }

    public boolean dg() {
        return this.qg.hu();
    }

    public boolean u() {
        return this.qg.h();
    }

    public String pk() {
        return this.qg.bb();
    }

    public com.byazt.wv.x wo() {
        return this.qg;
    }

    public CharSequence sh() {
        return this.qg.wm();
    }
}
