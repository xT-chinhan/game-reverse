package com.bytedance.ms.xr.x;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static void ms(File file, String str, boolean z) throws Throwable {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        file.getParentFile().mkdirs();
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, z);
            try {
                fileOutputStream2.write(str.getBytes());
                fileOutputStream2.flush();
                c.ms(fileOutputStream2);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                c.ms(fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.delete();
    }

    public static boolean ms(File file) {
        return file.exists() && file.delete();
    }

    public static String ms(String str, String str2) throws Throwable {
        BufferedReader bufferedReader = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    String line = bufferedReader2.readLine();
                    if (line != null) {
                        sb.append(line);
                        if (str2 != null) {
                            sb.append(str2);
                        }
                    } else {
                        c.ms(bufferedReader2);
                        return sb.toString();
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    c.ms(bufferedReader);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String xr(String str) throws IOException {
        return ms(str, null);
    }

    public static com.bytedance.ms.xr.ah.ah ah(String str) {
        try {
            JSONObject jSONObject = new JSONObject(xr(str));
            com.bytedance.ms.xr.ah.ah ahVar = new com.bytedance.ms.xr.ah.ah();
            ahVar.ms(jSONObject.optString("url"));
            ahVar.ms(jSONObject.optJSONObject("body"));
            ahVar.xr(jSONObject.optString("dump_file"));
            ahVar.ms(jSONObject.optBoolean("encrypt", false));
            return ahVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String ms(File file, String str, String str2, JSONObject jSONObject, boolean z) {
        return ms(file, str, str2, jSONObject, null, z);
    }

    public static String ms(File file, String str, String str2, JSONObject jSONObject, String str3, boolean z) throws Throwable {
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("url", str2);
            jSONObject2.put("body", jSONObject);
            if (str3 == null) {
                str3 = "";
            }
            jSONObject2.put("dump_file", str3);
            jSONObject2.put("encrypt", z);
            ms(file2, jSONObject2.toString(), false);
        } catch (IOException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        } catch (JSONException e2) {
            com.bytedance.sdk.component.utils.sl.ms(e2);
        }
        return file2.getAbsolutePath();
    }

    public static void ms(Context context, String str, String str2) throws Throwable {
        try {
            StringBuilder sbAppend = new StringBuilder().append(System.currentTimeMillis()).append(" ");
            if (str == null) {
                str = AbstractJsonLexerKt.NULL;
            }
            StringBuilder sbAppend2 = sbAppend.append(str).append(" ");
            if (str2 == null) {
                str2 = AbstractJsonLexerKt.NULL;
            }
            ms(x.xr(context), sbAppend2.append(str2).append("\n").toString(), true);
        } catch (IOException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
    }
}
