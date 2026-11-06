package com.byazt.pk;

import android.view.MotionEvent;
import android.view.View;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 36, 19})
public final class n {
    public static MotionEvent n(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        Object obj = map.get("args");
        if (!(obj instanceof Object[])) {
            return null;
        }
        Object[] objArr = (Object[]) obj;
        if (objArr.length != 0) {
            Object obj2 = objArr[0];
            if (obj2 instanceof MotionEvent) {
                return (MotionEvent) obj2;
            }
        }
        return null;
    }

    public static View qg(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        Object obj = map.get("view");
        if (obj instanceof View) {
            return (View) obj;
        }
        return null;
    }

    public static boolean s(Map<String, Object> map) {
        if (map == null) {
            return true;
        }
        Object obj = map.get("lastEventInView");
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return true;
    }

    public static long q(Map<String, Object> map) {
        if (map == null) {
            return -1L;
        }
        Object obj = map.get("viewAttachTime");
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        return -1L;
    }
}
