package com.byazt.tz;

import android.content.SharedPreferences;
import com.byazt.nf.rv;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1894, 19})
public class n {
    public volatile SharedPreferences q;
    public volatile int n = -1;
    public volatile int qg = -1;
    public volatile int s = -1;

    public SharedPreferences n() {
        if (this.q == null) {
            this.q = com.byazt.qyu.qg.qg(rv.getContext(), "sp_ad_common_config", 0);
        }
        return this.q;
    }

    @com.byazt.cp.n(n = {0, 1, 1894, 226})
    private static class qg {
        public static n n = new n();
    }

    public static n qg() {
        return qg.n;
    }

    public int s() {
        if (this.n == -1) {
            this.n = n("store_isolate_conf", 3);
        }
        return this.n;
    }

    public int q() {
        if (this.qg == -1) {
            return 1;
        }
        return this.qg;
    }

    public int l() {
        if (this.qg == -1) {
            this.qg = n("is_kv_cache_type", 1);
        }
        return this.qg;
    }

    public int w() {
        if (this.s == -1) {
            this.s = n("kv_init_type", 0);
        }
        return this.s;
    }

    public int n(String str, int i) {
        try {
            if (com.byazt.ed.qg.n().qg()) {
                return com.byazt.jz.qg.n("sp_ad_common_config", str, i);
            }
            return n().getInt(str, i);
        } catch (Throwable unused) {
            return i;
        }
    }

    /* JADX INFO: renamed from: com.byazt.tz.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 1894, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    public static class C0359n {
        public Map<String, Object> n = new HashMap();

        public C0359n n(int i) {
            if (n.qg().n == i) {
                return this;
            }
            n.qg().n = i;
            this.n.put("store_isolate_conf", Integer.valueOf(i));
            return this;
        }

        public C0359n qg(int i) {
            if (n.qg().qg == i) {
                return this;
            }
            n.qg().qg = i;
            this.n.put("is_kv_cache_type", Integer.valueOf(i));
            return this;
        }

        public C0359n s(int i) {
            if (n.qg().s == i) {
                return this;
            }
            n.qg().s = i;
            this.n.put("kv_init_type", Integer.valueOf(i));
            return this;
        }

        public void n() {
            try {
                if (com.byazt.ed.qg.n().qg()) {
                    for (Map.Entry<String, Object> entry : this.n.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (value instanceof Boolean) {
                            com.byazt.jz.qg.n("sp_ad_common_config", key, (Boolean) value);
                        } else if (value instanceof Long) {
                            com.byazt.jz.qg.n("sp_ad_common_config", key, (Long) value);
                        } else if (value instanceof Float) {
                            com.byazt.jz.qg.n("sp_ad_common_config", key, (Float) value);
                        } else if (value instanceof Integer) {
                            com.byazt.jz.qg.n("sp_ad_common_config", key, (Integer) value);
                        } else if (value instanceof String) {
                            com.byazt.jz.qg.n("sp_ad_common_config", key, (String) value);
                        }
                    }
                    return;
                }
                SharedPreferences.Editor editorEdit = n.qg().n().edit();
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
                editorEdit.apply();
            } catch (Exception unused) {
            }
        }
    }
}
