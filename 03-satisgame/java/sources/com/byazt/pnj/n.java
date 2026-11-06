package com.byazt.pnj;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.byazt.fvm.cp;
import com.byazt.fvm.rv;
import com.byazt.fvm.tj;
import com.byazt.gct.cd;
import com.byazt.gct.pk;
import com.byazt.pj.x;
import com.byazt.rv.l;
import com.byazt.tk.h;
import com.byazt.tk.k;
import com.byazt.vgx.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_PREPARE_CACHE_MS, 19})
public class n {
    public pk n;
    public Context qg;
    public AtomicBoolean s = new AtomicBoolean(false);
    public AtomicBoolean q = new AtomicBoolean(false);
    public AtomicBoolean l = new AtomicBoolean(false);

    public n(pk pkVar, Context context) {
        this.n = pkVar;
        this.qg = context;
    }

    public void n(int i, com.byazt.zq.qg qgVar) {
        if (this.n == null) {
            n();
            s.n(null, false, i, 2);
            return;
        }
        if (this.qg == null) {
            n();
            s.n(this.n, false, i, 3);
            return;
        }
        if (qgVar == null) {
            n();
            s.n(this.n, false, i, 7);
            return;
        }
        if (this.l.get()) {
            s.n(this.n, false, i, 4);
            return;
        }
        this.l.set(true);
        int iD = w.d(this.n);
        if (iD == 5) {
            n(i, qgVar, this.n);
            return;
        }
        if (iD == 7) {
            s(i, qgVar, this.n);
            return;
        }
        if (iD == 8) {
            q(i, qgVar, this.n);
        } else {
            if (iD == 9) {
                qg(i, qgVar, this.n);
                return;
            }
            n();
            s.n(this.n, false, i, 5);
            this.l.set(false);
        }
    }

    public void n(final int i, com.byazt.zq.qg qgVar, final pk pkVar) {
        try {
            final q qVarQg = qg(pkVar, i);
            qg();
            com.byazt.be.n.q().n(qgVar, qVarQg, new com.byazt.ap.s(null) { // from class: com.byazt.pnj.n.1
                @Override // com.byazt.ap.s
                public void n(List<tj> list) {
                    list.size();
                    pk pkVarQg = qVarQg.qg();
                    if (pkVarQg != null) {
                        n.this.n(pkVarQg, i);
                    } else {
                        n.this.n();
                        s.qg(pkVar, false, i, 5);
                    }
                    n.this.l.set(false);
                }

                @Override // com.byazt.ap.s
                public void n(int i2, String str) {
                    k.qg("SecondPageImpl", "requestNewFeedAd onError code:" + i2 + " message:" + str);
                    n.this.l.set(false);
                    n.this.n();
                    s.qg(pkVar, false, i, 2);
                }
            });
        } catch (Throwable th) {
            this.l.set(false);
            k.n("SecondPageImpl", "requestNewFeedAd error", th.toString());
            n();
            s.n(pkVar, false, i, 6);
        }
    }

    public void qg(final int i, com.byazt.zq.qg qgVar, final pk pkVar) {
        try {
            final q qVarQg = qg(pkVar, i);
            qg();
            com.byazt.vgo.n.q().n(qgVar, qVarQg, new com.byazt.ap.qg(null) { // from class: com.byazt.pnj.n.2
                @Override // com.byazt.ap.qg
                public void n(List<rv> list) {
                    list.size();
                    pk pkVarQg = qVarQg.qg();
                    if (pkVarQg != null) {
                        n.this.n(pkVarQg, i);
                    } else {
                        n.this.n();
                        s.qg(pkVar, false, i, 5);
                    }
                    n.this.l.set(false);
                }

                @Override // com.byazt.ap.qg
                public void n(int i2, String str) {
                    k.qg("SecondPageImpl", "requestNewDrawAd onError code:" + i2 + " message:" + str);
                    n.this.l.set(false);
                    n.this.n();
                    s.qg(pkVar, false, i, 2);
                }
            });
        } catch (Throwable th) {
            this.l.set(false);
            k.n("SecondPageImpl", "requestNewDrawAd error", th.toString());
            n();
            s.n(pkVar, false, i, 6);
        }
    }

