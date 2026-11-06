package com.smartdigimkt.i2;

import android.view.View;
import com.smartdigimkt.sdk.core.SDKContext;
import java.util.Random;

/* JADX INFO: loaded from: classes3.dex */
public final class m {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public long i;
    public long j;
    public int k;
    public int l;
    public int m;
    public long n = -1;
    public long o = -1;
    public int p;
    public int q;
    public int r;
    public int s;

    public static int b(int i, int i2) {
        if (i == 4) {
            return 2;
        }
        if (i == 18) {
            return 1;
        }
        if (i == 19) {
            return 5;
        }
        switch (i) {
            case 11:
                if (i2 == 15 || i2 == 16 || i2 == 21 || i2 == 48 || i2 == 45 || i2 == 46) {
                    return 1;
                }
                break;
            case 12:
            case 13:
                return 1;
        }
        return 0;
    }

    public final void a(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.e = i3;
        this.f = i4;
        this.i = System.currentTimeMillis();
        if (this.c == 0 && this.d == 0 && this.g == 0 && this.h == 0 && this.j == 0) {
            this.c = i;
            this.d = i2;
            this.g = i3;
            this.h = i4;
            this.j = System.currentTimeMillis() + ((long) (new Random().nextInt(10) + 5));
        }
    }

    public final void a() {
        long j;
        com.smartdigimkt.z.p pVarA = com.smartdigimkt.z.p.a();
        synchronized (pVarA) {
            j = pVarA.d;
        }
        if (j < 0) {
            this.n = -1L;
            this.o = -1L;
            return;
        }
        int iB = pVarA.b();
        int iC = pVarA.c();
        int iD = pVarA.d();
        long jE = pVarA.e();
        if (j >= 0) {
            this.k = iB;
            this.l = iC;
            this.m = iD;
            this.n = j;
            this.o = jE;
        } else {
            this.n = -1L;
            this.o = -1L;
        }
        pVarA.f();
    }

    public final com.smartdigimkt.h0.a a(int i, int i2) {
        float[] fArr;
        com.smartdigimkt.h0.a aVar = new com.smartdigimkt.h0.a();
        aVar.a = this.a;
        aVar.b = this.b;
        int i3 = this.c;
        aVar.c = i3;
        int i4 = this.d;
        aVar.d = i4;
        aVar.e = this.e;
        aVar.f = this.f;
        int i5 = this.g;
        aVar.g = i5;
        int i6 = this.h;
        aVar.h = i6;
        aVar.k = this.i;
        aVar.l = this.j;
        aVar.s = i;
        aVar.t = i2;
        if (i == 0) {
            aVar.a = i3;
            aVar.b = i4;
            aVar.e = i5;
            aVar.f = i6;
        }
        if (i == 2) {
            com.smartdigimkt.z.o oVarA = com.smartdigimkt.z.o.a();
            synchronized (oVarA) {
                fArr = oVarA.c;
            }
            aVar.m = fArr;
        }
        if (i == 5) {
            if (this.n < 0) {
                a();
            }
            long j = this.n;
            if (j >= 0) {
                aVar.n = this.k;
                aVar.o = this.l;
                aVar.p = this.m;
                aVar.q = j;
                aVar.r = this.o;
            }
        }
        return aVar;
    }

    public final com.smartdigimkt.h0.a a(View view, View view2, int i, int i2, int i3) {
        int iB = b(i, i2);
        if (i == 5 || i == 6 || i == 7) {
            a(view, view2, i3);
            iB = 0;
        }
        return a(iB, i2);
    }

    public final void a(View view, View view2, int i) {
        float f;
        float f2;
        float f3;
        float f4;
        int iNextInt;
        int iNextInt2;
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i2 = iArr[0];
        int i3 = iArr[1];
        int width = view.getWidth();
        int height = view.getHeight();
        if (width == 0) {
            width = com.smartdigimkt.r4.h.k(SDKContext.getInstance().d());
            i2 = 0;
        }
        if (height == 0) {
            height = com.smartdigimkt.r4.h.j(SDKContext.getInstance().d());
            i3 = 0;
        }
        if (i == 3) {
            f = 0.08f;
            f2 = 0.92f;
            f3 = 0.25f;
            f4 = 0.75f;
        } else if (i != 4) {
            f2 = 0.9f;
            f = 0.1f;
            f3 = 0.6f;
            f4 = 0.9f;
        } else {
            f2 = 1.0f;
            f = 0.0f;
            f4 = 1.0f;
            f3 = 0.0f;
        }
        Random random = new Random();
        if (width > 0) {
            float f5 = width;
            iNextInt = (int) (f * f5);
            int i4 = (int) (f5 * f2);
            if (i4 > iNextInt) {
                iNextInt += random.nextInt((i4 - iNextInt) + 1);
            }
        } else {
            iNextInt = 0;
        }
        Random random2 = new Random();
        if (height > 0) {
            float f6 = height;
            iNextInt2 = (int) (f3 * f6);
            int i5 = (int) (f6 * f4);
            if (i5 > iNextInt2) {
                iNextInt2 += random2.nextInt((i5 - iNextInt2) + 1);
            }
        } else {
            iNextInt2 = 0;
        }
        int i6 = i2 + iNextInt;
        int i7 = i3 + iNextInt2;
        if (view2 == null) {
            view2 = view;
        }
        if (view2 != view) {
            int[] iArr2 = new int[2];
            view2.getLocationInWindow(iArr2);
            iNextInt = i6 - iArr2[0];
            iNextInt2 = i7 - iArr2[1];
        }
        a(i6, i7, iNextInt, iNextInt2);
        this.c = i6;
        this.d = i7;
        this.g = iNextInt;
        this.h = iNextInt2;
        this.j = System.currentTimeMillis();
    }
}
