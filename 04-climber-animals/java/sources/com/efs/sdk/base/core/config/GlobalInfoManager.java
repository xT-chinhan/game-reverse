package com.efs.sdk.base.core.config;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.anythink.basead.c.b;
import com.anythink.core.common.m.e;
import com.efs.sdk.base.BuildConfig;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.efs.sdk.base.core.util.PackageUtil;
import com.efs.sdk.base.core.util.ProcessUtil;
import com.efs.sdk.base.core.util.c;
import com.efs.sdk.base.core.util.secure.EncodeUtil;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.umeng.umcrash.UMCrash;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
public class GlobalInfoManager {
    private GlobalInfo a;
    private Context b;

    /* synthetic */ GlobalInfoManager(byte b) {
        this();
    }

    private GlobalInfoManager() {
        this.b = ControllerCenter.getGlobalEnvStruct().mAppContext;
    }

    static class a {
        private static final GlobalInfoManager a = new GlobalInfoManager(0);
    }

    public static GlobalInfoManager getInstance() {
        return a.a;
    }

    public void initGlobalInfo() {
        Log.e("ballack", "initGlobalInfo called once.");
        GlobalInfo globalInfo = new GlobalInfo();
        this.a = globalInfo;
        globalInfo.a("appid", ControllerCenter.getGlobalEnvStruct().getAppid());
        int iMyPid = ProcessUtil.myPid();
        this.a.a("pid", Integer.valueOf(iMyPid));
        this.a.a(e.bc, ProcessUtil.getProcessName(iMyPid));
        String strA = c.a(this.b);
        this.a.a("wid", strA);
        if (TextUtils.isEmpty(ControllerCenter.getGlobalEnvStruct().getUid())) {
            this.a.a("uid", strA);
        } else {
            this.a.a("uid", ControllerCenter.getGlobalEnvStruct().getUid());
        }
        GlobalInfo globalInfo2 = this.a;
        com.efs.sdk.base.core.a.a.a();
        globalInfo2.a("stime", Long.valueOf(com.efs.sdk.base.core.a.a.b() - Process.getElapsedCpuTime()));
        this.a.a(b.a.A, PackageUtil.getPackageName(this.b));
        this.a.a("ver", PackageUtil.getAppVersionName(this.b));
        this.a.a("vcode", PackageUtil.getAppVersionCode(this.b));
        this.a.a("sdk_ver", BuildConfig.VERSION_NAME);
        this.a.a("brand", Build.BRAND.toLowerCase());
        if (ControllerCenter.getGlobalEnvStruct().getCustomController() == null || ControllerCenter.getGlobalEnvStruct().getCustomController().isCanUseDeviceModel()) {
            this.a.a("model", Build.MODEL == null ? "unknown" : Build.MODEL.replace(" ", "-").replace("_", "-").toLowerCase());
            this.a.a("build_model", Build.MODEL);
        } else {
            this.a.a("model", "UNKNOWN");
            this.a.a("build_model", "UNKNOWN");
        }
        DisplayMetrics displayMetrics = this.b.getResources().getDisplayMetrics();
        if (ControllerCenter.getGlobalEnvStruct().getCustomController() == null || ControllerCenter.getGlobalEnvStruct().getCustomController().isCanUseScreenResolution()) {
            this.a.a("dsp_w", Integer.valueOf(displayMetrics.widthPixels));
            this.a.a("dsp_h", Integer.valueOf(displayMetrics.heightPixels));
        }
        this.a.a("fr", "android");
        if (ControllerCenter.getGlobalEnvStruct().getCustomController() == null || ControllerCenter.getGlobalEnvStruct().getCustomController().isCanUseSystemVersion()) {
            this.a.a("rom", Build.VERSION.RELEASE);
            this.a.a("sdk", Integer.valueOf(Build.VERSION.SDK_INT));
        } else {
            this.a.a("rom", "UNKNOWN");
            this.a.a("sdk", 0);
        }
        this.a.a(com.anythink.basead.webtemplet.a.b.c.j, Locale.getDefault().getLanguage());
        this.a.a("tzone", TimeZone.getDefault().getID());
        this.a.a(TKDownloadReason.KSAD_TK_NET, NetworkUtil.getNetworkType(this.b));
        try {
            String[] networkAccessMode = NetworkUtil.getNetworkAccessMode(this.b);
            if ("Wi-Fi".equals(networkAccessMode[0])) {
                this.a.a(UMCrash.KEY_HEADER_ACCESS, NetworkUtil.NETWORK_TYPE_WIFI);
            } else if ("2G/3G".equals(networkAccessMode[0])) {
                this.a.a(UMCrash.KEY_HEADER_ACCESS, "2G/3G");
            } else {
                this.a.a(UMCrash.KEY_HEADER_ACCESS, "unknow");
            }
            if (!"".equals(networkAccessMode[1])) {
                this.a.a(UMCrash.KEY_HEADER_ACCESS_SUBTYPE, networkAccessMode[1]);
            }
            this.a.a(UMCrash.KEY_HEADER_NETWORK_TYPE, Integer.valueOf(NetworkUtil.getNetworkTypeUmeng(this.b)));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            this.a.a("log_uid", EncodeUtil.base64DecodeToStr(ControllerCenter.getGlobalEnvStruct().getLogUid().getBytes()));
            this.a.a("log_did", ControllerCenter.getGlobalEnvStruct().getLogDid());
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public String getNetStatus() {
        return this.a.b(TKDownloadReason.KSAD_TK_NET, NetworkUtil.NETWORK_CLASS_DISCONNECTED).toString();
    }

    public void refreshNetStatus() {
        String networkType = NetworkUtil.getNetworkType(ControllerCenter.getGlobalEnvStruct().mAppContext);
        Log.w("efs.info.manager", "network change: ".concat(String.valueOf(networkType)));
        this.a.a(TKDownloadReason.KSAD_TK_NET, networkType);
    }

    private static String a(Context context) {
        Class<?> cls;
        Method method;
        if (context == null) {
            return null;
        }
        try {
            cls = Class.forName("com.umeng.commonsdk.statistics.common.DeviceConfig");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            method = cls.getMethod("getSid", Context.class);
        } catch (NoSuchMethodException unused2) {
            method = null;
        }
        if (method == null) {
            return null;
        }
        try {
            Object objInvoke = method.invoke(null, context);
            if (objInvoke != null) {
                return objInvoke.toString();
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException unused3) {
            return null;
        }
    }

    public GlobalInfo getGlobalInfo() {
        try {
            String strA = a(this.b);
            if (!TextUtils.isEmpty(strA)) {
                this.a.a(UMCrash.KEY_CALLBACK_SESSION_ID, strA);
            }
        } catch (Throwable th) {
            Log.d("efs.info.manager", "refreshSessionId caused error: " + th.getMessage());
        }
        return this.a;
    }
}
