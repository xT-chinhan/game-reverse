package com.anythink.basead.exoplayer.j.a;

import com.anythink.basead.exoplayer.k.af;
import com.anythink.basead.exoplayer.k.x;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class b implements com.anythink.basead.exoplayer.j.g {
    public static final int a = 20480;
    private final com.anythink.basead.exoplayer.j.a.a b;
    private final long c;
    private final int d;
    private final boolean e;
    private com.anythink.basead.exoplayer.j.k f;
    private File g;
    private OutputStream h;
    private FileOutputStream i;
    private long j;
    private long k;
    private x l;

    public static class a extends com.anythink.basead.exoplayer.j.a.a.C0036a {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public b(com.anythink.basead.exoplayer.j.a.a aVar) {
        this(aVar, c.a, a, true);
    }

    private b(com.anythink.basead.exoplayer.j.a.a aVar, long j, boolean z) {
        this(aVar, j, a, z);
    }

    private b(com.anythink.basead.exoplayer.j.a.a aVar, long j, int i) {
        this(aVar, j, i, true);
    }

    private b(com.anythink.basead.exoplayer.j.a.a aVar, long j, int i, boolean z) {
        this.b = (com.anythink.basead.exoplayer.j.a.a) com.anythink.basead.exoplayer.k.a.a(aVar);
        this.c = j;
        this.d = i;
        this.e = z;
    }

    @Override // com.anythink.basead.exoplayer.j.g
    public final void a(com.anythink.basead.exoplayer.j.k kVar) throws a {
        if (kVar.g == -1 && !kVar.a(2)) {
            this.f = null;
            return;
        }
        this.f = kVar;
        this.k = 0L;
        try {
            b();
        } catch (IOException e) {
            throw new a(e);
        }
    }

    @Override // com.anythink.basead.exoplayer.j.g
    public final void a(byte[] bArr, int i, int i2) throws a {
        if (this.f == null) {
            return;
        }
        int i3 = 0;
        while (i3 < i2) {
            try {
                if (this.j == this.c) {
                    c();
                    b();
                }
                int iMin = (int) Math.min(i2 - i3, this.c - this.j);
                this.h.write(bArr, i + i3, iMin);
                i3 += iMin;
                long j = iMin;
                this.j += j;
                this.k += j;
            } catch (IOException e) {
                throw new a(e);
            }
        }
    }

    @Override // com.anythink.basead.exoplayer.j.g
    public final void a() throws a {
        if (this.f == null) {
            return;
        }
        try {
            c();
        } catch (IOException e) {
            throw new a(e);
        }
    }

    private void b() {
        if (this.f.g != -1) {
            Math.min(this.f.g - this.k, this.c);
        }
        this.g = this.b.c(this.f.h, this.f.e + this.k);
        FileOutputStream fileOutputStream = new FileOutputStream(this.g);
        this.i = fileOutputStream;
        if (this.d > 0) {
            x xVar = this.l;
            if (xVar == null) {
                this.l = new x(this.i, this.d);
            } else {
                xVar.a(fileOutputStream);
            }
            this.h = this.l;
        } else {
            this.h = fileOutputStream;
        }
        this.j = 0L;
    }

    private void c() {
        OutputStream outputStream = this.h;
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.flush();
            if (this.e) {
                this.i.getFD().sync();
            }
            af.a(this.h);
            this.h = null;
            File file = this.g;
            this.g = null;
            this.b.a(file);
        } catch (Throwable th) {
            af.a(this.h);
            this.h = null;
            File file2 = this.g;
            this.g = null;
            file2.delete();
            throw th;
        }
    }
}
