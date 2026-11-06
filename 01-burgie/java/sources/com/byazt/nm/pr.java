package com.byazt.nm;

import android.content.SharedPreferences;
import com.byazt.mp.hn;
import com.byazt.sd.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mar.sdk.MARCode;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 780, 37})
public class pr {
    public volatile int pr = -1;
    public volatile SharedPreferences hw = com.byazt.mg.hw.hw(a.getContext(), "sp_ad_common_config", 0);

    @com.byazt.vzx.pr(pr = {0, 1, 780, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE})
    private static class hw {
        public static pr pr = new pr();
    }

    public static pr pr() {
        return hw.pr;
    }

    public int hw() {
        if (this.pr == -1) {
            this.pr = pr("store_isolate_conf", 3);
        }
        return this.pr;
    }

    public int pr(String str, int i) {
        try {
            if (hn.pr().hw()) {
                return com.byazt.jc.hw.pr("sp_ad_common_config", str, i);
            }
            return this.hw.getInt(str, i);
        } catch (Throwable th) {
            return i;
        }
    }

    /* JADX INFO: renamed from: com.byazt.nm.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 780, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    public static class C0142pr {
        public Map<String, Object> pr = new HashMap();

        public C0142pr pr(int i) {
            if (pr.pr().pr == i) {
                return this;
            }
            pr.pr().pr = i;
            this.pr.put("store_isolate_conf", Integer.valueOf(i));
            return this;
        }

        public void pr() {
            try {
                if (!hn.pr().hw()) {
                    SharedPreferences.Editor editorEdit = pr.pr().hw.edit();
                    for (Map.Entry<String, Object> entry : this.pr.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (value instanceof Boolean) {
                            editorEdit.putBoolean(key, ((Boolean) value).booleanValue());
                        } else if (value instanceof Long) {
                            editorEdit.putLong(key, ((Long) value).longValue());
                        } else if (value instanceof Float) {
                            editorEdit.putFloat(key, ((Float) value).floatValue());
                        } else if (value instanceof Integer) {
                            editorEdit.putInt(key, ((Integer) value).intValue());
                        } else if (value instanceof String) {
                            editorEdit.putString(key, (String) value);
                        }
                    }
                    editorEdit.apply();
                    return;
                }
                for (Map.Entry<String, Object> entry2 : this.pr.entrySet()) {
                    String key2 = entry2.getKey();
                    Object value2 = entry2.getValue();
                    if (value2 instanceof Boolean) {
                        com.byazt.jc.hw.pr("sp_ad_common_config", key2, (Boolean) value2);
                    } else if (value2 instanceof Long) {
                        com.byazt.jc.hw.pr("sp_ad_common_config", key2, (Long) value2);
                    } else if (value2 instanceof Float) {
                        com.byazt.jc.hw.pr("sp_ad_common_config", key2, (Float) value2);
                    } else if (value2 instanceof Integer) {
                        com.byazt.jc.hw.pr("sp_ad_common_config", key2, (Integer) value2);
                    } else if (value2 instanceof String) {
                        com.byazt.jc.hw.pr("sp_ad_common_config", key2, (String) value2);
                    }
                }
            } catch (Exception e) {
            }
        }
    }
}
