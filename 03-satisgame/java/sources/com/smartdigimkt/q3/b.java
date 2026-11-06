package com.smartdigimkt.q3;

import android.os.Handler;
import android.os.HandlerThread;
import com.smartdigimkt.n3.k;
import com.smartdigimkt.sdk.core.SDKContext;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public volatile ThreadPoolExecutor a;
    public volatile ThreadPoolExecutor b;
    public volatile ThreadPoolExecutor c;
    public volatile ThreadPoolExecutor d;
    public volatile ThreadPoolExecutor e;
    public volatile ThreadPoolExecutor f;
    public volatile ThreadPoolExecutor g;
    public volatile ThreadPoolExecutor h;
    public final ConcurrentHashMap i = new ConcurrentHashMap();
    public volatile ScheduledThreadPoolExecutor j;
    public volatile ThreadPoolExecutor k;

    public final void a(h hVar, int i) {
        String strA = a(i);
        hVar.a = strA;
        if (i != 1) {
            if (i != 13) {
                if (i != 3) {
                    if (i == 4) {
                        ((ThreadPoolExecutor) b()).execute(hVar);
                        return;
                    }
                    if (i != 5) {
                        if (i != 7) {
                            if (i != 8) {
                                if (i == 16) {
                                    if (this.f == null) {
                                        synchronized (b.class) {
                                            if (this.f == null) {
                                                this.f = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new g());
                                            }
                                        }
                                    }
                                    this.f.execute(hVar);
                                    return;
                                }
                                if (i == 17) {
                                    ((ThreadPoolExecutor) c()).execute(hVar);
                                    return;
                                }
                                if (i == 19) {
                                    ((ThreadPoolExecutor) a()).execute(hVar);
                                    return;
                                } else if (i != 20) {
                                    ((ThreadPoolExecutor) e()).execute(hVar);
                                    return;
                                } else {
                                    ((ThreadPoolExecutor) f()).execute(hVar);
                                    return;
                                }
                            }
                        }
                    }
                }
                Handler handlerA = a(strA);
                if (handlerA != null) {
                    handlerA.post(hVar);
                    return;
                }
                return;
            }
            ((ThreadPoolExecutor) d()).execute(hVar);
            return;
        }
        if (this.e == null) {
            synchronized (b.class) {
                if (this.e == null) {
                    this.e = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new g());
                }
            }
        }
        this.e.execute(hVar);
    }

    public final ExecutorService b() {
        if (this.c == null) {
            synchronized (b.class) {
                if (this.c == null) {
                    this.c = new ThreadPoolExecutor(5, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new g(), new a(this));
                }
            }
        }
        return this.c;
    }

    public final ExecutorService c() {
        if (this.g == null) {
            synchronized (b.class) {
                if (this.g == null) {
                    this.g = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new g(), new a(this));
                }
            }
        }
        return this.g;
    }

    public final ExecutorService d() {
        if (this.b == null) {
            synchronized (b.class) {
                if (this.b == null) {
                    int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
                    this.b = new ThreadPoolExecutor(iAvailableProcessors + 1, iAvailableProcessors * 2, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(100), new g(), new a(this));
                }
            }
        }
        return this.b;
    }

    public final ExecutorService e() {
        if (this.a == null) {
            synchronized (b.class) {
                if (this.a == null) {
                    this.a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new g());
                }
            }
        }
        return this.a;
    }

    public final ExecutorService f() {
        if (this.d == null) {
            synchronized (b.class) {
                if (this.d == null) {
                    this.d = new ThreadPoolExecutor(3, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new g(), new a(this));
                }
            }
        }
        return this.d;
    }

    public final Handler a(String str) {
        Handler handler;
        synchronized (this) {
            handler = (Handler) this.i.get(str);
            if (handler == null) {
                try {
                    HandlerThread handlerThread = new HandlerThread(str);
                    handlerThread.setPriority(1);
                    handlerThread.start();
                    Thread.currentThread().getId();
                    Thread.currentThread().getName();
                    Handler handler2 = new Handler(handlerThread.getLooper());
                    try {
                        this.i.put(str, handler2);
                        handler = handler2;
                    } catch (Throwable th) {
                        th = th;
                        handler = handler2;
                        th.getMessage();
                        k.a("create handler thread error", th.getMessage() + ", " + com.smartdigimkt.r4.k.a(th.getStackTrace()), SDKContext.getInstance().f(), "");
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        return handler;
    }

    public static String a(int i) {
        String str;
        String str2 = "def_t_" + i;
        switch (i) {
            case 1:
                str = "s_p";
                break;
            case 2:
                str = "n_p";
                break;
            case 3:
                str = "h_t_l";
                break;
            case 4:
                str = "i_p";
                break;
            case 5:
                str = "s_p_p_t";
                break;
            case 6:
                str = "n_p_n_r";
                break;
            case 7:
                str = "l_p_s_i";
                break;
            case 8:
                str = "h_a_e";
                break;
            case 9:
                str = "h_a_t";
                break;
            case 10:
                str = "n_p_h_r";
                break;
            case 11:
                str = "h_p_s";
                break;
            case 12:
                str = "h_t";
                break;
            case 13:
                str = "l_p_o_s_t";
                break;
            case 14:
                str = "h_a_l";
                break;
            case 15:
                str = "h_s_p";
                break;
            case 16:
                str = "s_p_s_r_f_i";
                break;
            case 17:
                str = "s_p_i";
                break;
            case 18:
                str = "h_a_d_u";
                break;
            case 19:
                str = "s_p_a_t_u";
                break;
            case 20:
                str = "v_p";
                break;
            default:
                return "sdm_" + str2;
        }
        str2 = str;
        return "sdm_" + str2;
    }

    public final ExecutorService a() {
        if (this.h == null) {
            synchronized (b.class) {
                if (this.h == null) {
                    this.h = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new g());
                }
            }
        }
        return this.h;
    }
}
