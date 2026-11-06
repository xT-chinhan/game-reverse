package com.anythink.core.common.v.a.d;

import android.text.TextUtils;
import com.anythink.core.common.h.aj;
import com.anythink.core.common.h.al;
import com.anythink.core.common.h.am;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static String a(String str, al alVar) {
        List<String> list;
        if (alVar == null) {
            return "";
        }
        List<String> listA = alVar.a();
        Map<String, List<String>> mapC = alVar.c();
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

    private static al a(am amVar, aj ajVar) {
        Map<Integer, al> mapE;
        if (amVar == null || ajVar == null || (mapE = ajVar.e()) == null) {
            return null;
        }
        return mapE.get(Integer.valueOf(amVar.c()));
    }
}
