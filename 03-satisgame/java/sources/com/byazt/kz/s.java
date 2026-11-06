package com.byazt.kz;

import android.content.pm.PackageInfo;
import android.util.Log;
import com.byazt.gx.fs;
import com.byazt.gx.oa;
import com.byazt.gx.rv;
import com.byazt.gx.x;
import com.byazt.ry.cp;
import com.byazt.vx.w;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1356, 8})
public class s {
    public static final cp n = cp.n();

    public static boolean n(final File file, final String str, final int i) {
        final StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("useOpt;");
        final boolean[] zArr = {false};
        try {
            cp cpVar = n;
            cpVar.n(1000, 0, str, i, null);
            com.byazt.is.qg qgVarN = com.byazt.is.qg.n(ZeusLogger.TAG_INSTALL, "PluginInstaller", "install:".concat(String.valueOf(str)));
            n(com.byazt.fw.qg.q, com.byazt.fw.qg.n.cd, str, i, -1L, null);
            qg(str, i);
            x.n(com.byazt.zi.s.n(str, i));
            com.byazt.qb.n.n(false, new com.byazt.qb.n.InterfaceC0309n() { // from class: com.byazt.kz.s.1
                @Override // com.byazt.qb.n.InterfaceC0309n
                public void n() throws Throwable {
                    s.w(file, str, i, stringBuffer);
                }
            }, new com.byazt.qb.n.InterfaceC0309n() { // from class: com.byazt.kz.s.2
                @Override // com.byazt.qb.n.InterfaceC0309n
                public void n() throws Throwable {
                    final Map mapX = s.x(file, str, i, stringBuffer);
                    s.fs(file, str, i, stringBuffer);
                    s.qg(s.rv(file, str, i, stringBuffer), str, i, stringBuffer);
                    if (rv.x()) {
                        final boolean[] zArr2 = {false};
                        com.byazt.qb.n.n(false, new com.byazt.qb.n.InterfaceC0309n() { // from class: com.byazt.kz.s.2.1
                            @Override // com.byazt.qb.n.InterfaceC0309n
                            public void n() throws Throwable {
                                s.qg(str, i, (Map<String, List<ZipEntry>>) mapX, stringBuffer);
                            }
                        }, new com.byazt.qb.n.InterfaceC0309n() { // from class: com.byazt.kz.s.2.2
                            @Override // com.byazt.qb.n.InterfaceC0309n
                            public void n() throws Throwable {
                                zArr2[0] = s.tj(file, str, i, stringBuffer);
                            }
                        });
                        zArr[0] = s.qg(str, i, zArr2[0], stringBuffer);
                    } else {
                        s.qg(str, i, (Map<String, List<ZipEntry>>) mapX, stringBuffer);
                        zArr[0] = s.qg(str, i, false, stringBuffer);
                        s.s(str, i);
                    }
                }
            });
            x.n(file);
            n(com.byazt.fw.qg.l, com.byazt.fw.qg.n.um, str, i, qgVarN.n(), stringBuffer.toString());
            qgVarN.n("success");
            cpVar.n(1100, 0, str, i, null);
            return true;
        } catch (Throwable th) {
            if (th instanceof n) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstaller " + str + " install failed.", th);
            } else {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstaller " + str + " install failed unknown error.", th);
                n(com.byazt.fw.qg.l, com.byazt.fw.qg.n.a, str, i, -1L, stringBuffer.toString());
                n.n(1100, -1, str, i, th);
            }
            if (zArr[0]) {
                oa.n().n(str, i, "install");
            }
            return false;
        }
    }

    private static void qg(String str, int i) {
        int iQg = oa.n().qg(str, i, "install");
        int iQg2 = oa.n().qg(str, i, "load");
        int removeApkEntryFlag = GlobalParam.getInstance().getRemoveApkEntryFlag(str);
        if (iQg > 3 || iQg2 > 3) {
            removeApkEntryFlag = 0;
        }
        oa.n().n(str, i, removeApkEntryFlag);
        oa.n().s(str, i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean qg(String str, int i, boolean z, StringBuffer stringBuffer) {
        int iFs = oa.n().fs(str, i);
        boolean z2 = (iFs & 1) != 0;
        boolean z3 = (iFs & 2) != 0;
        if (!z2 && !z3) {
            stringBuffer.append("removeEntry skip;");
            return false;
        }
        boolean z4 = z && z2;
        String strQg = com.byazt.zi.s.qg(str, i);
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zN = com.byazt.jh.qg.n(strQg, z4, z3, str, i, 1);
        stringBuffer.append("removeEntry cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
        return zN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(String str, String str2, int i, StringBuffer stringBuffer) throws n {
        long jCurrentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        int iN = new com.byazt.ev.s().n(new File(str), false, sb);
        stringBuffer.append(iN == 100 ? "modifyRes" : "noModifyRes").append(" cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
        if (iN == 100 || iN == 200) {
            return;
        }
        String string = sb.toString();
        n(com.byazt.fw.qg.l, com.byazt.fw.qg.n.ur, str2, i, -1L, string);
        n.n(1100, -2, str2, i, null);
        throw new n("modifyRes failed. result = " + iN + ", errorLog = " + string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(File file, String str, int i, StringBuffer stringBuffer) throws n {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                StringBuilder sb = new StringBuilder();
                if (!com.byazt.ls.l.n(file.getAbsolutePath(), str, sb)) {
                    throw new RuntimeException("安装包签名校验失败[1]:".concat(String.valueOf(sb)));
                }
                stringBuffer.append("checkSignature cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
                return;
            } catch (Exception e) {
                n(com.byazt.fw.qg.l, com.byazt.fw.qg.n.py, str, i, -1L, Log.getStackTraceString(e));
                n.n(1100, -3, str, i, e);
                throw new n(e.getMessage(), e);
            }
        } catch (Throwable th) {
            stringBuffer.append("checkSignature cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
            throw th;
        }
        stringBuffer.append("checkSignature cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
        throw th;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, List<ZipEntry>> x(File file, String str, int i, StringBuffer stringBuffer) throws n {
        String str2 = "插件包包含so不符合宿主ABI类型";
        if (!GlobalParam.getInstance().checkMatchHostAbi()) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                com.byazt.gx.l<Boolean, Map<String, List<ZipEntry>>> lVarN = com.byazt.zi.qg.n(file);
                boolean zBooleanValue = lVarN.n.booleanValue();
                Map<String, List<ZipEntry>> map = lVarN.qg;
                if (!zBooleanValue) {
                    throw new n(str2);
                }
                stringBuffer.append("checkMatchHostAbi cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
                return map;
            } catch (Exception e) {
                n(com.byazt.fw.qg.l, com.byazt.fw.qg.n.t, str, i, -1L, null);
                n.n(1100, -5, str, i, e);
                throw new n(str2, e);
            }
        } catch (Throwable th) {
            stringBuffer.append("checkMatchHostAbi cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void fs(File file, String str, int i, StringBuffer stringBuffer) throws n {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                PackageInfo packageInfo = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 4096);
                PackageInfo packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 4096);
                List listAsList = Arrays.asList(packageInfo.requestedPermissions);
                if (packageArchiveInfo.requestedPermissions != null && packageArchiveInfo.requestedPermissions.length > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (String str2 : packageArchiveInfo.requestedPermissions) {
                        if (!listAsList.contains(str2)) {
                            arrayList.add(str2);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        ZeusLogger.w("PluginInstaller", "The following permissions are declared in the plugin but not in the host: ".concat(String.valueOf(arrayList)));
                        if (GlobalParam.getInstance().checkPermission()) {
                            throw new n("The following permissions are declared in the plugin but not in the host: ".concat(String.valueOf(arrayList)));
                        }
                        stringBuffer.append("checkPermissions cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
                        throw th;
                    }
                }
                stringBuffer.append("checkPermissions cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
            } catch (Exception e) {
                n(com.byazt.fw.qg.l, com.byazt.fw.qg.n.ou, str, i, -1L, null);
                n.n(1100, -4, str, i, e);
                throw new n("安装包权限校验失败", e);
            }
        } catch (Throwable th) {
            stringBuffer.append("checkPermissions cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String rv(File file, String str, int i, StringBuffer stringBuffer) throws n {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strQg = com.byazt.zi.s.qg(str, i);
        try {
            try {
                fs.n(file.getAbsolutePath(), strQg);
                stringBuffer.append("copyApk cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
                return strQg;
            } catch (Exception e) {
                n(com.byazt.fw.qg.l, com.byazt.fw.qg.n.wm, str, i, -1L, null);
                n.n(1100, -6, str, i, e);
                throw new n("安装包拷贝失败", e);
            }
        } catch (Throwable th) {
            stringBuffer.append("copyApk cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(String str, int i, Map<String, List<ZipEntry>> map, StringBuffer stringBuffer) throws n {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                com.byazt.zi.qg.n(new File(com.byazt.zi.s.qg(str, i)), new File(com.byazt.zi.s.q(str, i)), str, map);
                stringBuffer.append("copySo cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
            } catch (Exception e) {
                n(com.byazt.fw.qg.l, com.byazt.fw.qg.n.m, str, i, -1L, com.byazt.is.s.n((Object) e));
                n.n(1100, -7, str, i, e);
                throw new n("安装包动态库拷贝失败", e);
            }
        } catch (Throwable th) {
            stringBuffer.append("copySo cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean tj(File file, String str, int i, StringBuffer stringBuffer) throws n {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                if (rv.x()) {
                    String strS = com.byazt.zi.s.s(str, i);
                    String strQg = com.byazt.zi.s.qg(str, i);
                    String str2 = strS + File.separator + com.byazt.sw.qg.n(strQg);
                    if (com.byazt.sw.qg.n(strQg, strS + File.separator + com.byazt.sw.qg.n(strQg)) && com.byazt.sw.qg.n(str2)) {
                        stringBuffer.append("dexOpt1 cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
                        return true;
                    }
                }
                stringBuffer.append("dexOpt1 cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
                return false;
            } catch (Exception e) {
                n(com.byazt.fw.qg.l, com.byazt.fw.qg.n.h, str, i, -1L, null);
                throw new n("dexOpt1失败", e);
            }
        } catch (Throwable th) {
            stringBuffer.append("dexOpt1 cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s(String str, int i) throws n {
        try {
            if (rv.w() || rv.fs()) {
                oa.n().qg(str, i, false);
                com.byazt.sw.qg.n(Zeus.getAppApplication()).edit().putInt(str, i).apply();
                com.byazt.sw.l.n();
            }
        } catch (Exception e) {
            n(com.byazt.fw.qg.l, com.byazt.fw.qg.n.h, str, i, -1L, null);
            throw new n("dexOpt2失败", e);
        }
    }

    public static void n(String str, int i, String str2, int i2, long j, String str3) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("status_code", com.byazt.is.s.n(Integer.valueOf(i)));
            jSONObject.putOpt("plugin_package_name", com.byazt.is.s.n(str2));
            jSONObject.putOpt("version_code", com.byazt.is.s.n(Integer.valueOf(i2)));
            jSONObject3.putOpt(MediationConstant.EXTRA_DURATION, Integer.valueOf(com.byazt.is.s.qg(Long.valueOf(j))));
            jSONObject2.putOpt("message", com.byazt.is.s.n(str3));
        } catch (JSONException e) {
            w.n(e);
        }
        com.byazt.fw.qg.n().n(str, jSONObject, jSONObject3, jSONObject2);
    }

    @com.byazt.cp.n(n = {0, 1, 1356, 546})
    public static class n extends IOException {
        private n(String str) {
            super(str);
        }

        private n(String str, Throwable th) {
            super(str, th);
        }
    }
}
