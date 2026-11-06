package com.byazt.ue;

import android.content.pm.PackageInfo;
import android.util.Log;
import com.byazt.ae.w;
import com.byazt.dea.uc;
import com.byazt.gs.aj;
import com.byazt.gs.fw;
import com.byazt.gs.m;
import com.byazt.gs.zo;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
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
@com.byazt.vzx.pr(pr = {0, 1, 594, 20})
public class hn {
    public static final w pr = w.pr();

    public static boolean pr(final File file, final String str, final int i) {
        final StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("useOpt;");
        final boolean[] zArr = {false};
        try {
            w wVar = pr;
            wVar.pr(1000, 0, str, i, null);
            com.byazt.wp.hw hwVarPr = com.byazt.wp.hw.pr(ZeusLogger.TAG_INSTALL, "PluginInstaller", "install:".concat(String.valueOf(str)));
            pr(com.byazt.yk.hw.x, com.byazt.yk.hw.pr.lb, str, i, -1L, null);
            hw(str, i);
            fw.pr(com.byazt.wo.hn.pr(str, i));
            com.byazt.hae.pr.pr(false, new com.byazt.hae.pr.InterfaceC0082pr() { // from class: com.byazt.ue.hn.1
                @Override // com.byazt.hae.pr.InterfaceC0082pr
                public void pr() throws Throwable {
                    hn.uc(file, str, i, stringBuffer);
                }
            }, new com.byazt.hae.pr.InterfaceC0082pr() { // from class: com.byazt.ue.hn.2
                @Override // com.byazt.hae.pr.InterfaceC0082pr
                public void pr() throws Throwable {
                    final Map mapFw = hn.fw(file, str, i, stringBuffer);
                    hn.zo(file, str, i, stringBuffer);
                    hn.hw(hn.aj(file, str, i, stringBuffer), str, i, stringBuffer);
                    if (!aj.fw()) {
                        hn.hw(str, i, (Map<String, List<ZipEntry>>) mapFw, stringBuffer);
                        zArr[0] = hn.hw(str, i, false, stringBuffer);
                        hn.hn(str, i);
                    } else {
                        final boolean[] zArr2 = {false};
                        com.byazt.hae.pr.pr(false, new com.byazt.hae.pr.InterfaceC0082pr() { // from class: com.byazt.ue.hn.2.1
                            @Override // com.byazt.hae.pr.InterfaceC0082pr
                            public void pr() throws Throwable {
                                hn.hw(str, i, (Map<String, List<ZipEntry>>) mapFw, stringBuffer);
                            }
                        }, new com.byazt.hae.pr.InterfaceC0082pr() { // from class: com.byazt.ue.hn.2.2
                            @Override // com.byazt.hae.pr.InterfaceC0082pr
                            public void pr() throws Throwable {
                                zArr2[0] = hn.vk(file, str, i, stringBuffer);
                            }
                        });
                        zArr[0] = hn.hw(str, i, zArr2[0], stringBuffer);
                    }
                }
            });
            fw.pr(file);
            pr(com.byazt.yk.hw.c, com.byazt.yk.hw.pr.qa, str, i, hwVarPr.pr(), stringBuffer.toString());
            hwVarPr.pr(TrackAction.SUCCESS);
            wVar.pr(1100, 0, str, i, null);
            return true;
        } catch (Throwable th) {
            if (th instanceof pr) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstaller " + str + " install failed.", th);
            } else {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstaller " + str + " install failed unknown error.", th);
                pr(com.byazt.yk.hw.c, com.byazt.yk.hw.pr.a, str, i, -1L, stringBuffer.toString());
                pr.pr(1100, -1, str, i, th);
            }
            if (zArr[0]) {
                m.pr().pr(str, i, "install");
            }
            return false;
        }
    }

    private static void hw(String str, int i) {
        int iHw = m.pr().hw(str, i, "install");
        int iHw2 = m.pr().hw(str, i, "load");
        int removeApkEntryFlag = GlobalParam.getInstance().getRemoveApkEntryFlag(str);
        if (iHw > 3 || iHw2 > 3) {
            removeApkEntryFlag = 0;
        }
        m.pr().pr(str, i, removeApkEntryFlag);
        m.pr().hn(str, i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hw(String str, int i, boolean z, StringBuffer stringBuffer) {
        int iZo = m.pr().zo(str, i);
        boolean z2 = (iZo & 1) != 0;
        boolean z3 = (iZo & 2) != 0;
        if (!z2 && !z3) {
            stringBuffer.append("removeEntry skip;");
            return false;
        }
        boolean z4 = z && z2;
        String strHw = com.byazt.wo.hn.hw(str, i);
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zPr = com.byazt.au.hw.pr(strHw, z4, z3, str, i, 1);
        stringBuffer.append("removeEntry cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
        return zPr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hw(String str, String str2, int i, StringBuffer stringBuffer) throws pr {
        long jCurrentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        int iPr = new com.byazt.ph.hn().pr(new File(str), false, sb);
        stringBuffer.append(iPr == 100 ? "modifyRes" : "noModifyRes").append(" cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
        if (iPr != 100 && iPr != 200) {
            String string = sb.toString();
            pr(com.byazt.yk.hw.c, com.byazt.yk.hw.pr.ve, str2, i, -1L, string);
            pr.pr(1100, -2, str2, i, null);
            throw new pr("modifyRes failed. result = " + iPr + ", errorLog = " + string);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void uc(File file, String str, int i, StringBuffer stringBuffer) throws pr {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                StringBuilder sb = new StringBuilder();
                if (com.byazt.lro.c.pr(file.getAbsolutePath(), str, sb)) {
                    stringBuffer.append("checkSignature cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
                    return;
                }
                throw new RuntimeException("安装包签名校验失败[1]:".concat(String.valueOf(sb)));
            } catch (Exception e) {
                pr(com.byazt.yk.hw.c, com.byazt.yk.hw.pr.cz, str, i, -1L, Log.getStackTraceString(e));
                pr.pr(1100, -3, str, i, e);
                throw new pr(e.getMessage(), e);
            }
        } catch (Throwable th) {
            stringBuffer.append("checkSignature cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
            throw th;
        }
        stringBuffer.append("checkSignature cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
        throw th;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, List<ZipEntry>> fw(File file, String str, int i, StringBuffer stringBuffer) throws pr {
        String str2 = "插件包包含so不符合宿主ABI类型";
        if (!GlobalParam.getInstance().checkMatchHostAbi()) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                com.byazt.gs.c<Boolean, Map<String, List<ZipEntry>>> cVarPr = com.byazt.wo.hw.pr(file);
                boolean zBooleanValue = cVarPr.pr.booleanValue();
                Map<String, List<ZipEntry>> map = cVarPr.hw;
                if (!zBooleanValue) {
                    throw new pr(str2);
                }
                stringBuffer.append("checkMatchHostAbi cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
                return map;
            } catch (Exception e) {
                pr(com.byazt.yk.hw.c, com.byazt.yk.hw.pr.iu, str, i, -1L, null);
                pr.pr(1100, -5, str, i, e);
                throw new pr(str2, e);
            }
        } catch (Throwable th) {
            stringBuffer.append("checkMatchHostAbi cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zo(File file, String str, int i, StringBuffer stringBuffer) throws pr {
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
                            throw new pr("The following permissions are declared in the plugin but not in the host: ".concat(String.valueOf(arrayList)));
                        }
                        stringBuffer.append("checkPermissions cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
                        throw th;
                    }
                }
                stringBuffer.append("checkPermissions cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
            } catch (Exception e) {
                pr(com.byazt.yk.hw.c, com.byazt.yk.hw.pr.ny, str, i, -1L, null);
                pr.pr(1100, -4, str, i, e);
                throw new pr("安装包权限校验失败", e);
            }
        } catch (Throwable th) {
            stringBuffer.append("checkPermissions cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String aj(File file, String str, int i, StringBuffer stringBuffer) throws pr {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strHw = com.byazt.wo.hn.hw(str, i);
        try {
            try {
                zo.pr(file.getAbsolutePath(), strHw);
                stringBuffer.append("copyApk cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
                return strHw;
            } catch (Exception e) {
                pr(com.byazt.yk.hw.c, com.byazt.yk.hw.pr.fo, str, i, -1L, null);
                pr.pr(1100, -6, str, i, e);
                throw new pr("安装包拷贝失败", e);
            }
        } catch (Throwable th) {
            stringBuffer.append("copyApk cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hw(String str, int i, Map<String, List<ZipEntry>> map, StringBuffer stringBuffer) throws pr {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                com.byazt.wo.hw.pr(new File(com.byazt.wo.hn.hw(str, i)), new File(com.byazt.wo.hn.x(str, i)), str, map);
                stringBuffer.append("copySo cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
            } catch (Exception e) {
                pr(com.byazt.yk.hw.c, com.byazt.yk.hw.pr.rc, str, i, -1L, com.byazt.wp.hn.pr((Object) e));
                pr.pr(1100, -7, str, i, e);
                throw new pr("安装包动态库拷贝失败", e);
            }
        } catch (Throwable th) {
            stringBuffer.append("copySo cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean vk(File file, String str, int i, StringBuffer stringBuffer) throws pr {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                if (aj.fw()) {
                    String strHn = com.byazt.wo.hn.hn(str, i);
                    String strHw = com.byazt.wo.hn.hw(str, i);
                    String str2 = strHn + File.separator + com.byazt.xid.hw.pr(strHw);
                    if (com.byazt.xid.hw.pr(strHw, strHn + File.separator + com.byazt.xid.hw.pr(strHw)) && com.byazt.xid.hw.pr(str2)) {
                        stringBuffer.append("dexOpt1 cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
                        return true;
                    }
                }
                stringBuffer.append("dexOpt1 cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
                return false;
            } catch (Exception e) {
                pr(com.byazt.yk.hw.c, com.byazt.yk.hw.pr.b, str, i, -1L, null);
                throw new pr("dexOpt1失败", e);
            }
        } catch (Throwable th) {
            stringBuffer.append("dexOpt1 cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hn(String str, int i) throws pr {
        try {
            if (aj.uc() || aj.zo()) {
                m.pr().hw(str, i, false);
                com.byazt.xid.hw.pr(Zeus.getAppApplication()).edit().putInt(str, i).apply();
                com.byazt.xid.c.pr();
            }
        } catch (Exception e) {
            pr(com.byazt.yk.hw.c, com.byazt.yk.hw.pr.b, str, i, -1L, null);
            throw new pr("dexOpt2失败", e);
        }
    }

    public static void pr(String str, int i, String str2, int i2, long j, String str3) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("status_code", com.byazt.wp.hn.pr(Integer.valueOf(i)));
            jSONObject.putOpt("plugin_package_name", com.byazt.wp.hn.pr(str2));
            jSONObject.putOpt("version_code", com.byazt.wp.hn.pr(Integer.valueOf(i2)));
            jSONObject3.putOpt("duration", Integer.valueOf(com.byazt.wp.hn.hw(Long.valueOf(j))));
            jSONObject2.putOpt("message", com.byazt.wp.hn.pr(str3));
        } catch (JSONException e) {
            uc.pr(e);
        }
        com.byazt.yk.hw.pr().pr(str, jSONObject, jSONObject3, jSONObject2);
    }

    @com.byazt.vzx.pr(pr = {0, 1, 594, 116})
    public static class pr extends IOException {
        private pr(String str) {
            super(str);
        }

        private pr(String str, Throwable th) {
            super(str, th);
        }
    }
}
