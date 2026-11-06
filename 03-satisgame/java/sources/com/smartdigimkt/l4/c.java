package com.smartdigimkt.l4;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import com.bykv.vk.component.ttvideo.player.C;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.UByte;
import kotlin.UShort;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c implements SharedPreferences, SharedPreferences.Editor {
    public static final byte[] u = new byte[0];
    public static final int[] v = {0, 1, 4, 4, 8, 8};
    public static final int w;
    public static final int x;
    public final String a;
    public final String b;
    public final HashMap c;
    public int e;
    public long f;
    public r h;
    public int i;
    public int j;
    public String l;
    public int q;
    public final com.smartdigimkt.m4.a d = u.a;
    public final HashMap g = new HashMap();
    public final ArrayList k = new ArrayList();
    public final g0 m = new g0();
    public final g0 n = new g0();
    public final q o = new q();
    public final v p = new v();
    public final ArrayList r = new ArrayList();
    public final ArrayList s = new ArrayList();
    public final Handler t = new Handler(Looper.getMainLooper());

    static {
        int iA = e0.a();
        w = iA;
        x = Math.max(iA, 32768);
    }

    public c(String str, String str2, c0[] c0VarArr) {
        this.a = str;
        this.b = str2;
        HashMap map = new HashMap();
        if (c0VarArr != null) {
            for (c0 c0Var : c0VarArr) {
                c0Var.getClass();
                if (map.containsKey("StringSet")) {
                    c("duplicate encoder tag:StringSet");
                } else {
                    map.put("StringSet", c0Var);
                }
            }
        }
        map.put("StringSet", c0.a);
        this.c = map;
    }

    public static int a(int i, int i2) {
        if (i2 >= 268435456) {
            throw new IllegalStateException("data size out of limit");
        }
        int i3 = w;
        if (i2 <= i3) {
            return i3;
        }
        while (i < i2) {
            i <<= 1;
        }
        return i;
    }

    public static long a(int i, long j) {
        int i2 = (i & 7) << 3;
        return (j >>> (64 - i2)) | (j << i2);
    }

    public static boolean c(int i) {
        return (i & C.ENCODING_PCM_32BIT) != 0;
    }

    public abstract void a();

    public abstract void a(byte b, int i);

    public abstract void a(int i);

    public abstract void a(int i, int i2, int i3);

    public abstract void a(int i, int i2, long j);

    public abstract void a(int i, long j, long j2);

    public abstract void a(int i, byte[] bArr);

    public final void b(final String str) {
        u.a().execute(new Runnable() { // from class: com.smartdigimkt.l4.c$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.g(str);
            }
        });
    }

    public abstract void c();

    @Override // android.content.SharedPreferences
    public final synchronized boolean contains(String str) {
        return this.g.containsKey(str);
    }

    public void d() {
        this.e = 12;
        this.f = 0L;
        this.g.clear();
        g0 g0Var = this.n;
        synchronized (g0Var) {
            g0Var.a.clear();
            g0Var.a();
        }
        this.m.b();
        this.q = 0;
        this.r.clear();
    }

    public final void e() {
        d();
        r rVar = this.h;
        if (rVar == null || rVar.b.length != w) {
            this.h = new r(w);
        } else {
            rVar.a(4, 0L);
        }
        this.h.b(0, 0);
    }

    public abstract void e(String str);

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        return this;
    }

    public abstract void f();

    public final void f(String str) {
    }

    public final void g(String str) {
        o oVar = (o) this.o.a.get(str);
        if (oVar != null) {
            oVar.c.set(true);
        } else {
            e0.a(new File(this.a + this.b, str));
        }
    }

    @Override // android.content.SharedPreferences
    public final synchronized Map getAll() {
        Object objValueOf;
        int size = this.g.size();
        if (size == 0) {
            return new HashMap();
        }
        HashMap map = new HashMap(((size * 4) / 3) + 1);
        for (Map.Entry entry : this.g.entrySet()) {
            String str = (String) entry.getKey();
            e eVar = (e) entry.getValue();
            switch (eVar.a()) {
                case 1:
                    objValueOf = Boolean.valueOf(((f) eVar).b);
                    break;
                case 2:
                    objValueOf = Integer.valueOf(((i) eVar).b);
                    break;
                case 3:
                    objValueOf = Float.valueOf(((h) eVar).b);
                    break;
                case 4:
                    objValueOf = Long.valueOf(((j) eVar).b);
                    break;
                case 5:
                    objValueOf = Double.valueOf(((g) eVar).b);
                    break;
                case 6:
                    l lVar = (l) eVar;
                    objValueOf = lVar.e ? a(lVar) : lVar.b;
                    break;
                case 7:
                    d dVar = (d) eVar;
                    objValueOf = dVar.e ? a(dVar) : dVar.b;
                    break;
                case 8:
                    k kVar = (k) eVar;
                    objValueOf = kVar.e ? a(kVar) : kVar.b;
                    break;
                default:
                    objValueOf = null;
                    break;
            }
            if (objValueOf != null) {
                map.put(str, objValueOf);
            }
        }
        return map;
    }

    @Override // android.content.SharedPreferences
    public final synchronized boolean getBoolean(String str, boolean z) {
        e eVar = (e) this.g.get(str);
        if (eVar != null && eVar.a() == 1) {
            z = ((f) eVar).b;
        }
        return z;
    }

    @Override // android.content.SharedPreferences
    public final synchronized float getFloat(String str, float f) {
        e eVar = (e) this.g.get(str);
        if (eVar != null && eVar.a() == 3) {
            f = ((h) eVar).b;
        }
        return f;
    }

    @Override // android.content.SharedPreferences
    public final synchronized int getInt(String str, int i) {
        e eVar = (e) this.g.get(str);
        if (eVar != null && eVar.a() == 2) {
            i = ((i) eVar).b;
        }
        return i;
    }

    @Override // android.content.SharedPreferences
    public final synchronized long getLong(String str, long j) {
        e eVar = (e) this.g.get(str);
        if (eVar != null && eVar.a() == 4) {
            j = ((j) eVar).b;
        }
        return j;
    }

    @Override // android.content.SharedPreferences
    public final synchronized String getString(String str, String str2) {
        e eVar = (e) this.g.get(str);
        if (eVar != null && eVar.a() == 6) {
            l lVar = (l) eVar;
            if (!lVar.e) {
                return (String) lVar.b;
            }
            Object objA = this.n.a(str);
            if (objA instanceof String) {
                return (String) objA;
            }
            String strA = a(lVar);
            if (strA != null && !strA.isEmpty()) {
                this.n.a(strA, str);
                return strA;
            }
            remove(str);
            return str2;
        }
        return str2;
    }

    @Override // android.content.SharedPreferences
    public final Set getStringSet(String str, Set set) {
        Set set2;
        synchronized (this) {
            set2 = (Set) d(str);
        }
        return set2 != null ? set2 : set;
    }

    public final synchronized void h(final String str) {
        if (this.s.isEmpty()) {
            return;
        }
        for (final SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener : this.s) {
            this.t.post(new Runnable() { // from class: com.smartdigimkt.l4.c$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(onSharedPreferenceChangeListener, str);
                }
            });
        }
    }

    public abstract void i(String str);

    @Override // android.content.SharedPreferences.Editor
    public final synchronized SharedPreferences.Editor putBoolean(String str, boolean z) {
        a(str);
        c();
        e eVar = (e) this.g.get(str);
        if (eVar != null && eVar.a() != 1) {
            remove(str);
            eVar = null;
        }
        f fVar = (f) eVar;
        if (fVar == null) {
            a(str, (byte) 1, v[1]);
            r rVar = this.h;
            int i = rVar.c;
            rVar.a(z ? (byte) 1 : (byte) 0);
            f();
            this.g.put(str, new f(i, z));
            e(str);
        } else if (fVar.b != z) {
            fVar.b = z;
            a(z ? (byte) 1 : (byte) 0, fVar.a);
            e(str);
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final synchronized SharedPreferences.Editor putFloat(String str, float f) {
        a(str);
        c();
        e eVar = (e) this.g.get(str);
        if (eVar != null && eVar.a() != 3) {
            remove(str);
            eVar = null;
        }
        h hVar = (h) eVar;
        if (hVar == null) {
            a(str, (byte) 3, v[3]);
            r rVar = this.h;
            int i = rVar.c;
            int iFloatToRawIntBits = Float.floatToRawIntBits(f);
            byte[] bArr = rVar.b;
            int i2 = rVar.c;
            bArr[i2] = (byte) iFloatToRawIntBits;
            bArr[i2 + 1] = (byte) (iFloatToRawIntBits >> 8);
            bArr[i2 + 2] = (byte) (iFloatToRawIntBits >> 16);
            rVar.c = i2 + 4;
            bArr[i2 + 3] = (byte) (iFloatToRawIntBits >> 24);
            f();
            this.g.put(str, new h(i, f));
            e(str);
        } else if (hVar.b != f) {
            int iFloatToRawIntBits2 = Float.floatToRawIntBits(f);
            r rVar2 = this.h;
            int i3 = hVar.a;
            byte[] bArr2 = rVar2.b;
            long j = ((long) (((bArr2[i3 + 3] << 24) | ((((bArr2[i3 + 1] & UByte.MAX_VALUE) << 8) | (bArr2[i3] & UByte.MAX_VALUE)) | ((bArr2[i3 + 2] & UByte.MAX_VALUE) << 16))) ^ iFloatToRawIntBits2)) & 4294967295L;
            hVar.b = f;
            a(iFloatToRawIntBits2, i3, j);
            e(str);
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final synchronized SharedPreferences.Editor putInt(String str, int i) {
        a(str);
        c();
        e eVar = (e) this.g.get(str);
        if (eVar != null && eVar.a() != 2) {
            remove(str);
            eVar = null;
        }
        i iVar = (i) eVar;
        if (iVar == null) {
            a(str, (byte) 2, v[2]);
            r rVar = this.h;
            int i2 = rVar.c;
            byte[] bArr = rVar.b;
            bArr[i2] = (byte) i;
            bArr[i2 + 1] = (byte) (i >> 8);
            bArr[i2 + 2] = (byte) (i >> 16);
            rVar.c = i2 + 4;
            bArr[i2 + 3] = (byte) (i >> 24);
            f();
            this.g.put(str, new i(i2, i));
            e(str);
        } else {
            int i3 = iVar.b;
            if (i3 != i) {
                iVar.b = i;
                a(i, iVar.a, ((long) (i3 ^ i)) & 4294967295L);
                e(str);
            }
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final synchronized SharedPreferences.Editor putLong(String str, long j) {
        a(str);
        c();
        e eVar = (e) this.g.get(str);
        if (eVar != null && eVar.a() != 4) {
            remove(str);
            eVar = null;
        }
        j jVar = (j) eVar;
        if (jVar == null) {
            a(str, (byte) 4, v[4]);
            r rVar = this.h;
            int i = rVar.c;
            rVar.a(i, j);
            rVar.c += 8;
            f();
            this.g.put(str, new j(i, j));
            e(str);
        } else {
            long j2 = jVar.b;
            if (j2 != j) {
                jVar.b = j;
                a(jVar.a, j, j ^ j2);
                e(str);
            }
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final synchronized SharedPreferences.Editor putString(String str, String str2) {
        a(str);
        if (str2 == null) {
            remove(str);
        } else {
            e eVar = (e) this.g.get(str);
            String str3 = null;
            if (eVar != null && eVar.a() != 6) {
                remove(str);
                eVar = null;
            }
            l lVar = (l) eVar;
            if (lVar != null && !lVar.e && str2.equals(lVar.b)) {
                return this;
            }
            c();
            if (str2.length() * 3 < 4096) {
                int iA = s.a(str2);
                boolean z = false;
                if (lVar == null) {
                    int iA2 = s.a(str);
                    if (iA2 > 255) {
                        throw new IllegalArgumentException("key's length must less than 256");
                    }
                    int i = iA2 + 4;
                    int i2 = i + iA;
                    this.j = i2;
                    a(i2);
                    int i3 = this.e;
                    this.i = i3;
                    this.e = this.j + i3;
                    r rVar = this.h;
                    rVar.c = i3;
                    rVar.a((byte) 6);
                    this.h.a((byte) iA2);
                    if (iA2 == str.length()) {
                        r rVar2 = this.h;
                        str.getBytes(0, iA2, rVar2.b, rVar2.c);
                        this.h.c += iA2;
                    } else {
                        this.h.b(str);
                    }
                    r rVar3 = this.h;
                    short s = (short) iA;
                    byte[] bArr = rVar3.b;
                    int i4 = rVar3.c;
                    bArr[i4] = (byte) s;
                    rVar3.c = i4 + 2;
                    bArr[i4 + 1] = (byte) (s >> 8);
                    if (iA == str2.length()) {
                        r rVar4 = this.h;
                        str2.getBytes(0, iA, rVar4.b, rVar4.c);
                    } else {
                        this.h.b(str2);
                    }
                    HashMap map = this.g;
                    int i5 = this.i;
                    map.put(str, new l(i5, i5 + i, str2, iA, false));
                    f();
                } else {
                    int i6 = lVar.a;
                    int i7 = i6 - lVar.c;
                    int i8 = lVar.d;
                    if (i8 == iA) {
                        this.f = this.h.a(i6, i8) ^ this.f;
                        if (iA == str2.length()) {
                            str2.getBytes(0, iA, this.h.b, lVar.a);
                        } else {
                            r rVar5 = this.h;
                            rVar5.c = lVar.a;
                            rVar5.b(str2);
                        }
                        this.i = lVar.a;
                        this.j = iA;
                    } else {
                        int i9 = i7 + iA;
                        this.j = i9;
                        a(i9);
                        int i10 = this.e;
                        this.i = i10;
                        this.e = this.j + i10;
                        r rVar6 = this.h;
                        rVar6.c = i10;
                        rVar6.a((byte) 6);
                        int i11 = i7 - 3;
                        r rVar7 = this.h;
                        byte[] bArr2 = rVar7.b;
                        System.arraycopy(bArr2, lVar.c + 1, bArr2, rVar7.c, i11);
                        r rVar8 = this.h;
                        int i12 = rVar8.c + i11;
                        rVar8.c = i12;
                        short s2 = (short) iA;
                        byte[] bArr3 = rVar8.b;
                        bArr3[i12] = (byte) s2;
                        rVar8.c = i12 + 2;
                        bArr3[i12 + 1] = (byte) (s2 >> 8);
                        if (iA == str2.length()) {
                            r rVar9 = this.h;
                            str2.getBytes(0, iA, rVar9.b, rVar9.c);
                        } else {
                            this.h.b(str2);
                        }
                        a((byte) 6, lVar.c, lVar.a + lVar.d);
                        str3 = lVar.e ? (String) lVar.b : null;
                        lVar.e = false;
                        int i13 = this.i;
                        lVar.c = i13;
                        lVar.a = i13 + i7;
                        lVar.d = iA;
                        z = true;
                    }
                    lVar.b = str2;
                    f();
                    if (z) {
                        a();
                    }
                    if (str3 != null) {
                        i(str3);
                    }
                }
            } else {
                byte[] bytes = str2.isEmpty() ? u : str2.getBytes(StandardCharsets.UTF_8);
                if (bytes == null) {
                    a(new Exception("Encrypt failed"));
                    return this;
                }
                a(str, str2, bytes, lVar, (byte) 6);
            }
            e(str);
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final synchronized SharedPreferences.Editor putStringSet(String str, Set set) {
        try {
            if (set == null) {
                remove(str);
            } else {
                a(str, set, c0.a);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    @Override // android.content.SharedPreferences
    public final synchronized void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (onSharedPreferenceChangeListener == null) {
            return;
        }
        if (!this.s.contains(onSharedPreferenceChangeListener)) {
            this.s.add(onSharedPreferenceChangeListener);
        }
    }

    @Override // android.content.SharedPreferences
    public final synchronized void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.s.remove(onSharedPreferenceChangeListener);
    }

    public final void b() {
        try {
            e0.a(new File(this.a, this.b + ".kvc"));
            e0.a(new File(this.a, this.b + ".tmp"));
        } catch (Exception e) {
            a(e);
        }
    }

    public final void c(String str) {
        com.smartdigimkt.m4.a aVar = this.d;
        if (aVar != null) {
            aVar.a(new Exception(str));
        }
    }

    public final boolean a(File file) {
        long length = file.length();
        if (length != 0 && length < com.anythink.china.a.c.C) {
            int i = (int) length;
            int iA = a(w, i);
            r rVar = this.h;
            if (rVar != null && rVar.b.length == iA) {
                rVar.c = 0;
            } else {
                rVar = new r(new byte[iA]);
                this.h = rVar;
            }
            byte[] bArr = rVar.b;
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            int i2 = 0;
            while (i2 < i) {
                try {
                    int i3 = randomAccessFile.read(bArr, i2, i - i2);
                    if (i3 < 0) {
                        break;
                    }
                    i2 += i3;
                } catch (Throwable th) {
                    e0.a(randomAccessFile);
                    throw th;
                }
            }
            e0.a(randomAccessFile);
            int iA2 = rVar.a();
            if (iA2 < 0) {
                return false;
            }
            int i4 = (-1073741825) & iA2;
            boolean zC = c(iA2);
            long jA = rVar.a(rVar.c);
            rVar.c += 8;
            this.e = i4 + 12;
            if (i4 >= 0 && i4 <= i - 12 && jA == rVar.a(12, i4) && a(zC)) {
                this.f = jA;
                return true;
            }
        }
        return false;
    }

    public final void b(int i) {
        ArrayList arrayList = this.r;
        Collections.sort(arrayList);
        b bVar = (b) arrayList.get(0);
        int size = arrayList.size();
        int i2 = 1;
        int i3 = 0;
        for (int i4 = 1; i4 < size; i4++) {
            b bVar2 = (b) arrayList.get(i4);
            if (bVar2.a == bVar.b) {
                bVar.b = bVar2.b;
            } else {
                i3++;
                if (i3 != i4) {
                    arrayList.set(i3, bVar2);
                }
                bVar = bVar2;
            }
        }
        int i5 = i3 + 1;
        if (size > i5) {
            arrayList.subList(i5, size).clear();
        }
        b bVar3 = (b) this.r.get(0);
        int i6 = bVar3.a;
        int i7 = this.e;
        int i8 = i7 - this.q;
        int i9 = i8 - 12;
        int i10 = i8 - i6;
        int i11 = i7 - i6;
        boolean z = i9 < i11 + i10;
        if (!z) {
            this.f ^= this.h.a(i6, i11);
        }
        int size2 = this.r.size();
        int i12 = size2 - 1;
        int i13 = this.e - ((b) this.r.get(i12)).b;
        int i14 = i13 > 0 ? size2 : i12;
        int[] iArr = new int[i14];
        int[] iArr2 = new int[i14];
        int i15 = bVar3.a;
        int i16 = bVar3.b;
        while (i2 < size2) {
            b bVar4 = (b) this.r.get(i2);
            int i17 = size2;
            int i18 = bVar4.a - i16;
            int i19 = i14;
            byte[] bArr = this.h.b;
            System.arraycopy(bArr, i16, bArr, i15, i18);
            int i20 = i2 - 1;
            iArr[i20] = i16;
            iArr2[i20] = i16 - i15;
            i15 += i18;
            i16 = bVar4.b;
            i2++;
            size2 = i17;
            i14 = i19;
        }
        int i21 = i14;
        if (i13 > 0) {
            byte[] bArr2 = this.h.b;
            System.arraycopy(bArr2, i16, bArr2, i15, i13);
            iArr[i12] = i16;
            iArr2[i12] = i16 - i15;
        }
        this.q = 0;
        this.r.clear();
        if (z) {
            this.f = this.h.a(12, i9);
        } else {
            this.f ^= this.h.a(i6, i10);
        }
        this.e = i8;
        a(i6, i, i10);
        for (e eVar : this.g.values()) {
            int i22 = eVar.a;
            if (i22 > i6) {
                int i23 = i21 - 1;
                int i24 = 0;
                while (i24 <= i23) {
                    int i25 = (i24 + i23) >>> 1;
                    int i26 = iArr[i25];
                    if (i26 >= i22) {
                        if (i26 <= i22) {
                            i23 = i25;
                            break;
                        }
                        i23 = i25 - 1;
                    } else {
                        i24 = i25 + 1;
                    }
                }
                int i27 = iArr2[i23];
                eVar.a -= i27;
                if (eVar.a() >= 6) {
                    ((m) eVar).c -= i27;
                }
            }
        }
    }

    public final synchronized Object d(String str) {
        e eVar = (e) this.g.get(str);
        if (eVar != null && eVar.a() == 8) {
            k kVar = (k) eVar;
            if (kVar.e) {
                Object objA = this.n.a(str);
                if (objA != null) {
                    return objA;
                }
                LinkedHashSet linkedHashSetA = a(kVar);
                if (linkedHashSetA == null) {
                    remove(str);
                    return null;
                }
                this.n.a(linkedHashSetA, str);
                return linkedHashSetA;
            }
            return kVar.b;
        }
        return null;
    }

    public final boolean a(boolean z) {
        int i;
        Object objC;
        if (z) {
            c("miss cipher");
            return false;
        }
        r rVar = this.h;
        rVar.c = 12;
        while (true) {
            try {
                int i2 = rVar.c;
                int i3 = this.e;
                boolean z2 = true;
                if (i2 >= i3) {
                    if (i2 == i3) {
                        return true;
                    }
                    a(new Exception("parse dara failed"));
                    return false;
                }
                byte[] bArr = rVar.b;
                int i4 = i2 + 1;
                rVar.c = i4;
                byte b = bArr[i2];
                byte b2 = (byte) (b & com.anythink.core.common.r.a.c.c);
                if (b2 >= 1 && b2 <= 8) {
                    int i5 = i2 + 2;
                    rVar.c = i5;
                    int i6 = bArr[i4] & UByte.MAX_VALUE;
                    if (i6 == 0) {
                        throw new IllegalStateException("invalid key size");
                    }
                    if (b < 0) {
                        int i7 = i5 + i6;
                        rVar.c = i7;
                        if (b2 <= 5) {
                            i = v[b2];
                        } else {
                            int i8 = bArr[i7] & UByte.MAX_VALUE;
                            rVar.c = i7 + 2;
                            i = ((short) ((bArr[i7 + 1] << 8) | i8)) & UShort.MAX_VALUE;
                        }
                        int i9 = rVar.c + i;
                        rVar.c = i9;
                        this.q = (i9 - i2) + this.q;
                        this.r.add(new b(i2, i9));
                    } else {
                        String strB = rVar.b(i6);
                        int i10 = rVar.c;
                        if (b2 > 5) {
                            byte[] bArr2 = rVar.b;
                            int i11 = bArr2[i10] & UByte.MAX_VALUE;
                            int i12 = i10 + 2;
                            rVar.c = i12;
                            int i13 = ((short) ((bArr2[i10 + 1] << 8) | i11)) & UShort.MAX_VALUE;
                            boolean z3 = (b & com.anythink.core.common.r.a.c.b) != 0;
                            if (z3 && i13 != 32) {
                                throw new IllegalStateException("name size not match");
                            }
                            if (b2 == 6) {
                                this.g.put(strB, new l(i2, i12, z3 ? rVar.c(i13) : rVar.b(i13), i13, z3));
                            } else if (b2 == 7) {
                                if (z3) {
                                    objC = rVar.c(i13);
                                } else {
                                    objC = new byte[i13];
                                    System.arraycopy(bArr2, i12, objC, 0, i13);
                                    rVar.c += i13;
                                }
                                this.g.put(strB, new d(i2, i12, objC, i13, z3));
                            } else if (z3) {
                                this.g.put(strB, new k(i2, i12, rVar.c(i13), i13, true));
                            } else {
                                a(i13, strB, i2, i10);
                                rVar.c = i12 + i13;
                            }
                        } else if (b2 == 1) {
                            HashMap map = this.g;
                            byte[] bArr3 = rVar.b;
                            rVar.c = i10 + 1;
                            if (bArr3[i10] != 1) {
                                z2 = false;
                            }
                            map.put(strB, new f(i10, z2));
                        } else if (b2 == 2) {
                            this.g.put(strB, new i(i10, rVar.a()));
                        } else if (b2 == 3) {
                            this.g.put(strB, new h(i10, Float.intBitsToFloat(rVar.a())));
                        } else if (b2 != 4) {
                            HashMap map2 = this.g;
                            long jA = rVar.a(i10);
                            rVar.c += 8;
                            map2.put(strB, new g(i10, Double.longBitsToDouble(jA)));
                        } else {
                            HashMap map3 = this.g;
                            long jA2 = rVar.a(i10);
                            rVar.c += 8;
                            map3.put(strB, new j(i10, jA2));
                        }
                    }
                } else {
                    throw new Exception("parse dara failed");
                }
            } catch (Exception e) {
                a(e);
                return false;
            }
        }
    }

    public final void b(Exception exc) {
        com.smartdigimkt.m4.a aVar = this.d;
        if (aVar != null) {
            aVar.b(exc);
        }
    }

    public final void a(int i, String str, int i2, int i3) throws Exception {
        r rVar = this.h;
        byte[] bArr = rVar.b;
        int i4 = rVar.c;
        rVar.c = i4 + 1;
        int i5 = bArr[i4] & UByte.MAX_VALUE;
        String strC = rVar.c(i5);
        c0 c0Var = (c0) this.c.get(strC);
        int i6 = i - (i5 + 1);
        if (i6 < 0) {
            throw new Exception("parse dara failed");
        }
        if (c0Var != null) {
            try {
                this.g.put(str, new k(i2, i3 + 2, c0Var.a(rVar.b, rVar.c, i6), i, false));
                return;
            } catch (Exception e) {
                a(e);
                return;
            }
        }
        c("object with tag: " + strC + " without encoder");
    }

    public static void a(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("key is empty");
        }
    }

    public final void a(File file, File file2) {
        try {
            if (a(file)) {
                return;
            }
        } catch (IOException e) {
            b(e);
        }
        e();
        try {
            if (a(file2)) {
                return;
            }
        } catch (IOException e2) {
            b(e2);
        }
        e();
    }

    public void a(byte b, int i, int i2) {
        this.q = (i2 - i) + this.q;
        this.r.add(new b(i, i2));
        byte b2 = (byte) (b | (-128));
        byte[] bArr = this.h.b;
        this.f = ((((long) (bArr[i] ^ b2)) & 255) << ((i & 7) << 3)) ^ this.f;
        bArr[i] = b2;
    }

    public final void a(Exception exc) {
        com.smartdigimkt.m4.a aVar = this.d;
        if (aVar != null) {
            aVar.a(exc);
        }
    }

    public final String a(l lVar) {
        String str = (String) lVar.b;
        byte[] bArrC = (byte[]) this.m.a(str);
        if (bArrC == null) {
            try {
                bArrC = e0.c(new File(this.a + this.b, str));
            } catch (Exception e) {
                a(e);
                return null;
            }
        }
        if (bArrC != null) {
            return new String(bArrC, StandardCharsets.UTF_8);
        }
        return null;
    }

    public final byte[] a(d dVar) {
        String str = (String) dVar.b;
        byte[] bArrC = (byte[]) this.m.a(str);
        if (bArrC == null) {
            try {
                bArrC = e0.c(new File(this.a + this.b, str));
            } catch (Exception e) {
                a(e);
                return null;
            }
        }
        if (bArrC != null) {
            return bArrC;
        }
        return null;
    }

    public final LinkedHashSet a(k kVar) {
        String str = (String) kVar.b;
        byte[] bArrC = (byte[]) this.m.a(str);
        if (bArrC == null) {
            try {
                bArrC = e0.c(new File(this.a + this.b, str));
            } catch (Exception e) {
                a(e);
                return null;
            }
        }
        if (bArrC != null) {
            int i = bArrC[0] & UByte.MAX_VALUE;
            String strA = this.h.a(bArrC, 1, i);
            c0 c0Var = (c0) this.c.get(strA);
            if (c0Var != null) {
                kVar.getClass();
                int i2 = i + 1;
                return c0Var.a(bArrC, i2, bArrC.length - i2);
            }
            b(new Exception("No encoder for tag:".concat(strA)));
            return null;
        }
        b(new Exception("Read object data failed"));
        return null;
    }

    public final synchronized void a(String str, double d) {
        a(str);
        c();
        e eVar = (e) this.g.get(str);
        if (eVar != null && eVar.a() != 5) {
            remove(str);
            eVar = null;
        }
        g gVar = (g) eVar;
        if (gVar == null) {
            a(str, (byte) 5, v[5]);
            r rVar = this.h;
            int i = rVar.c;
            rVar.a(rVar.c, Double.doubleToRawLongBits(d));
            rVar.c += 8;
            f();
            this.g.put(str, new g(i, d));
            e(str);
        } else if (gVar.b != d) {
            long jDoubleToRawLongBits = Double.doubleToRawLongBits(d);
            long jA = jDoubleToRawLongBits ^ this.h.a(gVar.a);
            gVar.b = d;
            a(gVar.a, jDoubleToRawLongBits, jA);
            e(str);
        }
    }

    public final synchronized void a(String str, byte[] bArr) {
        a(str);
        if (bArr == null) {
            remove(str);
        } else {
            c();
            e eVar = (e) this.g.get(str);
            if (eVar != null && eVar.a() != 7) {
                remove(str);
                eVar = null;
            }
            a(str, bArr, bArr, (d) eVar, (byte) 7);
            e(str);
        }
    }

    public final synchronized void a(String str, Object obj, c0 c0Var) {
        byte[] bArrA;
        a(str);
        if (c0Var != null) {
            if (!this.c.containsKey("StringSet")) {
                throw new IllegalArgumentException("Encoder hasn't been registered");
            }
            if (obj == null) {
                remove(str);
                return;
            }
            e eVar = null;
            try {
                bArrA = c0Var.a(obj);
            } catch (Exception e) {
                a(e);
                bArrA = null;
            }
            if (bArrA == null) {
                remove(str);
                return;
            }
            c();
            e eVar2 = (e) this.g.get(str);
            if (eVar2 == null || eVar2.a() == 8) {
                eVar = eVar2;
            } else {
                remove(str);
            }
            k kVar = (k) eVar;
            int iA = s.a("StringSet");
            r rVar = new r(iA + 1 + bArrA.length);
            rVar.a((byte) iA);
            rVar.b("StringSet");
            int length = bArrA.length;
            if (length > 0) {
                System.arraycopy(bArrA, 0, rVar.b, rVar.c, length);
                rVar.c += length;
            }
            byte[] bArr = rVar.b;
            if (bArr == null) {
                return;
            }
            a(str, obj, bArr, kVar, (byte) 8);
            e(str);
            return;
        }
        throw new IllegalArgumentException("Encoder is null");
    }

    public final /* synthetic */ void a(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener, String str) {
        onSharedPreferenceChangeListener.onSharedPreferenceChanged(this, str);
    }

    public synchronized void a(Map map) {
        for (Map.Entry entry : ((HashMap) map).entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (str != null && !str.isEmpty()) {
                if (value instanceof String) {
                    putString(str, (String) value);
                } else if (value instanceof Boolean) {
                    putBoolean(str, ((Boolean) value).booleanValue());
                } else if (value instanceof Integer) {
                    putInt(str, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    putLong(str, ((Long) value).longValue());
                } else if (value instanceof Float) {
                    putFloat(str, ((Float) value).floatValue());
                } else if (value instanceof Double) {
                    a(str, ((Double) value).doubleValue());
                } else if (value instanceof byte[]) {
                    a(str, (byte[]) value);
                } else {
                    if (value instanceof Set) {
                        Set set = (Set) value;
                        if (set.isEmpty() || (set.iterator().next() instanceof String)) {
                            putStringSet(str, set);
                        }
                    }
                    b(new Exception("missing encoders"));
                }
            }
        }
    }

    public final void a(String str, byte b, int i) {
        int iA = s.a(str);
        if (iA <= 255) {
            int i2 = iA + 2 + i;
            this.j = i2;
            a(i2);
            int i3 = this.e;
            this.i = i3;
            this.e = this.j + i3;
            r rVar = this.h;
            rVar.c = i3;
            rVar.a(b);
            this.h.a((byte) iA);
            if (iA == str.length()) {
                r rVar2 = this.h;
                str.getBytes(0, iA, rVar2.b, rVar2.c);
                this.h.c += iA;
                return;
            }
            this.h.b(str);
            return;
        }
        throw new IllegalArgumentException("key's length must less than 256");
    }

    public final void a(String str, Object obj, byte[] bArr, m mVar, byte b) {
        e kVar;
        int length = 32;
        if (mVar == null) {
            int iA = a(str, bArr, b);
            if (iA > 0) {
                boolean z = this.l != null;
                if (z) {
                    this.n.a(obj, str);
                    obj = this.l;
                    this.l = null;
                } else {
                    length = bArr.length;
                }
                Object obj2 = obj;
                int i = length;
                if (b == 6) {
                    kVar = new l(this.i, iA, (String) obj2, i, z);
                } else if (b == 7) {
                    kVar = new d(this.i, iA, obj2, i, z);
                } else {
                    kVar = new k(this.i, iA, obj2, i, z);
                }
                this.g.put(str, kVar);
                f();
                return;
            }
            return;
        }
        if (!mVar.e && mVar.d == bArr.length) {
            a(mVar.a, bArr);
            mVar.b = obj;
            return;
        }
        int iA2 = a(str, bArr, mVar.a());
        if (iA2 > 0) {
            String str2 = mVar.e ? (String) mVar.b : null;
            a(mVar.a(), mVar.c, mVar.a + mVar.d);
            boolean z2 = this.l != null;
            mVar.c = this.i;
            mVar.a = iA2;
            mVar.e = z2;
            if (z2) {
                this.n.a(obj, str);
                mVar.b = this.l;
                mVar.d = 32;
                this.l = null;
            } else {
                mVar.b = obj;
                mVar.d = bArr.length;
            }
            f();
            a();
            if (str2 != null) {
                i(str2);
            }
        }
    }

    public final int a(final String str, final byte[] bArr, byte b) {
        this.l = null;
        if (bArr.length < 4096) {
            a(str, b, bArr.length + 2);
            r rVar = this.h;
            short length = (short) bArr.length;
            byte[] bArr2 = rVar.b;
            int i = rVar.c;
            int i2 = i + 1;
            bArr2[i] = (byte) length;
            int i3 = i + 2;
            rVar.c = i3;
            bArr2[i2] = (byte) (length >> 8);
            int length2 = bArr.length;
            if (length2 > 0) {
                System.arraycopy(bArr, 0, bArr2, i3, length2);
                rVar.c += length2;
            }
            return i3;
        }
        byte[] bArr3 = new byte[16];
        d0.a.nextBytes(bArr3);
        char[] cArr = new char[32];
        for (int i4 = 0; i4 < 16; i4++) {
            byte b2 = bArr3[i4];
            int i5 = i4 << 1;
            char[] cArr2 = d0.b;
            cArr[i5] = cArr2[(b2 >> 4) & 15];
            cArr[i5 + 1] = cArr2[b2 & 15];
        }
        final String str2 = new String(cArr);
        byte[] bArr4 = new byte[32];
        str2.getBytes(0, 32, bArr4, 0);
        a(str, (byte) (b | com.anythink.core.common.r.a.c.b), 34);
        r rVar2 = this.h;
        short s = (short) 32;
        byte[] bArr5 = rVar2.b;
        int i6 = rVar2.c;
        int i7 = i6 + 1;
        bArr5[i6] = (byte) s;
        int i8 = i6 + 2;
        rVar2.c = i8;
        bArr5[i7] = (byte) (s >> 8);
        System.arraycopy(bArr4, 0, bArr5, i8, 32);
        rVar2.c += 32;
        if (i8 > 0) {
            this.m.a(bArr, str2);
            q qVar = this.o;
            p pVar = new p() { // from class: com.smartdigimkt.l4.c$$ExternalSyntheticLambda2
                @Override // com.smartdigimkt.l4.p
                public final void a(AtomicBoolean atomicBoolean) {
                    this.f$0.a(str2, bArr, str, atomicBoolean);
                }
            };
            qVar.getClass();
            o oVar = new o(qVar, str2, pVar);
            qVar.a.put(str2, oVar);
            u.a().execute(oVar);
            this.l = str2;
        }
        return i8;
    }

    public final /* synthetic */ void a(String str, byte[] bArr, String str2, AtomicBoolean atomicBoolean) {
        if (atomicBoolean.get() || e0.a(new File(this.a + this.b, str), bArr, atomicBoolean)) {
            return;
        }
        String str3 = "Write large value with key:" + str2 + " failed";
    }
}
