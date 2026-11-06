package com.byazt.mg;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.ae.g;
import com.byazt.ae.k;
import com.byazt.gs.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.IZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.taptap.sdk.db.biz.iap.lib2plus.BillingClientConstants;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 860, 61})
public class aj {
    public static volatile TTPluginListener k;
    public static volatile BaseDexClassLoader x;
    public final Context aj;
    public static final String pr = "next" + File.separator;
    public static final HashMap<String, TTPluginListener> hw = new HashMap<>();
    public static final HashMap<String, Handler> hn = new HashMap<>();
    public static volatile aj c = null;
    public final CountDownLatch uc = new CountDownLatch(1);
    public volatile boolean fw = false;
    public volatile String zo = "none";
    public JSONObject vk = new JSONObject();
    public EventListener w = null;

    private aj(Context context) {
        this.aj = context.getApplicationContext();
        try {
            GlobalParam.getInstance().closeHookHuaweiOnInit(true);
        } catch (Throwable th) {
            com.byazt.dea.uc.x("TTPluginManager", "Unexpected error for closeHookHuaweiOnInit.", th);
        }
        hw(context.getApplicationContext());
        Plugin plugin = Zeus.getPlugin("com.byted.pangle");
        if (plugin != null) {
            plugin.setApiBridge(com.byazt.bw.x.pr());
        }
    }

    public static aj pr(Context context) {
        if (c == null) {
            synchronized (aj.class) {
                if (c == null) {
                    c = new aj(context);
                }
            }
        }
        return c;
    }

    public JSONObject pr() {
        return this.vk;
    }

    public BaseDexClassLoader pr(fw fwVar, int i) throws Exception {
        String str;
        if (!this.fw) {
            com.byazt.dea.uc.x("TTPluginManager", "Zeus init failed.");
            throw new x(4, this.zo);
        }
        boolean zHw = com.byazt.ud.hn.hw();
        int i2 = 8;
        if (!Zeus.isPluginInstalled("com.byted.pangle")) {
            if (zHw) {
                new zo(this.aj).pr();
            }
            if (x(this.aj)) {
                Zeus.installFromDownloadDir();
            }
            try {
                if (!zHw) {
                    com.byazt.dea.uc.hw("TTPluginManager", "dont wait pl");
                } else {
                    com.byazt.dea.uc.hw("TTPluginManager", "wait start");
                    this.uc.await(i, TimeUnit.MILLISECONDS);
                }
                com.byazt.dea.uc.hw("TTPluginManager", "wait done");
                fwVar.hw("wait_install_cost");
            } catch (Exception e) {
                com.byazt.dea.uc.hw("TTPluginManager", "Install wait time out");
                throw new x(8, "install wait timeout");
            }
        }
        boolean z = false;
        if (Zeus.isPluginLoaded("com.byted.pangle") || Zeus.loadPlugin("com.byted.pangle")) {
            x = Zeus.getPlugin("com.byted.pangle").mClassLoader;
            z = true;
        }
        fwVar.hw("get_classloader_cost");
        Zeus.installFromDownloadDir();
        if (x == null) {
            if (this.uc.getCount() != 0) {
                if (zHw) {
                    i2 = 10;
                    str = "this device does not support arm64-v8a, and install wait time out";
                } else {
                    str = "install wait time out";
                }
                com.byazt.dea.uc.x("TTPluginManager", "Install wait time out");
                throw new x(i2, str);
            }
            if (z) {
                com.byazt.dea.uc.x("TTPluginManager", "Get null after load");
                throw new x(9, "Get null after load");
            }
        }
        fwVar.hw("get_classloader_done");
        return x;
    }

