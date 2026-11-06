package com.anythink.core.common.m.b.a.k;

import com.anythink.core.common.m.c.e;
import com.anythink.core.common.m.c.f;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.UByte;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: loaded from: classes.dex */
final class c {
    final boolean a;
    final e b;
    final a c;
    boolean d;
    int e;
    long f;
    boolean g;
    boolean h;
    private final com.anythink.core.common.m.c.c i = new com.anythink.core.common.m.c.c();
    private final com.anythink.core.common.m.c.c j = new com.anythink.core.common.m.c.c();
    private final byte[] k;
    private final com.anythink.core.common.m.c.c.a l;

    public interface a {
        void a(int i, String str);

        void b(f fVar);

        void e();

        void f();

        void g();
    }

    c(boolean z, e eVar, a aVar) {
        if (eVar == null) {
            throw new NullPointerException("source == null");
        }
        this.a = z;
        this.b = eVar;
        this.c = aVar;
        this.k = z ? null : new byte[4];
        this.l = z ? null : new com.anythink.core.common.m.c.c.a();
    }

    final void a() throws IOException {
        b();
        if (this.h) {
            c();
            return;
        }
        int i = this.e;
        if (i != 1 && i != 2) {
            throw new ProtocolException("Unknown opcode: " + Integer.toHexString(i));
        }
        f();
        if (i == 1) {
            this.j.u();
        } else {
            this.j.t();
        }
    }

    private void b() throws IOException {
        if (this.d) {
            throw new IOException("closed");
        }
        long jE_ = this.b.a().e_();
        this.b.a().d_();
        try {
            int iK = this.b.k() & UByte.MAX_VALUE;
            this.b.a().a(jE_, TimeUnit.NANOSECONDS);
            this.e = iK & 15;
            boolean z = (iK & 128) != 0;
            this.g = z;
            boolean z2 = (iK & 8) != 0;
            this.h = z2;
            if (z2 && !z) {
                throw new ProtocolException("Control frames must be final.");
            }
            boolean z3 = (iK & 64) != 0;
            boolean z4 = (iK & 32) != 0;
            boolean z5 = (iK & 16) != 0;
            if (z3 || z4 || z5) {
                throw new ProtocolException("Reserved flags are unsupported.");
            }
            int iK2 = this.b.k() & UByte.MAX_VALUE;
            boolean z6 = (iK2 & 128) != 0;
            if (z6 == this.a) {
                throw new ProtocolException(this.a ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
            }
            long j = iK2 & WorkQueueKt.MASK;
            this.f = j;
            if (j == 126) {
                this.f = ((long) this.b.l()) & 65535;
            } else if (j == 127) {
                long jN = this.b.n();
                this.f = jN;
                if (jN < 0) {
                    throw new ProtocolException("Frame length 0x" + Long.toHexString(this.f) + " > 0x7FFFFFFFFFFFFFFF");
                }
            }
            if (this.h && this.f > 125) {
                throw new ProtocolException("Control frame must be less than 125B.");
            }
            if (z6) {
                this.b.b(this.k);
            }
        } catch (Throwable th) {
            this.b.a().a(jE_, TimeUnit.NANOSECONDS);
            throw th;
        }
    }

    private void c() throws ProtocolException {
        short sL;
        String strU;
        long j = this.f;
        if (j > 0) {
            this.b.b(this.i, j);
            if (!this.a) {
                this.i.a(this.l);
                this.l.a(0L);
                b.a(this.l, this.k);
                this.l.close();
            }
        }
        switch (this.e) {
            case 8:
                long jB = this.i.b();
                if (jB == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (jB != 0) {
                    sL = this.i.l();
                    strU = this.i.u();
                    String strA = b.a(sL);
                    if (strA != null) {
                        throw new ProtocolException(strA);
                    }
                } else {
                    sL = 1005;
                    strU = "";
                }
                this.c.a(sL, strU);
                this.d = true;
                return;
            case 9:
                this.c.b(this.i.t());
                return;
            case 10:
                a aVar = this.c;
                this.i.t();
                aVar.g();
                return;
            default:
                throw new ProtocolException("Unknown control opcode: " + Integer.toHexString(this.e));
        }
    }

    private void d() throws IOException {
        int i = this.e;
        if (i != 1 && i != 2) {
            throw new ProtocolException("Unknown opcode: " + Integer.toHexString(i));
        }
        f();
        if (i == 1) {
            this.j.u();
        } else {
            this.j.t();
        }
    }

    private void e() throws IOException {
        while (!this.d) {
            b();
            if (!this.h) {
                return;
            } else {
                c();
            }
        }
    }

    private void f() throws IOException {
        while (!this.d) {
            long j = this.f;
            if (j > 0) {
                this.b.b(this.j, j);
                if (!this.a) {
                    this.j.a(this.l);
                    this.l.a(this.j.b() - this.f);
                    b.a(this.l, this.k);
                    this.l.close();
                }
            }
            if (this.g) {
                return;
            }
            e();
            if (this.e != 0) {
                throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(this.e));
            }
        }
        throw new IOException("closed");
    }
}
