package com.smartdigimkt.a1;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.smartdigimkt.i0.h0;
import com.smartdigimkt.z0.u;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends com.smartdigimkt.p0.c {
    public static final int[] C0 = {1920, 1600, 1440, 1280, 960, 854, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HW_ERR_REASON, 480};
    public static boolean D0;
    public static boolean E0;
    public long A0;
    public int B0;
    public final Context R;
    public final j S;
    public final s T;
    public final long U;
    public final int V;
    public final boolean W;
    public final long[] X;
    public final long[] Y;
    public e Z;
    public boolean a0;
    public Surface b0;
    public d c0;
    public int d0;
    public boolean e0;
    public long f0;
    public long g0;
    public long h0;
    public int i0;
    public int j0;
    public int k0;
    public long l0;
    public int m0;
    public float n0;
    public int o0;
    public int p0;
    public int q0;
    public float r0;
    public int s0;
    public int t0;
    public int u0;
    public float v0;
    public boolean w0;
    public int x0;
    public f y0;
    public long z0;

    public g(Context context, long j, Handler handler, h0 h0Var) {
        super(2);
        this.U = j;
        this.V = 50;
        Context applicationContext = context.getApplicationContext();
        this.R = applicationContext;
        this.S = new j(applicationContext);
        this.T = new s(handler, h0Var);
        this.W = u.a <= 22 && "foster".equals(u.b) && "NVIDIA".equals(u.c);
        this.X = new long[10];
        this.Y = new long[10];
        this.A0 = -9223372036854775807L;
        this.z0 = -9223372036854775807L;
        this.g0 = -9223372036854775807L;
        this.o0 = -1;
        this.p0 = -1;
        this.r0 = -1.0f;
        this.n0 = -1.0f;
        this.d0 = 1;
        this.s0 = -1;
        this.t0 = -1;
        this.v0 = -1.0f;
        this.u0 = -1;
    }

    @Override // com.smartdigimkt.p0.c
    public final void a(com.smartdigimkt.p0.a aVar, MediaCodec mediaCodec, com.smartdigimkt.i0.s sVar) {
        e eVar;
        Point point;
        int i;
        com.smartdigimkt.i0.s[] sVarArr = this.e;
        int iMax = sVar.k;
        int iMax2 = sVar.l;
        int iA = a(aVar, sVar);
        if (sVarArr.length == 1) {
            eVar = new e(iMax, iMax2, iA);
        } else {
            boolean z = false;
            for (com.smartdigimkt.i0.s sVar2 : sVarArr) {
                if (a(aVar.d, sVar, sVar2)) {
                    int i2 = sVar2.k;
                    z |= i2 == -1 || sVar2.l == -1;
                    iMax = Math.max(iMax, i2);
                    iMax2 = Math.max(iMax2, sVar2.l);
                    iA = Math.max(iA, a(aVar, sVar2));
                }
            }
            if (z) {
                int i3 = sVar.l;
                int i4 = sVar.k;
                boolean z2 = i3 > i4;
                int i5 = z2 ? i3 : i4;
                if (z2) {
                    i3 = i4;
                }
                float f = i3 / i5;
                int[] iArr = C0;
                int i6 = 0;
                while (true) {
                    if (i6 < 9) {
                        int i7 = iArr[i6];
                        int i8 = (int) (i7 * f);
                        if (i7 > i5 && i8 > i3) {
                            int i9 = i3;
                            if (u.a >= 21) {
                                int i10 = z2 ? i8 : i7;
                                if (!z2) {
                                    i7 = i8;
                                }
                                point = aVar.a(i10, i7);
                                if (aVar.a(point.x, point.y, sVar.m)) {
                                    break;
                                }
                                i6++;
                                i3 = i9;
                                f = f;
                            } else {
                                int i11 = ((i7 + 15) / 16) * 16;
                                int i12 = ((i8 + 15) / 16) * 16;
                                if (i11 * i12 <= com.smartdigimkt.p0.j.a()) {
                                    int i13 = z2 ? i12 : i11;
                                    if (!z2) {
                                        i11 = i12;
                                    }
                                    point = new Point(i13, i11);
                                    break;
                                }
                                i6++;
                                i3 = i9;
                                f = f;
                            }
                        }
                    }
                    point = null;
                    break;
                }
                if (point != null) {
                    iMax = Math.max(iMax, point.x);
                    iMax2 = Math.max(iMax2, point.y);
                    iA = Math.max(iA, a(aVar, sVar.f, iMax, iMax2));
                }
            }
            eVar = new e(iMax, iMax2, iA);
        }
        this.Z = eVar;
        boolean z3 = this.W;
        int i14 = this.x0;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", sVar.f);
        mediaFormat.setInteger("width", sVar.k);
        mediaFormat.setInteger("height", sVar.l);
        List list = sVar.h;
        for (int i15 = 0; i15 < list.size(); i15++) {
            mediaFormat.setByteBuffer("csd-" + i15, ByteBuffer.wrap((byte[]) list.get(i15)));
        }
        float f2 = sVar.m;
        if (f2 != -1.0f) {
            mediaFormat.setFloat("frame-rate", f2);
        }
        com.smartdigimkt.p0.k.a(mediaFormat, "rotation-degrees", sVar.n);
        b bVar = sVar.r;
        if (bVar != null) {
            com.smartdigimkt.p0.k.a(mediaFormat, "color-transfer", bVar.c);
            com.smartdigimkt.p0.k.a(mediaFormat, "color-standard", bVar.a);
            com.smartdigimkt.p0.k.a(mediaFormat, "color-range", bVar.b);
            byte[] bArr = bVar.d;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        mediaFormat.setInteger("max-width", eVar.a);
        mediaFormat.setInteger("max-height", eVar.b);
        com.smartdigimkt.p0.k.a(mediaFormat, "max-input-size", eVar.c);
        int i16 = u.a;
        if (i16 >= 23) {
            i = 0;
            mediaFormat.setInteger("priority", 0);
        } else {
            i = 0;
        }
        if (z3) {
            mediaFormat.setInteger("auto-frc", i);
        }
        if (i14 != 0) {
            mediaFormat.setFeatureEnabled("tunneled-playback", true);
            mediaFormat.setInteger("audio-session-id", i14);
        }
        if (this.b0 == null) {
            if (!b(aVar)) {
                throw new IllegalStateException();
            }
            if (this.c0 == null) {
                Context context = this.R;
                boolean z4 = aVar.f;
                int i17 = d.c;
                if (i16 < 17) {
                    throw new UnsupportedOperationException("Unsupported prior to API level 17");
                }
                if (z4 && !d.a(context)) {
                    throw new IllegalStateException();
                }
                this.c0 = new c().a(z4 ? d.c : 0);
            }
            this.b0 = this.c0;
        }
        mediaCodec.configure(mediaFormat, this.b0, (MediaCrypto) null, 0);
        if (i16 < 23 || !this.w0) {
            return;
        }
        this.y0 = new f(this, mediaCodec);
    }

    @Override // com.smartdigimkt.p0.c
    public final int b(com.smartdigimkt.p0.d dVar, com.smartdigimkt.i0.s sVar) {
        boolean z;
        int i;
        int i2;
        String str = sVar.f;
        if (!com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_VIDEO.equals(com.smartdigimkt.z0.i.b(str))) {
            return 0;
        }
        com.smartdigimkt.m0.d dVar2 = sVar.i;
        if (dVar2 != null) {
            z = false;
            for (int i3 = 0; i3 < dVar2.d; i3++) {
                z |= dVar2.a[i3].f;
            }
        } else {
            z = false;
        }
        dVar.getClass();
        com.smartdigimkt.p0.a aVarA = com.smartdigimkt.p0.j.a(str, z);
        boolean zA = true;
        if (aVarA == null) {
            return (!z || com.smartdigimkt.p0.j.a(str, false) == null) ? 1 : 2;
        }
        if (dVar2 != null) {
            return 2;
        }
        boolean zA2 = aVarA.a(sVar.c);
        if (!zA2 || (i = sVar.k) <= 0 || (i2 = sVar.l) <= 0) {
            zA = zA2;
        } else if (u.a >= 21) {
            zA = aVarA.a(i, i2, sVar.m);
        } else if (i * i2 > com.smartdigimkt.p0.j.a()) {
            zA = false;
        }
        return (zA ? 4 : 3) | (aVarA.d ? 16 : 8) | (aVarA.e ? 32 : 0);
    }

    @Override // com.smartdigimkt.p0.c, com.smartdigimkt.i0.a
    public final boolean e() {
        d dVar;
        if (super.e() && (this.e0 || (((dVar = this.c0) != null && this.b0 == dVar) || this.p == null || this.w0))) {
            this.g0 = -9223372036854775807L;
            return true;
        }
        if (this.g0 == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.g0) {
            return true;
        }
        this.g0 = -9223372036854775807L;
        return false;
    }

    @Override // com.smartdigimkt.i0.a
    public final void f() {
        this.o0 = -1;
        this.p0 = -1;
        this.r0 = -1.0f;
        this.n0 = -1.0f;
        this.A0 = -9223372036854775807L;
        this.z0 = -9223372036854775807L;
        this.B0 = 0;
        this.s0 = -1;
        this.t0 = -1;
        this.v0 = -1.0f;
        this.u0 = -1;
        q();
        j jVar = this.S;
        if (jVar.a != null) {
            h hVar = jVar.c;
            if (hVar != null) {
                hVar.b();
            }
            jVar.b.b.sendEmptyMessage(2);
        }
        this.y0 = null;
        this.w0 = false;
        try {
            this.o = null;
            n();
            synchronized (this.P) {
            }
        } finally {
            this.P.a();
            s sVar = this.T;
            com.smartdigimkt.l0.d dVar = this.P;
            if (sVar.b != null) {
                sVar.a.post(new r(sVar, dVar));
            }
        }
    }

    @Override // com.smartdigimkt.i0.a
    public final void g() {
        com.smartdigimkt.l0.d dVar = new com.smartdigimkt.l0.d();
        this.P = dVar;
        int i = this.b.a;
        this.x0 = i;
        this.w0 = i != 0;
        s sVar = this.T;
        if (sVar.b != null) {
            sVar.a.post(new l(sVar, dVar));
        }
        j jVar = this.S;
        jVar.i = false;
        if (jVar.a != null) {
            jVar.b.b.sendEmptyMessage(1);
            h hVar = jVar.c;
            if (hVar != null) {
                hVar.a();
            }
            jVar.a();
        }
    }

    @Override // com.smartdigimkt.i0.a
    public final void h() {
        this.i0 = 0;
        this.h0 = SystemClock.elapsedRealtime();
        this.l0 = SystemClock.elapsedRealtime() * 1000;
    }

    @Override // com.smartdigimkt.i0.a
    public final void i() {
        this.g0 = -9223372036854775807L;
        if (this.i0 > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j = jElapsedRealtime - this.h0;
            s sVar = this.T;
            int i = this.i0;
            if (sVar.b != null) {
                sVar.a.post(new o(sVar, i, j));
            }
            this.i0 = 0;
            this.h0 = jElapsedRealtime;
        }
    }

    @Override // com.smartdigimkt.p0.c
    public final void k() {
        super.k();
        this.k0 = 0;
    }

    @Override // com.smartdigimkt.p0.c
    public final void n() {
        d dVar;
        try {
            super.n();
            this.k0 = 0;
            dVar = this.c0;
            if (dVar != null) {
                if (this.b0 == dVar) {
                    this.b0 = null;
                }
            }
        } finally {
            this.k0 = 0;
            if (this.c0 != null) {
                Surface surface = this.b0;
                dVar = this.c0;
                if (surface == dVar) {
                    this.b0 = null;
                }
                dVar.release();
                this.c0 = null;
            }
        }
    }

    public final void q() {
        MediaCodec mediaCodec;
        this.e0 = false;
        if (u.a < 23 || !this.w0 || (mediaCodec = this.p) == null) {
            return;
        }
        this.y0 = new f(this, mediaCodec);
    }

    public final void r() {
        int i = this.o0;
        if (i == -1 && this.p0 == -1) {
            return;
        }
        if (this.s0 == i && this.t0 == this.p0 && this.u0 == this.q0 && this.v0 == this.r0) {
            return;
        }
        s sVar = this.T;
        int i2 = this.p0;
        int i3 = this.q0;
        float f = this.r0;
        if (sVar.b != null) {
            sVar.a.post(new p(sVar, i, i2, i3, f));
        }
        this.s0 = this.o0;
        this.t0 = this.p0;
        this.u0 = this.q0;
        this.v0 = this.r0;
    }

    @Override // com.smartdigimkt.p0.c
    public final void b(com.smartdigimkt.i0.s sVar) {
        super.b(sVar);
        s sVar2 = this.T;
        if (sVar2.b != null) {
            sVar2.a.post(new n(sVar2, sVar));
        }
        this.n0 = sVar.o;
        this.m0 = sVar.n;
    }

    public final boolean b(com.smartdigimkt.p0.a aVar) {
        return u.a >= 23 && !this.w0 && !a(aVar.a) && (!aVar.f || d.a(this.R));
    }

    @Override // com.smartdigimkt.i0.a
    public final void a(com.smartdigimkt.i0.s[] sVarArr, long j) {
        if (this.A0 == -9223372036854775807L) {
            this.A0 = j;
            return;
        }
        int i = this.B0;
        long[] jArr = this.X;
        if (i == jArr.length) {
            long j2 = jArr[i - 1];
        } else {
            this.B0 = i + 1;
        }
        int i2 = this.B0 - 1;
        jArr[i2] = j;
        this.Y[i2] = this.z0;
    }

    @Override // com.smartdigimkt.i0.a
    public final void a(int i, Object obj) throws com.smartdigimkt.i0.g {
        Surface surface;
        if (i != 1) {
            if (i == 4) {
                int iIntValue = ((Integer) obj).intValue();
                this.d0 = iIntValue;
                MediaCodec mediaCodec = this.p;
                if (mediaCodec != null) {
                    mediaCodec.setVideoScalingMode(iIntValue);
                    return;
                }
                return;
            }
            return;
        }
        Surface surface2 = (Surface) obj;
        if (surface2 == null) {
            d dVar = this.c0;
            if (dVar != null) {
                surface = surface2;
                surface = dVar;
            } else {
                com.smartdigimkt.p0.a aVar = this.q;
                if (aVar != null && b(aVar)) {
                    Context context = this.R;
                    boolean z = aVar.f;
                    int i2 = d.c;
                    if (u.a >= 17) {
                        if (z && !d.a(context)) {
                            throw new IllegalStateException();
                        }
                        d dVarA = new c().a(z ? d.c : 0);
                        this.c0 = dVarA;
                        surface = dVarA;
                    } else {
                        surface = surface2;
                        surface = surface2;
                        surface = surface2;
                        throw new UnsupportedOperationException("Unsupported prior to API level 17");
                    }
                }
            }
        }
        surface = surface2;
        surface = surface2;
        surface = surface2;
        surface = surface2;
        surface = surface2;
        surface = surface2;
        if (this.b0 != surface) {
            this.b0 = surface;
            int i3 = this.c;
            if (i3 == 1 || i3 == 2) {
                MediaCodec mediaCodec2 = this.p;
                if (u.a >= 23 && mediaCodec2 != null && surface != null && !this.a0) {
                    mediaCodec2.setOutputSurface(surface);
                } else {
                    n();
                    l();
                }
            }
            if (surface != null && surface != this.c0) {
                int i4 = this.s0;
                if (i4 != -1 || this.t0 != -1) {
                    s sVar = this.T;
                    int i5 = this.t0;
                    int i6 = this.u0;
                    float f = this.v0;
                    if (sVar.b != null) {
                        sVar.a.post(new p(sVar, i4, i5, i6, f));
                    }
                }
                q();
                if (i3 == 2) {
                    this.g0 = this.U > 0 ? SystemClock.elapsedRealtime() + this.U : -9223372036854775807L;
                    return;
                }
                return;
            }
            this.s0 = -1;
            this.t0 = -1;
            this.v0 = -1.0f;
            this.u0 = -1;
            q();
            return;
        }
        if (surface == null || surface == this.c0) {
            return;
        }
        int i7 = this.s0;
        if (i7 != -1 || this.t0 != -1) {
            s sVar2 = this.T;
            int i8 = this.t0;
            int i9 = this.u0;
            float f2 = this.v0;
            if (sVar2.b != null) {
                sVar2.a.post(new p(sVar2, i7, i8, i9, f2));
            }
        }
        if (this.e0) {
            s sVar3 = this.T;
            Surface surface3 = this.b0;
            if (sVar3.b != null) {
                sVar3.a.post(new q(sVar3, surface3));
            }
        }
    }

    @Override // com.smartdigimkt.p0.c
    public final boolean a(com.smartdigimkt.p0.a aVar) {
        return this.b0 != null || b(aVar);
    }

    @Override // com.smartdigimkt.p0.c
    public final int a(com.smartdigimkt.p0.a aVar, com.smartdigimkt.i0.s sVar, com.smartdigimkt.i0.s sVar2) {
        if (a(aVar.d, sVar, sVar2)) {
            int i = sVar2.k;
            e eVar = this.Z;
            if (i <= eVar.a && sVar2.l <= eVar.b && a(aVar, sVar2) <= this.Z.c) {
                if (sVar.h.size() == sVar2.h.size()) {
                    for (int i2 = 0; i2 < sVar.h.size(); i2++) {
                        if (Arrays.equals((byte[]) sVar.h.get(i2), (byte[]) sVar2.h.get(i2))) {
                        }
                    }
                    return 1;
                }
                return 3;
            }
        }
        return 0;
    }

    @Override // com.smartdigimkt.i0.a
    public final void a(long j, boolean z) {
        this.M = false;
        this.N = false;
        if (this.p != null) {
            k();
        }
        q();
        long jElapsedRealtime = -9223372036854775807L;
        this.f0 = -9223372036854775807L;
        this.j0 = 0;
        this.z0 = -9223372036854775807L;
        int i = this.B0;
        if (i != 0) {
            this.A0 = this.X[i - 1];
            this.B0 = 0;
        }
        if (!z) {
            this.g0 = -9223372036854775807L;
            return;
        }
        if (this.U > 0) {
            jElapsedRealtime = this.U + SystemClock.elapsedRealtime();
        }
        this.g0 = jElapsedRealtime;
    }

    @Override // com.smartdigimkt.p0.c
    public final void a(String str, long j, long j2) {
        s sVar = this.T;
        if (sVar.b != null) {
            sVar.a.post(new m(sVar, str, j, j2));
        }
        this.a0 = a(str);
    }

    @Override // com.smartdigimkt.p0.c
    public final void a(com.smartdigimkt.l0.e eVar) {
        this.k0++;
        this.z0 = Math.max(eVar.c, this.z0);
        if (u.a >= 23 || !this.w0 || this.e0) {
            return;
        }
        this.e0 = true;
        s sVar = this.T;
        Surface surface = this.b0;
        if (sVar.b != null) {
            sVar.a.post(new q(sVar, surface));
        }
    }

    @Override // com.smartdigimkt.p0.c
    public final void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int integer;
        int integer2;
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        if (z) {
            integer = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            integer = mediaFormat.getInteger("width");
        }
        this.o0 = integer;
        if (z) {
            integer2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            integer2 = mediaFormat.getInteger("height");
        }
        this.p0 = integer2;
        float f = this.n0;
        this.r0 = f;
        if (u.a >= 21) {
            int i = this.m0;
            if (i == 90 || i == 270) {
                int i2 = this.o0;
                this.o0 = integer2;
                this.p0 = i2;
                this.r0 = 1.0f / f;
            }
        } else {
            this.q0 = this.m0;
        }
        mediaCodec.setVideoScalingMode(this.d0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x006f, code lost:
    
        if (r8 > 100000) goto L125;
     */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9, types: [boolean, int] */
    @Override // com.smartdigimkt.p0.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(long r26, long r28, android.media.MediaCodec r30, java.nio.ByteBuffer r31, int r32, int r33, long r34, boolean r36) {
        /*
            Method dump skipped, instruction units count: 785
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.smartdigimkt.a1.g.a(long, long, android.media.MediaCodec, java.nio.ByteBuffer, int, int, long, boolean):boolean");
    }

    @Override // com.smartdigimkt.p0.c
    public final void a(long j) {
        this.k0--;
        while (true) {
            int i = this.B0;
            if (i == 0 || j < this.Y[0]) {
                return;
            }
            long[] jArr = this.X;
            this.A0 = jArr[0];
            int i2 = i - 1;
            this.B0 = i2;
            System.arraycopy(jArr, 1, jArr, 0, i2);
            long[] jArr2 = this.Y;
            System.arraycopy(jArr2, 1, jArr2, 0, this.B0);
        }
    }

    public static int a(com.smartdigimkt.p0.a aVar, com.smartdigimkt.i0.s sVar) {
        if (sVar.g != -1) {
            int size = sVar.h.size();
            int length = 0;
            for (int i = 0; i < size; i++) {
                length += ((byte[]) sVar.h.get(i)).length;
            }
            return sVar.g + length;
        }
        return a(aVar, sVar.f, sVar.k, sVar.l);
    }

    public static int a(com.smartdigimkt.p0.a aVar, String str, int i, int i2) {
        int i3;
        if (i == -1 || i2 == -1) {
            return -1;
        }
        str.getClass();
        str.hashCode();
        int i4 = 4;
        switch (str) {
            case "video/3gpp":
            case "video/mp4v-es":
            case "video/x-vnd.on2.vp8":
                i3 = i2 * i;
                i4 = 2;
                return (i3 * 3) / (i4 * 2);
            case "video/hevc":
            case "video/x-vnd.on2.vp9":
                i3 = i2 * i;
                return (i3 * 3) / (i4 * 2);
            case "video/avc":
                String str2 = u.d;
                if ("BRAVIA 4K 2015".equals(str2) || ("Amazon".equals(u.c) && ("KFSOWI".equals(str2) || ("AFTS".equals(str2) && aVar.f)))) {
                    return -1;
                }
                i3 = ((i2 + 15) / 16) * ((i + 15) / 16) * 256;
                i4 = 2;
                return (i3 * 3) / (i4 * 2);
            default:
                return -1;
        }
    }

    public static boolean a(boolean z, com.smartdigimkt.i0.s sVar, com.smartdigimkt.i0.s sVar2) {
        return sVar.f.equals(sVar2.f) && sVar.n == sVar2.n && (z || (sVar.k == sVar2.k && sVar.l == sVar2.l)) && u.a(sVar.r, sVar2.r);
    }

    /* JADX WARN: Code duplicated, block: B:368:0x059a  */
    /* JADX WARN: Code duplicated, block: B:383:0x05c5  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static boolean a(String str) {
        byte b = 0;
        byte b2 = 27;
        if (u.a >= 27 || str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (g.class) {
            if (!D0) {
                String str2 = u.b;
                switch (str2.hashCode()) {
                    case -2144781245:
                        if (!str2.equals("GIONEE_SWW1609")) {
                            b2 = -1;
                        } else {
                            b2 = 39;
                        }
                        break;
                    case -2144781185:
                        if (!str2.equals("GIONEE_SWW1627")) {
                            b2 = -1;
                        } else {
                            b2 = 40;
                        }
                        break;
                    case -2144781160:
                        if (!str2.equals("GIONEE_SWW1631")) {
                            b2 = -1;
                        } else {
                            b2 = 41;
                        }
                        break;
                    case -2097309513:
                        if (!str2.equals("K50a40")) {
                            b2 = -1;
                        } else {
                            b2 = 57;
                        }
                        break;
                    case -2022874474:
                        if (!str2.equals("CP8676_I02")) {
                            b2 = -1;
                        } else {
                            b2 = 16;
                        }
                        break;
                    case -1978993182:
                        if (!str2.equals("NX541J")) {
                            b2 = -1;
                        } else {
                            b2 = 69;
                        }
                        break;
                    case -1978990237:
                        if (!str2.equals("NX573J")) {
                            b2 = -1;
                        } else {
                            b2 = 70;
                        }
                        break;
                    case -1936688988:
                        if (!str2.equals("PGN528")) {
                            b2 = -1;
                        } else {
                            b2 = 80;
                        }
                        break;
                    case -1936688066:
                        if (!str2.equals("PGN610")) {
                            b2 = -1;
                        } else {
                            b2 = 81;
                        }
                        break;
                    case -1936688065:
                        if (!str2.equals("PGN611")) {
                            b2 = -1;
                        } else {
                            b2 = 82;
                        }
                        break;
                    case -1931988508:
                        if (!str2.equals("AquaPowerM")) {
                            b2 = -1;
                        } else {
                            b2 = 10;
                        }
                        break;
                    case -1696512866:
                        if (!str2.equals("XT1663")) {
                            b2 = -1;
                        } else {
                            b2 = 115;
                        }
                        break;
                    case -1680025915:
                        if (!str2.equals("ComioS1")) {
                            b2 = -1;
                        } else {
                            b2 = 15;
                        }
                        break;
                    case -1615810839:
                        if (!str2.equals("Phantom6")) {
                            b2 = -1;
                        } else {
                            b2 = 83;
                        }
                        break;
                    case -1554255044:
                        if (!str2.equals("vernee_M5")) {
                            b2 = -1;
                        } else {
                            b2 = 108;
                        }
                        break;
                    case -1481772737:
                        if (!str2.equals("panell_dl")) {
                            b2 = -1;
                        } else {
                            b2 = 76;
                        }
                        break;
                    case -1481772730:
                        if (!str2.equals("panell_ds")) {
                            b2 = -1;
                        } else {
                            b2 = 77;
                        }
                        break;
                    case -1481772729:
                        if (!str2.equals("panell_dt")) {
                            b2 = -1;
                        } else {
                            b2 = 78;
                        }
                        break;
                    case -1320080169:
                        if (!str2.equals("GiONEE_GBL7319")) {
                            b2 = -1;
                        } else {
                            b2 = 37;
                        }
                        break;
                    case -1217592143:
                        if (!str2.equals("BRAVIA_ATV2")) {
                            b2 = -1;
                        } else {
                            b2 = 13;
                        }
                        break;
                    case -1180384755:
                        if (!str2.equals("iris60")) {
                            b2 = -1;
                        } else {
                            b2 = 53;
                        }
                        break;
                    case -1139198265:
                        if (!str2.equals("Slate_Pro")) {
                            b2 = -1;
                        } else {
                            b2 = 96;
                        }
                        break;
                    case -1052835013:
                        if (!str2.equals("namath")) {
                            b2 = -1;
                        } else {
                            b2 = 67;
                        }
                        break;
                    case -993250464:
                        if (!str2.equals("A10-70F")) {
                            b2 = -1;
                        } else {
                            b2 = 3;
                        }
                        break;
                    case -965403638:
                        if (!str2.equals("s905x018")) {
                            b2 = -1;
                        } else {
                            b2 = 98;
                        }
                        break;
                    case -958336948:
                        if (!str2.equals("ELUGA_Ray_X")) {
                            b2 = -1;
                        } else {
                            b2 = 26;
                        }
                        break;
                    case -879245230:
                        if (!str2.equals("tcl_eu")) {
                            b2 = -1;
                        } else {
                            b2 = 104;
                        }
                        break;
                    case -842500323:
                        if (!str2.equals("nicklaus_f")) {
                            b2 = -1;
                        } else {
                            b2 = 68;
                        }
                        break;
                    case -821392978:
                        if (!str2.equals("A7000-a")) {
                            b2 = -1;
                        } else {
                            b2 = 6;
                        }
                        break;
                    case -797483286:
                        if (!str2.equals("SVP-DTV15")) {
                            b2 = -1;
                        } else {
                            b2 = 97;
                        }
                        break;
                    case -794946968:
                        if (!str2.equals("watson")) {
                            b2 = -1;
                        } else {
                            b2 = 109;
                        }
                        break;
                    case -788334647:
                        if (!str2.equals("whyred")) {
                            b2 = -1;
                        } else {
                            b2 = 110;
                        }
                        break;
                    case -782144577:
                        if (!str2.equals("OnePlus5T")) {
                            b2 = -1;
                        } else {
                            b2 = 71;
                        }
                        break;
                    case -575125681:
                        if (!str2.equals("GiONEE_CBL7513")) {
                            b2 = -1;
                        } else {
                            b2 = 36;
                        }
                        break;
                    case -521118391:
                        if (!str2.equals("GIONEE_GBL7360")) {
                            b2 = -1;
                        } else {
                            b2 = 38;
                        }
                        break;
                    case -430914369:
                        if (!str2.equals("Pixi4-7_3G")) {
                            b2 = -1;
                        } else {
                            b2 = 84;
                        }
                        break;
                    case -290434366:
                        if (!str2.equals("taido_row")) {
                            b2 = -1;
                        } else {
                            b2 = 99;
                        }
                        break;
                    case -282781963:
                        if (!str2.equals("BLACK-1X")) {
                            b2 = -1;
                        } else {
                            b2 = 12;
                        }
                        break;
                    case -277133239:
                        if (!str2.equals("Z12_PRO")) {
                            b2 = -1;
                        } else {
                            b2 = 116;
                        }
                        break;
                    case -173639913:
                        if (!str2.equals("ELUGA_A3_Pro")) {
                            b2 = -1;
                        } else {
                            b2 = 23;
                        }
                        break;
                    case -56598463:
                        if (!str2.equals("woods_fn")) {
                            b2 = -1;
                        } else {
                            b2 = 112;
                        }
                        break;
                    case 2126:
                        if (!str2.equals("C1")) {
                            b2 = -1;
                        } else {
                            b2 = 14;
                        }
                        break;
                    case 2564:
                        if (!str2.equals("Q5")) {
                            b2 = -1;
                        } else {
                            b2 = 92;
                        }
                        break;
                    case 2715:
                        if (!str2.equals("V1")) {
                            b2 = -1;
                        } else {
                            b2 = 105;
                        }
                        break;
                    case 2719:
                        if (!str2.equals("V5")) {
                            b2 = -1;
                        } else {
                            b2 = 107;
                        }
                        break;
                    case 3483:
                        if (!str2.equals("mh")) {
                            b2 = -1;
                        } else {
                            b2 = com.anythink.core.common.r.a.c.b;
                        }
                        break;
                    case 73405:
                        if (!str2.equals("JGZ")) {
                            b2 = -1;
                        } else {
                            b2 = 56;
                        }
                        break;
                    case 75739:
                        if (!str2.equals("M5c")) {
                            b2 = -1;
                        } else {
                            b2 = 60;
                        }
                        break;
                    case 76779:
                        if (!str2.equals("MX6")) {
                            b2 = -1;
                        } else {
                            b2 = 66;
                        }
                        break;
                    case 78669:
                        if (!str2.equals("P85")) {
                            b2 = -1;
                        } else {
                            b2 = 74;
                        }
                        break;
                    case 79305:
                        if (!str2.equals("PLE")) {
                            b2 = -1;
                        } else {
                            b2 = 86;
                        }
                        break;
                    case 80618:
                        if (!str2.equals("QX1")) {
                            b2 = -1;
                        } else {
                            b2 = 94;
                        }
                        break;
                    case 88274:
                        if (!str2.equals("Z80")) {
                            b2 = -1;
                        } else {
                            b2 = 117;
                        }
                        break;
                    case 98846:
                        if (!str2.equals("cv1")) {
                            b2 = -1;
                        } else {
                            b2 = 19;
                        }
                        break;
                    case 98848:
                        if (!str2.equals("cv3")) {
                            b2 = -1;
                        } else {
                            b2 = 20;
                        }
                        break;
                    case 99329:
                        if (!str2.equals("deb")) {
                            b2 = -1;
                        } else {
                            b2 = 21;
                        }
                        break;
                    case 101481:
                        if (!str2.equals("flo")) {
                            b2 = -1;
                        } else {
                            b2 = 35;
                        }
                        break;
                    case 1513190:
                        if (!str2.equals("1601")) {
                            b2 = -1;
                        } else {
                            b2 = 0;
                        }
                        break;
                    case 1514184:
                        if (!str2.equals("1713")) {
                            b2 = -1;
                        } else {
                            b2 = 1;
                        }
                        break;
                    case 1514185:
                        if (!str2.equals("1714")) {
                            b2 = -1;
                        } else {
                            b2 = 2;
                        }
                        break;
                    case 2436959:
                        if (!str2.equals("P681")) {
                            b2 = -1;
                        } else {
                            b2 = 73;
                        }
                        break;
                    case 2463773:
                        if (!str2.equals("Q350")) {
                            b2 = -1;
                        } else {
                            b2 = 88;
                        }
                        break;
                    case 2464648:
                        if (!str2.equals("Q427")) {
                            b2 = -1;
                        } else {
                            b2 = 90;
                        }
                        break;
                    case 2689555:
                        if (!str2.equals("XE2X")) {
                            b2 = -1;
                        } else {
                            b2 = 114;
                        }
                        break;
                    case 3351335:
                        if (!str2.equals("mido")) {
                            b2 = -1;
                        } else {
                            b2 = 65;
                        }
                        break;
                    case 3386211:
                        if (!str2.equals("p212")) {
                            b2 = -1;
                        } else {
                            b2 = 72;
                        }
                        break;
                    case 41325051:
                        if (!str2.equals("MEIZU_M5")) {
                            b2 = -1;
                        } else {
                            b2 = com.anythink.core.common.r.a.c.c;
                        }
                        break;
                    case 55178625:
                        if (!str2.equals("Aura_Note_2")) {
                            b2 = -1;
                        } else {
                            b2 = 11;
                        }
                        break;
                    case 61542055:
                        if (!str2.equals("A1601")) {
                            b2 = -1;
                        } else {
                            b2 = 4;
                        }
                        break;
                    case 65355429:
                        if (!str2.equals("E5643")) {
                            b2 = -1;
                        } else {
                            b2 = 22;
                        }
                        break;
                    case 66214468:
                        if (!str2.equals("F3111")) {
                            b2 = -1;
                        } else {
                            b2 = 28;
                        }
                        break;
                    case 66214470:
                        if (!str2.equals("F3113")) {
                            b2 = -1;
                        } else {
                            b2 = 29;
                        }
                        break;
                    case 66214473:
                        if (!str2.equals("F3116")) {
                            b2 = -1;
                        } else {
                            b2 = 30;
                        }
                        break;
                    case 66215429:
                        if (!str2.equals("F3211")) {
                            b2 = -1;
                        } else {
                            b2 = 31;
                        }
                        break;
                    case 66215431:
                        if (!str2.equals("F3213")) {
                            b2 = -1;
                        } else {
                            b2 = 32;
                        }
                        break;
                    case 66215433:
                        if (!str2.equals("F3215")) {
                            b2 = -1;
                        } else {
                            b2 = 33;
                        }
                        break;
                    case 66216390:
                        if (!str2.equals("F3311")) {
                            b2 = -1;
                        } else {
                            b2 = 34;
                        }
                        break;
                    case 76402249:
                        if (!str2.equals("PRO7S")) {
                            b2 = -1;
                        } else {
                            b2 = 87;
                        }
                        break;
                    case 76404105:
                        if (!str2.equals("Q4260")) {
                            b2 = -1;
                        } else {
                            b2 = 89;
                        }
                        break;
                    case 76404911:
                        if (!str2.equals("Q4310")) {
                            b2 = -1;
                        } else {
                            b2 = 91;
                        }
                        break;
                    case 80963634:
                        if (!str2.equals("V23GB")) {
                            b2 = -1;
                        } else {
                            b2 = 106;
                        }
                        break;
                    case 82882791:
                        if (!str2.equals("X3_HK")) {
                            b2 = -1;
                        } else {
                            b2 = 113;
                        }
                        break;
                    case 102844228:
                        if (!str2.equals("le_x6")) {
                            b2 = -1;
                        } else {
                            b2 = 58;
                        }
                        break;
                    case 165221241:
                        if (!str2.equals("A2016a40")) {
                            b2 = -1;
                        } else {
                            b2 = 5;
                        }
                        break;
                    case 182191441:
                        if (!str2.equals("CPY83_I00")) {
                            b2 = -1;
                        } else {
                            b2 = 18;
                        }
                        break;
                    case 245388979:
                        if (!str2.equals("marino_f")) {
                            b2 = -1;
                        } else {
                            b2 = 62;
                        }
                        break;
                    case 287431619:
                        if (!str2.equals("griffin")) {
                            b2 = -1;
                        } else {
                            b2 = 45;
                        }
                        break;
                    case 307593612:
                        if (!str2.equals("A7010a48")) {
                            b2 = -1;
                        } else {
                            b2 = 8;
                        }
                        break;
                    case 308517133:
                        if (!str2.equals("A7020a48")) {
                            b2 = -1;
                        } else {
                            b2 = 9;
                        }
                        break;
                    case 316215098:
                        if (!str2.equals("TB3-730F")) {
                            b2 = -1;
                        } else {
                            b2 = 100;
                        }
                        break;
                    case 316215116:
                        if (!str2.equals("TB3-730X")) {
                            b2 = -1;
                        } else {
                            b2 = 101;
                        }
                        break;
                    case 316246811:
                        if (!str2.equals("TB3-850F")) {
                            b2 = -1;
                        } else {
                            b2 = 102;
                        }
                        break;
                    case 316246818:
                        if (!str2.equals("TB3-850M")) {
                            b2 = -1;
                        } else {
                            b2 = 103;
                        }
                        break;
                    case 407160593:
                        if (!str2.equals("Pixi5-10_4G")) {
                            b2 = -1;
                        } else {
                            b2 = 85;
                        }
                        break;
                    case 507412548:
                        if (!str2.equals("QM16XE_U")) {
                            b2 = -1;
                        } else {
                            b2 = 93;
                        }
                        break;
                    case 793982701:
                        if (!str2.equals("GIONEE_WBL5708")) {
                            b2 = -1;
                        } else {
                            b2 = 42;
                        }
                        break;
                    case 794038622:
                        if (!str2.equals("GIONEE_WBL7365")) {
                            b2 = -1;
                        } else {
                            b2 = 43;
                        }
                        break;
                    case 794040393:
                        if (!str2.equals("GIONEE_WBL7519")) {
                            b2 = -1;
                        } else {
                            b2 = 44;
                        }
                        break;
                    case 835649806:
                        if (!str2.equals("manning")) {
                            b2 = -1;
                        } else {
                            b2 = 61;
                        }
                        break;
                    case 917340916:
                        if (!str2.equals("A7000plus")) {
                            b2 = -1;
                        } else {
                            b2 = 7;
                        }
                        break;
                    case 958008161:
                        if (!str2.equals("j2xlteins")) {
                            b2 = -1;
                        } else {
                            b2 = 55;
                        }
                        break;
                    case 1060579533:
                        if (!str2.equals("panell_d")) {
                            b2 = -1;
                        } else {
                            b2 = 75;
                        }
                        break;
                    case 1150207623:
                        if (!str2.equals("LS-5017")) {
                            b2 = -1;
                        } else {
                            b2 = 59;
                        }
                        break;
                    case 1176899427:
                        if (!str2.equals("itel_S41")) {
                            b2 = -1;
                        } else {
                            b2 = 54;
                        }
                        break;
                    case 1280332038:
                        if (!str2.equals("hwALE-H")) {
                            b2 = -1;
                        } else {
                            b2 = 47;
                        }
                        break;
                    case 1306947716:
                        if (!str2.equals("EverStar_S")) {
                            b2 = -1;
                        }
                        break;
                    case 1349174697:
                        if (!str2.equals("htc_e56ml_dtul")) {
                            b2 = -1;
                        } else {
                            b2 = 46;
                        }
                        break;
                    case 1522194893:
                        if (!str2.equals("woods_f")) {
                            b2 = -1;
                        } else {
                            b2 = 111;
                        }
                        break;
                    case 1691543273:
                        if (!str2.equals("CPH1609")) {
                            b2 = -1;
                        } else {
                            b2 = 17;
                        }
                        break;
                    case 1709443163:
                        if (!str2.equals("iball8735_9806")) {
                            b2 = -1;
                        } else {
                            b2 = 51;
                        }
                        break;
                    case 1865889110:
                        if (!str2.equals("santoni")) {
                            b2 = -1;
                        } else {
                            b2 = 95;
                        }
                        break;
                    case 1906253259:
                        if (!str2.equals("PB2-670M")) {
                            b2 = -1;
                        } else {
                            b2 = 79;
                        }
                        break;
                    case 1977196784:
                        if (!str2.equals("Infinix-X572")) {
                            b2 = -1;
                        } else {
                            b2 = 52;
                        }
                        break;
                    case 2029784656:
                        if (!str2.equals("HWBLN-H")) {
                            b2 = -1;
                        } else {
                            b2 = 48;
                        }
                        break;
                    case 2030379515:
                        if (!str2.equals("HWCAM-H")) {
                            b2 = -1;
                        } else {
                            b2 = 49;
                        }
                        break;
                    case 2047190025:
                        if (!str2.equals("ELUGA_Note")) {
                            b2 = -1;
                        } else {
                            b2 = 24;
                        }
                        break;
                    case 2047252157:
                        if (!str2.equals("ELUGA_Prim")) {
                            b2 = -1;
                        } else {
                            b2 = 25;
                        }
                        break;
                    case 2048319463:
                        if (!str2.equals("HWVNS-H")) {
                            b2 = -1;
                        } else {
                            b2 = 50;
                        }
                        break;
                    default:
                        b2 = -1;
                        break;
                }
                switch (b2) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                    case 69:
                    case 70:
                    case 71:
                    case 72:
                    case 73:
                    case 74:
                    case 75:
                    case 76:
                    case 77:
                    case 78:
                    case 79:
                    case 80:
                    case 81:
                    case 82:
                    case 83:
                    case 84:
                    case 85:
                    case 86:
                    case 87:
                    case 88:
                    case 89:
                    case 90:
                    case 91:
                    case 92:
                    case 93:
                    case 94:
                    case 95:
                    case 96:
                    case 97:
                    case 98:
                    case 99:
                    case 100:
                    case 101:
                    case 102:
                    case 103:
                    case 104:
                    case 105:
                    case 106:
                    case 107:
                    case 108:
                    case 109:
                    case 110:
                    case 111:
                    case 112:
                    case 113:
                    case 114:
                    case 115:
                    case 116:
                    case 117:
                        E0 = true;
                        break;
                }
                String str3 = u.d;
                int iHashCode = str3.hashCode();
                if (iHashCode != 2006354) {
                    if (iHashCode == 2006367 && str3.equals("AFTN")) {
                        b = 1;
                    } else {
                        b = -1;
                    }
                } else if (!str3.equals("AFTA")) {
                    b = -1;
                }
                if (b == 0 || b == 1) {
                    E0 = true;
                }
                D0 = true;
            }
        }
        return E0;
    }
}
