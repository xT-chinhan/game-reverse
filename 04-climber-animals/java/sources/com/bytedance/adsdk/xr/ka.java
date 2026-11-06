package com.bytedance.adsdk.xr;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ka implements c {
    @Override // com.bytedance.adsdk.xr.c
    /* JADX INFO: renamed from: xr, reason: merged with bridge method [inline-methods] */
    public Boolean ms(JSONObject jSONObject, Object[] objArr) {
        if (objArr == null || objArr.length <= 0) {
            return Boolean.FALSE;
        }
        try {
            Double.parseDouble(String.valueOf(objArr[0]));
            return Boolean.TRUE;
        } catch (NumberFormatException unused) {
            return Boolean.FALSE;
        }
    }
}
