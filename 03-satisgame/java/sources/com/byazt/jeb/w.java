package com.byazt.jeb;

import android.content.Context;
import android.os.Handler;
import com.byazt.hls.x;
import com.byazt.vf.cp;
import com.byazt.vf.oa;
import com.byazt.vf.wm;
import com.byazt.vf.wo;
import com.byazt.vr.n;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1621, 13})
public class w<T extends com.byazt.vr.n> {
    public wm fs;
    public final com.byazt.kp.s l;
    public final com.byazt.vr.qg q;
    public s qg;
    public final cp w;
    public final com.byazt.zad.qg<com.byazt.vr.n> x;
    public volatile long s = 0;
    public final AtomicInteger n = new AtomicInteger(0);
    public final Runnable rv = new Runnable() { // from class: com.byazt.jeb.w.2
        @Override // java.lang.Runnable
        public void run() {
            try {
                w.this.l.x();
                w.this.n();
            } catch (Exception unused) {
            }
        }
    };
    public Handler tj = null;

    public w(Context context, com.byazt.vr.qg qgVar, com.byazt.kp.s sVar, com.byazt.vf.n nVar) {
        this.q = qgVar;
        this.l = sVar;
        this.w = (cp) com.byazt.qp.q.n("csj_settings", nVar);
        this.x = new com.byazt.xdz.s(nVar, qgVar);
        this.fs = (wm) com.byazt.qp.q.n("mediation_settings", nVar);
    }

    public void n(List<com.byazt.vr.n> list, String str, int i, Object obj) {
        this.qg = this.l.w();
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.byazt.hls.q.n(list, i, str);
        com.byazt.hls.q.n(list, str);
        n(list, jCurrentTimeMillis, i, obj);
    }

