package com.byazt.iy;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.webkit.WebView;
import com.byazt.ca.ho;
import com.byazt.fj.SSWebView;
import com.byazt.xlm.fw;
import com.byazt.zp.zo;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileLock;
import java.util.Arrays;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1110, 121})
public class x {
    public static void pr(final Context context) {
        if (context == null) {
            return;
        }
        SSWebView.x = new com.byazt.fj.pr() { // from class: com.byazt.iy.x.1
            @Override // com.byazt.fj.pr
            public void pr(String str, Throwable th) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("threadName", str);
                    jSONObject.put("record", Arrays.toString(th.getStackTrace()));
                } catch (Exception e) {
                }
                com.byazt.xk.hw.pr().pr("webview_init_failed", jSONObject, th);
            }
        };
        com.byazt.to.hn.pr(context.getApplicationContext());
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                com.byazt.vkw.c cVar = (com.byazt.vkw.c) com.byazt.zs.uc.pr("app_process");
                if (cVar.pr()) {
                    zo.pr(new fw("tt_webview_file_path") { // from class: com.byazt.iy.x.2
                        @Override // java.lang.Runnable
                        public void run() throws Throwable {
                            x.hn(context);
                        }
                    });
                    return;
                }
                String strHw = cVar.hw();
                try {
                    if (TextUtils.isEmpty(strHw)) {
                        strHw = context.getPackageName() + Process.myPid();
                    }
                    WebView.setDataDirectorySuffix(strHw);
                } catch (IllegalStateException e) {
                    pr(strHw);
                } catch (Exception e2) {
                }
            }
        } catch (Throwable th) {
            ho.pr(th.getMessage());
        }
    }

    private static void pr(String str) {
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
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hn(Context context) throws Throwable {
        RandomAccessFile randomAccessFile;
        Throwable th;
        String strPr = pr();
        File file = new File(com.byazt.mg.hw.pr(context, TextUtils.isEmpty(strPr) ? "webview" : "webview_".concat(String.valueOf(strPr)), 0).getPath(), "webview_data.lock");
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
                    if (fileLockTryLock == null) {
                        pr(file, file.delete());
                    } else if (Build.VERSION.SDK_INT >= 19) {
                        fileLockTryLock.close();
                    }
                    com.byazt.cb.hw.pr(randomAccessFile);
                } catch (Exception e) {
                    randomAccessFile2 = randomAccessFile;
                    pr(file, file.exists() ? file.delete() : false);
                    com.byazt.cb.hw.pr(randomAccessFile2);
                } catch (Throwable th2) {
                    th = th2;
                    com.byazt.cb.hw.pr(randomAccessFile);
                    throw th;
                }
            } catch (Throwable th3) {
                randomAccessFile = null;
                th = th3;
            }
        } catch (Exception e2) {
        }
    }

    private static void pr(File file, boolean z) {
        if (z && !file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
            }
        }
    }

    private static String pr() {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            declaredMethod2.setAccessible(true);
            Class cls = (Class) declaredMethod.invoke(null, "android.webkit.WebViewFactory");
            return (String) ((Field) declaredMethod2.invoke(cls, "sDataDirectorySuffix")).get(cls);
        } catch (Throwable th) {
            return null;
        }
    }
}
