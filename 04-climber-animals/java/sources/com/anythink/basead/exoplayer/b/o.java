package com.anythink.basead.exoplayer.b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import com.anythink.basead.exoplayer.k.af;
import com.anythink.basead.exoplayer.v;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class o extends com.anythink.basead.exoplayer.f.b implements com.anythink.basead.exoplayer.k.n {
    private int A;
    private int B;
    private long C;
    private boolean D;
    private boolean E;
    private final Context r;
    private final g.a s;
    private final h t;
    private int u;
    private boolean v;
    private boolean w;
    private MediaFormat x;
    private int y;
    private int z;

    private static void C() {
    }

    private static void D() {
    }

    private static void E() {
    }

    @Override // com.anythink.basead.exoplayer.f.b
    protected final int a(com.anythink.basead.exoplayer.f.a aVar, com.anythink.basead.exoplayer.m mVar, com.anythink.basead.exoplayer.m mVar2) {
        return 0;
    }

    @Override // com.anythink.basead.exoplayer.a, com.anythink.basead.exoplayer.y
    public final com.anythink.basead.exoplayer.k.n c() {
        return this;
    }

    static /* synthetic */ boolean b(o oVar) {
        oVar.E = true;
        return true;
    }

    private o(Context context, com.anythink.basead.exoplayer.f.c cVar) {
        this(context, cVar, null);
    }

    private o(Context context, com.anythink.basead.exoplayer.f.c cVar, com.anythink.basead.exoplayer.d.g<com.anythink.basead.exoplayer.d.k> gVar) {
        this(context, cVar, gVar, null, null);
    }

    private o(Context context, com.anythink.basead.exoplayer.f.c cVar, Handler handler, g gVar) {
        this(context, cVar, null, handler, gVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    private o(Context context, com.anythink.basead.exoplayer.f.c cVar, com.anythink.basead.exoplayer.d.g<com.anythink.basead.exoplayer.d.k> gVar, Handler handler, g gVar2) {
        this(context, cVar, gVar, handler, gVar2, null, new f[0]);
    }

    public o(Context context, com.anythink.basead.exoplayer.f.c cVar, com.anythink.basead.exoplayer.d.g<com.anythink.basead.exoplayer.d.k> gVar, Handler handler, g gVar2, c cVar2, f... fVarArr) {
        this(context, cVar, gVar, handler, gVar2, new l(cVar2, fVarArr));
    }

    private o(Context context, com.anythink.basead.exoplayer.f.c cVar, com.anythink.basead.exoplayer.d.g<com.anythink.basead.exoplayer.d.k> gVar, Handler handler, g gVar2, h hVar) {
        super(1, cVar, gVar, false);
        this.r = context.getApplicationContext();
        this.t = hVar;
        this.s = new g.a(handler, gVar2);
        hVar.a(new a(this, (byte) 0));
    }

    @Override // com.anythink.basead.exoplayer.f.b
    protected final int a(com.anythink.basead.exoplayer.f.c cVar, com.anythink.basead.exoplayer.d.g<com.anythink.basead.exoplayer.d.k> gVar, com.anythink.basead.exoplayer.m mVar) {
        boolean z;
        String str = mVar.h;
        boolean z2 = false;
        if (!com.anythink.basead.exoplayer.k.o.a(str)) {
            return 0;
        }
        int i = af.a >= 21 ? 32 : 0;
        boolean zA = a(gVar, mVar.k);
        if (zA && a(str) && cVar.a() != null) {
            return i | 8 | 4;
        }
        if ((com.anythink.basead.exoplayer.k.o.w.equals(str) && !this.t.a(mVar.w)) || !this.t.a(2)) {
            return 1;
        }
        com.anythink.basead.exoplayer.d.e eVar = mVar.k;
        if (eVar != null) {
            z = false;
            for (int i2 = 0; i2 < eVar.b; i2++) {
                z |= eVar.a(i2).d;
            }
        } else {
            z = false;
        }
        com.anythink.basead.exoplayer.f.a aVarA = cVar.a(str, z);
        if (aVarA == null) {
            return (!z || cVar.a(str, false) == null) ? 1 : 2;
        }
        if (!zA) {
            return 2;
        }
        if (af.a < 21 || ((mVar.v == -1 || aVarA.a(mVar.v)) && (mVar.u == -1 || aVarA.b(mVar.u)))) {
            z2 = true;
        }
        return i | 8 | (z2 ? 4 : 3);
    }

    @Override // com.anythink.basead.exoplayer.f.b
    protected final com.anythink.basead.exoplayer.f.a a(com.anythink.basead.exoplayer.f.c cVar, com.anythink.basead.exoplayer.m mVar, boolean z) {
        com.anythink.basead.exoplayer.f.a aVarA;
        return (!a(mVar.h) || (aVarA = cVar.a()) == null) ? super.a(cVar, mVar, z) : aVarA;
    }

    private boolean a(String str) {
        int iE = com.anythink.basead.exoplayer.k.o.e(str);
        return iE != 0 && this.t.a(iE);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0032  */
    @Override // com.anythink.basead.exoplayer.f.b
    protected final void a(com.anythink.basead.exoplayer.f.a aVar, MediaCodec mediaCodec, com.anythink.basead.exoplayer.m mVar, MediaCrypto mediaCrypto) {
        int i;
        PackageManager packageManager;
        q();
        boolean z = true;
        if (af.a < 24 && "OMX.google.raw.decoder".equals(aVar.c)) {
            if ((af.a == 23 && (packageManager = this.r.getPackageManager()) != null && packageManager.hasSystemFeature("android.software.leanback")) ? false : true) {
                i = -1;
            } else {
                i = mVar.i;
            }
        } else {
            i = mVar.i;
        }
        this.u = i;
        String str = aVar.c;
        if (af.a >= 24 || !"OMX.SEC.aac.dec".equals(str) || !"samsung".equals(af.c) || (!af.b.startsWith("zeroflte") && !af.b.startsWith("herolte") && !af.b.startsWith("heroqlte"))) {
            z = false;
        }
        this.w = z;
        this.v = aVar.i;
        String str2 = aVar.d == null ? com.anythink.basead.exoplayer.k.o.w : aVar.d;
        int i2 = this.u;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str2);
        mediaFormat.setInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT, mVar.u);
        mediaFormat.setInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_SAMPLE_RATE, mVar.v);
        com.anythink.basead.exoplayer.f.e.a(mediaFormat, mVar.j);
        com.anythink.basead.exoplayer.f.e.a(mediaFormat, "max-input-size", i2);
        if (af.a >= 23) {
            mediaFormat.setInteger("priority", 0);
        }
        mediaCodec.configure(mediaFormat, (Surface) null, mediaCrypto, 0);
        if (this.v) {
            this.x = mediaFormat;
            mediaFormat.setString("mime", mVar.h);
        } else {
            this.x = null;
        }
    }

    @Override // com.anythink.basead.exoplayer.f.b
    protected final void a(String str, long j, long j2) {
        this.s.a(str, j, j2);
    }

    @Override // com.anythink.basead.exoplayer.f.b
    protected final void b(com.anythink.basead.exoplayer.m mVar) throws com.anythink.basead.exoplayer.g {
        super.b(mVar);
        this.s.a(mVar);
        this.y = com.anythink.basead.exoplayer.k.o.w.equals(mVar.h) ? mVar.w : 2;
        this.z = mVar.u;
        this.A = mVar.x;
        this.B = mVar.y;
    }

    @Override // com.anythink.basead.exoplayer.f.b
    protected final void a(MediaCodec mediaCodec, MediaFormat mediaFormat) throws com.anythink.basead.exoplayer.g {
        int iE;
        int[] iArr;
        int i;
        MediaFormat mediaFormat2 = this.x;
        if (mediaFormat2 != null) {
            iE = com.anythink.basead.exoplayer.k.o.e(mediaFormat2.getString("mime"));
            mediaFormat = this.x;
        } else {
            iE = this.y;
        }
        int i2 = iE;
        int integer = mediaFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT);
        int integer2 = mediaFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_SAMPLE_RATE);
        if (this.w && integer == 6 && (i = this.z) < 6) {
            iArr = new int[i];
            for (int i3 = 0; i3 < this.z; i3++) {
                iArr[i3] = i3;
            }
        } else {
            iArr = null;
        }
        try {
            this.t.a(i2, integer, integer2, iArr, this.A, this.B);
        } catch (h.a e) {
            throw com.anythink.basead.exoplayer.g.a(e, s());
        }
    }

    @Override // com.anythink.basead.exoplayer.f.b, com.anythink.basead.exoplayer.a
    protected final void a(boolean z) {
        super.a(z);
        this.s.a(this.q);
        int i = r().b;
        if (i != 0) {
            this.t.c(i);
        } else {
            this.t.g();
        }
    }

    @Override // com.anythink.basead.exoplayer.f.b, com.anythink.basead.exoplayer.a
    protected final void a(long j, boolean z) throws com.anythink.basead.exoplayer.g {
        super.a(j, z);
        this.t.i();
        this.C = j;
        this.D = true;
        this.E = true;
    }

    @Override // com.anythink.basead.exoplayer.f.b, com.anythink.basead.exoplayer.a
    protected final void n() {
        super.n();
        this.t.a();
    }

    @Override // com.anythink.basead.exoplayer.f.b, com.anythink.basead.exoplayer.a
    protected final void o() {
        F();
        this.t.h();
        super.o();
    }

    @Override // com.anythink.basead.exoplayer.f.b, com.anythink.basead.exoplayer.a
    protected final void p() {
        try {
            this.t.j();
            try {
                super.p();
            } finally {
                this.s.b(this.q);
            }
        } catch (Throwable th) {
            try {
                super.p();
                throw th;
            } finally {
                this.s.b(this.q);
            }
        }
    }

    @Override // com.anythink.basead.exoplayer.f.b, com.anythink.basead.exoplayer.y
    public final boolean v() {
        return super.v() && this.t.d();
    }

    @Override // com.anythink.basead.exoplayer.f.b, com.anythink.basead.exoplayer.y
    public final boolean u() {
        return this.t.e() || super.u();
    }

    @Override // com.anythink.basead.exoplayer.k.n
    public final long d() {
        if (a_() == 2) {
            F();
        }
        return this.C;
    }

    @Override // com.anythink.basead.exoplayer.k.n
    public final v a(v vVar) {
        return this.t.a(vVar);
    }

    @Override // com.anythink.basead.exoplayer.k.n
    public final v e() {
        return this.t.f();
    }

    @Override // com.anythink.basead.exoplayer.f.b
    protected final void a(com.anythink.basead.exoplayer.c.e eVar) {
        if (!this.D || eVar.b()) {
            return;
        }
        if (Math.abs(eVar.f - this.C) > 500000) {
            this.C = eVar.f;
        }
        this.D = false;
    }

    @Override // com.anythink.basead.exoplayer.f.b
    protected final boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws com.anythink.basead.exoplayer.g {
        if (this.v && (i2 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i, false);
            return true;
        }
        if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            this.q.f++;
            this.t.b();
            return true;
        }
        try {
            if (!this.t.a(byteBuffer, j3)) {
                return false;
            }
            mediaCodec.releaseOutputBuffer(i, false);
            this.q.e++;
            return true;
        } catch (h.b | h.d e) {
            throw com.anythink.basead.exoplayer.g.a(e, s());
        }
    }

    @Override // com.anythink.basead.exoplayer.f.b
    protected final void w() throws com.anythink.basead.exoplayer.g {
        try {
            this.t.c();
        } catch (h.d e) {
            throw com.anythink.basead.exoplayer.g.a(e, s());
        }
    }

    @Override // com.anythink.basead.exoplayer.a, com.anythink.basead.exoplayer.x.b
    public final void a(int i, Object obj) {
        if (i == 2) {
            this.t.a(((Float) obj).floatValue());
        } else if (i == 3) {
            this.t.a((b) obj);
        } else {
            super.a(i, obj);
        }
    }

    private int b(com.anythink.basead.exoplayer.f.a aVar, com.anythink.basead.exoplayer.m mVar) {
        PackageManager packageManager;
        if (af.a < 24 && "OMX.google.raw.decoder".equals(aVar.c)) {
            if ((af.a == 23 && (packageManager = this.r.getPackageManager()) != null && packageManager.hasSystemFeature("android.software.leanback")) ? false : true) {
                return -1;
            }
        }
        return mVar.i;
    }

    private static MediaFormat a(com.anythink.basead.exoplayer.m mVar, String str, int i) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT, mVar.u);
        mediaFormat.setInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_SAMPLE_RATE, mVar.v);
        com.anythink.basead.exoplayer.f.e.a(mediaFormat, mVar.j);
        com.anythink.basead.exoplayer.f.e.a(mediaFormat, "max-input-size", i);
        if (af.a >= 23) {
            mediaFormat.setInteger("priority", 0);
        }
        return mediaFormat;
    }

    private void F() {
        long jA = this.t.a(v());
        if (jA != Long.MIN_VALUE) {
            if (!this.E) {
                jA = Math.max(this.C, jA);
            }
            this.C = jA;
            this.E = false;
        }
    }

    private static boolean a(com.anythink.basead.exoplayer.m mVar, com.anythink.basead.exoplayer.m mVar2) {
        return mVar.h.equals(mVar2.h) && mVar.u == mVar2.u && mVar.v == mVar2.v && mVar.x == 0 && mVar.y == 0 && mVar2.x == 0 && mVar2.y == 0 && mVar.b(mVar2);
    }

    private static boolean b(String str) {
        if (af.a < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(af.c)) {
            return af.b.startsWith("zeroflte") || af.b.startsWith("herolte") || af.b.startsWith("heroqlte");
        }
        return false;
    }

    private final class a implements h.c {
        private a() {
        }

        /* synthetic */ a(o oVar, byte b) {
            this();
        }

        @Override // com.anythink.basead.exoplayer.b.h.c
        public final void a(int i) {
            o.this.s.a(i);
        }

        @Override // com.anythink.basead.exoplayer.b.h.c
        public final void a() {
            o.b(o.this);
        }

        @Override // com.anythink.basead.exoplayer.b.h.c
        public final void a(int i, long j, long j2) {
            o.this.s.a(i, j, j2);
        }
    }

    private int a(com.anythink.basead.exoplayer.f.a aVar, com.anythink.basead.exoplayer.m mVar) {
        PackageManager packageManager;
        if (af.a < 24 && "OMX.google.raw.decoder".equals(aVar.c)) {
            if ((af.a == 23 && (packageManager = this.r.getPackageManager()) != null && packageManager.hasSystemFeature("android.software.leanback")) ? false : true) {
                return -1;
            }
        }
        return mVar.i;
    }
}
