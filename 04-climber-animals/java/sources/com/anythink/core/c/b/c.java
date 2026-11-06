package com.anythink.core.c.b;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.common.h.bu;
import com.anythink.core.common.h.bv;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class c implements b {
    private static final String a = "PlacementStatRecWrapper";
    private final b c = new d();
    private final Handler b = com.anythink.core.common.v.b.b.a().a(11);

    @Override // com.anythink.core.c.b.b
    public final void a(final String str, final String str2, final int i, final ATAdRequest aTAdRequest, final bv bvVar) {
        a(new Runnable() { // from class: com.anythink.core.c.b.c.1
            @Override // java.lang.Runnable
            public final void run() {
                if (c.this.c != null) {
                    c.this.c.a(str, str2, i, aTAdRequest, bvVar);
                }
            }
        });
    }

    @Override // com.anythink.core.c.b.b
    public final void a(final bu buVar, final bv bvVar) {
        a(new Runnable() { // from class: com.anythink.core.c.b.c.2
            @Override // java.lang.Runnable
            public final void run() {
                if (c.this.c != null) {
                    c.this.c.a(buVar, bvVar);
                }
            }
        });
    }

    @Override // com.anythink.core.c.b.b
    public final List<com.anythink.core.c.a.a> a(int i, String str, int i2) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            Log.w(a, "The getStatisticsBeanList method cannot be called from the main thread.");
        }
        b bVar = this.c;
        return bVar != null ? bVar.a(i, str, i2) : new ArrayList();
    }

    @Override // com.anythink.core.c.b.b
    public final JSONObject a(String str) {
        return a(str, 0);
    }

    @Override // com.anythink.core.c.b.b
    public final JSONObject a(String str, int i) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            Log.w(a, "The getUserValueParams method cannot be called from the main thread.");
        }
        b bVar = this.c;
        return bVar != null ? bVar.a(str, i) : new JSONObject();
    }

    @Override // com.anythink.core.c.b.b
    public final JSONObject a(String str, int i, int i2) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            Log.w(a, "The getUserValueParams with count method cannot be called from the main thread.");
        }
        b bVar = this.c;
        return bVar != null ? bVar.a(str, i, i2) : new JSONObject();
    }

    @Override // com.anythink.core.c.b.b
    public final void b(String str) {
        b bVar = this.c;
        if (bVar != null) {
            bVar.b(str);
        }
    }

    @Override // com.anythink.core.c.b.b
    public final com.anythink.core.c.a.d a(String str, int i, com.anythink.core.d.f fVar) {
        b bVar = this.c;
        return bVar != null ? bVar.a(str, i, fVar) : new com.anythink.core.c.a.d();
    }

    private void a(Runnable runnable) {
        Handler handler = this.b;
        if (handler != null) {
            handler.post(runnable);
        }
    }
}
