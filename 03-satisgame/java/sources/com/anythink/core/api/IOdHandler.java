package com.anythink.core.api;

import android.content.Context;
import com.anythink.core.e.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface IOdHandler {
    boolean checkDebuggerDevice(Context context, String str);

    String fillCDataParam(String str);

    void fillRequestData(JSONObject jSONObject, b bVar, int i);

    void fillTestDeviceData(JSONObject jSONObject, b bVar);

    String getUniqueId(Context context);

    void initDeviceInfo(Context context);
}
