package com.byazt.ld;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1423, 19})
public class n {
    public final PointF n;
    public final PointF qg;
    public final PointF s;

    public n() {
        this.n = new PointF();
        this.qg = new PointF();
        this.s = new PointF();
    }

    public n(PointF pointF, PointF pointF2, PointF pointF3) {
        this.n = pointF;
        this.qg = pointF2;
        this.s = pointF3;
    }

    public void n(float f, float f2) {
        this.n.set(f, f2);
    }

    public PointF n() {
        return this.n;
    }

    public void qg(float f, float f2) {
        this.qg.set(f, f2);
    }

    public PointF qg() {
        return this.qg;
    }

    public void s(float f, float f2) {
        this.s.set(f, f2);
    }

    public PointF s() {
        return this.s;
    }

    public String toString() {
        return String.format("v=%.2f,%.2f cp1=%.2f,%.2f cp2=%.2f,%.2f", Float.valueOf(this.s.x), Float.valueOf(this.s.y), Float.valueOf(this.n.x), Float.valueOf(this.n.y), Float.valueOf(this.qg.x), Float.valueOf(this.qg.y));
    }
}
