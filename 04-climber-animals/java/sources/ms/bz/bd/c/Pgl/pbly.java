package ms.bz.bd.c.Pgl;

import android.util.SparseArray;
import com.umeng.analytics.pro.ek;

/* JADX INFO: loaded from: classes4.dex */
public final class pbly {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final /* synthetic */ int f4864ms = 0;
    private static final SparseArray<pgla> xr = new SparseArray<>();

    public static abstract class pgla {
        public Object ms(int i, int i2, long j, String str, Object obj) throws Throwable {
            return ms(j, str, obj);
        }

        protected Object ms(long j, String str, Object obj) throws Throwable {
            return null;
        }
    }

    public static Object ms(int i, int i2, long j, String str, Object obj) {
        pgla pglaVar = xr.get(i);
        if (pglaVar == null) {
            throw new RuntimeException(String.format((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "aac7ae", new byte[]{127, 115, 80, com.anythink.core.common.s.a.c.b, 81, 118, 103, 0, 119, 99, 48, 106, 3, 3, 87, 124, 116, 65, 62, 110, 116}), Integer.valueOf(i)));
        }
        try {
            return pglaVar.ms(i, i2, j, str, obj);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    public static void ms(int i, pgla pglaVar) {
        SparseArray<pgla> sparseArray = xr;
        pgla pglaVar2 = sparseArray.get(i);
        if (pglaVar2 != null) {
            throw new RuntimeException(String.format((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "ed7866", new byte[]{49, 117, 4, 68, 8, 37, 38, 71, 99, 109, 122, 38, 86, 73, ek.l, 40, 117, 81, 99, 122, 58}), pglaVar2.toString()));
        }
        sparseArray.put(i, pglaVar);
    }
}
