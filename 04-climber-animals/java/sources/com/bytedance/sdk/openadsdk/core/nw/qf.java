package com.bytedance.sdk.openadsdk.core.nw;

import android.text.TextUtils;
import com.tapsdk.tapad.constants.Constants;
import com.umeng.analytics.pro.cl;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class qf {
    private static int ah = 0;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static long f3086ms = 27000;
    private static int xr = 5;
    private boolean ab;
    private boolean ao;
    private int b;
    private boolean c;
    private double ch;
    private int cv;
    private String d;
    private boolean g;
    private double h;
    private String hi;
    private boolean i;
    private int ka;
    private boolean le;
    private int nw;
    private boolean ny;
    private int of;
    private boolean op;
    private boolean qv;
    private boolean re;
    private int sl;
    private int t;
    private int u;
    private int ub;
    private ArrayList<gy> w;
    private double x;
    private double y;
    private l yu;
    private int zb;

    public qf(JSONObject jSONObject) {
        this.b = 0;
        this.re = false;
        this.i = false;
        this.w = new ArrayList<>();
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(Constants.AdTypeName.REWARD);
        if (jSONObjectOptJSONObject != null) {
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("retain_dialog_config");
            if (jSONArrayOptJSONArray != null) {
                this.w = new ArrayList<>();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject2 != null) {
                        this.w.add(new gy(jSONObjectOptJSONObject2));
                    }
                }
            }
            this.yu = new l(jSONObjectOptJSONObject);
            this.le = jSONObjectOptJSONObject.optBoolean("endcard_transform_enabled", false);
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("reward_data");
        if (jSONObjectOptJSONObject3 != null) {
            this.ka = jSONObjectOptJSONObject3.optInt("reward_amount", 0);
            this.d = jSONObjectOptJSONObject3.optString("reward_name", "");
            this.c = jSONObjectOptJSONObject3.optBoolean("reward_info_show", false);
            this.zb = jSONObjectOptJSONObject3.optInt("reward_back_type", 0);
            this.u = jSONObjectOptJSONObject3.optInt("reward_backup_timing", 0);
            this.ub = jSONObjectOptJSONObject3.optInt("reward_backup_duration", Integer.MAX_VALUE);
            this.cv = jSONObjectOptJSONObject3.optInt("reward_is_callback", 0);
            this.g = jSONObjectOptJSONObject3.optBoolean("reward_need_click", false);
            JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject3.optJSONObject("reward_advanced_config");
            if (jSONObjectOptJSONObject4 != null) {
                JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject4.optJSONObject("easy_playable");
                if (jSONObjectOptJSONObject5 != null) {
                    this.ab = jSONObjectOptJSONObject5.optBoolean(cl.q);
                    double dOptDouble = jSONObjectOptJSONObject5.optDouble("propose_reward", 0.0d);
                    this.x = dOptDouble;
                    if (dOptDouble < 0.0d) {
                        this.x = 0.0d;
                    }
                }
                JSONObject jSONObjectOptJSONObject6 = jSONObjectOptJSONObject4.optJSONObject("play_complete");
                if (jSONObjectOptJSONObject6 != null) {
                    this.ny = jSONObjectOptJSONObject6.optBoolean(cl.q);
                    double dOptDouble2 = jSONObjectOptJSONObject6.optDouble("propose_reward", 0.0d);
                    this.ch = dOptDouble2;
                    if (dOptDouble2 < 0.0d) {
                        this.ch = 0.0d;
                    }
                    this.hi = jSONObjectOptJSONObject6.optString("tip_toast");
                    this.sl = jSONObjectOptJSONObject6.optInt("min_duration");
                }
                JSONObject jSONObjectOptJSONObject7 = jSONObjectOptJSONObject4.optJSONObject("playable_interactive");
                if (jSONObjectOptJSONObject7 != null) {
                    this.ao = jSONObjectOptJSONObject7.optBoolean(cl.q);
                    this.h = jSONObjectOptJSONObject7.optDouble("propose_reward", 0.0d);
                }
                JSONObject jSONObjectOptJSONObject8 = jSONObjectOptJSONObject4.optJSONObject("click_landing");
                if (jSONObjectOptJSONObject8 != null) {
                    this.qv = jSONObjectOptJSONObject8.optBoolean(cl.q);
                    this.y = jSONObjectOptJSONObject8.optDouble("propose_reward", 0.0d);
                    this.t = jSONObjectOptJSONObject8.optInt("landing_view_time", 5);
                }
            }
        }
        this.nw = jSONObject.optInt("reward_full_play_time", 30);
        this.b = jSONObject.optInt("reward_full_time_type", 0);
        this.op = jSONObject.optBoolean("interstitial_bg_transparent", false);
        this.of = jSONObject.optInt("template_sign", 0);
        this.re = jSONObject.optBoolean("__is_use_local_time", false);
        this.i = jSONObject.optBoolean("__is_click_landing_reward", false);
    }

    public static void ms(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
        if (jSONObjectOptJSONObject != null) {
            try {
                f3086ms = jSONObjectOptJSONObject.optLong("reward_time_limited", 27000L);
                xr = jSONObjectOptJSONObject.optInt("reward_force_close_max_count", 5);
                ah = jSONObjectOptJSONObject.optInt("reward_local_countdown_close_style", 0);
            } catch (Exception unused) {
            }
        }
    }

    public static void ms(com.bytedance.sdk.component.d.ms.xr xrVar) {
        xrVar.ms("reward_time_limited", f3086ms);
        xrVar.ms("reward_force_close_max_count", xr);
        xrVar.ms("reward_local_countdown_close_style", ah);
    }

    public static void xr(com.bytedance.sdk.component.d.ms.xr xrVar) {
        f3086ms = xrVar.xr("reward_time_limited", 27000L);
        xr = xrVar.xr("reward_force_close_max_count", 5);
        ah = xrVar.xr("reward_local_countdown_close_style", 0);
    }

    public void xr(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            ArrayList<gy> arrayList = this.w;
            if (arrayList != null && arrayList.size() != 0) {
                Iterator<gy> it = this.w.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().ms());
                }
            }
            jSONObject2.put("retain_dialog_config", jSONArray);
            l lVar = this.yu;
            if (lVar != null) {
                lVar.ms(jSONObject2);
            }
            jSONObject2.put("endcard_transform_enabled", this.le);
            jSONObject.put(Constants.AdTypeName.REWARD, jSONObject2);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("reward_name", this.d);
            jSONObject3.put("reward_amount", this.ka);
            jSONObject3.put("reward_info_show", this.c);
            jSONObject3.put("reward_back_type", this.zb);
            jSONObject3.put("reward_backup_timing", this.u);
            jSONObject3.put("reward_backup_duration", this.ub);
            jSONObject3.put("reward_is_callback", this.cv);
            jSONObject3.put("reward_need_click", this.g);
            JSONObject jSONObject4 = new JSONObject();
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put(cl.q, this.ab);
            jSONObject5.put("propose_reward", this.x);
            jSONObject4.put("easy_playable", jSONObject5);
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put(cl.q, this.ny);
            jSONObject6.put("propose_reward", this.ch);
            jSONObject6.put("tip_toast", this.hi);
            jSONObject6.put("min_duration", this.sl);
            jSONObject4.put("play_complete", jSONObject6);
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put(cl.q, this.ao);
            jSONObject7.put("propose_reward", this.h);
            jSONObject4.put("playable_interactive", jSONObject7);
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put(cl.q, this.qv);
            jSONObject8.put("propose_reward", this.y);
            jSONObject8.put("landing_view_time", this.t);
            jSONObject4.put("click_landing", jSONObject8);
            jSONObject3.put("reward_advanced_config", jSONObject4);
            jSONObject.put("reward_data", jSONObject3);
        } catch (JSONException e2) {
            com.bytedance.sdk.component.utils.sl.ms(e2);
        }
        try {
            jSONObject.put("reward_full_play_time", this.nw);
            jSONObject.put("reward_full_time_type", this.b);
            jSONObject.put("interstitial_bg_transparent", this.op);
            jSONObject.put("template_sign", this.of);
            jSONObject.put("__is_use_local_time", this.re);
            jSONObject.put("__is_click_landing_reward", this.i);
        } catch (JSONException e3) {
            com.bytedance.sdk.component.utils.sl.ms(e3);
        }
    }

    private static qf le(lm lmVar) {
        if (lmVar == null) {
            return null;
        }
        return lmVar.k();
    }

    public static String ms(lm lmVar) {
        qf qfVarLe = le(lmVar);
        return qfVarLe == null ? "" : qfVarLe.d;
    }

    public static int xr(lm lmVar) {
        qf qfVarLe = le(lmVar);
        if (qfVarLe == null) {
            return 0;
        }
        return qfVarLe.ka;
    }

    public static boolean ah(lm lmVar) {
        qf qfVarLe = le(lmVar);
        if (qfVarLe == null) {
            return false;
        }
        return qfVarLe.c;
    }

    public static long ms() {
        return f3086ms;
    }

    public static long xr() {
        int i = xr;
        if (i < 2) {
            return 5L;
        }
        return i;
    }

    public static boolean ah() {
        return ah == 1;
    }

    public static boolean d(lm lmVar) {
        qf qfVarLe = le(lmVar);
        return qfVarLe != null && qfVarLe.zb == 1;
    }

    public static boolean ka(lm lmVar) {
        qf qfVarLe = le(lmVar);
        if (qfVarLe == null) {
            return false;
        }
        return qfVarLe.ab;
    }

    public static double c(lm lmVar) {
        qf qfVarLe = le(lmVar);
        if (qfVarLe == null) {
            return 0.0d;
        }
        return qfVarLe.x;
    }

    public static boolean ab(lm lmVar) {
        qf qfVarLe = le(lmVar);
        if (qfVarLe == null) {
            return false;
        }
        return qfVarLe.ny;
    }

    public static double x(lm lmVar) {
        qf qfVarLe = le(lmVar);
        if (qfVarLe == null) {
            return 0.0d;
        }
        return qfVarLe.ch;
    }

    public static String ny(lm lmVar) {
        qf qfVarLe = le(lmVar);
        if (qfVarLe == null) {
            return "";
        }
        return TextUtils.isEmpty(qfVarLe.hi) ? "别急着跳过，继续观看完整视频，可获得更多额外奖励～" : qfVarLe.hi;
    }

    public static int ch(lm lmVar) {
        qf qfVarLe = le(lmVar);
        if (qfVarLe == null) {
            return 30000;
        }
        int iMax = Math.max(qfVarLe.sl, 30);
        return (iMax <= 60 ? iMax : 30) * 1000;
    }

    public static boolean hi(lm lmVar) {
        qf qfVarLe = le(lmVar);
        if (qfVarLe == null) {
            return false;
        }
        return qfVarLe.ao;
    }

    public static double sl(lm lmVar) {
        qf qfVarLe = le(lmVar);
        if (qfVarLe == null) {
            return 0.0d;
        }
        return qfVarLe.h;
    }

    public static boolean zb(lm lmVar) {
        qf qfVarLe = le(lmVar);
        if (qfVarLe == null) {
            return false;
        }
        return qfVarLe.qv;
    }

    public static int u(lm lmVar) {
        qf qfVarLe = le(lmVar);
        if (qfVarLe == null) {
            return 5;
        }
        return Math.max(5, qfVarLe.t);
    }

    public static float ms(lm lmVar, int i) {
        double dC;
        if (i == 0) {
            return 1.0f;
        }
        if (i == 1) {
            dC = c(lmVar);
        } else if (i == 2) {
            dC = x(lmVar);
        } else {
            if (i != 3) {
                return 0.0f;
            }
            dC = sl(lmVar);
        }
        return (float) dC;
    }

    public static int ub(lm lmVar) {
        int i;
        qf qfVarLe = le(lmVar);
        if (qfVarLe != null && (i = qfVarLe.nw) >= 10 && i <= 60) {
            return i;
        }
        return 30;
    }

    public static int ao(lm lmVar) {
        qf qfVarLe = le(lmVar);
        if (qfVarLe == null) {
            return 0;
        }
        return qfVarLe.b;
    }

    public static boolean h(lm lmVar) {
        qf qfVarLe = le(lmVar);
        if (qfVarLe != null && qfVarLe.re) {
            return t.d(lmVar) || ao(lmVar) == 1 || ao(lmVar) == 2;
        }
        return false;
    }

    public static boolean qv(lm lmVar) {
        qf qfVarLe = le(lmVar);
        return qfVarLe != null && qfVarLe.re && ao(lmVar) == 1;
    }

    public static boolean y(lm lmVar) {
        qf qfVarLe = le(lmVar);
        if (qfVarLe != null && qfVarLe.i) {
            return zb(lmVar);
        }
        return false;
    }

    public static void ms(lm lmVar, boolean z) {
        qf qfVarLe = le(lmVar);
        if (qfVarLe != null) {
            qfVarLe.re = z;
        }
    }

    public static void xr(lm lmVar, boolean z) {
        qf qfVarLe = le(lmVar);
        if (qfVarLe != null) {
            qfVarLe.i = z;
        }
    }

    public static ArrayList<gy> t(lm lmVar) {
        qf qfVarLe = le(lmVar);
        if (qfVarLe != null) {
            return qfVarLe.w;
        }
        return new ArrayList<>();
    }

    public static boolean nw(lm lmVar) {
        qf qfVarLe = le(lmVar);
        return qfVarLe != null && qfVarLe.u == 1;
    }

    public static int xr(lm lmVar, int i) {
        int i2;
        qf qfVarLe = le(lmVar);
        return (qfVarLe != null && (i2 = qfVarLe.ub) > 0) ? Math.min(i, i2) : i;
    }

    public static l b(lm lmVar) {
        qf qfVarLe = le(lmVar);
        if (qfVarLe != null) {
            return qfVarLe.yu;
        }
        return null;
    }

    public static boolean re(lm lmVar) {
        qf qfVarLe = le(lmVar);
        if (qfVarLe != null) {
            return qfVarLe.op;
        }
        return false;
    }

    public static boolean i(lm lmVar) {
        qf qfVarLe = le(lmVar);
        if (qfVarLe == null) {
            return false;
        }
        return qfVarLe.le;
    }

    public static boolean w(lm lmVar) {
        qf qfVarLe = le(lmVar);
        return qfVarLe != null && qfVarLe.cv == 1;
    }

    public static boolean yu(lm lmVar) {
        qf qfVarLe = le(lmVar);
        if (qfVarLe == null) {
            return false;
        }
        return qfVarLe.g;
    }

    public static int op(lm lmVar) {
        qf qfVarLe = le(lmVar);
        if (qfVarLe == null) {
            return 0;
        }
        return qfVarLe.of;
    }
}
