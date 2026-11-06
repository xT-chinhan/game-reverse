package com.byazt.mz;

import android.text.TextUtils;
import com.byazt.gct.pk;
import com.byazt.gct.z;
import com.byazt.hi.fs;
import com.byazt.se.rv;
import com.byazt.se.w;
import com.byazt.se.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 895, 5})
public class q extends com.byazt.mz.n {
    public volatile com.byazt.eau.l fs = null;
    public qg x;

    @com.byazt.cp.n(n = {0, 1, 895, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME})
    static class n {
        public boolean n = true;
        public long qg = 0;
        public long s = 0;
        public long q = 0;
    }

    @Override // com.byazt.mz.n
    public void n(String str, String str2, boolean z, boolean z2, Object obj) {
    }

    @Override // com.byazt.mz.n
    public void qg() {
    }

    @Override // com.byazt.mz.n
    public void n(z zVar, com.byazt.zq.qg qgVar, boolean z) {
        int iN;
        if (zVar != null && (iN = fs.n(zVar)) > 0) {
            n(iN, zVar.n().aj());
            n(zVar);
        }
    }

    private void n(z zVar) {
        qg qgVar = this.x;
        if (qgVar == null) {
            this.x = new qg(zVar);
        } else {
            qgVar.n(zVar);
        }
        com.byazt.qit.l.n(this.x, 10);
    }

