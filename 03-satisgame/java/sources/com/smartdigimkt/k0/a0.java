package com.smartdigimkt.k0;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 implements q {
    public int A;
    public int B;
    public long C;
    public long D;
    public int E;
    public long F;
    public long G;
    public int H;
    public int I;
    public long J;
    public float K;
    public e[] L;
    public ByteBuffer[] M;
    public ByteBuffer N;
    public ByteBuffer O;
    public byte[] P;
    public int Q;
    public int R;
    public boolean S;
    public boolean T;
    public int U;
    public boolean V;
    public long W;
    public final c a;
    public final w b;
    public final u c;
    public final i0 d;
    public final e[] e;
    public final e[] f;
    public final ConditionVariable g;
    public final t h;
    public final ArrayDeque i;
    public c0 j;
    public AudioTrack k;
    public boolean l;
    public boolean m;
    public int n;
    public int o;
    public int p;
    public int q;
    public b r;
    public boolean s;
    public boolean t;
    public int u;
    public com.smartdigimkt.i0.a0 v;
    public com.smartdigimkt.i0.a0 w;
    public long x;
    public long y;
    public ByteBuffer z;

    public a0(c cVar, e[] eVarArr) {
        x xVar = new x(eVarArr);
        this.a = cVar;
        this.b = xVar;
        this.g = new ConditionVariable(true);
        this.h = new t(new z(this));
        u uVar = new u();
        this.c = uVar;
        i0 i0Var = new i0();
        this.d = i0Var;
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new e0(), uVar, i0Var);
        Collections.addAll(arrayList, xVar.a);
        this.e = (e[]) arrayList.toArray(new e[arrayList.size()]);
        this.f = new e[]{new b0()};
        this.K = 1.0f;
        this.I = 0;
        this.r = b.b;
        this.U = 0;
        this.w = com.smartdigimkt.i0.a0.e;
        this.R = -1;
        this.L = new e[0];
        this.M = new ByteBuffer[0];
        this.i = new ArrayDeque();
    }

    public final boolean a(int i) {
        if (com.smartdigimkt.z0.u.a(i)) {
            return i != 4 || com.smartdigimkt.z0.u.a >= 21;
        }
        c cVar = this.a;
        return cVar != null && Arrays.binarySearch(cVar.a, i) >= 0;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:45:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:46:0x00d8  */
    public final void b(ByteBuffer byteBuffer, long j) throws p {
        int iWrite;
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.O;
            int iWrite2 = 0;
            if (byteBuffer2 == null) {
                this.O = byteBuffer;
                if (com.smartdigimkt.z0.u.a < 21) {
                    int iRemaining = byteBuffer.remaining();
                    byte[] bArr = this.P;
                    if (bArr == null || bArr.length < iRemaining) {
                        this.P = new byte[iRemaining];
                    }
                    int iPosition = byteBuffer.position();
                    byteBuffer.get(this.P, 0, iRemaining);
                    byteBuffer.position(iPosition);
                    this.Q = 0;
                }
            } else if (byteBuffer2 != byteBuffer) {
                throw new IllegalArgumentException();
            }
            int iRemaining2 = byteBuffer.remaining();
            if (com.smartdigimkt.z0.u.a < 21) {
                t tVar = this.h;
                int iA = tVar.e - ((int) (this.F - (tVar.a() * ((long) tVar.d))));
                if (iA > 0) {
                    iWrite2 = this.k.write(this.P, this.Q, Math.min(iRemaining2, iA));
                    if (iWrite2 > 0) {
                        this.Q += iWrite2;
                        byteBuffer.position(byteBuffer.position() + iWrite2);
                    }
                }
            } else if (!this.V) {
                iWrite2 = this.k.write(byteBuffer, iRemaining2, 1);
            } else {
                if (j == -9223372036854775807L) {
                    throw new IllegalStateException();
                }
                AudioTrack audioTrack = this.k;
                if (this.z == null) {
                    ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
                    this.z = byteBufferAllocate;
                    byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
                    this.z.putInt(1431633921);
                }
                if (this.A == 0) {
                    this.z.putInt(4, iRemaining2);
                    this.z.putLong(8, j * 1000);
                    this.z.position(0);
                    this.A = iRemaining2;
                }
                int iRemaining3 = this.z.remaining();
                if (iRemaining3 <= 0) {
                    iWrite = audioTrack.write(byteBuffer, iRemaining2, 1);
                    if (iWrite < 0) {
                        this.A = 0;
                    } else {
                        this.A -= iWrite;
                    }
                    iWrite2 = iWrite;
                } else {
                    int iWrite3 = audioTrack.write(this.z, iRemaining3, 1);
                    if (iWrite3 < 0) {
                        this.A = 0;
                        iWrite2 = iWrite3;
                    } else if (iWrite3 >= iRemaining3) {
                        iWrite = audioTrack.write(byteBuffer, iRemaining2, 1);
                        if (iWrite < 0) {
                            this.A = 0;
                        } else {
                            this.A -= iWrite;
                        }
                        iWrite2 = iWrite;
                    }
                }
            }
            this.W = SystemClock.elapsedRealtime();
            if (iWrite2 < 0) {
                throw new p(iWrite2);
            }
            boolean z = this.l;
            if (z) {
                this.F += (long) iWrite2;
            }
            if (iWrite2 == iRemaining2) {
                if (!z) {
                    this.G += (long) this.H;
                }
                this.O = null;
            }
        }
    }

    public final boolean c() {
        return this.k != null;
    }

    public final void d() {
        this.T = false;
        if (c()) {
            t tVar = this.h;
            tVar.j = 0L;
            tVar.u = 0;
            tVar.t = 0;
            tVar.k = 0L;
            if (tVar.v == -9223372036854775807L) {
                tVar.f.a();
                this.k.pause();
            }
        }
    }

    public final void e() {
        this.T = true;
        if (c()) {
            this.h.f.a();
            this.k.play();
        }
    }

    public final void f() {
        if (!this.S && c() && a()) {
            t tVar = this.h;
            long jB = b();
            tVar.x = tVar.a();
            tVar.v = SystemClock.elapsedRealtime() * 1000;
            tVar.y = jB;
            this.k.stop();
            this.A = 0;
            this.S = true;
        }
    }

    public final void g() {
        if (c()) {
            this.C = 0L;
            this.D = 0L;
            this.F = 0L;
            this.G = 0L;
            this.H = 0;
            com.smartdigimkt.i0.a0 a0Var = this.v;
            if (a0Var != null) {
                this.w = a0Var;
                this.v = null;
            } else if (!this.i.isEmpty()) {
                this.w = ((y) this.i.getLast()).a;
            }
            this.i.clear();
            this.x = 0L;
            this.y = 0L;
            this.N = null;
            this.O = null;
            int i = 0;
            while (true) {
                e[] eVarArr = this.L;
                if (i >= eVarArr.length) {
                    break;
                }
                e eVar = eVarArr[i];
                eVar.flush();
                this.M[i] = eVar.a();
                i++;
            }
            this.S = false;
            this.R = -1;
            this.z = null;
            this.A = 0;
            this.I = 0;
            if (this.h.c.getPlayState() == 3) {
                this.k.pause();
            }
            AudioTrack audioTrack = this.k;
            this.k = null;
            t tVar = this.h;
            tVar.j = 0L;
            tVar.u = 0;
            tVar.t = 0;
            tVar.k = 0L;
            tVar.c = null;
            tVar.f = null;
            this.g.close();
            new v(this, audioTrack).start();
        }
    }

    public final void h() {
        if (c()) {
            if (com.smartdigimkt.z0.u.a >= 21) {
                this.k.setVolume(this.K);
                return;
            }
            AudioTrack audioTrack = this.k;
            float f = this.K;
            audioTrack.setStereoVolume(f, f);
        }
    }

    public final long a(boolean z) {
        long j;
        long jA;
        if (!c() || this.I == 0) {
            return Long.MIN_VALUE;
        }
        long jMin = Math.min(this.h.a(z), (b() * C.MICROS_PER_SECOND) / ((long) this.o));
        long j2 = this.J;
        y yVar = null;
        while (!this.i.isEmpty() && jMin >= ((y) this.i.getFirst()).c) {
            yVar = (y) this.i.remove();
        }
        if (yVar != null) {
            this.w = yVar.a;
            this.y = yVar.c;
            this.x = yVar.b - this.J;
        }
        if (this.w.a == 1.0f) {
            j = (jMin + this.x) - this.y;
        } else if (this.i.isEmpty()) {
            long j3 = this.x;
            w wVar = this.b;
            long j4 = jMin - this.y;
            h0 h0Var = ((x) wVar).c;
            long j5 = h0Var.m;
            if (j5 >= com.anythink.china.a.c.k) {
                int i = h0Var.f;
                int i2 = h0Var.c;
                if (i == i2) {
                    jA = com.smartdigimkt.z0.u.a(j4, h0Var.l, j5);
                } else {
                    jA = com.smartdigimkt.z0.u.a(j4, h0Var.l * ((long) i), j5 * ((long) i2));
                }
            } else {
                jA = (long) (((double) h0Var.d) * j4);
            }
            j = jA + j3;
        } else {
            long j6 = this.x;
            long jRound = jMin - this.y;
            float f = this.w.a;
            int i3 = com.smartdigimkt.z0.u.a;
            if (f != 1.0f) {
                jRound = Math.round(jRound * ((double) f));
            }
            j = jRound + j6;
        }
        return ((((x) this.b).b.o * C.MICROS_PER_SECOND) / ((long) this.o)) + j + j2;
    }

    /* JADX WARN: Code duplicated, block: B:56:0x00be  */
    public final void a(int i, int i2, int i3, int[] iArr, int i4, int i5) throws n {
        this.n = i3;
        boolean zA = com.smartdigimkt.z0.u.a(i);
        this.l = zA;
        int i6 = 0;
        this.m = false;
        if (zA) {
            this.B = com.smartdigimkt.z0.u.a(i, i2);
        }
        int i7 = 4;
        boolean z = this.l && i != 4;
        this.t = z && !this.m;
        if (z) {
            i0 i0Var = this.d;
            i0Var.c = i4;
            i0Var.d = i5;
            this.c.d = iArr;
            e[] eVarArr = this.m ? this.f : this.e;
            int length = eVarArr.length;
            int i8 = 0;
            while (i6 < length) {
                e eVar = eVarArr[i6];
                try {
                    i8 |= eVar.a(i3, i2, i) ? 1 : 0;
                    if (eVar.b()) {
                        i2 = eVar.f();
                        i3 = eVar.c();
                        i = eVar.d();
                    }
                    i6++;
                } catch (d e) {
                    throw new n(e);
                }
            }
            i6 = i8;
        }
        int i9 = MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF;
        switch (i2) {
            case 1:
                break;
            case 2:
                i7 = 12;
                break;
            case 3:
                i7 = 28;
                break;
            case 4:
                i7 = 204;
                break;
            case 5:
                i7 = MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM;
                break;
            case 6:
                i7 = 252;
                break;
            case 7:
                i7 = 1276;
                break;
            case 8:
                i7 = com.smartdigimkt.i0.b.a;
                break;
            default:
                throw new n("Unsupported channel count: " + i2);
        }
        int i10 = com.smartdigimkt.z0.u.a;
        if (i10 > 23 || !"foster".equals(com.smartdigimkt.z0.u.b) || !"NVIDIA".equals(com.smartdigimkt.z0.u.c)) {
            i9 = i7;
        } else if (i2 != 3 && i2 != 5) {
            if (i2 != 7) {
                i9 = i7;
            } else {
                i9 = com.smartdigimkt.i0.b.a;
            }
        }
        int i11 = (i10 > 25 || !"fugu".equals(com.smartdigimkt.z0.u.b) || this.l || i2 != 1) ? i9 : 12;
        if (i6 == 0 && c() && this.q == i && this.o == i3 && this.p == i11) {
            return;
        }
        g();
        this.s = z;
        this.o = i3;
        this.p = i11;
        this.q = i;
        this.E = this.l ? com.smartdigimkt.z0.u.a(i, i2) : -1;
        if (this.l) {
            int minBufferSize = AudioTrack.getMinBufferSize(i3, i11, this.q);
            if (minBufferSize != -2) {
                long j = this.o;
                int i12 = (int) ((250000 * j) / C.MICROS_PER_SECOND);
                int i13 = this.E;
                this.u = Math.max(i12 * i13, Math.min(minBufferSize * 4, (int) Math.max(minBufferSize, ((j * 750000) / C.MICROS_PER_SECOND) * ((long) i13))));
                return;
            }
            throw new IllegalStateException();
        }
        int i14 = this.q;
        if (i14 == 5 || i14 == 6) {
            this.u = 20480;
        } else if (i14 == 7) {
            this.u = 49152;
        } else {
            this.u = 294912;
        }
    }

    public final long b() {
        return this.l ? this.F / ((long) this.E) : this.G;
    }

    /* JADX WARN: Code duplicated, block: B:138:0x0300  */
    /* JADX WARN: Code duplicated, block: B:140:0x030b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:141:0x030d  */
    /* JADX WARN: Code duplicated, block: B:143:0x0311  */
    /* JADX WARN: Code duplicated, block: B:144:0x031f  */
    /* JADX WARN: Code duplicated, block: B:145:0x032e  */
    /* JADX WARN: Code duplicated, block: B:147:0x033f  */
    public final boolean a(ByteBuffer byteBuffer, long j) throws p, o {
        int i;
        int iPosition;
        byte b;
        int i2;
        byte b2;
        int i3;
        int i4;
        byte b3;
        int i5;
        z zVar;
        AudioTrack audioTrack;
        com.smartdigimkt.i0.a0 a0VarA;
        AudioAttributes audioAttributesBuild;
        ByteBuffer byteBuffer2 = this.N;
        if (byteBuffer2 != null && byteBuffer != byteBuffer2) {
            throw new IllegalArgumentException();
        }
        if (!c()) {
            this.g.block();
            int i6 = com.smartdigimkt.z0.u.a;
            if (i6 >= 21) {
                if (this.V) {
                    audioAttributesBuild = new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
                } else {
                    b bVar = this.r;
                    if (bVar.a == null) {
                        bVar.a = new AudioAttributes.Builder().setContentType(0).setFlags(0).setUsage(1).build();
                    }
                    audioAttributesBuild = bVar.a;
                }
                AudioAttributes audioAttributes = audioAttributesBuild;
                AudioFormat audioFormatBuild = new AudioFormat.Builder().setChannelMask(this.p).setEncoding(this.q).setSampleRate(this.o).build();
                int i7 = this.U;
                audioTrack = new AudioTrack(audioAttributes, audioFormatBuild, this.u, 1, i7 != 0 ? i7 : 0);
            } else {
                this.r.getClass();
                if (this.U == 0) {
                    audioTrack = new AudioTrack(3, this.o, this.p, this.q, this.u, 1);
                } else {
                    audioTrack = new AudioTrack(3, this.o, this.p, this.q, this.u, 1, this.U);
                }
            }
            int state = audioTrack.getState();
            if (state == 1) {
                this.k = audioTrack;
                int audioSessionId = audioTrack.getAudioSessionId();
                if (this.U != audioSessionId) {
                    this.U = audioSessionId;
                    c0 c0Var = this.j;
                    if (c0Var != null) {
                        l lVar = c0Var.a.S;
                        if (lVar.b != null) {
                            lVar.a.post(new k(lVar, audioSessionId));
                        }
                        c0Var.a.getClass();
                    }
                }
                if (this.t) {
                    a0VarA = ((x) this.b).a(this.w);
                } else {
                    a0VarA = com.smartdigimkt.i0.a0.e;
                }
                this.w = a0VarA;
                ArrayList arrayList = new ArrayList();
                for (e eVar : this.m ? this.f : this.e) {
                    if (eVar.b()) {
                        arrayList.add(eVar);
                    } else {
                        eVar.flush();
                    }
                }
                int size = arrayList.size();
                this.L = (e[]) arrayList.toArray(new e[size]);
                this.M = new ByteBuffer[size];
                int i8 = 0;
                while (true) {
                    e[] eVarArr = this.L;
                    if (i8 >= eVarArr.length) {
                        break;
                    }
                    e eVar2 = eVarArr[i8];
                    eVar2.flush();
                    this.M[i8] = eVar2.a();
                    i8++;
                }
                t tVar = this.h;
                AudioTrack audioTrack2 = this.k;
                int i9 = this.q;
                int i10 = this.E;
                int i11 = this.u;
                tVar.c = audioTrack2;
                tVar.d = i10;
                tVar.e = i11;
                tVar.f = new s(audioTrack2);
                tVar.g = audioTrack2.getSampleRate();
                tVar.h = i6 < 23 && (i9 == 5 || i9 == 6);
                boolean zA = com.smartdigimkt.z0.u.a(i9);
                tVar.o = zA;
                tVar.i = zA ? tVar.a(i11 / i10) : -9223372036854775807L;
                tVar.q = 0L;
                tVar.r = 0L;
                tVar.s = 0L;
                tVar.n = false;
                tVar.v = -9223372036854775807L;
                tVar.w = -9223372036854775807L;
                tVar.m = 0L;
                h();
                if (this.T) {
                    e();
                }
            } else {
                try {
                    audioTrack.release();
                } catch (Exception unused) {
                }
                throw new o(state, this.o, this.p, this.u);
            }
        }
        t tVar2 = this.h;
        long jB = b();
        int playState = tVar2.c.getPlayState();
        if (tVar2.h) {
            if (playState == 2) {
                tVar2.n = false;
                return false;
            }
            if (playState == 1 && tVar2.a() == 0) {
                return false;
            }
        }
        boolean z = tVar2.n;
        boolean zB = tVar2.b(jB);
        tVar2.n = zB;
        if (z && !zB && playState != 1 && (zVar = tVar2.a) != null) {
            int i12 = tVar2.e;
            long jB2 = com.smartdigimkt.i0.b.b(tVar2.i);
            if (zVar.a.j != null) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                a0 a0Var = zVar.a;
                long j2 = jElapsedRealtime - a0Var.W;
                c0 c0Var2 = a0Var.j;
                l lVar2 = c0Var2.a.S;
                if (lVar2.b != null) {
                    lVar2.a.post(new i(lVar2, i12, jB2, j2));
                }
                c0Var2.a.getClass();
            }
        }
        if (this.N == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (!this.l && this.H == 0) {
                int i13 = this.q;
                if (i13 == 7) {
                    iPosition = byteBuffer.position();
                    b = byteBuffer.get(iPosition);
                    if (b != -2) {
                        if (b != -1) {
                            i2 = (byteBuffer.get(iPosition + 4) & 7) << 4;
                            b3 = byteBuffer.get(iPosition + 7);
                        } else if (b != 31) {
                            i2 = (byteBuffer.get(iPosition + 4) & 1) << 6;
                            b2 = byteBuffer.get(iPosition + 5);
                        } else {
                            i2 = (byteBuffer.get(iPosition + 5) & 7) << 4;
                            b3 = byteBuffer.get(iPosition + 6);
                        }
                        i3 = b3 & 60;
                        i4 = (((i3 >> 2) | i2) + 1) * 32;
                    } else {
                        i2 = (byteBuffer.get(iPosition + 5) & 1) << 6;
                        b2 = byteBuffer.get(iPosition + 4);
                    }
                    i3 = b2 & 252;
                    i4 = (((i3 >> 2) | i2) + 1) * 32;
                } else if (i13 == 8) {
                    iPosition = byteBuffer.position();
                    b = byteBuffer.get(iPosition);
                    if (b != -2) {
                        if (b != -1) {
                            i2 = (byteBuffer.get(iPosition + 4) & 7) << 4;
                            b3 = byteBuffer.get(iPosition + 7);
                        } else if (b != 31) {
                            i2 = (byteBuffer.get(iPosition + 4) & 1) << 6;
                            b2 = byteBuffer.get(iPosition + 5);
                        } else {
                            i2 = (byteBuffer.get(iPosition + 5) & 7) << 4;
                            b3 = byteBuffer.get(iPosition + 6);
                        }
                        i3 = b3 & 60;
                        i4 = (((i3 >> 2) | i2) + 1) * 32;
                    } else {
                        i2 = (byteBuffer.get(iPosition + 5) & 1) << 6;
                        b2 = byteBuffer.get(iPosition + 4);
                    }
                    i3 = b2 & 252;
                    i4 = (((i3 >> 2) | i2) + 1) * 32;
                } else if (i13 == 5) {
                    i4 = 1536;
                } else if (i13 == 6) {
                    i4 = (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? a.a[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4] : 6) * 256;
                } else if (i13 == 14) {
                    int iPosition2 = byteBuffer.position();
                    int iLimit = byteBuffer.limit() - 10;
                    int i14 = iPosition2;
                    while (true) {
                        if (i14 > iLimit) {
                            i5 = -1;
                            break;
                        }
                        if ((byteBuffer.getInt(i14 + 4) & (-16777217)) == -1167101192) {
                            i5 = i14 - iPosition2;
                            break;
                        }
                        i14++;
                    }
                    i4 = i5 == -1 ? 0 : (40 << ((byteBuffer.get((byteBuffer.position() + i5) + ((byteBuffer.get((byteBuffer.position() + i5) + 7) & UByte.MAX_VALUE) == 187 ? 9 : 8)) >> 4) & 7)) * 16;
                } else {
                    throw new IllegalStateException("Unexpected audio encoding: " + i13);
                }
                this.H = i4;
                if (i4 == 0) {
                    return true;
                }
            }
            if (this.v != null) {
                if (!a()) {
                    return false;
                }
                com.smartdigimkt.i0.a0 a0Var2 = this.v;
                this.v = null;
                this.i.add(new y(((x) this.b).a(a0Var2), Math.max(0L, j), (b() * C.MICROS_PER_SECOND) / ((long) this.o)));
                ArrayList arrayList2 = new ArrayList();
                for (e eVar3 : this.m ? this.f : this.e) {
                    if (eVar3.b()) {
                        arrayList2.add(eVar3);
                    } else {
                        eVar3.flush();
                    }
                }
                int size2 = arrayList2.size();
                this.L = (e[]) arrayList2.toArray(new e[size2]);
                this.M = new ByteBuffer[size2];
                int i15 = 0;
                while (true) {
                    e[] eVarArr2 = this.L;
                    if (i15 >= eVarArr2.length) {
                        break;
                    }
                    e eVar4 = eVarArr2[i15];
                    eVar4.flush();
                    this.M[i15] = eVar4.a();
                    i15++;
                }
            }
            int i16 = this.I;
            if (i16 == 0) {
                this.J = Math.max(0L, j);
                this.I = 1;
            } else {
                long j3 = (((this.l ? this.C / ((long) this.B) : this.D) * C.MICROS_PER_SECOND) / ((long) this.n)) + this.J;
                if (i16 != 1 || Math.abs(j3 - j) <= 200000) {
                    i = 2;
                } else {
                    i = 2;
                    this.I = 2;
                }
                if (this.I == i) {
                    this.J = (j - j3) + this.J;
                    this.I = 1;
                    c0 c0Var3 = this.j;
                    if (c0Var3 != null) {
                        c0Var3.a.getClass();
                        c0Var3.a.e0 = true;
                    }
                }
            }
            if (this.l) {
                this.C += (long) byteBuffer.remaining();
            } else {
                this.D += (long) this.H;
            }
            this.N = byteBuffer;
        }
        if (this.s) {
            a(j);
        } else {
            b(this.N, j);
        }
        if (!this.N.hasRemaining()) {
            this.N = null;
            return true;
        }
        t tVar3 = this.h;
        long jB3 = b();
        if (tVar3.w == -9223372036854775807L || jB3 <= 0 || SystemClock.elapsedRealtime() - tVar3.w < 200) {
            return false;
        }
        g();
        return true;
    }

    public final void a(long j) throws p {
        ByteBuffer byteBuffer;
        int length = this.L.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.M[i - 1];
            } else {
                byteBuffer = this.N;
                if (byteBuffer == null) {
                    byteBuffer = e.a;
                }
            }
            if (i == length) {
                b(byteBuffer, j);
            } else {
                e eVar = this.L[i];
                eVar.a(byteBuffer);
                ByteBuffer byteBufferA = eVar.a();
                this.M[i] = byteBufferA;
                if (byteBufferA.hasRemaining()) {
                    i++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            } else {
                i--;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0021  */
    /* JADX WARN: Code duplicated, block: B:15:0x0025  */
    /* JADX WARN: Code duplicated, block: B:18:0x0031 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:19:0x0032  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0032 -> B:9:0x0012). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final boolean a() {
        /*
            r9 = this;
            int r0 = r9.R
            r1 = 1
            r2 = 0
            r3 = -1
            if (r0 != r3) goto L14
            boolean r0 = r9.s
            if (r0 == 0) goto Ld
            r0 = r2
            goto L10
        Ld:
            com.smartdigimkt.k0.e[] r0 = r9.L
            int r0 = r0.length
        L10:
            r9.R = r0
        L12:
            r0 = r1
            goto L15
        L14:
            r0 = r2
        L15:
            int r4 = r9.R
            com.smartdigimkt.k0.e[] r5 = r9.L
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L38
            r4 = r5[r4]
            if (r0 == 0) goto L28
            r4.e()
        L28:
            r9.a(r7)
            boolean r0 = r4.g()
            if (r0 != 0) goto L32
            return r2
        L32:
            int r0 = r9.R
            int r0 = r0 + r1
            r9.R = r0
            goto L12
        L38:
            java.nio.ByteBuffer r0 = r9.O
            if (r0 == 0) goto L44
            r9.b(r0, r7)
            java.nio.ByteBuffer r0 = r9.O
            if (r0 == 0) goto L44
            return r2
        L44:
            r9.R = r3
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.smartdigimkt.k0.a0.a():boolean");
    }

    public final com.smartdigimkt.i0.a0 a(com.smartdigimkt.i0.a0 a0Var) {
        if (c() && !this.t) {
            com.smartdigimkt.i0.a0 a0Var2 = com.smartdigimkt.i0.a0.e;
            this.w = a0Var2;
            return a0Var2;
        }
        com.smartdigimkt.i0.a0 a0Var3 = this.v;
        if (a0Var3 == null) {
            if (!this.i.isEmpty()) {
                a0Var3 = ((y) this.i.getLast()).a;
            } else {
                a0Var3 = this.w;
            }
        }
        if (!a0Var.equals(a0Var3)) {
            if (c()) {
                this.v = a0Var;
            } else {
                this.w = ((x) this.b).a(a0Var);
            }
        }
        return this.w;
    }
}
