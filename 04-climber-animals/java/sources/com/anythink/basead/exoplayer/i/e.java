package com.anythink.basead.exoplayer.i;

import android.util.Pair;
import com.anythink.basead.exoplayer.aa;
import com.anythink.basead.exoplayer.h.ae;
import com.anythink.basead.exoplayer.h.af;
import com.anythink.basead.exoplayer.z;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class e extends h {
    private a a;

    protected abstract Pair<aa[], f[]> a(a aVar, int[][][] iArr, int[] iArr2);

    public static final class a {
        public static final int a = 0;
        public static final int b = 1;
        public static final int c = 2;
        public static final int d = 3;

        @Deprecated
        public final int e;
        private final int f;
        private final int[] g;
        private final af[] h;
        private final int[] i;
        private final int[][][] j;
        private final af k;

        /* JADX INFO: renamed from: com.anythink.basead.exoplayer.i.e$a$a, reason: collision with other inner class name */
        @Retention(RetentionPolicy.SOURCE)
        @interface InterfaceC0035a {
        }

        a(int[] iArr, af[] afVarArr, int[] iArr2, int[][][] iArr3, af afVar) {
            this.g = iArr;
            this.h = afVarArr;
            this.j = iArr3;
            this.i = iArr2;
            this.k = afVar;
            int length = iArr.length;
            this.f = length;
            this.e = length;
        }

        public final int a() {
            return this.f;
        }

        public final int a(int i) {
            return this.g[i];
        }

        public final af b(int i) {
            return this.h[i];
        }

        private int c(int i) {
            int i2;
            int iMax = 0;
            for (int[] iArr : this.j[i]) {
                int i3 = 0;
                while (true) {
                    if (i3 < iArr.length) {
                        int i4 = iArr[i3] & 7;
                        if (i4 == 3) {
                            i2 = 2;
                        } else {
                            if (i4 == 4) {
                                return 3;
                            }
                            i2 = 1;
                        }
                        iMax = Math.max(iMax, i2);
                        i3++;
                    }
                }
            }
            return iMax;
        }

        private int e(int i) {
            int i2;
            int iMax = 0;
            for (int i3 = 0; i3 < this.f; i3++) {
                if (this.g[i3] == i) {
                    int iMax2 = 0;
                    for (int[] iArr : this.j[i3]) {
                        int i4 = 0;
                        while (true) {
                            if (i4 < iArr.length) {
                                int i5 = iArr[i4] & 7;
                                if (i5 == 3) {
                                    i2 = 2;
                                } else {
                                    if (i5 == 4) {
                                        iMax2 = 3;
                                        break;
                                    }
                                    i2 = 1;
                                }
                                iMax2 = Math.max(iMax2, i2);
                                i4++;
                            }
                        }
                    }
                    iMax = Math.max(iMax, iMax2);
                }
            }
            return iMax;
        }

        @Deprecated
        private int b(int i, int i2, int i3) {
            return a(i, i2, i3);
        }

        public final int a(int i, int i2, int i3) {
            return this.j[i][i2][i3] & 7;
        }

        public final int a(int i, int i2) {
            int i3 = this.h[i].a(i2).a;
            int[] iArr = new int[i3];
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < i3; i6++) {
                if (a(i, i2, i6) == 4) {
                    iArr[i5] = i6;
                    i5++;
                }
            }
            int[] iArrCopyOf = Arrays.copyOf(iArr, i5);
            int iMin = 16;
            int i7 = 0;
            String str = null;
            boolean z = false;
            while (i4 < iArrCopyOf.length) {
                String str2 = this.h[i].a(i2).a(iArrCopyOf[i4]).h;
                int i8 = i7 + 1;
                if (i7 == 0) {
                    str = str2;
                } else {
                    z |= !com.anythink.basead.exoplayer.k.af.a((Object) str, (Object) str2);
                }
                iMin = Math.min(iMin, this.j[i][i2][i4] & 24);
                i4++;
                i7 = i8;
            }
            return z ? Math.min(iMin, this.i[i]) : iMin;
        }

        private int a(int i, int i2, int[] iArr) {
            int i3 = 0;
            int iMin = 16;
            String str = null;
            boolean z = false;
            int i4 = 0;
            while (i3 < iArr.length) {
                String str2 = this.h[i].a(i2).a(iArr[i3]).h;
                int i5 = i4 + 1;
                if (i4 == 0) {
                    str = str2;
                } else {
                    z |= !com.anythink.basead.exoplayer.k.af.a((Object) str, (Object) str2);
                }
                iMin = Math.min(iMin, this.j[i][i2][i3] & 24);
                i3++;
                i4 = i5;
            }
            return z ? Math.min(iMin, this.i[i]) : iMin;
        }

        public final af b() {
            return this.k;
        }

        @Deprecated
        private int d(int i) {
            int i2;
            int iMax = 0;
            for (int i3 = 0; i3 < this.f; i3++) {
                if (this.g[i3] == i) {
                    int iMax2 = 0;
                    for (int[] iArr : this.j[i3]) {
                        int i4 = 0;
                        while (true) {
                            if (i4 < iArr.length) {
                                int i5 = iArr[i4] & 7;
                                if (i5 == 3) {
                                    i2 = 2;
                                } else {
                                    if (i5 == 4) {
                                        iMax2 = 3;
                                        break;
                                    }
                                    i2 = 1;
                                }
                                iMax2 = Math.max(iMax2, i2);
                                i4++;
                            }
                        }
                    }
                    iMax = Math.max(iMax, iMax2);
                }
            }
            return iMax;
        }

        @Deprecated
        private af c() {
            return this.k;
        }
    }

    public final a a() {
        return this.a;
    }

    @Override // com.anythink.basead.exoplayer.i.h
    public final void a(Object obj) {
        this.a = (a) obj;
    }

    @Override // com.anythink.basead.exoplayer.i.h
    public final i a(z[] zVarArr, af afVar) {
        int[] iArr;
        int[] iArr2 = new int[zVarArr.length + 1];
        int length = zVarArr.length + 1;
        ae[][] aeVarArr = new ae[length][];
        int[][][] iArr3 = new int[zVarArr.length + 1][][];
        for (int i = 0; i < length; i++) {
            aeVarArr[i] = new ae[afVar.b];
            iArr3[i] = new int[afVar.b][];
        }
        int length2 = zVarArr.length;
        int[] iArr4 = new int[length2];
        for (int i2 = 0; i2 < length2; i2++) {
            iArr4[i2] = zVarArr[i2].m();
        }
        for (int i3 = 0; i3 < afVar.b; i3++) {
            ae aeVarA = afVar.a(i3);
            int length3 = zVarArr.length;
            int i4 = 0;
            for (int i5 = 0; i5 < zVarArr.length; i5++) {
                z zVar = zVarArr[i5];
                for (int i6 = 0; i6 < aeVarA.a; i6++) {
                    int iA = zVar.a(aeVarA.a(i6)) & 7;
                    if (iA > i4) {
                        if (iA == 4) {
                            length3 = i5;
                            break;
                        }
                        length3 = i5;
                        i4 = iA;
                    }
                }
            }
            if (length3 == zVarArr.length) {
                iArr = new int[aeVarA.a];
            } else {
                z zVar2 = zVarArr[length3];
                int[] iArr5 = new int[aeVarA.a];
                for (int i7 = 0; i7 < aeVarA.a; i7++) {
                    iArr5[i7] = zVar2.a(aeVarA.a(i7));
                }
                iArr = iArr5;
            }
            int i8 = iArr2[length3];
            aeVarArr[length3][i8] = aeVarA;
            iArr3[length3][i8] = iArr;
            iArr2[length3] = i8 + 1;
        }
        af[] afVarArr = new af[zVarArr.length];
        int[] iArr6 = new int[zVarArr.length];
        for (int i9 = 0; i9 < zVarArr.length; i9++) {
            int i10 = iArr2[i9];
            afVarArr[i9] = new af((ae[]) com.anythink.basead.exoplayer.k.af.a(aeVarArr[i9], i10));
            iArr3[i9] = (int[][]) com.anythink.basead.exoplayer.k.af.a(iArr3[i9], i10);
            iArr6[i9] = zVarArr[i9].a();
        }
        a aVar = new a(iArr6, afVarArr, iArr4, iArr3, new af((ae[]) com.anythink.basead.exoplayer.k.af.a(aeVarArr[zVarArr.length], iArr2[zVarArr.length])));
        Pair<aa[], f[]> pairA = a(aVar, iArr3, iArr4);
        return new i((aa[]) pairA.first, (f[]) pairA.second, aVar);
    }

    private static int a(z[] zVarArr, ae aeVar) {
        int length = zVarArr.length;
        int i = 0;
        for (int i2 = 0; i2 < zVarArr.length; i2++) {
            z zVar = zVarArr[i2];
            for (int i3 = 0; i3 < aeVar.a; i3++) {
                int iA = zVar.a(aeVar.a(i3)) & 7;
                if (iA > i) {
                    if (iA == 4) {
                        return i2;
                    }
                    length = i2;
                    i = iA;
                }
            }
        }
        return length;
    }

    private static int[] a(z zVar, ae aeVar) {
        int[] iArr = new int[aeVar.a];
        for (int i = 0; i < aeVar.a; i++) {
            iArr[i] = zVar.a(aeVar.a(i));
        }
        return iArr;
    }

    private static int[] a(z[] zVarArr) {
        int length = zVarArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = zVarArr[i].m();
        }
        return iArr;
    }
}
