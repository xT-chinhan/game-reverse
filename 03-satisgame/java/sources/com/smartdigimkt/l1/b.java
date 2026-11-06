package com.smartdigimkt.l1;

import android.content.Context;
import android.text.TextUtils;
import com.smartdigimkt.d0.s;
import com.smartdigimkt.h0.g;
import com.smartdigimkt.o4.o;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.z.e0;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static b b;
    public final Context a;

    public b(Context context) {
        this.a = context.getApplicationContext();
    }

    public static b a(Context context) {
        if (b == null) {
            b = new b(context);
        }
        return b;
    }

    public static com.smartdigimkt.e3.a a(String str, String str2) {
        List<com.smartdigimkt.e3.a> list;
        com.smartdigimkt.e3.b bVar;
        com.smartdigimkt.p4.e eVarB = o.a().b(str);
        if (eVarB == null || (list = eVarB.D) == null) {
            return null;
        }
        for (com.smartdigimkt.e3.a aVar : list) {
            if (aVar.w == null) {
                aVar.w = eVarB.E;
            }
            if (TextUtils.equals(str2, aVar.a) && (bVar = eVarB.E) != null && System.currentTimeMillis() - aVar.e0 <= bVar.q) {
                return aVar;
            }
        }
        return null;
    }

    public final void a(String str, com.smartdigimkt.e3.a aVar, com.smartdigimkt.a3.a aVar2, com.smartdigimkt.k1.b bVar) {
        List list = SDKContext.getInstance().r.a;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(aVar.m, (String) it.next())) {
                    bVar.a(new g(com.anythink.core.common.inner.b.b.h, com.anythink.core.common.inner.b.b.M));
                    return;
                }
            }
        }
        com.smartdigimkt.h0.c cVarA = e.a(this.a).a(aVar);
        int i = aVar.c0;
        if (i != -1 && cVarA.d >= i) {
            bVar.a(new g(com.anythink.core.common.inner.b.b.e, com.anythink.core.common.inner.b.b.F));
            return;
        }
        e eVarA = e.a(this.a);
        eVarA.getClass();
        if (System.currentTimeMillis() - eVarA.a(aVar).e <= aVar.d0) {
            bVar.a(new g(com.anythink.core.common.inner.b.b.f, com.anythink.core.common.inner.b.b.G));
        } else {
            e0.a().getClass();
            e0.a(str, false, aVar, aVar2, bVar);
        }
    }

    public final boolean a(com.smartdigimkt.e3.a aVar, com.smartdigimkt.a3.a aVar2, boolean z) {
        if (this.a == null || aVar == null) {
            return false;
        }
        List list = SDKContext.getInstance().r.a;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(aVar.m, (String) it.next())) {
                    return false;
                }
            }
        }
        if (z) {
            e0.a().getClass();
            return s.a(aVar, aVar2);
        }
        com.smartdigimkt.h0.c cVarA = e.a(this.a).a(aVar);
        int i = aVar.c0;
        if (i != -1 && cVarA.d >= i) {
            return false;
        }
        e eVarA = e.a(this.a);
        eVarA.getClass();
        if (System.currentTimeMillis() - eVarA.a(aVar).e <= aVar.d0) {
            return false;
        }
        e0.a().getClass();
        return s.a(aVar, aVar2);
    }
}
