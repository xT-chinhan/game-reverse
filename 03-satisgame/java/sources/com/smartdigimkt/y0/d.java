package com.smartdigimkt.y0;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements i {
    public final AssetManager a;
    public Uri b;
    public InputStream c;
    public long d;
    public boolean e;

    public d(Context context) {
        this.a = context.getAssets();
    }

    @Override // com.smartdigimkt.y0.i
    public final long a(k kVar) throws c {
        try {
            Uri uri = kVar.a;
            this.b = uri;
            String path = uri.getPath();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith("/")) {
                path = path.substring(1);
            }
            InputStream inputStreamOpen = this.a.open(path, 1);
            this.c = inputStreamOpen;
            if (inputStreamOpen.skip(kVar.c) < kVar.c) {
                throw new EOFException();
            }
            long jAvailable = this.c.available();
            this.d = jAvailable;
            if (jAvailable == 2147483647L) {
                this.d = -1L;
            }
            this.e = true;
            return this.d;
        } catch (IOException e) {
            throw new c(e);
        }
    }

    @Override // com.smartdigimkt.y0.i
    public final void close() {
        this.b = null;
        try {
            try {
                InputStream inputStream = this.c;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.c = null;
                if (this.e) {
                    this.e = false;
                }
            } catch (IOException e) {
                throw new c(e);
            }
        } catch (Throwable th) {
            this.c = null;
            if (this.e) {
                this.e = false;
            }
            throw th;
        }
    }

    @Override // com.smartdigimkt.y0.i
    public final int a(byte[] bArr, int i, int i2) throws c {
        if (i2 == 0) {
            return 0;
        }
        long j = this.d;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e) {
                throw new c(e);
            }
        }
        int i3 = this.c.read(bArr, i, i2);
        if (i3 == -1) {
            if (this.d == -1) {
                return -1;
            }
            throw new c(new EOFException());
        }
        long j2 = this.d;
        if (j2 != -1) {
            this.d = j2 - ((long) i3);
        }
        return i3;
    }

    @Override // com.smartdigimkt.y0.i
    public final Uri a() {
        return this.b;
    }
}
