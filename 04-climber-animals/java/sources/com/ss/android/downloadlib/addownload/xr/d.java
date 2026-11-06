package com.ss.android.downloadlib.addownload.xr;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Pair;
import com.ss.android.downloadlib.ab.zb;
import com.ss.android.downloadlib.addownload.hi;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes3.dex */
public class d {
    private static final String[] ah = {"com", "android", "ss"};
    private static final int[] d = {3101, 3102, 3103, 3201, 3202, 3203};

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile d f4452ms;
    private final LinkedList<ms> xr = new LinkedList<>();

    private d() {
    }

    public static d ms() {
        if (f4452ms == null) {
            synchronized (d.class) {
                if (f4452ms == null) {
                    f4452ms = new d();
                }
            }
        }
        return f4452ms;
    }

    public void ms(String str) {
        ms msVarAh;
        xr();
        if (TextUtils.isEmpty(str) || (msVarAh = ah(str)) == null) {
            return;
        }
        synchronized (this.xr) {
            this.xr.add(msVarAh);
        }
    }

    public void xr(String str) {
        xr();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.xr) {
            Iterator<ms> it = this.xr.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next().f4453ms)) {
                    it.remove();
                    return;
                }
            }
        }
    }

    public ms ms(com.ss.android.downloadad.api.ms.xr xrVar) {
        if (xrVar == null) {
            return null;
        }
        xr();
        synchronized (this.xr) {
            for (ms msVar : this.xr) {
                if (msVar.ka > xrVar.cv()) {
                    return msVar;
                }
            }
            return null;
        }
    }

    public Pair<ms, Integer> xr(com.ss.android.downloadad.api.ms.xr xrVar) {
        int i;
        if (xrVar == null) {
            return null;
        }
        try {
            xr();
            if (this.xr.isEmpty()) {
                return null;
            }
            String strE = xrVar.e();
            String strKa = xrVar.ka();
            String strUl = xrVar.ul();
            int iF = xrVar.f();
            int length = d.length;
            ms[] msVarArr = new ms[length];
            synchronized (this.xr) {
                Iterator<ms> it = this.xr.iterator();
                PackageInfo packageInfoMs = null;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ms next = it.next();
                    if (next.ka >= xrVar.cv()) {
                        if (TextUtils.isEmpty(strE)) {
                            if (packageInfoMs == null) {
                                packageInfoMs = zb.ms(xrVar);
                            }
                            if (packageInfoMs != null) {
                                try {
                                    strE = (String) hi.getContext().getPackageManager().getApplicationLabel(packageInfoMs.applicationInfo);
                                } catch (Throwable unused) {
                                }
                            }
                        }
                        if (!TextUtils.isEmpty(strE) && !TextUtils.isEmpty(next.d)) {
                            strE = strE.toLowerCase();
                            if (strE.equals(next.d)) {
                                msVarArr[0] = next;
                                break;
                            }
                            if (strE.contains(next.d) || next.d.contains(strE)) {
                                msVarArr[1] = next;
                                break;
                            }
                        }
                        if (TextUtils.isEmpty(strKa)) {
                            if (packageInfoMs == null) {
                                packageInfoMs = zb.ms(xrVar);
                            }
                            if (packageInfoMs != null) {
                                strKa = packageInfoMs.packageName;
                            }
                        }
                        if (!TextUtils.isEmpty(strKa) && !TextUtils.isEmpty(next.f4453ms)) {
                            strKa = strKa.toLowerCase();
                            if (!strKa.contains(next.f4453ms) && !next.f4453ms.contains(strKa)) {
                                if (msVarArr[3] == null) {
                                    if (ms(strKa, next.f4453ms)) {
                                        msVarArr[3] = next;
                                    }
                                }
                            }
                            msVarArr[2] = next;
                            break;
                        }
                        if (msVarArr[4] == null) {
                            if (TextUtils.isEmpty(strUl)) {
                                if (packageInfoMs == null) {
                                    packageInfoMs = zb.ms(xrVar);
                                }
                                if (packageInfoMs != null) {
                                    strUl = packageInfoMs.versionName;
                                }
                            }
                            if (!TextUtils.isEmpty(strUl) && !TextUtils.isEmpty(next.ah)) {
                                strUl = strUl.toLowerCase();
                                if (strUl.equals(next.ah)) {
                                    msVarArr[4] = next;
                                }
                            }
                            if (msVarArr[5] == null) {
                                if (iF <= 0) {
                                    if (packageInfoMs == null) {
                                        packageInfoMs = zb.ms(xrVar);
                                    }
                                    if (packageInfoMs != null) {
                                        iF = packageInfoMs.versionCode;
                                    }
                                }
                                if (iF == next.xr) {
                                    msVarArr[5] = next;
                                }
                            }
                        }
                    }
                }
            }
            for (i = 0; i < length; i++) {
                if (msVarArr[i] != null) {
                    return new Pair<>(msVarArr[i], Integer.valueOf(d[i]));
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
        }
        return null;
    }

    private void xr() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this.xr) {
            Iterator<ms> it = this.xr.iterator();
            while (it.hasNext() && jCurrentTimeMillis - it.next().ka > 1800000) {
                it.remove();
            }
        }
    }

    private ms ah(String str) {
        try {
            PackageManager packageManager = hi.getContext().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return new ms(str, packageInfo.versionCode, packageInfo.versionName, (String) packageManager.getApplicationLabel(packageInfo.applicationInfo), System.currentTimeMillis());
            }
            return null;
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
            return null;
        }
    }

    private static boolean ms(String str, String str2) {
        boolean z;
        try {
            String[] strArrSplit = str.split("\\.");
            String[] strArrSplit2 = str2.split("\\.");
            if (strArrSplit.length != 0 && strArrSplit2.length != 0) {
                int i = 0;
                int i2 = 0;
                for (String str3 : strArrSplit) {
                    String[] strArr = ah;
                    int length = strArr.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            z = false;
                            break;
                        }
                        String str4 = strArr[i3];
                        if (str4.equals(str3)) {
                            if (i < strArrSplit2.length && str4.equals(strArrSplit2[i])) {
                                i++;
                            }
                            z = true;
                            break;
                        }
                        i3++;
                    }
                    if (!z) {
                        int i4 = i2;
                        int i5 = i;
                        while (i < strArrSplit2.length) {
                            if (str3.equals(strArrSplit2[i])) {
                                if (i == i5) {
                                    i5++;
                                }
                                i4++;
                                if (i4 >= 2) {
                                    return true;
                                }
                            }
                            i++;
                        }
                        i = i5;
                        i2 = i4;
                    }
                }
                return false;
            }
            return false;
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
        }
    }

    public static class ms {
        public final String ah;
        public final String d;
        public final long ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public final String f4453ms;
        public final int xr;

        private ms(String str, int i, String str2, String str3, long j) {
            this.f4453ms = str;
            this.xr = i;
            this.ah = str2 != null ? str2.toLowerCase() : null;
            this.d = str3 != null ? str3.toLowerCase() : null;
            this.ka = j;
        }
    }
}
