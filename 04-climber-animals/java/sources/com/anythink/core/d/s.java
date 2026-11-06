package com.anythink.core.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class s {
    private static final String a = "PrePlacementStrategy";
    private String b;

    public final void a(String str) {
        this.b = str;
    }

    public final l b(String str) {
        String strC = c(str);
        if (TextUtils.isEmpty(strC)) {
            return null;
        }
        try {
            l lVarA = l.a(str, new JSONObject(strC));
            lVarA.a(1);
            return lVarA;
        } catch (Throwable unused) {
            return null;
        }
    }

    private String c(String str) {
        int i;
        int i2;
        Context contextG = com.anythink.core.common.d.t.b().g();
        if (contextG != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.b)) {
            try {
                Object[] objArr = new Object[1];
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(contextG.getResources().getAssets().open(this.b + File.separator + str + ".json")));
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                    }
                    JSONObject jSONObject = new JSONObject(com.anythink.core.common.v.k.b(sb.toString()));
                    int iOptInt = jSONObject.optInt(com.anythink.core.common.m.e.M, 0);
                    if (iOptInt != 0) {
                        com.anythink.core.common.u.e.b("pre_s_cus_code_error", "sdk_cus_code = 0 strategy_cus_code = ".concat(String.valueOf(iOptInt)), com.anythink.core.common.d.t.b().r());
                        return "";
                    }
                    if (!jSONObject.isNull("sdk_ver")) {
                        String string = jSONObject.getString("sdk_ver");
                        if (!TextUtils.isEmpty(string) && (i2 = Integer.parseInt(com.anythink.core.common.v.p.a().replace("UA_", "").replace(com.anythink.core.common.d.j.z, ""))) < (i = Integer.parseInt(string.replace(com.anythink.core.common.d.j.z, "")))) {
                            Log.e(a, String.format("The sdk version(%s) must be greater than or equal to the version(%s) in the placement strategy.", Integer.valueOf(i2), Integer.valueOf(i)));
                            return "";
                        }
                    }
                    if (!jSONObject.isNull(com.anythink.core.common.m.e.bk)) {
                        String string2 = jSONObject.getString(com.anythink.core.common.m.e.bk);
                        if (!TextUtils.isEmpty(string2) && !str.equals(string2)) {
                            return "";
                        }
                    }
                    if (!jSONObject.isNull("pl_data")) {
                        return jSONObject.getJSONObject("pl_data").toString();
                    }
                } catch (IOException unused) {
                    return "";
                }
            } catch (Throwable th) {
                Log.e(a, "Get pre placement strategy failed: " + th.getMessage());
            }
        }
        return "";
    }
}
