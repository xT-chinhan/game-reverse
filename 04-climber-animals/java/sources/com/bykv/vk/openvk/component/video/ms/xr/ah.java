package com.bykv.vk.openvk.component.video.ms.xr;

/* JADX INFO: loaded from: classes.dex */
public class ah {
    private final long ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final long f64ms;
    private final long xr;

    public long ms(int i) {
        if (i <= 0) {
            return this.f64ms;
        }
        return Math.min(this.f64ms + (this.xr * ((long) i)), this.ah);
    }
}
