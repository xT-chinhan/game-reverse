package com.byazt.dr;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.hg.o;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.hg.vk;
import com.byazt.ihe.m;
import com.byazt.jx.zo;
import com.byazt.pg.FullRewardExpressView;
import com.byazt.qx.NativeExpressView;
import com.byazt.qx.b;
import com.byazt.qx.uc;
import com.byazt.wt.e;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import com.byazt.wt.ve;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1091, 13})
public class hw {
    public com.byazt.az.pr aj;
    public uc fw;
    public final String hn;
    public final boolean ho;
    public final of hw;
    public boolean k;
    public long m;
    public boolean nt;
    public final TTBaseVideoActivity pr;
    public int uc;
    public com.byazt.nv.hn vk;
    public ViewGroup w;
    public boolean x;
    public FullRewardExpressView yb;
    public com.byazt.qx.c zo;
    public final AtomicBoolean g = new AtomicBoolean(false);
    public boolean c = false;

    public hw(final TTBaseVideoActivity tTBaseVideoActivity, of ofVar, String str, boolean z, boolean z2) {
        this.vk = null;
        this.pr = tTBaseVideoActivity;
        this.hw = ofVar;
        this.hn = str;
        this.ho = z;
        this.nt = z2;
        uc ucVar = new uc(tTBaseVideoActivity, ofVar, str, ls.x(str)) { // from class: com.byazt.dr.hw.1
            @Override // com.byazt.qx.uc, com.byazt.az.hw, com.byazt.az.x
            public void pr(View view, vk vkVar) {
                super.pr(view, vkVar);
                tTBaseVideoActivity.pr(2);
            }
        };
        this.fw = ucVar;
        ((com.byazt.yx.pr) ucVar.pr(com.byazt.yx.pr.class)).pr(tTBaseVideoActivity.pr(ofVar));
        com.byazt.qx.c cVar = new com.byazt.qx.c(tTBaseVideoActivity, ofVar, str, ls.x(str)) { // from class: com.byazt.dr.hw.2
            @Override // com.byazt.qx.c, com.byazt.az.hw, com.byazt.az.x
            public void pr(View view, vk vkVar) {
                super.pr(view, vkVar);
                com.byazt.ln.hw hwVar = (com.byazt.ln.hw) this.zo.pr(com.byazt.ln.hw.class);
                if (hwVar == null || !hwVar.hw(view)) {
                    return;
                }
                tTBaseVideoActivity.pr(2);
            }
        };
        this.zo = cVar;
        ((com.byazt.yx.pr) cVar.pr(com.byazt.yx.pr.class)).pr(tTBaseVideoActivity.pr(ofVar));
        com.byazt.az.pr prVar = new com.byazt.az.pr(tTBaseVideoActivity, ofVar, str, 7);
        this.aj = prVar;
        tTBaseVideoActivity.pr((com.byazt.yx.hn) prVar.pr(com.byazt.yx.hn.class));
        ((com.byazt.yx.pr) this.aj.pr(com.byazt.yx.pr.class)).pr(tTBaseVideoActivity.pr(ofVar));
        if (ofVar.aj() == 4) {
            this.vk = zo.pr(tTBaseVideoActivity, ofVar, str);
            final String strX = pr().x();
            this.vk.pr(new com.byazt.nv.pr() { // from class: com.byazt.dr.hw.3
                @Override // com.byazt.nv.pr
                public void pr() {
                    com.byazt.dp.pr.pr(strX);
                }

                @Override // com.byazt.nv.pr
                public void pr(long j, long j2, String str2, String str3) {
                    com.byazt.dp.pr.pr(strX, j, j2);
                }

                @Override // com.byazt.nv.pr
                public void hw(long j, long j2, String str2, String str3) {
                    com.byazt.dp.pr.hw(strX, j, j2);
                }

                @Override // com.byazt.nv.pr
                public void hn(long j, long j2, String str2, String str3) {
                    com.byazt.dp.pr.hn(strX, j, j2);
                }

                @Override // com.byazt.nv.pr
                public void pr(long j, String str2, String str3) {
                    com.byazt.dp.pr.hw(strX);
                }

                @Override // com.byazt.nv.pr
                public void pr(String str2, String str3) {
                    com.byazt.dp.pr.hn(strX);
                }
            });
        }
    }

    public of pr() {
        return this.hw;
    }

    public String hw() {
        return this.hn;
    }

    public com.byazt.az.pr hn() {
        return this.aj;
    }

    public int x() {
        if (!o.vk(this.hw)) {
            return 1;
        }
        if (this.k) {
            int iHw = o.hw(this.hw) - this.uc;
            this.uc = o.hw(this.hw);
            return iHw;
        }
        if (this.uc >= o.hw(this.hw)) {
            return 0;
        }
        this.uc++;
        return 1;
    }

