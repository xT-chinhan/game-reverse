package com.anythink.core.common.s.a;

import com.umeng.analytics.pro.ek;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class k implements com.anythink.core.common.s.a.a.b<Set<String>> {
    static final k a = new k();

    @Override // com.anythink.core.common.s.a.a.b
    public final String a() {
        return "StringSet";
    }

    @Override // com.anythink.core.common.s.a.a.b
    public final /* synthetic */ byte[] a(Set<String> set) {
        int i;
        Set<String> set2 = set;
        if (set2.isEmpty()) {
            return new byte[0];
        }
        int size = set2.size();
        int[] iArr = new int[size];
        String[] strArr = new String[size];
        int i2 = 0;
        int i3 = 0;
        for (String str : set2) {
            if (str == null) {
                i2 += 5;
                iArr[i3] = -1;
            } else {
                int iB = f.b(str);
                strArr[i3] = str;
                iArr[i3] = iB;
                if ((iB >> 7) == 0) {
                    i = 1;
                } else if ((iB >> 14) == 0) {
                    i = 2;
                } else if ((iB >> 21) == 0) {
                    i = 3;
                } else {
                    i = (iB >> 28) == 0 ? 4 : 5;
                }
                i2 += i + iB;
            }
            i3++;
        }
        f fVar = new f(i2);
        for (int i4 = 0; i4 < size; i4++) {
            int i5 = iArr[i4];
            int i6 = fVar.b;
            int i7 = i5;
            while ((i7 & (-128)) != 0) {
                fVar.a[i6] = (byte) ((i7 & 127) | 128);
                i7 >>>= 7;
                i6++;
            }
            fVar.a[i6] = (byte) i7;
            fVar.b = i6 + 1;
            if (i5 >= 0) {
                fVar.a(strArr[i4]);
            }
        }
        return fVar.a;
    }

    private k() {
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    private static byte[] a2(Set<String> set) {
        int i;
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
                int iB = f.b(str);
                strArr[i3] = str;
                iArr[i3] = iB;
                if ((iB >> 7) == 0) {
                    i = 1;
                } else if ((iB >> 14) == 0) {
                    i = 2;
                } else if ((iB >> 21) == 0) {
                    i = 3;
                } else {
                    i = (iB >> 28) == 0 ? 4 : 5;
                }
                i2 += i + iB;
            }
            i3++;
        }
        f fVar = new f(i2);
        for (int i4 = 0; i4 < size; i4++) {
            int i5 = iArr[i4];
            int i6 = fVar.b;
            int i7 = i5;
            while ((i7 & (-128)) != 0) {
                fVar.a[i6] = (byte) ((i7 & 127) | 128);
                i7 >>>= 7;
                i6++;
            }
            fVar.a[i6] = (byte) i7;
            fVar.b = i6 + 1;
            if (i5 >= 0) {
                fVar.a(strArr[i4]);
            }
        }
        return fVar.a;
    }

    private static Set<String> b(byte[] bArr, int i, int i2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (i2 > 0) {
            f fVar = new f(bArr, i);
            int i3 = i + i2;
            while (fVar.b < i3) {
                byte[] bArr2 = fVar.a;
                int i4 = fVar.b;
                fVar.b = i4 + 1;
                int i5 = bArr2[i4];
                if ((i5 >> 7) != 0) {
                    byte[] bArr3 = fVar.a;
                    int i6 = fVar.b;
                    fVar.b = i6 + 1;
                    i5 = (i5 & 127) | (bArr3[i6] << 7);
                    if ((i5 >> 14) != 0) {
                        byte[] bArr4 = fVar.a;
                        int i7 = fVar.b;
                        fVar.b = i7 + 1;
                        i5 = (i5 & 16383) | (bArr4[i7] << ek.l);
                        if ((i5 >> 21) != 0) {
                            byte[] bArr5 = fVar.a;
                            int i8 = fVar.b;
                            fVar.b = i8 + 1;
                            i5 = (i5 & 2097151) | (bArr5[i8] << 21);
                            if ((i5 >> 28) != 0) {
                                byte[] bArr6 = fVar.a;
                                int i9 = fVar.b;
                                fVar.b = i9 + 1;
                                i5 = (i5 & 268435455) | (bArr6[i9] << 28);
                            }
                        }
                    }
                }
                linkedHashSet.add(fVar.d(i5));
            }
            if (fVar.b != i3) {
                throw new IllegalArgumentException("Invalid String set");
            }
        }
        return linkedHashSet;
    }

    @Override // com.anythink.core.common.s.a.a.b
    public final /* synthetic */ Set<String> a(byte[] bArr, int i, int i2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (i2 > 0) {
            f fVar = new f(bArr, i);
            int i3 = i + i2;
            while (fVar.b < i3) {
                byte[] bArr2 = fVar.a;
                int i4 = fVar.b;
                fVar.b = i4 + 1;
                int i5 = bArr2[i4];
                if ((i5 >> 7) != 0) {
                    byte[] bArr3 = fVar.a;
                    int i6 = fVar.b;
                    fVar.b = i6 + 1;
                    i5 = (i5 & 127) | (bArr3[i6] << 7);
                    if ((i5 >> 14) != 0) {
                        byte[] bArr4 = fVar.a;
                        int i7 = fVar.b;
                        fVar.b = i7 + 1;
                        i5 = (i5 & 16383) | (bArr4[i7] << ek.l);
                        if ((i5 >> 21) != 0) {
                            byte[] bArr5 = fVar.a;
                            int i8 = fVar.b;
                            fVar.b = i8 + 1;
                            i5 = (i5 & 2097151) | (bArr5[i8] << 21);
                            if ((i5 >> 28) != 0) {
                                byte[] bArr6 = fVar.a;
                                int i9 = fVar.b;
                                fVar.b = i9 + 1;
                                i5 = (i5 & 268435455) | (bArr6[i9] << 28);
                            }
                        }
                    }
                }
                linkedHashSet.add(fVar.d(i5));
            }
            if (fVar.b != i3) {
                throw new IllegalArgumentException("Invalid String set");
            }
        }
        return linkedHashSet;
    }
}
