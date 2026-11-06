package com.byazt.rcj;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.gct.pk;
import com.byazt.llp.rv;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 104, 5})
public class q extends n {
    public final boolean d;

    public q(rv rvVar, Context context, String str, com.byazt.wif.s sVar, String str2, boolean z, Map<String, Object> map, boolean z2) {
        this.n = rvVar;
        this.s = context;
        this.q = str;
        this.l = sVar;
        this.w = str2;
        this.cp = z;
        this.qg = map;
        this.d = z2;
    }

    @Override // com.byazt.rcj.n
    public com.byazt.myr.n l(final Map<String, Object> map) {
        final int iQ = n.q(map);
        com.byazt.esa.s.n(this.q, this.q, this.n.A_(), iQ);
        map.put("action_type_button", 2);
        if (this.n != null && !TextUtils.isEmpty(this.n.q())) {
            map.put("id", Long.valueOf(Double.valueOf(this.n.q()).longValue()));
        }
        if (!s(iQ)) {
            s(map);
            return null;
        }
        com.byazt.myr.n nVar = new com.byazt.myr.n() { // from class: com.byazt.rcj.q.1
            @Override // com.byazt.ky.IDownloadButtonClickListener
            public void handleComplianceDialog(boolean z) {
            }

            @Override // com.byazt.ky.IDownloadButtonClickListener
            public void handleMarketFailedComplianceDialog() {
                if (map == null) {
                    return;
                }
                com.byazt.esa.s.n(0, iQ);
                q.this.l.n(q.this.qg(iQ));
                map.remove("downloadButtonClickListener");
                if (q.this.n((com.byazt.gct.q) null, (com.byazt.myr.n) null, map)) {
                    return;
                }
                q.this.s(map);
            }
        };
        com.byazt.esa.s.n(map, nVar);
        return nVar;
    }

    @Override // com.byazt.rcj.n
    public boolean s(int i) {
        return this.tj != null && com.byazt.esa.s.n(this.tj, i) == 2;
    }

    @Override // com.byazt.rcj.n
    public com.byazt.myr.q n(Map<String, Object> map, final com.byazt.ikv.s<String, Object> sVar) {
        final int iQ = n.q(sVar);
        return new com.byazt.myr.q() { // from class: com.byazt.rcj.q.2
            @Override // com.byazt.myr.q
            public void onItemClick() {
                if (!q.this.fs && !q.this.n.G_()) {
                    if (q.this.d) {
                        com.byazt.ukb.qg.n(q.this.qg(), q.this.s, q.this.q, (Map<String, Object>) null, (com.byazt.xvf.l) null);
                        return;
                    } else {
                        if (q.this.n instanceof pk) {
                            new com.byazt.xwj.n((pk) q.this.n, q.this.s, q.this.q, com.byazt.vgx.w.q(q.this.q), new HashMap(), null, null).n(new HashMap());
                            return;
                        }
                        return;
                    }
                }
                com.byazt.esa.s.qg(1, iQ);
                sVar.remove("itemClickListener");
                q.this.tj.apply(com.byazt.of.qg.n().n(17).n(Void.class).n(0, sVar).qg());
            }
        };
    }
}
