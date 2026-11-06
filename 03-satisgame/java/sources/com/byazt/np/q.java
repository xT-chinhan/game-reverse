package com.byazt.np;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.byazt.vf.oj;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.msdk.api.activity.TTTransparentActivity;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.ref.SoftReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 20, 5})
public abstract class q extends tj {
    public SoftReference<Activity> a;
    public final Application.ActivityLifecycleCallbacks bb;
    public boolean cy;
    public com.byazt.sg.s h;
    public int hu;
    public int m;
    public boolean n;
    public int ou;
    public Handler py;
    public volatile boolean qg;
    public Object t;
    public SoftReference<Activity> um;
    public String ur;
    public int wm;

    public void n(Activity activity, Object obj, String str) {
    }

    public q(Context context) {
        super(context);
        this.n = false;
        this.cy = true;
        this.qg = false;
        this.um = new SoftReference<>(null);
        this.a = new SoftReference<>(null);
        this.ou = 0;
        this.wm = 2;
        this.m = 0;
        this.hu = 15000;
        this.bb = new Application.ActivityLifecycleCallbacks() { // from class: com.byazt.np.q.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                com.byazt.rb.qg.q(MediationConstant.TAG, "--==--- onAcCred: act: ".concat(String.valueOf(activity)));
                Activity activity2 = (Activity) q.this.a.get();
                if (activity2 == null) {
                    com.byazt.rb.qg.q(MediationConstant.TAG, "--==--- onAcCred: start trans act");
                    if (activity instanceof TTTransparentActivity) {
                        q.this.a = new SoftReference(activity);
                        com.byazt.rb.qg.q(MediationConstant.TAG, "--==--- onAcCred: start trans act, callSupSd");
                        q qVar = q.this;
                        qVar.qg(qVar.h, activity, q.this.t, q.this.ur);
                        com.byazt.rb.qg.q(MediationConstant.TAG, "--==--- onAcCred: end");
                        return;
                    }
                    com.byazt.rb.qg.q(MediationConstant.TAG, "--==--- onAcCred: is not trans");
                    return;
                }
                com.byazt.rb.qg.q(MediationConstant.TAG, "--==--- onAcCred again, showingAct: ".concat(String.valueOf(activity2)));
                String name = activity.getClass().getName();
                if ((activity2 instanceof TTTransparentActivity) && com.byazt.fh.n.qg(name)) {
                    com.byazt.rb.qg.q(MediationConstant.TAG, "--==--- onAcCred again, is adn ad act: ".concat(String.valueOf(activity)));
                    activity2.finish();
                    q.this.a = new SoftReference(activity);
                } else {
                    com.byazt.rb.qg.q(MediationConstant.TAG, "--==--- onAcCred again, is not adn ad act");
                }
                com.byazt.rb.qg.q(MediationConstant.TAG, "--==--- onAcCred: end 2");
            }
        };
    }

    public void qg(com.byazt.qn.qg qgVar) {
        n(qgVar);
        if (this.x != null) {
            this.m = this.x.cy();
            if (q()) {
                this.wm = this.x.hd();
                int iCp = this.x.cp(this.x.fi());
                this.hu = iCp;
                if (iCp <= 0) {
                    this.hu = 15000;
                }
                this.py = new Handler(Looper.getMainLooper());
                return;
            }
            com.byazt.rb.qg.q(MediationConstant.TAG, "--==--- inter full refresh is not enabled");
        }
    }

    private boolean q() {
        return this.m != 0;
    }

    private void l() {
        if (this.qg) {
            return;
        }
        Application applicationN = ((oj) com.byazt.qp.q.n("system_context")).n();
        if (applicationN == null) {
            com.byazt.rb.qg.q(MediationConstant.TAG, "--==--- app is null, 插全屏轮播直接return");
            return;
        }
        applicationN.unregisterActivityLifecycleCallbacks(this.bb);
        applicationN.registerActivityLifecycleCallbacks(this.bb);
        this.qg = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(com.byazt.sg.s sVar, Activity activity, Object obj, String str) {
        super.n(sVar, activity, obj, str);
    }

    @Override // com.byazt.np.tj
    public void n(com.byazt.sg.s sVar, Activity activity, Object obj, String str) {
        if (q()) {
            l();
            this.um = new SoftReference<>(activity);
            this.h = sVar;
            this.q = sVar;
            this.t = obj;
            this.ur = str;
            Intent intent = new Intent(com.byazt.qt.qg.getContext(), (Class<?>) TTTransparentActivity.class);
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
            com.byazt.qt.qg.getContext().startActivity(intent);
            return;
        }
        super.n(sVar, activity, obj, str);
    }

    @Override // com.byazt.np.tj
    public boolean py() {
        return this.n;
    }

    private void n(final Handler handler, final Activity activity) {
        int i = this.hu + AVMDLDataLoader.AVMDLErrorIsInvalidContentLenth;
        if (i <= 0) {
            return;
        }
        handler.postDelayed(new Runnable() { // from class: com.byazt.np.q.2
            @Override // java.lang.Runnable
            public void run() {
                if (!q.this.n(activity)) {
                    q.this.w();
                    return;
                }
                Toast toastMakeText = Toast.makeText(com.byazt.qt.qg.getContext(), "2秒后播放下一个广告", 0);
                toastMakeText.show();
                handler.postDelayed(new n(toastMakeText, 1, handler), 1000L);
            }
        }, i);
    }

    @com.byazt.cp.n(n = {0, 1, 20, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME})
    private static class n implements Runnable {
        public Toast n;
        public final int qg;
        public final Handler s;

        private n(Toast toast, int i, Handler handler) {
            this.n = toast;
            this.qg = i;
            this.s = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.qg > 0) {
                this.n.cancel();
                Toast toastMakeText = Toast.makeText(com.byazt.qt.qg.getContext(), this.qg + "秒后播放下一个广告", 0);
                this.n = toastMakeText;
                toastMakeText.show();
                Handler handler = this.s;
                handler.postDelayed(new n(this.n, this.qg - 1, handler), 1000L);
                return;
            }
            this.n.cancel();
        }
    }

    public final void ou() {
        if (q()) {
            this.cy = true;
            this.ou++;
            final Activity activity = this.um.get();
            final Activity activity2 = this.a.get();
            final com.byazt.sg.s sVar = this.h;
            if (!n(activity2, activity, sVar)) {
                w();
                return;
            }
            Handler handler = this.py;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                n(this.py, activity2);
                this.py.postDelayed(new Runnable() { // from class: com.byazt.np.q.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!q.this.n(activity2)) {
                            q.this.w();
                            return;
                        }
                        com.byazt.rb.qg.q(MediationConstant.TAG, "--==--- refresh 开始，先showingAct finish");
                        q.this.cy = false;
                        activity2.finish();
                        sVar.cd();
                        q.this.a = new SoftReference(null);
                        com.byazt.rb.qg.q(MediationConstant.TAG, "--==--- refresh开始 showingAct finish end");
                        q.this.n = true;
                        q qVar = q.this;
                        qVar.n(activity, qVar.t, q.this.ur);
                    }
                }, this.hu);
            }
        }
    }

    public final void wm() {
        if (q()) {
            if (this.cy) {
                com.byazt.rb.qg.q(MediationConstant.TAG, "--==--- 用户关闭了广，停止refresh");
                Activity activity = this.a.get();
                if (activity instanceof TTTransparentActivity) {
                    com.byazt.rb.qg.q(MediationConstant.TAG, "--==--- 用户关闭了广，finish showingAct");
                    activity.finish();
                    this.a = new SoftReference<>(null);
                }
                w();
                return;
            }
            com.byazt.rb.qg.q(MediationConstant.TAG, "--==--- 调用finish触发了close");
        }
    }

    public final void m() {
        if (q()) {
            com.byazt.rb.qg.q(MediationConstant.TAG, "--==--- 用户点击了广，停止refresh");
            w();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        Handler handler = this.py;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Application applicationN = ((oj) com.byazt.qp.q.n("system_context")).n();
        if (applicationN != null) {
            applicationN.unregisterActivityLifecycleCallbacks(this.bb);
        }
    }

    private boolean n(com.byazt.ws.tj tjVar) {
        return tjVar.oj() && tjVar.n() != 1;
    }

    private boolean q(com.byazt.sg.s sVar) {
        return sVar.rg() && sVar.m() != 1;
    }

    private boolean n(Activity activity, Activity activity2, com.byazt.sg.s sVar) {
        if (this.ou >= this.wm) {
            com.byazt.rb.qg.q(MediationConstant.TAG, "--==--- refresh，轮播次数已达上限: " + this.wm);
            return false;
        }
        if (activity2 == null) {
            com.byazt.rb.qg.q(MediationConstant.TAG, "--==--- refresh 停止轮播 developerAct为null");
            return false;
        }
        if (sVar == null) {
            com.byazt.rb.qg.q(MediationConstant.TAG, "--==--- refresh，tB为null，不轮播");
            return false;
        }
        if (q(sVar)) {
            com.byazt.rb.qg.q(MediationConstant.TAG, "--==--- refresh，展示的是自n，则不轮播");
            return false;
        }
        if (com.byazt.fh.n.n(sVar.lq(), sVar.ct(), sVar.dg())) {
            com.byazt.rb.qg.q(MediationConstant.TAG, "--==--- refresh，当前展广不支持轮播: " + sVar.lq() + ", adtype: " + sVar.ct() + ", subType: " + sVar.dg());
            com.byazt.gp.s.n(this.w, 81011);
            return false;
        }
        if (activity != null) {
            return true;
        }
        com.byazt.rb.qg.q(MediationConstant.TAG, "--==--- refresh，showingAct是null，停止轮播");
        com.byazt.gp.s.n(this.w, 81010);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n(Activity activity) {
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            com.byazt.rb.qg.q(MediationConstant.TAG, "--==--- refresh，showingAct正在finish或已经destroy，停止轮播");
            return false;
        }
        int iUr = ur();
        if (iUr == 2) {
            com.byazt.rb.qg.q(MediationConstant.TAG, "--==--- refresh，无任何广可用，停止轮播");
            com.byazt.gp.s.n(this.w, 81008);
            return false;
        }
        if (iUr == 1) {
            com.byazt.rb.qg.q(MediationConstant.TAG, "--==--- refresh，仅有自n广可用，停止轮播");
            com.byazt.gp.s.n(this.w, 81009);
            return false;
        }
        int iQg = qg(this.l);
        if (iQg == 0) {
            return true;
        }
        com.byazt.rb.qg.q(MediationConstant.TAG, "--==--- refresh，命中了控，停止轮播");
        com.byazt.gp.s.n(this.w, iQg);
        return false;
    }

    private int ur() {
        CopyOnWriteArrayList<com.byazt.sg.s> copyOnWriteArrayListCp;
        CopyOnWriteArrayList<com.byazt.sg.s> copyOnWriteArrayListSz;
        CopyOnWriteArrayList<com.byazt.sg.s> copyOnWriteArrayListD;
        boolean z;
        List<com.byazt.ws.tj> listQg = null;
        if (this.s != null) {
            copyOnWriteArrayListCp = this.s.cp();
            copyOnWriteArrayListSz = this.s.sz();
            copyOnWriteArrayListD = this.s.d();
        } else {
            copyOnWriteArrayListCp = null;
            copyOnWriteArrayListSz = null;
            copyOnWriteArrayListD = null;
        }
        if (copyOnWriteArrayListCp == null || copyOnWriteArrayListCp.size() <= 0) {
            z = false;
        } else {
            z = false;
            for (com.byazt.sg.s sVar : copyOnWriteArrayListCp) {
                if (sVar != null && sVar.ae(this.l) && !sVar.nf()) {
                    if (!q(sVar) && !com.byazt.fh.n.n(sVar.lq(), sVar.ct(), sVar.dg())) {
                        return 0;
                    }
                    z = true;
                }
            }
        }
        if (copyOnWriteArrayListD != null && copyOnWriteArrayListD.size() > 0) {
            for (com.byazt.sg.s sVar2 : copyOnWriteArrayListD) {
                if (sVar2 != null && sVar2.ae(this.l) && !sVar2.nf()) {
                    if (!q(sVar2) && !com.byazt.fh.n.n(sVar2.lq(), sVar2.ct(), sVar2.dg())) {
                        return 0;
                    }
                    z = true;
                }
            }
        }
        if (copyOnWriteArrayListSz != null && copyOnWriteArrayListSz.size() > 0) {
            for (com.byazt.sg.s sVar3 : copyOnWriteArrayListSz) {
                if (sVar3 != null && sVar3.ae(this.l) && !sVar3.nf()) {
                    if (!q(sVar3) && !com.byazt.fh.n.n(sVar3.lq(), sVar3.ct(), sVar3.dg())) {
                        return 0;
                    }
                    z = true;
                }
            }
        }
        try {
            listQg = qg();
        } catch (Throwable unused) {
        }
        if (listQg != null && listQg.size() > 0) {
            for (com.byazt.ws.tj tjVar : listQg) {
                String strCd = tjVar.cd();
                if (tjVar.a() && com.byazt.ra.n.n().q(this.l, strCd, cd()) && com.byazt.ra.n.n().n(strCd, this.w, false) == 3) {
                    if (!n(tjVar) && !com.byazt.fh.n.n(tjVar.k(), tjVar.oa(), tjVar.w())) {
                        return 0;
                    }
                    z = true;
                }
            }
        }
        return z ? 1 : 2;
    }
}
