package com.byazt.ye;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.af.aj;
import com.byazt.hg.of;
import com.byazt.wt.ls;
import com.byazt.wt.ww;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 475, 121})
public class x extends pr {
    public final boolean k;

    public x(aj ajVar, Context context, String str, com.byazt.wr.hn hnVar, String str2, boolean z, Map<String, Object> map, boolean z2) {
        this.pr = ajVar;
        this.hn = context;
        this.x = str;
        this.c = hnVar;
        this.uc = str2;
        this.w = z;
        this.hw = map;
        this.k = z2;
    }

    @Override // com.byazt.ye.pr
    public com.byazt.qp.pr c(final Map<String, Object> map) {
        final int iX = pr.x(map);
        com.byazt.vo.hn.pr(this.x, this.x, this.pr.v_(), iX);
        map.put("action_type_button", 2);
        if (this.pr != null && !TextUtils.isEmpty(this.pr.x())) {
            map.put("id", Long.valueOf(Double.valueOf(this.pr.x()).longValue()));
        }
        if (!hn(iX)) {
            hn(map);
            return null;
        }
        com.byazt.qp.pr prVar = new com.byazt.qp.pr() { // from class: com.byazt.ye.x.1
            @Override // com.byazt.zv.IDownloadButtonClickListener
            public void handleComplianceDialog(boolean z) {
            }

            @Override // com.byazt.zv.IDownloadButtonClickListener
            public void handleMarketFailedComplianceDialog() {
                if (map == null) {
                    return;
                }
                com.byazt.vo.hn.pr(0, iX);
                x.this.c.pr(x.this.hw(iX));
                map.remove("downloadButtonClickListener");
                if (x.this.pr((com.byazt.hg.x) null, (com.byazt.qp.pr) null, map)) {
                    return;
                }
                x.this.hn(map);
            }
        };
        com.byazt.vo.hn.pr(map, prVar);
        return prVar;
    }

    @Override // com.byazt.ye.pr
    public boolean hn(int i) {
        return this.vk != null && com.byazt.vo.hn.pr(this.vk, i) == 2;
    }

    @Override // com.byazt.ye.pr
    public com.byazt.qp.x pr(Map<String, Object> map, final ww<String, Object> wwVar) {
        final int iX = pr.x(wwVar);
        return new com.byazt.qp.x() { // from class: com.byazt.ye.x.2
            @Override // com.byazt.qp.x
            public void onItemClick() {
                if (!x.this.zo && !x.this.pr.C_()) {
                    if (x.this.k) {
                        com.byazt.lx.hw.pr(x.this.hw(), x.this.hn, x.this.x, (Map<String, Object>) null, (com.byazt.kr.c) null);
                        return;
                    } else {
                        if (x.this.pr instanceof of) {
                            new com.byazt.ov.pr((of) x.this.pr, x.this.hn, x.this.x, ls.x(x.this.x), new HashMap(), null, null).pr(new HashMap());
                            return;
                        }
                        return;
                    }
                }
                com.byazt.vo.hn.hw(1, iX);
                wwVar.remove("itemClickListener");
                x.this.vk.apply(com.byazt.xi.hw.pr().pr(17).pr(Void.class).pr(0, wwVar).hw());
            }
        };
    }
}
