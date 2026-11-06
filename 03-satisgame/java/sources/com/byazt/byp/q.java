package com.byazt.byp;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.webkit.WebView;
import com.byazt.kfh.SSWebView;
import com.byazt.qit.x;
import com.byazt.tk.k;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileLock;
import java.util.Arrays;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 74, 5})
public class q {
    public static void n(final Context context) {
        if (context == null) {
            return;
        }
        SSWebView.q = new com.byazt.kfh.n() { // from class: com.byazt.byp.q.1
            @Override // com.byazt.kfh.n
            public void n(String str, Throwable th) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("threadName", str);
                    jSONObject.put("record", Arrays.toString(th.getStackTrace()));
                } catch (Exception unused) {
                }
                com.byazt.eji.s.n().n("webview_init_failed", jSONObject, th);
            }
        };
        com.byazt.uyg.s.n(context.getApplicationContext());
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                com.byazt.vf.l lVar = (com.byazt.vf.l) com.byazt.qp.q.n("app_process");
                if (lVar.n()) {
                    com.byazt.ag.qg.n(new x("tt_webview_file_path") { // from class: com.byazt.byp.q.2
                        @Override // java.lang.Runnable
                        public void run() throws Throwable {
                            q.s(context);
                        }
                    });
                    return;
                }
                String strQg = lVar.qg();
                try {
                    if (TextUtils.isEmpty(strQg)) {
                        strQg = context.getPackageName() + Process.myPid();
                    }
                    WebView.setDataDirectorySuffix(strQg);
                } catch (IllegalStateException unused) {
                    n(strQg);
                } catch (Exception unused2) {
                }
            }
        } catch (Throwable th) {
            k.n(th.getMessage());
        }
    }

    private static void n(String str) {
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
    public static void s(Context context) throws Throwable {
        RandomAccessFile randomAccessFile;
        Throwable th;
        String strN = n();
        File file = new File(com.byazt.qyu.qg.n(context, TextUtils.isEmpty(strN) ? "webview" : "webview_".concat(String.valueOf(strN)), 0).getPath(), "webview_data.lock");
        file.getAbsolutePath();
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
                        n(file, file.delete());
                    }
                    com.byazt.wvr.qg.n(randomAccessFile);
                } catch (Exception unused) {
                    randomAccessFile2 = randomAccessFile;
                    n(file, file.exists() ? file.delete() : false);
                    com.byazt.wvr.qg.n(randomAccessFile2);
                } catch (Throwable th2) {
                    th = th2;
                    com.byazt.wvr.qg.n(randomAccessFile);
                    throw th;
                }
            } catch (Exception unused2) {
            }
        } catch (Throwable th3) {
            randomAccessFile = randomAccessFile2;
            th = th3;
        }
    }

    private static void n(File file, boolean z) {
        if (!z || file.exists()) {
            return;
        }
        try {
            file.createNewFile();
        } catch (IOException unused) {
        }
    }

    private static String n() {
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
