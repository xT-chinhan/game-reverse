package com.byazt.ca;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.an;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ANSWER_RECV_TIME, 213})
public class cz {
    public static volatile cz hw;
    public Map<Integer, Map<String, Object>> c;
    public pr pr;
    public Map<Integer, JSONObject> hn = new ConcurrentHashMap(1);
    public boolean x = false;

    public interface pr {
        void pr(int i, Map<String, Object> map);
    }

    public static cz pr() {
        if (hw == null) {
            synchronized (cz.class) {
                if (hw == null) {
                    hw = new cz();
                }
            }
        }
        return hw;
    }

    public void pr(int i, int i2) {
        if (i == 0) {
            return;
        }
        try {
            JSONObject jSONObject = this.hn.get(Integer.valueOf(i));
            if (jSONObject == null) {
                jSONObject = new JSONObject();
                this.hn.put(Integer.valueOf(i), jSONObject);
            }
            jSONObject.put("click_calculation_type", i2);
            jSONObject.put("click_calculation_time", System.currentTimeMillis());
        } catch (Exception e) {
        }
    }

    public JSONObject pr(int i) {
        Map<Integer, JSONObject> map;
        if (i == 0 || (map = this.hn) == null) {
            return null;
        }
        return map.get(Integer.valueOf(i));
    }

    public void hw(int i) {
        if (i == 0) {
            return;
        }
        try {
            Map<Integer, JSONObject> map = this.hn;
            if (map != null) {
                if (map.size() > 20) {
                    this.hn.clear();
                } else {
                    this.hn.remove(Integer.valueOf(i));
                }
            }
        } catch (Throwable th) {
        }
    }

    public void pr(boolean z) {
        this.x = z;
        if (z && this.c == null) {
            this.c = new ConcurrentHashMap();
        }
    }

    public void pr(int i, int i2, float[] fArr) {
        if (!this.x || i == 0 || this.pr == null) {
            return;
        }
        try {
            Map<String, Object> map = this.c.get(Integer.valueOf(i));
            if (map == null) {
                return;
            }
            HashMap map2 = new HashMap(map);
            map2.put("hashcode", Integer.valueOf(i));
            map2.put("type", Integer.valueOf(i2));
            if (i2 == 1) {
                map2.put("x", Float.valueOf(fArr[0]));
                map2.put("y", Float.valueOf(fArr[1]));
                map2.put(an.aD, Float.valueOf(fArr[2]));
            } else {
                map2.put("x", Double.valueOf(Math.toDegrees(fArr[0])));
                map2.put("y", Double.valueOf(Math.toDegrees(fArr[1])));
                map2.put(an.aD, Double.valueOf(Math.toDegrees(fArr[2])));
            }
            this.pr.pr(i, map2);
        } catch (Exception e) {
        }
    }

    public void pr(int i, String str, Object obj) {
        if (!this.x || i == 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Map<String, Object> concurrentHashMap = this.c.get(Integer.valueOf(i));
            if (concurrentHashMap == null) {
                concurrentHashMap = new ConcurrentHashMap<>();
                this.c.put(Integer.valueOf(i), concurrentHashMap);
            }
            concurrentHashMap.put(str, obj);
        } catch (Throwable th) {
        }
    }

    public void hn(int i) {
        if (!this.x || i == 0) {
            return;
        }
        try {
            this.c.remove(Integer.valueOf(i));
        } catch (Throwable th) {
        }
    }

    public void pr(pr prVar) {
        this.pr = prVar;
    }
}
