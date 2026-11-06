package com.byazt.mp;

import android.content.SharedPreferences;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 168, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public volatile String fw;
    public volatile String nt;
    public String pr;
    public volatile String uc;
    public volatile int hn = -1;
    public volatile long x = -1;
    public volatile float c = -1.0f;
    public volatile int zo = -1;
    public volatile int aj = -1;
    public volatile int vk = -1;
    public volatile int w = -1;
    public volatile int k = 0;
    public volatile int m = -1;
    public volatile int g = -1;
    public volatile int ho = -1;
    public volatile com.byazt.zq.c hw = com.byazt.qn.x.hw(com.byazt.zb.pr.x(), yb());

    @com.byazt.vzx.pr(pr = {0, 1, 168, 169})
    private static class pr {
        public static c pr = new c();
    }

    public static c pr() {
        return pr.pr;
    }

    private static String yb() {
        return "sp_exec_getad_config_bst";
    }

    public long hw() {
        if (this.x == -1) {
            this.x = pr("duration", ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
        }
        return this.x;
    }

    public int hn() {
        if (this.hn == -1) {
            this.hn = pr("max", 50);
        }
        return this.hn;
    }

    public float x() {
        if (this.c == -1.0f) {
            this.c = pr("aggMultiple", -1.0f);
        }
        return this.c;
    }

    public String c() {
        if (this.uc == null) {
            this.uc = pr("ab_test_version", "");
        }
        return this.uc;
    }

    public String uc() {
        if (this.fw == null) {
            this.fw = pr("ab_test_param", "");
        }
        return this.fw;
    }

    public void fw() {
        this.fw = "";
        this.uc = "";
        this.hw.pr("ab_test_version");
        this.hw.pr("ab_test_param");
    }

    public boolean zo() {
        if (this.m == -1) {
            this.m = pr("dl_storage_internal", 1);
        }
        return this.m == 1;
    }

    public int aj() {
        if (this.g == -1) {
            this.g = pr("cypher_version", 40001);
        }
        return this.g;
    }

    public boolean vk() {
        return pr("is_spl_cache_remove_change", false);
    }

    public int w() {
        if (this.zo == -1) {
            this.zo = pr("spl_cache_conf", 30);
        }
        return this.zo;
    }

    public int k() {
        if (this.vk == -1) {
            this.vk = pr("spl_thread_conf", 1);
        }
        return this.vk;
    }

    public int m() {
        if (this.w == -1) {
            this.w = pr("spl_common_conf", 0);
        }
        return this.w;
    }

    public int g() {
        if (this.k <= 0) {
            this.k = pr("splash_render_timeout_backup", 100);
        }
        return this.k;
    }

    public String ho() {
        if (this.nt == null) {
            this.nt = pr("cache_strategy_splash", "");
        }
        return this.nt;
    }

    public boolean pr(String str, boolean z) {
        try {
            return this.hw.getBoolean(str, z);
        } catch (Throwable th) {
            return z;
        }
    }

    public long pr(String str, long j) {
        try {
            return this.hw.getLong(str, j);
        } catch (Throwable th) {
            return j;
        }
    }

    public float pr(String str, float f) {
        try {
            return this.hw.getFloat(str, f);
        } catch (Throwable th) {
            return f;
        }
    }

    public int pr(String str, int i) {
        try {
            return this.hw.getInt(str, i);
        } catch (Throwable th) {
            return i;
        }
    }

    public String pr(String str, String str2) {
        try {
            return this.hw.getString(str, str2);
        } catch (Throwable th) {
            return str2;
        }
    }

    public void nt() {
        try {
            this.hw.pr();
        } catch (Throwable th) {
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 168, 401})
    public static class hw {
        public Map<String, Object> pr = new HashMap();

        public hw pr(long j) {
            if (c.pr().x != j) {
                c.pr().x = j;
                this.pr.put("duration", Long.valueOf(j));
                return this;
            }
            return this;
        }

        public hw pr(int i) {
            if (c.pr().hn != i) {
                c.pr().hn = i;
                this.pr.put("max", Integer.valueOf(i));
                return this;
            }
            return this;
        }

        public hw pr(float f) {
            if (c.pr().c != f) {
                c.pr().c = f;
                this.pr.put("aggMultiple", Float.valueOf(f));
                return this;
            }
            return this;
        }

        public hw pr(String str) {
            if (str == null || !str.equals(c.pr().uc)) {
                c.pr().uc = str;
                Map<String, Object> map = this.pr;
                if (str == null) {
                    str = "";
                }
                map.put("ab_test_version", str);
                return this;
            }
            return this;
        }

        public hw hw(String str) {
            if (str == null || !str.equals(c.pr().fw)) {
                c.pr().fw = str;
                Map<String, Object> map = this.pr;
                if (str == null) {
                    str = "";
                }
                map.put("ab_test_param", str);
                return this;
            }
            return this;
        }

        public hw pr(boolean z) {
            this.pr.put("is_spl_cache_remove_change", Boolean.valueOf(z));
            return this;
        }

        public hw hw(int i) {
            if (c.pr().g != i) {
                c.pr().g = i;
                this.pr.put("cypher_version", Integer.valueOf(i));
                return this;
            }
            return this;
        }

        public hw hn(int i) {
            if (c.pr().zo != i) {
                c.pr().zo = i;
                this.pr.put("spl_cache_conf", Integer.valueOf(i));
                return this;
            }
            return this;
        }

        public hw x(int i) {
            if (c.pr().vk == i) {
                return this;
            }
            this.pr.put("spl_thread_conf", Integer.valueOf(i));
            return this;
        }

        public hw c(int i) {
            if (c.pr().w != i) {
                c.pr().w = i;
                this.pr.put("spl_common_conf", Integer.valueOf(i));
                return this;
            }
            return this;
        }

        public hw uc(int i) {
            if (c.pr().aj != i) {
                c.pr().aj = i;
                this.pr.put("spl_cache_expired", Integer.valueOf(i));
                return this;
            }
            return this;
        }

        public hw hn(String str) {
            if (str != null && str.equals(c.pr().pr)) {
                return this;
            }
            c.pr().pr = str;
            Map<String, Object> map = this.pr;
            if (str == null) {
                str = "";
            }
            map.put("drop_cache_black_conf", str);
            return this;
        }

        public hw pr(JSONObject jSONObject) {
            int iOptInt;
            if (jSONObject != null && c.pr().ho != (iOptInt = jSONObject.optInt("splash_policy", 0))) {
                c.pr().ho = iOptInt;
                this.pr.put("splash_policy", Integer.valueOf(iOptInt));
                return this;
            }
            return this;
        }

        public hw fw(int i) {
            if (c.pr().k != i) {
                c.pr().k = i;
                this.pr.put("splash_render_timeout_backup", Integer.valueOf(i));
                return this;
            }
            return this;
        }

        public hw zo(int i) {
            if (c.pr().m != i) {
                c.pr().m = i;
                this.pr.put("dl_storage_internal", Integer.valueOf(i));
                return this;
            }
            return this;
        }

        public hw x(String str) {
            if (str == null || !str.equals(c.pr().nt)) {
                c.pr().nt = str;
                this.pr.put("cache_strategy_splash", str);
                return this;
            }
            return this;
        }

        public void pr() {
            try {
                com.byazt.zq.c cVar = c.pr().hw;
                SharedPreferences.Editor editorEdit = cVar.edit();
                if (editorEdit == null) {
                    for (Map.Entry<String, Object> entry : this.pr.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (value instanceof Boolean) {
                            cVar.pr(key, ((Boolean) value).booleanValue());
                        } else if (value instanceof Long) {
                            cVar.pr(key, ((Long) value).longValue());
                        } else if (value instanceof Float) {
                            cVar.pr(key, ((Float) value).floatValue());
                        } else if (value instanceof Integer) {
                            cVar.pr(key, ((Integer) value).intValue());
                        } else if (value instanceof String) {
                            cVar.pr(key, (String) value);
                        }
                    }
                    return;
                }
                for (Map.Entry<String, Object> entry2 : this.pr.entrySet()) {
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
            } catch (Exception e) {
            }
        }
    }
}
