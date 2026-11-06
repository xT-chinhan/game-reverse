package com.anythink.core.bridge.a;

import android.os.Bundle;
import com.anythink.core.api.ATAdFilter;
import com.anythink.core.api.bridge.ATBaseAdAdapter;
import com.anythink.core.bridge.a.b.AnonymousClass4;
import com.anythink.core.common.d.s;
import com.anythink.core.common.h.by;
import com.anythink.core.common.u.b.c;
import com.anythink.core.common.u.b.d;
import com.anythink.core.common.u.b.e;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static int a = 5;
    public static int b = 6;
    public static int c = 7;
    private static volatile a e;
    private final String d = "a";

    public static a a() {
        if (e == null) {
            synchronized (a.class) {
                if (e == null) {
                    e = new a();
                }
            }
        }
        return e;
    }

    private a() {
    }

    public static void a(ATBaseAdAdapter aTBaseAdAdapter, int i, String str) {
        if (aTBaseAdAdapter != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putString(com.anythink.core.common.f.a.C0017a.d, str);
                by unitGroupInfo = aTBaseAdAdapter.getUnitGroupInfo();
                if (unitGroupInfo != null) {
                    bundle.putInt(ATAdFilter.KEY_NETWORK_ID, unitGroupInfo.n());
                }
                c.a().a(new d(e.ce, b.a().new AnonymousClass4(i, s.b().g(), bundle)));
            } catch (Throwable unused) {
            }
        }
    }
}
