package com.byazt.xm;

import android.app.Activity;
import com.byazt.fvm.cp;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_POSITION_UPDATE_INTERVAL, 19})
public class n extends cp {
    public com.byazt.np.fs n;
    public com.byazt.rzx.n qg;

    @Override // com.byazt.fvm.fs
    public void n(Double d) {
    }

    @Override // com.byazt.fvm.fs
    public void n(Double d, String str, String str2) {
    }

    @Override // com.byazt.fvm.cp
    public long q() {
        return LongCompanionObject.MAX_VALUE;
    }

    @Override // com.byazt.fvm.fs
    public void qg(Double d) {
    }

    @Override // com.byazt.fvm.cp
    public int s() {
        return 0;
    }

    public n(com.byazt.np.fs fsVar) {
        this.n = fsVar;
        w();
    }

    private void w() {
        com.byazt.np.fs fsVar = this.n;
        if (fsVar == null) {
            return;
        }
        fsVar.n(new com.byazt.pf.n() { // from class: com.byazt.xm.n.1
            @Override // com.byazt.pf.n
            public void n() {
                if (n.this.qg != null) {
                    n.this.qg.n(null);
                }
            }

            @Override // com.byazt.pf.n
            public void n(com.byazt.mj.n nVar) {
                if (nVar == null || !(n.this.qg instanceof com.byazt.pe.qg)) {
                    return;
                }
                ((com.byazt.pe.qg) n.this.qg).n(nVar.n, nVar.qg);
            }

            @Override // com.byazt.pf.n
            public void g_() {
                if (n.this.qg != null) {
                    n.this.qg.qg(null);
                }
            }

            @Override // com.byazt.pf.n
            public void h_() {
                if (n.this.qg != null) {
                    n.this.qg.s(null);
                }
            }

            @Override // com.byazt.pf.n
            public void q() {
                if (n.this.qg != null) {
                    n.this.qg.n();
                }
            }

            @Override // com.byazt.pf.n
            public void l() {
                if (n.this.qg instanceof com.byazt.pe.qg) {
                    ((com.byazt.pe.qg) n.this.qg).s();
                }
            }

            @Override // com.byazt.pf.n
            public void w() {
                if (n.this.qg != null) {
                    n.this.qg.qg();
                }
            }

            @Override // com.byazt.pf.n
            public void n(com.byazt.fd.n nVar) {
                if (n.this.qg instanceof com.byazt.pe.qg) {
                    ((com.byazt.pe.qg) n.this.qg).q(q.n(nVar));
                }
            }
        });
    }

    @Override // com.byazt.fvm.cp
    public void n(com.byazt.rzx.n nVar) {
        this.qg = nVar;
    }

    @Override // com.byazt.fvm.cp
    public void n(final com.byazt.mi.s sVar) {
        com.byazt.np.fs fsVar = this.n;
        if (fsVar != null) {
            fsVar.n(new com.byazt.kv.qg() { // from class: com.byazt.xm.n.2
                @Override // com.byazt.kv.qg
                public void qg() {
                }

                @Override // com.byazt.kv.qg
                public void n() {
                    com.byazt.mi.s sVar2 = sVar;
                    if (sVar2 != null) {
                        sVar2.n();
                    }
                }

                @Override // com.byazt.kv.qg
                public void n(long j, long j2, int i, int i2, String str, String str2) {
                    com.byazt.mi.s sVar2 = sVar;
                    if (sVar2 != null) {
                        sVar2.n(j, j2, str, str2);
                    }
                }

                @Override // com.byazt.kv.qg
                public void n(long j, long j2, String str, String str2) {
                    com.byazt.mi.s sVar2 = sVar;
                    if (sVar2 != null) {
                        sVar2.qg(j, j2, str, str2);
                    }
                }

                @Override // com.byazt.kv.qg
                public void qg(long j, long j2, String str, String str2) {
                    com.byazt.mi.s sVar2 = sVar;
                    if (sVar2 != null) {
                        sVar2.s(j, j2, str, str2);
                    }
                }

                @Override // com.byazt.kv.qg
                public void n(long j, String str, String str2) {
                    com.byazt.mi.s sVar2 = sVar;
                    if (sVar2 != null) {
                        sVar2.n(j, str, str2);
                    }
                }

                @Override // com.byazt.kv.qg
                public void n(String str, String str2) {
                    com.byazt.mi.s sVar2 = sVar;
                    if (sVar2 != null) {
                        sVar2.n(str, str2);
                    }
                }
            });
        }
    }

    @Override // com.byazt.fvm.cp
    public int n() {
        com.byazt.np.fs fsVar = this.n;
        if (fsVar != null) {
            return fsVar.cy();
        }
        return -1;
    }

    @Override // com.byazt.fvm.cp
    public void n(Activity activity) {
        com.byazt.np.fs fsVar = this.n;
        if (fsVar != null) {
            fsVar.n(activity);
        }
    }

    @Override // com.byazt.fvm.cp
    public void n(Activity activity, Object obj, String str) {
        com.byazt.np.fs fsVar = this.n;
        if (fsVar != null) {
            fsVar.qg(activity, obj, str);
        }
    }

    @Override // com.byazt.fvm.cp
    public Map<String, Object> qg() {
        com.byazt.np.fs fsVar = this.n;
        if (fsVar != null) {
            return fsVar.hd();
        }
        return null;
    }

    @Override // com.byazt.fvm.cp
    public com.byazt.nq.q l() {
        return new fs(new qg(this.n));
    }

    @Override // com.byazt.fvm.fs
    public void n(com.byazt.mi.qg qgVar) {
        com.byazt.np.fs fsVar = this.n;
        if (fsVar != null) {
            fsVar.n(qgVar);
        }
    }
}
