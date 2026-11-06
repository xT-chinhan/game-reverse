package com.anythink.splashad.a;

/* JADX INFO: loaded from: classes.dex */
public final class d implements com.anythink.core.common.o.c {
    @Override // com.anythink.core.common.o.c
    public final void a(String str, com.anythink.core.common.d.a aVar) {
        if (aVar == null || !(aVar instanceof b)) {
            return;
        }
        ((b) aVar).setRequestId(str);
    }
}
