package ms.bz.bd.c.Pgl;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class pblp {
    private static final pblp n = new pblp();
    private Context qg;

    public static pblp n() {
        return n;
    }

    public final void n(Context context) {
        this.qg = context != null ? context.getApplicationContext() : null;
    }

    public final Context qg() {
        return this.qg;
    }
}
