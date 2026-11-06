package com.byazt.ra;

import android.os.Bundle;
import android.text.TextUtils;
import com.byazt.hg.i;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.hg.zo;
import com.byazt.ihe.vk;
import com.byazt.pe.fw;
import com.byazt.sd.a;
import com.byazt.wt.ls;
import com.byazt.zp.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_STALL_COUNTER, 13})
public abstract class hw<V> extends com.byazt.ci.pr<V> {
    public com.byazt.pe.hw pr;

    public interface pr<V> {
        void pr(V v);
    }

    public abstract void pr(com.byazt.qe.hw hwVar, List<of> list, pr<V> prVar);

    public abstract void pr(com.byazt.qe.hw hwVar, List<of> list, V v);

    public hw(com.byazt.pe.hw hwVar) {
        this.pr = hwVar;
    }

    @Override // com.byazt.ci.pr
    public boolean pr(com.byazt.qe.hw hwVar, List<of> list) {
        return true;
    }

    @Override // com.byazt.ci.pr
    public void pr(com.byazt.qe.hw hwVar, int i, String str, com.byazt.hg.hw hwVar2) {
        hwVar2.pr(i);
        com.byazt.hg.hw.pr(hwVar2);
    }

    @Override // com.byazt.ci.pr
    public void pr(int i, com.byazt.hg.pr prVar, com.byazt.hg.hw hwVar, i iVar, com.byazt.qe.hw hwVar2, com.byazt.pe.c<V> cVar, fw fwVar) {
        if (prVar.hw() == null || prVar.hw().isEmpty()) {
            if (fwVar != null) {
                fwVar.pr(-3);
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (prVar.hw().size() > 1) {
            if (zo.pr(i).pr("mix_ad", new zo.hw.pr().pr(hwVar2).pr(prVar.hw().get(0)).pr())) {
                com.byazt.sd.pr.pr(prVar.hw());
                arrayList.add(prVar.hw().get(0));
            } else {
                arrayList.addAll(prVar.hw());
            }
        } else {
            arrayList.addAll(prVar.hw());
        }
        for (of ofVar : arrayList) {
            if (ofVar.rq()) {
                if (ofVar.hp() <= 0) {
                    ofVar.c((System.currentTimeMillis() + 10500000) / 1000);
                }
                ofVar.i(102);
                pr(i, hwVar2, ofVar);
            }
        }
        if (arrayList.isEmpty()) {
            if (fwVar != null) {
                fwVar.pr(-4);
            }
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong(d.p, iVar.aj);
            bundle.putBoolean("is_second_page_ad", iVar.yb > 0);
            pr(i, arrayList, hwVar2, cVar, bundle, fwVar);
        }
    }

    @Override // com.byazt.ci.pr
    public void pr(final int i, final List<of> list, final com.byazt.qe.hw hwVar, final com.byazt.pe.c<V> cVar, final Bundle bundle, final fw fwVar) {
        boolean z = bundle.getBoolean("is_cache", false);
        Iterator<of> it = list.iterator();
        while (it.hasNext()) {
            it.next().vk(z);
        }
        pr(hwVar, list, (pr) new pr<V>() { // from class: com.byazt.ra.hw.1
            @Override // com.byazt.ra.hw.pr
            public void pr(V v) {
                com.byazt.pe.hn hnVarPr = hw.this.pr(i, hwVar, v, (List<of>) list, bundle, cVar);
                fw fwVar2 = fwVar;
                if (fwVar2 != null) {
                    fwVar2.pr(hnVarPr);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.pe.hn pr(final int i, final com.byazt.qe.hw hwVar, final V v, final List<of> list, Bundle bundle, final com.byazt.pe.c<V> cVar) {
        final long j = bundle.getLong(d.p);
        final boolean z = bundle.getBoolean("is_cache");
        final boolean z2 = bundle.getBoolean("is_second_page_ad", false);
        Iterator<of> it = list.iterator();
        while (it.hasNext()) {
            it.next().xh().hw();
        }
        final of ofVar = list.get(0);
        return new com.byazt.pe.hn() { // from class: com.byazt.ra.hw.2
            public final AtomicBoolean w = new AtomicBoolean(false);

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.byazt.pe.hn
            public void pr() {
                if (!z2) {
                    hw.this.pr(hwVar, (List<of>) list, v);
                }
                com.byazt.pj.pr.hw(ofVar, ls.hw(i), j);
                com.byazt.pe.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.pr(v, z, ofVar);
                }
            }

            @Override // com.byazt.pe.hn
            public void hw() {
            }

            @Override // com.byazt.pe.hn
            public void hn() {
                if (this.w.compareAndSet(false, true)) {
                    hw.this.pr(z, hwVar, list);
                }
            }
        };
    }

    public void pr(boolean z, com.byazt.qe.hw hwVar, List<of> list) {
        if (z) {
            com.byazt.pe.hw hwVar2 = this.pr;
            if (hwVar2 != null) {
                hwVar2.hw().hw(hwVar, list);
                return;
            }
            return;
        }
        com.byazt.pe.hw hwVar3 = this.pr;
        if (hwVar3 != null) {
            hwVar3.hw().pr(hwVar, list);
        }
    }

    @Override // com.byazt.ci.pr
    public void pr(final int i, com.byazt.qe.hw hwVar, final of ofVar) {
        com.byazt.zp.zo.pr(new com.byazt.xlm.fw("preloadResOnMetaCreated") { // from class: com.byazt.ra.hw.3
            @Override // java.lang.Runnable
            public void run() {
                if ((!of.pr(ofVar) || k.pr(ofVar)) && !TextUtils.isEmpty(qv.pr(ofVar))) {
                    if (a.hw().x(String.valueOf(ls.m(ofVar))) && a.hw().xn()) {
                        if (qv.ho(ofVar) != null) {
                            qv.ho(ofVar).uc(1);
                        }
                        if (qv.nt(ofVar) != null) {
                            qv.nt(ofVar).uc(1);
                        }
                        com.byazt.n.uc ucVarPr = qv.pr(4, ofVar);
                        ucVarPr.pr("material_meta", ofVar);
                        ucVarPr.pr("ad_slot", Integer.valueOf(i));
                        com.byazt.it.hn.pr(ucVarPr, (vk.pr) null);
                    }
                }
            }
        });
    }
}
