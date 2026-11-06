package ms.bz.bd.c.Pgl;

import com.umeng.analytics.pro.cc;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
final class q0 extends pbls.pgla {
    q0() {
    }

    @Override // ms.bz.bd.c.Pgl.pbls.pgla
    public final Object pr(long j, String str, Object obj) throws Throwable {
        try {
            Class<?> cls = Class.forName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "8ef071", new byte[]{42, 104, 24, 10, 27, 53, 117, 69, 57, 100, 59, 104, 28, 64, 70, 51, 60, 71, 121, 113, 60, 104, 1, 69, 70, 4, 31, 106, 50, 116, 62, 104, 7, 79, 60, 39, 60, 103, 56, 110, 61, 98, cc.k, 80, 56, 52, 52, 82, 62, 100, 44, 117, 52, 64, 9, 54, 47, 65, 37}));
            Method declaredMethod = cls.getDeclaredMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "0b2966", new byte[]{44, 97, 83, 70, 40, 50, 29, 70, 116, 92, 50, 101, 83}), new Class[0]);
            declaredMethod.setAccessible(true);
            Object objNewInstance = cls.newInstance();
            if (objNewInstance != null ? ((Boolean) declaredMethod.invoke(objNewInstance, new Object[0])).booleanValue() : false) {
                return (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "548003", new byte[]{42, 51, 92, 113, 28, 33, 36});
            }
            return null;
        } catch (Throwable th) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "cc43c2", new byte[]{117, 96, 65});
            return null;
        }
    }
}
