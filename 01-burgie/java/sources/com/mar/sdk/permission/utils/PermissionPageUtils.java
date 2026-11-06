package com.mar.sdk.permission.utils;

import android.app.Activity;
import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import com.byazt.ewn.AbsServerManager;
import com.bykv.vk.component.ttvideo.player.C;
import com.mar.sdk.log.Log;
import com.taptap.sdk.db.biz.iap.lib2plus.BillingClientConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PermissionPageUtils {
    public static void jumpPermissionPageDefault(Application application) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + application.getPackageName()));
        application.startActivity(intent.addFlags(C.ENCODING_PCM_MU_LAW));
    }

    public static void jumpWriteSettingPage(Application application) {
        Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
        intent.setData(Uri.parse("package:" + application.getPackageName()));
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        application.startActivity(intent);
    }

    public static void jumpPermissionPage(Activity context) throws Throwable {
        String name = Build.MANUFACTURER;
        Log.d("MARSDK", "jumpPermissionPage --- name : " + name);
        switch (name) {
            case "HUAWEI":
                goHuaWeiMainager(context);
                break;
            case "vivo":
                goVivoMainager(context);
                break;
            case "OPPO":
                goOppoMainager(context);
                break;
            case "Coolpad":
                goCoolpadMainager(context);
                break;
            case "Meizu":
                goMeizuMainager(context);
                break;
            case "Xiaomi":
                goXiaoMiMainager(context);
                break;
            case "samsung":
                goSangXinMainager(context);
                break;
            case "Sony":
                goSonyMainager(context);
                break;
            case "LG":
                goLGMainager(context);
                break;
            default:
                goIntentSetting(context);
                break;
        }
    }

    private static void goLGMainager(Activity mContext) {
        try {
            Intent intent = new Intent(mContext.getPackageName());
            ComponentName comp = new ComponentName("com.android.settings", "com.android.settings.Settings$AccessLockSummaryActivity");
            intent.setComponent(comp);
            mContext.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            goIntentSetting(mContext);
        }
    }

    private static void goSonyMainager(Activity mContext) {
        try {
            Intent intent = new Intent(mContext.getPackageName());
            ComponentName comp = new ComponentName("com.sonymobile.cta", "com.sonymobile.cta.SomcCTAMainActivity");
            intent.setComponent(comp);
            mContext.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            goIntentSetting(mContext);
        }
    }

    private static void goHuaWeiMainager(Activity mContext) {
        try {
            Intent intent = new Intent(mContext.getPackageName());
            intent.setFlags(C.ENCODING_PCM_MU_LAW);
            ComponentName comp = new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity");
            intent.setComponent(comp);
            mContext.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            goIntentSetting(mContext);
        }
    }

    private static String getMiuiVersion() throws Throwable {
        String line;
        BufferedReader input = null;
        try {
            Process p = Runtime.getRuntime().exec("getprop ro.miui.ui.version.name");
            BufferedReader input2 = new BufferedReader(new InputStreamReader(p.getInputStream()), 1024);
            try {
                line = input2.readLine();
                input2.close();
                try {
                    input2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e2) {
                ex = e2;
                input = input2;
                ex.printStackTrace();
                line = null;
                try {
                    input.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            } catch (Throwable th) {
                th = th;
                input = input2;
                try {
                    input.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                throw th;
            }
        } catch (IOException e5) {
            ex = e5;
        }
        return line;
    }

    private static void goXiaoMiMainager(Activity mContext) throws Throwable {
        String rom = getMiuiVersion();
        Log.d("MARSDK", "goMiaoMiMainager --- rom : " + rom);
        Intent intent = new Intent();
        if ("V6".equals(rom) || "V7".equals(rom)) {
            try {
                intent.setAction("miui.intent.action.APP_PERM_EDITOR");
                intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
                intent.putExtra("extra_pkgname", mContext.getPackageName());
                mContext.startActivity(intent);
                return;
            } catch (Exception e) {
                goIntentSetting(mContext);
                return;
            }
        }
        if ("V8".equals(rom) || "V9".equals(rom)) {
            try {
                intent.setAction("miui.intent.action.APP_PERM_EDITOR");
                intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
                intent.putExtra("extra_pkgname", mContext.getPackageName());
                mContext.startActivity(intent);
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                goIntentSetting(mContext);
                return;
            }
        }
        goIntentSetting(mContext);
    }

    private static void goMeizuMainager(Activity context) {
        try {
            Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.putExtra(BillingClientConstants.PACKAGE_NAME, context.getPackageName());
            context.startActivity(intent);
        } catch (ActivityNotFoundException localActivityNotFoundException) {
            localActivityNotFoundException.printStackTrace();
            goIntentSetting(context);
        }
    }

    private static void goSangXinMainager(Activity context) {
        goIntentSetting(context);
    }

    private static void goIntentSetting(Activity context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        Uri uri = Uri.fromParts(AbsServerManager.PACKAGE_QUERY_BINDER, context.getPackageName(), null);
        intent.setData(uri);
        try {
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void goOppoMainager(Activity context) {
        doStartApplicationWithPackageName(context, "com.coloros.safecenter");
    }

    private static void goCoolpadMainager(Activity context) {
        doStartApplicationWithPackageName(context, "com.yulong.android.security:remote");
    }

    private static void goVivoMainager(Activity context) {
        doStartApplicationWithPackageName(context, "com.bairenkeji.icaller");
    }

    private static Intent getAppDetailSettingIntent(Activity mContext) {
        Intent localIntent = new Intent();
        localIntent.addFlags(C.ENCODING_PCM_MU_LAW);
        if (Build.VERSION.SDK_INT >= 9) {
            localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            localIntent.setData(Uri.fromParts(AbsServerManager.PACKAGE_QUERY_BINDER, mContext.getPackageName(), null));
        } else if (Build.VERSION.SDK_INT <= 8) {
            localIntent.setAction("android.intent.action.VIEW");
            localIntent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
            localIntent.putExtra("com.android.settings.ApplicationPkgName", mContext.getPackageName());
        }
        return localIntent;
    }

    private static void doStartApplicationWithPackageName(Activity mContext, String packagename) {
        PackageInfo packageinfo = null;
        try {
            packageinfo = mContext.getPackageManager().getPackageInfo(packagename, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (packageinfo != null) {
            Intent resolveIntent = new Intent("android.intent.action.MAIN", (Uri) null);
            resolveIntent.addCategory("android.intent.category.LAUNCHER");
            resolveIntent.setPackage(packageinfo.packageName);
            List<ResolveInfo> resolveinfoList = mContext.getPackageManager().queryIntentActivities(resolveIntent, 0);
            Log.e("PermissionPageManager", "resolveinfoList" + resolveinfoList.size());
            for (int i = 0; i < resolveinfoList.size(); i++) {
                Log.e("PermissionPageManager", resolveinfoList.get(i).activityInfo.packageName + resolveinfoList.get(i).activityInfo.name);
            }
            ResolveInfo resolveinfo = resolveinfoList.iterator().next();
            if (resolveinfo != null) {
                String packageName = resolveinfo.activityInfo.packageName;
                String className = resolveinfo.activityInfo.name;
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.LAUNCHER");
                ComponentName cn = new ComponentName(packageName, className);
                intent.setComponent(cn);
                try {
                    mContext.startActivity(intent);
                } catch (Exception e2) {
                    goIntentSetting(mContext);
                    e2.printStackTrace();
                }
            }
        }
    }
}
