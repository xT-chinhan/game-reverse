package com.smartdigimkt.p0;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.SystemClock;
import com.bykv.vk.component.ttvideo.player.C;
import com.smartdigimkt.i0.s;
import com.smartdigimkt.i0.t;
import com.smartdigimkt.z0.u;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c extends com.smartdigimkt.i0.a {
    public static final byte[] Q;
    public ByteBuffer[] A;
    public ByteBuffer[] B;
    public long C;
    public int D;
    public int E;
    public ByteBuffer F;
    public boolean G;
    public boolean H;
    public int I;
    public int J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public com.smartdigimkt.l0.d P;
    public final d i;
    public final com.smartdigimkt.l0.e j;
    public final com.smartdigimkt.l0.e k;
    public final t l;
    public final ArrayList m;
    public final MediaCodec.BufferInfo n;
    public s o;
    public MediaCodec p;
    public a q;
    public int r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(int i) {
        super(i);
        d dVar = d.a;
        if (u.a < 16) {
            throw new IllegalStateException();
        }
        this.i = dVar;
        this.j = new com.smartdigimkt.l0.e(0);
        this.k = new com.smartdigimkt.l0.e(0);
        this.l = new t();
        this.m = new ArrayList();
        this.n = new MediaCodec.BufferInfo();
        this.I = 0;
        this.J = 0;
    }

    @Override // com.smartdigimkt.i0.a
    public final int a(s sVar) throws com.smartdigimkt.i0.g {
        try {
            return b(this.i, sVar);
        } catch (f e) {
            throw new com.smartdigimkt.i0.g(1, e);
        }
    }

    public abstract int a(a aVar, s sVar, s sVar2);

    public void a(long j) {
    }

    public abstract void a(MediaCodec mediaCodec, MediaFormat mediaFormat);

    public abstract void a(com.smartdigimkt.l0.e eVar);

    public abstract void a(a aVar, MediaCodec mediaCodec, s sVar);

    public abstract void a(String str, long j, long j2);

    public abstract boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z);

    public boolean a(a aVar) {
        return true;
    }

    public abstract int b(d dVar, s sVar);

    /* JADX WARN: Code duplicated, block: B:28:0x0055  */
    public void b(s sVar) {
        int iA;
        s sVar2 = this.o;
        this.o = sVar;
        boolean z = true;
        if ((!u.a(sVar.i, sVar2 == null ? null : sVar2.i)) && this.o.i != null) {
            throw new com.smartdigimkt.i0.g(1, new IllegalStateException("Media requires a DrmSessionManager"));
        }
        if (this.p == null || (iA = a(this.q, sVar2, this.o)) == 0) {
            if (this.K) {
                this.J = 1;
                return;
            } else {
                n();
                l();
                return;
            }
        }
        if (iA != 1) {
            if (iA != 3) {
                throw new IllegalStateException();
            }
            this.H = true;
            this.I = 1;
            int i = this.r;
            if (i != 2) {
                if (i == 1) {
                    s sVar3 = this.o;
                    if (sVar3.k != sVar2.k || sVar3.l != sVar2.l) {
                        z = false;
                    }
                } else {
                    z = false;
                }
            }
            this.y = z;
        }
    }

    @Override // com.smartdigimkt.i0.a
    public boolean d() {
        return this.N;
    }

    @Override // com.smartdigimkt.i0.a
    public boolean e() {
        if (this.o != null) {
            if ((this.g ? this.h : this.d.a()) || this.E >= 0 || (this.C != -9223372036854775807L && SystemClock.elapsedRealtime() < this.C)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.smartdigimkt.i0.a
    public final int j() {
        return 8;
    }

    public void k() {
        this.C = -9223372036854775807L;
        p();
        this.E = -1;
        this.F = null;
        this.O = true;
        this.G = false;
        this.m.clear();
        this.y = false;
        this.z = false;
        if (this.t || ((this.v && this.L) || this.J != 0)) {
            n();
            l();
        } else {
            this.p.flush();
            this.K = false;
        }
        if (!this.H || this.o == null) {
            return;
        }
        this.I = 1;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x007f  */
    /* JADX WARN: Code duplicated, block: B:48:0x00b7  */
    public final void l() throws com.smartdigimkt.i0.g {
        s sVar;
        int i;
        if (this.p != null || (sVar = this.o) == null) {
            return;
        }
        if (this.q == null) {
            try {
                a aVarA = a(this.i, sVar);
                this.q = aVarA;
                if (aVarA == null) {
                    throw new com.smartdigimkt.i0.g(1, new b(this.o, (f) null, -49999));
                }
            } catch (f e) {
                throw new com.smartdigimkt.i0.g(1, new b(this.o, e, -49998));
            }
        }
        if (a(this.q)) {
            String str = this.q.a;
            int i2 = u.a;
            boolean z = false;
            if (i2 <= 25 && "OMX.Exynos.avc.dec.secure".equals(str)) {
                String str2 = u.d;
                if (str2.startsWith("SM-T585") || str2.startsWith("SM-A510") || str2.startsWith("SM-A520") || str2.startsWith("SM-J700")) {
                    i = 2;
                } else if (i2 < 24) {
                    i = 0;
                } else {
                    i = 0;
                }
            } else if (i2 < 24 || !("OMX.Nvidia.h264.decode".equals(str) || "OMX.Nvidia.h264.decode.secure".equals(str))) {
                i = 0;
            } else {
                String str3 = u.b;
                if ("flounder".equals(str3) || "flounder_lte".equals(str3) || "grouper".equals(str3) || "tilapia".equals(str3)) {
                    i = 1;
                } else {
                    i = 0;
                }
            }
            this.r = i;
            this.s = i2 < 21 && this.o.h.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
            this.t = i2 < 18 || (i2 == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (i2 == 19 && u.d.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str)));
            a aVar = this.q;
            String str4 = aVar.a;
            this.u = (i2 <= 17 && ("OMX.rk.video_decoder.avc".equals(str4) || "OMX.allwinner.video.decoder.avc".equals(str4))) || ("Amazon".equals(u.c) && "AFTS".equals(u.d) && aVar.f);
            this.v = (i2 <= 23 && "OMX.google.vorbis.decoder".equals(str)) || (i2 <= 19 && "hb2000".equals(u.b) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str)));
            this.w = i2 == 21 && "OMX.google.aac.decoder".equals(str);
            s sVar2 = this.o;
            if (i2 <= 18 && sVar2.s == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str)) {
                z = true;
            }
            this.x = z;
            try {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                com.smartdigimkt.z0.s.a("createCodec:" + str);
                this.p = MediaCodec.createByCodecName(str);
                com.smartdigimkt.z0.s.a();
                com.smartdigimkt.z0.s.a("configureCodec");
                a(this.q, this.p, this.o);
                com.smartdigimkt.z0.s.a();
                com.smartdigimkt.z0.s.a("startCodec");
                this.p.start();
                com.smartdigimkt.z0.s.a();
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                a(str, jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
                if (i2 < 21) {
                    this.A = this.p.getInputBuffers();
                    this.B = this.p.getOutputBuffers();
                }
                this.C = this.c == 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
                p();
                this.E = -1;
                this.F = null;
                this.O = true;
                this.P.getClass();
            } catch (Exception e2) {
                throw new com.smartdigimkt.i0.g(1, new b(this.o, e2, str));
            }
        }
    }

    public final void m() throws com.smartdigimkt.i0.g {
        if (this.J == 2) {
            n();
            l();
        } else {
            this.N = true;
            o();
        }
    }

    public void n() {
        this.C = -9223372036854775807L;
        p();
        this.E = -1;
        this.F = null;
        this.G = false;
        this.m.clear();
        if (u.a < 21) {
            this.A = null;
            this.B = null;
        }
        this.q = null;
        this.H = false;
        this.K = false;
        this.s = false;
        this.t = false;
        this.r = 0;
        this.u = false;
        this.v = false;
        this.x = false;
        this.y = false;
        this.z = false;
        this.L = false;
        this.I = 0;
        this.J = 0;
        MediaCodec mediaCodec = this.p;
        if (mediaCodec != null) {
            this.P.getClass();
            try {
                mediaCodec.stop();
                try {
                    this.p.release();
                } finally {
                    this.p = null;
                }
            } catch (Throwable th) {
                try {
                    this.p.release();
                    throw th;
                } finally {
                    this.p = null;
                }
            }
        }
    }

    public void o() {
    }

    public final void p() {
        this.D = -1;
        this.j.b = null;
    }

    static {
        int i = u.a;
        byte[] bArr = new byte[38];
        for (int i2 = 0; i2 < 38; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) (Character.digit("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78".charAt(i3 + 1), 16) + (Character.digit("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78".charAt(i3), 16) << 4));
        }
        Q = bArr;
    }

    public a a(d dVar, s sVar) {
        String str = sVar.f;
        dVar.getClass();
        return j.a(str, false);
    }

    /* JADX WARN: Code duplicated, block: B:114:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:204:0x0363 A[Catch: Exception -> 0x03cc, TryCatch #1 {Exception -> 0x03cc, blocks: (B:202:0x0357, B:204:0x0363, B:205:0x036c, B:207:0x037a, B:214:0x0392, B:216:0x03bf, B:210:0x0383, B:212:0x0387, B:213:0x038b, B:215:0x03a6), top: B:238:0x0357 }] */
    /* JADX WARN: Code duplicated, block: B:207:0x037a A[Catch: Exception -> 0x03cc, TryCatch #1 {Exception -> 0x03cc, blocks: (B:202:0x0357, B:204:0x0363, B:205:0x036c, B:207:0x037a, B:214:0x0392, B:216:0x03bf, B:210:0x0383, B:212:0x0387, B:213:0x038b, B:215:0x03a6), top: B:238:0x0357 }] */
    /* JADX WARN: Code duplicated, block: B:209:0x0382  */
    /* JADX WARN: Code duplicated, block: B:210:0x0383 A[Catch: Exception -> 0x03cc, TryCatch #1 {Exception -> 0x03cc, blocks: (B:202:0x0357, B:204:0x0363, B:205:0x036c, B:207:0x037a, B:214:0x0392, B:216:0x03bf, B:210:0x0383, B:212:0x0387, B:213:0x038b, B:215:0x03a6), top: B:238:0x0357 }] */
    /* JADX WARN: Code duplicated, block: B:212:0x0387 A[Catch: Exception -> 0x03cc, TryCatch #1 {Exception -> 0x03cc, blocks: (B:202:0x0357, B:204:0x0363, B:205:0x036c, B:207:0x037a, B:214:0x0392, B:216:0x03bf, B:210:0x0383, B:212:0x0387, B:213:0x038b, B:215:0x03a6), top: B:238:0x0357 }] */
    /* JADX WARN: Code duplicated, block: B:215:0x03a6 A[Catch: Exception -> 0x03cc, TryCatch #1 {Exception -> 0x03cc, blocks: (B:202:0x0357, B:204:0x0363, B:205:0x036c, B:207:0x037a, B:214:0x0392, B:216:0x03bf, B:210:0x0383, B:212:0x0387, B:213:0x038b, B:215:0x03a6), top: B:238:0x0357 }] */
    /* JADX WARN: Code duplicated, block: B:264:0x03d3 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v51, types: [android.media.MediaFormat] */
    /* JADX WARN: Type inference failed for: r0v58, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v13, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v15, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v16 */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v18 */
    /* JADX WARN: Type inference failed for: r14v19 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v20 */
    /* JADX WARN: Type inference failed for: r14v21 */
    /* JADX WARN: Type inference failed for: r14v22 */
    /* JADX WARN: Type inference failed for: r14v24 */
    /* JADX WARN: Type inference failed for: r14v25 */
    /* JADX WARN: Type inference failed for: r14v26 */
    /* JADX WARN: Type inference failed for: r14v27 */
    /* JADX WARN: Type inference failed for: r14v28 */
    /* JADX WARN: Type inference failed for: r27v0, types: [com.smartdigimkt.i0.a, com.smartdigimkt.p0.c] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9, types: [int] */
    /* JADX WARN: Type inference failed for: r4v28, types: [java.util.ArrayList] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:83:0x016c -> B:112:0x01c7). Please report as a decompilation issue!!! */
    @Override // com.smartdigimkt.i0.a
    public final void a(long j, long j2) throws com.smartdigimkt.i0.g {
        ?? r14;
        int i;
        boolean z;
        boolean zA;
        int i2;
        ?? r15;
        int i3;
        int i4;
        MediaCodec mediaCodec;
        com.smartdigimkt.l0.e eVar;
        long j3;
        MediaCodec.CryptoInfo cryptoInfo;
        ByteBuffer inputBuffer;
        int iDequeueOutputBuffer;
        ?? r16;
        ByteBuffer outputBuffer;
        boolean z2;
        if (this.N) {
            o();
            return;
        }
        ?? r12 = 1;
        if (this.o == null) {
            this.k.a();
            int iA = a(this.l, this.k, true);
            if (iA != -5) {
                if (iA == -4) {
                    if (this.k.b(4)) {
                        this.M = true;
                        m();
                        return;
                    }
                    throw new IllegalStateException();
                }
                return;
            }
            b(this.l.a);
        }
        l();
        boolean z3 = false;
        if (this.p != null) {
            com.smartdigimkt.z0.s.a("drainAndFeed");
            while (true) {
                if (this.E < 0) {
                    if (this.w && this.L) {
                        try {
                            iDequeueOutputBuffer = this.p.dequeueOutputBuffer(this.n, 0L);
                        } catch (IllegalStateException unused) {
                            m();
                            if (this.N) {
                                n();
                            }
                        }
                    } else {
                        iDequeueOutputBuffer = this.p.dequeueOutputBuffer(this.n, 0L);
                    }
                    if (iDequeueOutputBuffer < 0) {
                        i2 = 21;
                        r16 = r12 == true ? 1 : 0;
                        if (iDequeueOutputBuffer == -2) {
                            ?? outputFormat = this.p.getOutputFormat();
                            if (this.r != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
                                this.z = r16;
                                r14 = r16;
                            } else {
                                if (this.x) {
                                    outputFormat.setInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT, r16);
                                }
                                a(this.p, outputFormat);
                                r14 = r16;
                            }
                        } else if (iDequeueOutputBuffer == -3) {
                            if (u.a < 21) {
                                r14 = r16;
                                this.B = this.p.getOutputBuffers();
                                r14 = r16;
                            }
                        } else {
                            r15 = r16;
                            if (this.u) {
                                if (this.M) {
                                    i3 = 2;
                                } else {
                                    i3 = 2;
                                    if (this.J == 2) {
                                    }
                                }
                                i4 = r16;
                                m();
                                i4 = r16;
                            } else {
                                i3 = 2;
                                i4 = r15;
                            }
                            i4 = r16;
                            while (true) {
                                mediaCodec = this.p;
                                if (mediaCodec == null) {
                                }
                                com.smartdigimkt.z0.s.a();
                            }
                        }
                        r14 = r16;
                        r12 = r14;
                        z3 = false;
                    } else if (this.z) {
                        this.z = z3;
                        this.p.releaseOutputBuffer(iDequeueOutputBuffer, z3);
                    } else {
                        MediaCodec.BufferInfo bufferInfo = this.n;
                        if (bufferInfo.size == 0 && (bufferInfo.flags & 4) != 0) {
                            m();
                            i3 = 2;
                            i2 = 21;
                            i4 = r12 == true ? 1 : 0;
                            i4 = r16;
                            while (true) {
                                mediaCodec = this.p;
                                if (mediaCodec == null && this.J != i3 && !this.M) {
                                    if (this.D < 0) {
                                        int iDequeueInputBuffer = mediaCodec.dequeueInputBuffer(0L);
                                        this.D = iDequeueInputBuffer;
                                        if (iDequeueInputBuffer >= 0) {
                                            com.smartdigimkt.l0.e eVar2 = this.j;
                                            if (u.a >= i2) {
                                                inputBuffer = this.p.getInputBuffer(iDequeueInputBuffer);
                                            } else {
                                                inputBuffer = this.A[iDequeueInputBuffer];
                                            }
                                            eVar2.b = inputBuffer;
                                            this.j.a();
                                        }
                                    }
                                    if (this.J == i4) {
                                        if (!this.u) {
                                            this.L = i4;
                                            this.p.queueInputBuffer(this.D, 0, 0, 0L, 4);
                                            p();
                                        }
                                        this.J = 2;
                                    } else {
                                        if (this.y) {
                                            this.y = false;
                                            ByteBuffer byteBuffer = this.j.b;
                                            byte[] bArr = Q;
                                            byteBuffer.put(bArr);
                                            this.p.queueInputBuffer(this.D, 0, bArr.length, 0L, 0);
                                            p();
                                            this.K = i4;
                                            r15 = i4;
                                        } else {
                                            if (this.I == i4) {
                                                for (int i5 = 0; i5 < this.o.h.size(); i5++) {
                                                    this.j.b.put((byte[]) this.o.h.get(i5));
                                                }
                                                this.I = 2;
                                            }
                                            int iPosition = this.j.b.position();
                                            int iA2 = a(this.l, this.j, false);
                                            if (iA2 != -3) {
                                                if (iA2 == -5) {
                                                    if (this.I == 2) {
                                                        this.j.a();
                                                        this.I = i4;
                                                    }
                                                    b(this.l.a);
                                                    r15 = i4;
                                                } else if (this.j.b(4)) {
                                                    if (this.I == 2) {
                                                        this.j.a();
                                                        this.I = i4;
                                                    }
                                                    this.M = i4;
                                                    if (!this.K) {
                                                        m();
                                                    } else {
                                                        try {
                                                            if (!this.u) {
                                                                this.L = i4;
                                                                this.p.queueInputBuffer(this.D, 0, 0, 0L, 4);
                                                                p();
                                                            }
                                                        } catch (Exception e) {
                                                            throw new com.smartdigimkt.i0.g(i4, e);
                                                        }
                                                    }
                                                } else if (this.O && !this.j.b(i4)) {
                                                    this.j.a();
                                                    if (this.I == 2) {
                                                        this.I = i4;
                                                    }
                                                    i3 = 2;
                                                } else {
                                                    this.O = false;
                                                    boolean zB = this.j.b(C.ENCODING_PCM_32BIT);
                                                    if (this.s && !zB) {
                                                        ByteBuffer byteBuffer2 = this.j.b;
                                                        int iPosition2 = byteBuffer2.position();
                                                        int i6 = 0;
                                                        int i7 = 0;
                                                        while (true) {
                                                            int i8 = i6 + 1;
                                                            if (i8 < iPosition2) {
                                                                int i9 = byteBuffer2.get(i6) & UByte.MAX_VALUE;
                                                                if (i7 == 3) {
                                                                    if (i9 == i4 && (byteBuffer2.get(i8) & 31) == 7) {
                                                                        ByteBuffer byteBufferDuplicate = byteBuffer2.duplicate();
                                                                        byteBufferDuplicate.position(i6 - 3);
                                                                        byteBufferDuplicate.limit(iPosition2);
                                                                        byteBuffer2.position(0);
                                                                        byteBuffer2.put(byteBufferDuplicate);
                                                                        break;
                                                                    }
                                                                } else if (i9 == 0) {
                                                                    i7++;
                                                                }
                                                                if (i9 != 0) {
                                                                    i7 = 0;
                                                                }
                                                                i6 = i8;
                                                            } else {
                                                                byteBuffer2.clear();
                                                                break;
                                                            }
                                                        }
                                                        if (this.j.b.position() != 0) {
                                                            this.s = false;
                                                            eVar = this.j;
                                                            j3 = eVar.c;
                                                            if (eVar.b(Integer.MIN_VALUE)) {
                                                                this.m.add(Long.valueOf(j3));
                                                            }
                                                            this.j.b.flip();
                                                            a(this.j);
                                                            if (zB) {
                                                                cryptoInfo = this.j.d.d;
                                                                if (iPosition != 0) {
                                                                    if (cryptoInfo.numBytesOfClearData == null) {
                                                                        cryptoInfo.numBytesOfClearData = new int[i4];
                                                                    }
                                                                    int[] iArr = cryptoInfo.numBytesOfClearData;
                                                                    iArr[0] = iArr[0] + iPosition;
                                                                }
                                                                this.p.queueSecureInputBuffer(this.D, 0, cryptoInfo, j3, 0);
                                                            } else {
                                                                this.p.queueInputBuffer(this.D, 0, this.j.b.limit(), j3, 0);
                                                            }
                                                            p();
                                                            this.K = i4;
                                                            this.I = 0;
                                                            this.P.getClass();
                                                        }
                                                    } else {
                                                        try {
                                                            eVar = this.j;
                                                            j3 = eVar.c;
                                                            if (eVar.b(Integer.MIN_VALUE)) {
                                                                this.m.add(Long.valueOf(j3));
                                                            }
                                                            this.j.b.flip();
                                                            a(this.j);
                                                            if (zB) {
                                                                cryptoInfo = this.j.d.d;
                                                                if (iPosition != 0) {
                                                                    if (cryptoInfo.numBytesOfClearData == null) {
                                                                        cryptoInfo.numBytesOfClearData = new int[i4];
                                                                    }
                                                                    int[] iArr2 = cryptoInfo.numBytesOfClearData;
                                                                    iArr2[0] = iArr2[0] + iPosition;
                                                                }
                                                                this.p.queueSecureInputBuffer(this.D, 0, cryptoInfo, j3, 0);
                                                            } else {
                                                                this.p.queueInputBuffer(this.D, 0, this.j.b.limit(), j3, 0);
                                                            }
                                                            p();
                                                            this.K = i4;
                                                            this.I = 0;
                                                            this.P.getClass();
                                                        } catch (Exception e2) {
                                                            throw new com.smartdigimkt.i0.g(i4, e2);
                                                        }
                                                    }
                                                    i3 = 2;
                                                    i2 = 21;
                                                }
                                            }
                                        }
                                        i3 = 2;
                                        i4 = r15;
                                        i4 = r16;
                                        mediaCodec = this.p;
                                        if (mediaCodec == null) {
                                        }
                                    }
                                }
                                com.smartdigimkt.z0.s.a();
                            }
                        } else {
                            this.E = iDequeueOutputBuffer;
                            if (u.a >= 21) {
                                outputBuffer = this.p.getOutputBuffer(iDequeueOutputBuffer);
                            } else {
                                outputBuffer = this.B[iDequeueOutputBuffer];
                            }
                            this.F = outputBuffer;
                            if (outputBuffer != null) {
                                outputBuffer.position(this.n.offset);
                                ByteBuffer byteBuffer3 = this.F;
                                MediaCodec.BufferInfo bufferInfo2 = this.n;
                                byteBuffer3.limit(bufferInfo2.offset + bufferInfo2.size);
                            }
                            long j4 = this.n.presentationTimeUs;
                            int size = this.m.size();
                            ?? r3 = z3;
                            while (true) {
                                if (r3 >= size) {
                                    z2 = z3;
                                    break;
                                } else {
                                    if (((Long) this.m.get(r3)).longValue() == j4) {
                                        this.m.remove(r3);
                                        z2 = r12 == true ? 1 : 0;
                                        break;
                                    }
                                    r3++;
                                }
                            }
                            this.G = z2;
                        }
                    }
                }
                if (this.w && this.L) {
                    try {
                        MediaCodec mediaCodec2 = this.p;
                        ByteBuffer byteBuffer4 = this.F;
                        int i10 = this.E;
                        MediaCodec.BufferInfo bufferInfo3 = this.n;
                        int i11 = bufferInfo3.flags;
                        long j5 = bufferInfo3.presentationTimeUs;
                        boolean z4 = this.G;
                        i = 21;
                        z = r12 == true ? 1 : 0;
                        try {
                            zA = a(j, j2, mediaCodec2, byteBuffer4, i10, i11, j5, z4);
                            z = z;
                        } catch (IllegalStateException unused2) {
                            m();
                            if (this.N) {
                                n();
                            }
                        }
                    } catch (IllegalStateException unused3) {
                        i = 21;
                        z = r12 == true ? 1 : 0;
                    }
                } else {
                    i = 21;
                    z = r12 == true ? 1 : 0;
                    MediaCodec mediaCodec3 = this.p;
                    ByteBuffer byteBuffer5 = this.F;
                    int i12 = this.E;
                    MediaCodec.BufferInfo bufferInfo4 = this.n;
                    zA = a(j, j2, mediaCodec3, byteBuffer5, i12, bufferInfo4.flags, bufferInfo4.presentationTimeUs, this.G);
                }
                if (zA) {
                    a(this.n.presentationTimeUs);
                    boolean z5 = (this.n.flags & 4) != 0 ? z : false;
                    this.E = -1;
                    this.F = null;
                    r14 = z;
                    if (z5) {
                        m();
                    }
                    r14 = r16;
                    r12 = r14;
                    z3 = false;
                }
                i2 = i;
                r15 = z;
                i3 = 2;
                i4 = r15;
                i4 = r16;
                while (true) {
                    mediaCodec = this.p;
                    if (mediaCodec == null) {
                    }
                    com.smartdigimkt.z0.s.a();
                }
            }
        } else {
            this.P.getClass();
            this.d.a(j - this.f);
            this.k.a();
            int iA3 = a(this.l, this.k, false);
            if (iA3 == -5) {
                b(this.l.a);
            } else if (iA3 == -4) {
                if (this.k.b(4)) {
                    this.M = true;
                    m();
                } else {
                    throw new IllegalStateException();
                }
            }
        }
        synchronized (this.P) {
        }
    }
}
