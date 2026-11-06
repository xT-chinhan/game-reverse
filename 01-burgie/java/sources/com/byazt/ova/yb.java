package com.byazt.ova;

import android.graphics.PointF;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 423, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE})
public class yb implements com.byazt.al.pr.InterfaceC0016pr, qa {
    public final com.byazt.al.pr<Float, Float> hn;
    public final String hw;
    public final com.byazt.dx.zo pr;
    public com.byazt.ynb.g x;

    public yb(com.byazt.dx.zo zoVar, com.byazt.cg.hn hnVar, com.byazt.ynb.m mVar) {
        this.pr = zoVar;
        this.hw = mVar.pr();
        com.byazt.al.pr<Float, Float> prVarPr = mVar.hw().pr();
        this.hn = prVarPr;
        hnVar.pr(prVarPr);
        prVarPr.pr(this);
    }

    @Override // com.byazt.al.pr.InterfaceC0016pr
    public void pr() {
        this.pr.invalidateSelf();
    }

    @Override // com.byazt.ova.hn
    public void pr(List<hn> list, List<hn> list2) {
    }

    public com.byazt.al.pr<Float, Float> hw() {
        return this.hn;
    }

    @Override // com.byazt.ova.qa
    public com.byazt.ynb.g pr(com.byazt.ynb.g gVar) {
        List<com.byazt.uxi.pr> listHn = gVar.hn();
        if (listHn.size() <= 2) {
            return gVar;
        }
        float fFloatValue = this.hn.fw().floatValue();
        if (fFloatValue == 0.0f) {
            return gVar;
        }
        com.byazt.ynb.g gVarHw = hw(gVar);
        gVarHw.pr(gVar.pr().x, gVar.pr().y);
        List<com.byazt.uxi.pr> listHn2 = gVarHw.hn();
        boolean zHw = gVar.hw();
        int i = 0;
        int i2 = 0;
        while (i < listHn.size()) {
            com.byazt.uxi.pr prVar = listHn.get(i);
            com.byazt.uxi.pr prVar2 = listHn.get(pr(i - 1, listHn.size()));
            com.byazt.uxi.pr prVar3 = listHn.get(pr(i - 2, listHn.size()));
            PointF pointFHn = (i != 0 || zHw) ? prVar2.hn() : gVar.pr();
            PointF pointFHw = (i != 0 || zHw) ? prVar2.hw() : pointFHn;
            PointF pointFPr = prVar.pr();
            PointF pointFHn2 = prVar3.hn();
            PointF pointFHn3 = prVar.hn();
            boolean z = !gVar.hw() && i == 0 && i == listHn.size() + (-1);
            if (pointFHw.equals(pointFHn) && pointFPr.equals(pointFHn) && !z) {
                float f = pointFHn.x - pointFHn2.x;
                float f2 = pointFHn.y - pointFHn2.y;
                float f3 = pointFHn3.x - pointFHn.x;
                float f4 = pointFHn3.y - pointFHn.y;
                float fHypot = (float) Math.hypot(f, f2);
                float fHypot2 = (float) Math.hypot(f3, f4);
                float fMin = Math.min(fFloatValue / fHypot, 0.5f);
                float fMin2 = Math.min(fFloatValue / fHypot2, 0.5f);
                float f5 = pointFHn.x + ((pointFHn2.x - pointFHn.x) * fMin);
                float f6 = pointFHn.y + ((pointFHn2.y - pointFHn.y) * fMin);
                float f7 = pointFHn.x + ((pointFHn3.x - pointFHn.x) * fMin2);
                float f8 = pointFHn.y + ((pointFHn3.y - pointFHn.y) * fMin2);
                float f9 = f5 - ((f5 - pointFHn.x) * 0.5519f);
                float f10 = f6 - ((f6 - pointFHn.y) * 0.5519f);
                float f11 = f7 - ((f7 - pointFHn.x) * 0.5519f);
                float f12 = f8 - ((f8 - pointFHn.y) * 0.5519f);
                com.byazt.uxi.pr prVar4 = listHn2.get(pr(i2 - 1, listHn2.size()));
                com.byazt.uxi.pr prVar5 = listHn2.get(i2);
                prVar4.hw(f5, f6);
                prVar4.hn(f5, f6);
                if (i == 0) {
                    gVarHw.pr(f5, f6);
                }
                prVar5.pr(f9, f10);
                i2++;
                com.byazt.uxi.pr prVar6 = listHn2.get(i2);
                prVar5.hw(f11, f12);
                prVar5.hn(f7, f8);
                prVar6.pr(f7, f8);
            } else {
                com.byazt.uxi.pr prVar7 = listHn2.get(pr(i2 - 1, listHn2.size()));
                com.byazt.uxi.pr prVar8 = listHn2.get(i2);
                prVar7.hw(prVar2.hw().x, prVar2.hw().y);
                prVar7.hn(prVar2.hn().x, prVar2.hn().y);
                prVar8.pr(prVar.pr().x, prVar.pr().y);
            }
            i2++;
            i++;
            listHn = listHn;
            zHw = zHw;
        }
        return gVarHw;
    }

    private com.byazt.ynb.g hw(com.byazt.ynb.g gVar) {
        List<com.byazt.uxi.pr> listHn = gVar.hn();
        boolean zHw = gVar.hw();
        int size = listHn.size() - 1;
        int i = 0;
        while (size >= 0) {
            com.byazt.uxi.pr prVar = listHn.get(size);
            com.byazt.uxi.pr prVar2 = listHn.get(pr(size - 1, listHn.size()));
            PointF pointFHn = (size != 0 || zHw) ? prVar2.hn() : gVar.pr();
            PointF pointFHw = (size != 0 || zHw) ? prVar2.hw() : pointFHn;
            PointF pointFPr = prVar.pr();
            boolean z = !gVar.hw() && size == 0 && size == listHn.size() - 1;
            if (pointFHw.equals(pointFHn) && pointFPr.equals(pointFHn) && !z) {
                i += 2;
            } else {
                i++;
            }
            size--;
        }
        com.byazt.ynb.g gVar2 = this.x;
        if (gVar2 == null || gVar2.hn().size() != i) {
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(new com.byazt.uxi.pr());
            }
            this.x = new com.byazt.ynb.g(new PointF(0.0f, 0.0f), false, arrayList);
        }
        this.x.pr(zHw);
        return this.x;
    }

    private static int pr(int i, int i2) {
        return i - (hw(i, i2) * i2);
    }

    private static int hw(int i, int i2) {
        int i3 = i / i2;
        if ((i ^ i2) < 0 && i2 * i3 != i) {
            return i3 - 1;
        }
        return i3;
    }
}
