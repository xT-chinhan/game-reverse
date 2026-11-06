package com.anythink.basead.handler;

import android.content.Context;
import com.anythink.basead.b.b;
import com.anythink.basead.b.d;
import com.anythink.basead.b.i;
import com.anythink.basead.d.e;
import com.anythink.core.api.IOfferClickHandler;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;

/* JADX INFO: loaded from: classes.dex */
public class OfferClickHandler extends IOfferClickHandler {
    private static e a(w wVar) {
        return d.a().a(wVar.b(), wVar.v());
    }

    @Override // com.anythink.core.api.IOfferClickHandler
    public boolean startDataFetchApp(Context context, w wVar, x xVar, String str) {
        return b.a(context, xVar, wVar, d.a().a(wVar.b(), wVar.v()), str, new i());
    }
}
