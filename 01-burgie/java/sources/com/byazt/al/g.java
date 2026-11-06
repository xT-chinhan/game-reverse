package com.byazt.al;

import android.graphics.PointF;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 60, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF})
public class g extends pr<PointF, PointF> {
    public final pr<Float, Float> aj;
    public com.byazt.cz.hn<Float> c;
    public final PointF fw;
    public final PointF uc;
    public com.byazt.cz.hn<Float> x;
    public final pr<Float, Float> zo;

    public g(pr<Float, Float> prVar, pr<Float, Float> prVar2) {
        super(Collections.emptyList());
        this.uc = new PointF();
        this.fw = new PointF();
        this.zo = prVar;
        this.aj = prVar2;
        pr(zo());
    }

    @Override // com.byazt.al.pr
    public void pr(float f) {
        this.zo.pr(f);
        this.aj.pr(f);
        this.uc.set(this.zo.fw().floatValue(), this.aj.fw().floatValue());
        for (int i = 0; i < this.pr.size(); i++) {
            this.pr.get(i).pr();
        }
    }

    @Override // com.byazt.al.pr
    /* JADX INFO: renamed from: aj, reason: merged with bridge method [inline-methods] */
    public PointF fw() {
        return pr(null, 0.0f);
    }

    @Override // com.byazt.al.pr
    /* JADX INFO: renamed from: hw, reason: merged with bridge method [inline-methods] */
    public PointF pr(com.byazt.cz.pr<PointF> prVar, float f) {
        Float fPr;
        com.byazt.cz.pr<Float> prVarHn;
        com.byazt.cz.pr<Float> prVarHn2;
        Float fPr2 = null;
        if (this.x != null && (prVarHn2 = this.zo.hn()) != null) {
            float fC = this.zo.c();
            Float f2 = prVarHn2.fw;
            fPr = this.x.pr(prVarHn2.uc, f2 == null ? prVarHn2.uc : f2.floatValue(), prVarHn2.pr, prVarHn2.hw, f, f, fC);
        } else {
            fPr = null;
        }
        if (this.c != null && (prVarHn = this.aj.hn()) != null) {
            float fC2 = this.aj.c();
            Float f3 = prVarHn.fw;
            fPr2 = this.c.pr(prVarHn.uc, f3 == null ? prVarHn.uc : f3.floatValue(), prVarHn.pr, prVarHn.hw, f, f, fC2);
        }
        if (fPr == null) {
            this.fw.set(this.uc.x, 0.0f);
        } else {
            this.fw.set(fPr.floatValue(), 0.0f);
        }
        if (fPr2 == null) {
            PointF pointF = this.fw;
            pointF.set(pointF.x, this.uc.y);
        } else {
            PointF pointF2 = this.fw;
            pointF2.set(pointF2.x, fPr2.floatValue());
        }
        return this.fw;
    }
}
