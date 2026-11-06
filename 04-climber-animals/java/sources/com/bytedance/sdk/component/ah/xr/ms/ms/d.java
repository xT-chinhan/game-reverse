package com.bytedance.sdk.component.ah.xr.ms.ms;

import com.bytedance.sdk.component.ah.ms.qv;
import com.bytedance.sdk.component.ah.ms.sl;
import com.bytedance.sdk.component.ah.ms.y;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements Closeable, Flushable {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    static final Pattern f1109ms = Pattern.compile("[a-z0-9_-]{1,120}");
    static final /* synthetic */ boolean zb = true;
    int ab;
    final File ah;
    private final File ao;
    private final Runnable b;
    final LinkedHashMap<String, xr> c;
    boolean ch;
    final int d;
    private final int h;
    boolean hi;
    com.bytedance.sdk.component.ah.ms.d ka;
    private final Executor nw;
    boolean ny;
    private long qv;
    boolean sl;
    private long t;
    private final File u;
    private final File ub;
    boolean x;
    final com.bytedance.sdk.component.ah.xr.ms.c.ms xr;
    private long y;

    public synchronized void ms() throws IOException {
        if (!zb && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (this.ny) {
            return;
        }
        if (this.xr.d(this.ao)) {
            if (this.xr.d(this.u)) {
                this.xr.delete(this.ao);
            } else {
                this.xr.ms(this.ao, this.u);
            }
        }
        if (this.xr.d(this.u)) {
            try {
                c();
                x();
                this.ny = true;
                return;
            } catch (IOException e) {
                com.bytedance.sdk.component.ah.xr.ms.ab.ka.xr().ms(5, "DiskLruCache " + this.ah + " is corrupt: " + e.getMessage() + ", removing", e);
                try {
                    delete();
                    this.ch = false;
                    xr();
                    this.ny = true;
                } catch (Throwable th) {
                    this.ch = false;
                    throw th;
                }
            }
        }
        xr();
        this.ny = true;
    }

    private void c() throws IOException {
        com.bytedance.sdk.component.ah.ms.ka kaVarMs = sl.ms(this.xr.ms(this.u));
        try {
            String strAo = kaVarMs.ao();
            String strAo2 = kaVarMs.ao();
            String strAo3 = kaVarMs.ao();
            String strAo4 = kaVarMs.ao();
            String strAo5 = kaVarMs.ao();
            if (!"libcore.io.DiskLruCache".equals(strAo) || !"1".equals(strAo2) || !Integer.toString(this.h).equals(strAo3) || !Integer.toString(this.d).equals(strAo4) || !"".equals(strAo5)) {
                throw new IOException("unexpected journal header: [" + strAo + ", " + strAo2 + ", " + strAo4 + ", " + strAo5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    ms(kaVarMs.ao());
                    i++;
                } catch (EOFException unused) {
                    this.ab = i - this.c.size();
                    if (!kaVarMs.ka()) {
                        xr();
                    } else {
                        this.ka = ab();
                    }
                    com.bytedance.sdk.component.ah.xr.ms.ah.ms(kaVarMs);
                    return;
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.ah.xr.ms.ah.ms(kaVarMs);
            throw th;
        }
    }

    private com.bytedance.sdk.component.ah.ms.d ab() throws FileNotFoundException {
        return sl.ms(new ka(this.xr.ah(this.u)) { // from class: com.bytedance.sdk.component.ah.xr.ms.ms.d.1

            /* JADX INFO: renamed from: ms, reason: collision with root package name */
            static final /* synthetic */ boolean f1110ms = true;

            @Override // com.bytedance.sdk.component.ah.xr.ms.ms.ka
            protected void ms(IOException iOException) {
                if (!f1110ms && !Thread.holdsLock(d.this)) {
                    throw new AssertionError();
                }
                d.this.x = true;
            }
        });
    }

    private void ms(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: ".concat(String.valueOf(str)));
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                this.c.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        xr xrVar = this.c.get(strSubstring);
        if (xrVar == null) {
            xrVar = new xr(strSubstring);
            this.c.put(strSubstring, xrVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            xrVar.ka = true;
            xrVar.c = null;
            xrVar.ms(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
            xrVar.c = new ms(xrVar);
        } else if (iIndexOf2 != -1 || iIndexOf != 4 || !str.startsWith("READ")) {
            throw new IOException("unexpected journal line: ".concat(String.valueOf(str)));
        }
    }

    private void x() throws IOException {
        this.xr.delete(this.ub);
        Iterator<xr> it = this.c.values().iterator();
        while (it.hasNext()) {
            xr next = it.next();
            int i = 0;
            if (next.c == null) {
                while (i < this.d) {
                    this.y += next.xr[i];
                    i++;
                }
            } else {
                next.c = null;
                while (i < this.d) {
                    this.xr.delete(next.ah[i]);
                    this.xr.delete(next.d[i]);
                    i++;
                }
                it.remove();
            }
        }
    }

    synchronized void xr() throws IOException {
        try {
            com.bytedance.sdk.component.ah.ms.d dVar = this.ka;
            if (dVar != null) {
                dVar.close();
            }
            com.bytedance.sdk.component.ah.ms.d dVarMs = sl.ms(this.xr.xr(this.ub));
            try {
                dVarMs.xr("libcore.io.DiskLruCache").ny(10);
                dVarMs.xr("1").ny(10);
                dVarMs.sl(this.h).ny(10);
                dVarMs.sl(this.d).ny(10);
                dVarMs.ny(10);
                for (xr xrVar : this.c.values()) {
                    if (xrVar.c != null) {
                        dVarMs.xr("DIRTY").ny(32);
                        dVarMs.xr(xrVar.f1114ms);
                        dVarMs.ny(10);
                    } else {
                        dVarMs.xr("CLEAN").ny(32);
                        dVarMs.xr(xrVar.f1114ms);
                        xrVar.ms(dVarMs);
                        dVarMs.ny(10);
                    }
                }
                dVarMs.close();
                if (this.xr.d(this.u)) {
                    this.xr.ms(this.u, this.ao);
                }
                this.xr.ms(this.ub, this.u);
                this.xr.delete(this.ao);
                this.ka = ab();
                this.x = false;
                this.sl = false;
            } catch (Throwable th) {
                dVarMs.close();
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    synchronized ms ms(String str, long j) throws IOException {
        ms();
        ny();
        xr(str);
        xr xrVar = this.c.get(str);
        if (j != -1 && (xrVar == null || xrVar.ab != j)) {
            return null;
        }
        if (xrVar != null && xrVar.c != null) {
            return null;
        }
        if (!this.hi && !this.sl) {
            this.ka.xr("DIRTY").ny(32).xr(str).ny(10);
            this.ka.flush();
            if (this.x) {
                return null;
            }
            if (xrVar == null) {
                xrVar = new xr(str);
                this.c.put(str, xrVar);
            }
            ms msVar = new ms(xrVar);
            xrVar.c = msVar;
            return msVar;
        }
        this.nw.execute(this.b);
        return null;
    }

    synchronized void ms(ms msVar, boolean z) throws IOException {
        xr xrVar = msVar.f1112ms;
        if (xrVar.c != msVar) {
            throw new IllegalStateException();
        }
        if (z && !xrVar.ka) {
            for (int i = 0; i < this.d; i++) {
                if (!msVar.xr[i]) {
                    msVar.ah();
                    throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i)));
                }
                if (!this.xr.d(xrVar.d[i])) {
                    msVar.ah();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.d; i2++) {
            File file = xrVar.d[i2];
            if (z) {
                if (this.xr.d(file)) {
                    File file2 = xrVar.ah[i2];
                    this.xr.ms(file, file2);
                    long j = xrVar.xr[i2];
                    long jKa = this.xr.ka(file2);
                    xrVar.xr[i2] = jKa;
                    this.y = (this.y - j) + jKa;
                }
            } else {
                this.xr.delete(file);
            }
        }
        this.ab++;
        xrVar.c = null;
        if (xrVar.ka | z) {
            xrVar.ka = true;
            this.ka.xr("CLEAN").ny(32);
            this.ka.xr(xrVar.f1114ms);
            xrVar.ms(this.ka);
            this.ka.ny(10);
            if (z) {
                long j2 = this.t;
                this.t = 1 + j2;
                xrVar.ab = j2;
            }
        } else {
            this.c.remove(xrVar.f1114ms);
            this.ka.xr("REMOVE").ny(32);
            this.ka.xr(xrVar.f1114ms);
            this.ka.ny(10);
        }
        this.ka.flush();
        if (this.y > this.qv || ah()) {
            this.nw.execute(this.b);
        }
    }

    boolean ah() {
        int i = this.ab;
        return i >= 2000 && i >= this.c.size();
    }

    boolean ms(xr xrVar) throws IOException {
        if (xrVar.c != null) {
            xrVar.c.ms();
        }
        for (int i = 0; i < this.d; i++) {
            this.xr.delete(xrVar.ah[i]);
            this.y -= xrVar.xr[i];
            xrVar.xr[i] = 0;
        }
        this.ab++;
        this.ka.xr("REMOVE").ny(32).xr(xrVar.f1114ms).ny(10);
        this.c.remove(xrVar.f1114ms);
        if (ah()) {
            this.nw.execute(this.b);
        }
        return true;
    }

    public synchronized boolean d() {
        return this.ch;
    }

    private synchronized void ny() {
        if (d()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.ny) {
            ny();
            ka();
            this.ka.flush();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.ny && !this.ch) {
            for (xr xrVar : (xr[]) this.c.values().toArray(new xr[this.c.size()])) {
                if (xrVar.c != null) {
                    xrVar.c.ah();
                }
            }
            ka();
            this.ka.close();
            this.ka = null;
            this.ch = true;
            return;
        }
        this.ch = true;
    }

    void ka() throws IOException {
        while (this.y > this.qv) {
            ms(this.c.values().iterator().next());
        }
        this.hi = false;
    }

    public void delete() throws IOException {
        close();
        this.xr.c(this.ah);
    }

    private void xr(String str) {
        if (!f1109ms.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    public final class ah implements Closeable {
        private final long ah;
        private final y[] d;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        final /* synthetic */ d f1111ms;
        private final String xr;

        public ms ms() throws IOException {
            return this.f1111ms.ms(this.xr, this.ah);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (y yVar : this.d) {
                com.bytedance.sdk.component.ah.xr.ms.ah.ms(yVar);
            }
        }
    }

    public final class ms {
        private boolean d;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        final xr f1112ms;
        final boolean[] xr;

        ms(xr xrVar) {
            this.f1112ms = xrVar;
            this.xr = xrVar.ka ? null : new boolean[d.this.d];
        }

        void ms() {
            if (this.f1112ms.c == this) {
                for (int i = 0; i < d.this.d; i++) {
                    try {
                        d.this.xr.delete(this.f1112ms.d[i]);
                    } catch (IOException unused) {
                    }
                }
                this.f1112ms.c = null;
            }
        }

        public qv ms(int i) {
            synchronized (d.this) {
                if (this.d) {
                    throw new IllegalStateException();
                }
                if (this.f1112ms.c != this) {
                    return sl.ms();
                }
                if (!this.f1112ms.ka) {
                    this.xr[i] = true;
                }
                try {
                    return new ka(d.this.xr.xr(this.f1112ms.d[i])) { // from class: com.bytedance.sdk.component.ah.xr.ms.ms.d.ms.1
                        @Override // com.bytedance.sdk.component.ah.xr.ms.ms.ka
                        protected void ms(IOException iOException) {
                            synchronized (d.this) {
                                ms.this.ms();
                            }
                        }
                    };
                } catch (FileNotFoundException unused) {
                    return sl.ms();
                }
            }
        }

        public void xr() throws IOException {
            synchronized (d.this) {
                if (this.d) {
                    throw new IllegalStateException();
                }
                if (this.f1112ms.c == this) {
                    d.this.ms(this, true);
                }
                this.d = true;
            }
        }

        public void ah() throws IOException {
            synchronized (d.this) {
                if (this.d) {
                    throw new IllegalStateException();
                }
                if (this.f1112ms.c == this) {
                    d.this.ms(this, false);
                }
                this.d = true;
            }
        }
    }

    private final class xr {
        long ab;
        final File[] ah;
        ms c;
        final File[] d;
        boolean ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        final String f1114ms;
        final long[] xr;

        xr(String str) {
            this.f1114ms = str;
            this.xr = new long[d.this.d];
            this.ah = new File[d.this.d];
            this.d = new File[d.this.d];
            StringBuilder sbAppend = new StringBuilder(str).append('.');
            int length = sbAppend.length();
            for (int i = 0; i < d.this.d; i++) {
                sbAppend.append(i);
                this.ah[i] = new File(d.this.ah, sbAppend.toString());
                sbAppend.append(".tmp");
                this.d[i] = new File(d.this.ah, sbAppend.toString());
                sbAppend.setLength(length);
            }
        }

        void ms(String[] strArr) throws IOException {
            if (strArr.length != d.this.d) {
                throw xr(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.xr[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw xr(strArr);
                }
            }
        }

        void ms(com.bytedance.sdk.component.ah.ms.d dVar) throws IOException {
            for (long j : this.xr) {
                dVar.ny(32).sl(j);
            }
        }

        private IOException xr(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }
    }
}
