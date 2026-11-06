package com.tapsdk.tapad.internal.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes3.dex */
public class WXUtil {
    public static boolean isWXInstalledThroughOpenSDK(Context context) {
        try {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.tencent.mm", 64);
                if (packageInfo == null) {
                    return false;
                }
                return validateAppSignature(packageInfo.signatures, true);
            } catch (Exception e) {
                e.getMessage();
                return false;
            }
        } catch (Throwable th) {
            th.getMessage();
            return false;
        }
        th.getMessage();
        return false;
    }

    public static boolean isWXOpenSDKIntegrated() {
        try {
            Class.forName("com.tencent.mm.opensdk.openapi.IWXAPI");
            Class.forName("com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram$Req");
            Class.forName("com.tencent.mm.opensdk.openapi.WXAPIFactory");
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean launchMiniProgram(Context context, String str, String str2, String str3, int i) {
        try {
            Class<?> cls = Class.forName("com.tencent.mm.opensdk.openapi.IWXAPI");
            Class<?> cls2 = Class.forName("com.tencent.mm.opensdk.modelbase.BaseReq");
            Class<?> cls3 = Class.forName("com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram$Req");
            Object objInvoke = Class.forName("com.tencent.mm.opensdk.openapi.WXAPIFactory").getDeclaredMethod("createWXAPI", Context.class, String.class).invoke(null, context, str);
            if (objInvoke == null || !isWXInstalledThroughOpenSDK(context)) {
                return false;
            }
            cls.getDeclaredMethod("sendReq", cls2);
            Object objNewInstance = cls3.newInstance();
            cls3.getDeclaredField("userName").set(objNewInstance, str2);
            cls3.getDeclaredField("path").set(objNewInstance, str3);
            Field declaredField = cls3.getDeclaredField("miniprogramType");
            if (i > 2 || i < 0) {
                i = 0;
            }
            declaredField.setInt(objNewInstance, i);
            cls.getDeclaredMethod("sendReq", cls2).invoke(objInvoke, objNewInstance);
            return true;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }

    public static boolean validateAppSignature(Signature[] signatureArr, boolean z) {
        if (!z) {
            return true;
        }
        for (Signature signature : signatureArr) {
            if (signature != null) {
                String lowerCase = signature.toCharsString().toLowerCase();
                "WXUtil check signature:".concat(lowerCase);
                if (lowerCase.equals("308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499")) {
                    return true;
                }
            }
        }
        return false;
    }
}