    public void s(final int i, com.byazt.zq.qg qgVar, final pk pkVar) {
        try {
            x.n().n(qgVar, qg(pkVar, i), new com.byazt.pj.q(new com.byazt.ap.x(null) { // from class: com.byazt.pnj.n.3
                @Override // com.byazt.ap.x
                public void n() {
                }

                @Override // com.byazt.ap.x
                public void qg(com.byazt.fvm.k kVar) {
                }

                @Override // com.byazt.ap.x
                public void n(final com.byazt.fvm.k kVar) {
                    com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.pnj.n.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (kVar instanceof l) {
                                if (n.this.qg instanceof Activity) {
                                    l lVar = (l) kVar;
                                    lVar.n(true);
                                    lVar.n((Activity) n.this.qg);
                                    s.qg(pkVar, true, i, 0);
                                } else {
                                    n.this.n();
                                    s.qg(pkVar, false, i, 3);
                                }
                            } else {
                                n.this.n();
                                s.qg(pkVar, false, i, 1);
                            }
                            n.this.l.set(false);
                        }
                    });
                }

                @Override // com.byazt.ap.x
                public void n(int i2, String str) {
                    k.qg("SecondPageImpl", "requestNewRewardAd onError code:" + i2 + " message:" + str);
                    n.this.l.set(false);
                    n.this.n();
                    s.qg(pkVar, false, i, 2);
                }
            }));
        } catch (Throwable th) {
            this.l.set(false);
            k.n("SecondPageImpl", "requestNewAd error", th.toString());
            n();
            s.n(pkVar, false, i, 6);
        }
    }

    public void q(final int i, com.byazt.zq.qg qgVar, final pk pkVar) {
        try {
            com.byazt.pj.qg.n().n(qgVar, qg(pkVar, i), new com.byazt.pj.q(new com.byazt.ap.q(null) { // from class: com.byazt.pnj.n.4
                @Override // com.byazt.ap.q
                public void n() {
                }

                @Override // com.byazt.ap.q
                public void qg(cp cpVar) {
                }

                @Override // com.byazt.ap.q
                public void n(final cp cpVar) {
                    com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.pnj.n.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (cpVar instanceof com.byazt.rv.q) {
                                if (n.this.qg instanceof Activity) {
                                    com.byazt.rv.q qVar = (com.byazt.rv.q) cpVar;
                                    qVar.n(true);
                                    qVar.n((Activity) n.this.qg);
                                    s.qg(pkVar, true, i, 0);
                                } else {
                                    n.this.n();
                                    s.qg(pkVar, false, i, 3);
                                }
                            } else {
                                n.this.n();
                                s.qg(pkVar, false, i, 1);
                            }
                            n.this.l.set(false);
                        }
                    });
                }

                @Override // com.byazt.ap.q
                public void n(int i2, String str) {
                    k.qg("SecondPageImpl", "requestNewFullScreenAd onError code:" + i2 + " message:" + str);
                    n.this.l.set(false);
                    n.this.n();
                    s.qg(pkVar, false, i, 2);
                }
            }));
        } catch (Throwable th) {
            k.n("SecondPageImpl", "requestNewAd error", th.toString());
            this.l.set(false);
            n();
            s.n(pkVar, false, i, 6);
        }
    }

    public void n() {
        com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.pnj.n.5
            @Override // java.lang.Runnable
            public void run() {
                h.n(n.this.qg, "加载失败了，将跳转至推荐页面", 1);
            }
        });
        com.byazt.ru.n.n((View) null, this.n, this.qg);
    }

    public void qg() {
        com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.pnj.n.6
            @Override // java.lang.Runnable
            public void run() {
                h.n(n.this.qg, "正在努力加载中", 0);
            }
        });
    }

    public void n(pk pkVar, int i) {
        String strQg = w.qg(w.d(pkVar));
        String strFs = cd.fs(pkVar);
        if (TextUtils.isEmpty(strFs)) {
            strFs = pkVar.fs();
        }
        com.byazt.xwj.n nVar = new com.byazt.xwj.n(pkVar, this.qg, strQg, w.q(strQg), new HashMap(), null, pkVar.pv());
        nVar.n(strFs);
        if (nVar.n(new HashMap())) {
            com.byazt.hm.n.n(pkVar, strQg, new HashMap(), (Double) null);
            s.qg(pkVar, true, i, 0);
        } else {
            n();
            s.qg(pkVar, false, i, 4);
        }
    }

    public q qg(pk pkVar, int i) {
        String strHd = w.hd(pkVar);
        q qVar = new q();
        qVar.n(i);
        qVar.n(strHd);
        qVar.n(pkVar);
        return qVar;
    }

    public void n(boolean z) {
        this.q.set(z);
    }

    public boolean s() {
        return this.q.get();
    }

    public void qg(boolean z) {
        this.s.set(z);
    }

    public boolean q() {
        return this.s.get();
    }
}
