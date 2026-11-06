package com.smartdigimkt.y0;

import android.net.Uri;
import android.util.Base64;
import java.net.URLDecoder;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements i {
    public k a;
    public int b;
    public byte[] c;

    @Override // com.smartdigimkt.y0.i
    public final long a(k kVar) throws com.smartdigimkt.i0.y {
        this.a = kVar;
        Uri uri = kVar.a;
        String scheme = uri.getScheme();
        if (!com.anythink.core.common.l.f.R.equals(scheme)) {
            throw new com.smartdigimkt.i0.y("Unsupported scheme: " + scheme);
        }
        String schemeSpecificPart = uri.getSchemeSpecificPart();
        int i = com.smartdigimkt.z0.u.a;
        String[] strArrSplit = schemeSpecificPart.split(",", -1);
        if (strArrSplit.length != 2) {
            throw new com.smartdigimkt.i0.y("Unexpected URI format: " + uri);
        }
        String str = strArrSplit[1];
        if (strArrSplit[0].contains(";base64")) {
            try {
                this.c = Base64.decode(str, 0);
            } catch (IllegalArgumentException e) {
                throw new com.smartdigimkt.i0.y("Error while parsing Base64 encoded string: " + str, e);
            }
        } else {
            this.c = URLDecoder.decode(str, "US-ASCII").getBytes();
        }
        return this.c.length;
    }

    @Override // com.smartdigimkt.y0.i
    public final void close() {
        this.a = null;
        this.c = null;
    }

    @Override // com.smartdigimkt.y0.i
    public final int a(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int length = this.c.length - this.b;
        if (length == 0) {
            return -1;
        }
        int iMin = Math.min(i2, length);
        System.arraycopy(this.c, this.b, bArr, i, iMin);
        this.b += iMin;
        return iMin;
    }

    @Override // com.smartdigimkt.y0.i
    public final Uri a() {
        k kVar = this.a;
        if (kVar != null) {
            return kVar.a;
        }
        return null;
    }
}
