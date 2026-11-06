package com.byazt.it;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.ca.ho;
import com.byazt.hg.of;
import com.byazt.ihe.m;
import com.byazt.ihe.vk;
import com.byazt.n.uc;
import com.byazt.sd.a;
import com.byazt.wt.ls;
import com.byazt.xlm.fw;
import com.byazt.yo.k;
import com.byazt.yo.w;
import com.byazt.zp.zo;
import com.qq.e.comm.constants.ErrorCode;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1799, 20})
public class hn {
    public static volatile vk hw;
    public static volatile vk pr;

    private static vk hw(uc ucVar) {
        if (ucVar.rc() == 1) {
            if (hw == null) {
                synchronized (hn.class) {
                    if (hw == null) {
                        hw = hw.pr().hw();
                    }
                }
            }
            return hw;
        }
        if (pr == null) {
            synchronized (hn.class) {
                if (pr == null) {
                    pr = new com.byazt.u.pr();
                }
            }
        }
        return pr;
    }

    private static void hw(uc ucVar, vk.pr prVar, of ofVar) {
        if (prVar != null) {
            prVar.hw(ucVar, -100);
        }
        if (ofVar != null) {
            if (hw(ls.k(ofVar)) || pr(ls.k(ofVar))) {
                pr(ucVar, ofVar, 0L);
            }
        }
    }

    public static void pr(final uc ucVar, final vk.pr prVar) {
        if (ucVar == null) {
            hw(null, prVar, null);
            return;
        }
        ucVar.fw();
        ucVar.yb();
        final of ofVarPr = pr(ucVar);
        if (ucVar.fw() <= 0 && !ucVar.yb()) {
            hw(ucVar, prVar, ofVarPr);
        } else if (zo.pr()) {
            zo.pr(new fw("csj_vPreload") { // from class: com.byazt.it.hn.1
                @Override // java.lang.Runnable
                public void run() {
                    hn.hn(ucVar, prVar, ofVarPr);
                }
            });
        } else {
            hn(ucVar, prVar, ofVarPr);
        }
    }

    private static boolean pr(int i) {
        return i == 3 || i == 4;
    }

