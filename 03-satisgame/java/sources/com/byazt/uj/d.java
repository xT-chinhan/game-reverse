package com.byazt.uj;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 738, 113})
public class d implements hd {
    @Override // com.byazt.uj.hd
    /* JADX INFO: renamed from: qg, reason: merged with bridge method [inline-methods] */
    public Number n(JSONObject jSONObject, Object[] objArr) {
        if (objArr == null || objArr.length < 3) {
            return null;
        }
        Number numberN = n(objArr[0]);
        int iN = n(objArr[1], 0);
        boolean zN = n(objArr[2], false);
        if (numberN == null) {
            return null;
        }
        return n(numberN, iN, zN);
    }

    public Number n(Number number, int i, boolean z) {
        BigDecimal scale;
        if (number == null) {
            return null;
        }
        int iMax = Math.max(i, 0);
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(number.doubleValue());
        if (z) {
            scale = bigDecimalValueOf.setScale(iMax, RoundingMode.HALF_UP);
        } else {
            scale = bigDecimalValueOf.setScale(iMax, RoundingMode.DOWN);
        }
        if (iMax == 0 || scale.stripTrailingZeros().scale() <= 0) {
            return Long.valueOf(scale.longValue());
        }
        return Double.valueOf(scale.doubleValue());
    }

    private Number n(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (obj instanceof String) {
            try {
                return Double.valueOf(Double.parseDouble((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    private int n(Object obj, int i) {
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
        if (obj instanceof String) {
            try {
                return Integer.parseInt((String) obj);
            } catch (NumberFormatException unused) {
            }
        }
        return i;
    }

    private boolean n(Object obj, boolean z) {
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return obj instanceof String ? Boolean.parseBoolean((String) obj) : z;
    }
}
