package com.smartdigimkt.d1;

import android.content.Context;
import com.smartdigimkt.sdk.api.IOfferClickHandler;
import com.smartdigimkt.z.b0;
import com.smartdigimkt.z.j0;
import com.smartdigimkt.z.s;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends IOfferClickHandler {
    @Override // com.smartdigimkt.sdk.api.IOfferClickHandler
    public final boolean startDataFetchApp(Context context, com.smartdigimkt.b3.c cVar, com.smartdigimkt.a3.a aVar, String str) {
        return s.a(context, aVar, cVar, (com.smartdigimkt.h0.f) b0.a().a.get(cVar.e() + cVar.a), str, new j0());
    }
}
