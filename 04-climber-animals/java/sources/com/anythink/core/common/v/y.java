package com.anythink.core.common.v;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.anythink.core.basead.ui.web.WebLandPageActivity;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class y {
    public static void a(String str) {
        List<ResolveInfo> listA;
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268468224);
            Context contextG = com.anythink.core.common.d.t.b().g();
            if (contextG != null) {
                com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(com.anythink.core.common.d.t.b().g()).b(com.anythink.core.common.d.t.b().p());
                if (bVarB != null && bVarB.aY() && (listA = a(contextG, intent)) != null && listA.size() > 1) {
                    String str2 = listA.get(0).activityInfo != null ? listA.get(0).activityInfo.packageName : "";
                    if (!TextUtils.isEmpty(str2)) {
                        intent.setPackage(str2);
                    }
                }
                contextG.startActivity(intent);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Context context, String str) {
        try {
            WebLandPageActivity.a(context, str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static List<ResolveInfo> a(Context context, Intent intent) {
        ArrayList arrayList = new ArrayList();
        return (com.anythink.core.common.d.t.b().c(com.anythink.core.common.m.e.bu) || com.anythink.core.common.d.t.b().c(com.anythink.core.common.m.e.bv) || context == null || intent == null) ? arrayList : context.getPackageManager().queryIntentActivities(intent, 131072);
    }
}
