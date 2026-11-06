package com.byazt.as;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.np.oa;
import com.byazt.nq.x;
import com.byazt.vv.q;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_TT_HLS_DRM_TOKEN, 19})
public class n extends com.byazt.fvm.qg {
    public q l = new q() { // from class: com.byazt.as.n.2
        @Override // com.byazt.vv.q
        public Activity getActivity() {
            return null;
        }

        @Override // com.byazt.vv.q
        public void n() {
            if (n.this.s != null) {
                n.this.s.n(n.this);
            }
        }

        @Override // com.byazt.vv.q
        public void qg() {
            if (n.this.s != null) {
                n.this.s.qg();
            }
        }

        @Override // com.byazt.vv.q
        public void s() {
            if (n.this.s != null) {
                n.this.s.n();
            }
        }
    };
    public oa n;
    public com.byazt.ap.n q;
    public com.byazt.cne.n qg;
    public com.byazt.cne.qg s;

    @Override // com.byazt.fvm.fs
    public void n(Double d) {
    }

    @Override // com.byazt.fvm.fs
    public void n(Double d, String str, String str2) {
    }

    @Override // com.byazt.fvm.qg
    public String qg() {
        return null;
    }

    @Override // com.byazt.fvm.fs
    public void qg(Double d) {
    }

    @Override // com.byazt.fvm.qg
    public PluginValueSet n() {
        return com.byazt.qvu.n.n(super.n()).n(1, com.byazt.zo.qg.n()).qg();
    }

    public n(oa oaVar, com.byazt.ap.n nVar) {
        this.n = oaVar;
        this.q = nVar;
        rv();
    }

    private void rv() {
        this.n.n(new com.byazt.vv.qg() { // from class: com.byazt.as.n.1
            @Override // com.byazt.vv.qg
            public void q() {
                if (n.this.qg != null) {
                    n.this.qg.qg(n.this);
                }
            }

            @Override // com.byazt.vv.qg
            public void l() {
                if (n.this.qg != null) {
                    n.this.qg.n(n.this);
                }
            }

            @Override // com.byazt.vv.qg
            public void n(com.byazt.mj.n nVar) {
                if (n.this.q == null || nVar == null) {
                    return;
                }
                n.this.q.n(n.this, new com.byazt.fb.n(nVar.n, nVar.qg));
            }

            @Override // com.byazt.vv.qg
            public void n(int i) {
                if (n.this.qg != null) {
                    n.this.qg.n(n.this, i);
                }
            }

            @Override // com.byazt.vv.qg
            public void qg(int i) {
                if (n.this.qg != null) {
                    n.this.qg.n(n.this, i);
                }
            }
        });
        this.n.n(this.l);
    }

    @Override // com.byazt.fvm.qg
    public View s() {
        oa oaVar = this.n;
        if (oaVar != null) {
            return oaVar.ou();
        }
        return null;
    }

    @Override // com.byazt.fvm.qg
    public View q() {
        oa oaVar = this.n;
        if (oaVar != null) {
            return oaVar.w();
        }
        return null;
    }

    @Override // com.byazt.fvm.qg
    public int l() {
        oa oaVar = this.n;
        if (oaVar != null) {
            return oaVar.cy();
        }
        return -1;
    }

    @Override // com.byazt.fvm.qg
    public Map<String, Object> w() {
        oa oaVar = this.n;
        if (oaVar != null) {
            return oaVar.hd();
        }
        return null;
    }

    @Override // com.byazt.fvm.qg
    public void x() {
        oa oaVar = this.n;
        if (oaVar != null) {
            oaVar.m();
        }
    }

    @Override // com.byazt.fvm.qg
    public void n(final com.byazt.mi.s sVar) {
        oa oaVar = this.n;
        if (oaVar != null) {
            oaVar.n(new com.byazt.kv.qg() { // from class: com.byazt.as.n.3
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

    @Override // com.byazt.fvm.qg
    public void n(com.byazt.cne.n nVar) {
        this.qg = nVar;
    }

    @Override // com.byazt.fvm.qg
    public void n(com.byazt.cne.qg qgVar) {
        this.s = qgVar;
    }

    @Override // com.byazt.fvm.qg
    public void n(ViewGroup viewGroup) {
        oa oaVar = this.n;
        if (oaVar == null || viewGroup == null) {
            return;
        }
        oaVar.n(viewGroup);
    }

    @Override // com.byazt.fvm.qg
    public void n(ViewGroup viewGroup, Activity activity) {
        oa oaVar = this.n;
        if (oaVar == null || viewGroup == null || activity == null) {
            return;
        }
        oaVar.n(viewGroup, activity);
    }

    @Override // com.byazt.fvm.qg
    public x fs() {
        return new com.byazt.oq.n(new qg(this.n));
    }

    @Override // com.byazt.fvm.fs
    public void n(com.byazt.mi.qg qgVar) {
        oa oaVar = this.n;
        if (oaVar != null) {
            oaVar.n(qgVar);
        }
    }
}
