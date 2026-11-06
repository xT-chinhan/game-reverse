package com.byazt.ph;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.common.d.i;
import com.anythink.core.common.l.f;
import com.byazt.nf.rv;
import com.byazt.nf.tj;
import com.byazt.qit.l;
import com.byazt.qit.x;
import com.byazt.qk.oa;
import com.byazt.qx.BaseException;
import com.byazt.qyu.PluginConstants;
import com.byazt.ta.w;
import com.byazt.tk.hd;
import com.byazt.tk.k;
import com.byazt.vf.fi;
import com.byazt.vf.t;
import com.byazt.wm.DownloadInfo;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.smartdigimkt.sdk.api.SDMAdConst;
import com.taptap.sdk.compilance.constants.ComplianceMessage;
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

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 513, 8})
public class s {
    public static long fs;
    public static long rv;
    public FileOutputStream q;
    public Function<SparseArray<Object>, Object> w;
    public static final String n = File.separator + "next";
    public static final String qg = File.separator + "tmp";
    public static final String s = File.separator + "conf";
    public static final s l = new s();
    public static final HashMap<String, String> x = new HashMap<>();

    private s() {
    }

    public static s n() {
        return l;
    }

    public void n(final JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        final Context applicationContext = rv.getContext().getApplicationContext();
        l.qg(new x("updatePlugin") { // from class: com.byazt.ph.s.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    s.this.n(applicationContext, (List<C0294s>) s.s(jSONArray));
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0033  */
    private boolean n(int i, String str) {
        int iN = com.byazt.vyf.s.cy().h().n(str);
        if (com.byazt.vyf.s.cy().wo()) {
            return n(iN);
        }
        if (i == -1) {
            i = iN;
        } else if (i != 1 && i != 2 && i != 3) {
            if (i == 4 || i == 5) {
                return false;
            }
            if (iN == 3) {
                i = 1;
            } else {
                i = iN;
            }
        }
        return n(i);
    }

    private boolean n(int i) {
        if (i != 1) {
            if (i == 3 || i == 4 || i == 5) {
                return false;
            }
        } else if (!hd.q(rv.getContext())) {
            return false;
        }
        return true;
    }

    public void n(Function<SparseArray<Object>, Object> function) {
        this.w = function;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final Context context, List<C0294s> list) throws Throwable {
        synchronized ("__tt_pl_up_lock__") {
            try {
                try {
                    try {
                        if (!n(context)) {
                            qg(context);
                            return;
                        }
                        final boolean zS = s();
                        com.byazt.vf.l lVar = (com.byazt.vf.l) com.byazt.qp.q.n("app_process");
                        if (zS && !lVar.n()) {
                            qg(context);
                            return;
                        }
                        list.size();
                        final CountDownLatch countDownLatch = new CountDownLatch(list.size());
                        for (final C0294s c0294s : list) {
                            try {
                                try {
                                    if (n(c0294s)) {
                                        countDownLatch.countDown();
                                    } else {
                                        l.qg(new x("pl download") { // from class: com.byazt.ph.s.2
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                s.this.n(context, c0294s, false, zS);
                                                countDownLatch.countDown();
                                            }
                                        });
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    com.byazt.eji.s.n().n("", 7814, 0, "", 14, e.getMessage(), 0L, false, false, false, false, 0);
                                    qg(context);
                                }
                            } catch (Throwable th) {
                                th = th;
                                qg(context);
                                throw th;
                            }
                        }
                        countDownLatch.await();
                        t tVar = (t) com.byazt.qp.q.n(ATAdConst.KEY.M_S);
                        if (tVar != null) {
                            tVar.n(0, 64, false);
                        }
                        qg(context);
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
                qg(context);
                throw th;
            }
            com.byazt.eji.s.n().n("", 7814, 0, "", 14, e.getMessage(), 0L, false, false, false, false, 0);
            qg(context);
        }
    }

    private boolean n(Context context) {
        try {
            File fileQ = q(context);
            if (!fileQ.exists()) {
                fileQ.mkdirs();
            }
            File file = new File(fileQ, "update.lock");
            if (!file.exists()) {
                file.createNewFile();
            }
            if (!file.exists()) {
                return false;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            this.q = fileOutputStream;
            FileLock fileLockTryLock = fileOutputStream.getChannel().tryLock();
            if (fileLockTryLock != null && fileLockTryLock.isValid()) {
                return true;
            }
            this.q.close();
            return false;
        } catch (Throwable unused) {
            FileOutputStream fileOutputStream2 = this.q;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused2) {
                }
            }
            return false;
        }
    }

    private void qg(Context context) {
        FileOutputStream fileOutputStream = this.q;
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Exception unused) {
            }
        }
        File fileQ = q(context);
        if (fileQ.exists()) {
            for (File file : fileQ.listFiles()) {
                try {
                    if (!"update.lock".equals(file.getName())) {
                        file.delete();
                    }
                } catch (Exception unused2) {
                }
            }
        }
    }

    private boolean n(C0294s c0294s) {
        String str = c0294s == null ? null : c0294s.n;
        return !TextUtils.isEmpty(str) && str.equalsIgnoreCase("com.byted.pangle") && com.byazt.ed.qg.n().fs() == 2;
    }

    private static File s(Context context) {
        return com.byazt.qyu.qg.n(context, "tt_pangle_bykv_file", 0);
    }

    private static File q(Context context) {
        return new File(s(context), qg);
    }

    private static File l(Context context) {
        return new File(s(context), n);
    }

    private static File w(Context context) {
        return new File(s(context), s);
    }

    private static boolean qg(C0294s c0294s) {
        return "com.byted.pangle".equals(c0294s.n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:37:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:40:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:42:? A[RETURN, SYNTHETIC] */
    public void n(Context context, C0294s c0294s, boolean z, boolean z2) {
        int i;
        n nVar = new n(0);
        boolean z3 = true;
        String str = "";
        if ("com.byted.live.lite".equals(c0294s.n) && com.byazt.hoz.q.n()) {
            nVar = new n(22);
            i = nVar.n;
        } else if (!n(c0294s.tj, c0294s.n)) {
            str = com.byazt.vyf.s.cy().h() + ":" + c0294s.tj;
            i = 20;
        } else {
            int iQg = qg(c0294s.n);
            if (iQg == 1 || iQg == 0) {
                File fileQ = q(context);
                if (z2) {
                    nVar = n(context, fileQ, c0294s);
                } else {
                    nVar = n(context, fileQ, c0294s, z, z2);
                }
                if (iQg == 0 && qg(c0294s.n) == 2) {
                    nVar = new n(23);
                }
                i = nVar.n;
            } else {
                nVar = new n(22);
                i = nVar.n;
            }
        }
        String str2 = str;
        if (i == 9 || i == 14) {
            n(c0294s.n, 1004);
        } else {
            if (i == 22 || i == 23) {
            }
            com.byazt.eji.s.n().n(c0294s.n, qg(c0294s) ? 7814 : 0, c0294s.qg, c0294s.q, i, str2, rv - fs, z, ((Boolean) q(c0294s).second).booleanValue(), nVar.s, z2, nVar.q);
            if (z3) {
                n(c0294s, nVar.n);
            }
        }
        z3 = false;
        if (qg(c0294s)) {
        }
        com.byazt.eji.s.n().n(c0294s.n, qg(c0294s) ? 7814 : 0, c0294s.qg, c0294s.q, i, str2, rv - fs, z, ((Boolean) q(c0294s).second).booleanValue(), nVar.s, z2, nVar.q);
        if (z3) {
            n(c0294s, nVar.n);
        }
    }

    private int qg(String str) {
        try {
            return ((fi) com.byazt.qp.q.n("strategy")).n(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(C0294s c0294s, int i) {
        if (this.w == null || !qg(c0294s, i)) {
            return;
        }
        SparseArray<Object> sparseArrayQg = com.byazt.of.qg.n().n(2, c0294s.toString()).n(3, c0294s.n).qg();
        boolean z = i == 6 || i == 10 || i == 16;
        try {
            Object objApply = this.w.apply(com.byazt.of.qg.n().n(1).n(SparseArray.class).n(-99999979, com.byazt.of.s.n().n(z).n(z ? 0 : 1004).n(sparseArrayQg).qg()).qg());
            PluginValueSet pluginValueSetQg = objApply instanceof SparseArray ? com.byazt.qvu.n.n((SparseArray<Object>) objApply).qg() : null;
            if (pluginValueSetQg != null && pluginValueSetQg.booleanValue(4) && c0294s.cp != null) {
                HashMap<String, String> map = x;
                map.put(c0294s.n, new File(c0294s.cp).getName());
                n(c0294s.n, c0294s.s);
                map.values();
            }
            if (c0294s.n.equals("com.byted.csj.ext")) {
                com.byazt.gh.q.n();
            }
        } catch (Exception e) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("plugin_name", c0294s.n);
                jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, c0294s.qg);
                jSONObject.put("plugin_url", c0294s.q);
                jSONObject.put("plugin_result", i);
            } catch (Throwable unused) {
            }
            com.byazt.eji.s.n().n("pl_install", jSONObject, e);
            k.n("PluginUpdater", "Download pl done, but install error:" + e.getMessage());
        }
    }

    private boolean qg(C0294s c0294s, int i) {
        qg(c0294s);
        return (i == 21 || i == 18) ? false : true;
    }

    private static void n(String str, String str2) {
        if (str == null) {
            return;
        }
        com.byazt.vyf.s.cy().n(str, str2);
    }

    private n n(Context context, File file, final C0294s c0294s) {
        if (c0294s != null) {
            try {
                if (!TextUtils.isEmpty(c0294s.q)) {
                    if (TextUtils.isEmpty(c0294s.n)) {
                        return new n(12);
                    }
                    if (!qg(c0294s) && !com.byazt.vyf.s.cy().ae().has(c0294s.n)) {
                        return new n(17);
                    }
                    final Pair<Boolean, Boolean> pairQ = q(c0294s);
                    if (((Boolean) pairQ.first).booleanValue()) {
                        return new n(18);
                    }
                    if (qg(c0294s.qg)) {
                        return new n(21);
                    }
                    if (!s(c0294s)) {
                        return new n(19);
                    }
                    final File fileW = w(context);
                    if (!fileW.exists()) {
                        fileW.mkdirs();
                    }
                    if (qg(c0294s) && tj.l >= c0294s.qg) {
                        String str = "-" + com.byazt.tk.l.qg(c0294s.n) + "-" + tj.l + "-" + tj.l;
                        c0294s.rv = tj.l;
                        c0294s.fs = tj.l;
                        c0294s.x = true;
                        n(new File(fileW, str + ".conf"), c0294s);
                        return new n(10);
                    }
                    if (TextUtils.isEmpty(c0294s.l) && !c0294s.n()) {
                        return new n(1);
                    }
                    final String strQg = com.byazt.tk.l.qg(c0294s.n);
                    StringBuilder sb = new StringBuilder();
                    String strQg2 = com.byazt.tk.l.qg(c0294s.l);
                    if (!TextUtils.isEmpty(strQg2)) {
                        sb.append(strQg2).append("-");
                    }
                    sb.append(strQg).append("-").append(c0294s.fs).append("-").append(c0294s.rv);
                    String string = sb.toString();
                    final File fileL = l(context);
                    if (!fileL.exists()) {
                        fileL.mkdirs();
                    }
                    final File file2 = new File(fileL, string + (c0294s.n() ? ".dex.zip" : ".apk"));
                    if (file2.exists()) {
                        c0294s.w = com.byazt.tk.l.n(file2);
                        c0294s.cp = file2.getAbsolutePath();
                        return new n(16);
                    }
                    if (file2.getName().equals(x.get(c0294s.n))) {
                        return new n(21);
                    }
                    final int i = qg(c0294s) ? 7814 : 0;
                    Object obj = pairQ.second;
                    final File file3 = new File(file, string);
                    fs = System.currentTimeMillis();
                    final CountDownLatch countDownLatch = new CountDownLatch(1);
                    final qg qgVar = new qg();
                    new com.byazt.ph.n(c0294s.n, c0294s.q, file.getAbsolutePath(), string, c0294s.tj == 1, new com.byazt.ph.n.InterfaceC0293n() { // from class: com.byazt.ph.s.3
                        public long d = 0;

                        @Override // com.byazt.ph.n.InterfaceC0293n
                        public void n(DownloadInfo downloadInfo) {
                            qgVar.n(w.w(downloadInfo) > 0);
                            com.byazt.eji.s.n().n(c0294s.n, i, c0294s.qg, c0294s.q, 7, "", 0L, false, ((Boolean) pairQ.second).booleanValue(), qgVar.q(), true, 1);
                            com.byazt.eji.s.s(c0294s.n, String.valueOf(c0294s.qg));
                        }

                        @Override // com.byazt.ph.n.InterfaceC0293n
                        public void n(DownloadInfo downloadInfo, BaseException baseException) {
                            long unused = s.rv = System.currentTimeMillis();
                            qgVar.n(9);
                            qgVar.qg(1);
                            qgVar.n(baseException.getErrorCode() + " : " + (baseException.getErrorMessage() == null ? "" : baseException.getErrorMessage()));
                            countDownLatch.countDown();
                        }

                        @Override // com.byazt.ph.n.InterfaceC0293n
                        public void qg(DownloadInfo downloadInfo) {
                            qgVar.n(s.this.n(file3, fileW, file2, fileL, strQg, c0294s));
                            qgVar.qg(1);
                            if (qgVar.l()) {
                                s.this.n(c0294s, qgVar.qg());
                            }
                            countDownLatch.countDown();
                        }

                        @Override // com.byazt.ph.n.InterfaceC0293n
                        public void n(DownloadInfo downloadInfo, int i2) {
                            int iN = s.this.n(file3, fileW, file2, fileL, strQg, c0294s);
                            com.byazt.eji.s.n().n(c0294s.n, i, c0294s.qg, c0294s.q, 6, "", System.currentTimeMillis() - this.d, false, ((Boolean) pairQ.second).booleanValue(), qgVar.q(), true, i2);
                            s.this.n(c0294s, iN);
                        }

                        @Override // com.byazt.ph.n.InterfaceC0293n
                        public void qg(DownloadInfo downloadInfo, int i2) {
                            this.d = System.currentTimeMillis();
                            com.byazt.eji.s.n().n(c0294s.n, i, c0294s.qg, c0294s.q, 7, "", 0L, false, ((Boolean) pairQ.second).booleanValue(), qgVar.q(), true, i2);
                        }

                        @Override // com.byazt.ph.n.InterfaceC0293n
                        public void n(DownloadInfo downloadInfo, BaseException baseException, int i2) {
                            com.byazt.eji.s.n().n(c0294s.n, i, c0294s.qg, c0294s.q, 9, baseException.getErrorCode() + " : " + (baseException.getErrorMessage() == null ? "" : baseException.getErrorMessage()), System.currentTimeMillis() - this.d, false, ((Boolean) pairQ.second).booleanValue(), qgVar.q(), true, i2);
                        }
                    }).n(context);
                    try {
                        qgVar.qg(!countDownLatch.await(600L, TimeUnit.SECONDS));
                    } catch (InterruptedException e) {
                        qgVar.n(9);
                        qgVar.n("countDownLatch interrupted: " + e.getMessage());
                    }
                    if (qgVar.l()) {
                        qgVar.n(9);
                        qgVar.n("countDownLatch timeout");
                    }
                    return new n(qgVar.qg(), qgVar.s(), qgVar.q(), qgVar.n());
                }
            } catch (Exception e2) {
                String message = e2.getMessage();
                try {
                    message = Log.getStackTraceString(e2);
                } catch (Throwable unused) {
                }
                return new n(14, message, false, 0);
            }
        }
        return new n(2);
    }

    private n n(Context context, File file, C0294s c0294s, boolean z, boolean z2) {
        oa oaVarN;
        if (c0294s != null) {
            try {
                if (!TextUtils.isEmpty(c0294s.q)) {
                    if (TextUtils.isEmpty(c0294s.n)) {
                        return new n(12);
                    }
                    if (!qg(c0294s) && !com.byazt.vyf.s.cy().ae().has(c0294s.n)) {
                        return new n(17);
                    }
                    Pair<Boolean, Boolean> pairQ = q(c0294s);
                    if (((Boolean) pairQ.first).booleanValue()) {
                        return new n(18);
                    }
                    if (qg(c0294s.qg)) {
                        return new n(21);
                    }
                    if (!s(c0294s)) {
                        return new n(19);
                    }
                    File fileW = w(context);
                    if (!fileW.exists()) {
                        fileW.mkdirs();
                    }
                    if (qg(c0294s) && tj.l >= c0294s.qg) {
                        String str = "-" + com.byazt.tk.l.qg(c0294s.n) + "-" + tj.l + "-" + tj.l;
                        c0294s.rv = tj.l;
                        c0294s.fs = tj.l;
                        c0294s.x = true;
                        n(new File(fileW, str + ".conf"), c0294s);
                        return new n(10);
                    }
                    if (TextUtils.isEmpty(c0294s.l) && !c0294s.n()) {
                        return new n(1);
                    }
                    String strQg = com.byazt.tk.l.qg(c0294s.n);
                    StringBuilder sb = new StringBuilder();
                    String strQg2 = com.byazt.tk.l.qg(c0294s.l);
                    if (!TextUtils.isEmpty(strQg2)) {
                        sb.append(strQg2).append("-");
                    }
                    sb.append(strQg).append("-").append(c0294s.fs).append("-").append(c0294s.rv);
                    String string = sb.toString();
                    File fileL = l(context);
                    if (!fileL.exists()) {
                        fileL.mkdirs();
                    }
                    File file2 = new File(fileL, string + (c0294s.n() ? ".dex.zip" : ".apk"));
                    if (file2.exists()) {
                        c0294s.w = com.byazt.tk.l.n(file2);
                        c0294s.cp = file2.getAbsolutePath();
                        return new n(16);
                    }
                    if (file2.getName().equals(x.get(c0294s.n))) {
                        return new n(21);
                    }
                    int i = qg(c0294s) ? 7814 : 0;
                    Object obj = pairQ.second;
                    File file3 = new File(file, string);
                    fs = System.currentTimeMillis();
                    String absolutePath = file.getAbsolutePath();
                    boolean zQg = qg(absolutePath, string);
                    com.byazt.eji.s.n().n(c0294s.n, i, c0294s.qg, c0294s.q, 7, "", 0L, z, ((Boolean) pairQ.second).booleanValue(), zQg, false, 0);
                    com.byazt.eji.s.s(c0294s.n, String.valueOf(c0294s.qg));
                    com.byazt.qk.rv rvVarN = com.byazt.phf.s.n(c0294s.q, absolutePath, string);
                    if (com.byazt.ph.q.n(c0294s.n)) {
                        oaVarN = n(rvVarN, c0294s.n);
                    } else {
                        oaVarN = rvVarN.n();
                    }
                    if (oaVarN != null && oaVarN.x()) {
                        return new n(n(file3, fileW, file2, fileL, strQg, c0294s), "", zQg, 0);
                    }
                    rv = System.currentTimeMillis();
                    return new n(9, oaVarN != null ? oaVarN.n() + " : " + oaVarN.qg() : "no response", zQg, 0);
                }
            } catch (Exception e) {
                if (!z2) {
                    n(context, c0294s);
                }
                String message = e.getMessage();
                try {
                    message = Log.getStackTraceString(e);
                } catch (Throwable unused) {
                }
                return new n(14, message, false, 0);
            }
        }
        return new n(2);
    }

    private boolean qg(String str, String str2) {
        File file = new File(str, str2 + ".temp");
        return file.exists() && file.length() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int n(File file, File file2, File file3, File file4, String str, C0294s c0294s) {
        rv = System.currentTimeMillis();
        if (!file.exists()) {
            return 13;
        }
        n(file4, str);
        n(file2, str);
        if (!file.renameTo(file3)) {
            return 5;
        }
        File file5 = new File(file2, file.getName() + ".conf");
        c0294s.w = com.byazt.tk.l.n(file3);
        c0294s.cp = file3.getAbsolutePath();
        c0294s.x = c0294s.qg < l(c0294s);
        return n(file5, c0294s) ? 6 : 15;
    }

    private static oa n(final com.byazt.qk.rv rvVar, final String str) throws q {
        try {
            return (oa) new com.byazt.wl.q.n(new Callable<oa>() { // from class: com.byazt.ph.s.4
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public oa call() {
                    return rvVar.n();
                }
            }, new com.byazt.wl.q.qg<oa>() { // from class: com.byazt.ph.s.5
                @Override // com.byazt.wl.q.qg
                public boolean n(oa oaVar) {
                    if (((com.byazt.vf.oa) com.byazt.qp.q.n("device_info_new")).n(0L) == 0 || oaVar == null) {
                        return false;
                    }
                    Throwable thCp = oaVar.cp();
                    if (thCp != null) {
                        return com.byazt.wl.q.n(thCp);
                    }
                    return com.byazt.wl.q.n(oaVar.n());
                }

                @Override // com.byazt.wl.q.qg
                public boolean n(Exception exc) {
                    if (((com.byazt.vf.oa) com.byazt.qp.q.n("device_info_new")).n(0L) == 0) {
                        return false;
                    }
                    return exc instanceof NullPointerException;
                }
            }).n(com.byazt.ph.q.qg(str)).n().n();
        } catch (Exception e) {
            String message = e.getMessage();
            try {
                message = Log.getStackTraceString(e);
            } catch (Throwable unused) {
            }
            throw new q(14, message);
        }
    }

    private void n(final Context context, final C0294s c0294s) {
        if (com.byazt.ph.q.n(c0294s.n) && ((com.byazt.vf.oa) com.byazt.qp.q.n("device_info_new")).n(0L) == 0) {
            com.byazt.wl.s.n().n(new com.byazt.wl.s.qg() { // from class: com.byazt.ph.s.6
                @Override // com.byazt.wl.s.qg
                public void n() throws Exception {
                    s.this.n(context, c0294s, true, false);
                }
            });
        }
    }

    private static boolean s(C0294s c0294s) {
        int iS;
        JSONObject jSONObjectOptJSONObject;
        if (qg(c0294s)) {
            iS = tj.l;
        } else {
            iS = (!com.byazt.vyf.s.cy().ae().has(c0294s.n) || (jSONObjectOptJSONObject = com.byazt.vyf.s.cy().ae().optJSONObject(c0294s.n)) == null) ? 0 : s(jSONObjectOptJSONObject.optString("sdk_version"));
        }
        return iS >= c0294s.fs && iS <= c0294s.rv;
    }

    private static Pair<Boolean, Boolean> q(C0294s c0294s) {
        if (qg(c0294s)) {
            return new Pair<>(Boolean.valueOf(7814 == c0294s.qg), Boolean.FALSE);
        }
        JSONObject jSONObjectOptJSONObject = com.byazt.vyf.s.cy().ae().optJSONObject(c0294s.n);
        int iS = jSONObjectOptJSONObject != null ? s(jSONObjectOptJSONObject.optString(PluginConstants.KEY_PLUGIN_VERSION)) : 0;
        return new Pair<>(Boolean.valueOf(iS == c0294s.qg), Boolean.valueOf(iS != 0));
    }

    private static boolean qg(int i) {
        File fileN = com.byazt.qyu.qg.n(rv.getContext());
        if (fileN == null) {
            return false;
        }
        return new File(fileN.getParent() + "/pangle_p/com.byted.pangle/version-" + i).exists();
    }

    private static int l(C0294s c0294s) {
        int iS;
        if (qg(c0294s)) {
            iS = 7814;
        } else {
            if (!com.byazt.vyf.s.cy().ae().has(c0294s.n)) {
                return 0;
            }
            JSONObject jSONObjectOptJSONObject = com.byazt.vyf.s.cy().ae().optJSONObject(c0294s.n);
            iS = jSONObjectOptJSONObject != null ? s(jSONObjectOptJSONObject.optString(PluginConstants.KEY_PLUGIN_VERSION)) : 0;
        }
        return iS;
    }

    private static boolean n(File file, C0294s c0294s) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(c0294s.toString());
            fileWriter.close();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    private static void n(File file, final String str) {
        file.listFiles(new FilenameFilter() { // from class: com.byazt.ph.s.7
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str2) {
                if (str2 == null || !str2.contains(str)) {
                    return false;
                }
                new File(file2, str2).delete();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<C0294s> s(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                String strN = n(jSONObjectOptJSONObject.optString("package_name"));
                if (!strN.equals("com.byted.csj.ext") || rv.qg().oj()) {
                    C0294s c0294s = new C0294s();
                    c0294s.n = strN;
                    c0294s.qg = jSONObjectOptJSONObject.optInt("version_code");
                    c0294s.s = jSONObjectOptJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
                    c0294s.q = jSONObjectOptJSONObject.optString(SDMAdConst.NETWORK_CUSTOM_KEY.DOWNLOAD_URL);
                    c0294s.l = jSONObjectOptJSONObject.optString(f.Y);
                    c0294s.fs = s(jSONObjectOptJSONObject.optString("min_version"));
                    c0294s.rv = s(jSONObjectOptJSONObject.optString("max_version"));
                    c0294s.tj = jSONObjectOptJSONObject.optInt("plugin_update_network", -2);
                    arrayList.add(c0294s);
                }
            }
        }
        Collections.sort(arrayList, new Comparator<C0294s>() { // from class: com.byazt.ph.s.8
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public int compare(C0294s c0294s2, C0294s c0294s3) {
                if ("com.byted.pangle".equals(c0294s2.n)) {
                    return -1;
                }
                return "com.byted.pangle".equals(c0294s3.n) ? 1 : 0;
            }
        });
        return arrayList;
    }

    public static String qg() {
        String str;
        String strN = com.byazt.wl.qg.n();
        if ("arm64-v8a".equals(strN)) {
            str = "@64";
        } else if ("armeabi-v7a".equals(strN)) {
            str = "@32";
        } else {
            str = "armeabi".equals(strN) ? "@armeabi" : "";
        }
        return "com.byted.live.lite".concat(str);
    }

    public static String n(String str) {
        return ("com.byted.live.lite@64".equals(str) || "com.byted.live.lite@32".equals(str) || "com.byted.live.lite@armeabi".equals(str)) ? "com.byted.live.lite" : str;
    }

    private static int s(String str) {
        if (str != null) {
            try {
                return Integer.parseInt(str.replace(i.E, ""));
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public void n(String str, int i) {
        if (this.w == null) {
            return;
        }
        this.w.apply(com.byazt.of.qg.n().n(1).n(Void.class).n(-99999979, com.byazt.of.s.n().n(false).n(i).n(com.byazt.of.qg.n().n(3, str).qg()).qg()).qg());
    }

    private boolean s() {
        JSONObject jSONObjectPv = rv.qg().pv();
        if (jSONObjectPv == null) {
            return false;
        }
        return jSONObjectPv.optBoolean("use_downloader", false);
    }

    /* JADX INFO: renamed from: com.byazt.ph.s$s, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 513, ComplianceMessage.INVALID_CLIENT_OR_NETWORK_ERROR})
    private static final class C0294s {
        public String cp;
        public int fs;
        public String l;
        public String n;
        public String q;
        public int qg;
        public int rv;
        public String s;
        public int tj;
        public String w;
        public boolean x;

        private C0294s() {
        }

        public String toString() {
            try {
                return new JSONObject().put("package_name", this.n).put("version_code", this.qg).put(f.Y, this.l).put("max_version", this.rv).put("min_version", this.fs).put("is_revert", this.x).put("md5", this.w).put("plugin_file", this.cp).toString();
            } catch (JSONException unused) {
                return "";
            }
        }

        public boolean n() {
            return TextUtils.equals(this.n, "com.byted.mixed");
        }
    }

    @com.byazt.cp.n(n = {0, 1, 513, 1604})
    private static final class q extends Exception {
        public final int n;

        public q(int i, String str) {
            super(str);
            this.n = i;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 513, 546})
    static class n {
        public int n;
        public int q;
        public String qg;
        public boolean s;

        public n(int i, String str, boolean z, int i2) {
            this.n = i;
            this.qg = str;
            this.s = z;
            this.q = i2;
        }

        public n(int i) {
            this(i, "", false, 0);
        }
    }

    @com.byazt.cp.n(n = {0, 1, 513, 782})
    private static class qg {
        public int l;
        public int n;
        public boolean q;
        public String qg;
        public boolean s;

        private qg() {
            this.n = 0;
            this.qg = "";
            this.s = false;
            this.q = false;
            this.l = 0;
        }

        public synchronized void n(int i) {
            this.n = i;
        }

        public synchronized void n(String str) {
            this.qg = str;
        }

        public synchronized void n(boolean z) {
            this.s = z;
        }

        public synchronized void qg(boolean z) {
            this.q = z;
        }

        public synchronized void qg(int i) {
            this.l = i;
        }

        public synchronized int n() {
            return this.l;
        }

        public synchronized int qg() {
            return this.n;
        }

        public synchronized String s() {
            return this.qg;
        }

        public synchronized boolean q() {
            return this.s;
        }

        public synchronized boolean l() {
            return this.q;
        }
    }
}
