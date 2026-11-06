package ms.bz.bd.c.Pgl;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.ArrayMap;
import com.umeng.analytics.pro.cc;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class pblc {
    private static volatile String hw = "";
    private static volatile int pr = -1;

    public static String hw(Context context) {
        try {
            if (hw == "") {
                hw = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            }
        } catch (Throwable th) {
        }
        return hw;
    }

    public static int pr(Context context) {
        if (pr <= 0) {
            try {
                pr = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (Throwable th) {
            }
        }
        return pr;
    }

    public static Activity pr() {
        try {
            Class<?> cls = Class.forName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "228733", new byte[]{34, 62, 79, 81, 3, 45, 53, 93, 104, 119, 51, 126, 106, 64, 24, 45, 39, 26, 125, 126, 23, 56, 89, 70, cc.k, 32}));
            Object objInvoke = cls.getMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a4032b", new byte[]{115, 35, 81, 85, 8, 123, 118, 52, 98, 119, 121, 32, 74, 83, 20, 65, 106, 7, 100, 98, 116}), new Class[0]).invoke(null, new Object[0]);
            if (objInvoke == null) {
                int i = Build.VERSION.SDK_INT;
            }
            Field declaredField = cls.getDeclaredField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "87297e", new byte[]{36, 20, 66, 89, 1, 100, 50, 2, 106, 108, 58}));
            declaredField.setAccessible(true);
            Map map = Build.VERSION.SDK_INT < 19 ? (HashMap) declaredField.get(objInvoke) : (ArrayMap) declaredField.get(objInvoke);
            if (map.size() <= 0) {
                return null;
            }
            for (Object obj : map.values()) {
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
        } catch (Exception e) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f91dc6", new byte[]{118, 50, 125, 23});
            return null;
        }
    }
}
