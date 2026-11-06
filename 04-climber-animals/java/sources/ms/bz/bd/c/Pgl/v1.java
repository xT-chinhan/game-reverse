package ms.bz.bd.c.Pgl;

import android.content.Context;
import com.umeng.analytics.pro.ek;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes4.dex */
public final class v1 {
    private Object ah;
    private Method d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Context f4870ms;
    private Class xr;

    public v1(Context context) {
        int i;
        this.f4870ms = context;
        try {
            i = 1;
            try {
                Class<?> cls = Class.forName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "bb3f19", new byte[]{112, 111, 77, 92, ek.m, 32, 101, 81, 109, com.anythink.core.common.s.a.c.c, 119, 46, 73, 22, com.anythink.core.common.s.a.c.b, 39, 108, 83, 110, 120, 90, 100, 112, 0, 1, 56, 104, 71, 103, 36, 90, 109, 80, 30}));
                this.xr = cls;
                this.ah = cls.newInstance();
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            i = 1;
        }
        try {
            Class cls2 = this.xr;
            byte[] bArr = new byte[7];
            bArr[0] = 37;
            bArr[i] = 100;
            bArr[2] = 4;
            bArr[3] = com.anythink.core.common.s.a.c.c;
            bArr[4] = 45;
            bArr[5] = 90;
            bArr[6] = 20;
            String str = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3ccd3d", bArr);
            Class<?>[] clsArr = new Class[i];
            clsArr[0] = Context.class;
            this.d = cls2.getMethod(str, clsArr);
        } catch (Exception unused3) {
        }
    }

    public final String ms() {
        Context context = this.f4870ms;
        Method method = this.d;
        Object obj = this.ah;
        if (obj != null && method != null) {
            try {
                return (String) method.invoke(obj, context);
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
