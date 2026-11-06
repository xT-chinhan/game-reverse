package com.byazt.qx;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 49, 37})
public abstract class pr {
    public void pr(View view, int i) {
    }

    public void hw(View view, int i) {
    }

    public void pr(View view, String str, int i) {
    }

    public void pr(View view, float f, float f2) {
    }

    public static pr pr(final com.byazt.mr.g gVar, final com.byazt.qh.hw hwVar) {
        return new pr() { // from class: com.byazt.qx.pr.1
            @Override // com.byazt.qx.pr
            public void pr(View view, int i) {
                com.byazt.mr.g gVar2 = gVar;
                if (gVar2 != null) {
                    com.byazt.qd.hw.hn(gVar2.vk());
                }
                com.byazt.qh.hw hwVar2 = hwVar;
                if (hwVar2 != null) {
                    hwVar2.pr(view, i);
                }
            }

            @Override // com.byazt.qx.pr
            public void hw(View view, int i) {
                com.byazt.mr.g gVar2 = gVar;
                if (gVar2 != null) {
                    com.byazt.qd.hw.pr(gVar2.vk(), false);
                }
                com.byazt.qh.hw hwVar2 = hwVar;
                if (hwVar2 != null) {
                    hwVar2.hw(view, i);
                }
            }

            @Override // com.byazt.qx.pr
            public void pr(View view, String str, int i) {
                com.byazt.qh.hw hwVar2 = hwVar;
                if (hwVar2 != null) {
                    hwVar2.pr(view, str, i);
                }
            }

            @Override // com.byazt.qx.pr
            public void pr(View view, float f, float f2) {
                com.byazt.qh.hw hwVar2 = hwVar;
                if (hwVar2 != null) {
                    hwVar2.pr(view, f, f2);
                }
            }
        };
    }

    public static pr pr(final com.byazt.mr.g gVar, final com.byazt.qh.pr prVar) {
        return new pr() { // from class: com.byazt.qx.pr.2
            @Override // com.byazt.qx.pr
            public void pr(View view, int i) {
                com.byazt.mr.g gVar2 = gVar;
                if (gVar2 != null) {
                    com.byazt.qd.hw.hn(gVar2.vk());
                }
                com.byazt.qh.pr prVar2 = prVar;
                if (prVar2 != null) {
                    prVar2.pr(view, i);
                }
            }

            @Override // com.byazt.qx.pr
            public void hw(View view, int i) {
                com.byazt.mr.g gVar2 = gVar;
                if (gVar2 != null) {
                    com.byazt.qd.hw.pr(gVar2.vk(), false);
                }
                com.byazt.qh.pr prVar2 = prVar;
                if (prVar2 != null) {
                    prVar2.hw(view, i);
                }
            }

            @Override // com.byazt.qx.pr
            public void pr(View view, String str, int i) {
                com.byazt.qh.pr prVar2 = prVar;
                if (prVar2 != null) {
                    prVar2.pr(view, str, i);
                }
            }

            @Override // com.byazt.qx.pr
            public void pr(View view, float f, float f2) {
                com.byazt.qh.pr prVar2 = prVar;
                if (prVar2 != null) {
                    prVar2.pr(view, f, f2);
                }
            }
        };
    }
}
