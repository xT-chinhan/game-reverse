package com.smartdigimkt.pd;

import android.content.Context;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.GeolocationPermissions;
import com.smartdigimkt.p4.a;
import com.smartdigimkt.q2.g;
import com.smartdigimkt.r4.e;
import com.smartdigimkt.r4.h;
import com.smartdigimkt.r4.i;
import com.smartdigimkt.r4.p;
import com.smartdigimkt.sdk.api.IExHandler;
import com.smartdigimkt.sdk.core.SDKContext;
import java.math.BigDecimal;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ExHandler implements IExHandler {
    public static final String JSON_REQUEST_BOOT_MARK = "boot_mark";
    public static final String JSON_REQUEST_BTTS = "btts";
    public static final String JSON_REQUEST_COMMON_DENY_PLAD = "deny_plad";
    public static final String JSON_REQUEST_COMMON_IMSI = "imsi";
    public static final String JSON_REQUEST_CPU = "cpu";
    public static final String JSON_REQUEST_IMEI = "imei";
    public static final String JSON_REQUEST_INSTALL_TS = "install_ts";
    public static final String JSON_REQUEST_ISAGENT = "isagent";
    public static final String JSON_REQUEST_ISROOT = "isroot";
    public static final String JSON_REQUEST_MAC = "mac";
    public static final String JSON_REQUEST_SSID = "wifi_name";
    public static final String JSON_REQUEST_UPDATE_MARK = "update_mark";
    public static final String JSON_REQUEST_UPDATE_TS = "update_ts";
    private int macOpen = 1;
    private int imeiOpen = 1;

    @Override // com.smartdigimkt.sdk.api.IExHandler
    public void fillRequestData(JSONObject jSONObject, a aVar) {
        fillRequestData(jSONObject, aVar, -1);
    }

    @Override // com.smartdigimkt.sdk.api.IExHandler
    public void fillRequestDeviceData(JSONObject jSONObject, int i) {
        if ((i & 1) == 1) {
            try {
                if (!TextUtils.isEmpty(com.smartdigimkt.g.a.c)) {
                    jSONObject.put("isroot", Integer.parseInt(com.smartdigimkt.g.a.c));
                }
            } catch (Throwable unused) {
            }
            try {
                String strB = "";
                if (!TextUtils.isEmpty(h.c("isagent") ? "" : p.b(SDKContext.getInstance().d()))) {
                    Context contextD = SDKContext.getInstance().d();
                    if (!h.c("isagent")) {
                        strB = p.b(contextD);
                    }
                    jSONObject.put("isagent", Integer.parseInt(strB));
                }
            } catch (Throwable unused2) {
            }
            try {
                jSONObject.put("wifi_name", com.smartdigimkt.g.a.d());
            } catch (Throwable unused3) {
            }
            try {
                if (!TextUtils.isEmpty(com.smartdigimkt.g.a.d)) {
                    jSONObject.put("install_ts", Long.parseLong(com.smartdigimkt.g.a.d));
                }
            } catch (Throwable unused4) {
            }
            try {
                if (!TextUtils.isEmpty(com.smartdigimkt.g.a.e)) {
                    jSONObject.put("update_ts", Long.parseLong(com.smartdigimkt.g.a.e));
                }
            } catch (Throwable unused5) {
            }
        }
        if ((i & 2) == 2) {
            try {
                jSONObject.put("update_mark", com.smartdigimkt.g.a.f);
            } catch (Throwable unused6) {
            }
        }
        if ((i & 64) == 64) {
            try {
                jSONObject.put("wifi_name", com.smartdigimkt.g.a.d());
                jSONObject.put("deny_plad", g.a);
            } catch (Throwable unused7) {
            }
        }
    }

    @Override // com.smartdigimkt.sdk.api.IExHandler
    public void fillTestDeviceData(JSONObject jSONObject, a aVar) {
        Object obj = "";
        String str = aVar != null ? aVar.r : "";
        try {
            if (TextUtils.isEmpty(str)) {
                String strB = com.smartdigimkt.g.a.b(SDKContext.getInstance().d());
                if (!TextUtils.isEmpty(strB)) {
                    obj = strB;
                }
                jSONObject.put("IMEI", obj);
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(str);
                this.macOpen = jSONObject2.optInt("m");
                this.imeiOpen = jSONObject2.optInt("i");
            } catch (Exception unused) {
            }
            String strB2 = com.smartdigimkt.g.a.b(SDKContext.getInstance().d());
            if (this.imeiOpen == 1 && !TextUtils.isEmpty(strB2)) {
                obj = strB2;
            }
            jSONObject.put("IMEI", obj);
        } catch (Exception unused2) {
        }
    }

    @Override // com.smartdigimkt.sdk.api.IExHandler
    public String getAid(Context context) {
        return com.smartdigimkt.g.a.a(context);
    }

    @Override // com.smartdigimkt.sdk.api.IExHandler
    public String getDefaultMarketSchemePackageName() {
        return com.smartdigimkt.g.a.a();
    }

    @Override // com.smartdigimkt.sdk.api.IExHandler
    public String getUniqueId(Context context) {
        com.smartdigimkt.g.a.b(context);
        return !TextUtils.isEmpty(com.smartdigimkt.g.a.b) ? com.smartdigimkt.g.a.b : "";
    }

    @Override // com.smartdigimkt.sdk.api.IExHandler
    public void initDeviceInfo(Context context) {
        com.smartdigimkt.g.a.c(context);
    }

    @Override // com.smartdigimkt.sdk.api.IExHandler
    public boolean initPlugin(Context context) {
        com.smartdigimkt.f.h hVarA = com.smartdigimkt.f.h.a();
        if (context == null) {
            hVarA.getClass();
            return false;
        }
        if (hVarA.b != null) {
            com.smartdigimkt.w2.a.a(context).a(hVarA.b);
        }
        hVarA.b = new com.smartdigimkt.f.a();
        IntentFilter intentFilter = new IntentFilter();
        String packageName = context.getPackageName();
        intentFilter.addAction(i.a(e.e(packageName + packageName)));
        com.smartdigimkt.w2.a.a(context).a(hVarA.b, intentFilter);
        return true;
    }

    @Override // com.smartdigimkt.sdk.api.IExHandler
    public boolean isContainsPlStr(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains(com.smartdigimkt.d.a.a) || str.contains(com.smartdigimkt.d.a.b);
    }

    @Override // com.smartdigimkt.sdk.api.IExHandler
    public boolean onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        try {
            callback.invoke(str, true, false);
        } catch (Throwable unused) {
        }
        return true;
    }

    @Override // com.smartdigimkt.sdk.api.IExHandler
    public void resetSSID() {
        synchronized (com.smartdigimkt.g.a.class) {
            com.smartdigimkt.g.a.k = null;
        }
    }

    @Override // com.smartdigimkt.sdk.api.IExHandler
    public void startRefreshes(long j) {
    }

    @Override // com.smartdigimkt.sdk.api.IExHandler
    public void fillRequestData(JSONObject jSONObject, a aVar, int i) {
        String strC;
        String string = "";
        String str = aVar != null ? aVar.r : "";
        try {
            if (TextUtils.isEmpty(str)) {
                SDKContext.getInstance().d();
                jSONObject.put("mac", com.smartdigimkt.g.a.c());
                jSONObject.put("imei", com.smartdigimkt.g.a.b(SDKContext.getInstance().d()));
            } else {
                try {
                    JSONObject jSONObject2 = new JSONObject(str);
                    this.macOpen = jSONObject2.optInt("m");
                    this.imeiOpen = jSONObject2.optInt("i");
                } catch (Exception unused) {
                }
                if (this.macOpen == 1) {
                    SDKContext.getInstance().d();
                    strC = com.smartdigimkt.g.a.c();
                } else {
                    strC = "";
                }
                jSONObject.put("mac", strC);
                jSONObject.put("imei", this.imeiOpen == 1 ? com.smartdigimkt.g.a.b(SDKContext.getInstance().d()) : "");
            }
        } catch (Exception unused2) {
        }
        try {
            string = new BigDecimal((System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000.0d).setScale(6, 4).toString();
        } catch (Throwable unused3) {
        }
        try {
            jSONObject.put("btts", string);
        } catch (Throwable unused4) {
        }
        if (i == -1 || (i & 64) != 64) {
            return;
        }
        try {
            jSONObject.put("imsi", com.smartdigimkt.g.a.b());
        } catch (Throwable unused5) {
        }
    }

    @Override // com.smartdigimkt.sdk.api.IExHandler
    public String fillCDataParam(String str) {
        String strC;
        if (str == null) {
            return "";
        }
        String strB = this.imeiOpen == 1 ? com.smartdigimkt.g.a.b(SDKContext.getInstance().d()) : "";
        if (this.macOpen == 1) {
            SDKContext.getInstance().d();
            strC = com.smartdigimkt.g.a.c();
        } else {
            strC = "";
        }
        if (strB == null) {
            strB = "";
        }
        return str.replaceAll("at_device1", strB).replaceAll("at_device2", strC != null ? strC : "");
    }
}
