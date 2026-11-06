package com.smartdigimkt.y0;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements i {
    public final ContentResolver a;
    public Uri b;
    public AssetFileDescriptor c;
    public FileInputStream d;
    public long e;
    public boolean f;

    public f(Context context) {
        this.a = context.getContentResolver();
    }

    @Override // com.smartdigimkt.y0.i
    public final long a(k kVar) throws e {
        try {
            Uri uri = kVar.a;
            this.b = uri;
            AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = this.a.openAssetFileDescriptor(uri, "r");
            this.c = assetFileDescriptorOpenAssetFileDescriptor;
            if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                throw new FileNotFoundException("Could not open file descriptor for: " + this.b);
            }
            this.d = new FileInputStream(this.c.getFileDescriptor());
            long startOffset = this.c.getStartOffset();
            long jSkip = this.d.skip(kVar.c + startOffset) - startOffset;
            if (jSkip != kVar.c) {
                throw new EOFException();
            }
            long length = this.c.getLength();
            long jPosition = -1;
            if (length == -1) {
                FileChannel channel = this.d.getChannel();
                long size = channel.size();
                if (size != 0) {
                    jPosition = size - channel.position();
                }
                this.e = jPosition;
            } else {
                this.e = length - jSkip;
            }
            this.f = true;
            return this.e;
        } catch (IOException e) {
            throw new e(e);
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x001d */
    /* JADX WARN: Bottom block not found for handler: all -> 0x002f */
    @Override // com.smartdigimkt.y0.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void close() {
        /*
            r4 = this;
            r0 = 0
            r4.b = r0
            r1 = 0
            java.io.FileInputStream r2 = r4.d     // Catch: java.lang.Throwable -> L2f java.io.IOException -> L31
            if (r2 == 0) goto Lb
            r2.close()     // Catch: java.lang.Throwable -> L2f java.io.IOException -> L31
        Lb:
            r4.d = r0
            android.content.res.AssetFileDescriptor r2 = r4.c     // Catch: java.lang.Throwable -> L1d java.io.IOException -> L1f
            if (r2 == 0) goto L14
            r2.close()     // Catch: java.lang.Throwable -> L1d java.io.IOException -> L1f
        L14:
            r4.c = r0
            boolean r0 = r4.f
            if (r0 == 0) goto L1c
            r4.f = r1
        L1c:
            return
        L1d:
            r2 = move-exception
            goto L26
        L1f:
            r2 = move-exception
            com.smartdigimkt.y0.e r3 = new com.smartdigimkt.y0.e     // Catch: java.lang.Throwable -> L1d
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L1d
            throw r3     // Catch: java.lang.Throwable -> L1d
        L26:
            r4.c = r0
            boolean r0 = r4.f
            if (r0 == 0) goto L2e
            r4.f = r1
        L2e:
            throw r2
        L2f:
            r2 = move-exception
            goto L38
        L31:
            r2 = move-exception
            com.smartdigimkt.y0.e r3 = new com.smartdigimkt.y0.e     // Catch: java.lang.Throwable -> L2f
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L2f
            throw r3     // Catch: java.lang.Throwable -> L2f
        L38:
            r4.d = r0
            android.content.res.AssetFileDescriptor r3 = r4.c     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            if (r3 == 0) goto L41
            r3.close()     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
        L41:
            r4.c = r0
            boolean r0 = r4.f
            if (r0 == 0) goto L49
            r4.f = r1
        L49:
            throw r2
        L4a:
            r2 = move-exception
            goto L53
        L4c:
            r2 = move-exception
            com.smartdigimkt.y0.e r3 = new com.smartdigimkt.y0.e     // Catch: java.lang.Throwable -> L4a
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L4a
            throw r3     // Catch: java.lang.Throwable -> L4a
        L53:
            r4.c = r0
            boolean r0 = r4.f
            if (r0 == 0) goto L5b
            r4.f = r1
        L5b:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.smartdigimkt.y0.f.close():void");
    }

    @Override // com.smartdigimkt.y0.i
    public final int a(byte[] bArr, int i, int i2) throws e {
        if (i2 == 0) {
            return 0;
        }
        long j = this.e;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e) {
                throw new e(e);
            }
        }
        int i3 = this.d.read(bArr, i, i2);
        if (i3 == -1) {
            if (this.e == -1) {
                return -1;
            }
            throw new e(new EOFException());
        }
        long j2 = this.e;
        if (j2 != -1) {
            this.e = j2 - ((long) i3);
        }
        return i3;
    }

    @Override // com.smartdigimkt.y0.i
    public final Uri a() {
        return this.b;
    }
}
