package com.byazt.uw;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1462, 13})
public final class w {
    public int[] fs;
    public float[] l;
    public int n;
    public float[] q;
    public int qg;
    public int[] rv;
    public float[] s;
    public float[] w;
    public float[] x;

    public void n(int i) {
        float[] fArr = this.s;
        if (fArr == null || fArr.length < i) {
            this.s = new float[i];
            this.q = new float[i];
            this.l = new float[i];
            this.w = new float[i];
            this.x = new float[i];
            this.fs = new int[i];
            this.rv = new int[i];
        }
    }
}
