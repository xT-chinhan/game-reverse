package com.byazt.rcj;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.gct.pk;
import com.byazt.gct.um;
import com.byazt.hj.DownloadStatusChangeListener;
import com.byazt.llp.rv;
import com.byazt.tk.h;
import com.byazt.tk.hd;
import com.taptap.sdk.core.internal.event.iap.lib2plus.BillingClientConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 104, 19})
public abstract class n implements com.byazt.wj.n {
    public boolean cp;
    public um d;
    public com.byazt.wj.n k;
    public com.byazt.wif.s l;
    public rv n;
    public String q;
    public Map<String, Object> qg;
    public DownloadStatusChangeListener rv;
    public Context s;
    public volatile boolean sz;
    public String w;
    public boolean x;
    public volatile boolean fs = false;
    public int oa = 0;
    public Function<SparseArray<Object>, Object> tj = com.byazt.vyf.s.cy().fi();

    public abstract com.byazt.myr.n l(Map<String, Object> map);

    public abstract com.byazt.myr.q n(Map<String, Object> map, com.byazt.ikv.s<String, Object> sVar);

    public abstract boolean s(int i);

    @Override // com.byazt.wj.n
    public boolean n(Map<String, Object> map) {
        if (!n()) {
            com.byazt.ukb.qg.n(this.qg, com.byazt.wr.qg.q);
            return false;
        }
        return qg(map);
    }

    public boolean n() {
        return (this.n == null || qg() == null || this.s == null || this.tj == null || TextUtils.isEmpty(this.w) || TextUtils.isEmpty(this.q) || this.l == null) ? false : true;
    }

    public boolean qg(Map<String, Object> map) {
        if (this.n.K_()) {
            com.byazt.ukb.qg.n(this.qg, com.byazt.wr.qg.l);
            return false;
        }
        if (TextUtils.isEmpty(this.w)) {
            com.byazt.ukb.qg.n(this.qg, com.byazt.wr.qg.l);
            return false;
        }
        if (hd.s(this.s) == 0) {
            try {
                h.n(this.s, "\"无网络，请稍后再试\"", 0);
            } catch (Exception unused) {
            }
            return true;
        }
        w(map);
        return true;
    }

    private void w(Map<String, Object> map) {
        int iQ = q(map);
        com.byazt.de.n.n(s(), s(iQ) ? 1 : 2);
        n(this.sz, iQ);
        if (this.s == null || TextUtils.isEmpty(this.w) || !x(map)) {
            return;
        }
        this.l.n(qg(iQ), this.n);
        com.byazt.ikv.s<String, Object> sVarN = new com.byazt.ikv.s().n("downloadUrl", this.w);
        sVarN.put("is_feed_register_direct_download", map.get("is_feed_register_direct_download"));
        sVarN.put("download_manager_hash_code", map.get("download_manager_hash_code"));
        sVarN.put("has_show_dl_factors", map.get("has_show_dl_factors"));
        sVarN.put("activity", map.get("activity"));
        sVarN.put("open_market_in_app", Boolean.valueOf(um.cy(qg())));
        com.byazt.myr.n nVarL = l(sVarN);
        if (nVarL == null || n((com.byazt.gct.q) null, nVarL, sVarN)) {
            return;
        }
        n(true, iQ);
        n(sVarN, nVarL);
    }

    private boolean x(Map<String, Object> map) {
        if (this.tj == null) {
            return true;
        }
        um umVar = this.d;
        if (umVar != null && umVar.x() == 1) {
            return true;
        }
        if (com.byazt.nf.rv.qg().c()) {
            String str = "已下载%d%%，可在通知栏暂停或取消";
            try {
                DownloadStatusChangeListener downloadStatusChangeListener = this.rv;
                if (downloadStatusChangeListener instanceof com.byazt.myr.qg) {
                    str = String.format("已下载%d%%，可在通知栏暂停或取消", Integer.valueOf(((com.byazt.myr.qg) downloadStatusChangeListener).getCurrentPercent()));
                }
            } catch (Exception unused) {
            }
            return n(map, str, true);
        }
        um umVar2 = this.d;
        if (umVar2 != null && umVar2.l()) {
            return true;
        }
        rv rvVar = this.n;
        if (rvVar instanceof pk) {
            com.byazt.oh.l.qg((pk) rvVar, "bdc");
        } else {
            com.byazt.oh.l.qg(null, "bdc");
        }
        return n(map, "应用正在下载...", false);
    }

