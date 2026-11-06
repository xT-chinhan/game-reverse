package com.ss.android.socialbase.downloader.c;

import android.text.TextUtils;
import com.anythink.basead.exoplayer.i.a;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.taptap.sdk.kit.internal.p000const.TrackAction;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class hi implements c, com.ss.android.socialbase.downloader.network.ah.ms {
    private final xr ah;
    private int ao;
    private com.ss.android.socialbase.downloader.model.d ch;
    private final com.ss.android.socialbase.downloader.x.c d;
    private BaseException h;
    private com.ss.android.socialbase.downloader.model.d hi;
    private long i;
    private final ab ka;
    private final boolean le;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final DownloadInfo f4616ms;
    private final com.ss.android.socialbase.downloader.x.ka nw;
    private int op;
    private volatile boolean qv;
    private long re;
    private final com.ss.android.socialbase.downloader.ny.ka t;
    private long w;
    private final u xr;
    private float yu;
    private long zb;
    private volatile boolean c = false;
    private volatile boolean ab = false;
    private final List<zb> x = new ArrayList();
    private final List<h> ny = new ArrayList();
    private volatile boolean sl = true;
    private final LinkedList<ny> u = new LinkedList<>();
    private final List<ny> ub = new ArrayList();
    private final Object y = new Object();
    private volatile boolean b = false;
    private final com.ss.android.socialbase.downloader.x.ka.xr cv = new com.ss.android.socialbase.downloader.x.ka.xr() { // from class: com.ss.android.socialbase.downloader.c.hi.1
        private int xr;

        @Override // com.ss.android.socialbase.downloader.x.ka.xr
        public long ms() {
            if (hi.this.c || hi.this.ab) {
                return -1L;
            }
            synchronized (hi.this) {
                if (hi.this.ch == null && hi.this.hi == null) {
                    long j = hi.this.re;
                    if (j <= 0) {
                        return -1L;
                    }
                    this.xr++;
                    zb zbVarMs = hi.this.ms(false, System.currentTimeMillis(), j);
                    if (zbVarMs == null) {
                        return j;
                    }
                    com.bytedance.sdk.openadsdk.api.ab.ah("SegmentDispatcher", "connectWatcher: switchUrl and reconnect");
                    hi.this.ah(zbVarMs);
                    zbVarMs.c();
                    return ((long) ((this.xr / hi.this.ny.size()) + 1)) * j;
                }
                return -1L;
            }
        }
    };
    private final com.ss.android.socialbase.downloader.x.ka.xr g = new com.ss.android.socialbase.downloader.x.ka.xr() { // from class: com.ss.android.socialbase.downloader.c.hi.2
        @Override // com.ss.android.socialbase.downloader.x.ka.xr
        public long ms() {
            return hi.this.qv();
        }
    };

    public hi(DownloadInfo downloadInfo, u uVar, com.ss.android.socialbase.downloader.x.c cVar) {
        this.f4616ms = downloadInfo;
        this.xr = uVar;
        xr xrVar = new xr(uVar.d(), uVar.ka());
        this.ah = xrVar;
        this.d = cVar;
        this.ka = new ab(downloadInfo, cVar, xrVar);
        this.nw = new com.ss.android.socialbase.downloader.x.ka();
        this.t = new com.ss.android.socialbase.downloader.ny.ka();
        this.le = com.ss.android.socialbase.downloader.ab.ms.ms(downloadInfo.getId()).xr("debug") == 1;
    }

    public boolean ms(List<ny> list) throws InterruptedException, BaseException {
        try {
            c();
            xr(list);
            ka();
            ab();
            ny();
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                ah();
                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                this.f4616ms.increaseAllConnectTime(jCurrentTimeMillis2);
                this.f4616ms.setFirstSpeedTime(jCurrentTimeMillis2);
                if (!this.ab && !this.c) {
                    this.d.ms(this.zb);
                    x();
                    d();
                    if (!this.ab && !this.c) {
                        com.ss.android.socialbase.downloader.ah.ms.ah("SegmentDispatcher", "finally pause");
                        xr();
                    }
                    this.nw.xr();
                    return true;
                }
                if (!this.ab && !this.c) {
                    com.ss.android.socialbase.downloader.ah.ms.ah("SegmentDispatcher", "finally pause");
                    xr();
                }
                this.nw.xr();
                return true;
            } catch (Throwable th) {
                long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis;
                this.f4616ms.increaseAllConnectTime(jCurrentTimeMillis3);
                this.f4616ms.setFirstSpeedTime(jCurrentTimeMillis3);
                throw th;
            }
        } catch (Throwable th2) {
            if (!this.ab && !this.c) {
                com.ss.android.socialbase.downloader.ah.ms.ah("SegmentDispatcher", "finally pause");
                xr();
            }
            this.nw.xr();
            throw th2;
        }
    }

    private void xr(List<ny> list) {
        long totalBytes = this.f4616ms.getTotalBytes();
        this.zb = totalBytes;
        if (totalBytes <= 0) {
            this.zb = this.f4616ms.getExpectFileLength();
            com.ss.android.socialbase.downloader.ah.ms.ah("SegmentDispatcher", "initSegments: getExpectFileLength = " + this.zb);
        }
        synchronized (this) {
            this.u.clear();
            if (list == null || list.isEmpty()) {
                ms((List<ny>) this.u, new ny(0L, -1L), false);
            } else {
                Iterator<ny> it = list.iterator();
                while (it.hasNext()) {
                    ms((List<ny>) this.u, new ny(it.next()), false);
                }
                d(this.u);
                ah(this.u);
            }
            com.ss.android.socialbase.downloader.ah.ms.ah("SegmentDispatcher", "initSegments: totalLength = " + this.zb);
        }
    }

    private void ah() throws InterruptedException, BaseException {
        BaseException baseException;
        synchronized (this.y) {
            if (this.ch == null && this.hi == null) {
                this.y.wait();
            }
        }
        if (this.ch == null && this.hi == null && (baseException = this.h) != null) {
            throw baseException;
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0049 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d() throws org.json.JSONException, com.ss.android.socialbase.downloader.exception.BaseException {
        /*
            r4 = this;
            com.ss.android.socialbase.downloader.c.ab r0 = r4.ka     // Catch: com.ss.android.socialbase.downloader.exception.BaseException -> L8 com.ss.android.socialbase.downloader.c.ao -> L1c
            com.ss.android.socialbase.downloader.c.xr r1 = r4.ah     // Catch: com.ss.android.socialbase.downloader.exception.BaseException -> L8 com.ss.android.socialbase.downloader.c.ao -> L1c
            r0.ms(r1)     // Catch: com.ss.android.socialbase.downloader.exception.BaseException -> L8 com.ss.android.socialbase.downloader.c.ao -> L1c
            goto L1c
        L8:
            r0 = move-exception
            java.lang.String r1 = "SegmentDispatcher"
            java.lang.String r2 = "dispatchSegments: loopAndWrite e = "
            java.lang.String r3 = java.lang.String.valueOf(r0)
            java.lang.String r2 = r2.concat(r3)
            com.ss.android.socialbase.downloader.ah.ms.ka(r1, r2)
            r4.ms(r0)
            throw r0
        L1c:
            boolean r0 = r4.ab
            if (r0 != 0) goto L8d
            boolean r0 = r4.c
            if (r0 == 0) goto L25
            goto L8d
        L25:
            monitor-enter(r4)     // Catch: java.lang.Throwable -> L49
        L26:
            java.util.LinkedList<com.ss.android.socialbase.downloader.c.ny> r0 = r4.u     // Catch: java.lang.Throwable -> L46
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L46
            if (r0 != 0) goto L3f
            java.util.LinkedList<com.ss.android.socialbase.downloader.c.ny> r0 = r4.u     // Catch: java.lang.Throwable -> L46
            java.lang.Object r0 = r0.poll()     // Catch: java.lang.Throwable -> L46
            com.ss.android.socialbase.downloader.c.ny r0 = (com.ss.android.socialbase.downloader.c.ny) r0     // Catch: java.lang.Throwable -> L46
            if (r0 == 0) goto L26
            java.util.List<com.ss.android.socialbase.downloader.c.ny> r1 = r4.ub     // Catch: java.lang.Throwable -> L46
            r2 = 1
            r4.ms(r1, r0, r2)     // Catch: java.lang.Throwable -> L46
            goto L26
        L3f:
            java.util.List<com.ss.android.socialbase.downloader.c.ny> r0 = r4.ub     // Catch: java.lang.Throwable -> L46
            r4.ah(r0)     // Catch: java.lang.Throwable -> L46
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L46
            goto L4d
        L46:
            r0 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L46
            throw r0     // Catch: java.lang.Throwable -> L49
        L49:
            r0 = move-exception
            com.bytedance.sdk.openadsdk.api.ab.ms(r0)
        L4d:
            boolean r0 = r4.b
            if (r0 == 0) goto L6f
            com.ss.android.socialbase.downloader.exception.BaseException r0 = r4.h
            if (r0 != 0) goto L56
            goto L6f
        L56:
            java.lang.String r0 = "SegmentDispatcher"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "dispatchSegments: loopAndWrite  failedException = "
            r1.<init>(r2)
            com.ss.android.socialbase.downloader.exception.BaseException r2 = r4.h
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.ss.android.socialbase.downloader.ah.ms.ka(r0, r1)
            com.ss.android.socialbase.downloader.exception.BaseException r0 = r4.h
            throw r0
        L6f:
            com.ss.android.socialbase.downloader.model.DownloadInfo r0 = r4.f4616ms
            long r0 = r0.getCurBytes()
            com.ss.android.socialbase.downloader.model.DownloadInfo r2 = r4.f4616ms
            long r2 = r2.getTotalBytes()
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L86
            com.ss.android.socialbase.downloader.model.DownloadInfo r0 = r4.f4616ms
            java.util.List<com.ss.android.socialbase.downloader.c.ny> r1 = r4.ub
            com.ss.android.socialbase.downloader.d.ms.ms(r0, r1)
        L86:
            java.lang.String r0 = "SegmentDispatcher"
            java.lang.String r1 = "dispatchSegments::download finished"
            com.ss.android.socialbase.downloader.ah.ms.ah(r0, r1)
        L8d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.c.hi.d():void");
    }

    private void ah(List<ny> list) {
        long jXr = ub.xr(list);
        com.ss.android.socialbase.downloader.ah.ms.ah("SegmentDispatcher", "checkDownloadBytes: getCurBytes = " + this.f4616ms.getCurBytes() + ", totalBytes = " + this.f4616ms.getTotalBytes() + ", downloadedBytes = " + jXr);
        if (jXr > this.f4616ms.getTotalBytes() && this.f4616ms.getTotalBytes() > 0) {
            jXr = this.f4616ms.getTotalBytes();
        }
        if (this.f4616ms.getCurBytes() == this.f4616ms.getTotalBytes() || this.f4616ms.getCurBytes() == jXr) {
            return;
        }
        this.f4616ms.setCurBytes(jXr);
    }

    private void ka() {
        int iMs;
        if (this.zb <= 0 || this.sl) {
            iMs = 1;
        } else {
            iMs = this.xr.ms();
            int iX = (int) (this.zb / this.xr.x());
            if (iMs > iX) {
                iMs = iX;
            }
        }
        com.ss.android.socialbase.downloader.ah.ms.ah("SegmentDispatcher", "dispatchReadThread: totalLength = " + this.zb + ", threadCount = " + iMs);
        int i = iMs > 0 ? iMs : 1;
        synchronized (this) {
            while (this.x.size() < i) {
                if (!this.ab && !this.c) {
                    ms(ch());
                    if (this.xr.c()) {
                        break;
                    }
                }
                return;
            }
        }
    }

    private void c() {
        this.ny.add(new h(this.f4616ms.getUrl(), true));
        List<String> backUpUrls = this.f4616ms.getBackUpUrls();
        if (backUpUrls != null) {
            for (String str : backUpUrls) {
                if (!TextUtils.isEmpty(str)) {
                    this.ny.add(new h(str, false));
                }
            }
        }
        this.xr.ms(this.ny.size());
    }

    private void ab() {
        u uVar = this.xr;
        this.re = uVar.ch();
        this.i = uVar.hi();
        this.yu = uVar.ub();
        int i = this.op;
        if (i > 0) {
            this.nw.ms(this.cv, i);
        }
    }

    private void x() {
        if (this.i > 0) {
            this.w = System.currentTimeMillis();
            this.nw.ms(this.g, 0L);
        }
    }

    private void ny() {
        List<String> backUpUrls;
        int iSl = this.xr.sl();
        if (iSl <= 0) {
            this.sl = false;
            ka();
            return;
        }
        com.ss.android.socialbase.downloader.network.ah ahVarMs = com.ss.android.socialbase.downloader.network.ah.ms();
        ahVarMs.ms(this.f4616ms.getUrl(), this, a.f);
        if (iSl <= 2 || (backUpUrls = this.f4616ms.getBackUpUrls()) == null) {
            return;
        }
        for (String str : backUpUrls) {
            if (!TextUtils.isEmpty(str)) {
                ahVarMs.ms(str, this, a.f);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.ah.ms
    public void ms(String str, List<InetAddress> list) {
        List<h> listAh;
        if (this.ab || this.c) {
            return;
        }
        try {
            listAh = ah(str, list);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
            listAh = null;
        }
        synchronized (this) {
            if (listAh != null) {
                xr(str, listAh);
                this.sl = false;
                this.xr.ms(this.ny.size());
                com.bytedance.sdk.openadsdk.api.ab.ah("SegmentDispatcher", "onDnsResolved: dispatchReadThread");
                ka();
            } else {
                this.sl = false;
                this.xr.ms(this.ny.size());
                com.bytedance.sdk.openadsdk.api.ab.ah("SegmentDispatcher", "onDnsResolved: dispatchReadThread");
                ka();
            }
            throw th;
        }
    }

    private void xr(String str, List<h> list) {
        int iMs;
        if (this.le) {
            Iterator<h> it = list.iterator();
            while (it.hasNext()) {
                com.bytedance.sdk.openadsdk.api.ab.ah("SegmentDispatcher", "addIpListLocked: urlRecord = ".concat(String.valueOf(it.next())));
            }
        }
        int iSl = this.xr.sl();
        if ((iSl == 1 || iSl == 3) && (iMs = ms(str)) >= 0 && iMs < this.ny.size()) {
            this.ny.addAll(iMs + 1, list);
        } else {
            this.ny.addAll(list);
        }
    }

    private int ms(String str) {
        int size = this.ny.size();
        for (int i = 0; i < size; i++) {
            if (TextUtils.equals(this.ny.get(i).f4615ms, str)) {
                return i;
            }
        }
        return -1;
    }

    private List<h> ah(String str, List<InetAddress> list) {
        boolean z;
        if (list != null && !list.isEmpty()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i = 0;
            for (InetAddress inetAddress : list) {
                if (inetAddress != null) {
                    String hostAddress = inetAddress.getHostAddress();
                    if (!TextUtils.isEmpty(hostAddress)) {
                        if (this.le) {
                            com.bytedance.sdk.openadsdk.api.ab.ah("SegmentDispatcher", "onDnsResolved: ip = ".concat(String.valueOf(hostAddress)));
                        }
                        h hVar = new h(str, hostAddress);
                        LinkedList linkedList = (LinkedList) linkedHashMap.get(hVar.ah);
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                            linkedHashMap.put(hVar.ah, linkedList);
                        }
                        linkedList.add(hVar);
                        i++;
                    }
                }
            }
            if (i > 0) {
                ArrayList arrayList = new ArrayList();
                do {
                    Iterator it = linkedHashMap.entrySet().iterator();
                    z = false;
                    while (it.hasNext()) {
                        LinkedList linkedList2 = (LinkedList) ((Map.Entry) it.next()).getValue();
                        if (linkedList2 != null && !linkedList2.isEmpty()) {
                            arrayList.add((h) linkedList2.pollFirst());
                            i--;
                            z = true;
                        }
                    }
                    if (i <= 0) {
                        break;
                    }
                } while (z);
                return arrayList;
            }
        }
        return null;
    }

    private h ch() {
        h hVar;
        synchronized (this) {
            int size = this.ao % this.ny.size();
            if (this.xr.xr()) {
                this.ao++;
            }
            hVar = this.ny.get(size);
        }
        return hVar;
    }

    private void ms(List<ny> list, ny nyVar, boolean z) {
        long jAh = nyVar.ah();
        int size = list.size();
        int i = 0;
        while (i < size && jAh >= list.get(i).ah()) {
            i++;
        }
        list.add(i, nyVar);
        if (z) {
            nyVar.ms(size);
        }
    }

    private void d(List<ny> list) {
        ny nyVar = list.get(0);
        long jAh = nyVar.ah();
        if (jAh > 0) {
            ny nyVar2 = new ny(0L, jAh - 1);
            com.bytedance.sdk.openadsdk.api.ab.d("SegmentDispatcher", "fixSegmentsLocked: first = " + nyVar + ", add new first = " + nyVar2);
            ms(list, nyVar2, true);
        }
        Iterator<ny> it = list.iterator();
        if (it.hasNext()) {
            ny next = it.next();
            while (it.hasNext()) {
                ny next2 = it.next();
                if (next.c() < next2.ah() - 1) {
                    com.ss.android.socialbase.downloader.ah.ms.d("SegmentDispatcher", "fixSegment: segment = " + next + ", new end = " + (next2.ah() - 1));
                    next.ah(next2.ah() - 1);
                }
                next = next2;
            }
        }
        ny nyVar3 = list.get(list.size() - 1);
        long totalBytes = this.f4616ms.getTotalBytes();
        if (totalBytes <= 0 || (nyVar3.c() != -1 && nyVar3.c() < totalBytes - 1)) {
            com.ss.android.socialbase.downloader.ah.ms.d("SegmentDispatcher", "fixSegment: last segment = " + nyVar3 + ", new end=-1");
            nyVar3.ah(-1L);
        }
    }

    private void ms(h hVar) {
        zb zbVar = new zb(this.f4616ms, this, this.ah, hVar, this.x.size());
        this.x.add(zbVar);
        zbVar.ms(com.ss.android.socialbase.downloader.downloader.ah.h().submit(zbVar));
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public void ms(zb zbVar) {
        if (this.le) {
            com.ss.android.socialbase.downloader.ah.ms.ah("SegmentDispatcher", "onReaderRun, threadIndex = " + zbVar.ah);
        }
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public ny ms(zb zbVar, h hVar) {
        if (this.c || this.ab) {
            return null;
        }
        synchronized (this) {
            ny nyVarXr = xr(zbVar, hVar);
            if (nyVarXr != null) {
                nyVarXr.x();
                if (nyVarXr.ch() > 1) {
                    return new ny(nyVarXr);
                }
            }
            return nyVarXr;
        }
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public void ms(zb zbVar, ny nyVar) {
        synchronized (this) {
            nyVar.ny();
        }
    }

    private ny xr(zb zbVar, h hVar) {
        while (!this.u.isEmpty()) {
            ny nyVarPoll = this.u.poll();
            if (nyVarPoll != null) {
                ms(this.ub, nyVarPoll, true);
                if (ms(nyVarPoll) > 0 || this.zb <= 0) {
                    return nyVarPoll;
                }
            }
        }
        zb();
        ny nyVarAh = ah(zbVar, hVar);
        if (nyVarAh != null && ms(nyVarAh) > 0) {
            ms(this.ub, nyVarAh, true);
            return nyVarAh;
        }
        ny nyVarAo = ao();
        if (nyVarAo != null) {
            return nyVarAo;
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public void ms(zb zbVar, ny nyVar, h hVar, com.ss.android.socialbase.downloader.model.d dVar) throws com.ss.android.socialbase.downloader.exception.ny, BaseException {
        synchronized (this) {
            if (this.c || this.ab) {
                throw new ao("connected");
            }
            xr(zbVar, nyVar, hVar, dVar);
            zbVar.xr(false);
            if (this.zb <= 0) {
                long totalBytes = this.f4616ms.getTotalBytes();
                this.zb = totalBytes;
                if (totalBytes <= 0) {
                    this.zb = dVar.ch();
                }
                ka();
            } else if (this.xr.c()) {
                ka();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public void xr(zb zbVar, ny nyVar) throws BaseException {
        synchronized (this) {
            ka(zbVar, nyVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public void ah(zb zbVar, ny nyVar) {
        synchronized (this) {
            if (nyVar.f4620ms == zbVar) {
                com.ss.android.socialbase.downloader.ah.ms.ah("SegmentDispatcher", "unApplySegment ".concat(String.valueOf(nyVar)));
                nyVar.d(zbVar.d());
                nyVar.f4620ms = null;
                zbVar.ms();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public ka d(zb zbVar, ny nyVar) throws BaseException {
        ka kaVarMs;
        synchronized (this) {
            sl slVar = new sl(this.f4616ms, this.ah, nyVar);
            this.ka.ms(slVar);
            kaVarMs = slVar.ms();
        }
        return kaVarMs;
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public void ms(zb zbVar, h hVar, ny nyVar, BaseException baseException, int i, int i2) {
        boolean zXr = com.ss.android.socialbase.downloader.ny.c.xr(baseException);
        int errorCode = baseException.getErrorCode();
        if (errorCode == 1047 || errorCode == 1074 || errorCode == 1055) {
            zXr = true;
        }
        if (zXr || i >= i2) {
            ah(zbVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public void ms(zb zbVar, h hVar, ny nyVar, BaseException baseException) {
        synchronized (this) {
            com.ss.android.socialbase.downloader.ah.ms.ka("SegmentDispatcher", "onSegmentFailed: segment = " + nyVar + ", e = " + baseException);
            zbVar.xr(true);
            if (zbVar.ah == 0) {
                this.h = baseException;
            }
            if (sl()) {
                if (this.h == null) {
                    this.h = baseException;
                }
                this.b = true;
                ms(this.h);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.c.c
    public void xr(zb zbVar) {
        com.ss.android.socialbase.downloader.ah.ms.ah("SegmentDispatcher", "onReaderExit: threadIndex = " + zbVar.ah);
        synchronized (this) {
            zbVar.ah(true);
            this.x.remove(zbVar);
            zb();
            if (!this.x.isEmpty()) {
                if (u()) {
                    com.bytedance.sdk.openadsdk.api.ab.ah("SegmentDispatcher", "onReaderExit: allContentDownloaded");
                    Iterator<zb> it = this.x.iterator();
                    while (it.hasNext()) {
                        it.next().ka();
                    }
                    hi();
                }
            } else {
                hi();
            }
        }
    }

    private void ms(BaseException baseException) {
        com.ss.android.socialbase.downloader.ah.ms.ka("SegmentDispatcher", "onError, e = ".concat(String.valueOf(baseException)));
        this.h = baseException;
        this.ah.ah();
        synchronized (this) {
            Iterator<zb> it = this.x.iterator();
            while (it.hasNext()) {
                it.next().ka();
            }
        }
    }

    private void hi() {
        com.ss.android.socialbase.downloader.ah.ms.ah("SegmentDispatcher", "onComplete");
        this.ah.ah();
        synchronized (this.y) {
            this.y.notify();
        }
    }

    private boolean sl() {
        Iterator<zb> it = this.x.iterator();
        while (it.hasNext()) {
            if (!it.next().ab()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ah(zb zbVar) {
        synchronized (this) {
            h hVarD = d(zbVar);
            if (hVarD == null) {
                return false;
            }
            return zbVar.ms(hVarD);
        }
    }

    private h d(zb zbVar) {
        h next;
        Iterator<h> it = this.ny.iterator();
        h hVar = null;
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next != zbVar.xr && !next.d()) {
                if (hVar == null) {
                    hVar = next;
                }
                if (next.ms() <= 0) {
                    break;
                }
            }
        }
        if (this.xr.xr()) {
            if (next != null) {
                return next;
            }
            if (this.xr.ah()) {
                return null;
            }
        }
        return hVar;
    }

    private void xr(zb zbVar, ny nyVar, h hVar, com.ss.android.socialbase.downloader.model.d dVar) throws com.ss.android.socialbase.downloader.exception.ny, BaseException {
        zb zbVar2 = nyVar.f4620ms;
        if (zbVar2 != null && zbVar2 != zbVar) {
            throw new ch(1, "segment already has an owner");
        }
        if (zbVar.x() != nyVar.ka()) {
            throw new ch(5, "applySegment");
        }
        if (!dVar.xr()) {
            if (nyVar.ka() > 0) {
                throw new com.ss.android.socialbase.downloader.exception.xr(1004, dVar.ah, "1: response code error : " + dVar.ah + " segment=" + nyVar);
            }
            com.ss.android.socialbase.downloader.ah.ms.ka("SegmentDispatcher", "parseHttpResponse: segment.getCurrentOffsetRead = " + nyVar.ka());
            if (!dVar.ms()) {
                throw new com.ss.android.socialbase.downloader.exception.xr(1004, dVar.ah, "2: response code error : " + dVar.ah + " segment=" + nyVar);
            }
        }
        if (hVar.d) {
            if (this.ch == null) {
                this.ch = dVar;
                synchronized (this.y) {
                    this.y.notify();
                }
                com.ss.android.socialbase.downloader.x.c cVar = this.d;
                if (cVar != null) {
                    cVar.ms(hVar.f4615ms, dVar.xr, nyVar.ka());
                }
                long jCh = dVar.ch();
                if (jCh > 0) {
                    for (ny nyVar2 : this.ub) {
                        if (nyVar2.c() <= 0 || nyVar2.c() > jCh - 1) {
                            nyVar2.ah(jCh - 1);
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        ms(dVar);
        if (this.hi == null) {
            this.hi = dVar;
            if (this.f4616ms.getTotalBytes() <= 0) {
                long jCh2 = dVar.ch();
                com.ss.android.socialbase.downloader.ah.ms.ah("SegmentDispatcher", "checkSegmentHttpResponse:len=" + jCh2 + ",url=" + hVar.f4615ms);
                this.f4616ms.setTotalBytes(jCh2);
            }
            synchronized (this.y) {
                this.y.notify();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00e5  */
    private void ka(zb zbVar, ny nyVar) throws ch {
        ny nyVar2;
        long j;
        boolean z;
        com.ss.android.socialbase.downloader.ah.ms.ah("SegmentDispatcher", "applySegment: start ".concat(String.valueOf(nyVar)));
        if (nyVar.f4620ms == zbVar) {
            com.ss.android.socialbase.downloader.ah.ms.ah("SegmentDispatcher", "applySegment: " + zbVar + " is already the owner of " + nyVar);
            return;
        }
        if (nyVar.f4620ms != null) {
            com.ss.android.socialbase.downloader.ah.ms.ka("SegmentDispatcher", "applySegment: " + nyVar + " is already has an owner:" + nyVar.f4620ms);
            throw new ch(1, "segment already has an owner");
        }
        if (zbVar.x() != nyVar.ka()) {
            throw new ch(5, "applySegment");
        }
        long jAh = nyVar.ah();
        int iMs = ms(jAh);
        if (iMs == -1 || (nyVar2 = this.ub.get(iMs)) == null) {
            com.ss.android.socialbase.downloader.ah.ms.ka("SegmentDispatcher", "applySegment: " + nyVar + " not exist! segmentIndex = " + iMs);
            throw new ch(2, "segment not exist");
        }
        if (nyVar2 != nyVar) {
            if (nyVar2.ah() == nyVar.ah()) {
                long jMs = ms(nyVar2);
                if (jMs > 0) {
                    zb zbVar2 = nyVar2.f4620ms;
                    if (zbVar2 != null) {
                        if (jMs < 524288) {
                            j = jAh;
                            if (zbVar.c - zbVar2.c <= 1000 || nyVar2.ka() - nyVar.ka() >= jMs / 2) {
                            }
                        } else {
                            j = jAh;
                        }
                        com.bytedance.sdk.openadsdk.api.ab.ah("SegmentDispatcher", "applySegmentLocked: has same segment, but owner is normal, abort. segmentInList = ".concat(String.valueOf(nyVar2)));
                    } else {
                        j = jAh;
                    }
                    if (zbVar2 != null) {
                        com.bytedance.sdk.openadsdk.api.ab.ah("SegmentDispatcher", "applySegmentLocked: has same segment,and owner too slow, segmentInList = ".concat(String.valueOf(nyVar2)));
                        zbVar2.ms(true);
                    } else {
                        com.bytedance.sdk.openadsdk.api.ab.ah("SegmentDispatcher", "applySegmentLocked: has same segment and no owner, segmentInList = ".concat(String.valueOf(nyVar2)));
                    }
                    nyVar.ah(nyVar2.c());
                    nyVar.xr(nyVar2.ch());
                    this.ub.set(iMs, nyVar);
                    z = true;
                } else {
                    j = jAh;
                }
                z = false;
            } else {
                j = jAh;
                z = false;
            }
            if (!z) {
                com.ss.android.socialbase.downloader.ah.ms.ka("SegmentDispatcher", "applySegment: " + nyVar + " not exist! but has another same segment, segmentInList = " + nyVar2);
                throw new ch(2, "segment not exist, but has another same segment");
            }
        } else {
            j = jAh;
        }
        long jMs2 = nyVar.ms();
        for (int i = iMs - 1; i >= 0; i--) {
            ny nyVar3 = this.ub.get(i);
            long jC = nyVar3.c();
            if (jC <= 0 || jC >= j) {
                if (jMs2 <= 0 && nyVar3.ka() > j) {
                    com.ss.android.socialbase.downloader.ah.ms.ka("SegmentDispatcher", "applySegment:prev's current has over this start, prev = " + nyVar3 + ", segment = " + nyVar);
                    this.ub.remove(nyVar);
                    throw new ch(3, "prev overstep");
                }
                if (nyVar3.f4620ms == null) {
                    nyVar3.ah(j - 1);
                    com.ss.android.socialbase.downloader.ah.ms.ah("SegmentDispatcher", "applySegment: prev set end, prev = ".concat(String.valueOf(nyVar3)));
                    if (nyVar3.ms() > 0) {
                        com.bytedance.sdk.openadsdk.api.ab.xr("SegmentDispatcher", "applySegmentLocked:q break");
                        break;
                    }
                } else {
                    long j2 = j - 1;
                    if (nyVar3.f4620ms.ms(j2)) {
                        nyVar3.ah(j2);
                        com.ss.android.socialbase.downloader.ah.ms.ah("SegmentDispatcher", "applySegment: adjustSegmentEndOffset succeed, prev = ".concat(String.valueOf(nyVar3)));
                        break;
                    } else {
                        com.ss.android.socialbase.downloader.ah.ms.ka("SegmentDispatcher", "applySegment: adjustSegmentEndOffset filed, prev = ".concat(String.valueOf(nyVar3)));
                        throw new ch(4, "prev end adjust fail");
                    }
                }
            }
        }
        int size = this.ub.size();
        for (int i2 = iMs + 1; i2 < size; i2++) {
            ny nyVar4 = this.ub.get(i2);
            if (nyVar4.ms() > 0 || nyVar4.f4620ms != null) {
                long jC2 = nyVar.c();
                long jAh2 = nyVar4.ah();
                if (jC2 <= 0 || jC2 >= jAh2) {
                    long j3 = jAh2 - 1;
                    nyVar.ah(j3);
                    com.ss.android.socialbase.downloader.ah.ms.ah("SegmentDispatcher", "applySegment: segment set end:" + j3 + ", later = " + nyVar4);
                }
                com.bytedance.sdk.openadsdk.api.ab.xr("SegmentDispatcher", "applySegmentLocked: break 2");
                break;
            }
        }
        long jC3 = nyVar.c();
        if (jC3 > 0 && (j > jC3 || nyVar.ka() > jC3)) {
            throw new ch(6, "applySegment: ".concat(String.valueOf(nyVar)));
        }
        nyVar.f4620ms = zbVar;
        com.ss.android.socialbase.downloader.ah.ms.ah("SegmentDispatcher", "applySegment: OK ".concat(String.valueOf(nyVar)));
    }

    private void ms(com.ss.android.socialbase.downloader.model.d dVar) throws BaseException {
        com.ss.android.socialbase.downloader.model.d dVar2 = this.ch;
        if (dVar2 == null && (dVar2 = this.hi) == null) {
            return;
        }
        long jCh = dVar.ch();
        long jCh2 = dVar2.ch();
        if (jCh != jCh2) {
            String str = "total len not equals,len=" + jCh + ",sLen=" + jCh2 + ",code=" + dVar.ah + ",sCode=" + dVar2.ah + ",range=" + dVar.ka() + ",sRange = " + dVar2.ka() + ",url = " + dVar.f4712ms + ",sUrl=" + dVar2.f4712ms;
            com.ss.android.socialbase.downloader.ah.ms.ka("SegmentDispatcher", str);
            if (jCh > 0 && jCh2 > 0) {
                throw new BaseException(1074, str);
            }
        }
        String strAh = dVar.ah();
        String strAh2 = dVar2.ah();
        if (TextUtils.equals(strAh, strAh2)) {
            return;
        }
        String str2 = "etag not equals with main url, etag = " + strAh + ", mainEtag = " + strAh2;
        com.ss.android.socialbase.downloader.ah.ms.ka("SegmentDispatcher", str2);
        if (!TextUtils.isEmpty(strAh) && !TextUtils.isEmpty(strAh2) && !strAh.equalsIgnoreCase(strAh2)) {
            throw new BaseException(1074, str2);
        }
    }

    public void ms() {
        com.ss.android.socialbase.downloader.ah.ms.ah("SegmentDispatcher", TrackAction.CANCEL);
        this.c = true;
        synchronized (this) {
            Iterator<zb> it = this.x.iterator();
            while (it.hasNext()) {
                it.next().ka();
            }
        }
        this.ka.ms();
        this.ah.ah();
    }

    public void xr() {
        com.ss.android.socialbase.downloader.ah.ms.ah("SegmentDispatcher", "pause1");
        this.ab = true;
        synchronized (this) {
            Iterator<zb> it = this.x.iterator();
            while (it.hasNext()) {
                it.next().ka();
            }
        }
        this.ka.xr();
        this.ah.ah();
    }

    private int ms(long j) {
        int size = this.ub.size();
        for (int i = 0; i < size; i++) {
            ny nyVar = this.ub.get(i);
            if (nyVar.ah() == j) {
                return i;
            }
            if (nyVar.ah() > j) {
                return -1;
            }
        }
        return -1;
    }

    private void zb() {
        int size;
        if (this.zb > 0 && (size = this.ub.size()) > 1) {
            ArrayList<ny> arrayList = null;
            int i = 0;
            for (int i2 = 1; i2 < size; i2++) {
                ny nyVar = this.ub.get(i);
                ny nyVar2 = this.ub.get(i2);
                if (nyVar.ka() > nyVar2.ah() && nyVar2.ms() <= 0 && nyVar2.f4620ms == null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                    }
                    arrayList.add(nyVar2);
                    if (this.le) {
                        com.bytedance.sdk.openadsdk.api.ab.d("SegmentDispatcher", "clearCovered, covered = " + nyVar2 + ", prev = " + nyVar);
                    }
                } else if (nyVar2.ka() > nyVar.ka()) {
                    i++;
                }
            }
            if (arrayList != null) {
                for (ny nyVar3 : arrayList) {
                    this.ub.remove(nyVar3);
                    for (zb zbVar : this.x) {
                        if (zbVar.f4625ms == nyVar3) {
                            if (this.le) {
                                com.bytedance.sdk.openadsdk.api.ab.d("SegmentDispatcher", "clearCoveredSegmentLocked: reconnect, segment = " + nyVar3 + ", threadIndex = " + zbVar.ah);
                            }
                            zbVar.ms(true);
                        }
                    }
                }
            }
        }
    }

    private boolean u() {
        long j = this.zb;
        if (j <= 0) {
            this.qv = false;
            return false;
        }
        synchronized (this) {
            long jMs = ub.ms(this.ub);
            com.ss.android.socialbase.downloader.ah.ms.ah("SegmentDispatcher", "isAllContentDownloaded: firstOffset = ".concat(String.valueOf(jMs)));
            if (jMs >= j) {
                this.qv = true;
                return true;
            }
            this.qv = false;
            return false;
        }
    }

    private ny ah(zb zbVar, h hVar) {
        String str;
        int size = this.ub.size();
        long j = -1;
        int i = -1;
        for (int i2 = 0; i2 < size; i2++) {
            long jMs = ms(i2, size);
            if (jMs > j) {
                i = i2;
                j = jMs;
            }
        }
        long jAb = this.xr.ab();
        long jNy = this.xr.ny();
        if (i < 0 || j <= jAb) {
            return null;
        }
        ny nyVar = this.ub.get(i);
        int iU = this.ub.size() < this.x.size() ? 2 : this.xr.u();
        if (iU == 1) {
            zb zbVar2 = nyVar.f4620ms;
            if (zbVar2 != null) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j2 = jCurrentTimeMillis - 4000;
                long jMs2 = zbVar2.ms(j2, jCurrentTimeMillis);
                long jMs3 = zbVar.ms(j2, jCurrentTimeMillis);
                float f = (jMs2 <= 0 || jMs3 <= 0) ? -1.0f : jMs3 / (jMs2 + jMs3);
                if (f == -1.0f) {
                    long jXr = zbVar2.xr();
                    long jXr2 = zbVar.xr();
                    if (jXr > 0 && jXr2 > 0) {
                        f = jXr2 / (jXr + jXr2);
                    }
                }
                if (f > 0.0f) {
                    float f2 = f * 0.9f;
                    long j3 = (long) (j * f2);
                    if (j3 < jAb) {
                        j3 = jAb;
                    }
                    if (jNy <= 0 || j3 <= jNy) {
                        jNy = j3;
                    }
                    long j4 = jAb / 2;
                    long j5 = j - j4;
                    if (jNy > j5) {
                        jNy = j5;
                    } else if (jNy < j4) {
                        jNy = j4;
                    }
                    ny nyVar2 = new ny(nyVar.ka() + (j - jNy), nyVar.c());
                    com.ss.android.socialbase.downloader.ah.ms.ah("SegmentDispatcher", "obtainSegment: parent = " + nyVar + ", child = " + nyVar2 + ", maxRemainBytes = " + j + ", childLength = " + jNy + ", ratio = " + f2 + ", threadIndex = " + zbVar.ah);
                    return nyVar2;
                }
            }
            str = "SegmentDispatcher";
        } else {
            if (iU == 2) {
                long curBytes = this.zb - this.f4616ms.getCurBytes();
                float fD = d(zbVar, hVar);
                long j6 = (long) (curBytes * fD);
                if (j6 < jAb) {
                    j6 = jAb;
                }
                if (jNy <= 0 || j6 <= jNy) {
                    jNy = j6;
                }
                long j7 = jAb / 2;
                long j8 = j - j7;
                if (jNy > j8) {
                    jNy = j8;
                } else if (jNy < j7) {
                    jNy = j7;
                }
                ny nyVar3 = new ny(nyVar.ka() + (j - jNy), nyVar.c());
                com.ss.android.socialbase.downloader.ah.ms.ah("SegmentDispatcher", "obtainSegment: parent = " + nyVar + ", child = " + nyVar3 + ", maxRemainBytes = " + j + ", childLength = " + jNy + ", ratio = " + fD + ", threadIndex = " + zbVar.ah);
                return nyVar3;
            }
            str = "SegmentDispatcher";
        }
        ny nyVar4 = new ny(nyVar.ka() + (j / 2), nyVar.c());
        com.ss.android.socialbase.downloader.ah.ms.ah(str, "obtainSegment: parent = " + nyVar + ",child = " + nyVar4);
        return nyVar4;
    }

    private float d(zb zbVar, h hVar) {
        long jXr = zbVar.xr();
        int size = this.x.size();
        if (size <= 1) {
            size = this.xr.ms();
        }
        float f = 1.0f;
        if (jXr <= 0) {
            float fZb = this.xr.zb();
            if (fZb <= 0.0f || fZb >= 1.0f) {
                fZb = 1.0f / size;
            }
            if (zbVar.ah == 0) {
                return fZb;
            }
            if (size > 1) {
                f = 1.0f - fZb;
                size--;
            }
        } else {
            long jUb = ub();
            if (jUb > jXr) {
                return jXr / jUb;
            }
        }
        return f / size;
    }

    private long ub() {
        Iterator<zb> it = this.x.iterator();
        long jXr = 0;
        while (it.hasNext()) {
            jXr += it.next().xr();
        }
        return jXr;
    }

    private ny ao() {
        int i = 0;
        while (true) {
            ny nyVarH = h();
            if (nyVarH == null) {
                return null;
            }
            zb zbVar = nyVarH.f4620ms;
            if (zbVar == null) {
                return nyVarH;
            }
            if (nyVarH.ch() >= 2) {
                return null;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            xr(jCurrentTimeMillis);
            if (jCurrentTimeMillis - zbVar.c > a.f && ms(zbVar, jCurrentTimeMillis - a.f, jCurrentTimeMillis, 500L, 1.0d)) {
                if (this.le) {
                    com.bytedance.sdk.openadsdk.api.ab.ah("SegmentDispatcher", "obtainSegmentWhenNoNewSegment: isDownloadSpeedPoor segment = " + nyVarH + ", owner.threadIndex = " + zbVar.ah);
                }
                return nyVarH;
            }
            int i2 = i + 1;
            if (i > 2) {
                if (this.le) {
                    com.bytedance.sdk.openadsdk.api.ab.ah("SegmentDispatcher", "obtainSegmentWhenNoNewSegment: waitCount > 2, return segment = ".concat(String.valueOf(nyVarH)));
                }
                return nyVarH;
            }
            try {
                synchronized (this) {
                    wait(500L);
                }
                i = i2;
            } catch (InterruptedException unused) {
                return null;
            }
        }
    }

    private ny h() {
        int iCh;
        ny nyVar = null;
        int i = Integer.MAX_VALUE;
        for (ny nyVar2 : this.ub) {
            if (ms(nyVar2) > 0 && (iCh = nyVar2.ch()) < i) {
                nyVar = nyVar2;
                i = iCh;
            }
        }
        return nyVar;
    }

    private long ms(int i, int i2) {
        ny nyVar = this.ub.get(i);
        long jMs = ms(nyVar);
        int i3 = i + 1;
        ny nyVar2 = i3 < i2 ? this.ub.get(i3) : null;
        if (nyVar2 == null) {
            return jMs;
        }
        long jAh = nyVar2.ah() - nyVar.ka();
        return jMs == -1 ? jAh : Math.min(jMs, jAh);
    }

    private long ms(ny nyVar) {
        long jXr = nyVar.xr();
        if (jXr != -1) {
            return jXr;
        }
        long j = this.zb;
        return j > 0 ? j - nyVar.ka() : jXr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public zb ms(boolean z, long j, long j2) {
        zb zbVar = null;
        for (zb zbVar2 : this.x) {
            if (zbVar2.ah != 0 || z) {
                if (zbVar2.d > 0 && zbVar2.ka <= 0 && j - zbVar2.d > j2 && (zbVar == null || zbVar2.d < zbVar.d)) {
                    zbVar = zbVar2;
                }
            }
        }
        return zbVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long qv() {
        if (this.c || this.ab) {
            return -1L;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            xr(jCurrentTimeMillis);
            long jHi = this.xr.hi();
            if (jHi > 0) {
                long j = this.w;
                if (j > 0 && jCurrentTimeMillis - j > jHi && ms(jCurrentTimeMillis, jHi)) {
                    this.w = jCurrentTimeMillis;
                    this.op++;
                }
            }
        }
        return a.f;
    }

    private void xr(long j) {
        this.t.ms(this.f4616ms.getCurBytes(), j);
        Iterator<zb> it = this.x.iterator();
        while (it.hasNext()) {
            it.next().xr(j);
        }
    }

    private boolean ms(zb zbVar, long j, long j2, long j3, double d) {
        if (zbVar.c <= 0) {
            return false;
        }
        long jXr = this.t.xr(j, j2);
        int size = this.x.size();
        long j4 = size > 0 ? jXr / ((long) size) : jXr;
        long jMs = zbVar.ms(j, j2);
        if (jMs >= j3 && jMs >= j4 * d) {
            return false;
        }
        com.bytedance.sdk.openadsdk.api.ab.ah("SegmentDispatcher", "isDownloadSpeedPoor: totalSpeed = " + jXr + ", threadAvgSpeed = " + j4 + ", poorSpeed = " + j3 + ", speed = " + jMs + ",threadIndex = " + zbVar.ah);
        return true;
    }

    private boolean ms(long j, long j2) {
        long j3 = j - j2;
        long jXr = this.t.xr(j3, j);
        int size = this.x.size();
        if (size > 0) {
            jXr /= (long) size;
        }
        zb zbVarMs = ms(j3, j, (long) Math.max(10.0f, jXr * this.yu), size / 2);
        if (zbVarMs != null) {
            ah(zbVarMs);
            com.ss.android.socialbase.downloader.ah.ms.d("SegmentDispatcher", "handlePoorReadThread: reconnect for poor speed, threadIndex = " + zbVarMs.ah);
            zbVarMs.c();
            return true;
        }
        zb zbVarMs2 = ms(true, j, j2);
        if (zbVarMs2 == null) {
            return false;
        }
        ah(zbVarMs2);
        com.ss.android.socialbase.downloader.ah.ms.d("SegmentDispatcher", "handlePoorReadThread: reconnect for connect timeout, threadIndex = " + zbVarMs2.ah);
        zbVarMs2.c();
        return true;
    }

    private zb ms(long j, long j2, long j3, int i) {
        int i2;
        long j4 = Long.MAX_VALUE;
        int i3 = 0;
        zb zbVar = null;
        for (zb zbVar2 : this.x) {
            if (zbVar2.c > 0) {
                int i4 = i3 + 1;
                if (zbVar2.c < j) {
                    i2 = i4;
                    long jMs = zbVar2.ms(j, j2);
                    if (this.le) {
                        com.bytedance.sdk.openadsdk.api.ab.ah("SegmentDispatcher", "findPoorReadThread: speed = " + jMs + ", threadIndex = " + zbVar2.ah);
                    }
                    if (jMs >= 0 && jMs < j4) {
                        j4 = jMs;
                        zbVar = zbVar2;
                    }
                } else {
                    i2 = i4;
                }
                i3 = i2;
            }
        }
        if (zbVar == null || i3 < i || j4 >= j3) {
            return null;
        }
        com.ss.android.socialbase.downloader.ah.ms.ah("SegmentDispatcher", "findPoorReadThread: ----------- minSpeed = " + j4 + ", threadIndex = " + zbVar.ah);
        return zbVar;
    }
}
