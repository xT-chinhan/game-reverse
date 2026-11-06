package com.byazt.ms;

import android.text.TextUtils;
import com.byazt.qk.oa;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 238, 5})
public class q {
    public static void n(int i, String str, Map<String, Object> map, ITTHttpCallback iTTHttpCallback) {
        com.byazt.qk.rv rvVarN = com.byazt.phf.s.n(str).n(i);
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                rvVarN.qg(entry.getKey(), entry.getValue().toString());
            }
        }
        n(rvVarN.n(), iTTHttpCallback);
    }

    public static void n(String str, byte[] bArr, String str2, int i, ITTHttpCallback iTTHttpCallback) {
        if (bArr == null) {
            if (iTTHttpCallback != null) {
                iTTHttpCallback.onError(new Exception("request data is null"));
            }
        } else {
            com.byazt.qk.rv rvVarN = com.byazt.phf.s.n(str).n(2);
            rvVarN.n(str2, bArr);
            n(rvVarN.n(), iTTHttpCallback);
        }
    }

    private static void n(oa oaVar, ITTHttpCallback iTTHttpCallback) {
        String strValueOf;
        if (oaVar != null && oaVar.x()) {
            if (iTTHttpCallback != null) {
                iTTHttpCallback.onResponse(oaVar.fs());
                return;
            }
            return;
        }
        boolean zIsEmpty = true ^ TextUtils.isEmpty(oaVar != null && oaVar.qg() != null ? oaVar.qg() : null);
        if (iTTHttpCallback != null) {
            if (zIsEmpty) {
                strValueOf = oaVar.qg();
            } else {
                strValueOf = oaVar != null ? String.valueOf(oaVar.n()) : "";
            }
            iTTHttpCallback.onError(new Exception(strValueOf));
        }
    }
}
