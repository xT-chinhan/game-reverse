package com.anythink.core.e;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class r {
    private static final String a = "r";
    private String b;

    public final void a(String str) {
        this.b = str;
    }

    public final b b(String str) {
        Looper.myLooper();
        Looper.getMainLooper();
        try {
            String strC = c(str);
            if (TextUtils.isEmpty(strC)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(strC);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(b.a.k);
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(b.a.C);
            com.anythink.core.common.q.g gVarA = com.anythink.core.common.q.g.a(jSONObjectOptJSONObject);
            b bVar = new b();
            if (gVarA != null) {
                gVarA.l();
                bVar.a(gVarA);
            }
            if (jSONObjectOptJSONObject2 != null) {
                b.a(bVar, jSONObjectOptJSONObject2);
            }
            return bVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    private String c(String str) {
        try {
            Context contextG = com.anythink.core.common.d.s.b().g();
            if (contextG != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.b)) {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(contextG.getResources().getAssets().open(this.b + File.separator + str + ".json")));
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line != null) {
                            sb.append(line);
                        } else {
                            return com.anythink.core.common.u.j.b(sb.toString());
                        }
                    }
                } catch (IOException unused) {
                }
            }
            return "";
        } catch (Exception e) {
            Log.e(a, "getPreAppStrategyStr() >>> error: " + e.getMessage());
            return "";
        }
    }
}
