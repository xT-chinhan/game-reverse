package com.byazt.ed;

import android.content.SharedPreferences;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 854, 5})
public class q {
    public volatile String cy;
    public String n;
    public volatile String w;
    public volatile String x;
    public volatile int s = -1;
    public volatile long q = -1;
    public volatile float l = -1.0f;
    public volatile int fs = -1;
    public volatile int rv = -1;
    public volatile int tj = -1;
    public volatile int cp = -1;
    public volatile int d = 0;
    public volatile int oa = -1;
    public volatile int sz = -1;
    public volatile int k = -1;
    public volatile com.byazt.gwu.l qg = com.byazt.lk.l.qg(com.byazt.vgx.s.q(), hd());

    private static String hd() {
        return "sp_exec_getad_config_bst";
    }

    @com.byazt.cp.n(n = {0, 1, 854, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME})
    private static class n {
        public static q n = new q();
    }

    public static q n() {
        return n.n;
    }

    public long qg() {
        if (this.q == -1) {
            this.q = n(MediationConstant.EXTRA_DURATION, 10000L);
        }
        return this.q;
    }

    public int s() {
        if (this.s == -1) {
            this.s = n("max", 50);
        }
        return this.s;
    }

    public float q() {
        if (this.l == -1.0f) {
            this.l = n("aggMultiple", -1.0f);
        }
        return this.l;
    }

    public String l() {
        if (this.w == null) {
            this.w = n("ab_test_version", "");
        }
        return this.w;
    }

    public String w() {
        if (this.x == null) {
            this.x = n("ab_test_param", "");
        }
        return this.x;
    }

    public void x() {
        this.x = "";
        this.w = "";
        this.qg.n("ab_test_version");
        this.qg.n("ab_test_param");
    }

    public boolean fs() {
        if (this.oa == -1) {
            this.oa = n("dl_storage_internal", 1);
        }
        return this.oa == 1;
    }

    public int rv() {
        if (this.sz == -1) {
            this.sz = n("cypher_version", 40001);
        }
        return this.sz;
    }

    public boolean tj() {
        return n("is_spl_cache_remove_change", false);
    }

    public int cp() {
        if (this.fs == -1) {
            this.fs = n("spl_cache_conf", 30);
        }
        return this.fs;
    }

    public int d() {
        if (this.tj == -1) {
            this.tj = n("spl_thread_conf", 1);
        }
        return this.tj;
    }

    public int oa() {
        if (this.cp == -1) {
            this.cp = n("spl_common_conf", 0);
        }
        return this.cp;
    }

    public int sz() {
        if (this.d <= 0) {
            this.d = n("splash_render_timeout_backup", 100);
        }
        return this.d;
    }

    public String k() {
        if (this.cy == null) {
            this.cy = n("cache_strategy_splash", "");
        }
        return this.cy;
    }

    public boolean n(String str, boolean z) {
        try {
            return this.qg.getBoolean(str, z);
        } catch (Throwable unused) {
            return z;
        }
    }

    public long n(String str, long j) {
        try {
            return this.qg.getLong(str, j);
        } catch (Throwable unused) {
            return j;
        }
    }

    public float n(String str, float f) {
        try {
            return this.qg.getFloat(str, f);
        } catch (Throwable unused) {
            return f;
        }
    }

    public int n(String str, int i) {
        try {
            return this.qg.getInt(str, i);
        } catch (Throwable unused) {
            return i;
        }
    }

