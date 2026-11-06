package com.byazt.sjd;

import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.ae.k;
import com.byazt.ae.w;
import com.byazt.dea.uc;
import com.byazt.gs.aj;
import com.byazt.gs.fw;
import com.byazt.gs.m;
import com.byazt.gs.zo;
import com.byazt.ue.x;
import com.byazt.wo.hn;
import com.bytedance.pangle.PluginClassLoader;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1328, 13})
public class hw {
    public static int pr(String str) {
        String strPr;
        File[] fileArrVk;
        int i = -1;
        if (TextUtils.isEmpty(str) || (strPr = hn.pr(str)) == null) {
            return -1;
        }
        File[] fileArrListFiles = new File(strPr).listFiles(new FileFilter() { // from class: com.byazt.sjd.hw.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return file != null && file.getName().matches("^version-(\\d+)$");
            }
        });
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file : fileArrListFiles) {
                int i2 = Integer.parseInt(file.getName().split("-")[1]);
                if (i2 > i && m.pr().x(str, i2) && (fileArrVk = hn.vk(str, i2)) != null && fileArrVk.length > 0) {
                    i = i2;
                }
            }
        }
        return i;
    }

    public static void pr(final String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strPr = hn.pr(str);
        if (!TextUtils.isEmpty(strPr)) {
            final String strConcat = "version-".concat(String.valueOf(i));
            new File(strPr).listFiles(new FileFilter() { // from class: com.byazt.sjd.hw.2
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    if (file != null && !strConcat.equals(file.getName())) {
                        fw.pr(file.getAbsolutePath());
                        if (file.getName().matches("^version-(\\d+)$")) {
                            m.pr().pr(str, Integer.parseInt(file.getName().split("-")[1]), false);
                        }
                    }
                    return false;
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x008b A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:36:0x0090 A[DONT_GENERATE] */
    /* JADX WARN: Multi-variable type inference failed */
    public static pr pr(File file, List<File> list) throws JSONException, IOException {
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        if (file != null && list != null && list.size() > 0) {
            try {
                StringBuilder sb = new StringBuilder();
                fileInputStream = new FileInputStream(file);
                try {
                    inputStreamReader = new InputStreamReader(fileInputStream);
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader);
                        while (true) {
                            try {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                sb.append(line);
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginUtils parse dex config fail throw error ".concat(String.valueOf(th)));
                                    return null;
                                } finally {
                                    if (fileInputStream != null) {
                                        fileInputStream.close();
                                    }
                                    if (inputStreamReader != null) {
                                        inputStreamReader.close();
                                    }
                                    if (bufferedReader != 0) {
                                        bufferedReader.close();
                                    }
                                }
                            }
                        }
                        k kVarX = w.pr().x();
                        if (kVarX != null) {
                            String strPr = kVarX.pr(sb.toString());
                            if (!TextUtils.isEmpty(strPr)) {
                                JSONObject jSONObject = new JSONObject(strPr);
                                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils parse dex config json success");
                                pr prVarPr = pr.pr(jSONObject, file, list);
                                fileInputStream.close();
                                inputStreamReader.close();
                                bufferedReader.close();
                                return prVarPr;
                            }
                            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginUtils parse dex config fail decode content is empty");
                        } else {
                            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginUtils parse dex config fail decode callback is null");
                        }
                        fileInputStream.close();
                        inputStreamReader.close();
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = 0;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStreamReader = null;
                    bufferedReader = inputStreamReader;
                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginUtils parse dex config fail throw error ".concat(String.valueOf(th)));
                    return null;
                }
            } catch (Throwable th4) {
                th = th4;
                fileInputStream = null;
                inputStreamReader = null;
            }
        }
        return null;
    }

    public static boolean pr(pr prVar, long j) {
        List<File> listX;
        File fileC = null;
        if (prVar == null) {
            listX = null;
        } else {
            listX = prVar.x();
            fileC = prVar.c();
        }
        if (fileC != null && listX != null && listX.size() > 0) {
            int iHn = prVar.hn();
            String strHw = prVar.hw();
            ZeusPluginStateListener.postStateChange(strHw, 11, new Object[0]);
            com.byazt.ue.hn.pr(com.byazt.yk.hw.x, com.byazt.yk.hw.pr.lb, strHw, iHn, -1L, null);
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex start packageName = " + strHw + " version is " + iHn);
            String strW = m.pr().w(strHw);
            if (!TextUtils.isEmpty(strW) && pr(strW) >= iHn) {
                com.byazt.ue.hn.pr(com.byazt.yk.hw.c, com.byazt.yk.hw.pr.a, strHw, iHn, -1L, "dex installed version more than download version can no install new dex zip");
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginUtils ".concat(String.valueOf("dex installed version more than download version can no install new dex zip")));
                return false;
            }
            String strFw = TextUtils.isEmpty(prVar.fw()) ? strHw : prVar.fw();
            if (!hn.aj(strFw, iHn)) {
                try {
                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex no dir need install packageName=" + strHw + " version=" + iHn);
                    for (File file : listX) {
                        if (file.getName().endsWith(".dex")) {
                            String strPr = hn.pr(strFw, iHn, file.getName());
                            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex = " + file.getName());
                            zo.pr(file.getAbsolutePath(), strPr);
                        }
                    }
                    if (fileC.getName().endsWith(".json")) {
                        String strW2 = hn.w(strFw, iHn);
                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex config = " + fileC.getName());
                        zo.pr(fileC.getAbsolutePath(), strW2);
                    }
                    if (hn.aj(strFw, iHn)) {
                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex success packageName = " + strHw + " version = " + iHn);
                        ZeusPluginStateListener.postStateChange(strHw, 12, new Object[0]);
                        com.byazt.ue.hn.pr(com.byazt.yk.hw.c, com.byazt.yk.hw.pr.qa, strHw, iHn, SystemClock.elapsedRealtime() - j, "install success");
                        m.pr().pr(strFw, iHn, true);
                        if (!TextUtils.isEmpty(prVar.fw())) {
                            m.pr().hn(strHw, strFw);
                            m.pr().x(strHw, strW);
                        }
                        return true;
                    }
                    com.byazt.ue.hn.pr(com.byazt.yk.hw.c, com.byazt.yk.hw.pr.a, strHw, iHn, -1L, "install dir not exists");
                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginUtils ".concat(String.valueOf("install dir not exists")));
                } catch (Exception e) {
                    com.byazt.ue.hn.pr(com.byazt.yk.hw.c, com.byazt.yk.hw.pr.a, strHw, iHn, -1L, "throw exception: ".concat(String.valueOf(e)));
                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex fail throw exception");
                    uc.pr(e);
                }
            } else {
                com.byazt.ue.hn.pr(com.byazt.yk.hw.c, com.byazt.yk.hw.pr.qa, strHw, iHn, SystemClock.elapsedRealtime() - j, "install success 已经安装完成");
                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex already install packageName = " + strHw + " version = " + iHn);
                return true;
            }
        } else {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex fail config is null");
        }
        return false;
    }

    private static String hw(String str) {
        if (str != null && str.endsWith(":")) {
            return str.substring(0, str.length() - 1);
        }
        return str;
    }

    public static boolean pr(Plugin plugin, StringBuilder sb) {
        try {
            if (plugin == null) {
                sb.append("loadDexPlugin fail, plugin == null;");
                return false;
            }
            if (!plugin.isInstalled()) {
                sb.append("loadDexPlugin fail, plugin is not installed");
                return false;
            }
            if (!(plugin instanceof com.byazt.ue.pr)) {
                sb.append("loadDexPlugin fail, plugin must be dexPlugin");
                return false;
            }
            String strW = m.pr().w(plugin.mPkgName);
            if (TextUtils.isEmpty(strW)) {
                strW = plugin.mPkgName;
            }
            int iPr = pr(strW);
            if (iPr == -1) {
                sb.append("loadDexPlugin fail, get Plugin version is -1");
                return false;
            }
            File[] fileArrVk = hn.vk(strW, iPr);
            if (fileArrVk != null && fileArrVk.length != 0) {
                String strW2 = hn.w(strW, iPr);
                if (TextUtils.isEmpty(strW2)) {
                    sb.append("loadDexPlugin fail, configFileString is empty");
                    return false;
                }
                File file = new File(strW2);
                if (file.exists() && file.isFile()) {
                    pr prVarPr = pr(file, (List<File>) Arrays.asList(fileArrVk));
                    ((com.byazt.ue.pr) plugin).pr(prVarPr);
                    if (prVarPr == null) {
                        sb.append("loadDexPlugin fail, config is null");
                        return false;
                    }
                    if (!prVarPr.pr()) {
                        sb.append("loadDexPlugin fail, check dex fail");
                        return false;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    for (File file2 : fileArrVk) {
                        if (file2.isFile()) {
                            sb2.append(file2.getAbsolutePath());
                            sb2.append(":");
                        }
                    }
                    String strHw = hw(sb2.toString());
                    if (TextUtils.isEmpty(strHw)) {
                        sb.append("loadDexPlugin fail, dexPath is empty");
                        return false;
                    }
                    sb.append("loadDexPlugin dexpath: ".concat(String.valueOf(strHw)));
                    PluginClassLoader pluginClassLoaderPr = plugin.mClassLoader != null ? plugin.mClassLoader : x.pr(plugin, strW, sb);
                    if (pluginClassLoaderPr != null) {
                        if (aj.vk()) {
                            sb.append("loadDexPlugin addDexPath success dexPath=".concat(String.valueOf(strHw)));
                            return x.pr(pluginClassLoaderPr, strHw);
                        }
                    } else {
                        sb.append("loadDexPlugin makeDexPluginClassLoader fail: classLoader is null");
                    }
                    return false;
                }
                sb.append("loadDexPlugin fail, config file is not exists or is not file");
                return false;
            }
            sb.append("loadDexPlugin fail, get dex files is null or length is 0");
            return false;
        } catch (Throwable th) {
            sb.append("loadDexPlugin fail, throw error ").append(th);
            return false;
        }
    }
}
