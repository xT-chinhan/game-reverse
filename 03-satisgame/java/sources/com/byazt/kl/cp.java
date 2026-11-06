package com.byazt.kl;

import android.text.TextUtils;
import com.anythink.china.a.c;
import com.byazt.qx.BaseException;
import com.byazt.wm.DownloadInfo;
import com.gopherhole.androidvibrate.BuildConfig;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 445, 29})
public class cp implements com.byazt.m.s.n, w {
    public final com.byazt.ta.l a;
    public volatile boolean cd;
    public com.byazt.wm.q cp;
    public int cy;
    public float h;
    public BaseException hd;
    public long hu;
    public final x l;
    public long m;
    public final DownloadInfo n;
    public long oa;
    public final com.byazt.l.l py;
    public final com.byazt.l.w q;
    public final sz qg;
    public final qg s;
    public int t;
    public com.byazt.wm.q tj;
    public final boolean ur;
    public long wm;
    public volatile boolean w = false;
    public volatile boolean x = false;
    public final List<oa> fs = new ArrayList();
    public final List<hd> rv = new ArrayList();
    public volatile boolean d = true;
    public final LinkedList<rv> sz = new LinkedList<>();
    public final List<rv> k = new ArrayList();
    public final Object um = new Object();
    public volatile boolean ou = false;
    public final com.byazt.l.l.qg bb = new com.byazt.l.l.qg() { // from class: com.byazt.kl.cp.1
        public int qg;

        @Override // com.byazt.l.l.qg
        public long n() {
            if (cp.this.w || cp.this.x) {
                return -1L;
            }
            synchronized (cp.this) {
                if (cp.this.tj == null && cp.this.cp == null) {
                    long j = cp.this.wm;
                    if (j <= 0) {
                        return -1L;
                    }
                    this.qg++;
                    oa oaVarN = cp.this.n(false, System.currentTimeMillis(), j);
                    if (oaVarN == null) {
                        return j;
                    }
                    cp.this.s(oaVarN);
                    oaVarN.w();
                    return ((long) ((this.qg / cp.this.rv.size()) + 1)) * j;
                }
                return -1L;
            }
        }
    };
    public final com.byazt.l.l.qg ln = new com.byazt.l.l.qg() { // from class: com.byazt.kl.cp.2
        @Override // com.byazt.l.l.qg
        public long n() {
            return cp.this.cd();
        }
    };

    public cp(DownloadInfo downloadInfo, sz szVar, com.byazt.l.w wVar) {
        this.n = downloadInfo;
        this.qg = szVar;
        qg qgVar = new qg(szVar.q(), szVar.l());
        this.s = qgVar;
        this.q = wVar;
        this.l = new x(downloadInfo, wVar, qgVar);
        this.py = new com.byazt.l.l();
        this.a = new com.byazt.ta.l();
        this.ur = com.byazt.f.n.n(downloadInfo.getId()).qg(BuildConfig.BUILD_TYPE) == 1;
    }

