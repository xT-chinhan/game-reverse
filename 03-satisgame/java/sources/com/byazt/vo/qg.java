package com.byazt.vo;

import com.byazt.cy.l;
import com.byazt.cy.w;
import com.byazt.fb.q;
import com.byazt.np.d;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_BUFFER_THRESHOLD_CONTROL, 26})
public class qg implements com.byazt.xll.qg {
    public d n;

    public qg(d dVar) {
        this.n = dVar;
    }

    @Override // com.byazt.fb.s
    public boolean n() {
        d dVar = this.n;
        if (dVar != null) {
            return dVar.t();
        }
        return false;
    }

    @Override // com.byazt.fb.s
    public List<q> qg() {
        List<com.byazt.mj.qg> listTj;
        ArrayList arrayList = new ArrayList();
        d dVar = this.n;
        if (dVar != null && (listTj = dVar.tj()) != null) {
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
        d dVar = this.n;
        if (dVar != null && (listCp = dVar.cp()) != null) {
            for (com.byazt.mj.s sVar : listCp) {
                if (sVar != null) {
                    arrayList.add(new w(sVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.byazt.fb.s
    public com.byazt.fb.qg q() {
        if (this.n != null) {
            return new w(this.n.k());
        }
        return new l();
    }

    @Override // com.byazt.fb.s
    public List<com.byazt.fb.qg> l() {
        List<com.byazt.mj.s> listD;
        ArrayList arrayList = new ArrayList();
        d dVar = this.n;
        if (dVar != null && (listD = dVar.d()) != null) {
            for (com.byazt.mj.s sVar : listD) {
                if (sVar != null) {
                    arrayList.add(new w(sVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.byazt.fb.s
    public com.byazt.fb.qg w() {
        if (this.n != null) {
            return new w(this.n.f_());
        }
        return new l();
    }

    @Override // com.byazt.xll.qg
    public void x() {
        d dVar = this.n;
        if (dVar != null) {
            dVar.s();
        }
    }
}
