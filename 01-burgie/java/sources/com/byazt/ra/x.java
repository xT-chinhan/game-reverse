package com.byazt.ra;

import android.text.TextUtils;
import com.byazt.ca.aj;
import com.byazt.ea.w;
import com.byazt.hg.ie;
import com.byazt.hg.iy;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.hg.y;
import com.byazt.ihe.vk;
import com.byazt.mr.g;
import com.byazt.qx.fo;
import com.byazt.qx.rc;
import com.byazt.qx.z;
import com.byazt.sd.a;
import com.byazt.wt.ls;
import com.byazt.zp.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_STALL_COUNTER, 121})
public class x extends hw<List<g>> {
    public final int hn;
    public List<Long> hw;

    @Override // com.byazt.ra.hw
    public /* bridge */ /* synthetic */ void pr(com.byazt.qe.hw hwVar, List list, List<g> list2) {
        pr2(hwVar, (List<of>) list, list2);
    }

    public x(com.byazt.pe.hw hwVar, int i) {
        super(hwVar);
        this.hw = new CopyOnWriteArrayList();
        this.hn = i;
    }

    @Override // com.byazt.ra.hw
    public void pr(final com.byazt.qe.hw hwVar, final List<of> list, final hw.pr<List<g>> prVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        this.hw.add(Long.valueOf(jCurrentTimeMillis));
        final int[] iArr = {0};
        final int[] iArr2 = {list.size()};
        if (a.hw().zc() > 0) {
            aj.pr().postDelayed(new Runnable() { // from class: com.byazt.ra.x.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (this) {
                        if (x.this.hw.contains(Long.valueOf(jCurrentTimeMillis))) {
                            x.this.hw.remove(Long.valueOf(jCurrentTimeMillis));
                            x.this.hw(hwVar, list, prVar);
                        }
                    }
                }
            }, a.hw().zc());
        }
        Iterator<of> it = list.iterator();
        while (it.hasNext()) {
            final long j = jCurrentTimeMillis;
            pr(it.next(), new com.byazt.ea.hn() { // from class: com.byazt.ra.x.2
                @Override // com.byazt.ea.hn
                public void pr(String str) {
                    synchronized (this) {
                        int[] iArr3 = iArr;
                        int i = iArr3[0] + 1;
                        iArr3[0] = i;
                        x.this.pr(j, hwVar, (List<of>) list, (hw.pr<List<g>>) prVar, i, iArr2[0]);
                    }
                }

                @Override // com.byazt.ea.hn
                public void pr() {
                    synchronized (this) {
                        int[] iArr3 = iArr2;
                        int i = iArr3[0] - 1;
                        iArr3[0] = i;
                        x.this.pr(j, hwVar, (List<of>) list, (hw.pr<List<g>>) prVar, iArr[0], i);
                    }
                }
            });
            jCurrentTimeMillis = jCurrentTimeMillis;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(long j, com.byazt.qe.hw hwVar, List<of> list, hw.pr<List<g>> prVar, int i, int i2) {
        if (!this.hw.contains(Long.valueOf(j))) {
            return;
        }
        if (a.hw().cg() == 1 && i != i2) {
            return;
        }
        this.hw.remove(Long.valueOf(j));
        hw(hwVar, list, prVar);
    }

    private void pr(of ofVar, com.byazt.ea.hn hnVar) {
        if (ie.k(ofVar)) {
            com.byazt.jh.pr.pr(ofVar, hnVar);
            return;
        }
        if (ie.w(ofVar)) {
            iy iyVarFw = ie.fw(ofVar);
            if (iyVarFw != null) {
                w.pr(iyVarFw.aj(), iyVarFw.vk(), hnVar);
                return;
            }
            return;
        }
        hnVar.pr(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(final com.byazt.qe.hw hwVar, final List<of> list, final hw.pr<List<g>> prVar) {
        zo.hn(new Runnable() { // from class: com.byazt.ra.x.3
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    g gVarPr = x.this.pr(hwVar, (of) it.next());
                    if (gVarPr != null) {
                        arrayList.add(gVarPr);
                    }
                }
                hw.pr prVar2 = prVar;
                if (prVar2 != null) {
                    prVar2.pr(arrayList);
                }
            }
        });
    }

    /* JADX INFO: renamed from: pr, reason: avoid collision after fix types in other method */
    public void pr2(com.byazt.qe.hw hwVar, List<of> list, List<g> list2) {
        for (int i = 0; i < list2.size(); i++) {
            g gVar = list2.get(i);
            of ofVar = list.get(i);
            if (this.pr != null) {
                this.pr.hw().pr(hwVar, ofVar, (Object) gVar, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g pr(com.byazt.qe.hw hwVar, of ofVar) {
        boolean z = qv.ho(ofVar) != null;
        switch (this.hn) {
            case 1:
                if (z) {
                    return new com.byazt.et.hn(a.getContext(), ofVar, hwVar);
                }
                return new com.byazt.et.hw(a.getContext(), ofVar, hwVar);
            case 5:
                if (z) {
                    return new z(a.getContext(), ofVar, hwVar, this.hn);
                }
                return new fo(a.getContext(), ofVar, hwVar, this.hn);
            case 9:
                return new rc(a.getContext(), ofVar, hwVar, this.hn);
            default:
                return null;
        }
    }

    @Override // com.byazt.ra.hw, com.byazt.ci.pr
    public void pr(int i, com.byazt.qe.hw hwVar, of ofVar) {
        String strC;
        int i2;
        if (ofVar == null) {
            return;
        }
        if (hwVar != null && ((i2 = this.hn) == 3 || i2 == 4)) {
            strC = com.byazt.zp.w.c();
        } else {
            strC = null;
        }
        com.byazt.lpk.pr.hw(ofVar);
        if (ofVar.rq() && ofVar.de() != null && !ofVar.de().isEmpty()) {
            for (y yVar : ofVar.de()) {
                if (!TextUtils.isEmpty(yVar.pr())) {
                    com.byazt.pk.uc.pr().hn().pr(new com.byazt.vl.hw(yVar.pr(), yVar.fw()), com.byazt.bd.pr.hw(), yVar.hw(), yVar.hn(), strC);
                }
            }
        }
        if (!TextUtils.isEmpty(qv.pr(ofVar))) {
            if (a.hw().x(String.valueOf(ls.m(ofVar))) && a.hw().xn()) {
                com.byazt.n.uc ucVarPr = qv.pr(4, ofVar);
                ucVarPr.pr("material_meta", ofVar);
                ucVarPr.pr("ad_slot", Integer.valueOf(i));
                com.byazt.it.hn.pr(ucVarPr, (vk.pr) null);
            }
        }
    }
}
