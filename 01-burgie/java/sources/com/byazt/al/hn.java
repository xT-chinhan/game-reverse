package com.byazt.al;

import android.graphics.Color;
import android.graphics.Paint;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 60, 20})
public class hn implements pr.InterfaceC0016pr {
    public final pr<Float, Float> c;
    public boolean fw = true;
    public final pr<Float, Float> hn;
    public final pr<Integer, Integer> hw;
    public final pr.InterfaceC0016pr pr;
    public final pr<Float, Float> uc;
    public final pr<Float, Float> x;

    public hn(pr.InterfaceC0016pr interfaceC0016pr, com.byazt.cg.hn hnVar, com.byazt.tx.vk vkVar) {
        this.pr = interfaceC0016pr;
        pr<Integer, Integer> prVarPr = vkVar.pr().pr();
        this.hw = prVarPr;
        prVarPr.pr(this);
        hnVar.pr(prVarPr);
        pr<Float, Float> prVarPr2 = vkVar.hw().pr();
        this.hn = prVarPr2;
        prVarPr2.pr(this);
        hnVar.pr(prVarPr2);
        pr<Float, Float> prVarPr3 = vkVar.hn().pr();
        this.x = prVarPr3;
        prVarPr3.pr(this);
        hnVar.pr(prVarPr3);
        pr<Float, Float> prVarPr4 = vkVar.x().pr();
        this.c = prVarPr4;
        prVarPr4.pr(this);
        hnVar.pr(prVarPr4);
        pr<Float, Float> prVarPr5 = vkVar.c().pr();
        this.uc = prVarPr5;
        prVarPr5.pr(this);
        hnVar.pr(prVarPr5);
    }

    @Override // com.byazt.al.pr.InterfaceC0016pr
    public void pr() {
        this.fw = true;
        this.pr.pr();
    }

    public void pr(Paint paint) {
        if (!this.fw) {
            return;
        }
        this.fw = false;
        double dFloatValue = ((double) this.x.fw().floatValue()) * 0.017453292519943295d;
        float fFloatValue = this.c.fw().floatValue();
        float fSin = ((float) Math.sin(dFloatValue)) * fFloatValue;
        float fCos = ((float) Math.cos(dFloatValue + 3.141592653589793d)) * fFloatValue;
        int iIntValue = this.hw.fw().intValue();
        paint.setShadowLayer(this.uc.fw().floatValue(), fSin, fCos, Color.argb(Math.round(this.hn.fw().floatValue()), Color.red(iIntValue), Color.green(iIntValue), Color.blue(iIntValue)));
    }
}
