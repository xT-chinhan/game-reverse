package com.smartdigimkt.k0;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class g0 {
    public final int a;
    public final int b;
    public final float c;
    public final float d;
    public final float e;
    public final int f;
    public final int g;
    public final int h;
    public final short[] i;
    public short[] j;
    public int k;
    public short[] l;
    public int m;
    public short[] n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;

    public g0(int i, int i2, float f, float f2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = f;
        this.d = f2;
        this.e = i / i3;
        this.f = i / MediaPlayer.MEDIA_PLAYER_OPTION_USE_CODEC_POOL;
        int i4 = i / 65;
        this.g = i4;
        int i5 = i4 * 2;
        this.h = i5;
        this.i = new short[i5];
        int i6 = i5 * i2;
        this.j = new short[i6];
        this.l = new short[i6];
        this.n = new short[i6];
    }

    public final void a(short[] sArr, int i, int i2) {
        int i3 = this.h / i2;
        int i4 = this.b;
        int i5 = i2 * i4;
        int i6 = i * i4;
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = 0;
            for (int i9 = 0; i9 < i5; i9++) {
                i8 += sArr[(i7 * i5) + i6 + i9];
            }
            this.i[i7] = (short) (i8 / i5);
        }
    }

    public final short[] b(short[] sArr, int i, int i2) {
        int length = sArr.length;
        int i3 = this.b;
        int i4 = length / i3;
        return i + i2 <= i4 ? sArr : Arrays.copyOf(sArr, (((i4 * 3) / 2) + i2) * i3);
    }

    public final int a(short[] sArr, int i, int i2, int i3) {
        int i4 = i * this.b;
        int i5 = 255;
        int i6 = 1;
        int i7 = 0;
        int i8 = 0;
        while (i2 <= i3) {
            int iAbs = 0;
            for (int i9 = 0; i9 < i2; i9++) {
                iAbs += Math.abs(sArr[i4 + i9] - sArr[(i4 + i2) + i9]);
            }
            if (iAbs * i7 < i6 * i2) {
                i7 = i2;
                i6 = iAbs;
            }
            if (iAbs * i5 > i8 * i2) {
                i5 = i2;
                i8 = iAbs;
            }
            i2++;
        }
        this.u = i6 / i7;
        this.v = i8 / i5;
        return i7;
    }

    /* JADX WARN: Code duplicated, block: B:108:0x018e A[EDGE_INSN: B:108:0x018e->B:64:0x018e BREAK  A[LOOP:4: B:12:0x004a->B:98:0x025e], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:0x025e A[LOOP:4: B:12:0x004a->B:98:0x025e, LOOP_END] */
    public final void a() {
        int iA;
        int i;
        int iMin;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6 = this.m;
        float f = this.c;
        float f2 = this.d;
        float f3 = f / f2;
        float f4 = this.e * f2;
        double d = f3;
        int i7 = 1;
        if (d <= 1.00001d && d >= 0.99999d) {
            short[] sArr = this.j;
            int i8 = this.k;
            short[] sArrB = b(this.l, i6, i8);
            this.l = sArrB;
            int i9 = this.b;
            System.arraycopy(sArr, 0, sArrB, this.m * i9, i9 * i8);
            this.m += i8;
            this.k = 0;
        } else {
            int i10 = this.k;
            if (i10 >= this.h) {
                int i11 = 0;
                while (true) {
                    int i12 = this.r;
                    if (i12 > 0) {
                        iMin = Math.min(this.h, i12);
                        short[] sArr2 = this.j;
                        short[] sArrB2 = b(this.l, this.m, iMin);
                        this.l = sArrB2;
                        int i13 = this.b;
                        System.arraycopy(sArr2, i11 * i13, sArrB2, this.m * i13, i13 * iMin);
                        this.m += iMin;
                        this.r -= iMin;
                    } else {
                        short[] sArr3 = this.j;
                        int i14 = this.a;
                        int i15 = i14 > 4000 ? i14 / TTAdConstant.INIT_LOCAL_FAIL_CODE : i7;
                        if (this.b == i7 && i15 == i7) {
                            iA = a(sArr3, i11, this.f, this.g);
                        } else {
                            a(sArr3, i11, i15);
                            int iA2 = a(this.i, 0, this.f / i15, this.g / i15);
                            if (i15 != i7) {
                                int i16 = iA2 * i15;
                                int i17 = i15 * 4;
                                int i18 = i16 - i17;
                                int i19 = i16 + i17;
                                int i20 = this.f;
                                if (i18 < i20) {
                                    i18 = i20;
                                }
                                int i21 = this.g;
                                if (i19 > i21) {
                                    i19 = i21;
                                }
                                if (this.b == i7) {
                                    iA = a(sArr3, i11, i18, i19);
                                } else {
                                    a(sArr3, i11, i7);
                                    iA = a(this.i, 0, i18, i19);
                                }
                            } else {
                                iA = iA2;
                            }
                        }
                        int i22 = this.u;
                        int i23 = (i22 == 0 || (i3 = this.s) == 0 || this.v > i22 * 3 || i22 * 2 <= this.t * 3) ? iA : i3;
                        this.t = i22;
                        this.s = iA;
                        if (d > 1.0d) {
                            short[] sArr4 = this.j;
                            if (f3 >= 2.0f) {
                                i2 = (int) (i23 / (f3 - 1.0f));
                            } else {
                                this.r = (int) (((2.0f - f3) * i23) / (f3 - 1.0f));
                                i2 = i23;
                            }
                            short[] sArrB3 = b(this.l, this.m, i2);
                            this.l = sArrB3;
                            int i24 = i2;
                            a(i2, this.b, sArrB3, this.m, sArr4, i11, sArr4, i11 + i23);
                            this.m += i24;
                            i11 = i23 + i24 + i11;
                        } else {
                            int i25 = i23;
                            short[] sArr5 = this.j;
                            if (f3 < 0.5f) {
                                i = (int) ((i25 * f3) / (1.0f - f3));
                            } else {
                                this.r = (int) ((((2.0f * f3) - 1.0f) * i25) / (1.0f - f3));
                                i = i25;
                            }
                            int i26 = i25 + i;
                            short[] sArrB4 = b(this.l, this.m, i26);
                            this.l = sArrB4;
                            int i27 = this.b;
                            System.arraycopy(sArr5, i11 * i27, sArrB4, this.m * i27, i27 * i25);
                            iMin = i;
                            a(iMin, this.b, this.l, this.m + i25, sArr5, i11 + i25, sArr5, i11);
                            this.m += i26;
                        }
                        if (this.h + i11 > i10) {
                            break;
                        } else {
                            i7 = 1;
                        }
                    }
                    i11 += iMin;
                    if (this.h + i11 > i10) {
                        break;
                        break;
                    }
                    i7 = 1;
                }
                int i28 = this.k - i11;
                short[] sArr6 = this.j;
                int i29 = this.b;
                System.arraycopy(sArr6, i11 * i29, sArr6, 0, i29 * i28);
                this.k = i28;
            }
        }
        if (f4 == 1.0f || this.m == i6) {
            return;
        }
        int i30 = this.a;
        int i31 = (int) (i30 / f4);
        while (true) {
            if (i31 <= 16384 && i30 <= 16384) {
                break;
            }
            i31 /= 2;
            i30 /= 2;
        }
        int i32 = this.m - i6;
        short[] sArrB5 = b(this.n, this.o, i32);
        this.n = sArrB5;
        short[] sArr7 = this.l;
        int i33 = this.b;
        System.arraycopy(sArr7, i6 * i33, sArrB5, this.o * i33, i33 * i32);
        this.m = i6;
        this.o += i32;
        int i34 = 0;
        while (true) {
            int i35 = this.o;
            int i36 = i35 - 1;
            if (i34 >= i36) {
                if (i36 == 0) {
                    return;
                }
                short[] sArr8 = this.n;
                int i37 = this.b;
                System.arraycopy(sArr8, i36 * i37, sArr8, 0, (i35 - i36) * i37);
                this.o -= i36;
                return;
            }
            while (true) {
                i4 = this.p + 1;
                int i38 = i4 * i31;
                i5 = this.q;
                if (i38 <= i5 * i30) {
                    break;
                }
                this.l = b(this.l, this.m, 1);
                int i39 = 0;
                while (true) {
                    int i40 = this.b;
                    if (i39 < i40) {
                        short[] sArr9 = this.l;
                        int i41 = (this.m * i40) + i39;
                        short[] sArr10 = this.n;
                        int i42 = (i34 * i40) + i39;
                        short s = sArr10[i42];
                        short s2 = sArr10[i42 + i40];
                        int i43 = this.q * i30;
                        int i44 = this.p;
                        int i45 = i44 * i31;
                        int i46 = (i44 + 1) * i31;
                        int i47 = i46 - i43;
                        int i48 = i46 - i45;
                        sArr9[i41] = (short) ((((i48 - i47) * s2) + (s * i47)) / i48);
                        i39++;
                    }
                }
                this.q++;
                this.m++;
            }
            this.p = i4;
            if (i4 == i30) {
                this.p = 0;
                if (i5 == i31) {
                    this.q = 0;
                } else {
                    throw new IllegalStateException();
                }
            }
            i34++;
        }
    }

    public static void a(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i3 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i4 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                sArr[i7] = (short) (((sArr3[i8] * i10) + ((i - i10) * sArr2[i9])) / i);
                i7 += i2;
                i9 += i2;
                i8 += i2;
            }
        }
    }
}
