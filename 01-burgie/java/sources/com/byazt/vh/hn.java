package com.byazt.vh;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.byazt.ca.ho;
import com.byazt.hg.i;
import com.byazt.hg.of;
import com.byazt.is.aj;
import com.byazt.sd.a;
import com.byazt.sd.gz;
import com.byazt.sd.lb;
import com.byazt.wt.ls;
import com.byazt.zp.zo;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.umeng.analytics.pro.d;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1093, 20})
public abstract class hn {
    public final com.byazt.pe.x hw;
    public Context pr;

    public abstract int hw();

    public hn(Context context) {
        this.pr = context == null ? a.getContext() : context.getApplicationContext();
        this.hw = new com.byazt.pe.x(hw());
    }

    public void pr(com.byazt.qe.hw hwVar, com.byazt.tt.x xVar, x xVar2) {
        pr(hwVar, xVar2, null, xVar, null, null);
        com.byazt.tt.hn.pr(xVar.pr(), true, xVar.hn(), 0);
    }

    public void pr(final of ofVar, final String str) {
        zo.pr(new com.byazt.xlm.fw("rewardFull preloadOnDestroy") { // from class: com.byazt.vh.hn.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.qe.hw hwVarPr = com.byazt.bv.pr.pr().pr(ofVar, str);
                if (hwVarPr == null || TextUtils.isEmpty(hwVarPr.x())) {
                    return;
                }
                of ofVarPr = com.byazt.py.c.pr(hn.this.hw()).pr(hwVarPr.x(), false, 0L);
                if (a.hw().hw(hwVarPr.x()) && ofVarPr != null) {
                    if (ofVarPr.iy() + ofVarPr.l() < System.currentTimeMillis()) {
                        com.byazt.py.c.pr(hn.this.hw()).pr(hwVarPr.x());
                    }
                }
                if (ofVarPr == null) {
                    hn.this.pr(hwVarPr);
                }
            }
        });
    }

    public void pr(com.byazt.qe.hw hwVar) {
        if (this.hw != null) {
            this.hw.pr(hwVar, pr(true, System.currentTimeMillis(), hwVar, null, null));
        }
    }

    public void pr(final com.byazt.qe.hw hwVar, final x xVar) {
        String str;
        if (hwVar != null) {
            hwVar.x();
        }
        final String string = UUID.randomUUID().toString();
        if (hwVar != null && TextUtils.isEmpty(hwVar.cz())) {
            String string2 = UUID.randomUUID().toString();
            pr(string2, hwVar, hw());
            str = string2;
        } else {
            str = null;
        }
        pr(str);
        if (!aj.pr()) {
            pr(str, null, false, new com.byazt.xn.hn(1000, "广告请求开关已关闭,请联系穿山甲管理员"));
            xVar.pr(1000, "广告请求开关已关闭,请联系穿山甲管理员");
            return;
        }
        com.byazt.ua.hw.pr(hwVar, true, string);
        final String str2 = str;
        com.byazt.xlm.fw fwVar = new com.byazt.xlm.fw("loadRewardVideoAd") { // from class: com.byazt.vh.hn.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    hn.this.pr(hwVar, xVar, null, null, str2, string);
                } catch (Throwable th) {
                    String str3 = " msg = " + th.getMessage();
                    hn.this.pr(str2, null, false, new com.byazt.xn.hn(TTAdConstant.INIT_LOCAL_FAIL_CODE, str3));
                    xVar.pr(TTAdConstant.INIT_LOCAL_FAIL_CODE, str3);
                    ho.pr("RewardFullLoadManager", "reward  component maybe not exist, pls check1", th);
                }
            }
        };
        if (!lb.pr) {
            ho.hw("RewardFullLoadManager", gz.NOT_INIT_TIPS_MSG);
            pr(str, null, false, new com.byazt.xn.hn(10000, gz.NOT_INIT_TIPS_MSG));
            xVar.pr(10000, gz.NOT_INIT_TIPS_MSG);
        } else {
            gz.pr(fwVar, hw());
            com.byazt.ip.pr.c().pr(hw(), hwVar);
        }
    }

    private void pr(String str, final com.byazt.qe.hw hwVar, final int i) {
        com.byazt.dc.hw hwVar2 = (com.byazt.dc.hw) com.byazt.ewt.c.pr(0);
        hwVar2.hw(str, hwVar.gz());
        hwVar2.pr(str, new com.byazt.tb.hn());
        if (com.byazt.cf.uc.pr().pr(i)) {
            hwVar2.pr(str, new com.byazt.cf.hn());
        }
        hwVar2.pr(str, new com.byazt.ewt.x.pr() { // from class: com.byazt.vh.hn.3
            @Override // com.byazt.ewt.x.pr
            public void pr(com.byazt.ewt.hw hwVar3) {
                com.byazt.qe.hw hwVar4;
                if ((hwVar3 instanceof com.byazt.pv.hw) && (hwVar4 = hwVar) != null) {
                    com.byazt.pv.hw hwVar5 = (com.byazt.pv.hw) hwVar3;
                    hwVar5.pr = hwVar4;
                    hwVar5.k = i;
                    hwVar5.m = 0;
                    hwVar5.g = hwVar.x();
                }
            }
        });
    }

    public void pr(final com.byazt.qe.hw hwVar, final x xVar, com.byazt.db.hn hnVar, final com.byazt.tt.x xVar2, final String str, final String str2) {
        final i iVarPr = pr(false, xVar != null ? xVar.pr() : System.currentTimeMillis(), hwVar, hnVar, xVar2);
        iVarPr.qa = str2;
        if (this.hw != null) {
            hw(str);
            final AtomicReference atomicReference = new AtomicReference(str);
            this.hw.pr(hwVar, iVarPr, new com.byazt.pe.c() { // from class: com.byazt.vh.hn.4
                @Override // com.byazt.pe.c
                public void pr(Object obj, boolean z, of ofVar) {
                    com.byazt.qe.hw hwVar2;
                    String strHw = (String) atomicReference.get();
                    if (TextUtils.isEmpty(strHw) && (hwVar2 = hwVar) != null && !TextUtils.isEmpty(hwVar2.cz()) && ofVar != null) {
                        strHw = hn.this.pr().hw(ofVar.ny());
                        atomicReference.set(strHw);
                    }
                    hn.this.pr(strHw, true);
                    iVarPr.pr(obj, z ? 3 : 2);
                    hn hnVar2 = hn.this;
                    hnVar2.pr(strHw, hnVar2.pr(obj), true, null);
                    com.byazt.tt.x xVar3 = xVar2;
                    if (xVar3 != null && xVar3.c()) {
                        xVar2.hw(ofVar);
                    }
                    x xVar4 = xVar;
                    if (xVar4 != null) {
                        xVar4.pr(obj);
                    }
                    if (ofVar != null && !TextUtils.isEmpty(str2)) {
                        ofVar.pr(str2);
                        com.byazt.ua.hw.pr(ofVar, ls.hw(hn.this.hw()));
                    }
                }

                @Override // com.byazt.pe.c
                public void pr(Object obj) {
                    String str3 = (String) atomicReference.get();
                    if (com.byazt.cf.uc.pr().pr(hn.this.hw()) && !TextUtils.isEmpty(str3)) {
                        com.byazt.cf.uc.pr().hw(str3, System.currentTimeMillis());
                    }
                    x xVar3 = xVar;
                    if (xVar3 != null) {
                        xVar3.hw(obj);
                    }
                }

                @Override // com.byazt.pe.c
                public void pr(int i, String str3) {
                    hn.this.pr(str, false);
                    iVarPr.pr((Object) null, 1);
                    hn.this.pr(str, null, false, new com.byazt.xn.hn(i, str3));
                    x xVar3 = xVar;
                    if (xVar3 != null) {
                        xVar3.pr(i, str3);
                    }
                }
            });
        }
    }

    private i pr(boolean z, long j, com.byazt.qe.hw hwVar, com.byazt.db.hn hnVar, com.byazt.tt.x xVar) {
        boolean z2;
        i iVar = new i();
        iVar.aj = j;
        if (z) {
            iVar.pr = 2;
        }
        iVar.fw = 2;
        boolean z3 = false;
        if (hnVar != null && hnVar.hn()) {
            iVar.hn = hnVar.pr();
            iVar.x = hnVar.hw();
            iVar.a = true;
            z2 = true;
        } else {
            z2 = false;
        }
        if (xVar != null && xVar.c()) {
            iVar.yb = xVar.hn();
            iVar.lb = xVar.x();
            iVar.a = true;
            z3 = true;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_playAgain", z2);
        bundle.putBoolean("is_second_page_ad", z3);
        bundle.putBoolean("is_preload", z);
        bundle.putLong(d.p, iVar.aj);
        iVar.nt = bundle;
        if (hwVar != null) {
            iVar.pr(hw(), hwVar.x(), 1, hwVar);
        } else {
            iVar.pr(hw(), "", 1, hwVar);
        }
        return iVar;
    }

    public void pr(String str) {
        pr().pr(str, com.byazt.tq.hw.STARTED);
    }

    public void hw(String str) {
        pr().pr(str, com.byazt.tq.hw.REQED);
    }

    public void pr(String str, final boolean z) {
        pr().pr(str, new com.byazt.ewt.x.pr() { // from class: com.byazt.vh.hn.5
            @Override // com.byazt.ewt.x.pr
            public void pr(com.byazt.ewt.hw hwVar) {
                if (hwVar instanceof com.byazt.pv.hw) {
                    ((com.byazt.pv.hw) hwVar).hw = z;
                }
            }
        });
        pr().pr(str, com.byazt.tq.hw.RECEIVED);
    }

    public void pr(final String str, final String str2, final boolean z, final com.byazt.xn.hn hnVar) {
        pr().pr(str, new com.byazt.ewt.x.pr() { // from class: com.byazt.vh.hn.6
            @Override // com.byazt.ewt.x.pr
            public void pr(com.byazt.ewt.hw hwVar) {
                if (hwVar instanceof com.byazt.pv.hw) {
                    com.byazt.pv.hw hwVar2 = (com.byazt.pv.hw) hwVar;
                    hwVar2.hn = z;
                    hwVar2.x = hnVar;
                    if (!TextUtils.isEmpty(str2)) {
                        hwVar2.c.add(str2);
                    }
                }
            }
        });
        if (!TextUtils.isEmpty(str2)) {
            ((com.byazt.dc.hn) com.byazt.ewt.c.pr(1)).pr(str2, new com.byazt.ewt.x.pr() { // from class: com.byazt.vh.hn.7
                @Override // com.byazt.ewt.x.pr
                public void pr(com.byazt.ewt.hw hwVar) {
                    if (hwVar instanceof com.byazt.pv.hn) {
                        ((com.byazt.pv.hn) hwVar).pr = str;
                    }
                }
            });
        }
        pr().pr(str, com.byazt.tq.hw.LOADED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.dc.hw pr() {
        return (com.byazt.dc.hw) com.byazt.ewt.c.pr(0);
    }

    public String pr(Object obj) {
        if (obj instanceof com.byazt.joa.hn) {
            return ((com.byazt.joa.hn) obj).zo();
        }
        if (obj instanceof com.byazt.joa.hw) {
            return ((com.byazt.joa.hw) obj).zo();
        }
        return null;
    }

    public void pr(of ofVar) {
        com.byazt.pe.x xVar = this.hw;
        if (xVar != null) {
            xVar.hw().pr(ofVar);
        }
    }

    public static void pr(int i, of ofVar) {
        switch (i) {
            case 7:
                fw.pr().pr(ofVar);
                break;
            case 8:
                hw.pr().pr(ofVar);
                break;
        }
    }

    public of pr(String str, int i) {
        com.byazt.pe.x xVar = this.hw;
        if (xVar == null) {
            return null;
        }
        return xVar.hw().pr(str, i);
    }
}