    public String n(String str, String str2) {
        try {
            return this.qg.getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public void cy() {
        try {
            this.qg.n();
        } catch (Throwable unused) {
        }
    }

    @com.byazt.cp.n(n = {0, 1, 854, 524})
    public static class qg {
        public Map<String, Object> n = new HashMap();

        public qg n(long j) {
            if (q.n().q == j) {
                return this;
            }
            q.n().q = j;
            this.n.put(MediationConstant.EXTRA_DURATION, Long.valueOf(j));
            return this;
        }

        public qg n(int i) {
            if (q.n().s == i) {
                return this;
            }
            q.n().s = i;
            this.n.put("max", Integer.valueOf(i));
            return this;
        }

        public qg n(float f) {
            if (q.n().l == f) {
                return this;
            }
            q.n().l = f;
            this.n.put("aggMultiple", Float.valueOf(f));
            return this;
        }

        public qg n(String str) {
            if (str != null && str.equals(q.n().w)) {
                return this;
            }
            q.n().w = str;
            Map<String, Object> map = this.n;
            if (str == null) {
                str = "";
            }
            map.put("ab_test_version", str);
            return this;
        }

        public qg qg(String str) {
            if (str != null && str.equals(q.n().x)) {
                return this;
            }
            q.n().x = str;
            Map<String, Object> map = this.n;
            if (str == null) {
                str = "";
            }
            map.put("ab_test_param", str);
            return this;
        }

        public qg n(boolean z) {
            this.n.put("is_spl_cache_remove_change", Boolean.valueOf(z));
            return this;
        }

        public qg qg(int i) {
            if (q.n().sz == i) {
                return this;
            }
            q.n().sz = i;
            this.n.put("cypher_version", Integer.valueOf(i));
            return this;
        }

        public qg s(int i) {
            if (q.n().fs == i) {
                return this;
            }
            q.n().fs = i;
            this.n.put("spl_cache_conf", Integer.valueOf(i));
            return this;
        }

        public qg q(int i) {
            if (q.n().tj == i) {
                return this;
            }
            this.n.put("spl_thread_conf", Integer.valueOf(i));
            return this;
        }

        public qg l(int i) {
            if (q.n().cp == i) {
                return this;
            }
            q.n().cp = i;
            this.n.put("spl_common_conf", Integer.valueOf(i));
            return this;
        }

        public qg w(int i) {
            if (q.n().rv == i) {
                return this;
            }
            q.n().rv = i;
            this.n.put("spl_cache_expired", Integer.valueOf(i));
            return this;
        }

        public qg s(String str) {
            if (str != null && str.equals(q.n().n)) {
                return this;
            }
            q.n().n = str;
            Map<String, Object> map = this.n;
            if (str == null) {
                str = "";
            }
            map.put("drop_cache_black_conf", str);
            return this;
        }

        public qg n(JSONObject jSONObject) {
            int iOptInt;
            if (jSONObject == null || q.n().k == (iOptInt = jSONObject.optInt("splash_policy", 0))) {
                return this;
            }
            q.n().k = iOptInt;
            this.n.put("splash_policy", Integer.valueOf(iOptInt));
            return this;
        }

        public qg x(int i) {
            if (q.n().d == i) {
                return this;
            }
            q.n().d = i;
            this.n.put("splash_render_timeout_backup", Integer.valueOf(i));
            return this;
        }

        public qg fs(int i) {
            if (q.n().oa == i) {
                return this;
            }
            q.n().oa = i;
            this.n.put("dl_storage_internal", Integer.valueOf(i));
            return this;
        }

        public qg q(String str) {
            if (str != null && str.equals(q.n().cy)) {
                return this;
            }
            q.n().cy = str;
            this.n.put("cache_strategy_splash", str);
            return this;
        }

        public void n() {
            try {
                com.byazt.gwu.l lVar = q.n().qg;
                SharedPreferences.Editor editorEdit = lVar.edit();
                if (editorEdit == null) {
                    for (Map.Entry<String, Object> entry : this.n.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (value instanceof Boolean) {
                            lVar.n(key, ((Boolean) value).booleanValue());
                        } else if (value instanceof Long) {
                            lVar.n(key, ((Long) value).longValue());
                        } else if (value instanceof Float) {
                            lVar.n(key, ((Float) value).floatValue());
                        } else if (value instanceof Integer) {
                            lVar.n(key, ((Integer) value).intValue());
                        } else if (value instanceof String) {
                            lVar.n(key, (String) value);
                        }
                    }
                    return;
                }
                for (Map.Entry<String, Object> entry2 : this.n.entrySet()) {
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
                editorEdit.commit();
            } catch (Exception unused) {
            }
        }
    }
}
