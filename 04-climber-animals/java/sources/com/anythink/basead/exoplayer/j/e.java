package com.anythink.basead.exoplayer.j;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes.dex */
public final class e implements h {
    private final ContentResolver a;
    private final aa<? super e> b;
    private Uri c;
    private AssetFileDescriptor d;
    private FileInputStream e;
    private long f;
    private boolean g;

    public static class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    private e(Context context) {
        this(context, null);
    }

    public e(Context context, aa<? super e> aaVar) {
        this.a = context.getContentResolver();
        this.b = aaVar;
    }

    @Override // com.anythink.basead.exoplayer.j.h
    public final long a(k kVar) throws a {
        try {
            Uri uri = kVar.c;
            this.c = uri;
            AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = this.a.openAssetFileDescriptor(uri, com.kuaishou.weapon.p0.t.k);
            this.d = assetFileDescriptorOpenAssetFileDescriptor;
            if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                throw new FileNotFoundException("Could not open file descriptor for: " + this.c);
            }
            this.e = new FileInputStream(this.d.getFileDescriptor());
            long startOffset = this.d.getStartOffset();
            long jSkip = this.e.skip(kVar.f + startOffset) - startOffset;
            if (jSkip != kVar.f) {
                throw new EOFException();
            }
            long jPosition = -1;
            if (kVar.g != -1) {
                this.f = kVar.g;
            } else {
                long length = this.d.getLength();
                if (length == -1) {
                    FileChannel channel = this.e.getChannel();
                    long size = channel.size();
                    if (size != 0) {
                        jPosition = size - channel.position();
                    }
                    this.f = jPosition;
                } else {
                    this.f = length - jSkip;
                }
            }
            this.g = true;
            aa<? super e> aaVar = this.b;
            if (aaVar != null) {
                aaVar.b();
            }
            return this.f;
        } catch (IOException e) {
            throw new a(e);
        }
    }

    @Override // com.anythink.basead.exoplayer.j.h
    public final int a(byte[] bArr, int i, int i2) throws a {
        if (i2 == 0) {
            return 0;
        }
        long j = this.f;
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
        int i3 = this.e.read(bArr, i, i2);
        if (i3 == -1) {
            if (this.f == -1) {
                return -1;
            }
            throw new a(new EOFException());
        }
        long j2 = this.f;
        if (j2 != -1) {
            this.f = j2 - ((long) i3);
        }
        aa<? super e> aaVar = this.b;
        if (aaVar != null) {
            aaVar.a(i3);
        }
        return i3;
    }

    @Override // com.anythink.basead.exoplayer.j.h
    public final Uri a() {
        return this.c;
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
            r4.c = r0
            r1 = 0
            java.io.FileInputStream r2 = r4.e     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L3f
            if (r2 == 0) goto Lb
            r2.close()     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L3f
        Lb:
            r4.e = r0
            android.content.res.AssetFileDescriptor r2 = r4.d     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L26
            if (r2 == 0) goto L14
            r2.close()     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L26
        L14:
            r4.d = r0
            boolean r0 = r4.g
            if (r0 == 0) goto L23
            r4.g = r1
            com.anythink.basead.exoplayer.j.aa<? super com.anythink.basead.exoplayer.j.e> r0 = r4.b
            if (r0 == 0) goto L23
            r0.c()
        L23:
            return
        L24:
            r2 = move-exception
            goto L2d
        L26:
            r2 = move-exception
            com.anythink.basead.exoplayer.j.e$a r3 = new com.anythink.basead.exoplayer.j.e$a     // Catch: java.lang.Throwable -> L24
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L24
            throw r3     // Catch: java.lang.Throwable -> L24
        L2d:
            r4.d = r0
            boolean r0 = r4.g
            if (r0 == 0) goto L3c
            r4.g = r1
            com.anythink.basead.exoplayer.j.aa<? super com.anythink.basead.exoplayer.j.e> r0 = r4.b
            if (r0 == 0) goto L3c
            r0.c()
        L3c:
            throw r2
        L3d:
            r2 = move-exception
            goto L46
        L3f:
            r2 = move-exception
            com.anythink.basead.exoplayer.j.e$a r3 = new com.anythink.basead.exoplayer.j.e$a     // Catch: java.lang.Throwable -> L3d
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L3d
            throw r3     // Catch: java.lang.Throwable -> L3d
        L46:
            r4.e = r0
            android.content.res.AssetFileDescriptor r3 = r4.d     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L61
            if (r3 == 0) goto L4f
            r3.close()     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L61
        L4f:
            r4.d = r0
            boolean r0 = r4.g
            if (r0 == 0) goto L5e
            r4.g = r1
            com.anythink.basead.exoplayer.j.aa<? super com.anythink.basead.exoplayer.j.e> r0 = r4.b
            if (r0 == 0) goto L5e
            r0.c()
        L5e:
            throw r2
        L5f:
            r2 = move-exception
            goto L68
        L61:
            r2 = move-exception
            com.anythink.basead.exoplayer.j.e$a r3 = new com.anythink.basead.exoplayer.j.e$a     // Catch: java.lang.Throwable -> L5f
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L5f
            throw r3     // Catch: java.lang.Throwable -> L5f
        L68:
            r4.d = r0
            boolean r0 = r4.g
            if (r0 == 0) goto L77
            r4.g = r1
            com.anythink.basead.exoplayer.j.aa<? super com.anythink.basead.exoplayer.j.e> r0 = r4.b
            if (r0 == 0) goto L77
            r0.c()
        L77:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.basead.exoplayer.j.e.b():void");
    }
}
