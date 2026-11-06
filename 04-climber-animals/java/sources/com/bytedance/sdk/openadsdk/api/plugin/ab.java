package com.bytedance.sdk.openadsdk.api.plugin;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.anythink.core.common.d.j;
import com.anythink.core.common.m.e;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginDecodeCallback;
import com.bytedance.pangle.ZeusPluginInstallListener;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.log.IZeusLogger;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.umeng.ccg.a;
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
public class ab {
    private static volatile BaseDexClassLoader d;
    private static volatile TTPluginListener sl;
    private final Context ny;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final String f1806ms = "next" + File.separator;
    private static final HashMap<String, TTPluginListener> xr = new HashMap<>();
    private static final HashMap<String, Handler> ah = new HashMap<>();
    private static volatile ab ka = null;
    private final CountDownLatch c = new CountDownLatch(1);
    private volatile boolean ab = false;
    private volatile String x = "none";
    private JSONObject ch = new JSONObject();
    private EventListener hi = null;

    private ab(Context context) {
        this.ny = context.getApplicationContext();
        try {
            GlobalParam.getInstance().closeHookHuaweiOnInit(true);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.d("TTPluginManager", "Unexpected error for closeHookHuaweiOnInit.", th);
        }
        xr(context.getApplicationContext());
    }

    public static ab ms(Context context) {
        if (ka == null) {
            synchronized (ab.class) {
                if (ka == null) {
                    ka = new ab(context);
                }
            }
        }
        return ka;
    }

    public JSONObject ms() {
        return this.ch;
    }

    public BaseDexClassLoader ms(c cVar, int i) throws Exception {
        boolean z;
        if (!this.ab) {
            com.bytedance.sdk.openadsdk.api.ab.d("TTPluginManager", "Zeus init failed.");
            throw new com.bytedance.sdk.openadsdk.api.plugin.ah(4, this.x);
        }
        if (!Zeus.isPluginInstalled("com.byted.pangle")) {
            if (d(this.ny)) {
                Zeus.installFromDownloadDir();
            }
            try {
                com.bytedance.sdk.openadsdk.api.ab.xr("TTPluginManager", "wait start");
                this.c.await(i, TimeUnit.MILLISECONDS);
                com.bytedance.sdk.openadsdk.api.ab.xr("TTPluginManager", "wait done");
                cVar.xr("wait_install_cost");
            } catch (Exception unused) {
                com.bytedance.sdk.openadsdk.api.ab.xr("TTPluginManager", "Install wait time out");
                throw new com.bytedance.sdk.openadsdk.api.plugin.ah(8, "install wait timeout");
            }
        }
        if (Zeus.isPluginLoaded("com.byted.pangle") || Zeus.loadPlugin("com.byted.pangle")) {
            d = Zeus.getPlugin("com.byted.pangle").mClassLoader;
            z = true;
        } else {
            z = false;
        }
        cVar.xr("get_classloader_cost");
        Zeus.installFromDownloadDir();
        if (d == null) {
            if (this.c.getCount() != 0) {
                com.bytedance.sdk.openadsdk.api.ab.d("TTPluginManager", "Install wait time out");
                throw new com.bytedance.sdk.openadsdk.api.plugin.ah(8, "install wait timeout");
            }
            if (z) {
                com.bytedance.sdk.openadsdk.api.ab.d("TTPluginManager", "Get null after load");
                throw new com.bytedance.sdk.openadsdk.api.plugin.ah(9, "Get null after load");
            }
        }
        cVar.xr("get_classloader_done");
        return d;
    }

