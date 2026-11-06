package com.byazt.gks;

import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.ej.tj;
import com.byazt.gct.pk;
import com.byazt.nf.rv;
import com.byazt.qit.x;
import com.byazt.shr.cp;
import com.byazt.shr.d;
import com.byazt.shr.oa;
import com.byazt.shr.sz;
import com.byazt.tk.k;
import com.byazt.vgx.w;
import com.byazt.zsl.l;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.comm.constants.ErrorCode;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DNS_START_TIME, 8})
public class s {
    public static volatile tj n;
    public static volatile tj qg;

    private static boolean n(int i) {
        return i == 3 || i == 4;
    }

    private static boolean qg(int i) {
        return i == 8 || i == 7;
    }

    private static boolean s(l lVar) {
        return true;
    }

    private static tj qg(l lVar) {
        if (lVar.m() == 1) {
            if (qg == null) {
                synchronized (s.class) {
                    if (qg == null) {
                        qg = qg.n().qg();
                    }
                }
            }
            return qg;
        }
        if (n == null) {
            synchronized (s.class) {
                if (n == null) {
                    n = new com.byazt.nkg.n();
                }
            }
        }
        return n;
    }

    private static void qg(l lVar, tj.n nVar, pk pkVar) {
        if (nVar != null) {
            nVar.qg(lVar, -100);
        }
        if (pkVar != null) {
            if (qg(w.d(pkVar)) || n(w.d(pkVar))) {
                n(lVar, pkVar, 0L);
            }
        }
    }

    public static void n(final l lVar, final tj.n nVar) {
        if (lVar == null) {
            qg(null, nVar, null);
            return;
        }
        lVar.x();
        lVar.hd();
        final pk pkVarN = n(lVar);
        if (lVar.x() <= 0 && !lVar.hd()) {
            qg(lVar, nVar, pkVarN);
        } else if (com.byazt.ag.qg.n()) {
            com.byazt.ag.qg.n(new x("csj_vPreload") { // from class: com.byazt.gks.s.1
                @Override // java.lang.Runnable
                public void run() {
                    s.s(lVar, nVar, pkVarN);
                }
            });
        } else {
            s(lVar, nVar, pkVarN);
        }
    }

