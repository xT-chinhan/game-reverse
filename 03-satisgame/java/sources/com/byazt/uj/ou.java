package com.byazt.uj;

import com.anythink.core.common.d.i;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 738, 849})
public class ou implements hd {
    @Override // com.byazt.uj.hd
    /* JADX INFO: renamed from: qg, reason: merged with bridge method [inline-methods] */
    public Number n(JSONObject jSONObject, Object[] objArr) {
        Object obj;
        if (objArr == null || objArr.length == 0 || (obj = objArr[0]) == null) {
            return null;
        }
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (obj instanceof Boolean) {
            return Integer.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        }
        if (!(obj instanceof String)) {
            return null;
        }
        try {
            String strTrim = ((String) obj).trim();
            if (!strTrim.equalsIgnoreCase("true") && !strTrim.equalsIgnoreCase("false")) {
                if (strTrim.contains(i.E)) {
                    return Double.valueOf(Double.parseDouble(strTrim));
                }
                return Long.valueOf(Long.parseLong(strTrim));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
