package com.byazt.jr;

import android.text.TextUtils;
import com.byazt.gct.y;
import com.byazt.se.x;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1256, 18})
public class l {
    public com.byazt.se.w fs;
    public com.byazt.se.l l;
    public volatile boolean n;
    public volatile boolean q;
    public volatile boolean qg;
    public com.byazt.mz.n rv;
    public volatile boolean s;
    public com.byazt.hi.qg tj;
    public qg<com.byazt.se.w, x> w;
    public x x;

    public l(com.byazt.se.l lVar, qg<com.byazt.se.w, x> qgVar, com.byazt.mz.n nVar, com.byazt.hi.qg qgVar2) {
        if (lVar == null || qgVar == null) {
            return;
        }
        this.l = lVar;
        this.w = qgVar;
        this.rv = nVar;
        this.tj = qgVar2;
    }

    public void n(final int i) {
        if (this.l == null || this.w == null) {
            return;
        }
        com.byazt.eo.n.n("Splash_FullLink", "loadAd Type ".concat(String.valueOf(i)));
        if (i == 0) {
            new com.byazt.kr.s().n(this.l, this.w);
            return;
        }
        if (i == 1) {
            new com.byazt.kr.n(this.rv).n(this.l, new qg<com.byazt.se.w, x>() { // from class: com.byazt.jr.l.1
                @Override // com.byazt.jr.qg
                /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
                public void qg(com.byazt.se.w wVar) {
                    l.this.w.qg(wVar);
                    if (!com.byazt.mz.n.n(i) || l.this.rv == null || l.this.l == null) {
                        return;
                    }
                    l.this.rv.qg(l.this.l.q(), l.this.l.l());
                }

                @Override // com.byazt.jr.qg
                public void n(x xVar) {
                    if (xVar != null && l.this.l != null) {
                        l.this.l.n(xVar.q());
                        l.this.l.n(xVar.s());
                    }
                    if (l.this.tj == null || !l.this.tj.qg()) {
                        new com.byazt.kr.s().n(l.this.l, new qg<com.byazt.se.w, x>() { // from class: com.byazt.jr.l.1.1
                            @Override // com.byazt.jr.qg
                            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
                            public void qg(com.byazt.se.w wVar) {
                                if (l.this.q) {
                                    if (l.this.rv == null || l.this.l == null) {
                                        return;
                                    }
                                    l.this.rv.n(wVar, l.this.l.q(), true, 1);
                                    return;
                                }
                                l.this.w.qg(wVar);
                            }

                            @Override // com.byazt.jr.qg
                            public void n(x xVar2) {
                                l.this.w.n(xVar2);
                                if (!com.byazt.mz.n.n(i) || l.this.rv == null || l.this.l == null) {
                                    return;
                                }
                                l.this.rv.qg(l.this.l.q(), l.this.l.l());
                            }
                        });
                    } else {
                        l.this.w.n(xVar);
                    }
                }
            });
            return;
        }
        if (i == 2) {
            new com.byazt.kr.s().n(this.l, new qg<com.byazt.se.w, x>() { // from class: com.byazt.jr.l.2
                @Override // com.byazt.jr.qg
                /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
                public void qg(com.byazt.se.w wVar) {
                    l.this.fs = wVar;
                    if (l.this.x != null && wVar != null) {
                        wVar.n(l.this.x.q());
                        wVar.n(l.this.x.s());
                    }
                    com.byazt.eo.n.n("Splash_FullLink", "实时物料加载成功 isCache " + wVar.l());
                    l.this.w.qg(wVar);
                }

                @Override // com.byazt.jr.qg
                public void n(x xVar) {
                    com.byazt.eo.n.n("Splash_FullLink", "实时物料加载失败 ");
                    l.this.w.n(xVar);
                }
            });
            new com.byazt.kr.n(this.rv).n(this.l, new qg<com.byazt.se.w, x>() { // from class: com.byazt.jr.l.3
                @Override // com.byazt.jr.qg
                /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
                public void qg(com.byazt.se.w wVar) {
                    com.byazt.eo.n.n("Splash_FullLink", "缓存物料加载成功 isCache " + wVar.l());
                    l.this.w.qg(wVar);
                }

                @Override // com.byazt.jr.qg
                public void n(x xVar) {
                    l.this.x = xVar;
                    com.byazt.eo.n.n("Splash_FullLink", "缓存物料加载失败  ");
                    if (l.this.fs != null && xVar != null) {
                        l.this.fs.n(xVar.q());
                        l.this.fs.n(xVar.s());
                    }
                    l.this.w.n(xVar);
                }
            });
        } else if (i == 3) {
            new com.byazt.kr.s().n(this.l, new qg<com.byazt.se.w, x>() { // from class: com.byazt.jr.l.4
                @Override // com.byazt.jr.qg
                /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
                public void qg(com.byazt.se.w wVar) {
                    l.this.fs = wVar;
                    if (l.this.s || l.this.q) {
                        if (l.this.rv == null || l.this.l == null) {
                            return;
                        }
                        l.this.rv.n(wVar, l.this.l.q(), true, 3);
                        return;
                    }
                    if (l.this.x != null && wVar != null) {
                        wVar.n(l.this.x.q());
                        wVar.n(l.this.x.s());
                    }
                    l.this.s = true;
                    l.this.w.qg(wVar);
                }

                @Override // com.byazt.jr.qg
                public void n(x xVar) {
                    l.this.n = true;
                    if (l.this.qg) {
                        l.this.w.n(xVar);
                    }
                    if (!com.byazt.mz.n.n(i) || l.this.rv == null || l.this.l == null) {
                        return;
                    }
                    l.this.rv.qg(l.this.l.q(), l.this.l.l());
                }
            });
            new com.byazt.kr.n(this.rv).n(this.l, new qg<com.byazt.se.w, x>() { // from class: com.byazt.jr.l.5
                @Override // com.byazt.jr.qg
                /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
                public void qg(com.byazt.se.w wVar) {
                    if (l.this.s) {
                        return;
                    }
                    l.this.s = true;
                    l.this.w.qg(wVar);
                }

                @Override // com.byazt.jr.qg
                public void n(x xVar) {
                    l.this.x = xVar;
                    if (l.this.fs != null && xVar != null) {
                        l.this.fs.n(xVar.q());
                        l.this.fs.n(xVar.s());
                    }
                    l.this.qg = true;
                    if (l.this.n) {
                        l.this.w.n(xVar);
                    }
                }
            });
        } else {
            if (i != 4) {
                return;
            }
            new com.byazt.kr.n(this.rv).n(this.l, new qg<com.byazt.se.w, x>() { // from class: com.byazt.jr.l.6
                @Override // com.byazt.jr.qg
                /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
                public void qg(com.byazt.se.w wVar) {
                    l.this.w.qg(wVar);
                }

                @Override // com.byazt.jr.qg
                public void n(x xVar) {
                    l.this.w.n(xVar);
                }
            });
        }
    }

    public void n() {
        this.q = true;
    }

    public static boolean n(com.byazt.zq.qg qgVar, y yVar) {
        return (qgVar == null || yVar == null || TextUtils.isEmpty(qgVar.py()) || yVar.l > 0) ? false : true;
    }
}
