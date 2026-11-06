package com.anythink.core.common.w.a.d;

import android.text.TextUtils;
import com.anythink.core.common.h.ai;
import com.anythink.core.common.h.ak;
import com.anythink.core.common.h.al;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static String a(String str, ak akVar) {
        List<String> list;
        if (akVar == null) {
            return "";
        }
        List<String> listA = akVar.a();
        Map<String, List<String>> mapC = akVar.c();
        if (listA != null && !listA.isEmpty()) {
            for (String str2 : listA) {
                if (!TextUtils.isEmpty(str2) && str.contains(str2)) {
                    if (mapC != null && !mapC.isEmpty() && (list = mapC.get(str2)) != null && !list.isEmpty()) {
                        for (int i = 0; i < list.size(); i++) {
                            String str3 = list.get(i);
                            if (str.contains(str3)) {
                                return str2 + "&&" + str3;
                            }
                        }
                    }
                    return str2;
                }
            }
        }
        return "";
    }

    private static ak a(al alVar, ai aiVar) {
        Map<Integer, ak> mapE;
        if (alVar == null || aiVar == null || (mapE = aiVar.e()) == null) {
            return null;
        }
        return mapE.get(Integer.valueOf(alVar.c()));
    }
}
