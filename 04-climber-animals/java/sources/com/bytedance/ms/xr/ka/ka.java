package com.bytedance.ms.xr.ka;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Printer;
import android.util.SparseArray;
import com.bytedance.ms.xr.x.ch;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ka implements Handler.Callback {
    private static final Printer ch = new Printer() { // from class: com.bytedance.ms.xr.ka.ka.1
        @Override // android.util.Printer
        public void println(String str) {
            if (str == null) {
                return;
            }
            if (str.startsWith(">>>>> Dispatching")) {
                ka.ms().ms(str);
            } else if (str.startsWith("<<<<< Finished")) {
                ka.ms().xr(str);
            }
            if (ka.f571ms == null || ka.f571ms == ka.ch) {
                return;
            }
            ka.f571ms.println(str);
        }
    };

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static Printer f571ms;
    private static ka xr;
    private long c;
    private long ka;
    private boolean sl;
    private int d = 0;
    private final SparseArray<List<Runnable>> ab = new SparseArray<>();
    private final List<Printer> x = new LinkedList();
    private final List<Printer> ny = new LinkedList();
    private boolean hi = false;
    private Handler ah = new Handler(ab.ms().getLooper(), this);

    private ka() {
        xr();
    }

    public static ka ms() {
        if (xr == null) {
            synchronized (ka.class) {
                if (xr == null) {
                    xr = new ka();
                }
            }
        }
        return xr;
    }

    public void xr() {
        if (this.hi) {
            return;
        }
        this.hi = true;
        Printer printerKa = ka();
        f571ms = printerKa;
        Printer printer = ch;
        if (printerKa == printer) {
            f571ms = null;
        }
        Looper.getMainLooper().setMessageLogging(printer);
    }

    private Printer ka() {
        try {
            Field declaredField = Class.forName("android.os.Looper").getDeclaredField("mLogging");
            declaredField.setAccessible(true);
            return (Printer) declaredField.get(Looper.getMainLooper());
        } catch (Exception e) {
            ch.xr(e);
            return null;
        }
    }

    public void ms(long j, Runnable runnable) {
        ms(j, runnable, 1, 0L);
    }

    public void ms(long j, Runnable runnable, int i, long j2) {
        if (j < 0) {
            return;
        }
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = (int) j;
            List<Runnable> linkedList = this.ab.get(i3);
            if (linkedList == null) {
                synchronized (this.ab) {
                    linkedList = this.ab.get(i3);
                    if (linkedList == null) {
                        linkedList = new LinkedList<>();
                        this.ab.put(i3, linkedList);
                    }
                }
            }
            linkedList.add(runnable);
            j += j2;
        }
    }

    void ms(String str) {
        if (!this.sl) {
            c.ms(32L);
            this.sl = true;
        }
        this.ka = SystemClock.uptimeMillis();
        try {
            ms(this.x, str);
            this.ah.sendEmptyMessage(0);
        } catch (Exception e) {
            ch.ms(e);
        }
    }

    void xr(String str) {
        this.c = SystemClock.uptimeMillis();
        try {
            this.ah.removeMessages(2);
            ms(this.ny, str);
            this.ah.sendEmptyMessage(1);
        } catch (Exception e) {
            ch.xr(e);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        try {
            if (this.ah.hasMessages(0)) {
                return true;
            }
            int i = message.what;
            if (i == 0) {
                this.d = 0;
                if (this.ab.size() != 0 && this.ab.keyAt(0) == 0) {
                    ms(this.ab.valueAt(0));
                    this.d++;
                }
            } else {
                if (i == 1) {
                    this.ah.removeMessages(2);
                    if (this.ab.size() != 0) {
                        SparseArray<List<Runnable>> sparseArray = this.ab;
                        if (sparseArray.keyAt(sparseArray.size() - 1) == 0) {
                            ms(this.ab.get(Integer.MAX_VALUE));
                        }
                    }
                    return true;
                }
                if (i == 2) {
                    ms(this.ab.valueAt(this.d));
                    this.d++;
                }
            }
            if (this.d >= this.ab.size()) {
                return true;
            }
            long jKeyAt = this.ab.keyAt(this.d);
            if (jKeyAt != 2147483647L) {
                this.ah.sendEmptyMessageAtTime(2, this.ka + jKeyAt);
            }
            return true;
        } catch (Throwable unused) {
        }
    }

    private static void ms(List<? extends Runnable> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            Iterator<? extends Runnable> it = list.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        } catch (Exception e) {
            ch.ms(e);
        }
    }

    private synchronized void ms(List<? extends Printer> list, String str) {
        if (list != null) {
            if (!list.isEmpty()) {
                try {
                    Iterator<? extends Printer> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().println(str);
                    }
                } catch (Exception e) {
                    ch.ms(e);
                }
            }
        }
    }
}
