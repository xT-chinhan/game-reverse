package com.byazt.ks;

import android.text.TextUtils;
import com.byazt.hg.of;
import com.byazt.hg.sv;
import com.byazt.jm.zo;
import com.byazt.sd.a;
import com.byazt.sd.rc;
import com.byazt.wt.ls;
import com.byazt.zn.aj;
import com.byazt.zn.fw;
import com.byazt.zn.uc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE, 121})
public class x extends com.byazt.ks.pr {
    public hw fw;
    public volatile com.byazt.cr.c zo = null;

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
    static class pr {
        public boolean pr = true;
        public long hw = 0;
        public long hn = 0;
        public long x = 0;
    }

    @Override // com.byazt.ks.pr
    public void hw() {
    }

    @Override // com.byazt.ks.pr
    public void pr(sv svVar, com.byazt.qe.hw hwVar, boolean z) {
        int iPr;
        if (svVar == null || (iPr = zo.pr(svVar)) <= 0) {
            return;
        }
        pr(iPr, svVar.pr().hp());
        pr(svVar);
    }

    private void pr(sv svVar) {
        hw hwVar = this.fw;
        if (hwVar == null) {
            this.fw = new hw(svVar);
        } else {
            hwVar.pr(svVar);
        }
        com.byazt.xlm.c.pr(this.fw, 10);
    }

