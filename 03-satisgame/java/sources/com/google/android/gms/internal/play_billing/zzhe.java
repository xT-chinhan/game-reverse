package com.google.android.gms.internal.play_billing;

import com.bykv.vk.component.ttvideo.player.C;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhe<T> implements zzhl<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzii.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzhb zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzib zzl;
    private final zzfi zzm;

    private zzhe(int[] iArr, Object[] objArr, int i, int i2, zzhb zzhbVar, boolean z, int[] iArr2, int i3, int i4, zzhg zzhgVar, zzgk zzgkVar, zzib zzibVar, zzfi zzfiVar, zzgw zzgwVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        boolean z2 = false;
        if (zzfiVar != null && (zzhbVar instanceof zzfr)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzi = iArr2;
        this.zzj = i3;
        this.zzk = i4;
        this.zzl = zzibVar;
        this.zzm = zzfiVar;
        this.zzg = zzhbVar;
    }

    private static void zzA(Object obj) {
        if (!zzL(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    private final void zzB(Object obj, Object obj2, int i) {
        if (zzI(obj2, i)) {
            int iZzs = zzs(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzhl zzhlVarZzv = zzv(i);
            if (!zzI(obj, i)) {
                if (zzL(object)) {
                    Object objZze = zzhlVarZzv.zze();
                    zzhlVarZzv.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzD(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object objZze2 = zzhlVarZzv.zze();
                zzhlVarZzv.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzhlVarZzv.zzg(object2, object);
        }
    }

    private final void zzC(Object obj, Object obj2, int i) {
        int[] iArr = this.zzc;
        int i2 = iArr[i];
        if (zzM(obj2, i2, i)) {
            int iZzs = zzs(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + iArr[i] + " is present but null: " + obj2.toString());
            }
            zzhl zzhlVarZzv = zzv(i);
            if (!zzM(obj, i2, i)) {
                if (zzL(object)) {
                    Object objZze = zzhlVarZzv.zze();
                    zzhlVarZzv.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzE(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object objZze2 = zzhlVarZzv.zze();
                zzhlVarZzv.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzhlVarZzv.zzg(object2, object);
        }
    }

    private final void zzD(Object obj, int i) {
        int iZzp = zzp(i);
        long j = 1048575 & iZzp;
        if (j == 1048575) {
            return;
        }
        zzii.zzq(obj, j, (1 << (iZzp >>> 20)) | zzii.zzc(obj, j));
    }

    private final void zzE(Object obj, int i, int i2) {
        zzii.zzq(obj, zzp(i2) & 1048575, i);
    }

    private final void zzF(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzs(i) & 1048575, obj2);
        zzD(obj, i);
    }

    private final void zzG(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzs(i2) & 1048575, obj2);
        zzE(obj, i, i2);
    }

    private final boolean zzH(Object obj, Object obj2, int i) {
        return zzI(obj, i) == zzI(obj2, i);
    }

    private final boolean zzI(Object obj, int i) {
        int iZzp = zzp(i);
        long j = iZzp & 1048575;
        if (j != 1048575) {
            return (zzii.zzc(obj, j) & (1 << (iZzp >>> 20))) != 0;
        }
        int iZzs = zzs(i);
        long j2 = iZzs & 1048575;
        switch (zzr(iZzs)) {
            case 0:
                return Double.doubleToRawLongBits(zzii.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzii.zzb(obj, j2)) != 0;
            case 2:
                return zzii.zzd(obj, j2) != 0;
            case 3:
                return zzii.zzd(obj, j2) != 0;
            case 4:
                return zzii.zzc(obj, j2) != 0;
            case 5:
                return zzii.zzd(obj, j2) != 0;
            case 6:
                return zzii.zzc(obj, j2) != 0;
            case 7:
                return zzii.zzw(obj, j2);
            case 8:
                Object objZzf = zzii.zzf(obj, j2);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzev) {
                    return !zzev.zza.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzii.zzf(obj, j2) != null;
            case 10:
                return !zzev.zza.equals(zzii.zzf(obj, j2));
            case 11:
                return zzii.zzc(obj, j2) != 0;
            case 12:
                return zzii.zzc(obj, j2) != 0;
            case 13:
                return zzii.zzc(obj, j2) != 0;
            case 14:
                return zzii.zzd(obj, j2) != 0;
            case 15:
                return zzii.zzc(obj, j2) != 0;
            case 16:
                return zzii.zzd(obj, j2) != 0;
            case 17:
                return zzii.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzJ(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzI(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzK(Object obj, int i, zzhl zzhlVar) {
        return zzhlVar.zzk(zzii.zzf(obj, i & 1048575));
    }

    private static boolean zzL(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzfu) {
            return ((zzfu) obj).zzF();
        }
        return true;
    }

    private final boolean zzM(Object obj, int i, int i2) {
        return zzii.zzc(obj, (long) (zzp(i2) & 1048575)) == i;
    }

    private static boolean zzN(Object obj, long j) {
        return ((Boolean) zzii.zzf(obj, j)).booleanValue();
    }

    private static final int zzO(byte[] bArr, int i, int i2, zzir zzirVar, Class cls, zzej zzejVar) throws IOException {
        int i3;
        zzir zzirVar2 = zzir.DOUBLE;
        switch (zzirVar) {
            case DOUBLE:
                i3 = i + 8;
                zzejVar.zzc = Double.valueOf(Double.longBitsToDouble(zzek.zzp(bArr, i)));
                break;
            case FLOAT:
                i3 = i + 4;
                zzejVar.zzc = Float.valueOf(Float.intBitsToFloat(zzek.zzb(bArr, i)));
                break;
            case INT64:
            case UINT64:
                int iZzl = zzek.zzl(bArr, i, zzejVar);
                zzejVar.zzc = Long.valueOf(zzejVar.zzb);
                return iZzl;
            case INT32:
            case UINT32:
            case ENUM:
                int iZzi = zzek.zzi(bArr, i, zzejVar);
                zzejVar.zzc = Integer.valueOf(zzejVar.zza);
                return iZzi;
            case FIXED64:
            case SFIXED64:
                i3 = i + 8;
                zzejVar.zzc = Long.valueOf(zzek.zzp(bArr, i));
                break;
            case FIXED32:
            case SFIXED32:
                i3 = i + 4;
                zzejVar.zzc = Integer.valueOf(zzek.zzb(bArr, i));
                break;
            case BOOL:
                int iZzl2 = zzek.zzl(bArr, i, zzejVar);
                zzejVar.zzc = Boolean.valueOf(zzejVar.zzb != 0);
                return iZzl2;
            case STRING:
                return zzek.zzg(bArr, i, zzejVar);
            case GROUP:
            default:
                throw new RuntimeException("unsupported field type.");
            case MESSAGE:
                return zzek.zzd(zzhi.zza().zzb(cls), bArr, i, i2, zzejVar);
            case BYTES:
                return zzek.zza(bArr, i, zzejVar);
            case SINT32:
                int iZzi2 = zzek.zzi(bArr, i, zzejVar);
                zzejVar.zzc = Integer.valueOf(zzey.zzb(zzejVar.zza));
                return iZzi2;
            case SINT64:
                int iZzl3 = zzek.zzl(bArr, i, zzejVar);
                zzejVar.zzc = Long.valueOf(zzey.zzc(zzejVar.zzb));
                return iZzl3;
        }
        return i3;
    }

    private static final void zzP(int i, Object obj, zzit zzitVar) throws IOException {
        if (obj instanceof String) {
            zzitVar.zzH(i, (String) obj);
        } else {
            zzitVar.zzd(i, (zzev) obj);
        }
    }

    static zzic zzd(Object obj) {
        zzfu zzfuVar = (zzfu) obj;
        zzic zzicVar = zzfuVar.zzc;
        if (zzicVar != zzic.zzc()) {
            return zzicVar;
        }
        zzic zzicVarZzf = zzic.zzf();
        zzfuVar.zzc = zzicVarZzf;
        return zzicVarZzf;
    }

    /* JADX WARN: Code duplicated, block: B:125:0x0265  */
    /* JADX WARN: Code duplicated, block: B:126:0x0268  */
    /* JADX WARN: Code duplicated, block: B:129:0x027f  */
    /* JADX WARN: Code duplicated, block: B:130:0x0282  */
    /* JADX WARN: Code duplicated, block: B:184:0x0398  */
    static zzhe zzl(Class cls, zzgy zzgyVar, zzhg zzhgVar, zzgk zzgkVar, zzib zzibVar, zzfi zzfiVar, zzgw zzgwVar) {
        int i;
        int iCharAt;
        int iCharAt2;
        int i2;
        int i3;
        int i4;
        int[] iArr;
        int i5;
        int i6;
        int i7;
        char cCharAt;
        int i8;
        char cCharAt2;
        int i9;
        char cCharAt3;
        int i10;
        char cCharAt4;
        int i11;
        char cCharAt5;
        int i12;
        char cCharAt6;
        int i13;
        char cCharAt7;
        int i14;
        char cCharAt8;
        int i15;
        int i16;
        int i17;
        int i18;
        int iObjectFieldOffset;
        int iObjectFieldOffset2;
        int i19;
        int i20;
        int i21;
        Field fieldZzz;
        char cCharAt9;
        int i22;
        int i23;
        int i24;
        int i25;
        Object obj;
        Field fieldZzz2;
        int i26;
        Object obj2;
        Field fieldZzz3;
        int i27;
        char cCharAt10;
        int i28;
        char cCharAt11;
        int i29;
        char cCharAt12;
        int i30;
        char cCharAt13;
        if (!(zzgyVar instanceof zzhk)) {
            throw null;
        }
        zzhk zzhkVar = (zzhk) zzgyVar;
        String strZzd = zzhkVar.zzd();
        int length = strZzd.length();
        char c = 55296;
        if (strZzd.charAt(0) >= 55296) {
            int i31 = 1;
            while (true) {
                i = i31 + 1;
                if (strZzd.charAt(i31) < 55296) {
                    break;
                }
                i31 = i;
            }
        } else {
            i = 1;
        }
        int i32 = i + 1;
        int iCharAt3 = strZzd.charAt(i);
        if (iCharAt3 >= 55296) {
            int i33 = iCharAt3 & 8191;
            int i34 = 13;
            while (true) {
                i30 = i32 + 1;
                cCharAt13 = strZzd.charAt(i32);
                if (cCharAt13 < 55296) {
                    break;
                }
                i33 |= (cCharAt13 & 8191) << i34;
                i34 += 13;
                i32 = i30;
            }
            iCharAt3 = i33 | (cCharAt13 << i34);
            i32 = i30;
        }
        if (iCharAt3 == 0) {
            i4 = 0;
            iCharAt = 0;
            iCharAt2 = 0;
            i2 = 0;
            i5 = 0;
            i3 = 0;
            iArr = zza;
            i6 = 0;
        } else {
            int i35 = i32 + 1;
            int iCharAt4 = strZzd.charAt(i32);
            if (iCharAt4 >= 55296) {
                int i36 = iCharAt4 & 8191;
                int i37 = 13;
                while (true) {
                    i14 = i35 + 1;
                    cCharAt8 = strZzd.charAt(i35);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i36 |= (cCharAt8 & 8191) << i37;
                    i37 += 13;
                    i35 = i14;
                }
                iCharAt4 = i36 | (cCharAt8 << i37);
                i35 = i14;
            }
            int i38 = i35 + 1;
            int iCharAt5 = strZzd.charAt(i35);
            if (iCharAt5 >= 55296) {
                int i39 = iCharAt5 & 8191;
                int i40 = 13;
                while (true) {
                    i13 = i38 + 1;
                    cCharAt7 = strZzd.charAt(i38);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i39 |= (cCharAt7 & 8191) << i40;
                    i40 += 13;
                    i38 = i13;
                }
                iCharAt5 = i39 | (cCharAt7 << i40);
                i38 = i13;
            }
            int i41 = i38 + 1;
            int iCharAt6 = strZzd.charAt(i38);
            if (iCharAt6 >= 55296) {
                int i42 = iCharAt6 & 8191;
                int i43 = 13;
                while (true) {
                    i12 = i41 + 1;
                    cCharAt6 = strZzd.charAt(i41);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i42 |= (cCharAt6 & 8191) << i43;
                    i43 += 13;
                    i41 = i12;
                }
                iCharAt6 = i42 | (cCharAt6 << i43);
                i41 = i12;
            }
            int i44 = i41 + 1;
            int iCharAt7 = strZzd.charAt(i41);
            if (iCharAt7 >= 55296) {
                int i45 = iCharAt7 & 8191;
                int i46 = 13;
                while (true) {
                    i11 = i44 + 1;
                    cCharAt5 = strZzd.charAt(i44);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i45 |= (cCharAt5 & 8191) << i46;
                    i46 += 13;
                    i44 = i11;
                }
                iCharAt7 = i45 | (cCharAt5 << i46);
                i44 = i11;
            }
            int i47 = i44 + 1;
            iCharAt = strZzd.charAt(i44);
            if (iCharAt >= 55296) {
                int i48 = iCharAt & 8191;
                int i49 = 13;
                while (true) {
                    i10 = i47 + 1;
                    cCharAt4 = strZzd.charAt(i47);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i48 |= (cCharAt4 & 8191) << i49;
                    i49 += 13;
                    i47 = i10;
                }
                iCharAt = i48 | (cCharAt4 << i49);
                i47 = i10;
            }
            int i50 = i47 + 1;
            iCharAt2 = strZzd.charAt(i47);
            if (iCharAt2 >= 55296) {
                int i51 = iCharAt2 & 8191;
                int i52 = 13;
                while (true) {
                    i9 = i50 + 1;
                    cCharAt3 = strZzd.charAt(i50);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i51 |= (cCharAt3 & 8191) << i52;
                    i52 += 13;
                    i50 = i9;
                }
                iCharAt2 = i51 | (cCharAt3 << i52);
                i50 = i9;
            }
            int i53 = i50 + 1;
            int iCharAt8 = strZzd.charAt(i50);
            if (iCharAt8 >= 55296) {
                int i54 = iCharAt8 & 8191;
                int i55 = 13;
                while (true) {
                    i8 = i53 + 1;
                    cCharAt2 = strZzd.charAt(i53);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i54 |= (cCharAt2 & 8191) << i55;
                    i55 += 13;
                    i53 = i8;
                }
                iCharAt8 = i54 | (cCharAt2 << i55);
                i53 = i8;
            }
            int i56 = i53 + 1;
            int iCharAt9 = strZzd.charAt(i53);
            if (iCharAt9 >= 55296) {
                int i57 = iCharAt9 & 8191;
                int i58 = 13;
                while (true) {
                    i7 = i56 + 1;
                    cCharAt = strZzd.charAt(i56);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i57 |= (cCharAt & 8191) << i58;
                    i58 += 13;
                    i56 = i7;
                }
                iCharAt9 = i57 | (cCharAt << i58);
                i56 = i7;
            }
            int i59 = iCharAt4 + iCharAt4 + iCharAt5;
            int[] iArr2 = new int[iCharAt9 + iCharAt2 + iCharAt8];
            i2 = iCharAt6;
            i3 = iCharAt9;
            i4 = i59;
            iArr = iArr2;
            i5 = iCharAt7;
            i6 = iCharAt4;
            i32 = i56;
        }
        Unsafe unsafe = zzb;
        Object[] objArrZze = zzhkVar.zze();
        Class<?> cls2 = zzhkVar.zza().getClass();
        int i60 = i3 + iCharAt2;
        int i61 = iCharAt + iCharAt;
        int[] iArr3 = new int[iCharAt * 3];
        Object[] objArr = new Object[i61];
        int i62 = i3;
        int i63 = i60;
        int i64 = 0;
        int i65 = 0;
        while (i32 < length) {
            int i66 = i32 + 1;
            int iCharAt10 = strZzd.charAt(i32);
            if (iCharAt10 >= c) {
                int i67 = iCharAt10 & 8191;
                int i68 = i66;
                int i69 = 13;
                while (true) {
                    i29 = i68 + 1;
                    cCharAt12 = strZzd.charAt(i68);
                    if (cCharAt12 < c) {
                        break;
                    }
                    i67 |= (cCharAt12 & 8191) << i69;
                    i69 += 13;
                    i68 = i29;
                }
                iCharAt10 = i67 | (cCharAt12 << i69);
                i15 = i29;
            } else {
                i15 = i66;
            }
            int i70 = i15 + 1;
            int iCharAt11 = strZzd.charAt(i15);
            if (iCharAt11 >= c) {
                int i71 = iCharAt11 & 8191;
                int i72 = i70;
                int i73 = 13;
                while (true) {
                    i28 = i72 + 1;
                    cCharAt11 = strZzd.charAt(i72);
                    if (cCharAt11 < c) {
                        break;
                    }
                    i71 |= (cCharAt11 & 8191) << i73;
                    i73 += 13;
                    i72 = i28;
                }
                iCharAt11 = i71 | (cCharAt11 << i73);
                i16 = i28;
            } else {
                i16 = i70;
            }
            if ((iCharAt11 & 1024) != 0) {
                iArr[i64] = i65;
                i64++;
            }
            int i74 = iCharAt11 & 255;
            int i75 = length;
            int i76 = iCharAt11 & 2048;
            int i77 = i5;
            if (i74 >= 51) {
                int i78 = i16 + 1;
                int iCharAt12 = strZzd.charAt(i16);
                if (iCharAt12 >= 55296) {
                    int i79 = iCharAt12 & 8191;
                    int i80 = i78;
                    int i81 = 13;
                    while (true) {
                        i27 = i80 + 1;
                        cCharAt10 = strZzd.charAt(i80);
                        i17 = i2;
                        if (cCharAt10 < 55296) {
                            break;
                        }
                        i79 |= (cCharAt10 & 8191) << i81;
                        i81 += 13;
                        i80 = i27;
                        i2 = i17;
                    }
                    iCharAt12 = i79 | (cCharAt10 << i81);
                    i23 = i27;
                } else {
                    i17 = i2;
                    i23 = i78;
                }
                int i82 = i74 - 51;
                int i83 = i23;
                if (i82 == 9 || i82 == 17) {
                    i24 = i4 + 1;
                    int i84 = i65 / 3;
                    objArr[i84 + i84 + 1] = objArrZze[i4];
                } else {
                    if (i82 == 12) {
                        if (zzhkVar.zzc() == 1 || i76 != 0) {
                            i24 = i4 + 1;
                            int i85 = i65 / 3;
                            objArr[i85 + i85 + 1] = objArrZze[i4];
                        } else {
                            i76 = 0;
                        }
                    }
                    i25 = iCharAt12 + iCharAt12;
                    obj = objArrZze[i25];
                    if (obj instanceof Field) {
                        fieldZzz2 = (Field) obj;
                    } else {
                        fieldZzz2 = zzz(cls2, (String) obj);
                        objArrZze[i25] = fieldZzz2;
                    }
                    int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzz2);
                    i26 = i25 + 1;
                    obj2 = objArrZze[i26];
                    int i86 = i76;
                    if (obj2 instanceof Field) {
                        fieldZzz3 = (Field) obj2;
                    } else {
                        fieldZzz3 = zzz(cls2, (String) obj2);
                        objArrZze[i26] = fieldZzz3;
                    }
                    int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldZzz3);
                    strZzd = strZzd;
                    i18 = i4;
                    i19 = i83;
                    iObjectFieldOffset2 = iObjectFieldOffset4;
                    i20 = 0;
                    zzhkVar = zzhkVar;
                    iObjectFieldOffset = iObjectFieldOffset3;
                    i21 = i86;
                }
                i4 = i24;
                i25 = iCharAt12 + iCharAt12;
                obj = objArrZze[i25];
                if (obj instanceof Field) {
                    fieldZzz2 = (Field) obj;
                } else {
                    fieldZzz2 = zzz(cls2, (String) obj);
                    objArrZze[i25] = fieldZzz2;
                }
                int iObjectFieldOffset5 = (int) unsafe.objectFieldOffset(fieldZzz2);
                i26 = i25 + 1;
                obj2 = objArrZze[i26];
                int i87 = i76;
                if (obj2 instanceof Field) {
                    fieldZzz3 = (Field) obj2;
                } else {
                    fieldZzz3 = zzz(cls2, (String) obj2);
                    objArrZze[i26] = fieldZzz3;
                }
                int iObjectFieldOffset6 = (int) unsafe.objectFieldOffset(fieldZzz3);
                strZzd = strZzd;
                i18 = i4;
                i19 = i83;
                iObjectFieldOffset2 = iObjectFieldOffset6;
                i20 = 0;
                zzhkVar = zzhkVar;
                iObjectFieldOffset = iObjectFieldOffset5;
                i21 = i87;
            } else {
                i17 = i2;
                i18 = i4 + 1;
                Field fieldZzz4 = zzz(cls2, (String) objArrZze[i4]);
                if (i74 == 9 || i74 == 17) {
                    zzhkVar = zzhkVar;
                    int i88 = i65 / 3;
                    objArr[i88 + i88 + 1] = fieldZzz4.getType();
                } else {
                    if (i74 == 27 || i74 == 49) {
                        i22 = i18 + 1;
                        int i89 = i65 / 3;
                        objArr[i89 + i89 + 1] = objArrZze[i18];
                        i18 = i22;
                    } else if (i74 == 12 || i74 == 30 || i74 == 44) {
                        zzhkVar = zzhkVar;
                        if (zzhkVar.zzc() == 1 || i76 != 0) {
                            i22 = i18 + 1;
                            int i90 = i65 / 3;
                            objArr[i90 + i90 + 1] = objArrZze[i18];
                            i18 = i22;
                        } else {
                            i76 = 0;
                        }
                    } else if (i74 == 50) {
                        int i91 = i18 + 1;
                        int i92 = i62 + 1;
                        iArr[i62] = i65;
                        int i93 = i65 / 3;
                        int i94 = i93 + i93;
                        objArr[i94] = objArrZze[i18];
                        if (i76 != 0) {
                            i18 = i91 + 1;
                            objArr[i94 + 1] = objArrZze[i91];
                            i62 = i92;
                            zzhkVar = zzhkVar;
                        } else {
                            i18 = i91;
                            i62 = i92;
                            i76 = 0;
                            zzhkVar = zzhkVar;
                        }
                    } else {
                        zzhkVar = zzhkVar;
                    }
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzz4);
                    iObjectFieldOffset2 = 1048575;
                    if ((iCharAt11 & 4096) != 0 || i74 > 17) {
                        i19 = i16;
                        i20 = 0;
                    } else {
                        int i95 = i16 + 1;
                        int iCharAt13 = strZzd.charAt(i16);
                        if (iCharAt13 >= 55296) {
                            int i96 = iCharAt13 & 8191;
                            int i97 = 13;
                            while (true) {
                                i19 = i95 + 1;
                                cCharAt9 = strZzd.charAt(i95);
                                if (cCharAt9 < 55296) {
                                    break;
                                }
                                i96 |= (cCharAt9 & 8191) << i97;
                                i97 += 13;
                                i95 = i19;
                            }
                            iCharAt13 = i96 | (cCharAt9 << i97);
                        } else {
                            i19 = i95;
                        }
                        int i98 = i6 + i6 + (iCharAt13 / 32);
                        Object obj3 = objArrZze[i98];
                        if (obj3 instanceof Field) {
                            fieldZzz = (Field) obj3;
                        } else {
                            fieldZzz = zzz(cls2, (String) obj3);
                            objArrZze[i98] = fieldZzz;
                        }
                        i20 = iCharAt13 % 32;
                        iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzz);
                    }
                    if (i74 >= 18 && i74 <= 49) {
                        iArr[i63] = iObjectFieldOffset;
                        i63++;
                    }
                    i21 = i76;
                }
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzz4);
                iObjectFieldOffset2 = 1048575;
                if ((iCharAt11 & 4096) != 0) {
                    i19 = i16;
                    i20 = 0;
                } else {
                    i19 = i16;
                    i20 = 0;
                }
                if (i74 >= 18) {
                    iArr[i63] = iObjectFieldOffset;
                    i63++;
                }
                i21 = i76;
            }
            int i99 = i65 + 1;
            iArr3[i65] = iCharAt10;
            int i100 = i99 + 1;
            iArr3[i99] = iObjectFieldOffset | ((iCharAt11 & 512) != 0 ? C.ENCODING_PCM_A_LAW : 0) | ((iCharAt11 & 256) != 0 ? C.ENCODING_PCM_MU_LAW : 0) | (i21 != 0 ? Integer.MIN_VALUE : 0) | (i74 << 20);
            iArr3[i100] = (i20 << 20) | iObjectFieldOffset2;
            i65 = i100 + 1;
            i4 = i18;
            strZzd = strZzd;
            length = i75;
            i5 = i77;
            zzhkVar = zzhkVar;
            i32 = i19;
            i2 = i17;
            c = 55296;
        }
        return new zzhe(iArr3, objArr, i2, i5, zzhkVar.zza(), false, iArr, i3, i60, zzhgVar, zzgkVar, zzibVar, zzfiVar, zzgwVar);
    }

    private static double zzm(Object obj, long j) {
        return ((Double) zzii.zzf(obj, j)).doubleValue();
    }

    private static float zzn(Object obj, long j) {
        return ((Float) zzii.zzf(obj, j)).floatValue();
    }

    private static int zzo(Object obj, long j) {
        return ((Integer) zzii.zzf(obj, j)).intValue();
    }

    private final int zzp(int i) {
        return this.zzc[i + 2];
    }

    private final int zzq(int i, int i2) {
        int[] iArr = this.zzc;
        int length = (iArr.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = iArr[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private static int zzr(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzs(int i) {
        return this.zzc[i + 1];
    }

    private static long zzt(Object obj, long j) {
        return ((Long) zzii.zzf(obj, j)).longValue();
    }

    private final zzfx zzu(int i) {
        int i2 = i / 3;
        return (zzfx) this.zzd[i2 + i2 + 1];
    }

    private final zzhl zzv(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzhl zzhlVar = (zzhl) objArr[i3];
        if (zzhlVar != null) {
            return zzhlVar;
        }
        zzhl zzhlVarZzb = zzhi.zza().zzb((Class) objArr[i3 + 1]);
        objArr[i3] = zzhlVarZzb;
        return zzhlVarZzb;
    }

    private final Object zzw(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final Object zzx(Object obj, int i) {
        zzhl zzhlVarZzv = zzv(i);
        int iZzs = zzs(i) & 1048575;
        if (!zzI(obj, i)) {
            return zzhlVarZzv.zze();
        }
        Object object = zzb.getObject(obj, iZzs);
        if (zzL(object)) {
            return object;
        }
        Object objZze = zzhlVarZzv.zze();
        if (object != null) {
            zzhlVarZzv.zzg(objZze, object);
        }
        return objZze;
    }

    private final Object zzy(Object obj, int i, int i2) {
        zzhl zzhlVarZzv = zzv(i2);
        if (!zzM(obj, i, i2)) {
            return zzhlVarZzv.zze();
        }
        Object object = zzb.getObject(obj, zzs(i2) & 1048575);
        if (zzL(object)) {
            return object;
        }
        Object objZze = zzhlVarZzv.zze();
        if (object != null) {
            zzhlVarZzv.zzg(objZze, object);
        }
        return objZze;
    }

    private static Field zzz(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields), e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:137:0x0396  */
    /* JADX WARN: Code duplicated, block: B:207:0x0560  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v115, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v118, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v120, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v137 */
    /* JADX WARN: Type inference failed for: r0v185, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v253, types: [int] */
    /* JADX WARN: Type inference failed for: r0v261 */
    /* JADX WARN: Type inference failed for: r0v263 */
    /* JADX WARN: Type inference failed for: r0v264 */
    /* JADX WARN: Type inference failed for: r0v265 */
    /* JADX WARN: Type inference failed for: r0v266 */
    /* JADX WARN: Type inference failed for: r0v267 */
    /* JADX WARN: Type inference failed for: r0v268 */
    /* JADX WARN: Type inference failed for: r0v269 */
    /* JADX WARN: Type inference failed for: r0v270 */
    /* JADX WARN: Type inference failed for: r0v271 */
    /* JADX WARN: Type inference failed for: r0v272 */
    /* JADX WARN: Type inference failed for: r0v273 */
    /* JADX WARN: Type inference failed for: r0v274 */
    /* JADX WARN: Type inference failed for: r0v275 */
    /* JADX WARN: Type inference failed for: r0v276 */
    /* JADX WARN: Type inference failed for: r0v277 */
    /* JADX WARN: Type inference failed for: r0v278 */
    /* JADX WARN: Type inference failed for: r0v279 */
    /* JADX WARN: Type inference failed for: r0v280 */
    /* JADX WARN: Type inference failed for: r12v4, types: [int] */
    /* JADX WARN: Type inference failed for: r12v5, types: [int] */
    /* JADX WARN: Type inference failed for: r12v6, types: [int] */
    /* JADX WARN: Type inference failed for: r12v7, types: [int] */
    /* JADX WARN: Type inference failed for: r12v9, types: [int] */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v118, types: [int] */
    /* JADX WARN: Type inference failed for: r1v121, types: [int] */
    /* JADX WARN: Type inference failed for: r1v158 */
    /* JADX WARN: Type inference failed for: r1v161 */
    /* JADX WARN: Type inference failed for: r1v162 */
    /* JADX WARN: Type inference failed for: r1v164 */
    /* JADX WARN: Type inference failed for: r1v165 */
    /* JADX WARN: Type inference failed for: r1v166 */
    /* JADX WARN: Type inference failed for: r1v78, types: [int] */
    /* JADX WARN: Type inference failed for: r1v80 */
    /* JADX WARN: Type inference failed for: r2v32, types: [int] */
    /* JADX WARN: Type inference failed for: r2v40, types: [int] */
    /* JADX WARN: Type inference failed for: r2v42, types: [int] */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r2v49, types: [int] */
    /* JADX WARN: Type inference failed for: r2v77 */
    /* JADX WARN: Type inference failed for: r2v78, types: [int] */
    /* JADX WARN: Type inference failed for: r2v80 */
    /* JADX WARN: Type inference failed for: r2v81, types: [int] */
    /* JADX WARN: Type inference failed for: r2v92 */
    /* JADX WARN: Type inference failed for: r2v93 */
    /* JADX WARN: Type inference failed for: r2v94 */
    /* JADX WARN: Type inference failed for: r2v95 */
    /* JADX WARN: Type inference failed for: r2v96 */
    /* JADX WARN: Type inference failed for: r2v97 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28, types: [int] */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v31, types: [int] */
    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v38, types: [int] */
    /* JADX WARN: Type inference failed for: r3v39 */
    /* JADX WARN: Type inference failed for: r3v45, types: [int] */
    /* JADX WARN: Type inference failed for: r3v54 */
    /* JADX WARN: Type inference failed for: r3v55 */
    /* JADX WARN: Type inference failed for: r3v56 */
    /* JADX WARN: Type inference failed for: r3v57 */
    /* JADX WARN: Type inference failed for: r3v58 */
    /* JADX WARN: Type inference failed for: r3v59 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v32, types: [int] */
    /* JADX WARN: Type inference failed for: r4v36 */
    /* JADX WARN: Type inference failed for: r4v37 */
    /* JADX WARN: Type inference failed for: r4v39, types: [int] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v40 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v61 */
    /* JADX WARN: Type inference failed for: r4v62 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v3, types: [int] */
    @Override // com.google.android.gms.internal.play_billing.zzhl
    public final int zza(Object obj) {
        int i;
        ?? r16;
        ?? r5;
        int iZzy;
        int iZzy2;
        int iZzy3;
        int iZzz;
        int iZzy4;
        int iZzy5;
        int iZzb;
        int iZzy6;
        ?? Zzh;
        int size;
        int iZzy7;
        int iZzb2;
        int iZzy8;
        int iZzb3;
        int iZzy9;
        ?? r3;
        int iZzi;
        int iZzy10;
        ?? Zzy;
        ?? Zzi;
        int iZzf;
        int iZzy11;
        int iZzy12;
        ?? r4;
        ?? r6;
        ?? r1;
        Unsafe unsafe = zzb;
        boolean z = false;
        int i2 = 1048575;
        ?? r2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1048575;
        while (true) {
            int[] iArr = this.zzc;
            if (i3 >= iArr.length) {
                int iZza = i4 + ((zzfu) obj).zzc.zza();
                if (!this.zzh) {
                    return iZza;
                }
                zzht zzhtVar = ((zzfr) obj).zzb.zza;
                int iZzc = zzhtVar.zzc();
                int iZzc2 = 0;
                for (int i6 = 0; i6 < iZzc; i6++) {
                    Map.Entry entryZzg = zzhtVar.zzg(i6);
                    iZzc2 += zzfm.zzc((zzfl) ((zzhp) entryZzg).zza(), entryZzg.getValue());
                }
                for (Map.Entry entry : zzhtVar.zzd()) {
                    iZzc2 += zzfm.zzc((zzfl) entry.getKey(), entry.getValue());
                }
                return iZza + iZzc2;
            }
            int iZzs = zzs(i3);
            int iZzr = zzr(iZzs);
            int i7 = iArr[i3];
            int i8 = iArr[i3 + 2];
            int i9 = i8 & i2;
            if (iZzr <= 17) {
                if (i9 != i5) {
                    r1 = i9 == i2 ? z : unsafe.getInt(obj, i9);
                    i5 = i9;
                }
                i = i5;
                r16 = r1;
                r5 = 1 << (i8 >>> 20);
            } else {
                r1 = r2;
                i = i5;
                r16 = r2 == true ? 1 : 0;
                r5 = z;
            }
            int i10 = iZzs & i2;
            if (iZzr >= zzfn.DOUBLE_LIST_PACKED.zza()) {
                zzfn.SINT64_LIST_PACKED.zza();
            }
            long j = i10;
            switch (iZzr) {
                case 0:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzy = zzfc.zzy(i7 << 3);
                        Zzi = iZzy + 8;
                        i4 += Zzi;
                    }
                    break;
                case 1:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzy2 = zzfc.zzy(i7 << 3);
                        Zzi = iZzy2 + 4;
                        i4 += Zzi;
                    }
                    break;
                case 2:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        long j2 = unsafe.getLong(obj, j);
                        iZzy3 = zzfc.zzy(i7 << 3);
                        iZzz = zzfc.zzz(j2);
                        Zzi = iZzy3 + iZzz;
                        i4 += Zzi;
                    }
                    break;
                case 3:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        long j3 = unsafe.getLong(obj, j);
                        iZzy3 = zzfc.zzy(i7 << 3);
                        iZzz = zzfc.zzz(j3);
                        Zzi = iZzy3 + iZzz;
                        i4 += Zzi;
                    }
                    break;
                case 4:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        long j4 = unsafe.getInt(obj, j);
                        iZzy3 = zzfc.zzy(i7 << 3);
                        iZzz = zzfc.zzz(j4);
                        Zzi = iZzy3 + iZzz;
                        i4 += Zzi;
                    }
                    break;
                case 5:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzy = zzfc.zzy(i7 << 3);
                        Zzi = iZzy + 8;
                        i4 += Zzi;
                    }
                    break;
                case 6:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzy2 = zzfc.zzy(i7 << 3);
                        Zzi = iZzy2 + 4;
                        i4 += Zzi;
                    }
                    break;
                case 7:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzy4 = zzfc.zzy(i7 << 3);
                        Zzi = iZzy4 + 1;
                        i4 += Zzi;
                    }
                    break;
                case 8:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        int i11 = i7 << 3;
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof zzev) {
                            iZzy5 = zzfc.zzy(i11);
                            iZzb = ((zzev) object).zze();
                            iZzy6 = zzfc.zzy(iZzb);
                        } else {
                            iZzy5 = zzfc.zzy(i11);
                            iZzb = zzin.zzb((String) object);
                            iZzy6 = zzfc.zzy(iZzb);
                        }
                        Zzi = iZzy5 + iZzy6 + iZzb;
                        i4 += Zzi;
                    }
                    break;
                case 9:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        Zzi = zzhn.zzi(i7, unsafe.getObject(obj, j), zzv(i3));
                        i4 += Zzi;
                    }
                    break;
                case 10:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        zzev zzevVar = (zzev) unsafe.getObject(obj, j);
                        iZzy5 = zzfc.zzy(i7 << 3);
                        iZzb = zzevVar.zze();
                        iZzy6 = zzfc.zzy(iZzb);
                        Zzi = iZzy5 + iZzy6 + iZzb;
                        i4 += Zzi;
                    }
                    break;
                case 11:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        int i12 = unsafe.getInt(obj, j);
                        iZzy3 = zzfc.zzy(i7 << 3);
                        iZzz = zzfc.zzy(i12);
                        Zzi = iZzy3 + iZzz;
                        i4 += Zzi;
                    }
                    break;
                case 12:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        long j5 = unsafe.getInt(obj, j);
                        iZzy3 = zzfc.zzy(i7 << 3);
                        iZzz = zzfc.zzz(j5);
                        Zzi = iZzy3 + iZzz;
                        i4 += Zzi;
                    }
                    break;
                case 13:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzy2 = zzfc.zzy(i7 << 3);
                        Zzi = iZzy2 + 4;
                        i4 += Zzi;
                    }
                    break;
                case 14:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzy = zzfc.zzy(i7 << 3);
                        Zzi = iZzy + 8;
                        i4 += Zzi;
                    }
                    break;
                case 15:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        int i13 = unsafe.getInt(obj, j);
                        iZzy3 = zzfc.zzy(i7 << 3);
                        iZzz = zzfc.zzy((i13 >> 31) ^ (i13 + i13));
                        Zzi = iZzy3 + iZzz;
                        i4 += Zzi;
                    }
                    break;
                case 16:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        long j6 = unsafe.getLong(obj, j);
                        iZzy3 = zzfc.zzy(i7 << 3);
                        iZzz = zzfc.zzz((j6 >> 63) ^ (j6 + j6));
                        Zzi = iZzy3 + iZzz;
                        i4 += Zzi;
                    }
                    break;
                case 17:
                    if (zzJ(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        Zzi = zzhn.zza(i7, (zzhb) unsafe.getObject(obj, j), zzv(i3));
                        i4 += Zzi;
                    }
                    break;
                case 18:
                    Zzi = zzhn.zze(i7, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzi;
                    break;
                case 19:
                    Zzi = zzhn.zzc(i7, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzi;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(obj, j);
                    int i14 = zzhn.zza;
                    if (list.size() == 0) {
                        Zzh = z;
                    } else {
                        Zzh = zzhn.zzh(list) + (list.size() * zzfc.zzy(i7 << 3));
                    }
                    i4 += Zzh;
                    break;
                case 21:
                    List list2 = (List) unsafe.getObject(obj, j);
                    int i15 = zzhn.zza;
                    size = list2.size();
                    if (size == 0) {
                        Zzi = z;
                    } else {
                        iZzy3 = zzhn.zzm(list2);
                        iZzy7 = zzfc.zzy(i7 << 3);
                        iZzz = size * iZzy7;
                        Zzi = iZzy3 + iZzz;
                    }
                    i4 += Zzi;
                    break;
                case 22:
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i16 = zzhn.zza;
                    size = list3.size();
                    if (size == 0) {
                        Zzi = z;
                    } else {
                        iZzy3 = zzhn.zzg(list3);
                        iZzy7 = zzfc.zzy(i7 << 3);
                        iZzz = size * iZzy7;
                        Zzi = iZzy3 + iZzz;
                    }
                    i4 += Zzi;
                    break;
                case 23:
                    Zzi = zzhn.zze(i7, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzi;
                    break;
                case 24:
                    Zzi = zzhn.zzc(i7, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzi;
                    break;
                case 25:
                    List list4 = (List) unsafe.getObject(obj, j);
                    int i17 = zzhn.zza;
                    int size2 = list4.size();
                    if (size2 == 0) {
                        Zzi = z;
                    } else {
                        Zzi = size2 * (zzfc.zzy(i7 << 3) + 1);
                    }
                    i4 += Zzi;
                    break;
                case 26:
                    ?? r0 = (List) unsafe.getObject(obj, j);
                    int i18 = zzhn.zza;
                    int size3 = r0.size();
                    if (size3 == 0) {
                        Zzh = z;
                    } else {
                        int iZzy13 = zzfc.zzy(i7 << 3) * size3;
                        if (r0 instanceof zzgj) {
                            zzgj zzgjVar = (zzgj) r0;
                            for (?? r7 = z; r7 < size3; r7++) {
                                Object objZza = zzgjVar.zza();
                                if (objZza instanceof zzev) {
                                    Zzh = iZzy13;
                                    iZzb3 = ((zzev) objZza).zze();
                                    iZzy9 = zzfc.zzy(iZzb3);
                                } else {
                                    Zzh = iZzy13;
                                    iZzb3 = zzin.zzb((String) objZza);
                                    iZzy9 = zzfc.zzy(iZzb3);
                                }
                                Zzh += iZzy9 + iZzb3;
                            }
                            Zzh = iZzy13;
                        } else {
                            for (?? r8 = z; r8 < size3; r8++) {
                                Object obj2 = r0.get(r8);
                                if (obj2 instanceof zzev) {
                                    Zzh = iZzy13;
                                    iZzb2 = ((zzev) obj2).zze();
                                    iZzy8 = zzfc.zzy(iZzb2);
                                } else {
                                    Zzh = iZzy13;
                                    iZzb2 = zzin.zzb((String) obj2);
                                    iZzy8 = zzfc.zzy(iZzb2);
                                }
                                Zzh += iZzy8 + iZzb2;
                            }
                            Zzh = iZzy13;
                        }
                    }
                    i4 += Zzh;
                    break;
                case 27:
                    ?? r9 = (List) unsafe.getObject(obj, j);
                    zzhl zzhlVarZzv = zzv(i3);
                    int i19 = zzhn.zza;
                    int size4 = r9.size();
                    if (size4 == 0) {
                        r3 = z;
                    } else {
                        int iZzy14 = zzfc.zzy(i7 << 3) * size4;
                        for (?? r10 = z; r10 < size4; r10++) {
                            Object obj3 = r9.get(r10);
                            if (obj3 instanceof zzgi) {
                                r3 = iZzy14;
                                iZzi = ((zzgi) obj3).zza();
                                iZzy10 = zzfc.zzy(iZzi);
                            } else {
                                r3 = iZzy14;
                                iZzi = ((zzeg) obj3).zzi(zzhlVarZzv);
                                iZzy10 = zzfc.zzy(iZzi);
                            }
                            r3 = (r3 == true ? 1 : 0) + iZzy10 + iZzi;
                        }
                        r3 = iZzy14;
                    }
                    i4 += r3;
                    break;
                case 28:
                    ?? r11 = (List) unsafe.getObject(obj, j);
                    int i20 = zzhn.zza;
                    int size5 = r11.size();
                    if (size5 == 0) {
                        Zzy = z;
                    } else {
                        Zzy = size5 * zzfc.zzy(i7 << 3);
                        for (?? r12 = z; r12 < r11.size(); r12++) {
                            int iZze = ((zzev) r11.get(r12)).zze();
                            Zzy += zzfc.zzy(iZze) + iZze;
                        }
                    }
                    i4 += Zzy;
                    break;
                case 29:
                    List list5 = (List) unsafe.getObject(obj, j);
                    int i21 = zzhn.zza;
                    size = list5.size();
                    if (size == 0) {
                        Zzi = z;
                    } else {
                        iZzy3 = zzhn.zzl(list5);
                        iZzy7 = zzfc.zzy(i7 << 3);
                        iZzz = size * iZzy7;
                        Zzi = iZzy3 + iZzz;
                    }
                    i4 += Zzi;
                    break;
                case 30:
                    List list6 = (List) unsafe.getObject(obj, j);
                    int i22 = zzhn.zza;
                    size = list6.size();
                    if (size == 0) {
                        Zzi = z;
                    } else {
                        iZzy3 = zzhn.zzb(list6);
                        iZzy7 = zzfc.zzy(i7 << 3);
                        iZzz = size * iZzy7;
                        Zzi = iZzy3 + iZzz;
                    }
                    i4 += Zzi;
                    break;
                case 31:
                    Zzi = zzhn.zzc(i7, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzi;
                    break;
                case 32:
                    Zzi = zzhn.zze(i7, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzi;
                    break;
                case 33:
                    List list7 = (List) unsafe.getObject(obj, j);
                    int i23 = zzhn.zza;
                    size = list7.size();
                    if (size == 0) {
                        Zzi = z;
                    } else {
                        iZzy3 = zzhn.zzj(list7);
                        iZzy7 = zzfc.zzy(i7 << 3);
                        iZzz = size * iZzy7;
                        Zzi = iZzy3 + iZzz;
                    }
                    i4 += Zzi;
                    break;
                case 34:
                    List list8 = (List) unsafe.getObject(obj, j);
                    int i24 = zzhn.zza;
                    size = list8.size();
                    if (size == 0) {
                        Zzi = z;
                    } else {
                        iZzy3 = zzhn.zzk(list8);
                        iZzy7 = zzfc.zzy(i7 << 3);
                        iZzz = size * iZzy7;
                        Zzi = iZzy3 + iZzz;
                    }
                    i4 += Zzi;
                    break;
                case 35:
                    iZzf = zzhn.zzf((List) unsafe.getObject(obj, j));
                    if (iZzf > 0) {
                        iZzy11 = zzfc.zzy(i7 << 3);
                        iZzy12 = zzfc.zzy(iZzf);
                        Zzy = iZzy11 + iZzy12 + iZzf;
                        i4 += Zzy;
                    }
                    break;
                case 36:
                    iZzf = zzhn.zzd((List) unsafe.getObject(obj, j));
                    if (iZzf > 0) {
                        iZzy11 = zzfc.zzy(i7 << 3);
                        iZzy12 = zzfc.zzy(iZzf);
                        Zzy = iZzy11 + iZzy12 + iZzf;
                        i4 += Zzy;
                    }
                    break;
                case 37:
                    iZzf = zzhn.zzh((List) unsafe.getObject(obj, j));
                    if (iZzf > 0) {
                        iZzy11 = zzfc.zzy(i7 << 3);
                        iZzy12 = zzfc.zzy(iZzf);
                        Zzy = iZzy11 + iZzy12 + iZzf;
                        i4 += Zzy;
                    }
                    break;
                case 38:
                    iZzf = zzhn.zzm((List) unsafe.getObject(obj, j));
                    if (iZzf > 0) {
                        iZzy11 = zzfc.zzy(i7 << 3);
                        iZzy12 = zzfc.zzy(iZzf);
                        Zzy = iZzy11 + iZzy12 + iZzf;
                        i4 += Zzy;
                    }
                    break;
                case 39:
                    iZzf = zzhn.zzg((List) unsafe.getObject(obj, j));
                    if (iZzf > 0) {
                        iZzy11 = zzfc.zzy(i7 << 3);
                        iZzy12 = zzfc.zzy(iZzf);
                        Zzy = iZzy11 + iZzy12 + iZzf;
                        i4 += Zzy;
                    }
                    break;
                case 40:
                    iZzf = zzhn.zzf((List) unsafe.getObject(obj, j));
                    if (iZzf > 0) {
                        iZzy11 = zzfc.zzy(i7 << 3);
                        iZzy12 = zzfc.zzy(iZzf);
                        Zzy = iZzy11 + iZzy12 + iZzf;
                        i4 += Zzy;
                    }
                    break;
                case 41:
                    iZzf = zzhn.zzd((List) unsafe.getObject(obj, j));
                    if (iZzf > 0) {
                        iZzy11 = zzfc.zzy(i7 << 3);
                        iZzy12 = zzfc.zzy(iZzf);
                        Zzy = iZzy11 + iZzy12 + iZzf;
                        i4 += Zzy;
                    }
                    break;
                case 42:
                    List list9 = (List) unsafe.getObject(obj, j);
                    int i25 = zzhn.zza;
                    iZzf = list9.size();
                    if (iZzf > 0) {
                        iZzy11 = zzfc.zzy(i7 << 3);
                        iZzy12 = zzfc.zzy(iZzf);
                        Zzy = iZzy11 + iZzy12 + iZzf;
                        i4 += Zzy;
                    }
                    break;
                case 43:
                    iZzf = zzhn.zzl((List) unsafe.getObject(obj, j));
                    if (iZzf > 0) {
                        iZzy11 = zzfc.zzy(i7 << 3);
                        iZzy12 = zzfc.zzy(iZzf);
                        Zzy = iZzy11 + iZzy12 + iZzf;
                        i4 += Zzy;
                    }
                    break;
                case 44:
                    iZzf = zzhn.zzb((List) unsafe.getObject(obj, j));
                    if (iZzf > 0) {
                        iZzy11 = zzfc.zzy(i7 << 3);
                        iZzy12 = zzfc.zzy(iZzf);
                        Zzy = iZzy11 + iZzy12 + iZzf;
                        i4 += Zzy;
                    }
                    break;
                case 45:
                    iZzf = zzhn.zzd((List) unsafe.getObject(obj, j));
                    if (iZzf > 0) {
                        iZzy11 = zzfc.zzy(i7 << 3);
                        iZzy12 = zzfc.zzy(iZzf);
                        Zzy = iZzy11 + iZzy12 + iZzf;
                        i4 += Zzy;
                    }
                    break;
                case 46:
                    iZzf = zzhn.zzf((List) unsafe.getObject(obj, j));
                    if (iZzf > 0) {
                        iZzy11 = zzfc.zzy(i7 << 3);
                        iZzy12 = zzfc.zzy(iZzf);
                        Zzy = iZzy11 + iZzy12 + iZzf;
                        i4 += Zzy;
                    }
                    break;
                case 47:
                    iZzf = zzhn.zzj((List) unsafe.getObject(obj, j));
                    if (iZzf > 0) {
                        iZzy11 = zzfc.zzy(i7 << 3);
                        iZzy12 = zzfc.zzy(iZzf);
                        Zzy = iZzy11 + iZzy12 + iZzf;
                        i4 += Zzy;
                    }
                    break;
                case 48:
                    iZzf = zzhn.zzk((List) unsafe.getObject(obj, j));
                    if (iZzf > 0) {
                        iZzy11 = zzfc.zzy(i7 << 3);
                        iZzy12 = zzfc.zzy(iZzf);
                        Zzy = iZzy11 + iZzy12 + iZzf;
                        i4 += Zzy;
                    }
                    break;
                case 49:
                    ?? r13 = (List) unsafe.getObject(obj, j);
                    zzhl zzhlVarZzv2 = zzv(i3);
                    int i26 = zzhn.zza;
                    int size6 = r13.size();
                    if (size6 == 0) {
                        r4 = z;
                    } else {
                        boolean z2 = z;
                        r4 = z2;
                        while (r6 < size6) {
                            r6 = z2;
                            int iZza2 = zzhn.zza(i7, (zzhb) r13.get(r6), zzhlVarZzv2);
                            r6++;
                            r4 = (r4 == true ? 1 : 0) + iZza2;
                        }
                        r6 = z2;
                    }
                    i4 += r4;
                    break;
                case 50:
                    zzgv zzgvVar = (zzgv) unsafe.getObject(obj, j);
                    zzgu zzguVar = (zzgu) zzw(i3);
                    if (zzgvVar.isEmpty()) {
                        Zzh = z;
                    } else {
                        Zzh = z;
                        for (Map.Entry entry2 : zzgvVar.entrySet()) {
                            Zzh += zzguVar.zza(i7, entry2.getKey(), entry2.getValue());
                        }
                    }
                    i4 += Zzh;
                    break;
                case 51:
                    if (zzM(obj, i7, i3)) {
                        iZzy = zzfc.zzy(i7 << 3);
                        Zzi = iZzy + 8;
                        i4 += Zzi;
                    }
                    break;
                case 52:
                    if (zzM(obj, i7, i3)) {
                        iZzy2 = zzfc.zzy(i7 << 3);
                        Zzi = iZzy2 + 4;
                        i4 += Zzi;
                    }
                    break;
                case 53:
                    if (zzM(obj, i7, i3)) {
                        long jZzt = zzt(obj, j);
                        iZzy3 = zzfc.zzy(i7 << 3);
                        iZzz = zzfc.zzz(jZzt);
                        Zzi = iZzy3 + iZzz;
                        i4 += Zzi;
                    }
                    break;
                case 54:
                    if (zzM(obj, i7, i3)) {
                        long jZzt2 = zzt(obj, j);
                        iZzy3 = zzfc.zzy(i7 << 3);
                        iZzz = zzfc.zzz(jZzt2);
                        Zzi = iZzy3 + iZzz;
                        i4 += Zzi;
                    }
                    break;
                case 55:
                    if (zzM(obj, i7, i3)) {
                        long jZzo = zzo(obj, j);
                        iZzy3 = zzfc.zzy(i7 << 3);
                        iZzz = zzfc.zzz(jZzo);
                        Zzi = iZzy3 + iZzz;
                        i4 += Zzi;
                    }
                    break;
                case 56:
                    if (zzM(obj, i7, i3)) {
                        iZzy = zzfc.zzy(i7 << 3);
                        Zzi = iZzy + 8;
                        i4 += Zzi;
                    }
                    break;
                case 57:
                    if (zzM(obj, i7, i3)) {
                        iZzy2 = zzfc.zzy(i7 << 3);
                        Zzi = iZzy2 + 4;
                        i4 += Zzi;
                    }
                    break;
                case 58:
                    if (zzM(obj, i7, i3)) {
                        iZzy4 = zzfc.zzy(i7 << 3);
                        Zzi = iZzy4 + 1;
                        i4 += Zzi;
                    }
                    break;
                case 59:
                    if (zzM(obj, i7, i3)) {
                        int i27 = i7 << 3;
                        Object object2 = unsafe.getObject(obj, j);
                        if (object2 instanceof zzev) {
                            iZzy5 = zzfc.zzy(i27);
                            iZzb = ((zzev) object2).zze();
                            iZzy6 = zzfc.zzy(iZzb);
                        } else {
                            iZzy5 = zzfc.zzy(i27);
                            iZzb = zzin.zzb((String) object2);
                            iZzy6 = zzfc.zzy(iZzb);
                        }
                        Zzi = iZzy5 + iZzy6 + iZzb;
                        i4 += Zzi;
                    }
                    break;
                case 60:
                    if (zzM(obj, i7, i3)) {
                        Zzi = zzhn.zzi(i7, unsafe.getObject(obj, j), zzv(i3));
                        i4 += Zzi;
                    }
                    break;
                case 61:
                    if (zzM(obj, i7, i3)) {
                        zzev zzevVar2 = (zzev) unsafe.getObject(obj, j);
                        iZzy5 = zzfc.zzy(i7 << 3);
                        iZzb = zzevVar2.zze();
                        iZzy6 = zzfc.zzy(iZzb);
                        Zzi = iZzy5 + iZzy6 + iZzb;
                        i4 += Zzi;
                    }
                    break;
                case 62:
                    if (zzM(obj, i7, i3)) {
                        int iZzo = zzo(obj, j);
                        iZzy3 = zzfc.zzy(i7 << 3);
                        iZzz = zzfc.zzy(iZzo);
                        Zzi = iZzy3 + iZzz;
                        i4 += Zzi;
                    }
                    break;
                case 63:
                    if (zzM(obj, i7, i3)) {
                        long jZzo2 = zzo(obj, j);
                        iZzy3 = zzfc.zzy(i7 << 3);
                        iZzz = zzfc.zzz(jZzo2);
                        Zzi = iZzy3 + iZzz;
                        i4 += Zzi;
                    }
                    break;
                case 64:
                    if (zzM(obj, i7, i3)) {
                        iZzy2 = zzfc.zzy(i7 << 3);
                        Zzi = iZzy2 + 4;
                        i4 += Zzi;
                    }
                    break;
                case 65:
                    if (zzM(obj, i7, i3)) {
                        iZzy = zzfc.zzy(i7 << 3);
                        Zzi = iZzy + 8;
                        i4 += Zzi;
                    }
                    break;
                case 66:
                    if (zzM(obj, i7, i3)) {
                        int iZzo2 = zzo(obj, j);
                        iZzy3 = zzfc.zzy(i7 << 3);
                        iZzz = zzfc.zzy((iZzo2 >> 31) ^ (iZzo2 + iZzo2));
                        Zzi = iZzy3 + iZzz;
                        i4 += Zzi;
                    }
                    break;
                case 67:
                    if (zzM(obj, i7, i3)) {
                        long jZzt3 = zzt(obj, j);
                        iZzy3 = zzfc.zzy(i7 << 3);
                        iZzz = zzfc.zzz((jZzt3 >> 63) ^ (jZzt3 + jZzt3));
                        Zzi = iZzy3 + iZzz;
                        i4 += Zzi;
                    }
                    break;
                case 68:
                    if (zzM(obj, i7, i3)) {
                        Zzi = zzhn.zza(i7, (zzhb) unsafe.getObject(obj, j), zzv(i3));
                        i4 += Zzi;
                    }
                    break;
            }
            i3 += 3;
            i5 = i;
            r2 = r16;
            z = false;
            i2 = 1048575;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhl
    public final int zzb(Object obj) {
        int i;
        long jDoubleToLongBits;
        int iFloatToIntBits;
        int i2;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i3 >= iArr.length) {
                int iHashCode = (i4 * 53) + ((zzfu) obj).zzc.hashCode();
                return this.zzh ? (iHashCode * 53) + ((zzfr) obj).zzb.zza.hashCode() : iHashCode;
            }
            int iZzs = zzs(i3);
            int i5 = 1048575 & iZzs;
            int iZzr = zzr(iZzs);
            int i6 = iArr[i3];
            long j = i5;
            int iHashCode2 = 37;
            switch (iZzr) {
                case 0:
                    i = i4 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzii.zza(obj, j));
                    byte[] bArr = zzga.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 1:
                    i = i4 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzii.zzb(obj, j));
                    i4 = i + iFloatToIntBits;
                    break;
                case 2:
                    i = i4 * 53;
                    jDoubleToLongBits = zzii.zzd(obj, j);
                    byte[] bArr2 = zzga.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 3:
                    i = i4 * 53;
                    jDoubleToLongBits = zzii.zzd(obj, j);
                    byte[] bArr3 = zzga.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 4:
                    i = i4 * 53;
                    iFloatToIntBits = zzii.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 5:
                    i = i4 * 53;
                    jDoubleToLongBits = zzii.zzd(obj, j);
                    byte[] bArr4 = zzga.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 6:
                    i = i4 * 53;
                    iFloatToIntBits = zzii.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 7:
                    i = i4 * 53;
                    iFloatToIntBits = zzga.zza(zzii.zzw(obj, j));
                    i4 = i + iFloatToIntBits;
                    break;
                case 8:
                    i = i4 * 53;
                    iFloatToIntBits = ((String) zzii.zzf(obj, j)).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 9:
                    i2 = i4 * 53;
                    Object objZzf = zzii.zzf(obj, j);
                    if (objZzf != null) {
                        iHashCode2 = objZzf.hashCode();
                    }
                    i4 = i2 + iHashCode2;
                    break;
                case 10:
                    i = i4 * 53;
                    iFloatToIntBits = zzii.zzf(obj, j).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 11:
                    i = i4 * 53;
                    iFloatToIntBits = zzii.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 12:
                    i = i4 * 53;
                    iFloatToIntBits = zzii.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 13:
                    i = i4 * 53;
                    iFloatToIntBits = zzii.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 14:
                    i = i4 * 53;
                    jDoubleToLongBits = zzii.zzd(obj, j);
                    byte[] bArr5 = zzga.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 15:
                    i = i4 * 53;
                    iFloatToIntBits = zzii.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 16:
                    i = i4 * 53;
                    jDoubleToLongBits = zzii.zzd(obj, j);
                    byte[] bArr6 = zzga.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 17:
                    i2 = i4 * 53;
                    Object objZzf2 = zzii.zzf(obj, j);
                    if (objZzf2 != null) {
                        iHashCode2 = objZzf2.hashCode();
                    }
                    i4 = i2 + iHashCode2;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i4 * 53;
                    iFloatToIntBits = zzii.zzf(obj, j).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 50:
                    i = i4 * 53;
                    iFloatToIntBits = zzii.zzf(obj, j).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 51:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzm(obj, j));
                        byte[] bArr7 = zzga.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 52:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzn(obj, j));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 53:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr8 = zzga.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 54:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr9 = zzga.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 55:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 56:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr10 = zzga.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 57:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 58:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzga.zza(zzN(obj, j));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 59:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = ((String) zzii.zzf(obj, j)).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 60:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzii.zzf(obj, j).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 61:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzii.zzf(obj, j).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 62:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 63:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 64:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 65:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr11 = zzga.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 66:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 67:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr12 = zzga.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 68:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzii.zzf(obj, j).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
            }
            i3 += 3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:118:0x0354  */
    /* JADX WARN: Code duplicated, block: B:120:0x0360  */
    /* JADX WARN: Code duplicated, block: B:122:0x0366  */
    /* JADX WARN: Code duplicated, block: B:123:0x0369  */
    /* JADX WARN: Code duplicated, block: B:126:0x0391  */
    /* JADX WARN: Code duplicated, block: B:128:0x039c  */
    /* JADX WARN: Code duplicated, block: B:132:0x03b8  */
    /* JADX WARN: Code duplicated, block: B:133:0x03c9  */
    /* JADX WARN: Code duplicated, block: B:135:0x03cf  */
    /* JADX WARN: Code duplicated, block: B:137:0x03dc  */
    /* JADX WARN: Code duplicated, block: B:138:0x03fc  */
    /* JADX WARN: Code duplicated, block: B:140:0x03ff  */
    /* JADX WARN: Code duplicated, block: B:142:0x040e A[LOOP:4: B:141:0x040c->B:142:0x040e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:144:0x041e  */
    /* JADX WARN: Code duplicated, block: B:147:0x0428  */
    /* JADX WARN: Code duplicated, block: B:149:0x042c  */
    /* JADX WARN: Code duplicated, block: B:151:0x0441  */
    /* JADX WARN: Code duplicated, block: B:153:0x0449 A[LOOP:5: B:150:0x043f->B:153:0x0449, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:154:0x0457  */
    /* JADX WARN: Code duplicated, block: B:155:0x045b  */
    /* JADX WARN: Code duplicated, block: B:157:0x0462  */
    /* JADX WARN: Code duplicated, block: B:159:0x046f A[LOOP:6: B:158:0x046d->B:159:0x046f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:164:0x0486 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:165:0x0488  */
    /* JADX WARN: Code duplicated, block: B:167:0x049b  */
    /* JADX WARN: Code duplicated, block: B:169:0x04a3 A[LOOP:7: B:166:0x0499->B:169:0x04a3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:171:0x04b5  */
    /* JADX WARN: Code duplicated, block: B:173:0x04bc  */
    /* JADX WARN: Code duplicated, block: B:174:0x04c3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:175:0x04c5  */
    /* JADX WARN: Code duplicated, block: B:178:0x04de  */
    /* JADX WARN: Code duplicated, block: B:180:0x04e2  */
    /* JADX WARN: Code duplicated, block: B:182:0x04ee  */
    /* JADX WARN: Code duplicated, block: B:184:0x04fe A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:185:0x0500  */
    /* JADX WARN: Code duplicated, block: B:187:0x050e  */
    /* JADX WARN: Code duplicated, block: B:191:0x0525  */
    /* JADX WARN: Code duplicated, block: B:192:0x052d  */
    /* JADX WARN: Code duplicated, block: B:195:0x053f  */
    /* JADX WARN: Code duplicated, block: B:198:0x0557  */
    /* JADX WARN: Code duplicated, block: B:202:0x056b  */
    /* JADX WARN: Code duplicated, block: B:204:0x0578  */
    /* JADX WARN: Code duplicated, block: B:206:0x0580  */
    /* JADX WARN: Code duplicated, block: B:208:0x0584 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:209:0x0586  */
    /* JADX WARN: Code duplicated, block: B:210:0x058c  */
    /* JADX WARN: Code duplicated, block: B:213:0x0596  */
    /* JADX WARN: Code duplicated, block: B:215:0x059e  */
    /* JADX WARN: Code duplicated, block: B:217:0x05a6  */
    /* JADX WARN: Code duplicated, block: B:219:0x05aa A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:231:0x05d7  */
    /* JADX WARN: Code duplicated, block: B:233:0x05e4  */
    /* JADX WARN: Code duplicated, block: B:237:0x0604  */
    /* JADX WARN: Code duplicated, block: B:239:0x0611  */
    /* JADX WARN: Code duplicated, block: B:241:0x061a  */
    /* JADX WARN: Code duplicated, block: B:243:0x0622 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:244:0x0624  */
    /* JADX WARN: Code duplicated, block: B:245:0x062a  */
    /* JADX WARN: Code duplicated, block: B:248:0x0639  */
    /* JADX WARN: Code duplicated, block: B:250:0x0641  */
    /* JADX WARN: Code duplicated, block: B:252:0x0649 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:259:0x0666  */
    /* JADX WARN: Code duplicated, block: B:261:0x0670 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:262:0x0672  */
    /* JADX WARN: Code duplicated, block: B:263:0x0676  */
    /* JADX WARN: Code duplicated, block: B:265:0x067e  */
    /* JADX WARN: Code duplicated, block: B:268:0x068e  */
    /* JADX WARN: Code duplicated, block: B:270:0x0696  */
    /* JADX WARN: Code duplicated, block: B:272:0x069e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:276:0x06ac  */
    /* JADX WARN: Code duplicated, block: B:27:0x006b  */
    /* JADX WARN: Code duplicated, block: B:286:0x06da  */
    /* JADX WARN: Code duplicated, block: B:287:0x06df  */
    /* JADX WARN: Code duplicated, block: B:289:0x06ec  */
    /* JADX WARN: Code duplicated, block: B:291:0x06f9  */
    /* JADX WARN: Code duplicated, block: B:293:0x0703  */
    /* JADX WARN: Code duplicated, block: B:294:0x0705  */
    /* JADX WARN: Code duplicated, block: B:300:0x0714 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:301:0x0716  */
    /* JADX WARN: Code duplicated, block: B:303:0x0724  */
    /* JADX WARN: Code duplicated, block: B:304:0x0726  */
    /* JADX WARN: Code duplicated, block: B:307:0x072c  */
    /* JADX WARN: Code duplicated, block: B:309:0x0734  */
    /* JADX WARN: Code duplicated, block: B:311:0x073e  */
    /* JADX WARN: Code duplicated, block: B:312:0x0740  */
    /* JADX WARN: Code duplicated, block: B:314:0x0745  */
    /* JADX WARN: Code duplicated, block: B:316:0x0752  */
    /* JADX WARN: Code duplicated, block: B:318:0x0761  */
    /* JADX WARN: Code duplicated, block: B:31:0x00a5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:320:0x076d A[LOOP:15: B:319:0x076b->B:320:0x076d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:327:0x0787  */
    /* JADX WARN: Code duplicated, block: B:329:0x078a  */
    /* JADX WARN: Code duplicated, block: B:32:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:331:0x0799  */
    /* JADX WARN: Code duplicated, block: B:333:0x07a1 A[LOOP:16: B:330:0x0797->B:333:0x07a1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:334:0x07ab  */
    /* JADX WARN: Code duplicated, block: B:336:0x07b8  */
    /* JADX WARN: Code duplicated, block: B:338:0x07c7  */
    /* JADX WARN: Code duplicated, block: B:340:0x07d3 A[LOOP:17: B:339:0x07d1->B:340:0x07d3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:347:0x07ec  */
    /* JADX WARN: Code duplicated, block: B:349:0x07ef  */
    /* JADX WARN: Code duplicated, block: B:34:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:351:0x07fe  */
    /* JADX WARN: Code duplicated, block: B:353:0x0806 A[LOOP:18: B:350:0x07fc->B:353:0x0806, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:354:0x0810  */
    /* JADX WARN: Code duplicated, block: B:356:0x081d  */
    /* JADX WARN: Code duplicated, block: B:359:0x0826 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:360:0x0828  */
    /* JADX WARN: Code duplicated, block: B:361:0x083b  */
    /* JADX WARN: Code duplicated, block: B:363:0x0848  */
    /* JADX WARN: Code duplicated, block: B:365:0x0855 A[LOOP:19: B:364:0x0853->B:365:0x0855, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:36:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:370:0x0868 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:371:0x086a  */
    /* JADX WARN: Code duplicated, block: B:373:0x0879  */
    /* JADX WARN: Code duplicated, block: B:375:0x0881 A[LOOP:20: B:372:0x0877->B:375:0x0881, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:376:0x088b  */
    /* JADX WARN: Code duplicated, block: B:378:0x0898  */
    /* JADX WARN: Code duplicated, block: B:380:0x08a7  */
    /* JADX WARN: Code duplicated, block: B:382:0x08b3 A[LOOP:21: B:381:0x08b1->B:382:0x08b3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:389:0x08d1  */
    /* JADX WARN: Code duplicated, block: B:391:0x08d4  */
    /* JADX WARN: Code duplicated, block: B:393:0x08e7  */
    /* JADX WARN: Code duplicated, block: B:395:0x08ef A[LOOP:22: B:392:0x08e5->B:395:0x08ef, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:396:0x08fd  */
    /* JADX WARN: Code duplicated, block: B:398:0x090a  */
    /* JADX WARN: Code duplicated, block: B:400:0x0919  */
    /* JADX WARN: Code duplicated, block: B:402:0x0925 A[LOOP:23: B:401:0x0923->B:402:0x0925, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:409:0x0943  */
    /* JADX WARN: Code duplicated, block: B:40:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:411:0x0946  */
    /* JADX WARN: Code duplicated, block: B:413:0x0959  */
    /* JADX WARN: Code duplicated, block: B:415:0x0961 A[LOOP:24: B:412:0x0957->B:415:0x0961, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:417:0x0971  */
    /* JADX WARN: Code duplicated, block: B:419:0x0979 A[LOOP:1: B:416:0x096f->B:419:0x0979, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:420:0x098c A[PHI: r7 r8 r11 r13 r29
      0x098c: PHI (r7v76 com.google.android.gms.internal.play_billing.zzhe<T>) = 
      (r7v49 com.google.android.gms.internal.play_billing.zzhe<T>)
      (r7v50 com.google.android.gms.internal.play_billing.zzhe<T>)
      (r7v51 com.google.android.gms.internal.play_billing.zzhe<T>)
      (r7v52 com.google.android.gms.internal.play_billing.zzhe<T>)
      (r7v54 com.google.android.gms.internal.play_billing.zzhe<T>)
      (r7v55 com.google.android.gms.internal.play_billing.zzhe<T>)
      (r7v57 com.google.android.gms.internal.play_billing.zzhe<T>)
      (r7v78 com.google.android.gms.internal.play_billing.zzhe<T>)
     binds: [B:410:0x0944, B:390:0x08d2, B:370:0x0868, B:359:0x0826, B:348:0x07ed, B:328:0x0788, B:300:0x0714, B:136:0x03da] A[DONT_GENERATE, DONT_INLINE]
      0x098c: PHI (r8v95 int) = (r8v69 int), (r8v70 int), (r8v71 int), (r8v72 int), (r8v73 int), (r8v74 int), (r8v76 int), (r8v98 int) binds: [B:410:0x0944, B:390:0x08d2, B:370:0x0868, B:359:0x0826, B:348:0x07ed, B:328:0x0788, B:300:0x0714, B:136:0x03da] A[DONT_GENERATE, DONT_INLINE]
      0x098c: PHI (r11v53 int) = (r11v30 int), (r11v31 int), (r11v32 int), (r11v33 int), (r11v34 int), (r11v35 int), (r11v37 int), (r11v57 int) binds: [B:410:0x0944, B:390:0x08d2, B:370:0x0868, B:359:0x0826, B:348:0x07ed, B:328:0x0788, B:300:0x0714, B:136:0x03da] A[DONT_GENERATE, DONT_INLINE]
      0x098c: PHI (r13v80 java.lang.String) = 
      (r13v50 java.lang.String)
      (r13v51 java.lang.String)
      (r13v52 java.lang.String)
      (r13v53 java.lang.String)
      (r13v55 java.lang.String)
      (r13v56 java.lang.String)
      (r13v58 java.lang.String)
      (r13v84 java.lang.String)
     binds: [B:410:0x0944, B:390:0x08d2, B:370:0x0868, B:359:0x0826, B:348:0x07ed, B:328:0x0788, B:300:0x0714, B:136:0x03da] A[DONT_GENERATE, DONT_INLINE]
      0x098c: PHI (r29v31 sun.misc.Unsafe) = 
      (r29v5 sun.misc.Unsafe)
      (r29v6 sun.misc.Unsafe)
      (r29v7 sun.misc.Unsafe)
      (r29v8 sun.misc.Unsafe)
      (r29v9 sun.misc.Unsafe)
      (r29v10 sun.misc.Unsafe)
      (r29v12 sun.misc.Unsafe)
      (r29v33 sun.misc.Unsafe)
     binds: [B:410:0x0944, B:390:0x08d2, B:370:0x0868, B:359:0x0826, B:348:0x07ed, B:328:0x0788, B:300:0x0714, B:136:0x03da] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:427:0x09bf  */
    /* JADX WARN: Code duplicated, block: B:429:0x09c2  */
    /* JADX WARN: Code duplicated, block: B:431:0x09d5  */
    /* JADX WARN: Code duplicated, block: B:468:0x0ae1  */
    /* JADX WARN: Code duplicated, block: B:469:0x0aee  */
    /* JADX WARN: Code duplicated, block: B:471:0x0af1  */
    /* JADX WARN: Code duplicated, block: B:472:0x0b1b  */
    /* JADX WARN: Code duplicated, block: B:473:0x0b26  */
    /* JADX WARN: Code duplicated, block: B:475:0x0b32  */
    /* JADX WARN: Code duplicated, block: B:476:0x0b49  */
    /* JADX WARN: Code duplicated, block: B:478:0x0b55  */
    /* JADX WARN: Code duplicated, block: B:481:0x0b75  */
    /* JADX WARN: Code duplicated, block: B:483:0x0b81  */
    /* JADX WARN: Code duplicated, block: B:489:0x0ba3  */
    /* JADX WARN: Code duplicated, block: B:490:0x0bb0  */
    /* JADX WARN: Code duplicated, block: B:491:0x0bb4  */
    /* JADX WARN: Code duplicated, block: B:493:0x0bc0  */
    /* JADX WARN: Code duplicated, block: B:494:0x0bce  */
    /* JADX WARN: Code duplicated, block: B:496:0x0bda  */
    /* JADX WARN: Code duplicated, block: B:498:0x0bf5  */
    /* JADX WARN: Code duplicated, block: B:500:0x0c01  */
    /* JADX WARN: Code duplicated, block: B:502:0x0c09  */
    /* JADX WARN: Code duplicated, block: B:503:0x0c11  */
    /* JADX WARN: Code duplicated, block: B:512:0x0c3b A[PHI: r1 r8 r10 r13 r19
      0x0c3b: PHI (r1v62 com.google.android.gms.internal.play_billing.zzhe<T>) = 
      (r1v59 com.google.android.gms.internal.play_billing.zzhe<T>)
      (r1v60 com.google.android.gms.internal.play_billing.zzhe<T>)
      (r1v61 com.google.android.gms.internal.play_billing.zzhe<T>)
      (r1v64 com.google.android.gms.internal.play_billing.zzhe<T>)
     binds: [B:499:0x0bff, B:495:0x0bd8, B:492:0x0bbe, B:490:0x0bb0] A[DONT_GENERATE, DONT_INLINE]
      0x0c3b: PHI (r8v41 int) = (r8v38 int), (r8v39 int), (r8v40 int), (r8v43 int) binds: [B:499:0x0bff, B:495:0x0bd8, B:492:0x0bbe, B:490:0x0bb0] A[DONT_GENERATE, DONT_INLINE]
      0x0c3b: PHI (r10v36 java.lang.Object) = (r10v33 java.lang.Object), (r10v34 java.lang.Object), (r10v35 java.lang.Object), (r10v38 java.lang.Object) binds: [B:499:0x0bff, B:495:0x0bd8, B:492:0x0bbe, B:490:0x0bb0] A[DONT_GENERATE, DONT_INLINE]
      0x0c3b: PHI (r13v29 int) = (r13v26 int), (r13v27 int), (r13v28 int), (r13v31 int) binds: [B:499:0x0bff, B:495:0x0bd8, B:492:0x0bbe, B:490:0x0bb0] A[DONT_GENERATE, DONT_INLINE]
      0x0c3b: PHI (r19v17 java.lang.String) = (r19v14 java.lang.String), (r19v15 java.lang.String), (r19v16 java.lang.String), (r19v19 java.lang.String) binds: [B:499:0x0bff, B:495:0x0bd8, B:492:0x0bbe, B:490:0x0bb0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:513:0x0c3f  */
    /* JADX WARN: Code duplicated, block: B:515:0x0c4c  */
    /* JADX WARN: Code duplicated, block: B:517:0x0c56  */
    /* JADX WARN: Code duplicated, block: B:518:0x0c58  */
    /* JADX WARN: Code duplicated, block: B:520:0x0c65  */
    /* JADX WARN: Code duplicated, block: B:522:0x0c73  */
    /* JADX WARN: Code duplicated, block: B:523:0x0c85  */
    /* JADX WARN: Code duplicated, block: B:525:0x0c93  */
    /* JADX WARN: Code duplicated, block: B:526:0x0ca5  */
    /* JADX WARN: Code duplicated, block: B:528:0x0cb2  */
    /* JADX WARN: Code duplicated, block: B:529:0x0cc4  */
    /* JADX WARN: Code duplicated, block: B:531:0x0cd1  */
    /* JADX WARN: Code duplicated, block: B:532:0x0ce2  */
    /* JADX WARN: Code duplicated, block: B:534:0x0cf0  */
    /* JADX WARN: Code duplicated, block: B:535:0x0d05  */
    /* JADX WARN: Code duplicated, block: B:537:0x0d13  */
    /* JADX WARN: Code duplicated, block: B:538:0x0d28 A[PHI: r1 r8 r10 r13 r18 r19
      0x0d28: PHI (r1v72 com.google.android.gms.internal.play_billing.zzhe<T>) = 
      (r1v52 com.google.android.gms.internal.play_billing.zzhe<T>)
      (r1v53 com.google.android.gms.internal.play_billing.zzhe<T>)
      (r1v54 com.google.android.gms.internal.play_billing.zzhe<T>)
      (r1v55 com.google.android.gms.internal.play_billing.zzhe<T>)
      (r1v56 com.google.android.gms.internal.play_billing.zzhe<T>)
      (r1v57 com.google.android.gms.internal.play_billing.zzhe<T>)
      (r1v58 com.google.android.gms.internal.play_billing.zzhe<T>)
      (r1v62 com.google.android.gms.internal.play_billing.zzhe<T>)
      (r1v67 com.google.android.gms.internal.play_billing.zzhe<T>)
      (r1v73 com.google.android.gms.internal.play_billing.zzhe<T>)
     binds: [B:536:0x0d11, B:533:0x0cee, B:530:0x0ccf, B:527:0x0cb0, B:524:0x0c91, B:521:0x0c71, B:514:0x0c4a, B:512:0x0c3b, B:480:0x0b6f, B:468:0x0ae1] A[DONT_GENERATE, DONT_INLINE]
      0x0d28: PHI (r8v54 int) = 
      (r8v31 int)
      (r8v32 int)
      (r8v33 int)
      (r8v34 int)
      (r8v35 int)
      (r8v36 int)
      (r8v37 int)
      (r8v41 int)
      (r8v49 int)
      (r8v55 int)
     binds: [B:536:0x0d11, B:533:0x0cee, B:530:0x0ccf, B:527:0x0cb0, B:524:0x0c91, B:521:0x0c71, B:514:0x0c4a, B:512:0x0c3b, B:480:0x0b6f, B:468:0x0ae1] A[DONT_GENERATE, DONT_INLINE]
      0x0d28: PHI (r10v46 java.lang.Object) = 
      (r10v26 java.lang.Object)
      (r10v27 java.lang.Object)
      (r10v28 java.lang.Object)
      (r10v29 java.lang.Object)
      (r10v30 java.lang.Object)
      (r10v31 java.lang.Object)
      (r10v32 java.lang.Object)
      (r10v36 java.lang.Object)
      (r10v41 java.lang.Object)
      (r10v47 java.lang.Object)
     binds: [B:536:0x0d11, B:533:0x0cee, B:530:0x0ccf, B:527:0x0cb0, B:524:0x0c91, B:521:0x0c71, B:514:0x0c4a, B:512:0x0c3b, B:480:0x0b6f, B:468:0x0ae1] A[DONT_GENERATE, DONT_INLINE]
      0x0d28: PHI (r13v39 int) = 
      (r13v19 int)
      (r13v20 int)
      (r13v21 int)
      (r13v22 int)
      (r13v23 int)
      (r13v24 int)
      (r13v25 int)
      (r13v29 int)
      (r13v34 int)
      (r13v40 int)
     binds: [B:536:0x0d11, B:533:0x0cee, B:530:0x0ccf, B:527:0x0cb0, B:524:0x0c91, B:521:0x0c71, B:514:0x0c4a, B:512:0x0c3b, B:480:0x0b6f, B:468:0x0ae1] A[DONT_GENERATE, DONT_INLINE]
      0x0d28: PHI (r18v41 int) = 
      (r18v26 int)
      (r18v27 int)
      (r18v28 int)
      (r18v29 int)
      (r18v30 int)
      (r18v31 int)
      (r18v32 int)
      (r18v36 int)
      (r18v38 int)
      (r18v42 int)
     binds: [B:536:0x0d11, B:533:0x0cee, B:530:0x0ccf, B:527:0x0cb0, B:524:0x0c91, B:521:0x0c71, B:514:0x0c4a, B:512:0x0c3b, B:480:0x0b6f, B:468:0x0ae1] A[DONT_GENERATE, DONT_INLINE]
      0x0d28: PHI (r19v27 java.lang.String) = 
      (r19v7 java.lang.String)
      (r19v8 java.lang.String)
      (r19v9 java.lang.String)
      (r19v10 java.lang.String)
      (r19v11 java.lang.String)
      (r19v12 java.lang.String)
      (r19v13 java.lang.String)
      (r19v17 java.lang.String)
      (r19v22 java.lang.String)
      (r19v28 java.lang.String)
     binds: [B:536:0x0d11, B:533:0x0cee, B:530:0x0ccf, B:527:0x0cb0, B:524:0x0c91, B:521:0x0c71, B:514:0x0c4a, B:512:0x0c3b, B:480:0x0b6f, B:468:0x0ae1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:540:0x0d2b  */
    /* JADX WARN: Code duplicated, block: B:541:0x0d32  */
    /* JADX WARN: Code duplicated, block: B:547:0x0d46  */
    /* JADX WARN: Code duplicated, block: B:549:0x0d50  */
    /* JADX WARN: Code duplicated, block: B:551:0x0d5a  */
    /* JADX WARN: Code duplicated, block: B:554:0x0d6e  */
    /* JADX WARN: Code duplicated, block: B:58:0x0185  */
    /* JADX WARN: Code duplicated, block: B:603:0x00f8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:604:0x0133 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:605:0x015a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:606:0x01a2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:607:0x01fd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:608:0x0246 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:609:0x026b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:610:0x0289 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:611:0x02a9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:612:0x02c6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:613:0x02f1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:614:0x0312 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:615:0x0422 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:616:0x0480 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:617:0x05d1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:618:0x05cb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:619:0x05c0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:620:0x05ba A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:621:0x0660 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:622:0x065a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:623:0x06d4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:624:0x06cc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:625:0x06c1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:626:0x06b9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:627:0x070e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:628:0x0781 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:629:0x077b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:630:0x07e6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:631:0x07e0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:632:0x0862 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:633:0x08cb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:634:0x08c5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:635:0x093d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:636:0x0937 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:637:0x0993 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:644:0x0d6a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:645:0x03a7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:646:0x005b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:647:0x00bd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:648:0x014f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:649:0x0190 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:650:0x01ae A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:651:0x01eb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:652:0x0235 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:653:0x0259 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:654:0x0277 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:655:0x0298 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:656:0x02b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:657:0x02df A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:658:0x0300 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:659:0x011d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:660:0x0acd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:661:0x0398 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:662:0x018b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:664:0x0351 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:665:0x033d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:666:0x00f6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:667:0x0128 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:668:0x018b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:669:0x01e8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:670:0x032d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:671:0x022d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:672:0x032d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:673:0x032d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:674:0x032d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:675:0x032d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:676:0x032d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:677:0x032d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:678:0x032d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:679:0x0093 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:680:0x09af A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:681:0x09a3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:688:0x0991 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:697:0x04b1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:700:0x04b1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:705:0x054f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:707:0x0539 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:710:0x05c6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:711:0x05b2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:712:0x05ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:718:0x06c7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:719:0x064f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:720:0x064b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:725:0x06a4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:727:0x06c7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:728:0x06a0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:737:0x0821 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x0201  */
    /* JADX WARN: Code duplicated, block: B:742:0x0821 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:744:0x0821 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:748:0x0821 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:74:0x020a  */
    /* JADX WARN: Code duplicated, block: B:751:0x0821 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:754:0x0821 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:76:0x0212  */
    /* JADX WARN: Code duplicated, block: B:78:0x0216  */
    /* JADX WARN: Code duplicated, block: B:79:0x021b  */
    /* JADX WARN: Code duplicated, block: B:88:0x0251  */
    /* JADX WARN: Code duplicated, block: B:89:0x0253  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r3v202 */
    /* JADX WARN: Type inference failed for: r3v203 */
    /* JADX WARN: Type inference failed for: r3v204 */
    /* JADX WARN: Type inference failed for: r3v205 */
    /* JADX WARN: Type inference failed for: r3v206 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.google.android.gms.internal.play_billing.zzic] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    final int zzc(Object obj, byte[] bArr, int i, int i2, int i3, zzej zzejVar) throws IOException {
        Object obj2;
        String str;
        Unsafe unsafe;
        zzfx zzfxVarZzu;
        int i4;
        int iZzj;
        int i5;
        int iZzq;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        zzfh zzfhVar;
        zzhb zzhbVar;
        int i12;
        int[] iArr;
        int i13;
        int i14;
        int iZzr;
        long j;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        zzhe<T> zzheVar;
        int i22;
        int i23;
        int iZzl;
        boolean z;
        int i24;
        int i25;
        zzhe<T> zzheVar2;
        int i26;
        int i27;
        zzhe<T> zzheVar3;
        Unsafe unsafe2;
        int i28;
        zzfz zzfzVarZzd;
        int size;
        int i29;
        long j2;
        boolean z2;
        int i30;
        int i31;
        int i32;
        zzfx zzfxVarZzu2;
        int i33;
        Unsafe unsafe3;
        Object object;
        int i34;
        zzgt zzgtVar;
        zzgv zzgvVar;
        Object obj3;
        long j3;
        zzfz zzfzVar;
        zzfz zzfzVar2;
        zzhe<T> zzheVar4;
        int i35;
        Unsafe unsafe4;
        int i36;
        String str2;
        zzfe zzfeVar;
        int iZzi;
        zzfe zzfeVar2;
        int i37;
        int i38;
        zzfo zzfoVar;
        int iZzi2;
        zzfo zzfoVar2;
        int i39;
        int i40;
        zzgp zzgpVar;
        int iZzi3;
        zzgp zzgpVar2;
        int i41;
        zzhe<T> zzheVar5;
        zzgp zzgpVar3;
        int iZzi4;
        zzgp zzgpVar4;
        int i42;
        int i43;
        zzfv zzfvVar;
        int iZzi5;
        zzfv zzfvVar2;
        int i44;
        int i45;
        zzel zzelVar;
        boolean z3;
        int iZzi6;
        boolean z4;
        zzel zzelVar2;
        int i46;
        boolean z5;
        zzhe<T> zzheVar6;
        int iZzi7;
        int i47;
        int i48;
        int iZzi8;
        int i49;
        int i50;
        int i51;
        Object obj4;
        int iZzi9;
        int i52;
        int i53;
        int iZzi10;
        int i54;
        int iZzi11;
        int i55;
        int iZzk;
        zzfx zzfxVarZzu3;
        zzib zzibVar;
        int i56;
        int i57;
        Iterator it;
        Object objZzo;
        int iIntValue;
        int size2;
        Object objZzo2;
        int i58;
        int i59;
        int iIntValue2;
        int i60;
        zzfv zzfvVar3;
        int iZzi12;
        zzfv zzfvVar4;
        int i61;
        zzgp zzgpVar5;
        int iZzi13;
        zzgp zzgpVar6;
        int i62;
        int i63;
        zzhl zzhlVarZzv;
        int iZzi14;
        zzhe<T> zzheVar7 = this;
        Object obj5 = obj;
        i2 = i2;
        i3 = i3;
        zzA(obj);
        Unsafe unsafe5 = zzb;
        int iZzh = i;
        int i64 = -1;
        int i65 = 0;
        int i66 = 0;
        int i67 = 0;
        int i68 = 1048575;
        while (true) {
            if (iZzh < i2) {
                int i69 = iZzh + 1;
                int i70 = bArr[iZzh];
                if (i70 < 0) {
                    iZzj = zzek.zzj(i70, bArr, i69, zzejVar);
                    i4 = zzejVar.zza;
                } else {
                    i4 = i70;
                    iZzj = i69;
                }
                int i71 = i4 >>> 3;
                if (i71 > i64) {
                    iZzq = (i71 < zzheVar7.zze || i71 > zzheVar7.zzf) ? -1 : zzheVar7.zzq(i71, i65 / 3);
                } else {
                    if (i71 < zzheVar7.zze || i71 > zzheVar7.zzf) {
                        i5 = -1;
                        iZzq = -1;
                    } else {
                        iZzq = zzheVar7.zzq(i71, 0);
                    }
                    if (iZzq == i5) {
                        obj2 = obj5;
                        i6 = iZzj;
                        i7 = i67;
                        i8 = i68;
                        str = "Failed to parse the message.";
                        unsafe = unsafe5;
                        i9 = i71;
                        i10 = 0;
                        i11 = i4;
                    } else {
                        i12 = i4 & 7;
                        iArr = zzheVar7.zzc;
                        i13 = i4;
                        i14 = iArr[iZzq + 1];
                        str = "Failed to parse the message.";
                        iZzr = zzr(i14);
                        j = i14 & 1048575;
                        i64 = i71;
                        if (iZzr <= 17) {
                            int i72 = iArr[iZzq + 2];
                            i15 = 1 << (i72 >>> 20);
                            i16 = 1048575;
                            i17 = i72 & 1048575;
                            i18 = iZzj;
                            if (i17 != i68) {
                                if (i68 != 1048575) {
                                    unsafe5.putInt(obj5, i68, i67);
                                    i16 = 1048575;
                                }
                                if (i17 == i16) {
                                    i67 = 0;
                                } else {
                                    i67 = unsafe5.getInt(obj5, i17);
                                }
                            } else {
                                i17 = i68;
                            }
                            switch (iZzr) {
                                case 0:
                                    zzheVar = this;
                                    i19 = i17;
                                    i22 = i18;
                                    i10 = iZzq;
                                    i21 = i13 == true ? 1 : 0;
                                    if (i12 == 1) {
                                        zzheVar2 = zzheVar;
                                        i3 = i3;
                                        obj2 = obj5;
                                        i11 = i21;
                                        i7 = i67;
                                        i6 = i22;
                                        unsafe = unsafe5;
                                        zzheVar7 = zzheVar2;
                                        i8 = i19;
                                        i9 = i64;
                                    } else {
                                        iZzh = i22 + 8;
                                        i67 |= i15;
                                        zzii.zzo(obj5, j, Double.longBitsToDouble(zzek.zzp(bArr, i22)));
                                        i66 = i21;
                                        zzheVar7 = zzheVar;
                                        i65 = i10;
                                        i68 = i19;
                                        i64 = i64;
                                    }
                                    break;
                                case 1:
                                    zzheVar = this;
                                    i19 = i17;
                                    i22 = i18;
                                    i10 = iZzq;
                                    i21 = i13 == true ? 1 : 0;
                                    if (i12 == 5) {
                                        zzheVar2 = zzheVar;
                                        i3 = i3;
                                        obj2 = obj5;
                                        i11 = i21;
                                        i7 = i67;
                                        i6 = i22;
                                        unsafe = unsafe5;
                                        zzheVar7 = zzheVar2;
                                        i8 = i19;
                                        i9 = i64;
                                    } else {
                                        iZzh = i22 + 4;
                                        i67 |= i15;
                                        zzii.zzp(obj5, j, Float.intBitsToFloat(zzek.zzb(bArr, i22)));
                                        i66 = i21;
                                        zzheVar7 = zzheVar;
                                        i65 = i10;
                                        i68 = i19;
                                        i64 = i64;
                                    }
                                    break;
                                case 2:
                                case 3:
                                    zzheVar = this;
                                    i19 = i17;
                                    i22 = i18;
                                    i10 = iZzq;
                                    i21 = i13 == true ? 1 : 0;
                                    if (i12 == 0) {
                                        zzheVar2 = zzheVar;
                                        i3 = i3;
                                        obj2 = obj5;
                                        i11 = i21;
                                        i7 = i67;
                                        i6 = i22;
                                        unsafe = unsafe5;
                                        zzheVar7 = zzheVar2;
                                        i8 = i19;
                                        i9 = i64;
                                    } else {
                                        i23 = i15 | i67;
                                        iZzl = zzek.zzl(bArr, i22, zzejVar);
                                        unsafe5.putLong(obj, j, zzejVar.zzb);
                                        i66 = i21;
                                        zzheVar7 = zzheVar;
                                        i65 = i10;
                                        i67 = i23;
                                        iZzh = iZzl;
                                        i68 = i19;
                                        i64 = i64;
                                    }
                                    break;
                                case 4:
                                case 11:
                                    zzheVar = this;
                                    i19 = i17;
                                    i22 = i18;
                                    i10 = iZzq;
                                    i21 = i13 == true ? 1 : 0;
                                    if (i12 == 0) {
                                        zzheVar2 = zzheVar;
                                        i3 = i3;
                                        obj2 = obj5;
                                        i11 = i21;
                                        i7 = i67;
                                        i6 = i22;
                                        unsafe = unsafe5;
                                        zzheVar7 = zzheVar2;
                                        i8 = i19;
                                        i9 = i64;
                                    } else {
                                        i67 |= i15;
                                        iZzh = zzek.zzi(bArr, i22, zzejVar);
                                        unsafe5.putInt(obj5, j, zzejVar.zza);
                                        i66 = i21;
                                        zzheVar7 = zzheVar;
                                        i65 = i10;
                                        i68 = i19;
                                        i64 = i64;
                                    }
                                    break;
                                case 5:
                                case 14:
                                    zzheVar = this;
                                    i19 = i17;
                                    i22 = i18;
                                    i10 = iZzq;
                                    i21 = i13 == true ? 1 : 0;
                                    if (i12 == 1) {
                                        zzheVar2 = zzheVar;
                                        i3 = i3;
                                        obj2 = obj5;
                                        i11 = i21;
                                        i7 = i67;
                                        i6 = i22;
                                        unsafe = unsafe5;
                                        zzheVar7 = zzheVar2;
                                        i8 = i19;
                                        i9 = i64;
                                    } else {
                                        iZzl = i22 + 8;
                                        i23 = i15 | i67;
                                        unsafe5.putLong(obj, j, zzek.zzp(bArr, i22));
                                        i66 = i21;
                                        zzheVar7 = zzheVar;
                                        i65 = i10;
                                        i67 = i23;
                                        iZzh = iZzl;
                                        i68 = i19;
                                        i64 = i64;
                                    }
                                    break;
                                case 6:
                                case 13:
                                    zzheVar = this;
                                    i19 = i17;
                                    i22 = i18;
                                    i10 = iZzq;
                                    i21 = i13 == true ? 1 : 0;
                                    if (i12 == 5) {
                                        zzheVar2 = zzheVar;
                                        i3 = i3;
                                        obj2 = obj5;
                                        i11 = i21;
                                        i7 = i67;
                                        i6 = i22;
                                        unsafe = unsafe5;
                                        zzheVar7 = zzheVar2;
                                        i8 = i19;
                                        i9 = i64;
                                    } else {
                                        iZzh = i22 + 4;
                                        i67 |= i15;
                                        unsafe5.putInt(obj5, j, zzek.zzb(bArr, i22));
                                        i66 = i21;
                                        zzheVar7 = zzheVar;
                                        i65 = i10;
                                        i68 = i19;
                                        i64 = i64;
                                    }
                                    break;
                                case 7:
                                    zzheVar = this;
                                    i19 = i17;
                                    i22 = i18;
                                    i10 = iZzq;
                                    i21 = i13 == true ? 1 : 0;
                                    if (i12 == 0) {
                                        zzheVar2 = zzheVar;
                                        i3 = i3;
                                        obj2 = obj5;
                                        i11 = i21;
                                        i7 = i67;
                                        i6 = i22;
                                        unsafe = unsafe5;
                                        zzheVar7 = zzheVar2;
                                        i8 = i19;
                                        i9 = i64;
                                    } else {
                                        i67 |= i15;
                                        iZzh = zzek.zzl(bArr, i22, zzejVar);
                                        if (zzejVar.zzb != 0) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        zzii.zzm(obj5, j, z);
                                        i66 = i21;
                                        zzheVar7 = zzheVar;
                                        i65 = i10;
                                        i68 = i19;
                                        i64 = i64;
                                    }
                                    break;
                                case 8:
                                    zzheVar = this;
                                    i19 = i17;
                                    i22 = i18;
                                    i10 = iZzq;
                                    i21 = i13 == true ? 1 : 0;
                                    if (i12 == 2) {
                                        zzheVar2 = zzheVar;
                                        i3 = i3;
                                        obj2 = obj5;
                                        i11 = i21;
                                        i7 = i67;
                                        i6 = i22;
                                        unsafe = unsafe5;
                                        zzheVar7 = zzheVar2;
                                        i8 = i19;
                                        i9 = i64;
                                    } else {
                                        if ((i14 & C.ENCODING_PCM_A_LAW) != 0) {
                                            i67 |= i15;
                                            iZzh = zzek.zzg(bArr, i22, zzejVar);
                                        } else {
                                            iZzh = zzek.zzi(bArr, i22, zzejVar);
                                            i24 = zzejVar.zza;
                                            if (i24 >= 0) {
                                                throw new zzgc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                            }
                                            int i73 = i67 | i15;
                                            if (i24 == 0) {
                                                zzejVar.zzc = "";
                                            } else {
                                                zzejVar.zzc = new String(bArr, iZzh, i24, zzga.zza);
                                                iZzh += i24;
                                            }
                                            i67 = i73;
                                        }
                                        unsafe5.putObject(obj5, j, zzejVar.zzc);
                                        i66 = i21;
                                        zzheVar7 = zzheVar;
                                        i65 = i10;
                                        i68 = i19;
                                        i64 = i64;
                                    }
                                    break;
                                case 9:
                                    zzheVar = this;
                                    i19 = i17;
                                    i25 = i18;
                                    i10 = iZzq;
                                    i21 = i13 == true ? 1 : 0;
                                    if (i12 == 2) {
                                        Object objZzx = zzheVar.zzx(obj5, i10);
                                        iZzh = zzek.zzn(objZzx, zzheVar.zzv(i10), bArr, i25, i2, zzejVar);
                                        zzheVar.zzF(obj5, i10, objZzx);
                                        i66 = i21 == true ? 1 : 0;
                                        zzheVar7 = zzheVar;
                                        i67 |= i15;
                                        i65 = i10;
                                        i68 = i19;
                                        i64 = i64;
                                        i2 = i2;
                                    }
                                    i22 = i25;
                                    zzheVar2 = zzheVar;
                                    i3 = i3;
                                    obj2 = obj5;
                                    i11 = i21;
                                    i7 = i67;
                                    i6 = i22;
                                    unsafe = unsafe5;
                                    zzheVar7 = zzheVar2;
                                    i8 = i19;
                                    i9 = i64;
                                    break;
                                case 10:
                                    zzheVar = this;
                                    i19 = i17;
                                    i25 = i18;
                                    i10 = iZzq;
                                    i21 = i13 == true ? 1 : 0;
                                    if (i12 == 2) {
                                        i22 = i25;
                                        zzheVar2 = zzheVar;
                                        i3 = i3;
                                        obj2 = obj5;
                                        i11 = i21;
                                        i7 = i67;
                                        i6 = i22;
                                        unsafe = unsafe5;
                                        zzheVar7 = zzheVar2;
                                        i8 = i19;
                                        i9 = i64;
                                    } else {
                                        i67 |= i15;
                                        iZzh = zzek.zza(bArr, i25, zzejVar);
                                        unsafe5.putObject(obj5, j, zzejVar.zzc);
                                        i66 = i21;
                                        zzheVar7 = zzheVar;
                                        i65 = i10;
                                        i68 = i19;
                                        i64 = i64;
                                    }
                                    break;
                                case 12:
                                    i19 = i17;
                                    i20 = i18;
                                    i21 = i13 == true ? 1 : 0;
                                    i10 = iZzq;
                                    if (i12 == 0) {
                                        zzheVar2 = this;
                                        i22 = i20;
                                        i3 = i3;
                                        obj2 = obj5;
                                        i11 = i21;
                                        i7 = i67;
                                        i6 = i22;
                                        unsafe = unsafe5;
                                        zzheVar7 = zzheVar2;
                                        i8 = i19;
                                        i9 = i64;
                                    } else {
                                        iZzh = zzek.zzi(bArr, i20, zzejVar);
                                        i26 = zzejVar.zza;
                                        zzheVar = this;
                                        zzfx zzfxVarZzu4 = zzheVar.zzu(i10);
                                        if ((i14 & Integer.MIN_VALUE) != 0 || zzfxVarZzu4 == null || zzfxVarZzu4.zza(i26)) {
                                            i67 |= i15;
                                            unsafe5.putInt(obj5, j, i26);
                                        } else {
                                            zzd(obj).zzj(i21 == true ? 1 : 0, Long.valueOf(i26));
                                        }
                                        i66 = i21;
                                        zzheVar7 = zzheVar;
                                        i65 = i10;
                                        i68 = i19;
                                        i64 = i64;
                                    }
                                    break;
                                case 15:
                                    i19 = i17;
                                    i20 = i18;
                                    i21 = i13 == true ? 1 : 0;
                                    i10 = iZzq;
                                    if (i12 == 0) {
                                        zzheVar2 = this;
                                        i22 = i20;
                                        i3 = i3;
                                        obj2 = obj5;
                                        i11 = i21;
                                        i7 = i67;
                                        i6 = i22;
                                        unsafe = unsafe5;
                                        zzheVar7 = zzheVar2;
                                        i8 = i19;
                                        i9 = i64;
                                    } else {
                                        i67 |= i15;
                                        iZzh = zzek.zzi(bArr, i20, zzejVar);
                                        unsafe5.putInt(obj5, j, zzey.zzb(zzejVar.zza));
                                        i66 = i21 == true ? 1 : 0;
                                        i65 = i10;
                                        i68 = i19;
                                        zzheVar7 = this;
                                    }
                                    break;
                                case 16:
                                    if (i12 == 0) {
                                        i19 = i17;
                                        i20 = i18;
                                        i21 = i13 == true ? 1 : 0;
                                        i10 = iZzq;
                                        zzheVar2 = this;
                                        i22 = i20;
                                        i3 = i3;
                                        obj2 = obj5;
                                        i11 = i21;
                                        i7 = i67;
                                        i6 = i22;
                                        unsafe = unsafe5;
                                        zzheVar7 = zzheVar2;
                                        i8 = i19;
                                        i9 = i64;
                                    } else {
                                        int i74 = i67 | i15;
                                        int iZzl2 = zzek.zzl(bArr, i18, zzejVar);
                                        i19 = i17;
                                        unsafe5.putLong(obj, j, zzey.zzc(zzejVar.zzb));
                                        i66 = i13 == true ? 1 : 0;
                                        i67 = i74;
                                        i65 = iZzq;
                                        iZzh = iZzl2;
                                        i68 = i19;
                                        zzheVar7 = this;
                                    }
                                    break;
                                default:
                                    zzheVar = this;
                                    i19 = i17;
                                    i22 = i18;
                                    i10 = iZzq;
                                    i21 = i13 == true ? 1 : 0;
                                    if (i12 == 3) {
                                        Object objZzx2 = zzheVar.zzx(obj5, i10);
                                        iZzh = zzek.zzm(objZzx2, zzheVar.zzv(i10), bArr, i22, i2, (i64 << 3) | 4, zzejVar);
                                        zzheVar.zzF(obj5, i10, objZzx2);
                                        i66 = i21 == true ? 1 : 0;
                                        i67 |= i15;
                                        i65 = i10;
                                        zzheVar7 = zzheVar;
                                        i68 = i19;
                                        i64 = i64;
                                        i2 = i2;
                                    }
                                    zzheVar2 = zzheVar;
                                    i3 = i3;
                                    obj2 = obj5;
                                    i11 = i21;
                                    i7 = i67;
                                    i6 = i22;
                                    unsafe = unsafe5;
                                    zzheVar7 = zzheVar2;
                                    i8 = i19;
                                    i9 = i64;
                                    break;
                            }
                        } else {
                            i27 = iZzj;
                            i10 = iZzq;
                            i8 = i68;
                            zzheVar3 = zzheVar7;
                            i7 = i67;
                            if (iZzr == 27) {
                                if (i12 == 2) {
                                    zzfzVarZzd = (zzfz) unsafe5.getObject(obj5, j);
                                    if (!zzfzVarZzd.zzc()) {
                                        size = zzfzVarZzd.size();
                                        if (size == 0) {
                                            i29 = 10;
                                        } else {
                                            i29 = size + size;
                                        }
                                        zzfzVarZzd = zzfzVarZzd.zzd(i29);
                                        unsafe5.putObject(obj5, j, zzfzVarZzd);
                                    }
                                    iZzh = zzek.zze(zzheVar3.zzv(i10), i13 == true ? 1 : 0, bArr, i27, i2, zzfzVarZzd, zzejVar);
                                    i3 = i3;
                                    i66 = i13 == true ? 1 : 0;
                                    zzheVar7 = zzheVar3;
                                    i65 = i10;
                                    i67 = i7;
                                    i64 = i64;
                                    i68 = i8;
                                } else {
                                    unsafe2 = unsafe5;
                                    i28 = i27;
                                }
                                i2 = i2;
                            } else if (iZzr <= 49) {
                                j3 = i14;
                                zzfzVar = (zzfz) unsafe5.getObject(obj5, j);
                                if (zzfzVar.zzc()) {
                                    zzfzVar2 = zzfzVar;
                                } else {
                                    int size3 = zzfzVar.size();
                                    zzfz zzfzVarZzd2 = zzfzVar.zzd(size3 + size3);
                                    unsafe5.putObject(obj5, j, zzfzVarZzd2);
                                    zzfzVar2 = zzfzVarZzd2;
                                }
                                switch (iZzr) {
                                    case 18:
                                    case 35:
                                        zzheVar4 = this;
                                        i35 = i2;
                                        unsafe4 = unsafe5;
                                        i36 = i27;
                                        str2 = str;
                                        if (i12 == 2) {
                                            if (i12 == 1) {
                                                iZzh = i36 + 8;
                                                int i75 = zzek.zza;
                                                zzfeVar = (zzfe) zzfzVar2;
                                                zzfeVar.zzf(Double.longBitsToDouble(zzek.zzp(bArr, i36)));
                                                while (iZzh < i35) {
                                                    iZzi = zzek.zzi(bArr, iZzh, zzejVar);
                                                    if (i13 == zzejVar.zza) {
                                                        zzfeVar.zzf(Double.longBitsToDouble(zzek.zzp(bArr, iZzi)));
                                                        iZzh = iZzi + 8;
                                                    }
                                                }
                                            }
                                            str = str2;
                                            zzheVar5 = zzheVar4;
                                            iZzh = i36;
                                            if (iZzh != i36) {
                                                i3 = i3;
                                                obj2 = obj5;
                                                i11 = i13 == true ? 1 : 0;
                                                i6 = iZzh;
                                                zzheVar7 = zzheVar5;
                                                i9 = i64;
                                                unsafe = unsafe4;
                                            } else {
                                                i3 = i3;
                                                i66 = i13 == true ? 1 : 0;
                                                i2 = i35;
                                                zzheVar7 = zzheVar5;
                                                i65 = i10;
                                                i67 = i7;
                                                i64 = i64;
                                                i68 = i8;
                                                unsafe5 = unsafe4;
                                            }
                                        } else {
                                            int i76 = zzek.zza;
                                            zzfeVar2 = (zzfe) zzfzVar2;
                                            iZzh = zzek.zzi(bArr, i36, zzejVar);
                                            i37 = zzejVar.zza;
                                            i38 = iZzh + i37;
                                            if (i38 <= bArr.length) {
                                                throw new zzgc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            zzfeVar2.zzg(zzfeVar2.size() + (i37 / 8));
                                            while (iZzh < i38) {
                                                zzfeVar2.zzf(Double.longBitsToDouble(zzek.zzp(bArr, iZzh)));
                                                iZzh += 8;
                                            }
                                            if (iZzh != i38) {
                                                throw new zzgc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        str = str2;
                                        zzheVar5 = zzheVar4;
                                        if (iZzh != i36) {
                                            i3 = i3;
                                            obj2 = obj5;
                                            i11 = i13 == true ? 1 : 0;
                                            i6 = iZzh;
                                            zzheVar7 = zzheVar5;
                                            i9 = i64;
                                            unsafe = unsafe4;
                                        } else {
                                            i3 = i3;
                                            i66 = i13 == true ? 1 : 0;
                                            i2 = i35;
                                            zzheVar7 = zzheVar5;
                                            i65 = i10;
                                            i67 = i7;
                                            i64 = i64;
                                            i68 = i8;
                                            unsafe5 = unsafe4;
                                        }
                                        break;
                                    case 19:
                                    case 36:
                                        zzheVar4 = this;
                                        i35 = i2;
                                        unsafe4 = unsafe5;
                                        i36 = i27;
                                        str2 = str;
                                        if (i12 == 2) {
                                            if (i12 == 5) {
                                                iZzh = i36 + 4;
                                                int i77 = zzek.zza;
                                                zzfoVar = (zzfo) zzfzVar2;
                                                zzfoVar.zzf(Float.intBitsToFloat(zzek.zzb(bArr, i36)));
                                                while (iZzh < i35) {
                                                    iZzi2 = zzek.zzi(bArr, iZzh, zzejVar);
                                                    if (i13 == zzejVar.zza) {
                                                        zzfoVar.zzf(Float.intBitsToFloat(zzek.zzb(bArr, iZzi2)));
                                                        iZzh = iZzi2 + 4;
                                                    }
                                                }
                                            }
                                            str = str2;
                                            zzheVar5 = zzheVar4;
                                            iZzh = i36;
                                            if (iZzh != i36) {
                                                i3 = i3;
                                                obj2 = obj5;
                                                i11 = i13 == true ? 1 : 0;
                                                i6 = iZzh;
                                                zzheVar7 = zzheVar5;
                                                i9 = i64;
                                                unsafe = unsafe4;
                                            } else {
                                                i3 = i3;
                                                i66 = i13 == true ? 1 : 0;
                                                i2 = i35;
                                                zzheVar7 = zzheVar5;
                                                i65 = i10;
                                                i67 = i7;
                                                i64 = i64;
                                                i68 = i8;
                                                unsafe5 = unsafe4;
                                            }
                                        } else {
                                            int i78 = zzek.zza;
                                            zzfoVar2 = (zzfo) zzfzVar2;
                                            iZzh = zzek.zzi(bArr, i36, zzejVar);
                                            i39 = zzejVar.zza;
                                            i40 = iZzh + i39;
                                            if (i40 <= bArr.length) {
                                                throw new zzgc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            zzfoVar2.zzg(zzfoVar2.size() + (i39 / 4));
                                            while (iZzh < i40) {
                                                zzfoVar2.zzf(Float.intBitsToFloat(zzek.zzb(bArr, iZzh)));
                                                iZzh += 4;
                                            }
                                            if (iZzh != i40) {
                                                throw new zzgc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        str = str2;
                                        zzheVar5 = zzheVar4;
                                        if (iZzh != i36) {
                                            i3 = i3;
                                            obj2 = obj5;
                                            i11 = i13 == true ? 1 : 0;
                                            i6 = iZzh;
                                            zzheVar7 = zzheVar5;
                                            i9 = i64;
                                            unsafe = unsafe4;
                                        } else {
                                            i3 = i3;
                                            i66 = i13 == true ? 1 : 0;
                                            i2 = i35;
                                            zzheVar7 = zzheVar5;
                                            i65 = i10;
                                            i67 = i7;
                                            i64 = i64;
                                            i68 = i8;
                                            unsafe5 = unsafe4;
                                        }
                                        break;
                                    case 20:
                                    case 21:
                                    case 37:
                                    case 38:
                                        zzheVar4 = this;
                                        i35 = i2;
                                        unsafe4 = unsafe5;
                                        i36 = i27;
                                        str2 = str;
                                        if (i12 == 2) {
                                            if (i12 == 0) {
                                                int i79 = zzek.zza;
                                                zzgpVar = (zzgp) zzfzVar2;
                                                iZzh = zzek.zzl(bArr, i36, zzejVar);
                                                zzgpVar.zzf(zzejVar.zzb);
                                                while (iZzh < i35) {
                                                    iZzi3 = zzek.zzi(bArr, iZzh, zzejVar);
                                                    if (i13 == zzejVar.zza) {
                                                        iZzh = zzek.zzl(bArr, iZzi3, zzejVar);
                                                        zzgpVar.zzf(zzejVar.zzb);
                                                    }
                                                }
                                            }
                                            str = str2;
                                            zzheVar5 = zzheVar4;
                                            iZzh = i36;
                                            if (iZzh != i36) {
                                                i3 = i3;
                                                obj2 = obj5;
                                                i11 = i13 == true ? 1 : 0;
                                                i6 = iZzh;
                                                zzheVar7 = zzheVar5;
                                                i9 = i64;
                                                unsafe = unsafe4;
                                            } else {
                                                i3 = i3;
                                                i66 = i13 == true ? 1 : 0;
                                                i2 = i35;
                                                zzheVar7 = zzheVar5;
                                                i65 = i10;
                                                i67 = i7;
                                                i64 = i64;
                                                i68 = i8;
                                                unsafe5 = unsafe4;
                                            }
                                        } else {
                                            int i80 = zzek.zza;
                                            zzgpVar2 = (zzgp) zzfzVar2;
                                            iZzh = zzek.zzi(bArr, i36, zzejVar);
                                            i41 = zzejVar.zza + iZzh;
                                            while (iZzh < i41) {
                                                iZzh = zzek.zzl(bArr, iZzh, zzejVar);
                                                zzgpVar2.zzf(zzejVar.zzb);
                                            }
                                            if (iZzh != i41) {
                                                throw new zzgc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        str = str2;
                                        zzheVar5 = zzheVar4;
                                        if (iZzh != i36) {
                                            i3 = i3;
                                            obj2 = obj5;
                                            i11 = i13 == true ? 1 : 0;
                                            i6 = iZzh;
                                            zzheVar7 = zzheVar5;
                                            i9 = i64;
                                            unsafe = unsafe4;
                                        } else {
                                            i3 = i3;
                                            i66 = i13 == true ? 1 : 0;
                                            i2 = i35;
                                            zzheVar7 = zzheVar5;
                                            i65 = i10;
                                            i67 = i7;
                                            i64 = i64;
                                            i68 = i8;
                                            unsafe5 = unsafe4;
                                        }
                                        break;
                                    case 22:
                                    case 29:
                                    case 39:
                                    case 43:
                                        zzheVar4 = this;
                                        i35 = i2;
                                        unsafe4 = unsafe5;
                                        i36 = i27;
                                        str2 = str;
                                        if (i12 == 2) {
                                            iZzh = zzek.zzf(bArr, i36, zzfzVar2, zzejVar);
                                            str = str2;
                                            zzheVar5 = zzheVar4;
                                        } else if (i12 == 0) {
                                            iZzh = zzek.zzk(i13 == true ? 1 : 0, bArr, i36, i2, zzfzVar2, zzejVar);
                                            str = str2;
                                            zzheVar5 = zzheVar4;
                                        } else {
                                            str = str2;
                                            zzheVar5 = zzheVar4;
                                            iZzh = i36;
                                        }
                                        if (iZzh != i36) {
                                            i3 = i3;
                                            obj2 = obj5;
                                            i11 = i13 == true ? 1 : 0;
                                            i6 = iZzh;
                                            zzheVar7 = zzheVar5;
                                            i9 = i64;
                                            unsafe = unsafe4;
                                        } else {
                                            i3 = i3;
                                            i66 = i13 == true ? 1 : 0;
                                            i2 = i35;
                                            zzheVar7 = zzheVar5;
                                            i65 = i10;
                                            i67 = i7;
                                            i64 = i64;
                                            i68 = i8;
                                            unsafe5 = unsafe4;
                                        }
                                        break;
                                    case 23:
                                    case 32:
                                    case 40:
                                    case 46:
                                        zzheVar4 = this;
                                        i35 = i2;
                                        unsafe4 = unsafe5;
                                        i36 = i27;
                                        str2 = str;
                                        if (i12 == 2) {
                                            if (i12 == 1) {
                                                iZzh = i36 + 8;
                                                int i81 = zzek.zza;
                                                zzgpVar3 = (zzgp) zzfzVar2;
                                                zzgpVar3.zzf(zzek.zzp(bArr, i36));
                                                while (iZzh < i35) {
                                                    iZzi4 = zzek.zzi(bArr, iZzh, zzejVar);
                                                    if (i13 == zzejVar.zza) {
                                                        zzgpVar3.zzf(zzek.zzp(bArr, iZzi4));
                                                        iZzh = iZzi4 + 8;
                                                    }
                                                }
                                            }
                                            str = str2;
                                            zzheVar5 = zzheVar4;
                                            iZzh = i36;
                                            if (iZzh != i36) {
                                                i3 = i3;
                                                obj2 = obj5;
                                                i11 = i13 == true ? 1 : 0;
                                                i6 = iZzh;
                                                zzheVar7 = zzheVar5;
                                                i9 = i64;
                                                unsafe = unsafe4;
                                            } else {
                                                i3 = i3;
                                                i66 = i13 == true ? 1 : 0;
                                                i2 = i35;
                                                zzheVar7 = zzheVar5;
                                                i65 = i10;
                                                i67 = i7;
                                                i64 = i64;
                                                i68 = i8;
                                                unsafe5 = unsafe4;
                                            }
                                        } else {
                                            int i82 = zzek.zza;
                                            zzgpVar4 = (zzgp) zzfzVar2;
                                            iZzh = zzek.zzi(bArr, i36, zzejVar);
                                            i42 = zzejVar.zza;
                                            i43 = iZzh + i42;
                                            if (i43 <= bArr.length) {
                                                throw new zzgc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            zzgpVar4.zzg(zzgpVar4.size() + (i42 / 8));
                                            while (iZzh < i43) {
                                                zzgpVar4.zzf(zzek.zzp(bArr, iZzh));
                                                iZzh += 8;
                                            }
                                            if (iZzh != i43) {
                                                throw new zzgc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        str = str2;
                                        zzheVar5 = zzheVar4;
                                        if (iZzh != i36) {
                                            i3 = i3;
                                            obj2 = obj5;
                                            i11 = i13 == true ? 1 : 0;
                                            i6 = iZzh;
                                            zzheVar7 = zzheVar5;
                                            i9 = i64;
                                            unsafe = unsafe4;
                                        } else {
                                            i3 = i3;
                                            i66 = i13 == true ? 1 : 0;
                                            i2 = i35;
                                            zzheVar7 = zzheVar5;
                                            i65 = i10;
                                            i67 = i7;
                                            i64 = i64;
                                            i68 = i8;
                                            unsafe5 = unsafe4;
                                        }
                                        break;
                                    case 24:
                                    case 31:
                                    case 41:
                                    case 45:
                                        zzheVar4 = this;
                                        i35 = i2;
                                        unsafe4 = unsafe5;
                                        i36 = i27;
                                        str2 = str;
                                        if (i12 == 2) {
                                            if (i12 == 5) {
                                                iZzh = i36 + 4;
                                                int i83 = zzek.zza;
                                                zzfvVar = (zzfv) zzfzVar2;
                                                zzfvVar.zzg(zzek.zzb(bArr, i36));
                                                while (iZzh < i35) {
                                                    iZzi5 = zzek.zzi(bArr, iZzh, zzejVar);
                                                    if (i13 == zzejVar.zza) {
                                                        zzfvVar.zzg(zzek.zzb(bArr, iZzi5));
                                                        iZzh = iZzi5 + 4;
                                                    }
                                                }
                                            }
                                            str = str2;
                                            zzheVar5 = zzheVar4;
                                            iZzh = i36;
                                            if (iZzh != i36) {
                                                i3 = i3;
                                                obj2 = obj5;
                                                i11 = i13 == true ? 1 : 0;
                                                i6 = iZzh;
                                                zzheVar7 = zzheVar5;
                                                i9 = i64;
                                                unsafe = unsafe4;
                                            } else {
                                                i3 = i3;
                                                i66 = i13 == true ? 1 : 0;
                                                i2 = i35;
                                                zzheVar7 = zzheVar5;
                                                i65 = i10;
                                                i67 = i7;
                                                i64 = i64;
                                                i68 = i8;
                                                unsafe5 = unsafe4;
                                            }
                                        } else {
                                            int i84 = zzek.zza;
                                            zzfvVar2 = (zzfv) zzfzVar2;
                                            iZzh = zzek.zzi(bArr, i36, zzejVar);
                                            i44 = zzejVar.zza;
                                            i45 = iZzh + i44;
                                            if (i45 <= bArr.length) {
                                                throw new zzgc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            zzfvVar2.zzh(zzfvVar2.size() + (i44 / 4));
                                            while (iZzh < i45) {
                                                zzfvVar2.zzg(zzek.zzb(bArr, iZzh));
                                                iZzh += 4;
                                            }
                                            if (iZzh != i45) {
                                                throw new zzgc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        str = str2;
                                        zzheVar5 = zzheVar4;
                                        if (iZzh != i36) {
                                            i3 = i3;
                                            obj2 = obj5;
                                            i11 = i13 == true ? 1 : 0;
                                            i6 = iZzh;
                                            zzheVar7 = zzheVar5;
                                            i9 = i64;
                                            unsafe = unsafe4;
                                        } else {
                                            i3 = i3;
                                            i66 = i13 == true ? 1 : 0;
                                            i2 = i35;
                                            zzheVar7 = zzheVar5;
                                            i65 = i10;
                                            i67 = i7;
                                            i64 = i64;
                                            i68 = i8;
                                            unsafe5 = unsafe4;
                                        }
                                        break;
                                    case 25:
                                    case 42:
                                        zzheVar4 = this;
                                        i35 = i2;
                                        unsafe4 = unsafe5;
                                        i36 = i27;
                                        str2 = str;
                                        if (i12 == 2) {
                                            if (i12 == 0) {
                                                int i85 = zzek.zza;
                                                zzelVar = (zzel) zzfzVar2;
                                                iZzh = zzek.zzl(bArr, i36, zzejVar);
                                                if (zzejVar.zzb != 0) {
                                                    z3 = true;
                                                } else {
                                                    z3 = false;
                                                }
                                                zzelVar.zze(z3);
                                                while (iZzh < i35) {
                                                    iZzi6 = zzek.zzi(bArr, iZzh, zzejVar);
                                                    if (i13 == zzejVar.zza) {
                                                        iZzh = zzek.zzl(bArr, iZzi6, zzejVar);
                                                        if (zzejVar.zzb != 0) {
                                                            z4 = true;
                                                        } else {
                                                            z4 = false;
                                                        }
                                                        zzelVar.zze(z4);
                                                    }
                                                }
                                            }
                                            str = str2;
                                            zzheVar5 = zzheVar4;
                                            iZzh = i36;
                                            if (iZzh != i36) {
                                                i3 = i3;
                                                obj2 = obj5;
                                                i11 = i13 == true ? 1 : 0;
                                                i6 = iZzh;
                                                zzheVar7 = zzheVar5;
                                                i9 = i64;
                                                unsafe = unsafe4;
                                            } else {
                                                i3 = i3;
                                                i66 = i13 == true ? 1 : 0;
                                                i2 = i35;
                                                zzheVar7 = zzheVar5;
                                                i65 = i10;
                                                i67 = i7;
                                                i64 = i64;
                                                i68 = i8;
                                                unsafe5 = unsafe4;
                                            }
                                        } else {
                                            int i86 = zzek.zza;
                                            zzelVar2 = (zzel) zzfzVar2;
                                            iZzh = zzek.zzi(bArr, i36, zzejVar);
                                            i46 = zzejVar.zza + iZzh;
                                            while (iZzh < i46) {
                                                iZzh = zzek.zzl(bArr, iZzh, zzejVar);
                                                if (zzejVar.zzb != 0) {
                                                    z5 = true;
                                                } else {
                                                    z5 = false;
                                                }
                                                zzelVar2.zze(z5);
                                            }
                                            if (iZzh != i46) {
                                                throw new zzgc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        str = str2;
                                        zzheVar5 = zzheVar4;
                                        if (iZzh != i36) {
                                            i3 = i3;
                                            obj2 = obj5;
                                            i11 = i13 == true ? 1 : 0;
                                            i6 = iZzh;
                                            zzheVar7 = zzheVar5;
                                            i9 = i64;
                                            unsafe = unsafe4;
                                        } else {
                                            i3 = i3;
                                            i66 = i13 == true ? 1 : 0;
                                            i2 = i35;
                                            zzheVar7 = zzheVar5;
                                            i65 = i10;
                                            i67 = i7;
                                            i64 = i64;
                                            i68 = i8;
                                            unsafe5 = unsafe4;
                                        }
                                        break;
                                    case 26:
                                        zzheVar6 = this;
                                        i35 = i2;
                                        unsafe4 = unsafe5;
                                        i36 = i27;
                                        if (i12 == 2) {
                                            str = str;
                                            zzheVar5 = zzheVar6;
                                            iZzh = i36;
                                            if (iZzh != i36) {
                                                i3 = i3;
                                                obj2 = obj5;
                                                i11 = i13 == true ? 1 : 0;
                                                i6 = iZzh;
                                                zzheVar7 = zzheVar5;
                                                i9 = i64;
                                                unsafe = unsafe4;
                                            } else {
                                                i3 = i3;
                                                i66 = i13 == true ? 1 : 0;
                                                i2 = i35;
                                                zzheVar7 = zzheVar5;
                                                i65 = i10;
                                                i67 = i7;
                                                i64 = i64;
                                                i68 = i8;
                                                unsafe5 = unsafe4;
                                            }
                                        } else {
                                            if ((j3 & 536870912) == 0) {
                                                iZzi7 = zzek.zzi(bArr, i36, zzejVar);
                                                i51 = zzejVar.zza;
                                                if (i51 >= 0) {
                                                    throw new zzgc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                                if (i51 == 0) {
                                                    obj4 = "";
                                                    zzfzVar2.add(obj4);
                                                } else {
                                                    obj4 = 
                                                    /*  JADX ERROR: Method code generation error
                                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x062a: MOVE (r6v64 'obj4' java.lang.Object) = (r6v40 java.lang.Object) in method: com.google.android.gms.internal.play_billing.zzhe.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.play_billing.zzej):int, file: classes3.dex
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                                                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                                                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                        	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:267)
                                                        	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:90)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                        	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:157)
                                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                                                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                                                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                                                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                                                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                        	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:175)
                                                        	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:173)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r6v40 java.lang.Object
                                                        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
                                                        */
                                                    /*
                                                        Method dump skipped, instruction units count: 3840
                                                        To view this dump change 'Code comments level' option to 'DEBUG'
                                                    */
                                                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzhe.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.play_billing.zzej):int");
                                                }

                                                @Override // com.google.android.gms.internal.play_billing.zzhl
                                                public final Object zze() {
                                                    return ((zzfu) this.zzg).zzs();
                                                }

                                                /* JADX WARN: Code duplicated, block: B:26:0x006f  */
                                                /* JADX WARN: Code duplicated, block: B:28:0x0075  */
                                                /* JADX WARN: Code duplicated, block: B:41:0x0082 A[SYNTHETIC] */
                                                @Override // com.google.android.gms.internal.play_billing.zzhl
                                                public final void zzf(Object obj) {
                                                    if (zzL(obj)) {
                                                        if (obj instanceof zzfu) {
                                                            zzfu zzfuVar = (zzfu) obj;
                                                            zzfuVar.zzC(Integer.MAX_VALUE);
                                                            zzfuVar.zza = 0;
                                                            zzfuVar.zzA();
                                                        }
                                                        int[] iArr = this.zzc;
                                                        for (int i = 0; i < iArr.length; i += 3) {
                                                            int iZzs = zzs(i);
                                                            int i2 = 1048575 & iZzs;
                                                            int iZzr = zzr(iZzs);
                                                            long j = i2;
                                                            if (iZzr != 9) {
                                                                if (iZzr != 60 && iZzr != 68) {
                                                                    switch (iZzr) {
                                                                        case 17:
                                                                            if (zzI(obj, i)) {
                                                                                zzv(i).zzf(zzb.getObject(obj, j));
                                                                            }
                                                                            break;
                                                                        case 18:
                                                                        case 19:
                                                                        case 20:
                                                                        case 21:
                                                                        case 22:
                                                                        case 23:
                                                                        case 24:
                                                                        case 25:
                                                                        case 26:
                                                                        case 27:
                                                                        case 28:
                                                                        case 29:
                                                                        case 30:
                                                                        case 31:
                                                                        case 32:
                                                                        case 33:
                                                                        case 34:
                                                                        case 35:
                                                                        case 36:
                                                                        case 37:
                                                                        case 38:
                                                                        case 39:
                                                                        case 40:
                                                                        case 41:
                                                                        case 42:
                                                                        case 43:
                                                                        case 44:
                                                                        case 45:
                                                                        case 46:
                                                                        case 47:
                                                                        case 48:
                                                                        case 49:
                                                                            ((zzfz) zzii.zzf(obj, j)).zzb();
                                                                            break;
                                                                        case 50:
                                                                            Unsafe unsafe = zzb;
                                                                            Object object = unsafe.getObject(obj, j);
                                                                            if (object != null) {
                                                                                ((zzgv) object).zzc();
                                                                                unsafe.putObject(obj, j, object);
                                                                            }
                                                                            break;
                                                                    }
                                                                } else if (zzM(obj, iArr[i], i)) {
                                                                    zzv(i).zzf(zzb.getObject(obj, j));
                                                                }
                                                            } else if (zzI(obj, i)) {
                                                                zzv(i).zzf(zzb.getObject(obj, j));
                                                            }
                                                        }
                                                        this.zzl.zzb(obj);
                                                        if (this.zzh) {
                                                            this.zzm.zza(obj);
                                                        }
                                                    }
                                                }

                                                @Override // com.google.android.gms.internal.play_billing.zzhl
                                                public final void zzg(Object obj, Object obj2) {
                                                    zzA(obj);
                                                    obj2.getClass();
                                                    int i = 0;
                                                    while (true) {
                                                        int[] iArr = this.zzc;
                                                        if (i >= iArr.length) {
                                                            zzhn.zzq(this.zzl, obj, obj2);
                                                            if (this.zzh) {
                                                                zzhn.zzp(this.zzm, obj, obj2);
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        int iZzs = zzs(i);
                                                        int i2 = 1048575 & iZzs;
                                                        int iZzr = zzr(iZzs);
                                                        int i3 = iArr[i];
                                                        long j = i2;
                                                        switch (iZzr) {
                                                            case 0:
                                                                if (zzI(obj2, i)) {
                                                                    zzii.zzo(obj, j, zzii.zza(obj2, j));
                                                                    zzD(obj, i);
                                                                }
                                                                break;
                                                            case 1:
                                                                if (zzI(obj2, i)) {
                                                                    zzii.zzp(obj, j, zzii.zzb(obj2, j));
                                                                    zzD(obj, i);
                                                                }
                                                                break;
                                                            case 2:
                                                                if (zzI(obj2, i)) {
                                                                    zzii.zzr(obj, j, zzii.zzd(obj2, j));
                                                                    zzD(obj, i);
                                                                }
                                                                break;
                                                            case 3:
                                                                if (zzI(obj2, i)) {
                                                                    zzii.zzr(obj, j, zzii.zzd(obj2, j));
                                                                    zzD(obj, i);
                                                                }
                                                                break;
                                                            case 4:
                                                                if (zzI(obj2, i)) {
                                                                    zzii.zzq(obj, j, zzii.zzc(obj2, j));
                                                                    zzD(obj, i);
                                                                }
                                                                break;
                                                            case 5:
                                                                if (zzI(obj2, i)) {
                                                                    zzii.zzr(obj, j, zzii.zzd(obj2, j));
                                                                    zzD(obj, i);
                                                                }
                                                                break;
                                                            case 6:
                                                                if (zzI(obj2, i)) {
                                                                    zzii.zzq(obj, j, zzii.zzc(obj2, j));
                                                                    zzD(obj, i);
                                                                }
                                                                break;
                                                            case 7:
                                                                if (zzI(obj2, i)) {
                                                                    zzii.zzm(obj, j, zzii.zzw(obj2, j));
                                                                    zzD(obj, i);
                                                                }
                                                                break;
                                                            case 8:
                                                                if (zzI(obj2, i)) {
                                                                    zzii.zzs(obj, j, zzii.zzf(obj2, j));
                                                                    zzD(obj, i);
                                                                }
                                                                break;
                                                            case 9:
                                                                zzB(obj, obj2, i);
                                                                break;
                                                            case 10:
                                                                if (zzI(obj2, i)) {
                                                                    zzii.zzs(obj, j, zzii.zzf(obj2, j));
                                                                    zzD(obj, i);
                                                                }
                                                                break;
                                                            case 11:
                                                                if (zzI(obj2, i)) {
                                                                    zzii.zzq(obj, j, zzii.zzc(obj2, j));
                                                                    zzD(obj, i);
                                                                }
                                                                break;
                                                            case 12:
                                                                if (zzI(obj2, i)) {
                                                                    zzii.zzq(obj, j, zzii.zzc(obj2, j));
                                                                    zzD(obj, i);
                                                                }
                                                                break;
                                                            case 13:
                                                                if (zzI(obj2, i)) {
                                                                    zzii.zzq(obj, j, zzii.zzc(obj2, j));
                                                                    zzD(obj, i);
                                                                }
                                                                break;
                                                            case 14:
                                                                if (zzI(obj2, i)) {
                                                                    zzii.zzr(obj, j, zzii.zzd(obj2, j));
                                                                    zzD(obj, i);
                                                                }
                                                                break;
                                                            case 15:
                                                                if (zzI(obj2, i)) {
                                                                    zzii.zzq(obj, j, zzii.zzc(obj2, j));
                                                                    zzD(obj, i);
                                                                }
                                                                break;
                                                            case 16:
                                                                if (zzI(obj2, i)) {
                                                                    zzii.zzr(obj, j, zzii.zzd(obj2, j));
                                                                    zzD(obj, i);
                                                                }
                                                                break;
                                                            case 17:
                                                                zzB(obj, obj2, i);
                                                                break;
                                                            case 18:
                                                            case 19:
                                                            case 20:
                                                            case 21:
                                                            case 22:
                                                            case 23:
                                                            case 24:
                                                            case 25:
                                                            case 26:
                                                            case 27:
                                                            case 28:
                                                            case 29:
                                                            case 30:
                                                            case 31:
                                                            case 32:
                                                            case 33:
                                                            case 34:
                                                            case 35:
                                                            case 36:
                                                            case 37:
                                                            case 38:
                                                            case 39:
                                                            case 40:
                                                            case 41:
                                                            case 42:
                                                            case 43:
                                                            case 44:
                                                            case 45:
                                                            case 46:
                                                            case 47:
                                                            case 48:
                                                            case 49:
                                                                zzfz zzfzVarZzd = (zzfz) zzii.zzf(obj, j);
                                                                zzfz zzfzVar = (zzfz) zzii.zzf(obj2, j);
                                                                int size = zzfzVarZzd.size();
                                                                int size2 = zzfzVar.size();
                                                                if (size > 0 && size2 > 0) {
                                                                    if (!zzfzVarZzd.zzc()) {
                                                                        zzfzVarZzd = zzfzVarZzd.zzd(size2 + size);
                                                                    }
                                                                    zzfzVarZzd.addAll(zzfzVar);
                                                                }
                                                                if (size > 0) {
                                                                    zzfzVar = zzfzVarZzd;
                                                                }
                                                                zzii.zzs(obj, j, zzfzVar);
                                                                break;
                                                            case 50:
                                                                int i4 = zzhn.zza;
                                                                zzii.zzs(obj, j, zzgw.zza(zzii.zzf(obj, j), zzii.zzf(obj2, j)));
                                                                break;
                                                            case 51:
                                                            case 52:
                                                            case 53:
                                                            case 54:
                                                            case 55:
                                                            case 56:
                                                            case 57:
                                                            case 58:
                                                            case 59:
                                                                if (zzM(obj2, i3, i)) {
                                                                    zzii.zzs(obj, j, zzii.zzf(obj2, j));
                                                                    zzE(obj, i3, i);
                                                                }
                                                                break;
                                                            case 60:
                                                                zzC(obj, obj2, i);
                                                                break;
                                                            case 61:
                                                            case 62:
                                                            case 63:
                                                            case 64:
                                                            case 65:
                                                            case 66:
                                                            case 67:
                                                                if (zzM(obj2, i3, i)) {
                                                                    zzii.zzs(obj, j, zzii.zzf(obj2, j));
                                                                    zzE(obj, i3, i);
                                                                }
                                                                break;
                                                            case 68:
                                                                zzC(obj, obj2, i);
                                                                break;
                                                        }
                                                        i += 3;
                                                    }
                                                }

                                                @Override // com.google.android.gms.internal.play_billing.zzhl
                                                public final void zzh(Object obj, byte[] bArr, int i, int i2, zzej zzejVar) throws IOException {
                                                    zzc(obj, bArr, i, i2, 0, zzejVar);
                                                }

                                                /* JADX WARN: Code duplicated, block: B:7:0x0023  */
                                                @Override // com.google.android.gms.internal.play_billing.zzhl
                                                public final void zzi(Object obj, zzit zzitVar) throws IOException {
                                                    Map.Entry entry;
                                                    int i;
                                                    int i2;
                                                    int i3;
                                                    Map.Entry entry2;
                                                    if (this.zzh) {
                                                        zzfm zzfmVar = ((zzfr) obj).zzb;
                                                        if (zzfmVar.zza.isEmpty()) {
                                                            entry = null;
                                                        } else {
                                                            entry = (Map.Entry) zzfmVar.zzf().next();
                                                        }
                                                    } else {
                                                        entry = null;
                                                    }
                                                    int[] iArr = this.zzc;
                                                    Unsafe unsafe = zzb;
                                                    int i4 = 1048575;
                                                    int i5 = 1048575;
                                                    int i6 = 0;
                                                    int i7 = 0;
                                                    while (i7 < iArr.length) {
                                                        int iZzs = zzs(i7);
                                                        int iZzr = zzr(iZzs);
                                                        int i8 = iArr[i7];
                                                        if (iZzr <= 17) {
                                                            int i9 = iArr[i7 + 2];
                                                            int i10 = i9 & i4;
                                                            if (i10 != i5) {
                                                                i6 = i10 == i4 ? 0 : unsafe.getInt(obj, i10);
                                                                i5 = i10;
                                                            }
                                                            i = i5;
                                                            i2 = i6;
                                                            i3 = 1 << (i9 >>> 20);
                                                        } else {
                                                            i = i5;
                                                            i2 = i6;
                                                            i3 = 0;
                                                        }
                                                        if (entry != null) {
                                                            throw null;
                                                        }
                                                        long j = iZzs & i4;
                                                        switch (iZzr) {
                                                            case 0:
                                                                entry2 = entry;
                                                                if (zzJ(obj, i7, i, i2, i3)) {
                                                                    zzitVar.zzf(i8, zzii.zza(obj, j));
                                                                    continue;
                                                                }
                                                                i7 += 3;
                                                                i5 = i;
                                                                entry = entry2;
                                                                i6 = i2;
                                                                i4 = 1048575;
                                                                break;
                                                            case 1:
                                                                entry2 = entry;
                                                                if (zzJ(obj, i7, i, i2, i3)) {
                                                                    zzitVar.zzo(i8, zzii.zzb(obj, j));
                                                                } else {
                                                                    continue;
                                                                }
                                                                i7 += 3;
                                                                i5 = i;
                                                                entry = entry2;
                                                                i6 = i2;
                                                                i4 = 1048575;
                                                                break;
                                                            case 2:
                                                                entry2 = entry;
                                                                if (zzJ(obj, i7, i, i2, i3)) {
                                                                    zzitVar.zzt(i8, unsafe.getLong(obj, j));
                                                                } else {
                                                                    continue;
                                                                }
                                                                i7 += 3;
                                                                i5 = i;
                                                                entry = entry2;
                                                                i6 = i2;
                                                                i4 = 1048575;
                                                                break;
                                                            case 3:
                                                                entry2 = entry;
                                                                if (zzJ(obj, i7, i, i2, i3)) {
                                                                    zzitVar.zzL(i8, unsafe.getLong(obj, j));
                                                                } else {
                                                                    continue;
                                                                }
                                                                i7 += 3;
                                                                i5 = i;
                                                                entry = entry2;
                                                                i6 = i2;
                                                                i4 = 1048575;
                                                                break;
                                                            case 4:
                                                                entry2 = entry;
                                                                if (zzJ(obj, i7, i, i2, i3)) {
                                                                    zzitVar.zzr(i8, unsafe.getInt(obj, j));
                                                                } else {
                                                                    continue;
                                                                }
                                                                i7 += 3;
                                                                i5 = i;
                                                                entry = entry2;
                                                                i6 = i2;
                                                                i4 = 1048575;
                                                                break;
                                                            case 5:
                                                                entry2 = entry;
                                                                if (zzJ(obj, i7, i, i2, i3)) {
                                                                    zzitVar.zzm(i8, unsafe.getLong(obj, j));
                                                                } else {
                                                                    continue;
                                                                }
                                                                i7 += 3;
                                                                i5 = i;
                                                                entry = entry2;
                                                                i6 = i2;
                                                                i4 = 1048575;
                                                                break;
                                                            case 6:
                                                                entry2 = entry;
                                                                if (zzJ(obj, i7, i, i2, i3)) {
                                                                    zzitVar.zzk(i8, unsafe.getInt(obj, j));
                                                                } else {
                                                                    continue;
                                                                }
                                                                i7 += 3;
                                                                i5 = i;
                                                                entry = entry2;
                                                                i6 = i2;
                                                                i4 = 1048575;
                                                                break;
                                                            case 7:
                                                                entry2 = entry;
                                                                if (zzJ(obj, i7, i, i2, i3)) {
                                                                    zzitVar.zzb(i8, zzii.zzw(obj, j));
                                                                } else {
                                                                    continue;
                                                                }
                                                                i7 += 3;
                                                                i5 = i;
                                                                entry = entry2;
                                                                i6 = i2;
                                                                i4 = 1048575;
                                                                break;
                                                            case 8:
                                                                entry2 = entry;
                                                                if (zzJ(obj, i7, i, i2, i3)) {
                                                                    zzP(i8, unsafe.getObject(obj, j), zzitVar);
                                                                } else {
                                                                    continue;
                                                                }
                                                                i7 += 3;
                                                                i5 = i;
                                                                entry = entry2;
                                                                i6 = i2;
                                                                i4 = 1048575;
                                                                break;
                                                            case 9:
                                                                entry2 = entry;
                                                                if (zzJ(obj, i7, i, i2, i3)) {
                                                                    zzitVar.zzw(i8, unsafe.getObject(obj, j), zzv(i7));
                                                                } else {
                                                                    continue;
                                                                }
                                                                i7 += 3;
                                                                i5 = i;
                                                                entry = entry2;
                                                                i6 = i2;
                                                                i4 = 1048575;
                                                                break;
                                                            case 10:
                                                                entry2 = entry;
                                                                if (zzJ(obj, i7, i, i2, i3)) {
                                                                    zzitVar.zzd(i8, (zzev) unsafe.getObject(obj, j));
                                                                } else {
                                                                    continue;
                                                                }
                                                                i7 += 3;
                                                                i5 = i;
                                                                entry = entry2;
                                                                i6 = i2;
                                                                i4 = 1048575;
                                                                break;
                                                            case 11:
                                                                entry2 = entry;
                                                                if (zzJ(obj, i7, i, i2, i3)) {
                                                                    zzitVar.zzJ(i8, unsafe.getInt(obj, j));
                                                                } else {
                                                                    continue;
                                                                }
                                                                i7 += 3;
                                                                i5 = i;
                                                                entry = entry2;
                                                                i6 = i2;
                                                                i4 = 1048575;
                                                                break;
                                                            case 12:
                                                                entry2 = entry;
                                                                if (zzJ(obj, i7, i, i2, i3)) {
                                                                    zzitVar.zzi(i8, unsafe.getInt(obj, j));
                                                                } else {
                                                                    continue;
                                                                }
                                                                i7 += 3;
                                                                i5 = i;
                                                                entry = entry2;
                                                                i6 = i2;
                                                                i4 = 1048575;
                                                                break;
                                                            case 13:
                                                                entry2 = entry;
                                                                if (zzJ(obj, i7, i, i2, i3)) {
                                                                    zzitVar.zzy(i8, unsafe.getInt(obj, j));
                                                                } else {
                                                                    continue;
                                                                }
                                                                i7 += 3;
                                                                i5 = i;
                                                                entry = entry2;
                                                                i6 = i2;
                                                                i4 = 1048575;
                                                                break;
                                                            case 14:
                                                                entry2 = entry;
                                                                if (zzJ(obj, i7, i, i2, i3)) {
                                                                    zzitVar.zzA(i8, unsafe.getLong(obj, j));
                                                                } else {
                                                                    continue;
                                                                }
                                                                i7 += 3;
                                                                i5 = i;
                                                                entry = entry2;
                                                                i6 = i2;
                                                                i4 = 1048575;
                                                                break;
                                                            case 15:
                                                                entry2 = entry;
                                                                if (zzJ(obj, i7, i, i2, i3)) {
                                                                    zzitVar.zzC(i8, unsafe.getInt(obj, j));
                                                                } else {
                                                                    continue;
                                                                }
                                                                i7 += 3;
                                                                i5 = i;
                                                                entry = entry2;
                                                                i6 = i2;
                                                                i4 = 1048575;
                                                                break;
                                                            case 16:
                                                                entry2 = entry;
                                                                if (zzJ(obj, i7, i, i2, i3)) {
                                                                    zzitVar.zzE(i8, unsafe.getLong(obj, j));
                                                                } else {
                                                                    continue;
                                                                }
                                                                i7 += 3;
                                                                i5 = i;
                                                                entry = entry2;
                                                                i6 = i2;
                                                                i4 = 1048575;
                                                                break;
                                                            case 17:
                                                                entry2 = entry;
                                                                if (zzJ(obj, i7, i, i2, i3)) {
                                                                    zzitVar.zzq(i8, unsafe.getObject(obj, j), zzv(i7));
                                                                } else {
                                                                    continue;
                                                                }
                                                                i7 += 3;
                                                                i5 = i;
                                                                entry = entry2;
                                                                i6 = i2;
                                                                i4 = 1048575;
                                                                break;
                                                            case 18:
                                                                zzhn.zzs(iArr[i7], (List) unsafe.getObject(obj, j), zzitVar, false);
                                                                break;
                                                            case 19:
                                                                zzhn.zzw(iArr[i7], (List) unsafe.getObject(obj, j), zzitVar, false);
                                                                break;
                                                            case 20:
                                                                zzhn.zzy(iArr[i7], (List) unsafe.getObject(obj, j), zzitVar, false);
                                                                break;
                                                            case 21:
                                                                zzhn.zzE(iArr[i7], (List) unsafe.getObject(obj, j), zzitVar, false);
                                                                break;
                                                            case 22:
                                                                zzhn.zzx(iArr[i7], (List) unsafe.getObject(obj, j), zzitVar, false);
                                                                break;
                                                            case 23:
                                                                zzhn.zzv(iArr[i7], (List) unsafe.getObject(obj, j), zzitVar, false);
                                                                break;
                                                            case 24:
                                                                zzhn.zzu(iArr[i7], (List) unsafe.getObject(obj, j), zzitVar, false);
                                                                break;
                                                            case 25:
                                                                zzhn.zzr(iArr[i7], (List) unsafe.getObject(obj, j), zzitVar, false);
                                                                break;
                                                            case 26:
                                                                int i11 = iArr[i7];
                                                                List list = (List) unsafe.getObject(obj, j);
                                                                int i12 = zzhn.zza;
                                                                if (list != null && !list.isEmpty()) {
                                                                    zzitVar.zzI(i11, list);
                                                                }
                                                                break;
                                                            case 27:
                                                                int i13 = iArr[i7];
                                                                List list2 = (List) unsafe.getObject(obj, j);
                                                                zzhl zzhlVarZzv = zzv(i7);
                                                                int i14 = zzhn.zza;
                                                                if (list2 != null && !list2.isEmpty()) {
                                                                    for (int i15 = 0; i15 < list2.size(); i15++) {
                                                                        ((zzfd) zzitVar).zzw(i13, list2.get(i15), zzhlVarZzv);
                                                                    }
                                                                }
                                                                break;
                                                            case 28:
                                                                int i16 = iArr[i7];
                                                                List list3 = (List) unsafe.getObject(obj, j);
                                                                int i17 = zzhn.zza;
                                                                if (list3 != null && !list3.isEmpty()) {
                                                                    zzitVar.zze(i16, list3);
                                                                }
                                                                break;
                                                            case 29:
                                                                zzhn.zzD(iArr[i7], (List) unsafe.getObject(obj, j), zzitVar, false);
                                                                break;
                                                            case 30:
                                                                zzhn.zzt(iArr[i7], (List) unsafe.getObject(obj, j), zzitVar, false);
                                                                break;
                                                            case 31:
                                                                zzhn.zzz(iArr[i7], (List) unsafe.getObject(obj, j), zzitVar, false);
                                                                break;
                                                            case 32:
                                                                zzhn.zzA(iArr[i7], (List) unsafe.getObject(obj, j), zzitVar, false);
                                                                break;
                                                            case 33:
                                                                zzhn.zzB(iArr[i7], (List) unsafe.getObject(obj, j), zzitVar, false);
                                                                break;
                                                            case 34:
                                                                zzhn.zzC(iArr[i7], (List) unsafe.getObject(obj, j), zzitVar, false);
                                                                break;
                                                            case 35:
                                                                zzhn.zzs(iArr[i7], (List) unsafe.getObject(obj, j), zzitVar, true);
                                                                break;
                                                            case 36:
                                                                zzhn.zzw(iArr[i7], (List) unsafe.getObject(obj, j), zzitVar, true);
                                                                break;
                                                            case 37:
                                                                zzhn.zzy(iArr[i7], (List) unsafe.getObject(obj, j), zzitVar, true);
                                                                break;
                                                            case 38:
                                                                zzhn.zzE(iArr[i7], (List) unsafe.getObject(obj, j), zzitVar, true);
                                                                break;
                                                            case 39:
                                                                zzhn.zzx(iArr[i7], (List) unsafe.getObject(obj, j), zzitVar, true);
                                                                break;
                                                            case 40:
                                                                zzhn.zzv(iArr[i7], (List) unsafe.getObject(obj, j), zzitVar, true);
                                                                break;
                                                            case 41:
                                                                zzhn.zzu(iArr[i7], (List) unsafe.getObject(obj, j), zzitVar, true);
                                                                break;
                                                            case 42:
                                                                zzhn.zzr(iArr[i7], (List) unsafe.getObject(obj, j), zzitVar, true);
                                                                break;
                                                            case 43:
                                                                zzhn.zzD(iArr[i7], (List) unsafe.getObject(obj, j), zzitVar, true);
                                                                break;
                                                            case 44:
                                                                zzhn.zzt(iArr[i7], (List) unsafe.getObject(obj, j), zzitVar, true);
                                                                break;
                                                            case 45:
                                                                zzhn.zzz(iArr[i7], (List) unsafe.getObject(obj, j), zzitVar, true);
                                                                break;
                                                            case 46:
                                                                zzhn.zzA(iArr[i7], (List) unsafe.getObject(obj, j), zzitVar, true);
                                                                break;
                                                            case 47:
                                                                zzhn.zzB(iArr[i7], (List) unsafe.getObject(obj, j), zzitVar, true);
                                                                break;
                                                            case 48:
                                                                zzhn.zzC(iArr[i7], (List) unsafe.getObject(obj, j), zzitVar, true);
                                                                break;
                                                            case 49:
                                                                int i18 = iArr[i7];
                                                                List list4 = (List) unsafe.getObject(obj, j);
                                                                zzhl zzhlVarZzv2 = zzv(i7);
                                                                int i19 = zzhn.zza;
                                                                if (list4 != null && !list4.isEmpty()) {
                                                                    for (int i20 = 0; i20 < list4.size(); i20++) {
                                                                        ((zzfd) zzitVar).zzq(i18, list4.get(i20), zzhlVarZzv2);
                                                                    }
                                                                }
                                                                break;
                                                            case 50:
                                                                Object object = unsafe.getObject(obj, j);
                                                                if (object != null) {
                                                                    zzitVar.zzv(i8, ((zzgu) zzw(i7)).zzc(), (zzgv) object);
                                                                }
                                                                break;
                                                            case 51:
                                                                if (zzM(obj, i8, i7)) {
                                                                    zzitVar.zzf(i8, zzm(obj, j));
                                                                }
                                                                break;
                                                            case 52:
                                                                if (zzM(obj, i8, i7)) {
                                                                    zzitVar.zzo(i8, zzn(obj, j));
                                                                }
                                                                break;
                                                            case 53:
                                                                if (zzM(obj, i8, i7)) {
                                                                    zzitVar.zzt(i8, zzt(obj, j));
                                                                }
                                                                break;
                                                            case 54:
                                                                if (zzM(obj, i8, i7)) {
                                                                    zzitVar.zzL(i8, zzt(obj, j));
                                                                }
                                                                break;
                                                            case 55:
                                                                if (zzM(obj, i8, i7)) {
                                                                    zzitVar.zzr(i8, zzo(obj, j));
                                                                }
                                                                break;
                                                            case 56:
                                                                if (zzM(obj, i8, i7)) {
                                                                    zzitVar.zzm(i8, zzt(obj, j));
                                                                }
                                                                break;
                                                            case 57:
                                                                if (zzM(obj, i8, i7)) {
                                                                    zzitVar.zzk(i8, zzo(obj, j));
                                                                }
                                                                break;
                                                            case 58:
                                                                if (zzM(obj, i8, i7)) {
                                                                    zzitVar.zzb(i8, zzN(obj, j));
                                                                }
                                                                break;
                                                            case 59:
                                                                if (zzM(obj, i8, i7)) {
                                                                    zzP(i8, unsafe.getObject(obj, j), zzitVar);
                                                                }
                                                                break;
                                                            case 60:
                                                                if (zzM(obj, i8, i7)) {
                                                                    zzitVar.zzw(i8, unsafe.getObject(obj, j), zzv(i7));
                                                                }
                                                                break;
                                                            case 61:
                                                                if (zzM(obj, i8, i7)) {
                                                                    zzitVar.zzd(i8, (zzev) unsafe.getObject(obj, j));
                                                                }
                                                                break;
                                                            case 62:
                                                                if (zzM(obj, i8, i7)) {
                                                                    zzitVar.zzJ(i8, zzo(obj, j));
                                                                }
                                                                break;
                                                            case 63:
                                                                if (zzM(obj, i8, i7)) {
                                                                    zzitVar.zzi(i8, zzo(obj, j));
                                                                }
                                                                break;
                                                            case 64:
                                                                if (zzM(obj, i8, i7)) {
                                                                    zzitVar.zzy(i8, zzo(obj, j));
                                                                }
                                                                break;
                                                            case 65:
                                                                if (zzM(obj, i8, i7)) {
                                                                    zzitVar.zzA(i8, zzt(obj, j));
                                                                }
                                                                break;
                                                            case 66:
                                                                if (zzM(obj, i8, i7)) {
                                                                    zzitVar.zzC(i8, zzo(obj, j));
                                                                }
                                                                break;
                                                            case 67:
                                                                if (zzM(obj, i8, i7)) {
                                                                    zzitVar.zzE(i8, zzt(obj, j));
                                                                }
                                                                break;
                                                            case 68:
                                                                if (zzM(obj, i8, i7)) {
                                                                    zzitVar.zzq(i8, unsafe.getObject(obj, j), zzv(i7));
                                                                }
                                                                break;
                                                        }
                                                        entry2 = entry;
                                                        i7 += 3;
                                                        i5 = i;
                                                        entry = entry2;
                                                        i6 = i2;
                                                        i4 = 1048575;
                                                    }
                                                    Map.Entry entry3 = entry;
                                                    if (entry3 != null) {
                                                        throw null;
                                                    }
                                                    ((zzfu) obj).zzc.zzl(zzitVar);
                                                }

                                                @Override // com.google.android.gms.internal.play_billing.zzhl
                                                public final boolean zzj(Object obj, Object obj2) {
                                                    boolean zZzF;
                                                    for (int i = 0; i < this.zzc.length; i += 3) {
                                                        int iZzs = zzs(i);
                                                        long j = iZzs & 1048575;
                                                        switch (zzr(iZzs)) {
                                                            case 0:
                                                                if (!zzH(obj, obj2, i) || Double.doubleToLongBits(zzii.zza(obj, j)) != Double.doubleToLongBits(zzii.zza(obj2, j))) {
                                                                    return false;
                                                                }
                                                                continue;
                                                                break;
                                                                break;
                                                            case 1:
                                                                if (!zzH(obj, obj2, i) || Float.floatToIntBits(zzii.zzb(obj, j)) != Float.floatToIntBits(zzii.zzb(obj2, j))) {
                                                                    return false;
                                                                }
                                                                continue;
                                                                break;
                                                                break;
                                                            case 2:
                                                                if (!zzH(obj, obj2, i) || zzii.zzd(obj, j) != zzii.zzd(obj2, j)) {
                                                                    return false;
                                                                }
                                                                continue;
                                                                break;
                                                                break;
                                                            case 3:
                                                                if (!zzH(obj, obj2, i) || zzii.zzd(obj, j) != zzii.zzd(obj2, j)) {
                                                                    return false;
                                                                }
                                                                continue;
                                                                break;
                                                                break;
                                                            case 4:
                                                                if (!zzH(obj, obj2, i) || zzii.zzc(obj, j) != zzii.zzc(obj2, j)) {
                                                                    return false;
                                                                }
                                                                continue;
                                                                break;
                                                                break;
                                                            case 5:
                                                                if (!zzH(obj, obj2, i) || zzii.zzd(obj, j) != zzii.zzd(obj2, j)) {
                                                                    return false;
                                                                }
                                                                continue;
                                                                break;
                                                                break;
                                                            case 6:
                                                                if (!zzH(obj, obj2, i) || zzii.zzc(obj, j) != zzii.zzc(obj2, j)) {
                                                                    return false;
                                                                }
                                                                continue;
                                                                break;
                                                                break;
                                                            case 7:
                                                                if (!zzH(obj, obj2, i) || zzii.zzw(obj, j) != zzii.zzw(obj2, j)) {
                                                                    return false;
                                                                }
                                                                continue;
                                                                break;
                                                                break;
                                                            case 8:
                                                                if (!zzH(obj, obj2, i) || !zzhn.zzF(zzii.zzf(obj, j), zzii.zzf(obj2, j))) {
                                                                    return false;
                                                                }
                                                                continue;
                                                                break;
                                                                break;
                                                            case 9:
                                                                if (!zzH(obj, obj2, i) || !zzhn.zzF(zzii.zzf(obj, j), zzii.zzf(obj2, j))) {
                                                                    return false;
                                                                }
                                                                continue;
                                                                break;
                                                                break;
                                                            case 10:
                                                                if (!zzH(obj, obj2, i) || !zzhn.zzF(zzii.zzf(obj, j), zzii.zzf(obj2, j))) {
                                                                    return false;
                                                                }
                                                                continue;
                                                                break;
                                                                break;
                                                            case 11:
                                                                if (!zzH(obj, obj2, i) || zzii.zzc(obj, j) != zzii.zzc(obj2, j)) {
                                                                    return false;
                                                                }
                                                                continue;
                                                                break;
                                                                break;
                                                            case 12:
                                                                if (!zzH(obj, obj2, i) || zzii.zzc(obj, j) != zzii.zzc(obj2, j)) {
                                                                    return false;
                                                                }
                                                                continue;
                                                                break;
                                                                break;
                                                            case 13:
                                                                if (!zzH(obj, obj2, i) || zzii.zzc(obj, j) != zzii.zzc(obj2, j)) {
                                                                    return false;
                                                                }
                                                                continue;
                                                                break;
                                                                break;
                                                            case 14:
                                                                if (!zzH(obj, obj2, i) || zzii.zzd(obj, j) != zzii.zzd(obj2, j)) {
                                                                    return false;
                                                                }
                                                                continue;
                                                                break;
                                                                break;
                                                            case 15:
                                                                if (!zzH(obj, obj2, i) || zzii.zzc(obj, j) != zzii.zzc(obj2, j)) {
                                                                    return false;
                                                                }
                                                                continue;
                                                                break;
                                                                break;
                                                            case 16:
                                                                if (!zzH(obj, obj2, i) || zzii.zzd(obj, j) != zzii.zzd(obj2, j)) {
                                                                    return false;
                                                                }
                                                                continue;
                                                                break;
                                                                break;
                                                            case 17:
                                                                if (!zzH(obj, obj2, i) || !zzhn.zzF(zzii.zzf(obj, j), zzii.zzf(obj2, j))) {
                                                                    return false;
                                                                }
                                                                continue;
                                                                break;
                                                                break;
                                                            case 18:
                                                            case 19:
                                                            case 20:
                                                            case 21:
                                                            case 22:
                                                            case 23:
                                                            case 24:
                                                            case 25:
                                                            case 26:
                                                            case 27:
                                                            case 28:
                                                            case 29:
                                                            case 30:
                                                            case 31:
                                                            case 32:
                                                            case 33:
                                                            case 34:
                                                            case 35:
                                                            case 36:
                                                            case 37:
                                                            case 38:
                                                            case 39:
                                                            case 40:
                                                            case 41:
                                                            case 42:
                                                            case 43:
                                                            case 44:
                                                            case 45:
                                                            case 46:
                                                            case 47:
                                                            case 48:
                                                            case 49:
                                                                zZzF = zzhn.zzF(zzii.zzf(obj, j), zzii.zzf(obj2, j));
                                                                break;
                                                            case 50:
                                                                zZzF = zzhn.zzF(zzii.zzf(obj, j), zzii.zzf(obj2, j));
                                                                break;
                                                            case 51:
                                                            case 52:
                                                            case 53:
                                                            case 54:
                                                            case 55:
                                                            case 56:
                                                            case 57:
                                                            case 58:
                                                            case 59:
                                                            case 60:
                                                            case 61:
                                                            case 62:
                                                            case 63:
                                                            case 64:
                                                            case 65:
                                                            case 66:
                                                            case 67:
                                                            case 68:
                                                                long jZzp = zzp(i) & 1048575;
                                                                if (zzii.zzc(obj, jZzp) != zzii.zzc(obj2, jZzp) || !zzhn.zzF(zzii.zzf(obj, j), zzii.zzf(obj2, j))) {
                                                                    return false;
                                                                }
                                                                continue;
                                                                break;
                                                                break;
                                                            default:
                                                                continue;
                                                                break;
                                                        }
                                                        if (!zZzF) {
                                                            return false;
                                                        }
                                                    }
                                                    if (!((zzfu) obj).zzc.equals(((zzfu) obj2).zzc)) {
                                                        return false;
                                                    }
                                                    if (this.zzh) {
                                                        return ((zzfr) obj).zzb.equals(((zzfr) obj2).zzb);
                                                    }
                                                    return true;
                                                }

                                                /* JADX WARN: Code duplicated, block: B:49:0x00cb  */
                                                /* JADX WARN: Code duplicated, block: B:51:0x00da  */
                                                /* JADX WARN: Code duplicated, block: B:54:0x00e5  */
                                                /* JADX WARN: Code duplicated, block: B:57:0x00f0 A[LOOP:2: B:52:0x00df->B:57:0x00f0, LOOP_END] */
                                                /* JADX WARN: Code duplicated, block: B:74:0x00ef A[SYNTHETIC] */
                                                /* JADX WARN: Code duplicated, block: B:81:0x010d A[SYNTHETIC] */
                                                @Override // com.google.android.gms.internal.play_billing.zzhl
                                                public final boolean zzk(Object obj) {
                                                    int i;
                                                    int i2;
                                                    List list;
                                                    zzhl zzhlVarZzv;
                                                    int i3;
                                                    int i4 = 0;
                                                    int i5 = 0;
                                                    int i6 = 1048575;
                                                    while (i5 < this.zzj) {
                                                        int[] iArr = this.zzi;
                                                        int[] iArr2 = this.zzc;
                                                        int i7 = iArr[i5];
                                                        int i8 = iArr2[i7];
                                                        int iZzs = zzs(i7);
                                                        int i9 = iArr2[i7 + 2];
                                                        int i10 = i9 & 1048575;
                                                        int i11 = 1 << (i9 >>> 20);
                                                        if (i10 != i6) {
                                                            if (i10 != 1048575) {
                                                                i4 = zzb.getInt(obj, i10);
                                                            }
                                                            i2 = i4;
                                                            i = i10;
                                                        } else {
                                                            i = i6;
                                                            i2 = i4;
                                                        }
                                                        if ((268435456 & iZzs) != 0 && !zzJ(obj, i7, i, i2, i11)) {
                                                            return false;
                                                        }
                                                        int iZzr = zzr(iZzs);
                                                        if (iZzr == 9 || iZzr == 17) {
                                                            if (zzJ(obj, i7, i, i2, i11) && !zzK(obj, iZzs, zzv(i7))) {
                                                                return false;
                                                            }
                                                        } else if (iZzr == 27) {
                                                            list = (List) zzii.zzf(obj, iZzs & 1048575);
                                                            if (list.isEmpty()) {
                                                                continue;
                                                            } else {
                                                                zzhlVarZzv = zzv(i7);
                                                                for (i3 = 0; i3 < list.size(); i3++) {
                                                                    if (!zzhlVarZzv.zzk(list.get(i3))) {
                                                                        return false;
                                                                    }
                                                                }
                                                            }
                                                        } else if (iZzr == 60 || iZzr == 68) {
                                                            if (zzM(obj, i8, i7) && !zzK(obj, iZzs, zzv(i7))) {
                                                                return false;
                                                            }
                                                        } else if (iZzr == 49) {
                                                            list = (List) zzii.zzf(obj, iZzs & 1048575);
                                                            if (list.isEmpty()) {
                                                                zzhlVarZzv = zzv(i7);
                                                                while (i3 < list.size()) {
                                                                    if (!zzhlVarZzv.zzk(list.get(i3))) {
                                                                        return false;
                                                                    }
                                                                }
                                                            } else {
                                                                continue;
                                                            }
                                                        } else if (iZzr != 50) {
                                                            continue;
                                                        } else {
                                                            zzgv zzgvVar = (zzgv) zzii.zzf(obj, iZzs & 1048575);
                                                            if (!zzgvVar.isEmpty() && ((zzgu) zzw(i7)).zzc().zzc.zzb() == zzis.MESSAGE) {
                                                                zzhl zzhlVarZzb = null;
                                                                for (Object obj2 : zzgvVar.values()) {
                                                                    if (zzhlVarZzb == null) {
                                                                        zzhlVarZzb = zzhi.zza().zzb(obj2.getClass());
                                                                    }
                                                                    if (!zzhlVarZzb.zzk(obj2)) {
                                                                        return false;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        i5++;
                                                        i6 = i;
                                                        i4 = i2;
                                                    }
                                                    return !this.zzh || ((zzfr) obj).zzb.zzj();
                                                }
                                            }
