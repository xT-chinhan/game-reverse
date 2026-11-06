package com.anythink.core.common.k.a;

import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.bridge.IATBaseAdAdapter;
import com.anythink.core.common.k.g.c;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static IATBaseAdAdapter a(IATBaseAdAdapter iATBaseAdAdapter) {
        return new b(iATBaseAdAdapter);
    }

    private static ATCustomLoadListener a(IATBaseAdAdapter iATBaseAdAdapter, ATCustomLoadListener aTCustomLoadListener) {
        if (iATBaseAdAdapter == null || aTCustomLoadListener == null) {
            return null;
        }
        com.anythink.core.common.k.d.b serverExtraInfo = iATBaseAdAdapter.getServerExtraInfo();
        return (serverExtraInfo == null || !serverExtraInfo.k()) ? aTCustomLoadListener : new c(aTCustomLoadListener, serverExtraInfo);
    }

    private static ATBiddingListener a(IATBaseAdAdapter iATBaseAdAdapter, ATBiddingListener aTBiddingListener) {
        if (iATBaseAdAdapter == null || aTBiddingListener == null) {
            return null;
        }
        com.anythink.core.common.k.d.b serverExtraInfo = iATBaseAdAdapter.getServerExtraInfo();
        return (serverExtraInfo == null || !serverExtraInfo.k()) ? aTBiddingListener : new com.anythink.core.common.k.g.b(aTBiddingListener, serverExtraInfo);
    }
}
