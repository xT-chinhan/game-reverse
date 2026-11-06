package ms.bz.bd.c.Pgl;

/* JADX INFO: loaded from: classes3.dex */
public final class j1 {
    private static volatile j1 n;
    private Throwable qg = null;

    private j1() {
    }

    public static j1 n() {
        if (n == null) {
            synchronized (j1.class) {
                if (n == null) {
                    n = new j1();
                }
            }
        }
        return n;
    }

    public final synchronized Throwable qg() {
        return this.qg;
    }
}
