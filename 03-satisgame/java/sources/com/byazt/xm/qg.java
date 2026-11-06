package com.byazt.xm;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_POSITION_UPDATE_INTERVAL, 26})
public class qg implements com.byazt.xll.qg {
    public com.byazt.np.fs n;

    public qg(com.byazt.np.fs fsVar) {
        this.n = fsVar;
    }

    @Override // com.byazt.fb.s
    public boolean n() {
        com.byazt.np.fs fsVar = this.n;
        if (fsVar != null) {
            return fsVar.t();
        }
        return false;
    }

    @Override // com.byazt.fb.s
    public List<com.byazt.fb.q> qg() {
        List<com.byazt.mj.qg> listTj;
        ArrayList arrayList = new ArrayList();
        com.byazt.np.fs fsVar = this.n;
        if (fsVar != null && (listTj = fsVar.tj()) != null) {
            for (com.byazt.mj.qg qgVar : listTj) {
                if (qgVar != null) {
                    arrayList.add(new com.byazt.cy.n(qgVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.byazt.fb.s
    public List<com.byazt.fb.qg> s() {
        List<com.byazt.mj.s> listCp;
        ArrayList arrayList = new ArrayList();
        com.byazt.np.fs fsVar = this.n;
        if (fsVar != null && (listCp = fsVar.cp()) != null) {
            for (com.byazt.mj.s sVar : listCp) {
                if (sVar != null) {
                    arrayList.add(new com.byazt.cy.w(sVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.byazt.fb.s
    public com.byazt.fb.qg q() {
        if (this.n != null) {
            return new com.byazt.cy.w(this.n.k());
        }
        return new com.byazt.cy.l();
    }

    @Override // com.byazt.fb.s
    public List<com.byazt.fb.qg> l() {
        List<com.byazt.mj.s> listD;
        ArrayList arrayList = new ArrayList();
        com.byazt.np.fs fsVar = this.n;
        if (fsVar != null && (listD = fsVar.d()) != null) {
            for (com.byazt.mj.s sVar : listD) {
                if (sVar != null) {
                    arrayList.add(new com.byazt.cy.w(sVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.byazt.fb.s
    public com.byazt.fb.qg w() {
        if (this.n != null) {
            return new com.byazt.cy.w(this.n.f_());
        }
        return new com.byazt.cy.l();
    }

    @Override // com.byazt.xll.qg
    public void x() {
        com.byazt.np.fs fsVar = this.n;
        if (fsVar != null) {
            fsVar.s();
        }
    }
}