    private void xr(Context context) {
        try {
            com.bytedance.pangle.ka.ka.ms(new com.bytedance.pangle.c() { // from class: com.bytedance.sdk.openadsdk.api.plugin.ab.1
                @Override // com.bytedance.pangle.c
                public void ms(Runnable runnable) {
                    com.bytedance.sdk.openadsdk.qv.ms.ms().ah().execute(runnable);
                }

                @Override // com.bytedance.pangle.c
                public void xr(Runnable runnable) {
                    com.bytedance.sdk.openadsdk.qv.ms.ms().ah().execute(runnable);
                }

                @Override // com.bytedance.pangle.c
                public void ah(Runnable runnable) {
                    new Handler(Looper.getMainLooper()).post(runnable);
                }
            });
            IZeusReporter iZeusReporter = new IZeusReporter() { // from class: com.bytedance.sdk.openadsdk.api.plugin.ab.2
                @Override // com.bytedance.pangle.log.IZeusReporter
                public void report(String str, JSONObject jSONObject) {
                    if ("load_finish".equals(str) && jSONObject != null && "com.byted.pangle".endsWith(jSONObject.optString("plugin_package_name"))) {
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("duration", jSONObject.opt("duration"));
                            jSONObject2.put("message", jSONObject.opt("message"));
                            ab.this.ch.put("zeus", jSONObject2);
                        } catch (Exception e) {
                            com.bytedance.sdk.openadsdk.api.ab.ms(e);
                        }
                    }
                    if (TTAdSdk.isInitSuccess()) {
                        ka.ms(str, jSONObject);
                    } else {
                        ka.xr(str, jSONObject);
                    }
                }

                @Override // com.bytedance.pangle.log.IZeusReporter
                public void saveRecord(String str, String str2) {
                    d.ms(str, str2);
                }
            };
            com.bytedance.pangle.ka.ka.ms(new com.bytedance.pangle.c() { // from class: com.bytedance.sdk.openadsdk.api.plugin.ab.3
                @Override // com.bytedance.pangle.c
                public void ms(Runnable runnable) {
                    com.bytedance.sdk.openadsdk.qv.ms.ms().ah().execute(runnable);
                }

                @Override // com.bytedance.pangle.c
                public void xr(Runnable runnable) {
                    com.bytedance.sdk.openadsdk.qv.ms.ms().ah().execute(runnable);
                }

                @Override // com.bytedance.pangle.c
                public void ah(Runnable runnable) {
                    new Handler(Looper.getMainLooper()).post(runnable);
                }
            });
            GlobalParam globalParam = GlobalParam.getInstance();
            globalParam.setReporter(iZeusReporter);
            globalParam.setCheckPermission(false);
            globalParam.setDownloadDir(ah(context));
            globalParam.setLogger(new xr());
            globalParam.setSignature("com.byted.pangle", "MIIDfTCCAmWgAwIBAgIEfRwYPjANBgkqhkiG9w0BAQsFADBvMQswCQYDVQQGEwJDTjEQMA4GA1UECBMHQmVpamluZzEQMA4GA1UEBxMHQmVpamluZzESMBAGA1UEChMJQnl0ZURhbmNlMQ8wDQYDVQQLEwZQYW5nbGUxFzAVBgNVBAMTDkNodWFuIFNoYW4gSmlhMB4XDTIxMTEwODA2MjQzOVoXDTQ2MTEwMjA2MjQzOVowbzELMAkGA1UEBhMCQ04xEDAOBgNVBAgTB0JlaWppbmcxEDAOBgNVBAcTB0JlaWppbmcxEjAQBgNVBAoTCUJ5dGVEYW5jZTEPMA0GA1UECxMGUGFuZ2xlMRcwFQYDVQQDEw5DaHVhbiBTaGFuIEppYTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAIBKeRL+4mfCn1SLYv6OemfwwItkjlLPyqOEugkV6lanFTcZgLwEl5LIkL0y28UncPtMX1Mii6DzCdJ/plw7S9+RT/hYDneu339IKWojaU2qai/5FokHlQ0MMnYl5yry00ghVPsl1u+03cQA2ZnjIMiFhrBJpQzHt7IYvq2aEEMBcY8uT7iFoBI848e1mL1joVS2z02C3NliP7ZNARkXH+rTQAlCJulT5IZk+V/PTaKqzgNrkhsKh0/tBmU7m8u79x/xpgGsE19H18AgS4P/9/MDCRe2Z35boZeccaUy2MXCwv3djzUcDk3rRzQPYzdpyyRnrFMuhiKesc5VHgUMs9kCAwEAAaMhMB8wHQYDVR0OBBYEFENENrNWGzc2WhxdvhoMDs57U70zMA0GCSqGSIb3DQEBCwUAA4IBAQAHqDCrmvyBBmIGXwuL1rwS/Qv9ZJIZykBIaNMm+H1IfitCl4yXd9N2n+PjE0UZtxZ21UZOt9wAr+RFiSl5YRXqpt7WLARTy4YW3RiQ+wiL7bshzeSYBoSiC427Bfeq0WjwY0/jHlr8uouppyJOz++6U9hrYX2EW/6UjH5XlWiKQJ6b2ZzPcP8Xpg/TJn4tWvXJP6jw9kRRP2GmMttY78leWQst2QEZILmWJubXRLPj9O+qx2uP9oGTD4sc1vb9hzkOHBIHzGaalqLFbbGaeFpLFHoGTsnOfPTwUVKDZYmxbkcmR1bp7eYOW+nSQNMLn0FjDewZl5l37Sa/gz0WVHon");
            globalParam.setSignature("com.byted.csj.ext", "MIIDezCCAmOgAwIBAgIENkE1KDANBgkqhkiG9w0BAQsFADBtMQswCQYDVQQGEwI4NjEQMA4GA1UECBMHYmVpamluZzEQMA4GA1UEBxMHYmVpamluZzESMBAGA1UEChMJYnl0ZWRhbmNlMRIwEAYDVQQLEwlieXRlZGFuY2UxEjAQBgNVBAMTCWJ5dGVkYW5jZTAgFw0yMjExMDIwODI3MzlaGA8yMDUwMDMyMDA4MjczOVowbTELMAkGA1UEBhMCODYxEDAOBgNVBAgTB2JlaWppbmcxEDAOBgNVBAcTB2JlaWppbmcxEjAQBgNVBAoTCWJ5dGVkYW5jZTESMBAGA1UECxMJYnl0ZWRhbmNlMRIwEAYDVQQDEwlieXRlZGFuY2UwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCc9Z2F3xxOMX1qTXMy2aPmS9OSkqrp8C8bHwS1hkNVR4umKREuqOn73INNo+R706jaCVnlPwxDwWjtX6H74DE4CveivyM9f2wNC3yIyDW+5j7lW/keTQcOlGLDEJQv4O/6FbB/jNU6epjyNaNIZhgZcvTpgaSixbdyHzRTFmvMh+WovdVK/J9LnHOQ+pmPZj7NB6MQRGMUrPEotLHQca3cmnLrnPAaZQaVoaFE9lOt9syyqEuf361SprNIGDtbkJuX3EqV/QOKWFwZX94IS7ZGSvfyCojcD4kaUSbaSoZC7zEuBb7l69g+ZMrJ/v6wkm01wxsNNssUwF7k6Sp0zubbAgMBAAGjITAfMB0GA1UdDgQWBBSxk+gVdDco1dP65hP67qoKNlMEYDANBgkqhkiG9w0BAQsFAAOCAQEAfosExl/AYEbS2xqHBTHa28cvnp/SElUQuzW6aWLqkfk9cxmFSI/euUV3/eB8RN+U2X47Y05u6+XUxTv0tSSEtyXNawm0qWH8jkR4gZY38YqBChKjhea668oT5X3Uocrw7SYXO/BfI8SKPa0uI/U8Cyl3uctbmmq/pPUkd3mKAy+HgyJoThD6K0oyiADlygngUMVTv6Uvid4qPj/bBnxI+LvVeX4l1dxGqWkiafQW9sz+RbFdge3X2XsSH4eo01BsCwOYEv1lHO2FrbAtFNpnIsSqrERdFaAJZ3tlJmg9bA03png8A2AajEjkhaOhduJB8zkSlvHNpoQMIAS9WtkG/w==");
            globalParam.setSignature("com.byted.live.lite", "MIIDSTCCAjGgAwIBAgIEaLy5tzANBgkqhkiG9w0BAQsFADBVMQswCQYDVQQGEwIxMTEMMAoGA1UECBMDMTExMQ4wDAYDVQQHEwUxMTExMTEMMAoGA1UEChMDMTExMQwwCgYDVQQLEwMxMTExDDAKBgNVBAMTAzExMTAeFw0yMDEyMDMxMjQyMTJaFw00NTExMjcxMjQyMTJaMFUxCzAJBgNVBAYTAjExMQwwCgYDVQQIEwMxMTExDjAMBgNVBAcTBTExMTExMQwwCgYDVQQKEwMxMTExDDAKBgNVBAsTAzExMTEMMAoGA1UEAxMDMTExMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA45E52YdkJm4gPCXZq7KDoM1h6pgSswllC/CwDOmh8pDGvX4ROaYP1vr2biRlXMHg7G0iXpxWVdlTtx+4QFd3dC+cGJQk0f6apGo2n2RpMA0zIsSf0VO1a3GjWLei5INo+4RDdciqJ4jfsoqBIjZETRkky+UU4eO/oyrAwOu4KdMln3Bg3u7eHWU4kMFrXxrRruT3Q/9gzlO90yQa0CZPWVDrk6cGJtJwJGhWm+62S3U8D26HE++eGP7ve83QBDGtKqx7HpCAFWUiYBgXGq12H0amQDkKcPcr/EFCaBlombSgkN0t6zBX80m+wcUPC75IBTmMV/DT2dXcgjZ2I1JSCQIDAQABoyEwHzAdBgNVHQ4EFgQUPDyIeKI0KhZFPHyn36gMMIYrpukwDQYJKoZIhvcNAQELBQADggEBAHkl0DoCRwn+XKsDJE+wGMpBBqUDzL6DSOnJx4SNqb7YZZU0ThcDK7jY4If3QRkvMio6ODrVZc2U/m/Tc3VeMk5h2W2UZRUWHNH3k9Xe0720uL20ZeH2Y6IG4L5HG8kIbTbFtX3gJpPG/xAcez+CzyCFLWQAZt1N+csG0syWkXJ0Nryq8VrgSCyCXD1KzFxrOe+65wtu50Vi68Vlbk7BZe/G8Qm0RhKmxq5BPMBJ4uY3be+03Ba5qC//o1XQHOEAjrJKXcN5wqHdFZTkmuxVyIPogZOzx4JlNl0zOrYGDJxp7aZfKF9FkXQyF7x0Ns3mZEtjx/+flXRzAAU9MDhPr/0=");
            Zeus.registerPluginStateListener(new ZeusPluginStateListener() { // from class: com.bytedance.sdk.openadsdk.api.plugin.ab.4
                @Override // com.bytedance.pangle.ZeusPluginStateListener
                public void onPluginStateChange(String str, int i, Object... objArr) {
                    com.bytedance.sdk.openadsdk.api.ab.xr("TTPluginManager", str + " state changed, " + i);
                    if (i != 9 || TextUtils.equals(str, "com.byted.pangle")) {
                        return;
                    }
                    ab.this.d(str);
                }
            });
            Zeus.setDecodeCallback(new ZeusPluginDecodeCallback() { // from class: com.bytedance.sdk.openadsdk.api.plugin.ab.5
                @Override // com.bytedance.pangle.ZeusPluginDecodeCallback
                public String decode(String str) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        String strOptString = jSONObject.optString("cypher");
                        String strOptString2 = jSONObject.optString("message");
                        if (!TextUtils.equals(strOptString, "3") || TextUtils.isEmpty(strOptString2)) {
                            return null;
                        }
                        return com.bytedance.sdk.openadsdk.api.plugin.xr.ms.ms(strOptString2);
                    } catch (Throwable th) {
                        com.bytedance.sdk.openadsdk.api.ab.xr("TTPluginManager", "dex plugin decode throw error ".concat(String.valueOf(th)));
                        return null;
                    }
                }
            });
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isDexPlugin", 1);
                jSONObject.put("apiVersionCode", 1000);
                jSONObject.put("packageName", "com.byted.mixed");
                jSONObject.put("hostPackageName", "com.byted.pangle");
                jSONObject.put("minPluginVersion", 1000);
                jSONObject.put("maxPluginVersion", 999999999);
                jSONObject.put("internalPath", "");
                jSONObject.put("internalVersionCode", -1);
                jSONObject.put("appKey", "");
                jSONObject.put("appSecretKey", "");
                Zeus.addPackageDexManager("com.byted.mixed", jSONObject);
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.api.ab.xr("TTPluginManager", "init dex plugin config throw error " + th);
            }
            globalParam.closeBgDex2oat(true);
            Zeus.init((Application) context);
            Zeus.registerPluginInstallListener(new ZeusPluginInstallListener() { // from class: com.bytedance.sdk.openadsdk.api.plugin.ab.6
                @Override // com.bytedance.pangle.ZeusPluginInstallListener
                public void onPluginInstall(String str, int i, String str2) {
                    if (i == 7) {
                        ab.this.xr(str, i);
                        return;
                    }
                    if (i == 6) {
                        ab.this.xr(str, i);
                        if (ab.this.hi != null && "com.byted.pangle".equals(str)) {
                            ab.this.hi.onEvent(0, com.bykv.ms.ms.ms.ms.ms.ms().ms(true).xr());
                        } else {
                            com.bytedance.sdk.openadsdk.api.ab.xr("TTPluginManager", "no main pl");
                        }
                    }
                }
            });
            this.ab = true;
        } catch (Throwable th2) {
            com.bytedance.sdk.openadsdk.api.ab.d("TTPluginManager", "Unexpected error for init zeus.", th2);
            this.x = th2.getMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        Plugin plugin = Zeus.getPlugin(str, false);
        try {
            if (plugin.mClassLoader != null) {
                TTAdSdk.getAdManager().register(com.bykv.ms.ms.ms.ms.xr.ms(3).ms(0, 1).ms(1, str).ms(2, plugin.mClassLoader).xr().sparseArray());
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.xr("TTPluginManager", "initPluginService failed in " + str, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(String str, int i) {
        if ("com.byted.pangle".equals(str) && i == 6) {
            com.bytedance.sdk.openadsdk.api.ab.d("TTPluginManager", "notify to end wait");
            this.c.countDown();
        }
        ms(i == 6, str);
    }

    private static File ah(Context context) {
        return new File(com.bytedance.sdk.openadsdk.api.plugin.xr.ms(context, "tt_pangle_bykv_file", 0), f1806ms);
    }

    private static boolean d(Context context) {
        File fileAh = ah(context);
        return fileAh.exists() && fileAh.listFiles().length != 0;
    }

    public Bundle ms(String str, Bundle bundle) {
        String strMs = ms(str);
        if (!TextUtils.isEmpty(strMs)) {
            bundle.putString(PluginConstants.KEY_PLUGIN_VERSION, strMs);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putBundle(str, bundle);
        Bundle bundle3 = new Bundle();
        bundle3.putBundle(PluginConstants.KEY_PL_CONFIG_INFO, bundle2);
        return bundle3;
    }

    public static String ms(String str) {
        Plugin plugin;
        try {
            if (!Zeus.isPluginInstalled(str, false) || (plugin = Zeus.getPlugin(str, false)) == null) {
                return null;
            }
            return ms(plugin.getVersion());
        } catch (Throwable unused) {
            com.bytedance.sdk.openadsdk.api.ab.d("TTPluginManager", "Get local version failed");
            return null;
        }
    }

    public static String xr(String str) {
        int installedMaxVer;
        try {
            Plugin plugin = Zeus.getPlugin(str, false);
            if (plugin == null || (installedMaxVer = plugin.getInstalledMaxVer()) <= 0) {
                return null;
            }
            return ms(installedMaxVer);
        } catch (Throwable unused) {
            com.bytedance.sdk.openadsdk.api.ab.d("TTPluginManager", "Get local version failed");
            return null;
        }
    }

    public void ms(final TTPluginListener tTPluginListener) {
        if (!this.ab) {
            com.bytedance.sdk.openadsdk.api.ab.d("TTPluginManager", "Zeus init failed.");
            if (tTPluginListener != null) {
                tTPluginListener.onPluginListener(1002, null, null, null);
                return;
            }
            return;
        }
        Handler handlerXr = com.bytedance.sdk.openadsdk.qv.ms.ms().xr();
        Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.ab.7
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.api.ab.xr("TTPluginManager", "Load plugin failed, caused by timeout.");
                tTPluginListener.onPluginListener(1001, null, null, null);
            }
        };
        handlerXr.postDelayed(runnable, 180000L);
        String strPackageName = tTPluginListener.packageName();
        Plugin plugin = (Zeus.isPluginInstalled(strPackageName) && (Zeus.isPluginLoaded(strPackageName) || Zeus.loadPlugin(strPackageName))) ? Zeus.getPlugin(strPackageName) : null;
        com.bytedance.sdk.openadsdk.api.ab.xr("TTPluginManager", "Find plugin:" + (plugin != null));
        if (plugin != null) {
            ms(plugin);
            handlerXr.removeCallbacks(runnable);
            tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
        } else {
            xr.put(strPackageName, tTPluginListener);
            ah.put(strPackageName, handlerXr);
        }
    }

    public void xr(TTPluginListener tTPluginListener) {
        String strPackageName = tTPluginListener.packageName();
        Plugin plugin = (Zeus.isPluginInstalled(strPackageName) && (Zeus.isPluginLoaded(strPackageName) || Zeus.loadPlugin(strPackageName))) ? Zeus.getPlugin(strPackageName) : null;
        com.bytedance.sdk.openadsdk.api.ab.xr("TTPluginManager", "Find plugin:" + (plugin != null));
        if (plugin != null) {
            ms(plugin);
            tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
        } else {
            sl = tTPluginListener;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ms ka(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return ms(new JSONObject(str));
        } catch (JSONException unused) {
            com.bytedance.sdk.openadsdk.api.ab.ka("TTPluginManager", "Invalid plugin info:" + str);
            return null;
        }
    }

    private static ms ms(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ms msVar = new ms();
        msVar.ah = jSONObject.optString("package_name");
        msVar.d = jSONObject.optInt("version_code");
        msVar.ka = jSONObject.optString("download_url");
        msVar.ab = jSONObject.optString("md5");
        msVar.ny = jSONObject.optInt("min_version");
        msVar.ch = jSONObject.optInt("max_version");
        msVar.f1814ms = jSONObject.optString(e.X);
        msVar.c = jSONObject.optBoolean("is_revert") ? 3 : 2;
        msVar.xr = new File(jSONObject.optString("plugin_file"));
        return msVar;
    }

    private static void ms(Plugin plugin) {
        if (plugin == null) {
            com.bytedance.sdk.openadsdk.api.ab.d("TTPluginManager", "plugin is null.");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(a.z, 0);
        bundle.putString("plugin_pkg_name", plugin.mPkgName);
        bundle.putString(PluginConstants.KEY_PLUGIN_VERSION, ms(plugin.getVersion()));
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager != null) {
            adManager.getExtra(Bundle.class, bundle);
        }
    }

    public static String ms(int i) {
        char[] charArray = String.valueOf(i).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            sb.append(charArray[i2]);
            if (i2 < charArray.length - 1) {
                sb.append(j.z);
            }
        }
        return sb.toString();
    }

    private static boolean ms(TTPluginListener tTPluginListener, String str) {
        if (tTPluginListener == null || tTPluginListener.packageName() == null) {
            return false;
        }
        return tTPluginListener.packageName().equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean xr(ms msVar) {
        if (msVar == null || msVar.xr == null) {
            com.bytedance.sdk.openadsdk.api.ab.d("TTPluginManager", "plugin config is null");
            return false;
        }
        boolean zSyncInstallPlugin = Zeus.syncInstallPlugin(msVar.ah, msVar.xr.getAbsolutePath());
        ms(zSyncInstallPlugin, msVar.ah);
        return zSyncInstallPlugin;
    }

    private static void ms(boolean z, String str) {
        HashMap<String, TTPluginListener> map = xr;
        TTPluginListener tTPluginListener = map.get(str);
        com.bytedance.sdk.openadsdk.api.ab.xr("TTPluginManager", "Install dl plugin " + str + (z ? " success" : " failed") + ", need notify: " + (tTPluginListener != null));
        HashMap<String, Handler> map2 = ah;
        Handler handler = map2.get(str);
        if (z) {
            TTPluginListener tTPluginListener2 = sl;
            if (!ms(tTPluginListener2, str) && (tTPluginListener == null || handler == null)) {
                return;
            }
            if (Zeus.loadPlugin(str)) {
                Plugin plugin = Zeus.getPlugin(str);
                ms(plugin);
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
                if (tTPluginListener != null) {
                    tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
                }
                if (ms(tTPluginListener2, str)) {
                    tTPluginListener2.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
                    sl = null;
                }
            } else {
                com.bytedance.sdk.openadsdk.api.ab.xr("TTPluginManager", "handle installed, load failed");
                ah(str, 1002);
            }
        } else {
            com.bytedance.sdk.openadsdk.api.ab.xr("TTPluginManager", "handle installed failed");
            ah(str, 1003);
        }
        map.remove(str);
        map2.remove(str);
    }

    public static void ms(Throwable th) {
        if (th instanceof AbstractMethodError) {
            Zeus.unInstallPlugin("com.byted.pangle");
            com.bytedance.sdk.openadsdk.api.ab.d("TTPluginManager", "AbstractMethodError, rollback to builtin version.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ah(String str, int i) {
        com.bytedance.sdk.openadsdk.api.ab.d("TTPluginManager", "plugin update failed");
        Bundle bundle = new Bundle();
        bundle.putInt("code", i);
        TTPluginListener tTPluginListener = xr.get(str);
        if (tTPluginListener != null) {
            tTPluginListener.onPluginListener(1001, null, null, bundle);
        }
    }

    private static final class xr implements IZeusLogger {
        private xr() {
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void v(String str, String str2) {
            com.bytedance.sdk.openadsdk.api.ab.ms(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void i(String str, String str2) {
            com.bytedance.sdk.openadsdk.api.ab.ah(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void w(String str, String str2) {
            com.bytedance.sdk.openadsdk.api.ab.d(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void w(String str, String str2, Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.d(str, str2, th);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void e(String str, String str2, Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ka(str, str2, th);
        }
    }

    static final class ah implements Serializable, Function<SparseArray<Object>, Object> {
        ah() {
        }

        @Override // java.util.function.Function
        /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
        public Object apply(SparseArray<Object> sparseArray) {
            ValueSet valueSetXr;
            int iIntValue;
            if (sparseArray == null || (iIntValue = (valueSetXr = com.bykv.ms.ms.ms.ms.xr.ms(sparseArray).xr()).intValue(-99999987)) != 1) {
                return null;
            }
            return ms(iIntValue, com.bykv.ms.ms.ms.ms.ms.ms().ms(valueSetXr.intValue(-999900)).ms(valueSetXr.stringValue(-999901)).ms(valueSetXr.booleanValue(-999903)).ms(com.bykv.ms.ms.ms.ms.xr.ms((SparseArray<Object>) valueSetXr.objectValue(-999902, SparseArray.class)).xr()).xr());
        }

        public ValueSet ms(int i, Result result) {
            com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms();
            if (i == 1) {
                d.ms("plugin_download", "plugin update start");
                ValueSet valueSetValues = result.values();
                if (valueSetValues == null) {
                    d.ms("plugin_download", "valueSet empty");
                    return null;
                }
                String strStringValue = valueSetValues.stringValue(3);
                int iCode = result.code();
                if (result.isSuccess()) {
                    ms msVarKa = ab.ka(valueSetValues.stringValue(2));
                    if (msVarKa == null || TextUtils.isEmpty(msVarKa.ah)) {
                        d.ms("plugin_download", "plugin update received with invalid config");
                        com.bytedance.sdk.openadsdk.api.ab.d("TTPluginManager", "plugin update received with invalid config");
                        return null;
                    }
                    d.ms("plugin_download", "plugin update received: " + msVarKa.ah);
                    com.bytedance.sdk.openadsdk.api.ab.d("TTPluginManager", "plugin update received: " + msVarKa.ah);
                    if (msVarKa.ms()) {
                        d.ms("plugin_download", "plugin revert " + msVarKa.ah);
                        Zeus.unInstallPlugin(msVarKa.ah);
                    } else {
                        ms(msVarKa);
                        d.ms("plugin_download", "plugin install");
                        if (ab.xr(msVarKa)) {
                            xrVarMs.ms(4, true);
                        }
                    }
                } else {
                    d.ms("plugin_download", "plugin update received failed");
                    com.bytedance.sdk.openadsdk.api.ab.d("TTPluginManager", "plugin update received failed");
                    ab.ah(strStringValue, iCode);
                    return null;
                }
            }
            return xrVarMs.xr();
        }

        private void ms(ms msVar) {
            try {
                if (TextUtils.isEmpty(msVar.ah) || !msVar.ah.equals("com.byted.pangle")) {
                    return;
                }
                ab.ms(TTAppContextHolder.getContext()).xr();
            } catch (Exception unused) {
            }
        }
    }

    public void xr() {
        EventListener eventListener = this.hi;
        if (eventListener != null) {
            eventListener.onEvent(1, com.bykv.ms.ms.ms.ms.ms.ms().ms(true).xr());
        }
    }

    private static final class ms {
        public String ab;
        public String ah;
        public int c;
        public int d;
        public String ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public String f1814ms = "";
        public File xr = null;
        public int ny = 0;
        public int ch = Integer.MAX_VALUE;
        public List<String> x = null;

        ms() {
        }

        public boolean ms() {
            return this.c == 3;
        }
    }
}
