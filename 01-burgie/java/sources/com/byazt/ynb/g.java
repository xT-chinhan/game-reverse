package com.byazt.ynb;

import android.graphics.PointF;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 47, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF})
public class g {
    public boolean hn;
    public PointF hw;
    public final List<com.byazt.uxi.pr> pr;

    public g(PointF pointF, boolean z, List<com.byazt.uxi.pr> list) {
        this.hw = pointF;
        this.hn = z;
        this.pr = new ArrayList(list);
    }

    public g() {
        this.pr = new ArrayList();
    }

    public void pr(float f, float f2) {
        if (this.hw == null) {
            this.hw = new PointF();
        }
        this.hw.set(f, f2);
    }

    public PointF pr() {
        return this.hw;
    }

    public void pr(boolean z) {
        this.hn = z;
    }

    public boolean hw() {
        return this.hn;
    }

    public List<com.byazt.uxi.pr> hn() {
        return this.pr;
    }

    public void pr(g gVar, g gVar2, float f) {
        if (this.hw == null) {
            this.hw = new PointF();
        }
        this.hn = gVar.hw() || gVar2.hw();
        if (gVar.hn().size() != gVar2.hn().size()) {
            com.byazt.ptr.uc.hw("Curves must have the same number of control points. Shape 1: " + gVar.hn().size() + "\tShape 2: " + gVar2.hn().size());
        }
        int iMin = Math.min(gVar.hn().size(), gVar2.hn().size());
        if (this.pr.size() < iMin) {
            for (int size = this.pr.size(); size < iMin; size++) {
                this.pr.add(new com.byazt.uxi.pr());
            }
        } else if (this.pr.size() > iMin) {
            for (int size2 = this.pr.size() - 1; size2 >= iMin; size2--) {
                List<com.byazt.uxi.pr> list = this.pr;
                list.remove(list.size() - 1);
            }
        }
        PointF pointFPr = gVar.pr();
        PointF pointFPr2 = gVar2.pr();
        pr(com.byazt.ptr.aj.pr(pointFPr.x, pointFPr2.x, f), com.byazt.ptr.aj.pr(pointFPr.y, pointFPr2.y, f));
        for (int size3 = this.pr.size() - 1; size3 >= 0; size3--) {
            com.byazt.uxi.pr prVar = gVar.hn().get(size3);
            com.byazt.uxi.pr prVar2 = gVar2.hn().get(size3);
            PointF pointFPr3 = prVar.pr();
            PointF pointFHw = prVar.hw();
            PointF pointFHn = prVar.hn();
            PointF pointFPr4 = prVar2.pr();
            PointF pointFHw2 = prVar2.hw();
            PointF pointFHn2 = prVar2.hn();
            this.pr.get(size3).pr(com.byazt.ptr.aj.pr(pointFPr3.x, pointFPr4.x, f), com.byazt.ptr.aj.pr(pointFPr3.y, pointFPr4.y, f));
            this.pr.get(size3).hw(com.byazt.ptr.aj.pr(pointFHw.x, pointFHw2.x, f), com.byazt.ptr.aj.pr(pointFHw.y, pointFHw2.y, f));
            this.pr.get(size3).hn(com.byazt.ptr.aj.pr(pointFHn.x, pointFHn2.x, f), com.byazt.ptr.aj.pr(pointFHn.y, pointFHn2.y, f));
        }
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.pr.size() + "closed=" + this.hn + AbstractJsonLexerKt.END_OBJ;
    }
}
