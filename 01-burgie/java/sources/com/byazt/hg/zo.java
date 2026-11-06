package com.byazt.hg;

import android.text.TextUtils;
import com.byazt.mg.PluginConstants;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo {
    public static hn c;
    public static hn fw;
    public static hn hn;
    public static hn hw;
    public static hn pr;
    public static hn uc;
    public static hn x;
    public static final hn zo = new hn(null);

    public static void pr(com.byazt.zq.c cVar) {
        try {
            pr = new hn(new JSONObject(cVar.hw("cache_strategy_reward", "")));
        } catch (JSONException e) {
        }
        try {
            hw = new hn(new JSONObject(cVar.hw("cache_strategy_full", "")));
        } catch (JSONException e2) {
        }
        try {
            x = new hn(new JSONObject(cVar.hw("cache_strategy_banner", "")));
        } catch (JSONException e3) {
        }
        try {
            c = new hn(new JSONObject(cVar.hw("cache_strategy_feed", "")));
        } catch (JSONException e4) {
        }
        try {
            uc = new hn(new JSONObject(cVar.hw("cache_strategy_draw", "")));
        } catch (JSONException e5) {
        }
        try {
            fw = new hn(new JSONObject(cVar.hw("cache_strategy_stream", "")));
        } catch (JSONException e6) {
        }
        try {
            com.byazt.ra.hn.pr();
        } catch (Exception e7) {
        }
    }

    public static void pr(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
        if (jSONObjectOptJSONObject != null) {
            try {
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("cache_strategy_reward");
                if (jSONObjectOptJSONObject2 != null) {
                    pr = new hn(jSONObjectOptJSONObject2);
                    com.byazt.py.c.hw(7);
                }
            } catch (Exception e) {
                new Object[1][0] = e;
            }
            try {
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("cache_strategy_full");
                if (jSONObjectOptJSONObject3 != null) {
                    hw = new hn(jSONObjectOptJSONObject3);
                    com.byazt.py.c.hw(8);
                }
            } catch (Exception e2) {
                new Object[1][0] = e2;
            }
            try {
                JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject.optJSONObject("cache_strategy_banner");
                if (jSONObjectOptJSONObject4 != null) {
                    x = new hn(jSONObjectOptJSONObject4);
                    com.byazt.py.c.hw(1);
                }
            } catch (Exception e3) {
                new Object[1][0] = e3;
            }
            try {
                JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject.optJSONObject("cache_strategy_feed");
                if (jSONObjectOptJSONObject5 != null) {
                    c = new hn(jSONObjectOptJSONObject5);
                    com.byazt.py.c.hw(5);
                }
            } catch (Exception e4) {
                new Object[1][0] = e4;
            }
            try {
                JSONObject jSONObjectOptJSONObject6 = jSONObjectOptJSONObject.optJSONObject("cache_strategy_draw");
                if (jSONObjectOptJSONObject6 != null) {
                    uc = new hn(jSONObjectOptJSONObject6);
                    com.byazt.py.c.hw(9);
                }
            } catch (Exception e5) {
                new Object[1][0] = e5;
            }
            try {
                JSONObject jSONObjectOptJSONObject7 = jSONObjectOptJSONObject.optJSONObject("cache_strategy_splash");
                if (jSONObjectOptJSONObject7 != null) {
                    hn = new hn(jSONObjectOptJSONObject7);
                    com.byazt.py.c.hw(3);
                }
            } catch (Exception e6) {
                new Object[1][0] = e6;
            }
            try {
                JSONObject jSONObjectOptJSONObject8 = jSONObjectOptJSONObject.optJSONObject("cache_strategy_stream");
                if (jSONObjectOptJSONObject8 != null) {
                    fw = new hn(jSONObjectOptJSONObject8);
                    com.byazt.py.c.hw(6);
                }
            } catch (Exception e7) {
                new Object[1][0] = e7;
            }
        }
    }

    public static void hw(com.byazt.zq.c cVar) {
        hn hnVar = pr;
        if (hnVar != null) {
            cVar.pr("cache_strategy_reward", hnVar.pr());
        }
        hn hnVar2 = hw;
        if (hnVar2 != null) {
            cVar.pr("cache_strategy_full", hnVar2.pr());
        }
        hn hnVar3 = x;
        if (hnVar3 != null) {
            cVar.pr("cache_strategy_banner", hnVar3.pr());
        }
        hn hnVar4 = c;
        if (hnVar4 != null) {
            cVar.pr("cache_strategy_feed", hnVar4.pr());
        }
        hn hnVar5 = uc;
        if (hnVar5 != null) {
            cVar.pr("cache_strategy_draw", hnVar5.pr());
        }
        hn hnVar6 = fw;
        if (hnVar6 != null) {
            cVar.pr("cache_strategy_stream", hnVar6.pr());
        }
        if (hn != null) {
            com.byazt.mp.c.hw hwVar = new com.byazt.mp.c.hw();
            hwVar.x(hn.pr());
            hwVar.pr();
        }
    }

    private static hn hw() {
        hn hnVar = pr;
        if (hnVar == null) {
            return new hn(new JSONObject());
        }
        return hnVar;
    }

    private static hn hn() {
        hn hnVar = hw;
        if (hnVar == null) {
            return new hn(new JSONObject());
        }
        return hnVar;
    }

    private static hn x() {
        hn hnVar = x;
        if (hnVar == null) {
            return new hn(new JSONObject());
        }
        return hnVar;
    }

    private static hn c() {
        hn hnVar = c;
        if (hnVar == null) {
            return new hn(new JSONObject());
        }
        return hnVar;
    }

    private static hn uc() {
        hn hnVar = uc;
        if (hnVar == null) {
            return new hn(new JSONObject());
        }
        return hnVar;
    }

    private static hn fw() {
        hn hnVar = fw;
        if (hnVar == null) {
            return new hn(new JSONObject());
        }
        return hnVar;
    }

    public static hn pr() {
        if (hn == null) {
            String strHo = com.byazt.mp.c.pr().ho();
            try {
                if (TextUtils.isEmpty(strHo)) {
                    hn hnVar = new hn(new JSONObject());
                    hn = hnVar;
                    hnVar.x = 0;
                } else {
                    hn = new hn(new JSONObject(strHo));
                }
            } catch (JSONException e) {
            }
        }
        return hn;
    }

    public static hn pr(int i) {
        switch (i) {
            case 1:
                return x();
            case 2:
            default:
                return zo;
            case 3:
            case 4:
                return pr();
            case 5:
                return c();
            case 6:
                return fw();
            case 7:
                return hw();
            case 8:
                return hn();
            case 9:
                return uc();
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 498})
    public static class hn {
        public x aj;
        public int c;
        public int fw;
        public int g;
        public int hn;
        public boolean ho;
        public int hw;
        public int k;
        public int m;
        public double nt;
        public int pr;
        public boolean uc;
        public pr vk;
        public int w;
        public int x;
        public c yb;
        public int zo;

        public hn(JSONObject jSONObject) {
            this.pr = 1;
            this.hw = 1;
            this.hn = -1;
            this.x = 0;
            this.c = 10000;
            this.uc = false;
            this.fw = -1;
            this.zo = 0;
            this.w = 1;
            this.k = 0;
            this.m = 0;
            this.g = 0;
            this.ho = true;
            this.nt = 0.0d;
            if (jSONObject != null) {
                this.pr = jSONObject.optInt("get_type", 1);
                this.hw = jSONObject.optInt("max_count", 1);
                this.hn = jSONObject.optInt("strategy_type", -1);
                this.x = jSONObject.optInt("store_type", 0);
                this.c = jSONObject.optInt("online_timeout", 10000);
                this.uc = jSONObject.optBoolean("enable", false);
                this.fw = jSONObject.optInt("load_type", -1);
                this.zo = jSONObject.optInt("trans_cache", 0);
                this.w = jSONObject.optInt("ad_count_max", 1);
                this.k = jSONObject.optInt("libra_group", 0);
                this.m = jSONObject.optInt("record_interval_minute", 0);
                this.g = jSONObject.optInt("record_cache_minute", 0);
                this.aj = new x(jSONObject.optJSONObject("score_config"));
                this.vk = new pr(jSONObject.optJSONObject("control_el"));
                this.ho = jSONObject.optBoolean("is_filter_version", true);
                this.nt = jSONObject.optDouble("cache_available_percent", 0.0d);
                this.yb = new c(jSONObject.optJSONObject("tmax_config"));
                return;
            }
            this.yb = new c(null);
        }

        public String pr() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("get_type", this.pr);
                jSONObject.put("max_count", this.hw);
                jSONObject.put("strategy_type", this.hn);
                jSONObject.put("store_type", this.x);
                jSONObject.put("online_timeout", this.c);
                jSONObject.put("enable", this.uc);
                jSONObject.put("is_filter_version", this.ho);
                jSONObject.put("load_type", this.fw);
                jSONObject.put("trans_cache", this.zo);
                jSONObject.put("score_config", this.aj.pr());
                jSONObject.put("control_el", this.vk.pr());
                jSONObject.put("ad_count_max", this.w);
                jSONObject.put("libra_group", this.k);
                jSONObject.put("record_interval_minute", this.m);
                jSONObject.put("record_cache_minute", this.g);
                jSONObject.put("cache_available_percent", this.nt);
                c cVar = this.yb;
                jSONObject.put("tmax_config", cVar == null ? null : cVar.pr());
            } catch (Exception e) {
            }
            return jSONObject.toString();
        }

        public int hw() {
            return this.pr;
        }

        public int hn() {
            if (this.hw <= 0) {
                this.hw = 1;
            }
            return this.hw;
        }

        public int x() {
            return this.hn;
        }

        public int c() {
            return this.x;
        }

        public int uc() {
            return this.c;
        }

        public boolean fw() {
            return this.uc;
        }

        public boolean zo() {
            return this.ho;
        }

        public int aj() {
            return this.fw;
        }

        public int vk() {
            return this.zo;
        }

        public x w() {
            return this.aj;
        }

        public boolean pr(String str, hw hwVar) {
            if (this.vk == null) {
                return false;
            }
            System.currentTimeMillis();
            boolean zPr = this.vk.pr(str, hwVar);
            System.currentTimeMillis();
            return zPr;
        }

        public int k() {
            return Math.max(this.w, 1);
        }

        public int m() {
            return this.k;
        }

        public int g() {
            return this.m;
        }

        public int ho() {
            return this.g;
        }

        public double nt() {
            double d = this.nt;
            if (d >= 0.0d && d <= 1.0d) {
                return d;
            }
            return 0.0d;
        }

        public c yb() {
            return this.yb;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 1497})
    public static class c {
        public float a;
        public float aj;
        public int c;
        public float cz;
        public int fw;
        public float g;
        public long hn;
        public float ho;
        public long hw;
        public float k;
        public float lb;
        public float m;
        public float nt;
        public float ny;
        public boolean pr;
        public float qa;
        public int uc;
        public float vk;
        public float w;
        public int x;
        public float yb;
        public float zo;

        public c(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.pr = jSONObject.optBoolean("tmax_enable", false);
                this.hw = jSONObject.optLong("tmax_max_limit", 0L);
                this.hn = jSONObject.optLong("tmax_min_limit", 0L);
                this.x = jSONObject.optInt("tmax_calc_type", 0);
                this.c = jSONObject.optInt("tmax_calc_min_count_limit", 30);
                this.uc = jSONObject.optInt("tmax_calc_max_count_limit", 500);
                this.fw = jSONObject.optInt("tmax_cache_expire", 600);
                this.zo = (float) jSONObject.optDouble("tmax_calc_percent_low", 0.5d);
                this.aj = (float) jSONObject.optDouble("tmax_calc_percent_medium", 0.8999999761581421d);
                this.vk = (float) jSONObject.optDouble("tmax_calc_percent_high", 0.949999988079071d);
                this.w = (float) jSONObject.optDouble("tmax_calc_boundary_pct", 0.9800000190734863d);
                this.k = (float) jSONObject.optDouble("tmax_calc_shown_pct_low", 0.8999999761581421d);
                this.m = (float) jSONObject.optDouble("tmax_calc_shown_pct_medium", 0.949999988079071d);
                this.g = (float) jSONObject.optDouble("tmax_calc_shown_pct_high", 0.9900000095367432d);
                this.ho = (float) jSONObject.optDouble("tmax_calc_hard_cap_pct", 0.9950000047683716d);
                this.nt = (float) jSONObject.optDouble("tmax_deviation_ratio", 0.30000001192092896d);
                this.yb = (float) jSONObject.optDouble("tmax_marginal_load_rate", 0.05000000074505806d);
                this.lb = (float) jSONObject.optDouble("tmax_utilization_rate", 0.30000001192092896d);
                this.qa = (float) jSONObject.optDouble("tmax_too_small_load_success_rate_low", 0.8999999761581421d);
                this.a = (float) jSONObject.optDouble("tmax_too_small_load_success_rate_high", 0.949999988079071d);
                this.cz = (float) jSONObject.optDouble("tmax_too_small_marginal_load_rate", 0.15000000596046448d);
                this.ny = (float) jSONObject.optDouble("tmax_too_small_deviation_ratio", -0.10000000149011612d);
            } else {
                this.pr = false;
                this.hw = 0L;
                this.hn = 0L;
                this.x = 0;
                this.c = 30;
                this.uc = 500;
                this.fw = 600;
                this.zo = 0.5f;
                this.aj = 0.9f;
                this.vk = 0.95f;
                this.w = 0.98f;
                this.k = 0.9f;
                this.m = 0.95f;
                this.g = 0.99f;
                this.ho = 0.995f;
                this.nt = 0.3f;
                this.yb = 0.05f;
                this.lb = 0.3f;
                this.qa = 0.9f;
                this.a = 0.95f;
                this.cz = 0.15f;
                this.ny = -0.1f;
            }
            if (this.hw < 0) {
                this.hw = 0L;
            }
            if (this.hn < 0) {
                this.hn = 0L;
            }
            int i = this.x;
            if (i != 0 && i != 1) {
                this.x = 0;
            }
        }

        public JSONObject pr() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("tmax_enable", this.pr);
                jSONObject.put("tmax_max_limit", this.hw);
                jSONObject.put("tmax_min_limit", this.hn);
                jSONObject.put("tmax_calc_type", this.x);
                jSONObject.put("tmax_calc_min_count_limit", this.c);
                jSONObject.put("tmax_calc_max_count_limit", this.uc);
                jSONObject.put("tmax_cache_expire", this.fw);
                jSONObject.put("tmax_calc_percent_low", this.zo);
                jSONObject.put("tmax_calc_percent_medium", this.aj);
                jSONObject.put("tmax_calc_percent_high", this.vk);
                jSONObject.put("tmax_calc_boundary_pct", this.w);
                jSONObject.put("tmax_calc_shown_pct_low", this.k);
                jSONObject.put("tmax_calc_shown_pct_medium", this.m);
                jSONObject.put("tmax_calc_shown_pct_high", this.g);
                jSONObject.put("tmax_calc_hard_cap_pct", this.ho);
                jSONObject.put("tmax_deviation_ratio", this.nt);
                jSONObject.put("tmax_marginal_load_rate", this.yb);
                jSONObject.put("tmax_utilization_rate", this.lb);
                jSONObject.put("tmax_too_small_load_success_rate_low", this.qa);
                jSONObject.put("tmax_too_small_load_success_rate_high", this.a);
                jSONObject.put("tmax_too_small_marginal_load_rate", this.cz);
                jSONObject.put("tmax_too_small_deviation_ratio", this.ny);
            } catch (Exception e) {
            }
            return jSONObject;
        }

        public boolean hw() {
            return this.pr;
        }

        public long hn() {
            return this.hw;
        }

        public long x() {
            return this.hn;
        }

        public int c() {
            return this.x;
        }

        public int uc() {
            return this.c;
        }

        public int fw() {
            int i = this.uc;
            if (i <= 0) {
                return 500;
            }
            return i;
        }

        public int zo() {
            return this.fw;
        }

        public float aj() {
            return this.zo;
        }

        public float vk() {
            return this.aj;
        }

        public float w() {
            return this.vk;
        }

        public float k() {
            return this.w;
        }

        public float m() {
            return this.k;
        }

        public float g() {
            return this.m;
        }

        public float ho() {
            return this.g;
        }

        public float nt() {
            return this.ho;
        }

        public float yb() {
            return this.nt;
        }

        public float lb() {
            return this.yb;
        }

        public float qa() {
            return this.lb;
        }

        public float a() {
            return this.qa;
        }

        public float cz() {
            return this.a;
        }

        public float ny() {
            return this.cz;
        }

        public float fo() {
            return this.ny;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 1499})
    public static class x {
        public int c;
        public int hn;
        public int hw;
        public int pr;
        public LinkedHashMap<Integer, Integer> uc;
        public int x;

        public x(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.pr = jSONObject.optInt("device_score_threshold", 0);
                this.hw = jSONObject.optInt("net_type_threshold", 0);
                this.hn = jSONObject.optInt("base_score", 60);
                this.x = jSONObject.optInt("score_threshold", 60);
                this.c = jSONObject.optInt("backup_score_threshold", 0);
                LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("last_cache_score");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONArray jSONArrayOptJSONArray2 = jSONArrayOptJSONArray.optJSONArray(i);
                        int iOptInt = jSONArrayOptJSONArray2.optInt(0);
                        int iOptInt2 = jSONArrayOptJSONArray2.optInt(1);
                        if (iOptInt > 0) {
                            linkedHashMap.put(Integer.valueOf(iOptInt), Integer.valueOf(iOptInt2));
                        }
                    }
                }
                this.uc = linkedHashMap;
            }
        }

        public JSONObject pr() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("device_score_threshold", this.pr);
                jSONObject.put("net_type_threshold", this.hw);
                jSONObject.put("base_score", this.hn);
                jSONObject.put("score_threshold", this.x);
                jSONObject.put("backup_score_threshold", this.c);
                JSONArray jSONArray = new JSONArray();
                LinkedHashMap<Integer, Integer> linkedHashMap = this.uc;
                if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
                    for (Integer num : this.uc.keySet()) {
                        JSONArray jSONArray2 = new JSONArray();
                        jSONArray2.put(num);
                        jSONArray2.put(this.uc.get(num));
                        jSONArray.put(jSONArray2);
                    }
                }
                jSONObject.put("last_cache_score", jSONArray);
            } catch (Exception e) {
            }
            return jSONObject;
        }

        public int hw() {
            return this.pr;
        }

        public int hn() {
            return this.hw;
        }

        public int x() {
            return this.x;
        }

        public int c() {
            return this.c;
        }

        public LinkedHashMap<Integer, Integer> uc() {
            return this.uc;
        }

        public int fw() {
            return this.hn;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 673})
    public static class pr {
        public String aj;
        public String c;
        public String fw;
        public String hn;
        public String hw;
        public JSONObject pr;
        public String uc;
        public String vk;
        public String x;
        public String zo;

        public pr(JSONObject jSONObject) {
            this.pr = jSONObject;
            if (jSONObject != null) {
                this.hw = jSONObject.optString("mix_ad");
                this.hn = jSONObject.optString("disable_trans_cache");
                this.x = jSONObject.optString("delete_on_load");
                this.c = jSONObject.optString("load_only_online");
                this.uc = jSONObject.optString("forbid_save_cache");
                this.aj = jSONObject.optString("forbid_read_cache");
                this.fw = jSONObject.optString("forbid_realtime_use_cache");
                this.zo = jSONObject.optString("forbid_realtime");
                this.vk = jSONObject.optString("forbid_preload");
            }
        }

        public JSONObject pr() {
            return this.pr;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:32:0x0066  */
        /* JADX WARN: Code duplicated, block: B:59:0x00a8  */
        private boolean hw(String str, hw hwVar) {
            byte b;
            String str2;
            boolean z = true;
            switch (str) {
                case "delete_on_load":
                    b = 2;
                    break;
                case "mix_ad":
                    b = 0;
                    break;
                case "disable_trans_cache":
                    b = 1;
                    break;
                case "forbid_save_cache":
                    b = 4;
                    break;
                case "forbid_realtime_use_cache":
                    b = 6;
                    break;
                case "forbid_realtime":
                    b = 7;
                    break;
                case "load_only_online":
                    b = 3;
                    break;
                case "forbid_preload":
                    b = 8;
                    break;
                case "forbid_read_cache":
                    b = 5;
                    break;
                default:
                    b = -1;
                    break;
            }
            String strPr = null;
            switch (b) {
                case 0:
                    str2 = !TextUtils.isEmpty(this.hw) ? this.hw : "${(meta.group_info.group_id != null) || (meta.insert_ad_control == 1) || (meta.refresh_ad_control == 1) || (meta.force_refresh_ad_control == 1) || (meta.refresh_control == 1) || (meta.web_refresh_control == 1)}";
                    break;
                case 1:
                    str2 = this.hn;
                    break;
                case 2:
                    str2 = this.x;
                    break;
                case 3:
                    str2 = this.c;
                    break;
                case 4:
                    str2 = this.uc;
                    break;
                case 5:
                    str2 = this.aj;
                    break;
                case 6:
                    str2 = this.fw;
                    break;
                case 7:
                    str2 = this.zo;
                    break;
                case 8:
                    str2 = this.vk;
                    break;
                default:
                    str2 = null;
                    break;
            }
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            if (str2 == null) {
                z = false;
                strPr = com.byazt.tn.hw.pr(str2, pr(hwVar, z));
            } else {
                try {
                    if (!str2.contains("meta.")) {
                        z = false;
                    }
                    strPr = com.byazt.tn.hw.pr(str2, pr(hwVar, z));
                } catch (Exception e) {
                }
            }
            return TextUtils.equals(strPr, "true");
        }

        private JSONObject pr(hw hwVar, boolean z) {
            Object obj;
            int iHn;
            com.byazt.qe.hw hwVar2 = null;
            Object objHw = null;
            if (hwVar == null) {
                obj = null;
                iHn = 0;
            } else {
                com.byazt.qe.hw hwVarPr = hwVar.pr();
                if (z) {
                    objHw = hwVar.hw();
                }
                iHn = hwVar.hn();
                obj = objHw;
                hwVar2 = hwVarPr;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("os", "android");
                jSONObject2.put("sdk_version", com.byazt.sd.iu.x);
                jSONObject2.put(PluginConstants.KEY_PLUGIN_VERSION, 7714);
                jSONObject.put("device", jSONObject2);
                if (hwVar2 != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("adType", hwVar2.a());
                    jSONObject3.put("adCount", hwVar2.k());
                    jSONObject3.put("userData", com.byazt.zp.vk.pr(hwVar2.ny()));
                    jSONObject.put("adSlot", jSONObject3);
                }
                if (obj != null) {
                    jSONObject.put("meta", obj);
                }
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("last_net_code", iHn);
                jSONObject4.put("has_cache", hwVar != null && hwVar.x());
                JSONObject jSONObjectPr = com.byazt.ra.hn.pr(hwVar2 != null ? hwVar2.a() : 0, hwVar2 == null ? "" : hwVar2.gz());
                if (jSONObjectPr != null) {
                    jSONObject4.put("ca_interval_info", jSONObjectPr);
                }
                jSONObject.put("state", jSONObject4);
                return jSONObject;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

        public boolean pr(String str, hw hwVar) {
            return hw(str, hwVar);
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_CREATE_TIME})
    public static class hw {
        public boolean c;
        public of hn;
        public JSONObject hw;
        public com.byazt.qe.hw pr;
        public int x;

        private hw(pr prVar) {
            this.pr = prVar.pr;
            this.hn = prVar.hn;
            this.hw = prVar.hw;
            this.x = prVar.x;
            this.c = prVar.c;
        }

        public com.byazt.qe.hw pr() {
            return this.pr;
        }

        public JSONObject hw() {
            JSONObject jSONObject = this.hw;
            if (jSONObject != null) {
                return jSONObject;
            }
            of ofVar = this.hn;
            if (ofVar != null) {
                return ofVar.to();
            }
            return null;
        }

        public int hn() {
            return this.x;
        }

        public boolean x() {
            return this.c;
        }

        @com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 1687})
        public static class pr {
            public boolean c;
            public of hn;
            public JSONObject hw;
            public com.byazt.qe.hw pr;
            public int x;

            public pr pr(com.byazt.qe.hw hwVar) {
                this.pr = hwVar;
                return this;
            }

            public pr pr(JSONObject jSONObject) {
                this.hw = jSONObject;
                return this;
            }

            public pr pr(of ofVar) {
                this.hn = ofVar;
                return this;
            }

            public pr pr(int i) {
                this.x = i;
                return this;
            }

            public pr pr(boolean z) {
                this.c = z;
                return this;
            }

            public hw pr() {
                return new hw(this);
            }
        }
    }
}
