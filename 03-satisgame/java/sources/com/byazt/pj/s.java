package com.byazt.pj;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.anythink.core.common.d.f;
import com.byazt.gct.pk;
import com.byazt.gct.y;
import com.byazt.nf.rv;
import com.byazt.tk.k;
import com.byazt.wea.fs;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 441, 8})
public abstract class s {
    public Context n;
    public final com.byazt.gzx.q qg;

    public abstract int qg();

    public s(Context context) {
        this.n = context == null ? rv.getContext() : context.getApplicationContext();
        this.qg = new com.byazt.gzx.q(qg());
    }

    public void n(com.byazt.zq.qg qgVar, com.byazt.pnj.q qVar, q qVar2) {
        n(qgVar, qVar2, null, qVar, null, null);
        com.byazt.pnj.s.n(qVar.n(), true, qVar.s(), 0);
    }

    public void n(final pk pkVar, final String str) {
        com.byazt.ag.qg.n(new com.byazt.qit.x("rewardFull preloadOnDestroy") { // from class: com.byazt.pj.s.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.zq.qg qgVarN = com.byazt.tf.n.n().n(pkVar, str);
                if (qgVarN == null || TextUtils.isEmpty(qgVarN.q())) {
                    return;
                }
                pk pkVarN = com.byazt.ci.l.n(s.this.qg()).n(qgVarN.q(), false, 0L);
                if (rv.qg().qg(qgVarN.q()) && pkVarN != null) {
                    if (pkVarN.ju() + pkVarN.kc() < System.currentTimeMillis()) {
                        com.byazt.ci.l.n(s.this.qg()).n(qgVarN.q());
                    }
                }
                if (pkVarN == null) {
                    s.this.n(qgVarN);
                }
            }
        });
    }

    public void n(com.byazt.zq.qg qgVar) {
        if (this.qg != null) {
            this.qg.n(qgVar, n(true, System.currentTimeMillis(), qgVar, (com.byazt.dt.s) null, (com.byazt.pnj.q) null));
        }
    }

    public void n(final com.byazt.zq.qg qgVar, final q qVar) {
        String string;
        if (qgVar != null) {
            qgVar.q();
        }
        final String string2 = UUID.randomUUID().toString();
        if (qgVar == null || !TextUtils.isEmpty(qgVar.py())) {
            string = null;
        } else {
            string = UUID.randomUUID().toString();
            n(string, qgVar, qg());
        }
        n(string);
        if (!com.byazt.ivn.l.n()) {
            n(string, (String) null, false, new com.byazt.di.n(1000, "广告请求开关已关闭,请联系穿山甲管理员"), (pk) null);
            qVar.n(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        com.byazt.uq.qg.n(qgVar, true, string2);
        final String str = string;
        com.byazt.qit.x xVar = new com.byazt.qit.x("loadRewardVideoAd") { // from class: com.byazt.pj.s.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    s.this.n(qgVar, qVar, null, null, str, string2);
                } catch (Throwable th) {
                    String str2 = " msg = " + th.getMessage();
                    s.this.n(str, (String) null, false, new com.byazt.di.n(TTAdConstant.INIT_LOCAL_FAIL_CODE, str2), (pk) null);
                    qVar.n(TTAdConstant.INIT_LOCAL_FAIL_CODE, str2);
                    k.n("RewardFullLoadManager", "reward  component maybe not exist, pls check1", th);
                }
            }
        };
        if (!com.byazt.vyf.l.n) {
            k.qg("RewardFullLoadManager", com.byazt.yn.n.NOT_INIT_TIPS_MSG);
            n(string, (String) null, false, new com.byazt.di.n(10000, com.byazt.yn.n.NOT_INIT_TIPS_MSG), (pk) null);
            qVar.n(10000, com.byazt.yn.n.NOT_INIT_TIPS_MSG);
            return;
        }
        com.byazt.yn.n.n(xVar, qg());
        com.byazt.wz.n.l().n(qg(), qgVar);
    }

    private void n(String str, final com.byazt.zq.qg qgVar, final int i) {
        com.byazt.id.qg qgVar2 = (com.byazt.id.qg) com.byazt.bok.s.n(0);
        qgVar2.qg(str, qgVar.an());
        qgVar2.n(str, new com.byazt.oi.s());
        if (com.byazt.bh.w.n().n(i)) {
            qgVar2.n(str, new com.byazt.bh.s());
        }
        qgVar2.n(str, new com.byazt.bok.qg.n() { // from class: com.byazt.pj.s.3
            @Override // com.byazt.bok.qg.n
            public void n(fs fsVar) {
                com.byazt.zq.qg qgVar3;
                if (!(fsVar instanceof com.byazt.wea.s) || (qgVar3 = qgVar) == null) {
                    return;
                }
                com.byazt.wea.s sVar = (com.byazt.wea.s) fsVar;
                sVar.x = qgVar3;
                sVar.n = i;
                sVar.qg = 0;
                sVar.s = qgVar.q();
            }
        });
    }

    public void n(final com.byazt.zq.qg qgVar, final q qVar, com.byazt.dt.s sVar, final com.byazt.pnj.q qVar2, final String str, final String str2) {
        final y yVarN = n(false, qVar != null ? qVar.n() : System.currentTimeMillis(), qgVar, sVar, qVar2);
        yVarN.um = str2;
        if (this.qg != null) {
            qg(str);
            final AtomicReference atomicReference = new AtomicReference(str);
            this.qg.n(qgVar, yVarN, new com.byazt.gzx.l() { // from class: com.byazt.pj.s.4
                @Override // com.byazt.gzx.l
                public void n(Object obj, boolean z, pk pkVar) {
                    com.byazt.zq.qg qgVar2;
                    String strQg = (String) atomicReference.get();
                    if (TextUtils.isEmpty(strQg) && (qgVar2 = qgVar) != null && !TextUtils.isEmpty(qgVar2.py()) && pkVar != null) {
                        strQg = s.this.n().qg(pkVar.ou());
                        atomicReference.set(strQg);
                    }
                    String str3 = strQg;
                    s.this.n(str3, true);
                    yVarN.n(obj, z ? 3 : 2);
                    s sVar2 = s.this;
                    sVar2.n(str3, sVar2.n(obj), true, (com.byazt.di.n) null, pkVar);
                    com.byazt.pnj.q qVar3 = qVar2;
                    if (qVar3 != null && qVar3.l()) {
                        qVar2.qg(pkVar);
                    }
                    q qVar4 = qVar;
                    if (qVar4 != null) {
                        qVar4.n(obj);
                    }
                    if (pkVar == null || TextUtils.isEmpty(str2)) {
                        return;
                    }
                    pkVar.n(str2);
                    com.byazt.uq.qg.n(pkVar, com.byazt.vgx.w.qg(s.this.qg()));
                }

                @Override // com.byazt.gzx.l
                public void n(Object obj) {
                    String str3 = (String) atomicReference.get();
                    if (com.byazt.bh.w.n().n(s.this.qg()) && !TextUtils.isEmpty(str3)) {
                        com.byazt.bh.w.n().q(str3, System.currentTimeMillis());
                    }
                    q qVar3 = qVar;
                    if (qVar3 != null) {
                        qVar3.qg(obj);
                    }
                }

                @Override // com.byazt.gzx.l
                public void n(int i, String str3) {
                    s.this.n(str, false);
                    yVarN.n((Object) null, 1);
                    s.this.n(str, (String) null, false, new com.byazt.di.n(i, str3), (pk) null);
                    q qVar3 = qVar;
                    if (qVar3 != null) {
                        qVar3.n(i, str3);
                    }
                }
            });
        }
    }

    private y n(boolean z, long j, com.byazt.zq.qg qgVar, com.byazt.dt.s sVar, com.byazt.pnj.q qVar) {
        boolean z2;
        y yVar = new y();
        yVar.rv = j;
        if (z) {
            yVar.n = 2;
        }
        yVar.x = 2;
        boolean z3 = false;
        if (sVar == null || !sVar.s()) {
            z2 = false;
        } else {
            yVar.s = sVar.n();
            yVar.q = sVar.qg();
            yVar.a = true;
            z2 = true;
        }
        if (qVar != null && qVar.l()) {
            yVar.hd = qVar.s();
            yVar.cd = qVar.q();
            yVar.a = true;
            z3 = true;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_playAgain", z2);
        bundle.putBoolean("is_second_page_ad", z3);
        bundle.putBoolean("is_preload", z);
        bundle.putLong(f.a, yVar.rv);
        yVar.cy = bundle;
        if (qgVar != null) {
            yVar.n(qg(), qgVar.q(), 1, qgVar);
        } else {
            yVar.n(qg(), "", 1, qgVar);
        }
        return yVar;
    }

    public void n(String str) {
        n().n(str, com.byazt.hes.qg.STARTED);
    }

    public void qg(String str) {
        n().n(str, com.byazt.hes.qg.REQED);
    }

    public void n(String str, final boolean z) {
        n().n(str, new com.byazt.bok.qg.n() { // from class: com.byazt.pj.s.5
            @Override // com.byazt.bok.qg.n
            public void n(fs fsVar) {
                if (fsVar instanceof com.byazt.wea.s) {
                    ((com.byazt.wea.s) fsVar).fs = z;
                }
            }
        });
        n().n(str, com.byazt.hes.qg.RECEIVED);
    }

    public void n(final String str, final String str2, final boolean z, final com.byazt.di.n nVar, final pk pkVar) {
        n().n(str, new com.byazt.bok.qg.n() { // from class: com.byazt.pj.s.6
            @Override // com.byazt.bok.qg.n
            public void n(fs fsVar) {
                if (fsVar instanceof com.byazt.wea.s) {
                    com.byazt.wea.s sVar = (com.byazt.wea.s) fsVar;
                    sVar.rv = z;
                    sVar.q = pkVar;
                    sVar.tj = nVar;
                    if (TextUtils.isEmpty(str2)) {
                        return;
                    }
                    sVar.cp.add(str2);
                }
            }
        });
        if (!TextUtils.isEmpty(str2)) {
            ((com.byazt.id.s) com.byazt.bok.s.n(1)).n(str2, new com.byazt.bok.qg.n() { // from class: com.byazt.pj.s.7
                @Override // com.byazt.bok.qg.n
                public void n(fs fsVar) {
                    if (fsVar instanceof com.byazt.wea.q) {
                        ((com.byazt.wea.q) fsVar).x = str;
                    }
                }
            });
        }
        n().n(str, com.byazt.hes.qg.LOADED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.id.qg n() {
        return (com.byazt.id.qg) com.byazt.bok.s.n(0);
    }

    public String n(Object obj) {
        if (obj instanceof com.byazt.rv.l) {
            return ((com.byazt.rv.l) obj).fs();
        }
        if (obj instanceof com.byazt.rv.q) {
            return ((com.byazt.rv.q) obj).fs();
        }
        return null;
    }

    public void n(pk pkVar) {
        com.byazt.gzx.q qVar = this.qg;
        if (qVar != null) {
            qVar.qg().n(pkVar);
        }
    }

    public static void n(int i, pk pkVar) {
        if (i == 7) {
            x.n().n(pkVar);
        } else {
            if (i != 8) {
                return;
            }
            qg.n().n(pkVar);
        }
    }

    public pk n(String str, int i) {
        com.byazt.gzx.q qVar = this.qg;
        if (qVar != null) {
            return qVar.qg().n(str, i);
        }
        return null;
    }
}
