package com.anythink.core.d;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.h.v;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private static final String a = "c";

    public final void a(final Context context, final v vVar, com.anythink.core.common.m.q qVar) {
        if (context == null) {
            return;
        }
        com.anythink.core.common.d.t.b().T();
        if (vVar.e()) {
            com.anythink.core.common.g.c.a();
            if (com.anythink.core.common.g.c.c()) {
                final com.anythink.core.common.m.n nVar = new com.anythink.core.common.m.n(qVar);
                com.anythink.core.common.i.a();
                String strB = com.anythink.core.common.i.b();
                final String strF = com.anythink.core.common.v.q.f(strB);
                new com.anythink.core.common.m.f(context, vVar).a(strB).a(0, (com.anythink.core.common.m.q) nVar);
                com.anythink.core.common.g.c.a().a(new com.anythink.core.common.g.d() { // from class: com.anythink.core.d.c.1
                    @Override // com.anythink.core.common.g.d
                    public final void a(String str) {
                        String unused = c.a;
                        Object[] objArr = new Object[2];
                        if (!TextUtils.isEmpty(str) && !str.equals(strF)) {
                            boolean zA = nVar.a();
                            String unused2 = c.a;
                            Object[] objArr2 = new Object[2];
                            Boolean.valueOf(zA);
                            vVar.a();
                            if (zA) {
                                return;
                            }
                            com.anythink.core.common.g.c.a();
                            com.anythink.core.common.i.a();
                            new com.anythink.core.common.m.f(context, vVar).a(com.anythink.core.common.g.c.b(com.anythink.core.common.i.b(), str)).a(0, (com.anythink.core.common.m.q) nVar);
                            return;
                        }
                        nVar.onLoadError(0, String.format("The cdnDomain(%s) is not equal to curAppDomain(%s).", str, strF), ErrorCode.getErrorCode(ErrorCode.appIdError, "", ""));
                    }
                });
                return;
            }
        }
        new com.anythink.core.common.m.f(context, vVar).a(0, qVar);
    }

    public static void b(Context context, v vVar, com.anythink.core.common.m.q qVar) {
        if (context == null) {
            return;
        }
        new com.anythink.core.common.m.j(context, vVar).a(0, qVar);
    }
}
