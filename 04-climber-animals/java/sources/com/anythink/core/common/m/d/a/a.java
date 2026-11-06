package com.anythink.core.common.m.d.a;

import com.anythink.core.common.m.d.d;

/* JADX INFO: loaded from: classes.dex */
public class a extends c {
    private static final String b = "a";
    private static final int c = 1;

    @Override // com.anythink.core.common.m.d.a.c
    protected final synchronized void a(d dVar, d.a aVar) {
        int iA = a(this.a.getInputStream());
        if (iA == 1) {
            if (aVar != null) {
                aVar.a(dVar);
            }
            dVar.toString();
        } else {
            throw new Exception("Response Error Code:".concat(String.valueOf(iA)));
        }
    }
}
