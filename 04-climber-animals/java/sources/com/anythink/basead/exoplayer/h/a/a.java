package com.anythink.basead.exoplayer.h.a;

import android.net.Uri;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final a f = new a(new long[0]);
    public final int g;
    public final long[] h;
    public final C0028a[] i;
    public final long j;
    public final long k;

    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    /* JADX INFO: renamed from: com.anythink.basead.exoplayer.h.a.a$a, reason: collision with other inner class name */
    public static final class C0028a {
        public final int a;
        public final Uri[] b;
        public final int[] c;
        public final long[] d;

        public C0028a() {
            this(-1, new int[0], new Uri[0], new long[0]);
        }

        private C0028a(int i, int[] iArr, Uri[] uriArr, long[] jArr) {
            com.anythink.basead.exoplayer.k.a.a(iArr.length == uriArr.length);
            this.a = i;
            this.c = iArr;
            this.b = uriArr;
            this.d = jArr;
        }

        private int c() {
            return a(-1);
        }

        public final int a(int i) {
            int i2;
            int i3 = i + 1;
            while (true) {
                int[] iArr = this.c;
                if (i3 >= iArr.length || (i2 = iArr[i3]) == 0 || i2 == 1) {
                    break;
                }
                i3++;
            }
            return i3;
        }

        public final boolean a() {
            return this.a == -1 || a(-1) < this.a;
        }

        public final C0028a b(int i) {
            com.anythink.basead.exoplayer.k.a.a(this.a == -1 && this.c.length <= i);
            return new C0028a(i, a(this.c, i), (Uri[]) Arrays.copyOf(this.b, i), a(this.d, i));
        }

        public final C0028a a(Uri uri, int i) {
            int i2 = this.a;
            com.anythink.basead.exoplayer.k.a.a(i2 == -1 || i < i2);
            int[] iArrA = a(this.c, i + 1);
            com.anythink.basead.exoplayer.k.a.a(iArrA[i] == 0);
            long[] jArrA = this.d;
            if (jArrA.length != iArrA.length) {
                jArrA = a(jArrA, iArrA.length);
            }
            Uri[] uriArr = (Uri[]) Arrays.copyOf(this.b, iArrA.length);
            uriArr[i] = uri;
            iArrA[i] = 1;
            return new C0028a(this.a, iArrA, uriArr, jArrA);
        }

        public final C0028a a(int i, int i2) {
            int i3 = this.a;
            com.anythink.basead.exoplayer.k.a.a(i3 == -1 || i2 < i3);
            int[] iArrA = a(this.c, i2 + 1);
            int i4 = iArrA[i2];
            com.anythink.basead.exoplayer.k.a.a(i4 == 0 || i4 == 1 || i4 == i);
            long[] jArrA = this.d;
            if (jArrA.length != iArrA.length) {
                jArrA = a(jArrA, iArrA.length);
            }
            Uri[] uriArr = this.b;
            if (uriArr.length != iArrA.length) {
                uriArr = (Uri[]) Arrays.copyOf(uriArr, iArrA.length);
            }
            iArrA[i2] = i;
            return new C0028a(this.a, iArrA, uriArr, jArrA);
        }

        public final C0028a a(long[] jArr) {
            com.anythink.basead.exoplayer.k.a.a(this.a == -1 || jArr.length <= this.b.length);
            int length = jArr.length;
            Uri[] uriArr = this.b;
            if (length < uriArr.length) {
                jArr = a(jArr, uriArr.length);
            }
            return new C0028a(this.a, this.c, this.b, jArr);
        }

        public final C0028a b() {
            if (this.a == -1) {
                return new C0028a(0, new int[0], new Uri[0], new long[0]);
            }
            int[] iArr = this.c;
            int length = iArr.length;
            int[] iArrCopyOf = Arrays.copyOf(iArr, length);
            for (int i = 0; i < length; i++) {
                int i2 = iArrCopyOf[i];
                if (i2 == 1 || i2 == 0) {
                    iArrCopyOf[i] = 2;
                }
            }
            return new C0028a(length, iArrCopyOf, this.b, this.d);
        }

        private static int[] a(int[] iArr, int i) {
            int length = iArr.length;
            int iMax = Math.max(i, length);
            int[] iArrCopyOf = Arrays.copyOf(iArr, iMax);
            Arrays.fill(iArrCopyOf, length, iMax, 0);
            return iArrCopyOf;
        }

        private static long[] a(long[] jArr, int i) {
            int length = jArr.length;
            int iMax = Math.max(i, length);
            long[] jArrCopyOf = Arrays.copyOf(jArr, iMax);
            Arrays.fill(jArrCopyOf, length, iMax, -9223372036854775807L);
            return jArrCopyOf;
        }
    }

    private a(long... jArr) {
        this.g = 0;
        this.h = Arrays.copyOf(jArr, 0);
        this.i = new C0028a[0];
        this.j = 0L;
        this.k = -9223372036854775807L;
    }

    private a(long[] jArr, C0028a[] c0028aArr, long j, long j2) {
        this.g = c0028aArr.length;
        this.h = jArr;
        this.i = c0028aArr;
        this.j = j;
        this.k = j2;
    }

    private int a(long j) {
        int length = this.h.length - 1;
        while (length >= 0) {
            long j2 = this.h[length];
            if (j2 != Long.MIN_VALUE && j2 <= j) {
                break;
            }
            length--;
        }
        if (length < 0 || !this.i[length].a()) {
            return -1;
        }
        return length;
    }

    private int b(long j) {
        int i = 0;
        while (true) {
            long[] jArr = this.h;
            if (i >= jArr.length) {
                break;
            }
            long j2 = jArr[i];
            if (j2 == Long.MIN_VALUE || (j < j2 && this.i[i].a())) {
                break;
            }
            i++;
        }
        if (i < this.h.length) {
            return i;
        }
        return -1;
    }

    private a a(int i, int i2) {
        com.anythink.basead.exoplayer.k.a.a(i2 > 0);
        if (this.i[i].a == i2) {
            return this;
        }
        C0028a[] c0028aArr = this.i;
        C0028a[] c0028aArr2 = (C0028a[]) Arrays.copyOf(c0028aArr, c0028aArr.length);
        c0028aArr2[i] = this.i[i].b(i2);
        return new a(this.h, c0028aArr2, this.j, this.k);
    }

    private a a(int i, int i2, Uri uri) {
        C0028a[] c0028aArr = this.i;
        C0028a[] c0028aArr2 = (C0028a[]) Arrays.copyOf(c0028aArr, c0028aArr.length);
        c0028aArr2[i] = c0028aArr2[i].a(uri, i2);
        return new a(this.h, c0028aArr2, this.j, this.k);
    }

    private a b(int i, int i2) {
        C0028a[] c0028aArr = this.i;
        C0028a[] c0028aArr2 = (C0028a[]) Arrays.copyOf(c0028aArr, c0028aArr.length);
        c0028aArr2[i] = c0028aArr2[i].a(3, i2);
        return new a(this.h, c0028aArr2, this.j, this.k);
    }

    private a c(int i, int i2) {
        C0028a[] c0028aArr = this.i;
        C0028a[] c0028aArr2 = (C0028a[]) Arrays.copyOf(c0028aArr, c0028aArr.length);
        c0028aArr2[i] = c0028aArr2[i].a(2, i2);
        return new a(this.h, c0028aArr2, this.j, this.k);
    }

    private a d(int i, int i2) {
        C0028a[] c0028aArr = this.i;
        C0028a[] c0028aArr2 = (C0028a[]) Arrays.copyOf(c0028aArr, c0028aArr.length);
        c0028aArr2[i] = c0028aArr2[i].a(4, i2);
        return new a(this.h, c0028aArr2, this.j, this.k);
    }

    private a a(int i) {
        C0028a[] c0028aArr = this.i;
        C0028a[] c0028aArr2 = (C0028a[]) Arrays.copyOf(c0028aArr, c0028aArr.length);
        c0028aArr2[i] = c0028aArr2[i].b();
        return new a(this.h, c0028aArr2, this.j, this.k);
    }

    public final a a(long[][] jArr) {
        C0028a[] c0028aArr = this.i;
        C0028a[] c0028aArr2 = (C0028a[]) Arrays.copyOf(c0028aArr, c0028aArr.length);
        for (int i = 0; i < this.g; i++) {
            c0028aArr2[i] = c0028aArr2[i].a(jArr[i]);
        }
        return new a(this.h, c0028aArr2, this.j, this.k);
    }

    private a c(long j) {
        return this.j == j ? this : new a(this.h, this.i, j, this.k);
    }

    private a d(long j) {
        return this.k == j ? this : new a(this.h, this.i, this.j, j);
    }
}
