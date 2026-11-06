package com.byazt.kp;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.byazt.hls.x;
import com.byazt.qp.q;
import com.byazt.vf.cp;
import com.byazt.vf.oa;
import com.byazt.vf.wo;
import com.byazt.vr.l;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_COLOR_PRIMARIES, 8})
public class s implements l {
    public cp cp;
    public oa d;
    public com.byazt.vr.qg fs;
    public com.byazt.vf.n rv;
    public Context tj;
    public volatile com.byazt.jeb.s w;
    public volatile Handler x;
    public static final qg n = new qg();
    public static final long q = System.currentTimeMillis();
    public static long l = 0;
    public volatile int qg = 0;
    public volatile int s = 0;

    public s(Context context, com.byazt.vr.qg qgVar, com.byazt.vf.n nVar, oa oaVar) {
        this.tj = context;
        this.fs = qgVar;
        this.rv = nVar;
        this.d = oaVar;
        this.cp = (cp) q.n("csj_settings", nVar);
        this.w = new com.byazt.jeb.s(context, qgVar, this, nVar);
        this.w.q();
    }

    public cp s() {
        return this.cp;
    }

    @Override // com.byazt.vr.l
    public Context getContext() {
        return this.tj;
    }

    @Override // com.byazt.vr.l
    public oa qg() {
        return this.d;
    }

    @Override // com.byazt.vr.l
    public com.byazt.vr.qg n() {
        return this.fs;
    }

    public void n(int i) {
        this.qg = i;
    }

    public boolean q() {
        return this.qg == 2;
    }

    public void qg(int i) {
        this.s = i;
    }

    public boolean l() {
        return this.s == 1;
    }

    @Override // com.byazt.vr.l
    public void n(boolean z) {
        if (this.fs != null && z) {
            x();
        }
    }

    public com.byazt.jeb.s w() {
        return this.w;
    }

    public void n(Handler handler) {
        this.x = handler;
    }

    @Override // com.byazt.vr.l
    public void n(com.byazt.vr.n nVar) {
        x.n("report()");
        if (nVar == null) {
            x.l("error : log config is null");
            return;
        }
        com.byazt.vr.s sVarN = this.fs.n();
        com.byazt.jeb.s sVar = this.w;
        if (sVar != null) {
            sVar.n(this.rv);
            n(sVarN, nVar);
            sVar.n(nVar, nVar.d() == 4);
        }
    }

    private void n(final com.byazt.vr.s sVar, com.byazt.vr.n nVar) {
        if (sVar != null) {
            try {
                if (this.cp.fs()) {
                    final long jSz = nVar != null ? nVar.sz() : 0L;
                    if (jSz == 1) {
                        l = System.currentTimeMillis();
                    }
                    qg qgVar = n;
                    AtomicLong atomicLongHd = qgVar.hd();
                    com.byazt.hls.l.n(atomicLongHd, 1, this.cp);
                    if (TextUtils.equals("show", com.byazt.hls.q.n(nVar))) {
                        qgVar.an().incrementAndGet();
                    } else if (TextUtils.equals("click", com.byazt.hls.q.n(nVar))) {
                        qgVar.f().incrementAndGet();
                    }
                    if (atomicLongHd.get() == 200) {
                        if (Looper.getMainLooper() == Looper.myLooper()) {
                            ((wo) q.n("thread_service")).n().execute(new Runnable() { // from class: com.byazt.kp.s.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    s.this.n(sVar, jSz);
                                }
                            });
                        } else {
                            x.n("==> monitor upload index1:".concat(String.valueOf(jSz)));
                            n(sVar, jSz);
                        }
                    }
                }
            } catch (Exception e) {
                x.n("report", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(com.byazt.vr.s sVar, long j) {
        com.byazt.jeb.s sVar2 = this.w;
        if (sVar == null || sVar2 == null) {
            return;
        }
        qg qgVar = n;
        sVar.n(qgVar.n(j, this.rv));
        qgVar.w();
    }

    public void x() {
        com.byazt.vr.qg qgVar = this.fs;
        if (qgVar == null || qgVar.n() == null) {
            x.s("discard flush config is null");
            return;
        }
        x.s("flushMemoryAndDB");
        final com.byazt.jeb.s sVar = this.w;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ((wo) q.n("thread_service")).qg().execute(new Runnable() { // from class: com.byazt.kp.s.2
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.jeb.s sVar2 = sVar;
                    if (sVar2 != null) {
                        sVar2.n(72, "start_child1");
                    }
                }
            });
        } else if (sVar != null) {
            sVar.n(72, "start_child2");
        }
    }
}