    public boolean n(List<rv> list) throws InterruptedException, BaseException {
        try {
            w();
            qg(list);
            l();
            x();
            rv();
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                s();
                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                this.n.increaseAllConnectTime(jCurrentTimeMillis2);
                this.n.setFirstSpeedTime(jCurrentTimeMillis2);
                if (!this.x && !this.w) {
                    this.q.n(this.oa);
                    fs();
                    q();
                    if (!this.x && !this.w) {
                        com.byazt.fe.n.s("SegmentDispatcher", "finally pause");
                        qg();
                    }
                    this.py.qg();
                    return true;
                }
                if (!this.x && !this.w) {
                    com.byazt.fe.n.s("SegmentDispatcher", "finally pause");
                    qg();
                }
                this.py.qg();
                return true;
            } catch (Throwable th) {
                long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis;
                this.n.increaseAllConnectTime(jCurrentTimeMillis3);
                this.n.setFirstSpeedTime(jCurrentTimeMillis3);
                throw th;
            }
        } catch (Throwable th2) {
            if (!this.x && !this.w) {
                com.byazt.fe.n.s("SegmentDispatcher", "finally pause");
                qg();
            }
            this.py.qg();
            throw th2;
        }
    }

    private void qg(List<rv> list) {
        long totalBytes = this.n.getTotalBytes();
        this.oa = totalBytes;
        if (totalBytes <= 0) {
            this.oa = this.n.getExpectFileLength();
            com.byazt.fe.n.s("SegmentDispatcher", "initSegments: getExpectFileLength = " + this.oa);
        }
        synchronized (this) {
            this.sz.clear();
            if (list == null || list.isEmpty()) {
                n((List<rv>) this.sz, new rv(0L, -1L), false);
            } else {
                Iterator<rv> it = list.iterator();
                while (it.hasNext()) {
                    n((List<rv>) this.sz, new rv(it.next()), false);
                }
                q(this.sz);
                s(this.sz);
            }
            com.byazt.fe.n.s("SegmentDispatcher", "initSegments: totalLength = " + this.oa);
        }
    }

    private void s() throws InterruptedException, BaseException {
        BaseException baseException;
        synchronized (this.um) {
            if (this.tj == null && this.cp == null) {
                this.um.wait();
            }
        }
        if (this.tj == null && this.cp == null && (baseException = this.hd) != null) {
            throw baseException;
        }
    }

    private void q() throws BaseException {
        try {
            this.l.n((q) this.s);
        } catch (cy unused) {
        } catch (BaseException e) {
            com.byazt.fe.n.l("SegmentDispatcher", "dispatchSegments: loopAndWrite e = ".concat(String.valueOf(e)));
            n(e);
            throw e;
        }
        if (this.x || this.w) {
            return;
        }
        synchronized (this) {
            while (!this.sz.isEmpty()) {
                try {
                    rv rvVarPoll = this.sz.poll();
                    if (rvVarPoll != null) {
                        n(this.k, rvVarPoll, true);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            s(this.k);
        }
        if (this.ou && this.hd != null) {
            com.byazt.fe.n.l("SegmentDispatcher", "dispatchSegments: loopAndWrite  failedException = " + this.hd);
            throw this.hd;
        }
        if (this.n.getCurBytes() != this.n.getTotalBytes()) {
            com.byazt.g.n.n(this.n, this.k);
        }
        com.byazt.fe.n.s("SegmentDispatcher", "dispatchSegments::download finished");
    }

    private void s(List<rv> list) {
        long jQg = k.qg(list);
        com.byazt.fe.n.s("SegmentDispatcher", "checkDownloadBytes: getCurBytes = " + this.n.getCurBytes() + ", totalBytes = " + this.n.getTotalBytes() + ", downloadedBytes = " + jQg);
        if (jQg > this.n.getTotalBytes() && this.n.getTotalBytes() > 0) {
            jQg = this.n.getTotalBytes();
        }
        if (this.n.getCurBytes() == this.n.getTotalBytes() || this.n.getCurBytes() == jQg) {
            return;
        }
        this.n.setCurBytes(jQg);
    }

    private void l() {
        int iN;
        if (this.oa <= 0 || this.d) {
            iN = 1;
        } else {
            iN = this.qg.n();
            int iFs = (int) (this.oa / this.qg.fs());
            if (iN > iFs) {
                iN = iFs;
            }
        }
        com.byazt.fe.n.s("SegmentDispatcher", "dispatchReadThread: totalLength = " + this.oa + ", threadCount = " + iN);
        int i = iN > 0 ? iN : 1;
        synchronized (this) {
            while (this.fs.size() < i) {
                if (!this.x && !this.w) {
                    n(tj());
                    if (this.qg.w()) {
                        break;
                    }
                }
                return;
            }
        }
    }

    private void w() {
        this.rv.add(new hd(this.n.getUrl(), true));
        List<String> backUpUrls = this.n.getBackUpUrls();
        if (backUpUrls != null) {
            for (String str : backUpUrls) {
                if (!TextUtils.isEmpty(str)) {
                    this.rv.add(new hd(str, false));
                }
            }
        }
        this.qg.n(this.rv.size());
    }

    private void x() {
        sz szVar = this.qg;
        this.wm = szVar.tj();
        this.m = szVar.cp();
        this.h = szVar.k();
        int i = this.t;
        if (i > 0) {
            this.py.n(this.bb, i);
        }
    }

    private void fs() {
        if (this.m > 0) {
            this.hu = System.currentTimeMillis();
            this.py.n(this.ln, 0L);
        }
    }

    private void rv() {
        List<String> backUpUrls;
        int iD = this.qg.d();
        if (iD <= 0) {
            this.d = false;
            l();
            return;
        }
        com.byazt.m.s sVarN = com.byazt.m.s.n();
        sVarN.n(this.n.getUrl(), this, 2000L);
        if (iD <= 2 || (backUpUrls = this.n.getBackUpUrls()) == null) {
            return;
        }
        for (String str : backUpUrls) {
            if (!TextUtils.isEmpty(str)) {
                sVarN.n(str, this, 2000L);
            }
        }
    }

    @Override // com.byazt.m.s.n
    public void n(String str, List<InetAddress> list) {
        List<hd> listS;
        if (this.x || this.w) {
            return;
        }
        try {
            listS = s(str, list);
        } catch (Throwable unused) {
            listS = null;
        }
        synchronized (this) {
            if (listS != null) {
                qg(str, listS);
                this.d = false;
                this.qg.n(this.rv.size());
                l();
            } else {
                this.d = false;
                this.qg.n(this.rv.size());
                l();
            }
            throw th;
        }
    }

    private void qg(String str, List<hd> list) {
        int iN;
        if (this.ur) {
            Iterator<hd> it = list.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        int iD = this.qg.d();
        if ((iD == 1 || iD == 3) && (iN = n(str)) >= 0 && iN < this.rv.size()) {
            this.rv.addAll(iN + 1, list);
        } else {
            this.rv.addAll(list);
        }
    }

    private int n(String str) {
        int size = this.rv.size();
        for (int i = 0; i < size; i++) {
            if (TextUtils.equals(this.rv.get(i).n, str)) {
                return i;
            }
        }
        return -1;
    }

    private List<hd> s(String str, List<InetAddress> list) {
        boolean z;
        if (list != null && !list.isEmpty()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i = 0;
            for (InetAddress inetAddress : list) {
                if (inetAddress != null) {
                    String hostAddress = inetAddress.getHostAddress();
                    if (!TextUtils.isEmpty(hostAddress)) {
                        hd hdVar = new hd(str, hostAddress);
                        LinkedList linkedList = (LinkedList) linkedHashMap.get(hdVar.s);
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                            linkedHashMap.put(hdVar.s, linkedList);
                        }
                        linkedList.add(hdVar);
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
                            arrayList.add((hd) linkedList2.pollFirst());
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

    private hd tj() {
        hd hdVar;
        synchronized (this) {
            int size = this.cy % this.rv.size();
            if (this.qg.qg()) {
                this.cy++;
            }
            hdVar = this.rv.get(size);
        }
        return hdVar;
    }

    private void n(List<rv> list, rv rvVar, boolean z) {
        long jS = rvVar.s();
        int size = list.size();
        int i = 0;
        while (i < size && jS >= list.get(i).s()) {
            i++;
        }
        list.add(i, rvVar);
        if (z) {
            rvVar.n(size);
        }
    }

    private void q(List<rv> list) {
        long jS = list.get(0).s();
        if (jS > 0) {
            n(list, new rv(0L, jS - 1), true);
        }
        Iterator<rv> it = list.iterator();
        if (it.hasNext()) {
            rv next = it.next();
            while (it.hasNext()) {
                rv next2 = it.next();
                if (next.w() < next2.s() - 1) {
                    com.byazt.fe.n.q("SegmentDispatcher", "fixSegment: segment = " + next + ", new end = " + (next2.s() - 1));
                    next.s(next2.s() - 1);
                }
                next = next2;
            }
        }
        rv rvVar = list.get(list.size() - 1);
        long totalBytes = this.n.getTotalBytes();
        if (totalBytes <= 0 || (rvVar.w() != -1 && rvVar.w() < totalBytes - 1)) {
            com.byazt.fe.n.q("SegmentDispatcher", "fixSegment: last segment = " + rvVar + ", new end=-1");
            rvVar.s(-1L);
        }
    }

    private void n(hd hdVar) {
        oa oaVar = new oa(this.n, this, this.s, hdVar, this.fs.size());
        this.fs.add(oaVar);
        oaVar.n(com.byazt.xv.s.hd().submit(oaVar));
    }

    @Override // com.byazt.kl.w
    public void n(oa oaVar) {
        if (this.ur) {
            com.byazt.fe.n.s("SegmentDispatcher", "onReaderRun, threadIndex = " + oaVar.s);
        }
    }

    @Override // com.byazt.kl.w
    public rv n(oa oaVar, hd hdVar) {
        if (this.w || this.x) {
            return null;
        }
        synchronized (this) {
            rv rvVarQg = qg(oaVar, hdVar);
            if (rvVarQg != null) {
                rvVarQg.fs();
                if (rvVarQg.tj() > 1) {
                    return new rv(rvVarQg);
                }
            }
            return rvVarQg;
        }
    }

    @Override // com.byazt.kl.w
    public void n(oa oaVar, rv rvVar) {
        synchronized (this) {
            rvVar.rv();
        }
    }

    private rv qg(oa oaVar, hd hdVar) {
        while (!this.sz.isEmpty()) {
            rv rvVarPoll = this.sz.poll();
            if (rvVarPoll != null) {
                n(this.k, rvVarPoll, true);
                if (n(rvVarPoll) > 0 || this.oa <= 0) {
                    return rvVarPoll;
                }
            }
        }
        oa();
        rv rvVarS = s(oaVar, hdVar);
        if (rvVarS != null && n(rvVarS) > 0) {
            n(this.k, rvVarS, true);
            return rvVarS;
        }
        rv rvVarCy = cy();
        if (rvVarCy != null) {
            return rvVarCy;
        }
        return null;
    }

    @Override // com.byazt.kl.w
    public void n(oa oaVar, rv rvVar, hd hdVar, com.byazt.wm.q qVar) throws BaseException, com.byazt.qx.rv {
        synchronized (this) {
            if (this.w || this.x) {
                throw new cy("connected");
            }
            qg(oaVar, rvVar, hdVar, qVar);
            oaVar.qg(false);
            if (this.oa <= 0) {
                long totalBytes = this.n.getTotalBytes();
                this.oa = totalBytes;
                if (totalBytes <= 0) {
                    this.oa = qVar.tj();
                }
                l();
            } else if (this.qg.w()) {
                l();
            }
        }
    }

    @Override // com.byazt.kl.w
    public void qg(oa oaVar, rv rvVar) throws BaseException {
        synchronized (this) {
            l(oaVar, rvVar);
        }
    }

    @Override // com.byazt.kl.w
    public void s(oa oaVar, rv rvVar) {
        synchronized (this) {
            if (rvVar.n == oaVar) {
                com.byazt.fe.n.s("SegmentDispatcher", "unApplySegment ".concat(String.valueOf(rvVar)));
                rvVar.q(oaVar.q());
                rvVar.n = null;
                oaVar.n();
            }
        }
    }

    @Override // com.byazt.kl.w
    public l q(oa oaVar, rv rvVar) throws BaseException {
        l lVarN;
        synchronized (this) {
            d dVar = new d(this.n, this.s, rvVar);
            this.l.n(dVar);
            lVarN = dVar.n();
        }
        return lVarN;
    }

    @Override // com.byazt.kl.w
    public void n(oa oaVar, hd hdVar, rv rvVar, BaseException baseException, int i, int i2) {
        boolean zQg = com.byazt.ta.w.qg(baseException);
        int errorCode = baseException.getErrorCode();
        if (errorCode == 1047 || errorCode == 1074 || errorCode == 1055) {
            zQg = true;
        }
        if (zQg || i >= i2) {
            s(oaVar);
        }
    }

    @Override // com.byazt.kl.w
    public void n(oa oaVar, hd hdVar, rv rvVar, BaseException baseException) {
        synchronized (this) {
            com.byazt.fe.n.l("SegmentDispatcher", "onSegmentFailed: segment = " + rvVar + ", e = " + baseException);
            oaVar.qg(true);
            if (oaVar.s == 0) {
                this.hd = baseException;
            }
            if (d()) {
                if (this.hd == null) {
                    this.hd = baseException;
                }
                this.ou = true;
                n(this.hd);
            }
        }
    }

    @Override // com.byazt.kl.w
    public void qg(oa oaVar) {
        com.byazt.fe.n.s("SegmentDispatcher", "onReaderExit: threadIndex = " + oaVar.s);
        synchronized (this) {
            oaVar.s(true);
            this.fs.remove(oaVar);
            oa();
            if (!this.fs.isEmpty()) {
                if (sz()) {
                    Iterator<oa> it = this.fs.iterator();
                    while (it.hasNext()) {
                        it.next().l();
                    }
                    cp();
                }
            } else {
                cp();
            }
        }
    }

    private void n(BaseException baseException) {
        com.byazt.fe.n.l("SegmentDispatcher", "onError, e = ".concat(String.valueOf(baseException)));
        this.hd = baseException;
        this.s.s();
        synchronized (this) {
            Iterator<oa> it = this.fs.iterator();
            while (it.hasNext()) {
                it.next().l();
            }
        }
    }

    private void cp() {
        com.byazt.fe.n.s("SegmentDispatcher", "onComplete");
        this.s.s();
        synchronized (this.um) {
            this.um.notify();
        }
    }

    private boolean d() {
        Iterator<oa> it = this.fs.iterator();
        while (it.hasNext()) {
            if (!it.next().x()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean s(oa oaVar) {
        synchronized (this) {
            hd hdVarQ = q(oaVar);
            if (hdVarQ == null) {
                return false;
            }
            return oaVar.n(hdVarQ);
        }
    }

    private hd q(oa oaVar) {
        hd next;
        Iterator<hd> it = this.rv.iterator();
        hd hdVar = null;
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next != oaVar.qg && !next.q()) {
                if (hdVar == null) {
                    hdVar = next;
                }
                if (next.n() <= 0) {
                    break;
                }
            }
        }
        if (this.qg.qg()) {
            if (next != null) {
                return next;
            }
            if (this.qg.s()) {
                return null;
            }
        }
        return hdVar;
    }

    private void qg(oa oaVar, rv rvVar, hd hdVar, com.byazt.wm.q qVar) throws BaseException, com.byazt.qx.rv {
        oa oaVar2 = rvVar.n;
        if (oaVar2 != null && oaVar2 != oaVar) {
            throw new tj(1, "segment already has an owner");
        }
        if (oaVar.fs() != rvVar.l()) {
            throw new tj(5, "applySegment");
        }
        if (!qVar.qg()) {
            if (rvVar.l() > 0) {
                throw new com.byazt.qx.qg(1004, qVar.s, "1: response code error : " + qVar.s + " segment=" + rvVar);
            }
            com.byazt.fe.n.l("SegmentDispatcher", "parseHttpResponse: segment.getCurrentOffsetRead = " + rvVar.l());
            if (!qVar.n()) {
                throw new com.byazt.qx.qg(1004, qVar.s, "2: response code error : " + qVar.s + " segment=" + rvVar);
            }
        }
        if (hdVar.q) {
            if (this.tj == null) {
                this.tj = qVar;
                synchronized (this.um) {
                    this.um.notify();
                }
                com.byazt.l.w wVar = this.q;
                if (wVar != null) {
                    wVar.n(hdVar.n, qVar.qg, rvVar.l());
                }
                long jTj = qVar.tj();
                if (jTj > 0) {
                    for (rv rvVar2 : this.k) {
                        if (rvVar2.w() <= 0 || rvVar2.w() > jTj - 1) {
                            rvVar2.s(jTj - 1);
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        n(qVar);
        if (this.cp == null) {
            this.cp = qVar;
            if (this.n.getTotalBytes() <= 0) {
                long jTj2 = qVar.tj();
                com.byazt.fe.n.s("SegmentDispatcher", "checkSegmentHttpResponse:len=" + jTj2 + ",url=" + hdVar.n);
                this.n.setTotalBytes(jTj2);
            }
            synchronized (this.um) {
                this.um.notify();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00ba  */
    private void l(oa oaVar, rv rvVar) throws tj {
        rv rvVar2;
        long j;
        boolean z;
        com.byazt.fe.n.s("SegmentDispatcher", "applySegment: start ".concat(String.valueOf(rvVar)));
        if (rvVar.n == oaVar) {
            com.byazt.fe.n.s("SegmentDispatcher", "applySegment: " + oaVar + " is already the owner of " + rvVar);
            return;
        }
        if (rvVar.n != null) {
            com.byazt.fe.n.l("SegmentDispatcher", "applySegment: " + rvVar + " is already has an owner:" + rvVar.n);
            throw new tj(1, "segment already has an owner");
        }
        if (oaVar.fs() != rvVar.l()) {
            throw new tj(5, "applySegment");
        }
        long jS = rvVar.s();
        int iN = n(jS);
        if (iN == -1 || (rvVar2 = this.k.get(iN)) == null) {
            com.byazt.fe.n.l("SegmentDispatcher", "applySegment: " + rvVar + " not exist! segmentIndex = " + iN);
            throw new tj(2, "segment not exist");
        }
        if (rvVar2 != rvVar) {
            if (rvVar2.s() == rvVar.s()) {
                long jN = n(rvVar2);
                if (jN <= 0) {
                    j = jS;
                    z = false;
                } else {
                    oa oaVar2 = rvVar2.n;
                    if (oaVar2 != null) {
                        if (jN < c.t) {
                            j = jS;
                            if (oaVar.w - oaVar2.w <= 1000 || rvVar2.l() - rvVar.l() >= jN / 2) {
                            }
                        } else {
                            j = jS;
                        }
                        z = false;
                    } else {
                        j = jS;
                    }
                    if (oaVar2 != null) {
                        oaVar2.n(true);
                    }
                    rvVar.s(rvVar2.w());
                    rvVar.qg(rvVar2.tj());
                    this.k.set(iN, rvVar);
                    z = true;
                }
            } else {
                j = jS;
                z = false;
            }
            if (!z) {
                com.byazt.fe.n.l("SegmentDispatcher", "applySegment: " + rvVar + " not exist! but has another same segment, segmentInList = " + rvVar2);
                throw new tj(2, "segment not exist, but has another same segment");
            }
        } else {
            j = jS;
        }
        long jN2 = rvVar.n();
        for (int i = iN - 1; i >= 0; i--) {
            rv rvVar3 = this.k.get(i);
            long jW = rvVar3.w();
            if (jW <= 0 || jW >= j) {
                if (jN2 <= 0 && rvVar3.l() > j) {
                    com.byazt.fe.n.l("SegmentDispatcher", "applySegment:prev's current has over this start, prev = " + rvVar3 + ", segment = " + rvVar);
                    this.k.remove(rvVar);
                    throw new tj(3, "prev overstep");
                }
                if (rvVar3.n == null) {
                    rvVar3.s(j - 1);
                    com.byazt.fe.n.s("SegmentDispatcher", "applySegment: prev set end, prev = ".concat(String.valueOf(rvVar3)));
                    if (rvVar3.n() > 0) {
                        break;
                    }
                } else {
                    long j2 = j - 1;
                    if (rvVar3.n.n(j2)) {
                        rvVar3.s(j2);
                        com.byazt.fe.n.s("SegmentDispatcher", "applySegment: adjustSegmentEndOffset succeed, prev = ".concat(String.valueOf(rvVar3)));
                        break;
                    } else {
                        com.byazt.fe.n.l("SegmentDispatcher", "applySegment: adjustSegmentEndOffset filed, prev = ".concat(String.valueOf(rvVar3)));
                        throw new tj(4, "prev end adjust fail");
                    }
                }
            }
        }
        int size = this.k.size();
        for (int i2 = iN + 1; i2 < size; i2++) {
            rv rvVar4 = this.k.get(i2);
            if (rvVar4.n() > 0 || rvVar4.n != null) {
                long jW2 = rvVar.w();
                long jS2 = rvVar4.s();
                if (jW2 > 0 && jW2 < jS2) {
                    break;
                }
                long j3 = jS2 - 1;
                rvVar.s(j3);
                com.byazt.fe.n.s("SegmentDispatcher", "applySegment: segment set end:" + j3 + ", later = " + rvVar4);
                break;
            }
        }
        long jW3 = rvVar.w();
        if (jW3 > 0 && (j > jW3 || rvVar.l() > jW3)) {
            throw new tj(6, "applySegment: ".concat(String.valueOf(rvVar)));
        }
        rvVar.n = oaVar;
        com.byazt.fe.n.s("SegmentDispatcher", "applySegment: OK ".concat(String.valueOf(rvVar)));
    }

    private void n(com.byazt.wm.q qVar) throws BaseException {
        com.byazt.wm.q qVar2 = this.tj;
        if (qVar2 == null && (qVar2 = this.cp) == null) {
            return;
        }
        long jTj = qVar.tj();
        long jTj2 = qVar2.tj();
        if (jTj != jTj2) {
            String str = "total len not equals,len=" + jTj + ",sLen=" + jTj2 + ",code=" + qVar.s + ",sCode=" + qVar2.s + ",range=" + qVar.l() + ",sRange = " + qVar2.l() + ",url = " + qVar.n + ",sUrl=" + qVar2.n;
            com.byazt.fe.n.l("SegmentDispatcher", str);
            if (jTj > 0 && jTj2 > 0) {
                throw new BaseException(1074, str);
            }
        }
        String strS = qVar.s();
        String strS2 = qVar2.s();
        if (TextUtils.equals(strS, strS2)) {
            return;
        }
        String str2 = "etag not equals with main url, etag = " + strS + ", mainEtag = " + strS2;
        com.byazt.fe.n.l("SegmentDispatcher", str2);
        if (!TextUtils.isEmpty(strS) && !TextUtils.isEmpty(strS2) && !strS.equalsIgnoreCase(strS2)) {
            throw new BaseException(1074, str2);
        }
    }

    public void n() {
        com.byazt.fe.n.s("SegmentDispatcher", "cancel");
        this.w = true;
        synchronized (this) {
            Iterator<oa> it = this.fs.iterator();
            while (it.hasNext()) {
                it.next().l();
            }
        }
        this.l.n();
        this.s.s();
    }

    public void qg() {
        com.byazt.fe.n.s("SegmentDispatcher", "pause1");
        this.x = true;
        synchronized (this) {
            Iterator<oa> it = this.fs.iterator();
            while (it.hasNext()) {
                it.next().l();
            }
        }
        this.l.qg();
        this.s.s();
    }

    private int n(long j) {
        int size = this.k.size();
        for (int i = 0; i < size; i++) {
            rv rvVar = this.k.get(i);
            if (rvVar.s() == j) {
                return i;
            }
            if (rvVar.s() > j) {
                return -1;
            }
        }
        return -1;
    }

    private void oa() {
        int size;
        if (this.oa > 0 && (size = this.k.size()) > 1) {
            ArrayList<rv> arrayList = null;
            int i = 0;
            for (int i2 = 1; i2 < size; i2++) {
                rv rvVar = this.k.get(i);
                rv rvVar2 = this.k.get(i2);
                if (rvVar.l() > rvVar2.s() && rvVar2.n() <= 0 && rvVar2.n == null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                    }
                    arrayList.add(rvVar2);
                } else if (rvVar2.l() > rvVar.l()) {
                    i++;
                }
            }
            if (arrayList != null) {
                for (rv rvVar3 : arrayList) {
                    this.k.remove(rvVar3);
                    for (oa oaVar : this.fs) {
                        if (oaVar.n == rvVar3) {
                            oaVar.n(true);
                        }
                    }
                }
            }
        }
    }

    private boolean sz() {
        long j = this.oa;
        if (j <= 0) {
            this.cd = false;
            return false;
        }
        synchronized (this) {
            long jN = k.n(this.k);
            com.byazt.fe.n.s("SegmentDispatcher", "isAllContentDownloaded: firstOffset = ".concat(String.valueOf(jN)));
            if (jN >= j) {
                this.cd = true;
                return true;
            }
            this.cd = false;
            return false;
        }
    }

    private rv s(oa oaVar, hd hdVar) {
        String str;
        int size = this.k.size();
        long j = -1;
        int i = -1;
        for (int i2 = 0; i2 < size; i2++) {
            long jN = n(i2, size);
            if (jN > j) {
                i = i2;
                j = jN;
            }
        }
        long jX = this.qg.x();
        long jRv = this.qg.rv();
        if (i < 0 || j <= jX) {
            return null;
        }
        rv rvVar = this.k.get(i);
        int iSz = this.k.size() < this.fs.size() ? 2 : this.qg.sz();
        if (iSz == 1) {
            oa oaVar2 = rvVar.n;
            if (oaVar2 != null) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j2 = jCurrentTimeMillis - 4000;
                long jN2 = oaVar2.n(j2, jCurrentTimeMillis);
                long jN3 = oaVar.n(j2, jCurrentTimeMillis);
                float f = (jN2 <= 0 || jN3 <= 0) ? -1.0f : jN3 / (jN2 + jN3);
                if (f == -1.0f) {
                    long jQg = oaVar2.qg();
                    long jQg2 = oaVar.qg();
                    if (jQg > 0 && jQg2 > 0) {
                        f = jQg2 / (jQg + jQg2);
                    }
                }
                if (f > 0.0f) {
                    float f2 = f * 0.9f;
                    long j3 = (long) (j * f2);
                    if (j3 < jX) {
                        j3 = jX;
                    }
                    if (jRv <= 0 || j3 <= jRv) {
                        jRv = j3;
                    }
                    long j4 = jX / 2;
                    long j5 = j - j4;
                    if (jRv > j5) {
                        jRv = j5;
                    } else if (jRv < j4) {
                        jRv = j4;
                    }
                    rv rvVar2 = new rv(rvVar.l() + (j - jRv), rvVar.w());
                    com.byazt.fe.n.s("SegmentDispatcher", "obtainSegment: parent = " + rvVar + ", child = " + rvVar2 + ", maxRemainBytes = " + j + ", childLength = " + jRv + ", ratio = " + f2 + ", threadIndex = " + oaVar.s);
                    return rvVar2;
                }
            }
            str = "SegmentDispatcher";
        } else {
            if (iSz == 2) {
                long curBytes = this.oa - this.n.getCurBytes();
                float fQ = q(oaVar, hdVar);
                long j6 = (long) (curBytes * fQ);
                if (j6 < jX) {
                    j6 = jX;
                }
                if (jRv <= 0 || j6 <= jRv) {
                    jRv = j6;
                }
                long j7 = jX / 2;
                long j8 = j - j7;
                if (jRv > j8) {
                    jRv = j8;
                } else if (jRv < j7) {
                    jRv = j7;
                }
                rv rvVar3 = new rv(rvVar.l() + (j - jRv), rvVar.w());
                com.byazt.fe.n.s("SegmentDispatcher", "obtainSegment: parent = " + rvVar + ", child = " + rvVar3 + ", maxRemainBytes = " + j + ", childLength = " + jRv + ", ratio = " + fQ + ", threadIndex = " + oaVar.s);
                return rvVar3;
            }
            str = "SegmentDispatcher";
        }
        rv rvVar4 = new rv(rvVar.l() + (j / 2), rvVar.w());
        com.byazt.fe.n.s(str, "obtainSegment: parent = " + rvVar + ",child = " + rvVar4);
        return rvVar4;
    }

    private float q(oa oaVar, hd hdVar) {
        long jQg = oaVar.qg();
        int size = this.fs.size();
        if (size <= 1) {
            size = this.qg.n();
        }
        float f = 1.0f;
        if (jQg <= 0) {
            float fOa = this.qg.oa();
            if (fOa <= 0.0f || fOa >= 1.0f) {
                fOa = 1.0f / size;
            }
            if (oaVar.s == 0) {
                return fOa;
            }
            if (size > 1) {
                f = 1.0f - fOa;
                size--;
            }
        } else {
            long jK = k();
            if (jK > jQg) {
                return jQg / jK;
            }
        }
        return f / size;
    }

    private long k() {
        Iterator<oa> it = this.fs.iterator();
        long jQg = 0;
        while (it.hasNext()) {
            jQg += it.next().qg();
        }
        return jQg;
    }

    private rv cy() {
        int i = 0;
        while (true) {
            rv rvVarHd = hd();
            if (rvVarHd == null) {
                return null;
            }
            oa oaVar = rvVarHd.n;
            if (oaVar == null) {
                return rvVarHd;
            }
            if (rvVarHd.tj() >= 2) {
                return null;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            qg(jCurrentTimeMillis);
            if (jCurrentTimeMillis - oaVar.w > 2000 && n(oaVar, jCurrentTimeMillis - 2000, jCurrentTimeMillis, 500L, 1.0d)) {
                return rvVarHd;
            }
            int i2 = i + 1;
            if (i > 2) {
                return rvVarHd;
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

    private rv hd() {
        int iTj;
        rv rvVar = null;
        int i = Integer.MAX_VALUE;
        for (rv rvVar2 : this.k) {
            if (n(rvVar2) > 0 && (iTj = rvVar2.tj()) < i) {
                rvVar = rvVar2;
                i = iTj;
            }
        }
        return rvVar;
    }

    private long n(int i, int i2) {
        rv rvVar = this.k.get(i);
        long jN = n(rvVar);
        int i3 = i + 1;
        rv rvVar2 = i3 < i2 ? this.k.get(i3) : null;
        if (rvVar2 == null) {
            return jN;
        }
        long jS = rvVar2.s() - rvVar.l();
        return jN == -1 ? jS : Math.min(jN, jS);
    }

    private long n(rv rvVar) {
        long jQg = rvVar.qg();
        if (jQg != -1) {
            return jQg;
        }
        long j = this.oa;
        return j > 0 ? j - rvVar.l() : jQg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public oa n(boolean z, long j, long j2) {
        oa oaVar = null;
        for (oa oaVar2 : this.fs) {
            if (oaVar2.s != 0 || z) {
                if (oaVar2.q > 0 && oaVar2.l <= 0 && j - oaVar2.q > j2 && (oaVar == null || oaVar2.q < oaVar.q)) {
                    oaVar = oaVar2;
                }
            }
        }
        return oaVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long cd() {
        if (this.w || this.x) {
            return -1L;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            qg(jCurrentTimeMillis);
            long jCp = this.qg.cp();
            if (jCp > 0) {
                long j = this.hu;
                if (j > 0 && jCurrentTimeMillis - j > jCp && n(jCurrentTimeMillis, jCp)) {
                    this.hu = jCurrentTimeMillis;
                    this.t++;
                }
            }
        }
        return 2000L;
    }

    private void qg(long j) {
        this.a.n(this.n.getCurBytes(), j);
        Iterator<oa> it = this.fs.iterator();
        while (it.hasNext()) {
            it.next().qg(j);
        }
    }

    private boolean n(oa oaVar, long j, long j2, long j3, double d) {
        if (oaVar.w <= 0) {
            return false;
        }
        long jQg = this.a.qg(j, j2);
        int size = this.fs.size();
        if (size > 0) {
            jQg /= (long) size;
        }
        long jN = oaVar.n(j, j2);
        return jN < j3 || ((double) jN) < ((double) jQg) * d;
    }

    private boolean n(long j, long j2) {
        long j3 = j - j2;
        long jQg = this.a.qg(j3, j);
        int size = this.fs.size();
        if (size > 0) {
            jQg /= (long) size;
        }
        oa oaVarN = n(j3, j, (long) Math.max(10.0f, jQg * this.h), size / 2);
        if (oaVarN != null) {
            s(oaVarN);
            com.byazt.fe.n.q("SegmentDispatcher", "handlePoorReadThread: reconnect for poor speed, threadIndex = " + oaVarN.s);
            oaVarN.w();
            return true;
        }
        oa oaVarN2 = n(true, j, j2);
        if (oaVarN2 == null) {
            return false;
        }
        s(oaVarN2);
        com.byazt.fe.n.q("SegmentDispatcher", "handlePoorReadThread: reconnect for connect timeout, threadIndex = " + oaVarN2.s);
        oaVarN2.w();
        return true;
    }

    private oa n(long j, long j2, long j3, int i) {
        long j4 = LongCompanionObject.MAX_VALUE;
        int i2 = 0;
        oa oaVar = null;
        for (oa oaVar2 : this.fs) {
            if (oaVar2.w > 0) {
                i2++;
                if (oaVar2.w < j) {
                    long jN = oaVar2.n(j, j2);
                    if (jN >= 0 && jN < j4) {
                        oaVar = oaVar2;
                        j4 = jN;
                    }
                }
            }
        }
        if (oaVar == null || i2 < i || j4 >= j3) {
            return null;
        }
        com.byazt.fe.n.s("SegmentDispatcher", "findPoorReadThread: ----------- minSpeed = " + j4 + ", threadIndex = " + oaVar.s);
        return oaVar;
    }
}
