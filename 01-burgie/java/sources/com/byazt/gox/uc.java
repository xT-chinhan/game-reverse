package com.byazt.gox;

import android.os.Bundle;
import com.byazt.ec.g;
import com.byazt.ec.w;
import com.byazt.kg.zo;
import com.byazt.xa.aj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.an;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVPH_PARAMS, 5})
public class uc extends hw {
    public static final long[] hw = {60000};
    public long hn;
    public boolean x;

    public void pr(boolean z) {
        this.x = z;
    }

    public uc(x xVar) {
        super(xVar);
        this.x = true;
    }

    @Override // com.byazt.gox.hw
    public long pr() {
        long jRc = this.pr.hn().rc();
        if (jRc > 60000 || jRc <= 0) {
            jRc = 60000;
        }
        hw[0] = jRc;
        return this.hn + jRc;
    }

    @Override // com.byazt.gox.hw
    public long[] hw() {
        return hw;
    }

    @Override // com.byazt.gox.hw
    public boolean hn() {
        Bundle bundlePr;
        long jCurrentTimeMillis = System.currentTimeMillis();
        fw fwVarUc = this.pr.uc();
        if (fwVarUc != null && (bundlePr = fwVarUc.pr(jCurrentTimeMillis, 50000L)) != null) {
            com.byazt.zrg.pr.pr("play_session", bundlePr, 1);
            com.byazt.zrg.pr.hw();
        }
        com.byazt.kg.hw hwVarHw = this.pr.hw();
        aj ajVarX = this.pr.x();
        if (ajVarX.k() != 0) {
            JSONObject jSONObjectHn = g.hn(ajVarX.pr());
            if (jSONObjectHn != null) {
                pr(hwVarHw.pr(jSONObjectHn));
                this.hn = System.currentTimeMillis();
                return true;
            }
            w.hw((Throwable) null);
        }
        return false;
    }

    private void pr(ArrayList<zo> arrayList) {
        int iPr;
        com.byazt.kg.hw hwVarHw = this.pr.hw();
        ArrayList<zo> arrayList2 = new ArrayList<>();
        ArrayList<zo> arrayList3 = new ArrayList<>();
        com.byazt.xa.zo zoVarHn = this.pr.hn();
        ArrayList<zo> arrayList4 = new ArrayList();
        if (!arrayList.isEmpty()) {
            arrayList4.addAll(arrayList);
        }
        ArrayList<zo> arrayListPr = hwVarHw.pr();
        if (!arrayListPr.isEmpty()) {
            arrayList4.addAll(arrayListPr);
        }
        if (arrayList4.size() > 0) {
            for (zo zoVar : arrayList4) {
                if (zoVar.k == null || zoVar.k.length <= 0) {
                    arrayList2.add(zoVar);
                } else {
                    if (this.x) {
                        iPr = com.byazt.yj.pr.pr(com.byazt.yj.hw.pr(this.pr, this.pr.getContext(), this.pr.x().pr()), zoVar.k, zoVarHn);
                    } else {
                        iPr = 200;
                    }
                    if (com.byazt.yj.pr.pr(iPr)) {
                        if (!arrayList.contains(zoVar)) {
                            break;
                        }
                        zoVar.g = iPr;
                        arrayList3.add(zoVar);
                        break;
                    }
                    if (iPr == 200) {
                        arrayList2.add(zoVar);
                    } else {
                        zoVar.g = iPr;
                        arrayList3.add(zoVar);
                    }
                }
            }
            if (arrayList2.size() > 0 || arrayList3.size() > 0) {
                hwVarHw.setResult(arrayList2, arrayList3, arrayList);
            }
            w.x(x() + " " + arrayList2.size() + " " + arrayList4.size(), null);
        }
    }

    @Override // com.byazt.gox.hw
    public String x() {
        return an.aB;
    }
}
