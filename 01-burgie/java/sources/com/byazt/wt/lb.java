package com.byazt.wt;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.db.constant.Common;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 48})
public class lb {
    public static void pr() {
        Context context = com.byazt.sd.a.getContext();
        if (context == null || !com.byazt.ca.ho.hn()) {
            return;
        }
        pr(context);
        String packageName = context.getPackageName();
        int i = context.getApplicationInfo().targetSdkVersion;
        PackageManager packageManager = context.getPackageManager();
        boolean z = false;
        boolean z2 = false;
        for (ProviderInfo providerInfo : packageManager.queryContentProviders(context.getApplicationInfo().processName, context.getApplicationInfo().uid, 131072)) {
            if ("com.byazt.byx.TTMultiProvider".equals(providerInfo.name)) {
                String str = packageName + ".TTMultiProvider";
                if (TextUtils.isEmpty(str) || !str.equals(providerInfo.authority)) {
                    com.byazt.ca.ho.hw("TTAdSdk-InitChecker", "AndroidManifest.xml中TTMultiProvider配置异常：android:authorities，请参考接入文档");
                    com.byazt.hs.hn.hn(3, "0");
                } else {
                    com.byazt.hs.hn.hn(3, "1");
                }
                z = true;
            } else if (providerInfo.authority.equals(packageName + ".TTFileProvider")) {
                if (i < 24) {
                    int i2 = Build.VERSION.SDK_INT;
                    com.byazt.hs.hn.hn(3, "1");
                } else {
                    if (providerInfo.exported) {
                        com.byazt.ca.ho.hw("TTAdSdk-InitChecker", "AndroidManifest.xml中TTFileProvider配置异常：android:exported，请参考接入文档");
                        com.byazt.hs.hn.hn(3, "0");
                    }
                    if (!providerInfo.grantUriPermissions) {
                        com.byazt.ca.ho.hw("TTAdSdk-InitChecker", "AndroidManifest.xml中TTFileProvider配置异常：android:grantUriPermissions，请参考接入文档");
                        com.byazt.hs.hn.hn(3, "0");
                    }
                    try {
                        List<pr> listPr = pr(context, Integer.valueOf(String.valueOf(packageManager.getProviderInfo(new ComponentName(packageName, providerInfo.name), 128).metaData.get("android.support.FILE_PROVIDER_PATHS"))).intValue());
                        if (listPr != null && !listPr.isEmpty()) {
                            List<pr> listHn = hn();
                            List<pr> listX = x();
                            for (pr prVar : listPr) {
                                if (prVar != null) {
                                    listHn.remove(prVar);
                                    listX.remove(prVar);
                                }
                            }
                            if (listHn.isEmpty() && listX.isEmpty()) {
                                com.byazt.hs.hn.hn(3, "1");
                            } else {
                                Iterator<pr> it = listHn.iterator();
                                while (it.hasNext()) {
                                    com.byazt.ca.ho.hw("TTAdSdk-InitChecker", "    TTFileProvider缺少必要路径：" + it.next().toString());
                                }
                                Iterator<pr> it2 = listX.iterator();
                                while (it2.hasNext()) {
                                    com.byazt.ca.ho.hw("TTAdSdk-InitChecker", "    TTFileProvider缺少可选路径：" + it2.next().toString());
                                }
                                com.byazt.hs.hn.hn(3, "0");
                            }
                        } else {
                            com.byazt.ca.ho.hw("TTAdSdk-InitChecker", "AndroidManifest.xml中TTFileProvider中路径配置异常，请参考接入文档");
                            com.byazt.hs.hn.hn(3, "0");
                        }
                    } catch (Throwable th) {
                        com.byazt.ca.ho.pr("TTAdSdk-InitChecker", "AndroidManifest.xml中TTFileProvider配置错误，请参考接入文档", th);
                        com.byazt.hs.hn.hn(3, "0");
                        z2 = true;
                    }
                }
                z2 = true;
            }
        }
        try {
            String[] strArr = packageManager.getPackageInfo(packageName, 4096).requestedPermissions;
            if (strArr != null && strArr.length > 0) {
                List<String> listHw = hw();
                for (String str2 : strArr) {
                    if (str2 != null) {
                        listHw.remove(str2);
                    }
                }
                if (!listHw.isEmpty()) {
                    Iterator<String> it3 = listHw.iterator();
                    while (it3.hasNext()) {
                        com.byazt.ca.ho.hw("TTAdSdk-InitChecker", "    可能缺少权限：" + it3.next() + "，请参考接入文档");
                    }
                }
            } else {
                com.byazt.ca.ho.hw("TTAdSdk-InitChecker", "AndroidManifest.xml中uses-permission配置丢失，请参考接入文档");
            }
        } catch (Throwable th2) {
            com.byazt.ca.ho.pr("TTAdSdk-InitChecker", "AndroidManifest.xml中uses-permission配置错误，请参考接入文档", th2);
        }
        try {
            if (Build.VERSION.SDK_INT < 23 || i < 23) {
                int i3 = Build.VERSION.SDK_INT;
            } else {
                boolean zPr = com.byazt.qam.c.pr().pr(context, "android.permission.READ_PHONE_STATE");
                boolean zPr2 = com.byazt.qam.c.pr().pr(context, "android.permission.ACCESS_COARSE_LOCATION");
                boolean zPr3 = com.byazt.qam.c.pr().pr(context, "android.permission.ACCESS_FINE_LOCATION");
                boolean zPr4 = com.byazt.qam.c.pr().pr(context, "android.permission.WRITE_EXTERNAL_STORAGE");
                if (!zPr) {
                    com.byazt.ca.ho.hw("TTAdSdk-InitChecker", "动态权限没有获取，可能影响转化：android.permission.READ_PHONE_STATE");
                }
                if (!zPr2) {
                    com.byazt.ca.ho.hw("TTAdSdk-InitChecker", "动态权限没有获取，可能影响转化：android.permission.ACCESS_COARSE_LOCATION");
                }
                if (!zPr3) {
                    com.byazt.ca.ho.hw("TTAdSdk-InitChecker", "动态权限没有获取，可能影响转化：android.permission.ACCESS_FINE_LOCATION");
                }
                if (!zPr4) {
                    com.byazt.ca.ho.hw("TTAdSdk-InitChecker", "动态权限没有获取，可能影响转化：android.permission.WRITE_EXTERNAL_STORAGE");
                }
            }
        } catch (Throwable th3) {
            com.byazt.ca.ho.pr("TTAdSdk-InitChecker", "动态权限获取异常，请检查并详细阅读接入文档", th3);
        }
        if (!z) {
            com.byazt.ca.ho.hw("TTAdSdk-InitChecker", "××您没有配置TTMultiProvider，请参考接入文档，否则影响转化××");
        }
        if (!z2) {
            com.byazt.ca.ho.hw("TTAdSdk-InitChecker", "××您没有配置TTFileProvider，请参考接入文档，否则影响转化××");
        }
    }

