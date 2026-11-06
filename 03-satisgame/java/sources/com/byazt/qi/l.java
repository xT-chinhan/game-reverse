package com.byazt.qi;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Printer;
import android.util.SparseArray;
import com.byazt.yw.tj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_OPTION, 18})
public class l implements Handler.Callback {
    public static Printer n;
    public static l qg;
    public static final Printer tj = new Printer() { // from class: com.byazt.qi.l.1
        @Override // android.util.Printer
        public void println(String str) {
            if (str == null) {
                return;
            }
            if (str.startsWith(">>>>> Dispatching")) {
                l.n().n(str);
            } else if (str.startsWith("<<<<< Finished")) {
                l.n().qg(str);
            }
            if (l.n == null || l.n == l.tj) {
                return;
            }
            l.n.println(str);
        }
    };
    public boolean d;
    public long l;
    public long w;
    public int q = 0;
    public final SparseArray<List<Runnable>> x = new SparseArray<>();
    public final List<Printer> fs = new LinkedList();
    public final List<Printer> rv = new LinkedList();
    public boolean cp = false;
    public Handler s = new Handler(x.n().getLooper(), this);

    private l() {
        qg();
    }

    public static l n() {
        if (qg == null) {
            synchronized (l.class) {
                if (qg == null) {
                    qg = new l();
                }
            }
        }
        return qg;
    }

    public void qg() {
        if (this.cp) {
            return;
        }
        this.cp = true;
        Printer printerL = l();
        n = printerL;
        Printer printer = tj;
        if (printerL == printer) {
            n = null;
        }
        Looper.getMainLooper().setMessageLogging(printer);
    }

    private Printer l() {
        try {
            Field declaredField = Class.forName("android.os.Looper").getDeclaredField("mLogging");
            declaredField.setAccessible(true);
            return (Printer) declaredField.get(Looper.getMainLooper());
        } catch (Exception e) {
            tj.qg(e);
            return null;
        }
    }

    public void n(long j, Runnable runnable) {
        n(j, runnable, 1, 0L);
    }

    public void n(long j, Runnable runnable, int i, long j2) {
        if (j < 0) {
            return;
        }
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = (int) j;
            List<Runnable> linkedList = this.x.get(i3);
            if (linkedList == null) {
                synchronized (this.x) {
                    linkedList = this.x.get(i3);
                    if (linkedList == null) {
                        linkedList = new LinkedList<>();
                        this.x.put(i3, linkedList);
                    }
                }
            }
            linkedList.add(runnable);
            j += j2;
        }
    }

    public void n(String str) {
        if (!this.d) {
            w.n(32L);
            this.d = true;
        }
        this.l = SystemClock.uptimeMillis();
        try {
            n(this.fs, str);
            this.s.sendEmptyMessage(0);
        } catch (Exception e) {
            tj.n(e);
        }
    }

    public void qg(String str) {
        this.w = SystemClock.uptimeMillis();
        try {
            this.s.removeMessages(2);
            n(this.rv, str);
            this.s.sendEmptyMessage(1);
        } catch (Exception e) {
            tj.qg(e);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        try {
            if (this.s.hasMessages(0)) {
                return true;
            }
            int i = message.what;
            if (i == 0) {
                this.q = 0;
                if (this.x.size() != 0 && this.x.keyAt(0) == 0) {
                    n(this.x.valueAt(0));
                    this.q++;
                }
            } else {
                if (i == 1) {
                    this.s.removeMessages(2);
                    if (this.x.size() != 0) {
                        SparseArray<List<Runnable>> sparseArray = this.x;
                        if (sparseArray.keyAt(sparseArray.size() - 1) == 0) {
                            n(this.x.get(Integer.MAX_VALUE));
                        }
                    }
                    return true;
                }
                if (i == 2) {
                    n(this.x.valueAt(this.q));
                    this.q++;
                }
            }
            if (this.q >= this.x.size()) {
                return true;
            }
            long jKeyAt = this.x.keyAt(this.q);
            if (jKeyAt != 2147483647L) {
                this.s.sendEmptyMessageAtTime(2, this.l + jKeyAt);
            }
            return true;
        } catch (Throwable unused) {
        }
    }

    private static void n(List<? extends Runnable> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            Iterator<? extends Runnable> it = list.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        } catch (Exception e) {
            tj.n(e);
        }
    }

    private synchronized void n(List<? extends Printer> list, String str) {
        if (list != null) {
            if (!list.isEmpty()) {
                try {
                    Iterator<? extends Printer> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().println(str);
                    }
                } catch (Exception e) {
                    tj.n(e);
                }
            }
        }
    }
}
