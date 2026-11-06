package com.byazt.lm;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 572, 50})
public class vk {
    public static void pr(int i, String str, Map<String, Object> map, c cVar) {
        com.byazt.hcx.aj ajVarPr = com.byazt.tf.hn.pr(str).pr(i);
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                ajVarPr.hw(entry.getKey(), entry.getValue().toString());
            }
        }
        pr(ajVarPr.pr(), cVar);
    }

    public static void pr(String str, byte[] bArr, String str2, int i, c cVar) {
        if (bArr == null) {
            if (cVar != null) {
                cVar.pr(new Exception("request data is null"));
            }
        } else {
            com.byazt.hcx.aj ajVarPr = com.byazt.tf.hn.pr(str).pr(2);
            ajVarPr.pr(str2, bArr);
            pr(ajVarPr.pr(), cVar);
        }
    }

    private static void pr(com.byazt.hcx.m mVar, c cVar) {
        String strValueOf;
        if (mVar != null && mVar.fw()) {
            if (cVar != null) {
                cVar.pr(mVar.zo());
                return;
            }
            return;
        }
        boolean zIsEmpty = true ^ TextUtils.isEmpty(mVar != null && mVar.hw() != null ? mVar.hw() : null);
        if (cVar != null) {
            if (zIsEmpty) {
                strValueOf = mVar.hw();
            } else {
                strValueOf = mVar != null ? String.valueOf(mVar.pr()) : "";
            }
            cVar.pr(new Exception(strValueOf));
        }
    }
}