    private com.byazt.gwu.s w() {
        return com.byazt.lk.l.n(com.byazt.vgx.s.q(), n("tt_splash"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.gwu.s x() {
        return com.byazt.lk.l.n(com.byazt.vgx.s.q(), n("tt_materialMeta"));
    }

    public static void q() {
        com.byazt.lk.l.n(com.byazt.vgx.s.q(), n("tt_materialMeta")).n();
        com.byazt.lk.l.n(com.byazt.vgx.s.q(), n("tt_splash")).n();
    }

    public static String n(String str) {
        com.byazt.gct.fs.s sVarN = com.byazt.gct.fs.n(3);
        return (sVarN == null || sVarN.fs()) ? str + "_7814" : str;
    }

    private void n(int i, long j) {
        com.byazt.gwu.s sVarW = w();
        sVarW.n("expiration" + i, j);
        sVarW.n("update" + i, System.currentTimeMillis() / 1000);
        sVarW.n("has_ad_cache" + i, true);
    }

    private boolean n(x xVar, String str) {
        if (qg(str)) {
            return true;
        }
        if (xVar != null) {
            xVar.q(0);
            xVar.qg(1);
            xVar.n("no cache");
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003e  */
    /* JADX WARN: Code duplicated, block: B:20:0x0041 A[Catch: all -> 0x0054, TryCatch #0 {all -> 0x0054, blocks: (B:13:0x0022, B:15:0x0028, B:17:0x0032, B:20:0x0041, B:21:0x0044, B:24:0x0050), top: B:33:0x0022 }] */
    /* JADX WARN: Code duplicated, block: B:23:0x004f  */
    /* JADX WARN: Code duplicated, block: B:24:0x0050 A[Catch: all -> 0x0054, TRY_LEAVE, TryCatch #0 {all -> 0x0054, blocks: (B:13:0x0022, B:15:0x0028, B:17:0x0032, B:20:0x0041, B:21:0x0044, B:24:0x0050), top: B:33:0x0022 }] */
    @Override // com.byazt.mz.n
    public void n(x xVar, String str, com.byazt.mz.n.InterfaceC0253n interfaceC0253n, l lVar) {
        pk pkVar;
        if (TextUtils.isEmpty(str) || interfaceC0253n == null) {
            return;
        }
        this.w = lVar;
        if (!n(xVar, str)) {
            interfaceC0253n.n();
            return;
        }
        w wVar = null;
        try {
            com.byazt.gct.n nVarX = x(str);
            w wVar2 = new w(nVarX, true);
            if (nVarX != null) {
                try {
                    if (nVarX.qg() == null || nVarX.qg().isEmpty()) {
                        pkVar = null;
                    } else {
                        pkVar = nVarX.qg().get(0);
                    }
                    if (pkVar != null) {
                        wVar2.n(pkVar);
                    }
                    if (com.byazt.wq.qg.n().s(pkVar) != 3) {
                        wVar = wVar2;
                    } else {
                        wVar2.n((pk) null);
                    }
                } catch (Throwable unused) {
                }
            } else {
                pkVar = null;
                if (pkVar != null) {
                    wVar2.n(pkVar);
                }
                if (com.byazt.wq.qg.n().s(pkVar) != 3) {
                    wVar = wVar2;
                } else {
                    wVar2.n((pk) null);
                }
            }
        } catch (Throwable unused2) {
        }
        interfaceC0253n.n(wVar);
        if (com.byazt.ed.q.n().tj()) {
            return;
        }
        w(str);
    }

    public boolean qg(String str) {
        return (TextUtils.isEmpty(str) || !w().qg(new StringBuilder("has_ad_cache").append(str).toString(), false) || l(str)) ? false : true;
    }

    public long s(String str) {
        n nVarQ = q(str);
        if (nVarQ == null || nVarQ.n) {
            return 0L;
        }
        return Math.max(0L, nVarQ.s - nVarQ.q);
    }

    @Override // com.byazt.mz.n
    public void n(com.byazt.jr.q<rv, x> qVar, pk pkVar, com.byazt.zq.qg qgVar, boolean z) {
        if (pkVar == null) {
            return;
        }
        com.byazt.gwu.s sVarX = x();
        if (z) {
            sVarX.n("net_ad_already_shown", pkVar.ou());
        }
        if (this.l.get()) {
            return;
        }
        String strQg = sVarX.qg("net_ad_save_success" + com.byazt.vgx.w.cy(pkVar), "");
        if (TextUtils.isEmpty(strQg) || !strQg.equals(pkVar.ou())) {
            return;
        }
        this.l.set(true);
        com.byazt.eo.n.n("lqmt", "计划清除缓存 reqId:  " + strQg);
        w(qgVar != null ? qgVar.q() : null);
        if (qVar != null) {
            qVar.n();
        }
    }

    private n q(String str) {
        n nVar = new n();
        if (TextUtils.isEmpty(str)) {
            return nVar;
        }
        com.byazt.gwu.s sVarW = w();
        long jQg = sVarW.qg("expiration" + str, 0L);
        long jQg2 = sVarW.qg("update" + str, 0L);
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        nVar.n = jCurrentTimeMillis < jQg2 || jCurrentTimeMillis >= jQg;
        nVar.qg = jQg2;
        nVar.s = jQg;
        nVar.q = jCurrentTimeMillis;
        return nVar;
    }

    private boolean l(String str) {
        final n nVarQ = q(str);
        if (nVarQ.n) {
            com.byazt.eji.s.n().n("splash_creative_check", str, (String) null, 4, 0, (String) null, new com.byazt.rs.n() { // from class: com.byazt.mz.q.1
                @Override // com.byazt.rs.n
                public JSONObject n(JSONObject jSONObject) throws JSONException {
                    long j = nVarQ.q - nVarQ.qg;
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("available_type", 0);
                    jSONObject2.putOpt("creative_timeout_duration", Long.valueOf(j / 3600));
                    return jSONObject2;
                }
            });
        }
        long j = this.w == null ? 0L : this.w.n;
        if (j <= 0 || nVarQ.qg * 1000 >= j) {
            return nVarQ.n;
        }
        return true;
    }

    @Override // com.byazt.mz.n
    public void n(String str, pk pkVar) {
        w(str);
    }

    private void w(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.byazt.gwu.s sVarW = w();
        x().n("materialMeta" + str);
        if (sVarW != null) {
            sVarW.n("has_ad_cache" + str);
            sVarW.n("expiration" + str);
        }
        com.byazt.eo.n.n("lqmt", "清除成功： rit: " + str);
    }

    @com.byazt.cp.n(n = {0, 1, 895, 524})
    private class qg extends com.byazt.qit.x {
        public z qg;

        public qg(z zVar) {
            super("WriteCacheTask");
            this.qg = zVar;
        }

        public void n(z zVar) {
            this.qg = zVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            n();
        }

        private void n() {
            try {
                int iN = fs.n(this.qg);
                if (iN <= 0) {
                    return;
                }
                com.byazt.gwu.s sVarX = q.this.x();
                String strQg = sVarX.qg("net_ad_already_shown", "");
                if (!TextUtils.isEmpty(strQg) && strQg.equals(this.qg.n().ou())) {
                    com.byazt.eo.n.n("lqmt", "该缓存已show-则不再save： rit: " + iN + "   reqId: " + this.qg.n().ou());
                    return;
                }
                JSONObject jSONObjectS = this.qg.qg().s();
                if (jSONObjectS != null) {
                    sVarX.n("materialMeta".concat(String.valueOf(iN)), jSONObjectS.toString());
                }
                sVarX.n("net_ad_save_success".concat(String.valueOf(iN)), this.qg.n().ou());
                com.byazt.eo.n.n("lqmt", "缓存成功： rit: " + iN + "   reqId: " + this.qg.n().ou());
            } catch (Throwable unused) {
            }
        }
    }

    private com.byazt.gct.n x(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String strQg = x().qg("materialMeta" + str, (String) null);
        if (!TextUtils.isEmpty(strQg)) {
            try {
                com.byazt.mw.qg.n nVarN = com.byazt.mw.qg.n.n(new JSONObject(strQg));
                if (nVarN != null && nVarN.fs != null) {
                    return nVarN.fs;
                }
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public static void l() {
        com.byazt.nf.rv.qg().ot();
    }

    @Override // com.byazt.mz.n
    public void s() {
        try {
            x().n();
            w().n();
        } catch (Throwable unused) {
        }
    }
}
