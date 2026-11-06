package com.smartdigimkt.c0;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.bykv.vk.component.ttvideo.player.C;
import com.smartdigimkt.r4.a0;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c {
    public static final String a = a0.a("dggRsoxvIodjv");
    public static final String b = a0.a("ghhsOlqn");
    public static final String c = a0.a("snjQdph");
    public static final String d = a0.a("frqwhqw=22frp1klkrqru1lg1urxwhu1urxwhufrqwhqwsurylghu2ghhsolqnVwduwBurxwhDxwkrulw|@frp1klkrqru1ppv1dgv1uhprwh");

    public static Intent a(Intent intent) {
        try {
            Method method = intent.getClass().getMethod(a, Integer.class);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            method.invoke(intent, 131072);
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
            return intent;
        } catch (Throwable unused) {
            try {
                intent.setFlags(805339136);
                return Intent.createChooser(intent, "chooser");
            } catch (Exception unused2) {
                return intent;
            }
        }
    }

    public static boolean a(Context context, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(b, str);
            jSONObject.put(c, str2);
            return a(context, jSONObject.toString());
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a(Context context, String str) {
        try {
            ContentResolver contentResolver = context.getContentResolver();
            if (contentResolver == null) {
                return false;
            }
            try {
                Cursor cursorQuery = contentResolver.query(Uri.parse(d), null, str, null, null, null);
                if (cursorQuery == null) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return false;
                }
                try {
                    Bundle extras = cursorQuery.getExtras();
                    if (extras == null) {
                        cursorQuery.close();
                        return false;
                    }
                    if (extras.getInt("code") == 0) {
                        cursorQuery.close();
                        return true;
                    }
                    extras.getString(NotificationCompat.CATEGORY_MESSAGE);
                    cursorQuery.close();
                    return false;
                } catch (Throwable th) {
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
                th.getMessage();
                return false;
            } catch (Throwable th3) {
                th3.getMessage();
                return false;
            }
        } catch (Throwable th4) {
            th4.getMessage();
            return false;
        }
    }
}
