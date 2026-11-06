package com.bytedance.sdk.openadsdk.core.ah;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.component.ch.ab;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.re;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile xr f1978ms;
    private volatile SharedPreferences xr = com.bytedance.sdk.openadsdk.api.plugin.xr.xr(re.getContext(), "sp_dynamic_tmpl_config", 0);
    private volatile SharedPreferences ah = com.bytedance.sdk.openadsdk.api.plugin.xr.xr(re.getContext(), "sp_dynamic_tmpl_config_v3", 0);

    public static xr ms() {
        if (f1978ms == null) {
            synchronized (xr.class) {
                if (f1978ms == null) {
                    f1978ms = new xr();
                }
            }
        }
        return f1978ms;
    }

    public void ms(String str, String str2) {
        delete(str, str2, false);
    }

    public void delete(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String strXr = xr(str, null, z);
            if (TextUtils.isEmpty(strXr)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(strXr);
            if (jSONArray.length() > 0) {
                int i = 0;
                while (true) {
                    if (i >= jSONArray.length()) {
                        i = -1;
                        break;
                    }
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null && str2.equals(jSONObjectOptJSONObject.getString("id"))) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i != -1) {
                    jSONArray.remove(i);
                    ms(str, jSONArray.toString(), z);
                }
            }
        } catch (Exception unused) {
        }
    }

    public void ms(String str, com.bytedance.sdk.component.adexpress.ms.ah.ah ahVar) {
        update(str, ahVar, false);
    }

    public void update(String str, com.bytedance.sdk.component.adexpress.ms.ah.ah ahVar, boolean z) {
        if (ahVar == null || ahVar.xr() == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String strXr = xr(str, null, z);
            JSONArray jSONArray = strXr == null ? new JSONArray() : new JSONArray(strXr);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", ahVar.xr());
            jSONObject.put("md5", ahVar.ah());
            jSONArray.put(jSONObject);
            ms(str, jSONArray.toString(), z);
        } catch (Exception unused) {
        }
    }

    public JSONArray ms(final String str, int i) {
        try {
            final String strXr = xr(str, null, false);
            ab.xr(new ny("tmpl_updatetime") { // from class: com.bytedance.sdk.openadsdk.core.ah.xr.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean z;
                    try {
                        Set<com.bytedance.sdk.component.adexpress.ms.ah.xr> setMs = com.bytedance.sdk.component.adexpress.ms.xr.xr.ms(str, false);
                        JSONArray jSONArray = new JSONArray();
                        if (setMs == null || setMs.size() <= 0) {
                            z = false;
                        } else {
                            for (com.bytedance.sdk.component.adexpress.ms.ah.xr xrVar : setMs) {
                                if (xrVar != null) {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("id", xrVar.xr());
                                    jSONObject.put("md5", xrVar.ah());
                                    jSONArray.put(jSONObject);
                                }
                            }
                            z = true;
                        }
                        if (!(strXr == null && z) && jSONArray.toString().equals(strXr)) {
                            return;
                        }
                        xr.this.ms(str, jSONArray.toString(), false);
                    } catch (Exception unused) {
                    }
                }
            });
            if (TextUtils.isEmpty(strXr)) {
                return null;
            }
            return new JSONArray(strXr);
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONArray xr(final String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!ah.ms().ms(i)) {
            return ms(str);
        }
        try {
            final String strXr = xr(str, null, true);
            ab.xr(new ny("tmpl_updatetime") { // from class: com.bytedance.sdk.openadsdk.core.ah.xr.2
                @Override // java.lang.Runnable
                public void run() {
                    boolean z;
                    try {
                        Set<com.bytedance.sdk.openadsdk.core.nativeexpress.ms.ms> setMs = com.bytedance.sdk.openadsdk.core.nativeexpress.ms.xr.ms().ms(str);
                        JSONArray jSONArray = new JSONArray();
                        if (setMs == null || setMs.size() <= 0) {
                            z = false;
                        } else {
                            for (com.bytedance.sdk.openadsdk.core.nativeexpress.ms.ms msVar : setMs) {
                                if (msVar != null) {
                                    JSONObject jSONObject = new JSONObject();
                                    String[] strArrSplit = msVar.ms().split("_");
                                    if (strArrSplit.length == 2) {
                                        jSONObject.put("id", strArrSplit[1]);
                                        jSONObject.put("md5", msVar.xr());
                                        jSONArray.put(jSONObject);
                                    }
                                }
                            }
                            z = true;
                        }
                        if (!(strXr == null && z) && jSONArray.toString().equals(strXr)) {
                            return;
                        }
                        xr.this.ms(str, jSONArray.toString(), true);
                    } catch (Exception unused) {
                    }
                }
            });
            if (TextUtils.isEmpty(strXr)) {
                return null;
            }
            return new JSONArray(strXr);
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONArray ms(String str) {
        try {
            Set<com.bytedance.sdk.openadsdk.core.nativeexpress.ms.ms> setMs = com.bytedance.sdk.openadsdk.core.nativeexpress.ms.xr.ms().ms(str);
            if (setMs != null && setMs.size() != 0) {
                JSONArray jSONArray = new JSONArray();
                for (com.bytedance.sdk.openadsdk.core.nativeexpress.ms.ms msVar : setMs) {
                    if (msVar != null) {
                        JSONObject jSONObject = new JSONObject();
                        String[] strArrSplit = msVar.ms().split("_");
                        if (strArrSplit.length == 2) {
                            jSONObject.put("id", strArrSplit[1]);
                            jSONObject.put("md5", msVar.xr());
                            jSONArray.put(jSONObject);
                        } else {
                            continue;
                        }
                    }
                }
                return jSONArray;
            }
            return null;
        } catch (Exception e) {
            sl.ah("BidOptTmplManager", "getUgenParentTplIds: ", e);
            return null;
        }
    }

    public void ms(String str, String str2, boolean z) {
        SharedPreferences sharedPreferences;
        String str3;
        try {
            if (z) {
                sharedPreferences = this.ah;
                str3 = "sp_dynamic_tmpl_config_v3";
            } else {
                sharedPreferences = this.xr;
                str3 = "sp_dynamic_tmpl_config";
            }
            if (ah.ms().xr()) {
                com.bytedance.sdk.component.ab.ah.ms.xr.ms(str3, str, str2);
                return;
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString(str, str2);
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }

    public String xr(String str, String str2, boolean z) {
        SharedPreferences sharedPreferences;
        String str3;
        try {
            if (z) {
                sharedPreferences = this.ah;
                str3 = "sp_dynamic_tmpl_config_v3";
            } else {
                sharedPreferences = this.xr;
                str3 = "sp_dynamic_tmpl_config";
            }
            if (ah.ms().xr()) {
                return com.bytedance.sdk.component.ab.ah.ms.xr.xr(str3, str, str2);
            }
            return sharedPreferences.getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }
}
