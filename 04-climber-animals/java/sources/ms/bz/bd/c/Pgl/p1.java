package ms.bz.bd.c.Pgl;

/* JADX INFO: loaded from: classes4.dex */
public final class p1 {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile p1 f4843ms;
    private Throwable xr = null;

    private p1() {
    }

    public static p1 ms() {
        if (f4843ms == null) {
            synchronized (p1.class) {
                if (f4843ms == null) {
                    f4843ms = new p1();
                }
            }
        }
        return f4843ms;
    }

    public final synchronized Throwable xr() {
        return this.xr;
    }
}
