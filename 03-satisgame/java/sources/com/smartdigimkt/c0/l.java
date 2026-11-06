package com.smartdigimkt.c0;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.byazt.ho.BaseConstants;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public abstract class l {
    public static final String[] a = {"com.tencent.android.qqdownloader", "com.baidu.appsearch", "com.qihoo.appstore"};

    public static com.smartdigimkt.z.j a(Context context, String str, String str2) {
        String[] strArr;
        com.smartdigimkt.z.j jVarA;
        byte b;
        if (context == null || TextUtils.isEmpty(str)) {
            return a();
        }
        String str3 = Build.BRAND;
        String str4 = Build.MANUFACTURER;
        String strA = a(str3);
        if (strA.isEmpty()) {
            strA = a(str4);
        }
        strA.getClass();
        strA.hashCode();
        String str5 = "samsung";
        byte b2 = -1;
        switch (strA) {
            case "huawei":
                strArr = new String[]{"com.huawei.appmarket"};
                break;
            case "xiaomi":
                strArr = new String[]{"com.xiaomi.market"};
                break;
            case "oppo":
                strArr = new String[]{"com.heytap.market", "com.oppo.market"};
                break;
            case "vivo":
                strArr = new String[]{"com.bbk.appstore", "com.vivo.appstore"};
                break;
            case "honor":
                strArr = new String[]{"com.hihonor.appmarket"};
                break;
            case "meizu":
                strArr = new String[]{"com.meizu.mstore", "com.meizu.flyme.appcenter"};
                break;
            case "samsung":
                strArr = new String[]{"com.sec.android.app.samsungapps"};
                break;
            default:
                strArr = new String[0];
                break;
        }
        Uri uriBuild = Uri.parse(str);
        String lowerCase = uriBuild.getScheme() == null ? "" : uriBuild.getScheme().toLowerCase(Locale.ROOT);
        if (!"market".equals(lowerCase)) {
            lowerCase.getClass();
            lowerCase.hashCode();
            switch (lowerCase.hashCode()) {
                case -2068303459:
                    if (lowerCase.equals("appmarket")) {
                        b2 = 0;
                    }
                    break;
                case -1478446726:
                    if (lowerCase.equals(BaseConstants.MARKET_SCHEME_HW_HONOR)) {
                        b2 = 1;
                    }
                    break;
                case -1394934568:
                    if (lowerCase.equals("mimarket")) {
                        b2 = 2;
                    }
                    break;
                case -1064618860:
                    if (lowerCase.equals("mstore")) {
                        b2 = 3;
                    }
                    break;
                case -994641405:
                    if (lowerCase.equals("heytapmarket")) {
                        b2 = 4;
                    }
                    break;
                case -341015588:
                    if (lowerCase.equals("oppomarket")) {
                        b2 = 5;
                    }
                    break;
                case -82403352:
                    if (lowerCase.equals("vivomarket")) {
                        b2 = 6;
                    }
                    break;
                case 3403605:
                    if (lowerCase.equals("oaps")) {
                        b = 7;
                        b2 = b;
                    }
                    break;
                case 748813676:
                    if (lowerCase.equals(BaseConstants.MARKET_SCHEME_SAMSUNG)) {
                        b = 8;
                        b2 = b;
                    }
                    break;
                case 1994246438:
                    if (lowerCase.equals("honormarket")) {
                        b = 9;
                        b2 = b;
                    }
                    break;
            }
            switch (b2) {
                case 0:
                case 1:
                    str5 = "huawei";
                    break;
                case 2:
                    str5 = MediationConstant.ADN_XIAOMI;
                    break;
                case 3:
                    str5 = "meizu";
                    break;
                case 4:
                case 5:
                case 7:
                    str5 = "oppo";
                    break;
                case 6:
                    str5 = "vivo";
                    break;
                case 8:
                    break;
                case 9:
                    str5 = "honor";
                    break;
                default:
                    str5 = "";
                    break;
            }
            if (strA.equals(str5) && (jVarA = a(context, uriBuild, strArr)) != null) {
                return jVarA;
            }
            if (TextUtils.isEmpty(str2)) {
                return a(context, uriBuild, (String) null);
            }
            uriBuild = new Uri.Builder().scheme("market").authority(BaseConstants.MARKET_URI_AUTHORITY_DETAIL).appendQueryParameter("id", str2).build();
        }
        com.smartdigimkt.z.j jVarA2 = a(context, uriBuild, strArr);
        if (jVarA2 == null) {
            jVarA2 = a(context, uriBuild, a);
        }
        return jVarA2 != null ? jVarA2 : a(context, uriBuild, (String) null);
    }

    public static com.smartdigimkt.z.j a(Context context, Uri uri, String[] strArr) {
        for (String str : strArr) {
            com.smartdigimkt.z.j jVarA = a(context, uri, str);
            if (jVarA.a == 5) {
                return jVarA;
            }
        }
        return null;
    }

    public static com.smartdigimkt.z.j a(Context context, Uri uri, String str) {
        ActivityInfo activityInfo;
        try {
            Intent intentAddFlags = new Intent("android.intent.action.VIEW", uri).addFlags(268468224);
            if (!TextUtils.isEmpty(str)) {
                intentAddFlags.setPackage(str);
            }
            if (str == null) {
                List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intentAddFlags, 65536);
                Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
                while (it.hasNext()) {
                    ActivityInfo activityInfo2 = it.next().activityInfo;
                    if (activityInfo2 != null && "com.wandoujia.phoenix2".equals(activityInfo2.packageName)) {
                        for (ResolveInfo resolveInfo : listQueryIntentActivities) {
                            ActivityInfo activityInfo3 = resolveInfo.activityInfo;
                            if (activityInfo3 != null && !TextUtils.isEmpty(activityInfo3.packageName) && !"com.wandoujia.phoenix2".equals(resolveInfo.activityInfo.packageName)) {
                                com.smartdigimkt.z.j jVarA = a(context, uri, resolveInfo.activityInfo.packageName);
                                if (jVarA.a == 5) {
                                    return jVarA;
                                }
                            }
                        }
                        return a();
                    }
                }
            }
            ResolveInfo resolveInfoResolveActivity = context.getPackageManager().resolveActivity(intentAddFlags, 65536);
            if (resolveInfoResolveActivity != null && (activityInfo = resolveInfoResolveActivity.activityInfo) != null) {
                if ("com.wandoujia.phoenix2".equals(activityInfo.packageName)) {
                    return a();
                }
                ActivityInfo activityInfo4 = resolveInfoResolveActivity.activityInfo;
                String str2 = activityInfo4.packageName;
                String str3 = activityInfo4.name;
                if ("com.android.vending".equals(str2) && str3 != null && str3.startsWith("com.google.android.finsky.headless.")) {
                    String str4 = resolveInfoResolveActivity.activityInfo.name;
                    return a();
                }
                if (str != null && !str.equals(resolveInfoResolveActivity.activityInfo.packageName)) {
                    return a();
                }
                context.startActivity(intentAddFlags);
                com.smartdigimkt.z.i iVar = new com.smartdigimkt.z.i();
                iVar.a = 5;
                if (str == null) {
                    str = "";
                }
                iVar.b = str;
                return new com.smartdigimkt.z.j(iVar);
            }
            return a();
        } catch (RuntimeException unused) {
            return a();
        }
    }

    public static com.smartdigimkt.z.j a() {
        com.smartdigimkt.z.i iVar = new com.smartdigimkt.z.i();
        iVar.a = 1;
        return new com.smartdigimkt.z.j(iVar);
    }

    public static String a(String str) {
        String lowerCase = str == null ? "" : str.toLowerCase(Locale.ROOT);
        if (lowerCase.contains("honor")) {
            return "honor";
        }
        String str2 = MediationConstant.ADN_XIAOMI;
        if (!lowerCase.contains(MediationConstant.ADN_XIAOMI) && !lowerCase.contains("redmi") && !lowerCase.contains("poco")) {
            str2 = "oppo";
            if (!lowerCase.contains("oppo") && !lowerCase.contains("realme") && !lowerCase.contains("oneplus")) {
                String[] strArr = {"vivo", "huawei", "samsung", "meizu"};
                for (int i = 0; i < 4; i++) {
                    String str3 = strArr[i];
                    if (lowerCase.contains(str3)) {
                        return str3;
                    }
                }
                return "";
            }
        }
        return str2;
    }
}
