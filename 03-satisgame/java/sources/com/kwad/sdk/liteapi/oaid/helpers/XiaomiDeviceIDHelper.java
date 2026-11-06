package com.kwad.sdk.liteapi.oaid.helpers;

import android.content.Context;
import com.kwad.sdk.liteapi.LiteApiLogger;

/* JADX INFO: loaded from: classes3.dex */
public class XiaomiDeviceIDHelper {
    private static final String TAG = "XiaomiDeviceIDHelper";
    private Context mContext;

    public XiaomiDeviceIDHelper(Context context) {
        this.mContext = context;
    }

    public String getOAID() {
        String str = "";
        try {
            String str2 = (String) OaidJavaCalls.callMethod(OaidJavaCalls.newInstance("com.android.id.impl.IdProviderImpl", new Object[0]), "getOAID", this.mContext);
            try {
                LiteApiLogger.i(TAG, "getOAID oaid:" + str2);
                return str2;
            } catch (Exception e) {
                e = e;
                str = str2;
                LiteApiLogger.i(TAG, "getOAID fail");
                LiteApiLogger.printStackTraceOnly(e);
                return str;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }
}
