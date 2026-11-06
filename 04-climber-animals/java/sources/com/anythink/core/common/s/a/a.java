package com.anythink.core.common.s.a;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.UByte;
import kotlin.UShort;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements SharedPreferences, SharedPreferences.Editor {
    protected static final String a = "both files error";
    protected static final String b = "parse dara failed";
    protected static final String c = "open file failed";
    protected static final String d = "map failed";
    protected static final String e = "miss cipher";
    protected static final String f = "Encrypt failed";
    static final String g = "truncate finish";
    static final String h = "gc finish";
    protected static final String i = ".kva";
    protected static final String j = ".kvb";
    protected static final String k = ".kvc";
    protected static final String l = ".tmp";
    protected static final int m = 268435456;
    protected static final int n = 1073741824;
    protected static final int p = 12;
    protected static final int r;
    protected static final int s;
    protected static final int t = 8192;
    protected static final int u = 80;
    protected int A;
    protected long B;
    protected f E;
    protected int F;
    protected int G;
    protected String K;
    protected int P;
    protected final String v;
    protected final String w;
    protected final Map<String, com.anythink.core.common.s.a.a.b> x;
    protected final com.anythink.core.common.s.a.a.a z;
    private static final byte[] S = new byte[0];
    protected static final int[] o = {0, 1, 4, 4, 8, 8};
    protected final int q = h.c;
    protected final com.anythink.core.common.s.a.a.c y = h.a;
    protected final HashMap<String, b.AbstractC0101b> C = new HashMap<>();
    protected volatile boolean D = false;
    protected final List<String> H = new ArrayList();
    protected boolean I = false;
    protected boolean J = false;
    protected final m L = new m();
    protected final m M = new m();
    protected final e N = new e();
    protected final Executor O = new i();
    protected final ArrayList<C0100a> Q = new ArrayList<>();
    protected final ArrayList<SharedPreferences.OnSharedPreferenceChangeListener> R = new ArrayList<>();
    private final Handler T = new Handler(Looper.getMainLooper());

    protected static long a(long j2, int i2) {
        int i3 = (i2 & 7) << 3;
        return (j2 >>> (64 - i3)) | (j2 << i3);
    }

    protected static boolean b(int i2) {
        return (i2 & 1073741824) != 0;
    }

    private static int e(int i2) {
        return i2 & (-1073741825);
    }

    protected abstract void a(byte b2, int i2);

    protected abstract void a(int i2, int i3, int i4);

    protected abstract void a(int i2, long j2, int i3);

    protected abstract void a(long j2, long j3, int i2);

    protected abstract void a(g gVar);

    protected abstract void d(int i2);

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this;
    }

    protected abstract void f(String str);

    protected void g() {
    }

    protected abstract void g(String str);

    protected abstract void h();

    protected abstract void i();

    static {
        int iB = l.b();
        r = iB;
        s = Math.max(iB, 32768);
    }

    protected a(String str, String str2, com.anythink.core.common.s.a.a.b[] bVarArr, com.anythink.core.common.s.a.a.a aVar) {
        this.v = str;
        this.w = str2;
        this.z = aVar;
        HashMap map = new HashMap();
        if (bVarArr != null) {
            for (com.anythink.core.common.s.a.a.b bVar : bVarArr) {
                String strA = bVar.a();
                if (map.containsKey(strA)) {
                    b("duplicate encoder tag:".concat(String.valueOf(strA)));
                } else {
                    map.put(strA, bVar);
                }
            }
        }
        map.put("StringSet", k.a);
        this.x = map;
    }

    protected final int a(int i2) {
        return this.z == null ? i2 : i2 | 1073741824;
    }

    protected static int a(int i2, int i3) {
        if (i3 >= 268435456) {
            throw new IllegalStateException("data size out of limit");
        }
        int i4 = r;
        if (i3 <= i4) {
            return i4;
        }
        while (i2 < i3) {
            i2 <<= 1;
        }
        return i2;
    }

    protected final void a() throws Throwable {
        com.anythink.core.common.s.a.a.b[] bVarArr = (com.anythink.core.common.s.a.a.b[]) this.x.values().toArray(new com.anythink.core.common.s.a.a.b[this.x.size()]);
        String str = "temp_" + this.w;
        g gVar = new g(this.v, str, bVarArr, this.z, 2);
        gVar.V = false;
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, b.AbstractC0101b> entry : this.C.entrySet()) {
            String key = entry.getKey();
            b.AbstractC0101b value = entry.getValue();
            if (value instanceof b.i) {
                b.i iVar = (b.i) value;
                if (iVar.f) {
                    arrayList.add((String) iVar.c);
                    String strA = a(iVar, (com.anythink.core.common.s.a.a.a) null);
                    if (strA != null) {
                        gVar.putString(key, strA);
                    }
                } else {
                    gVar.putString(key, (String) iVar.c);
                }
            } else if (value instanceof b.c) {
                gVar.putBoolean(key, ((b.c) value).b);
            } else if (value instanceof b.f) {
                gVar.putInt(key, ((b.f) value).b);
            } else if (value instanceof b.g) {
                gVar.putLong(key, ((b.g) value).b);
            } else if (value instanceof b.e) {
                gVar.putFloat(key, ((b.e) value).b);
            } else if (value instanceof b.d) {
                gVar.b(key, ((b.d) value).b);
            } else if (value instanceof b.a) {
                b.a aVar = (b.a) value;
                if (aVar.f) {
                    arrayList.add((String) aVar.c);
                    byte[] bArrA = a(aVar, (com.anythink.core.common.s.a.a.a) null);
                    if (bArrA != null) {
                        gVar.a(key, bArrA);
                    }
                } else {
                    gVar.a(key, (byte[]) aVar.c);
                }
            } else if (value instanceof b.h) {
                b.h hVar = (b.h) value;
                if (hVar.f) {
                    arrayList.add((String) hVar.c);
                    Object objA = a(hVar, (com.anythink.core.common.s.a.a.a) null);
                    if (objA != null && hVar.b != null) {
                        gVar.a(key, objA, (com.anythink.core.common.s.a.a.b<Object>) hVar.b);
                    }
                } else if (hVar.b != null) {
                    gVar.a(key, hVar.c, (com.anythink.core.common.s.a.a.b<Object>) hVar.b);
                }
            }
        }
        gVar.contains("");
        this.E = gVar.E;
        this.B = gVar.B;
        this.A = gVar.A;
        e();
        this.C.clear();
        this.C.putAll(gVar.C);
        a(gVar);
        while (gVar.N.a()) {
            try {
                Thread.sleep(10L);
            } catch (Exception unused) {
            }
        }
        File file = new File(this.v, str);
        String str2 = this.v + this.w;
        l.a(file, str2);
        l.c(file);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            l.c(new File(str2, (String) it.next()));
        }
        this.I = false;
    }

    protected final boolean a(File file) {
        f fVar;
        long length = file.length();
        if (length != 0 && length < 268435456) {
            int i2 = (int) length;
            int iA = a(r, i2);
            f fVar2 = this.E;
            if (fVar2 != null && fVar2.a.length == iA) {
                fVar = this.E;
                fVar.b = 0;
            } else {
                f fVar3 = new f(new byte[iA]);
                this.E = fVar3;
                fVar = fVar3;
            }
            l.a(file, fVar.a, i2);
            int iC = fVar.c();
            if (iC < 0) {
                return false;
            }
            int i3 = (-1073741825) & iC;
            boolean zB = b(iC);
            long jD = fVar.d();
            this.A = i3 + 12;
            if (i3 >= 0 && i3 <= i2 - 12 && jD == fVar.b(12, i3) && a(zB)) {
                this.B = jD;
                return true;
            }
        }
        return false;
    }

    protected final void a(final String str) {
        h.a().execute(new Runnable() { // from class: com.anythink.core.common.s.a.a$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.q(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(String str) {
        if (this.N.a(str)) {
            return;
        }
        l.c(new File(this.v + this.w, str));
    }

    protected final void b() {
        try {
            l.c(new File(this.v, this.w + k));
            l.c(new File(this.v, this.w + ".tmp"));
        } catch (Exception e2) {
            a(e2);
        }
    }

    protected final boolean a(boolean z) {
        int length;
        f fVar;
        int i2;
        int i3;
        Object objB;
        boolean z2 = false;
        if (z && this.z == null) {
            b(e);
            return false;
        }
        com.anythink.core.common.s.a.a.a aVar = z ? this.z : null;
        f fVar2 = this.E;
        fVar2.b = 12;
        while (true) {
            try {
                boolean z3 = true;
                if (fVar2.b < this.A) {
                    int i4 = fVar2.b;
                    byte bA = fVar2.a();
                    byte b2 = (byte) (bA & c.c);
                    if (b2 <= 0 || b2 > 8) {
                        throw new Exception(b);
                    }
                    int iA = fVar2.a() & UByte.MAX_VALUE;
                    if (iA == 0) {
                        throw new IllegalStateException("invalid key size");
                    }
                    if (bA < 0) {
                        fVar2.b += iA;
                        fVar2.b += b2 <= 5 ? o[b2] : fVar2.b() & UShort.MAX_VALUE;
                        b(i4, fVar2.b);
                    } else {
                        String strA = fVar2.a(aVar, iA);
                        int i5 = fVar2.b;
                        if (b2 > 5) {
                            int iB = fVar2.b() & UShort.MAX_VALUE;
                            if ((bA & c.b) == 0) {
                                z3 = false;
                            }
                            if (z3 && iB != 32) {
                                throw new IllegalStateException("name size not match");
                            }
                            if (b2 == 6) {
                                this.C.put(strA, new b.i(i4, i5 + 2, z3 ? fVar2.d(iB) : fVar2.a(aVar, iB), iB, z3));
                            } else if (b2 == 7) {
                                if (z3) {
                                    objB = fVar2.d(iB);
                                } else {
                                    objB = new byte[iB];
                                    System.arraycopy(fVar2.a, fVar2.b, objB, 0, iB);
                                    fVar2.b += iB;
                                    if (aVar != null) {
                                        objB = aVar.b();
                                    }
                                }
                                this.C.put(strA, new b.a(i4, i5 + 2, objB, iB, z3));
                            } else if (z3) {
                                this.C.put(strA, new b.h(i4, i5 + 2, fVar2.d(iB), iB, true));
                            } else {
                                if (aVar == null) {
                                    fVar = this.E;
                                    length = iB;
                                } else {
                                    System.arraycopy(this.E.a, this.E.b, new byte[iB], 0, iB);
                                    byte[] bArrB = aVar.b();
                                    f fVar3 = new f(bArrB);
                                    length = bArrB.length;
                                    fVar = fVar3;
                                }
                                int iA2 = fVar.a() & UByte.MAX_VALUE;
                                String strD = fVar.d(iA2);
                                com.anythink.core.common.s.a.a.b bVar = this.x.get(strD);
                                int i6 = length - (iA2 + 1);
                                if (i6 >= 0) {
                                    if (bVar != null) {
                                        try {
                                            i2 = iB;
                                            i3 = i5;
                                            try {
                                                b.h hVar = new b.h(i4, i5 + 2, bVar.a(fVar.a, fVar.b, i6), iB, false);
                                                hVar.b = bVar;
                                                this.C.put(strA, hVar);
                                            } catch (Exception e2) {
                                                e = e2;
                                                a(e);
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            i2 = iB;
                                            i3 = i5;
                                        }
                                    } else {
                                        i2 = iB;
                                        i3 = i5;
                                        b("object with tag: " + strD + " without encoder");
                                    }
                                    fVar2.b = i3 + 2 + i2;
                                } else {
                                    throw new Exception(b);
                                }
                            }
                        } else if (b2 == 1) {
                            HashMap<String, b.AbstractC0101b> map = this.C;
                            if (fVar2.a() != 1) {
                                z3 = false;
                            }
                            map.put(strA, new b.c(i5, z3));
                        } else if (b2 == 2) {
                            this.C.put(strA, new b.f(i5, fVar2.a(aVar)));
                        } else if (b2 == 3) {
                            this.C.put(strA, new b.e(i5, Float.intBitsToFloat(fVar2.a(aVar))));
                        } else if (b2 == 4) {
                            this.C.put(strA, new b.g(i5, fVar2.b(aVar)));
                        } else {
                            this.C.put(strA, new b.d(i5, Double.longBitsToDouble(fVar2.b(aVar))));
                        }
                    }
                } else {
                    int i7 = fVar2.b;
                    int i8 = this.A;
                    if (i7 != i8) {
                        a(new Exception(b));
                        return false;
                    }
                    if (!z && this.z != null && i8 != 12) {
                        z2 = true;
                    }
                    this.I = z2;
                    return true;
                }
            } catch (Exception e4) {
                a(e4);
                return false;
            }
        }
    }

    private void a(int i2, String str, int i3, int i4, com.anythink.core.common.s.a.a.a aVar) throws Exception {
        int length;
        f fVar;
        if (aVar == null) {
            fVar = this.E;
            length = i2;
        } else {
            System.arraycopy(this.E.a, this.E.b, new byte[i2], 0, i2);
            byte[] bArrB = aVar.b();
            f fVar2 = new f(bArrB);
            length = bArrB.length;
            fVar = fVar2;
        }
        int iA = fVar.a() & UByte.MAX_VALUE;
        String strD = fVar.d(iA);
        com.anythink.core.common.s.a.a.b bVar = this.x.get(strD);
        int i5 = length - (iA + 1);
        if (i5 < 0) {
            throw new Exception(b);
        }
        if (bVar != null) {
            try {
                b.h hVar = new b.h(i3, i4 + 2, bVar.a(fVar.a, fVar.b, i5), i2, false);
                hVar.b = bVar;
                this.C.put(str, hVar);
                return;
            } catch (Exception e2) {
                a(e2);
                return;
            }
        }
        b("object with tag: " + strD + " without encoder");
    }

    private static void h(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("key is empty");
        }
    }

    private static void f(int i2) {
        if (i2 > 255) {
            throw new IllegalArgumentException("key's length must less than 256");
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.s.a.a$a, reason: collision with other inner class name */
    protected static class C0100a implements Comparable<C0100a> {
        int a;
        int b;

        @Override // java.lang.Comparable
        public final /* bridge */ /* synthetic */ int compareTo(C0100a c0100a) {
            return this.a - c0100a.a;
        }

        C0100a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        private int a(C0100a c0100a) {
            return this.a - c0100a.a;
        }
    }

    private static void a(ArrayList<C0100a> arrayList) {
        Collections.sort(arrayList);
        int i2 = 0;
        C0100a c0100a = arrayList.get(0);
        int size = arrayList.size();
        for (int i3 = 1; i3 < size; i3++) {
            C0100a c0100a2 = arrayList.get(i3);
            if (c0100a2.a == c0100a.b) {
                c0100a.b = c0100a2.b;
            } else {
                i2++;
                if (i2 != i3) {
                    arrayList.set(i2, c0100a2);
                }
                c0100a = c0100a2;
            }
        }
        int i4 = i2 + 1;
        if (size > i4) {
            arrayList.subList(i4, size).clear();
        }
    }

    protected final void c(int i2) {
        ArrayList<C0100a> arrayList = this.Q;
        Collections.sort(arrayList);
        C0100a c0100a = arrayList.get(0);
        int size = arrayList.size();
        int i3 = 0;
        for (int i4 = 1; i4 < size; i4++) {
            C0100a c0100a2 = arrayList.get(i4);
            if (c0100a2.a == c0100a.b) {
                c0100a.b = c0100a2.b;
            } else {
                i3++;
                if (i3 != i4) {
                    arrayList.set(i3, c0100a2);
                }
                c0100a = c0100a2;
            }
        }
        int i5 = i3 + 1;
        if (size > i5) {
            arrayList.subList(i5, size).clear();
        }
        C0100a c0100a3 = this.Q.get(0);
        int i6 = c0100a3.a;
        int i7 = this.A;
        int i8 = i7 - this.P;
        int i9 = i8 - 12;
        int i10 = i8 - i6;
        int i11 = i7 - i6;
        boolean z = i9 < i11 + i10;
        if (!z) {
            this.B ^= this.E.b(i6, i11);
        }
        int size2 = this.Q.size();
        int i12 = size2 - 1;
        int i13 = this.A - this.Q.get(i12).b;
        int i14 = i13 > 0 ? size2 : i12;
        int[] iArr = new int[i14];
        int[] iArr2 = new int[i14];
        int i15 = c0100a3.a;
        int i16 = c0100a3.b;
        int i17 = 1;
        while (i17 < size2) {
            C0100a c0100a4 = this.Q.get(i17);
            int i18 = size2;
            int i19 = c0100a4.a - i16;
            int i20 = i8;
            System.arraycopy(this.E.a, i16, this.E.a, i15, i19);
            int i21 = i17 - 1;
            iArr[i21] = i16;
            iArr2[i21] = i16 - i15;
            i15 += i19;
            i16 = c0100a4.b;
            i17++;
            size2 = i18;
            i14 = i14;
            i8 = i20;
        }
        int i22 = i8;
        int i23 = i14;
        if (i13 > 0) {
            System.arraycopy(this.E.a, i16, this.E.a, i15, i13);
            iArr[i12] = i16;
            iArr2[i12] = i16 - i15;
        }
        e();
        if (z) {
            this.B = this.E.b(12, i9);
        } else {
            this.B ^= this.E.b(i6, i10);
        }
        this.A = i22;
        a(i6, i2, i10);
        for (b.AbstractC0101b abstractC0101b : this.C.values()) {
            if (abstractC0101b.a > i6) {
                int i24 = abstractC0101b.a;
                int i25 = i23 - 1;
                int i26 = 0;
                while (i26 <= i25) {
                    int i27 = (i26 + i25) >>> 1;
                    int i28 = iArr[i27];
                    if (i28 >= i24) {
                        if (i28 <= i24) {
                            i25 = i27;
                            break;
                        }
                        i25 = i27 - 1;
                    } else {
                        i26 = i27 + 1;
                    }
                }
                int i29 = iArr2[i25];
                abstractC0101b.a -= i29;
                if (abstractC0101b.a() >= 6) {
                    ((b.j) abstractC0101b).d -= i29;
                }
            }
        }
        c(h);
    }

    private void a(int i2, int[] iArr, int[] iArr2) {
        for (b.AbstractC0101b abstractC0101b : this.C.values()) {
            if (abstractC0101b.a > i2) {
                int i3 = abstractC0101b.a;
                int length = iArr.length - 1;
                int i4 = 0;
                while (i4 <= length) {
                    int i5 = (i4 + length) >>> 1;
                    int i6 = iArr[i5];
                    if (i6 >= i3) {
                        if (i6 <= i3) {
                            length = i5;
                            break;
                        }
                        length = i5 - 1;
                    } else {
                        i4 = i5 + 1;
                    }
                }
                int i7 = iArr2[length];
                abstractC0101b.a -= i7;
                if (abstractC0101b.a() >= 6) {
                    ((b.j) abstractC0101b).d -= i7;
                }
            }
        }
    }

    protected final void a(File file, File file2) {
        try {
            if (a(file)) {
                return;
            }
        } catch (IOException e2) {
            b(e2);
        }
        c();
        try {
            if (a(file2)) {
                return;
            }
        } catch (IOException e3) {
            b(e3);
        }
        c();
    }

    protected final void c() {
        d();
        j();
    }

    protected void d() {
        this.A = 12;
        this.B = 0L;
        this.C.clear();
        this.M.a();
        this.L.a();
        e();
    }

    private void j() {
        f fVar = this.E;
        if (fVar == null || fVar.a.length != r) {
            this.E = new f(r);
        } else {
            this.E.a(4, 0L);
        }
        this.E.a(0, a(0));
    }

    private void b(int i2, int i3) {
        this.P += i3 - i2;
        this.Q.add(new C0100a(i2, i3));
    }

    protected final void e() {
        this.P = 0;
        this.Q.clear();
    }

    protected final void b(String str) {
        com.anythink.core.common.s.a.a.c cVar = this.y;
        if (cVar != null) {
            cVar.b(this.w, new Exception(str));
        }
    }

    protected final void a(Exception exc) {
        com.anythink.core.common.s.a.a.c cVar = this.y;
        if (cVar != null) {
            cVar.b(this.w, exc);
        }
    }

    protected final void b(Exception exc) {
        com.anythink.core.common.s.a.a.c cVar = this.y;
        if (cVar != null) {
            cVar.a(this.w, exc);
        }
    }

    protected final void c(String str) {
        com.anythink.core.common.s.a.a.c cVar = this.y;
        if (cVar != null) {
            cVar.a(this.w, str);
        }
    }

    protected final int f() {
        return this.A <= 16384 ? 8192 : 16384;
    }

    @Override // android.content.SharedPreferences
    public synchronized boolean contains(String str) {
        return this.C.containsKey(str);
    }

    private synchronized boolean i(String str) {
        return getBoolean(str, false);
    }

    @Override // android.content.SharedPreferences
    public synchronized boolean getBoolean(String str, boolean z) {
        b.AbstractC0101b abstractC0101b = this.C.get(str);
        if (abstractC0101b != null && abstractC0101b.a() == 1) {
            return ((b.c) abstractC0101b).b;
        }
        return z;
    }

    private int j(String str) {
        return getInt(str, 0);
    }

    @Override // android.content.SharedPreferences
    public synchronized int getInt(String str, int i2) {
        b.AbstractC0101b abstractC0101b = this.C.get(str);
        if (abstractC0101b != null && abstractC0101b.a() == 2) {
            return ((b.f) abstractC0101b).b;
        }
        return i2;
    }

    private float k(String str) {
        return getFloat(str, 0.0f);
    }

    @Override // android.content.SharedPreferences
    public synchronized float getFloat(String str, float f2) {
        b.AbstractC0101b abstractC0101b = this.C.get(str);
        if (abstractC0101b != null && abstractC0101b.a() == 3) {
            return ((b.e) abstractC0101b).b;
        }
        return f2;
    }

    private long l(String str) {
        return getLong(str, 0L);
    }

    @Override // android.content.SharedPreferences
    public synchronized long getLong(String str, long j2) {
        b.AbstractC0101b abstractC0101b = this.C.get(str);
        if (abstractC0101b != null && abstractC0101b.a() == 4) {
            return ((b.g) abstractC0101b).b;
        }
        return j2;
    }

    private double m(String str) {
        return a(str, 0.0d);
    }

    public final synchronized double a(String str, double d2) {
        b.AbstractC0101b abstractC0101b = this.C.get(str);
        if (abstractC0101b != null && abstractC0101b.a() == 5) {
            return ((b.d) abstractC0101b).b;
        }
        return d2;
    }

    private String n(String str) {
        return getString(str, "");
    }

    @Override // android.content.SharedPreferences
    public synchronized String getString(String str, String str2) {
        b.AbstractC0101b abstractC0101b = this.C.get(str);
        if (abstractC0101b != null && abstractC0101b.a() == 6) {
            b.i iVar = (b.i) abstractC0101b;
            if (iVar.f) {
                Object objA = this.M.a(str);
                if (objA instanceof String) {
                    return (String) objA;
                }
                String strA = a(iVar, this.z);
                if (strA != null && !strA.isEmpty()) {
                    this.M.a(str, strA);
                    return strA;
                }
                remove(str);
                return str2;
            }
            return (String) iVar.c;
        }
        return str2;
    }

    private String a(b.i iVar, com.anythink.core.common.s.a.a.a aVar) {
        String str = (String) iVar.c;
        byte[] bArrB = (byte[]) this.L.a(str);
        if (bArrB == null) {
            try {
                bArrB = l.b(new File(this.v + this.w, str));
            } catch (Exception e2) {
                a(e2);
            }
        }
        if (bArrB != null) {
            if (aVar != null) {
                bArrB = aVar.b();
            }
            if (bArrB != null) {
                return new String(bArrB, StandardCharsets.UTF_8);
            }
            return null;
        }
        return null;
    }

    private byte[] o(String str) {
        return b(str, S);
    }

    private synchronized byte[] b(String str, byte[] bArr) {
        b.AbstractC0101b abstractC0101b = this.C.get(str);
        if (abstractC0101b != null && abstractC0101b.a() == 7) {
            b.a aVar = (b.a) abstractC0101b;
            if (aVar.f) {
                Object objA = this.M.a(str);
                if (objA instanceof byte[]) {
                    return (byte[]) objA;
                }
                byte[] bArrA = a(aVar, this.z);
                if (bArrA != null && bArrA.length != 0) {
                    this.M.a(str, bArrA);
                    return bArrA;
                }
                remove(str);
                return bArr;
            }
            return (byte[]) aVar.c;
        }
        return bArr;
    }

    private byte[] a(b.a aVar, com.anythink.core.common.s.a.a.a aVar2) {
        String str = (String) aVar.c;
        byte[] bArrB = (byte[]) this.L.a(str);
        if (bArrB == null) {
            try {
                bArrB = l.b(new File(this.v + this.w, str));
            } catch (Exception e2) {
                a(e2);
                return null;
            }
        }
        if (bArrB != null) {
            return aVar2 != null ? aVar2.b() : bArrB;
        }
        return null;
    }

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
    public final synchronized <T> T d(String str) {
        b.AbstractC0101b abstractC0101b = this.C.get(str);
        if (abstractC0101b != null && abstractC0101b.a() == 8) {
            b.h hVar = (b.h) abstractC0101b;
            if (hVar.f) {
                T t2 = (T) this.M.a(str);
                if (t2 != null) {
                    return t2;
                }
                T t3 = (T) a(hVar, this.z);
                if (t3 == null) {
                    remove(str);
                    return null;
                }
                this.M.a(str, t3);
                return t3;
            }
            return (T) hVar.c;
        }
        return null;
    }

    private Object a(b.h hVar, com.anythink.core.common.s.a.a.a aVar) {
        String str = (String) hVar.c;
        byte[] bArrB = (byte[]) this.L.a(str);
        if (bArrB == null) {
            try {
                bArrB = l.b(new File(this.v + this.w, str));
            } catch (Exception e2) {
                a(e2);
                return null;
            }
        }
        if (bArrB != null) {
            if (aVar != null) {
                bArrB = aVar.b();
            }
            int i2 = bArrB[0] & UByte.MAX_VALUE;
            String strA = this.E.a(bArrB, 1, i2);
            com.anythink.core.common.s.a.a.b bVar = this.x.get(strA);
            if (bVar != null) {
                hVar.b = bVar;
                int i3 = i2 + 1;
                return bVar.a(bArrB, i3, bArrB.length - i3);
            }
            b(new Exception("No encoder for tag:".concat(String.valueOf(strA))));
            return null;
        }
        b(new Exception("Read object data failed"));
        return null;
    }

    private synchronized Set<String> p(String str) {
        return (Set) d(str);
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        Set<String> setP = p(str);
        return setP != null ? setP : set;
    }

    @Override // android.content.SharedPreferences.Editor
    public synchronized SharedPreferences.Editor putBoolean(String str, boolean z) {
        if (this.J) {
            return this;
        }
        h(str);
        g();
        b.AbstractC0101b abstractC0101b = this.C.get(str);
        int i2 = 1;
        if (abstractC0101b != null && abstractC0101b.a() != 1) {
            remove(str);
            abstractC0101b = null;
        }
        b.c cVar = (b.c) abstractC0101b;
        if (cVar == null) {
            if (!a(str, (byte) 1)) {
                return this;
            }
            int i3 = this.E.b;
            f fVar = this.E;
            if (!z) {
                i2 = 0;
            }
            fVar.a((byte) i2);
            i();
            this.C.put(str, new b.c(i3, z));
            f(str);
        } else if (cVar.b != z) {
            cVar.b = z;
            if (!z) {
                i2 = 0;
            }
            a((byte) i2, cVar.a);
            f(str);
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public synchronized SharedPreferences.Editor putInt(String str, int i2) {
        if (this.J) {
            return this;
        }
        h(str);
        g();
        b.AbstractC0101b abstractC0101b = this.C.get(str);
        if (abstractC0101b != null && abstractC0101b.a() != 2) {
            remove(str);
            abstractC0101b = null;
        }
        b.f fVar = (b.f) abstractC0101b;
        if (fVar == null) {
            if (!a(str, (byte) 2)) {
                return this;
            }
            int i3 = this.E.b;
            f fVar2 = this.E;
            com.anythink.core.common.s.a.a.a aVar = this.z;
            fVar2.b(aVar != null ? aVar.c() : i2);
            i();
            this.C.put(str, new b.f(i3, i2));
            f(str);
        } else if (fVar.b != i2) {
            com.anythink.core.common.s.a.a.a aVar2 = this.z;
            int iC = aVar2 != null ? aVar2.c() : i2;
            int iA = this.z != null ? this.E.a(fVar.a) : fVar.b;
            fVar.b = i2;
            a(iC, ((long) (iA ^ iC)) & 4294967295L, fVar.a);
            f(str);
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public synchronized SharedPreferences.Editor putFloat(String str, float f2) {
        if (this.J) {
            return this;
        }
        h(str);
        g();
        b.AbstractC0101b abstractC0101b = this.C.get(str);
        if (abstractC0101b != null && abstractC0101b.a() != 3) {
            remove(str);
            abstractC0101b = null;
        }
        b.e eVar = (b.e) abstractC0101b;
        if (eVar == null) {
            if (!a(str, (byte) 3)) {
                return this;
            }
            int i2 = this.E.b;
            this.E.b(a(f2));
            i();
            this.C.put(str, new b.e(i2, f2));
            f(str);
        } else if (eVar.b != f2) {
            int iA = a(f2);
            long jA = ((long) (this.E.a(eVar.a) ^ iA)) & 4294967295L;
            eVar.b = f2;
            a(iA, jA, eVar.a);
            f(str);
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public synchronized SharedPreferences.Editor putLong(String str, long j2) {
        if (this.J) {
            return this;
        }
        h(str);
        g();
        b.AbstractC0101b abstractC0101b = this.C.get(str);
        if (abstractC0101b != null && abstractC0101b.a() != 4) {
            remove(str);
            abstractC0101b = null;
        }
        b.g gVar = (b.g) abstractC0101b;
        if (gVar == null) {
            if (!a(str, (byte) 4)) {
                return this;
            }
            int i2 = this.E.b;
            f fVar = this.E;
            com.anythink.core.common.s.a.a.a aVar = this.z;
            fVar.a(aVar != null ? aVar.e() : j2);
            i();
            this.C.put(str, new b.g(i2, j2));
            f(str);
        } else if (gVar.b != j2) {
            com.anythink.core.common.s.a.a.a aVar2 = this.z;
            long jE = aVar2 != null ? aVar2.e() : j2;
            long jC = this.z != null ? this.E.c(gVar.a) : gVar.b;
            gVar.b = j2;
            a(jE, jC ^ jE, gVar.a);
            f(str);
        }
        return this;
    }

    public final synchronized SharedPreferences.Editor b(String str, double d2) {
        if (this.J) {
            return this;
        }
        h(str);
        g();
        b.AbstractC0101b abstractC0101b = this.C.get(str);
        if (abstractC0101b != null && abstractC0101b.a() != 5) {
            remove(str);
            abstractC0101b = null;
        }
        b.d dVar = (b.d) abstractC0101b;
        if (dVar == null) {
            if (!a(str, (byte) 5)) {
                return this;
            }
            int i2 = this.E.b;
            this.E.a(a(d2));
            i();
            this.C.put(str, new b.d(i2, d2));
            f(str);
        } else if (dVar.b != d2) {
            long jA = a(d2);
            long jC = jA ^ this.E.c(dVar.a);
            dVar.b = d2;
            a(jA, jC, dVar.a);
            f(str);
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public synchronized SharedPreferences.Editor putString(String str, String str2) {
        if (this.J) {
            return this;
        }
        h(str);
        if (str2 == null) {
            remove(str);
        } else {
            b.AbstractC0101b abstractC0101b = this.C.get(str);
            String str3 = null;
            if (abstractC0101b != null && abstractC0101b.a() != 6) {
                remove(str);
                abstractC0101b = null;
            }
            b.i iVar = (b.i) abstractC0101b;
            if (iVar != null && !iVar.f && str2.equals(iVar.c)) {
                return this;
            }
            g();
            if (this.z != null || str2.length() * 3 >= this.q) {
                byte[] bytes = str2.isEmpty() ? S : str2.getBytes(StandardCharsets.UTF_8);
                com.anythink.core.common.s.a.a.a aVar = this.z;
                if (aVar != null) {
                    bytes = aVar.a();
                }
                byte[] bArr = bytes;
                if (bArr == null) {
                    a(new Exception(f));
                    return this;
                }
                a(str, str2, bArr, iVar, (byte) 6);
            } else {
                int iB = f.b(str2);
                if (iVar == null) {
                    int iB2 = f.b(str);
                    f(iB2);
                    int i2 = iB2 + 4;
                    this.G = i2 + iB;
                    k();
                    this.E.a((byte) 6);
                    a(str, iB2);
                    b(str2, iB);
                    HashMap<String, b.AbstractC0101b> map = this.C;
                    int i3 = this.F;
                    map.put(str, new b.i(i3, i3 + i2, str2, iB, false));
                    i();
                } else {
                    int i4 = iVar.a - iVar.d;
                    boolean z = false;
                    if (iVar.e == iB) {
                        this.B ^= this.E.b(iVar.a, iVar.e);
                        if (iB == str2.length()) {
                            str2.getBytes(0, iB, this.E.a, iVar.a);
                        } else {
                            this.E.b = iVar.a;
                            this.E.a(str2);
                        }
                        this.F = iVar.a;
                        this.G = iB;
                    } else {
                        this.G = i4 + iB;
                        k();
                        this.E.a((byte) 6);
                        int i5 = i4 - 3;
                        System.arraycopy(this.E.a, iVar.d + 1, this.E.a, this.E.b, i5);
                        this.E.b += i5;
                        b(str2, iB);
                        a((byte) 6, iVar.d, iVar.a + iVar.e);
                        str3 = iVar.f ? (String) iVar.c : null;
                        iVar.f = false;
                        iVar.d = this.F;
                        iVar.a = this.F + i4;
                        iVar.e = iB;
                        z = true;
                    }
                    iVar.c = str2;
                    i();
                    if (z) {
                        h();
                    }
                    if (str3 != null) {
                        g(str3);
                    }
                }
            }
            f(str);
        }
        return this;
    }

    private void a(String str, String str2, b.i iVar) {
        int iB = f.b(str2);
        if (iVar == null) {
            int iB2 = f.b(str);
            f(iB2);
            int i2 = iB2 + 4;
            this.G = i2 + iB;
            k();
            this.E.a((byte) 6);
            a(str, iB2);
            b(str2, iB);
            HashMap<String, b.AbstractC0101b> map = this.C;
            int i3 = this.F;
            map.put(str, new b.i(i3, i3 + i2, str2, iB, false));
            i();
            return;
        }
        int i4 = iVar.a - iVar.d;
        String str3 = null;
        boolean z = false;
        if (iVar.e == iB) {
            this.B ^= this.E.b(iVar.a, iVar.e);
            if (iB == str2.length()) {
                str2.getBytes(0, iB, this.E.a, iVar.a);
            } else {
                this.E.b = iVar.a;
                this.E.a(str2);
            }
            this.F = iVar.a;
            this.G = iB;
        } else {
            this.G = i4 + iB;
            k();
            this.E.a((byte) 6);
            int i5 = i4 - 3;
            System.arraycopy(this.E.a, iVar.d + 1, this.E.a, this.E.b, i5);
            this.E.b += i5;
            b(str2, iB);
            a((byte) 6, iVar.d, iVar.a + iVar.e);
            str3 = iVar.f ? (String) iVar.c : null;
            iVar.f = false;
            iVar.d = this.F;
            iVar.a = this.F + i4;
            iVar.e = iB;
            z = true;
        }
        iVar.c = str2;
        i();
        if (z) {
            h();
        }
        if (str3 != null) {
            g(str3);
        }
    }

    public final synchronized SharedPreferences.Editor a(String str, byte[] bArr) {
        if (this.J) {
            return this;
        }
        h(str);
        if (bArr == null) {
            remove(str);
        } else {
            g();
            b.AbstractC0101b abstractC0101b = this.C.get(str);
            if (abstractC0101b != null && abstractC0101b.a() != 7) {
                remove(str);
                abstractC0101b = null;
            }
            b.a aVar = (b.a) abstractC0101b;
            com.anythink.core.common.s.a.a.a aVar2 = this.z;
            byte[] bArrA = aVar2 != null ? aVar2.a() : bArr;
            if (bArrA == null) {
                a(new Exception(f));
                return this;
            }
            a(str, bArr, bArrA, aVar, (byte) 7);
            f(str);
        }
        return this;
    }

    public final synchronized <T> SharedPreferences.Editor a(String str, T t2, com.anythink.core.common.s.a.a.b<T> bVar) {
        byte[] bArrA;
        if (this.J) {
            return this;
        }
        h(str);
        if (bVar == null) {
            throw new IllegalArgumentException("Encoder is null");
        }
        String strA = bVar.a();
        if (strA.isEmpty() || strA.length() > 50) {
            throw new IllegalArgumentException("Invalid encoder tag:".concat(String.valueOf(strA)));
        }
        if (!this.x.containsKey(strA)) {
            throw new IllegalArgumentException("Encoder hasn't been registered");
        }
        if (t2 == null) {
            remove(str);
            return this;
        }
        b.AbstractC0101b abstractC0101b = null;
        try {
            bArrA = bVar.a(t2);
        } catch (Exception e2) {
            a(e2);
            bArrA = null;
        }
        if (bArrA == null) {
            remove(str);
            return this;
        }
        g();
        b.AbstractC0101b abstractC0101b2 = this.C.get(str);
        if (abstractC0101b2 == null || abstractC0101b2.a() == 8) {
            abstractC0101b = abstractC0101b2;
        } else {
            remove(str);
        }
        b.h hVar = (b.h) abstractC0101b;
        int iB = f.b(strA);
        f fVar = new f(iB + 1 + bArrA.length);
        fVar.a((byte) iB);
        fVar.a(strA);
        fVar.a(bArrA);
        byte[] bArrA2 = fVar.a;
        com.anythink.core.common.s.a.a.a aVar = this.z;
        if (aVar != null) {
            bArrA2 = aVar.a();
        }
        byte[] bArr = bArrA2;
        if (bArr == null) {
            return this;
        }
        a(str, t2, bArr, hVar, (byte) 8);
        f(str);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public synchronized SharedPreferences.Editor putStringSet(String str, Set<String> set) {
        if (this.J) {
            return this;
        }
        if (set == null) {
            remove(str);
        } else {
            a(str, set, k.a);
        }
        return this;
    }

    protected final synchronized void e(final String str) {
        if (this.R.isEmpty()) {
            return;
        }
        for (final SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener : this.R) {
            this.T.post(new Runnable() { // from class: com.anythink.core.common.s.a.a$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(onSharedPreferenceChangeListener, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener, String str) {
        onSharedPreferenceChangeListener.onSharedPreferenceChanged(this, str);
    }

    @Override // android.content.SharedPreferences
    public synchronized void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (onSharedPreferenceChangeListener == null) {
            return;
        }
        if (!this.R.contains(onSharedPreferenceChangeListener)) {
            this.R.add(onSharedPreferenceChangeListener);
        }
    }

    @Override // android.content.SharedPreferences
    public synchronized void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.R.remove(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public synchronized Map<String, Object> getAll() {
        Object objValueOf;
        int size = this.C.size();
        if (size == 0) {
            return new HashMap();
        }
        HashMap map = new HashMap(((size * 4) / 3) + 1);
        for (Map.Entry<String, b.AbstractC0101b> entry : this.C.entrySet()) {
            String key = entry.getKey();
            b.AbstractC0101b value = entry.getValue();
            switch (value.a()) {
                case 1:
                    objValueOf = Boolean.valueOf(((b.c) value).b);
                    break;
                case 2:
                    objValueOf = Integer.valueOf(((b.f) value).b);
                    break;
                case 3:
                    objValueOf = Float.valueOf(((b.e) value).b);
                    break;
                case 4:
                    objValueOf = Long.valueOf(((b.g) value).b);
                    break;
                case 5:
                    objValueOf = Double.valueOf(((b.d) value).b);
                    break;
                case 6:
                    b.i iVar = (b.i) value;
                    objValueOf = iVar.f ? a(iVar, this.z) : iVar.c;
                    break;
                case 7:
                    b.a aVar = (b.a) value;
                    objValueOf = aVar.f ? a(aVar, this.z) : aVar.c;
                    break;
                case 8:
                    b.h hVar = (b.h) value;
                    objValueOf = hVar.f ? a(hVar, this.z) : ((b.h) value).c;
                    break;
                default:
                    objValueOf = null;
                    break;
            }
            if (objValueOf != null) {
                map.put(key, objValueOf);
            }
        }
        return map;
    }

    public synchronized void a(Map<String, Object> map, Map<Class, com.anythink.core.common.s.a.a.b> map2) {
        if (this.J) {
            return;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key != null && !key.isEmpty()) {
                if (value instanceof String) {
                    putString(key, (String) value);
                } else if (value instanceof Boolean) {
                    putBoolean(key, ((Boolean) value).booleanValue());
                } else if (value instanceof Integer) {
                    putInt(key, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    putLong(key, ((Long) value).longValue());
                } else if (value instanceof Float) {
                    putFloat(key, ((Float) value).floatValue());
                } else if (value instanceof Double) {
                    b(key, ((Double) value).doubleValue());
                } else if (value instanceof byte[]) {
                    a(key, (byte[]) value);
                } else {
                    if (value instanceof Set) {
                        Set<String> set = (Set) value;
                        if (set.isEmpty() || (set.iterator().next() instanceof String)) {
                            putStringSet(key, set);
                        }
                    }
                    if (map2 != null) {
                        com.anythink.core.common.s.a.a.b bVar = map2.get(value.getClass());
                        if (bVar != null) {
                            a(key, value, (com.anythink.core.common.s.a.a.b<Object>) bVar);
                        } else {
                            b(new Exception("missing encoder for type:" + value.getClass()));
                        }
                    } else {
                        b(new Exception("missing encoders"));
                    }
                }
            }
        }
    }

    private void a(Map<String, Object> map) {
        a(map, (Map<Class, com.anythink.core.common.s.a.a.b>) null);
    }

    private void a(String str, Object obj, Map<Class, com.anythink.core.common.s.a.a.b> map) {
        if (obj instanceof Set) {
            Set<String> set = (Set) obj;
            if (set.isEmpty() || (set.iterator().next() instanceof String)) {
                putStringSet(str, set);
                return;
            }
        }
        if (map != null) {
            com.anythink.core.common.s.a.a.b bVar = map.get(obj.getClass());
            if (bVar != null) {
                a(str, obj, (com.anythink.core.common.s.a.a.b<Object>) bVar);
                return;
            } else {
                b(new Exception("missing encoder for type:" + obj.getClass()));
                return;
            }
        }
        b(new Exception("missing encoders"));
    }

    private void k() {
        d(this.G);
        int i2 = this.A;
        this.F = i2;
        this.A = this.G + i2;
        this.E.b = i2;
    }

    private boolean a(String str, byte b2) {
        return a(str, b2, o[b2]);
    }

    private boolean a(String str, byte b2, int i2) {
        if (this.z != null) {
            com.anythink.core.common.s.a.a.a aVar = this.z;
            str.getBytes(StandardCharsets.UTF_8);
            byte[] bArrA = aVar.a();
            if (bArrA == null) {
                a(new Exception(f));
                return false;
            }
            int length = bArrA.length;
            a(length, i2, b2);
            this.E.a((byte) length);
            System.arraycopy(bArrA, 0, this.E.a, this.E.b, length);
            this.E.b += length;
            return true;
        }
        int iB = f.b(str);
        a(iB, i2, b2);
        a(str, iB);
        return true;
    }

    private void a(int i2, int i3, byte b2) {
        f(i2);
        this.G = i2 + 2 + i3;
        k();
        this.E.a(b2);
    }

    private void a(String str, int i2) {
        this.E.a((byte) i2);
        if (i2 == str.length()) {
            str.getBytes(0, i2, this.E.a, this.E.b);
            this.E.b += i2;
            return;
        }
        this.E.a(str);
    }

    protected void a(byte b2, int i2, int i3) {
        b(i2, i3);
        byte b3 = (byte) (b2 | (-128));
        this.B ^= (((long) (this.E.a[i2] ^ b3)) & 255) << ((i2 & 7) << 3);
        this.E.a[i2] = b3;
    }

    protected void a(int i2, byte[] bArr) {
        int length = bArr.length;
        this.B ^= this.E.b(i2, length);
        this.E.b = i2;
        this.E.a(bArr);
        this.B = this.E.b(i2, length) ^ this.B;
    }

    private int a(float f2) {
        int iFloatToRawIntBits = Float.floatToRawIntBits(f2);
        com.anythink.core.common.s.a.a.a aVar = this.z;
        return aVar != null ? aVar.c() : iFloatToRawIntBits;
    }

    private long a(double d2) {
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d2);
        com.anythink.core.common.s.a.a.a aVar = this.z;
        return aVar != null ? aVar.e() : jDoubleToRawLongBits;
    }

    private void b(String str, int i2) {
        this.E.a((short) i2);
        if (i2 == str.length()) {
            str.getBytes(0, i2, this.E.a, this.E.b);
        } else {
            this.E.a(str);
        }
    }

    private void a(String str, Object obj, byte[] bArr, b.j jVar, byte b2) {
        if (jVar == null) {
            a(str, obj, bArr, b2);
        } else if (!jVar.f && jVar.e == bArr.length) {
            a(jVar.a, bArr);
            jVar.c = obj;
        } else {
            a(str, obj, bArr, jVar);
        }
    }

    private void a(String str, Object obj, byte[] bArr, byte b2) {
        int length;
        b.AbstractC0101b hVar;
        int iA = a(str, bArr, b2);
        if (iA > 0) {
            boolean z = this.K != null;
            if (z) {
                this.M.a(str, obj);
                obj = this.K;
                this.K = null;
                length = 32;
            } else {
                length = bArr.length;
            }
            Object obj2 = obj;
            int i2 = length;
            if (b2 == 6) {
                hVar = new b.i(this.F, iA, (String) obj2, i2, z);
            } else if (b2 == 7) {
                hVar = new b.a(this.F, iA, obj2, i2, z);
            } else {
                hVar = new b.h(this.F, iA, obj2, i2, z);
            }
            this.C.put(str, hVar);
            i();
        }
    }

    private void a(String str, Object obj, byte[] bArr, b.j jVar) {
        int iA = a(str, bArr, jVar.a());
        if (iA > 0) {
            String str2 = jVar.f ? (String) jVar.c : null;
            a(jVar.a(), jVar.d, jVar.a + jVar.e);
            boolean z = this.K != null;
            jVar.d = this.F;
            jVar.a = iA;
            jVar.f = z;
            if (z) {
                this.M.a(str, obj);
                jVar.c = this.K;
                jVar.e = 32;
                this.K = null;
            } else {
                jVar.c = obj;
                jVar.e = bArr.length;
            }
            i();
            h();
            if (str2 != null) {
                g(str2);
            }
        }
    }

    private int a(final String str, final byte[] bArr, byte b2) {
        this.K = null;
        if (bArr.length < this.q) {
            return b(str, bArr, b2);
        }
        c("Large value, key: " + str + ", size: " + bArr.length);
        final String strA = l.a();
        byte[] bArr2 = new byte[32];
        strA.getBytes(0, 32, bArr2, 0);
        int iB = b(str, bArr2, (byte) (b2 | c.b));
        if (iB > 0) {
            this.L.a(strA, bArr);
            this.N.a(strA, new e.a() { // from class: com.anythink.core.common.s.a.a$$ExternalSyntheticLambda2
                @Override // com.anythink.core.common.s.a.e.a
                public final void execute(AtomicBoolean atomicBoolean) {
                    this.f$0.a(strA, bArr, str, atomicBoolean);
                }
            });
            this.K = strA;
        }
        return iB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, byte[] bArr, String str2, AtomicBoolean atomicBoolean) {
        if (atomicBoolean.get() || l.a(new File(this.v + this.w, str), bArr, atomicBoolean)) {
            return;
        }
        c("Write large value with key:" + str2 + " failed");
    }

    private int b(String str, byte[] bArr, byte b2) {
        if (!a(str, b2, bArr.length + 2)) {
            return 0;
        }
        this.E.a((short) bArr.length);
        int i2 = this.E.b;
        this.E.a(bArr);
        return i2;
    }
}