    private static boolean hw(int i) {
        return i == 8 || i == 7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hn(uc ucVar, vk.pr prVar, of ofVar) {
        try {
            x(ucVar, prVar, ofVar);
        } catch (Exception e) {
            ho.pr("pit predict error:" + e.getMessage());
        }
    }

    public static of pr(uc ucVar) {
        if (ucVar == null) {
            return null;
        }
        Object objC = ucVar.c("material_meta");
        if (!(objC instanceof of)) {
            return null;
        }
        return (of) objC;
    }

    private static void x(final uc ucVar, final vk.pr prVar, final of ofVar) {
        ucVar.uc(ErrorCode.UNKNOWN_ERROR);
        ucVar.fw(ErrorCode.UNKNOWN_ERROR);
        ucVar.zo(ErrorCode.UNKNOWN_ERROR);
        if (ofVar != null) {
            if (com.byazt.lpk.pr.pr(ofVar)) {
                return;
            } else {
                hw(ucVar, ofVar);
            }
        }
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        vk.pr prVar2 = new vk.pr() { // from class: com.byazt.it.hn.2
            @Override // com.byazt.ihe.vk.pr
            public void hw(m mVar, int i) {
                vk.pr prVar3 = prVar;
                if (prVar3 != null) {
                    prVar3.hw(mVar, i);
                }
                if (ofVar != null) {
                    hn.pr(ucVar, ofVar, SystemClock.elapsedRealtime() - jElapsedRealtime);
                }
                Object[] objArr = {"pit onVideoPreloadSuccess: ", ucVar.fo()};
            }

            @Override // com.byazt.ihe.vk.pr
            public void pr(m mVar, int i, String str) {
                vk.pr prVar3 = prVar;
                if (prVar3 != null) {
                    prVar3.pr(mVar, i, str);
                }
                if (ofVar != null) {
                    hn.hw(ucVar, ofVar, SystemClock.elapsedRealtime() - jElapsedRealtime, i, str);
                }
                Object[] objArr = {"pit onVideoPreloadFail: ", ucVar.fo()};
            }

            @Override // com.byazt.ihe.vk.pr
            public void pr(m mVar, int i) {
                vk.pr prVar3 = prVar;
                if (prVar3 != null) {
                    prVar3.hw(mVar, i);
                }
                of ofVar2 = ofVar;
                if (ofVar2 != null) {
                    hn.hn(ucVar, ofVar2);
                }
                Object[] objArr = {"pit cancel: ", ucVar.fo()};
            }
        };
        try {
            if (ucVar.rc() == 0 && Build.VERSION.SDK_INT < 23) {
                com.byazt.l.pr.pr().pr(ucVar);
            } else {
                hw(ucVar).pr(a.getContext(), ucVar, prVar2);
            }
        } catch (Exception e) {
            if (prVar != null) {
                Object[] objArr = {"pit exception onVideoPreloadFail: ", ucVar.fo()};
                prVar.pr(ucVar, -1, e.getMessage());
            }
            if (ofVar != null) {
                hw(ucVar, ofVar, SystemClock.elapsedRealtime() - jElapsedRealtime, -1, e.getMessage());
            }
        }
    }

    private static boolean hn(uc ucVar) {
        if (Build.VERSION.SDK_INT < 23 && ucVar.rc() == 0) {
            return false;
        }
        return true;
    }

    private static void hw(uc ucVar, of ofVar) {
        if (!hn(ucVar)) {
            return;
        }
        long jNt = ucVar.yb() ? ucVar.nt() : ucVar.fw();
        String strHw = ls.hw(ofVar);
        JSONObject jSONObjectPr = com.byazt.ne.hn.pr(ucVar, null, -1, ucVar.rc(), ofVar, -1L);
        k kVar = new k(ucVar.ny(), jNt);
        kVar.pr(ucVar);
        com.byazt.ne.hn.pr((com.byazt.yo.hw<k>) new com.byazt.yo.hw(ofVar, strHw, jSONObjectPr, kVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hw(uc ucVar, of ofVar, long j, int i, String str) {
        if (!hn(ucVar)) {
            return;
        }
        String strHw = ls.hw(ofVar);
        JSONObject jSONObjectPr = com.byazt.ne.hn.pr(ucVar, null, -1, ucVar.rc(), ofVar, -1L);
        w wVar = new w();
        wVar.pr(ucVar.ny());
        wVar.pr(ucVar.fw());
        wVar.hw(j);
        wVar.pr(i);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        wVar.hw(str);
        wVar.hn("");
        wVar.pr(ucVar);
        com.byazt.ne.hn.hn((com.byazt.yo.hw<w>) new com.byazt.yo.hw(ofVar, strHw, jSONObjectPr, wVar));
    }

    public static void pr(uc ucVar, of ofVar, long j) {
        if (!hn(ucVar)) {
            return;
        }
        String strHw = ls.hw(ofVar);
        JSONObject jSONObjectPr = com.byazt.ne.hn.pr(ucVar, null, -1, ucVar.rc(), ofVar, -1L);
        com.byazt.yo.m mVar = new com.byazt.yo.m();
        mVar.pr(ucVar.ny());
        mVar.pr(ucVar.fw());
        mVar.hw(j);
        mVar.pr(ucVar);
        if (ucVar.ve() == 1) {
            mVar.hn(1L);
        } else {
            mVar.hn(0L);
        }
        com.byazt.ne.hn.hw((com.byazt.yo.hw<com.byazt.yo.m>) new com.byazt.yo.hw(ofVar, strHw, jSONObjectPr, mVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hn(uc ucVar, of ofVar) {
        if (!hn(ucVar)) {
            return;
        }
        String strHw = ls.hw(ofVar);
        JSONObject jSONObjectPr = com.byazt.ne.hn.pr(ucVar, null, -1, ucVar.rc(), ofVar, -1L);
        com.byazt.yo.vk vkVar = new com.byazt.yo.vk(ucVar.ny(), ucVar.fw());
        vkVar.pr(ucVar);
        com.byazt.ne.hn.x((com.byazt.yo.hw<com.byazt.yo.vk>) new com.byazt.yo.hw(ofVar, strHw, jSONObjectPr, vkVar));
    }
}
