package com.bytedance.sdk.openadsdk.core.hi;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ab {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.bytedance.sdk.component.ny.xr.ah] */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.bytedance.sdk.component.ny.xr.d] */
    /* JADX WARN: Type inference failed for: r3v8, types: [com.bytedance.sdk.component.ny.xr.ka] */
    /* JADX WARN: Type inference failed for: r3v9 */
    public static void ms(int i, String str, Map<String, Object> map, ITTHttpCallback iTTHttpCallback) {
        ?? Ah;
        if (i == 0) {
            Ah = com.bytedance.sdk.openadsdk.core.re.ka.ms().xr().ah();
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    Ah.ms(entry.getKey(), entry.getValue().toString());
                }
            }
        } else if (i != 1) {
            Ah = 0;
        } else {
            Ah = com.bytedance.sdk.openadsdk.core.re.ka.ms().xr().xr();
            HashMap map2 = new HashMap();
            for (Map.Entry<String, Object> entry2 : map.entrySet()) {
                map2.put(entry2.getKey(), entry2.getValue().toString());
            }
            Ah.ms(map2);
        }
        if (Ah != 0) {
            Ah.ms(str);
            ms(Ah.ms(), iTTHttpCallback);
        }
    }

    public static void ms(String str, byte[] bArr, String str2, int i, ITTHttpCallback iTTHttpCallback) {
        if (bArr == null) {
            if (iTTHttpCallback != null) {
                iTTHttpCallback.onError(new Exception("request data is null"));
            }
        } else {
            com.bytedance.sdk.component.ny.xr.ka kaVarXr = com.bytedance.sdk.openadsdk.core.re.ka.ms().xr().xr();
            kaVarXr.ms(str);
            kaVarXr.ms(str2, bArr);
            ms(kaVarXr.ms(), iTTHttpCallback);
        }
    }

    private static void ms(com.bytedance.sdk.component.ny.xr xrVar, ITTHttpCallback iTTHttpCallback) {
        String strValueOf;
        if (xrVar != null && xrVar.x()) {
            if (iTTHttpCallback != null) {
                iTTHttpCallback.onResponse(xrVar.d());
                return;
            }
            return;
        }
        boolean zIsEmpty = true ^ TextUtils.isEmpty(xrVar != null && xrVar.xr() != null ? xrVar.xr() : null);
        if (iTTHttpCallback != null) {
            if (zIsEmpty) {
                strValueOf = xrVar.xr();
            } else {
                strValueOf = xrVar != null ? String.valueOf(xrVar.ms()) : "";
            }
            iTTHttpCallback.onError(new Exception(strValueOf));
        }
    }
}
