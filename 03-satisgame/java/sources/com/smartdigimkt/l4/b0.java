package com.smartdigimkt.l4;

import android.content.SharedPreferences;
import android.os.Looper;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 extends a {
    public static final Random P = new Random();
    public final File A;
    public RandomAccessFile B;
    public RandomAccessFile C;
    public FileChannel D;
    public FileChannel E;
    public MappedByteBuffer F;
    public FileLock G;
    public int[] H;
    public int I;
    public long J;
    public boolean K;
    public final v L;
    public volatile a0 M;
    public final HashSet N;
    public final y O;
    public final boolean y;
    public final File z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Code duplicated, block: B:26:0x00b6 A[Catch: all -> 0x00d8, TryCatch #1 {, blocks: (B:4:0x0045, B:5:0x0080, B:12:0x0091, B:14:0x0097, B:18:0x00a5, B:24:0x00b2, B:26:0x00b6, B:27:0x00bf, B:29:0x00c3, B:30:0x00c7, B:32:0x00cb, B:33:0x00d3, B:17:0x00a2, B:23:0x00af, B:8:0x0088, B:21:0x00aa), top: B:41:0x0045, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x00c3 A[Catch: all -> 0x00d8, TryCatch #1 {, blocks: (B:4:0x0045, B:5:0x0080, B:12:0x0091, B:14:0x0097, B:18:0x00a5, B:24:0x00b2, B:26:0x00b6, B:27:0x00bf, B:29:0x00c3, B:30:0x00c7, B:32:0x00cb, B:33:0x00d3, B:17:0x00a2, B:23:0x00af, B:8:0x0088, B:21:0x00aa), top: B:41:0x0045, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x00cb A[Catch: all -> 0x00d8, TryCatch #1 {, blocks: (B:4:0x0045, B:5:0x0080, B:12:0x0091, B:14:0x0097, B:18:0x00a5, B:24:0x00b2, B:26:0x00b6, B:27:0x00bf, B:29:0x00c3, B:30:0x00c7, B:32:0x00cb, B:33:0x00d3, B:17:0x00a2, B:23:0x00af, B:8:0x0088, B:21:0x00aa), top: B:41:0x0045, inners: #0 }] */
    public b0(String str, String str2, boolean z) {
        super(str, str2, null);
        File file = null;
        this.H = new int[16];
        boolean z2 = false;
        this.I = 0;
        this.K = false;
        this.L = new v();
        this.N = new HashSet();
        this.O = new y(this, Looper.getMainLooper());
        this.z = new File(str, com.smartdigimkt.p.a.a(str2, ".kva"));
        this.A = new File(str, com.smartdigimkt.p.a.a(str2, ".kvb"));
        this.y = z;
        synchronized (this) {
            System.nanoTime();
            File file2 = new File(this.a, this.b + ".kvc");
            File file3 = new File(this.a, this.b + ".tmp");
            try {
                if (file2.exists()) {
                    file = file2;
                } else if (file3.exists()) {
                    file = file3;
                }
                if (file != null) {
                    if (!a(file)) {
                        e();
                    } else if (a(this.h)) {
                        z2 = true;
                    }
                    b();
                    if (!z2) {
                    }
                    if (this.h == null) {
                        this.h = new r(c.w);
                    }
                    if (this.e == 0) {
                        this.e = 12;
                    }
                    if (this.d != null) {
                        System.nanoTime();
                        this.g.size();
                    }
                    q();
                }
            } catch (Exception e) {
                a(e);
            }
            k();
            if (this.h == null) {
                this.h = new r(c.w);
            }
            if (this.e == 0) {
                this.e = 12;
            }
            if (this.d != null) {
                System.nanoTime();
                this.g.size();
            }
            q();
        }
    }

    public final boolean a(r rVar) {
        int length = rVar.b.length;
        try {
            if (!e0.d(this.z) || !e0.d(this.A)) {
                throw new Exception("open file failed");
            }
            if (this.C == null) {
                this.C = new RandomAccessFile(this.A, "rw");
            }
            if (this.E == null) {
                this.E = this.C.getChannel();
            }
            FileLock fileLockLock = this.G == null ? this.E.lock() : null;
            try {
                g();
                this.F.put(rVar.b, 0, this.e);
                j();
                long j = length;
                if (this.C.length() != j) {
                    this.C.setLength(j);
                }
                this.E.truncate(j);
                c(0, this.e);
                this.E.force(false);
                if (fileLockLock != null) {
                    fileLockLock.release();
                }
                q();
                return true;
            } catch (Throwable th) {
                if (fileLockLock != null) {
                    fileLockLock.release();
                }
                throw th;
            }
        } catch (Exception e) {
            a(e);
            return false;
        }
    }

    @Override // android.content.SharedPreferences.Editor
    public final void apply() {
        this.p.execute(new w(this));
    }

    public final void b(int i, int i2) {
        int i3 = this.I;
        int[] iArr = this.H;
        int length = iArr.length;
        if ((i3 << 1) >= length) {
            int[] iArr2 = new int[length << 1];
            System.arraycopy(iArr, 0, iArr2, 0, length);
            this.H = iArr2;
        }
        int[] iArr3 = this.H;
        iArr3[i3] = i;
        iArr3[i3 + 1] = i2;
        this.I = i3 + 2;
    }

    public final void c(int i, int i2) throws IOException {
        MappedByteBuffer mappedByteBuffer = this.F;
        mappedByteBuffer.position(i);
        mappedByteBuffer.limit(i2 + i);
        if (this.E.size() != mappedByteBuffer.capacity()) {
            this.E.truncate(mappedByteBuffer.capacity());
        }
        this.E.position(i);
        while (mappedByteBuffer.hasRemaining()) {
            this.E.write(mappedByteBuffer);
        }
        mappedByteBuffer.limit(mappedByteBuffer.capacity());
    }

    @Override // android.content.SharedPreferences.Editor
    public final synchronized SharedPreferences.Editor clear() {
        c();
        i();
        m();
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final boolean commit() {
        return r();
    }

    public final void d(int i) throws IOException {
        if (this.C == null) {
            this.C = new RandomAccessFile(this.A, "rw");
        }
        if (this.E == null) {
            this.E = this.C.getChannel();
        }
        long j = i;
        if (this.E.size() != j) {
            this.C.setLength(j);
            this.E.truncate(j);
        }
    }

    @Override // com.smartdigimkt.l4.c
    public final void e(String str) {
        if (this.s.isEmpty()) {
            return;
        }
        this.N.add(str);
    }

    @Override // com.smartdigimkt.l4.c
    public final void f() {
        this.f ^= this.h.a(this.i, this.j);
        int i = this.j;
        if (i != 0) {
            b(this.i, i);
            this.j = 0;
        }
    }

    public final boolean g() {
        int length = this.h.b.length;
        try {
            if (this.B == null) {
                if (!e0.d(this.z)) {
                    return false;
                }
                this.B = new RandomAccessFile(this.z, "rw");
            }
            long j = length;
            if (this.B.length() != j) {
                this.B.setLength(j);
            }
            FileChannel fileChannel = this.D;
            if (fileChannel == null) {
                this.D = this.B.getChannel();
            } else if (fileChannel.size() != j) {
                this.D.truncate(j);
            }
            MappedByteBuffer mappedByteBuffer = this.F;
            if (mappedByteBuffer != null && mappedByteBuffer.capacity() == length) {
                return true;
            }
            MappedByteBuffer map = this.D.map(FileChannel.MapMode.READ_WRITE, 0L, j);
            this.F = map;
            map.order(ByteOrder.LITTLE_ENDIAN);
            return true;
        } catch (Exception e) {
            a(e);
            return false;
        }
    }

    public final void h() throws IOException {
        File file;
        MappedByteBuffer map = this.F;
        if (map == null || (file = this.z) == null) {
            return;
        }
        int length = (int) file.length();
        if (length <= 0) {
            c("invalid file length");
            return;
        }
        if (this.F.capacity() != length) {
            long j = length;
            this.D.truncate(j);
            map = this.D.map(FileChannel.MapMode.READ_WRITE, 0L, j);
            if (map == null) {
                return;
            }
            this.F = map;
            map.order(ByteOrder.LITTLE_ENDIAN);
        }
        long j2 = length;
        if (this.E.size() != j2) {
            this.E.truncate(j2);
        }
        int iCapacity = map.capacity();
        int i = map.getInt(0);
        int i2 = (-1073741825) & i;
        boolean zC = c.c(i);
        if (i2 < 0 || i2 > iCapacity) {
            throw new IllegalStateException("Invalid file, dataSize:" + i2 + ", capacity:" + iCapacity);
        }
        long j3 = map.getLong(4);
        int i3 = i2 + 12;
        long j4 = this.J;
        if (i3 < map.capacity() - 8) {
            j4 = map.getLong(i3);
        }
        if (i3 == this.e && j3 == this.f && j4 == this.J) {
            return;
        }
        this.e = i3;
        this.f = j3;
        this.J = j4;
        HashMap map2 = this.s.isEmpty() ? null : new HashMap(this.g);
        n();
        if (j3 != this.h.a(12, i2) || !a(zC)) {
            i();
            return;
        }
        if (map2 != null) {
            HashSet hashSet = new HashSet(this.g.keySet());
            HashSet hashSet2 = new HashSet(map2.keySet());
            HashSet<String> hashSet3 = new HashSet(hashSet);
            hashSet3.retainAll(hashSet2);
            hashSet.removeAll(hashSet3);
            hashSet2.removeAll(hashSet3);
            this.N.addAll(hashSet);
            this.N.addAll(hashSet2);
            for (String str : hashSet3) {
                e eVar = (e) map2.get(str);
                e eVar2 = (e) this.g.get(str);
                if (eVar != null && !eVar.a(eVar2)) {
                    this.N.add(str);
                }
            }
            if (this.N.isEmpty()) {
                return;
            }
            l();
        }
    }

    public final void i() {
        e();
        try {
            g();
            this.F.putInt(0, 0);
            this.F.putLong(4, 0L);
            j();
            if (e0.d(this.A)) {
                d(c.w);
                c(0, 12);
                q();
            }
        } catch (Exception e) {
            a(e);
            this.K = true;
        }
        e0.a(new File(this.a + this.b));
        h(null);
    }

    public final void j() {
        MappedByteBuffer mappedByteBuffer = this.F;
        if (mappedByteBuffer == null || this.e + 8 >= mappedByteBuffer.capacity()) {
            return;
        }
        this.J = this.F.getLong(this.e);
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00d1 A[Catch: all -> 0x0197, TRY_LEAVE, TryCatch #1 {all -> 0x0197, blocks: (B:16:0x0063, B:20:0x0074, B:25:0x0087, B:70:0x0190, B:26:0x0098, B:30:0x00a4, B:32:0x00b1, B:33:0x00bf, B:35:0x00c3, B:38:0x00ca, B:41:0x00d1, B:42:0x00db, B:44:0x00e1, B:47:0x00f4, B:48:0x00f9, B:50:0x0104, B:53:0x011c, B:55:0x012c, B:57:0x0134, B:59:0x0159, B:61:0x015f, B:62:0x016b, B:65:0x0174, B:68:0x0184, B:69:0x0188, B:52:0x010f, B:19:0x0071, B:76:0x019a), top: B:89:0x0063, outer: #2, inners: #0, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00e1 A[Catch: Exception -> 0x00f3, all -> 0x0197, TRY_LEAVE, TryCatch #4 {Exception -> 0x00f3, blocks: (B:42:0x00db, B:44:0x00e1), top: B:94:0x00db, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0188 A[Catch: all -> 0x0197, TryCatch #1 {all -> 0x0197, blocks: (B:16:0x0063, B:20:0x0074, B:25:0x0087, B:70:0x0190, B:26:0x0098, B:30:0x00a4, B:32:0x00b1, B:33:0x00bf, B:35:0x00c3, B:38:0x00ca, B:41:0x00d1, B:42:0x00db, B:44:0x00e1, B:47:0x00f4, B:48:0x00f9, B:50:0x0104, B:53:0x011c, B:55:0x012c, B:57:0x0134, B:59:0x0159, B:61:0x015f, B:62:0x016b, B:65:0x0174, B:68:0x0184, B:69:0x0188, B:52:0x010f, B:19:0x0071, B:76:0x019a), top: B:89:0x0063, outer: #2, inners: #0, #3, #4 }] */
    public final void k() {
        int i;
        int i2 = 0;
        while (true) {
            try {
                if ((e0.d(this.z) && e0.d(this.A)) || i2 >= 3) {
                    break;
                }
                Thread.sleep(20L);
                i2++;
            } catch (Throwable th) {
                if (th instanceof Exception) {
                    a(th);
                }
                e();
                return;
            }
        }
        if (this.z.exists() && this.A.exists()) {
            this.B = new RandomAccessFile(this.z, "rw");
            this.C = new RandomAccessFile(this.A, "rw");
            long length = this.B.length();
            long length2 = this.C.length();
            this.D = this.B.getChannel();
            FileChannel channel = this.C.getChannel();
            this.E = channel;
            FileLock fileLockLock = channel.lock();
            try {
                try {
                    MappedByteBuffer map = this.D.map(FileChannel.MapMode.READ_WRITE, 0L, length > 0 ? length : c.w);
                    this.F = map;
                    map.order(ByteOrder.LITTLE_ENDIAN);
                    if (length == 0 && length2 == 0) {
                        this.e = 12;
                        RandomAccessFile randomAccessFile = this.C;
                        long j = c.w;
                        randomAccessFile.setLength(j);
                        this.E.truncate(j);
                    } else if (!a(this.A)) {
                        this.I = 0;
                        super.d();
                        this.J = 0L;
                        r rVar = this.h;
                        if (rVar == null || rVar.b.length != this.F.capacity()) {
                            this.h = new r(this.F.capacity());
                        }
                        int i3 = this.F.getInt();
                        int i4 = (-1073741825) & i3;
                        boolean zC = c.c(i3);
                        if (i4 < 0 || i4 > length - 12) {
                            c("both files error");
                            i();
                        } else {
                            this.e = i4 + 12;
                            long j2 = this.F.getLong(4);
                            this.F.rewind();
                            this.F.get(this.h.b, 0, this.e);
                            if (j2 == this.h.a(12, i4) && a(zC)) {
                                this.f = j2;
                                b(new Exception("B file error"));
                                try {
                                    if (e0.d(this.A)) {
                                        d(this.F.capacity());
                                        c(0, this.e);
                                    }
                                } catch (Exception e) {
                                    a(e);
                                }
                            } else {
                                c("both files error");
                                i();
                            }
                        }
                    } else if (length == length2 && this.h.b.length == this.F.capacity()) {
                        byte[] bArr = this.h.b;
                        int i5 = this.e;
                        byte[] bArr2 = new byte[i5];
                        this.F.get(bArr2, 0, i5);
                        int i6 = 0;
                        while (true) {
                            i = this.e;
                            if (i6 >= i || bArr2[i6] != bArr[i6]) {
                                break;
                                break;
                            }
                            i6++;
                        }
                        if (i6 != i) {
                            b(new Exception("A file error"));
                            if (g()) {
                                this.F.position(0);
                                this.F.put(this.h.b, 0, this.e);
                            }
                        }
                    } else {
                        b(new Exception("A file error"));
                        try {
                            if (g()) {
                                this.F.position(0);
                                this.F.put(this.h.b, 0, this.e);
                            }
                        } catch (Exception e2) {
                            a(e2);
                        }
                    }
                    j();
                    fileLockLock.release();
                    return;
                } catch (IOException e3) {
                    a(e3);
                    a(this.z, this.A);
                    fileLockLock.release();
                    return;
                }
            } catch (Throwable th2) {
                fileLockLock.release();
                throw th2;
            }
        }
        a(new Exception("open file failed"));
    }

    public final synchronized void l() {
        if (!this.N.isEmpty()) {
            Iterator it = this.N.iterator();
            while (it.hasNext()) {
                h((String) it.next());
            }
            this.N.clear();
        }
    }

    public final synchronized void m() {
        FileLock fileLock = this.G;
        if (fileLock != null) {
            try {
                fileLock.release();
            } catch (Exception e) {
                a(e);
            }
            this.G = null;
            this.O.removeMessages(2);
        }
    }

    public final void n() {
        this.g.clear();
        this.q = 0;
        this.r.clear();
        int iCapacity = this.F.capacity();
        r rVar = this.h;
        if (rVar == null) {
            this.h = new r(iCapacity);
        } else if (rVar.b.length != iCapacity) {
            rVar.b = new byte[iCapacity];
        }
        this.F.rewind();
        this.F.get(this.h.b, 0, this.e);
    }

    public final void o() {
        if (this.F == null) {
            return;
        }
        n();
        j();
        r rVar = this.h;
        rVar.c = 0;
        int iA = rVar.a();
        int i = (-1073741825) & iA;
        boolean zC = c.c(iA);
        r rVar2 = this.h;
        long jA = rVar2.a(rVar2.c);
        rVar2.c += 8;
        this.f = jA;
        this.e = i + 12;
        if (jA == this.h.a(12, i) && a(zC)) {
            return;
        }
        i();
    }

    public final void p() {
        int i = c.w;
        int iA = c.a(i, this.e + i);
        byte[] bArr = this.h.b;
        if (iA >= bArr.length) {
            return;
        }
        byte[] bArr2 = new byte[iA];
        System.arraycopy(bArr, 0, bArr2, 0, this.e);
        this.h.b = bArr2;
        try {
            long j = iA;
            this.D.truncate(j);
            MappedByteBuffer map = this.D.map(FileChannel.MapMode.READ_WRITE, 0L, j);
            this.F = map;
            map.order(ByteOrder.LITTLE_ENDIAN);
            this.C.setLength(j);
            this.E.truncate(j);
        } catch (Exception e) {
            a(new Exception("map failed", e));
            this.K = true;
        }
    }

    public final void q() {
        File file;
        if (this.y && this.M == null && (file = this.A) != null && file.exists()) {
            this.M = new a0(this, this.A.getPath());
            this.M.startWatching();
        }
    }

    public final synchronized boolean r() {
        boolean zA;
        if (this.G == null) {
            return false;
        }
        r rVar = this.h;
        if (rVar == null || (this.I == 0 && !this.K)) {
            m();
            return false;
        }
        try {
            int i = this.e - 12;
            rVar.b(0, i);
            this.h.a(4, this.f);
            if (this.K) {
                r rVar2 = this.h;
                rVar2.c = 0;
                int iA = rVar2.a() & (-1073741825);
                r rVar3 = this.h;
                long jA = rVar3.a(rVar3.c);
                rVar3.c += 8;
                this.f = jA;
                this.e = iA + 12;
                if (jA == this.h.a(12, iA)) {
                    zA = a(this.h);
                } else {
                    i();
                    zA = true;
                }
                if (zA) {
                    this.K = false;
                }
                this.I = 0;
                if (!this.k.isEmpty()) {
                    this.k.clear();
                }
                s();
                m();
                l();
                return zA;
            }
            if (!g()) {
                if (this.F != null) {
                    o();
                } else {
                    this.K = true;
                }
                this.I = 0;
                if (!this.k.isEmpty()) {
                    this.k.clear();
                }
                s();
                m();
                l();
                return false;
            }
            d(this.F.capacity());
            this.F.putInt(0, i);
            this.F.putLong(4, this.f);
            for (int i2 = 0; i2 < this.I; i2 += 2) {
                int[] iArr = this.H;
                int i3 = iArr[i2];
                int i4 = iArr[i2 + 1];
                byte[] bArr = this.h.b;
                this.F.position(i3);
                this.F.put(bArr, i3, i4);
            }
            if (this.e + 8 < this.F.capacity()) {
                long jNextLong = P.nextLong() ^ System.nanoTime();
                this.J = jNextLong;
                this.F.putLong(this.e, jNextLong);
            }
            c(0, 12);
            for (int i5 = 0; i5 < this.I; i5 += 2) {
                int[] iArr2 = this.H;
                c(iArr2[i5], iArr2[i5 + 1]);
            }
            if (!this.k.isEmpty()) {
                Iterator it = this.k.iterator();
                while (it.hasNext()) {
                    b((String) it.next());
                }
            }
            if (this.h.b.length - this.e > c.x) {
                p();
            }
            this.I = 0;
            if (!this.k.isEmpty()) {
                this.k.clear();
            }
            s();
            m();
            l();
            return true;
        } catch (Throwable th) {
            try {
                if (th instanceof Exception) {
                    a(th);
                }
                this.K = true;
                return false;
            } finally {
                this.I = 0;
                if (!this.k.isEmpty()) {
                    this.k.clear();
                }
                s();
                m();
                l();
            }
        }
    }

    @Override // android.content.SharedPreferences.Editor
    public final synchronized SharedPreferences.Editor remove(String str) {
        c();
        e(str);
        e eVar = (e) this.g.get(str);
        if (eVar != null) {
            this.g.remove(str);
            this.n.b(str);
            this.m.b(str);
            byte bA = eVar.a();
            String str2 = null;
            if (bA <= 5) {
                int iA = s.a(str);
                int i = eVar.a;
                int i2 = i - (iA + 2);
                super.a(bA, i2, i + c.v[bA]);
                b(i2, 1);
            } else {
                m mVar = (m) eVar;
                int i3 = mVar.c;
                super.a(bA, i3, mVar.a + mVar.d);
                b(i3, 1);
                if (mVar.e) {
                    str2 = (String) mVar.b;
                }
            }
            if (str2 != null) {
                this.k.add(str2);
            }
            a();
        }
        return this;
    }

    public final void s() {
        while (!this.o.a.isEmpty()) {
            try {
                Thread.sleep(10L);
            } catch (Exception unused) {
            }
        }
    }

    public final String toString() {
        return "MPFastKV: path:" + this.a + " name:" + this.b;
    }

    @Override // com.smartdigimkt.l4.c
    public final void d() {
        super.d();
        this.J = 0L;
    }

    @Override // com.smartdigimkt.l4.c
    public final void c() {
        if (this.G != null) {
            return;
        }
        if (this.E == null) {
            k();
            q();
        }
        FileChannel fileChannel = this.E;
        if (fileChannel != null) {
            try {
                this.G = fileChannel.lock();
                try {
                    h();
                } finally {
                    this.O.sendEmptyMessageDelayed(2, 3000L);
                }
            } catch (Exception e) {
                a(e);
            }
        }
    }

    @Override // com.smartdigimkt.l4.c
    public final void i(String str) {
        this.k.add(str);
    }

    @Override // com.smartdigimkt.l4.c
    public final void a(int i) {
        int length = this.h.b.length;
        int i2 = this.e + i + 8;
        if (i2 >= length) {
            byte[] bArr = new byte[c.a(length, i2)];
            System.arraycopy(this.h.b, 0, bArr, 0, this.e);
            this.h.b = bArr;
        }
    }

    @Override // com.smartdigimkt.l4.c
    public final void a(byte b, int i) {
        this.f ^= c.a(i, 1L);
        this.h.b[i] = b;
        b(i, 1);
    }

    @Override // com.smartdigimkt.l4.c
    public final void a(int i, int i2, long j) {
        this.f = c.a(i2, j) ^ this.f;
        this.h.b(i2, i);
        b(i2, 4);
    }

    @Override // com.smartdigimkt.l4.c
    public final void a(int i, long j, long j2) {
        this.f = c.a(i, j2) ^ this.f;
        this.h.a(i, j);
        b(i, 8);
    }

    @Override // com.smartdigimkt.l4.c
    public final void a(byte b, int i, int i2) {
        super.a(b, i, i2);
        b(i, 1);
    }

    @Override // com.smartdigimkt.l4.c
    public final void a() {
        if (this.q >= (this.e <= 16384 ? 8192 : 16384) || this.r.size() >= 80) {
            b(0);
        }
    }

    @Override // com.smartdigimkt.l4.c
    public final void a(int i, int i2, int i3) {
        for (int i4 = 0; i4 < this.I; i4 += 2) {
            int i5 = this.H[i4];
            if (i5 < i) {
                i = i5;
            }
        }
        int[] iArr = this.H;
        iArr[0] = i;
        iArr[1] = this.e - i;
        this.I = 2;
    }

    @Override // com.smartdigimkt.l4.c
    public final void a(int i, byte[] bArr) {
        int length = bArr.length;
        this.f ^= this.h.a(i, length);
        r rVar = this.h;
        rVar.c = i;
        int length2 = bArr.length;
        if (length2 > 0) {
            System.arraycopy(bArr, 0, rVar.b, i, length2);
            rVar.c += length2;
        }
        this.f ^= this.h.a(i, length);
        b(i, bArr.length);
    }
}
