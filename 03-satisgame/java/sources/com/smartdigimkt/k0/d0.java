package com.smartdigimkt.k0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class d0 extends com.smartdigimkt.p0.c implements com.smartdigimkt.z0.h {
    public final Context R;
    public final l S;
    public final q T;
    public int U;
    public boolean V;
    public boolean W;
    public MediaFormat X;
    public int Y;
    public int Z;
    public int a0;
    public int b0;
    public long c0;
    public boolean d0;
    public boolean e0;

    public d0(Context context, Handler handler, com.smartdigimkt.i0.h0 h0Var, c cVar, e... eVarArr) {
        a0 a0Var = new a0(cVar, eVarArr);
        super(1);
        this.R = context.getApplicationContext();
        this.T = a0Var;
        this.S = new l(handler, h0Var);
        a0Var.j = new c0(this);
    }

    @Override // com.smartdigimkt.p0.c
    public final int a(com.smartdigimkt.p0.a aVar, com.smartdigimkt.i0.s sVar, com.smartdigimkt.i0.s sVar2) {
        return 0;
    }

    @Override // com.smartdigimkt.p0.c
    public final com.smartdigimkt.p0.a a(com.smartdigimkt.p0.d dVar, com.smartdigimkt.i0.s sVar) {
        int iA = com.smartdigimkt.z0.i.a(sVar.f);
        if (iA != 0 && ((a0) this.T).a(iA)) {
            dVar.getClass();
            com.smartdigimkt.p0.a aVar = com.smartdigimkt.p0.j.a;
            if (aVar != null) {
                return aVar;
            }
        }
        String str = sVar.f;
        dVar.getClass();
        return com.smartdigimkt.p0.j.a(str, false);
    }

    @Override // com.smartdigimkt.z0.h
    public final long b() {
        if (this.c == 2) {
            long jA = ((a0) this.T).a(d());
            if (jA != Long.MIN_VALUE) {
                if (!this.e0) {
                    jA = Math.max(this.c0, jA);
                }
                this.c0 = jA;
                this.e0 = false;
            }
        }
        return this.c0;
    }

    @Override // com.smartdigimkt.i0.a
    public final com.smartdigimkt.z0.h c() {
        return this;
    }

    @Override // com.smartdigimkt.p0.c, com.smartdigimkt.i0.a
    public final boolean d() {
        if (this.N) {
            a0 a0Var = (a0) this.T;
            if (!a0Var.c() || (a0Var.S && (!a0Var.c() || !a0Var.h.b(a0Var.b())))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.smartdigimkt.p0.c, com.smartdigimkt.i0.a
    public final boolean e() {
        a0 a0Var = (a0) this.T;
        return (a0Var.c() && a0Var.h.b(a0Var.b())) || super.e();
    }

    @Override // com.smartdigimkt.i0.a
    public final void f() {
        try {
            a0 a0Var = (a0) this.T;
            a0Var.g();
            for (e eVar : a0Var.e) {
                eVar.h();
            }
            for (e eVar2 : a0Var.f) {
                eVar2.h();
            }
            a0Var.U = 0;
            a0Var.T = false;
            try {
                this.o = null;
                n();
                synchronized (this.P) {
                }
            } finally {
                this.P.a();
                l lVar = this.S;
                com.smartdigimkt.l0.d dVar = this.P;
                if (lVar.b != null) {
                    lVar.a.post(new j(lVar, dVar));
                }
            }
        } catch (Throwable th) {
            try {
                this.o = null;
                n();
                throw th;
            } finally {
                this.P.a();
                l lVar2 = this.S;
                com.smartdigimkt.l0.d dVar2 = this.P;
                if (lVar2.b != null) {
                    lVar2.a.post(new j(lVar2, dVar2));
                }
            }
        }
    }

    @Override // com.smartdigimkt.i0.a
    public final void g() {
        com.smartdigimkt.l0.d dVar = new com.smartdigimkt.l0.d();
        this.P = dVar;
        l lVar = this.S;
        if (lVar.b != null) {
            lVar.a.post(new f(lVar, dVar));
        }
        int i = this.b.a;
        if (i == 0) {
            a0 a0Var = (a0) this.T;
            if (a0Var.V) {
                a0Var.V = false;
                a0Var.U = 0;
                a0Var.g();
                return;
            }
            return;
        }
        a0 a0Var2 = (a0) this.T;
        a0Var2.getClass();
        if (com.smartdigimkt.z0.u.a < 21) {
            throw new IllegalStateException();
        }
        if (a0Var2.V && a0Var2.U == i) {
            return;
        }
        a0Var2.V = true;
        a0Var2.U = i;
        a0Var2.g();
    }

    @Override // com.smartdigimkt.i0.a
    public final void h() {
        ((a0) this.T).e();
    }

    @Override // com.smartdigimkt.i0.a
    public final void i() {
        long jA = ((a0) this.T).a(d());
        if (jA != Long.MIN_VALUE) {
            if (!this.e0) {
                jA = Math.max(this.c0, jA);
            }
            this.c0 = jA;
            this.e0 = false;
        }
        ((a0) this.T).d();
    }

    @Override // com.smartdigimkt.p0.c
    public final void o() throws com.smartdigimkt.i0.g {
        try {
            ((a0) this.T).f();
        } catch (p e) {
            throw new com.smartdigimkt.i0.g(1, e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0052  */
    /* JADX WARN: Code duplicated, block: B:29:0x005e  */
    /* JADX WARN: Code duplicated, block: B:31:0x0062  */
    /* JADX WARN: Code duplicated, block: B:34:0x0068 A[LOOP:0: B:32:0x0064->B:34:0x0068, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:35:0x0072  */
    /* JADX WARN: Code duplicated, block: B:38:0x007c  */
    /* JADX WARN: Code duplicated, block: B:43:0x0086 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:44:0x0088 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:45:0x0089  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a5  */
    @Override // com.smartdigimkt.p0.c
    public final int b(com.smartdigimkt.p0.d dVar, com.smartdigimkt.i0.s sVar) {
        com.smartdigimkt.m0.d dVar2;
        boolean z;
        com.smartdigimkt.p0.a aVarA;
        int i;
        int i2;
        int i3;
        int i4;
        int iA;
        String str = sVar.f;
        if (!com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_AUDIO.equals(com.smartdigimkt.z0.i.b(str))) {
            return 0;
        }
        int i5 = com.smartdigimkt.z0.u.a >= 21 ? 32 : 0;
        boolean z2 = sVar.i == null;
        if (z2 && (iA = com.smartdigimkt.z0.i.a(str)) != 0 && ((a0) this.T).a(iA)) {
            dVar.getClass();
            if (com.smartdigimkt.p0.j.a != null) {
                return i5 | 12;
            }
        }
        if ("audio/raw".equals(str)) {
            if (((a0) this.T).a(sVar.u)) {
                if (((a0) this.T).a(2)) {
                    dVar2 = sVar.i;
                    if (dVar2 != null) {
                        z = false;
                        for (i4 = 0; i4 < dVar2.d; i4++) {
                            z |= dVar2.a[i4].f;
                        }
                    } else {
                        z = false;
                    }
                    dVar.getClass();
                    aVarA = com.smartdigimkt.p0.j.a(str, z);
                    if (aVarA == null) {
                        return (!z || com.smartdigimkt.p0.j.a(str, false) == null) ? 1 : 2;
                    }
                    if (!z2) {
                        return 2;
                    }
                    if (com.smartdigimkt.z0.u.a >= 21 || (((i2 = sVar.t) == -1 || aVarA.b(i2)) && ((i3 = sVar.s) == -1 || aVarA.a(i3)))) {
                        i = 4;
                    } else {
                        i = 3;
                    }
                    return i | i5 | 8;
                }
            }
        } else if (((a0) this.T).a(2)) {
            dVar2 = sVar.i;
            if (dVar2 != null) {
                z = false;
                while (i4 < dVar2.d) {
                    z |= dVar2.a[i4].f;
                }
            } else {
                z = false;
            }
            dVar.getClass();
            aVarA = com.smartdigimkt.p0.j.a(str, z);
            if (aVarA == null) {
                if (z) {
                    return 1;
                }
            }
            if (!z2) {
                return 2;
            }
            if (com.smartdigimkt.z0.u.a >= 21) {
                i = 4;
            } else {
                i = 4;
            }
            return i | i5 | 8;
        }
        return 1;
    }

    @Override // com.smartdigimkt.p0.c
    public final void a(String str, long j, long j2) {
        l lVar = this.S;
        if (lVar.b != null) {
            lVar.a.post(new g(lVar, str, j, j2));
        }
    }

    @Override // com.smartdigimkt.p0.c
    public final void a(MediaCodec mediaCodec, MediaFormat mediaFormat) throws com.smartdigimkt.i0.g {
        int iA;
        int[] iArr;
        int i;
        MediaFormat mediaFormat2 = this.X;
        if (mediaFormat2 != null) {
            iA = com.smartdigimkt.z0.i.a(mediaFormat2.getString("mime"));
            mediaFormat = this.X;
        } else {
            iA = this.Y;
        }
        int i2 = iA;
        int integer = mediaFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT);
        int integer2 = mediaFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_SAMPLE_RATE);
        if (this.W && integer == 6 && (i = this.Z) < 6) {
            iArr = new int[i];
            for (int i3 = 0; i3 < this.Z; i3++) {
                iArr[i3] = i3;
            }
        } else {
            iArr = null;
        }
        try {
            ((a0) this.T).a(i2, integer, integer2, iArr, this.a0, this.b0);
        } catch (n e) {
            throw new com.smartdigimkt.i0.g(1, e);
        }
    }

    @Override // com.smartdigimkt.z0.h
    public final com.smartdigimkt.i0.a0 a(com.smartdigimkt.i0.a0 a0Var) {
        return ((a0) this.T).a(a0Var);
    }

    @Override // com.smartdigimkt.z0.h
    public final com.smartdigimkt.i0.a0 a() {
        return ((a0) this.T).w;
    }

    @Override // com.smartdigimkt.p0.c
    public final void b(com.smartdigimkt.i0.s sVar) {
        super.b(sVar);
        l lVar = this.S;
        if (lVar.b != null) {
            lVar.a.post(new h(lVar, sVar));
        }
        this.Y = "audio/raw".equals(sVar.f) ? sVar.u : 2;
        this.Z = sVar.s;
        this.a0 = sVar.v;
        this.b0 = sVar.w;
    }

    @Override // com.smartdigimkt.p0.c
    public final void a(com.smartdigimkt.l0.e eVar) {
        if (!this.d0 || eVar.b(Integer.MIN_VALUE)) {
            return;
        }
        if (Math.abs(eVar.c - this.c0) > 500000) {
            this.c0 = eVar.c;
        }
        this.d0 = false;
    }

    @Override // com.smartdigimkt.i0.a
    public final void a(long j, boolean z) {
        this.M = false;
        this.N = false;
        if (this.p != null) {
            k();
        }
        ((a0) this.T).g();
        this.c0 = j;
        this.d0 = true;
        this.e0 = true;
    }

    @Override // com.smartdigimkt.p0.c
    public final boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws com.smartdigimkt.i0.g {
        if (this.V && (i2 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i, false);
            return true;
        }
        if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            this.P.getClass();
            a0 a0Var = (a0) this.T;
            if (a0Var.I == 1) {
                a0Var.I = 2;
            }
            return true;
        }
        try {
            if (!((a0) this.T).a(byteBuffer, j3)) {
                return false;
            }
            mediaCodec.releaseOutputBuffer(i, false);
            this.P.getClass();
            return true;
        } catch (o | p e) {
            throw new com.smartdigimkt.i0.g(1, e);
        }
    }

    @Override // com.smartdigimkt.i0.a
    public final void a(int i, Object obj) {
        if (i == 2) {
            q qVar = this.T;
            float fFloatValue = ((Float) obj).floatValue();
            a0 a0Var = (a0) qVar;
            if (a0Var.K != fFloatValue) {
                a0Var.K = fFloatValue;
                a0Var.h();
                return;
            }
            return;
        }
        if (i != 3) {
            return;
        }
        b bVar = (b) obj;
        a0 a0Var2 = (a0) this.T;
        if (a0Var2.r.equals(bVar)) {
            return;
        }
        a0Var2.r = bVar;
        if (a0Var2.V) {
            return;
        }
        a0Var2.g();
        a0Var2.U = 0;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x005e  */
    @Override // com.smartdigimkt.p0.c
    public final void a(com.smartdigimkt.p0.a aVar, MediaCodec mediaCodec, com.smartdigimkt.i0.s sVar) {
        boolean z;
        PackageManager packageManager;
        int i = com.smartdigimkt.z0.u.a;
        this.U = (i >= 24 || !"OMX.google.raw.decoder".equals(aVar.a) || (i == 23 && (packageManager = this.R.getPackageManager()) != null && packageManager.hasSystemFeature("android.software.leanback"))) ? sVar.g : -1;
        String str = aVar.a;
        if (i < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(com.smartdigimkt.z0.u.c)) {
            String str2 = com.smartdigimkt.z0.u.b;
            if (str2.startsWith("zeroflte") || str2.startsWith("herolte") || str2.startsWith("heroqlte")) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        this.W = z;
        this.V = aVar.g;
        String str3 = aVar.b;
        if (str3 == null) {
            str3 = "audio/raw";
        }
        int i2 = this.U;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str3);
        mediaFormat.setInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT, sVar.s);
        mediaFormat.setInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_SAMPLE_RATE, sVar.t);
        List list = sVar.h;
        for (int i3 = 0; i3 < list.size(); i3++) {
            mediaFormat.setByteBuffer("csd-" + i3, ByteBuffer.wrap((byte[]) list.get(i3)));
        }
        com.smartdigimkt.p0.k.a(mediaFormat, "max-input-size", i2);
        if (i >= 23) {
            mediaFormat.setInteger("priority", 0);
        }
        mediaCodec.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 0);
        if (this.V) {
            this.X = mediaFormat;
            mediaFormat.setString("mime", sVar.f);
        } else {
            this.X = null;
        }
    }
}
