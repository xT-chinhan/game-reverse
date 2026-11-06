package ms.bz.bd.c.Pgl;

import android.app.Application;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.view.Display;

/* JADX INFO: loaded from: classes3.dex */
public final class g1 {
    private static g1 n;
    private DisplayManager l;
    private boolean q = false;
    private final HandlerThread qg;
    private Context s;
    private pbli w;

    final class pgla implements Runnable {
        pgla() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (g1.this.s != null) {
                    g1.this.qg.start();
                    Handler handler = new Handler(g1.this.qg.getLooper());
                    g1 g1Var = g1.this;
                    g1Var.l = (DisplayManager) g1Var.s.getApplicationContext().getSystemService((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "31780a", new byte[]{38, 58, 87, 92, 3, 119, 41}));
                    if (g1.this.l != null) {
                        Display[] displays = g1.this.l.getDisplays();
                        int length = displays.length;
                        if (length > 1) {
                            f1 f1VarN = f1.n();
                            f1VarN.getClass();
                            String strN = f1.n(displays);
                            String strQg = f1.qg(displays);
                            f1VarN.n(length);
                            f1VarN.qg();
                            if (!TextUtils.isEmpty(strN)) {
                                f1VarN.n(strN);
                            }
                            if (!TextUtils.isEmpty(strQg)) {
                                f1VarN.qg(strQg);
                            }
                        }
                        g1 g1Var2 = g1.this;
                        g1Var2.w = new pbli(g1Var2.l);
                        g1.this.l.registerDisplayListener(g1.this.w, handler);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private g1(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.s = applicationContext;
        if (!(applicationContext instanceof Application)) {
            Context contextQg = qg();
            this.s = contextQg == null ? this.s : contextQg;
        }
        this.qg = new HandlerThread((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "93f385", new byte[]{5, 2, 38, 117}));
    }

    public static g1 n(Context context) {
        g1 g1Var;
        synchronized (g1.class) {
            if (n == null) {
                n = new g1(context);
            }
            g1Var = n;
        }
        return g1Var;
    }

    private static Application qg() {
        Application application;
        try {
            application = null;
            try {
                return (Application) Class.forName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "4d5ef0", new byte[]{36, 104, 66, 3, 86, 46, 51, 11, 101, 37, 53, 40, 103, 18, 77, 46, 33, 76, 112, 44, 17, 110, 84, 20, 88, 35})).getMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "8a090d", new byte[]{42, 118, 81, 95, 10, 125, 47, 97, 113, 121, 37, 106, com.anythink.core.common.r.a.c.b, 76, 27, 122, 52, 78}), new Class[0]).invoke(null, null);
            } catch (Throwable unused) {
                return application;
            }
        } catch (Throwable unused2) {
            application = null;
        }
    }

    protected final void finalize() throws Throwable {
        pbli pbliVar;
        synchronized (this) {
            try {
                DisplayManager displayManager = this.l;
                if (displayManager != null && (pbliVar = this.w) != null) {
                    displayManager.unregisterDisplayListener(pbliVar);
                }
            } catch (Throwable unused) {
            }
            HandlerThread handlerThread = this.qg;
            if (handlerThread != null) {
                try {
                    handlerThread.quitSafely();
                } catch (Throwable unused2) {
                }
            }
        }
        super.finalize();
    }

    public final synchronized void n() {
        if (this.q) {
            return;
        }
        this.q = true;
        new com.byazt.xis.s(new pgla(), "z/bd/c/Pgl/g1").start();
    }
}
