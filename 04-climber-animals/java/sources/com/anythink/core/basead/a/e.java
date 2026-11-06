package com.anythink.core.basead.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.anythink.core.common.d.s;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.by;
import com.anythink.core.common.h.cc;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.h.y;
import com.anythink.core.common.v.ab;
import com.anythink.core.common.v.m;
import com.anythink.core.common.v.p;
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

    public static cc a(String str) {
        cc ccVar = new cc();
        ccVar.l = 8;
        ccVar.n = false;
        ccVar.m = true;
        ccVar.o = str;
        try {
            if (Uri.parse(str).getScheme().equals("intent")) {
                Intent uri = Intent.parseUri(str, 1);
                uri.addCategory("android.intent.category.BROWSABLE");
                uri.setComponent(null);
                uri.setSelector(null);
                String stringExtra = uri.getStringExtra("browser_fallback_url");
                if (!TextUtils.isEmpty(stringExtra) && stringExtra.startsWith("http")) {
                    ccVar.l = 10;
                    ccVar.o = stringExtra;
                    return ccVar;
                }
            }
        } catch (Throwable unused) {
        }
        if (d(str)) {
            String strE = e(str);
            ccVar.l = 9;
            ccVar.o = strE;
        }
        return ccVar;
    }

    public static cc a(Context context, String str, w wVar) {
        cc ccVar = new cc();
        ccVar.n = !str.startsWith("http");
        ccVar.o = str;
        ccVar.p = false;
        if (!a(str, wVar != null ? wVar.r() : null)) {
            String strAw = wVar != null ? wVar.aw() : "";
            if (d(str)) {
                ccVar.o = str;
                t.b();
                if (a(context, new c.a().a(str).a(false).b(strAw).a()) || a(context, new c.a().a(str).a(false).b(strAw).a())) {
                    ccVar.m = true;
                    ccVar.l = 4;
                }
                return ccVar;
            }
            if (!str.startsWith("http")) {
                ccVar.o = str;
                if (a(context, new c.a().a(str).a(false).b(strAw).a())) {
                    ccVar.m = true;
                    ccVar.l = 5;
                }
                return ccVar;
            }
            if (c(str)) {
                String strF = f(str);
                ccVar.n = true;
                ccVar.o = strF;
                if (a(context, new c.a().a(strF).a(true).b(strAw).a())) {
                    ccVar.m = true;
                    ccVar.l = 1;
                } else if (a(context, new c.a().a(strF).a(false).b(strAw).a())) {
                    ccVar.m = true;
                    ccVar.l = 2;
                }
                return ccVar;
            }
        } else {
            ccVar.p = true;
        }
        return ccVar;
    }

    public static boolean a(Context context, String str, w wVar, x xVar) {
        return b(context, str, wVar, xVar).a() == 0;
    }

    public static d b(Context context, String str, w wVar, x xVar) {
        if (a(str, xVar != null ? xVar.o : null)) {
            com.anythink.core.common.u.e.a(wVar, xVar, 1, false, 0, "");
            if (wVar != null && TextUtils.isEmpty(wVar.H())) {
                com.anythink.core.common.u.e.b(wVar, xVar, 2);
            }
            return new d.a().a(4).a();
        }
        d dVarB = b(context, str, wVar != null ? wVar.aw() : "");
        if (dVarB.a() != 0 && wVar != null && TextUtils.isEmpty(wVar.H())) {
            com.anythink.core.common.u.e.b(wVar, xVar, 1);
        }
        return dVarB;
    }

    public static boolean a(String str, y yVar) {
        List<String> listBy;
        if (!TextUtils.isEmpty(str) && yVar != null && (listBy = yVar.by()) != null && !listBy.isEmpty()) {
            for (int i = 0; i < listBy.size(); i++) {
                String str2 = listBy.get(i);
                if (!TextUtils.isEmpty(str2) && str.startsWith(str2)) {
                    ab.a("OfferUrlHandler", "needFilterDeeplinkByScheme url:" + str + ",and scheme:" + str2);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean a(Context context, String str, String str2) {
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
        t.b();
        return b(context, new c.a().a(str).a(false).b(str2).a());
    }

    public static void b(String str) {
        com.anythink.core.common.v.y.a(str);
    }

    public static boolean c(String str) {
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
        t.b();
        return false;
    }

    private static String e(String str) {
        try {
            return "https://play.google.com/store/apps/details?id=".concat(String.valueOf(str.replace("market://details?id=", "")));
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
                    strA = p.a.a;
                    uri.setPackage(p.a.a);
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

    public static void a(Context context, String str) {
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

    public static boolean b(Context context, String str) {
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

    public static boolean a(w wVar, x xVar) {
        if (wVar == null || xVar == null) {
            return false;
        }
        by byVarR = t.b().R();
        boolean z = byVarR.b() == 1;
        boolean z2 = byVarR.a() == 1;
        String strN = m.n();
        if (TextUtils.isEmpty(strN)) {
            com.anythink.core.common.u.e.a(xVar, wVar, 5);
            return false;
        }
        if (!z) {
            com.anythink.core.common.u.e.a(xVar, wVar, 3);
            return false;
        }
        if (!z2) {
            com.anythink.core.common.u.e.a(xVar, wVar, 1);
            return false;
        }
        String strK = wVar.k();
        String strL = wVar.l();
        if (TextUtils.isEmpty(strK) || TextUtils.isEmpty(strL)) {
            com.anythink.core.common.u.e.a(xVar, wVar, 4);
            return false;
        }
        try {
            Object objD = m.d(strN);
            Class<?> cls = Class.forName("com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram$Req");
            Object objNewInstance = cls.newInstance();
            cls.getField("userName").set(objNewInstance, strK);
            cls.getField("path").set(objNewInstance, strL);
            cls.getField("miniprogramType").set(objNewInstance, cls.getField("MINIPTOGRAM_TYPE_RELEASE").get(null));
            Class.forName("com.tencent.mm.opensdk.openapi.IWXAPI").getMethod("sendReq", Class.forName("com.tencent.mm.opensdk.modelbase.BaseReq")).invoke(objD, objNewInstance);
            com.anythink.core.common.u.e.a(xVar, wVar, 0);
            return true;
        } catch (Throwable th) {
            th.getMessage();
            com.anythink.core.common.u.e.a(xVar, wVar, 2);
            return false;
        }
    }

    private static String a(Context context, Intent intent, String str) {
        String str2 = "";
        if (context != null && intent != null && com.anythink.core.d.d.a(t.b().g()).b(t.b().p()).aY()) {
            if (TextUtils.isEmpty(str)) {
                s sVarC = t.b().c();
                if (sVarC != null) {
                    str = sVarC.getDefaultMarketSchemePackageName();
                } else {
                    t.b();
                }
            }
            List<ResolveInfo> listA = com.anythink.core.common.v.y.a(context, intent);
            if (listA != null && listA.size() > 1) {
                str2 = listA.get(0).activityInfo.packageName;
                for (int i = 0; i < listA.size(); i++) {
                    String str3 = listA.get(i).activityInfo.packageName;
                    if (TextUtils.equals(str, listA.get(i).activityInfo.packageName)) {
                        return str;
                    }
                }
            }
        }
        return str2;
    }
}
