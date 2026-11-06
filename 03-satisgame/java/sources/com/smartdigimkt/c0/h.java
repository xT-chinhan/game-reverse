package com.smartdigimkt.c0;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.C;
import com.smartdigimkt.b3.v;
import com.smartdigimkt.r4.w;
import com.smartdigimkt.sdk.api.SDMSDK;
import com.smartdigimkt.sdk.core.SDKContext;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h {
    public static final /* synthetic */ int a = 0;

    public static v a(Context context, String str, com.smartdigimkt.b3.c cVar) {
        com.smartdigimkt.b3.e eVar;
        com.smartdigimkt.b3.e eVar2;
        v vVar = new v();
        vVar.c = !str.startsWith("http");
        vVar.d = str;
        vVar.e = false;
        if (a(str, cVar != null ? cVar.w : null)) {
            vVar.e = true;
        } else {
            String str2 = cVar != null ? cVar.R : "";
            if (cVar != null && com.smartdigimkt.z.k.a(str)) {
                if (l.a(context, str, cVar.m).a == 5) {
                    vVar.b = true;
                    vVar.a = a(str) ? 4 : 5;
                }
                return vVar;
            }
            int i = 2;
            if (a(str)) {
                vVar.d = str;
                com.smartdigimkt.z.g gVar = new com.smartdigimkt.z.g();
                gVar.a = str;
                gVar.b = str2;
                if (cVar != null && (eVar2 = cVar.w) != null) {
                    i = eVar2.H1;
                }
                gVar.d = i;
                if (a(context, new com.smartdigimkt.z.h(gVar)).a == 0) {
                    vVar.b = true;
                    vVar.a = 4;
                }
                return vVar;
            }
            if (!str.startsWith("http")) {
                vVar.d = str;
                com.smartdigimkt.z.g gVar2 = new com.smartdigimkt.z.g();
                gVar2.a = str;
                gVar2.b = str2;
                if (cVar != null && (eVar = cVar.w) != null) {
                    i = eVar.H1;
                }
                gVar2.d = i;
                if (a(context, new com.smartdigimkt.z.h(gVar2)).a == 0) {
                    vVar.b = true;
                    vVar.a = 5;
                }
                return vVar;
            }
        }
        return vVar;
    }

    public static v b(String str) {
        v vVar = new v();
        vVar.a = 8;
        vVar.c = false;
        vVar.b = true;
        vVar.d = str;
        try {
            if (Uri.parse(str).getScheme().equals("intent")) {
                Intent uri = Intent.parseUri(str, 1);
                uri.addCategory("android.intent.category.BROWSABLE");
                uri.setComponent(null);
                uri.setSelector(null);
                String stringExtra = uri.getStringExtra("browser_fallback_url");
                if (!TextUtils.isEmpty(stringExtra) && stringExtra.startsWith("http")) {
                    vVar.a = 10;
                    vVar.d = stringExtra;
                }
            }
        } catch (Throwable unused) {
        }
        return vVar;
    }

    public static com.smartdigimkt.z.j a(Context context, com.smartdigimkt.a3.a aVar, com.smartdigimkt.b3.c cVar, String str) {
        com.smartdigimkt.b3.e eVar;
        int i;
        int i2 = 2;
        if (a(str, aVar != null ? aVar.s : null)) {
            com.smartdigimkt.n3.k.a(1, 0, aVar, cVar, "", false);
            if (cVar != null && TextUtils.isEmpty(cVar.l)) {
                com.smartdigimkt.n3.k.a(2, aVar, cVar);
            }
            com.smartdigimkt.z.i iVar = new com.smartdigimkt.z.i();
            iVar.a = 4;
            return new com.smartdigimkt.z.j(iVar);
        }
        if (cVar != null && com.smartdigimkt.z.k.a(str)) {
            com.smartdigimkt.z.j jVarA = l.a(context, str, cVar.m);
            if (jVarA.a != 5 && TextUtils.isEmpty(cVar.l)) {
                com.smartdigimkt.n3.k.a(1, aVar, cVar);
            }
            return jVarA;
        }
        String str2 = "";
        String str3 = cVar != null ? cVar.R : "";
        if (cVar != null && ((i = cVar.o) == 2 || i == 3)) {
            if (!TextUtils.isEmpty(cVar.m)) {
                str2 = cVar.m;
            } else {
                str2 = cVar.K;
            }
        }
        if (cVar != null && (eVar = cVar.w) != null) {
            i2 = eVar.H1;
        }
        com.smartdigimkt.z.j jVarA2 = a(context, str, str3, str2, i2);
        if (jVarA2.a != 0 && cVar != null && TextUtils.isEmpty(cVar.l)) {
            com.smartdigimkt.n3.k.a(1, aVar, cVar);
        }
        return jVarA2;
    }

    public static boolean a(String str, com.smartdigimkt.b3.e eVar) {
        List list;
        if (!TextUtils.isEmpty(str) && eVar != null && (list = eVar.p1) != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                String str2 = (String) list.get(i);
                if (!TextUtils.isEmpty(str2)) {
                    if (str.startsWith(str2)) {
                        String str3 = "needFilterDeeplinkByScheme url:" + str + ",and scheme:" + str2;
                        ThreadPoolExecutor threadPoolExecutor = w.a;
                        if (SDMSDK.getInstance().isNetworkLogDebug()) {
                            w.a(str3);
                        }
                        return true;
                    }
                    if (str.startsWith("intent://")) {
                        try {
                            String scheme = Intent.parseUri(str, 1).getScheme();
                            if (!TextUtils.isEmpty(scheme) && (scheme + "://").startsWith(str2)) {
                                String str4 = "needFilterDeeplinkByScheme [Intent Wrapped] url:" + str + ", matched detectScheme:" + str2;
                                ThreadPoolExecutor threadPoolExecutor2 = w.a;
                                if (SDMSDK.getInstance().isNetworkLogDebug()) {
                                    w.a(str4);
                                }
                                return true;
                            }
                        } catch (Throwable unused) {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return false;
    }

    public static com.smartdigimkt.z.j a(Context context, String str, String str2, String str3, int i) {
        String scheme = Uri.parse(str).getScheme();
        if (scheme != null && !scheme.startsWith("http")) {
            com.smartdigimkt.z.g gVar = new com.smartdigimkt.z.g();
            gVar.a = str;
            gVar.b = str2;
            gVar.c = str3;
            gVar.d = i;
            return a(context, new com.smartdigimkt.z.h(gVar));
        }
        com.smartdigimkt.z.i iVar = new com.smartdigimkt.z.i();
        iVar.a = 2;
        return new com.smartdigimkt.z.j(iVar);
    }

    public static boolean a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return Uri.parse(str).getScheme().equals("market");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static com.smartdigimkt.z.j a(Context context, com.smartdigimkt.z.h hVar) {
        Intent uri;
        Intent intentA;
        String strA = "";
        int i = 3;
        try {
            Uri uri2 = Uri.parse(hVar.a);
            String strA2 = hVar.c;
            if (uri2.getScheme().equals("intent")) {
                uri = Intent.parseUri(hVar.a, 1);
                uri.addCategory("android.intent.category.BROWSABLE");
                uri.setComponent(null);
                uri.setSelector(null);
            } else if (uri2.getScheme().equals("android-app")) {
                uri = Intent.parseUri(hVar.a, 2);
                uri.setComponent(null);
                uri.setSelector(null);
            } else {
                Intent intent = new Intent("android.intent.action.VIEW", uri2);
                intent.setData(uri2);
                uri = intent;
            }
            if (TextUtils.isEmpty(uri.getPackage()) && a(hVar.a)) {
                strA = a(context, uri, hVar.b);
                if (!TextUtils.isEmpty(strA)) {
                    uri.setPackage(strA);
                }
            }
            uri.addFlags(C.ENCODING_PCM_MU_LAW);
            ResolveInfo resolveInfoResolveActivity = context.getPackageManager().resolveActivity(uri, 65536);
            String strP = com.smartdigimkt.r4.h.p(context);
            if (!TextUtils.isEmpty(strP)) {
                uri.putExtra("android.intent.extra.REFERRER", Uri.parse("android-app://" + strP));
                uri.putExtra("android.intent.extra.REFERRER_NAME", "android-app://" + strP);
            }
            int i2 = hVar.d;
            if (i2 == 3) {
                return e.a(context, uri, resolveInfoResolveActivity, strA, hVar);
            }
            if (i2 == 1) {
                if (!d.a("oppo") && !d.a("oneplus") && !d.a("realme")) {
                    if (d.a("honor")) {
                        if (TextUtils.isEmpty(strA2)) {
                            strA2 = a(context, uri);
                        }
                        if (!TextUtils.isEmpty(strA2) && c.a(context, hVar.a, strA2)) {
                            com.smartdigimkt.z.i iVar = new com.smartdigimkt.z.i();
                            iVar.a = 0;
                            iVar.b = strA;
                            return new com.smartdigimkt.z.j(iVar);
                        }
                    } else {
                        String str = c.a;
                        try {
                            uri.setFlags(805339136);
                            intentA = Intent.createChooser(uri, "chooser");
                        } catch (Exception unused) {
                        }
                    }
                    uri.addFlags(C.ENCODING_PCM_MU_LAW);
                } else {
                    intentA = c.a(uri);
                }
                uri = intentA;
                uri.addFlags(C.ENCODING_PCM_MU_LAW);
            }
            if (resolveInfoResolveActivity == null) {
                i = 1;
            } else {
                context.startActivity(uri);
                i = 0;
            }
            com.smartdigimkt.z.i iVar2 = new com.smartdigimkt.z.i();
            iVar2.a = i;
            iVar2.b = strA;
            return new com.smartdigimkt.z.j(iVar2);
        } catch (Throwable unused2) {
            Objects.toString(null);
            if (0 == 0) {
            }
        }
    }

    public static boolean a(Context context, String str) {
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

    public static String a(Context context, Intent intent, String str) {
        com.smartdigimkt.w2.b bVarE;
        String str2 = "";
        if (context != null) {
            com.smartdigimkt.p4.a aVarA = com.smartdigimkt.o4.e.c().a();
            if (!aVarA.g && aVarA.a0 != 1) {
                if (TextUtils.isEmpty(str) && (bVarE = SDKContext.getInstance().e()) != null) {
                    str = bVarE.getDefaultMarketSchemePackageName();
                }
                List listA = com.smartdigimkt.s4.e.a(context, intent);
                if (listA != null && listA.size() > 1) {
                    str2 = ((ResolveInfo) listA.get(0)).activityInfo.packageName;
                    for (int i = 0; i < listA.size(); i++) {
                        String str3 = ((ResolveInfo) listA.get(i)).activityInfo.packageName;
                        if (TextUtils.equals(str, ((ResolveInfo) listA.get(i)).activityInfo.packageName)) {
                            return str;
                        }
                    }
                }
            }
        }
        return str2;
    }

    public static String a(Context context, Intent intent) {
        List listA;
        if (context != null && intent != null) {
            com.smartdigimkt.p4.a aVarA = com.smartdigimkt.o4.e.c().a();
            if (!aVarA.g && aVarA.a0 != 1 && (listA = com.smartdigimkt.s4.e.a(context, intent)) != null && listA.size() > 0) {
                for (int i = 0; i < listA.size(); i++) {
                    String str = ((ResolveInfo) listA.get(i)).activityInfo.packageName;
                    if (!TextUtils.isEmpty(((ResolveInfo) listA.get(i)).activityInfo.packageName)) {
                        return ((ResolveInfo) listA.get(i)).activityInfo.packageName;
                    }
                }
            }
        }
        return "";
    }
}
