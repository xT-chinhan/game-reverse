package com.byazt.shh;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Pair;
import com.byazt.eld.k;
import com.byazt.uk.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DOWNLOAD_BYTES, 121})
public class x {
    public static volatile x pr;
    public final LinkedList<pr> hw = new LinkedList<>();
    public static final String[] hn = {"com", "android", "ss"};
    public static final int[] x = {3101, 3102, 3103, 3201, 3202, 3203};

    private x() {
    }

    public static x pr() {
        if (pr == null) {
            synchronized (x.class) {
                if (pr == null) {
                    pr = new x();
                }
            }
        }
        return pr;
    }

    public void pr(String str) {
        pr prVarHn;
        hw();
        if (!TextUtils.isEmpty(str) && (prVarHn = hn(str)) != null) {
            synchronized (this.hw) {
                this.hw.add(prVarHn);
            }
        }
    }

    public void hw(String str) {
        hw();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.hw) {
            Iterator<pr> it = this.hw.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next().pr)) {
                    it.remove();
                    return;
                }
            }
        }
    }

    public pr pr(com.byazt.tia.hw hwVar) {
        if (hwVar == null) {
            return null;
        }
        hw();
        synchronized (this.hw) {
            for (pr prVar : this.hw) {
                if (prVar.c > hwVar.gz()) {
                    return prVar;
                }
            }
            return null;
        }
    }

    public Pair<pr, Integer> hw(com.byazt.tia.hw hwVar) {
        int i;
        PackageInfo packageInfoPr;
        if (hwVar == null) {
            return null;
        }
        try {
            hw();
            if (this.hw.isEmpty()) {
                return null;
            }
            String strQn = hwVar.qn();
            String strC = hwVar.c();
            String strLs = hwVar.ls();
            int iS = hwVar.s();
            int length = x.length;
            pr[] prVarArr = new pr[length];
            synchronized (this.hw) {
                Iterator<pr> it = this.hw.iterator();
                int i2 = iS;
                String lowerCase = strLs;
                String lowerCase2 = strC;
                String lowerCase3 = strQn;
                PackageInfo packageInfoPr2 = null;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    pr next = it.next();
                    if (next.c >= hwVar.gz()) {
                        if (TextUtils.isEmpty(lowerCase3)) {
                            if (packageInfoPr2 != null) {
                                packageInfoPr = packageInfoPr2;
                            } else {
                                packageInfoPr = m.pr(hwVar);
                            }
                            if (packageInfoPr != null) {
                                try {
                                    lowerCase3 = (String) k.getContext().getPackageManager().getApplicationLabel(packageInfoPr.applicationInfo);
                                    packageInfoPr2 = packageInfoPr;
                                } catch (Throwable th) {
                                    packageInfoPr2 = packageInfoPr;
                                }
                            } else {
                                packageInfoPr2 = packageInfoPr;
                            }
                        }
                        if (!TextUtils.isEmpty(lowerCase3) && !TextUtils.isEmpty(next.x)) {
                            lowerCase3 = lowerCase3.toLowerCase();
                            if (lowerCase3.equals(next.x)) {
                                prVarArr[0] = next;
                                break;
                            }
                            if (lowerCase3.contains(next.x) || next.x.contains(lowerCase3)) {
                                prVarArr[1] = next;
                                break;
                            }
                        }
                        if (TextUtils.isEmpty(lowerCase2)) {
                            if (packageInfoPr2 == null) {
                                packageInfoPr2 = m.pr(hwVar);
                            }
                            if (packageInfoPr2 != null) {
                                lowerCase2 = packageInfoPr2.packageName;
                            }
                        }
                        if (!TextUtils.isEmpty(lowerCase2) && !TextUtils.isEmpty(next.pr)) {
                            lowerCase2 = lowerCase2.toLowerCase();
                            if (!lowerCase2.contains(next.pr) && !next.pr.contains(lowerCase2)) {
                                if (prVarArr[3] == null) {
                                    if (pr(lowerCase2, next.pr)) {
                                        prVarArr[3] = next;
                                    }
                                }
                            }
                            prVarArr[2] = next;
                            break;
                        }
                        if (prVarArr[4] == null) {
                            if (TextUtils.isEmpty(lowerCase)) {
                                if (packageInfoPr2 == null) {
                                    packageInfoPr2 = m.pr(hwVar);
                                }
                                if (packageInfoPr2 != null) {
                                    lowerCase = packageInfoPr2.versionName;
                                }
                            }
                            if (!TextUtils.isEmpty(lowerCase) && !TextUtils.isEmpty(next.hn)) {
                                lowerCase = lowerCase.toLowerCase();
                                if (lowerCase.equals(next.hn)) {
                                    prVarArr[4] = next;
                                }
                            }
                            if (prVarArr[5] == null) {
                                if (i2 <= 0) {
                                    if (packageInfoPr2 == null) {
                                        packageInfoPr2 = m.pr(hwVar);
                                    }
                                    if (packageInfoPr2 != null) {
                                        i2 = packageInfoPr2.versionCode;
                                    }
                                }
                                if (i2 == next.hw) {
                                    prVarArr[5] = next;
                                }
                            }
                        }
                    }
                }
            }
            for (i = 0; i < length; i++) {
                if (prVarArr[i] != null) {
                    return new Pair<>(prVarArr[i], Integer.valueOf(x[i]));
                }
            }
        } catch (Throwable th2) {
        }
        return null;
    }

    private void hw() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this.hw) {
            Iterator<pr> it = this.hw.iterator();
            while (it.hasNext() && jCurrentTimeMillis - it.next().c > 1800000) {
                it.remove();
            }
        }
    }

    private pr hn(String str) {
        try {
            PackageManager packageManager = k.getContext().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return new pr(str, packageInfo.versionCode, packageInfo.versionName, (String) packageManager.getApplicationLabel(packageInfo.applicationInfo), System.currentTimeMillis());
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    private static boolean pr(String str, String str2) {
        boolean z;
        try {
            String[] strArrSplit = str.split("\\.");
            String[] strArrSplit2 = str2.split("\\.");
            if (strArrSplit.length != 0 && strArrSplit2.length != 0) {
                int i = 0;
                int i2 = 0;
                for (String str3 : strArrSplit) {
                    String[] strArr = hn;
                    int length = strArr.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            z = false;
                            break;
                        }
                        String str4 = strArr[i3];
                        if (!str4.equals(str3)) {
                            i3++;
                        } else {
                            if (i < strArrSplit2.length && str4.equals(strArrSplit2[i])) {
                                i++;
                            }
                            z = true;
                            break;
                        }
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
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DOWNLOAD_BYTES, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
    public static class pr {
        public final long c;
        public final String hn;
        public final int hw;
        public final String pr;
        public final String x;

        private pr(String str, int i, String str2, String str3, long j) {
            this.pr = str;
            this.hw = i;
            this.hn = str2 != null ? str2.toLowerCase() : null;
            this.x = str3 != null ? str3.toLowerCase() : null;
            this.c = j;
        }
    }
}
