package ms.bz.bd.c.Pgl;

import android.app.Activity;
import android.content.Context;
import android.util.ArrayMap;
import com.umeng.analytics.pro.ek;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes4.dex */
public final class pble {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile int f4847ms = -1;
    private static volatile String xr = "";

    public static int ms(Context context) {
        if (f4847ms <= 0) {
            try {
                f4847ms = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (Throwable unused) {
            }
        }
        return f4847ms;
    }

    public static Activity ms() {
        try {
            Class<?> cls = Class.forName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e07dec", new byte[]{117, 60, com.anythink.core.common.s.a.c.b, 2, 85, 125, 98, 95, 103, 36, 100, 124, 101, 19, 78, 125, 112, 24, 114, 45, com.anythink.core.common.s.a.c.b, 58, 86, 21, 91, 112}));
            Object objInvoke = cls.getMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "2a2f97", new byte[]{32, 118, 83, 0, 3, 46, 37, 97, 96, 34, 42, 117, 72, 6, 31, 20, 57, 82, 102, 55, 39}), new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "9c1c1c", new byte[]{37, com.anythink.core.common.s.a.c.b, 65, 3, 7, 98, 51, 86, 105, 54, 59}));
            declaredField.setAccessible(true);
            ArrayMap arrayMap = (ArrayMap) declaredField.get(objInvoke);
            if (arrayMap.size() <= 0) {
                return null;
            }
            for (Object obj : arrayMap.values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "4aae42", new byte[]{53, 98, 7, 2, ek.l, 33}));
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(obj)) {
                    Field declaredField3 = cls2.getDeclaredField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "2939c2", new byte[]{34, 56, 84, 68, 74, 44, 37, 1}));
                    declaredField3.setAccessible(true);
                    return (Activity) declaredField3.get(obj);
                }
            }
            return null;
        } catch (Exception unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1d8ca1", new byte[]{33, 111, 116, ek.n});
            return null;
        }
    }

    public static String xr(Context context) {
        try {
            if (xr == "") {
                xr = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            }
        } catch (Throwable unused) {
        }
        return xr;
    }
}
