package ms.bz.bd.c.Pgl;

import android.content.Context;
import com.umeng.analytics.pro.ek;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes4.dex */
final class h0 extends pbly.pgla {
    h0() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object ms(long j, String str, Object obj) throws Throwable {
        double dDoubleValue;
        Context contextXr = pblv.ms().xr();
        try {
            Class<?> cls = Class.forName(new String(pbla.ms((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "ecd497", new byte[]{34, 50, 65, 70, 80, 36, 52, 71, 99, 53, 34, 100, 65, 20, 81, 114, 48, 68, 99, 61, 34, 53, 69, 69, 80, 121, 48, 71, 98, 48, 34, 52, com.anythink.core.common.s.a.c.b, 18, 80, 37, 48, 19, 99, 103, 38, 100, 65, 70, 81, 115, 52, 71, 96, 52, 34, 103, com.anythink.core.common.s.a.c.b, 23, 80, 117, 49, ek.n, 96, 52, 35, 51, 65, 70, 80, 118, 48, 27, 99, 103, 34, 52}))));
            Object objNewInstance = cls.getConstructor(Context.class).newInstance(contextXr);
            Method declaredMethod = cls.getDeclaredMethod(new String(pbla.ms((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f40084", new byte[]{33, 97, 21, 17, 80, 119, 49, 68, 54, 54, 33, 99, 20, 22, 81, 114, 51, 66, 55, 53, 34, 102, 21, 66, 80, 116, 51, com.anythink.core.common.s.a.c.b, 54, 50}))), String.class);
            declaredMethod.setAccessible(true);
            dDoubleValue = ((Double) declaredMethod.invoke(objNewInstance, new String(pbla.ms((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "952951", new byte[]{126, 101, 23, 28, 93, 114, 109, com.anythink.core.common.s.a.c.b, 53, 60, 127, 101, 22, 20, 88, 35, 108, 71, 53, 56, 127, 103, 23, 28, 92, 117, 108, 77, 52, 61, 127, 110}))))).doubleValue();
        } catch (Throwable unused) {
            dDoubleValue = 0.0d;
        }
        return Integer.toString((int) dDoubleValue);
    }
}
