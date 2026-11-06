package com.byazt.hg;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 2176})
public class jn {
    public double a;
    public double aj;
    public ArrayList<pj> b;
    public String c;
    public int cz;
    public int e;
    public int fo;
    public boolean fw;
    public int g;
    public boolean gz;
    public int ho;
    public l iu;
    public String k;
    public double lb;
    public int m;
    public int n;
    public int nl;
    public int nt;
    public int ny;
    public boolean qa;
    public boolean rc;
    public int uc;
    public boolean ve;
    public boolean vk;
    public double w;
    public float ww;
    public boolean y;
    public boolean yb;
    public boolean z;
    public boolean zo;
    public static long pr = 27000;
    public static int hw = 0;
    public static int hn = 0;
    public static int x = 0;

    public jn(JSONObject jSONObject) {
        this.fo = 0;
        this.rc = false;
        this.z = false;
        this.b = new ArrayList<>();
        this.ww = 1.0f;
        this.e = 0;
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("reward");
        if (jSONObjectOptJSONObject != null) {
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("retain_dialog_config");
            if (jSONArrayOptJSONArray != null) {
                this.b = new ArrayList<>();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject2 != null) {
                        this.b.add(new pj(jSONObjectOptJSONObject2));
                    }
                }
            }
            this.iu = new l(jSONObjectOptJSONObject);
            this.gz = jSONObjectOptJSONObject.optBoolean("endcard_transform_enabled", false);
            this.e = jSONObjectOptJSONObject.optInt("video_no_play_start", 0);
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("reward_data");
        if (jSONObjectOptJSONObject3 != null) {
            this.uc = jSONObjectOptJSONObject3.optInt("reward_amount", 0);
            this.c = jSONObjectOptJSONObject3.optString("reward_name", "");
            this.fw = jSONObjectOptJSONObject3.optBoolean("reward_info_show", false);
            this.g = jSONObjectOptJSONObject3.optInt("reward_back_type", 0);
            this.ho = jSONObjectOptJSONObject3.optInt("reward_backup_timing", 0);
            this.nt = jSONObjectOptJSONObject3.optInt("reward_backup_duration", Integer.MAX_VALUE);
            this.nl = jSONObjectOptJSONObject3.optInt("reward_is_callback", 0);
            this.y = jSONObjectOptJSONObject3.optBoolean("reward_need_click", false);
            this.ww = (float) jSONObjectOptJSONObject3.optDouble("reward_speed_time", 1.0d);
            JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject3.optJSONObject("reward_advanced_config");
            if (jSONObjectOptJSONObject4 != null) {
                JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject4.optJSONObject("easy_playable");
                if (jSONObjectOptJSONObject5 != null) {
                    this.zo = jSONObjectOptJSONObject5.optBoolean("enable");
                    double dOptDouble = jSONObjectOptJSONObject5.optDouble("propose_reward", 0.0d);
                    this.aj = dOptDouble;
                    if (dOptDouble < 0.0d) {
                        this.aj = 0.0d;
                    }
                }
                JSONObject jSONObjectOptJSONObject6 = jSONObjectOptJSONObject4.optJSONObject("play_complete");
                if (jSONObjectOptJSONObject6 != null) {
                    this.vk = jSONObjectOptJSONObject6.optBoolean("enable");
                    double dOptDouble2 = jSONObjectOptJSONObject6.optDouble("propose_reward", 0.0d);
                    this.w = dOptDouble2;
                    if (dOptDouble2 < 0.0d) {
                        this.w = 0.0d;
                    }
                    this.k = jSONObjectOptJSONObject6.optString("tip_toast");
                    this.m = jSONObjectOptJSONObject6.optInt("min_duration");
                }
                JSONObject jSONObjectOptJSONObject7 = jSONObjectOptJSONObject4.optJSONObject("playable_interactive");
                if (jSONObjectOptJSONObject7 != null) {
                    this.yb = jSONObjectOptJSONObject7.optBoolean("enable");
                    this.lb = jSONObjectOptJSONObject7.optDouble("propose_reward", 0.0d);
                }
                JSONObject jSONObjectOptJSONObject8 = jSONObjectOptJSONObject4.optJSONObject("click_landing");
                if (jSONObjectOptJSONObject8 != null) {
                    this.qa = jSONObjectOptJSONObject8.optBoolean("enable");
                    this.a = jSONObjectOptJSONObject8.optDouble("propose_reward", 0.0d);
                    this.cz = jSONObjectOptJSONObject8.optInt("landing_view_time", 5);
                }
            }
        }
        this.ny = jSONObject.optInt("reward_full_play_time", 30);
        this.fo = jSONObject.optInt("reward_full_time_type", 0);
        this.ve = jSONObject.optBoolean("interstitial_bg_transparent", false);
        this.n = jSONObject.optInt("template_sign", 0);
        this.rc = jSONObject.optBoolean("__is_use_local_time", false);
        this.z = jSONObject.optBoolean("__is_click_landing_reward", false);
    }

    public static void pr(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
        if (jSONObjectOptJSONObject != null) {
            try {
                pr = jSONObjectOptJSONObject.optLong("reward_time_limited", 27000L);
                hw = jSONObjectOptJSONObject.optInt("reward_force_close_max_count", 0);
                hn = jSONObjectOptJSONObject.optInt("reward_local_countdown_close_style", 0);
                x = jSONObjectOptJSONObject.optInt("native_countdown_limit_max", 0);
            } catch (Exception e) {
            }
        }
    }

    public static void pr(com.byazt.zq.c cVar) {
        cVar.pr("reward_time_limited", pr);
        cVar.pr("reward_force_close_max_count", hw);
        cVar.pr("reward_local_countdown_close_style", hn);
        cVar.pr("native_countdown_limit_max", x);
    }

    public static void hw(com.byazt.zq.c cVar) {
        pr = cVar.hw("reward_time_limited", 27000L);
        hw = cVar.hw("reward_force_close_max_count", 0);
        hn = cVar.hw("reward_local_countdown_close_style", 0);
        x = cVar.hw("native_countdown_limit_max", 0);
    }

    public void hw(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            ArrayList<pj> arrayList = this.b;
            if (arrayList != null && arrayList.size() != 0) {
                Iterator<pj> it = this.b.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().pr());
                }
            }
            jSONObject2.put("retain_dialog_config", jSONArray);
            l lVar = this.iu;
            if (lVar != null) {
                lVar.pr(jSONObject2);
            }
            jSONObject2.put("endcard_transform_enabled", this.gz);
            jSONObject2.put("video_no_play_start", this.e);
            jSONObject.put("reward", jSONObject2);
        } catch (JSONException e) {
        }
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("reward_name", this.c);
            jSONObject3.put("reward_amount", this.uc);
            jSONObject3.put("reward_info_show", this.fw);
            jSONObject3.put("reward_back_type", this.g);
            jSONObject3.put("reward_backup_timing", this.ho);
            jSONObject3.put("reward_backup_duration", this.nt);
            jSONObject3.put("reward_is_callback", this.nl);
            jSONObject3.put("reward_need_click", this.y);
            jSONObject3.put("reward_speed_time", this.ww);
            JSONObject jSONObject4 = new JSONObject();
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("enable", this.zo);
            jSONObject5.put("propose_reward", this.aj);
            jSONObject4.put("easy_playable", jSONObject5);
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("enable", this.vk);
            jSONObject6.put("propose_reward", this.w);
            jSONObject6.put("tip_toast", this.k);
            jSONObject6.put("min_duration", this.m);
            jSONObject4.put("play_complete", jSONObject6);
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("enable", this.yb);
            jSONObject7.put("propose_reward", this.lb);
            jSONObject4.put("playable_interactive", jSONObject7);
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("enable", this.qa);
            jSONObject8.put("propose_reward", this.a);
            jSONObject8.put("landing_view_time", this.cz);
            jSONObject4.put("click_landing", jSONObject8);
            jSONObject3.put("reward_advanced_config", jSONObject4);
            jSONObject.put("reward_data", jSONObject3);
        } catch (JSONException e2) {
        }
        try {
            jSONObject.put("reward_full_play_time", this.ny);
            jSONObject.put("reward_full_time_type", this.fo);
            jSONObject.put("interstitial_bg_transparent", this.ve);
            jSONObject.put("template_sign", this.n);
            jSONObject.put("__is_use_local_time", this.rc);
            jSONObject.put("__is_click_landing_reward", this.z);
        } catch (JSONException e3) {
        }
    }

    private static jn gz(of ofVar) {
        if (ofVar == null) {
            return null;
        }
        return ofVar.qv();
    }

    public static String pr(of ofVar) {
        jn jnVarGz = gz(ofVar);
        if (jnVarGz == null) {
            return "";
        }
        return jnVarGz.c;
    }

    public static int hw(of ofVar) {
        jn jnVarGz = gz(ofVar);
        if (jnVarGz == null) {
            return 0;
        }
        return jnVarGz.uc;
    }

    public static boolean hn(of ofVar) {
        jn jnVarGz = gz(ofVar);
        if (jnVarGz == null) {
            return false;
        }
        return jnVarGz.fw;
    }

    public static long pr() {
        return pr;
    }

    public static long hw() {
        return hw;
    }

    public static boolean hn() {
        return hn == 1;
    }

    public static boolean x() {
        return x == 1;
    }

    public static boolean x(of ofVar) {
        jn jnVarGz = gz(ofVar);
        return jnVarGz != null && jnVarGz.g == 1;
    }

    public static boolean c(of ofVar) {
        jn jnVarGz = gz(ofVar);
        if (jnVarGz == null) {
            return false;
        }
        return jnVarGz.zo;
    }

    public static double uc(of ofVar) {
        jn jnVarGz = gz(ofVar);
        if (jnVarGz == null) {
            return 0.0d;
        }
        return jnVarGz.aj;
    }

    public static boolean fw(of ofVar) {
        jn jnVarGz = gz(ofVar);
        if (jnVarGz == null) {
            return false;
        }
        return jnVarGz.vk;
    }

    public static double zo(of ofVar) {
        jn jnVarGz = gz(ofVar);
        if (jnVarGz == null) {
            return 0.0d;
        }
        return jnVarGz.w;
    }

    public static String aj(of ofVar) {
        jn jnVarGz = gz(ofVar);
        if (jnVarGz == null) {
            return "";
        }
        return TextUtils.isEmpty(jnVarGz.k) ? "别急着跳过，继续观看完整视频，可获得更多额外奖励～" : jnVarGz.k;
    }

    public static int vk(of ofVar) {
        jn jnVarGz = gz(ofVar);
        if (jnVarGz == null) {
            return 30000;
        }
        int iMax = Math.max(jnVarGz.m, 30);
        return (iMax <= 60 ? iMax : 30) * 1000;
    }

    public static boolean w(of ofVar) {
        jn jnVarGz = gz(ofVar);
        if (jnVarGz == null) {
            return false;
        }
        return jnVarGz.yb;
    }

    public static double k(of ofVar) {
        jn jnVarGz = gz(ofVar);
        if (jnVarGz == null) {
            return 0.0d;
        }
        return jnVarGz.lb;
    }

    public static boolean m(of ofVar) {
        jn jnVarGz = gz(ofVar);
        if (jnVarGz == null) {
            return false;
        }
        return jnVarGz.qa;
    }

    public static int g(of ofVar) {
        jn jnVarGz = gz(ofVar);
        if (jnVarGz == null) {
            return 5;
        }
        return Math.max(5, jnVarGz.cz);
    }

    public static float pr(of ofVar, int i) {
        switch (i) {
            case 0:
                return 1.0f;
            case 1:
                return (float) uc(ofVar);
            case 2:
                return (float) zo(ofVar);
            case 3:
                return (float) k(ofVar);
            default:
                return 0.0f;
        }
    }

    public static int ho(of ofVar) {
        int i;
        jn jnVarGz = gz(ofVar);
        if (jnVarGz == null || (i = jnVarGz.ny) < 10 || i > 60) {
            return 30;
        }
        return i;
    }

    public static int nt(of ofVar) {
        jn jnVarGz = gz(ofVar);
        if (jnVarGz == null) {
            return 0;
        }
        return jnVarGz.fo;
    }

    public static boolean yb(of ofVar) {
        jn jnVarGz = gz(ofVar);
        if (jnVarGz != null && jnVarGz.rc) {
            return lb.x(ofVar) || nt(ofVar) == 1 || nt(ofVar) == 2;
        }
        return false;
    }

    public static boolean lb(of ofVar) {
        jn jnVarGz = gz(ofVar);
        return jnVarGz != null && jnVarGz.rc && nt(ofVar) == 1;
    }

    public static boolean qa(of ofVar) {
        jn jnVarGz = gz(ofVar);
        if (jnVarGz == null || !jnVarGz.z) {
            return false;
        }
        return m(ofVar);
    }

    public static void pr(of ofVar, boolean z) {
        jn jnVarGz = gz(ofVar);
        if (jnVarGz != null) {
            jnVarGz.rc = z;
        }
    }

    public static void hw(of ofVar, boolean z) {
        jn jnVarGz = gz(ofVar);
        if (jnVarGz != null) {
            jnVarGz.z = z;
        }
    }

    public static ArrayList<pj> a(of ofVar) {
        jn jnVarGz = gz(ofVar);
        if (jnVarGz != null) {
            return jnVarGz.b;
        }
        return new ArrayList<>();
    }

    public static boolean cz(of ofVar) {
        jn jnVarGz = gz(ofVar);
        return jnVarGz != null && jnVarGz.ho == 1;
    }

    public static int hw(of ofVar, int i) {
        int i2;
        jn jnVarGz = gz(ofVar);
        if (jnVarGz == null || (i2 = jnVarGz.nt) <= 0) {
            return i;
        }
        return Math.min(i, i2);
    }

    public static l ny(of ofVar) {
        jn jnVarGz = gz(ofVar);
        if (jnVarGz != null) {
            return jnVarGz.iu;
        }
        return null;
    }

    public static boolean fo(of ofVar) {
        jn jnVarGz = gz(ofVar);
        if (jnVarGz != null) {
            return jnVarGz.ve;
        }
        return false;
    }

    public static boolean rc(of ofVar) {
        jn jnVarGz = gz(ofVar);
        if (jnVarGz == null) {
            return false;
        }
        return jnVarGz.gz;
    }

    public static boolean hn(of ofVar, boolean z) {
        jn jnVarGz = gz(ofVar);
        return (jnVarGz != null && z && jnVarGz.e == 1) ? false : true;
    }

    public static boolean z(of ofVar) {
        jn jnVarGz = gz(ofVar);
        return jnVarGz != null && jnVarGz.nl == 1;
    }

    public static float b(of ofVar) {
        jn jnVarGz = gz(ofVar);
        if (jnVarGz == null) {
            return 1.0f;
        }
        return jnVarGz.ww;
    }

    public static boolean iu(of ofVar) {
        jn jnVarGz = gz(ofVar);
        if (jnVarGz == null) {
            return false;
        }
        return jnVarGz.y;
    }

    public static int ve(of ofVar) {
        jn jnVarGz = gz(ofVar);
        if (jnVarGz == null) {
            return 0;
        }
        return jnVarGz.n;
    }
}