    private com.byazt.zq.hn c() {
        return com.byazt.qn.x.pr(com.byazt.zb.pr.x(), hn("tt_splash"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.zq.hn uc() {
        return com.byazt.qn.x.pr(com.byazt.zb.pr.x(), hn("tt_materialMeta"));
    }

    private String hn(String str) {
        com.byazt.hg.zo.hn hnVarPr = com.byazt.hg.zo.pr(3);
        String str2 = str + "_7714";
        if (hnVarPr == null || hnVarPr.zo()) {
            return str2;
        }
        return str;
    }

    private void pr(int i, long j) {
        com.byazt.zq.hn hnVarC = c();
        hnVarC.pr("expiration" + i, j);
        hnVarC.pr("update" + i, System.currentTimeMillis() / 1000);
        hnVarC.pr("has_ad_cache" + i, true);
    }

    private boolean pr(fw fwVar, String str) {
        if (pr(str)) {
            return true;
        }
        if (fwVar != null) {
            fwVar.x(0);
            fwVar.hw(1);
            fwVar.pr("no cache");
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0042  */
    /* JADX WARN: Code duplicated, block: B:22:0x0045 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:13:0x0024, B:15:0x002a, B:17:0x0034, B:22:0x0045, B:23:0x0048, B:24:0x0050, B:26:0x0055), top: B:35:0x0024 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x0053  */
    /* JADX WARN: Code duplicated, block: B:26:0x0055 A[Catch: all -> 0x0040, TRY_LEAVE, TryCatch #0 {all -> 0x0040, blocks: (B:13:0x0024, B:15:0x002a, B:17:0x0034, B:22:0x0045, B:23:0x0048, B:24:0x0050, B:26:0x0055), top: B:35:0x0024 }] */
    @Override // com.byazt.ks.pr
    public void pr(fw fwVar, String str, com.byazt.ks.pr.InterfaceC0116pr interfaceC0116pr, c cVar) {
        of ofVar;
        if (TextUtils.isEmpty(str) || interfaceC0116pr == null) {
            return;
        }
        this.uc = cVar;
        if (!pr(fwVar, str)) {
            interfaceC0116pr.pr();
            return;
        }
        uc ucVar = null;
        try {
            com.byazt.hg.pr prVarFw = fw(str);
            uc ucVar2 = new uc(prVarFw, true);
            if (prVarFw != null) {
                try {
                    if (prVarFw.hw() != null && !prVarFw.hw().isEmpty()) {
                        ofVar = prVarFw.hw().get(0);
                    } else {
                        ofVar = null;
                    }
                    if (ofVar != null) {
                        ucVar2.pr(ofVar);
                    }
                    switch (com.byazt.eg.hw.pr().hn(ofVar)) {
                        case 3:
                            ucVar2.pr((of) null);
                            break;
                        default:
                            ucVar = ucVar2;
                            break;
                    }
                } catch (Throwable th) {
                    ucVar = ucVar2;
                }
            } else {
                ofVar = null;
                if (ofVar != null) {
                    ucVar2.pr(ofVar);
                }
                switch (com.byazt.eg.hw.pr().hn(ofVar)) {
                    case 3:
                        ucVar2.pr((of) null);
                        break;
                    default:
                        ucVar = ucVar2;
                        break;
                }
            }
        } catch (Throwable th2) {
        }
        interfaceC0116pr.pr(ucVar);
        if (!com.byazt.mp.c.pr().vk()) {
            uc(str);
        }
    }

    public boolean pr(String str) {
        return (TextUtils.isEmpty(str) || !c().hw(new StringBuilder("has_ad_cache").append(str).toString(), false) || c(str)) ? false : true;
    }

    public long hw(String str) {
        pr prVarX = x(str);
        if (prVarX == null || prVarX.pr) {
            return 0L;
        }
        return Math.max(0L, prVarX.hn - prVarX.x);
    }

    @Override // com.byazt.ks.pr
    public void pr(com.byazt.vx.x<aj, fw> xVar, of ofVar, com.byazt.qe.hw hwVar, boolean z) {
        if (ofVar == null) {
            return;
        }
        com.byazt.zq.hn hnVarUc = uc();
        if (z) {
            hnVarUc.pr("net_ad_already_shown", ofVar.ny());
        }
        if (this.c.get()) {
            return;
        }
        String strHw = hnVarUc.hw("net_ad_save_success" + ls.m(ofVar), "");
        if (!TextUtils.isEmpty(strHw) && strHw.equals(ofVar.ny())) {
            this.c.set(true);
            com.byazt.nz.pr.pr("lqmt", "计划清除缓存 reqId:  " + strHw);
            uc(hwVar != null ? hwVar.x() : null);
            if (xVar != null) {
                xVar.pr();
            }
        }
    }

    private pr x(String str) {
        pr prVar = new pr();
        if (TextUtils.isEmpty(str)) {
            return prVar;
        }
        com.byazt.zq.hn hnVarC = c();
        long jHw = hnVarC.hw("expiration" + str, 0L);
        long jHw2 = hnVarC.hw("update" + str, 0L);
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        prVar.pr = jCurrentTimeMillis < jHw2 || jCurrentTimeMillis >= jHw;
        prVar.hw = jHw2;
        prVar.hn = jHw;
        prVar.x = jCurrentTimeMillis;
        return prVar;
    }

    private boolean c(String str) {
        final pr prVarX = x(str);
        if (prVarX.pr) {
            com.byazt.xk.hw.pr().pr("splash_creative_check", str, (String) null, 4, 0, (String) null, new com.byazt.ttf.pr() { // from class: com.byazt.ks.x.1
                @Override // com.byazt.ttf.pr
                public JSONObject pr(JSONObject jSONObject) throws JSONException {
                    long j = prVarX.x - prVarX.hw;
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("available_type", 0);
                    jSONObject2.putOpt("creative_timeout_duration", Long.valueOf(j / 3600));
                    return jSONObject2;
                }
            });
        }
        long j = this.uc == null ? 0L : this.uc.pr;
        if (j > 0 && prVarX.hw * 1000 < j) {
            return true;
        }
        return prVarX.pr;
    }

    @Override // com.byazt.ks.pr
    public void pr(String str, of ofVar) {
        uc(str);
    }

    private void uc(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.zq.hn hnVarC = c();
        uc().pr("materialMeta" + str);
        if (hnVarC != null) {
            hnVarC.pr("has_ad_cache" + str);
            hnVarC.pr("expiration" + str);
        }
        com.byazt.nz.pr.pr("lqmt", "清除成功： rit: " + str);
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE, 759})
    private class hw extends com.byazt.xlm.fw {
        public sv hw;

        public hw(sv svVar) {
            super("WriteCacheTask");
            this.hw = svVar;
        }

        public void pr(sv svVar) {
            this.hw = svVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            hw();
        }

        private void hw() {
            try {
                int iPr = zo.pr(this.hw);
                if (iPr > 0) {
                    com.byazt.zq.hn hnVarUc = x.this.uc();
                    String strHw = hnVarUc.hw("net_ad_already_shown", "");
                    if (!TextUtils.isEmpty(strHw) && strHw.equals(this.hw.pr().ny())) {
                        com.byazt.nz.pr.pr("lqmt", "该缓存已show-则不再save： rit: " + iPr + "   reqId: " + this.hw.pr().ny());
                        return;
                    }
                    JSONObject jSONObjectHn = this.hw.hw().hn();
                    if (jSONObjectHn != null) {
                        hnVarUc.pr("materialMeta".concat(String.valueOf(iPr)), jSONObjectHn.toString());
                    }
                    hnVarUc.pr("net_ad_save_success".concat(String.valueOf(iPr)), this.hw.pr().ny());
                    com.byazt.nz.pr.pr("lqmt", "缓存成功： rit: " + iPr + "   reqId: " + this.hw.pr().ny());
                }
            } catch (Throwable th) {
            }
        }
    }

    private com.byazt.hg.pr fw(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String strHw = uc().hw("materialMeta" + str, (String) null);
        if (!TextUtils.isEmpty(strHw)) {
            try {
                rc.pr prVarPr = rc.pr.pr(new JSONObject(strHw));
                if (prVarPr != null && prVarPr.zo != null) {
                    return prVarPr.zo;
                }
            } catch (JSONException e) {
            }
        }
        return null;
    }

    public static void x() {
        a.hw().ji();
    }

    @Override // com.byazt.ks.pr
    public void hn() {
        try {
            uc().pr();
            c().pr();
        } catch (Throwable th) {
        }
    }

    @Override // com.byazt.ks.pr
    public void pr(String str, String str2, boolean z, boolean z2, Object obj) {
    }
}
