package com.byazt.no;

import android.app.ActivityManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.byazt.ba.hw;
import com.byazt.hcx.m;
import com.byazt.mg.PluginConstants;
import com.byazt.ol.TTDownloadField;
import com.byazt.qn.x;
import com.byazt.sd.a;
import com.byazt.tf.hn;
import com.byazt.vkw.nt;
import com.byazt.wt.ls;
import com.byazt.zs.uc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.db.constant.Common;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_REAL_TIME, 37})
public class pr implements hw {
    public static final FileFilter hw = new FileFilter() { // from class: com.byazt.no.pr.1
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
    public static volatile pr pr;

    public static pr hw() {
        if (pr == null) {
            synchronized (pr.class) {
                if (pr == null) {
                    pr = new pr();
                }
            }
        }
        return pr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9 */
    public static long pr(Context context) {
        long j;
        if (Build.VERSION.SDK_INT >= 16) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getMemoryInfo(memoryInfo);
            return memoryInfo.totalMem;
        }
        ?? Pr = -1;
        Pr = -1;
        try {
            FileInputStream fileInputStream = new FileInputStream("/proc/meminfo");
            try {
                Pr = pr("MemTotal", fileInputStream);
            } finally {
                fileInputStream.close();
            }
        } catch (IOException e) {
            j = Pr;
        }
        return j;
    }

    public static int hn() {
        int iIntValue = -1;
        for (int i = 0; i < x(); i++) {
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
                        fileInputStream.close();
                    } catch (NumberFormatException e) {
                        fileInputStream.close();
                    } catch (Throwable th) {
                        fileInputStream.close();
                        throw th;
                    }
                }
            } catch (IOException e2) {
                return -1;
            }
        }
        if (iIntValue == -1) {
            FileInputStream fileInputStream2 = new FileInputStream("/proc/cpuinfo");
            try {
                int iPr = pr("cpu MHz", fileInputStream2) * 1000;
                if (iPr > iIntValue) {
                    iIntValue = iPr;
                }
                return iIntValue;
            } finally {
                fileInputStream2.close();
            }
        }
        return iIntValue;
    }

    public static int x() {
        if (Build.VERSION.SDK_INT <= 10) {
            return 1;
        }
        try {
            int iX = x("/sys/devices/system/cpu/possible");
            if (iX == -1) {
                iX = x("/sys/devices/system/cpu/present");
            }
            if (iX != -1) {
                return iX;
            }
            return new File("/sys/devices/system/cpu/").listFiles(hw).length;
        } catch (NullPointerException e) {
            return -1;
        } catch (SecurityException e2) {
            return -1;
        }
    }

    private static int x(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                String line = bufferedReader.readLine();
                bufferedReader.close();
                int iC = c(line);
                fileInputStream.close();
                return iC;
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
        } catch (IOException e) {
            return -1;
        }
    }

    private static int c(String str) {
        if (str == null || !str.matches("0-[\\d]+$")) {
            return -1;
        }
        return Integer.valueOf(str.substring(2)).intValue() + 1;
    }

    private static int pr(String str, FileInputStream fileInputStream) {
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
                            return pr(bArr, i3);
                        }
                    }
                }
                i2++;
            }
            return -1;
        } catch (IOException e) {
            return -1;
        } catch (NumberFormatException e2) {
            return -1;
        }
    }

    private static int pr(byte[] bArr, int i) {
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

    public void pr(String str) {
        if (a.hw().ez() && hw(str)) {
            fw(str);
        }
        try {
            if (Double.parseDouble(com.byazt.ba.pr.pr().pr("DeviceRate", "bytebench_value", str)) <= 0.0d || (a.hw().zn() && hn(str))) {
                uc(str);
            }
        } catch (Throwable th) {
        }
    }

    private void uc(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("os", "android");
            jSONObject.put("device_model", Build.MODEL);
            m mVarC = hn.c(Uri.parse(ls.aj("/api/ad/union/sdk/device_score")).buildUpon().appendQueryParameter("is_bidding", "1").appendQueryParameter("extra", ((nt) uc.pr("encrypt_service")).hn(jSONObject.toString())).toString());
            if (mVarC != null && mVarC.fw()) {
                JSONObject jSONObjectC = mVarC.c();
                if (jSONObjectC.optInt(PluginConstants.KEY_ERROR_CODE) == 200) {
                    double dOptDouble = jSONObjectC.optDouble("score");
                    if (dOptDouble > 0.0d) {
                        pr("bytebench_update_time", String.valueOf(System.currentTimeMillis()), str);
                        pr("bytebench_value", String.valueOf(dOptDouble), str);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("score", dOptDouble);
                        com.byazt.xk.hw.pr().zo(jSONObject2);
                        return;
                    }
                    pr("bytebench_value", "-1.0", str);
                    return;
                }
                pr("bytebench_value", "-1.0", str);
            }
        } catch (Exception e) {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("score", -1);
                com.byazt.xk.hw.pr().zo(jSONObject3);
            } catch (JSONException e2) {
            }
        }
    }

    private int fw(String str) {
        int iHw = hw(a.getContext());
        int iC = c();
        int i = 1;
        if (iHw == 0 || iHw == 1 || iC == 0) {
            i = 2;
        } else if (iHw != 2 || iC <= 0) {
            if (iHw <= 2) {
                i = -1000;
            } else if (iC > 1) {
                i = 0;
            }
        }
        pr("ram_level", String.valueOf(iHw), str);
        pr("cpu_level", String.valueOf(iC), str);
        pr("update_time", String.valueOf(System.currentTimeMillis()), str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Common.Predefined.SUB_RAM, iHw);
            jSONObject.put("cpu", iC);
            jSONObject.put("level", i);
        } catch (JSONException e) {
        }
        com.byazt.xk.hw.pr().fw(jSONObject);
        pr(i, str);
        return i;
    }

    public boolean hw(String str) {
        String strPr = pr("update_time", str);
        return strPr.isEmpty() || System.currentTimeMillis() - Long.parseLong(strPr) >= 2592000000L;
    }

    public boolean hn(String str) {
        String strPr = pr("bytebench_update_time", str);
        return strPr.isEmpty() || System.currentTimeMillis() - Long.parseLong(strPr) >= 2592000000L;
    }

    private static int hw(Context context) {
        long jPr = pr(context) / 1048576;
        if (jPr <= 2000) {
            return 0;
        }
        if (jPr <= 3000) {
            return 1;
        }
        if (jPr <= 4000) {
            return 2;
        }
        if (jPr <= 6000) {
            return 3;
        }
        return 4;
    }

    private static int c() {
        int iHn = hn() / 1000;
        if (iHn <= 1600) {
            return 0;
        }
        if (iHn <= 2000) {
            return 1;
        }
        if (iHn <= 2500) {
            return 2;
        }
        return 3;
    }

    @Override // com.byazt.ba.hw
    public String pr() {
        return "DeviceRate";
    }

    @Override // com.byazt.ba.hw
    public String pr(String str, String str2) {
        return x.pr(null, pr()).hw(str, "");
    }

    @Override // com.byazt.ba.hw
    public void pr(String str, String str2, String str3) {
        x.pr(null, pr()).pr(str, str2);
    }

    private void pr(int i, String str) {
        pr("device_level", String.valueOf(i), str);
        com.byazt.mp.x.pr().zo(i);
    }
}
