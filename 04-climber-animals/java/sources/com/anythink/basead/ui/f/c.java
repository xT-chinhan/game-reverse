package com.anythink.basead.ui.f;

import android.view.View;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.w;
import com.anythink.core.common.v.m;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static final int j = -999;
    int a;
    int b;
    int c;
    int d;
    int e;
    int f;
    int g;
    int h;
    public com.anythink.basead.d.a i;
    private long k;
    private long l;
    private w m;

    public static int a(int i, int i2) {
        if (i == 4) {
            return 2;
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

    public c(w wVar) {
        this.m = wVar;
    }

    public final void a(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.e = i3;
        this.f = i4;
        this.k = System.currentTimeMillis();
        if (this.c == 0 && this.d == 0 && this.g == 0 && this.h == 0 && this.l == 0) {
            this.c = i;
            this.d = i2;
            this.g = i3;
            this.h = i4;
            this.l = System.currentTimeMillis() + ((long) (new Random().nextInt(10) + 5));
        }
    }

    public final void b(int i, int i2, int i3, int i4) {
        this.c = i;
        this.d = i2;
        this.g = i3;
        this.h = i4;
        this.l = System.currentTimeMillis();
    }

    public final com.anythink.basead.d.a a() {
        return a(0);
    }

    private com.anythink.basead.d.a a(int i) {
        com.anythink.basead.d.a aVar = new com.anythink.basead.d.a();
        aVar.a = this.a;
        aVar.b = this.b;
        aVar.c = this.c;
        aVar.d = this.d;
        aVar.e = this.e;
        aVar.f = this.f;
        aVar.g = this.g;
        aVar.h = this.h;
        aVar.k = this.k;
        aVar.l = this.l;
        aVar.n = i;
        if (i == 2) {
            aVar.m = com.anythink.core.express.c.a.a().c();
        }
        aVar.o = this.i;
        return aVar;
    }

    public final com.anythink.basead.d.a a(View view, int i, int i2) {
        w wVar;
        int iA = a(i, i2);
        if (i == 4 && (wVar = this.m) != null && wVar.ai() == 1) {
            c cVar = new c(this.m);
            cVar.b(view);
            this.i = cVar.a(0);
        }
        if (i == 5 || i == 6 || i == 7) {
            b(view);
            iA = 0;
        }
        return a(iA);
    }

    public final void a(View view) {
        b(view);
    }

    private void b(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i = 0;
        int i2 = iArr[0];
        int i3 = iArr[1];
        int width = view.getWidth();
        int height = view.getHeight();
        if (width == 0) {
            width = m.j(t.b().g());
            i2 = 0;
        }
        if (height == 0) {
            height = m.k(t.b().g());
        } else {
            i = i3;
        }
        int iB = b(width);
        int iB2 = b(height);
        int i4 = i2 + iB;
        int i5 = i + iB2;
        int iRandom = ((int) (Math.random() * 15.0d)) + i4;
        int iRandom2 = ((int) (Math.random() * 15.0d)) + i5;
        a(i4, i5, iB, iB2);
        b(iRandom, iRandom2, iRandom - i2, iRandom2 - i);
    }

    private com.anythink.basead.d.a c(View view) {
        c cVar = new c(this.m);
        cVar.b(view);
        return cVar.a(0);
    }

    private static int b(int i) {
        Random random = new Random();
        if (i <= 0) {
            return 0;
        }
        double d = i;
        int i2 = (int) (0.1d * d);
        return random.nextInt((((int) (d * 0.9d)) - i2) + 1) + i2;
    }
}
