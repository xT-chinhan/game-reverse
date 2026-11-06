package com.smartdigimkt.o0;

import androidx.core.view.ViewCompat;
import com.bykv.vk.component.ttvideo.player.C;
import com.smartdigimkt.i0.y;
import com.smartdigimkt.v0.e0;
import java.io.EOFException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements com.smartdigimkt.n0.e, com.smartdigimkt.n0.l {
    public static final int s = com.smartdigimkt.z0.u.a("qt  ");
    public int e;
    public int f;
    public long g;
    public int h;
    public com.smartdigimkt.z0.m i;
    public int k;
    public int l;
    public com.smartdigimkt.n0.f m;
    public o[] n;
    public long[][] o;
    public int p;
    public long q;
    public boolean r;
    public final com.smartdigimkt.z0.m c = new com.smartdigimkt.z0.m(16);
    public final ArrayDeque d = new ArrayDeque();
    public final com.smartdigimkt.z0.m a = new com.smartdigimkt.z0.m(com.smartdigimkt.z0.k.a);
    public final com.smartdigimkt.z0.m b = new com.smartdigimkt.z0.m(4);
    public int j = -1;

    @Override // com.smartdigimkt.n0.l
    public final boolean a() {
        return true;
    }

    @Override // com.smartdigimkt.n0.e
    public final boolean a(com.smartdigimkt.n0.c cVar) {
        return r.a(cVar, false);
    }

    @Override // com.smartdigimkt.n0.l
    public final long b() {
        return this.q;
    }

    @Override // com.smartdigimkt.n0.e
    public final void a(com.smartdigimkt.n0.f fVar) {
        this.m = fVar;
    }

    /* JADX WARN: Code duplicated, block: B:143:0x0255 A[Catch: all -> 0x0277, TRY_LEAVE, TryCatch #0 {all -> 0x0277, blocks: (B:32:0x00aa, B:34:0x00ae, B:36:0x00bd, B:39:0x00cb, B:41:0x00d0, B:44:0x00d8, B:45:0x00df, B:47:0x00e3, B:48:0x00ea, B:50:0x00ee, B:51:0x00f5, B:53:0x00f9, B:54:0x0100, B:56:0x0104, B:57:0x010b, B:59:0x010f, B:61:0x011b, B:70:0x0134, B:72:0x014b, B:74:0x014f, B:75:0x0156, B:77:0x015a, B:78:0x0161, B:80:0x0165, B:81:0x016c, B:83:0x0170, B:84:0x0177, B:86:0x017b, B:87:0x0182, B:89:0x0186, B:90:0x018d, B:92:0x0191, B:93:0x0198, B:95:0x019c, B:96:0x01a3, B:98:0x01a7, B:99:0x01ae, B:101:0x01b2, B:102:0x01b9, B:104:0x01bd, B:143:0x0255, B:105:0x01c3, B:107:0x01c9, B:109:0x01d5, B:110:0x01ea, B:112:0x01f0, B:114:0x01f4, B:117:0x01fa, B:119:0x01fe, B:122:0x0203, B:124:0x0207, B:125:0x020f, B:127:0x0213, B:128:0x021b, B:130:0x021f, B:131:0x0227, B:133:0x022b, B:134:0x0233, B:136:0x0237, B:137:0x023f, B:139:0x0243, B:140:0x0249, B:142:0x024d, B:145:0x025d, B:146:0x0265), top: B:238:0x00aa }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00d5  */
    public final void b(long j) throws y {
        p pVar;
        ArrayList arrayListA;
        int i;
        int i2;
        com.smartdigimkt.q0.b bVarB;
        com.smartdigimkt.q0.b jVar;
        int iE;
        String str;
        p pVar2 = this;
        while (!pVar2.d.isEmpty() && ((a) pVar2.d.peek()).P0 == j) {
            a aVar = (a) pVar2.d.pop();
            if (aVar.a == c.C) {
                ArrayList arrayList = new ArrayList();
                com.smartdigimkt.n0.h hVar = new com.smartdigimkt.n0.h();
                b bVarC = aVar.c(c.A0);
                com.smartdigimkt.q0.c cVar = null;
                if (bVarC == null) {
                    break;
                }
                boolean z = pVar2.r;
                int i3 = i.a;
                if (!z) {
                    com.smartdigimkt.z0.m mVar = bVarC.P0;
                    mVar.c(8);
                    while (true) {
                        int i4 = mVar.c;
                        int i5 = mVar.b;
                        if (i4 - i5 < 8) {
                            break;
                        }
                        int iA = mVar.a();
                        if (mVar.a() == c.B0) {
                            mVar.c(i5);
                            int i6 = i5 + iA;
                            mVar.c(mVar.b + 12);
                            while (true) {
                                int i7 = mVar.b;
                                if (i7 >= i6) {
                                    break;
                                }
                                int iA2 = mVar.a();
                                if (mVar.a() == c.C0) {
                                    mVar.c(i7);
                                    int i8 = i7 + iA2;
                                    mVar.c(mVar.b + 8);
                                    ArrayList arrayList2 = new ArrayList();
                                    while (true) {
                                        int i9 = mVar.b;
                                        if (i9 >= i8) {
                                            break;
                                        }
                                        int i10 = n.a;
                                        int iA3 = mVar.a() + i9;
                                        int iA4 = mVar.a();
                                        int i11 = (iA4 >> 24) & 255;
                                        if (i11 == 169 || i11 == 65533) {
                                            int i12 = iA4 & ViewCompat.MEASURED_SIZE_MASK;
                                            if (i12 == n.c) {
                                                int iA5 = mVar.a();
                                                if (mVar.a() == c.F0) {
                                                    mVar.c(mVar.b + 8);
                                                    String strA = mVar.a(iA5 - 16);
                                                    jVar = new com.smartdigimkt.s0.j("und", strA, strA);
                                                } else {
                                                    c.a(iA4);
                                                }
                                            } else {
                                                if (i12 == n.a || i12 == n.b) {
                                                    bVarB = n.b(iA4, mVar, "TIT2");
                                                } else if (i12 == n.h || i12 == n.i) {
                                                    bVarB = n.b(iA4, mVar, "TCOM");
                                                } else if (i12 == n.d) {
                                                    bVarB = n.b(iA4, mVar, "TDRC");
                                                } else if (i12 == n.e) {
                                                    bVarB = n.b(iA4, mVar, "TPE1");
                                                } else if (i12 == n.f) {
                                                    bVarB = n.b(iA4, mVar, "TSSE");
                                                } else if (i12 == n.g) {
                                                    bVarB = n.b(iA4, mVar, "TALB");
                                                } else if (i12 == n.j) {
                                                    bVarB = n.b(iA4, mVar, "USLT");
                                                } else if (i12 == n.k) {
                                                    bVarB = n.b(iA4, mVar, "TCON");
                                                } else if (i12 == n.n) {
                                                    bVarB = n.b(iA4, mVar, "TIT1");
                                                } else {
                                                    c.a(iA4);
                                                    mVar.c(iA3);
                                                    jVar = null;
                                                }
                                                jVar = bVarB;
                                            }
                                            mVar.c(iA3);
                                        } else {
                                            try {
                                                if (iA4 == n.m) {
                                                    mVar.c(mVar.b + 4);
                                                    if (mVar.a() == c.F0) {
                                                        mVar.c(mVar.b + 8);
                                                        iE = mVar.e();
                                                    } else {
                                                        iE = -1;
                                                    }
                                                    if (iE > 0) {
                                                        String[] strArr = n.D;
                                                        if (iE <= strArr.length) {
                                                            str = strArr[iE - 1];
                                                        } else {
                                                            str = null;
                                                        }
                                                    } else {
                                                        str = null;
                                                    }
                                                    jVar = str != null ? new com.smartdigimkt.s0.u("TCON", null, str) : null;
                                                } else {
                                                    if (iA4 == n.o) {
                                                        bVarB = n.a(iA4, mVar, "TPOS");
                                                    } else if (iA4 == n.p) {
                                                        bVarB = n.a(iA4, mVar, "TRCK");
                                                    } else if (iA4 == n.q) {
                                                        bVarB = n.a(iA4, "TBPM", mVar, true, false);
                                                    } else if (iA4 == n.r) {
                                                        bVarB = n.a(iA4, "TCMP", mVar, true, true);
                                                    } else if (iA4 == n.l) {
                                                        int iA6 = mVar.a();
                                                        if (mVar.a() == c.F0) {
                                                            int iA7 = mVar.a() & ViewCompat.MEASURED_SIZE_MASK;
                                                            String str2 = iA7 == 13 ? "image/jpeg" : iA7 == 14 ? "image/png" : null;
                                                            if (str2 != null) {
                                                                mVar.c(mVar.b + 4);
                                                                int i13 = iA6 - 16;
                                                                byte[] bArr = new byte[i13];
                                                                mVar.a(bArr, 0, i13);
                                                                bVarB = new com.smartdigimkt.s0.b(str2, null, 3, bArr);
                                                            }
                                                        }
                                                    } else if (iA4 == n.s) {
                                                        bVarB = n.b(iA4, mVar, "TPE2");
                                                    } else if (iA4 == n.t) {
                                                        bVarB = n.b(iA4, mVar, "TSOT");
                                                    } else if (iA4 == n.u) {
                                                        bVarB = n.b(iA4, mVar, "TSO2");
                                                    } else if (iA4 == n.v) {
                                                        bVarB = n.b(iA4, mVar, "TSOA");
                                                    } else if (iA4 == n.w) {
                                                        bVarB = n.b(iA4, mVar, "TSOP");
                                                    } else if (iA4 == n.x) {
                                                        bVarB = n.b(iA4, mVar, "TSOC");
                                                    } else if (iA4 == n.y) {
                                                        bVarB = n.a(iA4, "ITUNESADVISORY", mVar, false, false);
                                                    } else if (iA4 == n.z) {
                                                        bVarB = n.a(iA4, "ITUNESGAPLESS", mVar, false, true);
                                                    } else if (iA4 == n.A) {
                                                        bVarB = n.b(iA4, mVar, "TVSHOWSORT");
                                                    } else if (iA4 == n.B) {
                                                        bVarB = n.b(iA4, mVar, "TVSHOW");
                                                    } else if (iA4 == n.C) {
                                                        jVar = n.a(iA3, mVar);
                                                    } else {
                                                        c.a(iA4);
                                                        mVar.c(iA3);
                                                        jVar = null;
                                                    }
                                                    jVar = bVarB;
                                                }
                                                mVar.c(iA3);
                                            } catch (Throwable th) {
                                                mVar.c(iA3);
                                                throw th;
                                            }
                                        }
                                        if (jVar != null) {
                                            arrayList2.add(jVar);
                                        }
                                    }
                                    if (!arrayList2.isEmpty()) {
                                        cVar = new com.smartdigimkt.q0.c(arrayList2);
                                        break;
                                    }
                                    break;
                                }
                                mVar.c(mVar.b + (iA2 - 8));
                            }
                        } else {
                            mVar.c(mVar.b + (iA - 8));
                        }
                    }
                }
                if (cVar == null) {
                    break;
                }
                int i14 = 0;
                while (true) {
                    com.smartdigimkt.q0.b[] bVarArr = cVar.a;
                    if (i14 >= bVarArr.length) {
                        break;
                    }
                    com.smartdigimkt.q0.b bVar = bVarArr[i14];
                    if (bVar instanceof com.smartdigimkt.s0.j) {
                        com.smartdigimkt.s0.j jVar2 = (com.smartdigimkt.s0.j) bVar;
                        if ("iTunSMPB".equals(jVar2.c) && hVar.a(jVar2.d)) {
                            break;
                        } else {
                            i14++;
                        }
                    } else {
                        if (bVar instanceof com.smartdigimkt.s0.q) {
                            com.smartdigimkt.s0.q qVar = (com.smartdigimkt.s0.q) bVar;
                            if ("com.apple.iTunes".equals(qVar.b) && "iTunSMPB".equals(qVar.c) && hVar.a(qVar.d)) {
                                break;
                            }
                        } else {
                            continue;
                        }
                        i14++;
                    }
                }
                try {
                    arrayListA = pVar2.a(aVar, hVar, false);
                } catch (h unused) {
                    hVar = new com.smartdigimkt.n0.h();
                    arrayListA = pVar2.a(aVar, hVar, true);
                }
                int size = arrayListA.size();
                int i15 = 0;
                int size2 = -1;
                long jMax = -9223372036854775807L;
                while (i15 < size) {
                    v vVar = (v) arrayListA.get(i15);
                    s sVar = vVar.a;
                    com.smartdigimkt.n0.f fVar = pVar2.m;
                    int i16 = sVar.b;
                    e0 e0VarC = ((com.smartdigimkt.v0.i) fVar).c(i15);
                    o oVar = new o(sVar, vVar, e0VarC);
                    int i17 = vVar.e + 30;
                    com.smartdigimkt.i0.s sVar2 = sVar.f;
                    ArrayList arrayList3 = arrayListA;
                    int i18 = size;
                    String str3 = sVar2.a;
                    String str4 = sVar2.e;
                    int i19 = i15;
                    String str5 = sVar2.f;
                    String str6 = sVar2.c;
                    ArrayList arrayList4 = arrayList;
                    int i20 = sVar2.b;
                    int i21 = size2;
                    int i22 = sVar2.k;
                    long j2 = jMax;
                    int i23 = sVar2.l;
                    float f = sVar2.m;
                    int i24 = sVar2.n;
                    float f2 = sVar2.o;
                    byte[] bArr2 = sVar2.q;
                    int i25 = sVar2.p;
                    com.smartdigimkt.q0.c cVar2 = cVar;
                    com.smartdigimkt.a1.b bVar2 = sVar2.r;
                    int i26 = sVar2.s;
                    int i27 = sVar2.t;
                    int i28 = sVar2.u;
                    int i29 = sVar2.v;
                    int i30 = sVar2.w;
                    int i31 = sVar2.x;
                    String str7 = sVar2.y;
                    int i32 = sVar2.z;
                    long j3 = sVar2.j;
                    com.smartdigimkt.i0.s sVar3 = new com.smartdigimkt.i0.s(str3, str4, str5, str6, i20, i17, i22, i23, f, i24, f2, bArr2, i25, bVar2, i26, i27, i28, i29, i30, i31, str7, i32, j3, sVar2.h, sVar2.i, sVar2.d);
                    if (sVar.b == 1) {
                        int i33 = hVar.a;
                        if (i33 != -1 && (i2 = hVar.b) != -1) {
                            sVar3 = new com.smartdigimkt.i0.s(str3, str4, str5, str6, i20, i17, i22, i23, f, sVar3.n, sVar3.o, bArr2, i25, bVar2, i26, i27, i28, i33, i2, i31, str7, i32, j3, sVar3.h, sVar3.i, sVar3.d);
                        }
                        if (cVar2 != null) {
                            sVar3 = new com.smartdigimkt.i0.s(sVar3.a, sVar3.e, sVar3.f, sVar3.c, sVar3.b, sVar3.g, sVar3.k, sVar3.l, sVar3.m, sVar3.n, sVar3.o, sVar3.q, sVar3.p, sVar3.r, sVar3.s, sVar3.t, sVar3.u, sVar3.v, sVar3.w, sVar3.x, sVar3.y, sVar3.z, sVar3.j, sVar3.h, sVar3.i, cVar2);
                        }
                    } else {
                        hVar = hVar;
                    }
                    e0VarC.a(sVar3);
                    long j4 = sVar.e;
                    if (j4 == -9223372036854775807L) {
                        j4 = vVar.h;
                    }
                    jMax = Math.max(j2, j4);
                    if (sVar.b == 2) {
                        i = i21;
                        if (i == -1) {
                            size2 = arrayList4.size();
                        }
                        arrayList = arrayList4;
                        arrayList.add(oVar);
                        i15 = i19 + 1;
                        arrayListA = arrayList3;
                        size = i18;
                        cVar = cVar2;
                        hVar = hVar;
                        pVar2 = this;
                    } else {
                        i = i21;
                    }
                    size2 = i;
                    arrayList = arrayList4;
                    arrayList.add(oVar);
                    i15 = i19 + 1;
                    arrayListA = arrayList3;
                    size = i18;
                    cVar = cVar2;
                    hVar = hVar;
                    pVar2 = this;
                }
                pVar = pVar2;
                pVar.p = size2;
                pVar.q = jMax;
                o[] oVarArr = (o[]) arrayList.toArray(new o[arrayList.size()]);
                pVar.n = oVarArr;
                long[][] jArr = new long[oVarArr.length][];
                int[] iArr = new int[oVarArr.length];
                long[] jArr2 = new long[oVarArr.length];
                boolean[] zArr = new boolean[oVarArr.length];
                for (int i34 = 0; i34 < oVarArr.length; i34++) {
                    jArr[i34] = new long[oVarArr[i34].b.b];
                    jArr2[i34] = oVarArr[i34].b.f[0];
                }
                long j5 = 0;
                int i35 = 0;
                while (i35 < oVarArr.length) {
                    int i36 = -1;
                    long j6 = Long.MAX_VALUE;
                    for (int i37 = 0; i37 < oVarArr.length; i37++) {
                        if (!zArr[i37]) {
                            long j7 = jArr2[i37];
                            if (j7 <= j6) {
                                i36 = i37;
                                j6 = j7;
                            }
                        }
                    }
                    int i38 = iArr[i36];
                    long[] jArr3 = jArr[i36];
                    jArr3[i38] = j5;
                    v vVar2 = oVarArr[i36].b;
                    j5 += (long) vVar2.d[i38];
                    int i39 = i38 + 1;
                    iArr[i36] = i39;
                    if (i39 < jArr3.length) {
                        jArr2[i36] = vVar2.f[i39];
                    } else {
                        zArr[i36] = true;
                        i35++;
                    }
                }
                pVar.o = jArr;
                com.smartdigimkt.v0.i iVar = (com.smartdigimkt.v0.i) pVar.m;
                iVar.s = true;
                iVar.n.post(iVar.l);
                com.smartdigimkt.v0.i iVar2 = (com.smartdigimkt.v0.i) pVar.m;
                iVar2.p = pVar;
                iVar2.n.post(iVar2.l);
                pVar.d.clear();
                pVar.e = 2;
            } else {
                pVar = pVar2;
                if (!pVar.d.isEmpty()) {
                    ((a) pVar.d.peek()).R0.add(aVar);
                }
            }
            pVar2 = pVar;
        }
        p pVar3 = pVar2;
        if (pVar3.e != 2) {
            pVar3.e = 0;
            pVar3.h = 0;
        }
    }

    @Override // com.smartdigimkt.n0.e
    public final void a(long j, long j2) {
        int iA;
        this.d.clear();
        this.h = 0;
        this.j = -1;
        this.k = 0;
        this.l = 0;
        if (j == 0) {
            this.e = 0;
            this.h = 0;
            return;
        }
        o[] oVarArr = this.n;
        if (oVarArr != null) {
            for (o oVar : oVarArr) {
                v vVar = oVar.b;
                long[] jArr = vVar.f;
                int i = com.smartdigimkt.z0.u.a;
                int iBinarySearch = Arrays.binarySearch(jArr, j2);
                if (iBinarySearch < 0) {
                    iA = -(iBinarySearch + 2);
                } else {
                    while (true) {
                        int i2 = iBinarySearch - 1;
                        if (i2 < 0 || jArr[i2] != j2) {
                            break;
                        } else {
                            iBinarySearch = i2;
                        }
                    }
                    iA = iBinarySearch;
                }
                while (true) {
                    if (iA < 0) {
                        iA = -1;
                        break;
                    } else if ((vVar.g[iA] & 1) != 0) {
                        break;
                    } else {
                        iA--;
                    }
                }
                if (iA == -1) {
                    iA = vVar.a(j2);
                }
                oVar.d = iA;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.smartdigimkt.n0.e
    public final int a(com.smartdigimkt.n0.c cVar, com.smartdigimkt.n0.i iVar) throws InterruptedException, y, EOFException {
        e0 e0Var;
        boolean z;
        boolean z2;
        while (true) {
            int i = this.e;
            if (i == 0) {
                if (this.h == 0) {
                    if (!cVar.a(this.c.a, 0, 8, true)) {
                        return -1;
                    }
                    this.h = 8;
                    this.c.c(0);
                    this.g = this.c.f();
                    this.f = this.c.a();
                }
                long j = this.g;
                if (j == 1) {
                    cVar.a(this.c.a, 8, 8, false);
                    this.h += 8;
                    this.g = this.c.i();
                } else if (j == 0) {
                    long j2 = cVar.c;
                    if (j2 == -1 && !this.d.isEmpty()) {
                        j2 = ((a) this.d.peek()).P0;
                    }
                    if (j2 != -1) {
                        this.g = (j2 - cVar.d) + ((long) this.h);
                    }
                }
                long j3 = this.g;
                int i2 = this.h;
                long j4 = i2;
                if (j3 >= j4) {
                    int i3 = this.f;
                    if (i3 != c.C && i3 != c.E && i3 != c.F && i3 != c.G && i3 != c.H && i3 != c.Q) {
                        if (i3 != c.S && i3 != c.D && i3 != c.T && i3 != c.U && i3 != c.m0 && i3 != c.n0 && i3 != c.o0 && i3 != c.R && i3 != c.p0 && i3 != c.q0 && i3 != c.r0 && i3 != c.s0 && i3 != c.t0 && i3 != c.P && i3 != c.b && i3 != c.A0) {
                            this.i = null;
                            this.e = 1;
                        } else {
                            if (i2 != 8) {
                                throw new IllegalStateException();
                            }
                            if (j3 <= 2147483647L) {
                                com.smartdigimkt.z0.m mVar = new com.smartdigimkt.z0.m((int) j3);
                                this.i = mVar;
                                System.arraycopy(this.c.a, 0, mVar.a, 0, 8);
                                this.e = 1;
                            } else {
                                throw new IllegalStateException();
                            }
                        }
                    } else {
                        long j5 = (cVar.d + j3) - j4;
                        this.d.push(new a(this.f, j5));
                        if (this.g == this.h) {
                            b(j5);
                        } else {
                            this.e = 0;
                            this.h = 0;
                        }
                    }
                } else {
                    throw new y("Atom size less than header length (unsupported).");
                }
            } else {
                if (i != 1) {
                    if (i == 2) {
                        long j6 = cVar.d;
                        if (this.j == -1) {
                            int i4 = -1;
                            int i5 = -1;
                            boolean z3 = true;
                            boolean z4 = true;
                            long j7 = Long.MAX_VALUE;
                            long j8 = Long.MAX_VALUE;
                            long j9 = Long.MAX_VALUE;
                            int i6 = 0;
                            while (true) {
                                o[] oVarArr = this.n;
                                if (i6 >= oVarArr.length) {
                                    break;
                                }
                                o oVar = oVarArr[i6];
                                int i7 = oVar.d;
                                v vVar = oVar.b;
                                if (i7 != vVar.b) {
                                    long j10 = vVar.c[i7];
                                    long j11 = this.o[i6][i7];
                                    long j12 = j10 - j6;
                                    boolean z5 = j12 < 0 || j12 >= com.anythink.china.a.c.s;
                                    if ((!z5 && z4) || (z5 == z4 && j12 < j9)) {
                                        i5 = i6;
                                        z4 = z5;
                                        j9 = j12;
                                        j8 = j11;
                                    }
                                    if (j11 < j7) {
                                        i4 = i6;
                                        z3 = z5;
                                        j7 = j11;
                                    }
                                }
                                i6++;
                            }
                            int i8 = (j7 == LongCompanionObject.MAX_VALUE || !z3 || j8 < j7 + 10485760) ? i5 : i4;
                            this.j = i8;
                            if (i8 == -1) {
                                return -1;
                            }
                        }
                        o oVar2 = this.n[this.j];
                        e0 e0Var2 = oVar2.c;
                        int i9 = oVar2.d;
                        v vVar2 = oVar2.b;
                        long j13 = vVar2.c[i9];
                        int i10 = vVar2.d[i9];
                        long j14 = (j13 - j6) + ((long) this.k);
                        if (j14 >= 0 && j14 < com.anythink.china.a.c.s) {
                            if (oVar2.a.g == 1) {
                                j14 += 8;
                                i10 -= 8;
                            }
                            cVar.b((int) j14);
                            int i11 = oVar2.a.j;
                            if (i11 == 0) {
                                e0Var = e0Var2;
                                while (true) {
                                    int i12 = this.k;
                                    if (i12 >= i10) {
                                        break;
                                    }
                                    int iA = e0Var.a(cVar, i10 - i12);
                                    this.k += iA;
                                    this.l -= iA;
                                }
                            } else {
                                byte[] bArr = this.b.a;
                                ?? r5 = 0;
                                bArr[0] = 0;
                                bArr[1] = 0;
                                bArr[2] = 0;
                                int i13 = 4 - i11;
                                while (this.k < i10) {
                                    int i14 = this.l;
                                    if (i14 == 0) {
                                        cVar.a(this.b.a, i13, i11, r5);
                                        this.b.c(r5);
                                        this.l = this.b.h();
                                        this.a.c(r5);
                                        e0Var2.a(4, this.a);
                                        this.k += 4;
                                        i10 += i13;
                                    } else {
                                        int iA2 = e0Var2.a(cVar, i14);
                                        this.k += iA2;
                                        this.l -= iA2;
                                    }
                                    r5 = 0;
                                }
                                e0Var = e0Var2;
                            }
                            v vVar3 = oVar2.b;
                            e0Var.a(vVar3.f[i9], vVar3.g[i9], i10, 0, null);
                            oVar2.d++;
                            this.j = -1;
                            this.k = 0;
                            this.l = 0;
                            return 0;
                        }
                        iVar.a = j13;
                        return 1;
                    }
                    throw new IllegalStateException();
                }
                long j15 = this.g;
                int i15 = this.h;
                long j16 = j15 - ((long) i15);
                long j17 = cVar.d + j16;
                com.smartdigimkt.z0.m mVar2 = this.i;
                if (mVar2 != null) {
                    cVar.a(mVar2.a, i15, (int) j16, false);
                    if (this.f == c.b) {
                        com.smartdigimkt.z0.m mVar3 = this.i;
                        mVar3.c(8);
                        if (mVar3.a() != s) {
                            mVar3.c(mVar3.b + 4);
                            while (true) {
                                if (mVar3.c - mVar3.b <= 0) {
                                    z2 = false;
                                    break;
                                }
                                if (mVar3.a() == s) {
                                    z2 = true;
                                    break;
                                }
                            }
                        } else {
                            z2 = true;
                            break;
                        }
                        this.r = z2;
                    } else if (!this.d.isEmpty()) {
                        ((a) this.d.peek()).Q0.add(new b(this.f, this.i));
                    }
                } else {
                    if (j16 < com.anythink.china.a.c.s) {
                        cVar.b((int) j16);
                    } else {
                        iVar.a = j17;
                        z = true;
                    }
                    b(j17);
                    if (z && this.e != 2) {
                        return 1;
                    }
                }
                z = false;
                b(j17);
                if (z) {
                    continue;
                }
            }
        }
    }

    @Override // com.smartdigimkt.n0.l
    public final com.smartdigimkt.n0.j a(long j) {
        long jMin;
        long jMin2;
        long j2;
        int iA;
        int iA2;
        int iA3;
        long j3;
        int iA4;
        long j4 = j;
        o[] oVarArr = this.n;
        if (oVarArr.length == 0) {
            com.smartdigimkt.n0.m mVar = com.smartdigimkt.n0.m.c;
            return new com.smartdigimkt.n0.j(mVar, mVar);
        }
        int i = this.p;
        if (i != -1) {
            v vVar = oVarArr[i].b;
            long[] jArr = vVar.f;
            int i2 = com.smartdigimkt.z0.u.a;
            int iBinarySearch = Arrays.binarySearch(jArr, j4);
            if (iBinarySearch < 0) {
                iA3 = -(iBinarySearch + 2);
            } else {
                while (true) {
                    int i3 = iBinarySearch - 1;
                    if (i3 < 0 || jArr[i3] != j4) {
                        break;
                    }
                    iBinarySearch = i3;
                }
                iA3 = iBinarySearch;
            }
            while (true) {
                if (iA3 < 0) {
                    iA3 = -1;
                    break;
                }
                if ((vVar.g[iA3] & 1) != 0) {
                    break;
                }
                iA3--;
            }
            if (iA3 == -1) {
                iA3 = vVar.a(j4);
            }
            if (iA3 == -1) {
                com.smartdigimkt.n0.m mVar2 = com.smartdigimkt.n0.m.c;
                return new com.smartdigimkt.n0.j(mVar2, mVar2);
            }
            long j5 = vVar.f[iA3];
            jMin = vVar.c[iA3];
            if (j5 >= j4 || iA3 >= vVar.b - 1 || (iA4 = vVar.a(j4)) == -1 || iA4 == iA3) {
                j3 = -1;
                j2 = -9223372036854775807L;
            } else {
                j2 = vVar.f[iA4];
                j3 = vVar.c[iA4];
            }
            jMin2 = j3;
            j4 = j5;
        } else {
            jMin = LongCompanionObject.MAX_VALUE;
            jMin2 = -1;
            j2 = -9223372036854775807L;
        }
        int i4 = 0;
        while (true) {
            o[] oVarArr2 = this.n;
            if (i4 >= oVarArr2.length) {
                break;
            }
            if (i4 != this.p) {
                v vVar2 = oVarArr2[i4].b;
                long[] jArr2 = vVar2.f;
                int i5 = com.smartdigimkt.z0.u.a;
                int iBinarySearch2 = Arrays.binarySearch(jArr2, j4);
                if (iBinarySearch2 < 0) {
                    iA = -(iBinarySearch2 + 2);
                } else {
                    while (true) {
                        int i6 = iBinarySearch2 - 1;
                        if (i6 < 0 || jArr2[i6] != j4) {
                            break;
                        }
                        iBinarySearch2 = i6;
                    }
                    iA = iBinarySearch2;
                }
                while (true) {
                    if (iA < 0) {
                        iA = -1;
                        break;
                    }
                    if ((vVar2.g[iA] & 1) != 0) {
                        break;
                    }
                    iA--;
                }
                if (iA == -1) {
                    iA = vVar2.a(j4);
                }
                if (iA != -1) {
                    jMin = Math.min(vVar2.c[iA], jMin);
                }
                if (j2 != -9223372036854775807L) {
                    long[] jArr3 = vVar2.f;
                    int i7 = com.smartdigimkt.z0.u.a;
                    int iBinarySearch3 = Arrays.binarySearch(jArr3, j2);
                    if (iBinarySearch3 < 0) {
                        iA2 = -(iBinarySearch3 + 2);
                    } else {
                        while (true) {
                            int i8 = iBinarySearch3 - 1;
                            if (i8 < 0 || jArr3[i8] != j2) {
                                break;
                            }
                            iBinarySearch3 = i8;
                        }
                        iA2 = iBinarySearch3;
                    }
                    while (true) {
                        if (iA2 < 0) {
                            iA2 = -1;
                            break;
                        }
                        if ((vVar2.g[iA2] & 1) != 0) {
                            break;
                        }
                        iA2--;
                    }
                    if (iA2 == -1) {
                        iA2 = vVar2.a(j2);
                    }
                    if (iA2 != -1) {
                        jMin2 = Math.min(vVar2.c[iA2], jMin2);
                    }
                }
            }
            i4++;
        }
        com.smartdigimkt.n0.m mVar3 = new com.smartdigimkt.n0.m(j4, jMin);
        if (j2 == -9223372036854775807L) {
            return new com.smartdigimkt.n0.j(mVar3, mVar3);
        }
        return new com.smartdigimkt.n0.j(mVar3, new com.smartdigimkt.n0.m(j2, jMin2));
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0248 A[LOOP:10: B:101:0x0246->B:102:0x0248, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:105:0x0264  */
    /* JADX WARN: Code duplicated, block: B:107:0x0274 A[LOOP:12: B:106:0x0272->B:107:0x0274, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:210:0x051e  */
    /* JADX WARN: Code duplicated, block: B:222:0x017d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:223:0x0211 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:224:0x0201 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x013e  */
    /* JADX WARN: Code duplicated, block: B:56:0x0164 A[ADDED_TO_REGION, LOOP:2: B:56:0x0164->B:59:0x016c, LOOP_START, PHI: r14 r15 r27 r31
      0x0164: PHI (r14v29 int) = (r14v28 int), (r14v42 int) binds: [B:55:0x0162, B:59:0x016c] A[DONT_GENERATE, DONT_INLINE]
      0x0164: PHI (r15v12 com.smartdigimkt.o0.s) = (r15v10 com.smartdigimkt.o0.s), (r15v15 com.smartdigimkt.o0.s) binds: [B:55:0x0162, B:59:0x016c] A[DONT_GENERATE, DONT_INLINE]
      0x0164: PHI (r27v8 int) = (r27v7 int), (r27v11 int) binds: [B:55:0x0162, B:59:0x016c] A[DONT_GENERATE, DONT_INLINE]
      0x0164: PHI (r31v11 long) = (r31v10 long), (r31v13 long) binds: [B:55:0x0162, B:59:0x016c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:57:0x0166  */
    /* JADX WARN: Code duplicated, block: B:59:0x016c A[LOOP:2: B:56:0x0164->B:59:0x016c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:64:0x0189 A[ADDED_TO_REGION, LOOP:3: B:64:0x0189->B:66:0x018d, LOOP_START, PHI: r4 r20 r25
      0x0189: PHI (r4v12 int) = (r4v7 int), (r4v13 int) binds: [B:63:0x0187, B:66:0x018d] A[DONT_GENERATE, DONT_INLINE]
      0x0189: PHI (r20v24 int) = (r20v20 int), (r20v25 int) binds: [B:63:0x0187, B:66:0x018d] A[DONT_GENERATE, DONT_INLINE]
      0x0189: PHI (r25v4 int) = (r25v2 int), (r25v6 int) binds: [B:63:0x0187, B:66:0x018d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:70:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:73:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:74:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:77:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:79:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:87:0x01f3 A[ADDED_TO_REGION, LOOP:4: B:87:0x01f3->B:90:0x01fb, LOOP_START, PHI: r20
      0x01f3: PHI (r20v21 int) = (r20v20 int), (r20v22 int) binds: [B:86:0x01f1, B:90:0x01fb] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:88:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:90:0x01fb A[LOOP:4: B:87:0x01f3->B:90:0x01fb, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:96:0x0217  */
    /* JADX WARN: Code duplicated, block: B:99:0x0229 A[LOOP:9: B:97:0x0223->B:99:0x0229, LOOP_END] */
    /* JADX WARN: Multi-variable type inference failed */
    public final ArrayList a(a aVar, com.smartdigimkt.n0.h hVar, boolean z) throws y {
        s sVarA;
        e gVar;
        boolean z2;
        int iH;
        int i;
        int i2;
        int i3;
        boolean z3;
        int i4;
        long[] jArr;
        int[] iArr;
        s sVar;
        int iA;
        long j;
        int i5;
        int i6;
        int i7;
        long[] jArr2;
        int[] iArr2;
        long[] jArr3;
        int[] iArr3;
        int i8;
        int i9;
        int i10;
        int i11;
        long j2;
        long[] jArr4;
        long j3;
        int i12;
        int iMax;
        long jA;
        long[] jArr5;
        v vVar;
        int i13;
        long[] jArr6;
        int[] iArr4;
        long j4;
        int[] iArr5;
        int[] iArr6;
        int[] iArr7;
        int[] iArr8;
        long[] jArr7;
        int iH2;
        long j5;
        long j6;
        int i14;
        int iA2;
        int i15;
        int iH3;
        int i16;
        int iA3;
        int iH4;
        int i17;
        int i18;
        s sVar2;
        long[] jArr8;
        long j7;
        int iC;
        int i19;
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        int i20 = 0;
        int i21 = 0;
        while (i21 < aVar.R0.size()) {
            a aVar2 = (a) aVar.R0.get(i21);
            if (aVar2.a == c.E && (sVarA = i.a(aVar2, aVar.c(c.D), -9223372036854775807L, null, z, this.r)) != null) {
                a aVarB = aVar2.b(c.F).b(c.G).b(c.H);
                b bVarC = aVarB.c(c.q0);
                if (bVarC != null) {
                    gVar = new f(bVarC);
                } else {
                    b bVarC2 = aVarB.c(c.r0);
                    if (bVarC2 != null) {
                        gVar = new g(bVarC2);
                    } else {
                        throw new y("Track has no sample table size information");
                    }
                }
                int iB = gVar.b();
                if (iB == 0) {
                    vVar = new v(sVarA, new long[i20], new int[i20], 0, new long[i20], new int[i20], -9223372036854775807L);
                    arrayList2 = arrayList2;
                    i21 = i21;
                } else {
                    b bVarC3 = aVarB.c(c.s0);
                    if (bVarC3 == null) {
                        bVarC3 = aVarB.c(c.t0);
                        z2 = 1;
                    } else {
                        z2 = i20;
                    }
                    com.smartdigimkt.z0.m mVar = bVarC3.P0;
                    com.smartdigimkt.z0.m mVar2 = aVarB.c(c.p0).P0;
                    com.smartdigimkt.z0.m mVar3 = aVarB.c(c.m0).P0;
                    b bVarC4 = aVarB.c(c.n0);
                    com.smartdigimkt.z0.m mVar4 = null;
                    com.smartdigimkt.z0.m mVar5 = bVarC4 != null ? bVarC4.P0 : null;
                    b bVarC5 = aVarB.c(c.o0);
                    com.smartdigimkt.z0.m mVar6 = bVarC5 != null ? bVarC5.P0 : null;
                    d dVar = new d(mVar2, mVar, z2);
                    mVar3.c(12);
                    int iH5 = mVar3.h() - 1;
                    int iH6 = mVar3.h();
                    int iH7 = mVar3.h();
                    if (mVar6 != null) {
                        mVar6.c(12);
                        iH = mVar6.h();
                    } else {
                        iH = 0;
                    }
                    if (mVar5 != null) {
                        mVar5.c(12);
                        int iH8 = mVar5.h();
                        if (iH8 > 0) {
                            int iH9 = mVar5.h() - 1;
                            com.smartdigimkt.z0.m mVar7 = mVar5;
                            i2 = iH8;
                            i = iH9;
                            mVar4 = mVar7;
                        } else {
                            i2 = iH8;
                            i = -1;
                        }
                    } else {
                        mVar4 = mVar5;
                        i = -1;
                        i2 = 0;
                    }
                    if (gVar.a()) {
                        i3 = i;
                        if ("audio/raw".equals(sVarA.f.f) && iH5 == 0 && iH == 0 && i2 == 0) {
                            z3 = true;
                        }
                        long j8 = 0;
                        if (!z3) {
                            jArr4 = new long[iB];
                            iArr8 = new int[iB];
                            int i22 = iH5;
                            jArr7 = new long[iB];
                            iH2 = iH6;
                            iArr3 = new int[iB];
                            j5 = 0;
                            j6 = 0;
                            i14 = 0;
                            iA2 = 0;
                            i15 = 0;
                            iH3 = 0;
                            i16 = 0;
                            int i23 = i2;
                            iA3 = iH7;
                            iH4 = i3;
                            i17 = iH;
                            i18 = i23;
                            while (i15 < iB) {
                                while (i16 == 0) {
                                    if (dVar.a()) {
                                        j6 = dVar.d;
                                        i16 = dVar.c;
                                        sVarA = sVarA;
                                        iA3 = iA3;
                                    } else {
                                        throw new IllegalStateException();
                                    }
                                }
                                int i24 = iA3;
                                s sVar3 = sVarA;
                                if (mVar6 != null) {
                                    while (iH3 == 0 && i17 > 0) {
                                        iH3 = mVar6.h();
                                        iA2 = mVar6.a();
                                        i17--;
                                    }
                                    iH3--;
                                }
                                jArr4[i15] = j6;
                                iC = gVar.c();
                                iArr8[i15] = iC;
                                if (iC > i14) {
                                    i14 = iC;
                                }
                                jArr7[i15] = j5 + ((long) iA2);
                                if (mVar4 == null) {
                                    i19 = 1;
                                } else {
                                    i19 = 0;
                                }
                                iArr3[i15] = i19;
                                if (i15 == iH4) {
                                    iArr3[i15] = 1;
                                    i18--;
                                    if (i18 > 0) {
                                        iH4 = mVar4.h() - 1;
                                    }
                                }
                                long[] jArr9 = jArr7;
                                iA3 = i24;
                                int i25 = iH4;
                                j5 += (long) iA3;
                                iH2--;
                                if (iH2 != 0 && i22 > 0) {
                                    i22--;
                                    iH2 = mVar3.h();
                                    iA3 = mVar3.a();
                                }
                                j6 += (long) iArr8[i15];
                                i16--;
                                i15++;
                                jArr7 = jArr9;
                                sVarA = sVar3;
                                iH4 = i25;
                            }
                            sVar2 = sVarA;
                            jArr8 = jArr7;
                            j7 = j5 + ((long) iA2);
                            if (iH3 == 0) {
                                throw new IllegalArgumentException();
                            }
                            while (i17 > 0) {
                                if (mVar6.h() == 0) {
                                    mVar6.a();
                                    i17--;
                                } else {
                                    throw new IllegalArgumentException();
                                }
                            }
                            i11 = i14;
                            iArr2 = iArr8;
                            jArr3 = jArr8;
                            j2 = j7;
                            sVar = sVar2;
                        } else {
                            i4 = dVar.a;
                            jArr = new long[i4];
                            iArr = new int[i4];
                            while (dVar.a()) {
                                int i26 = dVar.b;
                                jArr[i26] = dVar.d;
                                iArr[i26] = dVar.c;
                            }
                            sVar = sVarA;
                            com.smartdigimkt.i0.s sVar4 = sVar.f;
                            iA = com.smartdigimkt.z0.u.a(sVar4.u, sVar4.s);
                            j = iH7;
                            i5 = 8192 / iA;
                            i7 = 0;
                            for (i6 = 0; i6 < i4; i6++) {
                                int i27 = iArr[i6];
                                int i28 = com.smartdigimkt.z0.u.a;
                                i7 += ((i27 + i5) - 1) / i5;
                            }
                            jArr2 = new long[i7];
                            iArr2 = new int[i7];
                            jArr3 = new long[i7];
                            iArr3 = new int[i7];
                            i8 = 0;
                            i9 = 0;
                            i10 = 0;
                            i11 = 0;
                            while (i8 < i4) {
                                int i29 = iArr[i8];
                                j3 = jArr[i8];
                                long[] jArr10 = jArr;
                                i12 = i29;
                                int i30 = i4;
                                iMax = i11;
                                while (i12 > 0) {
                                    int iMin = Math.min(i5, i12);
                                    jArr2[i10] = j3;
                                    int[] iArr9 = iArr;
                                    int i31 = iA * iMin;
                                    iArr2[i10] = i31;
                                    iMax = Math.max(iMax, i31);
                                    jArr3[i10] = ((long) i9) * j;
                                    iArr3[i10] = 1;
                                    j3 += (long) iArr2[i10];
                                    i9 += iMin;
                                    i12 -= iMin;
                                    i10++;
                                    i5 = i5;
                                    iArr = iArr9;
                                    jArr2 = jArr2;
                                }
                                i8++;
                                i11 = iMax;
                                i4 = i30;
                                jArr = jArr10;
                                iArr = iArr;
                            }
                            j2 = ((long) i9) * j;
                            jArr4 = jArr2;
                        }
                        jA = com.smartdigimkt.z0.u.a(j2, C.MICROS_PER_SECOND, sVar.c);
                        jArr5 = sVar.h;
                        if (jArr5 == null && (hVar.a == -1 || hVar.b == -1)) {
                            if (jArr5.length == 1 && sVar.b == 1 && jArr3.length >= 2) {
                                long j9 = sVar.i[0];
                                i13 = iB;
                                long jA2 = com.smartdigimkt.z0.u.a(jArr5[0], sVar.c, sVar.d) + j9;
                                int length = jArr3.length - 1;
                                int iMax2 = Math.max(0, Math.min(3, length));
                                int iMax3 = Math.max(0, Math.min(jArr3.length - 3, length));
                                long j10 = jArr3[0];
                                if (j10 <= j9 && j9 < jArr3[iMax2] && jArr3[iMax3] < jA2 && jA2 <= j2) {
                                    long j11 = j2 - jA2;
                                    long jA3 = com.smartdigimkt.z0.u.a(j9 - j10, sVar.f.t, sVar.c);
                                    long jA4 = com.smartdigimkt.z0.u.a(j11, sVar.f.t, sVar.c);
                                    if ((jA3 != 0 || jA4 != 0) && jA3 <= 2147483647L && jA4 <= 2147483647L) {
                                        hVar.a = (int) jA3;
                                        hVar.b = (int) jA4;
                                        com.smartdigimkt.z0.u.a(jArr3, sVar.c);
                                        vVar = new v(sVar, jArr4, iArr2, i11, jArr3, iArr3, jA);
                                    }
                                }
                            } else {
                                i13 = iB;
                            }
                            long[] jArr11 = sVar.h;
                            if (jArr11.length == 1 && jArr11[0] == 0) {
                                long j12 = sVar.i[0];
                                for (int i32 = 0; i32 < jArr3.length; i32++) {
                                    jArr3[i32] = com.smartdigimkt.z0.u.a(jArr3[i32] - j12, C.MICROS_PER_SECOND, sVar.c);
                                }
                                vVar = new v(sVar, jArr4, iArr2, i11, jArr3, iArr3, com.smartdigimkt.z0.u.a(j2 - j12, C.MICROS_PER_SECOND, sVar.c));
                            } else {
                                boolean z4 = sVar.b == 1;
                                int i33 = 0;
                                int i34 = 0;
                                boolean z5 = false;
                                int i35 = 0;
                                while (true) {
                                    long[] jArr12 = sVar.h;
                                    if (i35 >= jArr12.length) {
                                        break;
                                    }
                                    int[] iArr10 = iArr3;
                                    int[] iArr11 = iArr2;
                                    long j13 = sVar.i[i35];
                                    if (j13 != -1) {
                                        long jA5 = com.smartdigimkt.z0.u.a(jArr12[i35], sVar.c, sVar.d);
                                        int iA4 = com.smartdigimkt.z0.u.a(jArr3, j13, true, true);
                                        int iA5 = com.smartdigimkt.z0.u.a(jArr3, j13 + jA5, z4, false);
                                        int i36 = (iA5 - iA4) + i33;
                                        z5 = (i34 != iA4) | z5;
                                        i33 = i36;
                                        i34 = iA5;
                                    }
                                    i35++;
                                    iArr2 = iArr11;
                                    iArr3 = iArr10;
                                }
                                int[] iArr12 = iArr3;
                                int[] iArr13 = iArr2;
                                boolean z6 = (i33 != i13) | z5;
                                long[] jArr13 = z6 ? new long[i33] : jArr4;
                                int[] iArr14 = z6 ? new int[i33] : iArr13;
                                if (z6) {
                                    i11 = 0;
                                }
                                int[] iArr15 = z6 ? new int[i33] : iArr12;
                                long[] jArr14 = new long[i33];
                                int i37 = 0;
                                int i38 = 0;
                                while (true) {
                                    long[] jArr15 = sVar.h;
                                    if (i37 < jArr15.length) {
                                        int[] iArr16 = iArr14;
                                        int[] iArr17 = iArr15;
                                        long j14 = sVar.i[i37];
                                        long j15 = jArr15[i37];
                                        if (j14 != -1) {
                                            iArr4 = iArr13;
                                            jArr6 = jArr4;
                                            long jA6 = com.smartdigimkt.z0.u.a(j15, sVar.c, sVar.d) + j14;
                                            int iA6 = com.smartdigimkt.z0.u.a(jArr3, j14, true, true);
                                            int iA7 = com.smartdigimkt.z0.u.a(jArr3, jA6, z4, false);
                                            if (z6) {
                                                int i39 = iA7 - iA6;
                                                System.arraycopy(jArr6, iA6, jArr13, i38, i39);
                                                iArr7 = iArr16;
                                                System.arraycopy(iArr4, iA6, iArr7, i38, i39);
                                                iArr5 = iArr12;
                                                iArr6 = iArr17;
                                                System.arraycopy(iArr5, iA6, iArr6, i38, i39);
                                            } else {
                                                iArr5 = iArr12;
                                                iArr6 = iArr17;
                                                iArr7 = iArr16;
                                            }
                                            if (iA6 < iA7 && (iArr6[i38] & 1) == 0) {
                                                throw new h();
                                            }
                                            int i40 = i11;
                                            while (true) {
                                                j4 = j15;
                                                if (iA6 >= iA7) {
                                                    break;
                                                }
                                                long j16 = j14;
                                                jArr14[i38] = com.smartdigimkt.z0.u.a(j8, C.MICROS_PER_SECOND, sVar.d) + com.smartdigimkt.z0.u.a(jArr3[iA6] - j14, C.MICROS_PER_SECOND, sVar.c);
                                                if (z6 && iArr7[i38] > i40) {
                                                    i40 = iArr4[iA6];
                                                }
                                                i38++;
                                                iA6++;
                                                j14 = j16;
                                                j15 = j4;
                                            }
                                            i11 = i40;
                                        } else {
                                            jArr6 = jArr4;
                                            iArr4 = iArr13;
                                            j4 = j15;
                                            iArr5 = iArr12;
                                            jArr13 = jArr13;
                                            iArr6 = iArr17;
                                            z4 = z4;
                                            iArr7 = iArr16;
                                        }
                                        j8 += j4;
                                        i37++;
                                        iArr14 = iArr7;
                                        iArr15 = iArr6;
                                        z4 = z4;
                                        jArr13 = jArr13;
                                        jArr4 = jArr6;
                                        iArr12 = iArr5;
                                        iArr13 = iArr4;
                                    } else {
                                        vVar = new v(sVar, jArr13, iArr14, i11, jArr14, iArr15, com.smartdigimkt.z0.u.a(j8, C.MICROS_PER_SECOND, sVar.c));
                                        break;
                                    }
                                }
                            }
                        } else {
                            com.smartdigimkt.z0.u.a(jArr3, sVar.c);
                            vVar = new v(sVar, jArr4, iArr2, i11, jArr3, iArr3, jA);
                        }
                    } else {
                        i3 = i;
                    }
                    z3 = false;
                    long j17 = 0;
                    if (!z3) {
                        jArr4 = new long[iB];
                        iArr8 = new int[iB];
                        int i210 = iH5;
                        jArr7 = new long[iB];
                        iH2 = iH6;
                        iArr3 = new int[iB];
                        j5 = 0;
                        j6 = 0;
                        i14 = 0;
                        iA2 = 0;
                        i15 = 0;
                        iH3 = 0;
                        i16 = 0;
                        int i211 = i2;
                        iA3 = iH7;
                        iH4 = i3;
                        i17 = iH;
                        i18 = i211;
                        while (i15 < iB) {
                            while (i16 == 0) {
                                if (dVar.a()) {
                                    j6 = dVar.d;
                                    i16 = dVar.c;
                                    sVarA = sVarA;
                                    iA3 = iA3;
                                } else {
                                    throw new IllegalStateException();
                                }
                            }
                            int i212 = iA3;
                            s sVar5 = sVarA;
                            if (mVar6 != null) {
                                while (iH3 == 0) {
                                    iH3 = mVar6.h();
                                    iA2 = mVar6.a();
                                    i17--;
                                }
                                iH3--;
                            }
                            jArr4[i15] = j6;
                            iC = gVar.c();
                            iArr8[i15] = iC;
                            if (iC > i14) {
                                i14 = iC;
                            }
                            jArr7[i15] = j5 + ((long) iA2);
                            if (mVar4 == null) {
                                i19 = 1;
                            } else {
                                i19 = 0;
                            }
                            iArr3[i15] = i19;
                            if (i15 == iH4) {
                                iArr3[i15] = 1;
                                i18--;
                                if (i18 > 0) {
                                    iH4 = mVar4.h() - 1;
                                }
                            }
                            long[] jArr16 = jArr7;
                            iA3 = i212;
                            int i213 = iH4;
                            j5 += (long) iA3;
                            iH2--;
                            if (iH2 != 0) {
                            }
                            j6 += (long) iArr8[i15];
                            i16--;
                            i15++;
                            jArr7 = jArr16;
                            sVarA = sVar5;
                            iH4 = i213;
                        }
                        sVar2 = sVarA;
                        jArr8 = jArr7;
                        j7 = j5 + ((long) iA2);
                        if (iH3 == 0) {
                            throw new IllegalArgumentException();
                        }
                        while (i17 > 0) {
                            if (mVar6.h() == 0) {
                                mVar6.a();
                                i17--;
                            } else {
                                throw new IllegalArgumentException();
                            }
                        }
                        i11 = i14;
                        iArr2 = iArr8;
                        jArr3 = jArr8;
                        j2 = j7;
                        sVar = sVar2;
                    } else {
                        i4 = dVar.a;
                        jArr = new long[i4];
                        iArr = new int[i4];
                        while (dVar.a()) {
                            int i214 = dVar.b;
                            jArr[i214] = dVar.d;
                            iArr[i214] = dVar.c;
                        }
                        sVar = sVarA;
                        com.smartdigimkt.i0.s sVar6 = sVar.f;
                        iA = com.smartdigimkt.z0.u.a(sVar6.u, sVar6.s);
                        j = iH7;
                        i5 = 8192 / iA;
                        i7 = 0;
                        while (i6 < i4) {
                            int i215 = iArr[i6];
                            int i216 = com.smartdigimkt.z0.u.a;
                            i7 += ((i215 + i5) - 1) / i5;
                        }
                        jArr2 = new long[i7];
                        iArr2 = new int[i7];
                        jArr3 = new long[i7];
                        iArr3 = new int[i7];
                        i8 = 0;
                        i9 = 0;
                        i10 = 0;
                        i11 = 0;
                        while (i8 < i4) {
                            int i217 = iArr[i8];
                            j3 = jArr[i8];
                            long[] jArr17 = jArr;
                            i12 = i217;
                            int i310 = i4;
                            iMax = i11;
                            while (i12 > 0) {
                                int iMin2 = Math.min(i5, i12);
                                jArr2[i10] = j3;
                                int[] iArr18 = iArr;
                                int i311 = iA * iMin2;
                                iArr2[i10] = i311;
                                iMax = Math.max(iMax, i311);
                                jArr3[i10] = ((long) i9) * j;
                                iArr3[i10] = 1;
                                j3 += (long) iArr2[i10];
                                i9 += iMin2;
                                i12 -= iMin2;
                                i10++;
                                i5 = i5;
                                iArr = iArr18;
                                jArr2 = jArr2;
                            }
                            i8++;
                            i11 = iMax;
                            i4 = i310;
                            jArr = jArr17;
                            iArr = iArr;
                        }
                        j2 = ((long) i9) * j;
                        jArr4 = jArr2;
                    }
                    jA = com.smartdigimkt.z0.u.a(j2, C.MICROS_PER_SECOND, sVar.c);
                    jArr5 = sVar.h;
                    if (jArr5 == null) {
                        com.smartdigimkt.z0.u.a(jArr3, sVar.c);
                        vVar = new v(sVar, jArr4, iArr2, i11, jArr3, iArr3, jA);
                    } else {
                        com.smartdigimkt.z0.u.a(jArr3, sVar.c);
                        vVar = new v(sVar, jArr4, iArr2, i11, jArr3, iArr3, jA);
                    }
                }
                if (vVar.b == 0) {
                    arrayList = arrayList2;
                } else {
                    arrayList = arrayList2;
                    arrayList.add(vVar);
                }
            } else {
                arrayList = arrayList2;
                i21 = i21;
            }
            i21++;
            arrayList2 = arrayList;
            i20 = 0;
        }
        return arrayList2;
    }
}