    private boolean n(Map<String, Object> map, final String str, final boolean z) {
        Object objApply = this.tj.apply(com.byazt.of.qg.n().n(6).n(Boolean.class).n(0, new com.byazt.ikv.s().n("hashCode", Integer.valueOf(q(map))).n("downloadUrl", this.w)).qg());
        if (objApply == null || !((Boolean) objApply).booleanValue()) {
            return true;
        }
        com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.rcj.n.1
            @Override // java.lang.Runnable
            public void run() {
                if (z) {
                    h.qg(n.this.s, str, 0, 17, 0, 0);
                } else {
                    h.n(n.this.s, str, 0);
                }
            }
        });
        return false;
    }

    public boolean n(com.byazt.gct.q qVar, final com.byazt.myr.n nVar, final Map<String, Object> map) {
        boolean zN = com.byazt.ukb.qg.n(map);
        boolean zQg = com.byazt.ukb.qg.qg(map);
        final int iQ = q(map);
        if (!this.l.q(zN || zQg)) {
            return false;
        }
        com.byazt.wj.n nVar2 = this.k;
        if (nVar2 != null && nVar2.n(new HashMap())) {
            return true;
        }
        this.l.n(qVar, this.q, this.w, new com.byazt.pma.qg() { // from class: com.byazt.rcj.n.2
            @Override // com.byazt.pma.qg
            public void n() {
                if (n.this.s(iQ)) {
                    n.this.n(true, iQ);
                    n.this.n((Map<String, Object>) map, nVar);
                } else {
                    n.this.n(nVar, map);
                }
            }
        });
        return true;
    }

    public void n(boolean z, int i) {
        if (s(i)) {
            com.byazt.esa.s.n(z, com.byazt.esa.s.n(this.n, this.x), i);
        }
    }

    public void n(boolean z) {
        this.fs = z;
    }

    public void n(DownloadStatusChangeListener downloadStatusChangeListener) {
        this.rv = downloadStatusChangeListener;
    }

    public void n(um umVar) {
        this.d = umVar;
    }

    public void n(int i) {
        this.oa = i;
    }

    public void n(com.byazt.wj.n nVar) {
        this.k = nVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final Map<String, Object> map, final com.byazt.myr.n nVar) {
        com.byazt.iz.rv.n(new Runnable() { // from class: com.byazt.rcj.n.3
            @Override // java.lang.Runnable
            public void run() {
                n.this.n(nVar, map);
            }
        }, this.n);
        this.sz = false;
    }

    public void n(com.byazt.myr.n nVar, Map<String, Object> map) {
        try {
            qg().w(true);
            if (nVar == null) {
                fs(map);
                this.sz = false;
            } else {
                qg(nVar, map);
                this.sz = false;
            }
        } catch (Throwable unused) {
        }
    }

    private void qg(com.byazt.myr.n nVar, Map<String, Object> map) {
        if (this.tj == null) {
            return;
        }
        com.byazt.ikv.s<String, Object> sVarN = new com.byazt.ikv.s().n("itemClickListener", null).n("downloadButtonClickListener", nVar).n("hashCode", Integer.valueOf(q(map))).n(map);
        sVarN.put("itemClickListener", n(map, sVarN));
        this.tj.apply(com.byazt.of.qg.n().n(17).n(Void.class).n(0, sVarN).qg());
    }

    private void fs(Map<String, Object> map) {
        if (this.tj != null) {
            int iQ = q(map);
            if (map != null) {
                map.put("hashCode", Integer.valueOf(iQ));
            }
            this.tj.apply(com.byazt.of.qg.n().n(16).n(Void.class).n(0, map).qg());
        }
    }

    public com.byazt.wif.n qg(int i) {
        if (s(i)) {
            return new com.byazt.wif.l();
        }
        if (this.fs) {
            return new com.byazt.wif.q();
        }
        return new com.byazt.wif.qg();
    }

    public void s(final Map<String, Object> map) {
        int i = this.oa;
        if (i == 1) {
            com.byazt.de.n.q(s(), 2);
            com.byazt.oh.l.n(com.byazt.nf.rv.getContext(), qg(), "uchain_1");
            com.byazt.ukb.qg.n(this.qg, com.byazt.wr.qg.q);
        } else if (i == 2) {
            com.byazt.qit.l.qg(new com.byazt.qit.x("tt_download_check") { // from class: com.byazt.rcj.n.4
                @Override // java.lang.Runnable
                public void run() {
                    com.byazt.gct.q qVarN = com.byazt.nf.rv.n().n(n.this.qg(), n.this.w);
                    if (qVarN == null || !qVarN.x()) {
                        com.byazt.de.n.q(n.this.s(), 2);
                        com.byazt.ukb.qg.n(n.this.qg, com.byazt.wr.qg.q);
                        com.byazt.oh.l.n(com.byazt.nf.rv.getContext(), n.this.qg(), "uchain_2");
                    } else {
                        if (n.this.cp) {
                            n.this.qg(qVarN, (Map<String, Object>) map);
                        }
                        n.this.n(qVarN, (Map<String, Object>) map);
                    }
                }
            });
        } else {
            n((com.byazt.gct.q) null, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(com.byazt.gct.q qVar, Map<String, Object> map) {
        n(s(qVar, map), map);
    }

    public void qg(boolean z) {
        this.x = z;
    }

    public static int q(Map<String, Object> map) {
        if (map == null) {
            return 0;
        }
        Object obj = map.get("download_manager_hash_code");
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(com.byazt.gct.q qVar, Map<String, Object> map) {
        com.byazt.gct.w wVarN = com.byazt.oh.l.n(qVar.fs());
        com.byazt.gct.w wVarCd = this.n.cd();
        if (wVarCd == null) {
            qg().n(wVarN);
        } else {
            if (wVarN != null) {
                wVarCd.tj(wVarN.sz());
                wVarCd.qg(wVarN.l());
                wVarCd.q(wVarN.x());
                wVarCd.qg(wVarN.d());
                wVarCd.l(wVarN.fs());
                wVarCd.rv(wVarN.oa());
                wVarCd.s(wVarN.w());
                wVarCd.w(wVarN.rv());
                wVarCd.x(wVarN.tj());
                wVarCd.fs(wVarN.cp());
            }
            wVarN = wVarCd;
        }
        if (wVarN != null) {
            n(wVarN.w(), wVarN.sz(), wVarN.oa(), map);
        }
    }

    private void n(String str, String str2, String str3, Map<String, Object> map) {
        if (this.tj == null) {
            return;
        }
        this.tj.apply(com.byazt.of.qg.n().n(24).n(Boolean.class).n(0, new com.byazt.ikv.s().n("appIcon", str).n("appName", str2).n("hashCode", Integer.valueOf(q(map))).n(BillingClientConstants.PACKAGE_NAME, str3)).qg());
    }

    private com.byazt.myr.n s(final com.byazt.gct.q qVar, final Map<String, Object> map) {
        return new com.byazt.myr.n() { // from class: com.byazt.rcj.n.5
            @Override // com.byazt.ky.IDownloadButtonClickListener
            public void handleMarketFailedComplianceDialog() {
            }

            @Override // com.byazt.ky.IDownloadButtonClickListener
            public void handleComplianceDialog(boolean z) {
                if (z && n.this.n(qVar, (com.byazt.myr.n) null, map)) {
                    return;
                }
                n.this.n((com.byazt.myr.n) null, map);
            }
        };
    }

    public pk qg() {
        return com.byazt.ukb.qg.n(this.n, this.qg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String s() {
        if (qg() == null) {
            return null;
        }
        return qg().h();
    }
}
