package com.byazt.vl;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Pair;
import com.anythink.core.common.g.c;
import com.byazt.rz.oa;
import com.byazt.ug.d;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TRAN_CONNECT_TIME, 5})
public class q {
    public static volatile q n;
    public final LinkedList<n> qg = new LinkedList<>();
    public static final String[] s = {"com", "android", "ss"};
    public static final int[] q = {3101, 3102, 3103, 3201, 3202, 3203};

    private q() {
    }

    public static q n() {
        if (n == null) {
            synchronized (q.class) {
                if (n == null) {
                    n = new q();
                }
            }
        }
        return n;
    }

    public void n(String str) {
        n nVarS;
        qg();
        if (TextUtils.isEmpty(str) || (nVarS = s(str)) == null) {
            return;
        }
        synchronized (this.qg) {
            this.qg.add(nVarS);
        }
    }

    public void qg(String str) {
        qg();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.qg) {
            Iterator<n> it = this.qg.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next().n)) {
                    it.remove();
                    return;
                }
            }
        }
    }

    public n n(com.byazt.h.qg qgVar) {
        if (qgVar == null) {
            return null;
        }
        qg();
        synchronized (this.qg) {
            for (n nVar : this.qg) {
                if (nVar.l > qgVar.bb()) {
                    return nVar;
                }
            }
            return null;
        }
    }

    public Pair<n, Integer> qg(com.byazt.h.qg qgVar) {
        int i;
        if (qgVar == null) {
            return null;
        }
        try {
            qg();
            if (this.qg.isEmpty()) {
                return null;
            }
            String strDg = qgVar.dg();
            String strL = qgVar.l();
            String strF = qgVar.f();
            int iAe = qgVar.ae();
            int length = q.length;
            n[] nVarArr = new n[length];
            synchronized (this.qg) {
                Iterator<n> it = this.qg.iterator();
                PackageInfo packageInfoN = null;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    n next = it.next();
                    if (next.l >= qgVar.bb()) {
                        if (TextUtils.isEmpty(strDg)) {
                            if (packageInfoN == null) {
                                packageInfoN = oa.n(qgVar);
                            }
                            if (packageInfoN != null) {
                                try {
                                    strDg = (String) d.getContext().getPackageManager().getApplicationLabel(packageInfoN.applicationInfo);
                                } catch (Throwable unused) {
                                }
                            }
                        }
                        if (!TextUtils.isEmpty(strDg) && !TextUtils.isEmpty(next.q)) {
                            strDg = strDg.toLowerCase();
                            if (strDg.equals(next.q)) {
                                nVarArr[0] = next;
                                break;
                            }
                            if (strDg.contains(next.q) || next.q.contains(strDg)) {
                                nVarArr[1] = next;
                                break;
                            }
                        }
                        if (TextUtils.isEmpty(strL)) {
                            if (packageInfoN == null) {
                                packageInfoN = oa.n(qgVar);
                            }
                            if (packageInfoN != null) {
                                strL = packageInfoN.packageName;
                            }
                        }
                        if (!TextUtils.isEmpty(strL) && !TextUtils.isEmpty(next.n)) {
                            strL = strL.toLowerCase();
                            if (!strL.contains(next.n) && !next.n.contains(strL)) {
                                if (nVarArr[3] == null) {
                                    if (n(strL, next.n)) {
                                        nVarArr[3] = next;
                                    }
                                }
                            }
                            nVarArr[2] = next;
                            break;
                        }
                        if (nVarArr[4] == null) {
                            if (TextUtils.isEmpty(strF)) {
                                if (packageInfoN == null) {
                                    packageInfoN = oa.n(qgVar);
                                }
                                if (packageInfoN != null) {
                                    strF = packageInfoN.versionName;
                                }
                            }
                            if (!TextUtils.isEmpty(strF) && !TextUtils.isEmpty(next.s)) {
                                strF = strF.toLowerCase();
                                if (strF.equals(next.s)) {
                                    nVarArr[4] = next;
                                }
                            }
                            if (nVarArr[5] == null) {
                                if (iAe <= 0) {
                                    if (packageInfoN == null) {
                                        packageInfoN = oa.n(qgVar);
                                    }
                                    if (packageInfoN != null) {
                                        iAe = packageInfoN.versionCode;
                                    }
                                }
                                if (iAe == next.qg) {
                                    nVarArr[5] = next;
                                }
                            }
                        }
                    }
                }
            }
            for (i = 0; i < length; i++) {
                if (nVarArr[i] != null) {
                    return new Pair<>(nVarArr[i], Integer.valueOf(q[i]));
                }
            }
        } catch (Throwable unused2) {
        }
        return null;
    }

    private void qg() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this.qg) {
            Iterator<n> it = this.qg.iterator();
            while (it.hasNext() && jCurrentTimeMillis - it.next().l > c.a) {
                it.remove();
            }
        }
    }

    private n s(String str) {
        try {
            PackageManager packageManager = d.getContext().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return new n(str, packageInfo.versionCode, packageInfo.versionName, (String) packageManager.getApplicationLabel(packageInfo.applicationInfo), System.currentTimeMillis());
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean n(String str, String str2) {
        boolean z;
        try {
            String[] strArrSplit = str.split("\\.");
            String[] strArrSplit2 = str2.split("\\.");
            if (strArrSplit.length != 0 && strArrSplit2.length != 0) {
                int i = 0;
                int i2 = 0;
                for (String str3 : strArrSplit) {
                    String[] strArr = s;
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
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TRAN_CONNECT_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_END_TIME})
    public static class n {
        public final long l;
        public final String n;
        public final String q;
        public final int qg;
        public final String s;

        private n(String str, int i, String str2, String str3, long j) {
            this.n = str;
            this.qg = i;
            this.s = str2 != null ? str2.toLowerCase() : null;
            this.q = str3 != null ? str3.toLowerCase() : null;
            this.l = j;
        }
    }
}
