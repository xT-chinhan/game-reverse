package com.byazt.av;

import android.content.Context;
import android.os.Handler;
import com.byazt.hh.pr;
import com.byazt.nn.fw;
import com.byazt.vkw.g;
import com.byazt.vkw.k;
import com.byazt.vkw.ny;
import com.byazt.vkw.qi;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapsdk.tapad.internal.ionia.IoniaAdWindowTracker;
import com.taptap.sdk.compliance.constants.ComplianceMessage;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, ComplianceMessage.OPEN_ALERT_TIP, 5})
public class uc<T extends com.byazt.hh.pr> {
    public final com.byazt.kbl.hn c;
    public final com.byazt.mqu.hw<com.byazt.hh.pr> fw;
    public hn hw;
    public final k uc;
    public final com.byazt.hh.hw x;
    public ny zo;
    public volatile long hn = 0;
    public final AtomicInteger pr = new AtomicInteger(0);
    public final Runnable aj = new Runnable() { // from class: com.byazt.av.uc.2
        @Override // java.lang.Runnable
        public void run() {
            try {
                uc.this.c.uc();
                uc.this.pr();
            } catch (Exception e) {
            }
        }
    };
    public Handler vk = null;

    public uc(Context context, com.byazt.hh.hw hwVar, com.byazt.kbl.hn hnVar, com.byazt.vkw.pr prVar) {
        this.x = hwVar;
        this.c = hnVar;
        this.uc = (k) com.byazt.zs.uc.pr("csj_settings", prVar);
        this.fw = new com.byazt.pa.hn(prVar, hwVar);
        this.zo = (ny) com.byazt.zs.uc.pr("mediation_settings", prVar);
    }

    public void pr(List<com.byazt.hh.pr> list, String str, int i, Object obj) {
        this.hw = this.c.c();
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.byazt.nn.x.pr(list, i, str);
        com.byazt.nn.x.pr(list, str);
        pr(list, jCurrentTimeMillis, i, obj);
    }

