package com.byazt.jeb;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.byazt.hls.x;
import com.byazt.vf.cp;
import com.byazt.vf.oa;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1621, 8})
public class s extends l implements Handler.Callback {
    public static int cy = 10;
    public static int hd = 200;
    public volatile int a;
    public final String cd;
    public final long cp;
    public volatile Handler d;
    public int fs;
    public oa h;
    public Context hu;
    public volatile boolean k;
    public final Object l;
    public final HashMap<String, List<com.byazt.vr.n>> m;
    public com.byazt.vr.q n;
    public final List<com.byazt.vr.n> oa;
    public volatile com.byazt.vf.n ou;
    public volatile String py;
    public final Object q;
    public final AtomicInteger rv;
    public final List<com.byazt.vr.n> sz;
    public cp t;
    public final long tj;
    public final String um;
    public w w;
    public final qg wm;
    public int x;

    public s(Context context, com.byazt.vr.qg qgVar, com.byazt.kp.s sVar, com.byazt.vf.n nVar) {
        super(qgVar, sVar);
        this.q = new Object();
        this.l = new Object();
        this.x = 0;
        this.fs = 0;
        this.rv = new AtomicInteger(0);
        this.tj = 5000L;
        this.cp = 5000000000L;
        this.oa = new ArrayList();
        this.sz = new CopyOnWriteArrayList();
        this.k = false;
        this.cd = "after_upload";
        this.um = "prepare_upload";
        this.a = 0;
        this.py = "DEFAULT";
        this.m = new HashMap<>();
        this.hu = context;
        this.h = (oa) com.byazt.qp.q.n("device_info_new");
        this.t = (cp) com.byazt.qp.q.n("csj_settings", nVar);
        this.n = new com.byazt.fa.s(context, qgVar, this, nVar);
        this.w = new w(context, this.qg, this.s, nVar);
        this.wm = new qg(qgVar, this.t);
    }

    public com.byazt.vr.q n() {
        return this.n;
    }

