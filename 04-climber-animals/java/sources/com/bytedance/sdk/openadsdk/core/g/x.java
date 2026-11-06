package com.bytedance.sdk.openadsdk.core.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.u;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.jw.b;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.g;
import com.bytedance.sdk.openadsdk.core.jw.m;
import com.bytedance.sdk.openadsdk.core.nw;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.t;
import com.umeng.analytics.pro.bv;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class x extends com.bytedance.sdk.component.ch.ny {
    private static volatile x d;
    private volatile Runnable ab;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final ka f2515ms;
    private final Context xr;
    private static final AtomicLong ah = new AtomicLong(0);
    private static boolean ka = true;
    private static volatile boolean c = false;

    public static x ms(ka kaVar) {
        if (d == null) {
            synchronized (x.class) {
                if (d == null) {
                    d = new x(kaVar);
                }
            }
        }
        return d;
    }

    public static void ah() {
        try {
            g.ms("tt_sdk_settings_other").ms();
            g.ms("tt_sdk_settings_other_bst").ms();
            g.ms("tt_sdk_settings_slot").ms();
            g.ms("tt_sdk_settings_slot_bst").ms();
            g.ms("tt_sdk_settings_slot_splash").ms();
            g.ms("tt_sdk_settings_slot_splash_bst").ms();
        } catch (Throwable unused) {
        }
    }

    private x(ka kaVar) {
        super("SdkSettingsHelper");
        this.f2515ms = kaVar == null ? re.xr() : kaVar;
        Context context = re.getContext();
        this.xr = context;
        if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
            try {
                context.registerReceiver(new ms(), new IntentFilter("com.bytedance.openadsdk.settingReceiver"), f.op(), com.bytedance.sdk.component.utils.x.ms());
            } catch (Throwable unused) {
            }
        }
    }

    private class ms extends BroadcastReceiver {
        private ms() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            sl.ms("SdkSettingsHelper", "onReceive: ");
            int intExtra = intent.getIntExtra("b_msg_id", -1);
            if (intExtra == 1) {
                long longExtra = intent.getLongExtra("b_msg_time", -1L);
                if (longExtra > 0) {
                    x.ah.set(longExtra);
                    return;
                }
                return;
            }
            if (intExtra == 2) {
                try {
                    if (x.this.f2515ms != null) {
                        x.this.f2515ms.ms();
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static void d() {
        if (re.getContext() != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(f.ch());
                intent.setAction("com.bytedance.openadsdk.settingReceiver");
                intent.putExtra("b_msg_id", 2);
                re.getContext().sendBroadcast(intent, f.ch() + ".openadsdk.permission.TT_PANGOLIN");
            } catch (Throwable unused) {
            }
        }
    }

    public static void ms(long j) {
        if (j > 0 && re.getContext() != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(f.ch());
                intent.setAction("com.bytedance.openadsdk.settingReceiver");
                intent.putExtra("b_msg_id", 1);
                intent.putExtra("b_msg_time", j);
                re.getContext().sendBroadcast(intent, f.op());
            } catch (Throwable unused) {
            }
        }
    }

    public void ka() {
        ms(false);
    }

    public void ms(boolean z) {
        try {
            if (ch()) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (!z) {
                if (jCurrentTimeMillis - ah.get() < 600000) {
                    return;
                }
                xr(jCurrentTimeMillis);
            } else {
                if (this.ab != null) {
                    sl.xr("SdkSettingsHelper", "current task is not null !");
                    return;
                }
                long j = (ah.get() + 60000) - jCurrentTimeMillis;
                if (j > 0) {
                    this.ab = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.g.x.1
                        @Override // java.lang.Runnable
                        public void run() {
                            x.this.ab = null;
                            x.this.xr(System.currentTimeMillis());
                        }
                    };
                    com.bytedance.sdk.component.utils.x.ms().postDelayed(this.ab, j);
                } else {
                    this.ab = null;
                    xr(jCurrentTimeMillis);
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(long j) {
        ah.set(j);
        if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
            ms(j);
        }
        com.bytedance.sdk.component.ch.ab.ms(this, 10);
    }

    private boolean ch() {
        return TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.ch.ub().t());
    }

    public static boolean c() {
        return c;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!u.ms(this.xr)) {
            try {
                this.f2515ms.ms();
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        if (ch()) {
            return;
        }
        if (!ny.ms() || nw.f3028ms) {
            JSONObject jSONObjectAb = ab();
            m mVar = new m(com.bytedance.sdk.openadsdk.core.re.ka.ms().xr().c());
            mVar.ms(com.bytedance.sdk.openadsdk.ab.d.ms(mVar, f.ny("/api/ad/union/sdk/settings/")));
            mVar.xr("User-Agent", f.ab());
            mVar.xr(jSONObjectAb, "settings");
            com.bytedance.sdk.openadsdk.ab.d.ms(jSONObjectAb, 1);
            mVar.ms(new com.bytedance.sdk.component.ny.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.g.x.2
                @Override // com.bytedance.sdk.component.ny.ms.ms
                public void ms(com.bytedance.sdk.component.ny.xr.d dVar, com.bytedance.sdk.component.ny.xr xrVar) {
                    if (xrVar == null || !xrVar.x()) {
                        try {
                            x.this.f2515ms.ms();
                            re.xr().y();
                        } catch (Throwable unused2) {
                        }
                        nw.xr();
                        return;
                    }
                    try {
                        try {
                            final JSONObject jSONObject = (JSONObject) com.bytedance.sdk.openadsdk.core.ah.c.ms(xrVar, "settings", false).second;
                            if (jSONObject == null) {
                                return;
                            }
                            try {
                                if (!x.this.ms(jSONObject)) {
                                    sl.xr("SdkSettingsHelper", "can not update settings");
                                    return;
                                }
                            } catch (Throwable unused3) {
                            }
                            if (com.bytedance.sdk.openadsdk.core.g.ka) {
                                x.this.f2515ms.ms(jSONObject);
                            }
                            new com.bytedance.sdk.openadsdk.core.d.xr("check_and_update_pl").ms(5).xr(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.g.x.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    JSONArray jSONArrayOptJSONArray;
                                    JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("plugins");
                                    if (jSONArrayOptJSONArray2 != null) {
                                        com.bytedance.sdk.openadsdk.core.yu.ms.xr.ms().ms(jSONArrayOptJSONArray2);
                                    }
                                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
                                    if (jSONObjectOptJSONObject == null || (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("plugins")) == null) {
                                        return;
                                    }
                                    com.bytedance.sdk.openadsdk.core.yu.ms.xr.ms().ms(jSONArrayOptJSONArray);
                                }
                            });
                            try {
                                x.this.f2515ms.xr(jSONObject);
                                nw.ms();
                                if (!x.c) {
                                    boolean unused4 = x.c = true;
                                }
                                com.bytedance.sdk.openadsdk.core.ch.ub().i().ka();
                                com.bytedance.sdk.openadsdk.core.of.ms.xr();
                            } catch (Throwable th) {
                                com.bytedance.sdk.openadsdk.core.t.u.ms().ms("setting_saveData_failed", x.this.ms(th), th);
                            }
                            com.bytedance.sdk.openadsdk.core.t.u.ms().xr();
                            if (com.bytedance.sdk.openadsdk.core.multipro.xr.ah()) {
                                x.d();
                            }
                            com.bytedance.sdk.openadsdk.ab.d.xr(jSONObject, 1);
                        } catch (Throwable th2) {
                            com.bytedance.sdk.openadsdk.core.t.u.ms().ms("setting_decrypt", th2);
                        }
                    } catch (Throwable th3) {
                        com.bytedance.sdk.openadsdk.core.t.u.ms().ms("setting_parse", th3);
                    }
                }

                @Override // com.bytedance.sdk.component.ny.ms.ms
                public void ms(com.bytedance.sdk.component.ny.xr.d dVar, IOException iOException) {
                    try {
                        Iterator<String> itKeys = com.bytedance.sdk.openadsdk.core.ch.ub().of().keys();
                        while (itKeys.hasNext()) {
                            com.bytedance.sdk.openadsdk.core.yu.ms.xr.ms().ms(itKeys.next(), 1007);
                        }
                    } catch (Throwable unused2) {
                    }
                    try {
                        x.this.f2515ms.ms();
                        re.xr().y();
                    } catch (Throwable unused3) {
                    }
                    nw.xr();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ms(JSONObject jSONObject) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
            if (jSONObjectOptJSONObject != null) {
                int iOptInt = jSONObjectOptJSONObject.optInt("active_control", 1);
                ny.ms(iOptInt);
                sl.ms("SdkSettingsHelper", "sdk status: ".concat(String.valueOf(iOptInt)));
                return iOptInt == 1;
            }
        } catch (Throwable unused) {
        }
        return true;
    }

    public JSONObject ab() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ip", com.bytedance.sdk.openadsdk.core.jw.ch.c());
            jSONObject.put("ipv6", com.bytedance.sdk.openadsdk.core.jw.ch.ab());
            jSONObject.put("oaid", b.ms(false));
            jSONObject.put("model", t.re());
            jSONObject.put("conn_type", u.xr(this.xr));
            jSONObject.put("os", 1);
            jSONObject.put("oversea_version_type", 0);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put(bv.y, String.valueOf(Build.VERSION.RELEASE));
            jSONObject.put("sdk_version", com.bytedance.sdk.openadsdk.core.g.ah);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "6.9.2.3");
            jSONObject.put("is_plugin", com.bytedance.sdk.openadsdk.core.g.ms());
            jSONObject.put("is_boost", true);
            jSONObject.put("sdk_boost_type", com.bytedance.sdk.openadsdk.core.d.ms.d());
            jSONObject.put("download_sdk_version", com.bytedance.sdk.openadsdk.core.hi.ch.d());
            jSONObject.put("package_name", f.ch());
            jSONObject.put("position", f.d() ? 1 : 2);
            jSONObject.put("app_version", f.sl());
            jSONObject.put("app_code", f.hi());
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("app_id", com.bytedance.sdk.openadsdk.core.ch.ub().t());
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject.put("ts", jCurrentTimeMillis);
            jSONObject.put("req_sign", com.bytedance.sdk.component.utils.ka.xr(com.bytedance.sdk.openadsdk.core.ch.ub().t() != null ? com.bytedance.sdk.openadsdk.core.ch.ub().t().concat(String.valueOf(jCurrentTimeMillis)).concat(com.bytedance.sdk.openadsdk.core.g.ah) : ""));
            sl.ms("isApplicationForeground", "app_version:" + f.sl() + "，vendor:" + Build.MANUFACTURER);
            jSONObject.put("locale_language", com.bytedance.sdk.openadsdk.core.jw.ch.hi());
            jSONObject.put("channel", com.bytedance.sdk.openadsdk.core.g.c);
            jSONObject.put("applog_did", com.bytedance.sdk.openadsdk.core.c.ms().ah());
            jSONObject.put("can_use_sensor", com.bytedance.sdk.openadsdk.core.ch.ub().c());
            com.bytedance.sdk.openadsdk.ub.xr.ms(this.xr, jSONObject);
            com.bytedance.sdk.openadsdk.ub.xr.xr(this.xr, jSONObject);
            jSONObject.put("system_app", com.bytedance.sdk.openadsdk.core.g.ah());
            if (com.bytedance.sdk.openadsdk.core.g.ms()) {
                jSONObject.put("plugins", hi());
            }
            jSONObject.put("imei", t.ab());
            jSONObject.put("source", 1);
            jSONObject.put("device_abi", Build.SUPPORTED_ABIS[0]);
            String strTz = com.bytedance.sdk.openadsdk.core.ch.ub().tz();
            if (!TextUtils.isEmpty(strTz)) {
                jSONObject.put("rit_list", strTz);
            }
            long jM = re.xr().m();
            if (jM > 0) {
                jSONObject.put("data_time", jM);
            }
            JSONObject jSONObjectAz = re.xr().az();
            if (jSONObjectAz != null) {
                jSONObject.put("digest", jSONObjectAz);
            }
            try {
                jSONObject.put("device_score", Double.parseDouble(com.bytedance.sdk.openadsdk.core.w.ms.ms().ms("DeviceRate", "bytebench_value")));
            } catch (NumberFormatException unused) {
                jSONObject.put("device_score", -1);
            }
            jSONObject.put("csj_type", com.bytedance.sdk.openadsdk.core.ch.ub().lm() ? 1 : 0);
        } catch (Throwable unused2) {
        }
        return jSONObject;
    }

    private static JSONObject hi() {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOf = com.bytedance.sdk.openadsdk.core.ch.ub().of();
        if (jSONObjectOf == null) {
            return new JSONObject();
        }
        Iterator<String> itKeys = jSONObjectOf.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next) && (jSONObjectOptJSONObject = jSONObjectOf.optJSONObject(next)) != null) {
                try {
                    jSONObjectOptJSONObject.put("plugin_update_network", com.bytedance.sdk.openadsdk.core.ch.ub().i().ms(next));
                } catch (JSONException e) {
                    sl.ms(e);
                }
            }
        }
        return jSONObjectOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject ms(Throwable th) {
        JSONObject jSONObject = new JSONObject();
        if (th == null) {
            return jSONObject;
        }
        int i = 0;
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            i++;
            if (stackTraceElement != null) {
                try {
                    jSONObject.putOpt(String.valueOf(i), stackTraceElement.toString());
                } catch (JSONException unused) {
                }
            }
        }
        return jSONObject;
    }
}
