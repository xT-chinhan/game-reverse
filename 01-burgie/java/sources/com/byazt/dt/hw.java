package com.byazt.dt;

import android.os.Handler;
import android.os.Looper;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1167, 13})
public abstract class hw {
    public static volatile long hw;
    public static volatile boolean pr;
    public final Queue<pr> hn = new LinkedList();
    public Handler x;

    public abstract long hn();

    public abstract int hw();

    private synchronized boolean hw(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iHw = hw();
        long jHn = hn();
        if (this.hn.size() > 0 && this.hn.size() >= iHw) {
            long jAbs = Math.abs(jCurrentTimeMillis - this.hn.peek().pr);
            if (jAbs <= jHn) {
                hw(jHn - jAbs);
                return true;
            }
            this.hn.poll();
            this.hn.offer(new pr(jCurrentTimeMillis, str));
        } else {
            this.hn.offer(new pr(jCurrentTimeMillis, str));
        }
        return false;
    }

    public synchronized boolean pr(String str) {
        if (hw(str)) {
            pr(true);
            pr(hw);
        } else {
            pr(false);
        }
        return pr;
    }

    private void pr(long j) {
        if (this.x == null) {
            this.x = new Handler(Looper.getMainLooper());
        }
        this.x.postDelayed(new Runnable() { // from class: com.byazt.dt.hw.1
            @Override // java.lang.Runnable
            public void run() {
                hw.this.pr(false);
            }
        }, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void pr(boolean z) {
        pr = z;
    }

    public boolean x() {
        return pr;
    }

    private synchronized void hw(long j) {
        hw = j;
    }

    public synchronized String c() {
        String str;
        HashMap map = new HashMap();
        for (pr prVar : this.hn) {
            if (map.containsKey(prVar.hw)) {
                map.put(prVar.hw, Integer.valueOf(((Integer) map.get(prVar.hw)).intValue() + 1));
            } else {
                map.put(prVar.hw, 1);
            }
        }
        int i = Integer.MIN_VALUE;
        str = "";
        for (String str2 : map.keySet()) {
            int iIntValue = ((Integer) map.get(str2)).intValue();
            if (i < iIntValue) {
                str = str2;
                i = iIntValue;
            }
        }
        return str;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 1167, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    private static class pr {
        public final String hw;
        public final long pr;

        private pr(long j, String str) {
            this.pr = j;
            this.hw = str;
        }
    }
}