    public Handler qg() {
        return this.d;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        ArrayList arrayList;
        int i = message.what;
        try {
            this.wm.n(message);
            boolean z = ((oa) com.byazt.qp.q.n("device_info_new")).n(60000L) != 0;
            if (i == 1) {
                x.n("_ams", "MESSAGE_INIT");
                synchronized (this.l) {
                    arrayList = new ArrayList(this.sz);
                    this.sz.clear();
                    this.k = true;
                }
                this.wm.s();
                if (!arrayList.isEmpty()) {
                    x.n("_ms", "initSize:" + arrayList.size());
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        n((com.byazt.vr.n) it.next(), 1, z);
                    }
                }
            } else if (i == 3) {
                x.n("_ams", "NET_ERROR");
                s((com.byazt.vr.n) null, 3, z);
            } else if (i == 5) {
                x.n("_ams", "OPT_DELAY_AD_MESSAGE");
                ArrayList arrayList2 = new ArrayList(this.oa);
                this.oa.clear();
                s(arrayList2, "timeout_dispatch", 5);
            } else if (i == 74) {
                x.n("_ams", "MESSAGE_NEW_EVENT");
                n((com.byazt.vr.n) message.obj, 74, z);
            } else if (i == 71) {
                x.n("_ams", "MESSAGE_ROUTINE_BATCH_ONCE");
                s((com.byazt.vr.n) null, 71, z);
            } else if (i == 72) {
                x.n("_ams", "MESSAGE_FLUSH_MEMORY_DB");
                s((com.byazt.vr.n) null, 72, z);
            }
        } catch (Throwable th) {
            x.n("csj_log_error", "handleMessage", th);
        }
        return true;
    }

    @Override // com.byazt.jeb.q
    public void s() {
        this.d = new Handler(l(), this);
        this.s.n(this.d);
        this.d.sendEmptyMessage(1);
        x.n("_ms", "onLooperPrepared");
    }

    public boolean n(int i, String str, com.byazt.vr.n nVar) {
        if (this.qg == null) {
            return false;
        }
        return this.n.n(i, str, nVar);
    }

    public void n(com.byazt.vr.n nVar, boolean z) {
        if (nVar == null) {
            return;
        }
        x.n("other thread ignore result : " + z + " adType: " + ((int) nVar.cp()));
        if (z) {
            if (this.d != null) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(nVar);
                s(arrayList, "ignore_result_dispatch", 78);
                return;
            }
            x.q("_error", "other thread handler is null，ignore is true");
            return;
        }
        synchronized (this.l) {
            if (this.k) {
                Message messageObtain = Message.obtain();
                messageObtain.obj = nVar;
                messageObtain.what = 74;
                this.wm.n();
                this.d.sendMessage(messageObtain);
                x.qg("new message send");
            } else {
                this.wm.qg();
                this.sz.add(nVar);
                x.qg("new message add delayList");
            }
        }
    }

    public void n(int i, String str) {
        try {
            if (!(((oa) com.byazt.qp.q.n("device_info_new")).n(60000L) != 0)) {
                x.q("_error", "AdThread NET IS NOT AVAILABLE");
                return;
            }
            boolean zN = n(i, str + " check", (com.byazt.vr.n) null);
            x.s("_flush", "notify runOnce check: " + zN + " " + str);
            if (zN) {
                Message messageObtain = Message.obtain();
                messageObtain.what = i;
                this.d.sendMessage(messageObtain);
            }
        } catch (Throwable th) {
            x.n("atLeast", th);
        }
    }

    private void n(com.byazt.vr.n nVar, int i, boolean z) {
        try {
            qg(nVar, i, z);
            s(nVar, i, z);
        } catch (Throwable th) {
            x.n("handleEvent", th);
            com.byazt.hls.l.n(com.byazt.kp.s.n.s(), 1, this.t);
        }
    }

    private void qg(com.byazt.vr.n nVar, int i, boolean z) {
        this.rv.set(0);
        com.byazt.hls.l.n(com.byazt.kp.s.n.cp(), 1, this.t);
        this.n.n(nVar, i, z);
        com.byazt.hls.q.n(nVar, "_ad");
        com.byazt.hls.q.qg(nVar, this.t);
    }

    public boolean n(com.byazt.vr.n nVar) {
        return this.s.l() && com.byazt.hls.q.l(nVar);
    }

    private void s(com.byazt.vr.n nVar, int i, boolean z) {
        boolean zL = this.s.l();
        boolean z2 = false;
        boolean z3 = com.byazt.hls.q.l(nVar) || i == 3;
        boolean zN = com.byazt.hls.q.n(i);
        x.n("_ms", "serbusy:" + zL + " isApplogMessageBusy:" + z3 + " flush:" + zN);
        if (zL && z3 && !zN) {
            if (i == 3) {
                x.q("_error", "start do flush");
                s((com.byazt.vr.n) null, 72, z);
                return;
            } else {
                if (i == 74 || i == 1) {
                    boolean zHasMessages = this.d.hasMessages(3);
                    x.q("_error", "server busy return : hasBusyMsg:".concat(String.valueOf(zHasMessages)));
                    if (zHasMessages) {
                        return;
                    }
                    this.w.n(3, 15000L, this.d);
                    return;
                }
                x.q("_error", "server busy");
                return;
            }
        }
        if (!z) {
            x.q("_error", "AdThread NET IS NOT AVAILABLE!!!");
            return;
        }
        boolean zN2 = n(i, "needUpload check", nVar);
        x.n("_ms", "prepare upload check ".concat(String.valueOf(zN2)));
        if (zN2) {
            List<com.byazt.vr.n> listN = this.n.n(i, nVar, zL, this.a + "_" + this.py);
            if (listN != null && !listN.isEmpty()) {
                x.s("_ms", "prepare get size =" + listN.size());
                n(listN, i);
            } else {
                x.s("_ms", "prepare get no event need upload");
                n("prepare_upload");
            }
            x.qg("_ms", "prepare upload end needUpload:".concat(String.valueOf(z2)));
        }
        x.s("_ms", "prepare upload no need");
        this.m.clear();
        n("prepare_upload");
        z2 = zN2;
        x.qg("_ms", "prepare upload end needUpload:".concat(String.valueOf(z2)));
    }

    private void n(String str) {
        if (!this.oa.isEmpty()) {
            com.byazt.vr.s sVarN = this.qg.n();
            if (this.d.hasMessages(5)) {
                this.d.removeMessages(5);
            }
            long jRv = hd;
            cp cpVar = (cp) com.byazt.qp.q.n("csj_settings", this.ou);
            if (sVarN != null) {
                jRv = cpVar.rv();
            }
            this.d.sendEmptyMessageDelayed(5, jRv);
            x.n("_ms", "handler send delay:" + jRv + " size:" + this.oa.size());
            return;
        }
        x.qg("_ms", "do nothing");
    }

    private void n(List<com.byazt.vr.n> list, String str, int i) {
        s(list, str, i);
    }

    private void n(List<com.byazt.vr.n> list, int i) {
        com.byazt.hls.q.n(list, this.t);
        com.byazt.vr.n nVar = list.get(0);
        if (nVar == null) {
            x.q("_error", "adLogEvent is null");
            return;
        }
        if (list.size() > 1 || com.byazt.hls.q.n(list)) {
            if (nVar.cp() == 0 && nVar.d() == 2 && i == 74) {
                qg(list, "batchOptimize", i);
                return;
            } else {
                n(list, "batchRead", i);
                return;
            }
        }
        if (nVar.d() == 1) {
            n(list, "highPriority", i);
            return;
        }
        if (nVar.cp() == 0 && nVar.d() == 2) {
            qg(list, "singleOptimize", i);
            return;
        }
        if (nVar.cp() == 1) {
            n(list, "stats_directly", i);
            return;
        }
        if (nVar.cp() == 3) {
            n(list, "adType_v3_directly", i);
        } else if (nVar.cp() == 2) {
            n(list, "other_directly", i);
        } else {
            x.q("_error", "adLogEvent adType error");
        }
    }

    private void qg(List<com.byazt.vr.n> list, String str, int i) {
        this.oa.addAll(list);
        cy = ((cp) com.byazt.qp.q.n("csj_settings", this.ou)).tj();
        if (this.oa.size() >= cy) {
            if (this.d.hasMessages(5)) {
                this.d.removeMessages(5);
            }
            ArrayList arrayList = new ArrayList(this.oa);
            this.oa.clear();
            s(arrayList, "max_size_dispatch", i);
            return;
        }
        n(str);
    }

    private void s(List<com.byazt.vr.n> list, String str, int i) {
        this.w.n(list, str, i, this.q);
        if (i != 78) {
            n(i, list);
        }
    }

    private void n(int i, List<com.byazt.vr.n> list) {
        n("after_upload");
        if (i != 72) {
            if (w()) {
                x.s("_flush", "keep flush message for in-progress flush, current message:" + com.byazt.hls.q.qg(i));
                return;
            }
            this.fs = 0;
            this.x = 0;
            if (this.d.hasMessages(72)) {
                this.d.removeMessages(72);
                return;
            }
            return;
        }
        if (list == null || list.isEmpty()) {
            return;
        }
        n(list);
    }

    private boolean w() {
        Handler handler = this.d;
        return handler != null && handler.hasMessages(72);
    }

    private void n(List<com.byazt.vr.n> list) {
        synchronized (this.q) {
            try {
                try {
                    if (this.x == 0) {
                        int iQg = this.n.qg() + this.n.n();
                        com.byazt.vr.w wVarS = this.qg.s();
                        int iN = wVarS != null ? wVarS.n() : 10;
                        if (iQg != 0 && iN != 0) {
                            this.x = (iQg / iN) + 5;
                        }
                    }
                    long jNanoTime = System.nanoTime();
                    this.q.wait(5000L);
                    long jNanoTime2 = System.nanoTime() - jNanoTime;
                    if (jNanoTime2 < 5000000000L && 5000000000L - jNanoTime2 >= 50000000) {
                        if (n(list.get(0))) {
                            x.q("_error", "return wait serverBusy");
                            return;
                        }
                        if (this.s.q()) {
                            x.q("_error", "return wait otherError");
                            return;
                        }
                        com.byazt.hls.l.n(com.byazt.kp.s.n.qg(), 1, this.t);
                        int i = this.fs;
                        if (i < this.x) {
                            this.fs = i + 1;
                            x.s("_flush", "afterUpload send flush again:" + this.fs);
                            n(72, "continue");
                        } else {
                            this.fs = 0;
                            this.x = 0;
                            if (this.d.hasMessages(72)) {
                                this.d.removeMessages(72);
                            }
                            x.q("_flush", "afterUpload send flush end");
                        }
                        return;
                    }
                    x.q("_error", "return wait timeout");
                } catch (InterruptedException unused) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void n(com.byazt.vf.n nVar) {
        this.ou = nVar;
    }
}
