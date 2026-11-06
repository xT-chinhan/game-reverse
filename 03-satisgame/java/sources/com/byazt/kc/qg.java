package com.byazt.kc;

import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.gx.fs;
import com.byazt.gx.oa;
import com.byazt.gx.rv;
import com.byazt.gx.x;
import com.byazt.kz.q;
import com.byazt.ry.cp;
import com.byazt.ry.d;
import com.byazt.vx.w;
import com.byazt.zi.s;
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
@com.byazt.cp.n(n = {0, 1, 1696, 26})
public class qg {
    public static int n(String str) {
        String strN;
        File[] fileArrTj;
        int i = -1;
        if (TextUtils.isEmpty(str) || (strN = s.n(str)) == null) {
            return -1;
        }
        File[] fileArrListFiles = new File(strN).listFiles(new FileFilter() { // from class: com.byazt.kc.qg.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return file != null && file.getName().matches("^version-(\\d+)$");
            }
        });
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file : fileArrListFiles) {
                int i2 = Integer.parseInt(file.getName().split("-")[1]);
                if (i2 > i && oa.n().q(str, i2) && (fileArrTj = s.tj(str, i2)) != null && fileArrTj.length > 0) {
                    i = i2;
                }
            }
        }
        return i;
    }

    public static void n(final String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strN = s.n(str);
        if (TextUtils.isEmpty(strN)) {
            return;
        }
        final String strConcat = "version-".concat(String.valueOf(i));
        new File(strN).listFiles(new FileFilter() { // from class: com.byazt.kc.qg.2
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                if (file != null && !strConcat.equals(file.getName())) {
                    x.n(file.getAbsolutePath());
                    if (file.getName().matches("^version-(\\d+)$")) {
                        oa.n().n(str, Integer.parseInt(file.getName().split("-")[1]), false);
                    }
                }
                return false;
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0088 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:36:0x008d A[DONT_GENERATE] */
    /* JADX WARN: Multi-variable type inference failed */
    public static n n(File file, List<File> list) throws JSONException, IOException {
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
                        d dVarQ = cp.n().q();
                        if (dVarQ != null) {
                            String strN = dVarQ.n(sb.toString());
                            if (!TextUtils.isEmpty(strN)) {
                                JSONObject jSONObject = new JSONObject(strN);
                                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils parse dex config json success");
                                n nVarN = n.n(jSONObject, file, list);
                                fileInputStream.close();
                                inputStreamReader.close();
                                bufferedReader.close();
                                return nVarN;
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

    public static boolean n(n nVar, long j) {
        List<File> listQ;
        File fileL;
        if (nVar != null) {
            listQ = nVar.q();
            fileL = nVar.l();
        } else {
            listQ = null;
            fileL = null;
        }
        if (fileL != null && listQ != null && listQ.size() > 0) {
            int iS = nVar.s();
            String strQg = nVar.qg();
            ZeusPluginStateListener.postStateChange(strQg, 11, new Object[0]);
            com.byazt.kz.s.n(com.byazt.fw.qg.q, com.byazt.fw.qg.n.cd, strQg, iS, -1L, null);
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex start packageName = " + strQg + " version is " + iS);
            String strCp = oa.n().cp(strQg);
            if (!TextUtils.isEmpty(strCp) && n(strCp) >= iS) {
                com.byazt.kz.s.n(com.byazt.fw.qg.l, com.byazt.fw.qg.n.a, strQg, iS, -1L, "dex installed version more than download version can no install new dex zip");
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginUtils ".concat("dex installed version more than download version can no install new dex zip"));
                return false;
            }
            String strX = TextUtils.isEmpty(nVar.x()) ? strQg : nVar.x();
            if (!s.rv(strX, iS)) {
                try {
                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex no dir need install packageName=" + strQg + " version=" + iS);
                    for (File file : listQ) {
                        if (file.getName().endsWith(".dex")) {
                            String strN = s.n(strX, iS, file.getName());
                            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex = " + file.getName());
                            fs.n(file.getAbsolutePath(), strN);
                        }
                    }
                    if (fileL.getName().endsWith(".json")) {
                        String strCp2 = s.cp(strX, iS);
                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex config = " + fileL.getName());
                        fs.n(fileL.getAbsolutePath(), strCp2);
                    }
                    if (s.rv(strX, iS)) {
                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex success packageName = " + strQg + " version = " + iS);
                        ZeusPluginStateListener.postStateChange(strQg, 12, new Object[0]);
                        com.byazt.kz.s.n(com.byazt.fw.qg.l, com.byazt.fw.qg.n.um, strQg, iS, SystemClock.elapsedRealtime() - j, "install success");
                        oa.n().n(strX, iS, true);
                        if (!TextUtils.isEmpty(nVar.x())) {
                            oa.n().s(strQg, strX);
                            oa.n().q(strQg, strCp);
                        }
                        return true;
                    }
                    com.byazt.kz.s.n(com.byazt.fw.qg.l, com.byazt.fw.qg.n.a, strQg, iS, -1L, "install dir not exists");
                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginUtils ".concat("install dir not exists"));
                } catch (Exception e) {
                    com.byazt.kz.s.n(com.byazt.fw.qg.l, com.byazt.fw.qg.n.a, strQg, iS, -1L, "throw exception: ".concat(String.valueOf(e)));
                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex fail throw exception");
                    w.n(e);
                }
            } else {
                com.byazt.kz.s.n(com.byazt.fw.qg.l, com.byazt.fw.qg.n.um, strQg, iS, SystemClock.elapsedRealtime() - j, "install success 已经安装完成");
                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex already install packageName = " + strQg + " version = " + iS);
                return true;
            }
        } else {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex fail config is null");
        }
        return false;
    }

    private static String qg(String str) {
        return (str == null || !str.endsWith(":")) ? str : str.substring(0, str.length() - 1);
    }

    public static boolean n(Plugin plugin, StringBuilder sb) {
        try {
            if (plugin == null) {
                sb.append("loadDexPlugin fail, plugin == null;");
                return false;
            }
            if (!plugin.isInstalled()) {
                sb.append("loadDexPlugin fail, plugin is not installed");
                return false;
            }
            if (!(plugin instanceof com.byazt.kz.n)) {
                sb.append("loadDexPlugin fail, plugin must be dexPlugin");
                return false;
            }
            String strCp = oa.n().cp(plugin.mPkgName);
            if (TextUtils.isEmpty(strCp)) {
                strCp = plugin.mPkgName;
            }
            int iN = n(strCp);
            if (iN == -1) {
                sb.append("loadDexPlugin fail, get Plugin version is -1");
                return false;
            }
            File[] fileArrTj = s.tj(strCp, iN);
            if (fileArrTj != null && fileArrTj.length != 0) {
                String strCp2 = s.cp(strCp, iN);
                if (TextUtils.isEmpty(strCp2)) {
                    sb.append("loadDexPlugin fail, configFileString is empty");
                    return false;
                }
                File file = new File(strCp2);
                if (file.exists() && file.isFile()) {
                    n nVarN = n(file, (List<File>) Arrays.asList(fileArrTj));
                    ((com.byazt.kz.n) plugin).n(nVarN);
                    if (nVarN == null) {
                        sb.append("loadDexPlugin fail, config is null");
                        return false;
                    }
                    if (!nVarN.n()) {
                        sb.append("loadDexPlugin fail, check dex fail");
                        return false;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    for (File file2 : fileArrTj) {
                        if (file2.isFile()) {
                            sb2.append(file2.getAbsolutePath());
                            sb2.append(":");
                        }
                    }
                    String strQg = qg(sb2.toString());
                    if (TextUtils.isEmpty(strQg)) {
                        sb.append("loadDexPlugin fail, dexPath is empty");
                        return false;
                    }
                    sb.append("loadDexPlugin dexpath: ".concat(String.valueOf(strQg)));
                    PluginClassLoader pluginClassLoaderN = plugin.mClassLoader != null ? plugin.mClassLoader : q.n(plugin, strCp, sb);
                    if (pluginClassLoaderN != null) {
                        if (rv.tj()) {
                            sb.append("loadDexPlugin addDexPath success dexPath=".concat(String.valueOf(strQg)));
                            return q.n(pluginClassLoaderN, strQg);
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
