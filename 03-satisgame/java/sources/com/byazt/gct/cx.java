package com.byazt.gct;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 2218})
public class cx {
    public static long n = 27000;
    public static int q;
    public static int qg;
    public static int s;
    public double a;
    public int an;
    public boolean bb;
    public double cd;
    public double cp;
    public int cy;
    public String d;
    public boolean fs;
    public ArrayList<ry> h;
    public boolean hd;
    public boolean hu;
    public int j;
    public int k;
    public String l;
    public boolean lh;
    public int ln;
    public boolean m;
    public int oa;
    public int ou;
    public int py;
    public double rv;
    public int sz;
    public lq t;
    public boolean tj;
    public boolean um;
    public boolean ur;
    public float v;
    public int w;
    public int wm;
    public boolean x;

    public cx(JSONObject jSONObject) {
        this.wm = 0;
        this.m = false;
        this.hu = false;
        this.h = new ArrayList<>();
        this.v = 1.0f;
        this.an = 0;
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("reward");
        if (jSONObjectOptJSONObject != null) {
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("retain_dialog_config");
            if (jSONArrayOptJSONArray != null) {
                this.h = new ArrayList<>();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject2 != null) {
                        this.h.add(new ry(jSONObjectOptJSONObject2));
                    }
                }
            }
            this.t = new lq(jSONObjectOptJSONObject);
            this.bb = jSONObjectOptJSONObject.optBoolean("endcard_transform_enabled", false);
            this.an = jSONObjectOptJSONObject.optInt("video_no_play_start", 0);
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("reward_data");
        if (jSONObjectOptJSONObject3 != null) {
            this.w = jSONObjectOptJSONObject3.optInt("reward_amount", 0);
            this.l = jSONObjectOptJSONObject3.optString("reward_name", "");
            this.x = jSONObjectOptJSONObject3.optBoolean("reward_info_show", false);
            this.sz = jSONObjectOptJSONObject3.optInt("reward_back_type", 0);
            this.k = jSONObjectOptJSONObject3.optInt("reward_backup_timing", 0);
            this.cy = jSONObjectOptJSONObject3.optInt("reward_backup_duration", Integer.MAX_VALUE);
            this.ln = jSONObjectOptJSONObject3.optInt("reward_is_callback", 0);
            this.lh = jSONObjectOptJSONObject3.optBoolean("reward_need_click", false);
            this.v = (float) jSONObjectOptJSONObject3.optDouble("reward_speed_time", 1.0d);
            JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject3.optJSONObject("reward_advanced_config");
            if (jSONObjectOptJSONObject4 != null) {
                JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject4.optJSONObject("easy_playable");
                if (jSONObjectOptJSONObject5 != null) {
                    this.fs = jSONObjectOptJSONObject5.optBoolean("enable");
                    double dOptDouble = jSONObjectOptJSONObject5.optDouble("propose_reward", 0.0d);
                    this.rv = dOptDouble;
                    if (dOptDouble < 0.0d) {
                        this.rv = 0.0d;
                    }
                }
                JSONObject jSONObjectOptJSONObject6 = jSONObjectOptJSONObject4.optJSONObject("play_complete");
                if (jSONObjectOptJSONObject6 != null) {
                    this.tj = jSONObjectOptJSONObject6.optBoolean("enable");
                    double dOptDouble2 = jSONObjectOptJSONObject6.optDouble("propose_reward", 0.0d);
                    this.cp = dOptDouble2;
                    if (dOptDouble2 < 0.0d) {
                        this.cp = 0.0d;
                    }
                    this.d = jSONObjectOptJSONObject6.optString("tip_toast");
                    this.oa = jSONObjectOptJSONObject6.optInt("min_duration");
                }
                JSONObject jSONObjectOptJSONObject7 = jSONObjectOptJSONObject4.optJSONObject("playable_interactive");
                if (jSONObjectOptJSONObject7 != null) {
                    this.hd = jSONObjectOptJSONObject7.optBoolean("enable");
                    this.cd = jSONObjectOptJSONObject7.optDouble("propose_reward", 0.0d);
                }
                JSONObject jSONObjectOptJSONObject8 = jSONObjectOptJSONObject4.optJSONObject("click_landing");
                if (jSONObjectOptJSONObject8 != null) {
                    this.um = jSONObjectOptJSONObject8.optBoolean("enable");
                    this.a = jSONObjectOptJSONObject8.optDouble("propose_reward", 0.0d);
                    this.py = jSONObjectOptJSONObject8.optInt("landing_view_time", 5);
                }
            }
        }
        this.ou = jSONObject.optInt("reward_full_play_time", 30);
        this.wm = jSONObject.optInt("reward_full_time_type", 0);
        this.ur = jSONObject.optBoolean("interstitial_bg_transparent", false);
        this.j = jSONObject.optInt("template_sign", 0);
        this.m = jSONObject.optBoolean("__is_use_local_time", false);
        this.hu = jSONObject.optBoolean("__is_click_landing_reward", false);
    }

    public static void n(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
        if (jSONObjectOptJSONObject != null) {
            try {
                n = jSONObjectOptJSONObject.optLong("reward_time_limited", 27000L);
                qg = jSONObjectOptJSONObject.optInt("reward_force_close_max_count", 0);
                s = jSONObjectOptJSONObject.optInt("reward_local_countdown_close_style", 0);
                q = jSONObjectOptJSONObject.optInt("native_countdown_limit_max", 0);
            } catch (Exception unused) {
            }
        }
    }

    public static void n(com.byazt.gwu.l lVar) {
        lVar.n("reward_time_limited", n);
        lVar.n("reward_force_close_max_count", qg);
        lVar.n("reward_local_countdown_close_style", s);
        lVar.n("native_countdown_limit_max", q);
    }

    public static void qg(com.byazt.gwu.l lVar) {
        n = lVar.qg("reward_time_limited", 27000L);
        qg = lVar.qg("reward_force_close_max_count", 0);
        s = lVar.qg("reward_local_countdown_close_style", 0);
        q = lVar.qg("native_countdown_limit_max", 0);
    }

    public void qg(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            ArrayList<ry> arrayList = this.h;
            if (arrayList != null && arrayList.size() != 0) {
                Iterator<ry> it = this.h.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().n());
                }
            }
            jSONObject2.put("retain_dialog_config", jSONArray);
            lq lqVar = this.t;
            if (lqVar != null) {
                lqVar.n(jSONObject2);
            }
            jSONObject2.put("endcard_transform_enabled", this.bb);
            jSONObject2.put("video_no_play_start", this.an);
            jSONObject.put("reward", jSONObject2);
        } catch (JSONException unused) {
        }
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("reward_name", this.l);
            jSONObject3.put("reward_amount", this.w);
            jSONObject3.put("reward_info_show", this.x);
            jSONObject3.put("reward_back_type", this.sz);
            jSONObject3.put("reward_backup_timing", this.k);
            jSONObject3.put("reward_backup_duration", this.cy);
            jSONObject3.put("reward_is_callback", this.ln);
            jSONObject3.put("reward_need_click", this.lh);
            jSONObject3.put("reward_speed_time", this.v);
            JSONObject jSONObject4 = new JSONObject();
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("enable", this.fs);
            jSONObject5.put("propose_reward", this.rv);
            jSONObject4.put("easy_playable", jSONObject5);
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("enable", this.tj);
            jSONObject6.put("propose_reward", this.cp);
            jSONObject6.put("tip_toast", this.d);
            jSONObject6.put("min_duration", this.oa);
            jSONObject4.put("play_complete", jSONObject6);
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("enable", this.hd);
            jSONObject7.put("propose_reward", this.cd);
            jSONObject4.put("playable_interactive", jSONObject7);
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("enable", this.um);
            jSONObject8.put("propose_reward", this.a);
            jSONObject8.put("landing_view_time", this.py);
            jSONObject4.put("click_landing", jSONObject8);
            jSONObject3.put("reward_advanced_config", jSONObject4);
            jSONObject.put("reward_data", jSONObject3);
        } catch (JSONException unused2) {
        }
        try {
            jSONObject.put("reward_full_play_time", this.ou);
            jSONObject.put("reward_full_time_type", this.wm);
            jSONObject.put("interstitial_bg_transparent", this.ur);
            jSONObject.put("template_sign", this.j);
            jSONObject.put("__is_use_local_time", this.m);
            jSONObject.put("__is_click_landing_reward", this.hu);
        } catch (JSONException unused3) {
        }
    }

    private static cx bb(pk pkVar) {
        if (pkVar == null) {
            return null;
        }
        return pkVar.sq();
    }

    public static String n(pk pkVar) {
        cx cxVarBb = bb(pkVar);
        return cxVarBb == null ? "" : cxVarBb.l;
    }

    public static int qg(pk pkVar) {
        cx cxVarBb = bb(pkVar);
        if (cxVarBb == null) {
            return 0;
        }
        return cxVarBb.w;
    }

    public static boolean s(pk pkVar) {
        cx cxVarBb = bb(pkVar);
        if (cxVarBb == null) {
            return false;
        }
        return cxVarBb.x;
    }

    public static long n() {
        return n;
    }

    public static long qg() {
        return qg;
    }

    public static boolean s() {
        return s == 1;
    }

    public static boolean q() {
        return q == 1;
    }

    public static boolean q(pk pkVar) {
        cx cxVarBb = bb(pkVar);
        return cxVarBb != null && cxVarBb.sz == 1;
    }

    public static boolean l(pk pkVar) {
        cx cxVarBb = bb(pkVar);
        if (cxVarBb == null) {
            return false;
        }
        return cxVarBb.fs;
    }

    public static double w(pk pkVar) {
        cx cxVarBb = bb(pkVar);
        if (cxVarBb == null) {
            return 0.0d;
        }
        return cxVarBb.rv;
    }

    public static boolean x(pk pkVar) {
        cx cxVarBb = bb(pkVar);
        if (cxVarBb == null) {
            return false;
        }
        return cxVarBb.tj;
    }

    public static double fs(pk pkVar) {
        cx cxVarBb = bb(pkVar);
        if (cxVarBb == null) {
            return 0.0d;
        }
        return cxVarBb.cp;
    }

    public static String rv(pk pkVar) {
        cx cxVarBb = bb(pkVar);
        if (cxVarBb == null) {
            return "";
        }
        return TextUtils.isEmpty(cxVarBb.d) ? "别急着跳过，继续观看完整视频，可获得更多额外奖励～" : cxVarBb.d;
    }

    public static int tj(pk pkVar) {
        cx cxVarBb = bb(pkVar);
        if (cxVarBb == null) {
            return 30000;
        }
        int iMax = Math.max(cxVarBb.oa, 30);
        return (iMax <= 60 ? iMax : 30) * 1000;
    }

    public static boolean cp(pk pkVar) {
        cx cxVarBb = bb(pkVar);
        if (cxVarBb == null) {
            return false;
        }
        return cxVarBb.hd;
    }

    public static double d(pk pkVar) {
        cx cxVarBb = bb(pkVar);
        if (cxVarBb == null) {
            return 0.0d;
        }
        return cxVarBb.cd;
    }

    public static boolean oa(pk pkVar) {
        cx cxVarBb = bb(pkVar);
        if (cxVarBb == null) {
            return false;
        }
        return cxVarBb.um;
    }

    public static int sz(pk pkVar) {
        cx cxVarBb = bb(pkVar);
        if (cxVarBb == null) {
            return 5;
        }
        return Math.max(5, cxVarBb.py);
    }

    public static float n(pk pkVar, int i) {
        double dW;
        if (i == 0) {
            return 1.0f;
        }
        if (i == 1) {
            dW = w(pkVar);
        } else if (i == 2) {
            dW = fs(pkVar);
        } else {
            if (i != 3) {
                return 0.0f;
            }
            dW = d(pkVar);
        }
        return (float) dW;
    }

    public static int k(pk pkVar) {
        int i;
        cx cxVarBb = bb(pkVar);
        if (cxVarBb != null && (i = cxVarBb.ou) >= 10 && i <= 60) {
            return i;
        }
        return 30;
    }

    public static int cy(pk pkVar) {
        cx cxVarBb = bb(pkVar);
        if (cxVarBb == null) {
            return 0;
        }
        return cxVarBb.wm;
    }

    public static boolean hd(pk pkVar) {
        cx cxVarBb = bb(pkVar);
        if (cxVarBb != null && cxVarBb.m) {
            return cd.q(pkVar) || cy(pkVar) == 1 || cy(pkVar) == 2;
        }
        return false;
    }

    public static boolean cd(pk pkVar) {
        cx cxVarBb = bb(pkVar);
        return cxVarBb != null && cxVarBb.m && cy(pkVar) == 1;
    }

    public static boolean um(pk pkVar) {
        cx cxVarBb = bb(pkVar);
        if (cxVarBb != null && cxVarBb.hu) {
            return oa(pkVar);
        }
        return false;
    }

    public static void n(pk pkVar, boolean z) {
        cx cxVarBb = bb(pkVar);
        if (cxVarBb != null) {
            cxVarBb.m = z;
        }
    }

    public static void qg(pk pkVar, boolean z) {
        cx cxVarBb = bb(pkVar);
        if (cxVarBb != null) {
            cxVarBb.hu = z;
        }
    }

    public static ArrayList<ry> a(pk pkVar) {
        cx cxVarBb = bb(pkVar);
        if (cxVarBb != null) {
            return cxVarBb.h;
        }
        return new ArrayList<>();
    }

    public static boolean py(pk pkVar) {
        cx cxVarBb = bb(pkVar);
        return cxVarBb != null && cxVarBb.k == 1;
    }

    public static int qg(pk pkVar, int i) {
        int i2;
        cx cxVarBb = bb(pkVar);
        return (cxVarBb != null && (i2 = cxVarBb.cy) > 0) ? Math.min(i, i2) : i;
    }

    public static lq ou(pk pkVar) {
        cx cxVarBb = bb(pkVar);
        if (cxVarBb != null) {
            return cxVarBb.t;
        }
        return null;
    }

    public static boolean wm(pk pkVar) {
        cx cxVarBb = bb(pkVar);
        if (cxVarBb != null) {
            return cxVarBb.ur;
        }
        return false;
    }

    public static boolean m(pk pkVar) {
        cx cxVarBb = bb(pkVar);
        if (cxVarBb == null) {
            return false;
        }
        return cxVarBb.bb;
    }

    public static boolean s(pk pkVar, boolean z) {
        cx cxVarBb = bb(pkVar);
        return (cxVarBb != null && z && cxVarBb.an == 1) ? false : true;
    }

    public static boolean hu(pk pkVar) {
        cx cxVarBb = bb(pkVar);
        return cxVarBb != null && cxVarBb.ln == 1;
    }

    public static float h(pk pkVar) {
        cx cxVarBb = bb(pkVar);
        if (cxVarBb == null) {
            return 1.0f;
        }
        return cxVarBb.v;
    }

    public static boolean t(pk pkVar) {
        cx cxVarBb = bb(pkVar);
        if (cxVarBb == null) {
            return false;
        }
        return cxVarBb.lh;
    }

    public static int ur(pk pkVar) {
        cx cxVarBb = bb(pkVar);
        if (cxVarBb == null) {
            return 0;
        }
        return cxVarBb.j;
    }
}
