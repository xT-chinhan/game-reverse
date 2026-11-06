package com.bytedance.sdk.openadsdk.core;

import android.os.Build;
import android.os.Environment;
import android.os.FileObserver;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class cv {
    private static xr c;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static String f2450ms = Environment.DIRECTORY_DCIM;
    private static String xr = Environment.DIRECTORY_PICTURES;
    private static String ah = "Screenshots";
    private static volatile boolean d = false;
    private static volatile boolean ka = false;
    private static long ab = 0;

    private interface ms {
        void ms(String str);
    }

    private static File c() {
        return null;
    }

    public static void ms() {
        if (!ka || d) {
            return;
        }
        try {
            xr();
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.d("ScreenShotObserver", "权限检查出错时,异常代码：" + e);
        }
    }

    public static void xr() {
        ka = true;
        if (!d && re.getContext().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            com.bytedance.sdk.component.ch.ab.d(new com.bytedance.sdk.component.ch.ny("sso") { // from class: com.bytedance.sdk.openadsdk.core.cv.1
                @Override // java.lang.Runnable
                public void run() {
                    cv.ka();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ka() {
        File fileC;
        if (d || (fileC = c()) == null) {
            return;
        }
        c = xr.ms(fileC, new ms() { // from class: com.bytedance.sdk.openadsdk.core.cv.2
            @Override // com.bytedance.sdk.openadsdk.core.cv.ms
            public void ms(String str) {
                long unused = cv.ab = System.currentTimeMillis();
            }
        });
        d = true;
        fileC.exists();
        xr xrVar = c;
        if (xrVar != null) {
            xrVar.startWatching();
        }
    }

    public static long ah() {
        return ab;
    }

    private static final class xr extends FileObserver {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private ms f2451ms;

        private xr(String str, int i, ms msVar) {
            super(str, i);
            this.f2451ms = msVar;
        }

        private xr(File file, int i, ms msVar) {
            super(file, i);
            this.f2451ms = msVar;
        }

        static xr ms(File file, ms msVar) {
            if (file == null || msVar == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 29) {
                return new xr(file, 256, msVar);
            }
            return new xr(file.getAbsolutePath(), 256, msVar);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i, String str) {
            ms msVar = this.f2451ms;
            if (msVar != null) {
                msVar.ms(str);
            }
        }
    }
}
