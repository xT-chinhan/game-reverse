package com.byazt.kw;

import android.content.Context;
import android.graphics.Bitmap;
import com.byazt.ee.CSJSpriteView;
import com.byazt.pp.w;
import com.byazt.sj.l;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2128, 19})
public abstract class n {
    public double cd;
    public double cy;
    public l.n d;
    public com.byazt.sj.n fs;
    public double hd;
    public double k;
    public final String l;
    public final Context n;
    public final JSONObject q;
    public final CSJSpriteView qg;
    public com.byazt.eu.n rv;
    public final com.byazt.dg.qg s;
    public com.byazt.tl.n w;
    public com.byazt.xi.n x;
    public boolean tj = false;
    public int cp = Integer.MIN_VALUE;
    public final AtomicBoolean oa = new AtomicBoolean(false);
    public boolean sz = false;

    public abstract com.byazt.eu.n n(com.byazt.dg.qg qgVar, double d, double d2);

    public void n(com.byazt.eu.n nVar) {
    }

    public void n(String str) {
    }

    public n(Context context, CSJSpriteView cSJSpriteView, com.byazt.dg.qg qgVar, JSONObject jSONObject, String str) {
        this.n = context;
        this.qg = cSJSpriteView;
        this.s = qgVar;
        this.q = jSONObject;
        this.l = str;
    }

    public com.byazt.tl.n n() {
        return this.w;
    }

    public com.byazt.sj.n qg() {
        return this.fs;
    }

