package com.smartdigimkt.t0;

import com.smartdigimkt.z0.r;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements com.smartdigimkt.q0.d {
    public final com.smartdigimkt.z0.m a = new com.smartdigimkt.z0.m();
    public final com.smartdigimkt.z0.l b = new com.smartdigimkt.z0.l();
    public r c;

    /* JADX WARN: Code duplicated, block: B:13:0x002c  */
    @Override // com.smartdigimkt.q0.d
    public final com.smartdigimkt.q0.c a(com.smartdigimkt.q0.f fVar) {
        int i;
        com.smartdigimkt.q0.b iVar;
        int i2;
        long j;
        ArrayList arrayList;
        boolean z;
        boolean z2;
        long j2;
        boolean z3;
        long j3;
        int iJ;
        int iE;
        int iE2;
        long jF;
        boolean z4;
        List list;
        long j4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        long j5;
        int i3;
        int i4;
        int iE3;
        boolean z9;
        long jF2;
        r rVar = this.c;
        long j6 = 0;
        if (rVar != null) {
            if (fVar.f != (rVar.a == LongCompanionObject.MAX_VALUE ? 0L : rVar.c == -9223372036854775807L ? -9223372036854775807L : rVar.b)) {
                r rVar2 = new r(fVar.c);
                this.c = rVar2;
                rVar2.a(fVar.c - fVar.f);
            }
        } else {
            r rVar3 = new r(fVar.c);
            this.c = rVar3;
            rVar3.a(fVar.c - fVar.f);
        }
        ByteBuffer byteBuffer = fVar.b;
        byte[] bArrArray = byteBuffer.array();
        int iLimit = byteBuffer.limit();
        com.smartdigimkt.z0.m mVar = this.a;
        mVar.a = bArrArray;
        mVar.c = iLimit;
        mVar.b = 0;
        com.smartdigimkt.z0.l lVar = this.b;
        lVar.a = bArrArray;
        lVar.d = iLimit;
        lVar.b = 4;
        lVar.c = 7;
        int i5 = lVar.b;
        if (i5 < 0 || (i5 >= iLimit && !(i5 == iLimit && lVar.c == 0))) {
            throw new IllegalStateException();
        }
        long jA = (((long) lVar.a(1)) << 32) | ((long) this.b.a(32));
        com.smartdigimkt.z0.l lVar2 = this.b;
        int i6 = lVar2.b;
        lVar2.b = i6 + 2;
        int i7 = lVar2.c;
        int i8 = i7 + 4;
        lVar2.c = i8;
        if (i8 > 7) {
            lVar2.b = i6 + 3;
            lVar2.c = i7 - 4;
        }
        int i9 = lVar2.b;
        if (i9 < 0 || (i9 >= (i = lVar2.d) && !(i9 == i && lVar2.c == 0))) {
            throw new IllegalStateException();
        }
        int iA = lVar2.a(12);
        int iA2 = this.b.a(8);
        com.smartdigimkt.z0.m mVar2 = this.a;
        mVar2.c(mVar2.b + 14);
        if (iA2 == 0) {
            iVar = new i();
        } else if (iA2 == 255) {
            com.smartdigimkt.z0.m mVar3 = this.a;
            long jF3 = mVar3.f();
            int i10 = iA - 4;
            byte[] bArr = new byte[i10];
            mVar3.a(bArr, 0, i10);
            iVar = new b(jF3, bArr, jA);
        } else if (iA2 == 4) {
            com.smartdigimkt.z0.m mVar4 = this.a;
            int iE4 = mVar4.e();
            ArrayList arrayList2 = new ArrayList(iE4);
            int i11 = 0;
            while (i11 < iE4) {
                long jF4 = mVar4.f();
                boolean z10 = (mVar4.e() & 128) != 0;
                ArrayList arrayList3 = new ArrayList();
                if (z10) {
                    i2 = iE4;
                    j = j6;
                    arrayList = arrayList3;
                    z = false;
                    z2 = false;
                    j2 = -9223372036854775807L;
                    z3 = false;
                    j3 = -9223372036854775807L;
                    iJ = 0;
                    iE = 0;
                    iE2 = 0;
                } else {
                    int iE5 = mVar4.e();
                    boolean z11 = (iE5 & 128) != 0;
                    boolean z12 = (iE5 & 64) != 0;
                    boolean z13 = (iE5 & 32) != 0;
                    long jF5 = z12 ? mVar4.f() : -9223372036854775807L;
                    if (z12) {
                        i2 = iE4;
                    } else {
                        int iE6 = mVar4.e();
                        ArrayList arrayList4 = new ArrayList(iE6);
                        int i12 = 0;
                        while (i12 < iE6) {
                            arrayList4.add(new k(mVar4.e(), 0, mVar4.f()));
                            i12++;
                            iE4 = iE4;
                            iE6 = iE6;
                        }
                        i2 = iE4;
                        arrayList3 = arrayList4;
                    }
                    if (z13) {
                        long jE = mVar4.e();
                        j = 0;
                        z4 = (jE & 128) != 0;
                        jF = ((((jE & 1) << 32) | mVar4.f()) * 1000) / 90;
                    } else {
                        j = 0;
                        jF = -9223372036854775807L;
                        z4 = false;
                    }
                    j3 = jF;
                    z3 = z4;
                    arrayList = arrayList3;
                    iJ = mVar4.j();
                    z = z11;
                    z2 = z12;
                    j2 = jF5;
                    iE = mVar4.e();
                    iE2 = mVar4.e();
                }
                arrayList2.add(new l(jF4, z10, z, z2, arrayList, j2, z3, j3, iJ, iE, iE2));
                i11++;
                j6 = j;
                iE4 = i2;
            }
            iVar = new m(arrayList2);
        } else if (iA2 == 5) {
            com.smartdigimkt.z0.m mVar5 = this.a;
            r rVar4 = this.c;
            long jF6 = mVar5.f();
            boolean z14 = (mVar5.e() & 128) != 0;
            List listEmptyList = Collections.emptyList();
            if (z14) {
                list = listEmptyList;
                j4 = -9223372036854775807L;
                z5 = false;
                z6 = false;
                z7 = false;
                z8 = false;
                j5 = -9223372036854775807L;
                i3 = 0;
                i4 = 0;
                iE3 = 0;
            } else {
                int iE7 = mVar5.e();
                boolean z15 = (iE7 & 128) != 0;
                boolean z16 = (iE7 & 64) != 0;
                boolean z17 = (iE7 & 32) != 0;
                boolean z18 = (iE7 & 16) != 0;
                long jA2 = (!z16 || z18) ? -9223372036854775807L : o.a(mVar5, jA);
                if (!z16) {
                    int iE8 = mVar5.e();
                    ArrayList arrayList5 = new ArrayList(iE8);
                    for (int i13 = 0; i13 < iE8; i13++) {
                        int iE9 = mVar5.e();
                        long jA3 = !z18 ? o.a(mVar5, jA) : -9223372036854775807L;
                        arrayList5.add(new f(iE9, jA3, rVar4.b(jA3), 0));
                    }
                    listEmptyList = arrayList5;
                }
                if (z17) {
                    long jE2 = mVar5.e();
                    z9 = (jE2 & 128) != 0;
                    jF2 = ((((jE2 & 1) << 32) | mVar5.f()) * 1000) / 90;
                } else {
                    z9 = false;
                    jF2 = -9223372036854775807L;
                }
                int iJ2 = mVar5.j();
                int iE10 = mVar5.e();
                z8 = z9;
                iE3 = mVar5.e();
                j5 = jF2;
                z7 = z18;
                z5 = z15;
                i3 = iJ2;
                i4 = iE10;
                list = listEmptyList;
                z6 = z16;
                j4 = jA2;
            }
            iVar = new g(jF6, z14, z5, z6, z7, j4, rVar4.b(j4), list, z8, j5, i3, i4, iE3);
        } else if (iA2 != 6) {
            iVar = null;
        } else {
            com.smartdigimkt.z0.m mVar6 = this.a;
            r rVar5 = this.c;
            long jA4 = o.a(mVar6, jA);
            iVar = new o(jA4, rVar5.b(jA4));
        }
        return iVar == null ? new com.smartdigimkt.q0.c(new com.smartdigimkt.q0.b[0]) : new com.smartdigimkt.q0.c(iVar);
    }
}