    public void pr(ViewGroup viewGroup, ViewGroup viewGroup2, FullRewardExpressView fullRewardExpressView) {
        this.w = viewGroup2;
        if (viewGroup == null || fullRewardExpressView == null || pr() == null) {
            return;
        }
        com.byazt.nv.hn hnVar = this.vk;
        if (hnVar != null) {
            hnVar.hw();
            if (fullRewardExpressView.getContext() != null && (fullRewardExpressView.getContext() instanceof Activity)) {
                this.vk.pr((Activity) fullRewardExpressView.getContext(), false);
            }
        }
        this.fw.pr(fullRewardExpressView);
        ((com.byazt.dl.pr) this.fw.pr(com.byazt.dl.pr.class)).pr(this.vk);
        fullRewardExpressView.setClickListener(this.fw);
        this.zo.pr(fullRewardExpressView);
        ((com.byazt.dl.pr) this.zo.pr(com.byazt.dl.pr.class)).pr(this.vk);
        fullRewardExpressView.setClickCreativeListener(this.zo);
        this.aj.pr(viewGroup);
        ((com.byazt.dl.pr) this.aj.pr(com.byazt.dl.pr.class)).pr(this.vk);
        ImageView imageView = new ImageView(this.pr);
        com.byazt.ub.hw.pr(this.hw.de().get(0)).pr(imageView);
        this.w.addView(imageView);
    }

    public com.byazt.ga.pr.InterfaceC0074pr c() {
        return new com.byazt.ga.pr.InterfaceC0074pr() { // from class: com.byazt.dr.hw.4
            @Override // com.byazt.ga.pr.InterfaceC0074pr
            public void pr() {
                hw.this.k = true;
            }

            @Override // com.byazt.ga.pr.InterfaceC0074pr
            public void pr(int i, String str) {
                hw.this.fw();
            }

            @Override // com.byazt.ga.pr.InterfaceC0074pr
            public void hw() {
                hw.this.fw();
            }

            @Override // com.byazt.ga.pr.InterfaceC0074pr
            public void pr(long j, long j2) {
                er.pr((View) hw.this.w, 8);
                hw.this.m = j;
            }

            @Override // com.byazt.ga.pr.InterfaceC0074pr
            public void hn() {
            }
        };
    }

    public void pr(boolean z) {
        this.x = z;
    }

    public boolean uc() {
        return this.x;
    }

    public void fw() {
        er.pr((View) this.w, 0);
        this.pr.g();
    }

    public void zo() {
        com.byazt.nv.hn hnVar = this.vk;
        if (hnVar != null) {
            hnVar.hn();
        }
        FullRewardExpressView fullRewardExpressView = this.yb;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.k();
        }
        of ofVar = this.hw;
        e.hw(ofVar != null ? ofVar.nl() : 0);
    }

    public void pr(NativeExpressView nativeExpressView) {
        if (!this.g.getAndSet(true)) {
            Map<String, Object> mapPr = this.pr.pr(this.hw);
            b.pr(mapPr, this.hw, nativeExpressView);
            com.byazt.pj.pr.pr(this.hw, this.hn, mapPr, this.pr.i());
            com.byazt.na.pr.pr().x();
            of ofVar = this.hw;
            e.pr(ofVar != null ? ofVar.nl() : 0);
        }
    }

    public void aj() {
        if (this.ho) {
            this.pr.pr(this.hw, this.aj);
        }
    }

    public com.byazt.n.uc vk() {
        com.byazt.n.uc ucVarPr = qv.pr(1, this.hw);
        ucVarPr.hw(this.hw.x());
        ucVarPr.hw(100);
        ucVarPr.hn(100);
        ucVarPr.hn(this.hw.B_());
        ucVarPr.hw(this.x);
        return ucVarPr;
    }

    public long w() {
        return this.m;
    }

    public void hw(boolean z) {
        this.hw.nt(z);
    }

    public void k() {
        if (this.nt) {
            return;
        }
        this.nt = true;
        of ofVar = this.hw;
        com.byazt.qe.hw hwVarPr = ve.pr(7, ofVar == null ? null : ofVar.yn());
        if (qv.ho(this.hw) != null) {
            com.byazt.n.uc ucVarPr = qv.pr(1, this.hw);
            ucVarPr.pr("material_meta", this.hw);
            ucVarPr.pr("ad_slot", Integer.valueOf(hwVarPr != null ? hwVarPr.a() : 0));
            com.byazt.it.hn.pr(ucVarPr, new com.byazt.ihe.vk.pr() { // from class: com.byazt.dr.hw.5
                @Override // com.byazt.ihe.vk.pr
                public void hw(m mVar, int i) {
                    mVar.ny();
                    mVar.fw();
                }

                @Override // com.byazt.ihe.vk.pr
                public void pr(m mVar, int i, String str) {
                    mVar.ny();
                    mVar.fw();
                }

                @Override // com.byazt.ihe.vk.pr
                public void pr(m mVar, int i) {
                }
            });
        }
    }

    public void pr(float f, float f2) {
        FullRewardExpressView fullRewardExpressView = new FullRewardExpressView(this.pr, pr(), ve.pr(7, String.valueOf(ls.m(pr())), f, f2, pr()), hw(), false, null);
        this.yb = fullRewardExpressView;
        fullRewardExpressView.getAdShowTime().pr(true);
        this.yb.setExpressInteractionListener(new com.byazt.qx.pr() { // from class: com.byazt.dr.hw.6
            @Override // com.byazt.qx.pr
            public void pr(View view, float f3, float f4) {
                hw.this.c = true;
            }
        });
        this.yb.nt();
    }

    public FullRewardExpressView hw(float f, float f2) {
        if (this.yb == null) {
            pr(f, f2);
        }
        return this.yb;
    }
}
