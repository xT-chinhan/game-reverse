package com.byazt.vyf;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import com.anythink.china.b.c;
import com.anythink.core.common.d.i;
import com.byazt.nf.rv;
import com.byazt.tk.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT, 5})
public class q {
    public static void n() {
        Context context = rv.getContext();
        if (context != null && k.s()) {
            n(context);
            String packageName = context.getPackageName();
            int i = context.getApplicationInfo().targetSdkVersion;
            PackageManager packageManager = context.getPackageManager();
            boolean z = false;
            boolean z2 = false;
            for (ProviderInfo providerInfo : packageManager.queryContentProviders(context.getApplicationInfo().processName, context.getApplicationInfo().uid, 131072)) {
                if ("com.byazt.gm.TTMultiProvider".equals(providerInfo.name)) {
                    String str = packageName + ".TTMultiProvider";
                    if (TextUtils.isEmpty(str) || !str.equals(providerInfo.authority)) {
                        k.qg("TTAdSdk-InitChecker", "AndroidManifest.xml中TTMultiProvider配置异常：android:authorities，请参考接入文档");
                        com.byazt.lq.s.s(3, "0");
                    } else {
                        com.byazt.lq.s.s(3, "1");
                    }
                    z = true;
                } else if (providerInfo.authority.equals(packageName + ".TTFileProvider")) {
                    if (i < 24) {
                        com.byazt.lq.s.s(3, "1");
                    } else {
                        if (providerInfo.exported) {
                            k.qg("TTAdSdk-InitChecker", "AndroidManifest.xml中TTFileProvider配置异常：android:exported，请参考接入文档");
                            com.byazt.lq.s.s(3, "0");
                        }
                        if (!providerInfo.grantUriPermissions) {
                            k.qg("TTAdSdk-InitChecker", "AndroidManifest.xml中TTFileProvider配置异常：android:grantUriPermissions，请参考接入文档");
                            com.byazt.lq.s.s(3, "0");
                        }
                        try {
                            List<n> listN = n(context, Integer.valueOf(String.valueOf(packageManager.getProviderInfo(new ComponentName(packageName, providerInfo.name), 128).metaData.get("android.support.FILE_PROVIDER_PATHS"))).intValue());
                            if (listN != null && !listN.isEmpty()) {
                                List<n> listS = s();
                                List<n> listQ = q();
                                for (n nVar : listN) {
                                    if (nVar != null) {
                                        listS.remove(nVar);
                                        listQ.remove(nVar);
                                    }
                                }
                                if (listS.isEmpty() && listQ.isEmpty()) {
                                    com.byazt.lq.s.s(3, "1");
                                } else {
                                    Iterator<n> it = listS.iterator();
                                    while (it.hasNext()) {
                                        k.qg("TTAdSdk-InitChecker", "    TTFileProvider缺少必要路径：" + it.next().toString());
                                    }
                                    Iterator<n> it2 = listQ.iterator();
                                    while (it2.hasNext()) {
                                        k.qg("TTAdSdk-InitChecker", "    TTFileProvider缺少可选路径：" + it2.next().toString());
                                    }
                                    com.byazt.lq.s.s(3, "0");
                                }
                            } else {
                                k.qg("TTAdSdk-InitChecker", "AndroidManifest.xml中TTFileProvider中路径配置异常，请参考接入文档");
                                com.byazt.lq.s.s(3, "0");
                            }
                        } catch (Throwable th) {
                            k.n("TTAdSdk-InitChecker", "AndroidManifest.xml中TTFileProvider配置错误，请参考接入文档", th);
                            com.byazt.lq.s.s(3, "0");
                        }
                    }
                    z2 = true;
                }
            }
            try {
                String[] strArr = packageManager.getPackageInfo(packageName, 4096).requestedPermissions;
                if (strArr != null && strArr.length > 0) {
                    List<String> listQg = qg();
                    for (String str2 : strArr) {
                        if (str2 != null) {
                            listQg.remove(str2);
                        }
                    }
                    if (!listQg.isEmpty()) {
                        Iterator<String> it3 = listQg.iterator();
                        while (it3.hasNext()) {
                            k.qg("TTAdSdk-InitChecker", "    可能缺少权限：" + it3.next() + "，请参考接入文档");
                        }
                    }
                } else {
                    k.qg("TTAdSdk-InitChecker", "AndroidManifest.xml中uses-permission配置丢失，请参考接入文档");
                }
            } catch (Throwable th2) {
                k.n("TTAdSdk-InitChecker", "AndroidManifest.xml中uses-permission配置错误，请参考接入文档", th2);
            }
            if (i >= 23) {
                try {
                    boolean zN = com.byazt.af.x.n().n(context, c.a);
                    boolean zN2 = com.byazt.af.x.n().n(context, "android.permission.ACCESS_COARSE_LOCATION");
                    boolean zN3 = com.byazt.af.x.n().n(context, "android.permission.ACCESS_FINE_LOCATION");
                    boolean zN4 = com.byazt.af.x.n().n(context, c.b);
                    if (!zN) {
                        k.qg("TTAdSdk-InitChecker", "动态权限没有获取，可能影响转化：android.permission.READ_PHONE_STATE");
                    }
                    if (!zN2) {
                        k.qg("TTAdSdk-InitChecker", "动态权限没有获取，可能影响转化：android.permission.ACCESS_COARSE_LOCATION");
                    }
                    if (!zN3) {
                        k.qg("TTAdSdk-InitChecker", "动态权限没有获取，可能影响转化：android.permission.ACCESS_FINE_LOCATION");
                    }
                    if (!zN4) {
                        k.qg("TTAdSdk-InitChecker", "动态权限没有获取，可能影响转化：android.permission.WRITE_EXTERNAL_STORAGE");
                    }
                } catch (Throwable th3) {
                    k.n("TTAdSdk-InitChecker", "动态权限获取异常，请检查并详细阅读接入文档", th3);
                }
            }
            if (!z) {
                k.qg("TTAdSdk-InitChecker", "××您没有配置TTMultiProvider，请参考接入文档，否则影响转化××");
            }
            if (z2) {
                return;
            }
            k.qg("TTAdSdk-InitChecker", "××您没有配置TTFileProvider，请参考接入文档，否则影响转化××");
        }
    }

