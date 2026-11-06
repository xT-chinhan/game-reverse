package com.anythink.network.myoffer;

import android.content.Context;
import com.anythink.basead.h.a.a;
import com.anythink.basead.h.a.b;
import com.anythink.core.common.h.az;

/* JADX INFO: loaded from: classes.dex */
public class MyOfferAPI {
    public static void preloadTopOnOffer(Context context, az azVar) {
        a.a(context).a(azVar);
    }

    public static String getOutOfCapOfferIds(Context context) {
        return b.a(context).a();
    }

    public static String getDefaultOfferId(Context context, String str) {
        return a.a(context).a(str);
    }

    public static boolean checkOffersOutOfCap(Context context, String str) {
        return b.a(context).a(str);
    }
}
