package com.anythink.basead.exoplayer.j.a;

import android.net.Uri;
import com.anythink.basead.exoplayer.k.af;
import com.anythink.basead.exoplayer.k.v;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class f {
    public static final int a = 131072;

    public static class a {
        public volatile long a;
        public volatile long b;
        public volatile long c = -1;

        private long a() {
            return this.a + this.b;
        }
    }

    private static String a(Uri uri) {
        return uri.toString();
    }

    public static String a(com.anythink.basead.exoplayer.j.k kVar) {
        return kVar.h != null ? kVar.h : kVar.c.toString();
    }

    private static void a(com.anythink.basead.exoplayer.j.k kVar, com.anythink.basead.exoplayer.j.a.a aVar, a aVar2) {
        String strA = a(kVar);
        long j = kVar.e;
        long jB = kVar.g != -1 ? kVar.g : aVar.b(strA);
        aVar2.c = jB;
        aVar2.a = 0L;
        aVar2.b = 0L;
        long j2 = j;
        long j3 = jB;
        while (j3 != 0) {
            long jB2 = aVar.b(strA, j2, j3 != -1 ? j3 : Long.MAX_VALUE);
            if (jB2 > 0) {
                aVar2.a += jB2;
            } else {
                jB2 = -jB2;
                if (jB2 == Long.MAX_VALUE) {
                    return;
                }
            }
            j2 += jB2;
            if (j3 == -1) {
                jB2 = 0;
            }
            j3 -= jB2;
        }
    }

    private static void a(com.anythink.basead.exoplayer.j.k kVar, com.anythink.basead.exoplayer.j.a.a aVar, com.anythink.basead.exoplayer.j.h hVar, a aVar2, AtomicBoolean atomicBoolean) throws InterruptedException {
        a aVar3;
        long j;
        c cVar = new c(aVar, hVar);
        byte[] bArr = new byte[131072];
        com.anythink.basead.exoplayer.k.a.a(cVar);
        com.anythink.basead.exoplayer.k.a.a(bArr);
        if (aVar2 == null) {
            aVar3 = new a();
        } else {
            String strA = a(kVar);
            long j2 = kVar.e;
            long jB = kVar.g != -1 ? kVar.g : aVar.b(strA);
            aVar2.c = jB;
            aVar2.a = 0L;
            aVar2.b = 0L;
            long j3 = j2;
            long j4 = jB;
            while (j4 != 0) {
                String str = strA;
                long jB2 = aVar.b(strA, j3, j4 != -1 ? j4 : Long.MAX_VALUE);
                if (jB2 <= 0) {
                    jB2 = -jB2;
                    if (jB2 == Long.MAX_VALUE) {
                        break;
                    }
                } else {
                    aVar2.a += jB2;
                }
                j3 += jB2;
                if (j4 == -1) {
                    jB2 = 0;
                }
                j4 -= jB2;
                strA = str;
            }
            aVar3 = aVar2;
        }
        String strA2 = a(kVar);
        long j5 = kVar.e;
        long jB3 = kVar.g != -1 ? kVar.g : aVar.b(strA2);
        for (long j6 = 0; jB3 != j6; j6 = j6) {
            if (atomicBoolean != null && atomicBoolean.get()) {
                throw new InterruptedException();
            }
            long jB4 = aVar.b(strA2, j5, jB3 != -1 ? jB3 : Long.MAX_VALUE);
            if (jB4 <= j6) {
                long j7 = -jB4;
                if (a(kVar, j5, j7, cVar, bArr, (v) null, aVar3) < j7) {
                    return;
                } else {
                    j = j7;
                }
            } else {
                j = jB4;
            }
            j5 += j;
            if (jB3 == -1) {
                j = j6;
            }
            jB3 -= j;
            strA2 = strA2;
        }
    }

    private static void a(com.anythink.basead.exoplayer.j.k kVar, com.anythink.basead.exoplayer.j.a.a aVar, c cVar, byte[] bArr, v vVar, a aVar2, AtomicBoolean atomicBoolean) throws InterruptedException {
        a aVar3;
        long j;
        com.anythink.basead.exoplayer.k.a.a(cVar);
        com.anythink.basead.exoplayer.k.a.a(bArr);
        if (aVar2 == null) {
            aVar3 = new a();
        } else {
            String strA = a(kVar);
            long j2 = kVar.e;
            long jB = kVar.g != -1 ? kVar.g : aVar.b(strA);
            aVar2.c = jB;
            aVar2.a = 0L;
            aVar2.b = 0L;
            long j3 = j2;
            long j4 = jB;
            while (j4 != 0) {
                long jB2 = aVar.b(strA, j3, j4 != -1 ? j4 : Long.MAX_VALUE);
                if (jB2 <= 0) {
                    jB2 = -jB2;
                    if (jB2 == Long.MAX_VALUE) {
                        break;
                    }
                } else {
                    aVar2.a += jB2;
                }
                j3 += jB2;
                if (j4 == -1) {
                    jB2 = 0;
                }
                j4 -= jB2;
            }
            aVar3 = aVar2;
        }
        String strA2 = a(kVar);
        long j5 = kVar.e;
        long jB3 = kVar.g != -1 ? kVar.g : aVar.b(strA2);
        for (long j6 = 0; jB3 != j6; j6 = j6) {
            if (atomicBoolean != null && atomicBoolean.get()) {
                throw new InterruptedException();
            }
            long jB4 = aVar.b(strA2, j5, jB3 != -1 ? jB3 : Long.MAX_VALUE);
            if (jB4 <= j6) {
                long j7 = -jB4;
                if (a(kVar, j5, j7, cVar, bArr, vVar, aVar3) < j7) {
                    return;
                } else {
                    j = j7;
                }
            } else {
                j = jB4;
            }
            j5 += j;
            if (jB3 == -1) {
                j = j6;
            }
            jB3 -= j;
            strA2 = strA2;
        }
    }

    private static long a(com.anythink.basead.exoplayer.j.k kVar, long j, long j2, com.anythink.basead.exoplayer.j.h hVar, byte[] bArr, v vVar, a aVar) {
        int length;
        com.anythink.basead.exoplayer.j.k kVar2 = kVar;
        while (true) {
            if (vVar != null) {
                vVar.b();
            }
            try {
                try {
                    if (Thread.interrupted()) {
                        throw new InterruptedException();
                    }
                    com.anythink.basead.exoplayer.j.k kVar3 = new com.anythink.basead.exoplayer.j.k(kVar2.c, kVar2.d, j, (kVar2.f + j) - kVar2.e, -1L, kVar2.h, kVar2.i | 2);
                    try {
                        long jA = hVar.a(kVar3);
                        if (aVar.c == -1 && jA != -1) {
                            aVar.c = kVar3.e + jA;
                        }
                        long j3 = 0;
                        while (j3 != j2) {
                            if (Thread.interrupted()) {
                                throw new InterruptedException();
                            }
                            if (j2 != -1) {
                                length = (int) Math.min(bArr.length, j2 - j3);
                            } else {
                                length = bArr.length;
                            }
                            int iA = hVar.a(bArr, 0, length);
                            if (iA == -1) {
                                if (aVar.c != -1) {
                                    break;
                                }
                                aVar.c = kVar3.e + j3;
                                break;
                            }
                            long j4 = iA;
                            j3 += j4;
                            aVar.b += j4;
                        }
                        af.a(hVar);
                        return j3;
                    } catch (v.a unused) {
                        kVar2 = kVar3;
                    }
                } catch (v.a unused2) {
                }
            } catch (Throwable th) {
                af.a(hVar);
                throw th;
            }
            af.a(hVar);
        }
    }

    private static void a(com.anythink.basead.exoplayer.j.a.a aVar, String str) {
        Iterator<e> it = aVar.a(str).iterator();
        while (it.hasNext()) {
            try {
                aVar.b(it.next());
            } catch (com.anythink.basead.exoplayer.j.a.a.C0036a unused) {
            }
        }
    }

    private f() {
    }
}
