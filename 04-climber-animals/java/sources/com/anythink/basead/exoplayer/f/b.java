package com.anythink.basead.exoplayer.f;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.anythink.basead.exoplayer.d.f;
import com.anythink.basead.exoplayer.d.g;
import com.anythink.basead.exoplayer.d.k;
import com.anythink.basead.exoplayer.k.ad;
import com.anythink.basead.exoplayer.k.af;
import com.anythink.basead.exoplayer.k.p;
import com.anythink.basead.exoplayer.m;
import com.anythink.basead.exoplayer.n;
import com.anythink.core.common.d.j;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends com.anythink.basead.exoplayer.a {
    private static final int A = 1;
    private static final int B = 2;
    private static final byte[] C = af.g("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private static final int D = 32;
    protected static final int n = 0;
    protected static final int o = 1;
    protected static final int p = 3;
    private static final String r = "MediaCodecRenderer";
    private static final long s = 1000;
    private static final int t = 0;
    private static final int u = 1;
    private static final int v = 2;
    private static final int w = 0;
    private static final int x = 1;
    private static final int y = 2;
    private static final int z = 0;
    private final com.anythink.basead.exoplayer.f.c E;
    private final g<k> F;
    private final boolean G;
    private final com.anythink.basead.exoplayer.c.e H;
    private final com.anythink.basead.exoplayer.c.e I;
    private final n J;
    private final List<Long> K;
    private final MediaCodec.BufferInfo L;
    private m M;
    private f<k> N;
    private f<k> O;
    private MediaCodec P;
    private com.anythink.basead.exoplayer.f.a Q;
    private int R;
    private boolean S;
    private boolean T;
    private boolean U;
    private boolean V;
    private boolean W;
    private boolean X;
    private boolean Y;
    private boolean Z;
    private ByteBuffer[] aa;
    private ByteBuffer[] ab;
    private long ac;
    private int ad;
    private int ae;
    private ByteBuffer af;
    private boolean ag;
    private boolean ah;
    private int ai;
    private int aj;
    private boolean ak;
    private boolean al;
    private boolean am;
    private boolean an;
    private boolean ao;
    private boolean ap;
    protected com.anythink.basead.exoplayer.c.d q;

    @Retention(RetentionPolicy.SOURCE)
    private @interface a {
    }

    @Retention(RetentionPolicy.SOURCE)
    protected @interface c {
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface d {
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface e {
    }

    private static long I() {
        return 0L;
    }

    protected int a(com.anythink.basead.exoplayer.f.a aVar, m mVar, m mVar2) {
        return 0;
    }

    protected abstract int a(com.anythink.basead.exoplayer.f.c cVar, g<k> gVar, m mVar);

    protected void a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
    }

    protected void a(com.anythink.basead.exoplayer.c.e eVar) {
    }

    protected abstract void a(com.anythink.basead.exoplayer.f.a aVar, MediaCodec mediaCodec, m mVar, MediaCrypto mediaCrypto);

    protected void a(String str, long j, long j2) {
    }

    protected abstract boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z2);

    protected boolean a(com.anythink.basead.exoplayer.f.a aVar) {
        return true;
    }

    protected void c(long j) {
    }

    @Override // com.anythink.basead.exoplayer.a, com.anythink.basead.exoplayer.z
    public final int m() {
        return 8;
    }

    @Override // com.anythink.basead.exoplayer.a
    protected void n() {
    }

    @Override // com.anythink.basead.exoplayer.a
    protected void o() {
    }

    protected void w() {
    }

    /* JADX INFO: renamed from: com.anythink.basead.exoplayer.f.b$b, reason: collision with other inner class name */
    public static class C0025b extends Exception {
        private static final int e = -50000;
        private static final int f = -49999;
        private static final int g = -49998;
        public final String a;
        public final boolean b;
        public final String c;
        public final String d;

        public C0025b(m mVar, Throwable th, boolean z, int i) {
            super("Decoder init failed: [" + i + "], " + mVar, th);
            this.a = mVar.h;
            this.b = z;
            this.c = null;
            this.d = "com.google.android.exoplayer.MediaCodecTrackRenderer_" + (i < 0 ? "neg_" : "") + Math.abs(i);
        }

        public C0025b(m mVar, Throwable th, boolean z, String str) {
            super("Decoder init failed: " + str + ", " + mVar, th);
            this.a = mVar.h;
            this.b = z;
            this.c = str;
            String diagnosticInfo = null;
            if (af.a >= 21 && (th instanceof MediaCodec.CodecException)) {
                diagnosticInfo = ((MediaCodec.CodecException) th).getDiagnosticInfo();
            }
            this.d = diagnosticInfo;
        }

        private static String a(Throwable th) {
            if (th instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) th).getDiagnosticInfo();
            }
            return null;
        }

        private static String a(int i) {
            return "com.google.android.exoplayer.MediaCodecTrackRenderer_" + (i < 0 ? "neg_" : "") + Math.abs(i);
        }
    }

    public b(int i, com.anythink.basead.exoplayer.f.c cVar, g<k> gVar, boolean z2) {
        super(i);
        com.anythink.basead.exoplayer.k.a.b(af.a >= 16);
        this.E = (com.anythink.basead.exoplayer.f.c) com.anythink.basead.exoplayer.k.a.a(cVar);
        this.F = gVar;
        this.G = false;
        this.H = new com.anythink.basead.exoplayer.c.e(0);
        this.I = com.anythink.basead.exoplayer.c.e.e();
        this.J = new n();
        this.K = new ArrayList();
        this.L = new MediaCodec.BufferInfo();
        this.ai = 0;
        this.aj = 0;
    }

    @Override // com.anythink.basead.exoplayer.z
    public final int a(m mVar) throws com.anythink.basead.exoplayer.g {
        try {
            return a(this.E, this.F, mVar);
        } catch (com.anythink.basead.exoplayer.f.d.b e2) {
            throw com.anythink.basead.exoplayer.g.a(e2, s());
        }
    }

    protected com.anythink.basead.exoplayer.f.a a(com.anythink.basead.exoplayer.f.c cVar, m mVar, boolean z2) {
        return cVar.a(mVar.h, z2);
    }

    protected final void x() throws com.anythink.basead.exoplayer.g {
        m mVar;
        MediaCrypto mediaCryptoA;
        boolean zA;
        int i;
        if (this.P != null || (mVar = this.M) == null) {
            return;
        }
        this.N = this.O;
        String str = mVar.h;
        f<k> fVar = this.N;
        boolean z2 = false;
        if (fVar != null) {
            k kVar = (k) fVar.g();
            if (kVar == null) {
                if (this.N.f() == null) {
                    return;
                }
                mediaCryptoA = null;
                zA = false;
            } else {
                mediaCryptoA = kVar.a();
                zA = kVar.a(str);
            }
            if ("Amazon".equals(af.c) && ("AFTM".equals(af.d) || "AFTB".equals(af.d))) {
                int iE = this.N.e();
                if (iE == 1) {
                    throw com.anythink.basead.exoplayer.g.a(this.N.f(), s());
                }
                if (iE != 4) {
                    return;
                }
            }
        } else {
            mediaCryptoA = null;
            zA = false;
        }
        if (this.Q == null) {
            try {
                com.anythink.basead.exoplayer.f.a aVarA = a(this.E, this.M, zA);
                this.Q = aVarA;
                if (aVarA == null && zA) {
                    com.anythink.basead.exoplayer.f.a aVarA2 = a(this.E, this.M, false);
                    this.Q = aVarA2;
                    if (aVarA2 != null) {
                        Log.w(r, "Drm session requires secure decoder for " + str + ", but no secure decoder available. Trying to proceed with " + this.Q.c + j.z);
                    }
                }
            } catch (com.anythink.basead.exoplayer.f.d.b e2) {
                a(new C0025b(this.M, e2, zA, -49998));
            }
            if (this.Q == null) {
                a(new C0025b(this.M, (Throwable) null, zA, -49999));
            }
        }
        if (a(this.Q)) {
            String str2 = this.Q.c;
            if (af.a <= 25 && "OMX.Exynos.avc.dec.secure".equals(str2) && (af.d.startsWith("SM-T585") || af.d.startsWith("SM-A510") || af.d.startsWith("SM-A520") || af.d.startsWith("SM-J700"))) {
                i = 2;
            } else {
                i = (af.a >= 24 || !(("OMX.Nvidia.h264.decode".equals(str2) || "OMX.Nvidia.h264.decode.secure".equals(str2)) && ("flounder".equals(af.b) || "flounder_lte".equals(af.b) || "grouper".equals(af.b) || "tilapia".equals(af.b)))) ? 0 : 1;
            }
            this.R = i;
            this.S = af.a < 21 && this.M.j.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str2);
            this.T = af.a < 18 || (af.a == 18 && ("OMX.SEC.avc.dec".equals(str2) || "OMX.SEC.avc.dec.secure".equals(str2))) || (af.a == 19 && af.d.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str2) || "OMX.Exynos.avc.dec.secure".equals(str2)));
            com.anythink.basead.exoplayer.f.a aVar = this.Q;
            String str3 = aVar.c;
            this.U = (af.a <= 17 && ("OMX.rk.video_decoder.avc".equals(str3) || "OMX.allwinner.video.decoder.avc".equals(str3))) || ("Amazon".equals(af.c) && "AFTS".equals(af.d) && aVar.h);
            this.V = (af.a <= 23 && "OMX.google.vorbis.decoder".equals(str2)) || (af.a <= 19 && "hb2000".equals(af.b) && ("OMX.amlogic.avc.decoder.awesome".equals(str2) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str2)));
            this.W = af.a == 21 && "OMX.google.aac.decoder".equals(str2);
            m mVar2 = this.M;
            if (af.a <= 18 && mVar2.u == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str2)) {
                z2 = true;
            }
            this.X = z2;
            try {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                ad.a("createCodec:".concat(String.valueOf(str2)));
                this.P = MediaCodec.createByCodecName(str2);
                ad.a();
                ad.a("configureCodec");
                a(this.Q, this.P, this.M, mediaCryptoA);
                ad.a();
                ad.a("startCodec");
                this.P.start();
                ad.a();
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                a(str2, jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
                if (af.a < 21) {
                    this.aa = this.P.getInputBuffers();
                    this.ab = this.P.getOutputBuffers();
                }
            } catch (Exception e3) {
                a(new C0025b(this.M, e3, zA, str2));
            }
            this.ac = a_() == 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
            G();
            H();
            this.ap = true;
            this.q.a++;
        }
    }

    private void a(C0025b c0025b) throws com.anythink.basead.exoplayer.g {
        throw com.anythink.basead.exoplayer.g.a(c0025b, s());
    }

    protected final MediaCodec y() {
        return this.P;
    }

    protected final com.anythink.basead.exoplayer.f.a z() {
        return this.Q;
    }

    @Override // com.anythink.basead.exoplayer.a
    protected void a(boolean z2) {
        this.q = new com.anythink.basead.exoplayer.c.d();
    }

    @Override // com.anythink.basead.exoplayer.a
    protected void a(long j, boolean z2) throws com.anythink.basead.exoplayer.g {
        this.am = false;
        this.an = false;
        if (this.P != null) {
            B();
        }
    }

    @Override // com.anythink.basead.exoplayer.a
    protected void p() {
        this.M = null;
        try {
            A();
            try {
                f<k> fVar = this.N;
                if (fVar != null) {
                    this.F.a(fVar);
                }
                try {
                    f<k> fVar2 = this.O;
                    if (fVar2 != null && fVar2 != this.N) {
                        this.F.a(fVar2);
                    }
                } finally {
                    this.N = null;
                    this.O = null;
                }
            } catch (Throwable th) {
                try {
                    f<k> fVar3 = this.O;
                    if (fVar3 != null && fVar3 != this.N) {
                        this.F.a(fVar3);
                    }
                    throw th;
                } finally {
                    this.N = null;
                    this.O = null;
                }
            }
        } catch (Throwable th2) {
            try {
                if (this.N != null) {
                    this.F.a(this.N);
                }
                try {
                    f<k> fVar4 = this.O;
                    if (fVar4 != null && fVar4 != this.N) {
                        this.F.a(fVar4);
                    }
                    throw th2;
                } finally {
                    this.N = null;
                    this.O = null;
                }
            } catch (Throwable th3) {
                try {
                    f<k> fVar5 = this.O;
                    if (fVar5 != null && fVar5 != this.N) {
                        this.F.a(fVar5);
                    }
                    throw th3;
                } finally {
                    this.N = null;
                    this.O = null;
                }
            }
        }
    }

    protected void A() {
        this.ac = -9223372036854775807L;
        G();
        H();
        this.ao = false;
        this.ag = false;
        this.K.clear();
        if (af.a < 21) {
            this.aa = null;
            this.ab = null;
        }
        this.Q = null;
        this.ah = false;
        this.ak = false;
        this.S = false;
        this.T = false;
        this.R = 0;
        this.U = false;
        this.V = false;
        this.X = false;
        this.Y = false;
        this.Z = false;
        this.al = false;
        this.ai = 0;
        this.aj = 0;
        if (this.P != null) {
            this.q.b++;
            try {
                this.P.stop();
                try {
                    this.P.release();
                    this.P = null;
                    f<k> fVar = this.N;
                    if (fVar == null || this.O == fVar) {
                        return;
                    }
                    try {
                        this.F.a(fVar);
                    } finally {
                        this.N = null;
                    }
                } catch (Throwable th) {
                    this.P = null;
                    f<k> fVar2 = this.N;
                    if (fVar2 != null && this.O != fVar2) {
                        try {
                            this.F.a(fVar2);
                        } finally {
                            this.N = null;
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    this.P.release();
                    this.P = null;
                    f<k> fVar3 = this.N;
                    if (fVar3 != null && this.O != fVar3) {
                        try {
                            this.F.a(fVar3);
                        } finally {
                            this.N = null;
                        }
                    }
                    throw th2;
                } catch (Throwable th3) {
                    this.P = null;
                    f<k> fVar4 = this.N;
                    if (fVar4 != null && this.O != fVar4) {
                        try {
                            this.F.a(fVar4);
                        } finally {
                            this.N = null;
                        }
                    }
                    throw th3;
                }
            }
        }
    }

    @Override // com.anythink.basead.exoplayer.y
    public final void a(long j, long j2) throws com.anythink.basead.exoplayer.g {
        if (this.an) {
            w();
            return;
        }
        if (this.M == null) {
            this.I.a();
            int iA = a(this.J, this.I, true);
            if (iA != -5) {
                if (iA == -4) {
                    com.anythink.basead.exoplayer.k.a.b(this.I.c());
                    this.am = true;
                    L();
                    return;
                }
                return;
            }
            b(this.J.a);
        }
        x();
        if (this.P != null) {
            ad.a("drainAndFeed");
            while (b(j, j2)) {
            }
            while (C()) {
            }
            ad.a();
            return;
        }
        this.q.d += b(j);
        this.I.a();
        int iA2 = a(this.J, this.I, false);
        if (iA2 == -5) {
            b(this.J.a);
        } else if (iA2 == -4) {
            com.anythink.basead.exoplayer.k.a.b(this.I.c());
            this.am = true;
            L();
        }
    }

    protected void B() throws com.anythink.basead.exoplayer.g {
        this.ac = -9223372036854775807L;
        G();
        H();
        this.ap = true;
        this.ao = false;
        this.ag = false;
        this.K.clear();
        this.Y = false;
        this.Z = false;
        if (this.T || ((this.V && this.al) || this.aj != 0)) {
            A();
            x();
        } else {
            this.P.flush();
            this.ak = false;
        }
        if (!this.ah || this.M == null) {
            return;
        }
        this.ai = 1;
    }

    /* JADX WARN: Code duplicated, block: B:88:0x0152  */
    private boolean C() throws com.anythink.basead.exoplayer.g {
        int iPosition;
        int iA;
        boolean z2;
        ByteBuffer inputBuffer;
        MediaCodec mediaCodec = this.P;
        if (mediaCodec == null || this.aj == 2 || this.am) {
            return false;
        }
        if (this.ad < 0) {
            int iDequeueInputBuffer = mediaCodec.dequeueInputBuffer(0L);
            this.ad = iDequeueInputBuffer;
            if (iDequeueInputBuffer < 0) {
                return false;
            }
            com.anythink.basead.exoplayer.c.e eVar = this.H;
            if (af.a >= 21) {
                inputBuffer = this.P.getInputBuffer(iDequeueInputBuffer);
            } else {
                inputBuffer = this.aa[iDequeueInputBuffer];
            }
            eVar.e = inputBuffer;
            this.H.a();
        }
        if (this.aj == 1) {
            if (!this.U) {
                this.al = true;
                this.P.queueInputBuffer(this.ad, 0, 0, 0L, 4);
                G();
            }
            this.aj = 2;
            return false;
        }
        if (this.Y) {
            this.Y = false;
            ByteBuffer byteBuffer = this.H.e;
            byte[] bArr = C;
            byteBuffer.put(bArr);
            this.P.queueInputBuffer(this.ad, 0, bArr.length, 0L, 0);
            G();
            this.ak = true;
            return true;
        }
        if (this.ao) {
            iA = -4;
            iPosition = 0;
        } else {
            if (this.ai == 1) {
                for (int i = 0; i < this.M.j.size(); i++) {
                    this.H.e.put(this.M.j.get(i));
                }
                this.ai = 2;
            }
            iPosition = this.H.e.position();
            iA = a(this.J, this.H, false);
        }
        if (iA == -3) {
            return false;
        }
        if (iA == -5) {
            if (this.ai == 2) {
                this.H.a();
                this.ai = 1;
            }
            b(this.J.a);
            return true;
        }
        if (this.H.c()) {
            if (this.ai == 2) {
                this.H.a();
                this.ai = 1;
            }
            this.am = true;
            if (!this.ak) {
                L();
                return false;
            }
            try {
                if (!this.U) {
                    this.al = true;
                    this.P.queueInputBuffer(this.ad, 0, 0, 0L, 4);
                    G();
                }
                return false;
            } catch (Exception e2) {
                throw com.anythink.basead.exoplayer.g.a(e2, s());
            }
        }
        if (this.ap && !this.H.d()) {
            this.H.a();
            if (this.ai == 2) {
                this.ai = 1;
            }
            return true;
        }
        this.ap = false;
        boolean zG = this.H.g();
        f<k> fVar = this.N;
        if (fVar == null || (!zG && this.G)) {
            z2 = false;
        } else {
            int iE = fVar.e();
            if (iE == 1) {
                throw com.anythink.basead.exoplayer.g.a(this.N.f(), s());
            }
            if (iE != 4) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        this.ao = z2;
        if (z2) {
            return false;
        }
        if (this.S && !zG) {
            p.a(this.H.e);
            if (this.H.e.position() == 0) {
                return true;
            }
            this.S = false;
        }
        try {
            long j = this.H.f;
            if (this.H.b()) {
                this.K.add(Long.valueOf(j));
            }
            this.H.h();
            a(this.H);
            if (!zG) {
                this.P.queueInputBuffer(this.ad, 0, this.H.e.limit(), j, 0);
            } else {
                MediaCodec.CryptoInfo cryptoInfoA = this.H.d.a();
                if (iPosition != 0) {
                    if (cryptoInfoA.numBytesOfClearData == null) {
                        cryptoInfoA.numBytesOfClearData = new int[1];
                    }
                    int[] iArr = cryptoInfoA.numBytesOfClearData;
                    iArr[0] = iArr[0] + iPosition;
                }
                this.P.queueSecureInputBuffer(this.ad, 0, cryptoInfoA, j, 0);
            }
            G();
            this.ak = true;
            this.ai = 0;
            this.q.c++;
            return true;
        } catch (Exception e3) {
            throw com.anythink.basead.exoplayer.g.a(e3, s());
        }
    }

    private void D() {
        if (af.a < 21) {
            this.aa = this.P.getInputBuffers();
            this.ab = this.P.getOutputBuffers();
        }
    }

    private void E() {
        if (af.a < 21) {
            this.aa = null;
            this.ab = null;
        }
    }

    private ByteBuffer b(int i) {
        if (af.a >= 21) {
            return this.P.getInputBuffer(i);
        }
        return this.aa[i];
    }

    private ByteBuffer c(int i) {
        if (af.a >= 21) {
            return this.P.getOutputBuffer(i);
        }
        return this.ab[i];
    }

    private boolean F() {
        return this.ae >= 0;
    }

    private void G() {
        this.ad = -1;
        this.H.e = null;
    }

    private void H() {
        this.ae = -1;
        this.af = null;
    }

    private static MediaCodec.CryptoInfo a(com.anythink.basead.exoplayer.c.e eVar, int i) {
        MediaCodec.CryptoInfo cryptoInfoA = eVar.d.a();
        if (i == 0) {
            return cryptoInfoA;
        }
        if (cryptoInfoA.numBytesOfClearData == null) {
            cryptoInfoA.numBytesOfClearData = new int[1];
        }
        int[] iArr = cryptoInfoA.numBytesOfClearData;
        iArr[0] = iArr[0] + i;
        return cryptoInfoA;
    }

    private boolean b(boolean z2) throws com.anythink.basead.exoplayer.g {
        f<k> fVar = this.N;
        if (fVar == null || (!z2 && this.G)) {
            return false;
        }
        int iE = fVar.e();
        if (iE != 1) {
            return iE != 4;
        }
        throw com.anythink.basead.exoplayer.g.a(this.N.f(), s());
    }

    protected void b(m mVar) throws com.anythink.basead.exoplayer.g {
        int iA;
        m mVar2 = this.M;
        this.M = mVar;
        if (!af.a(mVar.k, mVar2 == null ? null : mVar2.k)) {
            if (this.M.k != null) {
                g<k> gVar = this.F;
                if (gVar == null) {
                    throw com.anythink.basead.exoplayer.g.a(new IllegalStateException("Media requires a DrmSessionManager"), s());
                }
                f fVarA = gVar.a(Looper.myLooper(), this.M.k);
                this.O = fVarA;
                if (fVarA == this.N) {
                    this.F.a(fVarA);
                }
            } else {
                this.O = null;
            }
        }
        boolean z2 = false;
        if (this.O == this.N && this.P != null && (iA = a(this.Q, mVar2, this.M)) != 0) {
            if (iA != 1) {
                if (iA == 3) {
                    this.ah = true;
                    this.ai = 1;
                    int i = this.R;
                    if (i == 2 || (i == 1 && this.M.m == mVar2.m && this.M.n == mVar2.n)) {
                        z2 = true;
                    }
                    this.Y = z2;
                } else {
                    throw new IllegalStateException();
                }
            }
            z2 = true;
        }
        if (z2) {
            return;
        }
        if (this.ak) {
            this.aj = 1;
        } else {
            A();
            x();
        }
    }

    @Override // com.anythink.basead.exoplayer.y
    public boolean v() {
        return this.an;
    }

    @Override // com.anythink.basead.exoplayer.y
    public boolean u() {
        if (this.M == null || this.ao) {
            return false;
        }
        if (t() || F()) {
            return true;
        }
        return this.ac != -9223372036854775807L && SystemClock.elapsedRealtime() < this.ac;
    }

    private boolean b(long j, long j2) throws com.anythink.basead.exoplayer.g {
        boolean zA;
        int iDequeueOutputBuffer;
        ByteBuffer outputBuffer;
        boolean z2;
        if (!F()) {
            if (this.W && this.al) {
                try {
                    iDequeueOutputBuffer = this.P.dequeueOutputBuffer(this.L, 0L);
                } catch (IllegalStateException unused) {
                    L();
                    if (this.an) {
                        A();
                    }
                    return false;
                }
            } else {
                iDequeueOutputBuffer = this.P.dequeueOutputBuffer(this.L, 0L);
            }
            if (iDequeueOutputBuffer < 0) {
                if (iDequeueOutputBuffer == -2) {
                    MediaFormat outputFormat = this.P.getOutputFormat();
                    if (this.R != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
                        this.Z = true;
                    } else {
                        if (this.X) {
                            outputFormat.setInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT, 1);
                        }
                        a(this.P, outputFormat);
                    }
                    return true;
                }
                if (iDequeueOutputBuffer != -3) {
                    if (this.U && (this.am || this.aj == 2)) {
                        L();
                    }
                    return false;
                }
                if (af.a < 21) {
                    this.ab = this.P.getOutputBuffers();
                }
                return true;
            }
            if (this.Z) {
                this.Z = false;
                this.P.releaseOutputBuffer(iDequeueOutputBuffer, false);
                return true;
            }
            if (this.L.size == 0 && (this.L.flags & 4) != 0) {
                L();
                return false;
            }
            this.ae = iDequeueOutputBuffer;
            if (af.a >= 21) {
                outputBuffer = this.P.getOutputBuffer(iDequeueOutputBuffer);
            } else {
                outputBuffer = this.ab[iDequeueOutputBuffer];
            }
            this.af = outputBuffer;
            if (outputBuffer != null) {
                outputBuffer.position(this.L.offset);
                this.af.limit(this.L.offset + this.L.size);
            }
            long j3 = this.L.presentationTimeUs;
            int size = this.K.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    z2 = false;
                    break;
                }
                if (this.K.get(i).longValue() == j3) {
                    this.K.remove(i);
                    z2 = true;
                    break;
                }
                i++;
            }
            this.ag = z2;
        }
        if (this.W && this.al) {
            try {
                zA = a(j, j2, this.P, this.af, this.ae, this.L.flags, this.L.presentationTimeUs, this.ag);
            } catch (IllegalStateException unused2) {
                L();
                if (this.an) {
                    A();
                }
                return false;
            }
        } else {
            zA = a(j, j2, this.P, this.af, this.ae, this.L.flags, this.L.presentationTimeUs, this.ag);
        }
        if (zA) {
            c(this.L.presentationTimeUs);
            boolean z3 = (this.L.flags & 4) != 0;
            H();
            if (!z3) {
                return true;
            }
            L();
        }
        return false;
    }

    private void J() {
        MediaFormat outputFormat = this.P.getOutputFormat();
        if (this.R != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
            this.Z = true;
            return;
        }
        if (this.X) {
            outputFormat.setInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT, 1);
        }
        a(this.P, outputFormat);
    }

    private void K() {
        if (af.a < 21) {
            this.ab = this.P.getOutputBuffers();
        }
    }

    private void L() throws com.anythink.basead.exoplayer.g {
        if (this.aj == 2) {
            A();
            x();
        } else {
            this.an = true;
            w();
        }
    }

    private boolean d(long j) {
        int size = this.K.size();
        for (int i = 0; i < size; i++) {
            if (this.K.get(i).longValue() == j) {
                this.K.remove(i);
                return true;
            }
        }
        return false;
    }

    private static boolean M() {
        if ("Amazon".equals(af.c)) {
            return "AFTM".equals(af.d) || "AFTB".equals(af.d);
        }
        return false;
    }

    private static boolean a(String str) {
        if (af.a < 18) {
            return true;
        }
        if (af.a == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) {
            return true;
        }
        if (af.a == 19 && af.d.startsWith("SM-G800")) {
            return "OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str);
        }
        return false;
    }

    private static int b(String str) {
        if (af.a <= 25 && "OMX.Exynos.avc.dec.secure".equals(str) && (af.d.startsWith("SM-T585") || af.d.startsWith("SM-A510") || af.d.startsWith("SM-A520") || af.d.startsWith("SM-J700"))) {
            return 2;
        }
        if (af.a >= 24) {
            return 0;
        }
        if ("OMX.Nvidia.h264.decode".equals(str) || "OMX.Nvidia.h264.decode.secure".equals(str)) {
            return ("flounder".equals(af.b) || "flounder_lte".equals(af.b) || "grouper".equals(af.b) || "tilapia".equals(af.b)) ? 1 : 0;
        }
        return 0;
    }

    private static boolean a(String str, m mVar) {
        return af.a < 21 && mVar.j.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    private static boolean b(com.anythink.basead.exoplayer.f.a aVar) {
        String str = aVar.c;
        if (af.a > 17 || !("OMX.rk.video_decoder.avc".equals(str) || "OMX.allwinner.video.decoder.avc".equals(str))) {
            return "Amazon".equals(af.c) && "AFTS".equals(af.d) && aVar.h;
        }
        return true;
    }

    private static boolean c(String str) {
        if (af.a <= 23 && "OMX.google.vorbis.decoder".equals(str)) {
            return true;
        }
        if (af.a > 19 || !"hb2000".equals(af.b)) {
            return false;
        }
        return "OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str);
    }

    private static boolean d(String str) {
        return af.a == 21 && "OMX.google.aac.decoder".equals(str);
    }

    private static boolean b(String str, m mVar) {
        return af.a <= 18 && mVar.u == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str);
    }
}
