package com.byazt.yw;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_RATIO, 5})
public class q {
    public static void n(File file, String str, boolean z) throws Throwable {
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
                w.n(fileOutputStream2);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                w.n(fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean n(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.delete();
    }

    public static boolean n(File file) {
        return file.exists() && file.delete();
    }

    public static String n(String str, String str2) throws Throwable {
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
                        w.n(bufferedReader2);
                        return sb.toString();
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    w.n(bufferedReader);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String qg(String str) throws IOException {
        return n(str, null);
    }

    public static com.byazt.ub.s s(String str) {
        try {
            JSONObject jSONObject = new JSONObject(qg(str));
            com.byazt.ub.s sVar = new com.byazt.ub.s();
            sVar.n(jSONObject.optString(ImagesContract.URL));
            sVar.n(jSONObject.optJSONObject("body"));
            sVar.qg(jSONObject.optString("dump_file"));
            sVar.n(jSONObject.optBoolean("encrypt", false));
            return sVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String n(File file, String str, String str2, JSONObject jSONObject, boolean z) {
        return n(file, str, str2, jSONObject, null, z);
    }

    public static String n(File file, String str, String str2, JSONObject jSONObject, String str3, boolean z) {
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(ImagesContract.URL, str2);
            jSONObject2.put("body", jSONObject);
            if (str3 == null) {
                str3 = "";
            }
            jSONObject2.put("dump_file", str3);
            jSONObject2.put("encrypt", z);
            n(file2, jSONObject2.toString(), false);
        } catch (IOException | JSONException unused) {
        }
        return file2.getAbsolutePath();
    }

    public static void n(Context context, String str, String str2) throws Throwable {
        try {
            StringBuilder sbAppend = new StringBuilder().append(System.currentTimeMillis()).append(" ");
            if (str == null) {
                str = AbstractJsonLexerKt.NULL;
            }
            StringBuilder sbAppend2 = sbAppend.append(str).append(" ");
            if (str2 == null) {
                str2 = AbstractJsonLexerKt.NULL;
            }
            n(fs.qg(context), sbAppend2.append(str2).append("\n").toString(), true);
        } catch (IOException unused) {
        }
    }
}
