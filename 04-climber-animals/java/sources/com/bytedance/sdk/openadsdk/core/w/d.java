package com.bytedance.sdk.openadsdk.core.w;

import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d extends x {
    public d(Result result, int i) {
        super(result, i);
    }

    public boolean ms() {
        if (ah() != null) {
            return ah().isSuccess();
        }
        return false;
    }

    public c xr() {
        ValueSet valueSetValues;
        if (ah() == null || (valueSetValues = ah().values()) == null) {
            return null;
        }
        return new c((JSONObject) valueSetValues.objectValue(4, JSONObject.class));
    }
}