    private void hw(Context context) {
        try {
            m.pr().pr(new w());
            com.byazt.wo.c.pr(new com.byazt.ae.uc() { // from class: com.byazt.mg.aj.1
                @Override // com.byazt.ae.uc
                public void pr(Runnable runnable) {
                    com.byazt.as.pr.pr().x().execute(runnable);
                }

                @Override // com.byazt.ae.uc
                public void hw(Runnable runnable) {
                    com.byazt.as.pr.pr().x().execute(runnable);
                }

                @Override // com.byazt.ae.uc
                public void hn(Runnable runnable) {
                    new Handler(Looper.getMainLooper()).post(runnable);
                }
            });
            com.byazt.wp.pr prVar = new com.byazt.wp.pr() { // from class: com.byazt.mg.aj.2
                @Override // com.byazt.wp.pr
                public void pr(String str, JSONObject jSONObject) {
                    if ("load_finish".equals(str) && jSONObject != null && "com.byted.pangle".endsWith(jSONObject.optString("plugin_package_name"))) {
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("duration", jSONObject.opt("duration"));
                            jSONObject2.put("message", jSONObject.opt("message"));
                            aj.this.vk.put("zeus", jSONObject2);
                        } catch (Exception e) {
                            com.byazt.dea.uc.pr(e);
                        }
                    }
                    if (TTAdSdk.isInitSuccess()) {
                        uc.pr(str, jSONObject);
                    } else {
                        uc.hw(str, jSONObject);
                    }
                }

                @Override // com.byazt.wp.pr
                public void pr(String str, String str2) {
                    c.pr(str, str2);
                }
            };
            GlobalParam globalParam = GlobalParam.getInstance();
            globalParam.setReporter(prVar);
            globalParam.setCheckPermission(false);
            globalParam.setDownloadDir(hn(context));
            globalParam.setLogger(new hw());
            globalParam.setSignature("com.byted.pangle", "MIIDfTCCAmWgAwIBAgIEfRwYPjANBgkqhkiG9w0BAQsFADBvMQswCQYDVQQGEwJDTjEQMA4GA1UECBMHQmVpamluZzEQMA4GA1UEBxMHQmVpamluZzESMBAGA1UEChMJQnl0ZURhbmNlMQ8wDQYDVQQLEwZQYW5nbGUxFzAVBgNVBAMTDkNodWFuIFNoYW4gSmlhMB4XDTIxMTEwODA2MjQzOVoXDTQ2MTEwMjA2MjQzOVowbzELMAkGA1UEBhMCQ04xEDAOBgNVBAgTB0JlaWppbmcxEDAOBgNVBAcTB0JlaWppbmcxEjAQBgNVBAoTCUJ5dGVEYW5jZTEPMA0GA1UECxMGUGFuZ2xlMRcwFQYDVQQDEw5DaHVhbiBTaGFuIEppYTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAIBKeRL+4mfCn1SLYv6OemfwwItkjlLPyqOEugkV6lanFTcZgLwEl5LIkL0y28UncPtMX1Mii6DzCdJ/plw7S9+RT/hYDneu339IKWojaU2qai/5FokHlQ0MMnYl5yry00ghVPsl1u+03cQA2ZnjIMiFhrBJpQzHt7IYvq2aEEMBcY8uT7iFoBI848e1mL1joVS2z02C3NliP7ZNARkXH+rTQAlCJulT5IZk+V/PTaKqzgNrkhsKh0/tBmU7m8u79x/xpgGsE19H18AgS4P/9/MDCRe2Z35boZeccaUy2MXCwv3djzUcDk3rRzQPYzdpyyRnrFMuhiKesc5VHgUMs9kCAwEAAaMhMB8wHQYDVR0OBBYEFENENrNWGzc2WhxdvhoMDs57U70zMA0GCSqGSIb3DQEBCwUAA4IBAQAHqDCrmvyBBmIGXwuL1rwS/Qv9ZJIZykBIaNMm+H1IfitCl4yXd9N2n+PjE0UZtxZ21UZOt9wAr+RFiSl5YRXqpt7WLARTy4YW3RiQ+wiL7bshzeSYBoSiC427Bfeq0WjwY0/jHlr8uouppyJOz++6U9hrYX2EW/6UjH5XlWiKQJ6b2ZzPcP8Xpg/TJn4tWvXJP6jw9kRRP2GmMttY78leWQst2QEZILmWJubXRLPj9O+qx2uP9oGTD4sc1vb9hzkOHBIHzGaalqLFbbGaeFpLFHoGTsnOfPTwUVKDZYmxbkcmR1bp7eYOW+nSQNMLn0FjDewZl5l37Sa/gz0WVHon");
            globalParam.setSignature("com.byted.csj.ext", "MIIDezCCAmOgAwIBAgIENkE1KDANBgkqhkiG9w0BAQsFADBtMQswCQYDVQQGEwI4NjEQMA4GA1UECBMHYmVpamluZzEQMA4GA1UEBxMHYmVpamluZzESMBAGA1UEChMJYnl0ZWRhbmNlMRIwEAYDVQQLEwlieXRlZGFuY2UxEjAQBgNVBAMTCWJ5dGVkYW5jZTAgFw0yMjExMDIwODI3MzlaGA8yMDUwMDMyMDA4MjczOVowbTELMAkGA1UEBhMCODYxEDAOBgNVBAgTB2JlaWppbmcxEDAOBgNVBAcTB2JlaWppbmcxEjAQBgNVBAoTCWJ5dGVkYW5jZTESMBAGA1UECxMJYnl0ZWRhbmNlMRIwEAYDVQQDEwlieXRlZGFuY2UwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCc9Z2F3xxOMX1qTXMy2aPmS9OSkqrp8C8bHwS1hkNVR4umKREuqOn73INNo+R706jaCVnlPwxDwWjtX6H74DE4CveivyM9f2wNC3yIyDW+5j7lW/keTQcOlGLDEJQv4O/6FbB/jNU6epjyNaNIZhgZcvTpgaSixbdyHzRTFmvMh+WovdVK/J9LnHOQ+pmPZj7NB6MQRGMUrPEotLHQca3cmnLrnPAaZQaVoaFE9lOt9syyqEuf361SprNIGDtbkJuX3EqV/QOKWFwZX94IS7ZGSvfyCojcD4kaUSbaSoZC7zEuBb7l69g+ZMrJ/v6wkm01wxsNNssUwF7k6Sp0zubbAgMBAAGjITAfMB0GA1UdDgQWBBSxk+gVdDco1dP65hP67qoKNlMEYDANBgkqhkiG9w0BAQsFAAOCAQEAfosExl/AYEbS2xqHBTHa28cvnp/SElUQuzW6aWLqkfk9cxmFSI/euUV3/eB8RN+U2X47Y05u6+XUxTv0tSSEtyXNawm0qWH8jkR4gZY38YqBChKjhea668oT5X3Uocrw7SYXO/BfI8SKPa0uI/U8Cyl3uctbmmq/pPUkd3mKAy+HgyJoThD6K0oyiADlygngUMVTv6Uvid4qPj/bBnxI+LvVeX4l1dxGqWkiafQW9sz+RbFdge3X2XsSH4eo01BsCwOYEv1lHO2FrbAtFNpnIsSqrERdFaAJZ3tlJmg9bA03png8A2AajEjkhaOhduJB8zkSlvHNpoQMIAS9WtkG/w==");
            globalParam.setSignature("com.byted.live.lite", "MIIDSTCCAjGgAwIBAgIEaLy5tzANBgkqhkiG9w0BAQsFADBVMQswCQYDVQQGEwIxMTEMMAoGA1UECBMDMTExMQ4wDAYDVQQHEwUxMTExMTEMMAoGA1UEChMDMTExMQwwCgYDVQQLEwMxMTExDDAKBgNVBAMTAzExMTAeFw0yMDEyMDMxMjQyMTJaFw00NTExMjcxMjQyMTJaMFUxCzAJBgNVBAYTAjExMQwwCgYDVQQIEwMxMTExDjAMBgNVBAcTBTExMTExMQwwCgYDVQQKEwMxMTExDDAKBgNVBAsTAzExMTEMMAoGA1UEAxMDMTExMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA45E52YdkJm4gPCXZq7KDoM1h6pgSswllC/CwDOmh8pDGvX4ROaYP1vr2biRlXMHg7G0iXpxWVdlTtx+4QFd3dC+cGJQk0f6apGo2n2RpMA0zIsSf0VO1a3GjWLei5INo+4RDdciqJ4jfsoqBIjZETRkky+UU4eO/oyrAwOu4KdMln3Bg3u7eHWU4kMFrXxrRruT3Q/9gzlO90yQa0CZPWVDrk6cGJtJwJGhWm+62S3U8D26HE++eGP7ve83QBDGtKqx7HpCAFWUiYBgXGq12H0amQDkKcPcr/EFCaBlombSgkN0t6zBX80m+wcUPC75IBTmMV/DT2dXcgjZ2I1JSCQIDAQABoyEwHzAdBgNVHQ4EFgQUPDyIeKI0KhZFPHyn36gMMIYrpukwDQYJKoZIhvcNAQELBQADggEBAHkl0DoCRwn+XKsDJE+wGMpBBqUDzL6DSOnJx4SNqb7YZZU0ThcDK7jY4If3QRkvMio6ODrVZc2U/m/Tc3VeMk5h2W2UZRUWHNH3k9Xe0720uL20ZeH2Y6IG4L5HG8kIbTbFtX3gJpPG/xAcez+CzyCFLWQAZt1N+csG0syWkXJ0Nryq8VrgSCyCXD1KzFxrOe+65wtu50Vi68Vlbk7BZe/G8Qm0RhKmxq5BPMBJ4uY3be+03Ba5qC//o1XQHOEAjrJKXcN5wqHdFZTkmuxVyIPogZOzx4JlNl0zOrYGDJxp7aZfKF9FkXQyF7x0Ns3mZEtjx/+flXRzAAU9MDhPr/0=");
            Zeus.setDecodeCallback(new k() { // from class: com.byazt.mg.aj.3
                @Override // com.byazt.ae.k
                public String pr(String str) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        String strOptString = jSONObject.optString("cypher");
                        String strOptString2 = jSONObject.optString("message");
                        if (TextUtils.equals(strOptString, GlobalSetting.SPLASH_AD) && !TextUtils.isEmpty(strOptString2)) {
                            return com.byazt.ud.hw.hw(strOptString2);
                        }
                        return null;
                    } catch (Throwable th) {
                        com.byazt.dea.uc.hw("TTPluginManager", "dex plugin decode throw error ".concat(String.valueOf(th)));
                        return null;
                    }
                }
            });
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isDexPlugin", 1);
                jSONObject.put("apiVersionCode", 1000);
                jSONObject.put(BillingClientConstants.PACKAGE_NAME, "com.byted.mixed");
                jSONObject.put("hostPackageName", "com.byted.pangle");
                jSONObject.put("minPluginVersion", 1000);
                jSONObject.put("maxPluginVersion", 999999999);
                jSONObject.put("internalPath", "");
                jSONObject.put("internalVersionCode", -1);
                jSONObject.put("appKey", "");
                jSONObject.put("appSecretKey", "");
                Zeus.addPackageDexManager("com.byted.mixed", jSONObject);
            } catch (Throwable th) {
                com.byazt.dea.uc.hw("TTPluginManager", "init dex plugin config throw error " + th);
            }
            globalParam.closeBgDex2oat(true);
            Zeus.init((Application) context);
            Zeus.registerPluginInstallListener(new g() { // from class: com.byazt.mg.aj.4
                @Override // com.byazt.ae.g
                public void pr(String str, int i, String str2) {
                    if (i == 7) {
                        aj.this.hw(str, i);
                        return;
                    }
                    if (i == 6) {
                        aj.this.hw(str, i);
                        if (aj.this.w != null && "com.byted.pangle".equals(str)) {
                            aj.this.w.onEvent(0, com.byazt.ij.hw.pr().pr(true).hw());
                        } else {
                            com.byazt.dea.uc.hw("TTPluginManager", "no main pl");
                        }
                    }
                }
            });
            this.fw = true;
        } catch (Throwable th2) {
            com.byazt.dea.uc.x("TTPluginManager", "Unexpected error for init zeus.", th2);
            this.zo = th2.getMessage();
        }
        PluginManager pluginManager = PluginManager.getInstance();
        pluginManager.registerPlugin("{apiVersionCode:7714,packageName:com.byted.pangle,minPluginVersion:7714,internalPath:'',internalVersionCode:7714}");
        pluginManager.registerPlugin("{apiVersionCode:1000,packageName:com.byted.csj.ext,minPluginVersion:1000,maxPluginVersion:999999999,internalPath:'',internalVersionCode:-1,appKey:'',appSecretKey:''}");
        pluginManager.registerPlugin("{apiVersionCode:2114,packageName:com.byted.live.lite,minPluginVersion:211400,maxPluginVersion:999999,isSupportLibIsolate:true}");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(String str, int i) {
        if ("com.byted.pangle".equals(str) && i == 6) {
            com.byazt.dea.uc.x("TTPluginManager", "notify to end wait");
            this.uc.countDown();
        }
        pr(i == 6, str);
    }

    private static File hn(Context context) {
        return new File(com.byazt.mg.hw.pr(context, "tt_pangle_bykv_file", 0), pr);
    }

    private static boolean x(Context context) {
        File fileHn = hn(context);
        return fileHn.exists() && fileHn.listFiles().length != 0;
    }

    public Bundle pr(String str, Bundle bundle) {
        String strPr = pr(str);
        if (!TextUtils.isEmpty(strPr)) {
            bundle.putString(PluginConstants.KEY_PLUGIN_VERSION, strPr);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putBundle(str, bundle);
        Bundle bundle3 = new Bundle();
        bundle3.putBundle(PluginConstants.KEY_PL_CONFIG_INFO, bundle2);
        return bundle3;
    }

    public static String pr(String str) {
        Plugin plugin;
        try {
            if (Zeus.isPluginInstalled(str, false) && (plugin = Zeus.getPlugin(str, false)) != null) {
                return pr(plugin.getVersion());
            }
            return null;
        } catch (Throwable th) {
            com.byazt.dea.uc.x("TTPluginManager", "Get local version failed");
            Context context = TTAppContextHolder.getContext();
            if (context != null) {
                String packageName = context.getPackageName();
                if ("com.union_test.toutiao".equals(packageName) || "com.pangolin_demo.toutiao".equals(packageName) || "com.bytedance.mediation_demo_csj".equals(packageName)) {
                    throw th;
                }
                return null;
            }
            return null;
        }
    }

    public static String hw(String str) {
        int installedMaxVer;
        try {
            Plugin plugin = Zeus.getPlugin(str, false);
            if (plugin != null && (installedMaxVer = plugin.getInstalledMaxVer()) > 0) {
                return pr(installedMaxVer);
            }
            return null;
        } catch (Throwable th) {
            com.byazt.dea.uc.x("TTPluginManager", "Get local version failed");
            return null;
        }
    }

    public void pr(final TTPluginListener tTPluginListener) {
        Plugin plugin;
        if (!this.fw) {
            com.byazt.dea.uc.x("TTPluginManager", "Zeus init failed.");
            if (tTPluginListener != null) {
                tTPluginListener.onPluginListener(1002, null, null, null);
                return;
            }
            return;
        }
        Handler handlerHw = com.byazt.as.pr.pr().hw();
        Runnable runnable = new Runnable() { // from class: com.byazt.mg.aj.5
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.dea.uc.hw("TTPluginManager", "Load plugin failed, caused by timeout.");
                tTPluginListener.onPluginListener(1001, null, null, null);
            }
        };
        handlerHw.postDelayed(runnable, 180000L);
        String strPackageName = tTPluginListener.packageName();
        if (Zeus.isPluginInstalled(strPackageName) && (Zeus.isPluginLoaded(strPackageName) || Zeus.loadPlugin(strPackageName))) {
            plugin = Zeus.getPlugin(strPackageName);
        } else {
            plugin = null;
        }
        com.byazt.dea.uc.hw("TTPluginManager", "Find plugin:" + (plugin != null));
        if (plugin != null) {
            pr(plugin);
            handlerHw.removeCallbacks(runnable);
            tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
        } else {
            hw.put(strPackageName, tTPluginListener);
            hn.put(strPackageName, handlerHw);
        }
    }

    public void hw(TTPluginListener tTPluginListener) {
        Plugin plugin;
        String strPackageName = tTPluginListener.packageName();
        if (Zeus.isPluginInstalled(strPackageName) && (Zeus.isPluginLoaded(strPackageName) || Zeus.loadPlugin(strPackageName))) {
            plugin = Zeus.getPlugin(strPackageName);
        } else {
            plugin = null;
        }
        com.byazt.dea.uc.hw("TTPluginManager", "Find plugin:" + (plugin != null));
        if (plugin != null) {
            pr(plugin);
            tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
        } else {
            k = tTPluginListener;
        }
    }

    public void pr(EventListener eventListener) {
        this.w = eventListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static pr x(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return pr(new JSONObject(str));
        } catch (JSONException e) {
            com.byazt.dea.uc.c("TTPluginManager", "Invalid plugin info:" + str);
            return null;
        }
    }

    private static pr pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        pr prVar = new pr();
        prVar.hn = jSONObject.optString("package_name");
        prVar.x = jSONObject.optInt("version_code");
        prVar.c = jSONObject.optString("download_url");
        prVar.fw = jSONObject.optString("md5");
        prVar.aj = jSONObject.optInt("min_version");
        prVar.vk = jSONObject.optInt("max_version");
        prVar.pr = jSONObject.optString("sign");
        prVar.uc = jSONObject.optBoolean("is_revert") ? 3 : 2;
        prVar.hw = new File(jSONObject.optString("plugin_file"));
        return prVar;
    }

    private static void pr(Plugin plugin) {
        if (plugin == null) {
            com.byazt.dea.uc.x("TTPluginManager", "plugin is null.");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("action", 0);
        bundle.putString("plugin_pkg_name", plugin.mPkgName);
        bundle.putString(PluginConstants.KEY_PLUGIN_VERSION, pr(plugin.getVersion()));
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager != null) {
            adManager.getExtra(Bundle.class, bundle);
        }
    }

    public static String pr(int i) {
        char[] charArray = String.valueOf(i).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            sb.append(charArray[i2]);
            if (i2 < charArray.length - 1) {
                sb.append(".");
            }
        }
        return sb.toString();
    }

    private static boolean pr(TTPluginListener tTPluginListener, String str) {
        if (tTPluginListener == null || tTPluginListener.packageName() == null) {
            return false;
        }
        return tTPluginListener.packageName().equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hw(pr prVar) {
        if (prVar == null || prVar.hw == null) {
            com.byazt.dea.uc.x("TTPluginManager", "plugin config is null");
            return false;
        }
        boolean zSyncInstallPlugin = Zeus.syncInstallPlugin(prVar.hn, prVar.hw.getAbsolutePath());
        pr(zSyncInstallPlugin, prVar.hn);
        return zSyncInstallPlugin;
    }

    private static void pr(boolean z, String str) {
        HashMap<String, TTPluginListener> map = hw;
        TTPluginListener tTPluginListener = map.get(str);
        com.byazt.dea.uc.hw("TTPluginManager", "Install dl plugin " + str + (z ? " success" : " failed") + ", need notify: " + (tTPluginListener != null));
        HashMap<String, Handler> map2 = hn;
        Handler handler = map2.get(str);
        if (z) {
            TTPluginListener tTPluginListener2 = k;
            if (!pr(tTPluginListener2, str) && (tTPluginListener == null || handler == null)) {
                return;
            }
            if (Zeus.loadPlugin(str)) {
                Plugin plugin = Zeus.getPlugin(str);
                pr(plugin);
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
                if (tTPluginListener != null) {
                    tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
                }
                if (pr(tTPluginListener2, str)) {
                    tTPluginListener2.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
                    k = null;
                }
            } else {
                com.byazt.dea.uc.hw("TTPluginManager", "handle installed, load failed");
                hn(str, 1002);
            }
        } else {
            com.byazt.dea.uc.hw("TTPluginManager", "handle installed failed");
            hn(str, 1003);
        }
        map.remove(str);
        map2.remove(str);
    }

    public static void pr(Throwable th) {
        if (th instanceof AbstractMethodError) {
            Zeus.unInstallPlugin("com.byted.pangle");
            com.byazt.dea.uc.x("TTPluginManager", "AbstractMethodError, rollback to builtin version.");
            uc.pr("uninstall_plugin", null, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hn(String str, int i) {
        com.byazt.dea.uc.x("TTPluginManager", "plugin update failed");
        Bundle bundle = new Bundle();
        bundle.putInt(PluginConstants.KEY_ERROR_CODE, i);
        TTPluginListener tTPluginListener = hw.get(str);
        if (tTPluginListener != null) {
            tTPluginListener.onPluginListener(1001, null, null, bundle);
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 860, 470})
    private static final class hw implements IZeusLogger {
        private hw() {
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void v(String str, String str2) {
            com.byazt.dea.uc.pr(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void i(String str, String str2) {
            com.byazt.dea.uc.hn(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void w(String str, String str2) {
            com.byazt.dea.uc.x(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void w(String str, String str2, Throwable th) {
            com.byazt.dea.uc.x(str, str2, th);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void e(String str, String str2, Throwable th) {
            com.byazt.dea.uc.c(str, str2, th);
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 860, 474})
    static final class hn implements Serializable, Function<SparseArray<Object>, Object> {
        @Override // java.util.function.Function
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public Object apply(SparseArray<Object> sparseArray) {
            if (sparseArray != null) {
                ValueSet valueSetHw = com.byazt.ij.hn.pr(sparseArray).hw();
                int iIntValue = valueSetHw.intValue(-99999987);
                SparseArray sparseArray2 = (SparseArray) valueSetHw.objectValue(-99999979, SparseArray.class);
                if (sparseArray2 != null) {
                    ValueSet valueSetHw2 = com.byazt.ij.hn.pr((SparseArray<Object>) sparseArray2).hw();
                    return pr(iIntValue, com.byazt.ij.hw.pr().pr(valueSetHw2.intValue(-999900)).pr(valueSetHw2.stringValue(-999901)).pr(valueSetHw2.booleanValue(-999903)).pr(com.byazt.ij.hn.pr((SparseArray<Object>) valueSetHw2.objectValue(-999902, SparseArray.class)).hw()).hw());
                }
                return null;
            }
            return null;
        }

        public SparseArray<Object> pr(int i, Result result) {
            com.byazt.ij.hn hnVarPr = com.byazt.ij.hn.pr();
            if (i == 1) {
                c.pr("plugin_download", "plugin update start");
                ValueSet valueSetValues = result.values();
                if (valueSetValues == null) {
                    c.pr("plugin_download", "valueSet empty");
                    return null;
                }
                String strStringValue = valueSetValues.stringValue(3);
                int iCode = result.code();
                if (result.isSuccess()) {
                    pr prVarX = aj.x(valueSetValues.stringValue(2));
                    if (prVarX == null || TextUtils.isEmpty(prVarX.hn)) {
                        c.pr("plugin_download", "plugin update received with invalid config");
                        com.byazt.dea.uc.x("TTPluginManager", "plugin update received with invalid config");
                        return null;
                    }
                    c.pr("plugin_download", "plugin update received: " + prVarX.hn);
                    com.byazt.dea.uc.x("TTPluginManager", "plugin update received: " + prVarX.hn);
                    if (prVarX.pr()) {
                        c.pr("plugin_download", "plugin revert " + prVarX.hn);
                        Zeus.unInstallPlugin(prVarX.hn);
                    } else {
                        pr(prVarX);
                        c.pr("plugin_download", "plugin install");
                        if (aj.hw(prVarX)) {
                            hnVarPr.pr(4, true);
                        }
                    }
                } else {
                    c.pr("plugin_download", "plugin update received failed");
                    com.byazt.dea.uc.x("TTPluginManager", "plugin update received failed");
                    aj.hn(strStringValue, iCode);
                    return null;
                }
            }
            return hnVarPr.hw().sparseArray();
        }

        private void pr(pr prVar) {
            try {
                if (!TextUtils.isEmpty(prVar.hn) && prVar.hn.equals("com.byted.pangle")) {
                    aj.pr(TTAppContextHolder.getContext()).hw();
                }
            } catch (Exception e) {
            }
        }
    }

    public void hw() {
        EventListener eventListener = this.w;
        if (eventListener != null) {
            eventListener.onEvent(1, com.byazt.ij.hw.pr().pr(true).hw());
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 860, MediaPlayer.MEDIA_PLAYER_OPTION_GET_RES_HEADERS})
    private static final class pr {
        public String c;
        public String fw;
        public String hn;
        public int uc;
        public int x;
        public String pr = "";
        public File hw = null;
        public int aj = 0;
        public int vk = Integer.MAX_VALUE;
        public List<String> zo = null;

        public boolean pr() {
            return this.uc == 3;
        }
    }
}
