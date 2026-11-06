package ms.bz.bd.c.Pgl;

/* JADX INFO: loaded from: classes4.dex */
public final class q1 {
    static {
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "ebde13", new byte[]{79, 60, 86, 79, 51});
    }

    public static String ms(String str) {
        return (str == null || str.length() <= 0) ? "" : str.trim().replace('\'', ' ').replace('\"', ' ').replace('\r', ' ').replace('\n', ' ');
    }
}
