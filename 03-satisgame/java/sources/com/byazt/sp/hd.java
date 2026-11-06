package com.byazt.sp;

import android.graphics.PointF;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1179, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_EXACT})
public class hd implements um, com.byazt.bd.n.InterfaceC0134n {
    public final com.byazt.pp.fs n;
    public com.byazt.aw.sz q;
    public final String qg;
    public final com.byazt.bd.n<Float, Float> s;

    @Override // com.byazt.sp.s
    public void n(List<s> list, List<s> list2) {
    }

    public hd(com.byazt.pp.fs fsVar, com.byazt.eg.s sVar, com.byazt.aw.oa oaVar) {
        this.n = fsVar;
        this.qg = oaVar.n();
        com.byazt.bd.n<Float, Float> nVarN = oaVar.qg().n();
        this.s = nVarN;
        sVar.n(nVarN);
        nVarN.n(this);
    }

    @Override // com.byazt.bd.n.InterfaceC0134n
    public void n() {
        this.n.invalidateSelf();
    }

    public com.byazt.bd.n<Float, Float> qg() {
        return this.s;
    }

    @Override // com.byazt.sp.um
    public com.byazt.aw.sz n(com.byazt.aw.sz szVar) {
        List<com.byazt.ld.n> listS = szVar.s();
        if (listS.size() <= 2) {
            return szVar;
        }
        float fFloatValue = this.s.x().floatValue();
        if (fFloatValue == 0.0f) {
            return szVar;
        }
        com.byazt.aw.sz szVarQg = qg(szVar);
        szVarQg.n(szVar.n().x, szVar.n().y);
        List<com.byazt.ld.n> listS2 = szVarQg.s();
        boolean zQg = szVar.qg();
        int i = 0;
        int i2 = 0;
        while (i < listS.size()) {
            com.byazt.ld.n nVar = listS.get(i);
            com.byazt.ld.n nVar2 = listS.get(n(i - 1, listS.size()));
            com.byazt.ld.n nVar3 = listS.get(n(i - 2, listS.size()));
            PointF pointFS = (i != 0 || zQg) ? nVar2.s() : szVar.n();
            PointF pointFQg = (i != 0 || zQg) ? nVar2.qg() : pointFS;
            PointF pointFN = nVar.n();
            PointF pointFS2 = nVar3.s();
            PointF pointFS3 = nVar.s();
            boolean z = !szVar.qg() && i == 0 && i == listS.size() + (-1);
            if (pointFQg.equals(pointFS) && pointFN.equals(pointFS) && !z) {
                float f = pointFS.x - pointFS2.x;
                float f2 = pointFS.y - pointFS2.y;
                float f3 = pointFS3.x - pointFS.x;
                float f4 = pointFS3.y - pointFS.y;
                float fHypot = (float) Math.hypot(f, f2);
                float fHypot2 = (float) Math.hypot(f3, f4);
                float fMin = Math.min(fFloatValue / fHypot, 0.5f);
                float fMin2 = Math.min(fFloatValue / fHypot2, 0.5f);
                float f5 = pointFS.x + ((pointFS2.x - pointFS.x) * fMin);
                float f6 = pointFS.y + ((pointFS2.y - pointFS.y) * fMin);
                float f7 = pointFS.x + ((pointFS3.x - pointFS.x) * fMin2);
                float f8 = pointFS.y + ((pointFS3.y - pointFS.y) * fMin2);
                float f9 = f5 - ((f5 - pointFS.x) * 0.5519f);
                float f10 = f6 - ((f6 - pointFS.y) * 0.5519f);
                float f11 = f7 - ((f7 - pointFS.x) * 0.5519f);
                float f12 = f8 - ((f8 - pointFS.y) * 0.5519f);
                com.byazt.ld.n nVar4 = listS2.get(n(i2 - 1, listS2.size()));
                com.byazt.ld.n nVar5 = listS2.get(i2);
                nVar4.qg(f5, f6);
                nVar4.s(f5, f6);
                if (i == 0) {
                    szVarQg.n(f5, f6);
                }
                nVar5.n(f9, f10);
                i2++;
                com.byazt.ld.n nVar6 = listS2.get(i2);
                nVar5.qg(f11, f12);
                nVar5.s(f7, f8);
                nVar6.n(f7, f8);
            } else {
                com.byazt.ld.n nVar7 = listS2.get(n(i2 - 1, listS2.size()));
                com.byazt.ld.n nVar8 = listS2.get(i2);
                nVar7.qg(nVar2.qg().x, nVar2.qg().y);
                nVar7.s(nVar2.s().x, nVar2.s().y);
                nVar8.n(nVar.n().x, nVar.n().y);
            }
            i2++;
            i++;
            listS = listS;
            zQg = zQg;
        }
        return szVarQg;
    }

    private com.byazt.aw.sz qg(com.byazt.aw.sz szVar) {
        List<com.byazt.ld.n> listS = szVar.s();
        boolean zQg = szVar.qg();
        int size = listS.size() - 1;
        int i = 0;
        while (size >= 0) {
            com.byazt.ld.n nVar = listS.get(size);
            com.byazt.ld.n nVar2 = listS.get(n(size - 1, listS.size()));
            PointF pointFS = (size != 0 || zQg) ? nVar2.s() : szVar.n();
            i = (((size != 0 || zQg) ? nVar2.qg() : pointFS).equals(pointFS) && nVar.n().equals(pointFS) && !(!szVar.qg() && size == 0 && size == listS.size() - 1)) ? i + 2 : i + 1;
            size--;
        }
        com.byazt.aw.sz szVar2 = this.q;
        if (szVar2 == null || szVar2.s().size() != i) {
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(new com.byazt.ld.n());
            }
            this.q = new com.byazt.aw.sz(new PointF(0.0f, 0.0f), false, arrayList);
        }
        this.q.n(zQg);
        return this.q;
    }

    private static int n(int i, int i2) {
        return i - (qg(i, i2) * i2);
    }

    private static int qg(int i, int i2) {
        int i3 = i / i2;
        return ((i ^ i2) >= 0 || i2 * i3 == i) ? i3 : i3 - 1;
    }
}
