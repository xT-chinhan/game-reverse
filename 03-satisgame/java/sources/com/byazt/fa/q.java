package com.byazt.fa;

import android.content.Context;
import com.byazt.hls.x;
import com.byazt.vf.cp;
import com.byazt.vr.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT, 5})
public class q implements com.byazt.vr.q {
    public w cp;
    public w d;
    public w fs;
    public com.byazt.vga.q l;
    public Context n;
    public com.byazt.vr.qg oa;
    public com.byazt.vga.l q;
    public cp qg;
    public w rv;
    public com.byazt.vga.s s;
    public List<com.byazt.vga.qg> sz = new ArrayList();
    public w tj;
    public com.byazt.vga.w w;
    public com.byazt.vga.n x;

    @Override // com.byazt.vr.q
    public int n() {
        return 0;
    }

    @Override // com.byazt.vr.q
    public List<com.byazt.vr.n> n(int i, com.byazt.vr.n nVar, boolean z, String str) {
        return null;
    }

    public q(Context context, com.byazt.vr.qg qgVar, com.byazt.vf.n nVar) {
        this.oa = qgVar;
        this.n = context;
        this.qg = (cp) com.byazt.qp.q.n("csj_settings", nVar);
        w wVarQg = this.oa.qg();
        this.fs = wVarQg;
        if (wVarQg == null) {
            this.fs = com.byazt.blx.n.q(nVar);
        }
        com.byazt.vga.s sVar = new com.byazt.vga.s(context, this.fs, this.oa, this.qg);
        this.s = sVar;
        this.sz.add(sVar);
        if (this.oa.l() != null) {
            this.tj = this.oa.l();
        } else {
            this.tj = this.oa.s();
        }
        if (this.tj == null) {
            this.tj = com.byazt.blx.n.n(nVar);
        }
        com.byazt.vga.q qVar = new com.byazt.vga.q(context, this.tj, this.oa, this.qg);
        this.l = qVar;
        this.sz.add(qVar);
        w wVarS = this.oa.s();
        this.rv = wVarS;
        if (wVarS == null) {
            this.rv = com.byazt.blx.n.s(nVar);
        }
        com.byazt.vga.l lVar = new com.byazt.vga.l(context, this.rv, this.oa, this.qg);
        this.q = lVar;
        this.sz.add(lVar);
        w wVarS2 = this.oa.s();
        this.cp = wVarS2;
        if (wVarS2 == null) {
            this.cp = com.byazt.blx.n.s(nVar);
        }
        com.byazt.vga.w wVar = new com.byazt.vga.w(context, this.cp, this.oa, this.qg);
        this.w = wVar;
        this.sz.add(wVar);
        w wVarQ = this.oa.q();
        this.d = wVarQ;
        if (wVarQ == null) {
            this.d = com.byazt.blx.n.qg(nVar);
        }
        com.byazt.vga.n nVar2 = new com.byazt.vga.n(context, this.d, this.oa, this.qg);
        this.x = nVar2;
        this.sz.add(nVar2);
    }

    @Override // com.byazt.vr.q
    public void n(com.byazt.vr.n nVar, int i, boolean z) {
        if (nVar == null) {
            return;
        }
        try {
            nVar.n(System.currentTimeMillis());
            Iterator<com.byazt.vga.qg> it = this.sz.iterator();
            while (it.hasNext()) {
                it.next().qg(nVar);
            }
        } catch (Throwable unused) {
            com.byazt.hls.l.n(com.byazt.kp.s.n.n(), 1, this.qg);
        }
    }

    @Override // com.byazt.vr.q
    public qg n(int i, List<com.byazt.vr.n> list, int i2) {
        x.n("dbCache handleResult start");
        Iterator<com.byazt.vga.qg> it = this.sz.iterator();
        qg qgVarN = null;
        while (it.hasNext()) {
            qgVarN = it.next().n(i, list);
            if (qgVarN.n()) {
                break;
            }
        }
        x.n("dbCache handleResult end");
        return qgVarN;
    }

    public List<com.byazt.vr.n> n(com.byazt.vr.n nVar, int i, int i2, boolean z) {
        Iterator<com.byazt.vga.qg> it = this.sz.iterator();
        while (it.hasNext()) {
            List<com.byazt.vr.n> listN = it.next().n(i2, i, nVar, z);
            if (listN != null && listN.size() != 0) {
                return listN;
            }
        }
        return null;
    }

    @Override // com.byazt.vr.q
    public List<com.byazt.vr.n> n(int i, com.byazt.vr.n nVar, boolean z, List<String> list) {
        Iterator<com.byazt.vga.qg> it = this.sz.iterator();
        while (it.hasNext()) {
            List<com.byazt.vr.n> listN = it.next().n(i, nVar, z, list, "db");
            if (listN != null && listN.size() != 0) {
                return listN;
            }
        }
        return null;
    }

    @Override // com.byazt.vr.q
    public boolean n(int i, String str, com.byazt.vr.n nVar) {
        Iterator<com.byazt.vga.qg> it = this.sz.iterator();
        while (it.hasNext()) {
            if (it.next().n(i, str, nVar)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.byazt.vr.q
    public int qg() {
        int size = this.sz.size();
        int iS = 0;
        for (int i = 0; i < size; i++) {
            iS += this.sz.get(i).s();
        }
        return iS;
    }

    @Override // com.byazt.vr.q
    public List<com.byazt.vr.n> n(int i) {
        return n(i, null);
    }

    public List<com.byazt.vr.n> n(int i, List<String> list) {
        List<com.byazt.vr.n> listQg;
        ArrayList arrayList = new ArrayList();
        if (this.s == null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        if (list != null) {
            arrayList2.addAll(list);
        }
        while (arrayList.size() < 1000 && (listQg = this.s.qg(i, null, false, arrayList2, "direct_connect")) != null && !listQg.isEmpty()) {
            for (com.byazt.vr.n nVar : listQg) {
                if (nVar != null && nVar.w() != null) {
                    arrayList.add(nVar);
                    arrayList2.add(nVar.w());
                    if (arrayList.size() >= 1000) {
                        break;
                    }
                }
            }
            if (listQg.size() < 100) {
                break;
            }
        }
        x.s("DBCacheStrategy", "queryAllHighPriorityFromDb size=" + arrayList.size());
        return arrayList;
    }
}
