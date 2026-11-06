package com.bytedance.adsdk.xr;

import android.text.TextUtils;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ah implements c {
    @Override // com.bytedance.adsdk.xr.c
    public Object ms(JSONObject jSONObject, Object[] objArr) {
        if (objArr != null && objArr.length > 0) {
            for (Object obj : objArr) {
                String strValueOf = String.valueOf(obj);
                if (!TextUtils.isEmpty(strValueOf) && !TextUtils.equals(strValueOf, AbstractJsonLexerKt.NULL)) {
                    return strValueOf;
                }
            }
        }
        return null;
    }
}