    public void s() {
        new StringBuilder("loadGame gameType=").append(this.s.n).append(" templates=").append(this.s.w.keySet());
        this.s.x.size();
        if (this.s.w.get("guide_tip") != null) {
            String str = this.s.w.get("guide_tip").qg;
        }
        this.w = new com.byazt.tl.n(this.n);
        com.byazt.xi.n nVar = new com.byazt.xi.n();
        this.x = nVar;
        nVar.n();
        com.byazt.sj.n nVar2 = new com.byazt.sj.n(this.l);
        this.fs = nVar2;
        nVar2.n(new com.byazt.sj.n.InterfaceC0334n() { // from class: com.byazt.kw.n.1
            @Override // com.byazt.sj.n.InterfaceC0334n
            public void n(int i) {
                if (n.this.rv == null) {
                    n.this.tj = true;
                    n.this.cp = i;
                    return;
                }
                if (n.this.rv.s() == com.byazt.eu.n.x.PAUSED) {
                    n.this.rv.fs();
                } else if (n.this.rv.s() != com.byazt.eu.n.x.RUNNING) {
                    if (n.this.rv.s() == com.byazt.eu.n.x.FINISHED) {
                        n.this.rv.s(i);
                    }
                    n.this.rv.n(i);
                }
                n.this.qg.n();
                if (n.this.x != null) {
                    n.this.x.s();
                }
            }

            @Override // com.byazt.sj.n.InterfaceC0334n
            public void qg(int i) {
                if (n.this.rv == null) {
                    n.this.tj = false;
                    return;
                }
                n.this.rv.x();
                n.this.qg.qg();
                if (n.this.x != null) {
                    n.this.x.qg();
                }
            }

            @Override // com.byazt.sj.n.InterfaceC0334n
            public void s(int i) {
                if (n.this.rv == null) {
                    n.this.tj = true;
                    n.this.cp = i;
                } else {
                    n.this.rv.s(i);
                    n.this.rv.n(i);
                    n.this.qg.n();
                }
            }

            @Override // com.byazt.sj.n.InterfaceC0334n
            public void q(int i) {
                if (n.this.rv != null) {
                    n.this.rv.oa();
                }
            }

            @Override // com.byazt.sj.n.InterfaceC0334n
            public void l(int i) {
                l.qg();
            }

            @Override // com.byazt.sj.n.InterfaceC0334n
            public void w(int i) {
                if (n.this.rv == null) {
                    n.this.tj = true;
                    n.this.cp = i;
                } else {
                    n.this.rv.q(i);
                    n.this.qg.n();
                }
            }

            @Override // com.byazt.sj.n.InterfaceC0334n
            public void n(String str2, int i) {
                if (n.this.rv != null) {
                    n.this.rv.n(str2);
                }
            }
        });
        this.qg.setSceneFactory(new CSJSpriteView.qg() { // from class: com.byazt.kw.n.2
            @Override // com.byazt.ee.CSJSpriteView.qg
            public void n(int i, int i2) {
                float f = n.this.n.getResources().getDisplayMetrics().density;
                n nVar3 = n.this;
                nVar3.rv = nVar3.n(nVar3.s, i / f, i2 / f);
                n.this.rv.n(new com.byazt.eu.n.w() { // from class: com.byazt.kw.n.2.1
                    @Override // com.byazt.eu.n.w
                    public Bitmap n(String str2) {
                        if (n.this.w != null) {
                            return n.this.w.n(str2);
                        }
                        return null;
                    }
                });
                n.this.rv.n(new com.byazt.eu.n.q() { // from class: com.byazt.kw.n.2.2
                    @Override // com.byazt.eu.n.q
                    public void n(double d, double d2, double d3, double d4) {
                        n.this.sz = true;
                        n.this.k = d;
                        n.this.cy = d2;
                        n.this.hd = d3;
                        n.this.cd = d4;
                        n.this.l();
                    }

                    @Override // com.byazt.eu.n.q
                    public void n() {
                        n.this.sz = false;
                        n.this.qg.s();
                    }
                });
                n.this.rv.n(new com.byazt.eu.n.InterfaceC0171n() { // from class: com.byazt.kw.n.2.3
                    @Override // com.byazt.eu.n.InterfaceC0171n
                    public void n(double d) {
                        n.this.fs.n(d);
                    }

                    @Override // com.byazt.eu.n.InterfaceC0171n
                    public void n(boolean z) {
                        if (n.this.qg != null) {
                            n.this.qg.qg();
                        }
                        n.this.fs.n(z);
                    }

                    @Override // com.byazt.eu.n.InterfaceC0171n
                    public void n() {
                        l.n();
                    }
                });
                n nVar4 = n.this;
                nVar4.n(nVar4.rv);
                n.this.qg.n(n.this.rv);
                n.this.d = new l.n() { // from class: com.byazt.kw.n.2.4
                    @Override // com.byazt.sj.l.n
                    public int n() {
                        if (n.this.rv != null) {
                            return n.this.rv.l();
                        }
                        return 0;
                    }
                };
                l.n(n.this.l, n.this.d);
                if (n.this.tj) {
                    n.this.tj = false;
                    n.this.rv.n(n.this.cp);
                    n.this.qg.n();
                    if (n.this.x != null) {
                        n.this.x.s();
                        return;
                    }
                    return;
                }
                if (n.this.s.qg()) {
                    n.this.rv.qg(Integer.MIN_VALUE);
                }
            }
        });
        for (String str2 : this.s.w.keySet()) {
            com.byazt.dg.qg.q qVar = this.s.w.get(str2);
            if (qVar != null) {
                if (qVar.s == 1) {
                    this.w.n(str2, qVar.qg, new com.byazt.tl.n.InterfaceC0355n() { // from class: com.byazt.kw.n.3
                        @Override // com.byazt.tl.n.InterfaceC0355n
                        public void n(String str3, w wVar) {
                            n.this.l();
                            n.this.n(str3);
                        }
                    });
                } else {
                    this.w.n(str2, qVar.qg, new com.byazt.tl.n.qg() { // from class: com.byazt.kw.n.4
                        @Override // com.byazt.tl.n.qg
                        public void n(String str3, Bitmap bitmap) {
                            n.this.n(str3);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        com.byazt.tl.n nVar;
        w wVarQg;
        if (!this.sz || (nVar = this.w) == null || (wVarQg = nVar.qg("guide_tip")) == null) {
            return;
        }
        this.qg.n(wVarQg, this.q, this.k, this.cy, this.hd, this.cd);
    }

    public void q() {
        if (this.oa.compareAndSet(false, true)) {
            l.n nVar = this.d;
            if (nVar != null) {
                l.qg(this.l, nVar);
            }
            CSJSpriteView cSJSpriteView = this.qg;
            if (cSJSpriteView != null) {
                cSJSpriteView.qg();
            }
            com.byazt.xi.n nVar2 = this.x;
            if (nVar2 != null) {
                nVar2.q();
            }
            com.byazt.tl.n nVar3 = this.w;
            if (nVar3 != null) {
                nVar3.n();
            }
            com.byazt.sj.n nVar4 = this.fs;
            if (nVar4 != null) {
                nVar4.n();
            }
        }
    }
}
