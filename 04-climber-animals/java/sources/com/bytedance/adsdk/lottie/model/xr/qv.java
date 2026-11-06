package com.bytedance.adsdk.lottie.model.xr;

import android.graphics.Paint;
import com.bytedance.adsdk.lottie.ms.ms.t;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class qv implements ah {
    private final ms ab;
    private final List<com.bytedance.adsdk.lottie.model.ms.xr> ah;
    private final com.bytedance.adsdk.lottie.model.ms.xr c;
    private final boolean ch;
    private final com.bytedance.adsdk.lottie.model.ms.ms d;
    private final com.bytedance.adsdk.lottie.model.ms.d ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final String f228ms;
    private final float ny;
    private final xr x;
    private final com.bytedance.adsdk.lottie.model.ms.xr xr;

    public enum ms {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap ms() {
            int i = AnonymousClass1.f229ms[ordinal()];
            if (i == 1) {
                return Paint.Cap.BUTT;
            }
            if (i == 2) {
                return Paint.Cap.ROUND;
            }
            return Paint.Cap.SQUARE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.lottie.model.xr.qv$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        static final /* synthetic */ int[] f229ms;
        static final /* synthetic */ int[] xr;

        static {
            int[] iArr = new int[xr.values().length];
            xr = iArr;
            try {
                iArr[xr.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                xr[xr.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                xr[xr.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[ms.values().length];
            f229ms = iArr2;
            try {
                iArr2[ms.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f229ms[ms.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f229ms[ms.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public enum xr {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join ms() {
            int i = AnonymousClass1.xr[ordinal()];
            if (i == 1) {
                return Paint.Join.BEVEL;
            }
            if (i == 2) {
                return Paint.Join.MITER;
            }
            if (i != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    public qv(String str, com.bytedance.adsdk.lottie.model.ms.xr xrVar, List<com.bytedance.adsdk.lottie.model.ms.xr> list, com.bytedance.adsdk.lottie.model.ms.ms msVar, com.bytedance.adsdk.lottie.model.ms.d dVar, com.bytedance.adsdk.lottie.model.ms.xr xrVar2, ms msVar2, xr xrVar3, float f, boolean z) {
        this.f228ms = str;
        this.xr = xrVar;
        this.ah = list;
        this.d = msVar;
        this.ka = dVar;
        this.c = xrVar2;
        this.ab = msVar2;
        this.x = xrVar3;
        this.ny = f;
        this.ch = z;
    }

    @Override // com.bytedance.adsdk.lottie.model.xr.ah
    public com.bytedance.adsdk.lottie.ms.ms.ah ms(com.bytedance.adsdk.lottie.x xVar, com.bytedance.adsdk.lottie.c cVar, com.bytedance.adsdk.lottie.model.layer.ah ahVar) {
        return new t(xVar, ahVar, this);
    }

    public String ms() {
        return this.f228ms;
    }

    public com.bytedance.adsdk.lottie.model.ms.ms xr() {
        return this.d;
    }

    public com.bytedance.adsdk.lottie.model.ms.d ah() {
        return this.ka;
    }

    public com.bytedance.adsdk.lottie.model.ms.xr d() {
        return this.c;
    }

    public List<com.bytedance.adsdk.lottie.model.ms.xr> ka() {
        return this.ah;
    }

    public com.bytedance.adsdk.lottie.model.ms.xr c() {
        return this.xr;
    }

    public ms ab() {
        return this.ab;
    }

    public xr x() {
        return this.x;
    }

    public float ny() {
        return this.ny;
    }

    public boolean ch() {
        return this.ch;
    }
}
