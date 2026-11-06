package com.smartdigimkt.odpd;

import android.content.Context;
import android.text.TextUtils;
import com.smartdigimkt.p4.a;
import com.smartdigimkt.r4.h;
import com.smartdigimkt.r4.y;
import com.smartdigimkt.sdk.api.IOdHandler;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.sdk.core.bridge.entity.DeviceInfoEntity;
import com.smartdigimkt.t.f;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class OdHandler implements IOdHandler {
    public static final String JSON_REQUEST_OAID = "oaid";

    @Override // com.smartdigimkt.sdk.api.IOdHandler
    public boolean checkDebuggerDevice(Context context, String str) {
        String strA = f.a();
        if (TextUtils.isEmpty(strA)) {
            strA = y.c(context, "sdm_adx_rp_sdk", "oaid");
        }
        return TextUtils.equals(str, strA);
    }

    @Override // com.smartdigimkt.sdk.api.IOdHandler
    public void fillRequestData(JSONObject jSONObject, a aVar, int i) {
        try {
            jSONObject.put("oaid", f.a());
        } catch (Exception unused) {
        }
    }

    @Override // com.smartdigimkt.sdk.api.IOdHandler
    public void fillTestDeviceData(JSONObject jSONObject, a aVar) {
        try {
            jSONObject.put("OAID", f.a(SDKContext.getInstance().d()));
        } catch (Exception unused) {
        }
    }

    @Override // com.smartdigimkt.sdk.api.IOdHandler
    public String getUniqueId(Context context) {
        String strA = f.a(context);
        return !TextUtils.isEmpty(strA) ? strA : "";
    }

    @Override // com.smartdigimkt.sdk.api.IOdHandler
    public void initDeviceInfo(Context context) {
        String str = f.a;
        DeviceInfoEntity deviceInfoEntity = h.W;
        if (deviceInfoEntity != null) {
            f.a(context, deviceInfoEntity.getOaid(), true);
            return;
        }
        String strC = y.c(context, "sdm_adx_rp_sdk", "oaid");
        f.a(context, strC, false);
        f.e.set(System.currentTimeMillis());
        if (!TextUtils.isEmpty(strC) || SDKContext.getInstance().a("oaid")) {
            return;
        }
        com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.t.a(context));
    }

    @Override // com.smartdigimkt.sdk.api.IOdHandler
    public String fillCDataParam(String str) {
        if (str == null) {
            return "";
        }
        String strA = f.a();
        return str.replaceAll("at_device3", strA != null ? strA : "");
    }
}
