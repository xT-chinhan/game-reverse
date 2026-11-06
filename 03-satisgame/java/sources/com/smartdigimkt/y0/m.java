package com.smartdigimkt.y0;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.LiveConfigKey;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements i {
    public final Context a;
    public final i b;
    public r c;
    public d d;
    public f e;
    public i f;
    public g g;
    public c0 h;
    public i i;

    public m(Context context, i iVar) {
        this.a = context.getApplicationContext();
        iVar.getClass();
        this.b = iVar;
    }

    @Override // com.smartdigimkt.y0.i
    public final long a(k kVar) {
        if (this.i != null) {
            throw new IllegalStateException();
        }
        String scheme = kVar.a.getScheme();
        Uri uri = kVar.a;
        int i = com.smartdigimkt.z0.u.a;
        String scheme2 = uri.getScheme();
        if (TextUtils.isEmpty(scheme2) || "file".equals(scheme2)) {
            if (kVar.a.getPath().startsWith("/android_asset/")) {
                if (this.d == null) {
                    this.d = new d(this.a);
                }
                this.i = this.d;
            } else {
                if (this.c == null) {
                    this.c = new r();
                }
                this.i = this.c;
            }
        } else if ("asset".equals(scheme)) {
            if (this.d == null) {
                this.d = new d(this.a);
            }
            this.i = this.d;
        } else if (com.anythink.core.common.k.D.equals(scheme)) {
            if (this.e == null) {
                this.e = new f(this.a);
            }
            this.i = this.e;
        } else if (LiveConfigKey.RTMP.equals(scheme)) {
            i iVar = this.f;
            if (iVar == null && iVar == null) {
                this.f = this.b;
            }
            this.i = this.f;
        } else if (com.anythink.core.common.l.f.R.equals(scheme)) {
            if (this.g == null) {
                this.g = new g();
            }
            this.i = this.g;
        } else if ("rawresource".equals(scheme)) {
            if (this.h == null) {
                this.h = new c0(this.a);
            }
            this.i = this.h;
        } else {
            this.i = this.b;
        }
        return this.i.a(kVar);
    }

    @Override // com.smartdigimkt.y0.i
    public final void close() {
        i iVar = this.i;
        if (iVar != null) {
            try {
                iVar.close();
            } finally {
                this.i = null;
            }
        }
    }

    @Override // com.smartdigimkt.y0.i
    public final int a(byte[] bArr, int i, int i2) {
        return this.i.a(bArr, i, i2);
    }

    @Override // com.smartdigimkt.y0.i
    public final Uri a() {
        i iVar = this.i;
        if (iVar == null) {
            return null;
        }
        return iVar.a();
    }
}
