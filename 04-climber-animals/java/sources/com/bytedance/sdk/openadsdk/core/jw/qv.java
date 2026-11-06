package com.bytedance.sdk.openadsdk.core.jw;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.text.TextUtils;
import com.anythink.core.common.d.j;
import com.taptap.sdk.db.constant.Common;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class qv {
    public static void ms() {
        Context context = com.bytedance.sdk.openadsdk.core.re.getContext();
        if (context != null && com.bytedance.sdk.component.utils.sl.ah()) {
            ms(context);
            String packageName = context.getPackageName();
            int i = context.getApplicationInfo().targetSdkVersion;
            PackageManager packageManager = context.getPackageManager();
            boolean z = false;
            boolean z2 = false;
            for (ProviderInfo providerInfo : packageManager.queryContentProviders(context.getApplicationInfo().processName, context.getApplicationInfo().uid, 131072)) {
                if ("com.bytedance.sdk.openadsdk.multipro.TTMultiProvider".equals(providerInfo.name)) {
                    String str = packageName + ".TTMultiProvider";
                    if (TextUtils.isEmpty(str) || !str.equals(providerInfo.authority)) {
                        com.bytedance.sdk.component.utils.sl.d("TTAdSdk-InitChecker", "AndroidManifest.xml中TTMultiProvider配置异常：android:authorities，请参考接入文档");
                        com.bytedance.sdk.openadsdk.tools.xr.ah(3, "0");
                    } else {
                        com.bytedance.sdk.openadsdk.tools.xr.ah(3, "1");
                    }
                    z = true;
                } else if (providerInfo.authority.equals(packageName + ".TTFileProvider")) {
                    if (i < 24) {
                        com.bytedance.sdk.component.utils.sl.ms("TTAdSdk-InitChecker", "TTFileProvider不需要适配：target=" + i + "&phone=" + Build.VERSION.SDK_INT + ", require=24");
                        com.bytedance.sdk.openadsdk.tools.xr.ah(3, "1");
                    } else {
                        if (providerInfo.exported) {
                            com.bytedance.sdk.component.utils.sl.d("TTAdSdk-InitChecker", "AndroidManifest.xml中TTFileProvider配置异常：android:exported，请参考接入文档");
                            com.bytedance.sdk.openadsdk.tools.xr.ah(3, "0");
                        }
                        if (!providerInfo.grantUriPermissions) {
                            com.bytedance.sdk.component.utils.sl.d("TTAdSdk-InitChecker", "AndroidManifest.xml中TTFileProvider配置异常：android:grantUriPermissions，请参考接入文档");
                            com.bytedance.sdk.openadsdk.tools.xr.ah(3, "0");
                        }
                        try {
                            List<ms> listMs = ms(context, Integer.valueOf(String.valueOf(packageManager.getProviderInfo(new ComponentName(packageName, providerInfo.name), 128).metaData.get("android.support.FILE_PROVIDER_PATHS"))).intValue());
                            if (listMs != null && !listMs.isEmpty()) {
                                List<ms> listAh = ah();
                                List<ms> listD = d();
                                for (ms msVar : listMs) {
                                    if (msVar != null) {
                                        listAh.remove(msVar);
                                        listD.remove(msVar);
                                    }
                                }
                                if (listAh.isEmpty() && listD.isEmpty()) {
                                    com.bytedance.sdk.openadsdk.tools.xr.ah(3, "1");
                                } else {
                                    Iterator<ms> it = listAh.iterator();
                                    while (it.hasNext()) {
                                        com.bytedance.sdk.component.utils.sl.d("TTAdSdk-InitChecker", "    TTFileProvider缺少必要路径：" + it.next().toString());
                                    }
                                    Iterator<ms> it2 = listD.iterator();
                                    while (it2.hasNext()) {
                                        com.bytedance.sdk.component.utils.sl.d("TTAdSdk-InitChecker", "    TTFileProvider缺少可选路径：" + it2.next().toString());
                                    }
                                    com.bytedance.sdk.openadsdk.tools.xr.ah(3, "0");
                                }
                            } else {
                                com.bytedance.sdk.component.utils.sl.d("TTAdSdk-InitChecker", "AndroidManifest.xml中TTFileProvider中路径配置异常，请参考接入文档");
                                com.bytedance.sdk.openadsdk.tools.xr.ah(3, "0");
                            }
                        } catch (Throwable th) {
                            com.bytedance.sdk.component.utils.sl.ah("TTAdSdk-InitChecker", "AndroidManifest.xml中TTFileProvider配置错误，请参考接入文档", th);
                            com.bytedance.sdk.openadsdk.tools.xr.ah(3, "0");
                        }
                    }
                    z2 = true;
                }
            }
            try {
                String[] strArr = packageManager.getPackageInfo(packageName, 4096).requestedPermissions;
                if (strArr != null && strArr.length > 0) {
                    List<String> listXr = xr();
                    for (String str2 : strArr) {
                        if (str2 != null) {
                            listXr.remove(str2);
                        }
                    }
                    if (!listXr.isEmpty()) {
                        Iterator<String> it3 = listXr.iterator();
                        while (it3.hasNext()) {
                            com.bytedance.sdk.component.utils.sl.d("TTAdSdk-InitChecker", "    可能缺少权限：" + it3.next() + "，请参考接入文档");
                        }
                    }
                } else {
                    com.bytedance.sdk.component.utils.sl.d("TTAdSdk-InitChecker", "AndroidManifest.xml中uses-permission配置丢失，请参考接入文档");
                }
            } catch (Throwable th2) {
                com.bytedance.sdk.component.utils.sl.ah("TTAdSdk-InitChecker", "AndroidManifest.xml中uses-permission配置错误，请参考接入文档", th2);
            }
            try {
                if (i < 23) {
                    com.bytedance.sdk.component.utils.sl.ms("TTAdSdk-InitChecker", "动态权限不需要适配：target=" + i + "&phone=" + Build.VERSION.SDK_INT + ", require=23");
                } else {
                    boolean zMs = com.bytedance.sdk.openadsdk.core.i.ka.ms().ms(context, "android.permission.READ_PHONE_STATE");
                    boolean zMs2 = com.bytedance.sdk.openadsdk.core.i.ka.ms().ms(context, com.kuaishou.weapon.p0.g.h);
                    boolean zMs3 = com.bytedance.sdk.openadsdk.core.i.ka.ms().ms(context, com.kuaishou.weapon.p0.g.g);
                    boolean zMs4 = com.bytedance.sdk.openadsdk.core.i.ka.ms().ms(context, "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!zMs) {
                        com.bytedance.sdk.component.utils.sl.d("TTAdSdk-InitChecker", "动态权限没有获取，可能影响转化：android.permission.READ_PHONE_STATE");
                    }
                    if (!zMs2) {
                        com.bytedance.sdk.component.utils.sl.d("TTAdSdk-InitChecker", "动态权限没有获取，可能影响转化：android.permission.ACCESS_COARSE_LOCATION");
                    }
                    if (!zMs3) {
                        com.bytedance.sdk.component.utils.sl.d("TTAdSdk-InitChecker", "动态权限没有获取，可能影响转化：android.permission.ACCESS_FINE_LOCATION");
                    }
                    if (!zMs4) {
                        com.bytedance.sdk.component.utils.sl.d("TTAdSdk-InitChecker", "动态权限没有获取，可能影响转化：android.permission.WRITE_EXTERNAL_STORAGE");
                    }
                }
            } catch (Throwable th3) {
                com.bytedance.sdk.component.utils.sl.ah("TTAdSdk-InitChecker", "动态权限获取异常，请检查并详细阅读接入文档", th3);
            }
            if (!z) {
                com.bytedance.sdk.component.utils.sl.d("TTAdSdk-InitChecker", "××您没有配置TTMultiProvider，请参考接入文档，否则影响转化××");
            }
            if (z2) {
                return;
            }
            com.bytedance.sdk.component.utils.sl.d("TTAdSdk-InitChecker", "××您没有配置TTFileProvider，请参考接入文档，否则影响转化××");
        }
    }

    private static String ms(Context context) {
        try {
            return com.bytedance.sdk.component.utils.h.xr(context);
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    private static List<String> xr() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.kuaishou.weapon.p0.g.a);
        arrayList.add(com.kuaishou.weapon.p0.g.b);
        arrayList.add(com.kuaishou.weapon.p0.g.d);
        arrayList.add("android.permission.READ_PHONE_STATE");
        arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
        arrayList.add("android.permission.REQUEST_INSTALL_PACKAGES");
        arrayList.add(com.kuaishou.weapon.p0.g.h);
        arrayList.add(com.kuaishou.weapon.p0.g.g);
        return arrayList;
    }

    private static List<ms> ah() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ms("external-path", "tt_external_download", "Download"));
        arrayList.add(new ms("external-files-path", "tt_external_files_download", "Download"));
        arrayList.add(new ms("files-path", "tt_internal_file_download", "Download"));
        arrayList.add(new ms("cache-path", "tt_internal_cache_download", "Download"));
        return arrayList;
    }

    private static List<ms> d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ms("external-path", "tt_external_root", j.z));
        return arrayList;
    }

    private static List<ms> ms(Context context, int i) {
        XmlResourceParser xml;
        try {
            ArrayList arrayList = new ArrayList();
            xml = context.getResources().getXml(i);
            try {
                for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                    if (eventType == 2) {
                        String name = xml.getName();
                        int attributeCount = xml.getAttributeCount();
                        String attributeValue = null;
                        String attributeValue2 = null;
                        for (int i2 = 0; i2 < attributeCount; i2++) {
                            String attributeName = xml.getAttributeName(i2);
                            if (attributeName.equals(Common.System.NAME)) {
                                attributeValue = xml.getAttributeValue(i2);
                            } else if (attributeName.equals("path")) {
                                attributeValue2 = xml.getAttributeValue(i2);
                            }
                        }
                        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(attributeValue) && !TextUtils.isEmpty(attributeValue2)) {
                            arrayList.add(new ms(name, attributeValue, attributeValue2));
                        }
                    }
                }
                if (xml != null) {
                    xml.close();
                }
                return arrayList;
            } catch (Throwable unused) {
                if (xml != null) {
                    xml.close();
                }
                return null;
            }
        } catch (Throwable unused2) {
            xml = null;
        }
    }

    private static class ms {
        String ah;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        String f2727ms;
        String xr;

        ms(String str, String str2, String str3) {
            this.f2727ms = str;
            this.xr = str2;
            this.ah = str3;
        }

        public boolean equals(Object obj) {
            String str;
            if (obj instanceof ms) {
                ms msVar = (ms) obj;
                String str2 = this.f2727ms;
                return str2 != null && str2.equals(msVar.f2727ms) && (str = this.ah) != null && str.equals(msVar.ah);
            }
            return super.equals(obj);
        }

        public String toString() {
            try {
                return "<" + this.f2727ms + " name=\"" + this.xr + "\" path=\"" + this.ah + "\" />";
            } catch (Throwable unused) {
                return super.toString();
            }
        }
    }
}
