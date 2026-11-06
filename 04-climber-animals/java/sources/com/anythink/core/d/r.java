package com.anythink.core.d;

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
            com.anythink.core.common.r.g gVarA = com.anythink.core.common.r.g.a(new JSONObject(strC).optJSONObject(b.a.k));
            Object[] objArr = new Object[1];
            if (gVarA != null) {
                gVarA.j();
                b bVar = new b();
                bVar.a(gVarA);
                return bVar;
            }
        } catch (Throwable th) {
            Object[] objArr2 = new Object[1];
            th.getMessage();
        }
        return null;
    }

    private String c(String str) {
        try {
            Context contextG = com.anythink.core.common.d.t.b().g();
            if (contextG != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.b)) {
                Object[] objArr = new Object[1];
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(contextG.getResources().getAssets().open(this.b + File.separator + str + ".json")));
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line != null) {
                            sb.append(line);
                        } else {
                            return com.anythink.core.common.v.k.b(sb.toString());
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
