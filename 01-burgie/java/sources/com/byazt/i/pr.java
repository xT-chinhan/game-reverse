package com.byazt.i;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.update.download.core.Util;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO, 37})
public abstract class pr implements fw {
    public static final AtomicLong k = new AtomicLong();
    public volatile zo aj;
    public com.byazt.v.pr c;
    public volatile String fw;
    public final com.byazt.d.hn hw;
    public volatile com.byazt.j.pr pr;
    public volatile List<uc.hw> uc;
    public volatile String zo;
    public final AtomicInteger hn = new AtomicInteger();
    public final AtomicLong x = new AtomicLong();
    public volatile boolean vk = false;
    public final long w = k.incrementAndGet();
    public final AtomicInteger m = new AtomicInteger(0);
    public int g = -1;

    public pr(com.byazt.j.pr prVar, com.byazt.d.hn hnVar) {
        this.pr = prVar;
        this.hw = hnVar;
    }

    public void pr() {
        this.m.compareAndSet(0, 1);
    }

    public boolean hw() {
        return this.m.get() == 1;
    }

    public void hn() {
        this.m.compareAndSet(0, 2);
    }

    public void x() throws com.byazt.m.pr {
        if (hw()) {
            throw new com.byazt.m.pr();
        }
    }

    public com.byazt.aj.pr pr(zo.pr prVar, int i, int i2, String str) throws IOException {
        com.byazt.aj.hw hwVarHw = com.byazt.aj.hn.pr().hw();
        com.byazt.aj.c cVar = new com.byazt.aj.c();
        HashMap map = new HashMap();
        cVar.hw = prVar.pr;
        cVar.pr = 0;
        if (Util.METHOD_HEAD.equalsIgnoreCase(str)) {
            cVar.pr = 4;
        }
        List<uc.hw> list = this.uc;
        if (list != null && !list.isEmpty()) {
            for (uc.hw hwVar : list) {
                if (!Util.RANGE.equalsIgnoreCase(hwVar.pr) && !"Connection".equalsIgnoreCase(hwVar.pr) && !"Proxy-Connection".equalsIgnoreCase(hwVar.pr) && !"Host".equalsIgnoreCase(hwVar.pr)) {
                    map.put(hwVar.pr, hwVar.hw);
                }
            }
        }
        String strPr = com.byazt.a.pr.pr(i, i2);
        if (strPr != null) {
            map.put(Util.RANGE, strPr);
        }
        if (x.zo) {
            map.put("Cache-Control", "no-cache");
        }
        cVar.c = map;
        if (this.vk) {
            this.vk = false;
            return null;
        }
        return hwVarHw.pr(cVar);
    }

    public int c() {
        return this.pr instanceof com.byazt.j.hw ? 1 : 0;
    }

    public boolean uc() {
        return c() == 1;
    }

    public void pr(int i, int i2) {
        if (i <= 0 || i2 < 0) {
            return;
        }
        int i3 = x.aj;
        int iC = c();
        if (i3 == 1 || (i3 == 2 && iC == 1)) {
            int i4 = (int) ((i2 / i) * 100.0f);
            if (i4 > 100) {
                i4 = 100;
            }
            synchronized (this) {
                if (i4 <= this.g) {
                    return;
                }
                this.g = i4;
                com.byazt.a.pr.hw(new Runnable() { // from class: com.byazt.i.pr.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (pr.this.c != null) {
                            zo zoVar = pr.this.aj;
                            int unused = pr.this.g;
                        }
                    }
                });
            }
        }
    }
}
