package com.byazt.hr;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 180, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF})
public class g {
    public final com.byazt.fz.pr<RecyclerView.fo, pr> pr = new com.byazt.fz.pr<>();
    public final com.byazt.fz.hn<RecyclerView.fo> hw = new com.byazt.fz.hn<>();

    interface hw {
        void hn(RecyclerView.fo foVar, RecyclerView.uc.hw hwVar, RecyclerView.uc.hw hwVar2);

        void hw(RecyclerView.fo foVar, RecyclerView.uc.hw hwVar, RecyclerView.uc.hw hwVar2);

        void pr(RecyclerView.fo foVar);

        void pr(RecyclerView.fo foVar, RecyclerView.uc.hw hwVar, RecyclerView.uc.hw hwVar2);
    }

    public void pr() {
        this.pr.clear();
        this.hw.hn();
    }

    public void pr(RecyclerView.fo foVar, RecyclerView.uc.hw hwVar) {
        pr prVarPr = this.pr.get(foVar);
        if (prVarPr == null) {
            prVarPr = pr.pr();
            this.pr.put(foVar, prVarPr);
        }
        prVarPr.hw = hwVar;
        prVarPr.pr |= 4;
    }

    public boolean pr(RecyclerView.fo foVar) {
        pr prVar = this.pr.get(foVar);
        return (prVar == null || (prVar.pr & 1) == 0) ? false : true;
    }

    public RecyclerView.uc.hw hw(RecyclerView.fo foVar) {
        return pr(foVar, 4);
    }

    public RecyclerView.uc.hw hn(RecyclerView.fo foVar) {
        return pr(foVar, 8);
    }

    private RecyclerView.uc.hw pr(RecyclerView.fo foVar, int i) {
        pr prVarHw;
        RecyclerView.uc.hw hwVar;
        int iPr = this.pr.pr(foVar);
        if (iPr < 0 || (prVarHw = this.pr.hw(iPr)) == null || (prVarHw.pr & i) == 0) {
            return null;
        }
        prVarHw.pr &= ~i;
        if (i == 4) {
            hwVar = prVarHw.hw;
        } else {
            if (i != 8) {
                throw new IllegalArgumentException("Must provide flag PRE or POST");
            }
            hwVar = prVarHw.hn;
        }
        if ((prVarHw.pr & 12) == 0) {
            this.pr.hn(iPr);
            pr.pr(prVarHw);
        }
        return hwVar;
    }

    public void pr(long j, RecyclerView.fo foVar) {
        this.hw.hw(j, foVar);
    }

    public void hw(RecyclerView.fo foVar, RecyclerView.uc.hw hwVar) {
        pr prVarPr = this.pr.get(foVar);
        if (prVarPr == null) {
            prVarPr = pr.pr();
            this.pr.put(foVar, prVarPr);
        }
        prVarPr.pr |= 2;
        prVarPr.hw = hwVar;
    }

    public boolean x(RecyclerView.fo foVar) {
        pr prVar = this.pr.get(foVar);
        return (prVar == null || (prVar.pr & 4) == 0) ? false : true;
    }

    public RecyclerView.fo pr(long j) {
        return this.hw.pr(j);
    }

    public void hn(RecyclerView.fo foVar, RecyclerView.uc.hw hwVar) {
        pr prVarPr = this.pr.get(foVar);
        if (prVarPr == null) {
            prVarPr = pr.pr();
            this.pr.put(foVar, prVarPr);
        }
        prVarPr.hn = hwVar;
        prVarPr.pr |= 8;
    }

    public void c(RecyclerView.fo foVar) {
        pr prVarPr = this.pr.get(foVar);
        if (prVarPr == null) {
            prVarPr = pr.pr();
            this.pr.put(foVar, prVarPr);
        }
        prVarPr.pr |= 1;
    }

    public void uc(RecyclerView.fo foVar) {
        pr prVar = this.pr.get(foVar);
        if (prVar != null) {
            prVar.pr &= -2;
        }
    }

    public void pr(hw hwVar) {
        for (int size = this.pr.size() - 1; size >= 0; size--) {
            RecyclerView.fo foVarPr = this.pr.pr(size);
            pr prVarHn = this.pr.hn(size);
            if ((prVarHn.pr & 3) == 3) {
                hwVar.pr(foVarPr);
            } else if ((prVarHn.pr & 1) != 0) {
                if (prVarHn.hw == null) {
                    hwVar.pr(foVarPr);
                } else {
                    hwVar.pr(foVarPr, prVarHn.hw, prVarHn.hn);
                }
            } else if ((prVarHn.pr & 14) == 14) {
                hwVar.hw(foVarPr, prVarHn.hw, prVarHn.hn);
            } else if ((prVarHn.pr & 12) == 12) {
                hwVar.hn(foVarPr, prVarHn.hw, prVarHn.hn);
            } else if ((prVarHn.pr & 4) != 0) {
                hwVar.pr(foVarPr, prVarHn.hw, null);
            } else if ((prVarHn.pr & 8) != 0) {
                hwVar.hw(foVarPr, prVarHn.hw, prVarHn.hn);
            }
            pr.pr(prVarHn);
        }
    }

    public void fw(RecyclerView.fo foVar) {
        for (int iHw = this.hw.hw() - 1; iHw >= 0; iHw--) {
            if (foVar == this.hw.hn(iHw)) {
                this.hw.pr(iHw);
                break;
            }
        }
        pr prVarRemove = this.pr.remove(foVar);
        if (prVarRemove != null) {
            pr.pr(prVarRemove);
        }
    }

    public void hw() {
        pr.hw();
    }

    public void zo(RecyclerView.fo foVar) {
        uc(foVar);
    }

    @com.byazt.vzx.pr(pr = {0, 1, 180, MediaPlayer.MEDIA_PLAYER_OPTION_MOOV_POS})
    static class pr {
        public static com.byazt.fz.x.pr<pr> x = new com.byazt.fz.x.hw(20);
        public RecyclerView.uc.hw hn;
        public RecyclerView.uc.hw hw;
        public int pr;

        private pr() {
        }

        public static pr pr() {
            pr prVarPr = x.pr();
            return prVarPr == null ? new pr() : prVarPr;
        }

        public static void pr(pr prVar) {
            prVar.pr = 0;
            prVar.hw = null;
            prVar.hn = null;
            x.pr(prVar);
        }

        public static void hw() {
            while (x.pr() != null) {
            }
        }
    }
}
