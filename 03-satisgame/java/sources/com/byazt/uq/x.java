package com.byazt.uq;

import android.R;
import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.anythink.core.e.i;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_CHECK_SILENCE_INTERVAL, 21})
public final class x {
    public static volatile int cp;
    public static final Map<String, Boolean> d;
    public static WeakReference<Activity> fs;
    public static boolean l;
    public static final Set<String> n;
    public static String q;
    public static final Map<String, Boolean> qg;
    public static final WeakHashMap<Activity, n> rv;
    public static List<String> s;
    public static final Set<String> tj;
    public static int w;
    public static String x;

    static {
        ConcurrentHashMap.KeySetView keySetViewNewKeySet = ConcurrentHashMap.newKeySet();
        n = keySetViewNewKeySet;
        keySetViewNewKeySet.addAll(Arrays.asList("d22096b358acef645e49e08ad7de4bb6", "ff4b9977c134ab22a2d3618b51a36045", "7e2d432c1679374070821b28b7145c19", "b9304799be85d7222baa15927a7e3cd1", "6edca895469b266a9e12387b11115808", "8d432dfb8327eab8ced7b97f00221d4f", "2e934727248ee0cd7787256613245ba6", "07c1627688f39f4b050d7180bab92f34", "149a05b3da0f19e3ce840afe6f6c67f3", "529bd4093e440a920d7c99c8ba781a4d", "cbd09814ff5652055c2af0bb0f9d4314"));
        qg = new ConcurrentHashMap();
        s = null;
        rv = new WeakHashMap<>();
        tj = Collections.newSetFromMap(new ConcurrentHashMap());
        cp = -1;
        d = new ConcurrentHashMap();
    }

