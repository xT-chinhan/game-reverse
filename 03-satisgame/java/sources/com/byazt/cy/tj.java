package com.byazt.cy;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj extends com.byazt.nq.l {
    public d n;

    public tj(d dVar) {
        this.n = dVar;
    }

    @Override // com.byazt.nq.l
    public boolean n() {
        d dVar = this.n;
        if (dVar != null) {
            return dVar.x();
        }
        return false;
    }

    @Override // com.byazt.nq.l
    public void n(boolean z) {
        d dVar = this.n;
        if (dVar != null) {
            dVar.n(z);
        }
    }

    @Override // com.byazt.nq.l
    public void n(final com.byazt.he.w wVar) {
        d dVar = this.n;
        if (dVar != null) {
            dVar.n(new oa() { // from class: com.byazt.cy.tj.1
                @Override // com.byazt.cy.oa
                public void n() {
                    com.byazt.he.w wVar2 = wVar;
                    if (wVar2 != null) {
                        wVar2.n();
                    }
                }
            });
        }
    }

    @Override // com.byazt.nq.l
    public void qg() {
        d dVar = this.n;
        if (dVar != null) {
            dVar.rv();
        }
    }

    @Override // com.byazt.nq.l
    public void s() {
        d dVar = this.n;
        if (dVar != null) {
            dVar.tj();
        }
    }

    @Override // com.byazt.nq.l
    public boolean q() {
        d dVar = this.n;
        if (dVar != null) {
            return dVar.fs();
        }
        return false;
    }

    @Override // com.byazt.nq.s
    public boolean l() {
        d dVar = this.n;
        if (dVar != null) {
            return dVar.n();
        }
        return true;
    }

    @Override // com.byazt.nq.s
    public List<com.byazt.nq.qg> w() {
        if (this.n != null) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < this.n.qg().size(); i++) {
                linkedList.add(new fs(this.n.qg().get(i)));
            }
            return linkedList;
        }
        return new LinkedList();
    }

    @Override // com.byazt.nq.s
    public List<com.byazt.nq.n> x() {
        if (this.n != null) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < this.n.s().size(); i++) {
                linkedList.add(new x(this.n.s().get(i)));
            }
            return linkedList;
        }
        return new LinkedList();
    }

    @Override // com.byazt.nq.s
    public com.byazt.nq.n fs() {
        if (this.n != null) {
            return new x(this.n.q());
        }
        return new x(null);
    }

    @Override // com.byazt.nq.s
    public List<com.byazt.nq.n> rv() {
        if (this.n != null) {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < this.n.l().size(); i++) {
                linkedList.add(new x(this.n.l().get(i)));
            }
            return linkedList;
        }
        return new LinkedList();
    }

    @Override // com.byazt.nq.s
    public com.byazt.nq.n tj() {
        if (this.n != null) {
            return new x(this.n.w());
        }
        return new x(null);
    }
}
