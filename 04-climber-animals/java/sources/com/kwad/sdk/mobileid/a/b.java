package com.kwad.sdk.mobileid.a;

import com.anythink.core.common.d.j;
import com.anythink.core.common.m.e;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.h;
import com.kwad.sdk.utils.al;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends d {
    private static String aTm;

    private static String NH() {
        return "300012755841";
    }

    private static String NI() {
        return "CB607A51A7A639E532D288AB8C963DB6";
    }

    @Override // com.kwad.sdk.core.network.d, com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return h.Bb();
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final JSONObject getBody() {
        try {
            aTm = NF();
            String strNG = NG();
            String strAl = al(strNG, aTm);
            putBody("timestamp", strNG);
            putBody(e.X, strAl);
            putBody("traceId", aTm);
            putBody("appId", NH());
            putBody("interfaceVersion", j.e.b);
        } catch (Throwable th) {
            reportSdkCaughtException(th);
        }
        return this.mBodyParams;
    }

    private static String NF() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    private static String al(String str, String str2) {
        return al.md5(NH() + str + str2 + j.e.b + NI());
    }

    private static String NG() {
        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
    }
}
