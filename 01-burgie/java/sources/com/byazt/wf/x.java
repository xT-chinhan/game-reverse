package com.byazt.wf;

import android.content.Context;
import android.text.TextUtils;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 201, 121})
public class x {
    public static void pr(File file, String str, boolean z) throws Throwable {
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
                uc.pr(fileOutputStream2);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                uc.pr(fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.delete();
    }

    public static boolean pr(File file) {
        return file.exists() && file.delete();
    }

    public static String pr(String str, String str2) throws Throwable {
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
                        uc.pr(bufferedReader2);
                        return sb.toString();
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    uc.pr(bufferedReader);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String hw(String str) throws IOException {
        return pr(str, null);
    }

    public static com.byazt.lee.hn hn(String str) {
        try {
            JSONObject jSONObject = new JSONObject(hw(str));
            com.byazt.lee.hn hnVar = new com.byazt.lee.hn();
            hnVar.pr(jSONObject.optString(BreakpointSQLiteKey.URL));
            hnVar.pr(jSONObject.optJSONObject("body"));
            hnVar.hw(jSONObject.optString("dump_file"));
            hnVar.pr(jSONObject.optBoolean("encrypt", false));
            return hnVar;
        } catch (Throwable th) {
            return null;
        }
    }

    public static String pr(File file, String str, String str2, JSONObject jSONObject, boolean z) {
        return pr(file, str, str2, jSONObject, null, z);
    }

    public static String pr(File file, String str, String str2, JSONObject jSONObject, String str3, boolean z) throws Throwable {
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(BreakpointSQLiteKey.URL, str2);
            jSONObject2.put("body", jSONObject);
            if (str3 == null) {
                str3 = "";
            }
            jSONObject2.put("dump_file", str3);
            jSONObject2.put("encrypt", z);
            pr(file2, jSONObject2.toString(), false);
        } catch (IOException e) {
        } catch (JSONException e2) {
        }
        return file2.getAbsolutePath();
    }

    public static void pr(Context context, String str, String str2) throws Throwable {
        try {
            StringBuilder sbAppend = new StringBuilder().append(System.currentTimeMillis()).append(" ");
            if (str == null) {
                str = AbstractJsonLexerKt.NULL;
            }
            StringBuilder sbAppend2 = sbAppend.append(str).append(" ");
            if (str2 == null) {
                str2 = AbstractJsonLexerKt.NULL;
            }
            pr(zo.hw(context), sbAppend2.append(str2).append("\n").toString(), true);
        } catch (IOException e) {
        }
    }
}
