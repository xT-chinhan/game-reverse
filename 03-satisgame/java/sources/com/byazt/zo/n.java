package com.byazt.zo;

import android.os.Handler;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 588, 19})
public class n {
    public long cp;
    public long fs;
    public final Runnable l;
    public final List<com.byazt.kv.q> n;
    public final Runnable q;
    public final List<com.byazt.kv.q> qg;
    public long rv;
    public final Handler s;
    public long tj;
    public final AtomicBoolean w;
    public final AtomicBoolean x;

    private n() {
        this.n = new CopyOnWriteArrayList();
        this.qg = new CopyOnWriteArrayList();
        this.s = com.byazt.tk.rv.s();
        this.q = new Runnable() { // from class: com.byazt.zo.n.1
            @Override // java.lang.Runnable
            public void run() {
                n.this.n(true);
            }
        };
        this.l = new Runnable() { // from class: com.byazt.zo.n.2
            @Override // java.lang.Runnable
            public void run() {
                n.this.qg();
            }
        };
        this.w = new AtomicBoolean(false);
        this.x = new AtomicBoolean(false);
        this.fs = Long.MIN_VALUE;
        this.rv = Long.MIN_VALUE;
        this.tj = Long.MIN_VALUE;
        this.cp = Long.MIN_VALUE;
    }

    /* JADX INFO: renamed from: com.byazt.zo.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 588, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    private static class C0417n {
        public static final n n = new n();
    }

    public static n n() {
        return C0417n.n;
    }

    public void n(com.byazt.kv.q qVar) {
        if (qVar == null) {
            return;
        }
        if (qVar.n() == 3) {
            qg(qVar);
        } else {
            s(qVar);
        }
    }

    private void s(com.byazt.kv.q qVar) {
        long jH = com.byazt.qt.qg.n().h();
        HashMap map = new HashMap();
        map.put("config_use_type", Integer.valueOf(com.byazt.qt.qg.n().sz()));
        map.put("config_wait_duration", Long.valueOf(jH));
        if (jH == 0) {
            qVar.n(false, map);
            return;
        }
        if (q(qVar)) {
            map.put("is_wait_success", 2);
            qVar.n(false, map);
            return;
        }
        if (!this.n.contains(qVar)) {
            if (this.rv == Long.MIN_VALUE) {
                this.rv = System.currentTimeMillis();
            }
            this.n.add(qVar);
        }
        if (this.w.compareAndSet(false, true)) {
            com.byazt.qt.qg.n().h();
            this.s.postDelayed(this.q, com.byazt.qt.qg.n().h());
        }
    }

    private boolean q(com.byazt.kv.q qVar) {
        com.byazt.ws.qg qgVarN = n(qVar.qg(), qVar.n(), 100);
        if (qgVarN == null || System.currentTimeMillis() - qgVarN.qg() >= com.byazt.qt.qg.n().m()) {
            return !com.byazt.zs.n.n().n(qVar.qg(), qVar.n(), com.byazt.yc.q.n(qVar.qg()));
        }
        com.byazt.qt.qg.n().m();
        return true;
    }

    public void n(final boolean z) {
        com.byazt.rb.l.s(new Runnable() { // from class: com.byazt.zo.n.3
            @Override // java.lang.Runnable
            public void run() {
                n.this.qg(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(boolean z) {
        synchronized (this.n) {
            if (this.n.isEmpty()) {
                this.w.set(false);
                return;
            }
            ArrayList<com.byazt.kv.q> arrayList = new ArrayList(this.n);
            this.n.clear();
            long jH = com.byazt.qt.qg.n().h();
            HashMap map = new HashMap();
            map.put("config_use_type", Integer.valueOf(com.byazt.qt.qg.n().sz()));
            map.put("config_wait_duration", Long.valueOf(jH));
            for (com.byazt.kv.q qVar : arrayList) {
                if (z) {
                    com.byazt.ws.qg qgVarN = n(qVar.qg(), qVar.n(), 100);
                    map.put("is_wait_success", 0);
                    qVar.n(qgVarN == null, map);
                } else {
                    if (this.cp == Long.MIN_VALUE) {
                        this.cp = System.currentTimeMillis() - this.rv;
                    }
                    map.put("real_wait_duration", Long.valueOf(this.cp));
                    map.put("is_wait_success", 1);
                    qVar.n(false, map);
                }
            }
            this.s.removeCallbacks(this.q);
            this.w.set(false);
        }
    }

    public void qg(com.byazt.kv.q qVar) {
        long jHu = com.byazt.qt.qg.n().hu();
        HashMap map = new HashMap();
        map.put("config_use_type", Integer.valueOf(com.byazt.qt.qg.n().sz()));
        map.put("config_wait_duration", Long.valueOf(jHu));
        if (jHu == 0) {
            qVar.n(false, map);
            return;
        }
        if (q(qVar)) {
            map.put("is_wait_success", 2);
            qVar.n(false, map);
            return;
        }
        if (!this.qg.contains(qVar)) {
            if (this.fs == Long.MIN_VALUE) {
                this.fs = System.currentTimeMillis();
            }
            this.qg.add(qVar);
        }
        if (this.x.compareAndSet(false, true)) {
            com.byazt.qt.qg.n().hu();
            this.s.postDelayed(this.l, com.byazt.qt.qg.n().hu());
        }
    }

    public void qg() {
        com.byazt.rb.l.s(new Runnable() { // from class: com.byazt.zo.n.4
            @Override // java.lang.Runnable
            public void run() {
                n.this.q();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        synchronized (this.qg) {
            if (this.qg.isEmpty()) {
                this.x.set(false);
                return;
            }
            ArrayList arrayList = new ArrayList(this.qg);
            this.qg.clear();
            long jHu = com.byazt.qt.qg.n().hu();
            HashMap map = new HashMap();
            map.put("config_use_type", Integer.valueOf(com.byazt.qt.qg.n().sz()));
            map.put("config_wait_duration", Long.valueOf(jHu));
            map.put("is_wait_success", 1);
            if (this.tj == Long.MIN_VALUE) {
                this.tj = System.currentTimeMillis() - this.fs;
            }
            map.put("real_wait_duration", Long.valueOf(this.tj));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((com.byazt.kv.q) it.next()).n(false, map);
            }
            this.s.removeCallbacks(this.l);
            this.x.set(false);
        }
    }

    private com.byazt.ws.qg n(String str, int i, int i2) {
        com.byazt.ws.qg qgVarN = com.byazt.qt.qg.n().n(str, i, i2);
        return (qgVarN == null && i == 8) ? com.byazt.qt.qg.n().n(str, 10, i2) : qgVarN;
    }

    public void s() {
        qg();
        n(false);
    }
}
