package com.umeng.analytics.pro;

import android.content.Context;
import org.repackage.com.meizu.flyme.openidsdk.OpenIdHelper;

/* JADX INFO: compiled from: MeizuDeviceIdSupplier.java */
/* JADX INFO: loaded from: classes4.dex */
class bn implements bf {
    bn() {
    }

    @Override // com.umeng.analytics.pro.bf
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean zA = OpenIdHelper.a();
        bu.a("getOAID", "isSupported", Boolean.valueOf(zA));
        if (zA) {
            return OpenIdHelper.b(context);
        }
        return null;
    }
}
