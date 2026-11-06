package com.byazt.zf;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.anythink.core.d.b.e;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 547, 13})
public class w extends qg {
    public static final String TAG = "PangleFullVideoAdapter";

    public w(com.byazt.nw.qg qgVar) {
        super(qgVar);
    }

    @Override // com.byazt.ua.qg
    public void qg(Context context, com.byazt.dd.qg qgVar, com.byazt.qn.qg qgVar2, Map<String, Object> map) {
        if (qgVar2 == null) {
            n(new com.byazt.mj.n("load ad fail adSlot is null"));
        } else {
            new n().n(context.getApplicationContext(), qgVar2, qgVar, this);
        }
    }

    @com.byazt.cp.n(n = {0, 1, 547, 108})
    class n extends com.byazt.sg.s {
        public String cd;
        public com.byazt.qn.qg cy;
        public com.byazt.fvm.cp d;
        public boolean hd;
        public com.byazt.ua.qg k;
        public boolean oa;
        public boolean sz;
        public com.byazt.ap.q tj = new com.byazt.ap.q(null) { // from class: com.byazt.zf.w.n.1
            @Override // com.byazt.ap.q
            public void n(int i, String str) {
                n.this.oa = false;
                n.this.k.n(new com.byazt.mj.n(i, str));
            }

            @Override // com.byazt.ap.q
            public void n(com.byazt.fvm.cp cpVar) {
                if (cpVar == null) {
                    n.this.k.n(new com.byazt.mj.n(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "请求成功，但无广告可用"));
                    return;
                }
                n.this.d = cpVar;
                n.this.x(true);
                n nVar = n.this;
                nVar.d(nVar.d.n());
                Map<String, Object> mapQg = n.this.d.qg();
                com.byazt.rb.qg.q(MediationConstant.TAG, "PangleFullVideoLoader WaterfallPangleFullVideoLoader extraInfo :".concat(String.valueOf(mapQg)));
                if (n.this.hd && mapQg != null) {
                    double dN = com.byazt.mt.qg.n(mapQg.get(e.a.h));
                    com.byazt.rb.qg.n("TTMediationSDK_ECMP", com.byazt.rb.q.qg(n.this.cd, n.this.um) + "pangle 全屏 返回的 cpm价格：" + dN);
                    n nVar2 = n.this;
                    if (dN <= 0.0d) {
                        dN = 0.0d;
                    }
                    nVar2.n(dN);
                }
                if (mapQg != null) {
                    n.this.q(mapQg);
                    Object obj = mapQg.get("materialMetaIsFromPreload");
                    if (obj instanceof Boolean) {
                        n.this.sz = ((Boolean) obj).booleanValue();
                        com.byazt.rb.qg.n(MediationConstant.TAG, "pangle 全屏 返回的adnPreload：" + n.this.sz);
                    }
                }
                Function function = null;
                n.this.d.n(new com.byazt.mi.s(function) { // from class: com.byazt.zf.w.n.1.1
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
                n.this.d.n(new com.byazt.rzx.n(function) { // from class: com.byazt.zf.w.n.1.2
                    @Override // com.byazt.rzx.n
                    public void n(Bundle bundle) {
                        if (n.this.rv instanceof com.byazt.kt.qg) {
                            n.this.tv().n();
                        }
                    }

                    @Override // com.byazt.rzx.n
                    public void qg(Bundle bundle) {
                        if (n.this.rv instanceof com.byazt.kt.qg) {
                            n.this.tv().g_();
                        }
                    }

                    @Override // com.byazt.rzx.n
                    public void s(Bundle bundle) {
                        if (n.this.rv instanceof com.byazt.kt.qg) {
                            n.this.tv().h_();
                        }
                    }

                    @Override // com.byazt.rzx.n
                    public void n() {
                        if (n.this.rv instanceof com.byazt.kt.qg) {
                            n.this.tv().q();
                        }
                    }

                    @Override // com.byazt.rzx.n
                    public void qg() {
                        if (n.this.rv instanceof com.byazt.kt.qg) {
                            n.this.tv().w();
                        }
                    }
                });
                n.this.oa = true;
                n.this.k.n(n.this);
            }

            @Override // com.byazt.ap.q
            public void n() {
                com.byazt.rb.qg.n("TMe", "pangle full cached");
            }

            @Override // com.byazt.ap.q
            public void qg(com.byazt.fvm.cp cpVar) {
                com.byazt.rb.qg.n("TMe", "pangle full cached 2");
                n.this.oa = true;
                n.this.k.n(n.this, (com.byazt.mj.n) null);
            }
        };
        public String um;

        @Override // com.byazt.sg.s
        public boolean rm() {
            return true;
        }

        public n() {
        }

        public void n(Context context, com.byazt.qn.qg qgVar, com.byazt.dd.qg qgVar2, com.byazt.ua.qg qgVar3) {
            this.k = qgVar3;
            this.cy = qgVar;
            this.hd = qgVar2 != null && qgVar2.n();
            this.cd = qgVar2 != null ? qgVar2.qg() : null;
            this.um = qgVar2 != null ? qgVar2.d() : null;
            com.byazt.yn.n nVarN = w.this.n(context);
            if (nVarN == null) {
                return;
            }
            com.byazt.zq.qg.n nVarN2 = com.byazt.mt.qg.n(this.cy, qgVar2, false);
            nVarN2.n(1080).qg(1920).x(this.cy.um()).q(this.cy.ln());
            nVarN.n(nVarN2.n(), this.tj);
        }

        @Override // com.byazt.sg.s
        public void n(Activity activity, Object obj, String str) {
            com.byazt.rb.qg.q(MediationConstant.TAG, "PangleFullVideoLoader WaterfallPangleFullVideoLoader showAd ritScenes:" + obj + "  ritScenesContent: " + str + "  mTTFullScreenVideoAd:" + this.d + "  activity:" + activity);
            com.byazt.fvm.cp cpVar = this.d;
            if (cpVar != null) {
                if (obj != null) {
                    cpVar.n(activity, obj, str);
                } else {
                    cpVar.n(activity);
                }
            }
        }

        @Override // com.byazt.sg.s
        public Map<String, Object> bb() {
            Map<String, Object> mapQg;
            com.byazt.fvm.cp cpVar = this.d;
            if (cpVar == null || (mapQg = cpVar.qg()) == null) {
                return null;
            }
            HashMap map = new HashMap();
            map.put("coupon", mapQg.get("coupon"));
            map.put("live_room", mapQg.get("live_room"));
            map.put("product", mapQg.get("product"));
            s(map);
            return super.bb();
        }

        @Override // com.byazt.sg.s
        public Integer w() {
            com.byazt.fvm.cp cpVar = this.d;
            if (cpVar != null && cpVar.q() > System.currentTimeMillis()) {
                return 2;
            }
            return 3;
        }

        @Override // com.byazt.sg.s
        public boolean oj() {
            return this.sz;
        }

        @Override // com.byazt.sg.s
        public void cd() {
            com.byazt.fvm.cp cpVar = this.d;
            if (cpVar != null) {
                cpVar.n((com.byazt.rzx.n) null);
                this.d.n((com.byazt.mi.s) null);
                this.d.n((com.byazt.mi.qg) null);
                this.d = null;
            }
        }

        @Override // com.byazt.sg.s
        public boolean l() {
            return this.d == null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public com.byazt.kt.qg tv() {
            return (com.byazt.kt.qg) this.rv;
        }

        @Override // com.byazt.sg.s
        public long dz() {
            com.byazt.fvm.cp cpVar = this.d;
            if (cpVar != null) {
                return com.byazt.mt.qg.n(cpVar.qg());
            }
            return 0L;
        }

        @Override // com.byazt.sg.s
        public long c() {
            com.byazt.fvm.cp cpVar = this.d;
            if (cpVar != null) {
                return com.byazt.mt.qg.qg(cpVar.qg());
            }
            return 0L;
        }

        @Override // com.byazt.sg.s
        public String di() {
            com.byazt.fvm.cp cpVar = this.d;
            return cpVar != null ? com.byazt.mt.qg.s(cpVar.qg()) : "";
        }

        @Override // com.byazt.sg.s
        public void n(com.byazt.mi.qg qgVar) {
            com.byazt.fvm.cp cpVar = this.d;
            if (cpVar != null) {
                cpVar.n(qgVar);
            }
        }
    }
}
