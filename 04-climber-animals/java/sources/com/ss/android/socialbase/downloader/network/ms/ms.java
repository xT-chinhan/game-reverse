package com.ss.android.socialbase.downloader.network.ms;

import com.bytedance.sdk.openadsdk.api.ab;
import com.ss.android.socialbase.downloader.ny.c;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ms {
    private final Map<String, d> ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected int f4731ms;
    private final Map<String, ah> xr;

    void ms(String str, ah ahVar) {
        synchronized (this.xr) {
            this.xr.put(str, ahVar);
        }
    }

    void ms(int i) {
        this.f4731ms = i;
    }

    public ah ms(String str, List<com.ss.android.socialbase.downloader.model.ah> list) {
        ah ahVarRemove;
        synchronized (this.xr) {
            ahVarRemove = this.xr.remove(str);
        }
        if (ahVarRemove == null) {
            return null;
        }
        if (c.ms(ahVarRemove.x(), list)) {
            try {
                ahVarRemove.d();
            } catch (InterruptedException e) {
                ab.ms(e);
            }
            if (ahVarRemove.c() && ahVarRemove.ka()) {
                return ahVarRemove;
            }
        }
        try {
            ahVarRemove.ah();
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean ms(String str) {
        ah ahVar = this.xr.get(str);
        if (ahVar != null) {
            if (ahVar.ab()) {
                return true;
            }
            if (ahVar.c() && ahVar.ka()) {
                return true;
            }
        }
        return false;
    }

    public d xr(String str, List<com.ss.android.socialbase.downloader.model.ah> list) {
        d dVarRemove;
        synchronized (this.ah) {
            dVarRemove = this.ah.remove(str);
        }
        if (dVarRemove == null) {
            return null;
        }
        if (c.ms(dVarRemove.c(), list)) {
            try {
                dVarRemove.ka();
            } catch (InterruptedException e) {
                ab.ms(e);
            }
            if (dVarRemove.x() && dVarRemove.ab()) {
                return dVarRemove;
            }
        }
        try {
            dVarRemove.d();
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.network.ms.ms$ms, reason: collision with other inner class name */
    private static final class C0572ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private static final ms f4732ms = new ms();
    }

    public static ms ms() {
        return C0572ms.f4732ms;
    }

    private ms() {
        this.xr = new HashMap();
        this.ah = new LinkedHashMap(3);
        this.f4731ms = 3;
    }
}
