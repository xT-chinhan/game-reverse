package com.byazt.qyu;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.anythink.core.common.d.i;
import com.anythink.core.common.l.f;
import com.byazt.dx.MainServerManager;
import com.byazt.gx.oa;
import com.byazt.ry.d;
import com.byazt.ry.sz;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
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
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.smartdigimkt.sdk.api.SDMAdConst;
import com.taptap.sdk.core.internal.event.iap.lib2plus.BillingClientConstants;
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
@com.byazt.cp.n(n = {0, 1, 1178, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv {
    public static volatile TTPluginListener d;
    public static volatile BaseDexClassLoader q;
    public final Context rv;
    public static final String n = "next" + File.separator;
    public static final HashMap<String, TTPluginListener> qg = new HashMap<>();
    public static final HashMap<String, Handler> s = new HashMap<>();
    public static volatile rv l = null;
    public final CountDownLatch w = new CountDownLatch(1);
    public volatile boolean x = false;
    public volatile String fs = LiveConfigKey.NONE;
    public JSONObject tj = new JSONObject();
    public EventListener cp = null;

    private rv(Context context) {
        Plugin plugin = null;
        this.rv = context.getApplicationContext();
        try {
            GlobalParam.getInstance().closeHookHuaweiOnInit(true);
        } catch (Throwable th) {
            com.byazt.vx.w.q("TTPluginManager", "Unexpected error for closeHookHuaweiOnInit.", th);
        }
        com.byazt.ry.cp.n().n(MainServerManager.class.getName());
        qg(context.getApplicationContext());
        try {
            plugin = Zeus.getPlugin("com.byted.pangle");
        } catch (Throwable th2) {
            com.byazt.vx.w.q("TTPluginManager", "Failed to get plugin during init.", th2);
        }
        if (plugin != null) {
            plugin.setApiBridge(com.byazt.ja.q.n());
        }
    }

    public static rv n(Context context) {
        if (l == null) {
            synchronized (rv.class) {
                if (l == null) {
                    l = new rv(context);
                }
            }
        }
        return l;
    }

    public JSONObject n() {
        return this.tj;
    }

    public BaseDexClassLoader n(x xVar, int i) throws Exception {
        boolean z;
        String str;
        if (!this.x) {
            com.byazt.vx.w.q("TTPluginManager", "Zeus init failed.");
            throw new q(4, this.fs);
        }
        boolean zQg = com.byazt.eh.s.qg();
        int i2 = 8;
        if (!Zeus.isPluginInstalled("com.byted.pangle")) {
            if (zQg) {
                new fs(this.rv).n();
            }
            if (q(this.rv)) {
                Zeus.installFromDownloadDir();
            }
            try {
                if (!zQg) {
                    com.byazt.vx.w.qg("TTPluginManager", "dont wait pl");
                } else {
                    com.byazt.vx.w.qg("TTPluginManager", "wait start");
                    this.w.await(i, TimeUnit.MILLISECONDS);
                }
                com.byazt.vx.w.qg("TTPluginManager", "wait done");
                xVar.qg("wait_install_cost");
            } catch (Exception unused) {
                com.byazt.vx.w.qg("TTPluginManager", "Install wait time out");
                throw new q(8, "install wait timeout");
            }
        }
        if (Zeus.isPluginLoaded("com.byted.pangle") || Zeus.loadPlugin("com.byted.pangle")) {
            q = Zeus.getPlugin("com.byted.pangle").mClassLoader;
            z = true;
        } else {
            z = false;
        }
        xVar.qg("get_classloader_cost");
        Zeus.installFromDownloadDir();
        if (q == null) {
            if (this.w.getCount() != 0) {
                if (zQg) {
                    i2 = 10;
                    str = "this device does not support arm64-v8a, and install wait time out";
                } else {
                    str = "install wait time out";
                }
                com.byazt.vx.w.q("TTPluginManager", "Install wait time out");
                throw new q(i2, str);
            }
            if (z) {
                com.byazt.vx.w.q("TTPluginManager", "Get null after load");
                throw new q(9, "Get null after load");
            }
        }
        xVar.qg("get_classloader_done");
        return q;
    }

    private void qg(Context context) {
        try {
            oa.n().n(new cp());
            com.byazt.zi.l.n(new com.byazt.ry.w() { // from class: com.byazt.qyu.rv.1
                @Override // com.byazt.ry.w
                public void n(Runnable runnable) {
                    com.byazt.fyy.n.n().q().execute(runnable);
                }

                @Override // com.byazt.ry.w
                public void qg(Runnable runnable) {
                    com.byazt.fyy.n.n().q().execute(runnable);
                }

                @Override // com.byazt.ry.w
                public void s(Runnable runnable) {
                    new Handler(Looper.getMainLooper()).post(runnable);
                }
            });
            com.byazt.is.n nVar = new com.byazt.is.n() { // from class: com.byazt.qyu.rv.2
                @Override // com.byazt.is.n
                public void n(String str, JSONObject jSONObject) {
                    if ("load_finish".equals(str) && jSONObject != null && "com.byted.pangle".endsWith(jSONObject.optString("plugin_package_name"))) {
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(MediationConstant.EXTRA_DURATION, jSONObject.opt(MediationConstant.EXTRA_DURATION));
                            jSONObject2.put("message", jSONObject.opt("message"));
                            rv.this.tj.put("zeus", jSONObject2);
                        } catch (Exception e) {
                            com.byazt.vx.w.n(e);
                        }
                    }
                    if (TTAdSdk.isInitSuccess()) {
                        w.n(str, jSONObject);
                    } else {
                        w.qg(str, jSONObject);
                    }
                }

                @Override // com.byazt.is.n
                public void n(String str, String str2) {
                    l.n(str, str2);
                }
            };
            GlobalParam globalParam = GlobalParam.getInstance();
            globalParam.setReporter(nVar);
            globalParam.setCheckPermission(false);
            globalParam.setDownloadDir(s(context));
            globalParam.setLogger(new qg());
            globalParam.setSignature("com.byted.pangle", "MIIDfTCCAmWgAwIBAgIEfRwYPjANBgkqhkiG9w0BAQsFADBvMQswCQYDVQQGEwJDTjEQMA4GA1UECBMHQmVpamluZzEQMA4GA1UEBxMHQmVpamluZzESMBAGA1UEChMJQnl0ZURhbmNlMQ8wDQYDVQQLEwZQYW5nbGUxFzAVBgNVBAMTDkNodWFuIFNoYW4gSmlhMB4XDTIxMTEwODA2MjQzOVoXDTQ2MTEwMjA2MjQzOVowbzELMAkGA1UEBhMCQ04xEDAOBgNVBAgTB0JlaWppbmcxEDAOBgNVBAcTB0JlaWppbmcxEjAQBgNVBAoTCUJ5dGVEYW5jZTEPMA0GA1UECxMGUGFuZ2xlMRcwFQYDVQQDEw5DaHVhbiBTaGFuIEppYTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAIBKeRL+4mfCn1SLYv6OemfwwItkjlLPyqOEugkV6lanFTcZgLwEl5LIkL0y28UncPtMX1Mii6DzCdJ/plw7S9+RT/hYDneu339IKWojaU2qai/5FokHlQ0MMnYl5yry00ghVPsl1u+03cQA2ZnjIMiFhrBJpQzHt7IYvq2aEEMBcY8uT7iFoBI848e1mL1joVS2z02C3NliP7ZNARkXH+rTQAlCJulT5IZk+V/PTaKqzgNrkhsKh0/tBmU7m8u79x/xpgGsE19H18AgS4P/9/MDCRe2Z35boZeccaUy2MXCwv3djzUcDk3rRzQPYzdpyyRnrFMuhiKesc5VHgUMs9kCAwEAAaMhMB8wHQYDVR0OBBYEFENENrNWGzc2WhxdvhoMDs57U70zMA0GCSqGSIb3DQEBCwUAA4IBAQAHqDCrmvyBBmIGXwuL1rwS/Qv9ZJIZykBIaNMm+H1IfitCl4yXd9N2n+PjE0UZtxZ21UZOt9wAr+RFiSl5YRXqpt7WLARTy4YW3RiQ+wiL7bshzeSYBoSiC427Bfeq0WjwY0/jHlr8uouppyJOz++6U9hrYX2EW/6UjH5XlWiKQJ6b2ZzPcP8Xpg/TJn4tWvXJP6jw9kRRP2GmMttY78leWQst2QEZILmWJubXRLPj9O+qx2uP9oGTD4sc1vb9hzkOHBIHzGaalqLFbbGaeFpLFHoGTsnOfPTwUVKDZYmxbkcmR1bp7eYOW+nSQNMLn0FjDewZl5l37Sa/gz0WVHon");
            globalParam.setSignature("com.byted.csj.ext", "MIIDezCCAmOgAwIBAgIENkE1KDANBgkqhkiG9w0BAQsFADBtMQswCQYDVQQGEwI4NjEQMA4GA1UECBMHYmVpamluZzEQMA4GA1UEBxMHYmVpamluZzESMBAGA1UEChMJYnl0ZWRhbmNlMRIwEAYDVQQLEwlieXRlZGFuY2UxEjAQBgNVBAMTCWJ5dGVkYW5jZTAgFw0yMjExMDIwODI3MzlaGA8yMDUwMDMyMDA4MjczOVowbTELMAkGA1UEBhMCODYxEDAOBgNVBAgTB2JlaWppbmcxEDAOBgNVBAcTB2JlaWppbmcxEjAQBgNVBAoTCWJ5dGVkYW5jZTESMBAGA1UECxMJYnl0ZWRhbmNlMRIwEAYDVQQDEwlieXRlZGFuY2UwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCc9Z2F3xxOMX1qTXMy2aPmS9OSkqrp8C8bHwS1hkNVR4umKREuqOn73INNo+R706jaCVnlPwxDwWjtX6H74DE4CveivyM9f2wNC3yIyDW+5j7lW/keTQcOlGLDEJQv4O/6FbB/jNU6epjyNaNIZhgZcvTpgaSixbdyHzRTFmvMh+WovdVK/J9LnHOQ+pmPZj7NB6MQRGMUrPEotLHQca3cmnLrnPAaZQaVoaFE9lOt9syyqEuf361SprNIGDtbkJuX3EqV/QOKWFwZX94IS7ZGSvfyCojcD4kaUSbaSoZC7zEuBb7l69g+ZMrJ/v6wkm01wxsNNssUwF7k6Sp0zubbAgMBAAGjITAfMB0GA1UdDgQWBBSxk+gVdDco1dP65hP67qoKNlMEYDANBgkqhkiG9w0BAQsFAAOCAQEAfosExl/AYEbS2xqHBTHa28cvnp/SElUQuzW6aWLqkfk9cxmFSI/euUV3/eB8RN+U2X47Y05u6+XUxTv0tSSEtyXNawm0qWH8jkR4gZY38YqBChKjhea668oT5X3Uocrw7SYXO/BfI8SKPa0uI/U8Cyl3uctbmmq/pPUkd3mKAy+HgyJoThD6K0oyiADlygngUMVTv6Uvid4qPj/bBnxI+LvVeX4l1dxGqWkiafQW9sz+RbFdge3X2XsSH4eo01BsCwOYEv1lHO2FrbAtFNpnIsSqrERdFaAJZ3tlJmg9bA03png8A2AajEjkhaOhduJB8zkSlvHNpoQMIAS9WtkG/w==");
            globalParam.setSignature("com.byted.live.lite", "MIIDSTCCAjGgAwIBAgIEaLy5tzANBgkqhkiG9w0BAQsFADBVMQswCQYDVQQGEwIxMTEMMAoGA1UECBMDMTExMQ4wDAYDVQQHEwUxMTExMTEMMAoGA1UEChMDMTExMQwwCgYDVQQLEwMxMTExDDAKBgNVBAMTAzExMTAeFw0yMDEyMDMxMjQyMTJaFw00NTExMjcxMjQyMTJaMFUxCzAJBgNVBAYTAjExMQwwCgYDVQQIEwMxMTExDjAMBgNVBAcTBTExMTExMQwwCgYDVQQKEwMxMTExDDAKBgNVBAsTAzExMTEMMAoGA1UEAxMDMTExMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA45E52YdkJm4gPCXZq7KDoM1h6pgSswllC/CwDOmh8pDGvX4ROaYP1vr2biRlXMHg7G0iXpxWVdlTtx+4QFd3dC+cGJQk0f6apGo2n2RpMA0zIsSf0VO1a3GjWLei5INo+4RDdciqJ4jfsoqBIjZETRkky+UU4eO/oyrAwOu4KdMln3Bg3u7eHWU4kMFrXxrRruT3Q/9gzlO90yQa0CZPWVDrk6cGJtJwJGhWm+62S3U8D26HE++eGP7ve83QBDGtKqx7HpCAFWUiYBgXGq12H0amQDkKcPcr/EFCaBlombSgkN0t6zBX80m+wcUPC75IBTmMV/DT2dXcgjZ2I1JSCQIDAQABoyEwHzAdBgNVHQ4EFgQUPDyIeKI0KhZFPHyn36gMMIYrpukwDQYJKoZIhvcNAQELBQADggEBAHkl0DoCRwn+XKsDJE+wGMpBBqUDzL6DSOnJx4SNqb7YZZU0ThcDK7jY4If3QRkvMio6ODrVZc2U/m/Tc3VeMk5h2W2UZRUWHNH3k9Xe0720uL20ZeH2Y6IG4L5HG8kIbTbFtX3gJpPG/xAcez+CzyCFLWQAZt1N+csG0syWkXJ0Nryq8VrgSCyCXD1KzFxrOe+65wtu50Vi68Vlbk7BZe/G8Qm0RhKmxq5BPMBJ4uY3be+03Ba5qC//o1XQHOEAjrJKXcN5wqHdFZTkmuxVyIPogZOzx4JlNl0zOrYGDJxp7aZfKF9FkXQyF7x0Ns3mZEtjx/+flXRzAAU9MDhPr/0=");
            Zeus.setDecodeCallback(new d() { // from class: com.byazt.qyu.rv.3
                @Override // com.byazt.ry.d
                public String n(String str) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        String strOptString = jSONObject.optString("cypher");
                        String strOptString2 = jSONObject.optString("message");
                        if (!TextUtils.equals(strOptString, "3") || TextUtils.isEmpty(strOptString2)) {
                            return null;
                        }
                        return com.byazt.eh.qg.qg(strOptString2);
                    } catch (Throwable th) {
                        com.byazt.vx.w.qg("TTPluginManager", "dex plugin decode throw error ".concat(String.valueOf(th)));
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
                com.byazt.vx.w.qg("TTPluginManager", "init dex plugin config throw error " + th);
            }
            globalParam.closeBgDex2oat(true);
            Zeus.init((Application) context);
            Zeus.registerPluginInstallListener(new sz() { // from class: com.byazt.qyu.rv.4
                @Override // com.byazt.ry.sz
                public void n(String str, int i, String str2) {
                    if (i == 7) {
                        rv.this.qg(str, i);
                        return;
                    }
                    if (i == 6) {
                        rv.this.qg(str, i);
                        if (rv.this.cp != null && "com.byted.pangle".equals(str)) {
                            rv.this.cp.onEvent(0, com.byazt.qvu.qg.n().n(true).qg());
                        } else {
                            com.byazt.vx.w.qg("TTPluginManager", "no main pl");
                        }
                    }
                }
            });
            this.x = true;
        } catch (Throwable th2) {
            com.byazt.vx.w.q("TTPluginManager", "Unexpected error for init zeus.", th2);
            this.fs = th2.getMessage();
        }
        PluginManager pluginManager = PluginManager.getInstance();
        pluginManager.registerPlugin("{apiVersionCode:7814,packageName:com.byted.pangle,minPluginVersion:7814,internalPath:'',internalVersionCode:7814}");
        pluginManager.registerPlugin("{apiVersionCode:1000,packageName:com.byted.csj.ext,minPluginVersion:1000,maxPluginVersion:999999999,internalPath:'',internalVersionCode:-1,appKey:'',appSecretKey:''}");
        pluginManager.registerPlugin("{apiVersionCode:2114,packageName:com.byted.live.lite,minPluginVersion:211400,maxPluginVersion:999999,isSupportLibIsolate:true}");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(String str, int i) {
        if ("com.byted.pangle".equals(str) && i == 6) {
            com.byazt.vx.w.q("TTPluginManager", "notify to end wait");
            this.w.countDown();
        }
        n(i == 6, str);
    }

    private static File s(Context context) {
        return new File(com.byazt.qyu.qg.n(context, "tt_pangle_bykv_file", 0), n);
    }

    private static boolean q(Context context) {
        File fileS = s(context);
        return fileS.exists() && fileS.listFiles().length != 0;
    }

    public Bundle n(String str, Bundle bundle) {
        String strN = n(str);
        if (!TextUtils.isEmpty(strN)) {
            bundle.putString(PluginConstants.KEY_PLUGIN_VERSION, strN);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putBundle(str, bundle);
        Bundle bundle3 = new Bundle();
        bundle3.putBundle(PluginConstants.KEY_PL_CONFIG_INFO, bundle2);
        return bundle3;
    }

    public static String n(String str) {
        Plugin plugin;
        try {
            if (!Zeus.isPluginInstalled(str, false) || (plugin = Zeus.getPlugin(str, false)) == null) {
                return null;
            }
            return n(plugin.getVersion());
        } catch (Throwable th) {
            com.byazt.vx.w.q("TTPluginManager", "Get local version failed");
            Context context = TTAppContextHolder.getContext();
            if (context == null) {
                return null;
            }
            String packageName = context.getPackageName();
            if ("com.union_test.toutiao".equals(packageName) || "com.pangolin_demo.toutiao".equals(packageName) || "com.bytedance.mediation_demo_csj".equals(packageName)) {
                throw th;
            }
            return null;
        }
    }

    public static String qg(String str) {
        int installedMaxVer;
        try {
            Plugin plugin = Zeus.getPlugin(str, false);
            if (plugin == null || (installedMaxVer = plugin.getInstalledMaxVer()) <= 0) {
                return null;
            }
            return n(installedMaxVer);
        } catch (Throwable unused) {
            com.byazt.vx.w.q("TTPluginManager", "Get local version failed");
            return null;
        }
    }

    public void n(final TTPluginListener tTPluginListener) {
        if (!this.x) {
            com.byazt.vx.w.q("TTPluginManager", "Zeus init failed.");
            if (tTPluginListener != null) {
                tTPluginListener.onPluginListener(1002, null, null, null);
                return;
            }
            return;
        }
        Handler handlerQg = com.byazt.fyy.n.n().qg();
        Runnable runnable = new Runnable() { // from class: com.byazt.qyu.rv.5
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.vx.w.qg("TTPluginManager", "Load plugin failed, caused by timeout.");
                tTPluginListener.onPluginListener(1001, null, null, null);
            }
        };
        handlerQg.postDelayed(runnable, 180000L);
        String strPackageName = tTPluginListener.packageName();
        Plugin plugin = (Zeus.isPluginInstalled(strPackageName) && (Zeus.isPluginLoaded(strPackageName) || Zeus.loadPlugin(strPackageName))) ? Zeus.getPlugin(strPackageName) : null;
        com.byazt.vx.w.qg("TTPluginManager", "Find plugin:" + (plugin != null));
        if (plugin != null) {
            n(plugin);
            handlerQg.removeCallbacks(runnable);
            tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
        } else {
            qg.put(strPackageName, tTPluginListener);
            s.put(strPackageName, handlerQg);
        }
    }

    public void qg(TTPluginListener tTPluginListener) {
        String strPackageName = tTPluginListener.packageName();
        Plugin plugin = (Zeus.isPluginInstalled(strPackageName) && (Zeus.isPluginLoaded(strPackageName) || Zeus.loadPlugin(strPackageName))) ? Zeus.getPlugin(strPackageName) : null;
        com.byazt.vx.w.qg("TTPluginManager", "Find plugin:" + (plugin != null));
        if (plugin != null) {
            n(plugin);
            tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
        } else {
            d = tTPluginListener;
        }
    }

    public void n(EventListener eventListener) {
        this.cp = eventListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static n q(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return n(new JSONObject(str));
        } catch (JSONException unused) {
            com.byazt.vx.w.l("TTPluginManager", "Invalid plugin info:" + str);
            return null;
        }
    }

    private static n n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        n nVar = new n();
        nVar.s = jSONObject.optString("package_name");
        nVar.q = jSONObject.optInt("version_code");
        nVar.l = jSONObject.optString(SDMAdConst.NETWORK_CUSTOM_KEY.DOWNLOAD_URL);
        nVar.x = jSONObject.optString("md5");
        nVar.rv = jSONObject.optInt("min_version");
        nVar.tj = jSONObject.optInt("max_version");
        nVar.n = jSONObject.optString(f.Y);
        nVar.w = jSONObject.optBoolean("is_revert") ? 3 : 2;
        nVar.qg = new File(jSONObject.optString("plugin_file"));
        return nVar;
    }

    private static void n(Plugin plugin) {
        if (plugin == null) {
            com.byazt.vx.w.q("TTPluginManager", "plugin is null.");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("action", 0);
        bundle.putString("plugin_pkg_name", plugin.mPkgName);
        bundle.putString(PluginConstants.KEY_PLUGIN_VERSION, n(plugin.getVersion()));
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager != null) {
            adManager.getExtra(Bundle.class, bundle);
        }
    }

    public static String n(int i) {
        char[] charArray = String.valueOf(i).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            sb.append(charArray[i2]);
            if (i2 < charArray.length - 1) {
                sb.append(i.E);
            }
        }
        return sb.toString();
    }

    private static boolean n(TTPluginListener tTPluginListener, String str) {
        if (tTPluginListener == null || tTPluginListener.packageName() == null) {
            return false;
        }
        return tTPluginListener.packageName().equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean qg(n nVar) {
        if (nVar == null || nVar.qg == null) {
            com.byazt.vx.w.q("TTPluginManager", "plugin config is null");
            return false;
        }
        boolean zSyncInstallPlugin = Zeus.syncInstallPlugin(nVar.s, nVar.qg.getAbsolutePath());
        n(zSyncInstallPlugin, nVar.s);
        return zSyncInstallPlugin;
    }

    private static void n(boolean z, String str) {
        HashMap<String, TTPluginListener> map = qg;
        TTPluginListener tTPluginListener = map.get(str);
        com.byazt.vx.w.qg("TTPluginManager", "Install dl plugin " + str + (z ? " success" : " failed") + ", need notify: " + (tTPluginListener != null));
        HashMap<String, Handler> map2 = s;
        Handler handler = map2.get(str);
        if (z) {
            TTPluginListener tTPluginListener2 = d;
            if (!n(tTPluginListener2, str) && (tTPluginListener == null || handler == null)) {
                return;
            }
            if (Zeus.loadPlugin(str)) {
                Plugin plugin = Zeus.getPlugin(str);
                n(plugin);
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
                if (tTPluginListener != null) {
                    tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
                }
                if (n(tTPluginListener2, str)) {
                    tTPluginListener2.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
                    d = null;
                }
            } else {
                com.byazt.vx.w.qg("TTPluginManager", "handle installed, load failed");
                s(str, 1002);
            }
        } else {
            com.byazt.vx.w.qg("TTPluginManager", "handle installed failed");
            s(str, 1003);
        }
        map.remove(str);
        map2.remove(str);
    }

    public static void n(Throwable th) {
        if (th instanceof AbstractMethodError) {
            Zeus.unInstallPlugin("com.byted.pangle");
            com.byazt.vx.w.q("TTPluginManager", "AbstractMethodError, rollback to builtin version.");
            w.n("uninstall_plugin", null, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s(String str, int i) {
        com.byazt.vx.w.q("TTPluginManager", "plugin update failed");
        Bundle bundle = new Bundle();
        bundle.putInt("code", i);
        TTPluginListener tTPluginListener = qg.get(str);
        if (tTPluginListener != null) {
            tTPluginListener.onPluginListener(1001, null, null, bundle);
        }
    }

    @com.byazt.cp.n(n = {0, 1, 1178, 529})
    private static final class qg implements IZeusLogger {
        private qg() {
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void v(String str, String str2) {
            com.byazt.vx.w.n(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void i(String str, String str2) {
            com.byazt.vx.w.s(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void w(String str, String str2) {
            com.byazt.vx.w.q(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void w(String str, String str2, Throwable th) {
            com.byazt.vx.w.q(str, str2, th);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void e(String str, String str2, Throwable th) {
            com.byazt.vx.w.l(str, str2, th);
        }
    }

    @com.byazt.cp.n(n = {0, 1, 1178, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_OPENED_TIME})
    static final class s implements Serializable, Function<SparseArray<Object>, Object> {
        @Override // java.util.function.Function
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public Object apply(SparseArray<Object> sparseArray) {
            if (sparseArray == null) {
                return null;
            }
            ValueSet valueSetQg = com.byazt.qvu.s.n(sparseArray).qg();
            int iIntValue = valueSetQg.intValue(-99999987);
            SparseArray sparseArray2 = (SparseArray) valueSetQg.objectValue(-99999979, SparseArray.class);
            if (sparseArray2 == null) {
                return null;
            }
            ValueSet valueSetQg2 = com.byazt.qvu.s.n((SparseArray<Object>) sparseArray2).qg();
            return n(iIntValue, com.byazt.qvu.qg.n().n(valueSetQg2.intValue(-999900)).n(valueSetQg2.stringValue(-999901)).n(valueSetQg2.booleanValue(-999903)).n(com.byazt.qvu.s.n((SparseArray<Object>) valueSetQg2.objectValue(-999902, SparseArray.class)).qg()).qg());
        }

        public SparseArray<Object> n(int i, Result result) {
            com.byazt.qvu.s sVarN = com.byazt.qvu.s.n();
            if (i == 1) {
                l.n("plugin_download", "plugin update start");
                ValueSet valueSetValues = result.values();
                if (valueSetValues == null) {
                    l.n("plugin_download", "valueSet empty");
                    return null;
                }
                String strStringValue = valueSetValues.stringValue(3);
                int iCode = result.code();
                if (result.isSuccess()) {
                    n nVarQ = rv.q(valueSetValues.stringValue(2));
                    if (nVarQ == null || TextUtils.isEmpty(nVarQ.s)) {
                        l.n("plugin_download", "plugin update received with invalid config");
                        com.byazt.vx.w.q("TTPluginManager", "plugin update received with invalid config");
                        return null;
                    }
                    l.n("plugin_download", "plugin update received: " + nVarQ.s);
                    com.byazt.vx.w.q("TTPluginManager", "plugin update received: " + nVarQ.s);
                    if (nVarQ.n()) {
                        l.n("plugin_download", "plugin revert " + nVarQ.s);
                        Zeus.unInstallPlugin(nVarQ.s);
                    } else {
                        n(nVarQ);
                        l.n("plugin_download", "plugin install");
                        if (rv.qg(nVarQ)) {
                            sVarN.n(4, true);
                        }
                    }
                } else {
                    l.n("plugin_download", "plugin update received failed");
                    com.byazt.vx.w.q("TTPluginManager", "plugin update received failed");
                    rv.s(strStringValue, iCode);
                    return null;
                }
            }
            return sVarN.qg().sparseArray();
        }

        private void n(n nVar) {
            try {
                if (TextUtils.isEmpty(nVar.s) || !nVar.s.equals("com.byted.pangle")) {
                    return;
                }
                rv.n(TTAppContextHolder.getContext()).qg();
            } catch (Exception unused) {
            }
        }
    }

    public void qg() {
        EventListener eventListener = this.cp;
        if (eventListener != null) {
            eventListener.onEvent(1, com.byazt.qvu.qg.n().n(true).qg());
        }
    }

    @com.byazt.cp.n(n = {0, 1, 1178, 160})
    private static final class n {
        public String l;
        public int q;
        public String s;
        public int w;
        public String x;
        public String n = "";
        public File qg = null;
        public int rv = 0;
        public int tj = Integer.MAX_VALUE;
        public List<String> fs = null;

        public boolean n() {
            return this.w == 3;
        }
    }
}
