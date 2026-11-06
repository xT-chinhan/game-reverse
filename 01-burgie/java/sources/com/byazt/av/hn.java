package com.byazt.av;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.byazt.nn.fw;
import com.byazt.vkw.g;
import com.byazt.vkw.k;
import com.tapsdk.tapad.internal.ionia.IoniaAdWindowTracker;
import com.taptap.sdk.compliance.constants.ComplianceMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, ComplianceMessage.OPEN_ALERT_TIP, 20})
public class hn extends c implements Handler.Callback {
    public static int nt = 10;
    public static int yb = 200;
    public volatile int a;
    public final AtomicInteger aj;
    public g b;
    public final Object c;
    public volatile String cz;
    public final hw fo;
    public int fw;
    public final List<com.byazt.hh.pr> g;
    public volatile boolean ho;
    public k iu;
    public volatile Handler k;
    public final String lb;
    public final List<com.byazt.hh.pr> m;
    public volatile com.byazt.vkw.pr ny;
    public com.byazt.hh.x pr;
    public final String qa;
    public final HashMap<String, List<com.byazt.hh.pr>> rc;
    public uc uc;
    public final long vk;
    public final long w;
    public final Object x;
    public Context z;
    public int zo;

    public hn(Context context, com.byazt.hh.hw hwVar, com.byazt.kbl.hn hnVar, com.byazt.vkw.pr prVar) {
        super(hwVar, hnVar);
        this.x = new Object();
        this.c = new Object();
        this.fw = 0;
        this.zo = 0;
        this.aj = new AtomicInteger(0);
        this.vk = 5000L;
        this.w = 5000000000L;
        this.m = new ArrayList();
        this.g = new CopyOnWriteArrayList();
        this.ho = false;
        this.lb = "after_upload";
        this.qa = "prepare_upload";
        this.a = 0;
        this.cz = "DEFAULT";
        this.rc = new HashMap<>();
        this.z = context;
        this.b = (g) com.byazt.zs.uc.pr("device_info_new");
        this.iu = (k) com.byazt.zs.uc.pr("csj_settings", prVar);
        this.pr = new com.byazt.ie.hn(context, hwVar, this, prVar);
        this.uc = new uc(context, this.hw, this.hn, prVar);
        this.fo = new hw(hwVar, this.iu);
    }

    public com.byazt.hh.x pr() {
        return this.pr;
    }

