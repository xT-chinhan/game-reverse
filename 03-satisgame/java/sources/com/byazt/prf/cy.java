package com.byazt.prf;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 102, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE})
public class cy {
    public final com.byazt.ip.n<RecyclerView.m, n> n = new com.byazt.ip.n<>();
    public final com.byazt.ip.s<RecyclerView.m> qg = new com.byazt.ip.s<>();

    interface qg {
        void n(RecyclerView.m mVar);

        void n(RecyclerView.m mVar, RecyclerView.w.qg qgVar, RecyclerView.w.qg qgVar2);

        void qg(RecyclerView.m mVar, RecyclerView.w.qg qgVar, RecyclerView.w.qg qgVar2);

        void s(RecyclerView.m mVar, RecyclerView.w.qg qgVar, RecyclerView.w.qg qgVar2);
    }

    public void n() {
        this.n.clear();
        this.qg.s();
    }

    public void n(RecyclerView.m mVar, RecyclerView.w.qg qgVar) {
        n nVarN = this.n.get(mVar);
        if (nVarN == null) {
            nVarN = n.n();
            this.n.put(mVar, nVarN);
        }
        nVarN.qg = qgVar;
        nVarN.n |= 4;
    }

    public boolean n(RecyclerView.m mVar) {
        n nVar = this.n.get(mVar);
        return (nVar == null || (nVar.n & 1) == 0) ? false : true;
    }

    public RecyclerView.w.qg qg(RecyclerView.m mVar) {
        return n(mVar, 4);
    }

    public RecyclerView.w.qg s(RecyclerView.m mVar) {
        return n(mVar, 8);
    }

    private RecyclerView.w.qg n(RecyclerView.m mVar, int i) {
        n nVarQg;
        RecyclerView.w.qg qgVar;
        int iN = this.n.n(mVar);
        if (iN < 0 || (nVarQg = this.n.qg(iN)) == null || (nVarQg.n & i) == 0) {
            return null;
        }
        nVarQg.n &= ~i;
        if (i == 4) {
            qgVar = nVarQg.qg;
        } else {
            if (i != 8) {
                throw new IllegalArgumentException("Must provide flag PRE or POST");
            }
            qgVar = nVarQg.s;
        }
        if ((nVarQg.n & 12) == 0) {
            this.n.s(iN);
            n.n(nVarQg);
        }
        return qgVar;
    }

    public void n(long j, RecyclerView.m mVar) {
        this.qg.qg(j, mVar);
    }

    public void qg(RecyclerView.m mVar, RecyclerView.w.qg qgVar) {
        n nVarN = this.n.get(mVar);
        if (nVarN == null) {
            nVarN = n.n();
            this.n.put(mVar, nVarN);
        }
        nVarN.n |= 2;
        nVarN.qg = qgVar;
    }

    public boolean q(RecyclerView.m mVar) {
        n nVar = this.n.get(mVar);
        return (nVar == null || (nVar.n & 4) == 0) ? false : true;
    }

    public RecyclerView.m n(long j) {
        return this.qg.n(j);
    }

    public void s(RecyclerView.m mVar, RecyclerView.w.qg qgVar) {
        n nVarN = this.n.get(mVar);
        if (nVarN == null) {
            nVarN = n.n();
            this.n.put(mVar, nVarN);
        }
        nVarN.s = qgVar;
        nVarN.n |= 8;
    }

    public void l(RecyclerView.m mVar) {
        n nVarN = this.n.get(mVar);
        if (nVarN == null) {
            nVarN = n.n();
            this.n.put(mVar, nVarN);
        }
        nVarN.n |= 1;
    }

    public void w(RecyclerView.m mVar) {
        n nVar = this.n.get(mVar);
        if (nVar != null) {
            nVar.n &= -2;
        }
    }

    public void n(qg qgVar) {
        for (int size = this.n.size() - 1; size >= 0; size--) {
            RecyclerView.m mVarN = this.n.n(size);
            n nVarS = this.n.s(size);
            if ((nVarS.n & 3) == 3) {
                qgVar.n(mVarN);
            } else if ((nVarS.n & 1) != 0) {
                if (nVarS.qg == null) {
                    qgVar.n(mVarN);
                } else {
                    qgVar.n(mVarN, nVarS.qg, nVarS.s);
                }
            } else if ((nVarS.n & 14) == 14) {
                qgVar.qg(mVarN, nVarS.qg, nVarS.s);
            } else if ((nVarS.n & 12) == 12) {
                qgVar.s(mVarN, nVarS.qg, nVarS.s);
            } else if ((nVarS.n & 4) != 0) {
                qgVar.n(mVarN, nVarS.qg, null);
            } else if ((nVarS.n & 8) != 0) {
                qgVar.qg(mVarN, nVarS.qg, nVarS.s);
            }
            n.n(nVarS);
        }
    }

    public void x(RecyclerView.m mVar) {
        for (int iQg = this.qg.qg() - 1; iQg >= 0; iQg--) {
            if (mVar == this.qg.s(iQg)) {
                this.qg.n(iQg);
                break;
            }
        }
        n nVarRemove = this.n.remove(mVar);
        if (nVarRemove != null) {
            n.n(nVarRemove);
        }
    }

    public void qg() {
        n.qg();
    }

    public void fs(RecyclerView.m mVar) {
        w(mVar);
    }

    @com.byazt.cp.n(n = {0, 1, 102, 1086})
    static class n {
        public static com.byazt.ip.q.n<n> q = new com.byazt.ip.q.qg(20);
        public int n;
        public RecyclerView.w.qg qg;
        public RecyclerView.w.qg s;

        private n() {
        }

        public static n n() {
            n nVarN = q.n();
            return nVarN == null ? new n() : nVarN;
        }

        public static void n(n nVar) {
            nVar.n = 0;
            nVar.qg = null;
            nVar.s = null;
            q.n(nVar);
        }

        public static void qg() {
            while (q.n() != null) {
            }
        }
    }
}
