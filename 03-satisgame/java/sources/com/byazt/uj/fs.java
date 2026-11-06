package com.byazt.uj;

import android.text.TextUtils;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 738, 101})
public class fs implements hd {
    @Override // com.byazt.uj.hd
    public Object n(JSONObject jSONObject, Object[] objArr) {
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
