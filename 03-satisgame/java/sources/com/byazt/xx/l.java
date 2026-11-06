package com.byazt.xx;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 719, 18})
public class l {
    public int cp;
    public boolean cy;
    public Bitmap d;
    public double fs;
    public boolean hd;
    public double k;
    public double l;
    public String n;
    public double q;
    public String qg;
    public double sz;
    public double w;
    public double x;
    public int s = 0;
    public double rv = 1.0d;
    public double tj = 1.0d;
    public boolean oa = true;

    public boolean n(double d, double d2) {
        double d3 = this.x;
        double d4 = this.tj;
        double d5 = (d3 * d4) / 2.0d;
        double d6 = (this.fs * d4) / 2.0d;
        double d7 = this.l;
        if (d < d7 - d5 || d > d7 + d5) {
            return false;
        }
        double d8 = this.w;
        return d2 >= d8 - d6 && d2 <= d8 + d6;
    }
}
