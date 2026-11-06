package com.byazt.gc;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.byazt.auw.DownloadInfo;
import com.byazt.ca.ho;
import com.byazt.ca.yb;
import com.byazt.hcx.aj;
import com.byazt.hcx.m;
import com.byazt.is.vk;
import com.byazt.lhc.BaseException;
import com.byazt.mg.PluginConstants;
import com.byazt.sd.a;
import com.byazt.sd.iu;
import com.byazt.sd.zo;
import com.byazt.vkw.b;
import com.byazt.vkw.g;
import com.byazt.xlm.c;
import com.byazt.xlm.fw;
import com.byazt.zs.uc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEBUG_UI_NOTIFY, 20})
public class hn {
    public static long aj;
    public static long zo;
    public Function<SparseArray<Object>, Object> uc;
    public FileOutputStream x;
    public static final String pr = File.separator + "next";
    public static final String hw = File.separator + "tmp";
    public static final String hn = File.separator + "conf";
    public static final hn c = new hn();
    public static final HashMap<String, String> fw = new HashMap<>();

    private hn() {
    }

    public static hn pr() {
        return c;
    }

    public void pr(final JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        final Context applicationContext = a.getContext().getApplicationContext();
        c.hw(new fw("updatePlugin") { // from class: com.byazt.gc.hn.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    hn.this.pr(applicationContext, (List<C0075hn>) hn.hn(jSONArray));
                } catch (Throwable th) {
                }
            }
        });
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:13:0x0027  */
    private boolean pr(int i, String str) {
        int iPr = zo.nt().b().pr(str);
        if (zo.nt().ii()) {
            return pr(iPr);
        }
        switch (i) {
            case -1:
                i = iPr;
                return pr(i);
            case 0:
            default:
                if (iPr == 3) {
                    i = 1;
                } else {
                    i = iPr;
                }
                return pr(i);
            case 1:
            case 2:
            case 3:
                return pr(i);
            case 4:
            case 5:
                return false;
        }
    }

    private boolean pr(int i) {
        switch (i) {
            case 1:
                if (!yb.x(a.getContext())) {
                    return false;
                }
                return true;
            case 2:
            default:
                return true;
            case 3:
                return false;
            case 4:
            case 5:
                return false;
        }
    }

    public void pr(Function<SparseArray<Object>, Object> function) {
        this.uc = function;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(final Context context, List<C0075hn> list) throws Throwable {
        synchronized ("__tt_pl_up_lock__") {
            try {
                try {
                    try {
                        if (!pr(context)) {
                            hw(context);
                            return;
                        }
                        final boolean zHn = hn();
                        com.byazt.vkw.c cVar = (com.byazt.vkw.c) uc.pr("app_process");
                        if (zHn && !cVar.pr()) {
                            hw(context);
                            return;
                        }
                        list.size();
                        final CountDownLatch countDownLatch = new CountDownLatch(list.size());
                        for (final C0075hn c0075hn : list) {
                            try {
                                try {
                                    if (pr(c0075hn)) {
                                        countDownLatch.countDown();
                                    } else {
                                        c.hw(new fw("pl download") { // from class: com.byazt.gc.hn.2
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                hn.this.pr(context, c0075hn, false, zHn);
                                                countDownLatch.countDown();
                                            }
                                        });
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    com.byazt.xk.hw.pr().pr("", 7714, 0, "", 14, e.getMessage(), 0L, false, false, false, false, 0);
                                    hw(context);
                                }
                            } catch (Throwable th) {
                                th = th;
                                hw(context);
                                throw th;
                            }
                        }
                        countDownLatch.await();
                        b bVar = (b) uc.pr("m_s");
                        if (bVar != null) {
                            bVar.pr(0, 64, false);
                        }
                        hw(context);
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception e2) {
                e = e2;
            } catch (Throwable th4) {
                th = th4;
                hw(context);
                throw th;
            }
            com.byazt.xk.hw.pr().pr("", 7714, 0, "", 14, e.getMessage(), 0L, false, false, false, false, 0);
            hw(context);
        }
    }

    private boolean pr(Context context) {
        try {
            File fileX = x(context);
            if (!fileX.exists()) {
                fileX.mkdirs();
            }
            File file = new File(fileX, "update.lock");
            if (!file.exists()) {
                file.createNewFile();
            }
            if (!file.exists()) {
                return false;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            this.x = fileOutputStream;
            FileLock fileLockTryLock = fileOutputStream.getChannel().tryLock();
            if (fileLockTryLock != null && fileLockTryLock.isValid()) {
                return true;
            }
            this.x.close();
            return false;
        } catch (Throwable th) {
            FileOutputStream fileOutputStream2 = this.x;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e) {
                }
            }
            return false;
        }
    }

    private void hw(Context context) {
        FileOutputStream fileOutputStream = this.x;
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Exception e) {
            }
        }
        File fileX = x(context);
        if (fileX.exists()) {
            for (File file : fileX.listFiles()) {
                try {
                    if (!"update.lock".equals(file.getName())) {
                        file.delete();
                    }
                } catch (Exception e2) {
                }
            }
        }
    }

    private boolean pr(C0075hn c0075hn) {
        String str = c0075hn == null ? null : c0075hn.pr;
        return !TextUtils.isEmpty(str) && str.equalsIgnoreCase("com.byted.pangle") && com.byazt.mp.hn.pr().zo() == 2;
    }

    private static File hn(Context context) {
        return com.byazt.mg.hw.pr(context, "tt_pangle_bykv_file", 0);
    }

    private static File x(Context context) {
        return new File(hn(context), hw);
    }

    private static File c(Context context) {
        return new File(hn(context), pr);
    }

    private static File uc(Context context) {
        return new File(hn(context), hn);
    }

    private static boolean hw(C0075hn c0075hn) {
        return "com.byted.pangle".equals(c0075hn.pr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(Context context, C0075hn c0075hn, boolean z, boolean z2) {
        int i;
        String str;
        boolean z3;
        pr prVar = new pr(0);
        if (!pr(c0075hn.vk, c0075hn.pr)) {
            i = 20;
            str = zo.nt().b() + ":" + c0075hn.vk;
        } else {
            File fileX = x(context);
            if (z2) {
                prVar = pr(context, fileX, c0075hn);
            } else {
                prVar = pr(context, fileX, c0075hn, z, z2);
            }
            i = prVar.pr;
            str = "";
        }
        if (i == 9 || i == 14) {
            pr(c0075hn.pr, 1004);
            z3 = false;
        } else {
            z3 = true;
        }
        com.byazt.xk.hw.pr().pr(c0075hn.pr, hw(c0075hn) ? 7714 : 0, c0075hn.hw, c0075hn.x, i, str, aj - zo, z, ((Boolean) x(c0075hn).second).booleanValue(), prVar.hn, z2, prVar.x);
        if (z3) {
            pr(c0075hn, prVar.pr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(C0075hn c0075hn, int i) {
        if (this.uc != null && hw(c0075hn, i)) {
            SparseArray<Object> sparseArrayHw = com.byazt.xi.hw.pr().pr(2, c0075hn.toString()).pr(3, c0075hn.pr).hw();
            boolean z = i == 6 || i == 10 || i == 16;
            try {
                Object objApply = this.uc.apply(com.byazt.xi.hw.pr().pr(1).pr(SparseArray.class).pr(-99999979, com.byazt.xi.hn.pr().pr(z).pr(z ? 0 : 1004).pr(sparseArrayHw).hw()).hw());
                PluginValueSet pluginValueSetHw = null;
                if (objApply instanceof SparseArray) {
                    pluginValueSetHw = com.byazt.ij.pr.pr((SparseArray<Object>) objApply).hw();
                }
                if (pluginValueSetHw != null && pluginValueSetHw.booleanValue(4) && c0075hn.w != null) {
                    HashMap<String, String> map = fw;
                    map.put(c0075hn.pr, new File(c0075hn.w).getName());
                    pr(c0075hn.pr, c0075hn.hn);
                    map.values();
                }
                if (c0075hn.pr.equals("com.byted.csj.ext")) {
                    com.byazt.ba.x.pr();
                }
            } catch (Exception e) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("plugin_name", c0075hn.pr);
                    jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, c0075hn.hw);
                    jSONObject.put("plugin_url", c0075hn.x);
                    jSONObject.put("plugin_result", i);
                } catch (Throwable th) {
                }
                com.byazt.xk.hw.pr().pr("pl_install", jSONObject, e);
                ho.pr("PluginUpdater", "Download pl done, but install error:" + e.getMessage());
            }
        }
    }

    private boolean hw(C0075hn c0075hn, int i) {
        hw(c0075hn);
        return (i == 21 || i == 18) ? false : true;
    }

    private static void pr(String str, String str2) {
        if (str == null) {
            return;
        }
        zo.nt().pr(str, str2);
    }

    private pr pr(Context context, File file, final C0075hn c0075hn) {
        if (c0075hn != null) {
            try {
                if (!TextUtils.isEmpty(c0075hn.x)) {
                    if (TextUtils.isEmpty(c0075hn.pr)) {
                        return new pr(12);
                    }
                    if (!hw(c0075hn) && !zo.nt().e().has(c0075hn.pr)) {
                        return new pr(17);
                    }
                    final Pair<Boolean, Boolean> pairX = x(c0075hn);
                    if (((Boolean) pairX.first).booleanValue()) {
                        return new pr(18);
                    }
                    if (hw(c0075hn.hw)) {
                        return new pr(21);
                    }
                    if (!hn(c0075hn)) {
                        return new pr(19);
                    }
                    final File fileUc = uc(context);
                    if (!fileUc.exists()) {
                        fileUc.mkdirs();
                    }
                    if (hw(c0075hn) && iu.x >= c0075hn.hw) {
                        String str = "-" + com.byazt.ca.c.hw(c0075hn.pr) + "-" + iu.x + "-" + iu.x;
                        c0075hn.aj = iu.x;
                        c0075hn.zo = iu.x;
                        c0075hn.fw = true;
                        pr(new File(fileUc, str + ".conf"), c0075hn);
                        return new pr(10);
                    }
                    if (TextUtils.isEmpty(c0075hn.c) && !c0075hn.pr()) {
                        return new pr(1);
                    }
                    final String strHw = com.byazt.ca.c.hw(c0075hn.pr);
                    StringBuilder sb = new StringBuilder();
                    String strHw2 = com.byazt.ca.c.hw(c0075hn.c);
                    if (!TextUtils.isEmpty(strHw2)) {
                        sb.append(strHw2).append("-");
                    }
                    sb.append(strHw).append("-").append(c0075hn.zo).append("-").append(c0075hn.aj);
                    String string = sb.toString();
                    final File fileC = c(context);
                    if (!fileC.exists()) {
                        fileC.mkdirs();
                    }
                    final File file2 = new File(fileC, string + (c0075hn.pr() ? ".dex.zip" : ".apk"));
                    if (file2.exists()) {
                        c0075hn.uc = com.byazt.ca.c.pr(file2);
                        c0075hn.w = file2.getAbsolutePath();
                        return new pr(16);
                    }
                    if (file2.getName().equals(fw.get(c0075hn.pr))) {
                        return new pr(21);
                    }
                    final int i = hw(c0075hn) ? 7714 : 0;
                    Object obj = pairX.second;
                    final File file3 = new File(file, string);
                    zo = System.currentTimeMillis();
                    final CountDownLatch countDownLatch = new CountDownLatch(1);
                    final hw hwVar = new hw();
                    new com.byazt.gc.pr(c0075hn.pr, c0075hn.x, file.getAbsolutePath(), string, c0075hn.vk == 1, new com.byazt.gc.pr.InterfaceC0076pr() { // from class: com.byazt.gc.hn.3
                        public long k = 0;

                        @Override // com.byazt.gc.pr.InterfaceC0076pr
                        public void pr(DownloadInfo downloadInfo) {
                            hwVar.pr(com.byazt.tuy.uc.uc(downloadInfo) > 0);
                            com.byazt.xk.hw.pr().pr(c0075hn.pr, i, c0075hn.hw, c0075hn.x, 7, "", 0L, false, ((Boolean) pairX.second).booleanValue(), hwVar.x(), true, 1);
                            com.byazt.xk.hw.hn(c0075hn.pr, String.valueOf(c0075hn.hw));
                        }

                        @Override // com.byazt.gc.pr.InterfaceC0076pr
                        public void pr(DownloadInfo downloadInfo, BaseException baseException) {
                            long unused = hn.aj = System.currentTimeMillis();
                            hwVar.pr(9);
                            hwVar.hw(1);
                            hwVar.pr(baseException.getErrorCode() + " : " + (baseException.getErrorMessage() == null ? "" : baseException.getErrorMessage()));
                            countDownLatch.countDown();
                        }

                        @Override // com.byazt.gc.pr.InterfaceC0076pr
                        public void hw(DownloadInfo downloadInfo) {
                            hwVar.pr(hn.this.pr(file3, fileUc, file2, fileC, strHw, c0075hn));
                            hwVar.hw(1);
                            if (hwVar.c()) {
                                hn.this.pr(c0075hn, hwVar.hw());
                            }
                            countDownLatch.countDown();
                        }

                        @Override // com.byazt.gc.pr.InterfaceC0076pr
                        public void pr(DownloadInfo downloadInfo, int i2) {
                            int iPr = hn.this.pr(file3, fileUc, file2, fileC, strHw, c0075hn);
                            com.byazt.xk.hw.pr().pr(c0075hn.pr, i, c0075hn.hw, c0075hn.x, 6, "", System.currentTimeMillis() - this.k, false, ((Boolean) pairX.second).booleanValue(), hwVar.x(), true, i2);
                            hn.this.pr(c0075hn, iPr);
                        }

                        @Override // com.byazt.gc.pr.InterfaceC0076pr
                        public void hw(DownloadInfo downloadInfo, int i2) {
                            this.k = System.currentTimeMillis();
                            com.byazt.xk.hw.pr().pr(c0075hn.pr, i, c0075hn.hw, c0075hn.x, 7, "", 0L, false, ((Boolean) pairX.second).booleanValue(), hwVar.x(), true, i2);
                        }

                        @Override // com.byazt.gc.pr.InterfaceC0076pr
                        public void pr(DownloadInfo downloadInfo, BaseException baseException, int i2) {
                            com.byazt.xk.hw.pr().pr(c0075hn.pr, i, c0075hn.hw, c0075hn.x, 9, baseException.getErrorCode() + " : " + (baseException.getErrorMessage() == null ? "" : baseException.getErrorMessage()), System.currentTimeMillis() - this.k, false, ((Boolean) pairX.second).booleanValue(), hwVar.x(), true, i2);
                        }
                    }).pr(context);
                    try {
                        hwVar.hw(!countDownLatch.await(600L, TimeUnit.SECONDS));
                    } catch (InterruptedException e) {
                        hwVar.pr(9);
                        hwVar.pr("countDownLatch interrupted: " + e.getMessage());
                    }
                    if (hwVar.c()) {
                        hwVar.pr(9);
                        hwVar.pr("countDownLatch timeout");
                    }
                    return new pr(hwVar.hw(), hwVar.hn(), hwVar.x(), hwVar.pr());
                }
            } catch (Exception e2) {
                String message = e2.getMessage();
                try {
                    message = Log.getStackTraceString(e2);
                } catch (Throwable th) {
                }
                return new pr(14, message, false, 0);
            }
        }
        return new pr(2);
    }

    private pr pr(Context context, File file, C0075hn c0075hn, boolean z, boolean z2) {
        m mVarPr;
        if (c0075hn != null) {
            try {
                if (!TextUtils.isEmpty(c0075hn.x)) {
                    if (TextUtils.isEmpty(c0075hn.pr)) {
                        return new pr(12);
                    }
                    if (!hw(c0075hn) && !zo.nt().e().has(c0075hn.pr)) {
                        return new pr(17);
                    }
                    Pair<Boolean, Boolean> pairX = x(c0075hn);
                    if (((Boolean) pairX.first).booleanValue()) {
                        return new pr(18);
                    }
                    if (hw(c0075hn.hw)) {
                        return new pr(21);
                    }
                    if (!hn(c0075hn)) {
                        return new pr(19);
                    }
                    File fileUc = uc(context);
                    if (!fileUc.exists()) {
                        fileUc.mkdirs();
                    }
                    if (hw(c0075hn) && iu.x >= c0075hn.hw) {
                        String str = "-" + com.byazt.ca.c.hw(c0075hn.pr) + "-" + iu.x + "-" + iu.x;
                        c0075hn.aj = iu.x;
                        c0075hn.zo = iu.x;
                        c0075hn.fw = true;
                        pr(new File(fileUc, str + ".conf"), c0075hn);
                        return new pr(10);
                    }
                    if (TextUtils.isEmpty(c0075hn.c) && !c0075hn.pr()) {
                        return new pr(1);
                    }
                    String strHw = com.byazt.ca.c.hw(c0075hn.pr);
                    StringBuilder sb = new StringBuilder();
                    String strHw2 = com.byazt.ca.c.hw(c0075hn.c);
                    if (!TextUtils.isEmpty(strHw2)) {
                        sb.append(strHw2).append("-");
                    }
                    sb.append(strHw).append("-").append(c0075hn.zo).append("-").append(c0075hn.aj);
                    String string = sb.toString();
                    File fileC = c(context);
                    if (!fileC.exists()) {
                        fileC.mkdirs();
                    }
                    File file2 = new File(fileC, string + (c0075hn.pr() ? ".dex.zip" : ".apk"));
                    if (file2.exists()) {
                        c0075hn.uc = com.byazt.ca.c.pr(file2);
                        c0075hn.w = file2.getAbsolutePath();
                        return new pr(16);
                    }
                    if (file2.getName().equals(fw.get(c0075hn.pr))) {
                        return new pr(21);
                    }
                    int i = hw(c0075hn) ? 7714 : 0;
                    Object obj = pairX.second;
                    File file3 = new File(file, string);
                    zo = System.currentTimeMillis();
                    String absolutePath = file.getAbsolutePath();
                    boolean zHw = hw(absolutePath, string);
                    com.byazt.xk.hw.pr().pr(c0075hn.pr, i, c0075hn.hw, c0075hn.x, 7, "", 0L, z, ((Boolean) pairX.second).booleanValue(), zHw, false, 0);
                    com.byazt.xk.hw.hn(c0075hn.pr, String.valueOf(c0075hn.hw));
                    aj ajVarPr = com.byazt.tf.hn.pr(c0075hn.x, absolutePath, string);
                    if (vk.pr(c0075hn.pr)) {
                        mVarPr = pr(ajVarPr, c0075hn.pr);
                    } else {
                        mVarPr = ajVarPr.pr();
                    }
                    if (mVarPr != null && mVarPr.fw()) {
                        return new pr(pr(file3, fileUc, file2, fileC, strHw, c0075hn), "", zHw, 0);
                    }
                    aj = System.currentTimeMillis();
                    return new pr(9, mVarPr != null ? mVarPr.pr() + " : " + mVarPr.hw() : "no response", zHw, 0);
                }
            } catch (Exception e) {
                if (!z2) {
                    pr(context, c0075hn);
                }
                String message = e.getMessage();
                try {
                    message = Log.getStackTraceString(e);
                } catch (Throwable th) {
                }
                return new pr(14, message, false, 0);
            }
        }
        return new pr(2);
    }

    private boolean hw(String str, String str2) {
        File file = new File(str, str2 + ".temp");
        return file.exists() && file.length() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int pr(File file, File file2, File file3, File file4, String str, C0075hn c0075hn) {
        aj = System.currentTimeMillis();
        if (!file.exists()) {
            return 13;
        }
        pr(file4, str);
        pr(file2, str);
        if (file.renameTo(file3)) {
            File file5 = new File(file2, file.getName() + ".conf");
            c0075hn.uc = com.byazt.ca.c.pr(file3);
            c0075hn.w = file3.getAbsolutePath();
            c0075hn.fw = c0075hn.hw < c(c0075hn);
            if (pr(file5, c0075hn)) {
                return 6;
            }
            return 15;
        }
        return 5;
    }

    private static m pr(final aj ajVar, final String str) throws x {
        try {
            return (m) new com.byazt.sp.c.pr(new Callable<m>() { // from class: com.byazt.gc.hn.4
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public m call() {
                    return ajVar.pr();
                }
            }, new com.byazt.sp.c.hw<m>() { // from class: com.byazt.gc.hn.5
                @Override // com.byazt.sp.c.hw
                public boolean pr(m mVar) {
                    if (((g) uc.pr("device_info_new")).pr(0L) == 0 || mVar == null) {
                        return false;
                    }
                    Throwable thW = mVar.w();
                    if (thW != null) {
                        return com.byazt.sp.c.pr(thW);
                    }
                    return com.byazt.sp.c.pr(mVar.pr());
                }

                @Override // com.byazt.sp.c.hw
                public boolean pr(Exception exc) {
                    if (((g) uc.pr("device_info_new")).pr(0L) == 0) {
                        return false;
                    }
                    return exc instanceof NullPointerException;
                }
            }).pr(vk.hw(str)).pr().pr();
        } catch (Exception e) {
            String message = e.getMessage();
            try {
                message = Log.getStackTraceString(e);
            } catch (Throwable th) {
            }
            throw new x(14, message);
        }
    }

    private void pr(final Context context, final C0075hn c0075hn) {
        if (vk.pr(c0075hn.pr) && ((g) uc.pr("device_info_new")).pr(0L) == 0) {
            com.byazt.sp.hn.pr().pr(new com.byazt.sp.hn.hw() { // from class: com.byazt.gc.hn.6
                @Override // com.byazt.sp.hn.hw
                public void pr() throws Exception {
                    hn.this.pr(context, c0075hn, true, false);
                }
            });
        }
    }

    private static boolean hn(C0075hn c0075hn) {
        int iHw;
        JSONObject jSONObjectOptJSONObject;
        if (hw(c0075hn)) {
            iHw = iu.x;
        } else {
            iHw = (!zo.nt().e().has(c0075hn.pr) || (jSONObjectOptJSONObject = zo.nt().e().optJSONObject(c0075hn.pr)) == null) ? 0 : hw(jSONObjectOptJSONObject.optString("sdk_version"));
        }
        return iHw >= c0075hn.zo && iHw <= c0075hn.aj;
    }

    private static Pair<Boolean, Boolean> x(C0075hn c0075hn) {
        if (hw(c0075hn)) {
            return new Pair<>(Boolean.valueOf(7714 == c0075hn.hw), Boolean.FALSE);
        }
        JSONObject jSONObjectOptJSONObject = zo.nt().e().optJSONObject(c0075hn.pr);
        int iHw = jSONObjectOptJSONObject != null ? hw(jSONObjectOptJSONObject.optString(PluginConstants.KEY_PLUGIN_VERSION)) : 0;
        return new Pair<>(Boolean.valueOf(iHw == c0075hn.hw), Boolean.valueOf(iHw != 0));
    }

    private static boolean hw(int i) {
        File filePr = com.byazt.mg.hw.pr(a.getContext());
        if (filePr == null) {
            return false;
        }
        return new File(filePr.getParent() + "/pangle_p/com.byted.pangle/version-" + i).exists();
    }

    private static int c(C0075hn c0075hn) {
        JSONObject jSONObjectOptJSONObject;
        if (hw(c0075hn)) {
            return 7714;
        }
        if (!zo.nt().e().has(c0075hn.pr) || (jSONObjectOptJSONObject = zo.nt().e().optJSONObject(c0075hn.pr)) == null) {
            return 0;
        }
        return hw(jSONObjectOptJSONObject.optString(PluginConstants.KEY_PLUGIN_VERSION));
    }

    private static boolean pr(File file, C0075hn c0075hn) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(c0075hn.toString());
            fileWriter.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private static void pr(File file, final String str) {
        file.listFiles(new FilenameFilter() { // from class: com.byazt.gc.hn.7
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str2) {
                if (str2 != null && str2.contains(str)) {
                    new File(file2, str2).delete();
                    return false;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<C0075hn> hn(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                String strPr = pr(jSONObjectOptJSONObject.optString("package_name"));
                if (!strPr.equals("com.byted.csj.ext") || a.hw().v()) {
                    C0075hn c0075hn = new C0075hn();
                    c0075hn.pr = strPr;
                    c0075hn.hw = jSONObjectOptJSONObject.optInt("version_code");
                    c0075hn.hn = jSONObjectOptJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
                    c0075hn.x = jSONObjectOptJSONObject.optString("download_url");
                    c0075hn.c = jSONObjectOptJSONObject.optString("sign");
                    c0075hn.zo = hw(jSONObjectOptJSONObject.optString("min_version"));
                    c0075hn.aj = hw(jSONObjectOptJSONObject.optString("max_version"));
                    c0075hn.vk = jSONObjectOptJSONObject.optInt("plugin_update_network", -2);
                    arrayList.add(c0075hn);
                }
            }
        }
        Collections.sort(arrayList, new Comparator<C0075hn>() { // from class: com.byazt.gc.hn.8
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
            public int compare(C0075hn c0075hn2, C0075hn c0075hn3) {
                if ("com.byted.pangle".equals(c0075hn2.pr)) {
                    return -1;
                }
                if ("com.byted.pangle".equals(c0075hn3.pr)) {
                    return 1;
                }
                return 0;
            }
        });
        return arrayList;
    }

    public static String hw() {
        String str;
        String strPr = com.byazt.sp.hw.pr();
        if ("arm64-v8a".equals(strPr)) {
            str = "@64";
        } else if ("armeabi-v7a".equals(strPr)) {
            str = "@32";
        } else if (!"armeabi".equals(strPr)) {
            str = "";
        } else {
            str = "@armeabi";
        }
        return "com.byted.live.lite" + str;
    }

    public static String pr(String str) {
        if ("com.byted.live.lite@64".equals(str) || "com.byted.live.lite@32".equals(str) || "com.byted.live.lite@armeabi".equals(str)) {
            return "com.byted.live.lite";
        }
        return str;
    }

    private static int hw(String str) {
        if (str != null) {
            try {
                return Integer.parseInt(str.replace(".", ""));
            } catch (Exception e) {
                return 0;
            }
        }
        return 0;
    }

    public void pr(String str, int i) {
        if (this.uc == null) {
            return;
        }
        this.uc.apply(com.byazt.xi.hw.pr().pr(1).pr(Void.class).pr(-99999979, com.byazt.xi.hn.pr().pr(false).pr(i).pr(com.byazt.xi.hw.pr().pr(3, str).hw()).hw()).hw());
    }

    private boolean hn() {
        JSONObject jSONObjectUv = a.hw().uv();
        if (jSONObjectUv == null) {
            return false;
        }
        return jSONObjectUv.optBoolean("use_downloader", false);
    }

    /* JADX INFO: renamed from: com.byazt.gc.hn$hn, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEBUG_UI_NOTIFY, MediaPlayer.MEDIA_PLAYER_OPTION_CLIP_HEAACV2_FIRSTPTS_PACKET})
    private static final class C0075hn {
        public int aj;
        public String c;
        public boolean fw;
        public String hn;
        public int hw;
        public String pr;
        public String uc;
        public int vk;
        public String w;
        public String x;
        public int zo;

        private C0075hn() {
        }

        public String toString() {
            try {
                return new JSONObject().put("package_name", this.pr).put("version_code", this.hw).put("sign", this.c).put("max_version", this.aj).put("min_version", this.zo).put("is_revert", this.fw).put("md5", this.uc).put("plugin_file", this.w).toString();
            } catch (JSONException e) {
                return "";
            }
        }

        public boolean pr() {
            return TextUtils.equals(this.pr, "com.byted.mixed");
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEBUG_UI_NOTIFY, 1537})
    private static final class x extends Exception {
        public final int pr;

        public x(int i, String str) {
            super(str);
            this.pr = i;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEBUG_UI_NOTIFY, 116})
    static class pr {
        public boolean hn;
        public String hw;
        public int pr;
        public int x;

        public pr(int i, String str, boolean z, int i2) {
            this.hw = "";
            this.hn = false;
            this.x = 0;
            this.pr = i;
            this.hw = str;
            this.hn = z;
            this.x = i2;
        }

        public pr(int i) {
            this(i, "", false, 0);
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEBUG_UI_NOTIFY, 506})
    private static class hw {
        public int c;
        public boolean hn;
        public String hw;
        public int pr;
        public boolean x;

        private hw() {
            this.pr = 0;
            this.hw = "";
            this.hn = false;
            this.x = false;
            this.c = 0;
        }

        public synchronized void pr(int i) {
            this.pr = i;
        }

        public synchronized void pr(String str) {
            this.hw = str;
        }

        public synchronized void pr(boolean z) {
            this.hn = z;
        }

        public synchronized void hw(boolean z) {
            this.x = z;
        }

        public synchronized void hw(int i) {
            this.c = i;
        }

        public synchronized int pr() {
            return this.c;
        }

        public synchronized int hw() {
            return this.pr;
        }

        public synchronized String hn() {
            return this.hw;
        }

        public synchronized boolean x() {
            return this.hn;
        }

        public synchronized boolean c() {
            return this.x;
        }
    }
}
