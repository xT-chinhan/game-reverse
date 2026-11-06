package com.bytedance.sdk.openadsdk.core.ah;

import android.content.SharedPreferences;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.re;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ka {
    private volatile String ab;
    private volatile String c;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public String f1973ms;
    private volatile int ah = -1;
    private volatile long d = -1;
    private volatile float ka = -1.0f;
    private volatile int x = -1;
    private volatile int ny = -1;
    private volatile int ch = -1;
    private volatile int hi = -1;
    private volatile int sl = 0;
    private volatile int zb = -1;
    private volatile int u = -1;
    private volatile int ub = -1;
    private volatile SharedPreferences xr = com.bytedance.sdk.openadsdk.api.plugin.xr.xr(re.getContext(), qv(), 0);

    /* JADX INFO: Access modifiers changed from: private */
    public static String qv() {
        return "sp_exec_getad_config_bst";
    }

    private static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private static ka f1974ms = new ka();
    }

    public static ka ms() {
        return ms.f1974ms;
    }

    public long xr() {
        if (this.d == -1) {
            this.d = ms("duration", ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
        }
        return this.d;
    }

    public int ah() {
        if (this.ah == -1) {
            this.ah = ms("max", 50);
        }
        return this.ah;
    }

    public float d() {
        if (this.ka == -1.0f) {
            this.ka = ms("aggMultiple", -1.0f);
        }
        return this.ka;
    }

    public String ka() {
        if (this.c == null) {
            this.c = xr("ab_test_version", "");
        }
        return this.c;
    }

    public String c() {
        if (this.ab == null) {
            this.ab = xr("ab_test_param", "");
        }
        return this.ab;
    }

    public void ab() {
        this.ab = "";
        this.c = "";
        ms("ab_test_version", "");
        ms("ab_test_param", "");
    }

    public boolean x() {
        if (this.zb == -1) {
            this.zb = ms("dl_storage_internal", 1);
        }
        return this.zb == 1;
    }

    public int ny() {
        if (this.u == -1) {
            this.u = ms("cypher_version", 40001);
        }
        return this.u;
    }

    public boolean ch() {
        return ms("is_spl_cache_remove_change", false);
    }

    public int hi() {
        if (this.x == -1) {
            this.x = ms("spl_cache_conf", 14);
        }
        return this.x;
    }

    public int sl() {
        if (this.ch == -1) {
            this.ch = ms("spl_thread_conf", 1);
        }
        return this.ch;
    }

    public int zb() {
        if (this.hi == -1) {
            this.hi = ms("spl_common_conf", 0);
        }
        return this.hi;
    }

    public int u() {
        if (this.sl <= 0) {
            this.sl = ms("splash_render_timeout_backup", 100);
        }
        return this.sl;
    }

    public int ub() {
        if (this.ub == -1) {
            this.ub = ms("splash_policy", 0);
        }
        return this.ub;
    }

    public boolean ms(String str, boolean z) {
        try {
            if (ah.ms().xr()) {
                return com.bytedance.sdk.component.ab.ah.ms.xr.ms(qv(), str, z);
            }
            return this.xr.getBoolean(str, z);
        } catch (Throwable unused) {
            return z;
        }
    }

    public long ms(String str, long j) {
        try {
            if (ah.ms().xr()) {
                return com.bytedance.sdk.component.ab.ah.ms.xr.ms(qv(), str, j);
            }
            return this.xr.getLong(str, j);
        } catch (Throwable unused) {
            return j;
        }
    }

    public float ms(String str, float f) {
        try {
            if (ah.ms().xr()) {
                return com.bytedance.sdk.component.ab.ah.ms.xr.ms(qv(), str, f);
            }
            return this.xr.getFloat(str, f);
        } catch (Throwable unused) {
            return f;
        }
    }

    public int ms(String str, int i) {
        try {
            if (ah.ms().xr()) {
                return com.bytedance.sdk.component.ab.ah.ms.xr.ms(qv(), str, i);
            }
            return this.xr.getInt(str, i);
        } catch (Throwable unused) {
            return i;
        }
    }

    public void ms(String str, String str2) {
        try {
            if (ah.ms().xr()) {
                com.bytedance.sdk.component.ab.ah.ms.xr.ms(qv(), str, str2);
                return;
            }
            SharedPreferences.Editor editorEdit = this.xr.edit();
            editorEdit.putString(str, str2);
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }

    public String xr(String str, String str2) {
        try {
            if (ah.ms().xr()) {
                return com.bytedance.sdk.component.ab.ah.ms.xr.xr(qv(), str, str2);
            }
            return this.xr.getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public void ao() {
        try {
            SharedPreferences.Editor editorEdit = this.xr.edit();
            editorEdit.clear();
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }

    public static class xr {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private Map<String, Object> f1975ms = new HashMap();

        public xr ms(long j) {
            if (ka.ms().d == j) {
                return this;
            }
            ka.ms().d = j;
            this.f1975ms.put("duration", Long.valueOf(j));
            return this;
        }

        public xr ms(int i) {
            if (ka.ms().ah == i) {
                return this;
            }
            ka.ms().ah = i;
            this.f1975ms.put("max", Integer.valueOf(i));
            return this;
        }

        public xr ms(float f) {
            if (ka.ms().ka == f) {
                return this;
            }
            ka.ms().ka = f;
            this.f1975ms.put("aggMultiple", Float.valueOf(f));
            return this;
        }

        public xr ms(String str) {
            if (str != null && str.equals(ka.ms().c)) {
                return this;
            }
            ka.ms().c = str;
            Map<String, Object> map = this.f1975ms;
            if (str == null) {
                str = "";
            }
            map.put("ab_test_version", str);
            return this;
        }

        public xr xr(String str) {
            if (str != null && str.equals(ka.ms().ab)) {
                return this;
            }
            ka.ms().ab = str;
            Map<String, Object> map = this.f1975ms;
            if (str == null) {
                str = "";
            }
            map.put("ab_test_param", str);
            return this;
        }

        public xr ms(boolean z) {
            this.f1975ms.put("is_spl_cache_remove_change", Boolean.valueOf(z));
            return this;
        }

        public xr xr(int i) {
            if (ka.ms().u == i) {
                return this;
            }
            ka.ms().u = i;
            this.f1975ms.put("cypher_version", Integer.valueOf(i));
            return this;
        }

        public xr ah(int i) {
            if (ka.ms().x == i) {
                return this;
            }
            ka.ms().x = i;
            this.f1975ms.put("spl_cache_conf", Integer.valueOf(i));
            return this;
        }

        public xr d(int i) {
            if (ka.ms().ch == i) {
                return this;
            }
            ka.ms().ch = i;
            this.f1975ms.put("spl_thread_conf", Integer.valueOf(i));
            return this;
        }

        public xr ka(int i) {
            if (ka.ms().hi == i) {
                return this;
            }
            ka.ms().hi = i;
            this.f1975ms.put("spl_common_conf", Integer.valueOf(i));
            return this;
        }

        public xr c(int i) {
            if (ka.ms().ny == i) {
                return this;
            }
            ka.ms().ny = i;
            this.f1975ms.put("spl_cache_expired", Integer.valueOf(i));
            return this;
        }

        public xr ah(String str) {
            if (str != null && str.equals(ka.ms().f1973ms)) {
                return this;
            }
            ka.ms().f1973ms = str;
            Map<String, Object> map = this.f1975ms;
            if (str == null) {
                str = "";
            }
            map.put("drop_cache_black_conf", str);
            return this;
        }

        public xr ms(JSONObject jSONObject) {
            int iOptInt;
            if (jSONObject == null || ka.ms().ub == (iOptInt = jSONObject.optInt("splash_policy", 0))) {
                return this;
            }
            ka.ms().ub = iOptInt;
            this.f1975ms.put("splash_policy", Integer.valueOf(iOptInt));
            return this;
        }

        public xr ab(int i) {
            if (ka.ms().sl == i) {
                return this;
            }
            ka.ms().sl = i;
            this.f1975ms.put("splash_render_timeout_backup", Integer.valueOf(i));
            return this;
        }

        public xr x(int i) {
            if (ka.ms().zb == i) {
                return this;
            }
            ka.ms().zb = i;
            this.f1975ms.put("dl_storage_internal", Integer.valueOf(i));
            return this;
        }

        public void ms() {
            try {
                if (ah.ms().xr()) {
                    String strQv = ka.qv();
                    for (Map.Entry<String, Object> entry : this.f1975ms.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (value instanceof Boolean) {
                            com.bytedance.sdk.component.ab.ah.ms.xr.ms(strQv, key, (Boolean) value);
                        } else if (value instanceof Long) {
                            com.bytedance.sdk.component.ab.ah.ms.xr.ms(strQv, key, (Long) value);
                        } else if (value instanceof Float) {
                            com.bytedance.sdk.component.ab.ah.ms.xr.ms(strQv, key, (Float) value);
                        } else if (value instanceof Integer) {
                            com.bytedance.sdk.component.ab.ah.ms.xr.ms(strQv, key, (Integer) value);
                        } else if (value instanceof String) {
                            com.bytedance.sdk.component.ab.ah.ms.xr.ms(strQv, key, (String) value);
                        }
                    }
                    return;
                }
                SharedPreferences.Editor editorEdit = ka.ms().xr.edit();
                for (Map.Entry<String, Object> entry2 : this.f1975ms.entrySet()) {
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
                sl.ms(e);
            }
        }
    }
}
