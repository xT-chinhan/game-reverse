package com.byazt.sds;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Printer;
import android.util.SparseArray;
import com.byazt.wf.vk;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1663, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c implements Handler.Callback {
    public long c;
    public boolean k;
    public long uc;
    public static Printer pr = null;
    public static c hw = null;
    public static final Printer vk = new Printer() { // from class: com.byazt.sds.c.1
        @Override // android.util.Printer
        public void println(String str) {
            if (str == null) {
                return;
            }
            if (str.startsWith(">>>>> Dispatching")) {
                c.pr().pr(str);
            } else if (str.startsWith("<<<<< Finished")) {
                c.pr().hw(str);
            }
            if (c.pr != null && c.pr != c.vk) {
                c.pr.println(str);
            }
        }
    };
    public int x = 0;
    public final SparseArray<List<Runnable>> fw = new SparseArray<>();
    public final List<Printer> zo = new LinkedList();
    public final List<Printer> aj = new LinkedList();
    public boolean w = false;
    public Handler hn = new Handler(fw.pr().getLooper(), this);

    private c() {
        hw();
    }

    public static c pr() {
        if (hw == null) {
            synchronized (c.class) {
                if (hw == null) {
                    hw = new c();
                }
            }
        }
        return hw;
    }

    public void hw() {
        if (this.w) {
            return;
        }
        this.w = true;
        Printer printerC = c();
        pr = printerC;
        Printer printer = vk;
        if (printerC == printer) {
            pr = null;
        }
        Looper.getMainLooper().setMessageLogging(printer);
    }

    private Printer c() {
        try {
            Field declaredField = Class.forName("android.os.Looper").getDeclaredField("mLogging");
            declaredField.setAccessible(true);
            return (Printer) declaredField.get(Looper.getMainLooper());
        } catch (Exception e) {
            vk.hw(e);
            return null;
        }
    }

    public void pr(long j, Runnable runnable) {
        pr(j, runnable, 1, 0L);
    }

    public void pr(long j, Runnable runnable, int i, long j2) {
        if (j < 0) {
            return;
        }
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = (int) j;
            List<Runnable> linkedList = this.fw.get(i3);
            if (linkedList == null) {
                synchronized (this.fw) {
                    linkedList = this.fw.get(i3);
                    if (linkedList == null) {
                        linkedList = new LinkedList<>();
                        this.fw.put(i3, linkedList);
                    }
                }
            }
            linkedList.add(runnable);
            j += j2;
        }
    }

    public void pr(String str) {
        if (!this.k) {
            uc.pr(32L);
            this.k = true;
        }
        this.c = SystemClock.uptimeMillis();
        try {
            pr(this.zo, str);
            this.hn.sendEmptyMessage(0);
        } catch (Exception e) {
            vk.pr(e);
        }
    }

    public void hw(String str) {
        this.uc = SystemClock.uptimeMillis();
        try {
            this.hn.removeMessages(2);
            pr(this.aj, str);
            this.hn.sendEmptyMessage(1);
        } catch (Exception e) {
            vk.hw(e);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        try {
            if (this.hn.hasMessages(0)) {
                return true;
            }
            switch (message.what) {
                case 0:
                    this.x = 0;
                    if (this.fw.size() != 0 && this.fw.keyAt(0) == 0) {
                        pr(this.fw.valueAt(0));
                        this.x++;
                    }
                    break;
                case 1:
                    this.hn.removeMessages(2);
                    if (this.fw.size() != 0) {
                        SparseArray<List<Runnable>> sparseArray = this.fw;
                        if (sparseArray.keyAt(sparseArray.size() - 1) == 0) {
                            pr(this.fw.get(Integer.MAX_VALUE));
                        }
                    }
                    return true;
                case 2:
                    pr(this.fw.valueAt(this.x));
                    this.x++;
                    break;
            }
            if (this.x >= this.fw.size()) {
                return true;
            }
            long jKeyAt = this.fw.keyAt(this.x);
            if (jKeyAt != 2147483647L) {
                this.hn.sendEmptyMessageAtTime(2, this.c + jKeyAt);
            }
            return true;
        } catch (Throwable th) {
        }
    }

    private static void pr(List<? extends Runnable> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        try {
            Iterator<? extends Runnable> it = list.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        } catch (Exception e) {
            vk.pr(e);
        }
    }

    private synchronized void pr(List<? extends Printer> list, String str) {
        if (list != null) {
            if (!list.isEmpty()) {
                try {
                    Iterator<? extends Printer> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().println(str);
                    }
                } catch (Exception e) {
                    vk.pr(e);
                }
            }
        }
    }
}