    private static String n(Context context) {
        try {
            return ((com.byazt.vf.l) com.byazt.qp.q.n("app_process")).qg();
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    private static List<String> qg() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.INTERNET");
        arrayList.add("android.permission.ACCESS_NETWORK_STATE");
        arrayList.add("android.permission.ACCESS_WIFI_STATE");
        arrayList.add(c.a);
        arrayList.add(c.b);
        arrayList.add("android.permission.REQUEST_INSTALL_PACKAGES");
        arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
        arrayList.add("android.permission.ACCESS_FINE_LOCATION");
        return arrayList;
    }

    private static List<n> s() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new n("external-path", "tt_external_download", "Download"));
        arrayList.add(new n("external-files-path", "tt_external_files_download", "Download"));
        arrayList.add(new n("files-path", "tt_internal_file_download", "Download"));
        arrayList.add(new n("cache-path", "tt_internal_cache_download", "Download"));
        return arrayList;
    }

    private static List<n> q() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new n("external-path", "tt_external_root", i.E));
        return arrayList;
    }

    private static List<n> n(Context context, int i) {
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
                            if (attributeName.equals(TapEventParamConstants.PARAM_NAME)) {
                                attributeValue = xml.getAttributeValue(i2);
                            } else if (attributeName.equals("path")) {
                                attributeValue2 = xml.getAttributeValue(i2);
                            }
                        }
                        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(attributeValue) && !TextUtils.isEmpty(attributeValue2)) {
                            arrayList.add(new n(name, attributeValue, attributeValue2));
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

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME})
    private static class n {
        public String n;
        public String qg;
        public String s;

        public n(String str, String str2, String str3) {
            this.n = str;
            this.qg = str2;
            this.s = str3;
        }

        public boolean equals(Object obj) {
            String str;
            if (obj instanceof n) {
                n nVar = (n) obj;
                String str2 = this.n;
                return str2 != null && str2.equals(nVar.n) && (str = this.s) != null && str.equals(nVar.s);
            }
            return super.equals(obj);
        }

        public String toString() {
            try {
                return "<" + this.n + " name=\"" + this.qg + "\" path=\"" + this.s + "\" />";
            } catch (Throwable unused) {
                return super.toString();
            }
        }
    }
}
