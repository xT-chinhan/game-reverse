package com.anythink.core.common.l.e.a;

import com.anythink.core.common.l.e.i;

/* JADX INFO: loaded from: classes.dex */
public class a extends e {
    private static final String a = "a";
    private static final int c = 1;

    @Override // com.anythink.core.common.l.e.a.e
    protected final boolean a() {
        return true;
    }

    @Override // com.anythink.core.common.l.e.a.e
    protected final synchronized void a(i iVar, i.a aVar) {
        d(iVar, aVar);
    }

    @Override // com.anythink.core.common.l.e.a.e
    protected final synchronized boolean b(i iVar, i.a aVar) {
        return d(iVar, aVar);
    }

    private boolean d(i iVar, i.a aVar) throws Exception {
        int iA = a(this.b.getInputStream());
        if (iA != 1) {
            throw new Exception("Response Error Code:".concat(String.valueOf(iA)));
        }
        if (aVar != null) {
            aVar.a(iVar);
        }
        return true;
    }
}
