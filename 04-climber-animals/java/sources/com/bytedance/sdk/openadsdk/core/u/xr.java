package com.bytedance.sdk.openadsdk.core.u;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
public abstract class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile boolean f3369ms;
    private static volatile long xr;
    private final Queue<ms> ah = new LinkedList();
    private Handler d;

    protected abstract long ah();

    protected abstract int xr();

    protected xr() {
    }

    private synchronized boolean xr(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iXr = xr();
        long jAh = ah();
        if (this.ah.size() > 0 && this.ah.size() >= iXr) {
            long jAbs = Math.abs(jCurrentTimeMillis - this.ah.peek().f3371ms);
            if (jAbs <= jAh) {
                xr(jAh - jAbs);
                return true;
            }
            this.ah.poll();
            this.ah.offer(new ms(jCurrentTimeMillis, str));
        } else {
            this.ah.offer(new ms(jCurrentTimeMillis, str));
        }
        return false;
    }

    public synchronized boolean ms(String str) {
        if (xr(str)) {
            ms(true);
            ms(xr);
        } else {
            ms(false);
        }
        return f3369ms;
    }

    private void ms(long j) {
        if (this.d == null) {
            this.d = new Handler(Looper.getMainLooper());
        }
        this.d.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.u.xr.1
            @Override // java.lang.Runnable
            public void run() {
                xr.this.ms(false);
            }
        }, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ms(boolean z) {
        f3369ms = z;
    }

    public boolean d() {
        return f3369ms;
    }

    private synchronized void xr(long j) {
        xr = j;
    }

    public synchronized String ka() {
        String str;
        HashMap map = new HashMap();
        for (ms msVar : this.ah) {
            if (map.containsKey(msVar.xr)) {
                map.put(msVar.xr, Integer.valueOf(((Integer) map.get(msVar.xr)).intValue() + 1));
            } else {
                map.put(msVar.xr, 1);
            }
        }
        str = "";
        int i = Integer.MIN_VALUE;
        for (String str2 : map.keySet()) {
            int iIntValue = ((Integer) map.get(str2)).intValue();
            if (i < iIntValue) {
                str = str2;
                i = iIntValue;
            }
        }
        return str;
    }

    private static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final long f3371ms;
        private final String xr;

        private ms(long j, String str) {
            this.f3371ms = j;
            this.xr = str;
        }
    }
}
