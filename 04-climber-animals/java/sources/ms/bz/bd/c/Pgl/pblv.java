package ms.bz.bd.c.Pgl;

import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
public final class pblv {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final pblv f4861ms = new pblv();
    private Context xr;

    public static pblv ms() {
        return f4861ms;
    }

    public final void ms(Context context) {
        this.xr = context != null ? context.getApplicationContext() : null;
    }

    public final Context xr() {
        return this.xr;
    }
}
