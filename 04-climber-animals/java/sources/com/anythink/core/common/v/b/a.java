package com.anythink.core.common.v.b;

import android.os.Handler;
import android.os.HandlerThread;
import com.anythink.core.common.d.t;
import com.anythink.core.common.v.q;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String a = "TaskBusinessThreads";
    private final ExecutorService c;
    private final ExecutorService d;
    private volatile ExecutorService e;
    private volatile ExecutorService f;
    private final ExecutorService g;
    private final ConcurrentHashMap<String, Handler> h = new ConcurrentHashMap<>();
    private final ExecutorService b = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30, TimeUnit.SECONDS, new SynchronousQueue(), new c());

    private static void c() {
    }

    private static void d() {
    }

    public a() {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        byte b = 0;
        this.c = new ThreadPoolExecutor(iAvailableProcessors + 1, iAvailableProcessors * 2, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(100), new c(), new RejectedExecutionHandlerC0103a(this, b));
        this.d = new ThreadPoolExecutor(0, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new c(), new RejectedExecutionHandlerC0103a(this, b));
        this.g = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new c(), new RejectedExecutionHandlerC0103a(this, b));
    }

    /* JADX INFO: renamed from: com.anythink.core.common.v.b.a$a, reason: collision with other inner class name */
    private class RejectedExecutionHandlerC0103a implements RejectedExecutionHandler {
        private RejectedExecutionHandlerC0103a() {
        }

        /* synthetic */ RejectedExecutionHandlerC0103a(a aVar, byte b) {
            this();
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            new StringBuilder("rejectedExecution() >>> called. executor: ").append(threadPoolExecutor);
            a.this.b.execute(runnable);
        }
    }

    public final Handler a(int i) {
        return b(b(i));
    }

    public final void a(d dVar, int i) {
        String strB = b(i);
        dVar.a(strB);
        if (i != 1) {
            if (i != 13) {
                if (i != 3) {
                    if (i == 4) {
                        this.d.execute(dVar);
                        return;
                    }
                    if (i != 5) {
                        if (i != 7) {
                            if (i != 8) {
                                if (i != 16) {
                                    if (i == 17) {
                                        this.g.execute(dVar);
                                        return;
                                    } else {
                                        this.b.execute(dVar);
                                        return;
                                    }
                                }
                                if (this.f == null) {
                                    synchronized (a.class) {
                                        if (this.f == null) {
                                            this.f = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new c());
                                        }
                                    }
                                }
                                this.f.execute(dVar);
                                return;
                            }
                        }
                    }
                }
                Handler handlerB = b(strB);
                if (handlerB != null) {
                    handlerB.post(dVar);
                    return;
                }
                return;
            }
            this.c.execute(dVar);
            return;
        }
        if (this.e == null) {
            synchronized (a.class) {
                if (this.e == null) {
                    this.e = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new c());
                }
            }
        }
        this.e.execute(dVar);
    }

    private Handler a(String str) {
        return b(str);
    }

    private synchronized Handler b(String str) {
        Handler handler;
        Handler handler2 = this.h.get(str);
        if (handler2 != null) {
            return handler2;
        }
        try {
            HandlerThread handlerThread = new HandlerThread(str);
            handlerThread.setPriority(5);
            handlerThread.start();
            Thread.currentThread().getId();
            Thread.currentThread().getName();
            handler = new Handler(handlerThread.getLooper());
            try {
                this.h.put(str, handler);
            } catch (Throwable th) {
                th = th;
                handler2 = handler;
                th.getMessage();
                com.anythink.core.common.u.e.b("create handler thread error", th.getMessage() + ", " + q.a(th.getStackTrace()), t.b().r());
                handler = handler2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return handler;
    }

    public static String b(int i) {
        String strConcat = "def_t_".concat(String.valueOf(i));
        switch (i) {
            case 1:
                strConcat = "s_p";
                break;
            case 2:
                strConcat = "n_p";
                break;
            case 3:
                strConcat = "h_t_l";
                break;
            case 4:
                strConcat = "i_p";
                break;
            case 5:
                strConcat = "s_p_p_t";
                break;
            case 6:
                strConcat = "n_p_n_r";
                break;
            case 7:
                strConcat = "l_p_s_i";
                break;
            case 8:
                strConcat = "h_a_e";
                break;
            case 9:
                strConcat = "h_a_t";
                break;
            case 10:
                strConcat = "n_p_h_r";
                break;
            case 11:
                strConcat = "h_p_s";
                break;
            case 12:
                strConcat = "h_t";
                break;
            case 13:
                strConcat = "l_p_o_s_t";
                break;
            case 14:
                strConcat = "h_a_l";
                break;
            case 15:
                strConcat = "h_s_p";
                break;
            case 16:
                strConcat = "s_p_s_r_f_i";
                break;
            case 17:
                strConcat = "s_p_i";
                break;
            case 18:
                strConcat = "h_a_d_u";
                break;
        }
        return String.format("%s_%s", "anythink", strConcat);
    }

    public final Executor a() {
        return this.c;
    }

    public final ExecutorService b() {
        return this.b;
    }

    private void a(d dVar, String str) {
        Handler handlerB = b(str);
        if (handlerB != null) {
            handlerB.post(dVar);
        }
    }
}
