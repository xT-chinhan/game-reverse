package com.byazt.cy;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv extends com.byazt.suf.n {
    public final com.byazt.sg.s n;

    @Override // com.byazt.suf.n
    public void n(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.byazt.he.q qVar) {
    }

    public rv(com.byazt.sg.s sVar) {
        this.n = sVar;
    }

    @Override // com.byazt.suf.n
    public String n() {
        com.byazt.sg.s sVar = this.n;
        if (sVar != null) {
            return sVar.ca();
        }
        return null;
    }

    @Override // com.byazt.suf.n
    public String qg() {
        com.byazt.sg.s sVar = this.n;
        if (sVar != null) {
            return sVar.tr();
        }
        return null;
    }

    @Override // com.byazt.suf.n
    public String s() {
        com.byazt.sg.s sVar = this.n;
        if (sVar != null) {
            return sVar.eq();
        }
        return null;
    }

    @Override // com.byazt.suf.n
    public String q() {
        com.byazt.sg.s sVar = this.n;
        if (sVar != null) {
            return sVar.ox();
        }
        return null;
    }

    @Override // com.byazt.suf.n
    public String l() {
        com.byazt.sg.s sVar = this.n;
        if (sVar != null) {
            return sVar.lg();
        }
        return null;
    }

    @Override // com.byazt.suf.n
    public double w() {
        com.byazt.sg.s sVar = this.n;
        if (sVar != null) {
            return sVar.iz();
        }
        return 0.0d;
    }

    @Override // com.byazt.suf.n
    public List<String> x() {
        com.byazt.sg.s sVar = this.n;
        if (sVar != null) {
            return sVar.qh();
        }
        return null;
    }

    @Override // com.byazt.suf.n
    public String fs() {
        com.byazt.sg.s sVar = this.n;
        if (sVar != null) {
            return sVar.of();
        }
        return null;
    }

    @Override // com.byazt.suf.n
    public int rv() {
        com.byazt.sg.s sVar = this.n;
        if (sVar != null) {
            return sVar.dn();
        }
        return -1;
    }

    @Override // com.byazt.suf.n
    public int tj() {
        com.byazt.sg.s sVar = this.n;
        if (sVar != null) {
            return sVar.z();
        }
        return -1;
    }

    @Override // com.byazt.suf.n
    public com.byazt.suf.q cp() {
        com.byazt.sg.s sVar = this.n;
        if (sVar == null || !sVar.vb()) {
            return null;
        }
        com.byazt.fz.n nVar = new com.byazt.fz.n();
        nVar.q(this.n.fl());
        nVar.l(this.n.i());
        nVar.n(this.n.dw());
        nVar.w(this.n.su());
        nVar.x(this.n.ha());
        nVar.fs(this.n.g());
        nVar.n(this.n.ry());
        nVar.qg(this.n.ju());
        nVar.s(this.n.sh());
        nVar.n(this.n.pk());
        nVar.qg(this.n.wo());
        return new com.byazt.zj.qg(nVar);
    }

    @Override // com.byazt.suf.n
    public boolean d() {
        com.byazt.sg.s sVar = this.n;
        if (sVar != null) {
            return sVar.a();
        }
        return false;
    }

    @Override // com.byazt.suf.n
    public com.byazt.suf.s n(Activity activity) {
        if (activity == null || this.n == null) {
            return null;
        }
        return new com.byazt.zj.n(n(activity, this.n));
    }

    @Override // com.byazt.suf.n
    public com.byazt.suf.s n(Activity activity, Map<String, Object> map) {
        if (activity == null || map == null || this.n == null) {
            return null;
        }
        return new com.byazt.zj.n(n(activity, this.n));
    }

    private com.byazt.jp.qg n(Activity activity, com.byazt.sg.s sVar) {
        final com.byazt.fvm.x xVarN = sVar.n(activity);
        return new com.byazt.jp.qg() { // from class: com.byazt.cy.rv.1
            @Override // com.byazt.jp.qg
            public void n() {
                com.byazt.fvm.x xVar = xVarN;
                if (xVar != null) {
                    xVar.n();
                }
            }

            @Override // com.byazt.jp.qg
            public void n(final com.byazt.jp.x xVar) {
                com.byazt.fvm.x xVar2 = xVarN;
                if (xVar2 != null) {
                    xVar2.n(new com.byazt.lr.n(null) { // from class: com.byazt.cy.rv.1.1
                        @Override // com.byazt.lr.n
                        public void n() {
                            com.byazt.jp.x xVar3 = xVar;
                            if (xVar3 != null) {
                                xVar3.qg();
                            }
                        }

                        @Override // com.byazt.lr.n
                        public void n(int i, String str, boolean z) {
                            com.byazt.jp.x xVar3 = xVar;
                            if (xVar3 != null) {
                                xVar3.n(i, str);
                            }
                        }

                        @Override // com.byazt.lr.n
                        public void qg() {
                            com.byazt.jp.x xVar3 = xVar;
                            if (xVar3 != null) {
                                xVar3.n();
                            }
                        }
                    });
                }
            }
        };
    }

    @Override // com.byazt.suf.n
    public void n(Activity activity, com.byazt.lr.n nVar) {
        com.byazt.sg.s sVar = this.n;
        if (sVar != null) {
            sVar.n(activity, nVar);
        }
    }

    @Override // com.byazt.suf.n
    public void n(Dialog dialog, Integer[] numArr) {
        com.byazt.sg.s sVar = this.n;
        if (sVar != null) {
            sVar.n(dialog, numArr);
        }
    }

    @Override // com.byazt.suf.n
    public com.byazt.fvm.x qg(Activity activity) {
        com.byazt.sg.s sVar = this.n;
        if (sVar != null) {
            return sVar.n(activity);
        }
        return null;
    }

    @Override // com.byazt.suf.n
    public com.byazt.fvm.x qg(Dialog dialog, Integer[] numArr) {
        com.byazt.sg.s sVar = this.n;
        if (sVar != null) {
            return sVar.qg(dialog, numArr);
        }
        return null;
    }

    @Override // com.byazt.suf.n
    public com.byazt.fvm.q oa() {
        com.byazt.sg.s sVar = this.n;
        if (sVar != null) {
            return sVar.qd();
        }
        return null;
    }
}
