package com.byazt.stx;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.byazt.auw.DownloadInfo;
import com.byazt.lhc.BaseException;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, 109})
public class w implements com.byazt.edb.hn.pr, uc {
    public final com.byazt.tuy.c a;
    public float b;
    public final fw c;
    public final com.byazt.gi.c cz;
    public long fo;
    public final hw hn;
    public final g hw;
    public int iu;
    public volatile boolean lb;
    public long m;
    public int nt;
    public final DownloadInfo pr;
    public long rc;
    public final boolean ve;
    public com.byazt.auw.x vk;
    public com.byazt.auw.x w;
    public final com.byazt.gi.uc x;
    public BaseException yb;
    public long z;
    public volatile boolean uc = false;
    public volatile boolean fw = false;
    public final List<m> zo = new ArrayList();
    public final List<yb> aj = new ArrayList();
    public volatile boolean k = true;
    public final LinkedList<aj> g = new LinkedList<>();
    public final List<aj> ho = new ArrayList();
    public final Object qa = new Object();
    public volatile boolean ny = false;
    public final com.byazt.gi.c.hw gz = new com.byazt.gi.c.hw() { // from class: com.byazt.stx.w.1
        public int hw;

        @Override // com.byazt.gi.c.hw
        public long pr() {
            if (w.this.uc || w.this.fw) {
                return -1L;
            }
            synchronized (w.this) {
                if (w.this.vk == null && w.this.w == null) {
                    long j = w.this.fo;
                    if (j <= 0) {
                        return -1L;
                    }
                    this.hw++;
                    m mVarPr = w.this.pr(false, System.currentTimeMillis(), j);
                    if (mVarPr == null) {
                        return j;
                    }
                    w.this.hn(mVarPr);
                    mVarPr.uc();
                    return ((long) ((this.hw / w.this.aj.size()) + 1)) * j;
                }
                return -1L;
            }
        }
    };
    public final com.byazt.gi.c.hw nl = new com.byazt.gi.c.hw() { // from class: com.byazt.stx.w.2
        @Override // com.byazt.gi.c.hw
        public long pr() {
            return w.this.lb();
        }
    };

    public w(DownloadInfo downloadInfo, g gVar, com.byazt.gi.uc ucVar) {
        this.pr = downloadInfo;
        this.hw = gVar;
        hw hwVar = new hw(gVar.x(), gVar.c());
        this.hn = hwVar;
        this.x = ucVar;
        this.c = new fw(downloadInfo, ucVar, hwVar);
        this.cz = new com.byazt.gi.c();
        this.a = new com.byazt.tuy.c();
        this.ve = com.byazt.ew.pr.pr(downloadInfo.getId()).hw("debug") == 1;
    }

