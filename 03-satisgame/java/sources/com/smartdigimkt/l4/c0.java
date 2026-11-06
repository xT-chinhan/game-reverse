package com.smartdigimkt.l4;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 {
    public static final c0 a = new c0();

    public final byte[] a(Object obj) {
        int i;
        Set<String> set = (Set) obj;
        if (set.isEmpty()) {
            return new byte[0];
        }
        int size = set.size();
        int[] iArr = new int[size];
        String[] strArr = new String[size];
        int i2 = 0;
        int i3 = 0;
        for (String str : set) {
            if (str == null) {
                i2 += 5;
                iArr[i3] = -1;
            } else {
                int iA = s.a(str);
                strArr[i3] = str;
                iArr[i3] = iA;
                if ((iA >> 7) == 0) {
                    i = 1;
                } else if ((iA >> 14) == 0) {
                    i = 2;
                } else if ((iA >> 21) == 0) {
                    i = 3;
                } else {
                    i = (iA >> 28) == 0 ? 4 : 5;
                }
                i2 = i + iA + i2;
            }
            i3++;
        }
        r rVar = new r(i2);
        for (int i4 = 0; i4 < size; i4++) {
            int i5 = iArr[i4];
            int i6 = rVar.c;
            int i7 = i5;
            while ((i7 & (-128)) != 0) {
                rVar.b[i6] = (byte) ((i7 & WorkQueueKt.MASK) | 128);
                i7 >>>= 7;
                i6++;
            }
            rVar.b[i6] = (byte) i7;
            rVar.c = i6 + 1;
            if (i5 >= 0) {
                rVar.b(strArr[i4]);
            }
        }
        return rVar.b;
    }

    public final LinkedHashSet a(byte[] bArr, int i, int i2) {
        int i3;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (i2 > 0) {
            r rVar = new r(i, bArr);
            int i4 = i + i2;
            while (true) {
                i3 = rVar.c;
                if (i3 >= i4) {
                    break;
                }
                byte[] bArr2 = rVar.b;
                int i5 = i3 + 1;
                rVar.c = i5;
                int i6 = bArr2[i3];
                if ((i6 >> 7) != 0) {
                    int i7 = i6 & WorkQueueKt.MASK;
                    int i8 = i3 + 2;
                    rVar.c = i8;
                    i6 = i7 | (bArr2[i5] << 7);
                    if ((i6 >> 14) != 0) {
                        int i9 = i6 & 16383;
                        int i10 = i3 + 3;
                        rVar.c = i10;
                        int i11 = i9 | (bArr2[i8] << 14);
                        if ((i11 >> 21) == 0) {
                            i6 = i11;
                        } else {
                            int i12 = i3 + 4;
                            rVar.c = i12;
                            i6 = (bArr2[i10] << 21) | (i11 & 2097151);
                            if ((i6 >> 28) != 0) {
                                rVar.c = i3 + 5;
                                i6 = (268435455 & i6) | (bArr2[i12] << 28);
                            }
                        }
                    }
                }
                linkedHashSet.add(rVar.c(i6));
            }
            if (i3 != i4) {
                throw new IllegalArgumentException("Invalid String set");
            }
        }
        return linkedHashSet;
    }
}
