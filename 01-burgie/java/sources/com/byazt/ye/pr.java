package com.byazt.ye;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.af.aj;
import com.byazt.bek.DownloadStatusChangeListener;
import com.byazt.ca.b;
import com.byazt.ca.yb;
import com.byazt.hg.of;
import com.byazt.hg.qa;
import com.byazt.ol.TTDownloadField;
import com.byazt.sd.a;
import com.byazt.wt.ww;
import com.taptap.sdk.db.biz.iap.lib2plus.BillingClientConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 475, 37})
public abstract class pr implements com.byazt.ni.pr {
    public DownloadStatusChangeListener aj;
    public com.byazt.wr.hn c;
    public boolean fw;
    public volatile boolean g;
    public Context hn;
    public com.byazt.ni.pr ho;
    public Map<String, Object> hw;
    public qa k;
    public aj pr;
    public String uc;
    public boolean w;
    public String x;
    public volatile boolean zo = false;
    public int m = 0;
    public Function<SparseArray<Object>, Object> vk = com.byazt.sd.zo.nt().ls();

    public abstract com.byazt.qp.pr c(Map<String, Object> map);

    public abstract boolean hn(int i);

    public abstract com.byazt.qp.x pr(Map<String, Object> map, ww<String, Object> wwVar);

    @Override // com.byazt.ni.pr
    public boolean pr(Map<String, Object> map) {
        if (!pr()) {
            com.byazt.lx.hw.pr(this.hw, com.byazt.wb.hw.x);
            return false;
        }
        return hw(map);
    }

    public boolean pr() {
        return (this.pr == null || hw() == null || this.hn == null || this.vk == null || TextUtils.isEmpty(this.uc) || TextUtils.isEmpty(this.x) || this.c == null) ? false : true;
    }

    public boolean hw(Map<String, Object> map) {
        if (this.pr.G_()) {
            com.byazt.lx.hw.pr(this.hw, com.byazt.wb.hw.c);
            return false;
        }
        if (TextUtils.isEmpty(this.uc)) {
            com.byazt.lx.hw.pr(this.hw, com.byazt.wb.hw.c);
            return false;
        }
        if (yb.hn(this.hn) == 0) {
            try {
                b.pr(this.hn, "\"无网络，请稍后再试\"", 0);
            } catch (Exception e) {
            }
            return true;
        }
        uc(map);
        return true;
    }

    private void uc(Map<String, Object> map) {
        int iX = x(map);
        com.byazt.qd.pr.pr(hn(), hn(iX) ? 1 : 2);
        pr(this.g, iX);
        if (this.hn == null || TextUtils.isEmpty(this.uc) || !fw(map)) {
            return;
        }
        this.c.pr(hw(iX), this.pr);
        ww<String, Object> wwVarPr = new ww().pr("downloadUrl", this.uc);
        wwVarPr.put("is_feed_register_direct_download", map.get("is_feed_register_direct_download"));
        wwVarPr.put("download_manager_hash_code", map.get("download_manager_hash_code"));
        wwVarPr.put("has_show_dl_factors", map.get("has_show_dl_factors"));
        wwVarPr.put(TTDownloadField.TT_ACTIVITY, map.get(TTDownloadField.TT_ACTIVITY));
        wwVarPr.put("open_market_in_app", Boolean.valueOf(qa.nt(hw())));
        com.byazt.qp.pr prVarC = c(wwVarPr);
        if (prVarC == null || pr((com.byazt.hg.x) null, prVarC, wwVarPr)) {
            return;
        }
        pr(true, iX);
        pr(wwVarPr, prVarC);
    }

    private boolean fw(Map<String, Object> map) {
        if (this.vk == null) {
            return true;
        }
        qa qaVar = this.k;
        if (qaVar != null && qaVar.fw() == 1) {
            return true;
        }
        if (a.hw().om()) {
            String str = "已下载%d%%，可在通知栏暂停或取消";
            try {
                DownloadStatusChangeListener downloadStatusChangeListener = this.aj;
                if (downloadStatusChangeListener instanceof com.byazt.qp.hw) {
                    str = String.format("已下载%d%%，可在通知栏暂停或取消", Integer.valueOf(((com.byazt.qp.hw) downloadStatusChangeListener).getCurrentPercent()));
                }
            } catch (Exception e) {
            }
            return pr(map, str, true);
        }
        qa qaVar2 = this.k;
        if (qaVar2 != null && qaVar2.c()) {
            return true;
        }
        aj ajVar = this.pr;
        if (ajVar instanceof of) {
            com.byazt.ri.c.hw((of) ajVar, "bdc");
        } else {
            com.byazt.ri.c.hw(null, "bdc");
        }
        return pr(map, "应用正在下载...", false);
    }

