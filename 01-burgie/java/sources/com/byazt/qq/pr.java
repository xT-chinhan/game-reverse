package com.byazt.qq;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.ca.aj;
import com.byazt.dj.hn;
import com.byazt.gx.DynamicRootView;
import com.byazt.js.c;
import com.byazt.mo.ThemeStatusBroadcastReceiver;
import com.byazt.mq.fw;
import com.byazt.mq.g;
import com.byazt.mq.m;
import com.byazt.mq.w;
import com.byazt.mq.x;
import com.byazt.mq.zo;
import com.byazt.rk.uc;
import com.mar.sdk.MARCode;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1492, 37})
public class pr implements w, x<DynamicRootView> {
    public zo c;
    public ScheduledFuture<?> fw;
    public Context hn;
    public com.byazt.uko.zo hw;
    public DynamicRootView pr;
    public m uc;
    public fw x;
    public AtomicBoolean zo = new AtomicBoolean(false);
    public volatile boolean aj = false;

    public pr(Context context, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, com.byazt.uko.zo zoVar, m mVar, com.byazt.mft.pr prVar) {
        this.hn = context;
        DynamicRootView dynamicRootView = new DynamicRootView(context, themeStatusBroadcastReceiver, z, mVar, prVar);
        this.pr = dynamicRootView;
        this.hw = zoVar;
        this.uc = mVar;
        dynamicRootView.setRenderListener(this);
        this.uc = mVar;
    }

