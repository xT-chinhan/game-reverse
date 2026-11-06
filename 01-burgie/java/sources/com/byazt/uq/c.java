package com.byazt.uq;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.hg.b;
import com.byazt.hg.bh;
import com.byazt.hg.of;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 209, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public com.byazt.tg.hn hn;
    public com.byazt.tg.hw hw;
    public of pr;

    public c(of ofVar, pr prVar) {
        this.pr = ofVar;
        this.hw = new com.byazt.tg.hw(ofVar, prVar);
        this.hn = new com.byazt.tg.hn(this.pr, prVar);
        if (ofVar != null && b.pr(ofVar)) {
            com.byazt.qd.uc.pr(ofVar, String.valueOf(ls.m(ofVar)), ls.k(ofVar), b.hw(ofVar) ? 1 : 2, com.byazt.ewt.fw.pr(ofVar));
            final int iC = b.c(this.pr);
            com.byazt.qd.uc.pr().pr(com.byazt.ewt.fw.pr(ofVar), new com.byazt.ewt.x.pr() { // from class: com.byazt.uq.c.1
                @Override // com.byazt.ewt.x.pr
                public void pr(com.byazt.ewt.hw hwVar) {
                    if (hwVar instanceof com.byazt.pv.zo) {
                        ((com.byazt.pv.zo) hwVar).hn = iC;
                    }
                }
            });
            com.byazt.qd.hw.pr().pr(com.byazt.ewt.fw.pr(ofVar), new com.byazt.ewt.x.pr() { // from class: com.byazt.uq.c.2
                @Override // com.byazt.ewt.x.pr
                public void pr(com.byazt.ewt.hw hwVar) {
                    if (hwVar instanceof com.byazt.pv.hn) {
                        ((com.byazt.pv.hn) hwVar).w = iC;
                    }
                }
            });
        }
    }

    public c(of ofVar, pr prVar, com.byazt.qe.hw hwVar, Context context) {
        this(ofVar, prVar);
        this.hw.pr(hwVar);
        this.hw.pr(context);
    }

    public void pr(final ViewGroup viewGroup, final View view) {
        if (viewGroup == null) {
            return;
        }
        viewGroup.post(new Runnable() { // from class: com.byazt.uq.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.x(viewGroup, view);
                if (b.hw(c.this.pr)) {
                    c.this.hw(viewGroup, view);
                } else if (b.x(c.this.pr)) {
                    c.this.hn(viewGroup, view);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(ViewGroup viewGroup, View view) {
        boolean zK = b.k(this.pr);
        final bh bhVarPr = pr(zK);
        if (bhVarPr == null) {
            return;
        }
        if (zK) {
            this.hw.pr(bhVarPr);
        }
        com.byazt.qd.uc.pr().pr(com.byazt.ewt.fw.pr(this.pr), new com.byazt.ewt.x.pr() { // from class: com.byazt.uq.c.4
            @Override // com.byazt.ewt.x.pr
            public void pr(com.byazt.ewt.hw hwVar) {
                if (hwVar instanceof com.byazt.pv.zo) {
                    com.byazt.pv.zo zoVar = (com.byazt.pv.zo) hwVar;
                    zoVar.hw = bhVarPr.c();
                    zoVar.c = bhVarPr.x();
                }
            }
        });
        com.byazt.qd.hw.pr().pr(com.byazt.ewt.fw.pr(this.pr), new com.byazt.ewt.x.pr() { // from class: com.byazt.uq.c.5
            @Override // com.byazt.ewt.x.pr
            public void pr(com.byazt.ewt.hw hwVar) {
                if (hwVar instanceof com.byazt.pv.hn) {
                    ((com.byazt.pv.hn) hwVar).vk = bhVarPr.c();
                }
            }
        });
        com.byazt.qd.uc.hw(com.byazt.ewt.fw.pr(this.pr));
        hn.pr(this.pr, bhVarPr);
        if (zK) {
            pr(bhVarPr);
        }
        boolean z = bhVarPr.x() == 0;
        com.byazt.tg.hw hwVar = this.hw;
        if (z) {
            view = viewGroup;
        }
        hwVar.hw(viewGroup, view);
    }

    private bh pr(boolean z) {
        if (!z) {
            return b.aj(this.pr);
        }
        bh bhVarPr = vk.pr().pr(this.pr);
        if (bhVarPr != null) {
            return bhVarPr;
        }
        List<bh> listVk = b.vk(this.pr);
        if (listVk.isEmpty()) {
            return null;
        }
        return listVk.get(0);
    }

    private void pr(bh bhVar) {
        final String strC = bhVar.c();
        final int iC = b.c(this.pr);
        this.hw.pr(new Runnable() { // from class: com.byazt.uq.c.6
            @Override // java.lang.Runnable
            public void run() {
                vk.pr().pr(iC, strC);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hn(ViewGroup viewGroup, View view) {
        final b.pr prVarZo = b.zo(this.pr);
        if (prVarZo == null) {
            return;
        }
        com.byazt.qd.uc.pr().pr(com.byazt.ewt.fw.pr(this.pr), new com.byazt.ewt.x.pr() { // from class: com.byazt.uq.c.7
            @Override // com.byazt.ewt.x.pr
            public void pr(com.byazt.ewt.hw hwVar) {
                if (hwVar instanceof com.byazt.pv.zo) {
                    com.byazt.pv.zo zoVar = (com.byazt.pv.zo) hwVar;
                    zoVar.hw = prVarZo.c();
                    zoVar.c = prVarZo.x();
                }
            }
        });
        com.byazt.qd.hw.pr().pr(com.byazt.ewt.fw.pr(this.pr), new com.byazt.ewt.x.pr() { // from class: com.byazt.uq.c.8
            @Override // com.byazt.ewt.x.pr
            public void pr(com.byazt.ewt.hw hwVar) {
                if (hwVar instanceof com.byazt.pv.hn) {
                    ((com.byazt.pv.hn) hwVar).vk = prVarZo.c();
                }
            }
        });
        com.byazt.qd.uc.hw(com.byazt.ewt.fw.pr(this.pr));
        hn.pr(this.pr, prVarZo);
        boolean z = prVarZo.x() == 0;
        com.byazt.tg.hn hnVar = this.hn;
        if (z) {
            view = viewGroup;
        }
        hnVar.hw(viewGroup, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(ViewGroup viewGroup, View view) {
        if (viewGroup != null) {
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if ("easy_play_tag".equals(childAt.getTag())) {
                    viewGroup.removeView(childAt);
                }
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup2.getChildCount(); i2++) {
                View childAt2 = viewGroup2.getChildAt(i2);
                if ("easy_play_tag".equals(childAt2.getTag())) {
                    viewGroup2.removeView(childAt2);
                }
            }
        }
    }

    public fw pr() {
        if (b.hw(this.pr)) {
            return this.hw.pr();
        }
        if (b.x(this.pr)) {
            return this.hn.pr();
        }
        return new fw() { // from class: com.byazt.uq.c.9
            @Override // com.byazt.uq.fw
            public void pr() {
            }

            @Override // com.byazt.uq.fw
            public void pr(boolean z) {
            }

            @Override // com.byazt.uq.fw
            public void hw() {
            }

            @Override // com.byazt.uq.fw
            public void hn() {
            }

            @Override // com.byazt.uq.fw
            public void x() {
            }

            @Override // com.byazt.uq.fw
            public void c() {
            }

            @Override // com.byazt.uq.fw
            public void pr(int i) {
            }
        };
    }

    public void pr(com.byazt.ti.hw hwVar) {
        com.byazt.tg.hn hnVar = this.hn;
        if (hnVar != null) {
            hnVar.pr(hwVar);
        }
        com.byazt.tg.hw hwVar2 = this.hw;
        if (hwVar2 != null) {
            hwVar2.pr(hwVar);
        }
    }

    public void hw() {
        com.byazt.tg.hw hwVar = this.hw;
        if (hwVar != null) {
            hwVar.uc();
        }
        com.byazt.tg.hn hnVar = this.hn;
        if (hnVar != null) {
            hnVar.x();
        }
    }
}
