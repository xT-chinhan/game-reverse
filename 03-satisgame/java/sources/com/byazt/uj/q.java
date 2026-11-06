package com.byazt.uj;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 738, 5})
public class q implements hd {
    @Override // com.byazt.uj.hd
    /* JADX INFO: renamed from: qg, reason: merged with bridge method [inline-methods] */
    public String n(JSONObject jSONObject, Object[] objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        try {
            String strValueOf = String.valueOf(objArr[0]);
            if (TextUtils.isEmpty(strValueOf)) {
                if (objArr.length >= 2) {
                    return String.valueOf(objArr[1]);
                }
                return null;
            }
            return new SimpleDateFormat(strValueOf, Locale.getDefault()).format(new Date());
        } catch (Throwable unused) {
            return null;
        }
    }
}