    @Override // com.byazt.mq.x
    public void pr(fw fwVar) {
        int i;
        this.x = fwVar;
        int iZo = this.uc.zo();
        if (iZo < 0) {
            if (this.hw instanceof com.byazt.uko.fw) {
                i = WorkQueueKt.MASK;
            } else {
                i = 117;
            }
            this.pr.pr(i, "time is " + iZo);
            return;
        }
        this.fw = c.pr(new RunnableC0169pr(2), iZo, TimeUnit.MILLISECONDS);
        if (this.aj) {
            aj.hn().postDelayed(new Runnable() { // from class: com.byazt.qq.pr.1
                @Override // java.lang.Runnable
                public void run() {
                    pr.this.fw();
                }
            }, this.uc.w());
        } else if (Looper.getMainLooper() == Looper.myLooper() && this.uc.w() <= 0) {
            fw();
        } else {
            aj.hw().postDelayed(new Runnable() { // from class: com.byazt.qq.pr.2
                @Override // java.lang.Runnable
                public void run() {
                    pr.this.fw();
                }
            }, this.uc.w());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fw() {
        int i;
        this.uc.fw().hw(hw());
        JSONObject jSONObjectC = this.uc.c();
        if (!com.byazt.ce.hw.pr(jSONObjectC)) {
            if (this.hw instanceof com.byazt.uko.fw) {
                i = MARCode.CODE_VIVOCHANNEL_CALLBACK;
            } else {
                i = 113;
            }
            this.pr.pr(i, "data null is " + (jSONObjectC == null));
            return;
        }
        this.hw.pr(new com.byazt.mft.hw() { // from class: com.byazt.qq.pr.3
            @Override // com.byazt.mft.hw
            public void pr(final com.byazt.rk.zo zoVar) {
                pr.this.aj();
                pr.this.uc.fw().hn(pr.this.hw());
                pr.this.pr(zoVar);
                pr.this.hw(zoVar);
                if (pr.this.aj) {
                    pr.this.hn(zoVar);
                } else {
                    aj.hw().post(new Runnable() { // from class: com.byazt.qq.pr.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            pr.this.hn(zoVar);
                        }
                    });
                }
                if (pr.this.pr != null && zoVar != null) {
                    pr.this.pr.setBgColor(zoVar.pr());
                    pr.this.pr.setBgMaterialCenterCalcColor(zoVar.hw());
                }
            }
        });
        this.hw.pr(this.uc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(com.byazt.rk.zo zoVar) {
        List<com.byazt.rk.zo> listW;
        if (zoVar == null || (listW = zoVar.w()) == null || listW.size() <= 0) {
            return;
        }
        Collections.sort(listW, new Comparator<com.byazt.rk.zo>() { // from class: com.byazt.qq.pr.4
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public int compare(com.byazt.rk.zo zoVar2, com.byazt.rk.zo zoVar3) {
                uc ucVarC = zoVar2.vk().c();
                uc ucVarC2 = zoVar3.vk().c();
                if (ucVarC == null || ucVarC2 == null) {
                    return 0;
                }
                if (ucVarC.ey() >= ucVarC2.ey()) {
                    return 1;
                }
                return -1;
            }
        });
        for (com.byazt.rk.zo zoVar2 : listW) {
            if (zoVar2 != null) {
                pr(zoVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(com.byazt.rk.zo zoVar) {
        float fFw;
        float fUc;
        List<com.byazt.rk.zo> listW;
        if (zoVar == null) {
            return;
        }
        List<com.byazt.rk.zo> listW2 = zoVar.w();
        if (listW2 != null && listW2.size() > 0) {
            fFw = 0.0f;
            for (com.byazt.rk.zo zoVar2 : listW2) {
                if (zoVar2.fw() <= zoVar.fw() - zoVar2.aj() && (listW = zoVar2.w()) != null && listW.size() > 0) {
                    fUc = 0.0f;
                    for (com.byazt.rk.zo zoVar3 : listW) {
                        if (zoVar3.vk().getType().equals("logo-union")) {
                            fUc = zoVar3.vk().uc();
                            fFw = (((-fUc) + zoVar.fw()) - zoVar2.fw()) + zoVar2.vk().c().wz();
                        }
                    }
                } else {
                    fUc = 0.0f;
                }
                hw(zoVar2);
                if (fUc <= -15.0f) {
                    zoVar2.uc(zoVar2.aj() - fUc);
                    zoVar2.x(zoVar2.fw() + fUc);
                    for (com.byazt.rk.zo zoVar4 : zoVar2.w()) {
                        zoVar4.x(zoVar4.fw() - fUc);
                    }
                }
            }
        } else {
            fFw = 0.0f;
        }
        com.byazt.rk.zo zoVarK = zoVar.k();
        if (zoVarK == null) {
            return;
        }
        float fUc2 = zoVar.uc() - zoVarK.uc();
        float fFw2 = zoVar.fw() - zoVarK.fw();
        zoVar.hn(fUc2);
        zoVar.x(fFw2);
        if (fFw > 0.0f) {
            zoVar.x(zoVar.fw() - fFw);
            zoVar.uc(zoVar.aj() + fFw);
            for (com.byazt.rk.zo zoVar5 : zoVar.w()) {
                zoVar5.x(zoVar5.fw() + fFw);
            }
        }
    }

    @Override // com.byazt.mq.x
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public DynamicRootView uc() {
        return c();
    }

    @Override // com.byazt.mq.x
    public void pr(boolean z) {
        pr(uc());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void pr(View view) {
        if (view == 0) {
            return;
        }
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i >= viewGroup.getChildCount()) {
                    break;
                }
                pr(viewGroup.getChildAt(i));
                i++;
            }
        }
        if (view instanceof com.byazt.gx.c) {
            ((com.byazt.gx.c) view).hw();
        }
    }

    @Override // com.byazt.mq.x
    public int hw() {
        if (this.hw instanceof com.byazt.uko.fw) {
            return 3;
        }
        return 2;
    }

    public void hn() {
        this.pr.pr();
    }

    public void x() {
        this.pr.hw();
    }

    public void hw(boolean z) {
        this.pr.setSoundMute(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hn(com.byazt.rk.zo zoVar) {
        int i;
        int i2;
        if (zoVar == null) {
            if (this.hw instanceof com.byazt.uko.fw) {
                i2 = MARCode.CODE_VIVOCHANNEL_CALLBACK;
            } else {
                i2 = 113;
            }
            this.pr.pr(i2, "layoutUnit is null");
            return;
        }
        this.uc.fw().x(hw());
        try {
            this.pr.pr(zoVar, hw());
        } catch (Exception e) {
            if (this.hw instanceof com.byazt.uko.fw) {
                i = 128;
            } else {
                i = 118;
            }
            this.pr.pr(i, "exception is " + e.getMessage());
        }
    }

    public DynamicRootView c() {
        return this.pr;
    }

    public void pr(zo zoVar) {
        this.c = zoVar;
    }

    private boolean zo() {
        DynamicRootView dynamicRootView = this.pr;
        return (dynamicRootView == null || dynamicRootView.getChildCount() == 0) ? false : true;
    }

    @Override // com.byazt.mq.w
    public void pr(g gVar) {
        if (this.zo.get()) {
            return;
        }
        this.zo.set(true);
        if (gVar.hn() && zo()) {
            this.pr.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.x.pr(uc(), gVar);
            return;
        }
        this.x.pr(gVar.w(), gVar.vk());
    }

    @Override // com.byazt.mq.w
    public void pr(View view, int i, hn hnVar, int i2) {
        zo zoVar = this.c;
        if (zoVar != null) {
            zoVar.pr(view, i, hnVar, i2);
        }
    }

    @Override // com.byazt.mq.w
    public void hw(View view, int i, hn hnVar, int i2) {
        zo zoVar = this.c;
        if (zoVar != null) {
            zoVar.hw(view, i, hnVar, i2);
        }
    }

    public void hn(boolean z) {
        this.aj = z;
    }

    /* JADX INFO: renamed from: com.byazt.qq.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 1492, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    private class RunnableC0169pr implements Runnable {
        public int hw;

        public RunnableC0169pr(int i) {
            this.hw = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            if (this.hw == 2) {
                if (pr.this.hw instanceof com.byazt.uko.fw) {
                    i = WorkQueueKt.MASK;
                } else {
                    i = 117;
                }
                pr.this.pr.pr(i, (String) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj() {
        try {
            ScheduledFuture<?> scheduledFuture = this.fw;
            if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
                this.fw.cancel(false);
                this.fw = null;
            }
        } catch (Throwable th) {
        }
    }
}
