package com.bytedance.sdk.openadsdk.core.w;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class hi {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final HashMap<String, sl> f3681ms = new HashMap<>();

    public static void ms(lm lmVar) {
        ah ahVar = (ah) AutoService.ms(ah.class);
        if (ahVar != null && ahVar.d() && ahVar.ah() && ch.xr() && lmVar != null && lmVar.rt() != null) {
            String strEu = lmVar.eu();
            String strCz = lmVar.cz();
            String strD = lmVar.rt().d();
            if (TextUtils.isEmpty(strD)) {
                return;
            }
            sl slVar = new sl();
            slVar.ms(1);
            slVar.ms(strEu);
            slVar.xr(strCz);
            f3681ms.put(strD, slVar);
        }
    }
}
