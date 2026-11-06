package com.bytedance.pangle.ah;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.pangle.PluginClassLoader;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginDecodeCallback;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.ch;
import com.bytedance.pangle.ka.ah;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.d;
import com.bytedance.pangle.util.ab;
import com.bytedance.pangle.util.ny;
import com.bytedance.pangle.util.x;
import com.bytedance.pangle.util.zb;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    public static int ms(String str) {
        String strMs;
        File[] fileArrHi;
        int i = -1;
        if (TextUtils.isEmpty(str) || (strMs = ah.ms(str)) == null) {
            return -1;
        }
        File[] fileArrListFiles = new File(strMs).listFiles(new FileFilter() { // from class: com.bytedance.pangle.ah.xr.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return file != null && file.getName().matches("^version-(\\d+)$");
            }
        });
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file : fileArrListFiles) {
                int i2 = Integer.parseInt(file.getName().split("-")[1]);
                if (i2 > i && zb.ms().d(str, i2) && (fileArrHi = ah.hi(str, i2)) != null && fileArrHi.length > 0) {
                    i = i2;
                }
            }
        }
        return i;
    }

    public static void ms(final String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strMs = ah.ms(str);
        if (TextUtils.isEmpty(strMs)) {
            return;
        }
        final String strConcat = "version-".concat(String.valueOf(i));
        new File(strMs).listFiles(new FileFilter() { // from class: com.bytedance.pangle.ah.xr.2
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                if (file != null && !strConcat.equals(file.getName())) {
                    ab.ms(file.getAbsolutePath());
                    if (file.getName().matches("^version-(\\d+)$")) {
                        zb.ms().xr(str, Integer.parseInt(file.getName().split("-")[1]), false);
                    }
                }
                return false;
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0088 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:36:0x008d A[DONT_GENERATE] */
    /* JADX WARN: Multi-variable type inference failed */
    public static ms ms(File file, List<File> list) throws JSONException, IOException {
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
                        ZeusPluginDecodeCallback zeusPluginDecodeCallbackD = ch.ms().d();
                        if (zeusPluginDecodeCallbackD != null) {
                            String strDecode = zeusPluginDecodeCallbackD.decode(sb.toString());
                            if (!TextUtils.isEmpty(strDecode)) {
                                JSONObject jSONObject = new JSONObject(strDecode);
                                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils parse dex config json success");
                                ms msVarMs = ms.ms(jSONObject, file, list);
                                fileInputStream.close();
                                inputStreamReader.close();
                                bufferedReader.close();
                                return msVarMs;
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

    public static boolean ms(ms msVar, long j) {
        List<File> listD;
        File fileKa;
        if (msVar != null) {
            listD = msVar.d();
            fileKa = msVar.ka();
        } else {
            listD = null;
            fileKa = null;
        }
        if (fileKa != null && listD != null && listD.size() > 0) {
            int iAh = msVar.ah();
            String strXr = msVar.xr();
            ZeusPluginStateListener.postStateChange(strXr, 11, new Object[0]);
            com.bytedance.pangle.plugin.ah.ms(com.bytedance.pangle.d.xr.d, com.bytedance.pangle.d.xr.ms.qv, strXr, iAh, -1L, null);
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex start packageName = " + strXr + " version is " + iAh);
            String strHi = zb.ms().hi(strXr);
            if (!TextUtils.isEmpty(strHi) && ms(strHi) >= iAh) {
                com.bytedance.pangle.plugin.ah.ms(com.bytedance.pangle.d.xr.ka, com.bytedance.pangle.d.xr.ms.t, strXr, iAh, -1L, "dex installed version more than download version can no install new dex zip");
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginUtils ".concat("dex installed version more than download version can no install new dex zip"));
                return false;
            }
            String strAb = TextUtils.isEmpty(msVar.ab()) ? strXr : msVar.ab();
            if (!ah.ch(strAb, iAh)) {
                try {
                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex no dir need install packageName=" + strXr + " version=" + iAh);
                    for (File file : listD) {
                        if (file.getName().endsWith(".dex")) {
                            String strMs = ah.ms(strAb, iAh, file.getName());
                            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex = " + file.getName());
                            x.ms(file.getAbsolutePath(), strMs);
                        }
                    }
                    if (fileKa.getName().endsWith(".json")) {
                        String strSl = ah.sl(strAb, iAh);
                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex config = " + fileKa.getName());
                        x.ms(fileKa.getAbsolutePath(), strSl);
                    }
                    if (ah.ch(strAb, iAh)) {
                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex success packageName = " + strXr + " version = " + iAh);
                        ZeusPluginStateListener.postStateChange(strXr, 12, new Object[0]);
                        com.bytedance.pangle.plugin.ah.ms(com.bytedance.pangle.d.xr.ka, com.bytedance.pangle.d.xr.ms.y, strXr, iAh, SystemClock.elapsedRealtime() - j, "install success");
                        zb.ms().xr(strAb, iAh, true);
                        if (!TextUtils.isEmpty(msVar.ab())) {
                            zb.ms().ah(strXr, strAb);
                            zb.ms().d(strXr, strHi);
                        }
                        return true;
                    }
                    com.bytedance.pangle.plugin.ah.ms(com.bytedance.pangle.d.xr.ka, com.bytedance.pangle.d.xr.ms.t, strXr, iAh, -1L, "install dir not exists");
                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginUtils ".concat("install dir not exists"));
                } catch (Exception e) {
                    com.bytedance.pangle.plugin.ah.ms(com.bytedance.pangle.d.xr.ka, com.bytedance.pangle.d.xr.ms.t, strXr, iAh, -1L, "throw exception: ".concat(String.valueOf(e)));
                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex fail throw exception");
                    com.bytedance.sdk.openadsdk.api.ab.ms(e);
                }
            } else {
                com.bytedance.pangle.plugin.ah.ms(com.bytedance.pangle.d.xr.ka, com.bytedance.pangle.d.xr.ms.y, strXr, iAh, SystemClock.elapsedRealtime() - j, "install success 已经安装完成");
                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex already install packageName = " + strXr + " version = " + iAh);
                return true;
            }
        } else {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex fail config is null");
        }
        return false;
    }

    private static String xr(String str) {
        return (str == null || !str.endsWith(":")) ? str : str.substring(0, str.length() - 1);
    }

    public static boolean ms(Plugin plugin, StringBuilder sb) {
        try {
            if (plugin == null) {
                sb.append("loadDexPlugin fail, plugin == null;");
                return false;
            }
            if (!plugin.isInstalled()) {
                sb.append("loadDexPlugin fail, plugin is not installed");
                return false;
            }
            if (!(plugin instanceof com.bytedance.pangle.plugin.ms)) {
                sb.append("loadDexPlugin fail, plugin must be dexPlugin");
                return false;
            }
            String strHi = zb.ms().hi(plugin.mPkgName);
            if (TextUtils.isEmpty(strHi)) {
                strHi = plugin.mPkgName;
            }
            int iMs = ms(strHi);
            if (iMs == -1) {
                sb.append("loadDexPlugin fail, get Plugin version is -1");
                return false;
            }
            File[] fileArrHi = ah.hi(strHi, iMs);
            if (fileArrHi != null && fileArrHi.length != 0) {
                String strSl = ah.sl(strHi, iMs);
                if (TextUtils.isEmpty(strSl)) {
                    sb.append("loadDexPlugin fail, configFileString is empty");
                    return false;
                }
                File file = new File(strSl);
                if (file.exists() && file.isFile()) {
                    ms msVarMs = ms(file, (List<File>) Arrays.asList(fileArrHi));
                    ((com.bytedance.pangle.plugin.ms) plugin).ms(msVarMs);
                    if (msVarMs == null) {
                        sb.append("loadDexPlugin fail, config is null");
                        return false;
                    }
                    if (!msVarMs.ms()) {
                        sb.append("loadDexPlugin fail, check dex fail");
                        return false;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    for (File file2 : fileArrHi) {
                        if (file2.isFile()) {
                            sb2.append(file2.getAbsolutePath());
                            sb2.append(":");
                        }
                    }
                    String strXr = xr(sb2.toString());
                    if (TextUtils.isEmpty(strXr)) {
                        sb.append("loadDexPlugin fail, dexPath is empty");
                        return false;
                    }
                    Map<String, JSONObject> mapKa = ch.ms().ka();
                    if (mapKa != null && mapKa.size() != 0) {
                        JSONObject jSONObject = mapKa.get(plugin.mPkgName);
                        if (jSONObject != null && jSONObject.has("hostPackageName")) {
                            String strOptString = jSONObject.optString("hostPackageName");
                            if (TextUtils.isEmpty(strOptString)) {
                                sb.append("loadDexPlugin fail, hostPackageName is empty");
                                return false;
                            }
                            Plugin plugin2 = Zeus.getPlugin(strOptString);
                            if (plugin2 != null) {
                                if (ny.hi()) {
                                    sb.append("loadDexPlugin addDexPath success dexPath=".concat(String.valueOf(strXr)));
                                    return d.ms(plugin2.mClassLoader, strXr);
                                }
                                if (plugin2.mClassLoader != null) {
                                    ArrayList arrayList = new ArrayList(1);
                                    arrayList.add(new PluginClassLoader(strXr, null, null, null));
                                    sb.append("loadDexPlugin setOtherPluginClassLoader success dexPath=").append(strXr);
                                    plugin2.mClassLoader.setOtherPluginClassLoader(arrayList);
                                    return true;
                                }
                                sb.append("loadDexPlugin fail classLoader is null");
                                return false;
                            }
                            sb.append("loadDexPlugin fail, hostPlugin is null hostPackageName=").append(strOptString);
                            return false;
                        }
                        sb.append("loadDexPlugin fail, dex config can not get hostPackageName");
                        return false;
                    }
                    sb.append("loadDexPlugin fail, getPackageDexManager is empty");
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
