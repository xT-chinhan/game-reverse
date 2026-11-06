package ms.bz.bd.c.Pgl;

import com.umeng.analytics.pro.ek;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes4.dex */
final class u0 extends pbly.pgla {
    u0() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object ms(long j, String str, Object obj) throws Throwable {
        try {
            Class<?> cls = Class.forName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "445133", new byte[]{38, 57, 75, 11, 31, 55, 121, 20, 106, 101, 55, 57, 79, 65, 66, 49, 48, 22, 42, 112, 48, 57, 82, 68, 66, 6, 19, 59, 97, 117, 50, 57, 84, 78, 56, 37, 48, 54, 107, 111, 49, 51, 94, 81, 60, 54, 56, 3, 109, 101, 32, 36, 103, 65, ek.k, 52, 35, ek.n, 118}));
            Method declaredMethod = cls.getDeclaredMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "06b1bb", new byte[]{44, 53, 3, 78, 124, 102, 29, 18, 36, 84, 50, 49, 3}), new Class[0]);
            declaredMethod.setAccessible(true);
            Object objNewInstance = cls.newInstance();
            if (objNewInstance != null ? ((Boolean) declaredMethod.invoke(objNewInstance, new Object[0])).booleanValue() : false) {
                return (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "08a6a1", new byte[]{47, com.anythink.core.common.s.a.c.c, 5, 119, 77, 35, 33});
            }
            return null;
        } catch (Throwable unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "864c5c", new byte[]{46, 53, 65});
            return null;
        }
    }
}