    private static String pr(Context context) {
        try {
            return ((com.byazt.vkw.c) com.byazt.zs.uc.pr("app_process")).hw();
        } catch (Throwable th) {
            return "unknown";
        }
    }

    private static List<String> hw() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.INTERNET");
        arrayList.add("android.permission.ACCESS_NETWORK_STATE");
        arrayList.add("android.permission.ACCESS_WIFI_STATE");
        arrayList.add("android.permission.READ_PHONE_STATE");
        arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
        arrayList.add("android.permission.REQUEST_INSTALL_PACKAGES");
        arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
        arrayList.add("android.permission.ACCESS_FINE_LOCATION");
        return arrayList;
    }

    private static List<pr> hn() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new pr("external-path", "tt_external_download", "Download"));
        arrayList.add(new pr("external-files-path", "tt_external_files_download", "Download"));
        arrayList.add(new pr("files-path", "tt_internal_file_download", "Download"));
        arrayList.add(new pr("cache-path", "tt_internal_cache_download", "Download"));
        return arrayList;
    }

    private static List<pr> x() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new pr("external-path", "tt_external_root", "."));
        return arrayList;
    }

    private static List<pr> pr(Context context, int i) {
        XmlResourceParser xml;
        try {
            ArrayList arrayList = new ArrayList();
            xml = context.getResources().getXml(i);
            try {
                for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                    switch (eventType) {
                        case 2:
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
                                arrayList.add(new pr(name, attributeValue, attributeValue2));
                            }
                            break;
                    }
                }
                if (xml != null) {
                    xml.close();
                }
                return arrayList;
            } catch (Throwable th) {
                if (xml != null) {
                    xml.close();
                }
                return null;
            }
        } catch (Throwable th2) {
            xml = null;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 855})
    private static class pr {
        public String hn;
        public String hw;
        public String pr;

        public pr(String str, String str2, String str3) {
            this.pr = str;
            this.hw = str2;
            this.hn = str3;
        }

        public boolean equals(Object obj) {
            String str;
            if (obj instanceof pr) {
                pr prVar = (pr) obj;
                String str2 = this.pr;
                return str2 != null && str2.equals(prVar.pr) && (str = this.hn) != null && str.equals(prVar.hn);
            }
            return super.equals(obj);
        }

        public String toString() {
            try {
                return "<" + this.pr + " name=\"" + this.hw + "\" path=\"" + this.hn + "\" />";
            } catch (Throwable th) {
                return super.toString();
            }
        }
    }
}