    public Handler hw() {
        return this.k;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        ArrayList arrayList;
        int i = message.what;
        try {
            this.fo.pr(message);
            boolean z = ((g) com.byazt.zs.uc.pr("device_info_new")).pr(60000L) != 0;
            switch (i) {
                case 1:
                    fw.pr("_ams", "MESSAGE_INIT");
                    synchronized (this.c) {
                        arrayList = new ArrayList(this.g);
                        this.g.clear();
                        this.ho = true;
                        break;
                    }
                    this.fo.hn();
                    if (!arrayList.isEmpty()) {
                        fw.pr("_ms", "initSize:" + arrayList.size());
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            pr((com.byazt.hh.pr) it.next(), 1, z);
                        }
                    }
                    return true;
                case 3:
                    fw.pr("_ams", "NET_ERROR");
                    hn((com.byazt.hh.pr) null, 3, z);
                    return true;
                case 5:
                    fw.pr("_ams", "OPT_DELAY_AD_MESSAGE");
                    ArrayList arrayList2 = new ArrayList(this.m);
                    this.m.clear();
                    hn(arrayList2, "timeout_dispatch", 5);
                    return true;
                case 71:
                    fw.pr("_ams", "MESSAGE_ROUTINE_BATCH_ONCE");
                    hn((com.byazt.hh.pr) null, 71, z);
                    return true;
                case 72:
                    fw.pr("_ams", "MESSAGE_FLUSH_MEMORY_DB");
                    hn((com.byazt.hh.pr) null, 72, z);
                    return true;
                case 74:
                    fw.pr("_ams", "MESSAGE_NEW_EVENT");
                    pr((com.byazt.hh.pr) message.obj, 74, z);
                    return true;
                default:
                    return true;
            }
        } catch (Throwable th) {
            fw.pr("csj_log_error", "handleMessage", th);
        }
    }

    @Override // com.byazt.av.x
    public void hn() {
        this.k = new Handler(c(), this);
        this.hn.pr(this.k);
        this.k.sendEmptyMessage(1);
        fw.pr("_ms", "onLooperPrepared");
    }

    public boolean pr(int i, String str, com.byazt.hh.pr prVar) {
        if (this.hw == null) {
            return false;
        }
        return this.pr.pr(i, str, prVar);
    }

    public void pr(com.byazt.hh.pr prVar, boolean z) {
        if (prVar == null) {
            return;
        }
        fw.pr("other thread ignore result : " + z + " adType: " + ((int) prVar.w()));
        if (z) {
            if (this.k != null) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(prVar);
                hn(arrayList, "ignore_result_dispatch", 78);
                return;
            }
            fw.x("_error", "other thread handler is null，ignore is true");
            return;
        }
        synchronized (this.c) {
            if (this.ho) {
                Message messageObtain = Message.obtain();
                messageObtain.obj = prVar;
                messageObtain.what = 74;
                this.fo.pr();
                this.k.sendMessage(messageObtain);
                fw.hw("new message send");
            } else {
                this.fo.hw();
                this.g.add(prVar);
                fw.hw("new message add delayList");
            }
        }
    }

    public void pr(int i, String str) {
        try {
            if (!(((g) com.byazt.zs.uc.pr("device_info_new")).pr(60000L) != 0)) {
                fw.x("_error", "AdThread NET IS NOT AVAILABLE");
                return;
            }
            boolean zPr = pr(i, str + " check", (com.byazt.hh.pr) null);
            fw.hn("_flush", "notify runOnce check: " + zPr + " " + str);
            if (zPr) {
                Message messageObtain = Message.obtain();
                messageObtain.what = i;
                this.k.sendMessage(messageObtain);
            }
        } catch (Throwable th) {
            fw.pr("atLeast", th);
        }
    }

    private void pr(com.byazt.hh.pr prVar, int i, boolean z) {
        try {
            hw(prVar, i, z);
            hn(prVar, i, z);
        } catch (Throwable th) {
            fw.pr("handleEvent", th);
            com.byazt.nn.c.pr(com.byazt.kbl.hn.pr.hn(), 1, this.iu);
        }
    }

    private void hw(com.byazt.hh.pr prVar, int i, boolean z) {
        this.aj.set(0);
        com.byazt.nn.c.pr(com.byazt.kbl.hn.pr.w(), 1, this.iu);
        this.pr.pr(prVar, i, z);
        com.byazt.nn.x.pr(prVar, "_ad");
        com.byazt.nn.x.hw(prVar, this.iu);
    }

    public boolean pr(com.byazt.hh.pr prVar) {
        return this.hn.x() && com.byazt.nn.x.c(prVar);
    }

    private void hn(com.byazt.hh.pr prVar, int i, boolean z) {
        boolean zX = this.hn.x();
        boolean z2 = false;
        boolean z3 = com.byazt.nn.x.c(prVar) || i == 3;
        boolean zPr = com.byazt.nn.x.pr(i);
        fw.pr("_ms", "serbusy:" + zX + " isApplogMessageBusy:" + z3 + " flush:" + zPr);
        if (zX && z3 && !zPr) {
            if (i == 3) {
                fw.x("_error", "start do flush");
                hn((com.byazt.hh.pr) null, 72, z);
                return;
            } else {
                if (i != 74 && i != 1) {
                    fw.x("_error", "server busy");
                    return;
                }
                boolean zHasMessages = this.k.hasMessages(3);
                fw.x("_error", "server busy return : hasBusyMsg:".concat(String.valueOf(zHasMessages)));
                if (!zHasMessages) {
                    this.uc.pr(3, IoniaAdWindowTracker.BANNER_WINDOW_IDLE_TIMEOUT_MS, this.k);
                    return;
                }
                return;
            }
        }
        if (!z) {
            fw.x("_error", "AdThread NET IS NOT AVAILABLE!!!");
            return;
        }
        boolean zPr2 = pr(i, "needUpload check", prVar);
        fw.pr("_ms", "prepare upload check ".concat(String.valueOf(zPr2)));
        if (zPr2) {
            List<com.byazt.hh.pr> listPr = this.pr.pr(i, prVar, zX, this.a + "_" + this.cz);
            if (listPr != null && !listPr.isEmpty()) {
                fw.hn("_ms", "prepare get size =" + listPr.size());
                pr(listPr, i);
            } else {
                fw.hn("_ms", "prepare get no event need upload");
                pr("prepare_upload");
            }
            fw.hw("_ms", "prepare upload end needUpload:".concat(String.valueOf(z2)));
        }
        fw.hn("_ms", "prepare upload no need");
        this.rc.clear();
        pr("prepare_upload");
        z2 = zPr2;
        fw.hw("_ms", "prepare upload end needUpload:".concat(String.valueOf(z2)));
    }

    private void pr(String str) {
        if (!this.m.isEmpty()) {
            com.byazt.hh.hn hnVarPr = this.hw.pr();
            if (this.k.hasMessages(5)) {
                this.k.removeMessages(5);
            }
            long jAj = yb;
            k kVar = (k) com.byazt.zs.uc.pr("csj_settings", this.ny);
            if (hnVarPr != null) {
                jAj = kVar.aj();
            }
            this.k.sendEmptyMessageDelayed(5, jAj);
            fw.pr("_ms", "handler send delay:" + jAj + " size:" + this.m.size());
            return;
        }
        fw.hw("_ms", "do nothing");
    }

    private void pr(List<com.byazt.hh.pr> list, String str, int i) {
        hn(list, str, i);
    }

    private void pr(List<com.byazt.hh.pr> list, int i) {
        com.byazt.nn.x.pr(list, this.iu);
        com.byazt.hh.pr prVar = list.get(0);
        if (prVar == null) {
            fw.x("_error", "adLogEvent is null");
            return;
        }
        if (list.size() > 1 || com.byazt.nn.x.pr(list)) {
            if (prVar.w() == 0 && prVar.k() == 2 && i == 74) {
                hw(list, "batchOptimize", i);
                return;
            } else {
                pr(list, "batchRead", i);
                return;
            }
        }
        if (prVar.k() == 1) {
            pr(list, "highPriority", i);
            return;
        }
        if (prVar.w() == 0 && prVar.k() == 2) {
            hw(list, "singleOptimize", i);
            return;
        }
        if (prVar.w() == 1) {
            pr(list, "stats_directly", i);
            return;
        }
        if (prVar.w() == 3) {
            pr(list, "adType_v3_directly", i);
        } else if (prVar.w() != 2) {
            fw.x("_error", "adLogEvent adType error");
        } else {
            pr(list, "other_directly", i);
        }
    }

    private void hw(List<com.byazt.hh.pr> list, String str, int i) {
        this.m.addAll(list);
        nt = ((k) com.byazt.zs.uc.pr("csj_settings", this.ny)).vk();
        if (this.m.size() >= nt) {
            if (this.k.hasMessages(5)) {
                this.k.removeMessages(5);
            }
            ArrayList arrayList = new ArrayList(this.m);
            this.m.clear();
            hn(arrayList, "max_size_dispatch", i);
            return;
        }
        pr(str);
    }

    private void hn(List<com.byazt.hh.pr> list, String str, int i) {
        this.uc.pr(list, str, i, this.x);
        if (i != 78) {
            pr(i, list);
        }
    }

    private void pr(int i, List<com.byazt.hh.pr> list) {
        pr("after_upload");
        if (i != 72) {
            if (uc()) {
                fw.hn("_flush", "keep flush message for in-progress flush, current message:" + com.byazt.nn.x.hw(i));
                return;
            }
            this.zo = 0;
            this.fw = 0;
            if (this.k.hasMessages(72)) {
                this.k.removeMessages(72);
                return;
            }
            return;
        }
        if (list == null || list.isEmpty()) {
            return;
        }
        pr(list);
    }

    private boolean uc() {
        Handler handler = this.k;
        return handler != null && handler.hasMessages(72);
    }

    private void pr(List<com.byazt.hh.pr> list) {
        synchronized (this.x) {
            try {
                try {
                    if (this.fw == 0) {
                        int iHw = this.pr.hw() + this.pr.pr();
                        com.byazt.hh.uc ucVarHn = this.hw.hn();
                        int iPr = 10;
                        if (ucVarHn != null) {
                            iPr = ucVarHn.pr();
                        }
                        if (iHw != 0 && iPr != 0) {
                            this.fw = (iHw / iPr) + 5;
                        }
                    }
                    long jNanoTime = System.nanoTime();
                    this.x.wait(5000L);
                    long jNanoTime2 = System.nanoTime() - jNanoTime;
                    if (jNanoTime2 < 5000000000L && 5000000000L - jNanoTime2 >= 50000000) {
                        if (pr(list.get(0))) {
                            fw.x("_error", "return wait serverBusy");
                            return;
                        }
                        if (this.hn.hn()) {
                            fw.x("_error", "return wait otherError");
                            return;
                        }
                        com.byazt.nn.c.pr(com.byazt.kbl.hn.pr.hw(), 1, this.iu);
                        int i = this.zo;
                        if (i < this.fw) {
                            this.zo = i + 1;
                            fw.hn("_flush", "afterUpload send flush again:" + this.zo);
                            pr(72, "continue");
                        } else {
                            this.zo = 0;
                            this.fw = 0;
                            if (this.k.hasMessages(72)) {
                                this.k.removeMessages(72);
                            }
                            fw.x("_flush", "afterUpload send flush end");
                        }
                        return;
                    }
                    fw.x("_error", "return wait timeout");
                } catch (Throwable th) {
                    throw th;
                }
            } catch (InterruptedException e) {
            }
        }
    }

    public void pr(com.byazt.vkw.pr prVar) {
        this.ny = prVar;
    }
}
