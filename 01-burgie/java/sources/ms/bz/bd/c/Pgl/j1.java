package ms.bz.bd.c.Pgl;

/* JADX INFO: loaded from: classes3.dex */
public final class j1 {
    private static volatile j1 pr;
    private Throwable hw = null;

    private j1() {
    }

    public static j1 pr() {
        if (pr == null) {
            synchronized (j1.class) {
                if (pr == null) {
                    pr = new j1();
                }
            }
        }
        return pr;
    }

    public final synchronized Throwable hw() {
        return this.hw;
    }
}
