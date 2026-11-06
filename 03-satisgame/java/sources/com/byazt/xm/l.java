package com.byazt.xm;

import android.app.Activity;
import com.byazt.fvm.cp;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_POSITION_UPDATE_INTERVAL, 18})
public class l extends cp {
    public com.byazt.np.n n;
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

    public l(com.byazt.np.n nVar) {
        this.n = nVar;
        w();
    }

    private void w() {
        com.byazt.np.n nVar = this.n;
        if (nVar == null) {
            return;
        }
        nVar.n(new com.byazt.ig.n() { // from class: com.byazt.xm.l.1
            @Override // com.byazt.ig.n
            public void n() {
                if (l.this.qg != null) {
                    l.this.qg.n(null);
                }
            }

            @Override // com.byazt.ig.n
            public void n(com.byazt.mj.n nVar2) {
                if (nVar2 == null || !(l.this.qg instanceof com.byazt.pe.qg)) {
                    return;
                }
                ((com.byazt.pe.qg) l.this.qg).n(nVar2.n, nVar2.qg);
            }

            @Override // com.byazt.ig.n
            public void qg() {
                if (l.this.qg != null) {
                    l.this.qg.qg(null);
                }
            }

            @Override // com.byazt.ig.n
            public void s() {
                if (l.this.qg != null) {
                    l.this.qg.s(null);
                }
            }

            @Override // com.byazt.ig.n
            public void q() {
                if (l.this.qg != null) {
                    l.this.qg.n();
                }
            }

            @Override // com.byazt.ig.n
            public void l() {
                if (l.this.qg instanceof com.byazt.pe.qg) {
                    ((com.byazt.pe.qg) l.this.qg).s();
                }
            }

            @Override // com.byazt.ig.n
            public void w() {
                if (l.this.qg != null) {
                    l.this.qg.qg();
                }
            }

            @Override // com.byazt.ig.n
            public void x() {
                if (l.this.qg instanceof com.byazt.pe.qg) {
                    ((com.byazt.pe.qg) l.this.qg).q();
                }
            }

            @Override // com.byazt.ig.n
            public void fs() {
                if (l.this.qg instanceof com.byazt.pe.qg) {
                    ((com.byazt.pe.qg) l.this.qg).l();
                }
            }

            @Override // com.byazt.ig.n
            public void n(com.byazt.fd.n nVar2) {
                if (l.this.qg instanceof com.byazt.pe.qg) {
                    ((com.byazt.pe.qg) l.this.qg).q(q.n(nVar2));
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
        com.byazt.np.n nVar = this.n;
        if (nVar != null) {
            nVar.n(new com.byazt.kv.qg() { // from class: com.byazt.xm.l.2
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
        com.byazt.np.n nVar = this.n;
        if (nVar != null) {
            return nVar.cy();
        }
        return -1;
    }

    @Override // com.byazt.fvm.cp
    public void n(Activity activity) {
        com.byazt.np.n nVar = this.n;
        if (nVar != null) {
            nVar.n(activity);
        }
    }

    @Override // com.byazt.fvm.cp
    public void n(Activity activity, Object obj, String str) {
        com.byazt.np.n nVar = this.n;
        if (nVar != null) {
            nVar.n(activity, obj, str);
        }
    }

    @Override // com.byazt.fvm.cp
    public Map<String, Object> qg() {
        com.byazt.np.n nVar = this.n;
        if (nVar != null) {
            return nVar.hd();
        }
        return null;
    }

    @Override // com.byazt.fvm.cp
    public com.byazt.nq.q l() {
        return new fs(new w(this.n));
    }

    @Override // com.byazt.fvm.fs
    public void n(com.byazt.mi.qg qgVar) {
        com.byazt.np.n nVar = this.n;
        if (nVar != null) {
            nVar.n(qgVar);
        }
    }
}
