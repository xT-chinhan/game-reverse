package com.anythink.core.common.v.b;

import android.content.Context;
import com.anythink.core.api.ATSDK;
import com.anythink.core.common.u.p;
import com.anythink.core.e.l;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class f {
    private static void a(Context context, String str, l lVar, b bVar) {
        if (context != null && !ATSDK.isCnSDK() && p.a(context)) {
            h hVar = new h(context, str, lVar, bVar);
            new g(new ArrayList(1), hVar, 0).a(hVar);
        } else if (bVar != null) {
            bVar.a();
        }
    }

    private static void b(Context context, String str, l lVar, b bVar) {
        h hVar = new h(context, str, lVar, bVar);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new e());
        new g(arrayList, hVar, 0).a(hVar);
    }
}
