package com.anythink.basead.exoplayer.l;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import com.anythink.basead.exoplayer.d.k;
import com.anythink.basead.exoplayer.k.ad;
import com.anythink.basead.exoplayer.k.af;
import com.anythink.basead.exoplayer.k.o;
import com.anythink.basead.exoplayer.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.uc.crashsdk.export.LogType;
import com.umeng.analytics.pro.ek;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class e extends com.anythink.basead.exoplayer.f.b {
    private static boolean A = false;
    private static final String s = "MediaCodecVideoRenderer";
    private static final String t = "crop-left";
    private static final String u = "crop-right";
    private static final String v = "crop-bottom";
    private static final String w = "crop-top";
    private static final int[] x = {1920, 1600, 1440, LogType.UNEXP_ANR, 960, 854, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HW_ERR_REASON, 480};
    private static final int y = 10;
    private static boolean z;
    private final Context B;
    private final f C;
    private final h.a D;
    private final long E;
    private final int F;
    private final boolean G;
    private final long[] H;
    private final long[] I;
    private a J;
    private boolean K;
    private Surface L;
    private Surface M;
    private int N;
    private boolean O;
    private long P;
    private long Q;
    private long R;
    private int S;
    private int T;
    private int U;
    private long V;
    private int W;
    private float X;
    private int Y;
    private int Z;
    private int aa;
    private float ab;
    private int ac;
    private int ad;
    private int ae;
    private float af;
    private boolean ag;
    private int ah;
    private long ai;
    private long aj;
    private int ak;
    b r;

    private static boolean e(long j) {
        return j < -500000;
    }

    private static boolean g(long j) {
        return j < -30000;
    }

    private static boolean h(long j) {
        return j < -500000;
    }

    private e(Context context, com.anythink.basead.exoplayer.f.c cVar) {
        this(context, cVar, (byte) 0);
    }

    private e(Context context, com.anythink.basead.exoplayer.f.c cVar, byte b2) {
        this(context, cVar, null, null);
    }

    private e(Context context, com.anythink.basead.exoplayer.f.c cVar, Handler handler, h hVar) {
        this(context, cVar, 0L, null, handler, hVar, -1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context, com.anythink.basead.exoplayer.f.c cVar, long j, com.anythink.basead.exoplayer.d.g<k> gVar, Handler handler, h hVar, int i) {
        super(2, cVar, gVar, false);
        boolean z2 = false;
        this.E = j;
        this.F = i;
        Context applicationContext = context.getApplicationContext();
        this.B = applicationContext;
        this.C = new f(applicationContext);
        this.D = new h.a(handler, hVar);
        if (af.a <= 22 && "foster".equals(af.b) && "NVIDIA".equals(af.c)) {
            z2 = true;
        }
        this.G = z2;
        this.H = new long[10];
        this.I = new long[10];
        this.aj = -9223372036854775807L;
        this.ai = -9223372036854775807L;
        this.Q = -9223372036854775807L;
        this.Y = -1;
        this.Z = -1;
        this.ab = -1.0f;
        this.X = -1.0f;
        this.N = 1;
        G();
    }

    @Override // com.anythink.basead.exoplayer.f.b
    protected final int a(com.anythink.basead.exoplayer.f.c cVar, com.anythink.basead.exoplayer.d.g<k> gVar, m mVar) {
        boolean z2;
        String str = mVar.h;
        if (!o.b(str)) {
            return 0;
        }
        com.anythink.basead.exoplayer.d.e eVar = mVar.k;
        if (eVar != null) {
            z2 = false;
            for (int i = 0; i < eVar.b; i++) {
                z2 |= eVar.a(i).d;
            }
        } else {
            z2 = false;
        }
        com.anythink.basead.exoplayer.f.a aVarA = cVar.a(str, z2);
        if (aVarA == null) {
            return (!z2 || cVar.a(str, false) == null) ? 1 : 2;
        }
        if (!a(gVar, eVar)) {
            return 2;
        }
        boolean zB = aVarA.b(mVar.e);
        if (zB && mVar.m > 0 && mVar.n > 0) {
            if (af.a >= 21) {
                zB = aVarA.a(mVar.m, mVar.n, mVar.o);
            } else {
                boolean z3 = mVar.m * mVar.n <= com.anythink.basead.exoplayer.f.d.b();
                if (!z3) {
                    Log.d(s, "FalseCheck [legacyFrameSize, " + mVar.m + "x" + mVar.n + "] [" + af.e + "]");
                }
                zB = z3;
            }
        }
        return (zB ? 4 : 3) | (aVarA.f ? 16 : 8) | (aVarA.g ? 32 : 0);
    }

    @Override // com.anythink.basead.exoplayer.f.b, com.anythink.basead.exoplayer.a
    protected final void a(boolean z2) {
        super.a(z2);
        int i = r().b;
        this.ah = i;
        this.ag = i != 0;
        this.D.a(this.q);
        this.C.a();
    }

    @Override // com.anythink.basead.exoplayer.a
    protected final void a(m[] mVarArr, long j) {
        if (this.aj == -9223372036854775807L) {
            this.aj = j;
        } else {
            int i = this.ak;
            if (i == this.H.length) {
                Log.w(s, "Too many stream changes, so dropping offset: " + this.H[this.ak - 1]);
            } else {
                this.ak = i + 1;
            }
            long[] jArr = this.H;
            int i2 = this.ak;
            jArr[i2 - 1] = j;
            this.I[i2 - 1] = this.ai;
        }
        super.a(mVarArr, j);
    }

    @Override // com.anythink.basead.exoplayer.f.b, com.anythink.basead.exoplayer.a
    protected final void a(long j, boolean z2) throws com.anythink.basead.exoplayer.g {
        super.a(j, z2);
        E();
        this.P = -9223372036854775807L;
        this.T = 0;
        this.ai = -9223372036854775807L;
        int i = this.ak;
        if (i != 0) {
            this.aj = this.H[i - 1];
            this.ak = 0;
        }
        if (z2) {
            D();
        } else {
            this.Q = -9223372036854775807L;
        }
    }

    @Override // com.anythink.basead.exoplayer.f.b, com.anythink.basead.exoplayer.y
    public final boolean u() {
        Surface surface;
        if (super.u() && (this.O || (((surface = this.M) != null && this.L == surface) || y() == null || this.ag))) {
            this.Q = -9223372036854775807L;
            return true;
        }
        if (this.Q == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.Q) {
            return true;
        }
        this.Q = -9223372036854775807L;
        return false;
    }

    @Override // com.anythink.basead.exoplayer.f.b, com.anythink.basead.exoplayer.a
    protected final void n() {
        super.n();
        this.S = 0;
        this.R = SystemClock.elapsedRealtime();
        this.V = SystemClock.elapsedRealtime() * 1000;
    }

    @Override // com.anythink.basead.exoplayer.f.b, com.anythink.basead.exoplayer.a
    protected final void o() {
        this.Q = -9223372036854775807L;
        J();
        super.o();
    }

    @Override // com.anythink.basead.exoplayer.f.b, com.anythink.basead.exoplayer.a
    protected final void p() {
        this.Y = -1;
        this.Z = -1;
        this.ab = -1.0f;
        this.X = -1.0f;
        this.aj = -9223372036854775807L;
        this.ai = -9223372036854775807L;
        this.ak = 0;
        G();
        E();
        this.C.b();
        this.r = null;
        this.ag = false;
        try {
            super.p();
        } finally {
            this.D.b(this.q);
        }
    }

    @Override // com.anythink.basead.exoplayer.a, com.anythink.basead.exoplayer.x.b
    public final void a(int i, Object obj) {
        if (i != 1) {
            if (i == 4) {
                this.N = ((Integer) obj).intValue();
                MediaCodec mediaCodecY = y();
                if (mediaCodecY != null) {
                    mediaCodecY.setVideoScalingMode(this.N);
                    return;
                }
                return;
            }
            super.a(i, obj);
            return;
        }
        Surface surfaceA = (Surface) obj;
        if (surfaceA == null) {
            Surface surface = this.M;
            if (surface != null) {
                surfaceA = surface;
            } else {
                com.anythink.basead.exoplayer.f.a aVarZ = z();
                if (aVarZ != null && b(aVarZ)) {
                    surfaceA = c.a(this.B, aVarZ.h);
                    this.M = surfaceA;
                }
            }
        }
        if (this.L != surfaceA) {
            this.L = surfaceA;
            int iA_ = a_();
            if (iA_ == 1 || iA_ == 2) {
                MediaCodec mediaCodecY2 = y();
                if (af.a < 23 || mediaCodecY2 == null || surfaceA == null || this.K) {
                    A();
                    x();
                } else {
                    mediaCodecY2.setOutputSurface(surfaceA);
                }
            }
            if (surfaceA != null && surfaceA != this.M) {
                I();
                E();
                if (iA_ == 2) {
                    D();
                    return;
                }
                return;
            }
            G();
            E();
            return;
        }
        if (surfaceA == null || surfaceA == this.M) {
            return;
        }
        I();
        if (this.O) {
            this.D.a(this.L);
        }
    }

    private void a(Surface surface) {
        if (surface == null) {
            Surface surface2 = this.M;
            if (surface2 != null) {
                surface = surface2;
            } else {
                com.anythink.basead.exoplayer.f.a aVarZ = z();
                if (aVarZ != null && b(aVarZ)) {
                    surface = c.a(this.B, aVarZ.h);
                    this.M = surface;
                }
            }
        }
        if (this.L != surface) {
            this.L = surface;
            int iA_ = a_();
            if (iA_ == 1 || iA_ == 2) {
                MediaCodec mediaCodecY = y();
                if (af.a < 23 || mediaCodecY == null || surface == null || this.K) {
                    A();
                    x();
                } else {
                    mediaCodecY.setOutputSurface(surface);
                }
            }
            if (surface != null && surface != this.M) {
                I();
                E();
                if (iA_ == 2) {
                    D();
                    return;
                }
                return;
            }
            G();
            E();
            return;
        }
        if (surface == null || surface == this.M) {
            return;
        }
        I();
        if (this.O) {
            this.D.a(this.L);
        }
    }

    @Override // com.anythink.basead.exoplayer.f.b
    protected final boolean a(com.anythink.basead.exoplayer.f.a aVar) {
        return this.L != null || b(aVar);
    }

    @Override // com.anythink.basead.exoplayer.f.b
    protected final void a(com.anythink.basead.exoplayer.f.a aVar, MediaCodec mediaCodec, m mVar, MediaCrypto mediaCrypto) {
        a aVar2;
        m[] mVarArrQ = q();
        int iMax = mVar.m;
        int iMax2 = mVar.n;
        int iB = b(aVar, mVar);
        byte b2 = 0;
        if (mVarArrQ.length == 1) {
            aVar2 = new a(iMax, iMax2, iB);
        } else {
            boolean z2 = false;
            for (m mVar2 : mVarArrQ) {
                if (a(aVar.f, mVar, mVar2)) {
                    z2 |= mVar2.m == -1 || mVar2.n == -1;
                    iMax = Math.max(iMax, mVar2.m);
                    iMax2 = Math.max(iMax2, mVar2.n);
                    iB = Math.max(iB, b(aVar, mVar2));
                }
            }
            if (z2) {
                Log.w(s, "Resolutions unknown. Codec max resolution: " + iMax + "x" + iMax2);
                Point pointA = a(aVar, mVar);
                if (pointA != null) {
                    iMax = Math.max(iMax, pointA.x);
                    iMax2 = Math.max(iMax2, pointA.y);
                    iB = Math.max(iB, a(aVar, mVar.h, iMax, iMax2));
                    Log.w(s, "Codec max resolution adjusted to: " + iMax + "x" + iMax2);
                }
            }
            aVar2 = new a(iMax, iMax2, iB);
        }
        this.J = aVar2;
        boolean z3 = this.G;
        int i = this.ah;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", mVar.h);
        mediaFormat.setInteger("width", mVar.m);
        mediaFormat.setInteger("height", mVar.n);
        com.anythink.basead.exoplayer.f.e.a(mediaFormat, mVar.j);
        float f = mVar.o;
        if (f != -1.0f) {
            mediaFormat.setFloat("frame-rate", f);
        }
        com.anythink.basead.exoplayer.f.e.a(mediaFormat, "rotation-degrees", mVar.p);
        com.anythink.basead.exoplayer.l.b bVar = mVar.t;
        if (bVar != null) {
            com.anythink.basead.exoplayer.f.e.a(mediaFormat, "color-transfer", bVar.c);
            com.anythink.basead.exoplayer.f.e.a(mediaFormat, "color-standard", bVar.a);
            com.anythink.basead.exoplayer.f.e.a(mediaFormat, "color-range", bVar.b);
            byte[] bArr = bVar.d;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        mediaFormat.setInteger("max-width", aVar2.a);
        mediaFormat.setInteger("max-height", aVar2.b);
        com.anythink.basead.exoplayer.f.e.a(mediaFormat, "max-input-size", aVar2.c);
        if (af.a >= 23) {
            mediaFormat.setInteger("priority", 0);
        }
        if (z3) {
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i != 0) {
            mediaFormat.setFeatureEnabled("tunneled-playback", true);
            mediaFormat.setInteger("audio-session-id", i);
        }
        if (this.L == null) {
            com.anythink.basead.exoplayer.k.a.b(b(aVar));
            if (this.M == null) {
                this.M = c.a(this.B, aVar.h);
            }
            this.L = this.M;
        }
        mediaCodec.configure(mediaFormat, this.L, mediaCrypto, 0);
        if (af.a < 23 || !this.ag) {
            return;
        }
        this.r = new b(this, mediaCodec, b2);
    }

    @Override // com.anythink.basead.exoplayer.f.b
    protected final int a(com.anythink.basead.exoplayer.f.a aVar, m mVar, m mVar2) {
        if (!a(aVar.f, mVar, mVar2) || mVar2.m > this.J.a || mVar2.n > this.J.b || b(aVar, mVar2) > this.J.c) {
            return 0;
        }
        return mVar.b(mVar2) ? 1 : 3;
    }

    @Override // com.anythink.basead.exoplayer.f.b
    protected final void A() {
        Surface surface;
        try {
            super.A();
            this.U = 0;
            surface = this.M;
            if (surface != null) {
                if (this.L == surface) {
                    this.L = null;
                }
            }
        } finally {
            this.U = 0;
            if (this.M != null) {
                Surface surface2 = this.L;
                surface = this.M;
                if (surface2 == surface) {
                    this.L = null;
                }
                surface.release();
                this.M = null;
            }
        }
    }

    @Override // com.anythink.basead.exoplayer.f.b
    protected final void B() throws com.anythink.basead.exoplayer.g {
        super.B();
        this.U = 0;
    }

    @Override // com.anythink.basead.exoplayer.f.b
    protected final void a(String str, long j, long j2) {
        this.D.a(str, j, j2);
        this.K = a(str);
    }

    @Override // com.anythink.basead.exoplayer.f.b
    protected final void b(m mVar) throws com.anythink.basead.exoplayer.g {
        super.b(mVar);
        this.D.a(mVar);
        this.X = mVar.q;
        this.W = mVar.p;
    }

    @Override // com.anythink.basead.exoplayer.f.b
    protected final void a(com.anythink.basead.exoplayer.c.e eVar) {
        this.U++;
        this.ai = Math.max(eVar.f, this.ai);
        if (af.a >= 23 || !this.ag) {
            return;
        }
        C();
    }

    @Override // com.anythink.basead.exoplayer.f.b
    protected final void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int integer;
        int integer2;
        boolean z2 = mediaFormat.containsKey(u) && mediaFormat.containsKey(t) && mediaFormat.containsKey(v) && mediaFormat.containsKey(w);
        if (z2) {
            integer = (mediaFormat.getInteger(u) - mediaFormat.getInteger(t)) + 1;
        } else {
            integer = mediaFormat.getInteger("width");
        }
        this.Y = integer;
        if (z2) {
            integer2 = (mediaFormat.getInteger(v) - mediaFormat.getInteger(w)) + 1;
        } else {
            integer2 = mediaFormat.getInteger("height");
        }
        this.Z = integer2;
        this.ab = this.X;
        if (af.a >= 21) {
            int i = this.W;
            if (i == 90 || i == 270) {
                int i2 = this.Y;
                this.Y = this.Z;
                this.Z = i2;
                this.ab = 1.0f / this.ab;
            }
        } else {
            this.aa = this.W;
        }
        mediaCodec.setVideoScalingMode(this.N);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x005f, code lost:
    
        if ((g(r8) && r10 - r18.V > 100000) != false) goto L72;
     */
    @Override // com.anythink.basead.exoplayer.f.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final boolean a(long r19, long r21, android.media.MediaCodec r23, java.nio.ByteBuffer r24, int r25, int r26, long r27, boolean r29) throws com.anythink.basead.exoplayer.g {
        /*
            Method dump skipped, instruction units count: 267
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.basead.exoplayer.l.e.a(long, long, android.media.MediaCodec, java.nio.ByteBuffer, int, int, long, boolean):boolean");
    }

    @Override // com.anythink.basead.exoplayer.f.b
    protected final void c(long j) {
        this.U--;
        while (true) {
            int i = this.ak;
            if (i == 0 || j < this.I[0]) {
                return;
            }
            long[] jArr = this.H;
            this.aj = jArr[0];
            int i2 = i - 1;
            this.ak = i2;
            System.arraycopy(jArr, 1, jArr, 0, i2);
            long[] jArr2 = this.I;
            System.arraycopy(jArr2, 1, jArr2, 0, this.ak);
        }
    }

    private static boolean d(long j) {
        return g(j);
    }

    private static boolean b(long j, long j2) {
        return g(j) && j2 > 100000;
    }

    private void a(MediaCodec mediaCodec, int i) {
        ad.a("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        ad.a();
        this.q.f++;
    }

    private void b(MediaCodec mediaCodec, int i) {
        ad.a("dropVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        ad.a();
        b(1);
    }

    private boolean f(long j) throws com.anythink.basead.exoplayer.g {
        int iB = b(j);
        if (iB == 0) {
            return false;
        }
        this.q.i++;
        b(this.U + iB);
        B();
        return true;
    }

    private void b(int i) {
        this.q.g += i;
        this.S += i;
        this.T += i;
        this.q.h = Math.max(this.T, this.q.h);
        if (this.S >= this.F) {
            J();
        }
    }

    private void c(MediaCodec mediaCodec, int i) {
        H();
        ad.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        ad.a();
        this.V = SystemClock.elapsedRealtime() * 1000;
        this.q.e++;
        this.T = 0;
        C();
    }

    private void a(MediaCodec mediaCodec, int i, long j) {
        H();
        ad.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j);
        ad.a();
        this.V = SystemClock.elapsedRealtime() * 1000;
        this.q.e++;
        this.T = 0;
        C();
    }

    private boolean b(com.anythink.basead.exoplayer.f.a aVar) {
        if (af.a < 23 || this.ag || a(aVar.c)) {
            return false;
        }
        return !aVar.h || c.a(this.B);
    }

    private void D() {
        this.Q = this.E > 0 ? SystemClock.elapsedRealtime() + this.E : -9223372036854775807L;
    }

    private void E() {
        MediaCodec mediaCodecY;
        byte b2 = 0;
        this.O = false;
        if (af.a < 23 || !this.ag || (mediaCodecY = y()) == null) {
            return;
        }
        this.r = new b(this, mediaCodecY, b2);
    }

    final void C() {
        if (this.O) {
            return;
        }
        this.O = true;
        this.D.a(this.L);
    }

    private void F() {
        if (this.O) {
            this.D.a(this.L);
        }
    }

    private void G() {
        this.ac = -1;
        this.ad = -1;
        this.af = -1.0f;
        this.ae = -1;
    }

    private void H() {
        int i = this.Y;
        if (i == -1 && this.Z == -1) {
            return;
        }
        if (this.ac == i && this.ad == this.Z && this.ae == this.aa && this.af == this.ab) {
            return;
        }
        this.D.a(i, this.Z, this.aa, this.ab);
        this.ac = this.Y;
        this.ad = this.Z;
        this.ae = this.aa;
        this.af = this.ab;
    }

    private void I() {
        int i = this.ac;
        if (i == -1 && this.ad == -1) {
            return;
        }
        this.D.a(i, this.ad, this.ae, this.af);
    }

    private void J() {
        if (this.S > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.D.a(this.S, jElapsedRealtime - this.R);
            this.S = 0;
            this.R = jElapsedRealtime;
        }
    }

    private static void a(MediaCodec mediaCodec, Surface surface) {
        mediaCodec.setOutputSurface(surface);
    }

    private static void a(MediaFormat mediaFormat, int i) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i);
    }

    private static MediaFormat a(m mVar, a aVar, boolean z2, int i) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", mVar.h);
        mediaFormat.setInteger("width", mVar.m);
        mediaFormat.setInteger("height", mVar.n);
        com.anythink.basead.exoplayer.f.e.a(mediaFormat, mVar.j);
        float f = mVar.o;
        if (f != -1.0f) {
            mediaFormat.setFloat("frame-rate", f);
        }
        com.anythink.basead.exoplayer.f.e.a(mediaFormat, "rotation-degrees", mVar.p);
        com.anythink.basead.exoplayer.l.b bVar = mVar.t;
        if (bVar != null) {
            com.anythink.basead.exoplayer.f.e.a(mediaFormat, "color-transfer", bVar.c);
            com.anythink.basead.exoplayer.f.e.a(mediaFormat, "color-standard", bVar.a);
            com.anythink.basead.exoplayer.f.e.a(mediaFormat, "color-range", bVar.b);
            byte[] bArr = bVar.d;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        mediaFormat.setInteger("max-width", aVar.a);
        mediaFormat.setInteger("max-height", aVar.b);
        com.anythink.basead.exoplayer.f.e.a(mediaFormat, "max-input-size", aVar.c);
        if (af.a >= 23) {
            mediaFormat.setInteger("priority", 0);
        }
        if (z2) {
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i != 0) {
            mediaFormat.setFeatureEnabled("tunneled-playback", true);
            mediaFormat.setInteger("audio-session-id", i);
        }
        return mediaFormat;
    }

    private static a a(com.anythink.basead.exoplayer.f.a aVar, m mVar, m[] mVarArr) {
        int iMax = mVar.m;
        int iMax2 = mVar.n;
        int iB = b(aVar, mVar);
        if (mVarArr.length == 1) {
            return new a(iMax, iMax2, iB);
        }
        boolean z2 = false;
        for (m mVar2 : mVarArr) {
            if (a(aVar.f, mVar, mVar2)) {
                z2 |= mVar2.m == -1 || mVar2.n == -1;
                iMax = Math.max(iMax, mVar2.m);
                iMax2 = Math.max(iMax2, mVar2.n);
                iB = Math.max(iB, b(aVar, mVar2));
            }
        }
        if (z2) {
            Log.w(s, "Resolutions unknown. Codec max resolution: " + iMax + "x" + iMax2);
            Point pointA = a(aVar, mVar);
            if (pointA != null) {
                iMax = Math.max(iMax, pointA.x);
                iMax2 = Math.max(iMax2, pointA.y);
                iB = Math.max(iB, a(aVar, mVar.h, iMax, iMax2));
                Log.w(s, "Codec max resolution adjusted to: " + iMax + "x" + iMax2);
            }
        }
        return new a(iMax, iMax2, iB);
    }

    private static Point a(com.anythink.basead.exoplayer.f.a aVar, m mVar) {
        boolean z2 = mVar.n > mVar.m;
        int i = z2 ? mVar.n : mVar.m;
        int i2 = z2 ? mVar.m : mVar.n;
        float f = i2 / i;
        for (int i3 : x) {
            int i4 = (int) (i3 * f);
            if (i3 <= i || i4 <= i2) {
                break;
            }
            if (af.a >= 21) {
                int i5 = z2 ? i4 : i3;
                if (!z2) {
                    i3 = i4;
                }
                Point pointA = aVar.a(i5, i3);
                if (aVar.a(pointA.x, pointA.y, mVar.o)) {
                    return pointA;
                }
            } else {
                int iA = af.a(i3, 16) * 16;
                int iA2 = af.a(i4, 16) * 16;
                if (iA * iA2 <= com.anythink.basead.exoplayer.f.d.b()) {
                    int i6 = z2 ? iA2 : iA;
                    if (!z2) {
                        iA = iA2;
                    }
                    return new Point(i6, iA);
                }
            }
        }
        return null;
    }

    private static int b(com.anythink.basead.exoplayer.f.a aVar, m mVar) {
        if (mVar.i != -1) {
            int size = mVar.j.size();
            int length = 0;
            for (int i = 0; i < size; i++) {
                length += mVar.j.get(i).length;
            }
            return mVar.i + length;
        }
        return a(aVar, mVar.h, mVar.m, mVar.n);
    }

    private static int a(com.anythink.basead.exoplayer.f.a aVar, String str, int i, int i2) {
        int iA;
        if (i == -1 || i2 == -1) {
            return -1;
        }
        str.hashCode();
        int i3 = 4;
        switch (str) {
            case "video/3gpp":
            case "video/mp4v-es":
            case "video/x-vnd.on2.vp8":
                iA = i * i2;
                i3 = 2;
                return (iA * 3) / (i3 * 2);
            case "video/hevc":
            case "video/x-vnd.on2.vp9":
                iA = i * i2;
                return (iA * 3) / (i3 * 2);
            case "video/avc":
                if ("BRAVIA 4K 2015".equals(af.d) || ("Amazon".equals(af.c) && ("KFSOWI".equals(af.d) || ("AFTS".equals(af.d) && aVar.h)))) {
                    return -1;
                }
                iA = af.a(i, 16) * af.a(i2, 16) * 16 * 16;
                i3 = 2;
                return (iA * 3) / (i3 * 2);
            default:
                return -1;
        }
    }

    private static boolean a(boolean z2, m mVar, m mVar2) {
        if (mVar.h.equals(mVar2.h) && mVar.p == mVar2.p) {
            return (z2 || (mVar.m == mVar2.m && mVar.n == mVar2.n)) && af.a(mVar.t, mVar2.t);
        }
        return false;
    }

    private static boolean K() {
        return af.a <= 22 && "foster".equals(af.b) && "NVIDIA".equals(af.c);
    }

    /* JADX WARN: Code duplicated, block: B:368:0x059a  */
    /* JADX WARN: Code duplicated, block: B:383:0x05c5  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static boolean a(String str) {
        byte b2 = 0;
        byte b3 = 27;
        if (af.a >= 27 || str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (e.class) {
            if (!z) {
                String str2 = af.b;
                switch (str2.hashCode()) {
                    case -2144781245:
                        if (!str2.equals("GIONEE_SWW1609")) {
                            b3 = -1;
                        } else {
                            b3 = 39;
                        }
                        break;
                    case -2144781185:
                        if (!str2.equals("GIONEE_SWW1627")) {
                            b3 = -1;
                        } else {
                            b3 = 40;
                        }
                        break;
                    case -2144781160:
                        if (!str2.equals("GIONEE_SWW1631")) {
                            b3 = -1;
                        } else {
                            b3 = 41;
                        }
                        break;
                    case -2097309513:
                        if (!str2.equals("K50a40")) {
                            b3 = -1;
                        } else {
                            b3 = 57;
                        }
                        break;
                    case -2022874474:
                        if (!str2.equals("CP8676_I02")) {
                            b3 = -1;
                        } else {
                            b3 = ek.n;
                        }
                        break;
                    case -1978993182:
                        if (!str2.equals("NX541J")) {
                            b3 = -1;
                        } else {
                            b3 = 69;
                        }
                        break;
                    case -1978990237:
                        if (!str2.equals("NX573J")) {
                            b3 = -1;
                        } else {
                            b3 = 70;
                        }
                        break;
                    case -1936688988:
                        if (!str2.equals("PGN528")) {
                            b3 = -1;
                        } else {
                            b3 = 80;
                        }
                        break;
                    case -1936688066:
                        if (!str2.equals("PGN610")) {
                            b3 = -1;
                        } else {
                            b3 = 81;
                        }
                        break;
                    case -1936688065:
                        if (!str2.equals("PGN611")) {
                            b3 = -1;
                        } else {
                            b3 = 82;
                        }
                        break;
                    case -1931988508:
                        if (!str2.equals("AquaPowerM")) {
                            b3 = -1;
                        } else {
                            b3 = 10;
                        }
                        break;
                    case -1696512866:
                        if (!str2.equals("XT1663")) {
                            b3 = -1;
                        } else {
                            b3 = 115;
                        }
                        break;
                    case -1680025915:
                        if (!str2.equals("ComioS1")) {
                            b3 = -1;
                        } else {
                            b3 = ek.m;
                        }
                        break;
                    case -1615810839:
                        if (!str2.equals("Phantom6")) {
                            b3 = -1;
                        } else {
                            b3 = 83;
                        }
                        break;
                    case -1554255044:
                        if (!str2.equals("vernee_M5")) {
                            b3 = -1;
                        } else {
                            b3 = 108;
                        }
                        break;
                    case -1481772737:
                        if (!str2.equals("panell_dl")) {
                            b3 = -1;
                        } else {
                            b3 = 76;
                        }
                        break;
                    case -1481772730:
                        if (!str2.equals("panell_ds")) {
                            b3 = -1;
                        } else {
                            b3 = 77;
                        }
                        break;
                    case -1481772729:
                        if (!str2.equals("panell_dt")) {
                            b3 = -1;
                        } else {
                            b3 = 78;
                        }
                        break;
                    case -1320080169:
                        if (!str2.equals("GiONEE_GBL7319")) {
                            b3 = -1;
                        } else {
                            b3 = 37;
                        }
                        break;
                    case -1217592143:
                        if (!str2.equals("BRAVIA_ATV2")) {
                            b3 = -1;
                        } else {
                            b3 = ek.k;
                        }
                        break;
                    case -1180384755:
                        if (!str2.equals("iris60")) {
                            b3 = -1;
                        } else {
                            b3 = 53;
                        }
                        break;
                    case -1139198265:
                        if (!str2.equals("Slate_Pro")) {
                            b3 = -1;
                        } else {
                            b3 = 96;
                        }
                        break;
                    case -1052835013:
                        if (!str2.equals("namath")) {
                            b3 = -1;
                        } else {
                            b3 = 67;
                        }
                        break;
                    case -993250464:
                        if (!str2.equals("A10-70F")) {
                            b3 = -1;
                        } else {
                            b3 = 3;
                        }
                        break;
                    case -965403638:
                        if (!str2.equals("s905x018")) {
                            b3 = -1;
                        } else {
                            b3 = 98;
                        }
                        break;
                    case -958336948:
                        if (!str2.equals("ELUGA_Ray_X")) {
                            b3 = -1;
                        } else {
                            b3 = 26;
                        }
                        break;
                    case -879245230:
                        if (!str2.equals("tcl_eu")) {
                            b3 = -1;
                        } else {
                            b3 = 104;
                        }
                        break;
                    case -842500323:
                        if (!str2.equals("nicklaus_f")) {
                            b3 = -1;
                        } else {
                            b3 = 68;
                        }
                        break;
                    case -821392978:
                        if (!str2.equals("A7000-a")) {
                            b3 = -1;
                        } else {
                            b3 = 6;
                        }
                        break;
                    case -797483286:
                        if (!str2.equals("SVP-DTV15")) {
                            b3 = -1;
                        } else {
                            b3 = 97;
                        }
                        break;
                    case -794946968:
                        if (!str2.equals("watson")) {
                            b3 = -1;
                        } else {
                            b3 = 109;
                        }
                        break;
                    case -788334647:
                        if (!str2.equals("whyred")) {
                            b3 = -1;
                        } else {
                            b3 = 110;
                        }
                        break;
                    case -782144577:
                        if (!str2.equals("OnePlus5T")) {
                            b3 = -1;
                        } else {
                            b3 = 71;
                        }
                        break;
                    case -575125681:
                        if (!str2.equals("GiONEE_CBL7513")) {
                            b3 = -1;
                        } else {
                            b3 = 36;
                        }
                        break;
                    case -521118391:
                        if (!str2.equals("GIONEE_GBL7360")) {
                            b3 = -1;
                        } else {
                            b3 = 38;
                        }
                        break;
                    case -430914369:
                        if (!str2.equals("Pixi4-7_3G")) {
                            b3 = -1;
                        } else {
                            b3 = 84;
                        }
                        break;
                    case -290434366:
                        if (!str2.equals("taido_row")) {
                            b3 = -1;
                        } else {
                            b3 = 99;
                        }
                        break;
                    case -282781963:
                        if (!str2.equals("BLACK-1X")) {
                            b3 = -1;
                        } else {
                            b3 = 12;
                        }
                        break;
                    case -277133239:
                        if (!str2.equals("Z12_PRO")) {
                            b3 = -1;
                        } else {
                            b3 = 116;
                        }
                        break;
                    case -173639913:
                        if (!str2.equals("ELUGA_A3_Pro")) {
                            b3 = -1;
                        } else {
                            b3 = 23;
                        }
                        break;
                    case -56598463:
                        if (!str2.equals("woods_fn")) {
                            b3 = -1;
                        } else {
                            b3 = 112;
                        }
                        break;
                    case 2126:
                        if (!str2.equals("C1")) {
                            b3 = -1;
                        } else {
                            b3 = ek.l;
                        }
                        break;
                    case 2564:
                        if (!str2.equals("Q5")) {
                            b3 = -1;
                        } else {
                            b3 = 92;
                        }
                        break;
                    case 2715:
                        if (!str2.equals("V1")) {
                            b3 = -1;
                        } else {
                            b3 = 105;
                        }
                        break;
                    case 2719:
                        if (!str2.equals("V5")) {
                            b3 = -1;
                        } else {
                            b3 = 107;
                        }
                        break;
                    case 3483:
                        if (!str2.equals("mh")) {
                            b3 = -1;
                        } else {
                            b3 = com.anythink.core.common.s.a.c.b;
                        }
                        break;
                    case 73405:
                        if (!str2.equals("JGZ")) {
                            b3 = -1;
                        } else {
                            b3 = 56;
                        }
                        break;
                    case 75739:
                        if (!str2.equals("M5c")) {
                            b3 = -1;
                        } else {
                            b3 = 60;
                        }
                        break;
                    case 76779:
                        if (!str2.equals("MX6")) {
                            b3 = -1;
                        } else {
                            b3 = 66;
                        }
                        break;
                    case 78669:
                        if (!str2.equals("P85")) {
                            b3 = -1;
                        } else {
                            b3 = 74;
                        }
                        break;
                    case 79305:
                        if (!str2.equals("PLE")) {
                            b3 = -1;
                        } else {
                            b3 = 86;
                        }
                        break;
                    case 80618:
                        if (!str2.equals("QX1")) {
                            b3 = -1;
                        } else {
                            b3 = 94;
                        }
                        break;
                    case 88274:
                        if (!str2.equals("Z80")) {
                            b3 = -1;
                        } else {
                            b3 = 117;
                        }
                        break;
                    case 98846:
                        if (!str2.equals("cv1")) {
                            b3 = -1;
                        } else {
                            b3 = 19;
                        }
                        break;
                    case 98848:
                        if (!str2.equals("cv3")) {
                            b3 = -1;
                        } else {
                            b3 = 20;
                        }
                        break;
                    case 99329:
                        if (!str2.equals("deb")) {
                            b3 = -1;
                        } else {
                            b3 = 21;
                        }
                        break;
                    case 101481:
                        if (!str2.equals("flo")) {
                            b3 = -1;
                        } else {
                            b3 = 35;
                        }
                        break;
                    case 1513190:
                        if (!str2.equals("1601")) {
                            b3 = -1;
                        } else {
                            b3 = 0;
                        }
                        break;
                    case 1514184:
                        if (!str2.equals("1713")) {
                            b3 = -1;
                        } else {
                            b3 = 1;
                        }
                        break;
                    case 1514185:
                        if (!str2.equals("1714")) {
                            b3 = -1;
                        } else {
                            b3 = 2;
                        }
                        break;
                    case 2436959:
                        if (!str2.equals("P681")) {
                            b3 = -1;
                        } else {
                            b3 = 73;
                        }
                        break;
                    case 2463773:
                        if (!str2.equals("Q350")) {
                            b3 = -1;
                        } else {
                            b3 = 88;
                        }
                        break;
                    case 2464648:
                        if (!str2.equals("Q427")) {
                            b3 = -1;
                        } else {
                            b3 = 90;
                        }
                        break;
                    case 2689555:
                        if (!str2.equals("XE2X")) {
                            b3 = -1;
                        } else {
                            b3 = 114;
                        }
                        break;
                    case 3351335:
                        if (!str2.equals("mido")) {
                            b3 = -1;
                        } else {
                            b3 = 65;
                        }
                        break;
                    case 3386211:
                        if (!str2.equals("p212")) {
                            b3 = -1;
                        } else {
                            b3 = 72;
                        }
                        break;
                    case 41325051:
                        if (!str2.equals("MEIZU_M5")) {
                            b3 = -1;
                        } else {
                            b3 = com.anythink.core.common.s.a.c.c;
                        }
                        break;
                    case 55178625:
                        if (!str2.equals("Aura_Note_2")) {
                            b3 = -1;
                        } else {
                            b3 = 11;
                        }
                        break;
                    case 61542055:
                        if (!str2.equals("A1601")) {
                            b3 = -1;
                        } else {
                            b3 = 4;
                        }
                        break;
                    case 65355429:
                        if (!str2.equals("E5643")) {
                            b3 = -1;
                        } else {
                            b3 = 22;
                        }
                        break;
                    case 66214468:
                        if (!str2.equals("F3111")) {
                            b3 = -1;
                        } else {
                            b3 = 28;
                        }
                        break;
                    case 66214470:
                        if (!str2.equals("F3113")) {
                            b3 = -1;
                        } else {
                            b3 = 29;
                        }
                        break;
                    case 66214473:
                        if (!str2.equals("F3116")) {
                            b3 = -1;
                        } else {
                            b3 = 30;
                        }
                        break;
                    case 66215429:
                        if (!str2.equals("F3211")) {
                            b3 = -1;
                        } else {
                            b3 = 31;
                        }
                        break;
                    case 66215431:
                        if (!str2.equals("F3213")) {
                            b3 = -1;
                        } else {
                            b3 = 32;
                        }
                        break;
                    case 66215433:
                        if (!str2.equals("F3215")) {
                            b3 = -1;
                        } else {
                            b3 = 33;
                        }
                        break;
                    case 66216390:
                        if (!str2.equals("F3311")) {
                            b3 = -1;
                        } else {
                            b3 = 34;
                        }
                        break;
                    case 76402249:
                        if (!str2.equals("PRO7S")) {
                            b3 = -1;
                        } else {
                            b3 = 87;
                        }
                        break;
                    case 76404105:
                        if (!str2.equals("Q4260")) {
                            b3 = -1;
                        } else {
                            b3 = 89;
                        }
                        break;
                    case 76404911:
                        if (!str2.equals("Q4310")) {
                            b3 = -1;
                        } else {
                            b3 = 91;
                        }
                        break;
                    case 80963634:
                        if (!str2.equals("V23GB")) {
                            b3 = -1;
                        } else {
                            b3 = 106;
                        }
                        break;
                    case 82882791:
                        if (!str2.equals("X3_HK")) {
                            b3 = -1;
                        } else {
                            b3 = 113;
                        }
                        break;
                    case 102844228:
                        if (!str2.equals("le_x6")) {
                            b3 = -1;
                        } else {
                            b3 = 58;
                        }
                        break;
                    case 165221241:
                        if (!str2.equals("A2016a40")) {
                            b3 = -1;
                        } else {
                            b3 = 5;
                        }
                        break;
                    case 182191441:
                        if (!str2.equals("CPY83_I00")) {
                            b3 = -1;
                        } else {
                            b3 = 18;
                        }
                        break;
                    case 245388979:
                        if (!str2.equals("marino_f")) {
                            b3 = -1;
                        } else {
                            b3 = 62;
                        }
                        break;
                    case 287431619:
                        if (!str2.equals("griffin")) {
                            b3 = -1;
                        } else {
                            b3 = 45;
                        }
                        break;
                    case 307593612:
                        if (!str2.equals("A7010a48")) {
                            b3 = -1;
                        } else {
                            b3 = 8;
                        }
                        break;
                    case 308517133:
                        if (!str2.equals("A7020a48")) {
                            b3 = -1;
                        } else {
                            b3 = 9;
                        }
                        break;
                    case 316215098:
                        if (!str2.equals("TB3-730F")) {
                            b3 = -1;
                        } else {
                            b3 = 100;
                        }
                        break;
                    case 316215116:
                        if (!str2.equals("TB3-730X")) {
                            b3 = -1;
                        } else {
                            b3 = 101;
                        }
                        break;
                    case 316246811:
                        if (!str2.equals("TB3-850F")) {
                            b3 = -1;
                        } else {
                            b3 = 102;
                        }
                        break;
                    case 316246818:
                        if (!str2.equals("TB3-850M")) {
                            b3 = -1;
                        } else {
                            b3 = 103;
                        }
                        break;
                    case 407160593:
                        if (!str2.equals("Pixi5-10_4G")) {
                            b3 = -1;
                        } else {
                            b3 = 85;
                        }
                        break;
                    case 507412548:
                        if (!str2.equals("QM16XE_U")) {
                            b3 = -1;
                        } else {
                            b3 = 93;
                        }
                        break;
                    case 793982701:
                        if (!str2.equals("GIONEE_WBL5708")) {
                            b3 = -1;
                        } else {
                            b3 = 42;
                        }
                        break;
                    case 794038622:
                        if (!str2.equals("GIONEE_WBL7365")) {
                            b3 = -1;
                        } else {
                            b3 = 43;
                        }
                        break;
                    case 794040393:
                        if (!str2.equals("GIONEE_WBL7519")) {
                            b3 = -1;
                        } else {
                            b3 = 44;
                        }
                        break;
                    case 835649806:
                        if (!str2.equals("manning")) {
                            b3 = -1;
                        } else {
                            b3 = 61;
                        }
                        break;
                    case 917340916:
                        if (!str2.equals("A7000plus")) {
                            b3 = -1;
                        } else {
                            b3 = 7;
                        }
                        break;
                    case 958008161:
                        if (!str2.equals("j2xlteins")) {
                            b3 = -1;
                        } else {
                            b3 = 55;
                        }
                        break;
                    case 1060579533:
                        if (!str2.equals("panell_d")) {
                            b3 = -1;
                        } else {
                            b3 = 75;
                        }
                        break;
                    case 1150207623:
                        if (!str2.equals("LS-5017")) {
                            b3 = -1;
                        } else {
                            b3 = 59;
                        }
                        break;
                    case 1176899427:
                        if (!str2.equals("itel_S41")) {
                            b3 = -1;
                        } else {
                            b3 = 54;
                        }
                        break;
                    case 1280332038:
                        if (!str2.equals("hwALE-H")) {
                            b3 = -1;
                        } else {
                            b3 = 47;
                        }
                        break;
                    case 1306947716:
                        if (!str2.equals("EverStar_S")) {
                            b3 = -1;
                        }
                        break;
                    case 1349174697:
                        if (!str2.equals("htc_e56ml_dtul")) {
                            b3 = -1;
                        } else {
                            b3 = 46;
                        }
                        break;
                    case 1522194893:
                        if (!str2.equals("woods_f")) {
                            b3 = -1;
                        } else {
                            b3 = 111;
                        }
                        break;
                    case 1691543273:
                        if (!str2.equals("CPH1609")) {
                            b3 = -1;
                        } else {
                            b3 = 17;
                        }
                        break;
                    case 1709443163:
                        if (!str2.equals("iball8735_9806")) {
                            b3 = -1;
                        } else {
                            b3 = 51;
                        }
                        break;
                    case 1865889110:
                        if (!str2.equals("santoni")) {
                            b3 = -1;
                        } else {
                            b3 = 95;
                        }
                        break;
                    case 1906253259:
                        if (!str2.equals("PB2-670M")) {
                            b3 = -1;
                        } else {
                            b3 = 79;
                        }
                        break;
                    case 1977196784:
                        if (!str2.equals("Infinix-X572")) {
                            b3 = -1;
                        } else {
                            b3 = 52;
                        }
                        break;
                    case 2029784656:
                        if (!str2.equals("HWBLN-H")) {
                            b3 = -1;
                        } else {
                            b3 = 48;
                        }
                        break;
                    case 2030379515:
                        if (!str2.equals("HWCAM-H")) {
                            b3 = -1;
                        } else {
                            b3 = 49;
                        }
                        break;
                    case 2047190025:
                        if (!str2.equals("ELUGA_Note")) {
                            b3 = -1;
                        } else {
                            b3 = 24;
                        }
                        break;
                    case 2047252157:
                        if (!str2.equals("ELUGA_Prim")) {
                            b3 = -1;
                        } else {
                            b3 = 25;
                        }
                        break;
                    case 2048319463:
                        if (!str2.equals("HWVNS-H")) {
                            b3 = -1;
                        } else {
                            b3 = 50;
                        }
                        break;
                    default:
                        b3 = -1;
                        break;
                }
                switch (b3) {
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
                        A = true;
                        break;
                }
                String str3 = af.d;
                int iHashCode = str3.hashCode();
                if (iHashCode != 2006354) {
                    if (iHashCode == 2006367 && str3.equals("AFTN")) {
                        b2 = 1;
                    } else {
                        b2 = -1;
                    }
                } else if (!str3.equals("AFTA")) {
                    b2 = -1;
                }
                if (b2 == 0 || b2 == 1) {
                    A = true;
                }
                z = true;
            }
        }
        return A;
    }

    protected static final class a {
        public final int a;
        public final int b;
        public final int c;

        public a(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }
    }

    private final class b implements MediaCodec.OnFrameRenderedListener {
        /* synthetic */ b(e eVar, MediaCodec mediaCodec, byte b) {
            this(mediaCodec);
        }

        private b(MediaCodec mediaCodec) {
            mediaCodec.setOnFrameRenderedListener(this, new Handler());
        }

        @Override // android.media.MediaCodec.OnFrameRenderedListener
        public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
            if (this != e.this.r) {
                return;
            }
            e.this.C();
        }
    }
}
