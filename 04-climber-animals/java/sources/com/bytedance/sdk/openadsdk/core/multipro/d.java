package com.bytedance.sdk.openadsdk.core.multipro;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.component.utils.h;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.t.u;
import com.bytedance.sdk.openadsdk.op.ab;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileLock;
import java.util.Arrays;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static void ms(final Context context) {
        if (context == null) {
            return;
        }
        SSWebView.d = new com.bytedance.sdk.component.widget.ms() { // from class: com.bytedance.sdk.openadsdk.core.multipro.d.1
            @Override // com.bytedance.sdk.component.widget.ms
            public void ms(String str, Throwable th) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("threadName", str);
                    jSONObject.put("record", Arrays.toString(th.getStackTrace()));
                } catch (Exception unused) {
                }
                u.ms().ms("webview_init_failed", jSONObject, th);
            }
        };
        com.bytedance.sdk.component.ab.ah.ms(context.getApplicationContext());
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                if (h.ms(context)) {
                    ab.ms(new ny("tt_webview_file_path") { // from class: com.bytedance.sdk.openadsdk.core.multipro.d.2
                        @Override // java.lang.Runnable
                        public void run() throws Throwable {
                            d.ah(context);
                        }
                    });
                    return;
                }
                String strXr = h.xr(context);
                try {
                    if (TextUtils.isEmpty(strXr)) {
                        strXr = context.getPackageName() + Process.myPid();
                    }
                    WebView.setDataDirectorySuffix(strXr);
                } catch (IllegalStateException unused) {
                    ms(strXr);
                } catch (Exception unused2) {
                }
            }
        } catch (Throwable th) {
            sl.xr(th.getMessage());
        }
    }

    private static void ms(String str) {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            declaredMethod2.setAccessible(true);
            Class cls = (Class) declaredMethod.invoke(null, "android.webkit.WebViewFactory");
            Field field = (Field) declaredMethod2.invoke(cls, "sDataDirectorySuffix");
            field.setAccessible(true);
            if (TextUtils.isEmpty((String) field.get(cls))) {
                field.set(cls, str);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ah(Context context) throws Throwable {
        RandomAccessFile randomAccessFile;
        Throwable th;
        String strMs = ms();
        File file = new File(com.bytedance.sdk.openadsdk.api.plugin.xr.ms(context, TextUtils.isEmpty(strMs) ? "webview" : "webview_".concat(String.valueOf(strMs)), 0).getPath(), "webview_data.lock");
        sl.ms("TTMultiInitHelper", file.getAbsolutePath());
        if (!file.exists()) {
            return;
        }
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    FileLock fileLockTryLock = randomAccessFile.getChannel().tryLock();
                    if (fileLockTryLock != null) {
                        fileLockTryLock.close();
                    } else {
                        ms(file, file.delete());
                    }
                    com.bytedance.sdk.component.c.ah.ah.xr.ms(randomAccessFile);
                } catch (Exception unused) {
                    randomAccessFile2 = randomAccessFile;
                    ms(file, file.exists() ? file.delete() : false);
                    com.bytedance.sdk.component.c.ah.ah.xr.ms(randomAccessFile2);
                } catch (Throwable th2) {
                    th = th2;
                    com.bytedance.sdk.component.c.ah.ah.xr.ms(randomAccessFile);
                    throw th;
                }
            } catch (Exception unused2) {
            }
        } catch (Throwable th3) {
            randomAccessFile = randomAccessFile2;
            th = th3;
        }
    }

    private static void ms(File file, boolean z) {
        if (!z || file.exists()) {
            return;
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            sl.ms(e);
        }
    }

    private static String ms() {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            declaredMethod2.setAccessible(true);
            Class cls = (Class) declaredMethod.invoke(null, "android.webkit.WebViewFactory");
            return (String) ((Field) declaredMethod2.invoke(cls, "sDataDirectorySuffix")).get(cls);
        } catch (Throwable unused) {
            return null;
        }
    }
}
