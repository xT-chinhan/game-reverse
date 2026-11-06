package com.bytedance.sdk.openadsdk.core.w.ms;

import android.app.ActivityManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.anythink.basead.exoplayer.i.a;
import com.bytedance.sdk.component.ny.xr.ah;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.ah.d;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.re.ka;
import com.bytedance.sdk.openadsdk.core.t.u;
import com.bytedance.sdk.openadsdk.core.w.xr;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile ms f3688ms;
    private static final FileFilter xr = new FileFilter() { // from class: com.bytedance.sdk.openadsdk.core.w.ms.ms.1
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            if (!name.startsWith("cpu")) {
                return false;
            }
            for (int i = 3; i < name.length(); i++) {
                if (!Character.isDigit(name.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    };

    @Override // com.bytedance.sdk.openadsdk.core.w.xr
    public String ms() {
        return "DeviceRate";
    }

    public static ms xr() {
        if (f3688ms == null) {
            synchronized (ms.class) {
                if (f3688ms == null) {
                    f3688ms = new ms();
                }
            }
        }
        return f3688ms;
    }

    public static long ms(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }

    public static int ah() {
        int iIntValue = -1;
        for (int i = 0; i < d(); i++) {
            try {
                File file = new File("/sys/devices/system/cpu/cpu" + i + "/cpufreq/cpuinfo_max_freq");
                if (file.exists() && file.canRead()) {
                    byte[] bArr = new byte[128];
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        fileInputStream.read(bArr);
                        int i2 = 0;
                        while (Character.isDigit(bArr[i2]) && i2 < 128) {
                            i2++;
                        }
                        Integer numValueOf = Integer.valueOf(Integer.parseInt(new String(bArr, 0, i2)));
                        if (numValueOf.intValue() > iIntValue) {
                            iIntValue = numValueOf.intValue();
                        }
                    } catch (NumberFormatException unused) {
                    } catch (Throwable th) {
                        fileInputStream.close();
                        throw th;
                    }
                    fileInputStream.close();
                }
            } catch (IOException unused2) {
                return -1;
            }
        }
        if (iIntValue == -1) {
            FileInputStream fileInputStream2 = new FileInputStream("/proc/cpuinfo");
            try {
                int iMs = ms("cpu MHz", fileInputStream2) * 1000;
                if (iMs > iIntValue) {
                    iIntValue = iMs;
                }
            } finally {
                fileInputStream2.close();
            }
        }
        return iIntValue;
    }

    public static int d() {
        try {
            int iXr = xr("/sys/devices/system/cpu/possible");
            if (iXr == -1) {
                iXr = xr("/sys/devices/system/cpu/present");
            }
            return iXr == -1 ? new File("/sys/devices/system/cpu/").listFiles(xr).length : iXr;
        } catch (NullPointerException | SecurityException unused) {
            return -1;
        }
    }

    private static int xr(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                String line = bufferedReader.readLine();
                bufferedReader.close();
                int iAh = ah(line);
                fileInputStream.close();
                return iAh;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (IOException unused) {
            return -1;
        }
    }

    private static int ah(String str) {
        if (str == null || !str.matches("0-[\\d]+$")) {
            return -1;
        }
        return Integer.valueOf(str.substring(2)).intValue() + 1;
    }

    private static int ms(String str, FileInputStream fileInputStream) {
        byte[] bArr = new byte[1024];
        try {
            int i = fileInputStream.read(bArr);
            int i2 = 0;
            while (i2 < i) {
                byte b = bArr[i2];
                if (b == 10 || i2 == 0) {
                    if (b == 10) {
                        i2++;
                    }
                    for (int i3 = i2; i3 < i; i3++) {
                        int i4 = i3 - i2;
                        if (bArr[i3] != str.charAt(i4)) {
                            break;
                        }
                        if (i4 == str.length() - 1) {
                            return ms(bArr, i3);
                        }
                    }
                }
                i2++;
            }
            return -1;
        } catch (IOException | NumberFormatException e) {
            sl.ms(e);
            return -1;
        }
    }

    private static int ms(byte[] bArr, int i) {
        byte b;
        while (i < bArr.length && (b = bArr[i]) != 10) {
            if (Character.isDigit(b)) {
                int i2 = i + 1;
                while (i2 < bArr.length && Character.isDigit(bArr[i2])) {
                    i2++;
                }
                return Integer.parseInt(new String(bArr, 0, i, i2 - i));
            }
            i++;
        }
        return -1;
    }

    public void ka() {
        if (re.xr().ou() && c()) {
            ny();
        }
        if (re.xr().vt() && ab()) {
            x();
        }
    }

    private void x() {
        try {
            ah ahVarAh = ka.ms().xr().ah();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("os", "android");
            jSONObject.put("device_model", Build.MODEL);
            ahVarAh.ms(Uri.parse(f.ny("/api/ad/union/sdk/device_score")).buildUpon().appendQueryParameter("is_bidding", "1").appendQueryParameter("extra", com.bytedance.sdk.component.utils.ms.xr(jSONObject.toString())).toString());
            com.bytedance.sdk.component.ny.xr xrVarMs = ahVarAh.ms();
            if (xrVarMs == null || !xrVarMs.x()) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject(xrVarMs.d());
            if (jSONObject2.optInt("code") == 200) {
                double dOptDouble = jSONObject2.optDouble("score");
                ms("bytebench_update_time", String.valueOf(System.currentTimeMillis()));
                ms("bytebench_value", String.valueOf(dOptDouble));
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("score", dOptDouble);
                u.ms().d(jSONObject3);
                return;
            }
            ms("bytebench_value", "-1.0");
        } catch (Exception e) {
            sl.ms(e);
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject4.put("score", -1);
                u.ms().d(jSONObject4);
            } catch (JSONException e2) {
                sl.ms(e2);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x001f  */
    private int ny() {
        int iXr = xr(re.getContext());
        int iCh = ch();
        int i = 2;
        if (iXr != 0 && iXr != 1 && iCh != 0) {
            if (iXr == 2 && iCh > 0) {
                i = 1;
            } else if (iXr <= 2) {
                i = -1000;
            } else if (iCh > 1) {
                i = 0;
            } else {
                i = 1;
            }
        }
        ms("ram_level", String.valueOf(iXr));
        ms("cpu_level", String.valueOf(iCh));
        ms("update_time", String.valueOf(System.currentTimeMillis()));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ram", iXr);
            jSONObject.put("cpu", iCh);
            jSONObject.put("level", i);
        } catch (JSONException e) {
            sl.ms(e);
        }
        u.ms().ah(jSONObject);
        ms(i);
        return i;
    }

    public boolean c() {
        String strMs = ms("update_time");
        return strMs.isEmpty() || System.currentTimeMillis() - Long.parseLong(strMs) >= 15552000000L;
    }

    public boolean ab() {
        String strMs = ms("bytebench_update_time");
        return strMs.isEmpty() || System.currentTimeMillis() - Long.parseLong(strMs) >= 15552000000L;
    }

    private static int xr(Context context) {
        long jMs = ms(context) / BaseConstants.MB_VALUE;
        if (jMs <= a.f) {
            return 0;
        }
        if (jMs <= com.tapsdk.tapad.e.a.f) {
            return 1;
        }
        if (jMs <= 4000) {
            return 2;
        }
        return jMs <= 6000 ? 3 : 4;
    }

    private static int ch() {
        int iAh = ah() / 1000;
        if (iAh <= 1600) {
            return 0;
        }
        if (iAh <= 2000) {
            return 1;
        }
        return iAh <= 2500 ? 2 : 3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.w.xr
    public String ms(String str) {
        return com.bytedance.sdk.openadsdk.ats.ah.xr(ms()).xr(str, "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.w.xr
    public void ms(String str, String str2) {
        com.bytedance.sdk.openadsdk.ats.ah.xr(ms()).ms(str, str2);
    }

    private void ms(int i) {
        ms("device_level", String.valueOf(i));
        d.ms().x(i);
    }
}
