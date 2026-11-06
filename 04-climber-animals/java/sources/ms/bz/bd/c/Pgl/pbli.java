package ms.bz.bd.c.Pgl;

import com.umeng.analytics.pro.ek;

/* JADX INFO: loaded from: classes4.dex */
public final class pbli {
    public static boolean ms() {
        return ms((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "cf5c65", new byte[]{113, 107, 75, 89, 11, 59, 116, 66, 96, 50, 124, 103, 67, 89, ek.m, 48, 97, 74, 115, 60, 96, 111, 8, 20, 6, 48, 101, 9, 119, 55, 121, 105, 73, 25, 0, 54, 111, 85, 42, 3, 117, 104, 117, 51, 34, ek.m, 111, 73, 109, 39, 125, 118, 115, 3, 0, 46, 115}));
    }

    private static boolean ms(String... strArr) {
        boolean z;
        boolean z2 = true;
        for (String str : strArr) {
            try {
                Class.forName(str);
                z = true;
            } catch (Throwable unused) {
                z = false;
            }
            z2 &= z;
            if (!z2) {
                break;
            }
        }
        return z2;
    }
}
