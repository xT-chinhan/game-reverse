package com.bytedance.sdk.openadsdk.core.yu.ms;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.d.j;
import com.anythink.core.common.m.e;
import com.anythink.dlopt.common.a.a;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.component.ch.ab;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.component.utils.ka;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.u;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.re;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    private static long ny;
    private static long x;
    private EventListener c;
    private FileOutputStream d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final String f3805ms = File.separator + "next";
    private static final String xr = File.separator + "tmp";
    private static final String ah = File.separator + "conf";
    private static final xr ka = new xr();
    private static final HashMap<String, String> ab = new HashMap<>();

    private xr() {
    }

    public static xr ms() {
        return ka;
    }

    public void ms(final JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        final Context applicationContext = re.getContext().getApplicationContext();
        ab.xr(new ny("updatePlugin") { // from class: com.bytedance.sdk.openadsdk.core.yu.ms.xr.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    xr.this.ms(applicationContext, (List<ms>) xr.ah(jSONArray));
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0033  */
    private boolean ms(Context context, int i, String str) {
        int iMs = ch.ub().i().ms(str);
        if (ch.ub().xn()) {
            return ms(iMs);
        }
        if (i == -1) {
            i = iMs;
        } else if (i != 1 && i != 2 && i != 3) {
            if (i == 4 || i == 5) {
                return false;
            }
            if (iMs == 3) {
                i = 1;
            } else {
                i = iMs;
            }
        }
        return ms(i);
    }

    private boolean ms(int i) {
        if (i != 1) {
            if (i == 3 || i == 4 || i == 5) {
                return false;
            }
        } else if (!u.d(re.getContext())) {
            return false;
        }
        return true;
    }

    public void ms(EventListener eventListener) {
        this.c = eventListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(final Context context, List<ms> list) {
        synchronized ("__tt_pl_up_lock__") {
            try {
                try {
                    if (ms(context)) {
                        list.size();
                        final CountDownLatch countDownLatch = new CountDownLatch(list.size());
                        for (final ms msVar : list) {
                            ab.xr(new ny("pl download") { // from class: com.bytedance.sdk.openadsdk.core.yu.ms.xr.2
                                @Override // java.lang.Runnable
                                public void run() throws Exception {
                                    xr.this.ms(context, msVar);
                                    countDownLatch.countDown();
                                }
                            });
                        }
                        countDownLatch.await();
                        xr(context);
                        return;
                    }
                    xr(context);
                } catch (Exception e) {
                    com.bytedance.sdk.openadsdk.core.t.u.ms().ms("", 6923, 0, "", 14, e.getMessage(), 0L);
                    sl.xr("PluginUpdater", "Handle file error: " + e);
                }
            } catch (Throwable th) {
                xr(context);
                throw th;
            }
        }
    }

    private boolean ms(Context context) {
        try {
            File fileD = d(context);
            if (!fileD.exists()) {
                fileD.mkdirs();
            }
            File file = new File(fileD, "update.lock");
            if (!file.exists()) {
                file.createNewFile();
            }
            if (!file.exists()) {
                sl.xr("PluginUpdater", "create lock file failed");
                return false;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            this.d = fileOutputStream;
            FileLock fileLockTryLock = fileOutputStream.getChannel().tryLock();
            if (fileLockTryLock != null && fileLockTryLock.isValid()) {
                return true;
            }
            sl.xr("PluginUpdater", "Acquire file lock failed");
            this.d.close();
            return false;
        } catch (Throwable th) {
            FileOutputStream fileOutputStream2 = this.d;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused) {
                }
            }
            sl.xr("PluginUpdater", "Try get file lock failed:" + th);
            return false;
        }
    }

    private void xr(Context context) {
        FileOutputStream fileOutputStream = this.d;
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Exception e) {
                sl.ms(e);
            }
        }
        File fileD = d(context);
        if (fileD.exists()) {
            for (File file : fileD.listFiles()) {
                try {
                    if (!"update.lock".equals(file.getName())) {
                        file.delete();
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    private static File ah(Context context) {
        return com.bytedance.sdk.openadsdk.api.plugin.xr.ms(context, "tt_pangle_bykv_file", 0);
    }

    private static File d(Context context) {
        return new File(ah(context), xr);
    }

    private static File ka(Context context) {
        return new File(ah(context), f3805ms);
    }

    private static File c(Context context) {
        return new File(ah(context), ah);
    }

    private static boolean ms(ms msVar) {
        return "com.byted.pangle".equals(msVar.f3809ms);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(Context context, ms msVar) throws Exception {
        int iMs;
        String message;
        try {
            if (!ms(context, msVar.ch, msVar.f3809ms)) {
                message = ch.ub().i() + ":" + msVar.ch;
                iMs = 20;
            } else {
                iMs = ms(context, d(context), msVar);
                ms(msVar, iMs);
                message = "";
            }
        } catch (C0329xr e) {
            iMs = e.ms();
            message = e.getMessage();
            ms(msVar.f3809ms, 1004);
        }
        com.bytedance.sdk.openadsdk.core.t.u.ms().ms(msVar.f3809ms, ms(msVar) ? 6923 : 0, msVar.xr, msVar.d, iMs, message, ny - x);
    }

    private void ms(ms msVar, int i) {
        if (this.c == null || !xr(msVar, i)) {
            return;
        }
        ValueSet valueSetXr = com.bykv.ms.ms.ms.ms.xr.ms().ms(2, msVar.toString()).ms(3, msVar.f3809ms).xr();
        boolean z = i == 6 || i == 10 || i == 16;
        try {
            ValueSet valueSetOnEvent = this.c.onEvent(1, com.bykv.ms.ms.ms.ms.ms.ms().ms(z).ms(z ? 0 : 1004).ms(valueSetXr).xr());
            if (valueSetOnEvent == null || !valueSetOnEvent.booleanValue(4) || msVar.hi == null) {
                return;
            }
            HashMap<String, String> map = ab;
            map.put(msVar.f3809ms, new File(msVar.hi).getName());
            ms(msVar.f3809ms, msVar.ah);
            map.values();
        } catch (Exception e) {
            sl.ah("PluginUpdater", "Download pl done, but install error:" + e.getMessage());
        }
    }

    private boolean xr(ms msVar, int i) {
        ms(msVar);
        return (i == 21 || i == 18) ? false : true;
    }

    private static void ms(String str, String str2) {
        if (str == null) {
            return;
        }
        ch.ub().ms(str, str2);
    }

    private static int ms(Context context, File file, ms msVar) throws Exception {
        if (msVar == null) {
            return 2;
        }
        try {
            if (TextUtils.isEmpty(msVar.d)) {
                return 2;
            }
            if (TextUtils.isEmpty(msVar.f3809ms)) {
                return 12;
            }
            if (!ms(msVar) && !ch.ub().of().has(msVar.f3809ms)) {
                return 17;
            }
            if (ah(msVar)) {
                return 18;
            }
            if (xr(msVar.xr)) {
                return 21;
            }
            if (!xr(msVar)) {
                return 19;
            }
            File fileC = c(context);
            if (!fileC.exists()) {
                fileC.mkdirs();
            }
            boolean z = true;
            if (ms(msVar) && g.xr >= msVar.xr) {
                String str = "-" + ka.xr(msVar.f3809ms) + "-" + g.xr + "-" + g.xr;
                msVar.ny = g.xr;
                msVar.x = g.xr;
                msVar.ab = true;
                ms(new File(fileC, str + ".conf"), msVar);
                return 10;
            }
            if (TextUtils.isEmpty(msVar.ka) && !msVar.ms()) {
                return 1;
            }
            String strXr = ka.xr(msVar.f3809ms);
            StringBuilder sb = new StringBuilder();
            String strXr2 = ka.xr(msVar.ka);
            if (!TextUtils.isEmpty(strXr2)) {
                sb.append(strXr2).append("-");
            }
            sb.append(strXr).append("-").append(msVar.x).append("-").append(msVar.ny);
            String string = sb.toString();
            File fileKa = ka(context);
            if (!fileKa.exists()) {
                fileKa.mkdirs();
            }
            File file2 = new File(fileKa, string + (msVar.ms() ? ".dex.zip" : a.h));
            if (file2.exists()) {
                msVar.c = ka.ms(file2);
                msVar.hi = file2.getAbsolutePath();
                return 16;
            }
            if (file2.getName().equals(ab.get(msVar.f3809ms))) {
                return 21;
            }
            com.bytedance.sdk.openadsdk.core.t.u.ms().ms(msVar.f3809ms, ms(msVar) ? 6923 : 0, msVar.xr, msVar.d, 7, "", 0L);
            File file3 = new File(file, string);
            com.bytedance.sdk.component.ny.xr.xr xrVarD = com.bytedance.sdk.openadsdk.core.re.ka.ms().xr().d();
            xrVarD.ms(msVar.d);
            xrVarD.ms(file.getAbsolutePath(), string);
            x = System.currentTimeMillis();
            com.bytedance.sdk.component.ny.xr xrVarMs = xrVarD.ms();
            if (xrVarMs != null && xrVarMs.x()) {
                ny = System.currentTimeMillis();
                if (!file3.exists()) {
                    return 13;
                }
                ms(fileKa, strXr);
                ms(fileC, strXr);
                if (!file3.renameTo(file2)) {
                    return 5;
                }
                File file4 = new File(fileC, file3.getName() + ".conf");
                msVar.c = ka.ms(file2);
                msVar.hi = file2.getAbsolutePath();
                if (msVar.xr >= d(msVar)) {
                    z = false;
                }
                msVar.ab = z;
                return ms(file4, msVar) ? 6 : 15;
            }
            throw new C0329xr(9, xrVarMs != null ? xrVarMs.ms() + " : " + xrVarMs.xr() : "no response");
        } catch (Exception e) {
            sl.xr("PluginUpdater", "Download file error: " + e);
            if (e instanceof C0329xr) {
                throw e;
            }
            throw new C0329xr(14, e.getMessage());
        }
    }

    private static boolean xr(ms msVar) {
        int iXr;
        JSONObject jSONObjectOptJSONObject;
        if (ms(msVar)) {
            iXr = g.xr;
        } else {
            iXr = (!ch.ub().of().has(msVar.f3809ms) || (jSONObjectOptJSONObject = ch.ub().of().optJSONObject(msVar.f3809ms)) == null) ? 0 : xr(jSONObjectOptJSONObject.optString("sdk_version"));
        }
        return iXr >= msVar.x && iXr <= msVar.ny;
    }

    private static boolean ah(ms msVar) {
        if (ms(msVar)) {
            return 6923 == msVar.xr;
        }
        JSONObject jSONObjectOptJSONObject = ch.ub().of().optJSONObject(msVar.f3809ms);
        return (jSONObjectOptJSONObject != null ? xr(jSONObjectOptJSONObject.optString(PluginConstants.KEY_PLUGIN_VERSION)) : 0) == msVar.xr;
    }

    private static boolean xr(int i) {
        File fileMs = com.bytedance.sdk.openadsdk.api.plugin.xr.ms(re.getContext());
        if (fileMs == null) {
            return false;
        }
        return new File(fileMs.getParent() + "/pangle_p/com.byted.pangle/version-" + i).exists();
    }

    private static int d(ms msVar) {
        int iXr;
        if (ms(msVar)) {
            iXr = 6923;
        } else {
            if (!ch.ub().of().has(msVar.f3809ms)) {
                return 0;
            }
            JSONObject jSONObjectOptJSONObject = ch.ub().of().optJSONObject(msVar.f3809ms);
            iXr = jSONObjectOptJSONObject != null ? xr(jSONObjectOptJSONObject.optString(PluginConstants.KEY_PLUGIN_VERSION)) : 0;
        }
        return iXr;
    }

    private static boolean ms(File file, ms msVar) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(msVar.toString());
            fileWriter.close();
            return true;
        } catch (IOException unused) {
            sl.xr("PluginUpdater", "Write config failed;");
            return false;
        }
    }

    private static void ms(File file, final String str) {
        file.listFiles(new FilenameFilter() { // from class: com.bytedance.sdk.openadsdk.core.yu.ms.xr.3
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str2) {
                if (str2 == null || !str2.contains(str)) {
                    return false;
                }
                new File(file2, str2).delete();
                sl.xr("PluginUpdater", "Delete file: ".concat(String.valueOf(str2)));
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<ms> ah(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                ms msVar = new ms();
                msVar.f3809ms = ms(jSONObjectOptJSONObject.optString("package_name"));
                msVar.xr = jSONObjectOptJSONObject.optInt("version_code");
                msVar.ah = jSONObjectOptJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
                msVar.d = jSONObjectOptJSONObject.optString("download_url");
                msVar.ka = jSONObjectOptJSONObject.optString(e.X);
                msVar.x = xr(jSONObjectOptJSONObject.optString("min_version"));
                msVar.ny = xr(jSONObjectOptJSONObject.optString("max_version"));
                msVar.ch = jSONObjectOptJSONObject.optInt("plugin_update_network", -2);
                arrayList.add(msVar);
            }
        }
        return arrayList;
    }

    public static String xr() {
        String str;
        String strMs = com.bytedance.sdk.openadsdk.core.yu.xr.xr.ms();
        if ("arm64-v8a".equals(strMs)) {
            str = "@64";
        } else if ("armeabi-v7a".equals(strMs)) {
            str = "@32";
        } else {
            str = "armeabi".equals(strMs) ? "@armeabi" : "";
        }
        return "com.byted.live.lite".concat(str);
    }

    public static String ms(String str) {
        return ("com.byted.live.lite@64".equals(str) || "com.byted.live.lite@32".equals(str) || "com.byted.live.lite@armeabi".equals(str)) ? "com.byted.live.lite" : str;
    }

    private static int xr(String str) {
        if (str != null) {
            try {
                return Integer.parseInt(str.replace(j.z, ""));
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public void ms(String str, int i) {
        if (this.c == null) {
            return;
        }
        this.c.onEvent(1, com.bykv.ms.ms.ms.ms.ms.ms().ms(false).ms(i).ms(com.bykv.ms.ms.ms.ms.xr.ms().ms(3, str).xr()).xr());
    }

    private static final class ms {
        public boolean ab;
        public String ah;
        public String c;
        public int ch;
        public String d;
        public String hi;
        public String ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public String f3809ms;
        public int ny;
        public int x;
        public int xr;

        private ms() {
        }

        public String toString() {
            try {
                return new JSONObject().put("package_name", this.f3809ms).put("version_code", this.xr).put(e.X, this.ka).put("max_version", this.ny).put("min_version", this.x).put("is_revert", this.ab).put("md5", this.c).put("plugin_file", this.hi).toString();
            } catch (JSONException unused) {
                return "";
            }
        }

        public boolean ms() {
            return TextUtils.equals(this.f3809ms, "com.byted.mixed");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.yu.ms.xr$xr, reason: collision with other inner class name */
    private static final class C0329xr extends Exception {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private int f3810ms;

        public C0329xr(int i, String str) {
            super(str);
            this.f3810ms = i;
        }

        int ms() {
            return this.f3810ms;
        }
    }
}
