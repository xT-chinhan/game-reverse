package com.bytedance.adsdk.lottie;

import android.graphics.Bitmap;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class ny {
    private final String ab;
    private final String ah;
    private final String c;
    private final String ch;
    private final String d;
    private final int[][] hi;
    private final String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final int f265ms;
    private final List<xr> ny;
    private final JSONArray sl;
    private Bitmap u;
    private final String x;
    private final int xr;
    private final ms zb;

    public static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public C0190ms f266ms = null;
        public boolean xr;

        /* JADX INFO: renamed from: com.bytedance.adsdk.lottie.ny$ms$ms, reason: collision with other inner class name */
        public static class C0190ms {

            /* JADX INFO: renamed from: ms, reason: collision with root package name */
            public float f267ms = 5.0f;
        }
    }

    public static class xr {
        public int ab;
        public String ah;
        public int c;
        public String d;
        public String ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public int f268ms;
        public String ny;
        public int x;
        public int xr;
    }

    public ny(int i, int i2, String str, String str2, String str3, String str4, List<xr> list, String str5, int[][] iArr, JSONArray jSONArray, String str6, String str7, ms msVar) {
        this.f265ms = i;
        this.xr = i2;
        this.ah = str;
        this.d = str2;
        this.ka = str3;
        this.c = str4;
        this.ab = str6;
        this.x = str7;
        this.ny = list;
        this.ch = str5;
        this.hi = iArr;
        this.sl = jSONArray;
        this.zb = msVar;
    }

    public int ms() {
        return this.f265ms;
    }

    public int xr() {
        return this.xr;
    }

    public List<xr> ah() {
        return this.ny;
    }

    public String d() {
        return this.c;
    }

    public String ka() {
        return this.ab;
    }

    public String c() {
        return this.x;
    }

    public String ab() {
        return this.ch;
    }

    public int[][] x() {
        return this.hi;
    }

    public JSONArray ny() {
        return this.sl;
    }

    public ms ch() {
        return this.zb;
    }

    public String hi() {
        return this.ah;
    }

    public String sl() {
        return this.d;
    }

    public String zb() {
        return this.ka;
    }

    public Bitmap u() {
        return this.u;
    }

    public void ms(Bitmap bitmap) {
        this.u = bitmap;
    }
}
