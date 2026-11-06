package ms.bz.bd.c.Pgl;

import android.app.Application;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.view.Display;
import com.byazt.fr.hn;

/* JADX INFO: loaded from: classes3.dex */
public final class g1 {
    private static g1 pr;
    private DisplayManager c;
    private Context hn;
    private final HandlerThread hw;
    private pbli uc;
    private boolean x = false;

    final class pgla implements Runnable {
        pgla() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (Build.VERSION.SDK_INT < 17 || g1.this.hn == null) {
                    return;
                }
                g1.this.hw.start();
                Handler handler = new Handler(g1.this.hw.getLooper());
                g1 g1Var = g1.this;
                g1Var.c = (DisplayManager) g1Var.hn.getApplicationContext().getSystemService((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "31780a", new byte[]{38, 58, 87, 92, 3, 119, 41}));
                if (g1.this.c != null) {
                    Display[] displays = g1.this.c.getDisplays();
                    int length = displays.length;
                    if (length > 1) {
                        f1 f1VarPr = f1.pr();
                        f1VarPr.getClass();
                        String strPr = f1.pr(displays);
                        String strHw = f1.hw(displays);
                        f1VarPr.pr(length);
                        f1VarPr.hw();
                        if (!TextUtils.isEmpty(strPr)) {
                            f1VarPr.pr(strPr);
                        }
                        if (!TextUtils.isEmpty(strHw)) {
                            f1VarPr.hw(strHw);
                        }
                    }
                    g1 g1Var2 = g1.this;
                    g1Var2.uc = new pbli(g1Var2.c);
                    g1.this.c.registerDisplayListener(g1.this.uc, handler);
                }
            } catch (Throwable th) {
            }
        }
    }

    private g1(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.hn = applicationContext;
        if (!(applicationContext instanceof Application)) {
            Context contextHw = hw();
            this.hn = contextHw == null ? this.hn : contextHw;
        }
        this.hw = new HandlerThread((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "93f385", new byte[]{5, 2, 38, 117}));
    }

    private static Application hw() {
        try {
            try {
                return (Application) Class.forName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "4d5ef0", new byte[]{36, 104, 66, 3, 86, 46, 51, 11, 101, 37, 53, 40, 103, 18, 77, 46, 33, 76, 112, 44, 17, 110, 84, 20, 88, 35})).getMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "8a090d", new byte[]{42, 118, 81, 95, 10, 125, 47, 97, 113, 121, 37, 106, 64, 76, 27, 122, 52, 78}), new Class[0]).invoke(null, null);
            } catch (Throwable th) {
                return null;
            }
        } catch (Throwable th2) {
            return null;
        }
    }

    public static g1 pr(Context context) {
        g1 g1Var;
        synchronized (g1.class) {
            if (pr == null) {
                pr = new g1(context);
            }
            g1Var = pr;
        }
        return g1Var;
    }

    protected final void finalize() throws Throwable {
        DisplayManager displayManager;
        pbli pbliVar;
        synchronized (this) {
            try {
                if (Build.VERSION.SDK_INT >= 17 && (displayManager = this.c) != null && (pbliVar = this.uc) != null) {
                    displayManager.unregisterDisplayListener(pbliVar);
                }
            } catch (Throwable th) {
            }
            HandlerThread handlerThread = this.hw;
            if (handlerThread != null) {
                try {
                    if (Build.VERSION.SDK_INT >= 18) {
                        handlerThread.quitSafely();
                    } else {
                        handlerThread.quit();
                    }
                } catch (Throwable th2) {
                }
            }
        }
        super.finalize();
    }

    public final synchronized void pr() {
        if (this.x) {
            return;
        }
        this.x = true;
        new hn(new pgla(), "z/bd/c/Pgl/g1").start();
    }
}
