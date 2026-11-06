package com.byazt.za;

import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE, 19})
public abstract class n {
    public void n(View view, float f, float f2) {
    }

    public void n(View view, int i) {
    }

    public void n(View view, String str, int i) {
    }

    public void qg(View view, int i) {
    }

    public static n n(final com.byazt.fvm.sz szVar, final com.byazt.fx.qg qgVar) {
        return new n() { // from class: com.byazt.za.n.1
            @Override // com.byazt.za.n
            public void n(View view, int i) {
                com.byazt.fvm.sz szVar2 = szVar;
                if (szVar2 != null) {
                    com.byazt.de.qg.s(szVar2.tj());
                }
                com.byazt.fx.qg qgVar2 = qgVar;
                if (qgVar2 != null) {
                    qgVar2.n(view, i);
                }
            }

            @Override // com.byazt.za.n
            public void qg(View view, int i) {
                com.byazt.fvm.sz szVar2 = szVar;
                if (szVar2 != null) {
                    com.byazt.de.qg.n(szVar2.tj(), false);
                }
                com.byazt.fx.qg qgVar2 = qgVar;
                if (qgVar2 != null) {
                    qgVar2.qg(view, i);
                }
            }

            @Override // com.byazt.za.n
            public void n(View view, String str, int i) {
                com.byazt.fx.qg qgVar2 = qgVar;
                if (qgVar2 != null) {
                    qgVar2.n(view, str, i);
                }
            }

            @Override // com.byazt.za.n
            public void n(View view, float f, float f2) {
                com.byazt.fx.qg qgVar2 = qgVar;
                if (qgVar2 != null) {
                    qgVar2.n(view, f, f2);
                }
            }
        };
    }

    public static n n(final com.byazt.fvm.sz szVar, final com.byazt.fx.n nVar) {
        return new n() { // from class: com.byazt.za.n.2
            @Override // com.byazt.za.n
            public void n(View view, int i) {
                com.byazt.fvm.sz szVar2 = szVar;
                if (szVar2 != null) {
                    com.byazt.de.qg.s(szVar2.tj());
                }
                com.byazt.fx.n nVar2 = nVar;
                if (nVar2 != null) {
                    nVar2.n(view, i);
                }
            }

            @Override // com.byazt.za.n
            public void qg(View view, int i) {
                com.byazt.fvm.sz szVar2 = szVar;
                if (szVar2 != null) {
                    com.byazt.de.qg.n(szVar2.tj(), false);
                }
                com.byazt.fx.n nVar2 = nVar;
                if (nVar2 != null) {
                    nVar2.qg(view, i);
                }
            }

            @Override // com.byazt.za.n
            public void n(View view, String str, int i) {
                com.byazt.fx.n nVar2 = nVar;
                if (nVar2 != null) {
                    nVar2.n(view, str, i);
                }
            }

            @Override // com.byazt.za.n
            public void n(View view, float f, float f2) {
                com.byazt.fx.n nVar2 = nVar;
                if (nVar2 != null) {
                    nVar2.n(view, f, f2);
                }
            }
        };
    }
}
