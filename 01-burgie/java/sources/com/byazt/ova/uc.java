package com.byazt.ova;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 423, 5})
public class uc implements com.byazt.al.pr.InterfaceC0016pr, m, w {
    public final com.byazt.al.pr<?, PointF> c;
    public final com.byazt.dx.zo hn;
    public final String hw;
    public final com.byazt.ynb.hw uc;
    public final com.byazt.al.pr<?, PointF> x;
    public boolean zo;
    public final Path pr = new Path();
    public final hw fw = new hw();

    public uc(com.byazt.dx.zo zoVar, com.byazt.cg.hn hnVar, com.byazt.ynb.hw hwVar) {
        this.hw = hwVar.pr();
        this.hn = zoVar;
        com.byazt.al.pr<PointF, PointF> prVarPr = hwVar.hn().pr();
        this.x = prVarPr;
        com.byazt.al.pr<PointF, PointF> prVarPr2 = hwVar.hw().pr();
        this.c = prVarPr2;
        this.uc = hwVar;
        hnVar.pr(prVarPr);
        hnVar.pr(prVarPr2);
        prVarPr.pr(this);
        prVarPr2.pr(this);
    }

    @Override // com.byazt.al.pr.InterfaceC0016pr
    public void pr() {
        hw();
    }

    private void hw() {
        this.zo = false;
        this.hn.invalidateSelf();
    }

    @Override // com.byazt.ova.hn
    public void pr(List<hn> list, List<hn> list2) {
        for (int i = 0; i < list.size(); i++) {
            hn hnVar = list.get(i);
            if (hnVar instanceof cz) {
                cz czVar = (cz) hnVar;
                if (czVar.getType() == com.byazt.ynb.qa.pr.SIMULTANEOUSLY) {
                    this.fw.pr(czVar);
                    czVar.pr(this);
                }
            }
        }
    }

    @Override // com.byazt.ova.m
    public Path x() {
        if (this.zo) {
            return this.pr;
        }
        this.pr.reset();
        if (this.uc.c()) {
            this.zo = true;
            return this.pr;
        }
        PointF pointFFw = this.x.fw();
        float f = pointFFw.x / 2.0f;
        float f2 = pointFFw.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = 0.55228f * f2;
        this.pr.reset();
        if (this.uc.x()) {
            float f5 = -f2;
            this.pr.moveTo(0.0f, f5);
            float f6 = 0.0f - f3;
            float f7 = -f;
            float f8 = 0.0f - f4;
            this.pr.cubicTo(f6, f5, f7, f8, f7, 0.0f);
            float f9 = f4 + 0.0f;
            this.pr.cubicTo(f7, f9, f6, f2, 0.0f, f2);
            float f10 = f3 + 0.0f;
            this.pr.cubicTo(f10, f2, f, f9, f, 0.0f);
            this.pr.cubicTo(f, f8, f10, f5, 0.0f, f5);
        } else {
            float f11 = -f2;
            this.pr.moveTo(0.0f, f11);
            float f12 = f3 + 0.0f;
            float f13 = 0.0f - f4;
            this.pr.cubicTo(f12, f11, f, f13, f, 0.0f);
            float f14 = f4 + 0.0f;
            this.pr.cubicTo(f, f14, f12, f2, 0.0f, f2);
            float f15 = 0.0f - f3;
            float f16 = -f;
            this.pr.cubicTo(f15, f2, f16, f14, f16, 0.0f);
            this.pr.cubicTo(f16, f13, f15, f11, 0.0f, f11);
        }
        PointF pointFFw2 = this.c.fw();
        this.pr.offset(pointFFw2.x, pointFFw2.y);
        this.pr.close();
        this.fw.pr(this.pr);
        this.zo = true;
        return this.pr;
    }
}