    private void n(final List<com.byazt.vr.n> list, final long j, final int i, final Object obj) {
        if (list == null || list.isEmpty()) {
            return;
        }
        wo woVar = (wo) com.byazt.qp.q.n("thread_service");
        ExecutorService executorServiceQg = woVar.qg();
        if (list.get(0).d() == 1) {
            executorServiceQg = woVar.n();
        }
        executorServiceQg.execute(new Runnable() { // from class: com.byazt.jeb.w.1
            @Override // java.lang.Runnable
            public void run() {
                w.this.qg(list, j, i, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        try {
            wo woVar = (wo) com.byazt.qp.q.n("thread_service");
            Handler handler = this.tj;
            if (handler == null) {
                this.tj = new Handler(woVar.q().getLooper());
            } else {
                handler.removeCallbacksAndMessages(null);
            }
            this.tj.postDelayed(this.rv, this.fs.q());
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(List<com.byazt.vr.n> list, long j, int i, Object obj) {
        com.byazt.zad.n nVarQg;
        if (list != null) {
            try {
                if (list.isEmpty()) {
                    return;
                }
                com.byazt.vr.n nVar = list.get(0);
                com.byazt.hls.l.n(com.byazt.kp.s.n.a(), 1, this.w);
                if (nVar.cp() == 0) {
                    nVarQg = this.x.n(list, this.l);
                    n(nVarQg, list);
                    if (nVarQg != null) {
                        com.byazt.hls.q.n(list, nVarQg.q(), this.w);
                    }
                } else if (com.byazt.hls.q.n(list)) {
                    nVarQg = this.x.s(list, this.l);
                    if (nVarQg != null && nVarQg.n()) {
                        n();
                    }
                } else {
                    nVarQg = this.x.qg(list, this.l);
                }
                n(nVarQg, list, j, obj, i);
                if (nVarQg != null && nVarQg.w() && nVar.cp() == 0) {
                    n(i);
                }
            } catch (Throwable th) {
                x.n("_error", "doInnerUpload", th);
                com.byazt.hls.l.n(com.byazt.kp.s.n.s(), 1, this.w);
            }
        }
    }

    private void n(int i) {
        s sVar = this.qg;
        if (sVar == null) {
            return;
        }
        try {
            List<com.byazt.vr.n> listN = sVar.n().n(i);
            if (listN != null && !listN.isEmpty()) {
                x.qg("_direct", "queryAllHighPriorityFromDb size=" + listN.size());
                List<com.byazt.xdz.qg.n> listQ = this.x.q(listN, this.l);
                if (listQ != null && !listQ.isEmpty()) {
                    for (com.byazt.xdz.qg.n nVar : listQ) {
                        if (nVar != null && nVar.n != null && !nVar.n.isEmpty()) {
                            sVar.n().n((nVar.qg == null || !nVar.qg.n) ? -2 : 200, nVar.n, i);
                        }
                    }
                    return;
                }
                sVar.n().n(-2, listN, i);
                return;
            }
            x.qg("_direct", "queryAllHighPriorityFromDb empty, skip");
        } catch (Throwable th) {
            x.n("_direct", "doAllHighPriorityDirectConnectUpload error", th);
        }
    }

    private void n(com.byazt.zad.n nVar, List<com.byazt.vr.n> list) {
        if (nVar == null || !nVar.n()) {
            return;
        }
        List<com.byazt.sf.n> listQ = com.byazt.asa.s.q();
        if (list == null || listQ == null || listQ.isEmpty()) {
            return;
        }
        for (com.byazt.vr.n nVar2 : list) {
            if (nVar2.d() == 1) {
                String strN = com.byazt.hls.q.n(nVar2);
                String strQg = com.byazt.hls.q.qg(nVar2);
                for (com.byazt.sf.n nVar3 : listQ) {
                    if (nVar3 != null) {
                        nVar3.n(strN, strQg);
                    }
                }
            }
        }
    }

    private void n(com.byazt.zad.n nVar, List<com.byazt.vr.n> list, long j, Object obj, int i) {
        if (i == 78) {
            return;
        }
        if (nVar == null) {
            n(-1, list, j, obj, i, null);
            return;
        }
        int iQg = nVar.qg();
        int i2 = -2;
        if (nVar.l()) {
            iQg = -1;
        } else if (iQg < 0) {
            iQg = -2;
        }
        if (iQg == 510 || iQg == 511) {
            iQg = -2;
        }
        if (nVar.n() || ((iQg < 500 || iQg >= 509) && iQg <= 513)) {
            i2 = iQg;
        }
        n(i2, list, j, obj, i, nVar);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00b2 A[Catch: all -> 0x0133, TryCatch #0 {all -> 0x0133, blocks: (B:12:0x002e, B:14:0x0042, B:15:0x004f, B:17:0x0057, B:28:0x006c, B:30:0x0078, B:32:0x0089, B:33:0x0092, B:35:0x009f, B:36:0x00a8, B:37:0x00b2, B:39:0x00c3, B:40:0x00c8, B:42:0x00ce, B:44:0x00d6, B:45:0x00e3), top: B:68:0x002e }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00c3 A[Catch: all -> 0x0133, TryCatch #0 {all -> 0x0133, blocks: (B:12:0x002e, B:14:0x0042, B:15:0x004f, B:17:0x0057, B:28:0x006c, B:30:0x0078, B:32:0x0089, B:33:0x0092, B:35:0x009f, B:36:0x00a8, B:37:0x00b2, B:39:0x00c3, B:40:0x00c8, B:42:0x00ce, B:44:0x00d6, B:45:0x00e3), top: B:68:0x002e }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00e3 A[Catch: all -> 0x0133, TRY_LEAVE, TryCatch #0 {all -> 0x0133, blocks: (B:12:0x002e, B:14:0x0042, B:15:0x004f, B:17:0x0057, B:28:0x006c, B:30:0x0078, B:32:0x0089, B:33:0x0092, B:35:0x009f, B:36:0x00a8, B:37:0x00b2, B:39:0x00c3, B:40:0x00c8, B:42:0x00ce, B:44:0x00d6, B:45:0x00e3), top: B:68:0x002e }] */
    private void n(int i, List<com.byazt.vr.n> list, long j, Object obj, int i2, com.byazt.zad.n nVar) {
        x.n("_debug", "dispatchResult code-->".concat(String.valueOf(i)));
        s sVar = this.qg;
        if (list == null || sVar == null || list.isEmpty()) {
            return;
        }
        boolean z = i2 == 72;
        try {
            Handler handlerQg = sVar.qg();
            com.byazt.fa.qg qgVarN = sVar.n().n(i, list, i2);
            if (this.w.fs()) {
                com.byazt.hls.q.n(i, list, j, this.q, nVar, qgVarN);
            }
            com.byazt.vr.s sVarN = this.q.n();
            if (sVarN != null) {
                sVarN.n(i, list);
            }
            if (i == -2) {
                x.q("_error", "net is available:" + ((oa) com.byazt.qp.q.n("device_info_new")).n(60000L) + " code:" + i);
                this.l.n(2);
                this.l.qg(0);
                n(handlerQg, list, sVar);
            } else if (i == -1) {
                this.l.n(0);
                if (com.byazt.hls.q.l(list.get(0))) {
                    this.l.qg(0);
                }
                if (!n(handlerQg, list, sVar) && this.l.q()) {
                    x.q("_flush", "send reset error");
                    sVar.n(72, "handle_result");
                }
            } else if (i == 0) {
                x.q("_error", "net is available:" + ((oa) com.byazt.qp.q.n("device_info_new")).n(60000L) + " code:" + i);
                this.l.n(2);
                this.l.qg(0);
                n(handlerQg, list, sVar);
            } else if (i == 200) {
                this.l.n(0);
                if (com.byazt.hls.q.l(list.get(0))) {
                    this.l.qg(0);
                }
                if (!n(handlerQg, list, sVar)) {
                    x.q("_flush", "send reset error");
                    sVar.n(72, "handle_result");
                }
            } else if (i == 509 && com.byazt.hls.q.l(list.get(0))) {
                this.l.n(0);
                this.l.qg(1);
                if (handlerQg.hasMessages(3)) {
                    x.n("_error", "already busy message");
                } else if (System.currentTimeMillis() - this.s < 15000) {
                    x.n("_error", "already  busy meesage , too short");
                } else {
                    this.s = System.currentTimeMillis();
                    n(3, 15000L, handlerQg);
                }
            }
            if (!z || obj == null) {
                return;
            }
            synchronized (obj) {
                x.n("_debug", "send notify");
                obj.notifyAll();
            }
        } catch (Throwable th) {
            if (z && obj != null) {
                synchronized (obj) {
                    x.n("_debug", "send notify");
                    obj.notifyAll();
                }
            }
            throw th;
        }
    }

    private boolean n(Handler handler, List<com.byazt.vr.n> list, s sVar) {
        boolean zN = sVar.n(list.get(0));
        boolean zL = com.byazt.hls.q.l(list.get(0));
        if (!zN || !zL) {
            return false;
        }
        if (handler.hasMessages(3)) {
            handler.removeMessages(3);
        }
        this.n.set(0);
        this.s = 0L;
        x.q("_flush", "send flush message from busy reset");
        com.byazt.hls.l.n(com.byazt.kp.s.n.q(), 1, this.w);
        sVar.n(72, "handle_result");
        return true;
    }

    public void n(int i, long j, Handler handler) {
        if (handler == null) {
            x.q("_error", "mHandler == null");
            return;
        }
        if (i == 3) {
            if (handler.hasMessages(i)) {
                handler.removeMessages(i);
            }
            int iIncrementAndGet = this.n.incrementAndGet();
            if (iIncrementAndGet > 5) {
                x.q("_error", "reset busy > 5");
                this.n.set(0);
                this.s = 0L;
                return;
            } else {
                long j2 = ((long) (((iIncrementAndGet - 1) % 4) + 1)) * j;
                x.q("_error", "sendBusyMsg:" + i + "  retryCount:" + iIncrementAndGet + " delayTime:" + (j2 / 1000));
                handler.sendEmptyMessageDelayed(i, j2);
                return;
            }
        }
        x.q("_error", "sendBusyMsg error state");
    }
}