    public boolean pr(List<aj> list) throws InterruptedException, BaseException {
        try {
            uc();
            hw(list);
            c();
            fw();
            aj();
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                hn();
                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                this.pr.increaseAllConnectTime(jCurrentTimeMillis2);
                this.pr.setFirstSpeedTime(jCurrentTimeMillis2);
                if (!this.fw && !this.uc) {
                    this.x.pr(this.m);
                    zo();
                    x();
                    if (!this.fw && !this.uc) {
                        com.byazt.p000do.pr.hn("SegmentDispatcher", "finally pause");
                        hw();
                    }
                    this.cz.hw();
                    return true;
                }
                if (!this.fw && !this.uc) {
                    com.byazt.p000do.pr.hn("SegmentDispatcher", "finally pause");
                    hw();
                }
                this.cz.hw();
                return true;
            } catch (Throwable th) {
                long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis;
                this.pr.increaseAllConnectTime(jCurrentTimeMillis3);
                this.pr.setFirstSpeedTime(jCurrentTimeMillis3);
                throw th;
            }
        } catch (Throwable th2) {
            if (!this.fw && !this.uc) {
                com.byazt.p000do.pr.hn("SegmentDispatcher", "finally pause");
                hw();
            }
            this.cz.hw();
            throw th2;
        }
    }

    private void hw(List<aj> list) {
        long totalBytes = this.pr.getTotalBytes();
        this.m = totalBytes;
        if (totalBytes <= 0) {
            this.m = this.pr.getExpectFileLength();
            com.byazt.p000do.pr.hn("SegmentDispatcher", "initSegments: getExpectFileLength = " + this.m);
        }
        synchronized (this) {
            this.g.clear();
            if (list == null || list.isEmpty()) {
                pr((List<aj>) this.g, new aj(0L, -1L), false);
            } else {
                Iterator<aj> it = list.iterator();
                while (it.hasNext()) {
                    pr((List<aj>) this.g, new aj(it.next()), false);
                }
                x(this.g);
                hn(this.g);
            }
            com.byazt.p000do.pr.hn("SegmentDispatcher", "initSegments: totalLength = " + this.m);
        }
    }

    private void hn() throws InterruptedException, BaseException {
        BaseException baseException;
        synchronized (this.qa) {
            if (this.vk == null && this.w == null) {
                this.qa.wait();
            }
        }
        if (this.vk == null && this.w == null && (baseException = this.yb) != null) {
            throw baseException;
        }
    }

    private void x() throws BaseException {
        try {
            this.c.pr((x) this.hn);
        } catch (nt e) {
        } catch (BaseException e2) {
            com.byazt.p000do.pr.c("SegmentDispatcher", "dispatchSegments: loopAndWrite e = ".concat(String.valueOf(e2)));
            pr(e2);
            throw e2;
        }
        if (this.fw || this.uc) {
            return;
        }
        try {
            synchronized (this) {
                while (!this.g.isEmpty()) {
                    try {
                        aj ajVarPoll = this.g.poll();
                        if (ajVarPoll != null) {
                            pr(this.ho, ajVarPoll, true);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                hn(this.ho);
            }
        } catch (Throwable th2) {
        }
        if (this.ny && this.yb != null) {
            com.byazt.p000do.pr.c("SegmentDispatcher", "dispatchSegments: loopAndWrite  failedException = " + this.yb);
            throw this.yb;
        }
        if (this.pr.getCurBytes() != this.pr.getTotalBytes()) {
            com.byazt.cha.pr.pr(this.pr, this.ho);
        }
        com.byazt.p000do.pr.hn("SegmentDispatcher", "dispatchSegments::download finished");
    }

    private void hn(List<aj> list) {
        long jHw = ho.hw(list);
        com.byazt.p000do.pr.hn("SegmentDispatcher", "checkDownloadBytes: getCurBytes = " + this.pr.getCurBytes() + ", totalBytes = " + this.pr.getTotalBytes() + ", downloadedBytes = " + jHw);
        if (jHw > this.pr.getTotalBytes() && this.pr.getTotalBytes() > 0) {
            jHw = this.pr.getTotalBytes();
        }
        if (this.pr.getCurBytes() != this.pr.getTotalBytes() && this.pr.getCurBytes() != jHw) {
            this.pr.setCurBytes(jHw);
        }
    }

    private void c() {
        int iPr;
        if (this.m <= 0 || this.k) {
            iPr = 1;
        } else {
            iPr = this.hw.pr();
            int iZo = (int) (this.m / this.hw.zo());
            if (iPr > iZo) {
                iPr = iZo;
            }
        }
        com.byazt.p000do.pr.hn("SegmentDispatcher", "dispatchReadThread: totalLength = " + this.m + ", threadCount = " + iPr);
        int i = iPr > 0 ? iPr : 1;
        synchronized (this) {
            while (this.zo.size() < i) {
                if (!this.fw && !this.uc) {
                    pr(vk());
                    if (this.hw.uc()) {
                        break;
                    }
                }
                return;
            }
        }
    }

    private void uc() {
        this.aj.add(new yb(this.pr.getUrl(), true));
        List<String> backUpUrls = this.pr.getBackUpUrls();
        if (backUpUrls != null) {
            for (String str : backUpUrls) {
                if (!TextUtils.isEmpty(str)) {
                    this.aj.add(new yb(str, false));
                }
            }
        }
        this.hw.pr(this.aj.size());
    }

    private void fw() {
        g gVar = this.hw;
        this.fo = gVar.vk();
        this.rc = gVar.w();
        this.b = gVar.ho();
        int i = this.iu;
        if (i > 0) {
            this.cz.pr(this.gz, i);
        }
    }

    private void zo() {
        if (this.rc > 0) {
            this.z = System.currentTimeMillis();
            this.cz.pr(this.nl, 0L);
        }
    }

    private void aj() {
        List<String> backUpUrls;
        int iK = this.hw.k();
        if (iK <= 0) {
            this.k = false;
            c();
            return;
        }
        com.byazt.edb.hn hnVarPr = com.byazt.edb.hn.pr();
        hnVarPr.pr(this.pr.getUrl(), this, 2000L);
        if (iK > 2 && (backUpUrls = this.pr.getBackUpUrls()) != null) {
            for (String str : backUpUrls) {
                if (!TextUtils.isEmpty(str)) {
                    hnVarPr.pr(str, this, 2000L);
                }
            }
        }
    }

    @Override // com.byazt.edb.hn.pr
    public void pr(String str, List<InetAddress> list) {
        if (this.fw || this.uc) {
            return;
        }
        List<yb> listHn = null;
        try {
            listHn = hn(str, list);
        } catch (Throwable th) {
        }
        synchronized (this) {
            if (listHn != null) {
                hw(str, listHn);
                this.k = false;
                this.hw.pr(this.aj.size());
                c();
            } else {
                this.k = false;
                this.hw.pr(this.aj.size());
                c();
            }
            throw th;
        }
    }

    private void hw(String str, List<yb> list) {
        int iPr;
        if (this.ve) {
            Iterator<yb> it = list.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        int iK = this.hw.k();
        if ((iK == 1 || iK == 3) && (iPr = pr(str)) >= 0 && iPr < this.aj.size()) {
            this.aj.addAll(iPr + 1, list);
        } else {
            this.aj.addAll(list);
        }
    }

    private int pr(String str) {
        int size = this.aj.size();
        for (int i = 0; i < size; i++) {
            if (TextUtils.equals(this.aj.get(i).pr, str)) {
                return i;
            }
        }
        return -1;
    }

    private List<yb> hn(String str, List<InetAddress> list) {
        boolean z;
        if (list == null || list.isEmpty()) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = 0;
        for (InetAddress inetAddress : list) {
            if (inetAddress != null) {
                String hostAddress = inetAddress.getHostAddress();
                if (!TextUtils.isEmpty(hostAddress)) {
                    yb ybVar = new yb(str, hostAddress);
                    LinkedList linkedList = (LinkedList) linkedHashMap.get(ybVar.hn);
                    if (linkedList == null) {
                        linkedList = new LinkedList();
                        linkedHashMap.put(ybVar.hn, linkedList);
                    }
                    linkedList.add(ybVar);
                    i++;
                }
            }
        }
        if (i <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        do {
            Iterator it = linkedHashMap.entrySet().iterator();
            z = false;
            while (it.hasNext()) {
                LinkedList linkedList2 = (LinkedList) ((Map.Entry) it.next()).getValue();
                if (linkedList2 != null && !linkedList2.isEmpty()) {
                    arrayList.add((yb) linkedList2.pollFirst());
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

    private yb vk() {
        yb ybVar;
        synchronized (this) {
            int size = this.nt % this.aj.size();
            if (this.hw.hw()) {
                this.nt++;
            }
            ybVar = this.aj.get(size);
        }
        return ybVar;
    }

    private void pr(List<aj> list, aj ajVar, boolean z) {
        long jHn = ajVar.hn();
        int size = list.size();
        int i = 0;
        while (i < size && jHn >= list.get(i).hn()) {
            i++;
        }
        list.add(i, ajVar);
        if (z) {
            ajVar.pr(size);
        }
    }

    private void x(List<aj> list) {
        long jHn = list.get(0).hn();
        if (jHn > 0) {
            pr(list, new aj(0L, jHn - 1), true);
        }
        Iterator<aj> it = list.iterator();
        if (it.hasNext()) {
            aj next = it.next();
            while (it.hasNext()) {
                aj next2 = it.next();
                if (next.uc() < next2.hn() - 1) {
                    com.byazt.p000do.pr.x("SegmentDispatcher", "fixSegment: segment = " + next + ", new end = " + (next2.hn() - 1));
                    next.hn(next2.hn() - 1);
                }
                next = next2;
            }
        }
        aj ajVar = list.get(list.size() - 1);
        long totalBytes = this.pr.getTotalBytes();
        if (totalBytes <= 0 || (ajVar.uc() != -1 && ajVar.uc() < totalBytes - 1)) {
            com.byazt.p000do.pr.x("SegmentDispatcher", "fixSegment: last segment = " + ajVar + ", new end=-1");
            ajVar.hn(-1L);
        }
    }

    private void pr(yb ybVar) {
        m mVar = new m(this.pr, this, this.hn, ybVar, this.zo.size());
        this.zo.add(mVar);
        mVar.pr(com.byazt.lj.hn.yb().submit(mVar));
    }

    @Override // com.byazt.stx.uc
    public void pr(m mVar) {
        if (this.ve) {
            com.byazt.p000do.pr.hn("SegmentDispatcher", "onReaderRun, threadIndex = " + mVar.hn);
        }
    }

    @Override // com.byazt.stx.uc
    public aj pr(m mVar, yb ybVar) {
        if (this.uc || this.fw) {
            return null;
        }
        synchronized (this) {
            aj ajVarHw = hw(mVar, ybVar);
            if (ajVarHw != null) {
                ajVarHw.zo();
                if (ajVarHw.vk() > 1) {
                    return new aj(ajVarHw);
                }
            }
            return ajVarHw;
        }
    }

    @Override // com.byazt.stx.uc
    public void pr(m mVar, aj ajVar) {
        synchronized (this) {
            ajVar.aj();
        }
    }

    private aj hw(m mVar, yb ybVar) {
        while (!this.g.isEmpty()) {
            aj ajVarPoll = this.g.poll();
            if (ajVarPoll != null) {
                pr(this.ho, ajVarPoll, true);
                if (pr(ajVarPoll) > 0 || this.m <= 0) {
                    return ajVarPoll;
                }
            }
        }
        m();
        aj ajVarHn = hn(mVar, ybVar);
        if (ajVarHn != null && pr(ajVarHn) > 0) {
            pr(this.ho, ajVarHn, true);
            return ajVarHn;
        }
        aj ajVarNt = nt();
        if (ajVarNt != null) {
            return ajVarNt;
        }
        return null;
    }

    @Override // com.byazt.stx.uc
    public void pr(m mVar, aj ajVar, yb ybVar, com.byazt.auw.x xVar) throws com.byazt.lhc.aj, BaseException {
        synchronized (this) {
            if (this.uc || this.fw) {
                throw new nt("connected");
            }
            hw(mVar, ajVar, ybVar, xVar);
            mVar.hw(false);
            if (this.m <= 0) {
                long totalBytes = this.pr.getTotalBytes();
                this.m = totalBytes;
                if (totalBytes <= 0) {
                    this.m = xVar.vk();
                }
                c();
            } else if (this.hw.uc()) {
                c();
            }
        }
    }

    @Override // com.byazt.stx.uc
    public void hw(m mVar, aj ajVar) throws BaseException {
        synchronized (this) {
            c(mVar, ajVar);
        }
    }

    @Override // com.byazt.stx.uc
    public void hn(m mVar, aj ajVar) {
        synchronized (this) {
            if (ajVar.pr == mVar) {
                com.byazt.p000do.pr.hn("SegmentDispatcher", "unApplySegment ".concat(String.valueOf(ajVar)));
                ajVar.x(mVar.x());
                ajVar.pr = null;
                mVar.pr();
            }
        }
    }

    @Override // com.byazt.stx.uc
    public c x(m mVar, aj ajVar) throws BaseException {
        c cVarPr;
        synchronized (this) {
            k kVar = new k(this.pr, this.hn, ajVar);
            this.c.pr(kVar);
            cVarPr = kVar.pr();
        }
        return cVarPr;
    }

    @Override // com.byazt.stx.uc
    public void pr(m mVar, yb ybVar, aj ajVar, BaseException baseException, int i, int i2) {
        boolean z;
        boolean z2 = true;
        if (!com.byazt.tuy.uc.hw(baseException)) {
            z = false;
        } else {
            z = true;
        }
        int errorCode = baseException.getErrorCode();
        if (errorCode != 1047 && errorCode != 1074 && errorCode != 1055) {
            z2 = z;
        }
        if (z2 || i >= i2) {
            hn(mVar);
        }
    }

    @Override // com.byazt.stx.uc
    public void pr(m mVar, yb ybVar, aj ajVar, BaseException baseException) {
        synchronized (this) {
            com.byazt.p000do.pr.c("SegmentDispatcher", "onSegmentFailed: segment = " + ajVar + ", e = " + baseException);
            mVar.hw(true);
            if (mVar.hn == 0) {
                this.yb = baseException;
            }
            if (k()) {
                if (this.yb == null) {
                    this.yb = baseException;
                }
                this.ny = true;
                pr(this.yb);
            }
        }
    }

    @Override // com.byazt.stx.uc
    public void hw(m mVar) {
        com.byazt.p000do.pr.hn("SegmentDispatcher", "onReaderExit: threadIndex = " + mVar.hn);
        synchronized (this) {
            mVar.hn(true);
            this.zo.remove(mVar);
            m();
            if (!this.zo.isEmpty()) {
                if (g()) {
                    Iterator<m> it = this.zo.iterator();
                    while (it.hasNext()) {
                        it.next().c();
                    }
                    w();
                }
            } else {
                w();
            }
        }
    }

    private void pr(BaseException baseException) {
        com.byazt.p000do.pr.c("SegmentDispatcher", "onError, e = ".concat(String.valueOf(baseException)));
        this.yb = baseException;
        this.hn.hn();
        synchronized (this) {
            Iterator<m> it = this.zo.iterator();
            while (it.hasNext()) {
                it.next().c();
            }
        }
    }

    private void w() {
        com.byazt.p000do.pr.hn("SegmentDispatcher", "onComplete");
        this.hn.hn();
        synchronized (this.qa) {
            this.qa.notify();
        }
    }

    private boolean k() {
        Iterator<m> it = this.zo.iterator();
        while (it.hasNext()) {
            if (!it.next().fw()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hn(m mVar) {
        synchronized (this) {
            yb ybVarX = x(mVar);
            if (ybVarX == null) {
                return false;
            }
            return mVar.pr(ybVarX);
        }
    }

    private yb x(m mVar) {
        yb next;
        Iterator<yb> it = this.aj.iterator();
        yb ybVar = null;
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next != mVar.hw && !next.x()) {
                if (ybVar == null) {
                    ybVar = next;
                }
                if (next.pr() <= 0) {
                    break;
                }
            }
        }
        if (this.hw.hw()) {
            if (next != null) {
                return next;
            }
            if (this.hw.hn()) {
                return null;
            }
            return ybVar;
        }
        return ybVar;
    }

    private void hw(m mVar, aj ajVar, yb ybVar, com.byazt.auw.x xVar) throws com.byazt.lhc.aj, BaseException {
        m mVar2 = ajVar.pr;
        if (mVar2 != null && mVar2 != mVar) {
            throw new vk(1, "segment already has an owner");
        }
        if (mVar.zo() != ajVar.c()) {
            throw new vk(5, "applySegment");
        }
        if (!xVar.hw()) {
            if (ajVar.c() > 0) {
                throw new com.byazt.lhc.hw(1004, xVar.hn, "1: response code error : " + xVar.hn + " segment=" + ajVar);
            }
            com.byazt.p000do.pr.c("SegmentDispatcher", "parseHttpResponse: segment.getCurrentOffsetRead = " + ajVar.c());
            if (!xVar.pr()) {
                throw new com.byazt.lhc.hw(1004, xVar.hn, "2: response code error : " + xVar.hn + " segment=" + ajVar);
            }
        }
        if (ybVar.x) {
            if (this.vk == null) {
                this.vk = xVar;
                synchronized (this.qa) {
                    this.qa.notify();
                }
                com.byazt.gi.uc ucVar = this.x;
                if (ucVar != null) {
                    ucVar.pr(ybVar.pr, xVar.hw, ajVar.c());
                }
                long jVk = xVar.vk();
                if (jVk > 0) {
                    for (aj ajVar2 : this.ho) {
                        if (ajVar2.uc() <= 0 || ajVar2.uc() > jVk - 1) {
                            ajVar2.hn(jVk - 1);
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        pr(xVar);
        if (this.w == null) {
            this.w = xVar;
            if (this.pr.getTotalBytes() <= 0) {
                long jVk2 = xVar.vk();
                com.byazt.p000do.pr.hn("SegmentDispatcher", "checkSegmentHttpResponse:len=" + jVk2 + ",url=" + ybVar.pr);
                this.pr.setTotalBytes(jVk2);
            }
            synchronized (this.qa) {
                this.qa.notify();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00c8  */
    private void c(m mVar, aj ajVar) throws vk {
        aj ajVar2;
        long j;
        boolean z;
        com.byazt.p000do.pr.hn("SegmentDispatcher", "applySegment: start ".concat(String.valueOf(ajVar)));
        if (ajVar.pr == mVar) {
            com.byazt.p000do.pr.hn("SegmentDispatcher", "applySegment: " + mVar + " is already the owner of " + ajVar);
            return;
        }
        if (ajVar.pr != null) {
            com.byazt.p000do.pr.c("SegmentDispatcher", "applySegment: " + ajVar + " is already has an owner:" + ajVar.pr);
            throw new vk(1, "segment already has an owner");
        }
        if (mVar.zo() != ajVar.c()) {
            throw new vk(5, "applySegment");
        }
        long jHn = ajVar.hn();
        int iPr = pr(jHn);
        if (iPr == -1 || (ajVar2 = this.ho.get(iPr)) == null) {
            com.byazt.p000do.pr.c("SegmentDispatcher", "applySegment: " + ajVar + " not exist! segmentIndex = " + iPr);
            throw new vk(2, "segment not exist");
        }
        if (ajVar2 == ajVar) {
            j = jHn;
        } else {
            if (ajVar2.hn() != ajVar.hn()) {
                j = jHn;
            } else {
                long jPr = pr(ajVar2);
                if (jPr <= 0) {
                    j = jHn;
                } else {
                    m mVar2 = ajVar2.pr;
                    if (mVar2 == null) {
                        j = jHn;
                    } else if (jPr < PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                        j = jHn;
                        if (mVar.uc - mVar2.uc <= 1000 || ajVar2.c() - ajVar.c() >= jPr / 2) {
                        }
                        if (!z) {
                            com.byazt.p000do.pr.c("SegmentDispatcher", "applySegment: " + ajVar + " not exist! but has another same segment, segmentInList = " + ajVar2);
                            throw new vk(2, "segment not exist, but has another same segment");
                        }
                    } else {
                        j = jHn;
                    }
                    if (mVar2 != null) {
                        mVar2.pr(true);
                    }
                    ajVar.hn(ajVar2.uc());
                    ajVar.hw(ajVar2.vk());
                    this.ho.set(iPr, ajVar);
                    z = true;
                    if (!z) {
                        com.byazt.p000do.pr.c("SegmentDispatcher", "applySegment: " + ajVar + " not exist! but has another same segment, segmentInList = " + ajVar2);
                        throw new vk(2, "segment not exist, but has another same segment");
                    }
                }
            }
            z = false;
            if (!z) {
                com.byazt.p000do.pr.c("SegmentDispatcher", "applySegment: " + ajVar + " not exist! but has another same segment, segmentInList = " + ajVar2);
                throw new vk(2, "segment not exist, but has another same segment");
            }
        }
        long jPr2 = ajVar.pr();
        for (int i = iPr - 1; i >= 0; i--) {
            aj ajVar3 = this.ho.get(i);
            long jUc = ajVar3.uc();
            if (jUc <= 0 || jUc >= j) {
                if (jPr2 <= 0 && ajVar3.c() > j) {
                    com.byazt.p000do.pr.c("SegmentDispatcher", "applySegment:prev's current has over this start, prev = " + ajVar3 + ", segment = " + ajVar);
                    this.ho.remove(ajVar);
                    throw new vk(3, "prev overstep");
                }
                if (ajVar3.pr != null) {
                    long j2 = j - 1;
                    if (ajVar3.pr.pr(j2)) {
                        ajVar3.hn(j2);
                        com.byazt.p000do.pr.hn("SegmentDispatcher", "applySegment: adjustSegmentEndOffset succeed, prev = ".concat(String.valueOf(ajVar3)));
                        break;
                    } else {
                        com.byazt.p000do.pr.c("SegmentDispatcher", "applySegment: adjustSegmentEndOffset filed, prev = ".concat(String.valueOf(ajVar3)));
                        throw new vk(4, "prev end adjust fail");
                    }
                }
                ajVar3.hn(j - 1);
                com.byazt.p000do.pr.hn("SegmentDispatcher", "applySegment: prev set end, prev = ".concat(String.valueOf(ajVar3)));
                if (ajVar3.pr() > 0) {
                    break;
                }
            }
        }
        int size = this.ho.size();
        for (int i2 = iPr + 1; i2 < size; i2++) {
            aj ajVar4 = this.ho.get(i2);
            if (ajVar4.pr() > 0 || ajVar4.pr != null) {
                long jUc2 = ajVar.uc();
                long jHn2 = ajVar4.hn();
                if (jUc2 > 0 && jUc2 < jHn2) {
                    break;
                }
                long j3 = jHn2 - 1;
                ajVar.hn(j3);
                com.byazt.p000do.pr.hn("SegmentDispatcher", "applySegment: segment set end:" + j3 + ", later = " + ajVar4);
                break;
            }
        }
        long jUc3 = ajVar.uc();
        if (jUc3 > 0 && (j > jUc3 || ajVar.c() > jUc3)) {
            throw new vk(6, "applySegment: ".concat(String.valueOf(ajVar)));
        }
        ajVar.pr = mVar;
        com.byazt.p000do.pr.hn("SegmentDispatcher", "applySegment: OK ".concat(String.valueOf(ajVar)));
    }

    private void pr(com.byazt.auw.x xVar) throws BaseException {
        com.byazt.auw.x xVar2 = this.vk;
        if (xVar2 == null && (xVar2 = this.w) == null) {
            return;
        }
        long jVk = xVar.vk();
        long jVk2 = xVar2.vk();
        if (jVk != jVk2) {
            String str = "total len not equals,len=" + jVk + ",sLen=" + jVk2 + ",code=" + xVar.hn + ",sCode=" + xVar2.hn + ",range=" + xVar.c() + ",sRange = " + xVar2.c() + ",url = " + xVar.pr + ",sUrl=" + xVar2.pr;
            com.byazt.p000do.pr.c("SegmentDispatcher", str);
            if (jVk > 0 && jVk2 > 0) {
                throw new BaseException(1074, str);
            }
        }
        String strHn = xVar.hn();
        String strHn2 = xVar2.hn();
        if (!TextUtils.equals(strHn, strHn2)) {
            String str2 = "etag not equals with main url, etag = " + strHn + ", mainEtag = " + strHn2;
            com.byazt.p000do.pr.c("SegmentDispatcher", str2);
            if (!TextUtils.isEmpty(strHn) && !TextUtils.isEmpty(strHn2) && !strHn.equalsIgnoreCase(strHn2)) {
                throw new BaseException(1074, str2);
            }
        }
    }

    public void pr() {
        com.byazt.p000do.pr.hn("SegmentDispatcher", TrackAction.CANCEL);
        this.uc = true;
        synchronized (this) {
            Iterator<m> it = this.zo.iterator();
            while (it.hasNext()) {
                it.next().c();
            }
        }
        this.c.pr();
        this.hn.hn();
    }

    public void hw() {
        com.byazt.p000do.pr.hn("SegmentDispatcher", "pause1");
        this.fw = true;
        synchronized (this) {
            Iterator<m> it = this.zo.iterator();
            while (it.hasNext()) {
                it.next().c();
            }
        }
        this.c.hw();
        this.hn.hn();
    }

    private int pr(long j) {
        int size = this.ho.size();
        for (int i = 0; i < size; i++) {
            aj ajVar = this.ho.get(i);
            if (ajVar.hn() == j) {
                return i;
            }
            if (ajVar.hn() > j) {
                return -1;
            }
        }
        return -1;
    }

    private void m() {
        int size;
        if (this.m <= 0 || (size = this.ho.size()) <= 1) {
            return;
        }
        ArrayList<aj> arrayList = null;
        int i = 0;
        int i2 = 1;
        while (i2 < size) {
            aj ajVar = this.ho.get(i);
            aj ajVar2 = this.ho.get(i2);
            if (ajVar.c() > ajVar2.hn() && ajVar2.pr() <= 0 && ajVar2.pr == null) {
                if (arrayList == null) {
                    arrayList = new ArrayList(1);
                }
                arrayList.add(ajVar2);
                i2++;
            } else {
                if (ajVar2.c() > ajVar.c()) {
                    i++;
                }
                i2++;
            }
        }
        if (arrayList != null) {
            for (aj ajVar3 : arrayList) {
                this.ho.remove(ajVar3);
                for (m mVar : this.zo) {
                    if (mVar.pr == ajVar3) {
                        mVar.pr(true);
                    }
                }
            }
        }
    }

    private boolean g() {
        long j = this.m;
        if (j <= 0) {
            this.lb = false;
            return false;
        }
        synchronized (this) {
            long jPr = ho.pr(this.ho);
            com.byazt.p000do.pr.hn("SegmentDispatcher", "isAllContentDownloaded: firstOffset = ".concat(String.valueOf(jPr)));
            if (jPr >= j) {
                this.lb = true;
                return true;
            }
            this.lb = false;
            return false;
        }
    }

    private aj hn(m mVar, yb ybVar) {
        int iG;
        float f;
        int size = this.ho.size();
        long j = -1;
        int i = -1;
        for (int i2 = 0; i2 < size; i2++) {
            long jPr = pr(i2, size);
            if (jPr > j) {
                i = i2;
                j = jPr;
            }
        }
        long jFw = this.hw.fw();
        long jAj = this.hw.aj();
        if (i >= 0 && j > jFw) {
            aj ajVar = this.ho.get(i);
            if (this.ho.size() < this.zo.size()) {
                iG = 2;
            } else {
                iG = this.hw.g();
            }
            if (iG == 1) {
                m mVar2 = ajVar.pr;
                if (mVar2 != null) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    long j2 = jCurrentTimeMillis - 4000;
                    long jPr2 = mVar2.pr(j2, jCurrentTimeMillis);
                    long jPr3 = mVar.pr(j2, jCurrentTimeMillis);
                    if (jPr2 > 0 && jPr3 > 0) {
                        f = jPr3 / (jPr2 + jPr3);
                    } else {
                        f = -1.0f;
                    }
                    if (f == -1.0f) {
                        long jHw = mVar2.hw();
                        long jHw2 = mVar.hw();
                        if (jHw > 0 && jHw2 > 0) {
                            f = jHw2 / (jHw + jHw2);
                        }
                    }
                    if (f > 0.0f) {
                        float f2 = f * 0.9f;
                        long j3 = (long) (j * f2);
                        if (j3 < jFw) {
                            j3 = jFw;
                        }
                        if (jAj <= 0 || j3 <= jAj) {
                            jAj = j3;
                        }
                        long j4 = jFw / 2;
                        long j5 = j - j4;
                        if (jAj > j5) {
                            jAj = j5;
                        } else if (jAj < j4) {
                            jAj = j4;
                        }
                        aj ajVar2 = new aj(ajVar.c() + (j - jAj), ajVar.uc());
                        com.byazt.p000do.pr.hn("SegmentDispatcher", "obtainSegment: parent = " + ajVar + ", child = " + ajVar2 + ", maxRemainBytes = " + j + ", childLength = " + jAj + ", ratio = " + f2 + ", threadIndex = " + mVar.hn);
                        return ajVar2;
                    }
                }
            } else if (iG == 2) {
                long curBytes = this.m - this.pr.getCurBytes();
                float fX = x(mVar, ybVar);
                long j6 = (long) (curBytes * fX);
                if (j6 < jFw) {
                    j6 = jFw;
                }
                if (jAj <= 0 || j6 <= jAj) {
                    jAj = j6;
                }
                long j7 = jFw / 2;
                long j8 = j - j7;
                if (jAj > j8) {
                    jAj = j8;
                } else if (jAj < j7) {
                    jAj = j7;
                }
                aj ajVar3 = new aj(ajVar.c() + (j - jAj), ajVar.uc());
                com.byazt.p000do.pr.hn("SegmentDispatcher", "obtainSegment: parent = " + ajVar + ", child = " + ajVar3 + ", maxRemainBytes = " + j + ", childLength = " + jAj + ", ratio = " + fX + ", threadIndex = " + mVar.hn);
                return ajVar3;
            }
            aj ajVar4 = new aj(ajVar.c() + (j / 2), ajVar.uc());
            com.byazt.p000do.pr.hn("SegmentDispatcher", "obtainSegment: parent = " + ajVar + ",child = " + ajVar4);
            return ajVar4;
        }
        return null;
    }

    private float x(m mVar, yb ybVar) {
        long jHw = mVar.hw();
        int size = this.zo.size();
        if (size <= 1) {
            size = this.hw.pr();
        }
        if (jHw <= 0) {
            float fM = this.hw.m();
            if (fM <= 0.0f || fM >= 1.0f) {
                fM = 1.0f / size;
            }
            if (mVar.hn == 0) {
                return fM;
            }
            if (size > 1) {
                return (1.0f - fM) / (size - 1);
            }
            return 1.0f / size;
        }
        long jHo = ho();
        if (jHo > jHw) {
            return jHw / jHo;
        }
        return 1.0f / size;
    }

    private long ho() {
        Iterator<m> it = this.zo.iterator();
        long jHw = 0;
        while (it.hasNext()) {
            jHw += it.next().hw();
        }
        return jHw;
    }

    private aj nt() {
        int i = 0;
        while (true) {
            aj ajVarYb = yb();
            if (ajVarYb == null) {
                return null;
            }
            m mVar = ajVarYb.pr;
            if (mVar == null) {
                return ajVarYb;
            }
            if (ajVarYb.vk() >= 2) {
                return null;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            hw(jCurrentTimeMillis);
            if (jCurrentTimeMillis - mVar.uc > 2000 && pr(mVar, jCurrentTimeMillis - 2000, jCurrentTimeMillis, 500L, 1.0d)) {
                return ajVarYb;
            }
            int i2 = i + 1;
            if (i > 2) {
                return ajVarYb;
            }
            try {
                synchronized (this) {
                    wait(500L);
                }
                i = i2;
            } catch (InterruptedException e) {
                return null;
            }
        }
    }

    private aj yb() {
        int iVk;
        aj ajVar = null;
        int i = Integer.MAX_VALUE;
        for (aj ajVar2 : this.ho) {
            if (pr(ajVar2) > 0 && (iVk = ajVar2.vk()) < i) {
                ajVar = ajVar2;
                i = iVk;
            }
        }
        return ajVar;
    }

    private long pr(int i, int i2) {
        aj ajVar = this.ho.get(i);
        long jPr = pr(ajVar);
        int i3 = i + 1;
        aj ajVar2 = i3 < i2 ? this.ho.get(i3) : null;
        if (ajVar2 == null) {
            return jPr;
        }
        long jHn = ajVar2.hn() - ajVar.c();
        if (jPr == -1) {
            return jHn;
        }
        return Math.min(jPr, jHn);
    }

    private long pr(aj ajVar) {
        long jHw = ajVar.hw();
        if (jHw != -1) {
            return jHw;
        }
        long j = this.m;
        if (j > 0) {
            return j - ajVar.c();
        }
        return jHw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public m pr(boolean z, long j, long j2) {
        m mVar = null;
        for (m mVar2 : this.zo) {
            if (mVar2.hn != 0 || z) {
                if (mVar2.x > 0 && mVar2.c <= 0 && j - mVar2.x > j2) {
                    if (mVar == null) {
                        mVar = mVar2;
                    } else if (mVar2.x < mVar.x) {
                        mVar = mVar2;
                    }
                }
            }
        }
        return mVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long lb() {
        if (this.uc || this.fw) {
            return -1L;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            hw(jCurrentTimeMillis);
            long jW = this.hw.w();
            if (jW > 0) {
                long j = this.z;
                if (j > 0 && jCurrentTimeMillis - j > jW && pr(jCurrentTimeMillis, jW)) {
                    this.z = jCurrentTimeMillis;
                    this.iu++;
                }
            }
        }
        return 2000L;
    }

    private void hw(long j) {
        this.a.pr(this.pr.getCurBytes(), j);
        Iterator<m> it = this.zo.iterator();
        while (it.hasNext()) {
            it.next().hw(j);
        }
    }

    private boolean pr(m mVar, long j, long j2, long j3, double d) {
        if (mVar.uc > 0) {
            long jHw = this.a.hw(j, j2);
            int size = this.zo.size();
            if (size > 0) {
                jHw /= (long) size;
            }
            long jPr = mVar.pr(j, j2);
            if (jPr < j3 || jPr < jHw * d) {
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean pr(long j, long j2) {
        long j3 = j - j2;
        long jHw = this.a.hw(j3, j);
        int size = this.zo.size();
        if (size > 0) {
            jHw /= (long) size;
        }
        m mVarPr = pr(j3, j, (long) Math.max(10.0f, jHw * this.b), size / 2);
        if (mVarPr != null) {
            hn(mVarPr);
            com.byazt.p000do.pr.x("SegmentDispatcher", "handlePoorReadThread: reconnect for poor speed, threadIndex = " + mVarPr.hn);
            mVarPr.uc();
            return true;
        }
        m mVarPr2 = pr(true, j, j2);
        if (mVarPr2 != null) {
            hn(mVarPr2);
            com.byazt.p000do.pr.x("SegmentDispatcher", "handlePoorReadThread: reconnect for connect timeout, threadIndex = " + mVarPr2.hn);
            mVarPr2.uc();
            return true;
        }
        return false;
    }

    private m pr(long j, long j2, long j3, int i) {
        long j4 = LongCompanionObject.MAX_VALUE;
        int i2 = 0;
        m mVar = null;
        for (m mVar2 : this.zo) {
            if (mVar2.uc > 0) {
                i2++;
                if (mVar2.uc < j) {
                    long jPr = mVar2.pr(j, j2);
                    if (jPr >= 0 && jPr < j4) {
                        mVar = mVar2;
                        j4 = jPr;
                    }
                }
            }
        }
        if (mVar == null || i2 < i || j4 >= j3) {
            return null;
        }
        com.byazt.p000do.pr.hn("SegmentDispatcher", "findPoorReadThread: ----------- minSpeed = " + j4 + ", threadIndex = " + mVar.hn);
        return mVar;
    }
}
