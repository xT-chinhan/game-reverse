package com.byazt.as;

import com.byazt.cy.l;
import com.byazt.cy.w;
import com.byazt.fb.q;
import com.byazt.np.oa;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_TT_HLS_DRM_TOKEN, 26})
public class qg implements com.byazt.xll.qg {
    public oa n;

    public qg(oa oaVar) {
        this.n = oaVar;
    }

    @Override // com.byazt.fb.s
    public boolean n() {
        oa oaVar = this.n;
        if (oaVar != null) {
            return oaVar.py();
        }
        return false;
    }

    @Override // com.byazt.fb.s
    public List<q> qg() {
        List<com.byazt.mj.qg> listTj;
        ArrayList arrayList = new ArrayList();
        oa oaVar = this.n;
        if (oaVar != null && (listTj = oaVar.tj()) != null) {
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
        oa oaVar = this.n;
        if (oaVar != null && (listCp = oaVar.cp()) != null) {
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
        oa oaVar = this.n;
        if (oaVar != null && (listD = oaVar.d()) != null) {
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
        oa oaVar = this.n;
        if (oaVar != null) {
            oaVar.s();
        }
    }
}
