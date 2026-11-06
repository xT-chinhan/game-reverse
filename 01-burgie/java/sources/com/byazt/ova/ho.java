package com.byazt.ova;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 423, 19})
public class ho implements com.byazt.al.pr.InterfaceC0016pr, m, w {
    public final com.byazt.dx.zo c;
    public final com.byazt.al.pr<?, PointF> fw;
    public final String hn;
    public final com.byazt.al.pr<?, PointF> uc;
    public boolean w;
    public final boolean x;
    public final com.byazt.al.pr<?, Float> zo;
    public final Path pr = new Path();
    public final RectF hw = new RectF();
    public final hw aj = new hw();
    public com.byazt.al.pr<Float, Float> vk = null;

    public ho(com.byazt.dx.zo zoVar, com.byazt.cg.hn hnVar, com.byazt.ynb.w wVar) {
        this.hn = wVar.pr();
        this.x = wVar.c();
        this.c = zoVar;
        com.byazt.al.pr<PointF, PointF> prVarPr = wVar.x().pr();
        this.uc = prVarPr;
        com.byazt.al.pr<PointF, PointF> prVarPr2 = wVar.hn().pr();
        this.fw = prVarPr2;
        com.byazt.al.pr<Float, Float> prVarPr3 = wVar.hw().pr();
        this.zo = prVarPr3;
        hnVar.pr(prVarPr);
        hnVar.pr(prVarPr2);
        hnVar.pr(prVarPr3);
        prVarPr.pr(this);
        prVarPr2.pr(this);
        prVarPr3.pr(this);
    }

    @Override // com.byazt.al.pr.InterfaceC0016pr
    public void pr() {
        hw();
    }

    private void hw() {
        this.w = false;
        this.c.invalidateSelf();
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0026  */
    /* JADX WARN: Code duplicated, block: B:12:0x002a  */
    /* JADX WARN: Code duplicated, block: B:19:0x0034 A[SYNTHETIC] */
    @Override // com.byazt.ova.hn
    public void pr(List<hn> list, List<hn> list2) {
        for (int i = 0; i < list.size(); i++) {
            hn hnVar = list.get(i);
            if (hnVar instanceof cz) {
                cz czVar = (cz) hnVar;
                if (czVar.getType() == com.byazt.ynb.qa.pr.SIMULTANEOUSLY) {
                    this.aj.pr(czVar);
                    czVar.pr(this);
                } else if (hnVar instanceof yb) {
                    this.vk = ((yb) hnVar).hw();
                }
            } else if (hnVar instanceof yb) {
                this.vk = ((yb) hnVar).hw();
            }
        }
    }

    @Override // com.byazt.ova.m
    public Path x() {
        com.byazt.al.pr<Float, Float> prVar;
        if (this.w) {
            return this.pr;
        }
        this.pr.reset();
        if (this.x) {
            this.w = true;
            return this.pr;
        }
        PointF pointFFw = this.fw.fw();
        float f = pointFFw.x / 2.0f;
        float f2 = pointFFw.y / 2.0f;
        com.byazt.al.pr<?, Float> prVar2 = this.zo;
        float fAj = prVar2 == null ? 0.0f : ((com.byazt.al.x) prVar2).aj();
        if (fAj == 0.0f && (prVar = this.vk) != null) {
            fAj = Math.min(prVar.fw().floatValue(), Math.min(f, f2));
        }
        float fMin = Math.min(f, f2);
        if (fAj > fMin) {
            fAj = fMin;
        }
        PointF pointFFw2 = this.uc.fw();
        this.pr.moveTo(pointFFw2.x + f, (pointFFw2.y - f2) + fAj);
        this.pr.lineTo(pointFFw2.x + f, (pointFFw2.y + f2) - fAj);
        if (fAj > 0.0f) {
            float f3 = fAj * 2.0f;
            this.hw.set((pointFFw2.x + f) - f3, (pointFFw2.y + f2) - f3, pointFFw2.x + f, pointFFw2.y + f2);
            this.pr.arcTo(this.hw, 0.0f, 90.0f, false);
        }
        this.pr.lineTo((pointFFw2.x - f) + fAj, pointFFw2.y + f2);
        if (fAj > 0.0f) {
            float f4 = fAj * 2.0f;
            this.hw.set(pointFFw2.x - f, (pointFFw2.y + f2) - f4, (pointFFw2.x - f) + f4, pointFFw2.y + f2);
            this.pr.arcTo(this.hw, 90.0f, 90.0f, false);
        }
        this.pr.lineTo(pointFFw2.x - f, (pointFFw2.y - f2) + fAj);
        if (fAj > 0.0f) {
            float f5 = fAj * 2.0f;
            this.hw.set(pointFFw2.x - f, pointFFw2.y - f2, (pointFFw2.x - f) + f5, (pointFFw2.y - f2) + f5);
            this.pr.arcTo(this.hw, 180.0f, 90.0f, false);
        }
        this.pr.lineTo((pointFFw2.x + f) - fAj, pointFFw2.y - f2);
        if (fAj > 0.0f) {
            float f6 = fAj * 2.0f;
            this.hw.set((pointFFw2.x + f) - f6, pointFFw2.y - f2, pointFFw2.x + f, (pointFFw2.y - f2) + f6);
            this.pr.arcTo(this.hw, 270.0f, 90.0f, false);
        }
        this.pr.close();
        this.aj.pr(this.pr);
        this.w = true;
        return this.pr;
    }
}
