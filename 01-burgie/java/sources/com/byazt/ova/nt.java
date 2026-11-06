package com.byazt.ova;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 423, 74})
public class nt implements com.byazt.al.pr.InterfaceC0016pr, c, m, vk, w {
    public final com.byazt.al.nt aj;
    public final String c;
    public final com.byazt.al.pr<Float, Float> fw;
    public final com.byazt.dx.zo hn;
    public final boolean uc;
    public x vk;
    public final com.byazt.cg.hn x;
    public final com.byazt.al.pr<Float, Float> zo;
    public final Matrix pr = new Matrix();
    public final Path hw = new Path();

    public nt(com.byazt.dx.zo zoVar, com.byazt.cg.hn hnVar, com.byazt.ynb.k kVar) {
        this.hn = zoVar;
        this.x = hnVar;
        this.c = kVar.pr();
        this.uc = kVar.c();
        com.byazt.al.pr<Float, Float> prVarPr = kVar.hw().pr();
        this.fw = prVarPr;
        hnVar.pr(prVarPr);
        prVarPr.pr(this);
        com.byazt.al.pr<Float, Float> prVarPr2 = kVar.hn().pr();
        this.zo = prVarPr2;
        hnVar.pr(prVarPr2);
        prVarPr2.pr(this);
        com.byazt.al.nt ntVarVk = kVar.x().vk();
        this.aj = ntVarVk;
        ntVarVk.pr(hnVar);
        ntVarVk.pr(this);
    }

    @Override // com.byazt.ova.vk
    public void pr(ListIterator<hn> listIterator) {
        if (this.vk != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.vk = new x(this.hn, this.x, "Repeater", this.uc, arrayList, null);
    }

    @Override // com.byazt.ova.hn
    public void pr(List<hn> list, List<hn> list2) {
        this.vk.pr(list, list2);
    }

    @Override // com.byazt.ova.m
    public Path x() {
        Path pathX = this.vk.x();
        this.hw.reset();
        float fFloatValue = this.fw.fw().floatValue();
        float fFloatValue2 = this.zo.fw().floatValue();
        for (int i = ((int) fFloatValue) - 1; i >= 0; i--) {
            this.pr.set(this.aj.hw(i + fFloatValue2));
            this.hw.addPath(pathX, this.pr);
        }
        return this.hw;
    }

    @Override // com.byazt.ova.c
    public void pr(Canvas canvas, Matrix matrix, int i) {
        float fFloatValue = this.fw.fw().floatValue();
        float fFloatValue2 = this.zo.fw().floatValue();
        float fFloatValue3 = this.aj.hw().fw().floatValue() / 100.0f;
        float fFloatValue4 = this.aj.hn().fw().floatValue() / 100.0f;
        for (int i2 = ((int) fFloatValue) - 1; i2 >= 0; i2--) {
            this.pr.set(matrix);
            float f = i2;
            this.pr.preConcat(this.aj.hw(f + fFloatValue2));
            this.vk.pr(canvas, this.pr, (int) (i * com.byazt.ptr.aj.pr(fFloatValue3, fFloatValue4, f / fFloatValue)));
        }
    }

    @Override // com.byazt.ova.c
    public void pr(RectF rectF, Matrix matrix, boolean z) {
        this.vk.pr(rectF, matrix, z);
    }

    @Override // com.byazt.al.pr.InterfaceC0016pr
    public void pr() {
        this.hn.invalidateSelf();
    }
}
