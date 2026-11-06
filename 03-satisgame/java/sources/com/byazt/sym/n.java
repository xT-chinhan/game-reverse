package com.byazt.sym;

import android.os.SystemClock;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 78, 19})
public final class n {
    public static final ThreadLocal<C0345n> n = new ThreadLocal<>();
    public static final AtomicLong qg = new AtomicLong();

    public static C0345n n(String str, String str2) {
        ThreadLocal<C0345n> threadLocal = n;
        C0345n c0345n = threadLocal.get();
        if (c0345n == null) {
            c0345n = new C0345n(qg(), str, str2, s());
            threadLocal.set(c0345n);
        }
        c0345n.n(str, str2);
        return c0345n;
    }

    public static void n() {
        ThreadLocal<C0345n> threadLocal = n;
        C0345n c0345n = threadLocal.get();
        if (c0345n == null) {
            return;
        }
        c0345n.n();
        if (c0345n.l <= 0) {
            threadLocal.remove();
        }
    }

    private static String qg() {
        long jNanoTime;
        try {
            jNanoTime = SystemClock.elapsedRealtimeNanos();
        } catch (RuntimeException unused) {
            jNanoTime = System.nanoTime();
        }
        return Long.toHexString(jNanoTime) + '-' + Long.toHexString(qg.getAndIncrement());
    }

    private static long s() {
        try {
            return SystemClock.uptimeMillis();
        } catch (RuntimeException unused) {
            return System.currentTimeMillis();
        }
    }

    /* JADX INFO: renamed from: com.byazt.sym.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 78, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    public static final class C0345n {
        public int l;
        public final String n;
        public String q;
        public final long qg;
        public String s;
        public final Deque<String> w = new ArrayDeque();
        public final Deque<String> x = new ArrayDeque();

        public C0345n(String str, String str2, String str3, long j) {
            this.n = str;
            this.qg = j;
            this.s = str2;
            this.q = str3;
        }

        public void n(String str, String str2) {
            if (str == null) {
                str = "";
            }
            if (str2 == null) {
                str2 = "";
            }
            this.w.push(str);
            this.x.push(str2);
            this.s = str;
            this.q = str2;
            this.l++;
        }

        public void n() {
            int i = this.l;
            if (i <= 0) {
                return;
            }
            this.l = i - 1;
            if (!this.w.isEmpty()) {
                this.w.pop();
            }
            if (!this.x.isEmpty()) {
                this.x.pop();
            }
            this.s = this.w.peek();
            this.q = this.x.peek();
        }
    }
}
