package com.byazt.jc;

import android.text.TextUtils;
import com.anythink.core.common.l.b;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1447, 26})
public class qg {
    public static String n(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        return map.get(TextUtils.isEmpty(map.get("content-type")) ? b.g : "content-type");
    }
}
