package com.byazt.pj;

import android.text.TextUtils;
import com.byazt.hg.ny;
import com.byazt.hg.of;
import com.byazt.hg.yb;
import com.byazt.sd.n;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 115, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public static volatile c pr;

    public static c pr() {
        if (pr == null) {
            synchronized (c.class) {
                if (pr == null) {
                    pr = new c();
                }
            }
        }
        return pr;
    }

    private c() {
    }

    public void pr(final of ofVar, final String str, final boolean z, final boolean z2, final fw.pr prVar) {
        if (ofVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.wm.pr.pr(1);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        new fw().pr(new fw.pr() { // from class: com.byazt.pj.c.1
            public boolean zo = false;

            @Override // com.byazt.pj.fw.pr
            public void pr(long j) {
                fw.pr prVar2 = prVar;
                if (prVar2 != null) {
                    prVar2.pr(j);
                }
                pr(false, "resume");
                if (!z) {
                    pr(str, z2);
                }
                com.byazt.sd.hw.pr().pr("dpl_reject_by_dialog", true);
                pr.pr(ofVar, str, "dpl_popup", System.currentTimeMillis() - jCurrentTimeMillis);
                if (j > ny.hw()) {
                    com.byazt.wm.pr.pr(2);
                } else {
                    com.byazt.wm.pr.pr(3);
                }
            }

            @Override // com.byazt.pj.fw.pr
            public void pr(String str2) {
                fw.pr prVar2 = prVar;
                if (prVar2 != null) {
                    prVar2.pr(str2);
                }
                pr(false, str2);
            }

            @Override // com.byazt.pj.fw.pr
            public void pr(boolean z3) {
                fw.pr prVar2 = prVar;
                if (prVar2 != null) {
                    prVar2.pr(z3);
                }
                this.zo = z3;
                pr(z3, "stop");
                if (!this.zo && !z) {
                    pr(str, z2);
                }
                com.byazt.sd.hw.pr().pr("dpl_reject_by_dialog", false);
            }

            private void pr(String str2, boolean z3) {
                of ofVar2 = ofVar;
                if (ofVar2 != null && !this.zo) {
                    boolean zYb = ofVar2.yb();
                    yb ybVarG = ofVar.g();
                    if (ybVarG == null || ybVarG.pr()) {
                        return;
                    }
                    int iHn = ybVarG.hn();
                    if (zYb) {
                        return;
                    }
                    if (iHn == 1 || iHn == 2) {
                        n.pr(ofVar, str2, z3);
                    }
                }
            }

            private void pr(final boolean z3, final String str2) {
                com.byazt.xlm.c.pr(new com.byazt.xlm.fw("EventData") { // from class: com.byazt.pj.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (z) {
                            pr.hn(ofVar, str, z3 ? "lp_dpl_success" : "lp_dpl_failed");
                            return;
                        }
                        String str3 = z3 ? "dpl_success" : "dpl_failed";
                        HashMap map = new HashMap();
                        boolean zPr = com.byazt.sd.zo.nt().pr();
                        map.put("has_focus", Boolean.valueOf(com.byazt.sd.zo.nt().pr(true)));
                        map.put("is_background", Boolean.valueOf(zPr));
                        map.put("life", str2);
                        map.put("total_duration", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                        pr.aj(ofVar, str, str3, map);
                        if (ofVar != null && z3) {
                            c.hw(ofVar, str);
                        }
                    }
                }, 5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hw(of ofVar, String str) {
        if (ofVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.zq.c cVarHn = com.byazt.sd.hw.hn();
        cVarHn.pr("save_jump_success_time", System.currentTimeMillis());
        JSONObject jSONObject = ofVar.to();
        if (jSONObject == null) {
            return;
        }
        cVarHn.pr("save_dpl_success_materialmeta", jSONObject.toString());
        cVarHn.pr("save_jump_success_ad_tag", str);
    }
}
