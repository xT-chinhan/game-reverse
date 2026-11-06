package com.byazt.hm;

import android.text.TextUtils;
import com.byazt.gct.hd;
import com.byazt.gct.ou;
import com.byazt.gct.pk;
import com.byazt.qit.x;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 49, 18})
public class l {
    public static volatile l n;

    public static l n() {
        if (n == null) {
            synchronized (l.class) {
                if (n == null) {
                    n = new l();
                }
            }
        }
        return n;
    }

    private l() {
    }

    public void n(final pk pkVar, final String str, final boolean z, final boolean z2, final com.byazt.okk.qg.n nVar) {
        if (pkVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.wfe.n.n(1);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        new com.byazt.okk.qg().n(new com.byazt.okk.qg.n() { // from class: com.byazt.hm.l.1
            public boolean fs = false;

            @Override // com.byazt.okk.qg.n
            public void n(long j) {
                com.byazt.okk.qg.n nVar2 = nVar;
                if (nVar2 != null) {
                    nVar2.n(j);
                }
                n(false, "resume");
                if (!z) {
                    n(str, z2);
                }
                com.byazt.ikv.n.n().n("dpl_reject_by_dialog", true);
                n.n(pkVar, str, "dpl_popup", System.currentTimeMillis() - jCurrentTimeMillis);
                if (j > ou.qg()) {
                    com.byazt.wfe.n.n(2);
                } else {
                    com.byazt.wfe.n.n(3);
                }
            }

            @Override // com.byazt.okk.qg.n
            public void n(String str2) {
                com.byazt.okk.qg.n nVar2 = nVar;
                if (nVar2 != null) {
                    nVar2.n(str2);
                }
                n(false, str2);
            }

            @Override // com.byazt.okk.qg.n
            public void n(boolean z3) {
                com.byazt.okk.qg.n nVar2 = nVar;
                if (nVar2 != null) {
                    nVar2.n(z3);
                }
                this.fs = z3;
                n(z3, "stop");
                if (!this.fs && !z) {
                    n(str, z2);
                }
                com.byazt.ikv.n.n().n("dpl_reject_by_dialog", false);
            }

            private void n(String str2, boolean z3) {
                pk pkVar2 = pkVar;
                if (pkVar2 == null || this.fs) {
                    return;
                }
                boolean zHd = pkVar2.hd();
                hd hdVarSz = pkVar.sz();
                if (hdVarSz == null || hdVarSz.n()) {
                    return;
                }
                int iS = hdVarSz.s();
                if (zHd) {
                    return;
                }
                if (iS == 1 || iS == 2) {
                    com.byazt.qq.q.n(pkVar, str2, z3);
                }
            }

            private void n(final boolean z3, final String str2) {
                com.byazt.qit.l.n(new x("EventData") { // from class: com.byazt.hm.l.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (z) {
                            n.s(pkVar, str, z3 ? "lp_dpl_success" : "lp_dpl_failed");
                            return;
                        }
                        String str3 = z3 ? "dpl_success" : "dpl_failed";
                        HashMap map = new HashMap();
                        boolean zN = com.byazt.vyf.s.cy().n();
                        map.put("has_focus", Boolean.valueOf(com.byazt.vyf.s.cy().n(true)));
                        map.put("is_background", Boolean.valueOf(zN));
                        map.put("life", str2);
                        map.put("total_duration", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                        n.rv(pkVar, str, str3, map);
                        if (pkVar == null || !z3) {
                            return;
                        }
                        l.qg(pkVar, str);
                    }
                }, 5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(pk pkVar, String str) {
        if (pkVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.gwu.l lVarS = com.byazt.ikv.n.s();
        lVarS.n("save_jump_success_time", System.currentTimeMillis());
        JSONObject jSONObjectPv = pkVar.pv();
        if (jSONObjectPv == null) {
            return;
        }
        lVarS.n("save_dpl_success_materialmeta", jSONObjectPv.toString());
        lVarS.n("save_jump_success_ad_tag", str);
    }
}
