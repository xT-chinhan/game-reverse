package com.anythink.core.common.w.b;

import android.content.Context;
import com.anythink.core.api.ATSDK;
import com.anythink.core.common.v.q;
import com.anythink.core.d.l;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class f {
    private static void a(Context context, String str, l lVar, b bVar) {
        if (context == null || ATSDK.isCnSDK() || !q.a(context)) {
            if (bVar != null) {
                bVar.a();
            }
        } else {
            h hVar = new h(context, str, lVar, bVar);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(new d());
            new g(arrayList, hVar, 0).a(hVar);
        }
    }

    private static void b(Context context, String str, l lVar, b bVar) {
        h hVar = new h(context, str, lVar, bVar);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new e());
        new g(arrayList, hVar, 0).a(hVar);
    }
}
