package ms.bz.bd.c.Pgl;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class pblp {
    private static final pblp pr = new pblp();
    private Context hw;

    public static pblp pr() {
        return pr;
    }

    public final Context hw() {
        return this.hw;
    }

    public final void pr(Context context) {
        this.hw = context != null ? context.getApplicationContext() : null;
    }
}
