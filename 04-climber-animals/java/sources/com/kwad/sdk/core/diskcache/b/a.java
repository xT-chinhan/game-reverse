package com.kwad.sdk.core.diskcache.b;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.be;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private com.kwad.sdk.core.diskcache.a.a aDg;

    /* JADX INFO: renamed from: com.kwad.sdk.core.diskcache.b.a$a, reason: collision with other inner class name */
    static final class C0490a {
        static final a aDh = new a(0);
    }

    /* synthetic */ a(byte b) {
        this();
    }

    private a() {
    }

    private synchronized void init(Context context) {
        if (this.aDg != null || context == null) {
            return;
        }
        try {
            this.aDg = com.kwad.sdk.core.diskcache.a.a.a(be.dE(context), 1, 1, 209715200L);
        } catch (Throwable unused) {
        }
    }

    public static a GP() {
        return C0490a.aDh;
    }

    public final void dG(String str) {
        if (GQ() || TextUtils.isEmpty(str)) {
            return;
        }
        b.a(this.aDg, str, c.dI(str));
    }

    public final boolean a(String str, com.kwad.sdk.core.network.a.a.C0498a c0498a) {
        File fileDH;
        if (!GQ() && !TextUtils.isEmpty(str)) {
            String strDI = c.dI(str);
            if (b.a(this.aDg, str, strDI, c0498a) && (fileDH = dH(strDI)) != null && fileDH.exists()) {
                return true;
            }
        }
        return false;
    }

    public final boolean b(String str, String str2, com.kwad.sdk.core.network.a.a.C0498a c0498a) {
        File fileDH;
        if (!GQ() && !TextUtils.isEmpty(str)) {
            String strDI = c.dI(str2);
            if (b.a(this.aDg, str, strDI, c0498a) && (fileDH = dH(strDI)) != null && fileDH.exists()) {
                return true;
            }
        }
        return false;
    }

    public final File cf(String str) {
        if (GQ() || TextUtils.isEmpty(str)) {
            return null;
        }
        return dH(c.dI(str));
    }

    private File dH(String str) {
        if (GQ() || TextUtils.isEmpty(str)) {
            return null;
        }
        return b.a(this.aDg, str);
    }

    public final boolean remove(String str) {
        if (GQ()) {
            return false;
        }
        try {
            ax.ax(str, "cacheKey is not allowed empty");
            return this.aDg.remove(c.dI(str));
        } catch (IOException unused) {
            return false;
        }
    }

    public final void delete() {
        if (GQ()) {
            return;
        }
        try {
            this.aDg.delete();
        } catch (IOException unused) {
        }
    }

    private boolean GQ() {
        init(((f) ServiceProvider.get(f.class)).getContext());
        return this.aDg == null;
    }
}
