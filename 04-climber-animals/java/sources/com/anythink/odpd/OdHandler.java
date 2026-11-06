package com.anythink.odpd;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.IOdHandler;
import com.anythink.core.common.d.t;
import com.anythink.core.common.d.u;
import com.anythink.core.common.v.af;
import com.anythink.core.d.b;
import com.anythink.odopt.b.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class OdHandler implements IOdHandler {
    public static final String JSON_REQUEST_OAID = "oaid";

    @Override // com.anythink.core.api.IOdHandler
    public void initDeviceInfo(Context context) {
        a.a(context);
    }

    @Override // com.anythink.core.api.IOdHandler
    public String getUniqueId(Context context) {
        return a.b(context);
    }

    @Override // com.anythink.core.api.IOdHandler
    public boolean checkDebuggerDevice(Context context, String str) {
        String strA = a.a();
        if (TextUtils.isEmpty(strA)) {
            strA = af.c(context, u.b.a, "oaid", "");
        }
        return TextUtils.equals(str, strA);
    }

    @Override // com.anythink.core.api.IOdHandler
    public void fillRequestData(JSONObject jSONObject, b bVar, int i) {
        try {
            jSONObject.put("oaid", a.a());
        } catch (Exception unused) {
        }
    }

    @Override // com.anythink.core.api.IOdHandler
    public void fillTestDeviceData(JSONObject jSONObject, b bVar) {
        try {
            jSONObject.put("OAID", a.c(t.b().g()));
        } catch (Exception unused) {
        }
    }

    @Override // com.anythink.core.api.IOdHandler
    public String fillCDataParam(String str) {
        if (str == null) {
            return "";
        }
        String strA = a.a();
        return str.replaceAll("at_device3", strA != null ? strA : "");
    }
}
