package com.byazt.te;

import android.app.ActivityManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.anythink.core.e.i;
import com.byazt.gh.qg;
import com.byazt.lk.l;
import com.byazt.nf.rv;
import com.byazt.phf.s;
import com.byazt.qk.oa;
import com.byazt.qp.q;
import com.byazt.vf.k;
import com.byazt.vgx.w;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1158, 19})
public class n implements qg {
    public static volatile n n;
    public static final FileFilter qg = new FileFilter() { // from class: com.byazt.te.n.1
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

    @Override // com.byazt.gh.qg
    public String n() {
        return "DeviceRate";
    }

    public static n qg() {
        if (n == null) {
            synchronized (n.class) {
                if (n == null) {
                    n = new n();
                }
            }
        }
        return n;
    }

    public static long n(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }

    public static int s() {
        int iIntValue = -1;
        for (int i = 0; i < q(); i++) {
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
                int iN = n("cpu MHz", fileInputStream2) * 1000;
                if (iN > iIntValue) {
                    iIntValue = iN;
                }
            } finally {
                fileInputStream2.close();
            }
        }
        return iIntValue;
    }

    public static int q() {
        try {
            int iQ = q("/sys/devices/system/cpu/possible");
            if (iQ == -1) {
                iQ = q("/sys/devices/system/cpu/present");
            }
            return iQ == -1 ? new File("/sys/devices/system/cpu/").listFiles(qg).length : iQ;
        } catch (NullPointerException | SecurityException unused) {
            return -1;
        }
    }

    private static int q(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                String line = bufferedReader.readLine();
                bufferedReader.close();
                int iL = l(line);
                fileInputStream.close();
                return iL;
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

    private static int l(String str) {
        if (str == null || !str.matches("0-[\\d]+$")) {
            return -1;
        }
        return Integer.valueOf(str.substring(2)).intValue() + 1;
    }

    private static int n(String str, FileInputStream fileInputStream) {
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
                            return n(bArr, i3);
                        }
                    }
                }
                i2++;
            }
            return -1;
        } catch (IOException | NumberFormatException unused) {
            return -1;
        }
    }

    private static int n(byte[] bArr, int i) {
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

    public void n(String str) {
        if (rv.qg().zo() && qg(str)) {
            x(str);
        }
        try {
            double d = Double.parseDouble(com.byazt.gh.n.n().n("DeviceRate", "bytebench_value", str));
            boolean zYq = rv.qg().yq();
            if (zYq && rv.qg().gf() && !"1".equals(n("bytebench_pro_flag", str))) {
                w(str);
            } else if (d <= 0.0d || (zYq && s(str))) {
                w(str);
            }
        } catch (Throwable unused) {
        }
    }

    private void w(String str) {
        String str2 = "1";
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TapEventParamConstants.PARAM_SUB_OS, "android");
            jSONObject.put(TapEventParamConstants.PARAM_SUB_DEVICE_MODEL, Build.MODEL);
            oa oaVarL = s.l(Uri.parse(w.rv("/api/ad/union/sdk/device_score")).buildUpon().appendQueryParameter("is_bidding", "1").appendQueryParameter("extra", ((k) q.n("encrypt_service")).s(jSONObject.toString())).toString());
            if (oaVarL == null || !oaVarL.x()) {
                return;
            }
            JSONObject jSONObjectL = oaVarL.l();
            if (jSONObjectL.optInt("code") == 200) {
                boolean zGf = rv.qg().gf();
                double dOptDouble = zGf ? jSONObjectL.optDouble("pro_score") : jSONObjectL.optDouble("score");
                if (dOptDouble > 0.0d) {
                    n("bytebench_update_time", String.valueOf(System.currentTimeMillis()), str);
                    n("bytebench_value", String.valueOf(dOptDouble), str);
                    if (!zGf) {
                        str2 = "0";
                    }
                    n("bytebench_pro_flag", str2, str);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("score", dOptDouble);
                    com.byazt.eji.s.n().rv(jSONObject2);
                    return;
                }
                n("bytebench_value", "-1.0", str);
                return;
            }
            n("bytebench_value", "-1.0", str);
        } catch (Exception unused) {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("score", -1);
                com.byazt.eji.s.n().rv(jSONObject3);
            } catch (JSONException unused2) {
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x001f  */
    private int x(String str) {
        int iQg = qg(rv.getContext());
        int iL = l();
        int i = 2;
        if (iQg != 0 && iQg != 1 && iL != 0) {
            if (iQg == 2 && iL > 0) {
                i = 1;
            } else if (iQg <= 2) {
                i = -1000;
            } else if (iL > 1) {
                i = 0;
            } else {
                i = 1;
            }
        }
        n("ram_level", String.valueOf(iQg), str);
        n("cpu_level", String.valueOf(iL), str);
        n(com.anythink.core.common.f.k.a.g, String.valueOf(System.currentTimeMillis()), str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(TapEventParamConstants.PARAM_SUB_RAM, iQg);
            jSONObject.put("cpu", iL);
            jSONObject.put("level", i);
        } catch (JSONException unused) {
        }
        com.byazt.eji.s.n().fs(jSONObject);
        n(i, str);
        return i;
    }

    public boolean qg(String str) {
        String strN = n(com.anythink.core.common.f.k.a.g, str);
        return strN.isEmpty() || System.currentTimeMillis() - Long.parseLong(strN) >= 2592000000L;
    }

    public boolean s(String str) {
        String strN = n("bytebench_update_time", str);
        return strN.isEmpty() || System.currentTimeMillis() - Long.parseLong(strN) >= i.f;
    }

    private static int qg(Context context) {
        long jN = n(context) / 1048576;
        if (jN <= 2000) {
            return 0;
        }
        if (jN <= 3000) {
            return 1;
        }
        if (jN <= 4000) {
            return 2;
        }
        return jN <= 6000 ? 3 : 4;
    }

    private static int l() {
        int iS = s() / 1000;
        if (iS <= 1600) {
            return 0;
        }
        if (iS <= 2000) {
            return 1;
        }
        return iS <= 2500 ? 2 : 3;
    }

    @Override // com.byazt.gh.qg
    public String n(String str, String str2) {
        return l.n(null, n()).qg(str, "");
    }

    @Override // com.byazt.gh.qg
    public void n(String str, String str2, String str3) {
        l.n(null, n()).n(str, str2);
    }

    private void n(int i, String str) {
        n("device_level", String.valueOf(i), str);
        com.byazt.ed.s.n().fs(i);
    }
}
