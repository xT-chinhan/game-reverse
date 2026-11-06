package com.byazt.uj;

import java.math.BigDecimal;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 738, 26})
public class qg implements hd {
    @Override // com.byazt.uj.hd
    /* JADX INFO: renamed from: qg, reason: merged with bridge method [inline-methods] */
    public String n(JSONObject jSONObject, Object[] objArr) {
        if (objArr == null) {
            return "";
        }
        try {
            if (objArr.length < 2) {
                return "";
            }
            Object obj = objArr[0];
            Object obj2 = objArr[1];
            return (((obj instanceof String) || (obj instanceof Number)) && (obj2 instanceof String)) ? com.byazt.rp.qg.n(new BigDecimal(String.valueOf(obj)), (String) obj2, Locale.getDefault(), 2, 2, 2) : "";
        } catch (Throwable unused) {
            return "";
        }
    }
}
