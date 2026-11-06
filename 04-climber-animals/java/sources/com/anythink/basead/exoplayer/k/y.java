package com.anythink.basead.exoplayer.k;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public final class y {
    private static final Comparator<a> a = new Comparator<a>() { // from class: com.anythink.basead.exoplayer.k.y.1
        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(a aVar, a aVar2) {
            return aVar.a - aVar2.a;
        }

        private static int a(a aVar, a aVar2) {
            return aVar.a - aVar2.a;
        }
    };
    private static final Comparator<a> b = new Comparator<a>() { // from class: com.anythink.basead.exoplayer.k.y.2
        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(a aVar, a aVar2) {
            a aVar3 = aVar;
            a aVar4 = aVar2;
            if (aVar3.c < aVar4.c) {
                return -1;
            }
            return aVar4.c < aVar3.c ? 1 : 0;
        }

        private static int a(a aVar, a aVar2) {
            if (aVar.c < aVar2.c) {
                return -1;
            }
            return aVar2.c < aVar.c ? 1 : 0;
        }
    };
    private static final int c = -1;
    private static final int d = 0;
    private static final int e = 1;
    private static final int f = 5;
    private final int g;
    private int k;
    private int l;
    private int m;
    private final a[] i = new a[5];
    private final ArrayList<a> h = new ArrayList<>();
    private int j = -1;

    public y(int i) {
        this.g = i;
    }

    private void b() {
        if (this.j != 1) {
            Collections.sort(this.h, a);
            this.j = 1;
        }
    }

    private void c() {
        if (this.j != 0) {
            Collections.sort(this.h, b);
            this.j = 0;
        }
    }

    private static class a {
        public int a;
        public int b;
        public float c;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public final void a(int i, float f2) {
        a aVar;
        if (this.j != 1) {
            Collections.sort(this.h, a);
            this.j = 1;
        }
        int i2 = this.m;
        byte b2 = 0;
        if (i2 > 0) {
            a[] aVarArr = this.i;
            int i3 = i2 - 1;
            this.m = i3;
            aVar = aVarArr[i3];
        } else {
            aVar = new a(b2);
        }
        int i4 = this.k;
        this.k = i4 + 1;
        aVar.a = i4;
        aVar.b = i;
        aVar.c = f2;
        this.h.add(aVar);
        this.l += i;
        while (true) {
            int i5 = this.l;
            int i6 = this.g;
            if (i5 <= i6) {
                return;
            }
            int i7 = i5 - i6;
            a aVar2 = this.h.get(0);
            if (aVar2.b <= i7) {
                this.l -= aVar2.b;
                this.h.remove(0);
                int i8 = this.m;
                if (i8 < 5) {
                    a[] aVarArr2 = this.i;
                    this.m = i8 + 1;
                    aVarArr2[i8] = aVar2;
                }
            } else {
                aVar2.b -= i7;
                this.l -= i7;
            }
        }
    }

    public final float a() {
        if (this.j != 0) {
            Collections.sort(this.h, b);
            this.j = 0;
        }
        float f2 = this.l * 0.5f;
        int i = 0;
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            a aVar = this.h.get(i2);
            i += aVar.b;
            if (i >= f2) {
                return aVar.c;
            }
        }
        if (this.h.isEmpty()) {
            return Float.NaN;
        }
        ArrayList<a> arrayList = this.h;
        return arrayList.get(arrayList.size() - 1).c;
    }
}
