package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes4.dex */
public final class a1 {
    private static volatile a1 ah = null;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static volatile boolean f4827ms = true;
    public static String xr;
    private pblk d;
    private String ka = null;

    final class pgla implements pblk.pblb {
        pgla() {
        }

        @Override // ms.bz.bd.c.Pgl.pblk.pblb
        public final void ms(String str) {
            a1.this.ka = str;
        }
    }

    private a1(Context context) {
        try {
            this.d = new pblk(new pgla());
            if (!f4827ms || Build.VERSION.SDK_INT > 32) {
                return;
            }
            this.d.ms(context);
        } catch (Throwable unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "74928f", new byte[]{41, 35, 73});
        }
    }

    public static a1 ms(Context context) {
        if (ah == null) {
            synchronized (a1.class) {
                if (ah == null) {
                    ah = new a1(context);
                }
            }
        }
        return ah;
    }

    public final String ms() {
        String str = xr;
        return str != null ? str : this.ka;
    }
}