    private boolean pr(Map<String, Object> map, final String str, final boolean z) {
        Object objApply = this.vk.apply(com.byazt.xi.hw.pr().pr(6).pr(Boolean.class).pr(0, new ww().pr("hashCode", Integer.valueOf(x(map))).pr("downloadUrl", this.uc)).hw());
        if (objApply != null && ((Boolean) objApply).booleanValue()) {
            com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.ye.pr.1
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        b.hw(pr.this.hn, str, 0, 17, 0, 0);
                    } else {
                        b.pr(pr.this.hn, str, 0);
                    }
                }
            });
            return false;
        }
        return true;
    }

    public boolean pr(com.byazt.hg.x xVar, final com.byazt.qp.pr prVar, final Map<String, Object> map) {
        boolean zPr = com.byazt.lx.hw.pr(map);
        boolean zHw = com.byazt.lx.hw.hw(map);
        final int iX = x(map);
        if (!this.c.x(zPr || zHw)) {
            return false;
        }
        com.byazt.ni.pr prVar2 = this.ho;
        if (prVar2 != null && prVar2.pr(new HashMap())) {
            return true;
        }
        this.c.pr(xVar, this.x, this.uc, new com.byazt.rx.hw() { // from class: com.byazt.ye.pr.2
            @Override // com.byazt.rx.hw
            public void pr() {
                if (pr.this.hn(iX)) {
                    pr.this.pr(true, iX);
                    pr.this.pr((Map<String, Object>) map, prVar);
                } else {
                    pr.this.pr(prVar, map);
                }
            }
        });
        return true;
    }

    public void pr(boolean z, int i) {
        if (!hn(i)) {
            return;
        }
        com.byazt.vo.hn.pr(z, com.byazt.vo.hn.pr(this.pr, this.fw), i);
    }

    public void pr(boolean z) {
        this.zo = z;
    }

    public void pr(DownloadStatusChangeListener downloadStatusChangeListener) {
        this.aj = downloadStatusChangeListener;
    }

    public void pr(qa qaVar) {
        this.k = qaVar;
    }

    public void pr(int i) {
        this.m = i;
    }

    public void pr(com.byazt.ni.pr prVar) {
        this.ho = prVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(final Map<String, Object> map, final com.byazt.qp.pr prVar) {
        com.byazt.jx.aj.pr(new Runnable() { // from class: com.byazt.ye.pr.3
            @Override // java.lang.Runnable
            public void run() {
                pr.this.pr(prVar, map);
            }
        }, this.pr);
        this.g = false;
    }

    public void pr(com.byazt.qp.pr prVar, Map<String, Object> map) {
        try {
            hw().x(true);
            if (prVar == null) {
                zo(map);
                this.g = false;
            } else {
                hw(prVar, map);
                this.g = false;
            }
        } catch (Throwable th) {
        }
    }

    private void hw(com.byazt.qp.pr prVar, Map<String, Object> map) {
        if (this.vk == null) {
            return;
        }
        ww<String, Object> wwVarPr = new ww().pr("itemClickListener", null).pr("downloadButtonClickListener", prVar).pr("hashCode", Integer.valueOf(x(map))).pr(map);
        wwVarPr.put("itemClickListener", pr(map, wwVarPr));
        this.vk.apply(com.byazt.xi.hw.pr().pr(17).pr(Void.class).pr(0, wwVarPr).hw());
    }

    private void zo(Map<String, Object> map) {
        if (this.vk != null) {
            int iX = x(map);
            if (map != null) {
                map.put("hashCode", Integer.valueOf(iX));
            }
            this.vk.apply(com.byazt.xi.hw.pr().pr(16).pr(Void.class).pr(0, map).hw());
        }
    }

    public com.byazt.wr.pr hw(int i) {
        if (hn(i)) {
            return new com.byazt.wr.c();
        }
        if (this.zo) {
            return new com.byazt.wr.x();
        }
        return new com.byazt.wr.hw();
    }

    public void hn(final Map<String, Object> map) {
        switch (this.m) {
            case 1:
                com.byazt.qd.pr.x(hn(), 2);
                com.byazt.ri.c.pr(a.getContext(), hw(), "uchain_1");
                com.byazt.lx.hw.pr(this.hw, com.byazt.wb.hw.x);
                break;
            case 2:
                com.byazt.xlm.c.hw(new com.byazt.xlm.fw("tt_download_check") { // from class: com.byazt.ye.pr.4
                    @Override // java.lang.Runnable
                    public void run() {
                        com.byazt.hg.x xVarPr = a.pr().pr(pr.this.hw(), pr.this.uc);
                        if (xVarPr == null || !xVarPr.fw()) {
                            com.byazt.qd.pr.x(pr.this.hn(), 2);
                            com.byazt.lx.hw.pr(pr.this.hw, com.byazt.wb.hw.x);
                            com.byazt.ri.c.pr(a.getContext(), pr.this.hw(), "uchain_2");
                        } else {
                            if (pr.this.w) {
                                pr.this.hw(xVarPr, (Map<String, Object>) map);
                            }
                            pr.this.pr(xVarPr, (Map<String, Object>) map);
                        }
                    }
                });
                break;
            default:
                pr((com.byazt.hg.x) null, map);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(com.byazt.hg.x xVar, Map<String, Object> map) {
        pr(hn(xVar, map), map);
    }

    public void hw(boolean z) {
        this.fw = z;
    }

    public static int x(Map<String, Object> map) {
        if (map != null) {
            Object obj = map.get("download_manager_hash_code");
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            return 0;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(com.byazt.hg.x xVar, Map<String, Object> map) {
        com.byazt.hg.uc ucVarPr = com.byazt.ri.c.pr(xVar.zo());
        com.byazt.hg.uc ucVarLb = this.pr.lb();
        if (ucVarLb == null) {
            hw().pr(ucVarPr);
        } else {
            if (ucVarPr != null) {
                ucVarLb.vk(ucVarPr.g());
                ucVarLb.hw(ucVarPr.c());
                ucVarLb.x(ucVarPr.fw());
                ucVarLb.hw(ucVarPr.k());
                ucVarLb.c(ucVarPr.zo());
                ucVarLb.aj(ucVarPr.m());
                ucVarLb.hn(ucVarPr.uc());
                ucVarLb.uc(ucVarPr.aj());
                ucVarLb.fw(ucVarPr.vk());
                ucVarLb.zo(ucVarPr.w());
            }
            ucVarPr = ucVarLb;
        }
        if (ucVarPr != null) {
            pr(ucVarPr.uc(), ucVarPr.g(), ucVarPr.m(), map);
        }
    }

    private void pr(String str, String str2, String str3, Map<String, Object> map) {
        if (this.vk == null) {
            return;
        }
        this.vk.apply(com.byazt.xi.hw.pr().pr(24).pr(Boolean.class).pr(0, new ww().pr("appIcon", str).pr("appName", str2).pr("hashCode", Integer.valueOf(x(map))).pr(BillingClientConstants.PACKAGE_NAME, str3)).hw());
    }

    private com.byazt.qp.pr hn(final com.byazt.hg.x xVar, final Map<String, Object> map) {
        return new com.byazt.qp.pr() { // from class: com.byazt.ye.pr.5
            @Override // com.byazt.zv.IDownloadButtonClickListener
            public void handleComplianceDialog(boolean z) {
                if (!z || !pr.this.pr(xVar, (com.byazt.qp.pr) null, map)) {
                    pr.this.pr((com.byazt.qp.pr) null, map);
                }
            }

            @Override // com.byazt.zv.IDownloadButtonClickListener
            public void handleMarketFailedComplianceDialog() {
            }
        };
    }

    public of hw() {
        return com.byazt.lx.hw.pr(this.pr, this.hw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String hn() {
        if (hw() == null) {
            return null;
        }
        return hw().z();
    }
}
