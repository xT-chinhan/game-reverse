package com.ss.android.socialbase.downloader.c;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
class ab {
    private final ah ab;
    private final DownloadInfo ah;
    private final boolean ao;
    private final com.ss.android.socialbase.downloader.x.c c;
    private long h;
    private final com.ss.android.socialbase.downloader.ab.ms ka;
    private final long u;
    private final long ub;
    private BaseException x;
    private final boolean zb;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final List<sl> f4613ms = new LinkedList();
    private final List<sl> xr = new ArrayList();
    private volatile boolean ny = false;
    private volatile boolean ch = false;
    private volatile boolean hi = false;
    private volatile long qv = 0;
    private volatile long y = 0;
    private final com.ss.android.socialbase.downloader.downloader.ch d = com.ss.android.socialbase.downloader.downloader.ah.w();
    private final com.ss.android.socialbase.downloader.ms.ms sl = com.ss.android.socialbase.downloader.ms.ms.ms();

    private boolean ms(long j, long j2) {
        return j > 65536 && j2 > 500;
    }

    ab(DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.x.c cVar, ah ahVar) {
        this.ah = downloadInfo;
        this.c = cVar;
        this.ab = ahVar;
        com.ss.android.socialbase.downloader.ab.ms msVarMs = com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId());
        this.ka = msVarMs;
        boolean z = msVarMs.ms("sync_strategy", 0) == 1;
        this.zb = z;
        if (z) {
            long jMs = msVarMs.ms("sync_interval_ms_fg", 5000);
            long jMs2 = msVarMs.ms("sync_interval_ms_bg", 1000);
            this.u = Math.max(jMs, 500L);
            this.ub = Math.max(jMs2, 500L);
        } else {
            this.u = 0L;
            this.ub = 0L;
        }
        this.ao = msVarMs.xr("monitor_rw") == 1;
    }

    void ms(sl slVar) {
        synchronized (this) {
            this.f4613ms.add(slVar);
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 10781. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    void ms(com.ss.android.socialbase.downloader.c.d r31) throws com.ss.android.socialbase.downloader.exception.BaseException {
        /*
            Method dump skipped, instruction units count: 1078
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.c.ab.ms(com.ss.android.socialbase.downloader.c.d):void");
    }

    private void ms(long j, boolean z) throws IOException {
        long j2 = j - this.y;
        if (this.zb) {
            if (j2 <= (this.sl.xr() ? this.u : this.ub)) {
                return;
            }
        } else {
            long curBytes = this.ah.getCurBytes() - this.qv;
            if (!z && !ms(curBytes, j2)) {
                return;
            }
        }
        ah();
        this.y = j;
    }

    private void ms(ka kaVar) {
        synchronized (this) {
            this.xr.add((sl) kaVar);
        }
    }

    private void ah() throws IOException {
        boolean z;
        boolean z2 = this.ao;
        long jNanoTime = z2 ? System.nanoTime() : 0L;
        DownloadInfo downloadInfo = this.ah;
        com.ss.android.socialbase.downloader.downloader.ch chVar = this.d;
        List<sl> list = this.f4613ms;
        List<sl> list2 = this.xr;
        Map<Long, ny> mapSl = chVar.sl(downloadInfo.getId());
        if (mapSl == null) {
            mapSl = new HashMap<>(4);
        }
        synchronized (this) {
            ms(list);
            try {
                xr(list);
                z = true;
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.api.ab.ms(th);
                z = false;
            }
            ms(list, mapSl);
            if (list2.size() > 0) {
                ah(list2);
                list.removeAll(list2);
                list2.clear();
            }
        }
        if (z) {
            downloadInfo.updateRealDownloadTime(true);
            chVar.ms(downloadInfo.getId(), mapSl);
            chVar.ms(downloadInfo);
            this.qv = downloadInfo.getCurBytes();
        }
        if (z2) {
            this.h += System.nanoTime() - jNanoTime;
        }
    }

    private void ms(List<sl> list) throws IOException {
        Iterator<sl> it = list.iterator();
        while (it.hasNext()) {
            it.next().xr();
        }
    }

    private void xr(List<sl> list) throws IOException {
        Iterator<sl> it = list.iterator();
        while (it.hasNext()) {
            it.next().ah();
        }
    }

    private void ah(List<sl> list) {
        Iterator<sl> it = list.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
    }

    private void ms(List<sl> list, Map<Long, ny> map) {
        Iterator<sl> it = list.iterator();
        while (it.hasNext()) {
            ny nyVarKa = it.next().ka();
            ny nyVar = map.get(Long.valueOf(nyVarKa.ah()));
            if (nyVar == null) {
                map.put(Long.valueOf(nyVarKa.ah()), new ny(nyVarKa));
            } else {
                nyVar.ms(nyVarKa.d());
                nyVar.ah(nyVarKa.c());
            }
        }
    }

    public void ms() {
        this.hi = true;
        this.ny = true;
    }

    public void xr() {
        this.ch = true;
        this.ny = true;
    }
}
