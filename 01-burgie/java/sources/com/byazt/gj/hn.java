package com.byazt.gj;

import android.text.TextUtils;
import com.byazt.sd.a;
import com.byazt.sd.fo;
import com.byazt.zn.c;
import com.byazt.zn.fw;
import com.byazt.zn.uc;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 504, 20})
public class hn {
    public fw pr = new fw();
    public int hn = 3;
    public final fo hw = a.pr();

    public void pr(final c cVar, final com.byazt.vx.hw<uc, fw> hwVar) {
        if (this.hw == null || cVar == null) {
            return;
        }
        this.pr.hw(false);
        this.hw.pr(cVar.x(), cVar.c(), this.hn, new fo.hw() { // from class: com.byazt.gj.hn.1
            @Override // com.byazt.sd.fo.hw
            public void pr(int i, String str, com.byazt.hg.hw hwVar2) {
                hn.this.pr.hw(i);
                hn.this.pr.hn(hwVar2 != null ? hwVar2.hn() : 0);
                if (TextUtils.isEmpty(str)) {
                    str = "load ad error";
                }
                hn.this.pr.pr(str);
                hwVar.pr(hn.this.pr);
            }

            @Override // com.byazt.sd.fo.hw
            public void pr(com.byazt.hg.pr prVar, com.byazt.hg.hw hwVar2) {
                if (prVar == null || prVar.hw() == null) {
                    hn.this.pr.hw(1);
                    hn.this.pr.pr("no ad or material");
                    hwVar.pr(hn.this.pr);
                    return;
                }
                uc ucVar = new uc(prVar, false);
                ucVar.hw(hwVar2.aj());
                ucVar.hn(hwVar2.vk());
                ucVar.x(hwVar2.w());
                ucVar.c(hwVar2.k());
                ucVar.pr(cVar.pr());
                ucVar.pr(cVar.hn());
                hwVar.hw(ucVar);
            }
        });
    }
}
