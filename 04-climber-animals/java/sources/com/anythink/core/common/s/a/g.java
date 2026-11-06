package com.anythink.core.common.s.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.anythink.core.common.d.t;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class g extends com.anythink.core.common.s.a.a {
    public static final int S = 0;
    public static final int T = 1;
    public static final int U = 2;
    private static final String W = "g";
    boolean V;
    private FileChannel X;
    private FileChannel Y;
    private MappedByteBuffer Z;
    private MappedByteBuffer aa;
    private int ab;
    private int ac;

    g(String str, String str2, com.anythink.core.common.s.a.a.b[] bVarArr, com.anythink.core.common.s.a.a.a aVar, int i) {
        super(str, str2, bVarArr, aVar);
        this.V = true;
        this.ac = i;
        k();
    }

    /* JADX WARN: Code duplicated, block: B:43:0x0137  */
    /* JADX WARN: Code duplicated, block: B:47:0x0141 A[Catch: Exception -> 0x01ef, all -> 0x0265, TryCatch #0 {Exception -> 0x01ef, blocks: (B:35:0x0108, B:37:0x0128, B:39:0x012e, B:45:0x013b, B:47:0x0141, B:49:0x0158, B:51:0x015f, B:53:0x0178, B:54:0x0185, B:56:0x01a1, B:58:0x01a9, B:60:0x01c1, B:65:0x01d3, B:66:0x01df), top: B:91:0x004d }] */
    /* JADX WARN: Code duplicated, block: B:48:0x0156  */
    /* JADX WARN: Code duplicated, block: B:53:0x0178 A[Catch: Exception -> 0x01ef, all -> 0x0265, TryCatch #0 {Exception -> 0x01ef, blocks: (B:35:0x0108, B:37:0x0128, B:39:0x012e, B:45:0x013b, B:47:0x0141, B:49:0x0158, B:51:0x015f, B:53:0x0178, B:54:0x0185, B:56:0x01a1, B:58:0x01a9, B:60:0x01c1, B:65:0x01d3, B:66:0x01df), top: B:91:0x004d }] */
    /* JADX WARN: Code duplicated, block: B:60:0x01c1 A[Catch: Exception -> 0x01ef, all -> 0x0265, TryCatch #0 {Exception -> 0x01ef, blocks: (B:35:0x0108, B:37:0x0128, B:39:0x012e, B:45:0x013b, B:47:0x0141, B:49:0x0158, B:51:0x015f, B:53:0x0178, B:54:0x0185, B:56:0x01a1, B:58:0x01a9, B:60:0x01c1, B:65:0x01d3, B:66:0x01df), top: B:91:0x004d }] */
    private synchronized void k() {
        boolean z;
        boolean z2;
        long jNanoTime = System.nanoTime();
        if (n() || this.ac != 0) {
            jNanoTime = jNanoTime;
        } else {
            File file = new File(this.v, this.w + ".kva");
            File file2 = new File(this.v, this.w + ".kvb");
            try {
                try {
                    if (!l.a(file) || !l.a(file2)) {
                        jNanoTime = jNanoTime;
                        a(new Exception("open file failed"));
                        u();
                    } else {
                        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                        RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
                        long length = randomAccessFile.length();
                        long length2 = randomAccessFile2.length();
                        this.X = randomAccessFile.getChannel();
                        this.Y = randomAccessFile2.getChannel();
                        try {
                            try {
                                MappedByteBuffer map = this.X.map(FileChannel.MapMode.READ_WRITE, 0L, length > 0 ? length : r);
                                this.Z = map;
                                map.order(ByteOrder.LITTLE_ENDIAN);
                                MappedByteBuffer map2 = this.Y.map(FileChannel.MapMode.READ_WRITE, 0L, length2 > 0 ? length2 : r);
                                this.aa = map2;
                                map2.order(ByteOrder.LITTLE_ENDIAN);
                                this.E = new f(this.Z.capacity());
                                if (length == 0 && length2 == 0) {
                                    this.A = 12;
                                    jNanoTime = jNanoTime;
                                } else {
                                    int i = this.Z.getInt();
                                    int i2 = i & (-1073741825);
                                    boolean zB = b(i);
                                    long j = this.Z.getLong();
                                    int i3 = this.aa.getInt();
                                    int i4 = (-1073741825) & i3;
                                    boolean zB2 = b(i3);
                                    long j2 = this.aa.getLong();
                                    boolean z3 = false;
                                    jNanoTime = jNanoTime;
                                    if (i2 < 0 || i2 > length - 12) {
                                        z = zB2;
                                    } else {
                                        this.A = i2 + 12;
                                        this.Z.rewind();
                                        z = zB2;
                                        this.Z.get(this.E.a, 0, this.A);
                                        if (j == this.E.b(12, i2) && a(zB)) {
                                            this.B = j;
                                            z2 = true;
                                        }
                                        if (z2) {
                                            if (i4 >= 0 && i4 <= length2 - 12) {
                                                this.C.clear();
                                                e();
                                                this.A = i4 + 12;
                                                if (this.E.a.length != this.aa.capacity()) {
                                                    this.E = new f(this.aa.capacity());
                                                }
                                                this.aa.rewind();
                                                this.aa.get(this.E.a, 0, this.A);
                                                if (j2 == this.E.b(12, i4) && a(z)) {
                                                    b(new Exception("A file error"));
                                                    a(this.aa, this.Z, this.A);
                                                    this.B = j2;
                                                    z3 = true;
                                                }
                                            }
                                            if (!z3) {
                                                b("both files error");
                                                v();
                                            }
                                        } else if (length == length2 || !m()) {
                                            b(new Exception("B file error"));
                                            a(this.Z, this.aa, this.A);
                                        }
                                    }
                                    z2 = false;
                                    if (z2) {
                                        if (i4 >= 0) {
                                            this.C.clear();
                                            e();
                                            this.A = i4 + 12;
                                            if (this.E.a.length != this.aa.capacity()) {
                                                this.E = new f(this.aa.capacity());
                                            }
                                            this.aa.rewind();
                                            this.aa.get(this.E.a, 0, this.A);
                                            if (j2 == this.E.b(12, i4)) {
                                                b(new Exception("A file error"));
                                                a(this.aa, this.Z, this.A);
                                                this.B = j2;
                                                z3 = true;
                                            }
                                        }
                                        if (!z3) {
                                            b("both files error");
                                            v();
                                        }
                                    } else if (length == length2) {
                                        b(new Exception("B file error"));
                                        a(this.Z, this.aa, this.A);
                                    } else {
                                        b(new Exception("B file error"));
                                        a(this.Z, this.aa, this.A);
                                    }
                                }
                            } catch (IOException e) {
                                e = e;
                                a(e);
                                u();
                                a(file, file2);
                            }
                        } catch (IOException e2) {
                            e = e2;
                            file = file;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    a(e);
                    c();
                    u();
                }
            } catch (Exception e4) {
                e = e4;
                jNanoTime = jNanoTime;
            }
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
    }

    @Override // com.anythink.core.common.s.a.a
    protected final void a(g gVar) {
        MappedByteBuffer mappedByteBuffer;
        f fVar = gVar.E;
        if (this.ac == 0) {
            int length = fVar.a.length;
            MappedByteBuffer mappedByteBuffer2 = this.Z;
            if (mappedByteBuffer2 != null && mappedByteBuffer2.capacity() == length && (mappedByteBuffer = this.aa) != null && mappedByteBuffer.capacity() == length) {
                this.Z.position(0);
                this.Z.put(fVar.a, 0, this.A);
                this.aa.position(0);
                this.aa.put(fVar.a, 0, this.A);
            } else if (!a(fVar)) {
                this.ac = 1;
            }
        }
        if (this.ac != 0) {
            s();
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0115  */
    private void l() {
        boolean z;
        File file = new File(this.v, this.w + ".kva");
        File file2 = new File(this.v, this.w + ".kvb");
        try {
            if (l.a(file) && l.a(file2)) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
                long length = randomAccessFile.length();
                long length2 = randomAccessFile2.length();
                this.X = randomAccessFile.getChannel();
                this.Y = randomAccessFile2.getChannel();
                try {
                    MappedByteBuffer map = this.X.map(FileChannel.MapMode.READ_WRITE, 0L, length > 0 ? length : r);
                    this.Z = map;
                    map.order(ByteOrder.LITTLE_ENDIAN);
                    MappedByteBuffer map2 = this.Y.map(FileChannel.MapMode.READ_WRITE, 0L, length2 > 0 ? length2 : r);
                    this.aa = map2;
                    map2.order(ByteOrder.LITTLE_ENDIAN);
                    this.E = new f(this.Z.capacity());
                    if (length == 0 && length2 == 0) {
                        this.A = 12;
                        return;
                    }
                    int i = this.Z.getInt();
                    int i2 = i & (-1073741825);
                    boolean zB = b(i);
                    long j = this.Z.getLong();
                    int i3 = this.aa.getInt();
                    int i4 = (-1073741825) & i3;
                    boolean zB2 = b(i3);
                    long j2 = this.aa.getLong();
                    boolean z2 = false;
                    if (i2 < 0 || i2 > length - 12) {
                        z = false;
                    } else {
                        this.A = i2 + 12;
                        this.Z.rewind();
                        this.Z.get(this.E.a, 0, this.A);
                        if (j == this.E.b(12, i2) && a(zB)) {
                            this.B = j;
                            z = true;
                        } else {
                            z = false;
                        }
                    }
                    if (z) {
                        if (length == length2 && m()) {
                            return;
                        }
                        b(new Exception("B file error"));
                        a(this.Z, this.aa, this.A);
                        return;
                    }
                    if (i4 >= 0 && i4 <= length2 - 12) {
                        this.C.clear();
                        e();
                        this.A = i4 + 12;
                        if (this.E.a.length != this.aa.capacity()) {
                            this.E = new f(this.aa.capacity());
                        }
                        this.aa.rewind();
                        this.aa.get(this.E.a, 0, this.A);
                        if (j2 == this.E.b(12, i4) && a(zB2)) {
                            b(new Exception("A file error"));
                            a(this.aa, this.Z, this.A);
                            this.B = j2;
                            z2 = true;
                        }
                    }
                    if (z2) {
                        return;
                    }
                    b("both files error");
                    v();
                    return;
                } catch (IOException e) {
                    a(e);
                    u();
                    a(file, file2);
                    return;
                }
            }
            a(new Exception("open file failed"));
            u();
        } catch (Exception e2) {
            a(e2);
            c();
            u();
        }
    }

    private boolean m() {
        f fVar = new f(this.A);
        this.aa.rewind();
        this.aa.get(fVar.a, 0, this.A);
        byte[] bArr = this.E.a;
        byte[] bArr2 = fVar.a;
        for (int i = 0; i < this.A; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean n() {
        File file = new File(this.v, this.w + ".kvc");
        File file2 = new File(this.v, this.w + ".tmp");
        boolean z = false;
        try {
            if (!file.exists()) {
                file = file2.exists() ? file2 : null;
            }
            if (file != null) {
                if (a(file)) {
                    if (this.ac != 0) {
                        return false;
                    }
                    if (a(this.E)) {
                        c("recover from c file");
                        try {
                            b();
                            return true;
                        } catch (Exception e) {
                            e = e;
                            z = true;
                            a(e);
                            return z;
                        }
                    }
                    this.ac = 1;
                    return false;
                }
                c();
                b();
                return false;
            }
            if (this.ac == 0) {
                return false;
            }
            File file3 = new File(this.v, this.w + ".kva");
            File file4 = new File(this.v, this.w + ".kvb");
            if (!file3.exists() || !file4.exists()) {
                return false;
            }
            a(file3, file4);
            return false;
        } catch (Exception e2) {
            e = e2;
        }
    }

    private boolean a(f fVar) {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        try {
            int length = fVar.a.length;
            File file = new File(this.v, this.w + ".kva");
            File file2 = new File(this.v, this.w + ".kvb");
            if (!l.a(file) || !l.a(file2)) {
                throw new Exception("open file failed");
            }
            randomAccessFile = new RandomAccessFile(file, "rw");
            long j = length;
            try {
                randomAccessFile.setLength(j);
                FileChannel channel = randomAccessFile.getChannel();
                this.X = channel;
                MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                this.Z = map;
                map.order(ByteOrder.LITTLE_ENDIAN);
                this.Z.put(fVar.a, 0, this.A);
                randomAccessFile2 = new RandomAccessFile(file2, "rw");
                try {
                    randomAccessFile2.setLength(j);
                    FileChannel channel2 = randomAccessFile2.getChannel();
                    this.Y = channel2;
                    MappedByteBuffer map2 = channel2.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                    this.aa = map2;
                    map2.order(ByteOrder.LITTLE_ENDIAN);
                    this.aa.put(fVar.a, 0, this.A);
                    return true;
                } catch (Exception e) {
                    e = e;
                    l.a(randomAccessFile);
                    l.a(randomAccessFile2);
                    this.X = null;
                    this.Y = null;
                    this.Z = null;
                    this.aa = null;
                    a(e);
                    return false;
                }
            } catch (Exception e2) {
                e = e2;
                randomAccessFile2 = null;
            }
        } catch (Exception e3) {
            e = e3;
            randomAccessFile = null;
            randomAccessFile2 = null;
        }
    }

    private void a(MappedByteBuffer mappedByteBuffer, MappedByteBuffer mappedByteBuffer2, int i) {
        if (mappedByteBuffer.capacity() != mappedByteBuffer2.capacity()) {
            try {
                MappedByteBuffer map = (mappedByteBuffer2 == this.aa ? this.Y : this.X).map(FileChannel.MapMode.READ_WRITE, 0L, mappedByteBuffer.capacity());
                map.order(ByteOrder.LITTLE_ENDIAN);
                if (mappedByteBuffer2 == this.aa) {
                    this.aa = map;
                } else {
                    this.Z = map;
                }
                mappedByteBuffer2 = map;
            } catch (IOException e) {
                a(e);
                u();
                return;
            }
        }
        mappedByteBuffer.rewind();
        mappedByteBuffer2.rewind();
        mappedByteBuffer.limit(i);
        mappedByteBuffer2.put(mappedByteBuffer);
        mappedByteBuffer.limit(mappedByteBuffer.capacity());
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0059 A[Catch: all -> 0x0097, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:9:0x0011, B:11:0x0027, B:16:0x0051, B:18:0x0059, B:20:0x007d, B:22:0x0082, B:24:0x0086, B:25:0x008a, B:26:0x008f, B:19:0x0076, B:12:0x003b, B:14:0x004b), top: B:32:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x0076 A[Catch: all -> 0x0097, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:9:0x0011, B:11:0x0027, B:16:0x0051, B:18:0x0059, B:20:0x007d, B:22:0x0082, B:24:0x0086, B:25:0x008a, B:26:0x008f, B:19:0x0076, B:12:0x003b, B:14:0x004b), top: B:32:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:22:0x0082 A[Catch: all -> 0x0097, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:9:0x0011, B:11:0x0027, B:16:0x0051, B:18:0x0059, B:20:0x007d, B:22:0x0082, B:24:0x0086, B:25:0x008a, B:26:0x008f, B:19:0x0076, B:12:0x003b, B:14:0x004b), top: B:32:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x0086 A[Catch: all -> 0x0097, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:9:0x0011, B:11:0x0027, B:16:0x0051, B:18:0x0059, B:20:0x007d, B:22:0x0082, B:24:0x0086, B:25:0x008a, B:26:0x008f, B:19:0x0076, B:12:0x003b, B:14:0x004b), top: B:32:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x008a A[Catch: all -> 0x0097, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:9:0x0011, B:11:0x0027, B:16:0x0051, B:18:0x0059, B:20:0x007d, B:22:0x0082, B:24:0x0086, B:25:0x008a, B:26:0x008f, B:19:0x0076, B:12:0x003b, B:14:0x004b), top: B:32:0x0001 }] */
    @Override // android.content.SharedPreferences.Editor
    public final synchronized SharedPreferences.Editor remove(String str) {
        String str2;
        byte b;
        if (this.J) {
            return this;
        }
        b.AbstractC0101b abstractC0101b = this.C.get(str);
        if (abstractC0101b != null) {
            this.C.remove(str);
            this.M.b(str);
            this.L.b(str);
            byte bA = abstractC0101b.a();
            if (bA <= 5) {
                a(bA, abstractC0101b.a - (f.b(str) + 2), abstractC0101b.a + o[bA]);
            } else {
                b.j jVar = (b.j) abstractC0101b;
                a(bA, jVar.d, jVar.a + jVar.e);
                str2 = jVar.f ? (String) jVar.c : null;
                b = (byte) (bA | (-128));
                if (this.ac == 0) {
                    this.Z.putLong(4, this.B);
                    this.Z.put(this.ab, b);
                    this.aa.putLong(4, this.B);
                    this.aa.put(this.ab, b);
                } else {
                    this.E.a(4, this.B);
                }
                this.ab = 0;
                if (str2 != null) {
                    if (this.ac == 0) {
                        a(str2);
                    } else {
                        this.H.add(str2);
                    }
                }
                h();
                q();
            }
            b = (byte) (bA | (-128));
            if (this.ac == 0) {
                this.Z.putLong(4, this.B);
                this.Z.put(this.ab, b);
                this.aa.putLong(4, this.B);
                this.aa.put(this.ab, b);
            } else {
                this.E.a(4, this.B);
            }
            this.ab = 0;
            if (str2 != null) {
                if (this.ac == 0) {
                    a(str2);
                } else {
                    this.H.add(str2);
                }
            }
            h();
            q();
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final synchronized SharedPreferences.Editor clear() {
        if (this.J) {
            return this;
        }
        v();
        if (this.ac != 0) {
            b();
        }
        e((String) null);
        return this;
    }

    @Override // com.anythink.core.common.s.a.a
    public final synchronized void a(Map<String, Object> map, Map<Class, com.anythink.core.common.s.a.a.b> map2) {
        if (this.J) {
            return;
        }
        if (this.ac != 0) {
            this.V = false;
        }
        super.a(map, map2);
        if (this.ac != 0) {
            commit();
        }
    }

    private synchronized void o() {
        if (this.J) {
            return;
        }
        if (this.ac == 0) {
            this.Z.force();
            this.aa.force();
        }
    }

    private synchronized void p() {
        this.V = false;
    }

    @Override // android.content.SharedPreferences.Editor
    public final synchronized boolean commit() {
        if (this.J) {
            return false;
        }
        this.V = true;
        return r();
    }

    @Override // android.content.SharedPreferences.Editor
    public final synchronized void apply() {
        if (this.J) {
            return;
        }
        this.V = true;
        r();
    }

    @Override // com.anythink.core.common.s.a.a
    protected final void f(String str) {
        q();
        e(str);
    }

    private void q() {
        if (this.ac == 0 || !this.V) {
            return;
        }
        r();
    }

    private boolean r() {
        int i = this.ac;
        if (i == 1) {
            this.O.execute(new Runnable() { // from class: com.anythink.core.common.s.a.g$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.s();
                }
            });
        } else if (i == 2) {
            return s();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean s() {
        try {
            File file = new File(this.v, this.w + ".tmp");
            if (l.a(file)) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    randomAccessFile.setLength(this.A);
                    randomAccessFile.write(this.E.a, 0, this.A);
                    randomAccessFile.getFD().sync();
                    randomAccessFile.close();
                    if (l.a(file, new File(this.v, this.w + ".kvc"))) {
                        t();
                        return true;
                    }
                    b(new Exception("rename failed"));
                } catch (Throwable th) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
        } catch (Exception e) {
            a(e);
        }
        return false;
    }

    private void t() {
        if (this.H.isEmpty()) {
            return;
        }
        Iterator<String> it = this.H.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        this.H.clear();
    }

    private void u() {
        this.ac = 1;
        l.a(this.X);
        l.a(this.Y);
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.aa = null;
    }

    private void v() {
        if (this.ac == 0) {
            try {
                a(this.Z);
                a(this.aa);
            } catch (Exception unused) {
                u();
            }
        }
        c();
        l.c(new File(this.v + this.w));
    }

    private void a(MappedByteBuffer mappedByteBuffer) throws IOException {
        if (mappedByteBuffer.capacity() != r) {
            FileChannel fileChannel = mappedByteBuffer == this.Z ? this.X : this.Y;
            fileChannel.truncate(r);
            MappedByteBuffer map = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, r);
            map.order(ByteOrder.LITTLE_ENDIAN);
            if (mappedByteBuffer == this.Z) {
                this.Z = map;
            } else {
                this.aa = map;
            }
            mappedByteBuffer = map;
        }
        mappedByteBuffer.putInt(0, a(0));
        mappedByteBuffer.putLong(4, 0L);
    }

    @Override // com.anythink.core.common.s.a.a
    protected final void i() {
        this.B ^= this.E.b(this.F, this.G);
        int iA = a(this.A - 12);
        if (this.ac == 0) {
            this.Z.putInt(0, -1);
            b(this.Z);
            this.Z.putInt(0, iA);
            this.aa.putInt(0, iA);
            b(this.aa);
        } else {
            this.E.a(0, iA);
            this.E.a(4, this.B);
        }
        this.ab = 0;
        this.G = 0;
    }

    private void b(MappedByteBuffer mappedByteBuffer) {
        try {
            if (mappedByteBuffer.capacity() < 12) {
                throw new IllegalArgumentException("Buffer capacity too small for checksum");
            }
            mappedByteBuffer.putLong(4, this.B);
            int i = this.ab;
            if (i != 0) {
                if (i < 0 || i >= mappedByteBuffer.capacity()) {
                    throw new IllegalArgumentException("removeStart out of bounds: " + this.ab);
                }
                if (this.ab >= this.E.a.length) {
                    throw new IllegalArgumentException("fastBuffer.hb index out of bounds: " + this.ab);
                }
                mappedByteBuffer.put(this.ab, this.E.a[this.ab]);
            }
            if (this.G != 0) {
                if (this.F < 0 || this.G < 0 || this.F + this.G > this.E.a.length) {
                    throw new IllegalArgumentException("Invalid update range");
                }
                if (this.F > mappedByteBuffer.capacity() || mappedByteBuffer.capacity() - this.F < this.G) {
                    throw new IllegalArgumentException("buffer capacity overflow");
                }
                mappedByteBuffer.position(this.F);
                mappedByteBuffer.put(this.E.a, this.F, this.G);
            }
        } catch (Throwable th) {
            com.anythink.core.common.u.e.b("sp_mmap_error", "spName: " + this.w + " errorMsg: " + th.getMessage(), t.b().r());
        }
    }

    @Override // com.anythink.core.common.s.a.a
    protected final void d(int i) {
        int length = this.E.a.length;
        int i2 = this.A + i;
        if (i2 >= length) {
            if (this.P > i && this.P > f()) {
                c(i);
                return;
            }
            int iA = a(length, i2);
            byte[] bArr = new byte[iA];
            System.arraycopy(this.E.a, 0, bArr, 0, this.A);
            this.E.a = bArr;
            if (this.ac == 0) {
                try {
                    long j = iA;
                    MappedByteBuffer map = this.X.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                    this.Z = map;
                    map.order(ByteOrder.LITTLE_ENDIAN);
                    MappedByteBuffer map2 = this.Y.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                    this.aa = map2;
                    map2.order(ByteOrder.LITTLE_ENDIAN);
                } catch (IOException e) {
                    a(new Exception("map failed", e));
                    this.E.a(0, a(this.A - 12));
                    this.E.a(4, this.B);
                    u();
                }
            }
        }
    }

    @Override // com.anythink.core.common.s.a.a
    protected final void a(byte b, int i) {
        this.B ^= a(1L, i);
        if (this.ac == 0) {
            this.Z.putLong(4, this.B);
            this.Z.put(i, b);
            this.aa.putLong(4, this.B);
            this.aa.put(i, b);
        } else {
            this.E.a(4, this.B);
        }
        this.E.a[i] = b;
    }

    @Override // com.anythink.core.common.s.a.a
    protected final void a(int i, long j, int i2) {
        this.B = a(j, i2) ^ this.B;
        if (this.ac == 0) {
            this.Z.putLong(4, this.B);
            this.Z.putInt(i2, i);
            this.aa.putLong(4, this.B);
            this.aa.putInt(i2, i);
        } else {
            this.E.a(4, this.B);
        }
        this.E.a(i2, i);
    }

    @Override // com.anythink.core.common.s.a.a
    protected final void a(long j, long j2, int i) {
        this.B = a(j2, i) ^ this.B;
        if (this.ac == 0) {
            this.Z.putLong(4, this.B);
            this.Z.putLong(i, j);
            this.aa.putLong(4, this.B);
            this.aa.putLong(i, j);
        } else {
            this.E.a(4, this.B);
        }
        this.E.a(i, j);
    }

    @Override // com.anythink.core.common.s.a.a
    protected final void a(int i, byte[] bArr) {
        super.a(i, bArr);
        if (this.ac == 0) {
            this.Z.putInt(0, -1);
            this.Z.putLong(4, this.B);
            this.Z.position(i);
            this.Z.put(bArr);
            this.Z.putInt(0, a(this.A - 12));
            this.aa.putLong(4, this.B);
            this.aa.position(i);
            this.aa.put(bArr);
            return;
        }
        this.E.a(4, this.B);
    }

    @Override // com.anythink.core.common.s.a.a
    protected final void g(String str) {
        if (this.ac == 0) {
            a(str);
        } else {
            this.H.add(str);
        }
    }

    @Override // com.anythink.core.common.s.a.a
    protected final void a(byte b, int i, int i2) {
        super.a(b, i, i2);
        this.ab = i;
    }

    @Override // com.anythink.core.common.s.a.a
    protected final void h() {
        if (this.P < (f() << 1)) {
            if (this.Q.size() < (this.A < 16384 ? 80 : 160)) {
                return;
            }
        }
        c(0);
    }

    @Override // com.anythink.core.common.s.a.a
    protected final void a(int i, int i2, int i3) {
        int iA = a(this.A - 12);
        if (this.ac == 0) {
            this.Z.putInt(0, -1);
            this.Z.putLong(4, this.B);
            this.Z.position(i);
            this.Z.put(this.E.a, i, i3);
            this.Z.putInt(0, iA);
            this.aa.putInt(0, iA);
            this.aa.putLong(4, this.B);
            this.aa.position(i);
            this.aa.put(this.E.a, i, i3);
        } else {
            this.E.a(0, iA);
            this.E.a(4, this.B);
        }
        int i4 = this.A + i2;
        if (this.E.a.length - i4 > s) {
            int i5 = r;
            int iA2 = a(i5, i4 + i5);
            if (iA2 < this.E.a.length) {
                byte[] bArr = new byte[iA2];
                System.arraycopy(this.E.a, 0, bArr, 0, this.A);
                this.E.a = bArr;
                if (this.ac == 0) {
                    try {
                        long j = iA2;
                        this.X.truncate(j);
                        MappedByteBuffer map = this.X.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                        this.Z = map;
                        map.order(ByteOrder.LITTLE_ENDIAN);
                        this.Y.truncate(j);
                        MappedByteBuffer map2 = this.Y.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                        this.aa = map2;
                        map2.order(ByteOrder.LITTLE_ENDIAN);
                    } catch (Exception e) {
                        a(new Exception("map failed", e));
                        u();
                    }
                }
                c("truncate finish");
            }
        }
    }

    private void e(int i) {
        int i2 = r;
        int iA = a(i2, i + i2);
        if (iA >= this.E.a.length) {
            return;
        }
        byte[] bArr = new byte[iA];
        System.arraycopy(this.E.a, 0, bArr, 0, this.A);
        this.E.a = bArr;
        if (this.ac == 0) {
            try {
                long j = iA;
                this.X.truncate(j);
                MappedByteBuffer map = this.X.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                this.Z = map;
                map.order(ByteOrder.LITTLE_ENDIAN);
                this.Y.truncate(j);
                MappedByteBuffer map2 = this.Y.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                this.aa = map2;
                map2.order(ByteOrder.LITTLE_ENDIAN);
            } catch (Exception e) {
                a(new Exception("map failed", e));
                u();
            }
        }
        c("truncate finish");
    }

    /* JADX WARN: Code duplicated, block: B:26:0x002a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private synchronized void w() {
        if (this.J) {
            return;
        }
        this.J = true;
        if (this.ac == 0) {
            try {
                this.X.force(true);
                this.X.close();
                this.Y.force(true);
                this.Y.close();
            } catch (Exception e) {
                a(e);
            }
            synchronized (a.class) {
                a.a.remove(this.v + this.w);
            }
            return;
        }
        synchronized (a.class) {
            a.a.remove(this.v + this.w);
            return;
        }
        throw th;
    }

    public static final class a {
        static final Map<String, g> a = new ConcurrentHashMap();
        private String b;
        private String c;
        private com.anythink.core.common.s.a.a.b[] d;
        private com.anythink.core.common.s.a.a.a e;
        private int f = 0;

        private a(Context context, String str) {
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

        private a a() {
            this.f = 2;
            return this;
        }

        private a b() {
            this.f = 1;
            return this;
        }

        private g c() {
            g gVar;
            String str = this.b + this.c;
            Map<String, g> map = a;
            g gVar2 = map.get(str);
            if (gVar2 != null) {
                return gVar2;
            }
            synchronized (a.class) {
                gVar = map.get(str);
                if (gVar == null) {
                    gVar = new g(this.b, this.c, this.d, this.e, this.f);
                    map.put(str, gVar);
                }
            }
            return gVar;
        }
    }

    public final int j() {
        return this.ac;
    }

    public final String toString() {
        return "FastKV: path:" + this.v + " name:" + this.w;
    }
}
