package ms.bz.bd.c.Pgl;

import android.app.Activity;
import android.content.Context;
import android.util.ArrayMap;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes3.dex */
public final class pblc {
    private static volatile int n = -1;
    private static volatile String qg = "";

    public static int n(Context context) {
        if (n <= 0) {
            try {
                n = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (Throwable unused) {
            }
        }
        return n;
    }

    public static Activity n() {
        try {
            Class<?> cls = Class.forName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "228733", new byte[]{34, 62, 79, 81, 3, 45, 53, 93, 104, 119, 51, 126, 106, com.anythink.core.common.r.a.c.b, 24, 45, 39, 26, 125, 126, 23, 56, 89, 70, 13, 32}));
            Object objInvoke = cls.getMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a4032b", new byte[]{115, 35, 81, 85, 8, 123, 118, 52, 98, 119, 121, 32, 74, 83, 20, 65, 106, 7, 100, 98, 116}), new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "87297e", new byte[]{36, 20, 66, 89, 1, 100, 50, 2, 106, 108, 58}));
            declaredField.setAccessible(true);
            ArrayMap arrayMap = (ArrayMap) declaredField.get(objInvoke);
            if (arrayMap.size() <= 0) {
                return null;
            }
            for (Object obj : arrayMap.values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3b6415", new byte[]{50, 97, 80, 83, 11, 38}));
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(obj)) {
                    Field declaredField3 = cls2.getDeclaredField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "fc5c43", new byte[]{118, 98, 82, 30, 29, 45, 113, 91}));
                    declaredField3.setAccessible(true);
                    return (Activity) declaredField3.get(obj);
                }
            }
            return null;
        } catch (Exception unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f91dc6", new byte[]{118, 50, 125, 23});
            return null;
        }
    }

    public static String qg(Context context) {
        try {
            if (qg == "") {
                qg = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            }
        } catch (Throwable unused) {
        }
        return qg;
    }
}
