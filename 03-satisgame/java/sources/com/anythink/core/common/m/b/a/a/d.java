package com.anythink.core.common.m.b.a.a;

import com.anythink.core.common.m.c.n;
import com.anythink.core.common.m.c.v;
import com.anythink.core.common.m.c.w;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Closeable, Flushable {
    static final String a = "journal";
    static final String b = "journal.tmp";
    static final String c = "journal.bkp";
    static final String d = "libcore.io.DiskLruCache";
    static final String e = "1";
    static final long f = -1;
    static final Pattern g = Pattern.compile("[a-z0-9_-]{1,120}");
    static final /* synthetic */ boolean s = true;
    private static final String t = "CLEAN";
    private static final String u = "DIRTY";
    private static final String v = "REMOVE";
    private static final String w = "READ";
    private long B;
    private final Executor E;
    final com.anythink.core.common.m.b.a.f.a h;
    final File i;
    com.anythink.core.common.m.c.d k;
    int m;
    boolean n;
    boolean o;
    boolean p;
    boolean q;
    boolean r;
    private final File x;
    private final File y;
    private final File z;
    private long C = 0;
    final LinkedHashMap<String, b> l = new LinkedHashMap<>(0, 0.75f, true);
    private long D = 0;
    private final Runnable F = new Runnable() { // from class: com.anythink.core.common.m.b.a.a.d.1
        @Override // java.lang.Runnable
        public final void run() {
            synchronized (d.this) {
                if ((!d.this.o) || d.this.p) {
                    return;
                }
                try {
                    d.this.h();
                } catch (IOException unused) {
                    d.this.q = true;
                }
                try {
                    if (d.this.f()) {
                        d.this.b();
                        d.this.m = 0;
                    }
                } catch (IOException unused2) {
                    d.this.r = true;
                    d.this.k = n.a(n.a());
                }
            }
        }
    };
    private final int A = 201105;
    final int j = 2;

    private d(com.anythink.core.common.m.b.a.f.a aVar, File file, long j, Executor executor) {
        this.h = aVar;
        this.i = file;
        this.x = new File(file, a);
        this.y = new File(file, b);
        this.z = new File(file, c);
        this.B = j;
        this.E = executor;
    }

    public final synchronized void a() {
        if (!s && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (this.o) {
            return;
        }
        if (this.h.e(this.z)) {
            if (this.h.e(this.x)) {
                this.h.d(this.z);
            } else {
                this.h.a(this.z, this.x);
            }
        }
        if (this.h.e(this.x)) {
            try {
                l();
                n();
                this.o = true;
                return;
            } catch (IOException e2) {
                com.anythink.core.common.m.b.a.g.c.e().a(5, "DiskLruCache " + this.i + " is corrupt: " + e2.getMessage() + ", removing", e2);
                try {
                    i();
                    this.p = false;
                    b();
                    this.o = true;
                } catch (Throwable th) {
                    this.p = false;
                    throw th;
                }
            }
        }
        b();
        this.o = true;
    }

    public static d a(com.anythink.core.common.m.b.a.f.a aVar, File file, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        return new d(aVar, file, j, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), com.anythink.core.common.m.b.a.c.a("anythink DiskLruCache", true)));
    }

    private void l() {
        String strSubstring;
        com.anythink.core.common.m.c.e eVarA = n.a(this.h.a(this.x));
        try {
            String strW = eVarA.w();
            String strW2 = eVarA.w();
            String strW3 = eVarA.w();
            String strW4 = eVarA.w();
            String strW5 = eVarA.w();
            if (!d.equals(strW) || !"1".equals(strW2) || !Integer.toString(this.A).equals(strW3) || !Integer.toString(this.j).equals(strW4) || !"".equals(strW5)) {
                throw new IOException("unexpected journal header: [" + strW + ", " + strW2 + ", " + strW4 + ", " + strW5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    String strW6 = eVarA.w();
                    int iIndexOf = strW6.indexOf(32);
                    if (iIndexOf == -1) {
                        throw new IOException("unexpected journal line: ".concat(String.valueOf(strW6)));
                    }
                    int i2 = iIndexOf + 1;
                    int iIndexOf2 = strW6.indexOf(32, i2);
                    if (iIndexOf2 == -1) {
                        strSubstring = strW6.substring(i2);
                        if (iIndexOf == 6 && strW6.startsWith(v)) {
                            this.l.remove(strSubstring);
                        }
                        i++;
                    } else {
                        strSubstring = strW6.substring(i2, iIndexOf2);
                    }
                    b bVar = this.l.get(strSubstring);
                    if (bVar == null) {
                        bVar = new b(strSubstring);
                        this.l.put(strSubstring, bVar);
                    }
                    if (iIndexOf2 != -1 && iIndexOf == 5 && strW6.startsWith(t)) {
                        String[] strArrSplit = strW6.substring(iIndexOf2 + 1).split(" ");
                        bVar.e = true;
                        bVar.f = null;
                        bVar.a(strArrSplit);
                    } else if (iIndexOf2 == -1 && iIndexOf == 5 && strW6.startsWith(u)) {
                        bVar.f = new a(bVar);
                    } else if (iIndexOf2 != -1 || iIndexOf != 4 || !strW6.startsWith(w)) {
                        throw new IOException("unexpected journal line: ".concat(String.valueOf(strW6)));
                    }
                    i++;
                } catch (EOFException unused) {
                    this.m = i - this.l.size();
                    if (!eVarA.g()) {
                        b();
                    } else {
                        this.k = m();
                    }
                    eVarA.close();
                    return;
                }
            }
        } catch (Throwable th) {
            try {
                eVarA.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private com.anythink.core.common.m.c.d m() {
        return n.a(new e(this.h.c(this.x)) { // from class: com.anythink.core.common.m.b.a.a.d.2
            static final /* synthetic */ boolean a = true;

            @Override // com.anythink.core.common.m.b.a.a.e
            protected final void b() {
                if (!a && !Thread.holdsLock(d.this)) {
                    throw new AssertionError();
                }
                d.this.n = true;
            }
        });
    }

    private void d(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: ".concat(String.valueOf(str)));
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i);
            if (iIndexOf == 6 && str.startsWith(v)) {
                this.l.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        b bVar = this.l.get(strSubstring);
        if (bVar == null) {
            bVar = new b(strSubstring);
            this.l.put(strSubstring, bVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith(t)) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            bVar.e = true;
            bVar.f = null;
            bVar.a(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith(u)) {
            bVar.f = new a(bVar);
        } else if (iIndexOf2 != -1 || iIndexOf != 4 || !str.startsWith(w)) {
            throw new IOException("unexpected journal line: ".concat(String.valueOf(str)));
        }
    }

    private void n() {
        this.h.d(this.y);
        Iterator<b> it = this.l.values().iterator();
        while (it.hasNext()) {
            b next = it.next();
            int i = 0;
            if (next.f == null) {
                while (i < this.j) {
                    this.C += next.b[i];
                    i++;
                }
            } else {
                next.f = null;
                while (i < this.j) {
                    this.h.d(next.c[i]);
                    this.h.d(next.d[i]);
                    i++;
                }
                it.remove();
            }
        }
    }

    final synchronized void b() {
        try {
            com.anythink.core.common.m.c.d dVar = this.k;
            if (dVar != null) {
                dVar.close();
            }
            com.anythink.core.common.m.c.d dVarA = n.a(this.h.b(this.y));
            try {
                dVarA.b(d).l(10);
                dVarA.b("1").l(10);
                dVarA.o(this.A).l(10);
                dVarA.o(this.j).l(10);
                dVarA.l(10);
                for (b bVar : this.l.values()) {
                    if (bVar.f != null) {
                        dVarA.b(u).l(32);
                        dVarA.b(bVar.a);
                        dVarA.l(10);
                    } else {
                        dVarA.b(t).l(32);
                        dVarA.b(bVar.a);
                        bVar.a(dVarA);
                        dVarA.l(10);
                    }
                }
                dVarA.close();
                if (this.h.e(this.x)) {
                    this.h.a(this.x, this.z);
                }
                this.h.a(this.y, this.x);
                this.h.d(this.z);
                this.k = m();
                this.n = false;
                this.r = false;
            } catch (Throwable th) {
                try {
                    dVarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            throw th3;
        }
    }

    public final synchronized c a(String str) {
        a();
        o();
        e(str);
        b bVar = this.l.get(str);
        if (bVar != null && bVar.e) {
            c cVarA = bVar.a();
            if (cVarA == null) {
                return null;
            }
            this.m++;
            this.k.b(w).l(32).b(str).l(10);
            if (f()) {
                this.E.execute(this.F);
            }
            return cVarA;
        }
        return null;
    }

    public final a b(String str) {
        return a(str, -1L);
    }

    final synchronized a a(String str, long j) {
        a();
        o();
        e(str);
        b bVar = this.l.get(str);
        if (j != -1 && (bVar == null || bVar.g != j)) {
            return null;
        }
        if (bVar != null && bVar.f != null) {
            return null;
        }
        if (!this.q && !this.r) {
            this.k.b(u).l(32).b(str).l(10);
            this.k.flush();
            if (this.n) {
                return null;
            }
            if (bVar == null) {
                bVar = new b(str);
                this.l.put(str, bVar);
            }
            a aVar = new a(bVar);
            bVar.f = aVar;
            return aVar;
        }
        this.E.execute(this.F);
        return null;
    }

    public final File c() {
        return this.i;
    }

    public final synchronized long d() {
        return this.B;
    }

    private synchronized void a(long j) {
        this.B = j;
        if (this.o) {
            this.E.execute(this.F);
        }
    }

    public final synchronized long e() {
        a();
        return this.C;
    }

    final synchronized void a(a aVar, boolean z) {
        b bVar = aVar.a;
        if (bVar.f != aVar) {
            throw new IllegalStateException();
        }
        if (z && !bVar.e) {
            for (int i = 0; i < this.j; i++) {
                if (!aVar.b[i]) {
                    aVar.c();
                    throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i)));
                }
                if (!this.h.e(bVar.d[i])) {
                    aVar.c();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.j; i2++) {
            File file = bVar.d[i2];
            if (z) {
                if (this.h.e(file)) {
                    File file2 = bVar.c[i2];
                    this.h.a(file, file2);
                    long j = bVar.b[i2];
                    long jF = this.h.f(file2);
                    bVar.b[i2] = jF;
                    this.C = (this.C - j) + jF;
                }
            } else {
                this.h.d(file);
            }
        }
        this.m++;
        bVar.f = null;
        if (bVar.e | z) {
            bVar.e = true;
            this.k.b(t).l(32);
            this.k.b(bVar.a);
            bVar.a(this.k);
            this.k.l(10);
            if (z) {
                long j2 = this.D;
                this.D = 1 + j2;
                bVar.g = j2;
            }
        } else {
            this.l.remove(bVar.a);
            this.k.b(v).l(32);
            this.k.b(bVar.a);
            this.k.l(10);
        }
        this.k.flush();
        if (this.C > this.B || f()) {
            this.E.execute(this.F);
        }
    }

    final boolean f() {
        int i = this.m;
        return i >= 2000 && i >= this.l.size();
    }

    public final synchronized boolean c(String str) {
        a();
        o();
        e(str);
        b bVar = this.l.get(str);
        if (bVar == null) {
            return false;
        }
        a(bVar);
        if (this.C <= this.B) {
            this.q = false;
        }
        return true;
    }

    final boolean a(b bVar) {
        if (bVar.f != null) {
            bVar.f.a();
        }
        for (int i = 0; i < this.j; i++) {
            this.h.d(bVar.c[i]);
            this.C -= bVar.b[i];
            bVar.b[i] = 0;
        }
        this.m++;
        this.k.b(v).l(32).b(bVar.a).l(10);
        this.l.remove(bVar.a);
        if (f()) {
            this.E.execute(this.F);
        }
        return true;
    }

    public final synchronized boolean g() {
        return this.p;
    }

    private synchronized void o() {
        if (g()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @Override // java.io.Flushable
    public final synchronized void flush() {
        if (this.o) {
            o();
            h();
            this.k.flush();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (this.o && !this.p) {
            for (b bVar : (b[]) this.l.values().toArray(new b[this.l.size()])) {
                if (bVar.f != null) {
                    bVar.f.c();
                }
            }
            h();
            this.k.close();
            this.k = null;
            this.p = true;
            return;
        }
        this.p = true;
    }

    final void h() {
        while (this.C > this.B) {
            a(this.l.values().iterator().next());
        }
        this.q = false;
    }

    public final void i() {
        close();
        this.h.g(this.i);
    }

    public final synchronized void j() {
        a();
        for (b bVar : (b[]) this.l.values().toArray(new b[this.l.size()])) {
            a(bVar);
        }
        this.q = false;
    }

    private static void e(String str) {
        if (!g.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    public final synchronized Iterator<c> k() {
        a();
        return new Iterator<c>() { // from class: com.anythink.core.common.m.b.a.a.d.3
            final Iterator<b> a;
            c b;
            c c;

            {
                this.a = new ArrayList(d.this.l.values()).iterator();
            }

            @Override // java.util.Iterator
            public final boolean hasNext() {
                c cVarA;
                if (this.b != null) {
                    return true;
                }
                synchronized (d.this) {
                    if (d.this.p) {
                        return false;
                    }
                    while (this.a.hasNext()) {
                        b next = this.a.next();
                        if (next.e && (cVarA = next.a()) != null) {
                            this.b = cVarA;
                            return true;
                        }
                    }
                    return false;
                }
            }

            private c a() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                c cVar = this.b;
                this.c = cVar;
                this.b = null;
                return cVar;
            }

            @Override // java.util.Iterator
            public final void remove() {
                c cVar = this.c;
                if (cVar == null) {
                    throw new IllegalStateException("remove() before next()");
                }
                try {
                    d.this.c(cVar.b);
                } catch (IOException unused) {
                } finally {
                    this.c = null;
                }
            }

            @Override // java.util.Iterator
            public final /* synthetic */ c next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                c cVar = this.b;
                this.c = cVar;
                this.b = null;
                return cVar;
            }
        };
    }

    public final class c implements Closeable {
        private final String b;
        private final long c;
        private final w[] d;
        private final long[] e;

        c(String str, long j, w[] wVarArr, long[] jArr) {
            this.b = str;
            this.c = j;
            this.d = wVarArr;
            this.e = jArr;
        }

        private String b() {
            return this.b;
        }

        public final a a() {
            return d.this.a(this.b, this.c);
        }

        public final w a(int i) {
            return this.d[i];
        }

        private long b(int i) {
            return this.e[i];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            for (w wVar : this.d) {
                com.anythink.core.common.m.b.a.c.a(wVar);
            }
        }
    }

    public final class a {
        final b a;
        final boolean[] b;
        private boolean d;

        a(b bVar) {
            this.a = bVar;
            this.b = bVar.e ? null : new boolean[d.this.j];
        }

        final void a() {
            if (this.a.f == this) {
                for (int i = 0; i < d.this.j; i++) {
                    try {
                        d.this.h.d(this.a.d[i]);
                    } catch (IOException unused) {
                    }
                }
                this.a.f = null;
            }
        }

        private w b(int i) {
            synchronized (d.this) {
                if (this.d) {
                    throw new IllegalStateException();
                }
                if (!this.a.e || this.a.f != this) {
                    return null;
                }
                try {
                    return d.this.h.a(this.a.c[i]);
                } catch (FileNotFoundException unused) {
                    return null;
                }
            }
        }

        public final v a(int i) {
            synchronized (d.this) {
                if (this.d) {
                    throw new IllegalStateException();
                }
                if (this.a.f != this) {
                    return n.a();
                }
                if (!this.a.e) {
                    this.b[i] = true;
                }
                try {
                    return new e(d.this.h.b(this.a.d[i])) { // from class: com.anythink.core.common.m.b.a.a.d.a.1
                        @Override // com.anythink.core.common.m.b.a.a.e
                        protected final void b() {
                            synchronized (d.this) {
                                a.this.a();
                            }
                        }
                    };
                } catch (FileNotFoundException unused) {
                    return n.a();
                }
            }
        }

        public final void b() {
            synchronized (d.this) {
                if (this.d) {
                    throw new IllegalStateException();
                }
                if (this.a.f == this) {
                    d.this.a(this, true);
                }
                this.d = true;
            }
        }

        public final void c() {
            synchronized (d.this) {
                if (this.d) {
                    throw new IllegalStateException();
                }
                if (this.a.f == this) {
                    d.this.a(this, false);
                }
                this.d = true;
            }
        }

        private void d() {
            synchronized (d.this) {
                if (!this.d && this.a.f == this) {
                    try {
                        d.this.a(this, false);
                    } catch (IOException unused) {
                    }
                }
            }
        }
    }

    private final class b {
        final String a;
        final long[] b;
        final File[] c;
        final File[] d;
        boolean e;
        a f;
        long g;

        b(String str) {
            this.a = str;
            this.b = new long[d.this.j];
            this.c = new File[d.this.j];
            this.d = new File[d.this.j];
            StringBuilder sbAppend = new StringBuilder(str).append('.');
            int length = sbAppend.length();
            for (int i = 0; i < d.this.j; i++) {
                sbAppend.append(i);
                this.c[i] = new File(d.this.i, sbAppend.toString());
                sbAppend.append(".tmp");
                this.d[i] = new File(d.this.i, sbAppend.toString());
                sbAppend.setLength(length);
            }
        }

        final void a(String[] strArr) throws IOException {
            if (strArr.length != d.this.j) {
                throw b(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.b[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw b(strArr);
                }
            }
        }

        final void a(com.anythink.core.common.m.c.d dVar) {
            for (long j : this.b) {
                dVar.l(32).o(j);
            }
        }

        private static IOException b(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        final c a() {
            w wVar;
            if (!Thread.holdsLock(d.this)) {
                throw new AssertionError();
            }
            w[] wVarArr = new w[d.this.j];
            long[] jArr = (long[]) this.b.clone();
            for (int i = 0; i < d.this.j; i++) {
                try {
                    wVarArr[i] = d.this.h.a(this.c[i]);
                } catch (FileNotFoundException unused) {
                    for (int i2 = 0; i2 < d.this.j && (wVar = wVarArr[i2]) != null; i2++) {
                        com.anythink.core.common.m.b.a.c.a(wVar);
                    }
                    try {
                        d.this.a(this);
                        return null;
                    } catch (IOException unused2) {
                        return null;
                    }
                }
            }
            return d.this.new c(this.a, this.g, wVarArr, jArr);
        }
    }
}
