package com.bytedance.pangle.plugin;

import android.content.pm.PackageInfo;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.c.c;
import com.bytedance.pangle.ch;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.ab;
import com.bytedance.pangle.util.ny;
import com.bytedance.pangle.util.x;
import com.bytedance.pangle.util.zb;
import com.tapsdk.tapad.internal.tracker.experiment.h.f;
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
public class ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final ch f655ms = ch.ms();

    static boolean ms(final File file, final String str, final int i) {
        final StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("useOpt;");
        final boolean[] zArr = {false};
        try {
            ch chVar = f655ms;
            chVar.ms(1000, 0, str, i, null);
            com.bytedance.pangle.log.ms msVarMs = com.bytedance.pangle.log.ms.ms(ZeusLogger.TAG_INSTALL, "PluginInstaller", "install:".concat(String.valueOf(str)));
            ms(com.bytedance.pangle.d.xr.d, com.bytedance.pangle.d.xr.ms.qv, str, i, -1L, null);
            xr(str, i);
            ab.ms(com.bytedance.pangle.ka.ah.ms(str, i));
            com.bytedance.pangle.ms.ms.ms(false, new com.bytedance.pangle.ms.ms.InterfaceC0222ms() { // from class: com.bytedance.pangle.plugin.ah.1
                @Override // com.bytedance.pangle.ms.ms.InterfaceC0222ms
                public void ms() throws Throwable {
                    ah.c(file, str, i, stringBuffer);
                }
            }, new com.bytedance.pangle.ms.ms.InterfaceC0222ms() { // from class: com.bytedance.pangle.plugin.ah.2
                @Override // com.bytedance.pangle.ms.ms.InterfaceC0222ms
                public void ms() throws Throwable {
                    final Map mapAb = ah.ab(file, str, i, stringBuffer);
                    ah.x(file, str, i, stringBuffer);
                    ah.xr(ah.ny(file, str, i, stringBuffer), str, i, stringBuffer);
                    if (ny.x() || ny.ah()) {
                        final boolean[] zArr2 = {false};
                        com.bytedance.pangle.ms.ms.ms(false, new com.bytedance.pangle.ms.ms.InterfaceC0222ms() { // from class: com.bytedance.pangle.plugin.ah.2.1
                            @Override // com.bytedance.pangle.ms.ms.InterfaceC0222ms
                            public void ms() throws Throwable {
                                ah.xr(str, i, (Map<String, List<ZipEntry>>) mapAb, stringBuffer);
                            }
                        }, new com.bytedance.pangle.ms.ms.InterfaceC0222ms() { // from class: com.bytedance.pangle.plugin.ah.2.2
                            @Override // com.bytedance.pangle.ms.ms.InterfaceC0222ms
                            public void ms() throws Throwable {
                                zArr2[0] = ah.ch(file, str, i, stringBuffer);
                            }
                        });
                        zArr[0] = ah.xr(str, i, zArr2[0], stringBuffer);
                    } else {
                        ah.xr(str, i, (Map<String, List<ZipEntry>>) mapAb, stringBuffer);
                        zArr[0] = ah.xr(str, i, false, stringBuffer);
                        ah.ah(str, i);
                    }
                }
            });
            ab.ms(file);
            ms(com.bytedance.pangle.d.xr.ka, com.bytedance.pangle.d.xr.ms.y, str, i, msVarMs.ms(), stringBuffer.toString());
            msVarMs.ms("success");
            chVar.ms(1100, 0, str, i, null);
            return true;
        } catch (Throwable th) {
            if (th instanceof ms) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstaller " + str + " install failed.", th);
            } else {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstaller " + str + " install failed unknown error.", th);
                ms(com.bytedance.pangle.d.xr.ka, com.bytedance.pangle.d.xr.ms.t, str, i, -1L, stringBuffer.toString());
                f655ms.ms(1100, -1, str, i, th);
            }
            if (zArr[0]) {
                zb.ms().ms(str, i, "install");
            }
            return false;
        }
    }

    private static void xr(String str, int i) {
        int iXr = zb.ms().xr(str, i, "install");
        int iXr2 = zb.ms().xr(str, i, "load");
        int removeApkEntryFlag = GlobalParam.getInstance().getRemoveApkEntryFlag(str);
        if (iXr > 3 || iXr2 > 3) {
            removeApkEntryFlag = 0;
        }
        zb.ms().ms(str, i, removeApkEntryFlag);
        zb.ms().d(str, i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean xr(String str, int i, boolean z, StringBuffer stringBuffer) {
        int iNy = zb.ms().ny(str, i);
        boolean z2 = (iNy & 1) != 0;
        boolean z3 = (iNy & 2) != 0;
        if (!z2 && !z3) {
            stringBuffer.append("removeEntry skip;");
            return false;
        }
        boolean z4 = z && z2;
        String strXr = com.bytedance.pangle.ka.ah.xr(str, i);
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zMs = com.bytedance.pangle.util.xr.xr.ms(strXr, z4, z3, str, i, 1);
        stringBuffer.append("removeEntry cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
        return zMs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xr(String str, String str2, int i, StringBuffer stringBuffer) throws ms {
        long jCurrentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        int iMs = new com.bytedance.pangle.res.ms.ah().ms(new File(str), false, sb);
        stringBuffer.append(iMs == 100 ? "modifyRes" : "noModifyRes").append(" cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
        if (iMs == 100 || iMs == 200) {
            return;
        }
        String string = sb.toString();
        ms(com.bytedance.pangle.d.xr.ka, com.bytedance.pangle.d.xr.ms.le, str2, i, -1L, string);
        f655ms.ms(1100, -2, str2, i, null);
        throw new ms("modifyRes failed. result = " + iMs + ", errorLog = " + string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(File file, String str, int i, StringBuffer stringBuffer) throws ms {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                if (!com.bytedance.pangle.x.ka.ms(file.getAbsolutePath(), str)) {
                    throw new RuntimeException("安装包签名校验失败[1]");
                }
                stringBuffer.append("checkSignature cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
                return;
            } catch (Exception e) {
                ms(com.bytedance.pangle.d.xr.ka, com.bytedance.pangle.d.xr.ms.nw, str, i, -1L, null);
                f655ms.ms(1100, -3, str, i, e);
                throw new ms(e.getMessage(), e);
            }
        } catch (Throwable th) {
            stringBuffer.append("checkSignature cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
            throw th;
        }
        stringBuffer.append("checkSignature cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
        throw th;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, List<ZipEntry>> ab(File file, String str, int i, StringBuffer stringBuffer) throws ms {
        String str2 = "插件包包含so不符合宿主ABI类型";
        if (!GlobalParam.getInstance().checkMatchHostAbi()) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                com.bytedance.pangle.util.ka<Boolean, Map<String, List<ZipEntry>>> kaVarMs = com.bytedance.pangle.ka.xr.ms(file);
                boolean zBooleanValue = kaVarMs.f700ms.booleanValue();
                Map<String, List<ZipEntry>> map = kaVarMs.xr;
                if (!zBooleanValue) {
                    throw new ms(str2);
                }
                stringBuffer.append("checkMatchHostAbi cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
                return map;
            } catch (Exception e) {
                ms(com.bytedance.pangle.d.xr.ka, com.bytedance.pangle.d.xr.ms.op, str, i, -1L, null);
                f655ms.ms(1100, -5, str, i, e);
                throw new ms(str2, e);
            }
        } catch (Throwable th) {
            stringBuffer.append("checkMatchHostAbi cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void x(File file, String str, int i, StringBuffer stringBuffer) throws ms {
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
                            throw new ms("The following permissions are declared in the plugin but not in the host: ".concat(String.valueOf(arrayList)));
                        }
                        stringBuffer.append("checkPermissions cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
                        throw th;
                    }
                }
                stringBuffer.append("checkPermissions cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
            } catch (Exception e) {
                ms(com.bytedance.pangle.d.xr.ka, com.bytedance.pangle.d.xr.ms.b, str, i, -1L, null);
                f655ms.ms(1100, -4, str, i, e);
                throw new ms("安装包权限校验失败", e);
            }
        } catch (Throwable th) {
            stringBuffer.append("checkPermissions cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String ny(File file, String str, int i, StringBuffer stringBuffer) throws ms {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strXr = com.bytedance.pangle.ka.ah.xr(str, i);
        try {
            try {
                x.ms(file.getAbsolutePath(), strXr);
                stringBuffer.append("copyApk cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
                return strXr;
            } catch (Exception e) {
                ms(com.bytedance.pangle.d.xr.ka, com.bytedance.pangle.d.xr.ms.re, str, i, -1L, null);
                f655ms.ms(1100, -6, str, i, e);
                throw new ms("安装包拷贝失败", e);
            }
        } catch (Throwable th) {
            stringBuffer.append("copyApk cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xr(String str, int i, Map<String, List<ZipEntry>> map, StringBuffer stringBuffer) throws ms {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                com.bytedance.pangle.ka.xr.ms(new File(com.bytedance.pangle.ka.ah.xr(str, i)), new File(com.bytedance.pangle.ka.ah.d(str, i)), str, map);
                stringBuffer.append("copySo cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
            } catch (Exception e) {
                ms(com.bytedance.pangle.d.xr.ka, com.bytedance.pangle.d.xr.ms.i, str, i, -1L, com.bytedance.pangle.log.xr.ms((Object) e));
                f655ms.ms(1100, -7, str, i, e);
                throw new ms("安装包动态库拷贝失败", e);
            }
        } catch (Throwable th) {
            stringBuffer.append("copySo cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean ch(File file, String str, int i, StringBuffer stringBuffer) throws ms {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                if (ny.ah()) {
                    com.bytedance.pangle.c.ab.ms(file, str, i);
                    com.bytedance.pangle.c.xr.ms(Zeus.getAppApplication()).edit().putInt(str, i).apply();
                    c.ms();
                } else if (ny.x()) {
                    String strAh = com.bytedance.pangle.ka.ah.ah(str, i);
                    String strXr = com.bytedance.pangle.ka.ah.xr(str, i);
                    String str2 = strAh + File.separator + com.bytedance.pangle.c.xr.ms(strXr);
                    if (com.bytedance.pangle.c.xr.ms(strXr, strAh + File.separator + com.bytedance.pangle.c.xr.ms(strXr)) && com.bytedance.pangle.c.xr.ms(str2)) {
                        stringBuffer.append("dexOpt1 cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
                        return true;
                    }
                }
                stringBuffer.append("dexOpt1 cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
                return false;
            } catch (Exception e) {
                ms(com.bytedance.pangle.d.xr.ka, com.bytedance.pangle.d.xr.ms.yu, str, i, -1L, null);
                throw new ms("dexOpt1失败", e);
            }
        } catch (Throwable th) {
            stringBuffer.append("dexOpt1 cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(";");
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ah(String str, int i) throws ms {
        try {
            if (ny.ab() || ny.ny()) {
                zb.ms().ah(str, i, false);
                com.bytedance.pangle.c.xr.ms(Zeus.getAppApplication()).edit().putInt(str, i).apply();
                c.ms();
            }
        } catch (Exception e) {
            ms(com.bytedance.pangle.d.xr.ka, com.bytedance.pangle.d.xr.ms.yu, str, i, -1L, null);
            throw new ms("dexOpt2失败", e);
        }
    }

    public static void ms(String str, int i, String str2, int i2, long j, String str3) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt(f.z, com.bytedance.pangle.log.xr.ms(Integer.valueOf(i)));
            jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.xr.ms(str2));
            jSONObject.putOpt("version_code", com.bytedance.pangle.log.xr.ms(Integer.valueOf(i2)));
            jSONObject3.putOpt("duration", Integer.valueOf(com.bytedance.pangle.log.xr.xr(Long.valueOf(j))));
            jSONObject2.putOpt("message", com.bytedance.pangle.log.xr.ms(str3));
        } catch (JSONException e) {
            com.bytedance.sdk.openadsdk.api.ab.ms(e);
        }
        com.bytedance.pangle.d.xr.ms().ms(str, jSONObject, jSONObject3, jSONObject2);
    }

    public static class ms extends IOException {
        private ms(String str) {
            super(str);
        }

        private ms(String str, Throwable th) {
            super(str, th);
        }
    }
}
