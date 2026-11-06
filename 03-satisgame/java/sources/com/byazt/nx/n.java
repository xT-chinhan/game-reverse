package com.byazt.nx;

import android.text.TextUtils;
import com.anythink.core.common.l.b;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2150, 19})
public class n {
    /* JADX WARN: Code duplicated, block: B:10:0x0023 A[PHI: r1
      0x0023: PHI (r1v1 java.lang.String) = (r1v0 java.lang.String), (r1v3 java.lang.String) binds: [B:6:0x0010, B:8:0x001e] A[DONT_GENERATE, DONT_INLINE]] */
    public static boolean n(Map<String, String> map) {
        String str;
        if (map == null) {
            return false;
        }
        String str2 = "content-type";
        if (TextUtils.isEmpty(map.get("content-type"))) {
            str2 = b.g;
            if (TextUtils.isEmpty(map.get(b.g))) {
                str = "";
            } else {
                str = map.get(str2);
            }
        } else {
            str = map.get(str2);
        }
        return str.contains("application/octet-stream");
    }
}
