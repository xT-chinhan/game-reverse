package com.anythink.pd;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.GeolocationPermissions;
import com.anythink.china.b.e;
import com.anythink.china.b.f;
import com.anythink.china.c.a;
import com.anythink.core.api.ATSDK;
import com.anythink.core.api.IExHandler;
import com.anythink.core.common.d.t;
import com.anythink.core.common.k.d;
import com.anythink.core.d.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
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
    int macOpen = 1;
    int imeiOpen = 1;

    @Override // com.anythink.core.api.IExHandler, com.anythink.core.api.IOdHandler
    public void initDeviceInfo(Context context) {
        a.a(context);
    }

    @Override // com.anythink.core.api.IExHandler, com.anythink.core.api.IOdHandler
    public String getUniqueId(Context context) {
        return a.b(context);
    }

    @Override // com.anythink.core.api.IExHandler
    public void fillRequestData(JSONObject jSONObject, b bVar) {
        fillRequestData(jSONObject, bVar, -1);
    }

    @Override // com.anythink.core.api.IExHandler, com.anythink.core.api.IOdHandler
    public void fillRequestData(JSONObject jSONObject, b bVar, int i) {
        String strQ = bVar != null ? bVar.Q() : "";
        try {
            if (TextUtils.isEmpty(strQ)) {
                jSONObject.put("mac", a.c(t.b().g()));
                jSONObject.put("imei", a.d(t.b().g()));
            } else {
                try {
                    JSONObject jSONObject2 = new JSONObject(strQ);
                    this.macOpen = jSONObject2.optInt(com.kuaishou.weapon.p0.t.m);
                    this.imeiOpen = jSONObject2.optInt("i");
                } catch (Exception unused) {
                }
                jSONObject.put("mac", this.macOpen == 1 ? a.c(t.b().g()) : "");
                jSONObject.put("imei", this.imeiOpen == 1 ? a.d(t.b().g()) : "");
            }
        } catch (Exception unused2) {
        }
        try {
            jSONObject.put(JSON_REQUEST_BTTS, a.i());
        } catch (Throwable unused3) {
        }
        if (i == -1 || (i & 64) != 64) {
            return;
        }
        try {
            jSONObject.put("imsi", a.c());
        } catch (Throwable unused4) {
        }
    }

    @Override // com.anythink.core.api.IExHandler
    public void fillRequestDeviceData(JSONObject jSONObject, int i) {
        if ((i & 1) == 1) {
            try {
                if (!TextUtils.isEmpty(a.d())) {
                    jSONObject.put("isroot", Integer.parseInt(a.d()));
                }
            } catch (Throwable unused) {
            }
            try {
                if (!TextUtils.isEmpty(a.e())) {
                    jSONObject.put("isagent", Integer.parseInt(a.e()));
                }
            } catch (Throwable unused2) {
            }
            try {
                jSONObject.put("wifi_name", a.a());
            } catch (Throwable unused3) {
            }
            try {
                if (!TextUtils.isEmpty(a.f())) {
                    jSONObject.put(JSON_REQUEST_INSTALL_TS, Long.parseLong(a.f()));
                }
            } catch (Throwable unused4) {
            }
            try {
                if (!TextUtils.isEmpty(a.g())) {
                    jSONObject.put(JSON_REQUEST_UPDATE_TS, Long.parseLong(a.g()));
                }
            } catch (Throwable unused5) {
            }
        }
        if ((i & 2) == 2) {
            try {
                jSONObject.put(JSON_REQUEST_UPDATE_MARK, a.h());
            } catch (Throwable unused6) {
            }
        }
        if ((i & 64) == 64) {
            try {
                jSONObject.put("wifi_name", a.a());
                jSONObject.put(JSON_REQUEST_COMMON_DENY_PLAD, ATSDK.getPersionalizedAdStatus());
            } catch (Throwable unused7) {
            }
        }
    }

    @Override // com.anythink.core.api.IExHandler, com.anythink.core.api.IOdHandler
    public void fillTestDeviceData(JSONObject jSONObject, b bVar) {
        Object obj = "";
        String strQ = bVar != null ? bVar.Q() : "";
        if (TextUtils.isEmpty(strQ)) {
            try {
                String strD = a.d(t.b().g());
                if (!TextUtils.isEmpty(strD)) {
                    obj = strD;
                }
                jSONObject.put("IMEI", obj);
                return;
            } catch (Exception unused) {
                return;
            }
        }
        try {
            JSONObject jSONObject2 = new JSONObject(strQ);
            this.macOpen = jSONObject2.optInt(com.kuaishou.weapon.p0.t.m);
            this.imeiOpen = jSONObject2.optInt("i");
        } catch (Exception unused2) {
        }
        try {
            String strD2 = a.d(t.b().g());
            if (this.imeiOpen == 1 && !TextUtils.isEmpty(strD2)) {
                obj = strD2;
            }
            jSONObject.put("IMEI", obj);
        } catch (Exception unused3) {
        }
    }

    @Override // com.anythink.core.api.IExHandler, com.anythink.core.api.IOdHandler
    public String fillCDataParam(String str) {
        if (str == null) {
            return "";
        }
        String strD = this.imeiOpen == 1 ? a.d(t.b().g()) : "";
        String strC = this.macOpen == 1 ? a.c(t.b().g()) : "";
        if (strD == null) {
            strD = "";
        }
        return str.replaceAll("at_device1", strD).replaceAll("at_device2", strC != null ? strC : "");
    }

    @Override // com.anythink.core.api.IExHandler
    public String getAid(Context context) {
        return a.e(context);
    }

    @Override // com.anythink.core.api.IExHandler
    public boolean onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        try {
            callback.invoke(str, true, false);
        } catch (Throwable unused) {
        }
        return true;
    }

    @Override // com.anythink.core.api.IExHandler
    public void resetSSID() {
        a.b();
    }

    @Override // com.anythink.core.api.IExHandler
    public void startPlugin(Context context) {
        f.a().a(context);
    }

    @Override // com.anythink.core.api.IExHandler
    public void startRefreshes(long j) {
        e.a().a(j);
    }

    @Override // com.anythink.core.api.IExHandler
    public void addPlLoadStateListener(d dVar) {
        f.a().a(dVar);
    }

    @Override // com.anythink.core.api.IExHandler
    public boolean isContainsPlStr(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains(com.anythink.china.a.a.a) || str.contains(com.anythink.china.a.a.b);
    }

    @Override // com.anythink.core.api.IExHandler
    public String getDefaultMarketSchemePackageName() {
        return a.j();
    }
}
