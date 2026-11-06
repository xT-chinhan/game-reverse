package com.anythink.basead.exoplayer.b;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.anythink.basead.exoplayer.k.ad;
import com.anythink.basead.exoplayer.k.af;
import com.anythink.basead.exoplayer.v;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class r extends com.anythink.basead.exoplayer.a implements com.anythink.basead.exoplayer.k.n {
    private static final int n = 0;
    private static final int o = 1;
    private static final int p = 2;
    private com.anythink.basead.exoplayer.c.g<com.anythink.basead.exoplayer.c.e, ? extends com.anythink.basead.exoplayer.c.h, ? extends e> A;
    private com.anythink.basead.exoplayer.c.e B;
    private com.anythink.basead.exoplayer.c.h C;
    private com.anythink.basead.exoplayer.d.f<com.anythink.basead.exoplayer.d.i> D;
    private com.anythink.basead.exoplayer.d.f<com.anythink.basead.exoplayer.d.i> E;
    private int F;
    private boolean G;
    private boolean H;
    private long I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;
    private final com.anythink.basead.exoplayer.d.g<com.anythink.basead.exoplayer.d.i> q;
    private final boolean r;
    private final g.a s;
    private final h t;
    private final com.anythink.basead.exoplayer.n u;
    private final com.anythink.basead.exoplayer.c.e v;
    private com.anythink.basead.exoplayer.c.d w;
    private com.anythink.basead.exoplayer.m x;
    private int y;
    private int z;

    @Retention(RetentionPolicy.SOURCE)
    private @interface b {
    }

    private static void A() {
    }

    private static void y() {
    }

    private static void z() {
    }

    @Override // com.anythink.basead.exoplayer.a, com.anythink.basead.exoplayer.y
    public final com.anythink.basead.exoplayer.k.n c() {
        return this;
    }

    protected abstract int w();

    protected abstract com.anythink.basead.exoplayer.c.g<com.anythink.basead.exoplayer.c.e, ? extends com.anythink.basead.exoplayer.c.h, ? extends e> x();

    static /* synthetic */ boolean b(r rVar) {
        rVar.K = true;
        return true;
    }

    public r() {
        this((Handler) null, (g) null, new f[0]);
    }

    private r(Handler handler, g gVar, f... fVarArr) {
        this(handler, gVar, null, null, fVarArr);
    }

    private r(Handler handler, g gVar, c cVar) {
        this(handler, gVar, cVar, null, new f[0]);
    }

    private r(Handler handler, g gVar, c cVar, com.anythink.basead.exoplayer.d.g<com.anythink.basead.exoplayer.d.i> gVar2, f... fVarArr) {
        this(handler, gVar, gVar2, new l(cVar, fVarArr));
    }

    private r(Handler handler, g gVar, com.anythink.basead.exoplayer.d.g<com.anythink.basead.exoplayer.d.i> gVar2, h hVar) {
        super(1);
        this.q = gVar2;
        this.r = false;
        this.s = new g.a(handler, gVar);
        this.t = hVar;
        hVar.a(new a(this, (byte) 0));
        this.u = new com.anythink.basead.exoplayer.n();
        this.v = com.anythink.basead.exoplayer.c.e.e();
        this.F = 0;
        this.H = true;
    }

    @Override // com.anythink.basead.exoplayer.z
    public final int a(com.anythink.basead.exoplayer.m mVar) {
        int iW = w();
        if (iW <= 2) {
            return iW;
        }
        return iW | (af.a >= 21 ? 32 : 0) | 8;
    }

    private boolean b(int i) {
        return this.t.a(i);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0077 A[Catch: d -> 0x01b8, e | a | b | d -> 0x01ba, a -> 0x01bc, e -> 0x01be, TryCatch #3 {e | a | b | d -> 0x01ba, blocks: (B:19:0x004c, B:20:0x0051, B:22:0x0058, B:24:0x0064, B:39:0x00df, B:41:0x00e3, B:43:0x00e7, B:46:0x00ed, B:48:0x00f1, B:51:0x00fb, B:53:0x0100, B:54:0x0112, B:62:0x0127, B:94:0x01b4, B:64:0x0131, B:66:0x0139, B:67:0x0146, B:70:0x0152, B:73:0x0157, B:80:0x0171, B:83:0x0176, B:85:0x0181, B:87:0x0187, B:89:0x0197, B:90:0x019b, B:91:0x019d, B:77:0x0161, B:78:0x016f, B:57:0x0118, B:25:0x006f, B:27:0x0077, B:29:0x007b, B:30:0x0084, B:31:0x008f, B:33:0x0093, B:34:0x00bc, B:36:0x00cc), top: B:108:0x004c }] */
    /* JADX WARN: Code duplicated, block: B:29:0x007b A[Catch: d -> 0x01b8, e | a | b | d -> 0x01ba, a -> 0x01bc, e -> 0x01be, TryCatch #3 {e | a | b | d -> 0x01ba, blocks: (B:19:0x004c, B:20:0x0051, B:22:0x0058, B:24:0x0064, B:39:0x00df, B:41:0x00e3, B:43:0x00e7, B:46:0x00ed, B:48:0x00f1, B:51:0x00fb, B:53:0x0100, B:54:0x0112, B:62:0x0127, B:94:0x01b4, B:64:0x0131, B:66:0x0139, B:67:0x0146, B:70:0x0152, B:73:0x0157, B:80:0x0171, B:83:0x0176, B:85:0x0181, B:87:0x0187, B:89:0x0197, B:90:0x019b, B:91:0x019d, B:77:0x0161, B:78:0x016f, B:57:0x0118, B:25:0x006f, B:27:0x0077, B:29:0x007b, B:30:0x0084, B:31:0x008f, B:33:0x0093, B:34:0x00bc, B:36:0x00cc), top: B:108:0x004c }] */
    /* JADX WARN: Code duplicated, block: B:30:0x0084 A[Catch: d -> 0x01b8, e | a | b | d -> 0x01ba, a -> 0x01bc, e -> 0x01be, TryCatch #3 {e | a | b | d -> 0x01ba, blocks: (B:19:0x004c, B:20:0x0051, B:22:0x0058, B:24:0x0064, B:39:0x00df, B:41:0x00e3, B:43:0x00e7, B:46:0x00ed, B:48:0x00f1, B:51:0x00fb, B:53:0x0100, B:54:0x0112, B:62:0x0127, B:94:0x01b4, B:64:0x0131, B:66:0x0139, B:67:0x0146, B:70:0x0152, B:73:0x0157, B:80:0x0171, B:83:0x0176, B:85:0x0181, B:87:0x0187, B:89:0x0197, B:90:0x019b, B:91:0x019d, B:77:0x0161, B:78:0x016f, B:57:0x0118, B:25:0x006f, B:27:0x0077, B:29:0x007b, B:30:0x0084, B:31:0x008f, B:33:0x0093, B:34:0x00bc, B:36:0x00cc), top: B:108:0x004c }] */
    /* JADX WARN: Code duplicated, block: B:31:0x008f A[Catch: d -> 0x01b8, e | a | b | d -> 0x01ba, a -> 0x01bc, e -> 0x01be, TryCatch #3 {e | a | b | d -> 0x01ba, blocks: (B:19:0x004c, B:20:0x0051, B:22:0x0058, B:24:0x0064, B:39:0x00df, B:41:0x00e3, B:43:0x00e7, B:46:0x00ed, B:48:0x00f1, B:51:0x00fb, B:53:0x0100, B:54:0x0112, B:62:0x0127, B:94:0x01b4, B:64:0x0131, B:66:0x0139, B:67:0x0146, B:70:0x0152, B:73:0x0157, B:80:0x0171, B:83:0x0176, B:85:0x0181, B:87:0x0187, B:89:0x0197, B:90:0x019b, B:91:0x019d, B:77:0x0161, B:78:0x016f, B:57:0x0118, B:25:0x006f, B:27:0x0077, B:29:0x007b, B:30:0x0084, B:31:0x008f, B:33:0x0093, B:34:0x00bc, B:36:0x00cc), top: B:108:0x004c }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0093 A[Catch: d -> 0x01b8, e | a | b | d -> 0x01ba, a -> 0x01bc, e -> 0x01be, TryCatch #3 {e | a | b | d -> 0x01ba, blocks: (B:19:0x004c, B:20:0x0051, B:22:0x0058, B:24:0x0064, B:39:0x00df, B:41:0x00e3, B:43:0x00e7, B:46:0x00ed, B:48:0x00f1, B:51:0x00fb, B:53:0x0100, B:54:0x0112, B:62:0x0127, B:94:0x01b4, B:64:0x0131, B:66:0x0139, B:67:0x0146, B:70:0x0152, B:73:0x0157, B:80:0x0171, B:83:0x0176, B:85:0x0181, B:87:0x0187, B:89:0x0197, B:90:0x019b, B:91:0x019d, B:77:0x0161, B:78:0x016f, B:57:0x0118, B:25:0x006f, B:27:0x0077, B:29:0x007b, B:30:0x0084, B:31:0x008f, B:33:0x0093, B:34:0x00bc, B:36:0x00cc), top: B:108:0x004c }] */
    /* JADX WARN: Code duplicated, block: B:36:0x00cc A[Catch: d -> 0x01b8, e | a | b | d -> 0x01ba, a -> 0x01bc, e -> 0x01be, TryCatch #3 {e | a | b | d -> 0x01ba, blocks: (B:19:0x004c, B:20:0x0051, B:22:0x0058, B:24:0x0064, B:39:0x00df, B:41:0x00e3, B:43:0x00e7, B:46:0x00ed, B:48:0x00f1, B:51:0x00fb, B:53:0x0100, B:54:0x0112, B:62:0x0127, B:94:0x01b4, B:64:0x0131, B:66:0x0139, B:67:0x0146, B:70:0x0152, B:73:0x0157, B:80:0x0171, B:83:0x0176, B:85:0x0181, B:87:0x0187, B:89:0x0197, B:90:0x019b, B:91:0x019d, B:77:0x0161, B:78:0x016f, B:57:0x0118, B:25:0x006f, B:27:0x0077, B:29:0x007b, B:30:0x0084, B:31:0x008f, B:33:0x0093, B:34:0x00bc, B:36:0x00cc), top: B:108:0x004c }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00fb A[Catch: d -> 0x01b8, e | a | b | d -> 0x01ba, a -> 0x01bc, e -> 0x01be, TryCatch #3 {e | a | b | d -> 0x01ba, blocks: (B:19:0x004c, B:20:0x0051, B:22:0x0058, B:24:0x0064, B:39:0x00df, B:41:0x00e3, B:43:0x00e7, B:46:0x00ed, B:48:0x00f1, B:51:0x00fb, B:53:0x0100, B:54:0x0112, B:62:0x0127, B:94:0x01b4, B:64:0x0131, B:66:0x0139, B:67:0x0146, B:70:0x0152, B:73:0x0157, B:80:0x0171, B:83:0x0176, B:85:0x0181, B:87:0x0187, B:89:0x0197, B:90:0x019b, B:91:0x019d, B:77:0x0161, B:78:0x016f, B:57:0x0118, B:25:0x006f, B:27:0x0077, B:29:0x007b, B:30:0x0084, B:31:0x008f, B:33:0x0093, B:34:0x00bc, B:36:0x00cc), top: B:108:0x004c }] */
    /* JADX WARN: Code duplicated, block: B:53:0x0100 A[Catch: d -> 0x01b8, e | a | b | d -> 0x01ba, a -> 0x01bc, e -> 0x01be, TryCatch #3 {e | a | b | d -> 0x01ba, blocks: (B:19:0x004c, B:20:0x0051, B:22:0x0058, B:24:0x0064, B:39:0x00df, B:41:0x00e3, B:43:0x00e7, B:46:0x00ed, B:48:0x00f1, B:51:0x00fb, B:53:0x0100, B:54:0x0112, B:62:0x0127, B:94:0x01b4, B:64:0x0131, B:66:0x0139, B:67:0x0146, B:70:0x0152, B:73:0x0157, B:80:0x0171, B:83:0x0176, B:85:0x0181, B:87:0x0187, B:89:0x0197, B:90:0x019b, B:91:0x019d, B:77:0x0161, B:78:0x016f, B:57:0x0118, B:25:0x006f, B:27:0x0077, B:29:0x007b, B:30:0x0084, B:31:0x008f, B:33:0x0093, B:34:0x00bc, B:36:0x00cc), top: B:108:0x004c }] */
    /* JADX WARN: Code duplicated, block: B:54:0x0112 A[Catch: d -> 0x01b8, e | a | b | d -> 0x01ba, a -> 0x01bc, e -> 0x01be, TryCatch #3 {e | a | b | d -> 0x01ba, blocks: (B:19:0x004c, B:20:0x0051, B:22:0x0058, B:24:0x0064, B:39:0x00df, B:41:0x00e3, B:43:0x00e7, B:46:0x00ed, B:48:0x00f1, B:51:0x00fb, B:53:0x0100, B:54:0x0112, B:62:0x0127, B:94:0x01b4, B:64:0x0131, B:66:0x0139, B:67:0x0146, B:70:0x0152, B:73:0x0157, B:80:0x0171, B:83:0x0176, B:85:0x0181, B:87:0x0187, B:89:0x0197, B:90:0x019b, B:91:0x019d, B:77:0x0161, B:78:0x016f, B:57:0x0118, B:25:0x006f, B:27:0x0077, B:29:0x007b, B:30:0x0084, B:31:0x008f, B:33:0x0093, B:34:0x00bc, B:36:0x00cc), top: B:108:0x004c }] */
    /* JADX WARN: Code duplicated, block: B:56:0x0116  */
    /* JADX WARN: Code duplicated, block: B:57:0x0118 A[Catch: d -> 0x01b8, e | a | b | d -> 0x01ba, a -> 0x01bc, e -> 0x01be, TryCatch #3 {e | a | b | d -> 0x01ba, blocks: (B:19:0x004c, B:20:0x0051, B:22:0x0058, B:24:0x0064, B:39:0x00df, B:41:0x00e3, B:43:0x00e7, B:46:0x00ed, B:48:0x00f1, B:51:0x00fb, B:53:0x0100, B:54:0x0112, B:62:0x0127, B:94:0x01b4, B:64:0x0131, B:66:0x0139, B:67:0x0146, B:70:0x0152, B:73:0x0157, B:80:0x0171, B:83:0x0176, B:85:0x0181, B:87:0x0187, B:89:0x0197, B:90:0x019b, B:91:0x019d, B:77:0x0161, B:78:0x016f, B:57:0x0118, B:25:0x006f, B:27:0x0077, B:29:0x007b, B:30:0x0084, B:31:0x008f, B:33:0x0093, B:34:0x00bc, B:36:0x00cc), top: B:108:0x004c }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0123  */
    /* JADX WARN: Code duplicated, block: B:61:0x0125 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:62:0x0127 A[Catch: d -> 0x01b8, e | a | b | d -> 0x01ba, a -> 0x01bc, e -> 0x01be, TryCatch #3 {e | a | b | d -> 0x01ba, blocks: (B:19:0x004c, B:20:0x0051, B:22:0x0058, B:24:0x0064, B:39:0x00df, B:41:0x00e3, B:43:0x00e7, B:46:0x00ed, B:48:0x00f1, B:51:0x00fb, B:53:0x0100, B:54:0x0112, B:62:0x0127, B:94:0x01b4, B:64:0x0131, B:66:0x0139, B:67:0x0146, B:70:0x0152, B:73:0x0157, B:80:0x0171, B:83:0x0176, B:85:0x0181, B:87:0x0187, B:89:0x0197, B:90:0x019b, B:91:0x019d, B:77:0x0161, B:78:0x016f, B:57:0x0118, B:25:0x006f, B:27:0x0077, B:29:0x007b, B:30:0x0084, B:31:0x008f, B:33:0x0093, B:34:0x00bc, B:36:0x00cc), top: B:108:0x004c }] */
    /* JADX WARN: Code duplicated, block: B:64:0x0131 A[Catch: d -> 0x01b8, e | a | b | d -> 0x01ba, a -> 0x01bc, e -> 0x01be, TryCatch #3 {e | a | b | d -> 0x01ba, blocks: (B:19:0x004c, B:20:0x0051, B:22:0x0058, B:24:0x0064, B:39:0x00df, B:41:0x00e3, B:43:0x00e7, B:46:0x00ed, B:48:0x00f1, B:51:0x00fb, B:53:0x0100, B:54:0x0112, B:62:0x0127, B:94:0x01b4, B:64:0x0131, B:66:0x0139, B:67:0x0146, B:70:0x0152, B:73:0x0157, B:80:0x0171, B:83:0x0176, B:85:0x0181, B:87:0x0187, B:89:0x0197, B:90:0x019b, B:91:0x019d, B:77:0x0161, B:78:0x016f, B:57:0x0118, B:25:0x006f, B:27:0x0077, B:29:0x007b, B:30:0x0084, B:31:0x008f, B:33:0x0093, B:34:0x00bc, B:36:0x00cc), top: B:108:0x004c }] */
    /* JADX WARN: Code duplicated, block: B:66:0x0139 A[Catch: d -> 0x01b8, e | a | b | d -> 0x01ba, a -> 0x01bc, e -> 0x01be, TryCatch #3 {e | a | b | d -> 0x01ba, blocks: (B:19:0x004c, B:20:0x0051, B:22:0x0058, B:24:0x0064, B:39:0x00df, B:41:0x00e3, B:43:0x00e7, B:46:0x00ed, B:48:0x00f1, B:51:0x00fb, B:53:0x0100, B:54:0x0112, B:62:0x0127, B:94:0x01b4, B:64:0x0131, B:66:0x0139, B:67:0x0146, B:70:0x0152, B:73:0x0157, B:80:0x0171, B:83:0x0176, B:85:0x0181, B:87:0x0187, B:89:0x0197, B:90:0x019b, B:91:0x019d, B:77:0x0161, B:78:0x016f, B:57:0x0118, B:25:0x006f, B:27:0x0077, B:29:0x007b, B:30:0x0084, B:31:0x008f, B:33:0x0093, B:34:0x00bc, B:36:0x00cc), top: B:108:0x004c }] */
    /* JADX WARN: Code duplicated, block: B:67:0x0146 A[Catch: d -> 0x01b8, e | a | b | d -> 0x01ba, a -> 0x01bc, e -> 0x01be, TryCatch #3 {e | a | b | d -> 0x01ba, blocks: (B:19:0x004c, B:20:0x0051, B:22:0x0058, B:24:0x0064, B:39:0x00df, B:41:0x00e3, B:43:0x00e7, B:46:0x00ed, B:48:0x00f1, B:51:0x00fb, B:53:0x0100, B:54:0x0112, B:62:0x0127, B:94:0x01b4, B:64:0x0131, B:66:0x0139, B:67:0x0146, B:70:0x0152, B:73:0x0157, B:80:0x0171, B:83:0x0176, B:85:0x0181, B:87:0x0187, B:89:0x0197, B:90:0x019b, B:91:0x019d, B:77:0x0161, B:78:0x016f, B:57:0x0118, B:25:0x006f, B:27:0x0077, B:29:0x007b, B:30:0x0084, B:31:0x008f, B:33:0x0093, B:34:0x00bc, B:36:0x00cc), top: B:108:0x004c }] */
    /* JADX WARN: Code duplicated, block: B:79:0x0170  */
    /* JADX WARN: Code duplicated, block: B:82:0x0175  */
    /* JADX WARN: Code duplicated, block: B:83:0x0176 A[Catch: d -> 0x01b8, e | a | b | d -> 0x01ba, a -> 0x01bc, e -> 0x01be, TryCatch #3 {e | a | b | d -> 0x01ba, blocks: (B:19:0x004c, B:20:0x0051, B:22:0x0058, B:24:0x0064, B:39:0x00df, B:41:0x00e3, B:43:0x00e7, B:46:0x00ed, B:48:0x00f1, B:51:0x00fb, B:53:0x0100, B:54:0x0112, B:62:0x0127, B:94:0x01b4, B:64:0x0131, B:66:0x0139, B:67:0x0146, B:70:0x0152, B:73:0x0157, B:80:0x0171, B:83:0x0176, B:85:0x0181, B:87:0x0187, B:89:0x0197, B:90:0x019b, B:91:0x019d, B:77:0x0161, B:78:0x016f, B:57:0x0118, B:25:0x006f, B:27:0x0077, B:29:0x007b, B:30:0x0084, B:31:0x008f, B:33:0x0093, B:34:0x00bc, B:36:0x00cc), top: B:108:0x004c }] */
    /* JADX WARN: Code duplicated, block: B:89:0x0197 A[Catch: d -> 0x01b8, e | a | b | d -> 0x01ba, a -> 0x01bc, e -> 0x01be, TryCatch #3 {e | a | b | d -> 0x01ba, blocks: (B:19:0x004c, B:20:0x0051, B:22:0x0058, B:24:0x0064, B:39:0x00df, B:41:0x00e3, B:43:0x00e7, B:46:0x00ed, B:48:0x00f1, B:51:0x00fb, B:53:0x0100, B:54:0x0112, B:62:0x0127, B:94:0x01b4, B:64:0x0131, B:66:0x0139, B:67:0x0146, B:70:0x0152, B:73:0x0157, B:80:0x0171, B:83:0x0176, B:85:0x0181, B:87:0x0187, B:89:0x0197, B:90:0x019b, B:91:0x019d, B:77:0x0161, B:78:0x016f, B:57:0x0118, B:25:0x006f, B:27:0x0077, B:29:0x007b, B:30:0x0084, B:31:0x008f, B:33:0x0093, B:34:0x00bc, B:36:0x00cc), top: B:108:0x004c }] */
    @Override // com.anythink.basead.exoplayer.y
    public final void a(long j, long j2) throws com.anythink.basead.exoplayer.g {
        boolean z;
        boolean z2;
        int iA;
        com.anythink.basead.exoplayer.d.f<com.anythink.basead.exoplayer.d.i> fVar;
        boolean z3;
        com.anythink.basead.exoplayer.c.e eVar;
        if (this.M) {
            try {
                this.t.c();
                return;
            } catch (h.d e) {
                throw com.anythink.basead.exoplayer.g.a(e, s());
            }
        }
        if (this.x == null) {
            this.v.a();
            int iA2 = a(this.u, this.v, true);
            if (iA2 != -5) {
                if (iA2 == -4) {
                    com.anythink.basead.exoplayer.k.a.b(this.v.c());
                    this.L = true;
                    E();
                    return;
                }
                return;
            }
            b(this.u.a);
        }
        G();
        if (this.A != null) {
            try {
                ad.a("drainAndFeed");
                do {
                    if (this.C == null) {
                        com.anythink.basead.exoplayer.c.h hVar = (com.anythink.basead.exoplayer.c.h) this.A.c();
                        this.C = hVar;
                        if (hVar != null) {
                            this.w.f += this.C.b;
                            if (this.C.c()) {
                                if (this.F == 2) {
                                    H();
                                    G();
                                    this.H = true;
                                } else {
                                    this.C.e();
                                    this.C = null;
                                    E();
                                }
                            } else {
                                if (this.H) {
                                    com.anythink.basead.exoplayer.m mVarA = com.anythink.basead.exoplayer.m.a((String) null, com.anythink.basead.exoplayer.k.o.w, (String) null, -1, this.x.u, this.x.v, 2, (List<byte[]>) null, (com.anythink.basead.exoplayer.d.e) null, (String) null);
                                    this.t.a(mVarA.w, mVarA.u, mVarA.v, null, this.y, this.z);
                                    this.H = false;
                                }
                                if (this.t.a(this.C.c, this.C.a)) {
                                    this.w.e++;
                                    this.C.e();
                                    this.C = null;
                                    z = true;
                                }
                            }
                            z = false;
                        } else {
                            z = false;
                        }
                    } else {
                        if (this.C.c()) {
                            if (this.F == 2) {
                                H();
                                G();
                                this.H = true;
                            } else {
                                this.C.e();
                                this.C = null;
                                E();
                            }
                        } else {
                            if (this.H) {
                                com.anythink.basead.exoplayer.m mVarA2 = com.anythink.basead.exoplayer.m.a((String) null, com.anythink.basead.exoplayer.k.o.w, (String) null, -1, this.x.u, this.x.v, 2, (List<byte[]>) null, (com.anythink.basead.exoplayer.d.e) null, (String) null);
                                this.t.a(mVarA2.w, mVarA2.u, mVarA2.v, null, this.y, this.z);
                                this.H = false;
                            }
                            if (this.t.a(this.C.c, this.C.a)) {
                                this.w.e++;
                                this.C.e();
                                this.C = null;
                                z = true;
                            }
                        }
                        z = false;
                    }
                } while (z);
                do {
                    com.anythink.basead.exoplayer.c.g<com.anythink.basead.exoplayer.c.e, ? extends com.anythink.basead.exoplayer.c.h, ? extends e> gVar = this.A;
                    if (gVar == null || this.F == 2 || this.L) {
                        z2 = false;
                    } else if (this.B == null) {
                        com.anythink.basead.exoplayer.c.e eVarB = gVar.b();
                        this.B = eVarB;
                        if (eVarB != null) {
                            if (this.F == 1) {
                                this.B.a(4);
                                this.A.a(this.B);
                                this.B = null;
                                this.F = 2;
                            } else {
                                if (this.N) {
                                    iA = -4;
                                } else {
                                    iA = a(this.u, this.B, false);
                                }
                                if (iA != -3) {
                                    if (iA == -5) {
                                        b(this.u.a);
                                    } else if (this.B.c()) {
                                        this.L = true;
                                        this.A.a(this.B);
                                        this.B = null;
                                    } else {
                                        boolean zG = this.B.g();
                                        fVar = this.D;
                                        if (fVar != null || (!zG && this.r)) {
                                            z3 = false;
                                        } else {
                                            int iE = fVar.e();
                                            if (iE == 1) {
                                                throw com.anythink.basead.exoplayer.g.a(this.D.f(), s());
                                            }
                                            if (iE != 4) {
                                                z3 = true;
                                            } else {
                                                z3 = false;
                                            }
                                        }
                                        this.N = z3;
                                        if (z3) {
                                            this.B.h();
                                            eVar = this.B;
                                            if (this.J && !eVar.b()) {
                                                if (Math.abs(eVar.f - this.I) > 500000) {
                                                    this.I = eVar.f;
                                                }
                                                this.J = false;
                                            }
                                            this.A.a(this.B);
                                            this.G = true;
                                            this.w.c++;
                                            this.B = null;
                                        }
                                    }
                                    z2 = true;
                                }
                            }
                        }
                        z2 = false;
                    } else {
                        if (this.F == 1) {
                            this.B.a(4);
                            this.A.a(this.B);
                            this.B = null;
                            this.F = 2;
                        } else {
                            if (this.N) {
                                iA = -4;
                            } else {
                                iA = a(this.u, this.B, false);
                            }
                            if (iA != -3) {
                                if (iA == -5) {
                                    b(this.u.a);
                                } else if (this.B.c()) {
                                    this.L = true;
                                    this.A.a(this.B);
                                    this.B = null;
                                } else {
                                    boolean zG2 = this.B.g();
                                    fVar = this.D;
                                    if (fVar != null) {
                                        z3 = false;
                                    } else {
                                        z3 = false;
                                    }
                                    this.N = z3;
                                    if (z3) {
                                        this.B.h();
                                        eVar = this.B;
                                        if (this.J) {
                                            if (Math.abs(eVar.f - this.I) > 500000) {
                                                this.I = eVar.f;
                                            }
                                            this.J = false;
                                        }
                                        this.A.a(this.B);
                                        this.G = true;
                                        this.w.c++;
                                        this.B = null;
                                    }
                                }
                                z2 = true;
                            }
                        }
                        z2 = false;
                    }
                } while (z2);
                ad.a();
            } catch (e | h.a | h.b | h.d e2) {
                throw com.anythink.basead.exoplayer.g.a(e2, s());
            }
        }
    }

    private com.anythink.basead.exoplayer.m B() {
        return com.anythink.basead.exoplayer.m.a((String) null, com.anythink.basead.exoplayer.k.o.w, (String) null, -1, this.x.u, this.x.v, 2, (List<byte[]>) null, (com.anythink.basead.exoplayer.d.e) null, (String) null);
    }

    private boolean C() throws com.anythink.basead.exoplayer.g {
        if (this.C == null) {
            com.anythink.basead.exoplayer.c.h hVar = (com.anythink.basead.exoplayer.c.h) this.A.c();
            this.C = hVar;
            if (hVar == null) {
                return false;
            }
            this.w.f += this.C.b;
        }
        if (this.C.c()) {
            if (this.F == 2) {
                H();
                G();
                this.H = true;
            } else {
                this.C.e();
                this.C = null;
                E();
            }
            return false;
        }
        if (this.H) {
            com.anythink.basead.exoplayer.m mVarA = com.anythink.basead.exoplayer.m.a((String) null, com.anythink.basead.exoplayer.k.o.w, (String) null, -1, this.x.u, this.x.v, 2, (List<byte[]>) null, (com.anythink.basead.exoplayer.d.e) null, (String) null);
            this.t.a(mVarA.w, mVarA.u, mVarA.v, null, this.y, this.z);
            this.H = false;
        }
        if (!this.t.a(this.C.c, this.C.a)) {
            return false;
        }
        this.w.e++;
        this.C.e();
        this.C = null;
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:45:0x0090  */
    private boolean D() throws com.anythink.basead.exoplayer.g {
        boolean z;
        com.anythink.basead.exoplayer.c.g<com.anythink.basead.exoplayer.c.e, ? extends com.anythink.basead.exoplayer.c.h, ? extends e> gVar = this.A;
        if (gVar == null || this.F == 2 || this.L) {
            return false;
        }
        if (this.B == null) {
            com.anythink.basead.exoplayer.c.e eVarB = gVar.b();
            this.B = eVarB;
            if (eVarB == null) {
                return false;
            }
        }
        if (this.F == 1) {
            this.B.a(4);
            this.A.a(this.B);
            this.B = null;
            this.F = 2;
            return false;
        }
        int iA = this.N ? -4 : a(this.u, this.B, false);
        if (iA == -3) {
            return false;
        }
        if (iA == -5) {
            b(this.u.a);
            return true;
        }
        if (this.B.c()) {
            this.L = true;
            this.A.a(this.B);
            this.B = null;
            return false;
        }
        boolean zG = this.B.g();
        com.anythink.basead.exoplayer.d.f<com.anythink.basead.exoplayer.d.i> fVar = this.D;
        if (fVar == null || (!zG && this.r)) {
            z = false;
        } else {
            int iE = fVar.e();
            if (iE == 1) {
                throw com.anythink.basead.exoplayer.g.a(this.D.f(), s());
            }
            if (iE != 4) {
                z = true;
            } else {
                z = false;
            }
        }
        this.N = z;
        if (z) {
            return false;
        }
        this.B.h();
        com.anythink.basead.exoplayer.c.e eVar = this.B;
        if (this.J && !eVar.b()) {
            if (Math.abs(eVar.f - this.I) > 500000) {
                this.I = eVar.f;
            }
            this.J = false;
        }
        this.A.a(this.B);
        this.G = true;
        this.w.c++;
        this.B = null;
        return true;
    }

    private boolean b(boolean z) throws com.anythink.basead.exoplayer.g {
        com.anythink.basead.exoplayer.d.f<com.anythink.basead.exoplayer.d.i> fVar = this.D;
        if (fVar == null || (!z && this.r)) {
            return false;
        }
        int iE = fVar.e();
        if (iE != 1) {
            return iE != 4;
        }
        throw com.anythink.basead.exoplayer.g.a(this.D.f(), s());
    }

    private void E() throws com.anythink.basead.exoplayer.g {
        this.M = true;
        try {
            this.t.c();
        } catch (h.d e) {
            throw com.anythink.basead.exoplayer.g.a(e, s());
        }
    }

    private void F() throws com.anythink.basead.exoplayer.g {
        this.N = false;
        if (this.F != 0) {
            H();
            G();
            return;
        }
        this.B = null;
        com.anythink.basead.exoplayer.c.h hVar = this.C;
        if (hVar != null) {
            hVar.e();
            this.C = null;
        }
        this.A.d();
        this.G = false;
    }

    @Override // com.anythink.basead.exoplayer.y
    public final boolean v() {
        return this.M && this.t.d();
    }

    @Override // com.anythink.basead.exoplayer.y
    public final boolean u() {
        if (this.t.e()) {
            return true;
        }
        if (this.x == null || this.N) {
            return false;
        }
        return t() || this.C != null;
    }

    @Override // com.anythink.basead.exoplayer.k.n
    public final long d() {
        if (a_() == 2) {
            I();
        }
        return this.I;
    }

    @Override // com.anythink.basead.exoplayer.k.n
    public final v a(v vVar) {
        return this.t.a(vVar);
    }

    @Override // com.anythink.basead.exoplayer.k.n
    public final v e() {
        return this.t.f();
    }

    @Override // com.anythink.basead.exoplayer.a
    protected final void a(boolean z) {
        com.anythink.basead.exoplayer.c.d dVar = new com.anythink.basead.exoplayer.c.d();
        this.w = dVar;
        this.s.a(dVar);
        int i = r().b;
        if (i != 0) {
            this.t.c(i);
        } else {
            this.t.g();
        }
    }

    @Override // com.anythink.basead.exoplayer.a
    protected final void a(long j, boolean z) throws com.anythink.basead.exoplayer.g {
        this.t.i();
        this.I = j;
        this.J = true;
        this.K = true;
        this.L = false;
        this.M = false;
        if (this.A != null) {
            this.N = false;
            if (this.F != 0) {
                H();
                G();
                return;
            }
            this.B = null;
            com.anythink.basead.exoplayer.c.h hVar = this.C;
            if (hVar != null) {
                hVar.e();
                this.C = null;
            }
            this.A.d();
            this.G = false;
        }
    }

    @Override // com.anythink.basead.exoplayer.a
    protected final void n() {
        this.t.a();
    }

    @Override // com.anythink.basead.exoplayer.a
    protected final void o() {
        I();
        this.t.h();
    }

    @Override // com.anythink.basead.exoplayer.a
    protected final void p() {
        this.x = null;
        this.H = true;
        this.N = false;
        try {
            H();
            this.t.j();
            try {
                com.anythink.basead.exoplayer.d.f<com.anythink.basead.exoplayer.d.i> fVar = this.D;
                if (fVar != null) {
                    this.q.a(fVar);
                }
                try {
                    com.anythink.basead.exoplayer.d.f<com.anythink.basead.exoplayer.d.i> fVar2 = this.E;
                    if (fVar2 != null && fVar2 != this.D) {
                        this.q.a(fVar2);
                    }
                } finally {
                    this.D = null;
                    this.E = null;
                    this.s.b(this.w);
                }
            } catch (Throwable th) {
                try {
                    com.anythink.basead.exoplayer.d.f<com.anythink.basead.exoplayer.d.i> fVar3 = this.E;
                    if (fVar3 != null && fVar3 != this.D) {
                        this.q.a(fVar3);
                    }
                    throw th;
                } finally {
                    this.D = null;
                    this.E = null;
                    this.s.b(this.w);
                }
            }
        } catch (Throwable th2) {
            try {
                com.anythink.basead.exoplayer.d.f<com.anythink.basead.exoplayer.d.i> fVar4 = this.D;
                if (fVar4 != null) {
                    this.q.a(fVar4);
                }
                try {
                    com.anythink.basead.exoplayer.d.f<com.anythink.basead.exoplayer.d.i> fVar5 = this.E;
                    if (fVar5 != null && fVar5 != this.D) {
                        this.q.a(fVar5);
                    }
                    throw th2;
                } finally {
                    this.D = null;
                    this.E = null;
                    this.s.b(this.w);
                }
            } catch (Throwable th3) {
                try {
                    com.anythink.basead.exoplayer.d.f<com.anythink.basead.exoplayer.d.i> fVar6 = this.E;
                    if (fVar6 != null && fVar6 != this.D) {
                        this.q.a(fVar6);
                    }
                    throw th3;
                } finally {
                    this.D = null;
                    this.E = null;
                    this.s.b(this.w);
                }
            }
        }
    }

    @Override // com.anythink.basead.exoplayer.a, com.anythink.basead.exoplayer.x.b
    public final void a(int i, Object obj) {
        if (i == 2) {
            this.t.a(((Float) obj).floatValue());
        } else if (i == 3) {
            this.t.a((com.anythink.basead.exoplayer.b.b) obj);
        } else {
            super.a(i, obj);
        }
    }

    private void G() throws com.anythink.basead.exoplayer.g {
        if (this.A != null) {
            return;
        }
        com.anythink.basead.exoplayer.d.f<com.anythink.basead.exoplayer.d.i> fVar = this.E;
        this.D = fVar;
        if (fVar != null && fVar.g() == null && this.D.f() == null) {
            return;
        }
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            ad.a("createAudioDecoder");
            this.A = x();
            ad.a();
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            this.s.a(this.A.a(), jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
            this.w.a++;
        } catch (e e) {
            throw com.anythink.basead.exoplayer.g.a(e, s());
        }
    }

    private void H() {
        com.anythink.basead.exoplayer.c.g<com.anythink.basead.exoplayer.c.e, ? extends com.anythink.basead.exoplayer.c.h, ? extends e> gVar = this.A;
        if (gVar == null) {
            return;
        }
        this.B = null;
        this.C = null;
        gVar.e();
        this.A = null;
        this.w.b++;
        this.F = 0;
        this.G = false;
    }

    private void b(com.anythink.basead.exoplayer.m mVar) throws com.anythink.basead.exoplayer.g {
        com.anythink.basead.exoplayer.m mVar2 = this.x;
        this.x = mVar;
        if (!af.a(mVar.k, mVar2 == null ? null : mVar2.k)) {
            if (this.x.k != null) {
                com.anythink.basead.exoplayer.d.g<com.anythink.basead.exoplayer.d.i> gVar = this.q;
                if (gVar == null) {
                    throw com.anythink.basead.exoplayer.g.a(new IllegalStateException("Media requires a DrmSessionManager"), s());
                }
                com.anythink.basead.exoplayer.d.f<com.anythink.basead.exoplayer.d.i> fVarA = gVar.a(Looper.myLooper(), this.x.k);
                this.E = fVarA;
                if (fVarA == this.D) {
                    this.q.a(fVarA);
                }
            } else {
                this.E = null;
            }
        }
        if (this.G) {
            this.F = 1;
        } else {
            H();
            G();
            this.H = true;
        }
        this.y = mVar.x;
        this.z = mVar.y;
        this.s.a(mVar);
    }

    private void a(com.anythink.basead.exoplayer.c.e eVar) {
        if (!this.J || eVar.b()) {
            return;
        }
        if (Math.abs(eVar.f - this.I) > 500000) {
            this.I = eVar.f;
        }
        this.J = false;
    }

    private void I() {
        long jA = this.t.a(v());
        if (jA != Long.MIN_VALUE) {
            if (!this.K) {
                jA = Math.max(this.I, jA);
            }
            this.I = jA;
            this.K = false;
        }
    }

    private final class a implements h.c {
        private a() {
        }

        /* synthetic */ a(r rVar, byte b) {
            this();
        }

        @Override // com.anythink.basead.exoplayer.b.h.c
        public final void a(int i) {
            r.this.s.a(i);
        }

        @Override // com.anythink.basead.exoplayer.b.h.c
        public final void a() {
            r.b(r.this);
        }

        @Override // com.anythink.basead.exoplayer.b.h.c
        public final void a(int i, long j, long j2) {
            r.this.s.a(i, j, j2);
        }
    }
}
