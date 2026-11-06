package com.anythink.core.common.t.c;

import android.text.TextUtils;
import com.anythink.core.common.d.s;
import com.anythink.core.common.h.u;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    /* JADX WARN: Code duplicated, block: B:15:0x0033  */
    public static boolean a(com.anythink.core.e.b bVar, u uVar) {
        Integer num;
        Map<String, Integer> map;
        if (s.b().A()) {
            return true;
        }
        Map<String, Map<String, Integer>> mapAm = bVar.am();
        if (mapAm == null || (map = mapAm.get(uVar.c)) == null) {
            num = null;
        } else {
            String str = uVar.S;
            if (TextUtils.isEmpty(str)) {
                num = 0;
            } else {
                num = map.get(str);
                if (num == null) {
                    num = null;
                }
            }
        }
        if (num != null) {
            if (num.intValue() <= 0) {
                return true;
            }
            uVar.af = num.intValue();
        }
        return false;
    }
}
