package ms.bz.bd.c.Pgl;

/* JADX INFO: loaded from: classes3.dex */
public final class pblg {
    public static boolean n() {
        return n((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "805fee", new byte[]{42, 61, 75, 92, 88, 107, 47, 20, 96, 55, 39, 49, 67, 92, 92, 96, 58, 28, 115, 57, 59, 57, 8, 17, 85, 96, 62, 95, 119, 50, 34, com.anythink.core.common.r.a.c.c, 73, 28, 83, 102, 52, 3, 42, 6, 46, 62, 117, 54, 113, 95, 52, 31, 109, 34, 38, 32, 115, 6, 83, 126, 40}));
    }

    private static boolean n(String... strArr) {
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
