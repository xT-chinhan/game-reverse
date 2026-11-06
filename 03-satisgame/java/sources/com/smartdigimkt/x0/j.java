package com.smartdigimkt.x0;

import android.graphics.Point;
import android.text.TextUtils;
import android.util.Pair;
import com.smartdigimkt.i0.f0;
import com.smartdigimkt.i0.s;
import com.smartdigimkt.v0.i0;
import com.smartdigimkt.v0.k0;
import com.smartdigimkt.z0.u;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j extends l {
    /* JADX WARN: Code duplicated, block: B:168:0x02ae  */
    /* JADX WARN: Code duplicated, block: B:170:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:186:0x02d4  */
    /* JADX WARN: Code duplicated, block: B:188:0x02db  */
    /* JADX WARN: Code duplicated, block: B:190:0x02e1 A[PHI: r16 r17 r18
      0x02e1: PHI (r16v12 int[]) = (r16v13 int[]), (r16v15 int[]), (r16v15 int[]), (r16v15 int[]) binds: [B:189:0x02dd, B:179:0x02c4, B:176:0x02bd, B:174:0x02ba] A[DONT_GENERATE, DONT_INLINE]
      0x02e1: PHI (r17v13 int) = (r17v14 int), (r17v15 int), (r17v16 int), (r17v16 int) binds: [B:189:0x02dd, B:179:0x02c4, B:176:0x02bd, B:174:0x02ba] A[DONT_GENERATE, DONT_INLINE]
      0x02e1: PHI (r18v8 java.util.ArrayList) = (r18v9 java.util.ArrayList), (r18v11 java.util.ArrayList), (r18v13 java.util.ArrayList), (r18v13 java.util.ArrayList) binds: [B:189:0x02dd, B:179:0x02c4, B:176:0x02bd, B:174:0x02ba] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:317:0x04fe  */
    /* JADX WARN: Code duplicated, block: B:391:0x05e2  */
    /* JADX WARN: Code duplicated, block: B:76:0x0177  */
    /* JADX WARN: Code duplicated, block: B:77:0x0185  */
    @Override // com.smartdigimkt.x0.l
    public final m a(com.smartdigimkt.i0.a[] aVarArr, k0 k0Var) {
        int i;
        boolean z;
        boolean z2;
        h hVar;
        boolean z3;
        k0 k0Var2;
        int[][] iArr;
        i0 i0Var;
        int i2;
        int[][] iArr2;
        int i3;
        h[] hVarArr;
        int i4;
        int[][][] iArr3;
        int[] iArr4;
        i iVar;
        int i5;
        h[] hVarArr2;
        int i6;
        int[] iArr5;
        ArrayList arrayList;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        h[] hVarArr3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        Point point;
        int i23;
        int[] iArr6;
        int[] iArr7 = new int[aVarArr.length + 1];
        int length = aVarArr.length + 1;
        i0[][] i0VarArr = new i0[length][];
        int[][][] iArr8 = new int[aVarArr.length + 1][][];
        for (int i24 = 0; i24 < length; i24++) {
            int i25 = k0Var.a;
            i0VarArr[i24] = new i0[i25];
            iArr8[i24] = new int[i25][];
        }
        int length2 = aVarArr.length;
        int[] iArr9 = new int[length2];
        for (int i26 = 0; i26 < length2; i26++) {
            iArr9[i26] = aVarArr[i26].j();
        }
        for (int i27 = 0; i27 < k0Var.a; i27++) {
            i0 i0Var2 = k0Var.b[i27];
            int length3 = aVarArr.length;
            int i28 = 0;
            for (int i29 = 0; i29 < aVarArr.length; i29++) {
                com.smartdigimkt.i0.a aVar = aVarArr[i29];
                for (int i30 = 0; i30 < i0Var2.a; i30++) {
                    int iA = aVar.a(i0Var2.b[i30]) & 7;
                    if (iA > i28) {
                        if (iA == 4) {
                            length3 = i29;
                            break;
                        }
                        i28 = iA;
                        length3 = i29;
                    }
                }
            }
            if (length3 == aVarArr.length) {
                iArr6 = new int[i0Var2.a];
            } else {
                com.smartdigimkt.i0.a aVar2 = aVarArr[length3];
                int[] iArr10 = new int[i0Var2.a];
                for (int i31 = 0; i31 < i0Var2.a; i31++) {
                    iArr10[i31] = aVar2.a(i0Var2.b[i31]);
                }
                iArr6 = iArr10;
            }
            int i32 = iArr7[length3];
            i0VarArr[length3][i32] = i0Var2;
            iArr8[length3][i32] = iArr6;
            iArr7[length3] = i32 + 1;
        }
        k0[] k0VarArr = new k0[aVarArr.length];
        int[] iArr11 = new int[aVarArr.length];
        for (int i33 = 0; i33 < aVarArr.length; i33++) {
            int i34 = iArr7[i33];
            k0VarArr[i33] = new k0((i0[]) u.a(i0VarArr[i33], i34));
            iArr8[i33] = (int[][]) u.a(iArr8[i33], i34);
            iArr11[i33] = aVarArr[i33].a;
        }
        new k0((i0[]) u.a(i0VarArr[aVarArr.length], iArr7[aVarArr.length]));
        i iVar2 = new i(iArr11, k0VarArr);
        d dVar = (d) ((g) this).a.get();
        int i35 = iVar2.a;
        h[] hVarArr4 = new h[i35];
        int i36 = 0;
        boolean z4 = false;
        while (i36 < i35) {
            if (2 == iVar2.b[i36]) {
                if (z4) {
                    i3 = i35;
                    hVarArr = hVarArr4;
                    i4 = i36;
                    iArr3 = iArr8;
                    iArr4 = iArr9;
                } else {
                    k0 k0Var3 = iVar2.c[i36];
                    int[][] iArr12 = iArr8[i36];
                    int i37 = iArr9[i36];
                    boolean z5 = dVar.n;
                    i0 i0Var3 = null;
                    int i38 = 0;
                    int i39 = 0;
                    int i40 = 0;
                    int i41 = -1;
                    int i42 = -1;
                    while (i38 < k0Var3.a) {
                        i0 i0Var4 = k0Var3.b[i38];
                        int i43 = dVar.k;
                        int i44 = dVar.l;
                        boolean z6 = dVar.m;
                        k0 k0Var4 = k0Var3;
                        int[] iArr13 = iArr9;
                        ArrayList arrayList2 = new ArrayList(i0Var4.a);
                        int[][][] iArr14 = iArr8;
                        for (int i45 = 0; i45 < i0Var4.a; i45++) {
                            arrayList2.add(Integer.valueOf(i45));
                        }
                        int i46 = Integer.MAX_VALUE;
                        if (i43 == Integer.MAX_VALUE || i44 == Integer.MAX_VALUE) {
                            iVar = iVar2;
                            i5 = i35;
                            hVarArr2 = hVarArr4;
                            i6 = i36;
                        } else {
                            i5 = i35;
                            int i47 = 0;
                            while (i47 < i0Var4.a) {
                                s sVar = i0Var4.b[i47];
                                i iVar3 = iVar2;
                                int i48 = sVar.k;
                                if (i48 > 0) {
                                    hVarArr3 = hVarArr4;
                                    int i49 = sVar.l;
                                    if (i49 > 0) {
                                        z6 = z6;
                                        if (z6) {
                                            i17 = i43;
                                            if ((i48 > i49) != (i43 > i44)) {
                                                i20 = i44;
                                                i18 = i20;
                                                i19 = i17;
                                            }
                                            i21 = i48 * i19;
                                            i16 = i36;
                                            i22 = i49 * i20;
                                            if (i21 >= i22) {
                                                int i50 = u.a;
                                                point = new Point(i20, ((i22 + i48) - 1) / i48);
                                            } else {
                                                int i51 = u.a;
                                                point = new Point(((i21 + i49) - 1) / i49, i19);
                                            }
                                            i23 = sVar.k;
                                            int i52 = sVar.l;
                                            int i53 = i23 * i52;
                                            if (i23 < ((int) (point.x * 0.98f)) && i52 >= ((int) (point.y * 0.98f)) && i53 < i46) {
                                                i46 = i53;
                                            }
                                        } else {
                                            i17 = i43;
                                        }
                                        i19 = i44;
                                        i18 = i19;
                                        i20 = i17;
                                        i21 = i48 * i19;
                                        i16 = i36;
                                        i22 = i49 * i20;
                                        if (i21 >= i22) {
                                            int i54 = u.a;
                                            point = new Point(i20, ((i22 + i48) - 1) / i48);
                                        } else {
                                            int i55 = u.a;
                                            point = new Point(((i21 + i49) - 1) / i49, i19);
                                        }
                                        i23 = sVar.k;
                                        int i56 = sVar.l;
                                        int i57 = i23 * i56;
                                        if (i23 < ((int) (point.x * 0.98f))) {
                                        }
                                    }
                                    i47++;
                                    iVar2 = iVar3;
                                    hVarArr4 = hVarArr3;
                                    z6 = z6;
                                    i43 = i17;
                                    i44 = i18;
                                    i36 = i16;
                                } else {
                                    hVarArr3 = hVarArr4;
                                }
                                i16 = i36;
                                i17 = i43;
                                i18 = i44;
                                i47++;
                                iVar2 = iVar3;
                                hVarArr4 = hVarArr3;
                                z6 = z6;
                                i43 = i17;
                                i44 = i18;
                                i36 = i16;
                            }
                            iVar = iVar2;
                            hVarArr2 = hVarArr4;
                            i6 = i36;
                            if (i46 != Integer.MAX_VALUE) {
                                for (int size = arrayList2.size() - 1; size >= 0; size--) {
                                    s sVar2 = i0Var4.b[((Integer) arrayList2.get(size)).intValue()];
                                    int i58 = sVar2.k;
                                    int i59 = (i58 == -1 || (i15 = sVar2.l) == -1) ? -1 : i58 * i15;
                                    if (i59 == -1 || i59 > i46) {
                                        arrayList2.remove(size);
                                    }
                                }
                            }
                        }
                        int[] iArr15 = iArr12[i38];
                        int i60 = i40;
                        int i61 = i41;
                        int i62 = i42;
                        int i63 = 0;
                        while (i63 < i0Var4.a) {
                            if (g.a(iArr15[i63], dVar.q)) {
                                s sVar3 = i0Var4.b[i63];
                                boolean z7 = arrayList2.contains(Integer.valueOf(i63)) && ((i12 = sVar3.k) == -1 || i12 <= dVar.g) && (((i13 = sVar3.l) == -1 || i13 <= dVar.h) && ((i14 = sVar3.b) == -1 || i14 <= dVar.i));
                                if (z7 || dVar.j) {
                                    int i64 = z7 ? 2 : 1;
                                    iArr5 = iArr15;
                                    boolean zA = g.a(iArr15[i63], false);
                                    if (zA) {
                                        i64 += 1000;
                                    }
                                    boolean z8 = i64 > i60;
                                    if (i64 == i60) {
                                        if (dVar.n) {
                                            int i65 = sVar3.b;
                                            if (i65 != -1 ? i61 != -1 && i65 - i61 < 0 : i61 != -1) {
                                                arrayList = arrayList2;
                                            }
                                        } else {
                                            i7 = i60;
                                            int i66 = -1;
                                            int i67 = sVar3.k;
                                            arrayList = arrayList2;
                                            int i68 = (i67 == -1 || (i11 = sVar3.l) == -1) ? -1 : i67 * i11;
                                            if (i68 == i62) {
                                                int i69 = sVar3.b;
                                                if (i69 == -1) {
                                                    if (i61 == -1) {
                                                        i66 = 0;
                                                    }
                                                } else if (i61 == -1) {
                                                    i66 = 1;
                                                } else {
                                                    i66 = i69 - i61;
                                                }
                                            } else if (i68 == -1) {
                                                if (i62 == -1) {
                                                    i66 = 0;
                                                }
                                            } else if (i62 == -1) {
                                                i66 = 1;
                                            } else {
                                                i66 = i68 - i62;
                                            }
                                            if (!zA || !z7 ? i66 >= 0 : i66 <= 0) {
                                                i60 = i7;
                                            }
                                        }
                                        int i70 = sVar3.b;
                                        i8 = sVar3.k;
                                        if (i8 != -1 || (i10 = sVar3.l) == -1) {
                                            i9 = -1;
                                        } else {
                                            i9 = i8 * i10;
                                        }
                                        i61 = i70;
                                        i39 = i63;
                                        i62 = i9;
                                        i60 = i64;
                                        i0Var3 = i0Var4;
                                    } else {
                                        i7 = i60;
                                        arrayList = arrayList2;
                                        if (z8) {
                                            int i71 = sVar3.b;
                                            i8 = sVar3.k;
                                            if (i8 != -1) {
                                                i9 = -1;
                                            } else {
                                                i9 = -1;
                                            }
                                            i61 = i71;
                                            i39 = i63;
                                            i62 = i9;
                                            i60 = i64;
                                            i0Var3 = i0Var4;
                                        } else {
                                            i60 = i7;
                                        }
                                    }
                                } else {
                                    iArr5 = iArr15;
                                }
                                i7 = i60;
                                arrayList = arrayList2;
                                i60 = i7;
                            } else {
                                iArr5 = iArr15;
                                i7 = i60;
                                arrayList = arrayList2;
                                i60 = i7;
                            }
                            i63++;
                            iArr15 = iArr5;
                            arrayList2 = arrayList;
                        }
                        i38++;
                        i42 = i62;
                        i40 = i60;
                        k0Var3 = k0Var4;
                        iArr9 = iArr13;
                        iArr8 = iArr14;
                        i35 = i5;
                        iVar2 = iVar;
                        i36 = i6;
                        i41 = i61;
                        hVarArr4 = hVarArr2;
                    }
                    i iVar4 = iVar2;
                    i3 = i35;
                    hVarArr = hVarArr4;
                    i4 = i36;
                    iArr3 = iArr8;
                    iArr4 = iArr9;
                    h hVar2 = i0Var3 == null ? null : new h(i0Var3, i39);
                    hVarArr[i4] = hVar2;
                    iVar2 = iVar4;
                    z4 = hVar2 != null;
                }
                int i72 = iVar2.c[i4].a;
            } else {
                i3 = i35;
                hVarArr = hVarArr4;
                i4 = i36;
                iArr3 = iArr8;
                iArr4 = iArr9;
            }
            i36 = i4 + 1;
            iArr9 = iArr4;
            iArr8 = iArr3;
            i35 = i3;
            hVarArr4 = hVarArr;
        }
        h[] hVarArr5 = hVarArr4;
        int[][][] iArr16 = iArr8;
        int[] iArr17 = iArr9;
        int i73 = i35;
        boolean z9 = false;
        boolean z10 = false;
        for (int i74 = 0; i74 < i73; i74++) {
            int i75 = iVar2.b[i74];
            if (i75 != 1) {
                if (i75 == 2) {
                    z10 = z10;
                } else {
                    if (i75 != 3) {
                        k0 k0Var5 = iVar2.c[i74];
                        int[][] iArr18 = iArr16[i74];
                        i0 i0Var5 = null;
                        int i76 = 0;
                        int i77 = 0;
                        for (int i78 = 0; i78 < k0Var5.a; i78++) {
                            i0 i0Var6 = k0Var5.b[i78];
                            int[] iArr19 = iArr18[i78];
                            int i79 = 0;
                            while (i79 < i0Var6.a) {
                                k0 k0Var6 = k0Var5;
                                if (g.a(iArr19[i79], dVar.q)) {
                                    int i80 = (i0Var6.b[i79].x & 1) != 0 ? 2 : 1;
                                    iArr2 = iArr18;
                                    if (g.a(iArr19[i79], false)) {
                                        i80 += 1000;
                                    }
                                    if (i80 > i77) {
                                        i77 = i80;
                                        i0Var5 = i0Var6;
                                        i76 = i79;
                                    }
                                } else {
                                    iArr2 = iArr18;
                                }
                                i79++;
                                k0Var5 = k0Var6;
                                iArr18 = iArr2;
                            }
                        }
                        hVarArr5[i74] = i0Var5 == null ? null : new h(i0Var5, i76);
                    } else if (!z10) {
                        k0 k0Var7 = iVar2.c[i74];
                        int[][] iArr20 = iArr16[i74];
                        i0 i0Var7 = null;
                        int i81 = 0;
                        int i82 = 0;
                        int i83 = 0;
                        while (i81 < k0Var7.a) {
                            i0 i0Var8 = k0Var7.b[i81];
                            int[] iArr21 = iArr20[i81];
                            int i84 = i83;
                            int i85 = i82;
                            i0 i0Var9 = i0Var7;
                            int i86 = 0;
                            while (i86 < i0Var8.a) {
                                if (g.a(iArr21[i86], dVar.q)) {
                                    s sVar4 = i0Var8.b[i86];
                                    k0Var2 = k0Var7;
                                    int i87 = (~dVar.f) & sVar4.x;
                                    boolean z11 = (i87 & 1) != 0;
                                    iArr = iArr20;
                                    boolean z12 = (i87 & 2) != 0;
                                    boolean zA2 = g.a(sVar4, dVar.d);
                                    i0Var = i0Var9;
                                    if (zA2 || (dVar.e && (TextUtils.isEmpty(sVar4.y) || g.a(sVar4, "und")))) {
                                        i2 = (z11 ? 8 : !z12 ? 6 : 4) + (zA2 ? 1 : 0);
                                    } else if (z11) {
                                        i2 = 3;
                                    } else {
                                        if (z12) {
                                            i2 = g.a(sVar4, dVar.c) ? 2 : 1;
                                        }
                                        i86++;
                                        k0Var7 = k0Var2;
                                        iArr20 = iArr;
                                    }
                                    if (g.a(iArr21[i86], false)) {
                                        i2 += 1000;
                                    }
                                    if (i2 > i84) {
                                        i84 = i2;
                                        i85 = i86;
                                        i0Var9 = i0Var8;
                                    }
                                    i86++;
                                    k0Var7 = k0Var2;
                                    iArr20 = iArr;
                                } else {
                                    k0Var2 = k0Var7;
                                    iArr = iArr20;
                                    i0Var = i0Var9;
                                }
                                i0Var9 = i0Var;
                                i86++;
                                k0Var7 = k0Var2;
                                iArr20 = iArr;
                            }
                            i0 i0Var10 = i0Var9;
                            i81++;
                            i82 = i85;
                            i83 = i84;
                            i0Var7 = i0Var10;
                        }
                        h hVar3 = i0Var7 == null ? null : new h(i0Var7, i82);
                        hVarArr5[i74] = hVar3;
                        z10 = hVar3 != null;
                    }
                    z10 = z10;
                }
            } else if (z9) {
                z10 = z10;
            } else {
                k0 k0Var8 = iVar2.c[i74];
                int[][] iArr22 = iArr16[i74];
                int i88 = iArr17[i74];
                b bVar = null;
                int i89 = 0;
                int i90 = -1;
                int i91 = -1;
                while (i89 < k0Var8.a) {
                    i0 i0Var11 = k0Var8.b[i89];
                    int[] iArr23 = iArr22[i89];
                    int i92 = i91;
                    int i93 = i90;
                    b bVar2 = bVar;
                    int i94 = 0;
                    while (i94 < i0Var11.a) {
                        if (g.a(iArr23[i94], dVar.q)) {
                            z3 = z10;
                            b bVar3 = new b(i0Var11.b[i94], dVar, iArr23[i94]);
                            if (bVar2 == null || bVar3.compareTo(bVar2) > 0) {
                                i92 = i94;
                                i93 = i89;
                                bVar2 = bVar3;
                            }
                        } else {
                            z3 = z10;
                        }
                        i94++;
                        z10 = z3;
                    }
                    i89++;
                    bVar = bVar2;
                    i90 = i93;
                    i91 = i92;
                }
                boolean z13 = z10;
                if (i90 == -1) {
                    hVar = null;
                } else {
                    i0 i0Var12 = k0Var8.b[i90];
                    boolean z14 = dVar.n;
                    hVar = new h(i0Var12, i91);
                }
                hVarArr5[i74] = hVar;
                if (hVar != null) {
                    z10 = z13;
                    z9 = true;
                } else {
                    z10 = z13;
                    z9 = false;
                }
            }
        }
        for (int i95 = 0; i95 < i73; i95++) {
            if (dVar.b.get(i95)) {
                hVarArr5[i95] = null;
            } else {
                k0 k0Var9 = iVar2.c[i95];
                Map map = (Map) dVar.a.get(i95);
                if (map != null && map.containsKey(k0Var9)) {
                    Map map2 = (Map) dVar.a.get(i95);
                    f fVar = map2 != null ? (f) map2.get(k0Var9) : null;
                    if (fVar == null) {
                        hVarArr5[i95] = null;
                    } else {
                        if (fVar.c != 1) {
                            throw null;
                        }
                        hVarArr5[i95] = new h(k0Var9.b[fVar.a], fVar.b[0]);
                    }
                }
            }
        }
        f0[] f0VarArr = new f0[i73];
        for (int i96 = 0; i96 < i73; i96++) {
            f0VarArr[i96] = (dVar.b.get(i96) || (iVar2.b[i96] != 5 && hVarArr5[i96] == null)) ? null : f0.b;
        }
        int i97 = dVar.r;
        if (i97 != 0) {
            int i98 = 0;
            int i99 = -1;
            int i100 = -1;
            while (true) {
                if (i98 >= iVar2.a) {
                    i = -1;
                    z = true;
                    z2 = true;
                    break;
                }
                int i101 = iVar2.b[i98];
                h hVar4 = hVarArr5[i98];
                if (i101 != 1 && i101 != 2) {
                    break;
                    break;
                }
                if (hVar4 == null) {
                    break;
                    break;
                }
                int[][] iArr24 = iArr16[i98];
                k0 k0Var10 = iVar2.c[i98];
                i0 i0Var13 = hVar4.a;
                int i102 = 0;
                while (true) {
                    if (i102 >= k0Var10.a) {
                        i102 = -1;
                        break;
                    }
                    if (k0Var10.b[i102] == i0Var13) {
                        break;
                    }
                    i102++;
                }
                int i103 = 0;
                while (true) {
                    int[] iArr25 = hVar4.b;
                    if (i103 >= iArr25.length) {
                        z = true;
                        if (i101 != 1) {
                            i = -1;
                            if (i100 == -1) {
                                i100 = i98;
                                break;
                            }
                            z2 = false;
                            break;
                        }
                        i = -1;
                        if (i99 == -1) {
                            i99 = i98;
                            break;
                        }
                        z2 = false;
                        break;
                    }
                    if ((iArr24[i102][iArr25[i103]] & 32) != 32) {
                        break;
                    }
                    i103++;
                }
                i98++;
            }
            if (z2 & ((i99 == i || i100 == i) ? false : z)) {
                f0 f0Var = new f0(i97);
                f0VarArr[i99] = f0Var;
                f0VarArr[i100] = f0Var;
            }
        }
        Pair pairCreate = Pair.create(f0VarArr, hVarArr5);
        return new m((f0[]) pairCreate.first, (h[]) pairCreate.second, iVar2);
    }
}
