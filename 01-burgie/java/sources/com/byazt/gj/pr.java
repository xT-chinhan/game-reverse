package com.byazt.gj;

import com.byazt.hg.of;
import com.byazt.ks.c;
import com.byazt.sd.a;
import com.byazt.sd.fo;
import com.byazt.zn.fw;
import com.byazt.zn.uc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 504, 37})
public class pr {
    public boolean c;
    public c fw;
    public com.byazt.qe.hw hn;
    public String hw;
    public com.byazt.ks.pr pr;
    public fw x = new fw();
    public com.byazt.xe.pr uc = new com.byazt.xe.pr(4);

    public pr(com.byazt.ks.pr prVar) {
        this.pr = prVar;
        prVar.hw();
        this.c = a.hw().eh();
    }

    public void pr(com.byazt.zn.c cVar, com.byazt.vx.hw<uc, fw> hwVar) {
        if (cVar == null || hwVar == null) {
            return;
        }
        this.x.hw(true);
        this.hn = cVar.x();
        this.hw = cVar.uc();
        this.fw = cVar.fw();
        if (com.byazt.vx.c.pr(this.hn, cVar.c())) {
            this.x.hw(1);
            this.x.pr("no cache");
            hwVar.pr(this.x);
            return;
        }
        pr(this.hw, hwVar);
    }

    private void pr(final String str, final com.byazt.vx.hw<uc, fw> hwVar) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        this.pr.pr(this.x, str, new com.byazt.ks.pr.InterfaceC0116pr() { // from class: com.byazt.gj.pr.1
            @Override // com.byazt.ks.pr.InterfaceC0116pr
            public void pr(final uc ucVar) {
                com.byazt.nz.pr.pr("lqmt", "缓存读取总耗时： " + (System.currentTimeMillis() - jCurrentTimeMillis));
                if (hwVar == null) {
                    return;
                }
                if (ucVar == null || ucVar.hw() == null) {
                    if (ucVar == null) {
                        pr.this.x.hw(1);
                        pr.this.x.pr("no ad model cache");
                        hwVar.pr(pr.this.x);
                        return;
                    } else if (ucVar.hw() == null) {
                        pr.this.x.hw(1);
                        pr.this.x.pr("no splash material");
                        hwVar.pr(pr.this.x);
                        return;
                    }
                }
                of ofVarHw = ucVar.hw();
                pr.this.uc.pr(jCurrentTimeMillis);
                pr.this.uc.hw(System.currentTimeMillis());
                ArrayList arrayList = new ArrayList();
                arrayList.add(ofVarHw);
                pr.this.uc.pr(arrayList, new com.byazt.xe.uc() { // from class: com.byazt.gj.pr.1.1
                    @Override // com.byazt.xe.uc
                    public void pr(List<of> list) {
                        if (pr.this.c) {
                            pr.this.pr(ucVar, (com.byazt.vx.hw<uc, fw>) hwVar);
                        } else {
                            hwVar.hw(ucVar);
                        }
                    }

                    @Override // com.byazt.xe.uc
                    public void hw(List<of> list) {
                        if (list == null || list.isEmpty()) {
                            pr.this.x.hw(22);
                            pr.this.x.pr("check server cache unavailable");
                            hwVar.pr(pr.this.x);
                            return;
                        }
                        hwVar.hw(ucVar);
                    }

                    @Override // com.byazt.xe.uc
                    public void hn(List<of> list) {
                        Iterator<of> it = list.iterator();
                        while (it.hasNext()) {
                            pr.this.pr.pr(str, it.next());
                        }
                    }
                });
            }

            @Override // com.byazt.ks.pr.InterfaceC0116pr
            public void pr() {
                com.byazt.nz.pr.pr("lqmt", "缓存读取失败");
                com.byazt.vx.hw hwVar2 = hwVar;
                if (hwVar2 != null) {
                    hwVar2.pr(pr.this.x);
                }
            }
        }, this.fw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(final uc ucVar, final com.byazt.vx.hw<uc, fw> hwVar) {
        if (hwVar == null) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        of ofVarHw = ucVar.hw();
        a.pr().pr(ofVarHw.x(), ofVarHw.B_(), new fo.pr() { // from class: com.byazt.gj.pr.2
            @Override // com.byazt.sd.fo.pr
            public void pr(boolean z, long j, long j2) {
                com.byazt.xk.hw.pr(pr.this.hn, j, j2, System.currentTimeMillis() - jCurrentTimeMillis, 4, 1, z ? 1 : 0);
                if (!z) {
                    pr.this.x.hw(22);
                    pr.this.x.pr("check server cache unavailable");
                    pr.this.x.pr(j);
                    hwVar.pr(pr.this.x);
                    return;
                }
                hwVar.hw(ucVar);
            }
        });
    }
}
