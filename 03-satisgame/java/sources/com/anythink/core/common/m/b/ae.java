package com.anythink.core.common.m.b;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes.dex */
public abstract class ae {
    private static boolean c() {
        return false;
    }

    private static boolean d() {
        return false;
    }

    public abstract x a();

    public abstract void a(com.anythink.core.common.m.c.d dVar);

    public long b() {
        return -1L;
    }

    private static ae a(x xVar, String str) {
        Charset charsetA = StandardCharsets.UTF_8;
        if (xVar != null && (charsetA = xVar.a((Charset) null)) == null) {
            charsetA = StandardCharsets.UTF_8;
            xVar = x.b(xVar + "; charset=utf-8");
        }
        byte[] bytes = str.getBytes(charsetA);
        return a(xVar, bytes, bytes.length);
    }

    private static ae a(final x xVar, final com.anythink.core.common.m.c.f fVar) {
        return new ae() { // from class: com.anythink.core.common.m.b.ae.1
            @Override // com.anythink.core.common.m.b.ae
            public final x a() {
                return xVar;
            }

            @Override // com.anythink.core.common.m.b.ae
            public final long b() {
                return fVar.j();
            }

            @Override // com.anythink.core.common.m.b.ae
            public final void a(com.anythink.core.common.m.c.d dVar) {
                dVar.d(fVar);
            }
        };
    }

    public static ae a(x xVar, byte[] bArr) {
        return a(xVar, bArr, bArr.length);
    }

    private static ae a(final x xVar, final byte[] bArr, final int i) {
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        com.anythink.core.common.m.b.a.c.a(bArr.length, i);
        return new ae() { // from class: com.anythink.core.common.m.b.ae.2
            final /* synthetic */ int d = 0;

            @Override // com.anythink.core.common.m.b.ae
            public final x a() {
                return xVar;
            }

            @Override // com.anythink.core.common.m.b.ae
            public final long b() {
                return i;
            }

            @Override // com.anythink.core.common.m.b.ae
            public final void a(com.anythink.core.common.m.c.d dVar) {
                dVar.c(bArr, this.d, i);
            }
        };
    }

    private static ae a(final x xVar, final File file) {
        if (file == null) {
            throw new NullPointerException("file == null");
        }
        return new ae() { // from class: com.anythink.core.common.m.b.ae.3
            @Override // com.anythink.core.common.m.b.ae
            public final x a() {
                return xVar;
            }

            @Override // com.anythink.core.common.m.b.ae
            public final long b() {
                return file.length();
            }

            @Override // com.anythink.core.common.m.b.ae
            public final void a(com.anythink.core.common.m.c.d dVar) {
                com.anythink.core.common.m.c.w wVarA = com.anythink.core.common.m.c.n.a(file);
                try {
                    dVar.a(wVarA);
                    if (wVarA != null) {
                        wVarA.close();
                    }
                } catch (Throwable th) {
                    if (wVarA != null) {
                        try {
                            wVarA.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
        };
    }
}
