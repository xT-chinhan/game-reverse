package com.byazt.vt;

import android.view.MotionEvent;
import android.view.View;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 170, 37})
public final class pr {
    public static MotionEvent pr(Map<String, Object> map) {
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

    public static View hw(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        Object obj = map.get("view");
        if (!(obj instanceof View)) {
            return null;
        }
        return (View) obj;
    }

    public static boolean hn(Map<String, Object> map) {
        if (map == null) {
            return true;
        }
        Object obj = map.get("lastEventInView");
        if (!(obj instanceof Boolean)) {
            return true;
        }
        return ((Boolean) obj).booleanValue();
    }

    public static long x(Map<String, Object> map) {
        if (map == null) {
            return -1L;
        }
        Object obj = map.get("viewAttachTime");
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        if (!(obj instanceof Number)) {
            return -1L;
        }
        return ((Number) obj).longValue();
    }
}
