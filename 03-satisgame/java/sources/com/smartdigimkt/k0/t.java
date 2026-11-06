package com.smartdigimkt.k0;

import android.media.AudioTrack;
import android.os.SystemClock;
import com.bykv.vk.component.ttvideo.player.C;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public final class t {
    public final z a;
    public final long[] b;
    public AudioTrack c;
    public int d;
    public int e;
    public s f;
    public int g;
    public boolean h;
    public long i;
    public long j;
    public long k;
    public Method l;
    public long m;
    public boolean n;
    public boolean o;
    public long p;
    public long q;
    public long r;
    public long s;
    public int t;
    public int u;
    public long v;
    public long w;
    public long x;
    public long y;

    public t(z zVar) {
        this.a = zVar;
        if (com.smartdigimkt.z0.u.a >= 18) {
            try {
                this.l = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.b = new long[10];
    }

    public final long a(boolean z) {
        Method method;
        if (this.c.getPlayState() == 3) {
            long jA = a(a());
            if (jA != 0) {
                long jNanoTime = System.nanoTime() / 1000;
                if (jNanoTime - this.k >= 30000) {
                    long[] jArr = this.b;
                    int i = this.t;
                    jArr[i] = jA - jNanoTime;
                    this.t = (i + 1) % 10;
                    int i2 = this.u;
                    if (i2 < 10) {
                        this.u = i2 + 1;
                    }
                    this.k = jNanoTime;
                    this.j = 0L;
                    int i3 = 0;
                    while (true) {
                        int i4 = this.u;
                        if (i3 >= i4) {
                            break;
                        }
                        this.j = (this.b[i3] / ((long) i4)) + this.j;
                        i3++;
                    }
                }
                if (!this.h) {
                    s sVar = this.f;
                    r rVar = sVar.a;
                    if (rVar != null && jNanoTime - sVar.e >= sVar.d) {
                        sVar.e = jNanoTime;
                        boolean zB = rVar.b();
                        int i5 = sVar.b;
                        if (i5 != 0) {
                            if (i5 != 1) {
                                if (i5 != 2) {
                                    if (i5 != 3) {
                                        if (i5 != 4) {
                                            throw new IllegalStateException();
                                        }
                                    } else if (zB) {
                                        sVar.a();
                                    }
                                } else if (!zB) {
                                    sVar.a();
                                }
                            } else if (!zB) {
                                sVar.a();
                            } else if (sVar.a.e > sVar.f) {
                                sVar.a(2);
                            }
                        } else if (zB) {
                            if (sVar.a.a() >= sVar.c) {
                                sVar.f = sVar.a.e;
                                sVar.a(1);
                            }
                        } else if (jNanoTime - sVar.c > 500000) {
                            sVar.a(3);
                        }
                        if (zB) {
                            r rVar2 = this.f.a;
                            long jA2 = rVar2 != null ? rVar2.a() : -9223372036854775807L;
                            r rVar3 = this.f.a;
                            long j = rVar3 != null ? rVar3.e : -1L;
                            if (Math.abs(jA2 - jNanoTime) > 5000000) {
                                z zVar = this.a;
                                zVar.getClass();
                                a0 a0Var = zVar.a;
                                if (a0Var.l) {
                                    long j2 = a0Var.C / ((long) a0Var.B);
                                }
                                a0Var.b();
                                this.f.a(4);
                            } else if (Math.abs(a(j) - jA) > 5000000) {
                                z zVar2 = this.a;
                                zVar2.getClass();
                                a0 a0Var2 = zVar2.a;
                                if (a0Var2.l) {
                                    long j3 = a0Var2.C / ((long) a0Var2.B);
                                }
                                a0Var2.b();
                                this.f.a(4);
                            } else {
                                s sVar2 = this.f;
                                if (sVar2.b == 4) {
                                    sVar2.a();
                                }
                            }
                        }
                    }
                    if (this.o && (method = this.l) != null && jNanoTime - this.p >= 500000) {
                        try {
                            long jIntValue = (((long) ((Integer) method.invoke(this.c, null)).intValue()) * 1000) - this.i;
                            this.m = jIntValue;
                            long jMax = Math.max(jIntValue, 0L);
                            this.m = jMax;
                            if (jMax > 5000000) {
                                this.a.getClass();
                                this.m = 0L;
                            }
                        } catch (Exception unused) {
                            this.l = null;
                        }
                        this.p = jNanoTime;
                    }
                }
            }
        }
        long jNanoTime2 = System.nanoTime() / 1000;
        s sVar3 = this.f;
        int i6 = sVar3.b;
        if (i6 != 1 && i6 != 2) {
            long jA3 = this.u == 0 ? a(a()) : jNanoTime2 + this.j;
            return !z ? jA3 - this.m : jA3;
        }
        r rVar4 = sVar3.a;
        long jA4 = a(rVar4 != null ? rVar4.e : -1L);
        s sVar4 = this.f;
        if (sVar4.b != 2) {
            return jA4;
        }
        r rVar5 = sVar4.a;
        return (jNanoTime2 - (rVar5 != null ? rVar5.a() : -9223372036854775807L)) + jA4;
    }

    public final boolean b(long j) {
        return j > a() || (this.h && this.c.getPlayState() == 2 && a() == 0);
    }

    public final long a(long j) {
        return (j * C.MICROS_PER_SECOND) / ((long) this.g);
    }

    public final long a() {
        if (this.v != -9223372036854775807L) {
            return Math.min(this.y, this.x + ((((SystemClock.elapsedRealtime() * 1000) - this.v) * ((long) this.g)) / C.MICROS_PER_SECOND));
        }
        int playState = this.c.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = ((long) this.c.getPlaybackHeadPosition()) & 4294967295L;
        if (this.h) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.s = this.q;
            }
            playbackHeadPosition += this.s;
        }
        if (com.smartdigimkt.z0.u.a <= 28) {
            if (playbackHeadPosition == 0 && this.q > 0 && playState == 3) {
                if (this.w == -9223372036854775807L) {
                    this.w = SystemClock.elapsedRealtime();
                }
                return this.q;
            }
            this.w = -9223372036854775807L;
        }
        if (this.q > playbackHeadPosition) {
            this.r++;
        }
        this.q = playbackHeadPosition;
        return playbackHeadPosition + (this.r << 32);
    }
}
