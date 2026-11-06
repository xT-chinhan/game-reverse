package com.byazt.qx;

import android.content.Context;
import com.byazt.hg.of;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 49, 110})
public class z extends fo {
    public z(Context context, of ofVar, com.byazt.qe.hw hwVar, int i) {
        super(context, ofVar, hwVar, i);
    }

    @Override // com.byazt.qx.fo
    public void pr(Context context, of ofVar, com.byazt.qe.hw hwVar) {
        this.pr = new NativeExpressVideoView(context, ofVar, hwVar, com.byazt.pfl.hw.AD_TAG_FEED);
        pr(this.pr, this.hn);
    }

    @Override // com.byazt.qx.hw, com.byazt.mr.g
    public void pr(final com.byazt.qh.hn hnVar) {
        if (this.pr != null) {
            this.pr.setVideoAdListener(new com.byazt.w.hn.x() { // from class: com.byazt.qx.z.1
                @Override // com.byazt.w.hn.x
                public void O_() {
                    com.byazt.qh.hn hnVar2 = hnVar;
                    if (hnVar2 != null) {
                        hnVar2.pr();
                    }
                }

                @Override // com.byazt.w.hn.x
                public void a_(int i, int i2) {
                    com.byazt.qh.hn hnVar2 = hnVar;
                    if (hnVar2 != null) {
                        hnVar2.pr(i, i2);
                    }
                }
            });
            this.pr.setVideoAdInteractionListener(new com.byazt.w.hn.InterfaceC0220hn() { // from class: com.byazt.qx.z.2
                @Override // com.byazt.w.hn.InterfaceC0220hn
                public void m_() {
                    com.byazt.qh.hn hnVar2 = hnVar;
                    if (hnVar2 != null) {
                        hnVar2.hw();
                    }
                }

                @Override // com.byazt.w.hn.InterfaceC0220hn
                public void n_() {
                    com.byazt.qh.hn hnVar2 = hnVar;
                    if (hnVar2 != null) {
                        hnVar2.hn();
                    }
                }

                @Override // com.byazt.w.hn.InterfaceC0220hn
                public void o_() {
                    com.byazt.qh.hn hnVar2 = hnVar;
                    if (hnVar2 != null) {
                        hnVar2.x();
                    }
                }

                @Override // com.byazt.w.hn.InterfaceC0220hn
                public void pr(long j, long j2) {
                    com.byazt.qh.hn hnVar2 = hnVar;
                    if (hnVar2 != null) {
                        hnVar2.pr(j, j2);
                    }
                }

                @Override // com.byazt.w.hn.InterfaceC0220hn
                public void p_() {
                    com.byazt.qh.hn hnVar2 = hnVar;
                    if (hnVar2 != null) {
                        hnVar2.c();
                    }
                }
            });
        }
    }

    @Override // com.byazt.qx.hw
    public com.byazt.mm.pr k() {
        if (this.c != null && this.c.get() != null) {
            return this.c.get().getVideoModel();
        }
        if (this.pr instanceof NativeExpressVideoView) {
            ((NativeExpressVideoView) this.pr).g();
            return ((NativeExpressVideoView) this.pr).getVideoModel();
        }
        return null;
    }
}