    private static String n(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = (byte) (bArr[i] - 5);
        }
        return new String(bArr2);
    }

    private static Iterable<String> q() {
        Set<String> setDc;
        com.byazt.ivn.w wVarQg = com.byazt.nf.rv.qg();
        if (wVarQg != null && (setDc = wVarQg.dc()) != null && !setDc.isEmpty()) {
            return setDc;
        }
        if (s == null) {
            ArrayList arrayList = new ArrayList();
            s = arrayList;
            arrayList.add(n(new byte[]{120, 117, 113, 102, 120, 109}));
            s.add(n(new byte[]{108, 122, 110, 105, 106}));
            s.add(n(new byte[]{124, 106, 113, 104, 116, 114, 106}));
            s.add(n(new byte[]{110, 115, 121, 106, 119, 120, 121, 110, 121, 110, 102, 113}));
            s.add(n(new byte[]{119, 116, 122, 121, 106, 119}));
            s.add(n(new byte[]{119, 116, 122, 121, 106}));
            s.add(n(new byte[]{121, 119, 102, 115, 120, 110, 121, 110, 116, 115}));
            s.add(n(new byte[]{119, 106, 124, 102, 119, 105}));
        }
        return s;
    }

    public static void n(Activity activity) {
        if (activity != null && hd(activity)) {
            String strCd = cd(activity);
            if (qg(activity, strCd)) {
                return;
            }
            if (tj(activity)) {
                q.q();
            }
            if (s(activity, 2, true)) {
                return;
            }
            if (w(strCd)) {
                cy(activity);
                return;
            }
            n nVarS = s(activity, strCd);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (nVarS.qg == 0) {
                nVarS.qg = jCurrentTimeMillis;
            }
            nVarS.s = jCurrentTimeMillis;
            nVarS.w = activity.isTaskRoot();
            activity.hashCode();
            l();
            if (q(strCd) && (activity.isTaskRoot() || l())) {
                activity.isTaskRoot();
                l();
                qg(activity, 3, true);
                return;
            }
            x(activity);
        }
    }

    public static void qg(Activity activity) {
        n nVar;
        if (activity == null) {
            return;
        }
        a(activity);
        if (hd(activity)) {
            if (tj(activity)) {
                q.l();
            }
            if (s(activity, 6, false) || (nVar = rv.get(activity)) == null) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            nVar.q = jCurrentTimeMillis;
            if (nVar.s > 0 && jCurrentTimeMillis - nVar.s < 1200) {
                activity.hashCode();
                cy(activity);
            } else {
                activity.hashCode();
            }
        }
    }

    public static void s(Activity activity) {
        if (activity == null) {
            return;
        }
        a(activity);
        if (hd(activity)) {
            if (cp(activity)) {
                cd(activity);
                activity.hashCode();
                l.qg();
                q.x();
                l = false;
                w = -1;
                x = "";
                fs = null;
                return;
            }
            if (s(activity, 7, false)) {
                return;
            }
            n nVar = rv.get(activity);
            if (nVar == null) {
                cd(activity);
                activity.hashCode();
                cy(activity);
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            nVar.l = jCurrentTimeMillis;
            if (nVar.qg > 0 && jCurrentTimeMillis - nVar.qg < 1200) {
                activity.hashCode();
                cy(activity);
            } else {
                activity.hashCode();
                cy(activity);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(Activity activity, final int i, boolean z) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        String strCd = cd(activity);
        if (oa(activity) || sz(activity)) {
            activity.hashCode();
            return;
        }
        if (qg(activity, strCd)) {
            activity.hashCode();
            return;
        }
        if (cp(activity)) {
            activity.hashCode();
            return;
        }
        final n nVarS = s(activity, strCd);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (z || nVarS.rv <= 0 || jCurrentTimeMillis - nVarS.rv >= 2000) {
            nVarS.rv = jCurrentTimeMillis;
            activity.hashCode();
            final WeakReference weakReference = new WeakReference(activity);
            final int iHashCode = activity.hashCode();
            Runnable runnable = new Runnable() { // from class: com.byazt.uq.x.1
                @Override // java.lang.Runnable
                public void run() {
                    nVarS.tj = null;
                    Activity activity2 = (Activity) weakReference.get();
                    if (activity2 == null || activity2.isFinishing()) {
                        return;
                    }
                    x.qg(activity2, x.cd(activity2), activity2.hashCode(), i);
                }
            };
            nVarS.tj = runnable;
            View viewUm = um(activity);
            if (viewUm != null) {
                viewUm.post(runnable);
            } else {
                nVarS.tj = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(Activity activity, String str, int i, int i2) {
        if (activity == null || activity.isFinishing() || cp(activity)) {
            return;
        }
        l.qg qgVarN = l.n(activity);
        if (!((qgVarN == null || qgVarN.q == null || qgVarN.q.isEmpty()) ? false : true)) {
            tj(activity);
            q(str);
            if (i2 == 2 || i2 == 1 || i2 == 4 || i2 == 3 || i2 == 5) {
                fs(activity);
                return;
            }
            return;
        }
        try {
            if (qgVarN.qg >= 0) {
                fs.n(q.qg(qgVarN.qg));
            }
        } catch (Throwable unused) {
        }
        s(str);
        if (TextUtils.isEmpty(qg())) {
            qg(str);
        }
        l = true;
        w = i;
        x = str;
        fs = new WeakReference<>(activity);
        rv.clear();
        qgVarN.q.size();
    }

    private static void x(final Activity activity) {
        if (activity == null) {
            return;
        }
        final n nVarS = s(activity, cd(activity));
        if (nVarS.fs) {
            activity.hashCode();
            return;
        }
        nVarS.fs = true;
        activity.hashCode();
        final WeakReference weakReference = new WeakReference(activity);
        Runnable runnable = new Runnable() { // from class: com.byazt.uq.x.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    nVarS.d = null;
                    Activity activity2 = (Activity) weakReference.get();
                    if (activity2 != null && !activity2.isFinishing()) {
                        if (x.hd(activity)) {
                            if (x.rv(activity2)) {
                                x.cd(activity2);
                                x.qg();
                            } else if (x.w(x.cd(activity2))) {
                                x.cd(activity2);
                            } else {
                                long j = nVarS.s;
                                long j2 = nVarS.q;
                                long j3 = nVarS.l;
                                if (j > 0 && j2 < j && j3 <= 0 && System.currentTimeMillis() - j >= 3000) {
                                    x.qg(activity2, 4, true);
                                }
                            }
                        }
                    } else {
                        activity.hashCode();
                    }
                } finally {
                    nVarS.fs = false;
                    nVarS.d = null;
                }
            }
        };
        nVarS.d = runnable;
        View viewUm = um(activity);
        if (viewUm == null) {
            activity.hashCode();
            nVarS.fs = false;
            nVarS.d = null;
            return;
        }
        viewUm.postDelayed(runnable, 4500L);
    }

    private static void fs(final Activity activity) {
        if (activity == null) {
            return;
        }
        final n nVarS = s(activity, cd(activity));
        int i = nVarS.x + 1;
        if (i > 2) {
            activity.hashCode();
            if (k(activity)) {
                n(activity, nVarS.n);
                return;
            }
            return;
        }
        nVarS.x = i;
        long j = ((long) i) * 3000;
        activity.hashCode();
        final WeakReference weakReference = new WeakReference(activity);
        Runnable runnable = new Runnable() { // from class: com.byazt.uq.x.3
            @Override // java.lang.Runnable
            public void run() {
                nVarS.cp = null;
                Activity activity2 = (Activity) weakReference.get();
                if (activity2 != null && !activity2.isFinishing()) {
                    if (x.hd(activity) && !x.w(x.cd(activity2))) {
                        activity.hashCode();
                        x.qg(activity2, 5, true);
                        return;
                    }
                    return;
                }
                activity.hashCode();
            }
        };
        nVarS.cp = runnable;
        View viewUm = um(activity);
        if (viewUm == null) {
            activity.hashCode();
            nVarS.cp = null;
        } else {
            viewUm.postDelayed(runnable, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean rv(Activity activity) {
        String strQg = qg();
        return (TextUtils.isEmpty(strQg) || strQg.equals(cd(activity))) ? false : true;
    }

    private static boolean s(Activity activity, int i, boolean z) {
        String strQg = qg();
        if (TextUtils.isEmpty(strQg)) {
            return false;
        }
        if (!strQg.equals(cd(activity))) {
            return true;
        }
        if (!cp(activity)) {
            if (z) {
                activity.hashCode();
                qg(activity, i, false);
            } else {
                activity.hashCode();
            }
            return true;
        }
        if (!l.n()) {
            activity.hashCode();
            q.n();
            l = false;
            w = -1;
            x = "";
            qg(activity, i, false);
            return true;
        }
        activity.hashCode();
        return true;
    }

    private static boolean tj(Activity activity) {
        String strQg = qg();
        return !TextUtils.isEmpty(strQg) && strQg.equals(cd(activity));
    }

    private static boolean cp(Activity activity) {
        return activity != null && l && activity.hashCode() == w && cd(activity).equals(x);
    }

    public static Activity n() {
        WeakReference<Activity> weakReference = fs;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static String qg() {
        if (!TextUtils.isEmpty(q)) {
            return q;
        }
        com.byazt.gwu.s sVarN = com.byazt.ikv.n.n();
        if (sVarN == null) {
            return "";
        }
        String strQg = sVarN.qg("mc_c_name", "");
        long jQg = sVarN.qg("mc_c_name_cache_time", 0L);
        if (!TextUtils.isEmpty(strQg) && System.currentTimeMillis() - jQg > i.f) {
            sVarN.n("mc_c_name", "");
            sVarN.n("mc_c_name_cache_time", 0L);
            return "";
        }
        q = strQg;
        return strQg;
    }

    public static int s() {
        if (cp != -1) {
            return cp == 0 ? 0 : -1;
        }
        com.byazt.gwu.s sVarN = com.byazt.ikv.n.n();
        if (sVarN == null) {
            return -1;
        }
        try {
            return sVarN.qg("no_tab_global", false) ? 0 : -1;
        } catch (Throwable unused) {
        }
    }

    private static void qg(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            return;
        }
        q = str;
        com.byazt.gwu.s sVarN = com.byazt.ikv.n.n();
        if (sVarN != null) {
            sVarN.n("mc_c_name", str);
            sVarN.n("mc_c_name_cache_time", System.currentTimeMillis());
        }
    }

    private static long d(Activity activity) {
        PackageInfo packageInfo;
        if (activity == null) {
            return -1L;
        }
        try {
            PackageManager packageManager = activity.getPackageManager();
            if (packageManager == null || (packageInfo = packageManager.getPackageInfo(activity.getPackageName(), 0)) == null) {
                return -1L;
            }
            if (Build.VERSION.SDK_INT >= 28) {
                return packageInfo.getLongVersionCode();
            }
            return packageInfo.versionCode;
        } catch (Throwable unused) {
            return -1L;
        }
    }

    private static void n(Activity activity, String str) {
        if (activity == null || TextUtils.isEmpty(str)) {
            return;
        }
        Map<String, Boolean> map = d;
        map.put(str, Boolean.TRUE);
        if (tj.add(str)) {
            try {
                com.byazt.gwu.s sVarN = com.byazt.ikv.n.n();
                if (sVarN == null) {
                    return;
                }
                long jD = d(activity);
                long jQg = sVarN.qg("no_tab_fail_version_".concat(String.valueOf(str)), -1L);
                int iQg = sVarN.qg("no_tab_fail_count_".concat(String.valueOf(str)), 0);
                if (jD > 0 && jQg > 0 && jQg != jD) {
                    iQg = 0;
                }
                int i = iQg + 1;
                if (i >= 3) {
                    sVarN.n("no_tab_arch_".concat(String.valueOf(str)), true);
                    sVarN.n("no_tab_app_version_".concat(String.valueOf(str)), jD);
                    map.put(str, Boolean.TRUE);
                    int iQg2 = sVarN.qg("no_tab_global_class_count", 0) + 1;
                    sVarN.n("no_tab_global_class_count", iQg2);
                    if (q(str) || iQg2 >= 4) {
                        sVarN.n("no_tab_global", true);
                        sVarN.n("no_tab_global_version", jD);
                        cp = 0;
                        return;
                    }
                    return;
                }
                sVarN.n("no_tab_fail_count_".concat(String.valueOf(str)), i);
                sVarN.n("no_tab_fail_version_".concat(String.valueOf(str)), jD);
            } catch (Throwable unused) {
            }
        }
    }

    private static void s(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            com.byazt.gwu.s sVarN = com.byazt.ikv.n.n();
            if (sVarN == null) {
                return;
            }
            sVarN.n("no_tab_arch_".concat(String.valueOf(str)), false);
            sVarN.n("no_tab_fail_count_".concat(String.valueOf(str)), 0);
            sVarN.n("no_tab_fail_version_".concat(String.valueOf(str)), 0L);
            sVarN.n("no_tab_app_version_".concat(String.valueOf(str)), 0L);
            d.put(str, Boolean.FALSE);
            if (cp == 0 || sVarN.qg("no_tab_global", false)) {
                sVarN.n("no_tab_global", false);
                sVarN.n("no_tab_global_class_count", 0);
                cp = 1;
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean qg(Activity activity, String str) {
        if (activity != null && !TextUtils.isEmpty(str)) {
            Map<String, Boolean> map = d;
            Boolean bool = map.get(str);
            if (bool != null) {
                return bool.booleanValue();
            }
            com.byazt.gwu.s sVarN = com.byazt.ikv.n.n();
            if (sVarN == null) {
                return false;
            }
            try {
                if (!sVarN.qg("no_tab_arch_".concat(String.valueOf(str)), false)) {
                    map.put(str, Boolean.FALSE);
                    return false;
                }
                long jQg = sVarN.qg("no_tab_app_version_".concat(String.valueOf(str)), -1L);
                long jD = d(activity);
                if (jD > 0 && jQg > 0 && jQg != jD) {
                    s(str);
                    return false;
                }
                map.put(str, Boolean.TRUE);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static boolean oa(Activity activity) {
        if (activity == null) {
            return false;
        }
        try {
            if (activity.getResources() != null && activity.getResources().getConfiguration() != null && activity.getResources().getConfiguration().orientation == 2) {
                return true;
            }
        } catch (Throwable unused) {
        }
        try {
            return (activity.getWindow() == null || activity.getWindow().getAttributes() == null || (activity.getWindow().getAttributes().flags & 1024) == 0) ? false : true;
        } catch (Throwable unused2) {
        }
    }

    private static boolean sz(Activity activity) {
        if (activity == null) {
            return false;
        }
        String name = activity.getClass().getName();
        if (name.contains("UnityPlayerActivity") || name.contains("Cocos2dxActivity") || name.contains("NativeActivity") || name.contains("GameActivity")) {
            return true;
        }
        try {
            ApplicationInfo applicationInfo = activity.getApplicationInfo();
            return applicationInfo != null && ((Build.VERSION.SDK_INT >= 26 && applicationInfo.category == 0) || (applicationInfo.flags & 33554432) != 0);
        } catch (Throwable unused) {
        }
    }

    private static boolean k(Activity activity) {
        View decorView;
        if (activity == null) {
            return false;
        }
        try {
            Window window = activity.getWindow();
            if (window != null && (decorView = window.getDecorView()) != null && decorView.getWidth() != 0 && decorView.getHeight() != 0) {
                View viewFindViewById = decorView.findViewById(R.id.content);
                return !(viewFindViewById instanceof ViewGroup) || ((ViewGroup) viewFindViewById).getChildCount() > 0;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static n s(Activity activity, String str) {
        WeakHashMap<Activity, n> weakHashMap = rv;
        n nVar = weakHashMap.get(activity);
        if (nVar == null) {
            n nVar2 = new n(str);
            weakHashMap.put(activity, nVar2);
            return nVar2;
        }
        if (TextUtils.isEmpty(str)) {
            return nVar;
        }
        nVar.n = str;
        return nVar;
    }

    private static void cy(Activity activity) {
        if (activity == null) {
            return;
        }
        rv.remove(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hd(Activity activity) {
        if (!s.q()) {
            return false;
        }
        if (cp == -1 && activity != null) {
            com.byazt.gwu.s sVarN = com.byazt.ikv.n.n();
            if (sVarN == null) {
                return true;
            }
            try {
                if (sVarN.qg("no_tab_global", false)) {
                    long jQg = sVarN.qg("no_tab_global_version", -1L);
                    long jD = d(activity);
                    if (jD > 0 && jQg > 0 && jQg != jD) {
                        sVarN.n("no_tab_global", false);
                        sVarN.n("no_tab_global_class_count", 0);
                        cp = 1;
                    } else {
                        cp = 0;
                    }
                } else {
                    cp = 1;
                }
            } catch (Throwable unused) {
                cp = 1;
            }
        }
        return cp != 0;
    }

    private static boolean q(String str) {
        Set<String> setKx;
        String strX = x(str);
        boolean zL = false;
        if (TextUtils.isEmpty(strX)) {
            return false;
        }
        Map<String, Boolean> map = qg;
        Boolean bool = map.get(strX);
        if (bool != null) {
            bool.booleanValue();
            return bool.booleanValue();
        }
        com.byazt.ivn.w wVarQg = com.byazt.nf.rv.qg();
        if (wVarQg != null && (setKx = wVarQg.kx()) != null && setKx.contains(strX)) {
            zL = true;
        }
        if (!zL) {
            zL = l(strX);
        }
        map.put(strX, Boolean.valueOf(zL));
        return zL;
    }

    private static boolean l(String str) {
        try {
            String strN = com.byazt.wvr.s.n(str.toLowerCase());
            return strN != null && n.contains(strN);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:13:0x0026 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:15:0x0028 A[RETURN] */
    public static boolean w(String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        for (String str2 : q()) {
            if (lowerCase.contains(str2)) {
                if (str2 != null) {
                    return true;
                }
                return false;
            }
        }
        str2 = null;
        if (str2 != null) {
            return true;
        }
        return false;
    }

    private static boolean l() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i = 0;
        for (n nVar : rv.values()) {
            if (nVar != null && nVar.s > 0 && nVar.l == 0 && nVar.q < nVar.s && jCurrentTimeMillis - nVar.s < 86400000) {
                i++;
            }
        }
        return i <= 2;
    }

    private static String x(String str) {
        if (str == null) {
            return "";
        }
        int iLastIndexOf = str.lastIndexOf(46);
        return iLastIndexOf >= 0 ? str.substring(iLastIndexOf + 1) : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String cd(Activity activity) {
        if (activity == null) {
            return "";
        }
        try {
            Object objN = sz.n(activity);
            if (objN == null) {
                return activity.getClass().getName();
            }
            return objN.getClass().getName();
        } catch (Throwable unused) {
            return activity.getClass().getName();
        }
    }

    private static View um(Activity activity) {
        if (activity == null) {
            return null;
        }
        try {
            if (activity.getWindow() != null) {
                return activity.getWindow().getDecorView();
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static void a(Activity activity) {
        n nVar = rv.get(activity);
        if (nVar == null) {
            return;
        }
        View viewUm = um(activity);
        if (viewUm != null) {
            if (nVar.tj != null) {
                viewUm.removeCallbacks(nVar.tj);
            }
            if (nVar.cp != null) {
                viewUm.removeCallbacks(nVar.cp);
            }
            if (nVar.d != null) {
                viewUm.removeCallbacks(nVar.d);
            }
        }
        nVar.tj = null;
        nVar.cp = null;
        nVar.d = null;
        nVar.fs = false;
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_CHECK_SILENCE_INTERVAL, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_MTU})
    private static final class n {
        public Runnable cp;
        public Runnable d;
        public boolean fs;
        public long l;
        public String n;
        public long q;
        public long qg;
        public long rv;
        public long s;
        public Runnable tj;
        public boolean w;
        public int x;

        public n(String str) {
            this.n = str;
        }
    }
}
