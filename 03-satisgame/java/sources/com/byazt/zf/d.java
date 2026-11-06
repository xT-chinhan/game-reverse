package com.byazt.zf;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.anythink.core.d.b.e;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 547, 113})
public class d extends qg {
    public static final String VERSION_00 = "0.0";
    public int qg;

    public d(com.byazt.nw.qg qgVar) {
        super(qgVar);
        this.qg = 3000;
    }

    @Override // com.byazt.ua.qg
    public void qg(Context context, com.byazt.dd.qg qgVar, com.byazt.qn.qg qgVar2, Map<String, Object> map) {
        if (qgVar2 == null) {
            n(new com.byazt.mj.n("load ad fail adSlot is null"));
        } else {
            new n(map).n(context != null ? context.getApplicationContext() : com.byazt.qt.qg.getContext(), qgVar2, qgVar, this);
        }
    }

    @com.byazt.cp.n(n = {0, 1, 547, 89})
    class n extends com.byazt.sg.s {
        public com.byazt.fvm.qg cp;
        public String cy;
        public Map<String, Object> d;
        public String hd;
        public boolean k;
        public com.byazt.ua.qg oa;
        public com.byazt.qn.qg sz;

        public n(Map<String, Object> map) {
            this.d = map;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.byazt.kt.l tv() {
            return (com.byazt.kt.l) this.rv;
        }

        public void n(Context context, com.byazt.qn.qg qgVar, com.byazt.dd.qg qgVar2, com.byazt.ua.qg qgVar3) {
            this.oa = qgVar3;
            this.sz = qgVar;
            this.k = qgVar2 != null && qgVar2.n();
            this.cy = qgVar2 != null ? qgVar2.qg() : null;
            this.hd = qgVar2 != null ? qgVar2.d() : null;
            com.byazt.yn.n nVarN = d.this.n(context);
            if (nVarN == null) {
                return;
            }
            Map<String, Object> map = this.d;
            if (map == null) {
                d.this.qg = 3000;
            } else {
                d.this.qg = map.get("ad_load_timeout") != null ? ((Integer) this.d.get("ad_load_timeout")).intValue() : 3000;
            }
            com.byazt.zq.qg.n nVarN2 = com.byazt.mt.qg.n(this.sz, qgVar2, false);
            nVarN2.n(this.sz.ou()).qg(this.sz.wm()).x(this.sz.um()).n(this.sz.oa()).qg(this.sz.sz());
            n(nVarN, nVarN2.n());
        }

        private void n(com.byazt.yn.n nVar, com.byazt.zq.qg qgVar) {
            com.byazt.ap.n nVar2 = new com.byazt.ap.n(null) { // from class: com.byazt.zf.d.n.1
                @Override // com.byazt.ap.n
                public void n(com.byazt.fvm.qg qgVar2) {
                    com.byazt.rb.qg.q(MediationConstant.TAG, "new api onSplashLoadSuccess 111");
                    if (qgVar2 == null) {
                        n.this.oa.n(new com.byazt.mj.n(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "渲染成功但广告是空"));
                        return;
                    }
                    n.this.cp = qgVar2;
                    n.this.x(true);
                    n nVar3 = n.this;
                    nVar3.d(nVar3.cp.l());
                    Map<String, Object> mapW = n.this.cp.w();
                    com.byazt.rb.qg.q(MediationConstant.TAG, "PangleSplashLoader WaterfallPangleSplashLoader extraInfo :".concat(String.valueOf(mapW)));
                    if (mapW != null) {
                        n.this.q(mapW);
                    }
                    if (n.this.k && mapW != null) {
                        double dN = com.byazt.mt.qg.n(mapW.get(e.a.h));
                        com.byazt.rb.qg.n("TTMediationSDK_ECMP", com.byazt.rb.q.qg(n.this.cy, n.this.hd) + "pangle Splash 返回的 cpm价格：" + dN);
                        n nVar4 = n.this;
                        if (dN <= 0.0d) {
                            dN = 0.0d;
                        }
                        nVar4.n(dN);
                    }
                    Function function = null;
                    n.this.cp.n(new com.byazt.mi.s(function) { // from class: com.byazt.zf.d.n.1.1
                        @Override // com.byazt.mi.s
                        public void n() {
                            if (n.this.s != null) {
                                n.this.s.n();
                            }
                        }

                        @Override // com.byazt.mi.s
                        public void n(long j, long j2, String str, String str2) {
                            if (n.this.s != null) {
                                n.this.s.n(j, j2, (int) (j != 0 ? j2 / j : 0L), -1, str, str2);
                            }
                        }

                        @Override // com.byazt.mi.s
                        public void qg(long j, long j2, String str, String str2) {
                            if (n.this.s != null) {
                                n.this.s.n(j, j2, str, str2);
                            }
                        }

                        @Override // com.byazt.mi.s
                        public void s(long j, long j2, String str, String str2) {
                            if (n.this.s != null) {
                                n.this.s.qg(j, j2, str, str2);
                            }
                        }

                        @Override // com.byazt.mi.s
                        public void n(long j, String str, String str2) {
                            if (n.this.s != null) {
                                n.this.s.n(j, str, str2);
                            }
                        }

                        @Override // com.byazt.mi.s
                        public void n(String str, String str2) {
                            if (n.this.s != null) {
                                n.this.s.n(str, str2);
                            }
                        }
                    });
                    n.this.cp.n(new com.byazt.cne.n(function) { // from class: com.byazt.zf.d.n.1.2
                        @Override // com.byazt.cne.n
                        public void n(com.byazt.fvm.qg qgVar3) {
                            com.byazt.rb.qg.q(MediationConstant.TAG, "new api onSplashAdShow");
                            if (n.this.rv instanceof com.byazt.kt.l) {
                                n.this.tv().l();
                            }
                        }

                        @Override // com.byazt.cne.n
                        public void qg(com.byazt.fvm.qg qgVar3) {
                            com.byazt.rb.qg.q(MediationConstant.TAG, "new api onSplashAdClick");
                            if (n.this.rv instanceof com.byazt.kt.l) {
                                n.this.tv().q();
                            }
                        }

                        @Override // com.byazt.cne.n
                        public void n(com.byazt.fvm.qg qgVar3, int i) {
                            com.byazt.rb.qg.q(MediationConstant.TAG, "new api onSplashAdClose closeType = ".concat(String.valueOf(i)));
                            if (i == 1 || i == 3) {
                                if (n.this.rv instanceof com.byazt.kt.l) {
                                    n.this.tv().n(i);
                                }
                            } else if (n.this.rv instanceof com.byazt.kt.l) {
                                n.this.tv().qg(i);
                            }
                        }
                    });
                    n.this.cp.n(new com.byazt.cne.qg(function) { // from class: com.byazt.zf.d.n.1.3
                        @Override // com.byazt.cne.qg
                        public void n(com.byazt.fvm.qg qgVar3) {
                            if (qgVar3 != null) {
                                com.byazt.rb.qg.q(MediationConstant.TAG, "new api onSplashCardReadyToShow csjSplashAd.getSplashCardView()" + qgVar3.q());
                            }
                            if (n.this.rv instanceof com.byazt.kt.l) {
                                n.this.tv();
                            }
                            if (n.this.rv instanceof com.byazt.kt.l) {
                                n.this.tv().n();
                            }
                        }

                        @Override // com.byazt.cne.qg
                        public void n() {
                            com.byazt.rb.qg.q(MediationConstant.TAG, "new api onSplashCardClick");
                            try {
                                if (n.this.rv instanceof com.byazt.kt.l) {
                                    n.this.tv().l_();
                                }
                            } catch (Throwable unused) {
                            }
                        }

                        @Override // com.byazt.cne.qg
                        public void qg() {
                            com.byazt.rb.qg.q(MediationConstant.TAG, "new api onSplashCardClose");
                            if (n.this.rv instanceof com.byazt.kt.l) {
                                n.this.tv().k_();
                            }
                        }
                    });
                    n.this.oa.n(n.this);
                }

                @Override // com.byazt.ap.n
                public void n(com.byazt.fvm.n nVar3) {
                    com.byazt.rb.qg.q(MediationConstant.TAG, "new api onSplashLoadFail");
                    if (nVar3 != null) {
                        n.this.oa.n(new com.byazt.mj.n(nVar3.n(), nVar3.qg()));
                    } else {
                        n.this.oa.n(new com.byazt.mj.n(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "csjAdError is null"));
                    }
                }

                @Override // com.byazt.ap.n
                public void qg(com.byazt.fvm.qg qgVar2) {
                    com.byazt.rb.qg.q(MediationConstant.TAG, "new api onSplashRenderSuccess");
                }

                @Override // com.byazt.ap.n
                public void n(com.byazt.fvm.qg qgVar2, com.byazt.fvm.n nVar3) {
                    com.byazt.rb.qg.q(MediationConstant.TAG, "new api onSplashRenderFail");
                    if (nVar3 != null) {
                        n.this.oa.n(new com.byazt.mj.n(nVar3.n(), nVar3.qg()));
                    } else {
                        n.this.oa.n(new com.byazt.mj.n(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "csjAdError is null"));
                    }
                }
            };
            if (nVar != null) {
                nVar.n(qgVar, nVar2, d.this.qg);
            }
        }

        @Override // com.byazt.sg.s
        public void n(ViewGroup viewGroup) {
            com.byazt.fvm.qg qgVar = this.cp;
            if (qgVar == null || viewGroup == null) {
                return;
            }
            qgVar.n(viewGroup);
        }

        @Override // com.byazt.sg.s
        public void n(ViewGroup viewGroup, Activity activity) {
            com.byazt.fvm.qg qgVar = this.cp;
            if (qgVar != null) {
                qgVar.n(viewGroup, activity);
            }
        }

        @Override // com.byazt.sg.s
        public Map<String, Object> bb() {
            Map<String, Object> mapW;
            com.byazt.fvm.qg qgVar = this.cp;
            if (qgVar != null && (mapW = qgVar.w()) != null) {
                HashMap map = new HashMap();
                map.put("coupon", mapW.get("coupon"));
                map.put("live_room", mapW.get("live_room"));
                map.put("product", mapW.get("product"));
                s(map);
            }
            return super.bb();
        }

        @Override // com.byazt.sg.s
        public void cd() {
            com.byazt.fvm.qg qgVar = this.cp;
            if (qgVar != null) {
                qgVar.n((com.byazt.cne.n) null);
                this.cp.n((com.byazt.mi.s) null);
                this.cp.n((com.byazt.cne.qg) null);
                this.cp = null;
            }
        }

        @Override // com.byazt.sg.s
        public boolean l() {
            return this.cp == null;
        }

        @Override // com.byazt.sg.s
        public long dz() {
            com.byazt.fvm.qg qgVar = this.cp;
            if (qgVar != null) {
                return com.byazt.mt.qg.n(qgVar.w());
            }
            return 0L;
        }

        @Override // com.byazt.sg.s
        public long c() {
            com.byazt.fvm.qg qgVar = this.cp;
            if (qgVar != null) {
                return com.byazt.mt.qg.qg(qgVar.w());
            }
            return 0L;
        }

        @Override // com.byazt.sg.s
        public String di() {
            com.byazt.fvm.qg qgVar = this.cp;
            return qgVar != null ? com.byazt.mt.qg.s(qgVar.w()) : "";
        }

        @Override // com.byazt.sg.s
        public void n(com.byazt.mi.qg qgVar) {
            com.byazt.fvm.qg qgVar2 = this.cp;
            if (qgVar2 != null) {
                qgVar2.n(qgVar);
            }
        }

        @Override // com.byazt.sg.s
        public void ed() {
            com.byazt.rb.qg.q(MediationConstant.TAG, "PangleSplashLoader hideSkipButton   WaterfallPangleSplashLoader  mCSJSplashAd:" + this.cp);
            com.byazt.fvm.qg qgVar = this.cp;
            if (qgVar != null) {
                qgVar.x();
            }
        }
    }
}
