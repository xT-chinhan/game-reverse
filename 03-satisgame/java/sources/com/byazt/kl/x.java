package com.byazt.kl;

import com.anythink.china.a.c;
import com.byazt.qx.BaseException;
import com.byazt.wm.DownloadInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 445, 21})
public class x {
    public final boolean cy;
    public BaseException fs;
    public long hd;
    public final long k;
    public final com.byazt.f.n l;
    public final boolean oa;
    public final DownloadInfo s;
    public final long sz;
    public final com.byazt.l.w w;
    public final s x;
    public final List<d> n = new LinkedList();
    public final List<d> qg = new ArrayList();
    public volatile boolean rv = false;
    public volatile boolean tj = false;
    public volatile boolean cp = false;
    public volatile long cd = 0;
    public volatile long um = 0;
    public final com.byazt.xv.tj q = com.byazt.xv.s.hu();
    public final com.byazt.b.n d = com.byazt.b.n.n();

    private boolean n(long j, long j2) {
        return j > c.q && j2 > 500;
    }

    public x(DownloadInfo downloadInfo, com.byazt.l.w wVar, s sVar) {
        this.s = downloadInfo;
        this.w = wVar;
        this.x = sVar;
        com.byazt.f.n nVarN = com.byazt.f.n.n(downloadInfo.getId());
        this.l = nVarN;
        boolean z = nVarN.n("sync_strategy", 0) == 1;
        this.oa = z;
        if (z) {
            long jN = nVarN.n("sync_interval_ms_fg", 5000);
            long jN2 = nVarN.n("sync_interval_ms_bg", 1000);
            this.sz = Math.max(jN, 500L);
            this.k = Math.max(jN2, 500L);
        } else {
            this.sz = 0L;
            this.k = 0L;
        }
        this.cy = nVarN.qg("monitor_rw") == 1;
    }

    public void n(d dVar) {
        synchronized (this) {
            this.n.add(dVar);
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 10661. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public void n(com.byazt.kl.q r31) throws com.byazt.qx.BaseException {
        /*
            Method dump skipped, instruction units count: 1066
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.byazt.kl.x.n(com.byazt.kl.q):void");
    }

    private void n(long j, boolean z) throws IOException {
        long j2 = j - this.um;
        if (this.oa) {
            if (j2 <= (this.d.qg() ? this.sz : this.k)) {
                return;
            }
        } else {
            long curBytes = this.s.getCurBytes() - this.cd;
            if (!z && !n(curBytes, j2)) {
                return;
            }
        }
        s();
        this.um = j;
    }

    private void n(l lVar) {
        synchronized (this) {
            this.qg.add((d) lVar);
        }
    }

    private void s() throws IOException {
        boolean z;
        boolean z2 = this.cy;
        long jNanoTime = z2 ? System.nanoTime() : 0L;
        DownloadInfo downloadInfo = this.s;
        com.byazt.xv.tj tjVar = this.q;
        List<d> list = this.n;
        List<d> list2 = this.qg;
        Map<Long, rv> mapD = tjVar.d(downloadInfo.getId());
        if (mapD == null) {
            mapD = new HashMap<>(4);
        }
        synchronized (this) {
            n(list);
            try {
                qg(list);
                z = true;
            } catch (Throwable unused) {
                z = false;
            }
            n(list, mapD);
            if (list2.size() > 0) {
                s(list2);
                list.removeAll(list2);
                list2.clear();
            }
        }
        if (z) {
            downloadInfo.updateRealDownloadTime(true);
            tjVar.n(downloadInfo.getId(), mapD);
            tjVar.n(downloadInfo);
            this.cd = downloadInfo.getCurBytes();
        }
        if (z2) {
            this.hd += System.nanoTime() - jNanoTime;
        }
    }

    private void n(List<d> list) throws IOException {
        Iterator<d> it = list.iterator();
        while (it.hasNext()) {
            it.next().qg();
        }
    }

    private void qg(List<d> list) throws IOException {
        Iterator<d> it = list.iterator();
        while (it.hasNext()) {
            it.next().s();
        }
    }

    private void s(List<d> list) {
        Iterator<d> it = list.iterator();
        while (it.hasNext()) {
            it.next().q();
        }
    }

    private void n(List<d> list, Map<Long, rv> map) {
        Iterator<d> it = list.iterator();
        while (it.hasNext()) {
            rv rvVarL = it.next().l();
            rv rvVar = map.get(Long.valueOf(rvVarL.s()));
            if (rvVar == null) {
                map.put(Long.valueOf(rvVarL.s()), new rv(rvVarL));
            } else {
                rvVar.n(rvVarL.q());
                rvVar.s(rvVarL.w());
            }
        }
    }

    public void n() {
        this.cp = true;
        this.rv = true;
    }

    public void qg() {
        this.tj = true;
        this.rv = true;
    }
}
