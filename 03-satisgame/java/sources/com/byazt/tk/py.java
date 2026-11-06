package com.byazt.tk;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 350, 866})
public class py {
    public static volatile py qg;
    public Map<Integer, Map<String, Object>> l;
    public n n;
    public Map<Integer, JSONObject> s = new ConcurrentHashMap(1);
    public boolean q = false;

    public interface n {
        void n(int i, Map<String, Object> map);
    }

    public static py n() {
        if (qg == null) {
            synchronized (py.class) {
                if (qg == null) {
                    qg = new py();
                }
            }
        }
        return qg;
    }

    public void n(int i, int i2) {
        if (i == 0) {
            return;
        }
        try {
            JSONObject jSONObject = this.s.get(Integer.valueOf(i));
            if (jSONObject == null) {
                jSONObject = new JSONObject();
                this.s.put(Integer.valueOf(i), jSONObject);
            }
            jSONObject.put("click_calculation_type", i2);
            jSONObject.put("click_calculation_time", System.currentTimeMillis());
        } catch (Exception unused) {
        }
    }

    public JSONObject n(int i) {
        Map<Integer, JSONObject> map;
        if (i == 0 || (map = this.s) == null) {
            return null;
        }
        return map.get(Integer.valueOf(i));
    }

    public void qg(int i) {
        if (i == 0) {
            return;
        }
        try {
            Map<Integer, JSONObject> map = this.s;
            if (map != null) {
                if (map.size() > 20) {
                    this.s.clear();
                } else {
                    this.s.remove(Integer.valueOf(i));
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void n(boolean z) {
        this.q = z;
        if (z && this.l == null) {
            this.l = new ConcurrentHashMap();
        }
    }

    public void n(int i, int i2, float[] fArr) {
        if (!this.q || i == 0 || this.n == null) {
            return;
        }
        try {
            Map<String, Object> map = this.l.get(Integer.valueOf(i));
            if (map == null) {
                return;
            }
            HashMap map2 = new HashMap(map);
            map2.put("hashcode", Integer.valueOf(i));
            map2.put("type", Integer.valueOf(i2));
            if (i2 == 1) {
                map2.put(com.byazt.af.x.n, Float.valueOf(fArr[0]));
                map2.put("y", Float.valueOf(fArr[1]));
                map2.put("z", Float.valueOf(fArr[2]));
            } else {
                map2.put(com.byazt.af.x.n, Double.valueOf(Math.toDegrees(fArr[0])));
                map2.put("y", Double.valueOf(Math.toDegrees(fArr[1])));
                map2.put("z", Double.valueOf(Math.toDegrees(fArr[2])));
            }
            this.n.n(i, map2);
        } catch (Exception unused) {
        }
    }

    public void n(int i, String str, Object obj) {
        if (!this.q || i == 0 || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Map<String, Object> concurrentHashMap = this.l.get(Integer.valueOf(i));
            if (concurrentHashMap == null) {
                concurrentHashMap = new ConcurrentHashMap<>();
                this.l.put(Integer.valueOf(i), concurrentHashMap);
            }
            concurrentHashMap.put(str, obj);
        } catch (Throwable unused) {
        }
    }

    public void s(int i) {
        if (this.q && i != 0) {
            try {
                this.l.remove(Integer.valueOf(i));
            } catch (Throwable unused) {
            }
        }
    }

    public void n(n nVar) {
        this.n = nVar;
    }
}
