package com.anythink.core.d.b;

import android.os.Looper;
import android.util.Log;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.common.h.bx;
import com.anythink.core.common.h.by;
import com.anythink.core.e.g;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class c implements b {
    private static final String a = "PlacementStatRecWrapper";
    private final b b = new d();

    @Override // com.anythink.core.d.b.b
    public final void a(final String str, final String str2, final int i, final ATAdRequest aTAdRequest, final by byVar) {
        a(new Runnable() { // from class: com.anythink.core.d.b.c.1
            @Override // java.lang.Runnable
            public final void run() {
                if (c.this.b != null) {
                    c.this.b.a(str, str2, i, aTAdRequest, byVar);
                }
            }
        });
    }

    @Override // com.anythink.core.d.b.b
    public final void a(final bx bxVar, final by byVar) {
        a(new Runnable() { // from class: com.anythink.core.d.b.c.2
            @Override // java.lang.Runnable
            public final void run() {
                if (c.this.b != null) {
                    c.this.b.a(bxVar, byVar);
                }
            }
        });
    }

    @Override // com.anythink.core.d.b.b
    public final List<com.anythink.core.d.a.a> a(int i, String str, int i2) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            Log.w(a, "The getStatisticsBeanList method cannot be called from the main thread.");
        }
        b bVar = this.b;
        return bVar != null ? bVar.a(i, str, i2) : new ArrayList();
    }

    @Override // com.anythink.core.d.b.b
    public final JSONObject a(String str) {
        return a(str, 0);
    }

    @Override // com.anythink.core.d.b.b
    public final JSONObject a(String str, int i) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            Log.w(a, "The getUserValueParams method cannot be called from the main thread.");
        }
        b bVar = this.b;
        return bVar != null ? bVar.a(str, i) : new JSONObject();
    }

    @Override // com.anythink.core.d.b.b
    public final JSONObject a(String str, int i, int i2) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            Log.w(a, "The getUserValueParams with count method cannot be called from the main thread.");
        }
        b bVar = this.b;
        return bVar != null ? bVar.a(str, i, i2) : new JSONObject();
    }

    @Override // com.anythink.core.d.b.b
    public final void b(String str) {
        b bVar = this.b;
        if (bVar != null) {
            bVar.b(str);
        }
    }

    @Override // com.anythink.core.d.b.b
    public final com.anythink.core.d.a.d a(String str, int i, g gVar) {
        b bVar = this.b;
        return bVar != null ? bVar.a(str, i, gVar) : new com.anythink.core.d.a.d();
    }

    private static void a(Runnable runnable) {
        com.anythink.core.common.u.b.c.a().e(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.bY, runnable));
    }
}
