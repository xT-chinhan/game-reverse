package com.anythink.core.common.r.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.FileObserver;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.common.u.v;
import com.bykv.vk.component.ttvideo.player.C;
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
public final class j extends com.anythink.core.common.r.a.a {
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

    j(String str, String str2, com.anythink.core.common.r.a.a.b[] bVarArr, com.anythink.core.common.r.a.a.a aVar, boolean z) {
        super(str, str2, bVarArr, aVar);
        this.ag = new int[16];
        this.ah = 0;
        this.aj = false;
        this.ak = new i();
        this.am = new HashSet();
        this.an = new Handler(Looper.getMainLooper()) { // from class: com.anythink.core.common.r.a.j.2
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                int i = message.what;
                if (i == 1) {
                    j.this.ak.execute(new Runnable() { // from class: com.anythink.core.common.r.a.j.2.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            j.this.D();
                        }
                    });
                } else {
                    if (i != 2) {
                        return;
                    }
                    j.this.apply();
                }
            }
        };
        this.Y = new File(str, str2 + ".kva");
        this.Z = new File(str, str2 + ".kvb");
        this.X = z;
        SystemClock.currentThreadTimeMillis();
        k();
    }

    private synchronized void k() {
        long jNanoTime = System.nanoTime();
        if (!r()) {
            m();
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
            c("loading finish, data len:" + this.A + ", get keys:" + this.C.size() + ", use time:" + ((System.nanoTime() - jNanoTime) / C.MICROS_PER_SECOND) + " ms");
        }
        l();
    }

    @Override // com.anythink.core.common.r.a.a
    protected final void a(g gVar) {
        a(gVar.E);
    }

    private void l() {
        File file;
        if (this.X && this.al == null && (file = this.Z) != null && file.exists()) {
            this.al = new b(this.Z.getPath());
            this.al.startWatching();
        }
    }

    private void m() {
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
                        p();
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
                        o();
                    } else {
                        b("both files error");
                        B();
                    }
                }
                n();
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

    private void n() {
        if (this.ae == null || this.A + 8 >= this.ae.capacity()) {
            return;
        }
        this.ai = this.ae.getLong(this.A);
    }

    private void o() {
        try {
            if (l.a(this.Z)) {
                e(this.ae.capacity());
                b(0, this.A);
            }
        } catch (Exception e) {
            a(e);
        }
    }

    private void p() {
        try {
            if (q()) {
                this.ae.position(0);
                this.ae.put(this.E.a, 0, this.A);
            }
        } catch (Exception e) {
            a(e);
        }
    }

    private boolean q() {
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

    private boolean r() {
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
                q();
                this.ae.put(fVar.a, 0, this.A);
                n();
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
                l();
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
        com.anythink.core.common.r.a.b.AbstractC0042b abstractC0042b = this.C.get(str);
        if (abstractC0042b != null) {
            this.C.remove(str);
            this.M.b(str);
            this.L.b(str);
            byte bA = abstractC0042b.a();
            String str2 = null;
            if (bA <= 5) {
                a(bA, abstractC0042b.a - (f.b(str) + 2), abstractC0042b.a + o[bA]);
            } else {
                com.anythink.core.common.r.a.b.j jVar = (com.anythink.core.common.r.a.b.j) abstractC0042b;
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

    @Override // com.anythink.core.common.r.a.a
    protected final void f(String str) {
        if (this.R.isEmpty()) {
            return;
        }
        this.am.add(str);
    }

    private synchronized void s() {
        if (!this.am.isEmpty()) {
            Iterator<String> it = this.am.iterator();
            while (it.hasNext()) {
                e(it.next());
            }
            this.am.clear();
        }
    }

    private synchronized void t() {
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
        return v();
    }

    @Override // android.content.SharedPreferences.Editor
    public final void apply() {
        this.O.execute(new Runnable() { // from class: com.anythink.core.common.r.a.j.1
            @Override // java.lang.Runnable
            public final void run() {
                j.this.v();
            }
        });
    }

    private boolean u() {
        this.E.b = 0;
        int iC = this.E.c() & (-1073741825);
        this.B = this.E.d();
        this.A = iC + 12;
        if (this.B == this.E.b(12, iC)) {
            return a(this.E);
        }
        B();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean v() {
        int iA;
        if (this.af == null) {
            return false;
        }
        if (this.E == null || (this.ah == 0 && !this.aj)) {
            x();
            return false;
        }
        try {
            int iA2 = a(this.A - 12);
            this.E.a(0, iA2);
            this.E.a(4, this.B);
            if (this.aj) {
                boolean zU = u();
                if (zU) {
                    this.aj = false;
                }
                this.ah = 0;
                if (!this.H.isEmpty()) {
                    this.H.clear();
                }
                w();
                x();
                s();
                return zU;
            }
            if (!q()) {
                MappedByteBuffer mappedByteBuffer = this.ae;
                if (mappedByteBuffer == null) {
                    this.aj = true;
                } else if (mappedByteBuffer != null) {
                    z();
                    n();
                    this.E.b = 0;
                    int iC = this.E.c();
                    int i = (-1073741825) & iC;
                    boolean zB = b(iC);
                    this.B = this.E.d();
                    this.A = i + 12;
                    if (this.B != this.E.b(12, i) || !a(zB)) {
                        B();
                    }
                }
                this.ah = 0;
                if (!this.H.isEmpty()) {
                    this.H.clear();
                }
                w();
                x();
                s();
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
            w();
            x();
            s();
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
                w();
                x();
                s();
            }
        }
        throw th;
    }

    private void w() {
        while (this.N.a()) {
            try {
                Thread.sleep(10L);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.anythink.core.common.r.a.a
    protected final void g() {
        if (this.af != null) {
            return;
        }
        if (this.ad == null) {
            m();
            l();
        }
        FileChannel fileChannel = this.ad;
        if (fileChannel != null) {
            try {
                this.af = fileChannel.lock();
                try {
                    A();
                } finally {
                    this.an.sendEmptyMessageDelayed(2, 3000L);
                }
            } catch (Exception e) {
                a(e);
            }
        }
    }

    private synchronized void x() {
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

    private void y() {
        if (this.ae == null) {
            return;
        }
        z();
        n();
        this.E.b = 0;
        int iC = this.E.c();
        int i = (-1073741825) & iC;
        boolean zB = b(iC);
        this.B = this.E.d();
        this.A = i + 12;
        if (this.B == this.E.b(12, i) && a(zB)) {
            return;
        }
        B();
    }

    private void z() {
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

    private void A() throws IOException {
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
        HashMap<String, com.anythink.core.common.r.a.b.AbstractC0042b> map2 = this.R.isEmpty() ? null : new HashMap<>(this.C);
        z();
        if (j3 != this.E.b(12, i2) || !a(zB)) {
            B();
        } else if (map2 != null) {
            a(map2);
        }
    }

    private void a(HashMap<String, com.anythink.core.common.r.a.b.AbstractC0042b> map) {
        HashSet hashSet = new HashSet(this.C.keySet());
        HashSet hashSet2 = new HashSet(map.keySet());
        HashSet<String> hashSet3 = new HashSet(hashSet);
        hashSet3.retainAll(hashSet2);
        hashSet.removeAll(hashSet3);
        hashSet2.removeAll(hashSet3);
        this.am.addAll(hashSet);
        this.am.addAll(hashSet2);
        for (String str : hashSet3) {
            com.anythink.core.common.r.a.b.AbstractC0042b abstractC0042b = map.get(str);
            com.anythink.core.common.r.a.b.AbstractC0042b abstractC0042b2 = this.C.get(str);
            if (abstractC0042b != null && !abstractC0042b.a(abstractC0042b2)) {
                this.am.add(str);
            }
        }
        if (this.am.isEmpty()) {
            return;
        }
        s();
    }

    @Override // android.content.SharedPreferences.Editor
    public final synchronized SharedPreferences.Editor clear() {
        g();
        B();
        x();
        return this;
    }

    private void B() {
        c();
        try {
            q();
            this.ae.putInt(0, a(0));
            this.ae.putLong(4, 0L);
            n();
            if (l.a(this.Z)) {
                e(r);
                b(0, 12);
                l();
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

    @Override // com.anythink.core.common.r.a.a
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

    @Override // com.anythink.core.common.r.a.a
    protected final void i() {
        this.B ^= this.E.b(this.F, this.G);
        if (this.G != 0) {
            d(this.F, this.G);
            this.G = 0;
        }
    }

    @Override // com.anythink.core.common.r.a.a
    protected final void d(int i) {
        int length = this.E.a.length;
        int i2 = this.A + i + 8;
        if (i2 >= length) {
            byte[] bArr = new byte[a(length, i2)];
            System.arraycopy(this.E.a, 0, bArr, 0, this.A);
            this.E.a = bArr;
        }
    }

    @Override // com.anythink.core.common.r.a.a
    protected final void a(byte b2, int i) {
        this.B ^= a(1L, i);
        this.E.a[i] = b2;
        d(i, 1);
    }

    @Override // com.anythink.core.common.r.a.a
    protected final void a(int i, long j, int i2) {
        this.B = a(j, i2) ^ this.B;
        this.E.a(i2, i);
        d(i2, 4);
    }

    @Override // com.anythink.core.common.r.a.a
    protected final void a(long j, long j2, int i) {
        this.B = a(j2, i) ^ this.B;
        this.E.a(i, j);
        d(i, 8);
    }

    @Override // com.anythink.core.common.r.a.a
    protected final void a(int i, byte[] bArr) {
        super.a(i, bArr);
        d(i, bArr.length);
    }

    @Override // com.anythink.core.common.r.a.a
    protected final void g(String str) {
        this.H.add(str);
    }

    @Override // com.anythink.core.common.r.a.a
    protected final void a(byte b2, int i, int i2) {
        super.a(b2, i, i2);
        d(i, 1);
    }

    @Override // com.anythink.core.common.r.a.a
    protected final void h() {
        if (this.P >= f() || this.Q.size() >= 80) {
            c(0);
        }
    }

    @Override // com.anythink.core.common.r.a.a
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

    private void C() {
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
    public synchronized void D() {
        g();
        x();
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
        private com.anythink.core.common.r.a.a.b[] d;
        private com.anythink.core.common.r.a.a.a e;
        private boolean f = false;

        public a(Context context, String str) {
            if (context == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.b = v.b(context);
            this.c = str;
        }

        private a(String str, String str2) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            this.b = str.endsWith("/") ? str : str + '/';
            this.c = str2;
        }

        private a a(com.anythink.core.common.r.a.a.b[] bVarArr) {
            this.d = bVarArr;
            return this;
        }

        private a a(com.anythink.core.common.r.a.a.a aVar) {
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

    public final synchronized int j() {
        int i;
        i = 0;
        try {
            if (this.af != null) {
                commit();
            }
            if (this.al != null) {
                this.al.stopWatching();
                this.al = null;
            }
            MappedByteBuffer mappedByteBuffer = this.ae;
            if (mappedByteBuffer != null) {
                try {
                    mappedByteBuffer.force();
                } catch (Exception e) {
                    a(e);
                }
                this.ae = null;
            }
            FileChannel fileChannel = this.ac;
            if (fileChannel != null || this.aa != null) {
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (Exception e2) {
                        a(e2);
                    }
                    this.ac = null;
                }
                RandomAccessFile randomAccessFile = this.aa;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e3) {
                        a(e3);
                    }
                    this.aa = null;
                }
                i = 1;
            }
            FileChannel fileChannel2 = this.ad;
            if (fileChannel2 != null || this.ab != null) {
                if (fileChannel2 != null) {
                    try {
                        fileChannel2.close();
                    } catch (Exception e4) {
                        a(e4);
                    }
                    this.ad = null;
                }
                RandomAccessFile randomAccessFile2 = this.ab;
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (Exception e5) {
                        a(e5);
                    }
                    this.ab = null;
                }
                i++;
            }
            if (i > 0) {
                c("MPFastKV closed: " + this.w + ", released FD: " + i);
            }
        } catch (Exception e6) {
            a(e6);
        }
        return i;
    }

    private boolean E() {
        return this.ac == null && this.ad == null;
    }
}