    private void pr(final List<com.byazt.hh.pr> list, final long j, final int i, final Object obj) {
        if (list == null || list.isEmpty()) {
            return;
        }
        qi qiVar = (qi) com.byazt.zs.uc.pr("thread_service");
        ExecutorService executorServiceHw = qiVar.hw();
        if (list.get(0).k() == 1) {
            executorServiceHw = qiVar.pr();
        }
        executorServiceHw.execute(new Runnable() { // from class: com.byazt.av.uc.1
            @Override // java.lang.Runnable
            public void run() {
                uc.this.hw(list, j, i, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr() {
        try {
            qi qiVar = (qi) com.byazt.zs.uc.pr("thread_service");
            Handler handler = this.vk;
            if (handler == null) {
                this.vk = new Handler(qiVar.x().getLooper());
            } else {
                handler.removeCallbacksAndMessages(null);
            }
            this.vk.postDelayed(this.aj, this.zo.x());
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(List<com.byazt.hh.pr> list, long j, int i, Object obj) {
        com.byazt.mqu.pr prVarHw;
        if (list == null) {
            return;
        }
        try {
            if (list.isEmpty()) {
                return;
            }
            com.byazt.hh.pr prVar = list.get(0);
            com.byazt.nn.c.pr(com.byazt.kbl.hn.pr.a(), 1, this.uc);
            if (prVar.w() == 0) {
                prVarHw = this.fw.pr(list, this.c);
                pr(prVarHw, list);
                if (prVarHw != null) {
                    com.byazt.nn.x.pr(list, prVarHw.x(), this.uc);
                }
            } else if (com.byazt.nn.x.pr(list)) {
                prVarHw = this.fw.hn(list, this.c);
                if (prVarHw != null && prVarHw.pr()) {
                    pr();
                }
            } else {
                prVarHw = this.fw.hw(list, this.c);
            }
            pr(prVarHw, list, j, obj, i);
            if (prVarHw != null && prVarHw.uc() && prVar.w() == 0) {
                pr(i);
            }
        } catch (Throwable th) {
            fw.pr("_error", "doInnerUpload", th);
            com.byazt.nn.c.pr(com.byazt.kbl.hn.pr.hn(), 1, this.uc);
        }
    }

    private void pr(int i) {
        hn hnVar = this.hw;
        if (hnVar == null) {
            return;
        }
        try {
            List<com.byazt.hh.pr> listPr = hnVar.pr().pr(i);
            if (listPr != null && !listPr.isEmpty()) {
                fw.hw("_direct", "queryAllHighPriorityFromDb size=" + listPr.size());
                List<com.byazt.pa.hw.pr> listX = this.fw.x(listPr, this.c);
                if (listX != null && !listX.isEmpty()) {
                    for (com.byazt.pa.hw.pr prVar : listX) {
                        if (prVar != null && prVar.pr != null && !prVar.pr.isEmpty()) {
                            hnVar.pr().pr((prVar.hw == null || !prVar.hw.pr) ? -2 : 200, prVar.pr, i);
                        }
                    }
                    return;
                }
                hnVar.pr().pr(-2, listPr, i);
                return;
            }
            fw.hw("_direct", "queryAllHighPriorityFromDb empty, skip");
        } catch (Throwable th) {
            fw.pr("_direct", "doAllHighPriorityDirectConnectUpload error", th);
        }
    }

    private void pr(com.byazt.mqu.pr prVar, List<com.byazt.hh.pr> list) {
        if (prVar == null || !prVar.pr()) {
            return;
        }
        List<com.byazt.fu.pr> listX = com.byazt.yt.hn.x();
        if (list == null || listX == null || listX.isEmpty()) {
            return;
        }
        for (com.byazt.hh.pr prVar2 : list) {
            if (prVar2.k() == 1) {
                String strPr = com.byazt.nn.x.pr(prVar2);
                String strHw = com.byazt.nn.x.hw(prVar2);
                for (com.byazt.fu.pr prVar3 : listX) {
                    if (prVar3 != null) {
                        prVar3.pr(strPr, strHw);
                    }
                }
            }
        }
    }

    private void pr(com.byazt.mqu.pr prVar, List<com.byazt.hh.pr> list, long j, Object obj, int i) {
        if (i == 78) {
            return;
        }
        if (prVar == null) {
            pr(-1, list, j, obj, i, null);
            return;
        }
        int iHw = prVar.hw();
        int i2 = -2;
        if (prVar.c()) {
            iHw = -1;
        } else if (iHw < 0) {
            iHw = -2;
        }
        if (iHw == 510 || iHw == 511) {
            iHw = -2;
        }
        if (prVar.pr() || ((iHw < 500 || iHw >= 509) && iHw <= 513)) {
            i2 = iHw;
        }
        pr(i2, list, j, obj, i, prVar);
    }

    private void pr(int i, List<com.byazt.hh.pr> list, long j, Object obj, int i2, com.byazt.mqu.pr prVar) {
        fw.pr("_debug", "dispatchResult code-->".concat(String.valueOf(i)));
        hn hnVar = this.hw;
        if (list == null || hnVar == null || list.isEmpty()) {
            return;
        }
        boolean z = i2 == 72;
        try {
            Handler handlerHw = hnVar.hw();
            com.byazt.ie.hw hwVarPr = hnVar.pr().pr(i, list, i2);
            if (this.uc.zo()) {
                com.byazt.nn.x.pr(i, list, j, this.x, prVar, hwVarPr);
            }
            com.byazt.hh.hn hnVarPr = this.x.pr();
            if (hnVarPr != null) {
                hnVarPr.pr(i, list);
            }
            switch (i) {
                case -2:
                case 0:
                    fw.x("_error", "net is available:" + ((g) com.byazt.zs.uc.pr("device_info_new")).pr(60000L) + " code:" + i);
                    this.c.pr(2);
                    this.c.hw(0);
                    pr(handlerHw, list, hnVar);
                    break;
                case -1:
                case 200:
                    this.c.pr(0);
                    if (com.byazt.nn.x.c(list.get(0))) {
                        this.c.hw(0);
                    }
                    if (!pr(handlerHw, list, hnVar) && this.c.hn()) {
                        fw.x("_flush", "send reset error");
                        hnVar.pr(72, "handle_result");
                    }
                    break;
                case MediaPlayer.MEDIA_PLAYER_OPTION_MODULE_NAME /* 509 */:
                    if (com.byazt.nn.x.c(list.get(0))) {
                        this.c.pr(0);
                        this.c.hw(1);
                        if (handlerHw.hasMessages(3)) {
                            fw.pr("_error", "already busy message");
                        } else if (System.currentTimeMillis() - this.hn >= IoniaAdWindowTracker.BANNER_WINDOW_IDLE_TIMEOUT_MS) {
                            this.hn = System.currentTimeMillis();
                            pr(3, IoniaAdWindowTracker.BANNER_WINDOW_IDLE_TIMEOUT_MS, handlerHw);
                        } else {
                            fw.pr("_error", "already  busy meesage , too short");
                        }
                    }
                    break;
            }
            if (z && obj != null) {
                synchronized (obj) {
                    fw.pr("_debug", "send notify");
                    obj.notifyAll();
                }
            }
        } catch (Throwable th) {
            if (z && obj != null) {
                synchronized (obj) {
                    fw.pr("_debug", "send notify");
                    obj.notifyAll();
                }
            }
            throw th;
        }
    }

    private boolean pr(Handler handler, List<com.byazt.hh.pr> list, hn hnVar) {
        boolean zPr = hnVar.pr(list.get(0));
        boolean zC = com.byazt.nn.x.c(list.get(0));
        if (!zPr || !zC) {
            return false;
        }
        if (handler.hasMessages(3)) {
            handler.removeMessages(3);
        }
        this.pr.set(0);
        this.hn = 0L;
        fw.x("_flush", "send flush message from busy reset");
        com.byazt.nn.c.pr(com.byazt.kbl.hn.pr.x(), 1, this.uc);
        hnVar.pr(72, "handle_result");
        return true;
    }

    public void pr(int i, long j, Handler handler) {
        if (handler == null) {
            fw.x("_error", "mHandler == null");
            return;
        }
        if (i != 3) {
            fw.x("_error", "sendBusyMsg error state");
            return;
        }
        if (handler.hasMessages(i)) {
            handler.removeMessages(i);
        }
        int iIncrementAndGet = this.pr.incrementAndGet();
        if (iIncrementAndGet > 5) {
            fw.x("_error", "reset busy > 5");
            this.pr.set(0);
            this.hn = 0L;
        } else {
            long j2 = ((long) (((iIncrementAndGet - 1) % 4) + 1)) * j;
            fw.x("_error", "sendBusyMsg:" + i + "  retryCount:" + iIncrementAndGet + " delayTime:" + (j2 / 1000));
            handler.sendEmptyMessageDelayed(i, j2);
        }
    }
}
