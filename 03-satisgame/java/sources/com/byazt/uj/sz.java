package com.byazt.uj;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 738, 110})
public class sz implements hd {
    @Override // com.byazt.uj.hd
    /* JADX INFO: renamed from: qg, reason: merged with bridge method [inline-methods] */
    public Boolean n(JSONObject jSONObject, Object[] objArr) {
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
