package com.byazt.ef;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 2561, 19})
public class n {
    public static <T> T n(Class<T> cls) {
        if (cls == Boolean.class || cls == Boolean.TYPE) {
            return (T) Boolean.FALSE;
        }
        if (cls == Integer.class || cls == Integer.TYPE) {
            return (T) 0;
        }
        if (cls == Long.class || cls == Long.TYPE) {
            return (T) 0L;
        }
        if (cls == Float.class || cls == Float.TYPE) {
            return (T) Float.valueOf(0.0f);
        }
        if (cls == Double.class || cls == Double.TYPE) {
            return (T) Double.valueOf(0.0d);
        }
        return null;
    }

    public static Object n(Map<String, Object> map) {
        if (map != null) {
            return map.get(MediationConstant.KEY_BAIDU_REQUEST_PARAMETERS);
        }
        return null;
    }
}
