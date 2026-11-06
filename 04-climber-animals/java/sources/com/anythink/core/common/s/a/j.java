package com.anythink.core.common.s.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.FileObserver;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
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
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class j extends com.anythink.core.common.s.a.a {
    private static final String S = "j";
    private static final int T = 1;
    private static final int U = 2;
    private static final int V = 3000;
    private static final Random W = new Random();
    private final boolean X;
    private final File Y;
    private final File Z;
    private RandomAccessFile aa;
    private RandomAccessFile ab;
    private FileChannel ac;
    private FileChannel ad;
    private MappedByteBuffer ae;
    private FileLock af;
    private int[] ag;
    private int ah;
    private long ai;
    private boolean aj;
    private final Executor ak;
    private volatile b al;
    private final Set<String> am;
    private final Handler an;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(j jVar) {
        jVar.C();
    }

    j(String str, String str2, com.anythink.core.common.s.a.a.b[] bVarArr, com.anythink.core.common.s.a.a.a aVar, boolean z) {
        super(str, str2, bVarArr, aVar);
        this.ag = new int[16];
        this.ah = 0;
        this.aj = false;
        this.ak = new i();
        this.am = new HashSet();
        this.an = new AnonymousClass1(Looper.getMainLooper());
        this.Y = new File(str, str2 + ".kva");
        this.Z = new File(str, str2 + ".kvb");
        this.X = z;
        long jCurrentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        j();
        Object[] objArr = new Object[1];
        Long.valueOf(SystemClock.currentThreadTimeMillis() - jCurrentThreadTimeMillis);
    }

    private synchronized void j() {
        long jNanoTime = System.nanoTime();
        if (!q()) {
            l();
        }
        if (this.E == null) {
            this.E = new f(r);
        }
        if (this.A == 0) {
            this.A = 12;
        }
        if (this.I) {
            a();
            c("rewrite data");
        }
        if (this.y != null) {
            c("loading finish, data len:" + this.A + ", get keys:" + this.C.size() + ", use time:" + ((System.nanoTime() - jNanoTime) / 1000000) + " ms");
        }
        k();
    }

    @Override // com.anythink.core.common.s.a.a
    protected final void a(g gVar) {
        a(gVar.E);
    }

    private void k() {
        File file;
        if (this.X && this.al == null && (file = this.Z) != null && file.exists()) {
            this.al = new b(this.Z.getPath());
            this.al.startWatching();
        }
    }

    private void l() {
        boolean z = false;
        int i = 0;
        while (true) {
            try {
                if ((l.a(this.Y) && l.a(this.Z)) || i >= 3) {
                    break;
                }
                Thread.sleep(20L);
                i++;
            } catch (Throwable th) {
                if (th instanceof Exception) {
                    a(th);
                }
                c();
                return;
            }
        }
        if (this.Y.exists() && this.Z.exists()) {
            this.aa = new RandomAccessFile(this.Y, "rw");
            this.ab = new RandomAccessFile(this.Z, "rw");
            long length = this.aa.length();
            long length2 = this.ab.length();
            this.ac = this.aa.getChannel();
            FileChannel channel = this.ab.getChannel();
            this.ad = channel;
            FileLock fileLockLock = channel.lock();
            try {
                MappedByteBuffer map = this.ac.map(FileChannel.MapMode.READ_WRITE, 0L, length > 0 ? length : r);
                this.ae = map;
                map.order(ByteOrder.LITTLE_ENDIAN);
                if (length == 0 && length2 == 0) {
                    this.A = 12;
                    this.ab.setLength(r);
                    this.ad.truncate(r);
                } else if (a(this.Z)) {
                    if (length == length2 && this.E.a.length == this.ae.capacity()) {
                        byte[] bArr = this.E.a;
                        byte[] bArr2 = new byte[this.A];
                        this.ae.get(bArr2, 0, this.A);
                        int i2 = 0;
                        while (i2 < this.A && bArr2[i2] == bArr[i2]) {
                            i2++;
                        }
                        if (i2 == this.A) {
                            z = true;
                        }
                    }
                    if (!z) {
                        b(new Exception("A file error"));
                        o();
                    }
                } else {
                    this.ah = 0;
                    d();
                    if (this.E == null || this.E.a.length != this.ae.capacity()) {
                        this.E = new f(this.ae.capacity());
                    }
                    int i3 = this.ae.getInt();
                    int i4 = (-1073741825) & i3;
                    boolean zB = b(i3);
                    if (i4 >= 0 && i4 <= length - 12) {
                        this.A = i4 + 12;
                        long j = this.ae.getLong(4);
                        this.ae.rewind();
                        this.ae.get(this.E.a, 0, this.A);
                        if (j == this.E.b(12, i4) && a(zB)) {
                            this.B = j;
                            z = true;
                        }
                    }
                    if (z) {
                        b(new Exception("B file error"));
                        n();
                    } else {
                        b("both files error");
                        A();
                    }
                }
                m();
                return;
            } catch (IOException e) {
                a(e);
                a(this.Y, this.Z);
                return;
            } finally {
                fileLockLock.release();
            }
        }
        a(new Exception("open file failed"));
    }

    private void m() {
        if (this.ae == null || this.A + 8 >= this.ae.capacity()) {
            return;
        }
        this.ai = this.ae.getLong(this.A);
    }

    private void n() {
        try {
            if (l.a(this.Z)) {
                e(this.ae.capacity());
                b(0, this.A);
            }
        } catch (Exception e) {
            a(e);
        }
    }

    private void o() {
        try {
            if (p()) {
                this.ae.position(0);
                this.ae.put(this.E.a, 0, this.A);
            }
        } catch (Exception e) {
            a(e);
        }
    }

    private boolean p() {
        int length = this.E.a.length;
        try {
            if (this.aa == null) {
                if (!l.a(this.Y)) {
                    return false;
                }
                this.aa = new RandomAccessFile(this.Y, "rw");
            }
            long j = length;
            if (this.aa.length() != j) {
                this.aa.setLength(j);
            }
            FileChannel fileChannel = this.ac;
            if (fileChannel == null) {
                this.ac = this.aa.getChannel();
            } else if (fileChannel.size() != j) {
                this.ac.truncate(j);
            }
            MappedByteBuffer mappedByteBuffer = this.ae;
            if (mappedByteBuffer != null && mappedByteBuffer.capacity() == length) {
                return true;
            }
            MappedByteBuffer map = this.ac.map(FileChannel.MapMode.READ_WRITE, 0L, j);
            this.ae = map;
            map.order(ByteOrder.LITTLE_ENDIAN);
            return true;
        } catch (Exception e) {
            a(e);
            return false;
        }
    }

    private boolean q() {
        File file = new File(this.v, this.w + ".kvc");
        File file2 = new File(this.v, this.w + ".tmp");
        boolean z = false;
        try {
            if (!file.exists()) {
                file = file2.exists() ? file2 : null;
            }
            if (file != null) {
                if (a(file)) {
                    if (a(this.E)) {
                        c("recover from c file");
                        z = true;
                    }
                } else {
                    c();
                }
                b();
            }
        } catch (Exception e) {
            a(e);
        }
        return z;
    }

    private boolean a(f fVar) {
        int length = fVar.a.length;
        try {
            if (!l.a(this.Y) || !l.a(this.Z)) {
                throw new Exception("open file failed");
            }
            if (this.ab == null) {
                this.ab = new RandomAccessFile(this.Z, "rw");
            }
            if (this.ad == null) {
                this.ad = this.ab.getChannel();
            }
            FileLock fileLockLock = this.af == null ? this.ad.lock() : null;
            try {
                p();
                this.ae.put(fVar.a, 0, this.A);
                m();
                long j = length;
                if (this.ab.length() != j) {
                    this.ab.setLength(j);
                }
                this.ad.truncate(j);
                b(0, this.A);
                this.ad.force(false);
                if (fileLockLock != null) {
                    fileLockLock.release();
                }
                k();
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

    private void b(int i, int i2) throws IOException {
        MappedByteBuffer mappedByteBuffer = this.ae;
        mappedByteBuffer.position(i);
        mappedByteBuffer.limit(i2 + i);
        if (this.ad.size() != mappedByteBuffer.capacity()) {
            this.ad.truncate(mappedByteBuffer.capacity());
        }
        this.ad.position(i);
        while (mappedByteBuffer.hasRemaining()) {
            this.ad.write(mappedByteBuffer);
        }
        mappedByteBuffer.limit(mappedByteBuffer.capacity());
    }

    private void c(int i, int i2) {
        byte[] bArr = this.E.a;
        this.ae.position(i);
        this.ae.put(bArr, i, i2);
    }

    @Override // android.content.SharedPreferences.Editor
    public final synchronized SharedPreferences.Editor remove(String str) {
        g();
        f(str);
        com.anythink.core.common.s.a.b.AbstractC0101b abstractC0101b = this.C.get(str);
        if (abstractC0101b != null) {
            this.C.remove(str);
            this.M.b(str);
            this.L.b(str);
            byte bA = abstractC0101b.a();
            String str2 = null;
            if (bA <= 5) {
                a(bA, abstractC0101b.a - (f.b(str) + 2), abstractC0101b.a + o[bA]);
            } else {
                com.anythink.core.common.s.a.b.j jVar = (com.anythink.core.common.s.a.b.j) abstractC0101b;
                a(bA, jVar.d, jVar.a + jVar.e);
                if (jVar.f) {
                    str2 = (String) jVar.c;
                }
            }
            if (str2 != null) {
                this.H.add(str2);
            }
            h();
        }
        return this;
    }

    @Override // com.anythink.core.common.s.a.a
    protected final void f(String str) {
        if (this.R.isEmpty()) {
            return;
        }
        this.am.add(str);
    }

    private synchronized void r() {
        if (!this.am.isEmpty()) {
            Iterator<String> it = this.am.iterator();
            while (it.hasNext()) {
                e(it.next());
            }
            this.am.clear();
        }
    }

    private synchronized void s() {
        try {
            MappedByteBuffer mappedByteBuffer = this.ae;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.force();
            }
            FileChannel fileChannel = this.ad;
            if (fileChannel != null) {
                fileChannel.force(true);
            }
        } catch (Exception e) {
            a(e);
        }
    }

    @Override // android.content.SharedPreferences.Editor
    public final boolean commit() {
        return u();
    }

    @Override // android.content.SharedPreferences.Editor
    public final void apply() {
        this.O.execute(new Runnable() { // from class: com.anythink.core.common.s.a.j$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.u();
            }
        });
    }

    private boolean t() {
        this.E.b = 0;
        int iC = this.E.c() & (-1073741825);
        this.B = this.E.d();
        this.A = iC + 12;
        if (this.B == this.E.b(12, iC)) {
            return a(this.E);
        }
        A();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean u() {
        int iA;
        if (this.af == null) {
            return false;
        }
        if (this.E == null || (this.ah == 0 && !this.aj)) {
            w();
            return false;
        }
        try {
            int iA2 = a(this.A - 12);
            this.E.a(0, iA2);
            this.E.a(4, this.B);
            if (this.aj) {
                boolean zT = t();
                if (zT) {
                    this.aj = false;
                }
                this.ah = 0;
                if (!this.H.isEmpty()) {
                    this.H.clear();
                }
                v();
                w();
                r();
                return zT;
            }
            if (!p()) {
                MappedByteBuffer mappedByteBuffer = this.ae;
                if (mappedByteBuffer == null) {
                    this.aj = true;
                } else if (mappedByteBuffer != null) {
                    y();
                    m();
                    this.E.b = 0;
                    int iC = this.E.c();
                    int i = (-1073741825) & iC;
                    boolean zB = b(iC);
                    this.B = this.E.d();
                    this.A = i + 12;
                    if (this.B != this.E.b(12, i) || !a(zB)) {
                        A();
                    }
                }
                this.ah = 0;
                if (!this.H.isEmpty()) {
                    this.H.clear();
                }
                v();
                w();
                r();
                return false;
            }
            e(this.ae.capacity());
            this.ae.putInt(0, iA2);
            this.ae.putLong(4, this.B);
            for (int i2 = 0; i2 < this.ah; i2 += 2) {
                int[] iArr = this.ag;
                int i3 = iArr[i2];
                int i4 = iArr[i2 + 1];
                byte[] bArr = this.E.a;
                this.ae.position(i3);
                this.ae.put(bArr, i3, i4);
            }
            if (this.A + 8 < this.ae.capacity()) {
                this.ai = W.nextLong() ^ System.nanoTime();
                this.ae.putLong(this.A, this.ai);
            }
            b(0, 12);
            for (int i5 = 0; i5 < this.ah; i5 += 2) {
                int[] iArr2 = this.ag;
                b(iArr2[i5], iArr2[i5 + 1]);
            }
            if (!this.H.isEmpty()) {
                Iterator<String> it = this.H.iterator();
                while (it.hasNext()) {
                    a(it.next());
                }
            }
            if (this.E.a.length - this.A > s && (iA = a(r, this.A + r)) < this.E.a.length) {
                byte[] bArr2 = new byte[iA];
                System.arraycopy(this.E.a, 0, bArr2, 0, this.A);
                this.E.a = bArr2;
                try {
                    long j = iA;
                    this.ac.truncate(j);
                    MappedByteBuffer map = this.ac.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                    this.ae = map;
                    map.order(ByteOrder.LITTLE_ENDIAN);
                    this.ab.setLength(j);
                    this.ad.truncate(j);
                } catch (Exception e) {
                    a(new Exception("map failed", e));
                    this.aj = true;
                }
                c("truncate finish");
            }
            this.ah = 0;
            if (!this.H.isEmpty()) {
                this.H.clear();
            }
            v();
            w();
            r();
            return true;
        } catch (Throwable th) {
            try {
                if (th instanceof Exception) {
                    a(th);
                }
                this.aj = true;
                return false;
            } finally {
                this.ah = 0;
                if (!this.H.isEmpty()) {
                    this.H.clear();
                }
                v();
                w();
                r();
            }
        }
        throw th;
    }

    private void v() {
        while (this.N.a()) {
            try {
                Thread.sleep(10L);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.anythink.core.common.s.a.a
    protected final void g() {
        if (this.af != null) {
            return;
        }
        if (this.ad == null) {
            l();
            k();
        }
        FileChannel fileChannel = this.ad;
        if (fileChannel != null) {
            try {
                this.af = fileChannel.lock();
                try {
                    z();
                } finally {
                    this.an.sendEmptyMessageDelayed(2, com.tapsdk.tapad.e.a.f);
                }
            } catch (Exception e) {
                a(e);
            }
        }
    }

    private synchronized void w() {
        FileLock fileLock = this.af;
        if (fileLock != null) {
            try {
                fileLock.release();
            } catch (Exception e) {
                a(e);
            }
            this.af = null;
            this.an.removeMessages(2);
        }
    }

    private void x() {
        if (this.ae == null) {
            return;
        }
        y();
        m();
        this.E.b = 0;
        int iC = this.E.c();
        int i = (-1073741825) & iC;
        boolean zB = b(iC);
        this.B = this.E.d();
        this.A = i + 12;
        if (this.B == this.E.b(12, i) && a(zB)) {
            return;
        }
        A();
    }

    private void y() {
        this.C.clear();
        e();
        int iCapacity = this.ae.capacity();
        if (this.E == null) {
            this.E = new f(iCapacity);
        } else if (this.E.a.length != iCapacity) {
            this.E.a = new byte[iCapacity];
        }
        this.ae.rewind();
        this.ae.get(this.E.a, 0, this.A);
    }

    private void z() throws IOException {
        File file;
        MappedByteBuffer map = this.ae;
        if (map == null || (file = this.Y) == null) {
            return;
        }
        int length = (int) file.length();
        if (length <= 0) {
            b("invalid file length");
            return;
        }
        if (this.ae.capacity() != length) {
            long j = length;
            this.ac.truncate(j);
            map = this.ac.map(FileChannel.MapMode.READ_WRITE, 0L, j);
            if (map == null) {
                return;
            }
            this.ae = map;
            map.order(ByteOrder.LITTLE_ENDIAN);
        }
        long j2 = length;
        if (this.ad.size() != j2) {
            this.ad.truncate(j2);
        }
        int iCapacity = map.capacity();
        int i = map.getInt(0);
        int i2 = (-1073741825) & i;
        boolean zB = b(i);
        if (i2 < 0 || i2 > iCapacity) {
            throw new IllegalStateException("Invalid file, dataSize:" + i2 + ", capacity:" + iCapacity);
        }
        long j3 = map.getLong(4);
        int i3 = i2 + 12;
        long j4 = this.ai;
        if (i3 < map.capacity() - 8) {
            j4 = map.getLong(i3);
        }
        if (i3 == this.A && j3 == this.B && j4 == this.ai) {
            return;
        }
        this.A = i3;
        this.B = j3;
        this.ai = j4;
        HashMap<String, com.anythink.core.common.s.a.b.AbstractC0101b> map2 = this.R.isEmpty() ? null : new HashMap<>(this.C);
        y();
        if (j3 != this.E.b(12, i2) || !a(zB)) {
            A();
        } else if (map2 != null) {
            a(map2);
        }
    }

    private void a(HashMap<String, com.anythink.core.common.s.a.b.AbstractC0101b> map) {
        HashSet hashSet = new HashSet(this.C.keySet());
        HashSet hashSet2 = new HashSet(map.keySet());
        HashSet<String> hashSet3 = new HashSet(hashSet);
        hashSet3.retainAll(hashSet2);
        hashSet.removeAll(hashSet3);
        hashSet2.removeAll(hashSet3);
        this.am.addAll(hashSet);
        this.am.addAll(hashSet2);
        for (String str : hashSet3) {
            com.anythink.core.common.s.a.b.AbstractC0101b abstractC0101b = map.get(str);
            com.anythink.core.common.s.a.b.AbstractC0101b abstractC0101b2 = this.C.get(str);
            if (abstractC0101b != null && !abstractC0101b.a(abstractC0101b2)) {
                this.am.add(str);
            }
        }
        if (this.am.isEmpty()) {
            return;
        }
        r();
    }

    @Override // android.content.SharedPreferences.Editor
    public final synchronized SharedPreferences.Editor clear() {
        g();
        A();
        w();
        return this;
    }

    private void A() {
        c();
        try {
            p();
            this.ae.putInt(0, a(0));
            this.ae.putLong(4, 0L);
            m();
            if (l.a(this.Z)) {
                e(r);
                b(0, 12);
                k();
            }
        } catch (Exception e) {
            a(e);
            this.aj = true;
        }
        l.c(new File(this.v + this.w));
        e((String) null);
    }

    private void e(int i) throws IOException {
        if (this.ab == null) {
            this.ab = new RandomAccessFile(this.Z, "rw");
        }
        if (this.ad == null) {
            this.ad = this.ab.getChannel();
        }
        long j = i;
        if (this.ad.size() != j) {
            this.ab.setLength(j);
            this.ad.truncate(j);
        }
    }

    @Override // com.anythink.core.common.s.a.a
    protected final void d() {
        super.d();
        this.ai = 0L;
    }

    private void d(int i, int i2) {
        int i3 = this.ah;
        int[] iArr = this.ag;
        int length = iArr.length;
        if ((i3 << 1) >= length) {
            int[] iArr2 = new int[length << 1];
            System.arraycopy(iArr, 0, iArr2, 0, length);
            this.ag = iArr2;
        }
        int[] iArr3 = this.ag;
        iArr3[i3] = i;
        iArr3[i3 + 1] = i2;
        this.ah = i3 + 2;
    }

    @Override // com.anythink.core.common.s.a.a
    protected final void i() {
        this.B ^= this.E.b(this.F, this.G);
        if (this.G != 0) {
            d(this.F, this.G);
            this.G = 0;
        }
    }

    @Override // com.anythink.core.common.s.a.a
    protected final void d(int i) {
        int length = this.E.a.length;
        int i2 = this.A + i + 8;
        if (i2 >= length) {
            byte[] bArr = new byte[a(length, i2)];
            System.arraycopy(this.E.a, 0, bArr, 0, this.A);
            this.E.a = bArr;
        }
    }

    @Override // com.anythink.core.common.s.a.a
    protected final void a(byte b2, int i) {
        this.B ^= a(1L, i);
        this.E.a[i] = b2;
        d(i, 1);
    }

    @Override // com.anythink.core.common.s.a.a
    protected final void a(int i, long j, int i2) {
        this.B = a(j, i2) ^ this.B;
        this.E.a(i2, i);
        d(i2, 4);
    }

    @Override // com.anythink.core.common.s.a.a
    protected final void a(long j, long j2, int i) {
        this.B = a(j2, i) ^ this.B;
        this.E.a(i, j);
        d(i, 8);
    }

    @Override // com.anythink.core.common.s.a.a
    protected final void a(int i, byte[] bArr) {
        super.a(i, bArr);
        d(i, bArr.length);
    }

    @Override // com.anythink.core.common.s.a.a
    protected final void g(String str) {
        this.H.add(str);
    }

    @Override // com.anythink.core.common.s.a.a
    protected final void a(byte b2, int i, int i2) {
        super.a(b2, i, i2);
        d(i, 1);
    }

    @Override // com.anythink.core.common.s.a.a
    protected final void h() {
        if (this.P >= f() || this.Q.size() >= 80) {
            c(0);
        }
    }

    @Override // com.anythink.core.common.s.a.a
    protected final void a(int i, int i2, int i3) {
        for (int i4 = 0; i4 < this.ah; i4 += 2) {
            int i5 = this.ag[i4];
            if (i5 < i) {
                i = i5;
            }
        }
        int[] iArr = this.ag;
        iArr[0] = i;
        iArr[1] = this.A - i;
        this.ah = 2;
    }

    private void B() {
        int iA = a(r, this.A + r);
        if (iA >= this.E.a.length) {
            return;
        }
        byte[] bArr = new byte[iA];
        System.arraycopy(this.E.a, 0, bArr, 0, this.A);
        this.E.a = bArr;
        try {
            long j = iA;
            this.ac.truncate(j);
            MappedByteBuffer map = this.ac.map(FileChannel.MapMode.READ_WRITE, 0L, j);
            this.ae = map;
            map.order(ByteOrder.LITTLE_ENDIAN);
            this.ab.setLength(j);
            this.ad.truncate(j);
        } catch (Exception e) {
            a(new Exception("map failed", e));
            this.aj = true;
        }
        c("truncate finish");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void C() {
        g();
        w();
    }

    /* JADX INFO: renamed from: com.anythink.core.common.s.a.j$1, reason: invalid class name */
    final class AnonymousClass1 extends Handler {
        AnonymousClass1(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                j.this.apply();
            } else {
                Executor executor = j.this.ak;
                final j jVar = j.this;
                executor.execute(new Runnable() { // from class: com.anythink.core.common.s.a.j$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        j.b(jVar);
                    }
                });
            }
        }
    }

    private class b extends FileObserver {
        public b(String str) {
            super(str, 2);
        }

        @Override // android.os.FileObserver
        public final void onEvent(int i, String str) {
            if (j.this.an.hasMessages(1)) {
                return;
            }
            j.this.an.sendEmptyMessageDelayed(1, 30L);
        }
    }

    public static class a {
        private static final Map<String, j> a = new ConcurrentHashMap();
        private String b;
        private String c;
        private com.anythink.core.common.s.a.a.b[] d;
        private com.anythink.core.common.s.a.a.a e;
        private boolean f = false;

        public a(Context context, String str) {
            if (context == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.b = context.getFilesDir().getAbsolutePath() + "/tktp/";
            this.c = str;
        }

        private a(String str, String str2) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            this.b = str.endsWith("/") ? str : str + '/';
            this.c = str2;
        }

        private a a(com.anythink.core.common.s.a.a.b[] bVarArr) {
            this.d = bVarArr;
            return this;
        }

        private a a(com.anythink.core.common.s.a.a.a aVar) {
            this.e = aVar;
            return this;
        }

        public final a a() {
            this.f = false;
            return this;
        }

        public final j b() {
            j jVar;
            String str = this.b + this.c;
            Map<String, j> map = a;
            j jVar2 = map.get(str);
            if (jVar2 != null) {
                return jVar2;
            }
            synchronized (a.class) {
                jVar = map.get(str);
                if (jVar == null) {
                    jVar = new j(this.b, this.c, this.d, this.e, this.f);
                    map.put(str, jVar);
                }
            }
            return jVar;
        }
    }

    public final String toString() {
        return "MPFastKV: path:" + this.v + " name:" + this.w;
    }
}
