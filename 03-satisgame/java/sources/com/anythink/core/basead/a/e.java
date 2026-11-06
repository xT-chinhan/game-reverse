package com.anythink.core.basead.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.anythink.core.common.d.r;
import com.anythink.core.common.d.s;
import com.anythink.core.common.h.cb;
import com.anythink.core.common.h.cf;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.h.y;
import com.anythink.core.common.t.f;
import com.anythink.core.common.u.aa;
import com.anythink.core.common.u.l;
import com.byazt.ho.BaseConstants;
import com.bykv.vk.component.ttvideo.player.C;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static final String a = "play.google.com";
    public static final String b = "market.android.com";
    public static final String c = "details?";
    public static final String d = "market";
    public static final String e = "market://";
    private static final String f = "e";

    public static cf a(String str) {
        cf cfVar = new cf();
        cfVar.l = 8;
        cfVar.n = false;
        cfVar.m = true;
        cfVar.o = str;
        try {
            if (Uri.parse(str).getScheme().equals("intent")) {
                Intent uri = Intent.parseUri(str, 1);
                uri.addCategory("android.intent.category.BROWSABLE");
                uri.setComponent(null);
                uri.setSelector(null);
                String stringExtra = uri.getStringExtra("browser_fallback_url");
                if (!TextUtils.isEmpty(stringExtra) && stringExtra.startsWith("http")) {
                    cfVar.l = 10;
                    cfVar.o = stringExtra;
                    return cfVar;
                }
            }
        } catch (Throwable unused) {
        }
        if (d(str)) {
            String strE = e(str);
            cfVar.l = 9;
            cfVar.o = strE;
        }
        return cfVar;
    }

    public static cf a(Context context, String str, w wVar) {
        cf cfVar = new cf();
        cfVar.n = !str.startsWith("http");
        cfVar.o = str;
        cfVar.p = false;
        if (!a(str, wVar != null ? wVar.f() : null)) {
            String strL = wVar != null ? wVar.L() : "";
            if (d(str)) {
                cfVar.o = str;
                s.b();
                if (a(context, new c.a().a(str).a(false).b(strL).a()) || a(context, new c.a().a(str).a(false).b(strL).a())) {
                    cfVar.m = true;
                    cfVar.l = 4;
                }
                return cfVar;
            }
            if (!str.startsWith("http")) {
                cfVar.o = str;
                if (a(context, new c.a().a(str).a(false).b(strL).a())) {
                    cfVar.m = true;
                    cfVar.l = 5;
                }
                return cfVar;
            }
            if (c(str)) {
                String strF = f(str);
                cfVar.n = true;
                cfVar.o = strF;
                if (a(context, new c.a().a(strF).a(true).b(strL).a())) {
                    cfVar.m = true;
                    cfVar.l = 1;
                } else if (a(context, new c.a().a(strF).a(false).b(strL).a())) {
                    cfVar.m = true;
                    cfVar.l = 2;
                }
                return cfVar;
            }
        } else {
            cfVar.p = true;
        }
        return cfVar;
    }

    private static d b(Context context, String str, w wVar, x xVar) {
        if (a(str, xVar != null ? xVar.t : null)) {
            f.a(wVar, xVar, 1, false, 0, "");
            if (wVar != null && TextUtils.isEmpty(wVar.r())) {
                f.a(wVar, xVar, 2);
            }
            return new d.a().a(4).a();
        }
        d dVarB = b(context, str, wVar != null ? wVar.L() : "");
        if (dVarB.a() != 0 && wVar != null && TextUtils.isEmpty(wVar.r())) {
            f.a(wVar, xVar, 1);
        }
        return dVarB;
    }

    private static boolean a(String str, y yVar) {
        List<String> listV;
        if (!TextUtils.isEmpty(str) && yVar != null && (listV = yVar.V()) != null && !listV.isEmpty()) {
            for (int i = 0; i < listV.size(); i++) {
                String str2 = listV.get(i);
                if (!TextUtils.isEmpty(str2) && str.startsWith(str2)) {
                    aa.a("OfferUrlHandler", "needFilterDeeplinkByScheme url:" + str + ",and scheme:" + str2);
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean a(Context context, String str, String str2) {
        return b(context, str, str2).a() == 0;
    }

    private static d b(Context context, String str, String str2) {
        if (c(str)) {
            return b(context, new c.a().a(f(str)).a(true).b(str2).a());
        }
        String scheme = Uri.parse(str).getScheme();
        if (scheme == null || scheme.startsWith("http")) {
            return new d.a().a(2).a();
        }
        s.b();
        return b(context, new c.a().a(str).a(false).b(str2).a());
    }

    public static void b(String str) {
        com.anythink.core.common.u.x.a(str);
    }

    private static boolean c(String str) {
        Uri uri;
        try {
            if (!TextUtils.isEmpty(str) && (uri = Uri.parse(str)) != null && uri.getHost() != null) {
                return uri.getHost().equals(a) || uri.getHost().equals(b);
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static boolean d(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return Uri.parse(str).getScheme().equals("market");
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean a() {
        s.b();
        return false;
    }

    private static String e(String str) {
        try {
            return "https://play.google.com/store/apps/details?id=".concat(String.valueOf(str.replace(BaseConstants.MARKET_PREFIX, "")));
        } catch (Throwable unused) {
            return str;
        }
    }

    private static String f(String str) {
        try {
            return e.concat(String.valueOf(str.substring(str.indexOf(c))));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean a(Context context, c cVar) {
        return b(context, cVar).a() == 0;
    }

    private static d b(Context context, c cVar) {
        Intent uri;
        String strA = "";
        int i = 1;
        ResolveInfo resolveInfoResolveActivity = null;
        try {
            Uri uri2 = Uri.parse(cVar.a());
            if (uri2.getScheme().equals("intent")) {
                uri = Intent.parseUri(cVar.a(), 1);
                uri.addCategory("android.intent.category.BROWSABLE");
                uri.setComponent(null);
                uri.setSelector(null);
            } else if (uri2.getScheme().equals("android-app")) {
                uri = Intent.parseUri(cVar.a(), 2);
                uri.setComponent(null);
                uri.setSelector(null);
            } else {
                Intent intent = new Intent("android.intent.action.VIEW", uri2);
                intent.setData(uri2);
                uri = intent;
            }
            if (TextUtils.isEmpty(uri.getPackage())) {
                if (cVar.b()) {
                    strA = "com.android.vending";
                    uri.setPackage("com.android.vending");
                } else if (d(cVar.a())) {
                    strA = a(context, uri, cVar.c());
                    if (!TextUtils.isEmpty(strA)) {
                        uri.setPackage(strA);
                    }
                }
            }
            uri.addFlags(C.ENCODING_PCM_MU_LAW);
            resolveInfoResolveActivity = context.getPackageManager().resolveActivity(uri, 65536);
            context.startActivity(uri);
            i = 0;
        } catch (Throwable unused) {
            if (resolveInfoResolveActivity != null) {
                i = 3;
            }
        }
        return new d.a().a(i).a(strA).a();
    }

    private static void a(Context context, String str) {
        if (str == null || context == null) {
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
            ResolveInfo resolveInfoResolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
            if (resolveInfoResolveActivity != null) {
                intent.setClassName(resolveInfoResolveActivity.activityInfo.packageName, resolveInfoResolveActivity.activityInfo.name);
            }
            context.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
            try {
                Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent2.addFlags(C.ENCODING_PCM_MU_LAW);
                context.startActivity(intent2);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private static boolean b(Context context, String str) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage == null) {
                return false;
            }
            launchIntentForPackage.setFlags(C.ENCODING_PCM_MU_LAW);
            context.startActivity(launchIntentForPackage);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean a(w wVar, x xVar) {
        if (wVar == null || xVar == null) {
            return false;
        }
        cb cbVarR = s.b().R();
        boolean z = cbVarR.b() == 1;
        boolean z2 = cbVarR.a() == 1;
        String strN = l.n();
        if (TextUtils.isEmpty(strN)) {
            f.a(xVar, wVar, 5);
            return false;
        }
        if (!z) {
            f.a(xVar, wVar, 3);
            return false;
        }
        if (!z2) {
            f.a(xVar, wVar, 1);
            return false;
        }
        String strC = wVar.c();
        String strD = wVar.d();
        if (TextUtils.isEmpty(strC)) {
            f.a(xVar, wVar, 4);
            return false;
        }
        try {
            Object objC = l.c(strN);
            Class<?> cls = Class.forName("com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram$Req");
            Object objNewInstance = cls.newInstance();
            cls.getField("userName").set(objNewInstance, strC);
            if (!TextUtils.isEmpty(strD)) {
                cls.getField("path").set(objNewInstance, strD);
            }
            cls.getField("miniprogramType").set(objNewInstance, cls.getField("MINIPTOGRAM_TYPE_RELEASE").get(null));
            Class.forName("com.tencent.mm.opensdk.openapi.IWXAPI").getMethod("sendReq", Class.forName("com.tencent.mm.opensdk.modelbase.BaseReq")).invoke(objC, objNewInstance);
            f.a(xVar, wVar, 0);
            return true;
        } catch (Throwable th) {
            th.getMessage();
            f.a(xVar, wVar, 2);
            return false;
        }
    }

    private static String a(Context context, Intent intent, String str) {
        String str2 = "";
        if (context != null && intent != null && com.anythink.core.e.d.a(s.b().g()).b(s.b().p()).aY()) {
            if (TextUtils.isEmpty(str)) {
                r rVarC = s.b().c();
                if (rVarC != null) {
                    str = rVarC.getDefaultMarketSchemePackageName();
                } else {
                    s.b();
                }
            }
            List<ResolveInfo> listA = com.anythink.core.common.u.x.a(context, intent);
            if (listA != null && listA.size() > 1) {
                str2 = listA.get(0).activityInfo.packageName;
                for (int i = 0; i < listA.size(); i++) {
                    if (TextUtils.equals(str, listA.get(i).activityInfo.packageName)) {
                        return str;
                    }
                }
            }
        }
        return str2;
    }

    private static boolean a(Context context, String str, w wVar, x xVar) {
        d dVarB;
        if (a(str, xVar != null ? xVar.t : null)) {
            f.a(wVar, xVar, 1, false, 0, "");
            if (wVar != null && TextUtils.isEmpty(wVar.r())) {
                f.a(wVar, xVar, 2);
            }
            dVarB = new d.a().a(4).a();
        } else {
            dVarB = b(context, str, wVar != null ? wVar.L() : "");
            if (dVarB.a() != 0 && wVar != null && TextUtils.isEmpty(wVar.r())) {
                f.a(wVar, xVar, 1);
            }
        }
        return dVarB.a() == 0;
    }
}
