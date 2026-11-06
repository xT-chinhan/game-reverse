package com.byazt.gct;

import android.text.TextUtils;
import com.byazt.qyu.PluginConstants;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import com.taptap.sdk.login.internal.handlers.web.WebLoginFragment;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 101})
public class fs {
    public static s fs;
    public static s l;
    public static final q n;
    public static s q;
    public static final q qg;
    public static s rv;
    public static s s;
    public static final s tj = new s(null);
    public static s w;
    public static s x;

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 129})
    private static final class q {
        public int fs;
        public int l;
        public int n;
        public int q;
        public int qg;
        public int rv;
        public int s;
        public boolean tj;
        public boolean w;
        public int x;

        private q() {
            this.n = 1;
            this.qg = 1;
            this.s = -1;
            this.q = 0;
            this.l = 10000;
            this.w = false;
            this.x = -1;
            this.fs = 0;
            this.rv = 1;
            this.tj = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public q n(int i) {
            this.s = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public q qg(int i) {
            this.l = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public q s(int i) {
            this.x = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public q n(boolean z) {
            this.tj = z;
            return this;
        }
    }

    static {
        n = new q();
        qg = new q().s(2).n(3).qg(2700).n(true);
    }

    private static q qg(int i) {
        if (i == 7 || i == 8) {
            return qg;
        }
        return n;
    }

    public static void n(com.byazt.gwu.l lVar) {
        try {
            s = new s(new JSONObject(lVar.qg("cache_strategy_reward", "")), qg(7));
        } catch (JSONException unused) {
        }
        try {
            q = new s(new JSONObject(lVar.qg("cache_strategy_full", "")), qg(8));
        } catch (JSONException unused2) {
        }
        try {
            w = new s(new JSONObject(lVar.qg("cache_strategy_banner", "")));
        } catch (JSONException unused3) {
        }
        try {
            x = new s(new JSONObject(lVar.qg("cache_strategy_feed", "")));
        } catch (JSONException unused4) {
        }
        try {
            fs = new s(new JSONObject(lVar.qg("cache_strategy_draw", "")));
        } catch (JSONException unused5) {
        }
        try {
            rv = new s(new JSONObject(lVar.qg("cache_strategy_stream", "")));
        } catch (JSONException unused6) {
        }
        try {
            com.byazt.msp.s.n();
        } catch (Exception unused7) {
        }
    }

    public static void n(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
        if (jSONObjectOptJSONObject != null) {
            try {
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("cache_strategy_reward");
                if (jSONObjectOptJSONObject2 != null) {
                    s = new s(jSONObjectOptJSONObject2, qg(7));
                    com.byazt.ci.l.qg(7);
                }
            } catch (Exception unused) {
                Object[] objArr = new Object[1];
            }
            try {
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("cache_strategy_full");
                if (jSONObjectOptJSONObject3 != null) {
                    q = new s(jSONObjectOptJSONObject3, qg(8));
                    com.byazt.ci.l.qg(8);
                }
            } catch (Exception unused2) {
                Object[] objArr2 = new Object[1];
            }
            try {
                JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject.optJSONObject("cache_strategy_banner");
                if (jSONObjectOptJSONObject4 != null) {
                    w = new s(jSONObjectOptJSONObject4);
                    com.byazt.ci.l.qg(1);
                }
            } catch (Exception unused3) {
                Object[] objArr3 = new Object[1];
            }
            try {
                JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject.optJSONObject("cache_strategy_feed");
                if (jSONObjectOptJSONObject5 != null) {
                    x = new s(jSONObjectOptJSONObject5);
                    com.byazt.ci.l.qg(5);
                }
            } catch (Exception unused4) {
                Object[] objArr4 = new Object[1];
            }
            try {
                JSONObject jSONObjectOptJSONObject6 = jSONObjectOptJSONObject.optJSONObject("cache_strategy_draw");
                if (jSONObjectOptJSONObject6 != null) {
                    fs = new s(jSONObjectOptJSONObject6);
                    com.byazt.ci.l.qg(9);
                }
            } catch (Exception unused5) {
                Object[] objArr5 = new Object[1];
            }
            try {
                JSONObject jSONObjectOptJSONObject7 = jSONObjectOptJSONObject.optJSONObject("cache_strategy_splash");
                if (jSONObjectOptJSONObject7 != null) {
                    l = new s(jSONObjectOptJSONObject7);
                    com.byazt.ci.l.qg(3);
                }
            } catch (Exception unused6) {
                Object[] objArr6 = new Object[1];
            }
            try {
                JSONObject jSONObjectOptJSONObject8 = jSONObjectOptJSONObject.optJSONObject("cache_strategy_stream");
                if (jSONObjectOptJSONObject8 != null) {
                    rv = new s(jSONObjectOptJSONObject8);
                    com.byazt.ci.l.qg(6);
                }
            } catch (Exception unused7) {
                Object[] objArr7 = new Object[1];
            }
        }
    }

    public static void qg(com.byazt.gwu.l lVar) {
        s sVar = s;
        if (sVar != null) {
            lVar.n("cache_strategy_reward", sVar.n());
        }
        s sVar2 = q;
        if (sVar2 != null) {
            lVar.n("cache_strategy_full", sVar2.n());
        }
        s sVar3 = w;
        if (sVar3 != null) {
            lVar.n("cache_strategy_banner", sVar3.n());
        }
        s sVar4 = x;
        if (sVar4 != null) {
            lVar.n("cache_strategy_feed", sVar4.n());
        }
        s sVar5 = fs;
        if (sVar5 != null) {
            lVar.n("cache_strategy_draw", sVar5.n());
        }
        s sVar6 = rv;
        if (sVar6 != null) {
            lVar.n("cache_strategy_stream", sVar6.n());
        }
        if (l != null) {
            com.byazt.ed.q.qg qgVar = new com.byazt.ed.q.qg();
            qgVar.q(l.n());
            qgVar.n();
        }
    }

    private static s s() {
        s sVar = s;
        return sVar == null ? new s(new JSONObject(), qg(7)) : sVar;
    }

    private static s q() {
        s sVar = q;
        return sVar == null ? new s(new JSONObject(), qg(8)) : sVar;
    }

    private static s l() {
        s sVar = w;
        return sVar == null ? new s(new JSONObject()) : sVar;
    }

    private static s w() {
        s sVar = x;
        return sVar == null ? new s(new JSONObject()) : sVar;
    }

    private static s x() {
        s sVar = fs;
        return sVar == null ? new s(new JSONObject()) : sVar;
    }

    private static s fs() {
        s sVar = rv;
        return sVar == null ? new s(new JSONObject()) : sVar;
    }

    public static s n() {
        if (l == null) {
            String strK = com.byazt.ed.q.n().k();
            try {
                if (TextUtils.isEmpty(strK)) {
                    s sVar = new s(new JSONObject());
                    l = sVar;
                    sVar.q = 0;
                } else {
                    l = new s(new JSONObject(strK));
                }
            } catch (JSONException unused) {
            }
        }
        return l;
    }

    public static s n(int i) {
        switch (i) {
            case 1:
                return l();
            case 2:
            default:
                return tj;
            case 3:
            case 4:
                return n();
            case 5:
                return w();
            case 6:
                return fs();
            case 7:
                return s();
            case 8:
                return q();
            case 9:
                return x();
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 1588})
    public static class s {
        public int cp;
        public double cy;
        public int d;
        public int fs;
        public w hd;
        public boolean k;
        public int l;
        public int n;
        public int oa;
        public int q;
        public int qg;
        public l rv;
        public int s;
        public int sz;
        public n tj;
        public boolean w;
        public int x;

        public s(JSONObject jSONObject) {
            this(jSONObject, fs.n);
        }

        public s(JSONObject jSONObject, q qVar) {
            this.n = 1;
            this.qg = 1;
            this.s = -1;
            this.q = 0;
            this.l = 10000;
            this.w = false;
            this.x = -1;
            this.fs = 0;
            this.cp = 1;
            this.d = 0;
            this.oa = 0;
            this.sz = 0;
            this.k = true;
            this.cy = 0.0d;
            qVar = qVar == null ? fs.n : qVar;
            this.n = qVar.n;
            this.qg = qVar.qg;
            this.s = qVar.s;
            this.q = qVar.q;
            this.l = qVar.l;
            this.w = qVar.w;
            this.x = qVar.x;
            this.fs = qVar.fs;
            this.cp = qVar.rv;
            if (jSONObject != null) {
                this.n = jSONObject.optInt("get_type", qVar.n);
                this.qg = jSONObject.optInt("max_count", qVar.qg);
                this.s = jSONObject.optInt("strategy_type", qVar.s);
                this.q = jSONObject.optInt("store_type", qVar.q);
                this.l = jSONObject.optInt("online_timeout", qVar.l);
                this.w = jSONObject.optBoolean("enable", qVar.w);
                this.x = jSONObject.optInt("load_type", qVar.x);
                this.fs = jSONObject.optInt("trans_cache", qVar.fs);
                this.cp = jSONObject.optInt("ad_count_max", qVar.rv);
                this.d = jSONObject.optInt("libra_group", 0);
                this.oa = jSONObject.optInt("record_interval_minute", 0);
                this.sz = jSONObject.optInt("record_cache_minute", 0);
                this.rv = new l(jSONObject.optJSONObject("score_config"));
                this.tj = new n(jSONObject.optJSONObject("control_el"));
                this.k = jSONObject.optBoolean("is_filter_version", true);
                this.cy = jSONObject.optDouble("cache_available_percent", 0.0d);
                this.hd = new w(jSONObject.optJSONObject("tmax_config"), qVar.tj);
                return;
            }
            this.hd = new w(null, qVar.tj);
        }

        public String n() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("get_type", this.n);
                jSONObject.put("max_count", this.qg);
                jSONObject.put("strategy_type", this.s);
                jSONObject.put("store_type", this.q);
                jSONObject.put("online_timeout", this.l);
                jSONObject.put("enable", this.w);
                jSONObject.put("is_filter_version", this.k);
                jSONObject.put("load_type", this.x);
                jSONObject.put("trans_cache", this.fs);
                jSONObject.put("score_config", this.rv.n());
                jSONObject.put("control_el", this.tj.n());
                jSONObject.put("ad_count_max", this.cp);
                jSONObject.put("libra_group", this.d);
                jSONObject.put("record_interval_minute", this.oa);
                jSONObject.put("record_cache_minute", this.sz);
                jSONObject.put("cache_available_percent", this.cy);
                w wVar = this.hd;
                jSONObject.put("tmax_config", wVar == null ? null : wVar.n());
            } catch (Exception unused) {
            }
            return jSONObject.toString();
        }

        public int qg() {
            return this.n;
        }

        public int s() {
            if (this.qg <= 0) {
                this.qg = 1;
            }
            return this.qg;
        }

        public int q() {
            return this.s;
        }

        public int l() {
            return this.q;
        }

        public int w() {
            return this.l;
        }

        public boolean x() {
            return this.w;
        }

        public boolean fs() {
            return this.k;
        }

        public int rv() {
            return this.x;
        }

        public int tj() {
            return this.fs;
        }

        public l cp() {
            return this.rv;
        }

        public boolean n(String str, qg qgVar) {
            if (this.tj == null) {
                return false;
            }
            System.currentTimeMillis();
            boolean zN = this.tj.n(str, qgVar);
            System.currentTimeMillis();
            return zN;
        }

        public int d() {
            return Math.max(this.cp, 1);
        }

        public int oa() {
            return this.d;
        }

        public int sz() {
            return this.oa;
        }

        public int k() {
            return this.sz;
        }

        public double cy() {
            double d = this.cy;
            if (d >= 0.0d && d <= 1.0d) {
                return d;
            }
            return 0.0d;
        }

        public w hd() {
            return this.hd;
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 124})
    public static class w {
        public float a;
        public int bb;
        public float cd;
        public float cp;
        public float cy;
        public float d;
        public long fs;
        public boolean h;
        public float hd;
        public float hu;
        public float k;
        public int l;
        public int ln;
        public boolean m;
        public boolean n;
        public float oa;
        public float ou;
        public float py;
        public int q;
        public long qg;
        public float rv;
        public long s;
        public float sz;
        public int t;
        public float tj;
        public float um;
        public boolean ur;
        public int w;
        public float wm;
        public int x;

        public w(JSONObject jSONObject, boolean z) {
            if (jSONObject != null) {
                this.n = jSONObject.optBoolean("tmax_enable", z);
                this.qg = jSONObject.optLong("tmax_max_limit", 0L);
                this.s = jSONObject.optLong("tmax_min_limit", 0L);
                this.q = jSONObject.optInt("tmax_calc_type", 0);
                this.l = jSONObject.optInt("tmax_calc_min_count_limit", 30);
                this.w = jSONObject.optInt("tmax_calc_max_count_limit", 500);
                this.x = jSONObject.optInt("tmax_cache_expire", 600);
                this.fs = jSONObject.optLong("tmax_starting_point", 0L);
                this.rv = (float) jSONObject.optDouble("tmax_calc_percent_low", 0.5d);
                this.tj = (float) jSONObject.optDouble("tmax_calc_percent_medium", 0.8999999761581421d);
                this.cp = (float) jSONObject.optDouble("tmax_calc_percent_high", 0.949999988079071d);
                this.d = (float) jSONObject.optDouble("tmax_calc_boundary_pct", 0.9800000190734863d);
                this.oa = (float) jSONObject.optDouble("tmax_calc_shown_pct_low", 0.8999999761581421d);
                this.sz = (float) jSONObject.optDouble("tmax_calc_shown_pct_medium", 0.949999988079071d);
                this.k = (float) jSONObject.optDouble("tmax_calc_shown_pct_high", 0.9900000095367432d);
                this.cy = (float) jSONObject.optDouble("tmax_calc_hard_cap_pct", 0.9950000047683716d);
                this.hd = (float) jSONObject.optDouble("tmax_deviation_ratio", 0.30000001192092896d);
                this.cd = (float) jSONObject.optDouble("tmax_marginal_load_rate", 0.05000000074505806d);
                this.um = (float) jSONObject.optDouble("tmax_utilization_rate", 0.30000001192092896d);
                this.a = (float) jSONObject.optDouble("tmax_too_small_load_success_rate_low", 0.8999999761581421d);
                this.py = (float) jSONObject.optDouble("tmax_too_small_load_success_rate_high", 0.949999988079071d);
                this.ou = (float) jSONObject.optDouble("tmax_too_small_marginal_load_rate", 0.15000000596046448d);
                this.wm = (float) jSONObject.optDouble("tmax_too_small_deviation_ratio", -0.10000000149011612d);
                this.m = jSONObject.optBoolean("tmax_price_condition_enable", false);
                this.hu = (float) jSONObject.optDouble("tmax_cache_price_condition_shown_rate", 0.009999999776482582d);
                this.h = jSONObject.optBoolean("tmax_cached_callback", false);
                this.t = jSONObject.optInt("tmax_cache_callback_show_rate", 95);
                this.ur = jSONObject.optBoolean("tmax_slow_net_backup", false);
                this.bb = jSONObject.optInt("tmax_slow_net_duration", 95);
                this.ln = jSONObject.optInt("tmax_slow_net_show_ratio", 2);
            } else {
                this.n = z;
                this.qg = 0L;
                this.s = 0L;
                this.q = 0;
                this.l = 30;
                this.w = 500;
                this.x = 600;
                this.fs = 0L;
                this.rv = 0.5f;
                this.tj = 0.9f;
                this.cp = 0.95f;
                this.d = 0.98f;
                this.oa = 0.9f;
                this.sz = 0.95f;
                this.k = 0.99f;
                this.cy = 0.995f;
                this.hd = 0.3f;
                this.cd = 0.05f;
                this.um = 0.3f;
                this.a = 0.9f;
                this.py = 0.95f;
                this.ou = 0.15f;
                this.wm = -0.1f;
                this.m = false;
                this.hu = 0.01f;
                this.h = false;
                this.t = 95;
                this.ur = false;
                this.bb = 95;
                this.ln = 2;
            }
            if (this.qg < 0) {
                this.qg = 0L;
            }
            if (this.s < 0) {
                this.s = 0L;
            }
            if (this.fs < 0) {
                this.fs = 0L;
            }
            int i = this.q;
            if (i != 0 && i != 1) {
                this.q = 0;
            }
            float f = this.hu;
            if (f <= 0.0f || f > 1.0f) {
                this.hu = 0.01f;
            }
            int i2 = this.t;
            if (i2 <= 0 || i2 > 100) {
                this.t = 95;
            }
            int i3 = this.bb;
            if (i3 <= 0 || i3 > 100) {
                this.bb = 95;
            }
            int i4 = this.ln;
            if (i4 < 0 || i4 > 100) {
                this.ln = 2;
            }
        }

        public JSONObject n() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("tmax_enable", this.n);
                jSONObject.put("tmax_max_limit", this.qg);
                jSONObject.put("tmax_min_limit", this.s);
                jSONObject.put("tmax_calc_type", this.q);
                jSONObject.put("tmax_calc_min_count_limit", this.l);
                jSONObject.put("tmax_calc_max_count_limit", this.w);
                jSONObject.put("tmax_cache_expire", this.x);
                jSONObject.put("tmax_starting_point", this.fs);
                jSONObject.put("tmax_calc_percent_low", this.rv);
                jSONObject.put("tmax_calc_percent_medium", this.tj);
                jSONObject.put("tmax_calc_percent_high", this.cp);
                jSONObject.put("tmax_calc_boundary_pct", this.d);
                jSONObject.put("tmax_calc_shown_pct_low", this.oa);
                jSONObject.put("tmax_calc_shown_pct_medium", this.sz);
                jSONObject.put("tmax_calc_shown_pct_high", this.k);
                jSONObject.put("tmax_calc_hard_cap_pct", this.cy);
                jSONObject.put("tmax_deviation_ratio", this.hd);
                jSONObject.put("tmax_marginal_load_rate", this.cd);
                jSONObject.put("tmax_utilization_rate", this.um);
                jSONObject.put("tmax_too_small_load_success_rate_low", this.a);
                jSONObject.put("tmax_too_small_load_success_rate_high", this.py);
                jSONObject.put("tmax_too_small_marginal_load_rate", this.ou);
                jSONObject.put("tmax_too_small_deviation_ratio", this.wm);
                jSONObject.put("tmax_price_condition_enable", this.m);
                jSONObject.put("tmax_cache_price_condition_shown_rate", this.hu);
                jSONObject.put("tmax_cached_callback", this.h);
                jSONObject.put("tmax_cache_callback_show_rate", this.t);
                jSONObject.put("tmax_slow_net_backup", this.ur);
                jSONObject.put("tmax_slow_net_duration", this.bb);
                jSONObject.put("tmax_slow_net_show_ratio", this.ln);
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public boolean n(int i) {
            return this.n && com.byazt.ivn.s.n().n(i);
        }

        public long qg() {
            return this.qg;
        }

        public long s() {
            return this.s;
        }

        public int q() {
            return this.q;
        }

        public int l() {
            return this.l;
        }

        public int w() {
            int i = this.w;
            if (i <= 0) {
                return 500;
            }
            return i;
        }

        public int x() {
            return this.x;
        }

        public long fs() {
            return this.fs;
        }

        public float rv() {
            return this.tj;
        }

        public float tj() {
            return this.d;
        }

        public float cp() {
            return this.oa;
        }

        public float d() {
            return this.k;
        }

        public float oa() {
            return this.cy;
        }

        public float sz() {
            return this.hd;
        }

        public float k() {
            return this.cd;
        }

        public float cy() {
            return this.um;
        }

        public float hd() {
            return this.a;
        }

        public float cd() {
            return this.py;
        }

        public float um() {
            return this.ou;
        }

        public float a() {
            return this.wm;
        }

        public boolean py() {
            return this.h;
        }

        public int ou() {
            return this.t;
        }

        public boolean wm() {
            return this.ur;
        }

        public int m() {
            return this.bb;
        }

        public int hu() {
            return this.ln;
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, MediaPlayer.MEDIA_PLAYER_OPTION_SET_MAX_FPS})
    public static class l {
        public int l;
        public int n;
        public int q;
        public int qg;
        public int s;
        public LinkedHashMap<Integer, Integer> w;

        public l(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.n = jSONObject.optInt("device_score_threshold", 0);
                this.qg = jSONObject.optInt("net_type_threshold", 0);
                this.s = jSONObject.optInt("base_score", 60);
                this.q = jSONObject.optInt("score_threshold", 60);
                this.l = jSONObject.optInt("backup_score_threshold", 0);
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
                this.w = linkedHashMap;
            }
        }

        public JSONObject n() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("device_score_threshold", this.n);
                jSONObject.put("net_type_threshold", this.qg);
                jSONObject.put("base_score", this.s);
                jSONObject.put("score_threshold", this.q);
                jSONObject.put("backup_score_threshold", this.l);
                JSONArray jSONArray = new JSONArray();
                LinkedHashMap<Integer, Integer> linkedHashMap = this.w;
                if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
                    for (Integer num : this.w.keySet()) {
                        JSONArray jSONArray2 = new JSONArray();
                        jSONArray2.put(num);
                        jSONArray2.put(this.w.get(num));
                        jSONArray.put(jSONArray2);
                    }
                }
                jSONObject.put("last_cache_score", jSONArray);
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public int qg() {
            return this.n;
        }

        public int s() {
            return this.qg;
        }

        public int q() {
            return this.q;
        }

        public int l() {
            return this.l;
        }

        public LinkedHashMap<Integer, Integer> w() {
            return this.w;
        }

        public int x() {
            return this.s;
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO})
    public static class n {
        public String fs;
        public String l;
        public JSONObject n;
        public String q;
        public String qg;
        public String rv;
        public String s;
        public String tj;
        public String w;
        public String x;

        public n(JSONObject jSONObject) {
            this.n = jSONObject;
            if (jSONObject != null) {
                this.qg = jSONObject.optString("mix_ad");
                this.s = jSONObject.optString("disable_trans_cache");
                this.q = jSONObject.optString("delete_on_load");
                this.l = jSONObject.optString("load_only_online");
                this.w = jSONObject.optString("forbid_save_cache");
                this.rv = jSONObject.optString("forbid_read_cache");
                this.x = jSONObject.optString("forbid_realtime_use_cache");
                this.fs = jSONObject.optString("forbid_realtime");
                this.tj = jSONObject.optString("forbid_preload");
            }
        }

        public JSONObject n() {
            return this.n;
        }

        /* JADX WARN: Code duplicated, block: B:63:0x00b1  */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        private boolean qg(String str, qg qgVar) {
            String str2;
            str.hashCode();
            boolean z = true;
            byte b = -1;
            switch (str.hashCode()) {
                case -1085434702:
                    if (str.equals("delete_on_load")) {
                        b = 0;
                    }
                    break;
                case -1073750810:
                    if (str.equals("mix_ad")) {
                        b = 1;
                    }
                    break;
                case -883700652:
                    if (str.equals("disable_trans_cache")) {
                        b = 2;
                    }
                    break;
                case -707542069:
                    if (str.equals("forbid_save_cache")) {
                        b = 3;
                    }
                    break;
                case -91260031:
                    if (str.equals("forbid_realtime_use_cache")) {
                        b = 4;
                    }
                    break;
                case 899503542:
                    if (str.equals("forbid_realtime")) {
                        b = 5;
                    }
                    break;
                case 1290851437:
                    if (str.equals("load_only_online")) {
                        b = 6;
                    }
                    break;
                case 1816465502:
                    if (str.equals("forbid_preload")) {
                        b = 7;
                    }
                    break;
                case 2017273124:
                    if (str.equals("forbid_read_cache")) {
                        b = 8;
                    }
                    break;
            }
            String strN = null;
            switch (b) {
                case 0:
                    str2 = this.q;
                    break;
                case 1:
                    str2 = !TextUtils.isEmpty(this.qg) ? this.qg : "${(meta.group_info.group_id != null) || (meta.insert_ad_control == 1) || (meta.refresh_ad_control == 1) || (meta.force_refresh_ad_control == 1) || (meta.refresh_control == 1) || (meta.web_refresh_control == 1)}";
                    break;
                case 2:
                    str2 = this.s;
                    break;
                case 3:
                    str2 = this.w;
                    break;
                case 4:
                    str2 = this.x;
                    break;
                case 5:
                    str2 = this.fs;
                    break;
                case 6:
                    str2 = this.l;
                    break;
                case 7:
                    str2 = this.tj;
                    break;
                case 8:
                    str2 = this.rv;
                    break;
                default:
                    str2 = null;
                    break;
            }
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            if (str2 != null) {
                try {
                    if (!str2.contains("meta.")) {
                        z = false;
                    }
                    strN = com.byazt.mcb.qg.n(str2, n(qgVar, z));
                } catch (Exception unused) {
                }
            } else {
                z = false;
                strN = com.byazt.mcb.qg.n(str2, n(qgVar, z));
            }
            return TextUtils.equals(strN, "true");
        }

        private JSONObject n(qg qgVar, boolean z) {
            Object obj;
            int iS;
            com.byazt.zq.qg qgVar2 = null;
            if (qgVar != null) {
                com.byazt.zq.qg qgVarN = qgVar.n();
                Object objQg = z ? qgVar.qg() : null;
                iS = qgVar.s();
                obj = objQg;
                qgVar2 = qgVarN;
            } else {
                obj = null;
                iS = 0;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(TapEventParamConstants.PARAM_SUB_OS, "android");
                jSONObject2.put("sdk_version", com.byazt.nf.tj.l);
                jSONObject2.put(PluginConstants.KEY_PLUGIN_VERSION, 7814);
                jSONObject.put("device", jSONObject2);
                if (qgVar2 != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("adType", qgVar2.a());
                    jSONObject3.put("adCount", qgVar2.d());
                    jSONObject3.put("userData", com.byazt.vgx.x.n(qgVar2.ou()));
                    jSONObject.put("adSlot", jSONObject3);
                }
                if (obj != null) {
                    jSONObject.put("meta", obj);
                }
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("last_net_code", iS);
                jSONObject4.put("has_cache", qgVar != null && qgVar.q());
                JSONObject jSONObjectN = com.byazt.msp.s.n(qgVar2 != null ? qgVar2.a() : 0, qgVar2 == null ? "" : qgVar2.an());
                if (jSONObjectN != null) {
                    jSONObject4.put("ca_interval_info", jSONObjectN);
                }
                jSONObject.put(WebLoginFragment.QUERY_KEY_ID, jSONObject4);
                return jSONObject;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

        public boolean n(String str, qg qgVar) {
            return qg(str, qgVar);
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 1634})
    public static class qg {
        public boolean l;
        public com.byazt.zq.qg n;
        public int q;
        public JSONObject qg;
        public pk s;

        private qg(n nVar) {
            this.n = nVar.n;
            this.s = nVar.s;
            this.qg = nVar.qg;
            this.q = nVar.q;
            this.l = nVar.l;
        }

        public com.byazt.zq.qg n() {
            return this.n;
        }

        public JSONObject qg() {
            JSONObject jSONObject = this.qg;
            if (jSONObject != null) {
                return jSONObject;
            }
            pk pkVar = this.s;
            if (pkVar != null) {
                return pkVar.pv();
            }
            return null;
        }

        public int s() {
            return this.q;
        }

        public boolean q() {
            return this.l;
        }

        @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 2129})
        public static class n {
            public boolean l;
            public com.byazt.zq.qg n;
            public int q;
            public JSONObject qg;
            public pk s;

            public n n(com.byazt.zq.qg qgVar) {
                this.n = qgVar;
                return this;
            }

            public n n(JSONObject jSONObject) {
                this.qg = jSONObject;
                return this;
            }

            public n n(pk pkVar) {
                this.s = pkVar;
                return this;
            }

            public n n(int i) {
                this.q = i;
                return this;
            }

            public n n(boolean z) {
                this.l = z;
                return this;
            }

            public qg n() {
                return new qg(this);
            }
        }
    }
}
