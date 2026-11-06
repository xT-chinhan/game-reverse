package com.ss.android.socialbase.downloader.network;

/* JADX INFO: loaded from: classes3.dex */
class d {
    private double ah = -1.0d;
    private int d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final double f4725ms;
    private final int xr;

    public d(double d) {
        this.f4725ms = d;
        this.xr = d == 0.0d ? Integer.MAX_VALUE : (int) Math.ceil(1.0d / d);
    }

    public void ms(double d) {
        double d2 = 1.0d - this.f4725ms;
        int i = this.d;
        if (i > this.xr) {
            this.ah = Math.exp((d2 * Math.log(this.ah)) + (this.f4725ms * Math.log(d)));
        } else if (i > 0) {
            double d3 = (d2 * ((double) i)) / (((double) i) + 1.0d);
            this.ah = Math.exp((d3 * Math.log(this.ah)) + ((1.0d - d3) * Math.log(d)));
        } else {
            this.ah = d;
        }
        this.d++;
    }

    public double ms() {
        return this.ah;
    }
}
