package com.anythink.basead.exoplayer;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import com.anythink.basead.exoplayer.h.af;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class k implements Handler.Callback, e.a, com.anythink.basead.exoplayer.h.r.a, com.anythink.basead.exoplayer.h.s.b, com.anythink.basead.exoplayer.i.h.a, x.a {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    private static final String d = "ExoPlayerImplInternal";
    private static final int e = 0;
    private static final int f = 1;
    private static final int g = 2;
    private static final int h = 3;
    private static final int i = 4;
    private static final int j = 5;
    private static final int k = 6;
    private static final int l = 7;
    private static final int m = 8;
    private static final int n = 9;
    private static final int o = 10;
    private static final int p = 11;
    private static final int q = 12;
    private static final int r = 13;
    private static final int s = 14;
    private static final int t = 15;
    private static final int u = 10;
    private static final int v = 10;
    private static final int w = 1000;
    private static final long x = 500;
    private final com.anythink.basead.exoplayer.i.h A;
    private final com.anythink.basead.exoplayer.i.i B;
    private final p C;
    private final com.anythink.basead.exoplayer.k.k D;
    private final HandlerThread E;
    private final Handler F;
    private final h G;
    private final ae.b H;
    private final ae.a I;
    private final e L;
    private final ArrayList<b> N;
    private final com.anythink.basead.exoplayer.k.c O;
    private u R;
    private com.anythink.basead.exoplayer.h.s S;
    private y[] T;
    private boolean U;
    private boolean V;
    private boolean W;
    private int X;
    private boolean Y;
    private int Z;
    private d aa;
    private long ab;
    private int ac;
    private final y[] y;
    private final z[] z;
    private final s P = new s();
    private final long J = 0;
    private final boolean K = false;
    private ac Q = ac.e;
    private final c M = new c(0);

    @Override // com.anythink.basead.exoplayer.h.z.a
    public final /* synthetic */ void a(com.anythink.basead.exoplayer.h.z zVar) {
        this.D.a(10, (com.anythink.basead.exoplayer.h.r) zVar).sendToTarget();
    }

    public k(y[] yVarArr, com.anythink.basead.exoplayer.i.h hVar, com.anythink.basead.exoplayer.i.i iVar, p pVar, boolean z, int i2, boolean z2, Handler handler, h hVar2, com.anythink.basead.exoplayer.k.c cVar) {
        this.y = yVarArr;
        this.A = hVar;
        this.B = iVar;
        this.C = pVar;
        this.V = z;
        this.X = i2;
        this.Y = z2;
        this.F = handler;
        this.G = hVar2;
        this.O = cVar;
        this.R = new u(ae.a, -9223372036854775807L, af.a, iVar);
        this.z = new z[yVarArr.length];
        for (int i3 = 0; i3 < yVarArr.length; i3++) {
            yVarArr[i3].a(i3);
            this.z[i3] = yVarArr[i3].b();
        }
        this.L = new e(this, cVar);
        this.N = new ArrayList<>();
        this.T = new y[0];
        this.H = new ae.b();
        this.I = new ae.a();
        hVar.a((com.anythink.basead.exoplayer.i.h.a) this);
        HandlerThread handlerThread = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.E = handlerThread;
        handlerThread.start();
        this.D = cVar.a(handlerThread.getLooper(), this);
    }

    public final void a(com.anythink.basead.exoplayer.h.s sVar, boolean z, boolean z2) {
        this.D.a(z ? 1 : 0, z2 ? 1 : 0, sVar).sendToTarget();
    }

    public final void a(boolean z) {
        this.D.a(1, z ? 1 : 0).sendToTarget();
    }

    public final void a(int i2) {
        this.D.a(12, i2).sendToTarget();
    }

    public final void b(boolean z) {
        this.D.a(13, z ? 1 : 0).sendToTarget();
    }

    public final void a(ae aeVar, int i2, long j2) {
        this.D.a(3, new d(aeVar, i2, j2)).sendToTarget();
    }

    public final void b(v vVar) {
        this.D.a(4, vVar).sendToTarget();
    }

    public final void a(ac acVar) {
        this.D.a(5, acVar).sendToTarget();
    }

    public final void c(boolean z) {
        this.D.a(6, z ? 1 : 0).sendToTarget();
    }

    @Override // com.anythink.basead.exoplayer.x.a
    public final synchronized void a(x xVar) {
        if (this.U) {
            Log.w(d, "Ignoring messages sent after release.");
            xVar.a(false);
        } else {
            this.D.a(14, xVar).sendToTarget();
        }
    }

    public final synchronized void a() {
        if (!this.U && this.E.isAlive()) {
            this.D.b(7);
            long jA = 500;
            long jA2 = this.O.a() + 500;
            boolean z = false;
            while (!this.U && jA > 0) {
                try {
                    wait(jA);
                } catch (InterruptedException unused) {
                    z = true;
                }
                jA = jA2 - this.O.a();
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public final Looper b() {
        return this.E.getLooper();
    }

    @Override // com.anythink.basead.exoplayer.h.s.b
    public final void a(com.anythink.basead.exoplayer.h.s sVar, ae aeVar, Object obj) {
        this.D.a(8, new a(sVar, aeVar, obj)).sendToTarget();
    }

    @Override // com.anythink.basead.exoplayer.h.r.a
    public final void a(com.anythink.basead.exoplayer.h.r rVar) {
        this.D.a(9, rVar).sendToTarget();
    }

    private void b(com.anythink.basead.exoplayer.h.r rVar) {
        this.D.a(10, rVar).sendToTarget();
    }

    @Override // com.anythink.basead.exoplayer.i.h.a
    public final void c() {
        this.D.b(11);
    }

    @Override // com.anythink.basead.exoplayer.e.a
    public final void a(v vVar) {
        this.F.obtainMessage(1, vVar).sendToTarget();
        float f2 = vVar.b;
        for (q qVarE = this.P.e(); qVarE != null; qVarE = qVarE.i) {
            if (qVarE.k != null) {
                for (com.anythink.basead.exoplayer.i.f fVar : qVarE.k.c.a()) {
                    if (fVar != null) {
                        fVar.a(f2);
                    }
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:186:0x042d A[Catch: IOException -> 0x0562, g -> 0x0567, RuntimeException -> 0x0924, TRY_LEAVE, TryCatch #11 {RuntimeException -> 0x0924, blocks: (B:499:0x0915, B:50:0x00f9, B:51:0x010c, B:52:0x0113, B:54:0x0118, B:58:0x0123, B:60:0x012b, B:61:0x012d, B:63:0x0131, B:65:0x0137, B:66:0x013b, B:68:0x013f, B:69:0x0144, B:70:0x0147, B:74:0x0175, B:76:0x017b, B:71:0x0157, B:73:0x0160, B:79:0x018d, B:81:0x0199, B:82:0x01a5, B:84:0x01b1, B:86:0x0210, B:87:0x0220, B:88:0x0225, B:90:0x022f, B:92:0x024e, B:94:0x025c, B:97:0x026a, B:104:0x027f, B:105:0x0282, B:107:0x028b, B:110:0x0293, B:112:0x0297, B:114:0x02a0, B:115:0x02a5, B:119:0x02c6, B:120:0x02d0, B:122:0x02d8, B:124:0x02de, B:125:0x02e3, B:129:0x030e, B:134:0x031e, B:136:0x032e, B:138:0x0334, B:142:0x0345, B:143:0x034f, B:145:0x0357, B:147:0x0363, B:149:0x036a, B:151:0x0370, B:152:0x0375, B:155:0x037c, B:157:0x03a0, B:158:0x03ac, B:160:0x03b0, B:162:0x03ba, B:163:0x03c5, B:164:0x03ce, B:168:0x03d6, B:176:0x03f7, B:177:0x03ff, B:179:0x0409, B:181:0x0415, B:185:0x041d, B:186:0x042d, B:146:0x0361, B:191:0x043d, B:193:0x0442, B:197:0x0449, B:198:0x044f, B:199:0x0457, B:200:0x0462, B:202:0x0472, B:247:0x052c, B:249:0x053a, B:237:0x0513, B:233:0x0500, B:235:0x0510, B:251:0x053f, B:253:0x0550, B:255:0x0553, B:261:0x0561, B:204:0x0481, B:207:0x04a1, B:208:0x04a9, B:268:0x056c, B:270:0x0576, B:272:0x057a, B:273:0x057f, B:275:0x058e, B:277:0x059a, B:278:0x05a0, B:279:0x05d8, B:281:0x05e0, B:284:0x05e7, B:286:0x05ed, B:290:0x05f5, B:292:0x05fd, B:293:0x060a, B:296:0x0610, B:299:0x061c, B:300:0x061f, B:304:0x0628, B:305:0x065e, B:308:0x0665, B:310:0x066a, B:312:0x0672, B:314:0x0678, B:316:0x067e, B:317:0x0681, B:318:0x0684, B:320:0x0688, B:324:0x0691, B:326:0x0696, B:329:0x06a4, B:332:0x06ac, B:333:0x06af, B:338:0x06cc, B:340:0x06d1, B:343:0x06db, B:345:0x06e1, B:349:0x06f9, B:351:0x0703, B:354:0x070b, B:355:0x0719, B:356:0x071c, B:363:0x072a, B:365:0x0734, B:366:0x073c, B:368:0x0767, B:370:0x0770, B:374:0x0779, B:376:0x077f, B:378:0x0785, B:380:0x078f, B:382:0x0795, B:391:0x07a6, B:396:0x07b0, B:398:0x07b7, B:399:0x07ba, B:403:0x07c9, B:405:0x07d1, B:407:0x07d7, B:443:0x085c, B:445:0x0863, B:447:0x0869, B:448:0x0871, B:450:0x0875, B:454:0x0883, B:461:0x08a0, B:452:0x087c, B:455:0x0889, B:457:0x088e, B:459:0x0895, B:460:0x089b, B:408:0x07e0, B:410:0x07e7, B:412:0x07ec, B:428:0x0830, B:430:0x0838, B:414:0x07f3, B:417:0x07fb, B:421:0x080a, B:423:0x0814, B:431:0x083c, B:433:0x0843, B:435:0x0848, B:439:0x0851, B:441:0x0856, B:442:0x0859, B:462:0x08a5, B:468:0x08af, B:470:0x08b3, B:471:0x08ba, B:473:0x08c1, B:475:0x08c7, B:477:0x08cb, B:480:0x08d2, B:488:0x08e4, B:492:0x08ef, B:496:0x08f6, B:498:0x0907), top: B:527:0x0014 }] */
    /* JADX WARN: Code duplicated, block: B:188:0x0437  */
    /* JADX WARN: Code duplicated, block: B:245:0x0528 A[Catch: all -> 0x053e, TRY_LEAVE, TryCatch #14 {all -> 0x053e, blocks: (B:214:0x04b5, B:216:0x04b9, B:221:0x04c3, B:222:0x04cc, B:224:0x04d6, B:228:0x04e2, B:230:0x04ec, B:232:0x04fc, B:240:0x0519, B:244:0x0524, B:245:0x0528), top: B:528:0x04b5 }] */
    /* JADX WARN: Code duplicated, block: B:249:0x053a A[Catch: RuntimeException -> 0x0924, IOException -> 0x0928, g -> 0x092d, TryCatch #11 {RuntimeException -> 0x0924, blocks: (B:499:0x0915, B:50:0x00f9, B:51:0x010c, B:52:0x0113, B:54:0x0118, B:58:0x0123, B:60:0x012b, B:61:0x012d, B:63:0x0131, B:65:0x0137, B:66:0x013b, B:68:0x013f, B:69:0x0144, B:70:0x0147, B:74:0x0175, B:76:0x017b, B:71:0x0157, B:73:0x0160, B:79:0x018d, B:81:0x0199, B:82:0x01a5, B:84:0x01b1, B:86:0x0210, B:87:0x0220, B:88:0x0225, B:90:0x022f, B:92:0x024e, B:94:0x025c, B:97:0x026a, B:104:0x027f, B:105:0x0282, B:107:0x028b, B:110:0x0293, B:112:0x0297, B:114:0x02a0, B:115:0x02a5, B:119:0x02c6, B:120:0x02d0, B:122:0x02d8, B:124:0x02de, B:125:0x02e3, B:129:0x030e, B:134:0x031e, B:136:0x032e, B:138:0x0334, B:142:0x0345, B:143:0x034f, B:145:0x0357, B:147:0x0363, B:149:0x036a, B:151:0x0370, B:152:0x0375, B:155:0x037c, B:157:0x03a0, B:158:0x03ac, B:160:0x03b0, B:162:0x03ba, B:163:0x03c5, B:164:0x03ce, B:168:0x03d6, B:176:0x03f7, B:177:0x03ff, B:179:0x0409, B:181:0x0415, B:185:0x041d, B:186:0x042d, B:146:0x0361, B:191:0x043d, B:193:0x0442, B:197:0x0449, B:198:0x044f, B:199:0x0457, B:200:0x0462, B:202:0x0472, B:247:0x052c, B:249:0x053a, B:237:0x0513, B:233:0x0500, B:235:0x0510, B:251:0x053f, B:253:0x0550, B:255:0x0553, B:261:0x0561, B:204:0x0481, B:207:0x04a1, B:208:0x04a9, B:268:0x056c, B:270:0x0576, B:272:0x057a, B:273:0x057f, B:275:0x058e, B:277:0x059a, B:278:0x05a0, B:279:0x05d8, B:281:0x05e0, B:284:0x05e7, B:286:0x05ed, B:290:0x05f5, B:292:0x05fd, B:293:0x060a, B:296:0x0610, B:299:0x061c, B:300:0x061f, B:304:0x0628, B:305:0x065e, B:308:0x0665, B:310:0x066a, B:312:0x0672, B:314:0x0678, B:316:0x067e, B:317:0x0681, B:318:0x0684, B:320:0x0688, B:324:0x0691, B:326:0x0696, B:329:0x06a4, B:332:0x06ac, B:333:0x06af, B:338:0x06cc, B:340:0x06d1, B:343:0x06db, B:345:0x06e1, B:349:0x06f9, B:351:0x0703, B:354:0x070b, B:355:0x0719, B:356:0x071c, B:363:0x072a, B:365:0x0734, B:366:0x073c, B:368:0x0767, B:370:0x0770, B:374:0x0779, B:376:0x077f, B:378:0x0785, B:380:0x078f, B:382:0x0795, B:391:0x07a6, B:396:0x07b0, B:398:0x07b7, B:399:0x07ba, B:403:0x07c9, B:405:0x07d1, B:407:0x07d7, B:443:0x085c, B:445:0x0863, B:447:0x0869, B:448:0x0871, B:450:0x0875, B:454:0x0883, B:461:0x08a0, B:452:0x087c, B:455:0x0889, B:457:0x088e, B:459:0x0895, B:460:0x089b, B:408:0x07e0, B:410:0x07e7, B:412:0x07ec, B:428:0x0830, B:430:0x0838, B:414:0x07f3, B:417:0x07fb, B:421:0x080a, B:423:0x0814, B:431:0x083c, B:433:0x0843, B:435:0x0848, B:439:0x0851, B:441:0x0856, B:442:0x0859, B:462:0x08a5, B:468:0x08af, B:470:0x08b3, B:471:0x08ba, B:473:0x08c1, B:475:0x08c7, B:477:0x08cb, B:480:0x08d2, B:488:0x08e4, B:492:0x08ef, B:496:0x08f6, B:498:0x0907), top: B:527:0x0014 }] */
    /* JADX WARN: Code duplicated, block: B:355:0x0719 A[Catch: RuntimeException -> 0x0924, IOException -> 0x0928, g -> 0x092d, TryCatch #11 {RuntimeException -> 0x0924, blocks: (B:499:0x0915, B:50:0x00f9, B:51:0x010c, B:52:0x0113, B:54:0x0118, B:58:0x0123, B:60:0x012b, B:61:0x012d, B:63:0x0131, B:65:0x0137, B:66:0x013b, B:68:0x013f, B:69:0x0144, B:70:0x0147, B:74:0x0175, B:76:0x017b, B:71:0x0157, B:73:0x0160, B:79:0x018d, B:81:0x0199, B:82:0x01a5, B:84:0x01b1, B:86:0x0210, B:87:0x0220, B:88:0x0225, B:90:0x022f, B:92:0x024e, B:94:0x025c, B:97:0x026a, B:104:0x027f, B:105:0x0282, B:107:0x028b, B:110:0x0293, B:112:0x0297, B:114:0x02a0, B:115:0x02a5, B:119:0x02c6, B:120:0x02d0, B:122:0x02d8, B:124:0x02de, B:125:0x02e3, B:129:0x030e, B:134:0x031e, B:136:0x032e, B:138:0x0334, B:142:0x0345, B:143:0x034f, B:145:0x0357, B:147:0x0363, B:149:0x036a, B:151:0x0370, B:152:0x0375, B:155:0x037c, B:157:0x03a0, B:158:0x03ac, B:160:0x03b0, B:162:0x03ba, B:163:0x03c5, B:164:0x03ce, B:168:0x03d6, B:176:0x03f7, B:177:0x03ff, B:179:0x0409, B:181:0x0415, B:185:0x041d, B:186:0x042d, B:146:0x0361, B:191:0x043d, B:193:0x0442, B:197:0x0449, B:198:0x044f, B:199:0x0457, B:200:0x0462, B:202:0x0472, B:247:0x052c, B:249:0x053a, B:237:0x0513, B:233:0x0500, B:235:0x0510, B:251:0x053f, B:253:0x0550, B:255:0x0553, B:261:0x0561, B:204:0x0481, B:207:0x04a1, B:208:0x04a9, B:268:0x056c, B:270:0x0576, B:272:0x057a, B:273:0x057f, B:275:0x058e, B:277:0x059a, B:278:0x05a0, B:279:0x05d8, B:281:0x05e0, B:284:0x05e7, B:286:0x05ed, B:290:0x05f5, B:292:0x05fd, B:293:0x060a, B:296:0x0610, B:299:0x061c, B:300:0x061f, B:304:0x0628, B:305:0x065e, B:308:0x0665, B:310:0x066a, B:312:0x0672, B:314:0x0678, B:316:0x067e, B:317:0x0681, B:318:0x0684, B:320:0x0688, B:324:0x0691, B:326:0x0696, B:329:0x06a4, B:332:0x06ac, B:333:0x06af, B:338:0x06cc, B:340:0x06d1, B:343:0x06db, B:345:0x06e1, B:349:0x06f9, B:351:0x0703, B:354:0x070b, B:355:0x0719, B:356:0x071c, B:363:0x072a, B:365:0x0734, B:366:0x073c, B:368:0x0767, B:370:0x0770, B:374:0x0779, B:376:0x077f, B:378:0x0785, B:380:0x078f, B:382:0x0795, B:391:0x07a6, B:396:0x07b0, B:398:0x07b7, B:399:0x07ba, B:403:0x07c9, B:405:0x07d1, B:407:0x07d7, B:443:0x085c, B:445:0x0863, B:447:0x0869, B:448:0x0871, B:450:0x0875, B:454:0x0883, B:461:0x08a0, B:452:0x087c, B:455:0x0889, B:457:0x088e, B:459:0x0895, B:460:0x089b, B:408:0x07e0, B:410:0x07e7, B:412:0x07ec, B:428:0x0830, B:430:0x0838, B:414:0x07f3, B:417:0x07fb, B:421:0x080a, B:423:0x0814, B:431:0x083c, B:433:0x0843, B:435:0x0848, B:439:0x0851, B:441:0x0856, B:442:0x0859, B:462:0x08a5, B:468:0x08af, B:470:0x08b3, B:471:0x08ba, B:473:0x08c1, B:475:0x08c7, B:477:0x08cb, B:480:0x08d2, B:488:0x08e4, B:492:0x08ef, B:496:0x08f6, B:498:0x0907), top: B:527:0x0014 }] */
    /* JADX WARN: Code duplicated, block: B:426:0x082d  */
    /* JADX WARN: Code duplicated, block: B:431:0x083c A[Catch: RuntimeException -> 0x0924, IOException -> 0x0928, g -> 0x092d, TryCatch #11 {RuntimeException -> 0x0924, blocks: (B:499:0x0915, B:50:0x00f9, B:51:0x010c, B:52:0x0113, B:54:0x0118, B:58:0x0123, B:60:0x012b, B:61:0x012d, B:63:0x0131, B:65:0x0137, B:66:0x013b, B:68:0x013f, B:69:0x0144, B:70:0x0147, B:74:0x0175, B:76:0x017b, B:71:0x0157, B:73:0x0160, B:79:0x018d, B:81:0x0199, B:82:0x01a5, B:84:0x01b1, B:86:0x0210, B:87:0x0220, B:88:0x0225, B:90:0x022f, B:92:0x024e, B:94:0x025c, B:97:0x026a, B:104:0x027f, B:105:0x0282, B:107:0x028b, B:110:0x0293, B:112:0x0297, B:114:0x02a0, B:115:0x02a5, B:119:0x02c6, B:120:0x02d0, B:122:0x02d8, B:124:0x02de, B:125:0x02e3, B:129:0x030e, B:134:0x031e, B:136:0x032e, B:138:0x0334, B:142:0x0345, B:143:0x034f, B:145:0x0357, B:147:0x0363, B:149:0x036a, B:151:0x0370, B:152:0x0375, B:155:0x037c, B:157:0x03a0, B:158:0x03ac, B:160:0x03b0, B:162:0x03ba, B:163:0x03c5, B:164:0x03ce, B:168:0x03d6, B:176:0x03f7, B:177:0x03ff, B:179:0x0409, B:181:0x0415, B:185:0x041d, B:186:0x042d, B:146:0x0361, B:191:0x043d, B:193:0x0442, B:197:0x0449, B:198:0x044f, B:199:0x0457, B:200:0x0462, B:202:0x0472, B:247:0x052c, B:249:0x053a, B:237:0x0513, B:233:0x0500, B:235:0x0510, B:251:0x053f, B:253:0x0550, B:255:0x0553, B:261:0x0561, B:204:0x0481, B:207:0x04a1, B:208:0x04a9, B:268:0x056c, B:270:0x0576, B:272:0x057a, B:273:0x057f, B:275:0x058e, B:277:0x059a, B:278:0x05a0, B:279:0x05d8, B:281:0x05e0, B:284:0x05e7, B:286:0x05ed, B:290:0x05f5, B:292:0x05fd, B:293:0x060a, B:296:0x0610, B:299:0x061c, B:300:0x061f, B:304:0x0628, B:305:0x065e, B:308:0x0665, B:310:0x066a, B:312:0x0672, B:314:0x0678, B:316:0x067e, B:317:0x0681, B:318:0x0684, B:320:0x0688, B:324:0x0691, B:326:0x0696, B:329:0x06a4, B:332:0x06ac, B:333:0x06af, B:338:0x06cc, B:340:0x06d1, B:343:0x06db, B:345:0x06e1, B:349:0x06f9, B:351:0x0703, B:354:0x070b, B:355:0x0719, B:356:0x071c, B:363:0x072a, B:365:0x0734, B:366:0x073c, B:368:0x0767, B:370:0x0770, B:374:0x0779, B:376:0x077f, B:378:0x0785, B:380:0x078f, B:382:0x0795, B:391:0x07a6, B:396:0x07b0, B:398:0x07b7, B:399:0x07ba, B:403:0x07c9, B:405:0x07d1, B:407:0x07d7, B:443:0x085c, B:445:0x0863, B:447:0x0869, B:448:0x0871, B:450:0x0875, B:454:0x0883, B:461:0x08a0, B:452:0x087c, B:455:0x0889, B:457:0x088e, B:459:0x0895, B:460:0x089b, B:408:0x07e0, B:410:0x07e7, B:412:0x07ec, B:428:0x0830, B:430:0x0838, B:414:0x07f3, B:417:0x07fb, B:421:0x080a, B:423:0x0814, B:431:0x083c, B:433:0x0843, B:435:0x0848, B:439:0x0851, B:441:0x0856, B:442:0x0859, B:462:0x08a5, B:468:0x08af, B:470:0x08b3, B:471:0x08ba, B:473:0x08c1, B:475:0x08c7, B:477:0x08cb, B:480:0x08d2, B:488:0x08e4, B:492:0x08ef, B:496:0x08f6, B:498:0x0907), top: B:527:0x0014 }] */
    /* JADX WARN: Code duplicated, block: B:433:0x0843 A[Catch: RuntimeException -> 0x0924, IOException -> 0x0928, g -> 0x092d, TryCatch #11 {RuntimeException -> 0x0924, blocks: (B:499:0x0915, B:50:0x00f9, B:51:0x010c, B:52:0x0113, B:54:0x0118, B:58:0x0123, B:60:0x012b, B:61:0x012d, B:63:0x0131, B:65:0x0137, B:66:0x013b, B:68:0x013f, B:69:0x0144, B:70:0x0147, B:74:0x0175, B:76:0x017b, B:71:0x0157, B:73:0x0160, B:79:0x018d, B:81:0x0199, B:82:0x01a5, B:84:0x01b1, B:86:0x0210, B:87:0x0220, B:88:0x0225, B:90:0x022f, B:92:0x024e, B:94:0x025c, B:97:0x026a, B:104:0x027f, B:105:0x0282, B:107:0x028b, B:110:0x0293, B:112:0x0297, B:114:0x02a0, B:115:0x02a5, B:119:0x02c6, B:120:0x02d0, B:122:0x02d8, B:124:0x02de, B:125:0x02e3, B:129:0x030e, B:134:0x031e, B:136:0x032e, B:138:0x0334, B:142:0x0345, B:143:0x034f, B:145:0x0357, B:147:0x0363, B:149:0x036a, B:151:0x0370, B:152:0x0375, B:155:0x037c, B:157:0x03a0, B:158:0x03ac, B:160:0x03b0, B:162:0x03ba, B:163:0x03c5, B:164:0x03ce, B:168:0x03d6, B:176:0x03f7, B:177:0x03ff, B:179:0x0409, B:181:0x0415, B:185:0x041d, B:186:0x042d, B:146:0x0361, B:191:0x043d, B:193:0x0442, B:197:0x0449, B:198:0x044f, B:199:0x0457, B:200:0x0462, B:202:0x0472, B:247:0x052c, B:249:0x053a, B:237:0x0513, B:233:0x0500, B:235:0x0510, B:251:0x053f, B:253:0x0550, B:255:0x0553, B:261:0x0561, B:204:0x0481, B:207:0x04a1, B:208:0x04a9, B:268:0x056c, B:270:0x0576, B:272:0x057a, B:273:0x057f, B:275:0x058e, B:277:0x059a, B:278:0x05a0, B:279:0x05d8, B:281:0x05e0, B:284:0x05e7, B:286:0x05ed, B:290:0x05f5, B:292:0x05fd, B:293:0x060a, B:296:0x0610, B:299:0x061c, B:300:0x061f, B:304:0x0628, B:305:0x065e, B:308:0x0665, B:310:0x066a, B:312:0x0672, B:314:0x0678, B:316:0x067e, B:317:0x0681, B:318:0x0684, B:320:0x0688, B:324:0x0691, B:326:0x0696, B:329:0x06a4, B:332:0x06ac, B:333:0x06af, B:338:0x06cc, B:340:0x06d1, B:343:0x06db, B:345:0x06e1, B:349:0x06f9, B:351:0x0703, B:354:0x070b, B:355:0x0719, B:356:0x071c, B:363:0x072a, B:365:0x0734, B:366:0x073c, B:368:0x0767, B:370:0x0770, B:374:0x0779, B:376:0x077f, B:378:0x0785, B:380:0x078f, B:382:0x0795, B:391:0x07a6, B:396:0x07b0, B:398:0x07b7, B:399:0x07ba, B:403:0x07c9, B:405:0x07d1, B:407:0x07d7, B:443:0x085c, B:445:0x0863, B:447:0x0869, B:448:0x0871, B:450:0x0875, B:454:0x0883, B:461:0x08a0, B:452:0x087c, B:455:0x0889, B:457:0x088e, B:459:0x0895, B:460:0x089b, B:408:0x07e0, B:410:0x07e7, B:412:0x07ec, B:428:0x0830, B:430:0x0838, B:414:0x07f3, B:417:0x07fb, B:421:0x080a, B:423:0x0814, B:431:0x083c, B:433:0x0843, B:435:0x0848, B:439:0x0851, B:441:0x0856, B:442:0x0859, B:462:0x08a5, B:468:0x08af, B:470:0x08b3, B:471:0x08ba, B:473:0x08c1, B:475:0x08c7, B:477:0x08cb, B:480:0x08d2, B:488:0x08e4, B:492:0x08ef, B:496:0x08f6, B:498:0x0907), top: B:527:0x0014 }] */
    /* JADX WARN: Code duplicated, block: B:435:0x0848 A[Catch: RuntimeException -> 0x0924, IOException -> 0x0928, g -> 0x092d, TryCatch #11 {RuntimeException -> 0x0924, blocks: (B:499:0x0915, B:50:0x00f9, B:51:0x010c, B:52:0x0113, B:54:0x0118, B:58:0x0123, B:60:0x012b, B:61:0x012d, B:63:0x0131, B:65:0x0137, B:66:0x013b, B:68:0x013f, B:69:0x0144, B:70:0x0147, B:74:0x0175, B:76:0x017b, B:71:0x0157, B:73:0x0160, B:79:0x018d, B:81:0x0199, B:82:0x01a5, B:84:0x01b1, B:86:0x0210, B:87:0x0220, B:88:0x0225, B:90:0x022f, B:92:0x024e, B:94:0x025c, B:97:0x026a, B:104:0x027f, B:105:0x0282, B:107:0x028b, B:110:0x0293, B:112:0x0297, B:114:0x02a0, B:115:0x02a5, B:119:0x02c6, B:120:0x02d0, B:122:0x02d8, B:124:0x02de, B:125:0x02e3, B:129:0x030e, B:134:0x031e, B:136:0x032e, B:138:0x0334, B:142:0x0345, B:143:0x034f, B:145:0x0357, B:147:0x0363, B:149:0x036a, B:151:0x0370, B:152:0x0375, B:155:0x037c, B:157:0x03a0, B:158:0x03ac, B:160:0x03b0, B:162:0x03ba, B:163:0x03c5, B:164:0x03ce, B:168:0x03d6, B:176:0x03f7, B:177:0x03ff, B:179:0x0409, B:181:0x0415, B:185:0x041d, B:186:0x042d, B:146:0x0361, B:191:0x043d, B:193:0x0442, B:197:0x0449, B:198:0x044f, B:199:0x0457, B:200:0x0462, B:202:0x0472, B:247:0x052c, B:249:0x053a, B:237:0x0513, B:233:0x0500, B:235:0x0510, B:251:0x053f, B:253:0x0550, B:255:0x0553, B:261:0x0561, B:204:0x0481, B:207:0x04a1, B:208:0x04a9, B:268:0x056c, B:270:0x0576, B:272:0x057a, B:273:0x057f, B:275:0x058e, B:277:0x059a, B:278:0x05a0, B:279:0x05d8, B:281:0x05e0, B:284:0x05e7, B:286:0x05ed, B:290:0x05f5, B:292:0x05fd, B:293:0x060a, B:296:0x0610, B:299:0x061c, B:300:0x061f, B:304:0x0628, B:305:0x065e, B:308:0x0665, B:310:0x066a, B:312:0x0672, B:314:0x0678, B:316:0x067e, B:317:0x0681, B:318:0x0684, B:320:0x0688, B:324:0x0691, B:326:0x0696, B:329:0x06a4, B:332:0x06ac, B:333:0x06af, B:338:0x06cc, B:340:0x06d1, B:343:0x06db, B:345:0x06e1, B:349:0x06f9, B:351:0x0703, B:354:0x070b, B:355:0x0719, B:356:0x071c, B:363:0x072a, B:365:0x0734, B:366:0x073c, B:368:0x0767, B:370:0x0770, B:374:0x0779, B:376:0x077f, B:378:0x0785, B:380:0x078f, B:382:0x0795, B:391:0x07a6, B:396:0x07b0, B:398:0x07b7, B:399:0x07ba, B:403:0x07c9, B:405:0x07d1, B:407:0x07d7, B:443:0x085c, B:445:0x0863, B:447:0x0869, B:448:0x0871, B:450:0x0875, B:454:0x0883, B:461:0x08a0, B:452:0x087c, B:455:0x0889, B:457:0x088e, B:459:0x0895, B:460:0x089b, B:408:0x07e0, B:410:0x07e7, B:412:0x07ec, B:428:0x0830, B:430:0x0838, B:414:0x07f3, B:417:0x07fb, B:421:0x080a, B:423:0x0814, B:431:0x083c, B:433:0x0843, B:435:0x0848, B:439:0x0851, B:441:0x0856, B:442:0x0859, B:462:0x08a5, B:468:0x08af, B:470:0x08b3, B:471:0x08ba, B:473:0x08c1, B:475:0x08c7, B:477:0x08cb, B:480:0x08d2, B:488:0x08e4, B:492:0x08ef, B:496:0x08f6, B:498:0x0907), top: B:527:0x0014 }] */
    /* JADX WARN: Code duplicated, block: B:437:0x084e  */
    /* JADX WARN: Code duplicated, block: B:438:0x084f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:439:0x0851 A[Catch: RuntimeException -> 0x0924, IOException -> 0x0928, g -> 0x092d, TRY_LEAVE, TryCatch #11 {RuntimeException -> 0x0924, blocks: (B:499:0x0915, B:50:0x00f9, B:51:0x010c, B:52:0x0113, B:54:0x0118, B:58:0x0123, B:60:0x012b, B:61:0x012d, B:63:0x0131, B:65:0x0137, B:66:0x013b, B:68:0x013f, B:69:0x0144, B:70:0x0147, B:74:0x0175, B:76:0x017b, B:71:0x0157, B:73:0x0160, B:79:0x018d, B:81:0x0199, B:82:0x01a5, B:84:0x01b1, B:86:0x0210, B:87:0x0220, B:88:0x0225, B:90:0x022f, B:92:0x024e, B:94:0x025c, B:97:0x026a, B:104:0x027f, B:105:0x0282, B:107:0x028b, B:110:0x0293, B:112:0x0297, B:114:0x02a0, B:115:0x02a5, B:119:0x02c6, B:120:0x02d0, B:122:0x02d8, B:124:0x02de, B:125:0x02e3, B:129:0x030e, B:134:0x031e, B:136:0x032e, B:138:0x0334, B:142:0x0345, B:143:0x034f, B:145:0x0357, B:147:0x0363, B:149:0x036a, B:151:0x0370, B:152:0x0375, B:155:0x037c, B:157:0x03a0, B:158:0x03ac, B:160:0x03b0, B:162:0x03ba, B:163:0x03c5, B:164:0x03ce, B:168:0x03d6, B:176:0x03f7, B:177:0x03ff, B:179:0x0409, B:181:0x0415, B:185:0x041d, B:186:0x042d, B:146:0x0361, B:191:0x043d, B:193:0x0442, B:197:0x0449, B:198:0x044f, B:199:0x0457, B:200:0x0462, B:202:0x0472, B:247:0x052c, B:249:0x053a, B:237:0x0513, B:233:0x0500, B:235:0x0510, B:251:0x053f, B:253:0x0550, B:255:0x0553, B:261:0x0561, B:204:0x0481, B:207:0x04a1, B:208:0x04a9, B:268:0x056c, B:270:0x0576, B:272:0x057a, B:273:0x057f, B:275:0x058e, B:277:0x059a, B:278:0x05a0, B:279:0x05d8, B:281:0x05e0, B:284:0x05e7, B:286:0x05ed, B:290:0x05f5, B:292:0x05fd, B:293:0x060a, B:296:0x0610, B:299:0x061c, B:300:0x061f, B:304:0x0628, B:305:0x065e, B:308:0x0665, B:310:0x066a, B:312:0x0672, B:314:0x0678, B:316:0x067e, B:317:0x0681, B:318:0x0684, B:320:0x0688, B:324:0x0691, B:326:0x0696, B:329:0x06a4, B:332:0x06ac, B:333:0x06af, B:338:0x06cc, B:340:0x06d1, B:343:0x06db, B:345:0x06e1, B:349:0x06f9, B:351:0x0703, B:354:0x070b, B:355:0x0719, B:356:0x071c, B:363:0x072a, B:365:0x0734, B:366:0x073c, B:368:0x0767, B:370:0x0770, B:374:0x0779, B:376:0x077f, B:378:0x0785, B:380:0x078f, B:382:0x0795, B:391:0x07a6, B:396:0x07b0, B:398:0x07b7, B:399:0x07ba, B:403:0x07c9, B:405:0x07d1, B:407:0x07d7, B:443:0x085c, B:445:0x0863, B:447:0x0869, B:448:0x0871, B:450:0x0875, B:454:0x0883, B:461:0x08a0, B:452:0x087c, B:455:0x0889, B:457:0x088e, B:459:0x0895, B:460:0x089b, B:408:0x07e0, B:410:0x07e7, B:412:0x07ec, B:428:0x0830, B:430:0x0838, B:414:0x07f3, B:417:0x07fb, B:421:0x080a, B:423:0x0814, B:431:0x083c, B:433:0x0843, B:435:0x0848, B:439:0x0851, B:441:0x0856, B:442:0x0859, B:462:0x08a5, B:468:0x08af, B:470:0x08b3, B:471:0x08ba, B:473:0x08c1, B:475:0x08c7, B:477:0x08cb, B:480:0x08d2, B:488:0x08e4, B:492:0x08ef, B:496:0x08f6, B:498:0x0907), top: B:527:0x0014 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v12, types: [android.os.Handler] */
    /* JADX WARN: Type inference failed for: r2v130 */
    /* JADX WARN: Type inference failed for: r2v131 */
    /* JADX WARN: Type inference failed for: r2v15, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v16, types: [android.os.Handler] */
    /* JADX WARN: Type inference failed for: r2v172, types: [int] */
    /* JADX WARN: Type inference failed for: r2v173 */
    /* JADX WARN: Type inference failed for: r2v174 */
    /* JADX WARN: Type inference failed for: r2v181 */
    /* JADX WARN: Type inference failed for: r2v187 */
    /* JADX WARN: Type inference failed for: r2v188 */
    /* JADX WARN: Type inference failed for: r2v189 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v203 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v224 */
    /* JADX WARN: Type inference failed for: r2v225 */
    /* JADX WARN: Type inference failed for: r2v226 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v273 */
    /* JADX WARN: Type inference failed for: r2v274 */
    /* JADX WARN: Type inference failed for: r2v275 */
    /* JADX WARN: Type inference failed for: r2v276 */
    /* JADX WARN: Type inference failed for: r2v277 */
    /* JADX WARN: Type inference failed for: r2v278 */
    /* JADX WARN: Type inference failed for: r2v279 */
    /* JADX WARN: Type inference failed for: r2v280 */
    /* JADX WARN: Type inference failed for: r2v281 */
    /* JADX WARN: Type inference failed for: r2v282 */
    /* JADX WARN: Type inference failed for: r2v283 */
    /* JADX WARN: Type inference failed for: r2v284 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [boolean] */
    /* JADX WARN: Type inference failed for: r31v0, types: [com.anythink.basead.exoplayer.h.r$a, com.anythink.basead.exoplayer.h.s$b, com.anythink.basead.exoplayer.k] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v42 */
    /* JADX WARN: Type inference failed for: r4v43 */
    /* JADX WARN: Type inference failed for: r4v46 */
    /* JADX WARN: Type inference failed for: r4v47 */
    /* JADX WARN: Type inference failed for: r4v48 */
    /* JADX WARN: Type inference failed for: r4v49 */
    /* JADX WARN: Type inference failed for: r4v50 */
    /* JADX WARN: Type inference failed for: r4v51 */
    /* JADX WARN: Type inference failed for: r4v52 */
    /* JADX WARN: Type inference failed for: r4v53 */
    /* JADX WARN: Type inference failed for: r4v6, types: [int] */
    /* JADX WARN: Type inference failed for: r4v7, types: [int] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v55, types: [com.anythink.basead.exoplayer.k$c] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        ?? r2;
        ?? r3;
        Message message2;
        RuntimeException runtimeException;
        IOException iOException;
        g gVar;
        ?? r4;
        ?? r5;
        ?? r6;
        boolean z;
        boolean z2;
        boolean zM;
        boolean z3;
        int i2;
        com.anythink.basead.exoplayer.h.s.a aVarA;
        boolean z4;
        long j2;
        long j3;
        int i3;
        c cVar;
        long j4;
        long jA;
        int i4;
        long j5;
        Message message3 = message;
        char c2 = 2;
         = 2;
         = 2;
        ?? r7 = 2;
        ?? r8 = 2;
        c = 2;
        c2 = 2;
        ?? r9 = 2;
        ?? r10 = 2;
        char c3 = 2;
        try {
            try {
                long j6 = 0;
                try {
                    try {
                        try {
                            try {
                                try {
                                    try {
                                        switch (message3.what) {
                                            case 0:
                                                com.anythink.basead.exoplayer.h.s sVar = (com.anythink.basead.exoplayer.h.s) message3.obj;
                                                boolean z5 = message3.arg1 != 0;
                                                boolean z6 = message3.arg2 != 0;
                                                this.Z++;
                                                a(true, z5, z6);
                                                this.C.a();
                                                this.S = sVar;
                                                b(2);
                                                sVar.a(this.G, true, this);
                                                this.D.b(2);
                                                d();
                                                return true;
                                            case 1:
                                                boolean z7 = message3.arg1 != 0;
                                                try {
                                                    this.W = false;
                                                    this.V = z7;
                                                    if (!z7) {
                                                        f();
                                                        g();
                                                    } else if (this.R.f == 3) {
                                                        e();
                                                        this.D.b(2);
                                                    } else if (this.R.f == 2) {
                                                        this.D.b(2);
                                                    }
                                                    d();
                                                    return true;
                                                } catch (g e2) {
                                                    gVar = e2;
                                                    z2 = false;
                                                    r7 = 2;
                                                    r6 = z2;
                                                    Log.e(d, "Playback error.", gVar);
                                                    a(r6, r6);
                                                    this.F.obtainMessage(r7, gVar).sendToTarget();
                                                    d();
                                                    return true;
                                                } catch (IOException e3) {
                                                    iOException = e3;
                                                    z = false;
                                                    r8 = 2;
                                                    r5 = z;
                                                    Log.e(d, "Source error.", iOException);
                                                    a(r5, r5);
                                                    this.F.obtainMessage(r8, g.a(iOException)).sendToTarget();
                                                    d();
                                                    return true;
                                                } catch (RuntimeException e4) {
                                                    e = e4;
                                                    message2 = null;
                                                    runtimeException = e;
                                                    r4 = message2;
                                                    Log.e(d, "Internal runtime error.", runtimeException);
                                                    a(r4, r4);
                                                    this.F.obtainMessage(2, g.a(runtimeException)).sendToTarget();
                                                    d();
                                                    return true;
                                                }
                                            case 2:
                                                long jB = this.O.b();
                                                com.anythink.basead.exoplayer.h.s sVar2 = this.S;
                                                if (sVar2 != null) {
                                                    if (this.Z > 0) {
                                                        sVar2.b();
                                                    } else {
                                                        this.P.a(this.ab);
                                                        if (this.P.a()) {
                                                            r rVarA = this.P.a(this.ab, this.R);
                                                            if (rVarA == null) {
                                                                this.S.b();
                                                            } else {
                                                                this.P.a(this.z, this.A, this.C.d(), this.S, this.R.a.a(rVarA.a.a, this.I, true).b, rVarA).a((com.anythink.basead.exoplayer.h.r.a) this, rVarA.b);
                                                                d(true);
                                                            }
                                                        }
                                                        q qVarB = this.P.b();
                                                        if (qVarB == null || qVarB.a()) {
                                                            z = false;
                                                            z2 = false;
                                                            try {
                                                                d(false);
                                                            } catch (g e5) {
                                                                gVar = e5;
                                                                r7 = 2;
                                                                r6 = z2;
                                                                Log.e(d, "Playback error.", gVar);
                                                                a(r6, r6);
                                                                this.F.obtainMessage(r7, gVar).sendToTarget();
                                                                d();
                                                                return true;
                                                            } catch (IOException e6) {
                                                                iOException = e6;
                                                                r8 = 2;
                                                                r5 = z;
                                                                Log.e(d, "Source error.", iOException);
                                                                a(r5, r5);
                                                                this.F.obtainMessage(r8, g.a(iOException)).sendToTarget();
                                                                d();
                                                                return true;
                                                            }
                                                        } else if (!this.R.g) {
                                                            r();
                                                        }
                                                        if (this.P.f()) {
                                                            q qVarC = this.P.c();
                                                            q qVarD = this.P.d();
                                                            boolean z8 = false;
                                                            while (this.V && qVarC != qVarD && this.ab >= qVarC.i.e) {
                                                                if (z8) {
                                                                    d();
                                                                }
                                                                int i5 = qVarC.h.f ? 0 : 3;
                                                                q qVarH = this.P.h();
                                                                a(qVarC);
                                                                this.R = this.R.a(qVarH.h.a, qVarH.h.b, qVarH.h.d);
                                                                this.M.b(i5);
                                                                g();
                                                                qVarC = qVarH;
                                                                z8 = true;
                                                            }
                                                            if (qVarD.h.g) {
                                                                int i6 = 0;
                                                                while (true) {
                                                                    y[] yVarArr = this.y;
                                                                    if (i6 < yVarArr.length) {
                                                                        y yVar = yVarArr[i6];
                                                                        com.anythink.basead.exoplayer.h.y yVar2 = qVarD.c[i6];
                                                                        if (yVar2 != null && yVar.f() == yVar2 && yVar.g()) {
                                                                            yVar.h();
                                                                        }
                                                                        i6++;
                                                                    }
                                                                }
                                                            } else if (qVarD.i != null && qVarD.i.f) {
                                                                while (true) {
                                                                    y[] yVarArr2 = this.y;
                                                                    if (i2 < yVarArr2.length) {
                                                                        y yVar3 = yVarArr2[i2];
                                                                        com.anythink.basead.exoplayer.h.y yVar4 = qVarD.c[i2];
                                                                        i2 = (yVar3.f() == yVar4 && (yVar4 == null || yVar3.g())) ? i2 + 1 : 0;
                                                                    } else {
                                                                        com.anythink.basead.exoplayer.i.i iVar = qVarD.k;
                                                                        q qVarG = this.P.g();
                                                                        com.anythink.basead.exoplayer.i.i iVar2 = qVarG.k;
                                                                        boolean z9 = qVarG.a.c() != -9223372036854775807L;
                                                                        int i7 = 0;
                                                                        while (true) {
                                                                            y[] yVarArr3 = this.y;
                                                                            if (i7 < yVarArr3.length) {
                                                                                y yVar5 = yVarArr3[i7];
                                                                                if (iVar.a(i7)) {
                                                                                    if (!z9) {
                                                                                        if (!yVar5.i()) {
                                                                                            com.anythink.basead.exoplayer.i.f fVarA = iVar2.c.a(i7);
                                                                                            boolean zA = iVar2.a(i7);
                                                                                            boolean z10 = this.z[i7].a() == 5;
                                                                                            aa aaVar = iVar.b[i7];
                                                                                            aa aaVar2 = iVar2.b[i7];
                                                                                            if (zA && aaVar2.equals(aaVar) && !z10) {
                                                                                                yVar5.a(a(fVarA), qVarG.c[i7], qVarG.e);
                                                                                            } else {
                                                                                                yVar5.h();
                                                                                            }
                                                                                        }
                                                                                    } else {
                                                                                        yVar5.h();
                                                                                    }
                                                                                }
                                                                                i7++;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    break;
                                                }
                                                if (!this.P.f()) {
                                                    n();
                                                    a(jB, 10L);
                                                } else {
                                                    q qVarC2 = this.P.c();
                                                    com.anythink.basead.exoplayer.k.ad.a("doSomeWork");
                                                    g();
                                                    long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
                                                    qVarC2.a.a(this.R.j - this.J, this.K);
                                                    boolean z11 = true;
                                                    boolean z12 = true;
                                                    for (y yVar6 : this.T) {
                                                        yVar6.a(this.ab, jElapsedRealtime);
                                                        z12 = z12 && yVar6.v();
                                                        if (!yVar6.u() && !yVar6.v()) {
                                                            q qVarD2 = this.P.d();
                                                            z3 = qVarD2.i != null && qVarD2.i.f && yVar6.g();
                                                        }
                                                        if (!z3) {
                                                            yVar6.j();
                                                        }
                                                        z11 = z11 && z3;
                                                    }
                                                    if (!z11) {
                                                        n();
                                                    }
                                                    long j7 = qVarC2.h.e;
                                                    if (z12 && ((j7 == -9223372036854775807L || j7 <= this.R.j) && qVarC2.h.g)) {
                                                        b(4);
                                                        f();
                                                    } else if (this.R.f != 2) {
                                                        if (this.R.f == 3) {
                                                            if (this.T.length == 0) {
                                                                if (m()) {
                                                                    this.W = this.V;
                                                                    b(2);
                                                                    f();
                                                                }
                                                            } else if (!z11) {
                                                                this.W = this.V;
                                                                b(2);
                                                                f();
                                                            }
                                                        }
                                                    } else {
                                                        if (this.T.length == 0) {
                                                            zM = m();
                                                        } else if (z11) {
                                                            if (this.R.g) {
                                                                q qVarB2 = this.P.b();
                                                                long jA2 = qVarB2.a(!qVarB2.h.g);
                                                                if (jA2 != Long.MIN_VALUE && !this.C.a(jA2 - (this.ab - qVarB2.e), this.L.e().b, this.W)) {
                                                                    zM = false;
                                                                }
                                                            }
                                                            zM = true;
                                                        } else {
                                                            zM = false;
                                                        }
                                                        if (zM) {
                                                            b(3);
                                                            if (this.V) {
                                                                e();
                                                            }
                                                        } else if (this.R.f == 3) {
                                                            if (this.T.length == 0) {
                                                                if (m()) {
                                                                    this.W = this.V;
                                                                    b(2);
                                                                    f();
                                                                }
                                                            } else if (!z11) {
                                                                this.W = this.V;
                                                                b(2);
                                                                f();
                                                            }
                                                        }
                                                    }
                                                    if (this.R.f == 2) {
                                                        for (y yVar7 : this.T) {
                                                            yVar7.j();
                                                        }
                                                    }
                                                    if ((this.V && this.R.f == 3) || this.R.f == 2) {
                                                        a(jB, 10L);
                                                    } else if (this.T.length != 0 && this.R.f != 4) {
                                                        a(jB, 1000L);
                                                    } else {
                                                        this.D.b();
                                                    }
                                                    com.anythink.basead.exoplayer.k.ad.a();
                                                }
                                                d();
                                                return true;
                                            case 3:
                                                d dVar = (d) message3.obj;
                                                this.M.a(1);
                                                Pair<Integer, Long> pairA = a(dVar, true);
                                                try {
                                                    if (pairA == null) {
                                                        aVarA = new com.anythink.basead.exoplayer.h.s.a(j());
                                                        j3 = -9223372036854775807L;
                                                        j2 = -9223372036854775807L;
                                                    } else {
                                                        int iIntValue = ((Integer) pairA.first).intValue();
                                                        long jLongValue = ((Long) pairA.second).longValue();
                                                        aVarA = this.P.a(iIntValue, jLongValue);
                                                        if (aVarA.a()) {
                                                            j2 = jLongValue;
                                                            j3 = 0;
                                                        } else {
                                                            long jLongValue2 = ((Long) pairA.second).longValue();
                                                            z4 = dVar.c == -9223372036854775807L;
                                                            j2 = jLongValue;
                                                            j3 = jLongValue2;
                                                        }
                                                        if (this.S == null && this.Z <= 0) {
                                                            if (j3 == -9223372036854775807L) {
                                                                b(4);
                                                                a(false, true, false);
                                                            } else {
                                                                if (aVarA.equals(this.R.c)) {
                                                                    q qVarC3 = this.P.c();
                                                                    jA = (qVarC3 == null || j3 == 0) ? j3 : qVarC3.a.a(j3, this.Q);
                                                                    if (com.anythink.basead.exoplayer.b.a(jA) == com.anythink.basead.exoplayer.b.a(this.R.j)) {
                                                                        this.R = this.R.a(aVarA, this.R.j, j2);
                                                                        if (z4) {
                                                                            cVar = this.M;
                                                                            i3 = 2;
                                                                            cVar.b(i3);
                                                                        }
                                                                    }
                                                                } else {
                                                                    jA = j3;
                                                                }
                                                                long jA3 = a(aVarA, jA);
                                                                z4 |= j3 != jA3;
                                                                j4 = jA3;
                                                                this.R = this.R.a(aVarA, j4, j2);
                                                                if (z4) {
                                                                    cVar = this.M;
                                                                    i3 = 2;
                                                                    cVar.b(i3);
                                                                }
                                                            }
                                                            d();
                                                            return true;
                                                        }
                                                        this.aa = dVar;
                                                        j4 = j3;
                                                        this.R = this.R.a(aVarA, j4, j2);
                                                        if (z4) {
                                                            cVar = this.M;
                                                            i3 = 2;
                                                            cVar.b(i3);
                                                        }
                                                        d();
                                                        return true;
                                                    }
                                                    if (this.S == null) {
                                                        this.aa = dVar;
                                                        j4 = j3;
                                                        this.R = this.R.a(aVarA, j4, j2);
                                                        if (z4) {
                                                            cVar = this.M;
                                                            i3 = 2;
                                                            cVar.b(i3);
                                                        }
                                                    } else {
                                                        this.aa = dVar;
                                                        j4 = j3;
                                                        this.R = this.R.a(aVarA, j4, j2);
                                                        if (z4) {
                                                            cVar = this.M;
                                                            i3 = 2;
                                                            cVar.b(i3);
                                                        }
                                                    }
                                                    d();
                                                    return true;
                                                } catch (Throwable th) {
                                                    this.R = this.R.a(aVarA, j3, j2);
                                                    if (z4) {
                                                        try {
                                                            this.M.b(2);
                                                            throw th;
                                                        } catch (g e7) {
                                                            e = e7;
                                                            c3 = 2;
                                                            r3 = 0;
                                                            gVar = e;
                                                            r6 = r3;
                                                            r7 = c3;
                                                            Log.e(d, "Playback error.", gVar);
                                                            a(r6, r6);
                                                            this.F.obtainMessage(r7, gVar).sendToTarget();
                                                            d();
                                                            return true;
                                                        } catch (IOException e8) {
                                                            e = e8;
                                                            c2 = 2;
                                                            r2 = 0;
                                                            iOException = e;
                                                            r5 = r2;
                                                            r8 = c2;
                                                            Log.e(d, "Source error.", iOException);
                                                            a(r5, r5);
                                                            this.F.obtainMessage(r8, g.a(iOException)).sendToTarget();
                                                            d();
                                                            return true;
                                                        }
                                                    }
                                                    throw th;
                                                }
                                                z4 = true;
                                            case 4:
                                                this.L.a((v) message3.obj);
                                                d();
                                                return true;
                                            case 5:
                                                this.Q = (ac) message3.obj;
                                                d();
                                                return true;
                                            case 6:
                                                a(message3.arg1 != 0, true);
                                                d();
                                                return true;
                                            case 7:
                                                i();
                                                return true;
                                            case 8:
                                                a aVar = (a) message3.obj;
                                                if (aVar.a == this.S) {
                                                    ae aeVar = this.R.a;
                                                    ae aeVar2 = aVar.b;
                                                    Object obj = aVar.c;
                                                    this.P.a(aeVar2);
                                                    this.R = this.R.a(aeVar2, obj);
                                                    for (int size = this.N.size() - 1; size >= 0; size--) {
                                                        if (!a(this.N.get(size))) {
                                                            try {
                                                                this.N.get(size).a.a(false);
                                                                this.N.remove(size);
                                                            } catch (g e9) {
                                                                gVar = e9;
                                                                r6 = 0;
                                                                Log.e(d, "Playback error.", gVar);
                                                                a(r6, r6);
                                                                this.F.obtainMessage(r7, gVar).sendToTarget();
                                                                d();
                                                                return true;
                                                            } catch (IOException e10) {
                                                                iOException = e10;
                                                                r5 = 0;
                                                                Log.e(d, "Source error.", iOException);
                                                                a(r5, r5);
                                                                this.F.obtainMessage(r8, g.a(iOException)).sendToTarget();
                                                                d();
                                                                return true;
                                                            } catch (RuntimeException e11) {
                                                                runtimeException = e11;
                                                                r4 = 0;
                                                                Log.e(d, "Internal runtime error.", runtimeException);
                                                                a(r4, r4);
                                                                this.F.obtainMessage(2, g.a(runtimeException)).sendToTarget();
                                                                d();
                                                                return true;
                                                            }
                                                        }
                                                    }
                                                    Collections.sort(this.N);
                                                    ?? r11 = this.Z;
                                                    try {
                                                        if (r11 > 0) {
                                                            this.M.a(r11);
                                                            this.Z = 0;
                                                            d dVar2 = this.aa;
                                                            if (dVar2 != null) {
                                                                Pair<Integer, Long> pairA2 = a(dVar2, true);
                                                                this.aa = null;
                                                                if (pairA2 == null) {
                                                                    o();
                                                                    r11 = pairA2;
                                                                } else {
                                                                    int iIntValue2 = ((Integer) pairA2.first).intValue();
                                                                    long jLongValue3 = ((Long) pairA2.second).longValue();
                                                                    com.anythink.basead.exoplayer.h.s.a aVarA2 = this.P.a(iIntValue2, jLongValue3);
                                                                    u uVarA = this.R.a(aVarA2, aVarA2.a() ? 0L : jLongValue3, jLongValue3);
                                                                    this.R = uVarA;
                                                                    r11 = uVarA;
                                                                }
                                                            } else {
                                                                i4 = (this.R.d > (-9223372036854775807L) ? 1 : (this.R.d == (-9223372036854775807L) ? 0 : -1));
                                                                if (i4 == 0) {
                                                                    boolean zA2 = aeVar2.a();
                                                                    if (zA2) {
                                                                        r11 = i4;
                                                                        o();
                                                                        r11 = zA2;
                                                                    } else {
                                                                        Pair<Integer, Long> pairA3 = a(aeVar2, aeVar2.b(this.Y));
                                                                        int iIntValue3 = ((Integer) pairA3.first).intValue();
                                                                        long jLongValue4 = ((Long) pairA3.second).longValue();
                                                                        com.anythink.basead.exoplayer.h.s.a aVarA3 = this.P.a(iIntValue3, jLongValue4);
                                                                        u uVar = this.R;
                                                                        if (aVarA3.a()) {
                                                                            r11 = i4;
                                                                            j5 = 0;
                                                                        } else {
                                                                            r11 = i4;
                                                                            j5 = jLongValue4;
                                                                        }
                                                                        u uVarA2 = uVar.a(aVarA3, j5, jLongValue4);
                                                                        this.R = uVarA2;
                                                                        r11 = uVarA2;
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            int i8 = this.R.c.a;
                                                            long j8 = this.R.e;
                                                            if (aeVar.a()) {
                                                                if (!aeVar2.a()) {
                                                                    com.anythink.basead.exoplayer.h.s.a aVarA4 = this.P.a(i8, j8);
                                                                    this.R = this.R.a(aVarA4, aVarA4.a() ? 0L : j8, j8);
                                                                }
                                                            } else {
                                                                q qVarE = this.P.e();
                                                                int iA = aeVar2.a(qVarE == null ? aeVar.a(i8, this.I, true).b : qVarE.b);
                                                                if (iA == -1) {
                                                                    int iA2 = a(i8, aeVar, aeVar2);
                                                                    if (iA2 == -1) {
                                                                        o();
                                                                    } else {
                                                                        try {
                                                                            Pair<Integer, Long> pairA4 = a(aeVar2, aeVar2.a(iA2, this.I, false).c);
                                                                            int iIntValue4 = ((Integer) pairA4.first).intValue();
                                                                            long jLongValue5 = ((Long) pairA4.second).longValue();
                                                                            com.anythink.basead.exoplayer.h.s.a aVarA5 = this.P.a(iIntValue4, jLongValue5);
                                                                            aeVar2.a(iIntValue4, this.I, true);
                                                                            if (qVarE != null) {
                                                                                Object obj2 = this.I.b;
                                                                                qVarE.h = qVarE.h.a();
                                                                                while (qVarE.i != null) {
                                                                                    qVarE = qVarE.i;
                                                                                    if (qVarE.b.equals(obj2)) {
                                                                                        qVarE.h = this.P.a(qVarE.h, iIntValue4);
                                                                                    } else {
                                                                                        qVarE.h = qVarE.h.a();
                                                                                    }
                                                                                }
                                                                            }
                                                                            if (!aVarA5.a()) {
                                                                                j6 = jLongValue5;
                                                                            }
                                                                            this.R = this.R.a(aVarA5, a(aVarA5, j6), jLongValue5);
                                                                        } catch (g e12) {
                                                                            gVar = e12;
                                                                            r6 = 0;
                                                                            Log.e(d, "Playback error.", gVar);
                                                                            a(r6, r6);
                                                                            this.F.obtainMessage(r7, gVar).sendToTarget();
                                                                            d();
                                                                            return true;
                                                                        } catch (IOException e13) {
                                                                            iOException = e13;
                                                                            r5 = 0;
                                                                            Log.e(d, "Source error.", iOException);
                                                                            a(r5, r5);
                                                                            this.F.obtainMessage(r8, g.a(iOException)).sendToTarget();
                                                                            d();
                                                                            return true;
                                                                        } catch (RuntimeException e14) {
                                                                            runtimeException = e14;
                                                                            r4 = 0;
                                                                            Log.e(d, "Internal runtime error.", runtimeException);
                                                                            a(r4, r4);
                                                                            this.F.obtainMessage(2, g.a(runtimeException)).sendToTarget();
                                                                            d();
                                                                            return true;
                                                                        }
                                                                    }
                                                                } else {
                                                                    if (iA != i8) {
                                                                        this.R = this.R.a(iA);
                                                                    }
                                                                    com.anythink.basead.exoplayer.h.s.a aVar2 = this.R.c;
                                                                    if (aVar2.a()) {
                                                                        com.anythink.basead.exoplayer.h.s.a aVarA6 = this.P.a(iA, j8);
                                                                        if (!aVarA6.equals(aVar2)) {
                                                                            if (!aVarA6.a()) {
                                                                                j6 = j8;
                                                                            }
                                                                            this.R = this.R.a(aVarA6, a(aVarA6, j6), j8);
                                                                        } else if (!this.P.a(aVar2, this.ab)) {
                                                                            r11 = 0;
                                                                            g(false);
                                                                        }
                                                                    } else if (!this.P.a(aVar2, this.ab)) {
                                                                        r11 = 0;
                                                                        g(false);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        r11 = i4;
                                                    } catch (g e15) {
                                                        e = e15;
                                                        r3 = r11;
                                                        gVar = e;
                                                        r6 = r3;
                                                        r7 = c3;
                                                        Log.e(d, "Playback error.", gVar);
                                                        a(r6, r6);
                                                        this.F.obtainMessage(r7, gVar).sendToTarget();
                                                        d();
                                                        return true;
                                                    } catch (IOException e16) {
                                                        e = e16;
                                                        r2 = r11;
                                                        iOException = e;
                                                        r5 = r2;
                                                        r8 = c2;
                                                        Log.e(d, "Source error.", iOException);
                                                        a(r5, r5);
                                                        this.F.obtainMessage(r8, g.a(iOException)).sendToTarget();
                                                        d();
                                                        return true;
                                                    }
                                                    break;
                                                }
                                                d();
                                                return true;
                                            case 9:
                                                if (this.P.a((com.anythink.basead.exoplayer.h.r) message3.obj)) {
                                                    q qVarB3 = this.P.b();
                                                    float f2 = this.L.e().b;
                                                    qVarB3.f = true;
                                                    qVarB3.j = qVarB3.a.b();
                                                    qVarB3.a(f2);
                                                    long jB2 = qVarB3.b(qVarB3.h.b);
                                                    qVarB3.e += qVarB3.h.b - jB2;
                                                    r rVar = qVarB3.h;
                                                    qVarB3.h = new r(rVar.a, jB2, rVar.c, rVar.d, rVar.e, rVar.f, rVar.g);
                                                    a(qVarB3.k);
                                                    if (!this.P.f()) {
                                                        a(this.P.h().h.b);
                                                        a(null);
                                                    }
                                                    r();
                                                }
                                                d();
                                                return true;
                                            case 10:
                                                if (this.P.a((com.anythink.basead.exoplayer.h.r) message3.obj)) {
                                                    this.P.a(this.ab);
                                                    r();
                                                }
                                                d();
                                                return true;
                                            case 11:
                                                if (this.P.f()) {
                                                    float f3 = this.L.e().b;
                                                    q qVarC4 = this.P.c();
                                                    q qVarD3 = this.P.d();
                                                    boolean z13 = true;
                                                    while (qVarC4 != null && qVarC4.f) {
                                                        if (!qVarC4.a(f3)) {
                                                            if (qVarC4 == qVarD3) {
                                                                z13 = false;
                                                            }
                                                            qVarC4 = qVarC4.i;
                                                            z13 = z13;
                                                        } else {
                                                            if (z13) {
                                                                q qVarC5 = this.P.c();
                                                                boolean zA3 = this.P.a(qVarC5);
                                                                boolean[] zArr = new boolean[this.y.length];
                                                                long jA4 = qVarC5.a(this.R.j, zA3, zArr);
                                                                a(qVarC5.k);
                                                                if (this.R.f != 4 && jA4 != this.R.j) {
                                                                    u uVar2 = this.R;
                                                                    this.R = uVar2.a(uVar2.c, jA4, this.R.e);
                                                                    this.M.b(4);
                                                                    a(jA4);
                                                                }
                                                                boolean[] zArr2 = new boolean[this.y.length];
                                                                int i9 = 0;
                                                                int i10 = 0;
                                                                while (true) {
                                                                    y[] yVarArr4 = this.y;
                                                                    if (i9 < yVarArr4.length) {
                                                                        y yVar8 = yVarArr4[i9];
                                                                        zArr2[i9] = yVar8.a_() != 0;
                                                                        com.anythink.basead.exoplayer.h.y yVar9 = qVarC5.c[i9];
                                                                        if (yVar9 != null) {
                                                                            i10++;
                                                                        }
                                                                        if (zArr2[i9]) {
                                                                            if (yVar9 != yVar8.f()) {
                                                                                b(yVar8);
                                                                            } else if (zArr[i9]) {
                                                                                yVar8.a(this.ab);
                                                                            }
                                                                        }
                                                                        i9++;
                                                                    } else {
                                                                        this.R = this.R.a(qVarC5.j, qVarC5.k);
                                                                        a(zArr2, i10);
                                                                    }
                                                                }
                                                            } else {
                                                                this.P.a(qVarC4);
                                                                if (qVarC4.f) {
                                                                    qVarC4.b(Math.max(qVarC4.h.b, this.ab - qVarC4.e));
                                                                    a(qVarC4.k);
                                                                }
                                                            }
                                                            if (this.R.f != 4) {
                                                                r();
                                                                g();
                                                                this.D.b(2);
                                                            }
                                                        }
                                                    }
                                                }
                                                d();
                                                return true;
                                            case 12:
                                                int i11 = message3.arg1;
                                                this.X = i11;
                                                if (!this.P.a(i11)) {
                                                    g(true);
                                                }
                                                d();
                                                return true;
                                            case 13:
                                                boolean z14 = message3.arg1 != 0;
                                                this.Y = z14;
                                                if (!this.P.a(z14)) {
                                                    g(true);
                                                }
                                                d();
                                                return true;
                                            case 14:
                                                x xVar = (x) message3.obj;
                                                if (xVar.f() == -9223372036854775807L) {
                                                    d(xVar);
                                                } else if (this.S == null || this.Z > 0) {
                                                    this.N.add(new b(xVar));
                                                } else {
                                                    b bVar = new b(xVar);
                                                    if (a(bVar)) {
                                                        this.N.add(bVar);
                                                        Collections.sort(this.N);
                                                    } else {
                                                        xVar.a(false);
                                                    }
                                                }
                                                d();
                                                return true;
                                            case 15:
                                                x xVar2 = (x) message3.obj;
                                                xVar2.e().post(new AnonymousClass1(xVar2));
                                                d();
                                                return true;
                                            default:
                                                return false;
                                        }
                                    } catch (RuntimeException e17) {
                                        runtimeException = e17;
                                        r4 = 0;
                                    }
                                } catch (RuntimeException e18) {
                                    e = e18;
                                    message2 = message3;
                                }
                            } catch (RuntimeException e19) {
                                runtimeException = e19;
                                r4 = 0;
                            }
                        } catch (g e20) {
                            gVar = e20;
                            r9 = message3;
                            r6 = 0;
                            r7 = r9;
                            Log.e(d, "Playback error.", gVar);
                            a(r6, r6);
                            this.F.obtainMessage(r7, gVar).sendToTarget();
                            d();
                            return true;
                        } catch (IOException e21) {
                            iOException = e21;
                            r10 = message3;
                            r5 = 0;
                            r8 = r10;
                            Log.e(d, "Source error.", iOException);
                            a(r5, r5);
                            this.F.obtainMessage(r8, g.a(iOException)).sendToTarget();
                            d();
                            return true;
                        }
                    } catch (g e22) {
                        gVar = e22;
                        r6 = 0;
                        r7 = r9;
                        Log.e(d, "Playback error.", gVar);
                        a(r6, r6);
                        this.F.obtainMessage(r7, gVar).sendToTarget();
                        d();
                        return true;
                    } catch (IOException e23) {
                        iOException = e23;
                        r5 = 0;
                        r8 = r10;
                        Log.e(d, "Source error.", iOException);
                        a(r5, r5);
                        this.F.obtainMessage(r8, g.a(iOException)).sendToTarget();
                        d();
                        return true;
                    }
                } catch (g e24) {
                    gVar = e24;
                    z2 = false;
                } catch (IOException e25) {
                    iOException = e25;
                    z = false;
                }
            } catch (RuntimeException e26) {
                e = e26;
                message2 = null;
            }
        } catch (g e27) {
            e = e27;
            r3 = 0;
        } catch (IOException e28) {
            e = e28;
            r2 = 0;
        }
    }

    private void b(int i2) {
        if (this.R.f != i2) {
            this.R = this.R.b(i2);
        }
    }

    private void d(boolean z) {
        if (this.R.g != z) {
            this.R = this.R.a(z);
        }
    }

    private void d() {
        if (this.M.a(this.R)) {
            this.F.obtainMessage(0, this.M.b, this.M.c ? this.M.d : -1, this.R).sendToTarget();
            this.M.b(this.R);
        }
    }

    private void b(com.anythink.basead.exoplayer.h.s sVar, boolean z, boolean z2) {
        this.Z++;
        a(true, z, z2);
        this.C.a();
        this.S = sVar;
        b(2);
        sVar.a(this.G, true, this);
        this.D.b(2);
    }

    private void e(boolean z) {
        this.W = false;
        this.V = z;
        if (!z) {
            f();
            g();
        } else if (this.R.f == 3) {
            e();
            this.D.b(2);
        } else if (this.R.f == 2) {
            this.D.b(2);
        }
    }

    private void c(int i2) throws g {
        this.X = i2;
        if (this.P.a(i2)) {
            return;
        }
        g(true);
    }

    private void f(boolean z) throws g {
        this.Y = z;
        if (this.P.a(z)) {
            return;
        }
        g(true);
    }

    private void g(boolean z) throws g {
        com.anythink.basead.exoplayer.h.s.a aVar = this.P.c().h.a;
        long jA = a(aVar, this.R.j, true);
        if (jA != this.R.j) {
            u uVar = this.R;
            this.R = uVar.a(aVar, jA, uVar.e);
            if (z) {
                this.M.b(4);
            }
        }
    }

    private void e() {
        this.W = false;
        this.L.a();
        for (y yVar : this.T) {
            yVar.b_();
        }
    }

    private void f() {
        this.L.b();
        for (y yVar : this.T) {
            a(yVar);
        }
    }

    private void g() {
        long jA;
        if (this.P.f()) {
            q qVarC = this.P.c();
            long jC = qVarC.a.c();
            if (jC != -9223372036854775807L) {
                a(jC);
                if (jC != this.R.j) {
                    u uVar = this.R;
                    this.R = uVar.a(uVar.c, jC, this.R.e);
                    this.M.b(4);
                }
            } else {
                long jC2 = this.L.c();
                this.ab = jC2;
                long j2 = jC2 - qVarC.e;
                b(this.R.j, j2);
                this.R.j = j2;
            }
            u uVar2 = this.R;
            if (this.T.length == 0) {
                jA = qVarC.h.e;
            } else {
                jA = qVarC.a(true);
            }
            uVar2.k = jA;
        }
    }

    /* JADX WARN: Code duplicated, block: B:116:0x021c  */
    /* JADX WARN: Code duplicated, block: B:149:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:154:0x02b3  */
    /* JADX WARN: Code duplicated, block: B:87:0x019d  */
    private void h() throws g {
        boolean zM;
        boolean z;
        long jB = this.O.b();
        com.anythink.basead.exoplayer.h.s sVar = this.S;
        int i2 = 0;
        boolean z2 = true;
        if (sVar != null) {
            if (this.Z > 0) {
                sVar.b();
            } else {
                this.P.a(this.ab);
                if (this.P.a()) {
                    r rVarA = this.P.a(this.ab, this.R);
                    if (rVarA == null) {
                        this.S.b();
                    } else {
                        this.P.a(this.z, this.A, this.C.d(), this.S, this.R.a.a(rVarA.a.a, this.I, true).b, rVarA).a(this, rVarA.b);
                        d(true);
                    }
                }
                q qVarB = this.P.b();
                if (qVarB == null || qVarB.a()) {
                    d(false);
                } else if (!this.R.g) {
                    r();
                }
                if (this.P.f()) {
                    q qVarC = this.P.c();
                    q qVarD = this.P.d();
                    boolean z3 = false;
                    while (this.V && qVarC != qVarD && this.ab >= qVarC.i.e) {
                        if (z3) {
                            d();
                        }
                        int i3 = qVarC.h.f ? i2 : 3;
                        q qVarH = this.P.h();
                        a(qVarC);
                        this.R = this.R.a(qVarH.h.a, qVarH.h.b, qVarH.h.d);
                        this.M.b(i3);
                        g();
                        z3 = true;
                        qVarC = qVarH;
                        i2 = 0;
                    }
                    if (qVarD.h.g) {
                        int i4 = 0;
                        while (true) {
                            y[] yVarArr = this.y;
                            if (i4 >= yVarArr.length) {
                                break;
                            }
                            y yVar = yVarArr[i4];
                            com.anythink.basead.exoplayer.h.y yVar2 = qVarD.c[i4];
                            if (yVar2 != null && yVar.f() == yVar2 && yVar.g()) {
                                yVar.h();
                            }
                            i4++;
                        }
                    } else if (qVarD.i != null && qVarD.i.f) {
                        int i5 = 0;
                        while (true) {
                            y[] yVarArr2 = this.y;
                            if (i5 < yVarArr2.length) {
                                y yVar3 = yVarArr2[i5];
                                com.anythink.basead.exoplayer.h.y yVar4 = qVarD.c[i5];
                                if (yVar3.f() != yVar4 || (yVar4 != null && !yVar3.g())) {
                                    break;
                                } else {
                                    i5++;
                                }
                            } else {
                                com.anythink.basead.exoplayer.i.i iVar = qVarD.k;
                                q qVarG = this.P.g();
                                com.anythink.basead.exoplayer.i.i iVar2 = qVarG.k;
                                boolean z4 = qVarG.a.c() != -9223372036854775807L;
                                int i6 = 0;
                                while (true) {
                                    y[] yVarArr3 = this.y;
                                    if (i6 >= yVarArr3.length) {
                                        break;
                                    }
                                    y yVar5 = yVarArr3[i6];
                                    if (iVar.a(i6)) {
                                        if (!z4) {
                                            if (!yVar5.i()) {
                                                com.anythink.basead.exoplayer.i.f fVarA = iVar2.c.a(i6);
                                                boolean zA = iVar2.a(i6);
                                                boolean z5 = this.z[i6].a() == 5 ? z2 : false;
                                                aa aaVar = iVar.b[i6];
                                                aa aaVar2 = iVar2.b[i6];
                                                if (zA && aaVar2.equals(aaVar) && !z5) {
                                                    yVar5.a(a(fVarA), qVarG.c[i6], qVarG.e);
                                                } else {
                                                    yVar5.h();
                                                }
                                            }
                                        } else {
                                            yVar5.h();
                                        }
                                    }
                                    i6++;
                                    z2 = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (!this.P.f()) {
            n();
            a(jB, 10L);
            return;
        }
        q qVarC2 = this.P.c();
        com.anythink.basead.exoplayer.k.ad.a("doSomeWork");
        g();
        long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        qVarC2.a.a(this.R.j - this.J, this.K);
        boolean z6 = true;
        boolean z7 = true;
        for (y yVar6 : this.T) {
            yVar6.a(this.ab, jElapsedRealtime);
            z7 = z7 && yVar6.v();
            if (yVar6.u() || yVar6.v()) {
                z = true;
            } else {
                q qVarD2 = this.P.d();
                if (qVarD2.i != null && qVarD2.i.f && yVar6.g()) {
                    z = true;
                } else {
                    z = false;
                }
            }
            if (!z) {
                yVar6.j();
            }
            z6 = z6 && z;
        }
        if (!z6) {
            n();
        }
        long j2 = qVarC2.h.e;
        if (z7 && ((j2 == -9223372036854775807L || j2 <= this.R.j) && qVarC2.h.g)) {
            b(4);
            f();
        } else if (this.R.f != 2) {
            if (this.R.f == 3 && (this.T.length != 0 ? !z6 : !m())) {
                this.W = this.V;
                b(2);
                f();
            }
        } else {
            if (this.T.length == 0) {
                zM = m();
            } else if (!z6) {
                zM = false;
            } else if (this.R.g) {
                q qVarB2 = this.P.b();
                long jA = qVarB2.a(!qVarB2.h.g);
                if (jA == Long.MIN_VALUE || this.C.a(jA - (this.ab - qVarB2.e), this.L.e().b, this.W)) {
                    zM = true;
                } else {
                    zM = false;
                }
            } else {
                zM = true;
            }
            if (zM) {
                b(3);
                if (this.V) {
                    e();
                }
            } else if (this.R.f == 3) {
                this.W = this.V;
                b(2);
                f();
            }
        }
        if (this.R.f == 2) {
            for (y yVar7 : this.T) {
                yVar7.j();
            }
        }
        if ((this.V && this.R.f == 3) || this.R.f == 2) {
            a(jB, 10L);
        } else if (this.T.length != 0 && this.R.f != 4) {
            a(jB, 1000L);
        } else {
            this.D.b();
        }
        com.anythink.basead.exoplayer.k.ad.a();
    }

    private void a(long j2, long j3) {
        this.D.b();
        this.D.a(j2 + j3);
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00d4 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:56:? A[RETURN, SYNTHETIC] */
    private void a(d dVar) {
        long jLongValue;
        boolean z;
        com.anythink.basead.exoplayer.h.s.a aVar;
        long j2;
        long j3;
        u uVarA;
        long jA;
        boolean z2 = true;
        this.M.a(1);
        Pair<Integer, Long> pairA = a(dVar, true);
        if (pairA == null) {
            aVar = new com.anythink.basead.exoplayer.h.s.a(j());
            z = true;
            jLongValue = -9223372036854775807L;
            j2 = -9223372036854775807L;
        } else {
            int iIntValue = ((Integer) pairA.first).intValue();
            long jLongValue2 = ((Long) pairA.second).longValue();
            com.anythink.basead.exoplayer.h.s.a aVarA = this.P.a(iIntValue, jLongValue2);
            if (aVarA.a()) {
                z = true;
                jLongValue = 0;
            } else {
                jLongValue = ((Long) pairA.second).longValue();
                z = dVar.c == -9223372036854775807L;
            }
            aVar = aVarA;
            j2 = jLongValue2;
        }
        try {
            if (this.S == null || this.Z > 0) {
                this.aa = dVar;
            } else {
                if (jLongValue == -9223372036854775807L) {
                    b(4);
                    a(false, true, false);
                } else {
                    if (aVar.equals(this.R.c)) {
                        q qVarC = this.P.c();
                        jA = (qVarC == null || jLongValue == 0) ? jLongValue : qVarC.a.a(jLongValue, this.Q);
                        if (com.anythink.basead.exoplayer.b.a(jA) == com.anythink.basead.exoplayer.b.a(this.R.j)) {
                            uVarA = this.R.a(aVar, this.R.j, j2);
                            if (z) {
                                return;
                            } else {
                                return;
                            }
                        }
                    } else {
                        jA = jLongValue;
                    }
                    long jA2 = a(aVar, jA);
                    if (jLongValue == jA2) {
                        z2 = false;
                    }
                    z |= z2;
                    j3 = jA2;
                }
                uVarA = this.R.a(aVar, j3, j2);
            }
            j3 = jLongValue;
            uVarA = this.R.a(aVar, j3, j2);
        } finally {
            this.R = this.R.a(aVar, jLongValue, j2);
            if (z) {
                this.M.b(2);
            }
        }
    }

    private long a(com.anythink.basead.exoplayer.h.s.a aVar, long j2) {
        return a(aVar, j2, this.P.c() != this.P.d());
    }

    private long a(com.anythink.basead.exoplayer.h.s.a aVar, long j2, boolean z) throws g {
        f();
        this.W = false;
        b(2);
        q qVarC = this.P.c();
        q qVarH = qVarC;
        while (qVarH != null) {
            if (a(aVar, j2, qVarH)) {
                this.P.a(qVarH);
                break;
            }
            qVarH = this.P.h();
        }
        if (qVarC != qVarH || z) {
            for (y yVar : this.T) {
                b(yVar);
            }
            this.T = new y[0];
            qVarC = null;
        }
        if (qVarH != null) {
            a(qVarC);
            if (qVarH.g) {
                long jB = qVarH.a.b(j2);
                qVarH.a.a(jB - this.J, this.K);
                j2 = jB;
            }
            a(j2);
            r();
        } else {
            this.P.b(true);
            a(j2);
        }
        this.D.b(2);
        return j2;
    }

    private boolean a(com.anythink.basead.exoplayer.h.s.a aVar, long j2, q qVar) {
        if (aVar.equals(qVar.h.a) && qVar.f) {
            this.R.a.a(qVar.h.a.a, this.I, false);
            int iB = this.I.b(j2);
            if (iB == -1 || this.I.a(iB) == qVar.h.c) {
                return true;
            }
        }
        return false;
    }

    private void a(long j2) {
        if (this.P.f()) {
            j2 += this.P.c().e;
        }
        this.ab = j2;
        this.L.a(j2);
        for (y yVar : this.T) {
            yVar.a(this.ab);
        }
    }

    private void c(v vVar) {
        this.L.a(vVar);
    }

    private void b(ac acVar) {
        this.Q = acVar;
    }

    private void a(boolean z, boolean z2) {
        a(true, z, z);
        this.M.a(this.Z + (z2 ? 1 : 0));
        this.Z = 0;
        this.C.b();
        b(1);
    }

    private void i() {
        a(true, true, true);
        this.C.c();
        b(1);
        this.E.quitSafely();
        synchronized (this) {
            this.U = true;
            notifyAll();
        }
    }

    private int j() {
        ae aeVar = this.R.a;
        if (aeVar.a()) {
            return 0;
        }
        return aeVar.a(aeVar.b(this.Y), this.H, false).f;
    }

    private void a(boolean z, boolean z2, boolean z3) {
        com.anythink.basead.exoplayer.h.s sVar;
        this.D.b();
        this.W = false;
        this.L.b();
        this.ab = 0L;
        for (y yVar : this.T) {
            try {
                b(yVar);
            } catch (g | RuntimeException e2) {
                Log.e(d, "Stop failed.", e2);
            }
        }
        this.T = new y[0];
        this.P.b(!z2);
        d(false);
        if (z2) {
            this.aa = null;
        }
        if (z3) {
            this.P.a(ae.a);
            Iterator<b> it = this.N.iterator();
            while (it.hasNext()) {
                it.next().a.a(false);
            }
            this.N.clear();
            this.ac = 0;
        }
        this.R = new u(z3 ? ae.a : this.R.a, z3 ? null : this.R.b, z2 ? new com.anythink.basead.exoplayer.h.s.a(j()) : this.R.c, z2 ? -9223372036854775807L : this.R.j, z2 ? -9223372036854775807L : this.R.e, this.R.f, false, z3 ? af.a : this.R.h, z3 ? this.B : this.R.i);
        if (!z || (sVar = this.S) == null) {
            return;
        }
        sVar.a(this);
        this.S = null;
    }

    private void c(x xVar) {
        if (xVar.f() == -9223372036854775807L) {
            d(xVar);
            return;
        }
        if (this.S == null || this.Z > 0) {
            this.N.add(new b(xVar));
            return;
        }
        b bVar = new b(xVar);
        if (a(bVar)) {
            this.N.add(bVar);
            Collections.sort(this.N);
        } else {
            xVar.a(false);
        }
    }

    private void d(x xVar) {
        if (xVar.e().getLooper() == this.D.a()) {
            f(xVar);
            if (this.R.f == 3 || this.R.f == 2) {
                this.D.b(2);
                return;
            }
            return;
        }
        this.D.a(15, xVar).sendToTarget();
    }

    private void e(x xVar) {
        xVar.e().post(new AnonymousClass1(xVar));
    }

    /* JADX INFO: renamed from: com.anythink.basead.exoplayer.k$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ x a;

        AnonymousClass1(x xVar) {
            this.a = xVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                k.f(this.a);
            } catch (g e) {
                Log.e(k.d, "Unexpected error delivering message on external thread.", e);
                throw new RuntimeException(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(x xVar) {
        if (xVar.j()) {
            return;
        }
        try {
            xVar.b().a(xVar.c(), xVar.d());
        } finally {
            xVar.a(true);
        }
    }

    private void k() {
        for (int size = this.N.size() - 1; size >= 0; size--) {
            if (!a(this.N.get(size))) {
                this.N.get(size).a.a(false);
                this.N.remove(size);
            }
        }
        Collections.sort(this.N);
    }

    private boolean a(b bVar) {
        if (bVar.d == null) {
            Pair<Integer, Long> pairA = a(new d(bVar.a.a(), bVar.a.g(), com.anythink.basead.exoplayer.b.b(bVar.a.f())), false);
            if (pairA == null) {
                return false;
            }
            bVar.a(((Integer) pairA.first).intValue(), ((Long) pairA.second).longValue(), this.R.a.a(((Integer) pairA.first).intValue(), this.I, true).b);
        } else {
            int iA = this.R.a.a(bVar.d);
            if (iA == -1) {
                return false;
            }
            bVar.b = iA;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x0036, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x006f, code lost:
    
        r1 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(long r6, long r8) {
        /*
            Method dump skipped, instruction units count: 238
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.basead.exoplayer.k.b(long, long):void");
    }

    private static void a(y yVar) {
        if (yVar.a_() == 2) {
            yVar.k();
        }
    }

    private void b(y yVar) {
        this.L.b(yVar);
        a(yVar);
        yVar.l();
    }

    private void l() throws g {
        if (this.P.f()) {
            float f2 = this.L.e().b;
            q qVarD = this.P.d();
            boolean z = true;
            for (q qVarC = this.P.c(); qVarC != null && qVarC.f; qVarC = qVarC.i) {
                if (!qVarC.a(f2)) {
                    if (qVarC == qVarD) {
                        z = false;
                    }
                } else {
                    if (z) {
                        q qVarC2 = this.P.c();
                        boolean zA = this.P.a(qVarC2);
                        boolean[] zArr = new boolean[this.y.length];
                        long jA = qVarC2.a(this.R.j, zA, zArr);
                        a(qVarC2.k);
                        if (this.R.f != 4 && jA != this.R.j) {
                            u uVar = this.R;
                            this.R = uVar.a(uVar.c, jA, this.R.e);
                            this.M.b(4);
                            a(jA);
                        }
                        boolean[] zArr2 = new boolean[this.y.length];
                        int i2 = 0;
                        int i3 = 0;
                        while (true) {
                            y[] yVarArr = this.y;
                            if (i2 >= yVarArr.length) {
                                break;
                            }
                            y yVar = yVarArr[i2];
                            zArr2[i2] = yVar.a_() != 0;
                            com.anythink.basead.exoplayer.h.y yVar2 = qVarC2.c[i2];
                            if (yVar2 != null) {
                                i3++;
                            }
                            if (zArr2[i2]) {
                                if (yVar2 != yVar.f()) {
                                    b(yVar);
                                } else if (zArr[i2]) {
                                    yVar.a(this.ab);
                                }
                            }
                            i2++;
                        }
                        this.R = this.R.a(qVarC2.j, qVarC2.k);
                        a(zArr2, i3);
                    } else {
                        this.P.a(qVarC);
                        if (qVarC.f) {
                            qVarC.b(Math.max(qVarC.h.b, this.ab - qVarC.e));
                            a(qVarC.k);
                        }
                    }
                    if (this.R.f != 4) {
                        r();
                        g();
                        this.D.b(2);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private void a(com.anythink.basead.exoplayer.i.i iVar) {
        this.C.a(this.y, iVar.c);
    }

    private void a(float f2) {
        for (q qVarE = this.P.e(); qVarE != null; qVarE = qVarE.i) {
            if (qVarE.k != null) {
                for (com.anythink.basead.exoplayer.i.f fVar : qVarE.k.c.a()) {
                    if (fVar != null) {
                        fVar.a(f2);
                    }
                }
            }
        }
    }

    private boolean h(boolean z) {
        if (this.T.length == 0) {
            return m();
        }
        if (!z) {
            return false;
        }
        if (!this.R.g) {
            return true;
        }
        q qVarB = this.P.b();
        long jA = qVarB.a(!qVarB.h.g);
        return jA == Long.MIN_VALUE || this.C.a(jA - (this.ab - qVarB.e), this.L.e().b, this.W);
    }

    private boolean m() {
        q qVarC = this.P.c();
        long j2 = qVarC.h.e;
        if (j2 == -9223372036854775807L || this.R.j < j2) {
            return true;
        }
        if (qVarC.i != null) {
            return qVarC.i.f || qVarC.i.h.a.a();
        }
        return false;
    }

    private void n() {
        q qVarB = this.P.b();
        q qVarD = this.P.d();
        if (qVarB == null || qVarB.f) {
            return;
        }
        if (qVarD == null || qVarD.i == qVarB) {
            for (y yVar : this.T) {
                if (!yVar.g()) {
                    return;
                }
            }
            qVarB.a.a();
        }
    }

    private void a(a aVar) throws g {
        if (aVar.a != this.S) {
            return;
        }
        ae aeVar = this.R.a;
        ae aeVar2 = aVar.b;
        Object obj = aVar.c;
        this.P.a(aeVar2);
        this.R = this.R.a(aeVar2, obj);
        for (int size = this.N.size() - 1; size >= 0; size--) {
            if (!a(this.N.get(size))) {
                this.N.get(size).a.a(false);
                this.N.remove(size);
            }
        }
        Collections.sort(this.N);
        int i2 = this.Z;
        if (i2 > 0) {
            this.M.a(i2);
            this.Z = 0;
            d dVar = this.aa;
            if (dVar != null) {
                Pair<Integer, Long> pairA = a(dVar, true);
                this.aa = null;
                if (pairA == null) {
                    o();
                    return;
                }
                int iIntValue = ((Integer) pairA.first).intValue();
                long jLongValue = ((Long) pairA.second).longValue();
                com.anythink.basead.exoplayer.h.s.a aVarA = this.P.a(iIntValue, jLongValue);
                this.R = this.R.a(aVarA, aVarA.a() ? 0L : jLongValue, jLongValue);
                return;
            }
            if (this.R.d == -9223372036854775807L) {
                if (aeVar2.a()) {
                    o();
                    return;
                }
                Pair<Integer, Long> pairA2 = a(aeVar2, aeVar2.b(this.Y));
                int iIntValue2 = ((Integer) pairA2.first).intValue();
                long jLongValue2 = ((Long) pairA2.second).longValue();
                com.anythink.basead.exoplayer.h.s.a aVarA2 = this.P.a(iIntValue2, jLongValue2);
                this.R = this.R.a(aVarA2, aVarA2.a() ? 0L : jLongValue2, jLongValue2);
                return;
            }
            return;
        }
        int i3 = this.R.c.a;
        long j2 = this.R.e;
        if (aeVar.a()) {
            if (aeVar2.a()) {
                return;
            }
            com.anythink.basead.exoplayer.h.s.a aVarA3 = this.P.a(i3, j2);
            this.R = this.R.a(aVarA3, aVarA3.a() ? 0L : j2, j2);
            return;
        }
        q qVarE = this.P.e();
        int iA = aeVar2.a(qVarE == null ? aeVar.a(i3, this.I, true).b : qVarE.b);
        if (iA == -1) {
            int iA2 = a(i3, aeVar, aeVar2);
            if (iA2 == -1) {
                o();
                return;
            }
            Pair<Integer, Long> pairA3 = a(aeVar2, aeVar2.a(iA2, this.I, false).c);
            int iIntValue3 = ((Integer) pairA3.first).intValue();
            long jLongValue3 = ((Long) pairA3.second).longValue();
            com.anythink.basead.exoplayer.h.s.a aVarA4 = this.P.a(iIntValue3, jLongValue3);
            aeVar2.a(iIntValue3, this.I, true);
            if (qVarE != null) {
                Object obj2 = this.I.b;
                qVarE.h = qVarE.h.a();
                while (qVarE.i != null) {
                    qVarE = qVarE.i;
                    if (qVarE.b.equals(obj2)) {
                        qVarE.h = this.P.a(qVarE.h, iIntValue3);
                    } else {
                        qVarE.h = qVarE.h.a();
                    }
                }
            }
            this.R = this.R.a(aVarA4, a(aVarA4, aVarA4.a() ? 0L : jLongValue3), jLongValue3);
            return;
        }
        if (iA != i3) {
            this.R = this.R.a(iA);
        }
        com.anythink.basead.exoplayer.h.s.a aVar2 = this.R.c;
        if (aVar2.a()) {
            com.anythink.basead.exoplayer.h.s.a aVarA5 = this.P.a(iA, j2);
            if (!aVarA5.equals(aVar2)) {
                this.R = this.R.a(aVarA5, a(aVarA5, aVarA5.a() ? 0L : j2), j2);
                return;
            }
        }
        if (this.P.a(aVar2, this.ab)) {
            return;
        }
        g(false);
    }

    private void o() {
        b(4);
        a(false, true, false);
    }

    private int a(int i2, ae aeVar, ae aeVar2) {
        int iC = aeVar.c();
        int iA = i2;
        int iA2 = -1;
        for (int i3 = 0; i3 < iC && iA2 == -1; i3++) {
            iA = aeVar.a(iA, this.I, this.H, this.X, this.Y);
            if (iA == -1) {
                break;
            }
            iA2 = aeVar2.a(aeVar.a(iA, this.I, true).b);
        }
        return iA2;
    }

    private Pair<Integer, Long> a(d dVar, boolean z) {
        int iA;
        ae aeVar = this.R.a;
        ae aeVar2 = dVar.a;
        if (aeVar.a()) {
            return null;
        }
        if (aeVar2.a()) {
            aeVar2 = aeVar;
        }
        try {
            Pair<Integer, Long> pairA = aeVar2.a(this.H, this.I, dVar.b, dVar.c);
            if (aeVar == aeVar2) {
                return pairA;
            }
            int iA2 = aeVar.a(aeVar2.a(((Integer) pairA.first).intValue(), this.I, true).b);
            if (iA2 != -1) {
                return Pair.create(Integer.valueOf(iA2), (Long) pairA.second);
            }
            if (!z || (iA = a(((Integer) pairA.first).intValue(), aeVar2, aeVar)) == -1) {
                return null;
            }
            return a(aeVar, aeVar.a(iA, this.I, false).c);
        } catch (IndexOutOfBoundsException unused) {
            throw new o(aeVar, dVar.b, dVar.c);
        }
    }

    private Pair<Integer, Long> a(ae aeVar, int i2) {
        return aeVar.a(this.H, this.I, i2, -9223372036854775807L);
    }

    /* JADX WARN: Code duplicated, block: B:91:0x018e  */
    private void p() throws g {
        com.anythink.basead.exoplayer.h.s sVar = this.S;
        if (sVar == null) {
            return;
        }
        if (this.Z > 0) {
            sVar.b();
            return;
        }
        this.P.a(this.ab);
        if (this.P.a()) {
            r rVarA = this.P.a(this.ab, this.R);
            if (rVarA == null) {
                this.S.b();
            } else {
                this.P.a(this.z, this.A, this.C.d(), this.S, this.R.a.a(rVarA.a.a, this.I, true).b, rVarA).a(this, rVarA.b);
                d(true);
            }
        }
        q qVarB = this.P.b();
        int i2 = 0;
        if (qVarB == null || qVarB.a()) {
            d(false);
        } else if (!this.R.g) {
            r();
        }
        if (!this.P.f()) {
            return;
        }
        q qVarC = this.P.c();
        q qVarD = this.P.d();
        boolean z = false;
        while (this.V && qVarC != qVarD && this.ab >= qVarC.i.e) {
            if (z) {
                d();
            }
            int i3 = qVarC.h.f ? 0 : 3;
            q qVarH = this.P.h();
            a(qVarC);
            this.R = this.R.a(qVarH.h.a, qVarH.h.b, qVarH.h.d);
            this.M.b(i3);
            g();
            z = true;
            qVarC = qVarH;
        }
        if (qVarD.h.g) {
            while (true) {
                y[] yVarArr = this.y;
                if (i2 >= yVarArr.length) {
                    return;
                }
                y yVar = yVarArr[i2];
                com.anythink.basead.exoplayer.h.y yVar2 = qVarD.c[i2];
                if (yVar2 != null && yVar.f() == yVar2 && yVar.g()) {
                    yVar.h();
                }
                i2++;
            }
        } else {
            if (qVarD.i == null || !qVarD.i.f) {
                return;
            }
            int i4 = 0;
            while (true) {
                y[] yVarArr2 = this.y;
                if (i4 < yVarArr2.length) {
                    y yVar3 = yVarArr2[i4];
                    com.anythink.basead.exoplayer.h.y yVar4 = qVarD.c[i4];
                    if (yVar3.f() != yVar4) {
                        return;
                    }
                    if (yVar4 != null && !yVar3.g()) {
                        return;
                    } else {
                        i4++;
                    }
                } else {
                    com.anythink.basead.exoplayer.i.i iVar = qVarD.k;
                    q qVarG = this.P.g();
                    com.anythink.basead.exoplayer.i.i iVar2 = qVarG.k;
                    boolean z2 = qVarG.a.c() != -9223372036854775807L;
                    int i5 = 0;
                    while (true) {
                        y[] yVarArr3 = this.y;
                        if (i5 >= yVarArr3.length) {
                            return;
                        }
                        y yVar5 = yVarArr3[i5];
                        if (iVar.a(i5)) {
                            if (!z2) {
                                if (!yVar5.i()) {
                                    com.anythink.basead.exoplayer.i.f fVarA = iVar2.c.a(i5);
                                    boolean zA = iVar2.a(i5);
                                    boolean z3 = this.z[i5].a() == 5;
                                    aa aaVar = iVar.b[i5];
                                    aa aaVar2 = iVar2.b[i5];
                                    if (zA && aaVar2.equals(aaVar) && !z3) {
                                        yVar5.a(a(fVarA), qVarG.c[i5], qVarG.e);
                                    } else {
                                        yVar5.h();
                                    }
                                }
                            } else {
                                yVar5.h();
                            }
                        }
                        i5++;
                    }
                }
            }
        }
    }

    private void q() {
        this.P.a(this.ab);
        if (this.P.a()) {
            r rVarA = this.P.a(this.ab, this.R);
            if (rVarA == null) {
                this.S.b();
                return;
            }
            this.P.a(this.z, this.A, this.C.d(), this.S, this.R.a.a(rVarA.a.a, this.I, true).b, rVarA).a(this, rVarA.b);
            d(true);
        }
    }

    private void c(com.anythink.basead.exoplayer.h.r rVar) throws g {
        if (this.P.a(rVar)) {
            q qVarB = this.P.b();
            float f2 = this.L.e().b;
            qVarB.f = true;
            qVarB.j = qVarB.a.b();
            qVarB.a(f2);
            long jB = qVarB.b(qVarB.h.b);
            qVarB.e += qVarB.h.b - jB;
            r rVar2 = qVarB.h;
            qVarB.h = new r(rVar2.a, jB, rVar2.c, rVar2.d, rVar2.e, rVar2.f, rVar2.g);
            a(qVarB.k);
            if (!this.P.f()) {
                a(this.P.h().h.b);
                a((q) null);
            }
            r();
        }
    }

    private void d(com.anythink.basead.exoplayer.h.r rVar) {
        if (this.P.a(rVar)) {
            this.P.a(this.ab);
            r();
        }
    }

    private void r() {
        q qVarB = this.P.b();
        long jB = qVarB.b();
        if (jB == Long.MIN_VALUE) {
            d(false);
            return;
        }
        boolean zA = this.C.a(jB - (this.ab - qVarB.e), this.L.e().b);
        d(zA);
        if (zA) {
            qVarB.a(this.ab);
        }
    }

    private void a(q qVar) throws g {
        q qVarC = this.P.c();
        if (qVarC == null || qVar == qVarC) {
            return;
        }
        boolean[] zArr = new boolean[this.y.length];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            y[] yVarArr = this.y;
            if (i2 < yVarArr.length) {
                y yVar = yVarArr[i2];
                zArr[i2] = yVar.a_() != 0;
                if (qVarC.k.a(i2)) {
                    i3++;
                }
                if (zArr[i2] && (!qVarC.k.a(i2) || (yVar.i() && yVar.f() == qVar.c[i2]))) {
                    b(yVar);
                }
                i2++;
            } else {
                this.R = this.R.a(qVarC.j, qVarC.k);
                a(zArr, i3);
                return;
            }
        }
    }

    private void a(boolean[] zArr, int i2) throws g {
        this.T = new y[i2];
        q qVarC = this.P.c();
        int i3 = 0;
        for (int i4 = 0; i4 < this.y.length; i4++) {
            if (qVarC.k.a(i4)) {
                a(i4, zArr[i4], i3);
                i3++;
            }
        }
    }

    private void a(int i2, boolean z, int i3) throws g {
        q qVarC = this.P.c();
        y yVar = this.y[i2];
        this.T[i3] = yVar;
        if (yVar.a_() == 0) {
            aa aaVar = qVarC.k.b[i2];
            m[] mVarArrA = a(qVarC.k.c.a(i2));
            boolean z2 = this.V && this.R.f == 3;
            yVar.a(aaVar, mVarArrA, qVarC.c[i2], this.ab, !z && z2, qVarC.e);
            this.L.a(yVar);
            if (z2) {
                yVar.b_();
            }
        }
    }

    private boolean c(y yVar) {
        q qVarD = this.P.d();
        return qVarD.i != null && qVarD.i.f && yVar.g();
    }

    private static m[] a(com.anythink.basead.exoplayer.i.f fVar) {
        int iG = fVar != null ? fVar.g() : 0;
        m[] mVarArr = new m[iG];
        for (int i2 = 0; i2 < iG; i2++) {
            mVarArr[i2] = fVar.a(i2);
        }
        return mVarArr;
    }

    private static final class d {
        public final ae a;
        public final int b;
        public final long c;

        public d(ae aeVar, int i, long j) {
            this.a = aeVar;
            this.b = i;
            this.c = j;
        }
    }

    private static final class b implements Comparable<b> {
        public final x a;
        public int b;
        public long c;
        public Object d;

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(b bVar) {
            b bVar2 = bVar;
            Object obj = this.d;
            if ((obj == null) != (bVar2.d == null)) {
                return obj != null ? -1 : 1;
            }
            if (obj == null) {
                return 0;
            }
            int i = this.b - bVar2.b;
            return i != 0 ? i : com.anythink.basead.exoplayer.k.af.b(this.c, bVar2.c);
        }

        public b(x xVar) {
            this.a = xVar;
        }

        public final void a(int i, long j, Object obj) {
            this.b = i;
            this.c = j;
            this.d = obj;
        }

        private int a(b bVar) {
            Object obj = this.d;
            if ((obj == null) != (bVar.d == null)) {
                return obj != null ? -1 : 1;
            }
            if (obj == null) {
                return 0;
            }
            int i = this.b - bVar.b;
            return i != 0 ? i : com.anythink.basead.exoplayer.k.af.b(this.c, bVar.c);
        }
    }

    private static final class a {
        public final com.anythink.basead.exoplayer.h.s a;
        public final ae b;
        public final Object c;

        public a(com.anythink.basead.exoplayer.h.s sVar, ae aeVar, Object obj) {
            this.a = sVar;
            this.b = aeVar;
            this.c = obj;
        }
    }

    private static final class c {
        private u a;
        private int b;
        private boolean c;
        private int d;

        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }

        public final boolean a(u uVar) {
            return uVar != this.a || this.b > 0 || this.c;
        }

        public final void b(u uVar) {
            this.a = uVar;
            this.b = 0;
            this.c = false;
        }

        public final void a(int i) {
            this.b += i;
        }

        public final void b(int i) {
            if (this.c && this.d != 4) {
                com.anythink.basead.exoplayer.k.a.a(i == 4);
            } else {
                this.c = true;
                this.d = i;
            }
        }
    }
}
