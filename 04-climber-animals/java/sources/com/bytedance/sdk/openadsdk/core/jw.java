package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.anythink.core.common.d.j;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class jw {
    private Bridge x;
    private static final jw d = new jw();
    private static int ab = -1;
    private static String ny = "ext_plugin";

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private volatile Bridge f2667ms = null;
    private volatile Bridge xr = null;
    private volatile Bridge ah = null;
    private AtomicBoolean ka = new AtomicBoolean(false);
    private AtomicBoolean c = new AtomicBoolean(false);

    private jw() {
    }

    public static jw ms() {
        return d;
    }

    public Bridge ms(int i) {
        try {
            if (g.ms() && i == 10003) {
                return ab();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms(th);
        }
        return null;
    }

    public static int xr() {
        if (ab == -1) {
            ab = ms().c().intValue();
        }
        return ab;
    }

    private Integer c() {
        Integer num;
        Bridge bridgeZb = zb();
        if (bridgeZb == null || (num = (Integer) bridgeZb.call(1004, null, Integer.class)) == null) {
            return -1;
        }
        return num;
    }

    private Bridge ab() {
        com.bytedance.sdk.openadsdk.core.w.ah ahVar = (com.bytedance.sdk.openadsdk.core.w.ah) AutoService.ms(com.bytedance.sdk.openadsdk.core.w.ah.class);
        if (ahVar == null || !ahVar.ah()) {
            com.bytedance.sdk.component.utils.sl.d(ny, "can use pitaya false");
            return null;
        }
        if (!d() || c().intValue() < 1100) {
            return null;
        }
        if (this.ah == null) {
            synchronized (jw.class) {
                if (this.ah == null) {
                    try {
                        Bridge bridgeZb = zb();
                        if (bridgeZb != null) {
                            this.ah = (Bridge) bridgeZb.call(AVMDLDataLoader.KeyIsStoRingBufferSizeKB, null, Bridge.class);
                        }
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.sl.d(ny, "getBridge:" + th.getMessage());
                    }
                }
            }
        }
        return this.ah;
    }

    public static void ah() {
        if (g.xr < 5001) {
            return;
        }
        if (re.xr().w()) {
            Bundle bundle = new Bundle();
            Bundle bundleMs = ms(ch.ub().t());
            if (bundleMs != null) {
                bundle.putBundle("com.byted.csj.ext", bundleMs);
            }
            ch.ub().ms(bundle);
            return;
        }
        JSONObject jSONObjectOf = ch.ub().of();
        if (jSONObjectOf != null) {
            jSONObjectOf.remove("com.byted.csj.ext");
        }
    }

    private static Bundle ms(String str) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("app_id", str);
            String strX = x();
            if (TextUtils.isEmpty(strX)) {
                return null;
            }
            bundle.putString(PluginConstants.KEY_PLUGIN_VERSION, strX);
            bundle.putString("sdk_version", sl());
            return bundle;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.d(ny, "error:" + th.getMessage());
            com.bytedance.sdk.component.utils.sl.ms(th);
            return null;
        }
    }

    private static String x() {
        if (g.xr == 5001 || g.xr == 5002) {
            return ch();
        }
        return ny();
    }

    private static String ny() {
        return (String) ch.ub().am().call(8, com.bykv.ms.ms.ms.ms.xr.ms(1).ms(0, "com.byted.csj.ext").xr(), String.class);
    }

    private static String ch() {
        try {
            Bridge bridgeAm = ch.ub().am();
            JSONObject jSONObjectOptJSONObject = ch.ub().of().optJSONObject("com.byted.csj.ext");
            if (!((Boolean) bridgeAm.call(6, com.bykv.ms.ms.ms.ms.xr.ms(1).ms(0, "com.byted.csj.ext").xr(), Boolean.class)).booleanValue()) {
                return jSONObjectOptJSONObject == null ? "0.0.0.0" : (String) jSONObjectOptJSONObject.opt(PluginConstants.KEY_PLUGIN_VERSION);
            }
            if (ms().d()) {
                return hi();
            }
            return null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.d(ny, "ignore:" + th.getMessage());
            com.bytedance.sdk.component.utils.sl.ms(th);
            return "0.0.0.0";
        }
    }

    private static String hi() {
        try {
            Integer numC = ms().c();
            if (numC.intValue() != -1) {
                return xr(numC.intValue());
            }
            return null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms(th);
            return null;
        }
    }

    private static String sl() {
        if (g.xr >= 5003) {
            return xr(g.d);
        }
        return ms(re.getContext());
    }

    private static String ms(Context context) {
        try {
            String string = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("ZEUS_PLUGIN_com.byted.csj.ext");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            return xr(new JSONObject(string).optInt("apiVersionCode"));
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms(th);
            return null;
        }
    }

    public static String xr(int i) {
        char[] charArray = String.valueOf(i).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            sb.append(charArray[i2]);
            if (i2 < charArray.length - 1) {
                sb.append(j.z);
            }
        }
        String string = sb.toString();
        return (i < 100 || i >= 1000) ? string : "0." + string;
    }

    public boolean d() {
        try {
            if (g.xr < 5001 || !re.xr().w()) {
                return false;
            }
            if (this.ka.get()) {
                return true;
            }
            if (this.c.compareAndSet(false, true)) {
                final Bridge bridgeAm = ch.ub().am();
                ValueSet valueSetXr = com.bykv.ms.ms.ms.ms.xr.ms(1).ms(0, "com.byted.csj.ext").xr();
                if (((Boolean) bridgeAm.call(6, valueSetXr, Boolean.class)).booleanValue()) {
                    if (((Boolean) bridgeAm.call(7, valueSetXr, Boolean.class)).booleanValue()) {
                        this.ka.set(true);
                        this.c.set(false);
                    } else {
                        com.bytedance.sdk.component.utils.x.ms().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.jw.1
                            @Override // java.lang.Runnable
                            public void run() {
                                jw.this.ms(bridgeAm, true);
                            }
                        });
                    }
                } else {
                    this.c.set(false);
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.d(ny, "pit_ext_error:" + th.getMessage());
        }
        return false;
    }

    public com.byted.ms.ms.ms.ms ka() {
        if (g.xr >= 5001 && com.bytedance.sdk.openadsdk.core.y.xr.ms(re.xr().of()) && d()) {
            return (com.byted.ms.ms.ms.ms) AutoService.ms(com.byted.ms.ms.ms.ms.class);
        }
        return null;
    }

    private Bridge zb() {
        try {
            if (this.x == null) {
                this.x = (Bridge) ((ClassLoader) ch.ub().am().call(4, com.bykv.ms.ms.ms.ms.xr.ms(1).ms(0, "com.byted.csj.ext").xr(), ClassLoader.class)).loadClass("com.byted.csj.ext_impl.ServiceManager").getConstructor(new Class[0]).newInstance(new Object[0]);
            }
            return this.x;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.d(ny, "getServiceManager:" + th.getMessage());
            return null;
        }
    }

    public boolean ms(Bridge bridge, boolean z) {
        try {
            if (this.ka.get()) {
                return true;
            }
            if (!z) {
                this.c.set(true);
            }
            Boolean bool = (Boolean) bridge.call(5, com.bykv.ms.ms.ms.ms.xr.ms(1).ms(0, "com.byted.csj.ext").xr(), Boolean.class);
            this.ka.set(bool.booleanValue());
            this.c.set(false);
            return bool.booleanValue();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.d(ny, ":" + th.getMessage());
            return false;
        }
    }
}
