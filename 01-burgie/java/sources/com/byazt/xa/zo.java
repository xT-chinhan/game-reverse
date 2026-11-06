package com.byazt.xa;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CODEC_STOP_TIMEOUT, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo {
    public final SharedPreferences c;
    public volatile JSONObject fw;
    public final SharedPreferences hn;
    public final com.byazt.zrg.fw hw;
    public final Context pr;
    public volatile JSONObject uc;
    public final SharedPreferences x;

    public zo(Context context, com.byazt.zrg.fw fwVar) {
        this.pr = context;
        this.hw = fwVar;
        this.c = com.byazt.mg.hw.hw(context, "embed_applog_stats", 0);
        this.hn = com.byazt.mg.hw.hw(context, "embed_header_custom", 0);
        this.x = com.byazt.mg.hw.hw(context, "embed_last_sp_session", 0);
    }

    public static String pr() {
        return "embed_applog_stats";
    }

    public String hw() {
        return this.hw.fw();
    }

    public String hn() {
        return this.x.getString("session_last_day", "");
    }

    public void pr(String str, int i) {
        this.x.edit().putString("session_last_day", str).putInt("session_order", i).apply();
    }

    public int x() {
        return this.x.getInt("session_order", 0);
    }

    public SharedPreferences c() {
        return this.c;
    }

    public boolean uc() {
        return this.hw.hw();
    }

    public JSONObject fw() {
        return this.fw;
    }

    public void pr(JSONObject jSONObject) {
        if (com.byazt.ec.w.hw) {
            com.byazt.ec.w.pr("setConfig, " + jSONObject.toString(), null);
        }
        this.fw = jSONObject;
        long jCurrentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor editorEdit = this.c.edit();
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
        com.byazt.ec.w.pr = zOptBoolean;
        if (jSONObject.optBoolean("bav_ab_config", false)) {
            editorEdit.putBoolean("bav_ab_config", true);
        } else {
            editorEdit.remove("bav_ab_config");
        }
        int iOptInt2 = jSONObject.optInt("bav_monitor_rate", 0);
        if (iOptInt2 > 0 && iOptInt2 <= 100) {
            editorEdit.putInt("bav_monitor_rate", iOptInt2);
            com.byazt.ec.zo.pr(true);
        } else {
            editorEdit.remove("bav_monitor_rate");
            com.byazt.ec.zo.pr(false);
        }
        editorEdit.putLong("app_log_last_config_time", jCurrentTimeMillis);
        editorEdit.apply();
    }

    public long zo() {
        return this.c.getLong("app_log_last_config_time", 0L);
    }

    public int aj() {
        return this.c.getInt("bav_monitor_rate", 0);
    }

    public String vk() {
        return this.hw.hn();
    }

    public String w() {
        return this.hw.x();
    }

    public String k() {
        return this.hw.c();
    }

    public String m() {
        return this.hw.uc();
    }

    public void hw(JSONObject jSONObject) {
        this.hn.edit().putString("header_custom_info", jSONObject != null ? jSONObject.toString() : "").apply();
    }

    public String g() {
        return this.hn.getString("header_custom_info", null);
    }

    public String ho() {
        return this.hn.getString("ab_sdk_version", "");
    }

    public String nt() {
        return this.hn.getString("user_unique_id", null);
    }

    public boolean yb() {
        if (this.hw.zo() == 0) {
            String strPr = com.byazt.ec.g.pr(this.pr);
            if (!TextUtils.isEmpty(strPr)) {
                this.hw.pr(strPr.contains(":") ? 2 : 1);
            } else {
                this.hw.pr(0);
            }
        }
        return this.hw.zo() == 1;
    }

    public long lb() {
        return this.c.getLong("abtest_fetch_interval", 0L);
    }

    public void hn(JSONObject jSONObject) {
        com.byazt.ec.w.pr("setAbConfig, " + jSONObject.toString(), null);
        this.hn.edit().putString("ab_configure", jSONObject.toString()).apply();
        this.uc = null;
    }

    public String qa() {
        if (!TextUtils.isEmpty(this.hw.qa())) {
            return this.hw.qa();
        }
        return this.hn.getString("ab_version", null);
    }

    public JSONObject a() {
        JSONObject jSONObject = this.uc;
        if (jSONObject == null) {
            synchronized (this) {
                try {
                    if (cz()) {
                        jSONObject = new JSONObject(this.hn.getString("ab_configure", ""));
                    }
                } catch (JSONException e) {
                }
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                this.uc = jSONObject;
            }
        }
        return jSONObject;
    }

    public boolean cz() {
        return this.c.getBoolean("bav_ab_config", false);
    }

    public boolean ny() {
        return this.c.getBoolean("bav_log_collect", false);
    }

    public long fo() {
        return this.c.getLong("session_interval", 30000L);
    }

    public long rc() {
        return this.c.getLong("batch_event_interval", 30000L);
    }

    public String z() {
        return null;
    }

    public String b() {
        return this.hw.pr();
    }

    public String iu() {
        return this.c.getString("user_agent", null);
    }

    public boolean pr(ArrayList<com.byazt.kg.pr> arrayList) {
        return true;
    }

    public String ve() {
        return this.hw.w();
    }

    public int gz() {
        return this.hw.g();
    }

    public int nl() {
        return this.hw.ho();
    }

    public int y() {
        return this.hw.nt();
    }

    public String ww() {
        return this.hw.k();
    }

    public String n() {
        return this.hw.m();
    }

    public String e() {
        return this.hw.lb();
    }

    public String s() {
        return this.hw.a();
    }

    public String ls() {
        return this.hw.cz();
    }

    public String er() {
        return this.hw.ny();
    }

    public String v() {
        return this.hw.gz() == null ? "" : this.hw.gz();
    }

    public String qi() {
        return this.hw.nl() == null ? "" : this.hw.nl();
    }

    public boolean qn() {
        return this.hw.z();
    }

    public boolean of() {
        return this.hw.b();
    }

    public String ii() {
        return this.hw.ve();
    }

    public com.byazt.zrg.fw i() {
        return this.hw;
    }

    public CharSequence r() {
        return this.hw.fo();
    }
}
