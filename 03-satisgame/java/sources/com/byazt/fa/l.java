package com.byazt.fa;

import com.byazt.vr.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT, 18})
public class l implements com.byazt.vr.q {
    public List<com.byazt.cm.n> n;

    @Override // com.byazt.vr.q
    public List<com.byazt.vr.n> n(int i, com.byazt.vr.n nVar, boolean z, String str) {
        return null;
    }

    @Override // com.byazt.vr.q
    public int qg() {
        return 0;
    }

    public l(Queue<String> queue, com.byazt.vr.qg qgVar, com.byazt.vf.n nVar) {
        w wVarS;
        ArrayList arrayList = new ArrayList();
        this.n = arrayList;
        arrayList.add(new com.byazt.cm.s(qgVar.qg() == null ? com.byazt.blx.n.q(nVar) : qgVar.qg(), queue, nVar));
        if (qgVar.l() != null) {
            wVarS = qgVar.l();
        } else {
            wVarS = qgVar.s();
        }
        this.n.add(new com.byazt.cm.q(wVarS == null ? com.byazt.blx.n.n(nVar) : wVarS, queue, nVar));
        this.n.add(new com.byazt.cm.l(qgVar.s() == null ? com.byazt.blx.n.s(nVar) : qgVar.s(), queue, nVar));
        this.n.add(new com.byazt.cm.w(qgVar.s() == null ? com.byazt.blx.n.s(nVar) : qgVar.s(), queue, nVar));
        this.n.add(new com.byazt.cm.qg(qgVar.q() == null ? com.byazt.blx.n.qg(nVar) : qgVar.q(), queue, nVar));
    }

    @Override // com.byazt.vr.q
    public void n(com.byazt.vr.n nVar, int i, boolean z) {
        Iterator<com.byazt.cm.n> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().qg(nVar);
        }
    }

    @Override // com.byazt.vr.q
    public qg n(int i, List<com.byazt.vr.n> list, int i2) {
        Iterator<com.byazt.cm.n> it = this.n.iterator();
        qg qgVarN = null;
        while (it.hasNext()) {
            qgVarN = it.next().n(i, list, i2);
            if (qgVarN.n()) {
                break;
            }
        }
        return qgVarN;
    }

    @Override // com.byazt.vr.q
    public List<com.byazt.vr.n> n(int i, com.byazt.vr.n nVar, boolean z, List<String> list) {
        Iterator<com.byazt.cm.n> it = this.n.iterator();
        while (it.hasNext()) {
            List<com.byazt.vr.n> listN = it.next().n(i, nVar, z, list, "get");
            if (listN != null && listN.size() != 0) {
                return listN;
            }
        }
        return null;
    }

    @Override // com.byazt.vr.q
    public boolean n(int i, String str, com.byazt.vr.n nVar) {
        Iterator<com.byazt.cm.n> it = this.n.iterator();
        while (it.hasNext()) {
            if (it.next().n(i, str, nVar)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.byazt.vr.q
    public int n() {
        int size = this.n.size();
        int iN = 0;
        for (int i = 0; i < size; i++) {
            iN += this.n.get(i).n();
        }
        return iN;
    }

    @Override // com.byazt.vr.q
    public List<com.byazt.vr.n> n(int i) {
        return new ArrayList();
    }
}
