package com.anythink.basead.exoplayer.j;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class y implements h {
    public static final String a = "rawresource";
    private final Resources b;
    private final aa<? super y> c;
    private Uri d;
    private AssetFileDescriptor e;
    private InputStream f;
    private long g;
    private boolean h;

    public static class a extends IOException {
        public a(String str) {
            super(str);
        }

        public a(IOException iOException) {
            super(iOException);
        }
    }

    private static Uri a(int i) {
        return Uri.parse("rawresource:///".concat(String.valueOf(i)));
    }

    private y(Context context) {
        this(context, null);
    }

    public y(Context context, aa<? super y> aaVar) {
        this.b = context.getResources();
        this.c = aaVar;
    }

    @Override // com.anythink.basead.exoplayer.j.h
    public final long a(k kVar) throws a {
        try {
            Uri uri = kVar.c;
            this.d = uri;
            if (!TextUtils.equals(a, uri.getScheme())) {
                throw new a("URI must use scheme rawresource");
            }
            try {
                this.e = this.b.openRawResourceFd(Integer.parseInt(this.d.getLastPathSegment()));
                FileInputStream fileInputStream = new FileInputStream(this.e.getFileDescriptor());
                this.f = fileInputStream;
                fileInputStream.skip(this.e.getStartOffset());
                if (this.f.skip(kVar.f) < kVar.f) {
                    throw new EOFException();
                }
                long j = -1;
                if (kVar.g != -1) {
                    this.g = kVar.g;
                } else {
                    long length = this.e.getLength();
                    if (length != -1) {
                        j = length - kVar.f;
                    }
                    this.g = j;
                }
                this.h = true;
                aa<? super y> aaVar = this.c;
                if (aaVar != null) {
                    aaVar.b();
                }
                return this.g;
            } catch (NumberFormatException unused) {
                throw new a("Resource identifier must be an integer.");
            }
        } catch (IOException e) {
            throw new a(e);
        }
    }

    @Override // com.anythink.basead.exoplayer.j.h
    public final int a(byte[] bArr, int i, int i2) throws a {
        if (i2 == 0) {
            return 0;
        }
        long j = this.g;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e) {
                throw new a(e);
            }
        }
        int i3 = this.f.read(bArr, i, i2);
        if (i3 == -1) {
            if (this.g == -1) {
                return -1;
            }
            throw new a(new EOFException());
        }
        long j2 = this.g;
        if (j2 != -1) {
            this.g = j2 - ((long) i3);
        }
        aa<? super y> aaVar = this.c;
        if (aaVar != null) {
            aaVar.a(i3);
        }
        return i3;
    }

    @Override // com.anythink.basead.exoplayer.j.h
    public final Uri a() {
        return this.d;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x003d */
    /* JADX WARN: Bottom block not found for handler: all -> 0x005f */
    @Override // com.anythink.basead.exoplayer.j.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b() {
        /*
            r4 = this;
            r0 = 0
            r4.d = r0
            r1 = 0
            java.io.InputStream r2 = r4.f     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L3f
            if (r2 == 0) goto Lb
            r2.close()     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L3f
        Lb:
            r4.f = r0
            android.content.res.AssetFileDescriptor r2 = r4.e     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L26
            if (r2 == 0) goto L14
            r2.close()     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L26
        L14:
            r4.e = r0
            boolean r0 = r4.h
            if (r0 == 0) goto L23
            r4.h = r1
            com.anythink.basead.exoplayer.j.aa<? super com.anythink.basead.exoplayer.j.y> r0 = r4.c
            if (r0 == 0) goto L23
            r0.c()
        L23:
            return
        L24:
            r2 = move-exception
            goto L2d
        L26:
            r2 = move-exception
            com.anythink.basead.exoplayer.j.y$a r3 = new com.anythink.basead.exoplayer.j.y$a     // Catch: java.lang.Throwable -> L24
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L24
            throw r3     // Catch: java.lang.Throwable -> L24
        L2d:
            r4.e = r0
            boolean r0 = r4.h
            if (r0 == 0) goto L3c
            r4.h = r1
            com.anythink.basead.exoplayer.j.aa<? super com.anythink.basead.exoplayer.j.y> r0 = r4.c
            if (r0 == 0) goto L3c
            r0.c()
        L3c:
            throw r2
        L3d:
            r2 = move-exception
            goto L46
        L3f:
            r2 = move-exception
            com.anythink.basead.exoplayer.j.y$a r3 = new com.anythink.basead.exoplayer.j.y$a     // Catch: java.lang.Throwable -> L3d
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L3d
            throw r3     // Catch: java.lang.Throwable -> L3d
        L46:
            r4.f = r0
            android.content.res.AssetFileDescriptor r3 = r4.e     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L61
            if (r3 == 0) goto L4f
            r3.close()     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L61
        L4f:
            r4.e = r0
            boolean r0 = r4.h
            if (r0 == 0) goto L5e
            r4.h = r1
            com.anythink.basead.exoplayer.j.aa<? super com.anythink.basead.exoplayer.j.y> r0 = r4.c
            if (r0 == 0) goto L5e
            r0.c()
        L5e:
            throw r2
        L5f:
            r2 = move-exception
            goto L68
        L61:
            r2 = move-exception
            com.anythink.basead.exoplayer.j.y$a r3 = new com.anythink.basead.exoplayer.j.y$a     // Catch: java.lang.Throwable -> L5f
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L5f
            throw r3     // Catch: java.lang.Throwable -> L5f
        L68:
            r4.e = r0
            boolean r0 = r4.h
            if (r0 == 0) goto L77
            r4.h = r1
            com.anythink.basead.exoplayer.j.aa<? super com.anythink.basead.exoplayer.j.y> r0 = r4.c
            if (r0 == 0) goto L77
            r0.c()
        L77:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.basead.exoplayer.j.y.b():void");
    }
}