    public static void n(pk pkVar, l lVar) {
        List<l> listN = com.byazt.aci.n.n(pkVar, lVar);
        if (listN == null) {
            return;
        }
        for (int i = 0; i < listN.size() - 1; i++) {
            n(listN.get(i), (tj.n) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s(l lVar, tj.n nVar, pk pkVar) {
        try {
            q(lVar, nVar, pkVar);
        } catch (Exception e) {
            k.n("pit predict error:" + e.getMessage());
        }
    }

    public static pk n(l lVar) {
        if (lVar == null) {
            return null;
        }
        Object objL = lVar.l("material_meta");
        if (objL instanceof pk) {
            return (pk) objL;
        }
        return null;
    }

    private static void q(final l lVar, final tj.n nVar, final pk pkVar) {
        lVar.w(ErrorCode.UNKNOWN_ERROR);
        lVar.x(ErrorCode.UNKNOWN_ERROR);
        lVar.fs(ErrorCode.UNKNOWN_ERROR);
        if (pkVar != null) {
            if (n.n(pkVar)) {
                return;
            } else {
                qg(lVar, pkVar);
            }
        }
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        tj.n nVar2 = new tj.n() { // from class: com.byazt.gks.s.2
            @Override // com.byazt.ej.tj.n
            public void qg(com.byazt.ej.k kVar, int i) {
                tj.n nVar3 = nVar;
                if (nVar3 != null) {
                    nVar3.qg(kVar, i);
                }
                if (pkVar != null) {
                    s.n(lVar, pkVar, SystemClock.elapsedRealtime() - jElapsedRealtime);
                }
                Object[] objArr = new Object[2];
                lVar.wm();
            }

            @Override // com.byazt.ej.tj.n
            public void n(com.byazt.ej.k kVar, int i, String str) {
                tj.n nVar3 = nVar;
                if (nVar3 != null) {
                    nVar3.n(kVar, i, str);
                }
                if (pkVar != null) {
                    s.qg(lVar, pkVar, SystemClock.elapsedRealtime() - jElapsedRealtime, i, str);
                }
                Object[] objArr = new Object[2];
                lVar.wm();
            }

            @Override // com.byazt.ej.tj.n
            public void n(com.byazt.ej.k kVar, int i) {
                tj.n nVar3 = nVar;
                if (nVar3 != null) {
                    nVar3.qg(kVar, i);
                }
                pk pkVar2 = pkVar;
                if (pkVar2 != null) {
                    s.s(lVar, pkVar2);
                }
                Object[] objArr = new Object[2];
                lVar.wm();
            }
        };
        try {
            lVar.m();
            qg(lVar).n(rv.getContext(), lVar, nVar2);
        } catch (Exception e) {
            if (nVar != null) {
                Object[] objArr = new Object[2];
                lVar.wm();
                nVar.n(lVar, -1, e.getMessage());
            }
            if (pkVar != null) {
                qg(lVar, pkVar, SystemClock.elapsedRealtime() - jElapsedRealtime, -1, e.getMessage());
            }
        }
    }

    private static void qg(l lVar, pk pkVar) {
        if (s(lVar)) {
            long jCy = lVar.hd() ? lVar.cy() : lVar.x();
            String strQg = w.qg(pkVar);
            JSONObject jSONObjectN = com.byazt.gw.s.n(lVar, null, -1, lVar.m(), pkVar, -1L);
            oa oaVar = new oa(lVar.ou(), jCy);
            oaVar.n(lVar);
            com.byazt.gw.s.n((com.byazt.shr.qg<oa>) new com.byazt.shr.qg(pkVar, strQg, jSONObjectN, oaVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(l lVar, pk pkVar, long j, int i, String str) {
        if (s(lVar)) {
            String strQg = w.qg(pkVar);
            JSONObject jSONObjectN = com.byazt.gw.s.n(lVar, null, -1, lVar.m(), pkVar, -1L);
            d dVar = new d();
            dVar.n(lVar.ou());
            dVar.n(lVar.x());
            dVar.qg(j);
            dVar.n(i);
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            dVar.qg(str);
            dVar.s("");
            dVar.n(lVar);
            com.byazt.gw.s.s((com.byazt.shr.qg<d>) new com.byazt.shr.qg(pkVar, strQg, jSONObjectN, dVar));
        }
    }

    public static void n(l lVar, pk pkVar, long j) {
        if (s(lVar)) {
            String strQg = w.qg(pkVar);
            JSONObject jSONObjectN = com.byazt.gw.s.n(lVar, null, -1, lVar.m(), pkVar, -1L);
            sz szVar = new sz();
            szVar.n(lVar.ou());
            szVar.n(lVar.x());
            szVar.qg(j);
            szVar.n(lVar);
            if (lVar.ur() == 1) {
                szVar.s(1L);
            } else {
                szVar.s(0L);
            }
            com.byazt.gw.s.qg((com.byazt.shr.qg<sz>) new com.byazt.shr.qg(pkVar, strQg, jSONObjectN, szVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s(l lVar, pk pkVar) {
        if (s(lVar)) {
            String strQg = w.qg(pkVar);
            JSONObject jSONObjectN = com.byazt.gw.s.n(lVar, null, -1, lVar.m(), pkVar, -1L);
            cp cpVar = new cp(lVar.ou(), lVar.x());
            cpVar.n(lVar);
            com.byazt.gw.s.q((com.byazt.shr.qg<cp>) new com.byazt.shr.qg(pkVar, strQg, jSONObjectN, cpVar));
        }
    }
}
