package com.byazt.uxi;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1300, 37})
public class pr {
    public final PointF hn;
    public final PointF hw;
    public final PointF pr;

    public pr() {
        this.pr = new PointF();
        this.hw = new PointF();
        this.hn = new PointF();
    }

    public pr(PointF pointF, PointF pointF2, PointF pointF3) {
        this.pr = pointF;
        this.hw = pointF2;
        this.hn = pointF3;
    }

    public void pr(float f, float f2) {
        this.pr.set(f, f2);
    }

    public PointF pr() {
        return this.pr;
    }

    public void hw(float f, float f2) {
        this.hw.set(f, f2);
    }

    public PointF hw() {
        return this.hw;
    }

    public void hn(float f, float f2) {
        this.hn.set(f, f2);
    }

    public PointF hn() {
        return this.hn;
    }

    public String toString() {
        return String.format("v=%.2f,%.2f cp1=%.2f,%.2f cp2=%.2f,%.2f", Float.valueOf(this.hn.x), Float.valueOf(this.hn.y), Float.valueOf(this.pr.x), Float.valueOf(this.pr.y), Float.valueOf(this.hw.x), Float.valueOf(this.hw.y));
    }
}
