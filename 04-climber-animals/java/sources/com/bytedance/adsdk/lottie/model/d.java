package com.bytedance.adsdk.lottie.model;

import com.bytedance.adsdk.lottie.model.xr.ao;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    private final double ah;
    private final String c;
    private final double d;
    private final String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final List<ao> f180ms;
    private final char xr;

    public static int ms(char c, String str, String str2) {
        return (((c * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public d(List<ao> list, char c, double d, double d2, String str, String str2) {
        this.f180ms = list;
        this.xr = c;
        this.ah = d;
        this.d = d2;
        this.ka = str;
        this.c = str2;
    }

    public List<ao> ms() {
        return this.f180ms;
    }

    public double xr() {
        return this.d;
    }

    public int hashCode() {
        return ms(this.xr, this.c, this.ka);
    }
}
