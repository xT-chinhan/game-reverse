package com.byazt.ua;

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
import com.byazt.sd.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapsdk.tapad.internal.runtime.RustResolvedAsset;
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
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID, 62})
public final class fw {
    public static final WeakHashMap<Activity, pr> aj;
    public static boolean c;
    public static String fw;
    public static List<String> hn;
    public static final Map<String, Boolean> hw;
    public static final Map<String, Boolean> k;
    public static final Set<String> pr;
    public static int uc;
    public static final Set<String> vk;
    public static volatile int w;
    public static String x;
    public static WeakReference<Activity> zo;

    static {
        ConcurrentHashMap.KeySetView keySetViewNewKeySet = ConcurrentHashMap.newKeySet();
        pr = keySetViewNewKeySet;
        keySetViewNewKeySet.addAll(Arrays.asList("d22096b358acef645e49e08ad7de4bb6", "ff4b9977c134ab22a2d3618b51a36045", "7e2d432c1679374070821b28b7145c19", "b9304799be85d7222baa15927a7e3cd1", "6edca895469b266a9e12387b11115808", "8d432dfb8327eab8ced7b97f00221d4f", "2e934727248ee0cd7787256613245ba6", "07c1627688f39f4b050d7180bab92f34", "149a05b3da0f19e3ce840afe6f6c67f3", "529bd4093e440a920d7c99c8ba781a4d", "cbd09814ff5652055c2af0bb0f9d4314"));
        hw = new ConcurrentHashMap();
        hn = null;
        aj = new WeakHashMap<>();
        vk = Collections.newSetFromMap(new ConcurrentHashMap());
        w = -1;
        k = new ConcurrentHashMap();
    }

    private static String pr(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = (byte) (bArr[i] - 5);
        }
        return new String(bArr2);
    }

    private static Iterable<String> x() {
        Set<String> setLe;
        com.byazt.is.w wVarHw = a.hw();
        if (wVarHw != null && (setLe = wVarHw.le()) != null && !setLe.isEmpty()) {
            return setLe;
        }
        if (hn == null) {
            ArrayList arrayList = new ArrayList();
            hn = arrayList;
            arrayList.add(pr(new byte[]{120, 117, 113, 102, 120, 109}));
            hn.add(pr(new byte[]{108, 122, 110, 105, 106}));
            hn.add(pr(new byte[]{124, 106, 113, 104, 116, 114, 106}));
            hn.add(pr(new byte[]{110, 115, 121, 106, 119, 120, 121, 110, 121, 110, 102, 113}));
            hn.add(pr(new byte[]{119, 116, 122, 121, 106, 119}));
            hn.add(pr(new byte[]{119, 116, 122, 121, 106}));
            hn.add(pr(new byte[]{121, 119, 102, 115, 120, 110, 121, 110, 116, 115}));
            hn.add(pr(new byte[]{119, 106, 124, 102, 119, 105}));
        }
        return hn;
    }

    public static void pr(Activity activity) {
        if (activity == null || !yb(activity)) {
            return;
        }
        String strLb = lb(activity);
        if (hw(activity, strLb)) {
            return;
        }
        if (vk(activity)) {
            x.x();
        }
        if (hn(activity, 2, true)) {
            return;
        }
        if (uc(strLb)) {
            nt(activity);
            return;
        }
        pr prVarHn = hn(activity, strLb);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (prVarHn.hw == 0) {
            prVarHn.hw = jCurrentTimeMillis;
        }
        prVarHn.hn = jCurrentTimeMillis;
        prVarHn.uc = activity.isTaskRoot();
        activity.hashCode();
        c();
        if (x(strLb) && (activity.isTaskRoot() || c())) {
            activity.isTaskRoot();
            c();
            hw(activity, 3, true);
            return;
        }
        fw(activity);
    }

    public static void hw(Activity activity) {
        pr prVar;
        if (activity == null) {
            return;
        }
        a(activity);
        if (!yb(activity)) {
            return;
        }
        if (vk(activity)) {
            x.c();
        }
        if (hn(activity, 6, false) || (prVar = aj.get(activity)) == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        prVar.x = jCurrentTimeMillis;
        if (prVar.hn > 0 && jCurrentTimeMillis - prVar.hn < 1200) {
            activity.hashCode();
            nt(activity);
        } else {
            activity.hashCode();
        }
    }

    public static void hn(Activity activity) {
        if (activity == null) {
            return;
        }
        a(activity);
        if (!yb(activity)) {
            return;
        }
        if (w(activity)) {
            lb(activity);
            activity.hashCode();
            c.hw();
            x.fw();
            c = false;
            uc = -1;
            fw = "";
            zo = null;
            return;
        }
        if (hn(activity, 7, false)) {
            return;
        }
        pr prVar = aj.get(activity);
        if (prVar == null) {
            lb(activity);
            activity.hashCode();
            nt(activity);
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        prVar.c = jCurrentTimeMillis;
        if (prVar.hw > 0 && jCurrentTimeMillis - prVar.hw < 1200) {
            activity.hashCode();
            nt(activity);
        } else {
            activity.hashCode();
            nt(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hw(Activity activity, final int i, boolean z) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        String strLb = lb(activity);
        if (m(activity) || g(activity)) {
            activity.hashCode();
            return;
        }
        if (hw(activity, strLb)) {
            activity.hashCode();
            return;
        }
        if (w(activity)) {
            activity.hashCode();
            return;
        }
        final pr prVarHn = hn(activity, strLb);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!z && prVarHn.aj > 0 && jCurrentTimeMillis - prVarHn.aj < 2000) {
            return;
        }
        prVarHn.aj = jCurrentTimeMillis;
        activity.hashCode();
        final WeakReference weakReference = new WeakReference(activity);
        final int iHashCode = activity.hashCode();
        Runnable runnable = new Runnable() { // from class: com.byazt.ua.fw.1
            @Override // java.lang.Runnable
            public void run() {
                prVarHn.vk = null;
                Activity activity2 = (Activity) weakReference.get();
                if (activity2 != null && !activity2.isFinishing()) {
                    fw.hw(activity2, fw.lb(activity2), activity2.hashCode(), i);
                }
            }
        };
        prVarHn.vk = runnable;
        View viewQa = qa(activity);
        if (viewQa != null) {
            viewQa.post(runnable);
        } else {
            prVarHn.vk = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hw(Activity activity, String str, int i, int i2) {
        if (activity == null || activity.isFinishing() || w(activity)) {
            return;
        }
        c.hw hwVarPr = c.pr(activity);
        if (!((hwVarPr == null || hwVarPr.x == null || hwVarPr.x.isEmpty()) ? false : true)) {
            vk(activity);
            x(str);
            if (i2 == 2 || i2 == 1 || i2 == 4 || i2 == 3 || i2 == 5) {
                zo(activity);
                return;
            }
            return;
        }
        hn(str);
        if (TextUtils.isEmpty(hw())) {
            hw(str);
        }
        c = true;
        uc = i;
        fw = str;
        zo = new WeakReference<>(activity);
        aj.clear();
        hwVarPr.x.size();
    }

    private static void fw(final Activity activity) {
        if (activity == null) {
            return;
        }
        final pr prVarHn = hn(activity, lb(activity));
        if (prVarHn.zo) {
            activity.hashCode();
            return;
        }
        prVarHn.zo = true;
        activity.hashCode();
        final WeakReference weakReference = new WeakReference(activity);
        Runnable runnable = new Runnable() { // from class: com.byazt.ua.fw.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    prVarHn.k = null;
                    Activity activity2 = (Activity) weakReference.get();
                    if (activity2 != null && !activity2.isFinishing()) {
                        if (fw.yb(activity)) {
                            if (fw.aj(activity2)) {
                                fw.lb(activity2);
                                fw.hw();
                                return;
                            }
                            if (fw.uc(fw.lb(activity2))) {
                                fw.lb(activity2);
                                return;
                            }
                            long j = prVarHn.hn;
                            long j2 = prVarHn.x;
                            long j3 = prVarHn.c;
                            if (j > 0 && j2 < j && j3 <= 0) {
                                if (System.currentTimeMillis() - j >= 3000) {
                                    fw.hw(activity2, 4, true);
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    activity.hashCode();
                } finally {
                    prVarHn.zo = false;
                    prVarHn.k = null;
                }
            }
        };
        prVarHn.k = runnable;
        View viewQa = qa(activity);
        if (viewQa == null) {
            activity.hashCode();
            prVarHn.zo = false;
            prVarHn.k = null;
            return;
        }
        viewQa.postDelayed(runnable, 4500L);
    }

    private static void zo(final Activity activity) {
        if (activity == null) {
            return;
        }
        final pr prVarHn = hn(activity, lb(activity));
        int i = prVarHn.fw + 1;
        if (i > 2) {
            activity.hashCode();
            if (ho(activity)) {
                pr(activity, prVarHn.pr);
                return;
            }
            return;
        }
        prVarHn.fw = i;
        long j = ((long) i) * 3000;
        activity.hashCode();
        final WeakReference weakReference = new WeakReference(activity);
        Runnable runnable = new Runnable() { // from class: com.byazt.ua.fw.3
            @Override // java.lang.Runnable
            public void run() {
                prVarHn.w = null;
                Activity activity2 = (Activity) weakReference.get();
                if (activity2 != null && !activity2.isFinishing()) {
                    if (!fw.yb(activity) || fw.uc(fw.lb(activity2))) {
                        return;
                    }
                    activity.hashCode();
                    fw.hw(activity2, 5, true);
                    return;
                }
                activity.hashCode();
            }
        };
        prVarHn.w = runnable;
        View viewQa = qa(activity);
        if (viewQa == null) {
            activity.hashCode();
            prVarHn.w = null;
        } else {
            viewQa.postDelayed(runnable, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean aj(Activity activity) {
        String strHw = hw();
        return (TextUtils.isEmpty(strHw) || strHw.equals(lb(activity))) ? false : true;
    }

    private static boolean hn(Activity activity, int i, boolean z) {
        String strHw = hw();
        if (TextUtils.isEmpty(strHw)) {
            return false;
        }
        if (!strHw.equals(lb(activity))) {
            return true;
        }
        if (w(activity)) {
            if (!c.pr()) {
                activity.hashCode();
                x.pr();
                c = false;
                uc = -1;
                fw = "";
                hw(activity, i, false);
                return true;
            }
            activity.hashCode();
            return true;
        }
        if (z) {
            activity.hashCode();
            hw(activity, i, false);
        } else {
            activity.hashCode();
        }
        return true;
    }

    private static boolean vk(Activity activity) {
        String strHw = hw();
        return !TextUtils.isEmpty(strHw) && strHw.equals(lb(activity));
    }

    private static boolean w(Activity activity) {
        return activity != null && c && activity.hashCode() == uc && lb(activity).equals(fw);
    }

    public static Activity pr() {
        WeakReference<Activity> weakReference = zo;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static String hw() {
        if (!TextUtils.isEmpty(x)) {
            return x;
        }
        com.byazt.zq.hn hnVarPr = com.byazt.sd.hw.pr();
        if (hnVarPr == null) {
            return "";
        }
        String strHw = hnVarPr.hw("mc_c_name", "");
        long jHw = hnVarPr.hw("mc_c_name_cache_time", 0L);
        if (!TextUtils.isEmpty(strHw) && System.currentTimeMillis() - jHw > 604800000) {
            hnVarPr.pr("mc_c_name", "");
            hnVarPr.pr("mc_c_name_cache_time", 0L);
            return "";
        }
        x = strHw;
        return strHw;
    }

    public static int hn() {
        if (w != -1) {
            return w == 0 ? 0 : -1;
        }
        com.byazt.zq.hn hnVarPr = com.byazt.sd.hw.pr();
        if (hnVarPr == null) {
            return -1;
        }
        try {
            return hnVarPr.hw("no_tab_global", false) ? 0 : -1;
        } catch (Throwable th) {
            return -1;
        }
    }

    private static void hw(String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            return;
        }
        x = str;
        com.byazt.zq.hn hnVarPr = com.byazt.sd.hw.pr();
        if (hnVarPr != null) {
            hnVarPr.pr("mc_c_name", str);
            hnVarPr.pr("mc_c_name_cache_time", System.currentTimeMillis());
        }
    }

    private static long k(Activity activity) {
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
        } catch (Throwable th) {
            return -1L;
        }
    }

    private static void pr(Activity activity, String str) {
        if (activity == null || TextUtils.isEmpty(str)) {
            return;
        }
        Map<String, Boolean> map = k;
        map.put(str, Boolean.TRUE);
        if (!vk.add(str)) {
            return;
        }
        try {
            com.byazt.zq.hn hnVarPr = com.byazt.sd.hw.pr();
            if (hnVarPr == null) {
                return;
            }
            long jK = k(activity);
            long jHw = hnVarPr.hw("no_tab_fail_version_".concat(String.valueOf(str)), -1L);
            int iHw = hnVarPr.hw("no_tab_fail_count_".concat(String.valueOf(str)), 0);
            if (jK > 0 && jHw > 0 && jHw != jK) {
                iHw = 0;
            }
            int i = iHw + 1;
            if (i >= 3) {
                hnVarPr.pr("no_tab_arch_".concat(String.valueOf(str)), true);
                hnVarPr.pr("no_tab_app_version_".concat(String.valueOf(str)), jK);
                map.put(str, Boolean.TRUE);
                int iHw2 = hnVarPr.hw("no_tab_global_class_count", 0) + 1;
                hnVarPr.pr("no_tab_global_class_count", iHw2);
                if (x(str) || iHw2 >= 4) {
                    hnVarPr.pr("no_tab_global", true);
                    hnVarPr.pr("no_tab_global_version", jK);
                    w = 0;
                    return;
                }
                return;
            }
            hnVarPr.pr("no_tab_fail_count_".concat(String.valueOf(str)), i);
            hnVarPr.pr("no_tab_fail_version_".concat(String.valueOf(str)), jK);
        } catch (Throwable th) {
        }
    }

    private static void hn(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            com.byazt.zq.hn hnVarPr = com.byazt.sd.hw.pr();
            if (hnVarPr == null) {
                return;
            }
            hnVarPr.pr("no_tab_arch_".concat(String.valueOf(str)), false);
            hnVarPr.pr("no_tab_fail_count_".concat(String.valueOf(str)), 0);
            hnVarPr.pr("no_tab_fail_version_".concat(String.valueOf(str)), 0L);
            hnVarPr.pr("no_tab_app_version_".concat(String.valueOf(str)), 0L);
            k.put(str, Boolean.FALSE);
            if (w == 0 || hnVarPr.hw("no_tab_global", false)) {
                hnVarPr.pr("no_tab_global", false);
                hnVarPr.pr("no_tab_global_class_count", 0);
                w = 1;
            }
        } catch (Throwable th) {
        }
    }

    private static boolean hw(Activity activity, String str) {
        if (activity == null || TextUtils.isEmpty(str)) {
            return false;
        }
        Map<String, Boolean> map = k;
        Boolean bool = map.get(str);
        if (bool != null) {
            return bool.booleanValue();
        }
        com.byazt.zq.hn hnVarPr = com.byazt.sd.hw.pr();
        if (hnVarPr == null) {
            return false;
        }
        try {
            if (!hnVarPr.hw("no_tab_arch_".concat(String.valueOf(str)), false)) {
                map.put(str, Boolean.FALSE);
                return false;
            }
            long jHw = hnVarPr.hw("no_tab_app_version_".concat(String.valueOf(str)), -1L);
            long jK = k(activity);
            if (jK > 0 && jHw > 0 && jHw != jK) {
                hn(str);
                return false;
            }
            map.put(str, Boolean.TRUE);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    private static boolean m(Activity activity) {
        if (activity == null) {
            return false;
        }
        try {
            if (activity.getResources() != null && activity.getResources().getConfiguration() != null && activity.getResources().getConfiguration().orientation == 2) {
                return true;
            }
        } catch (Throwable th) {
        }
        try {
            if (activity.getWindow() == null || activity.getWindow().getAttributes() == null || (activity.getWindow().getAttributes().flags & 1024) == 0) {
                return false;
            }
            return true;
        } catch (Throwable th2) {
        }
        return false;
    }

    private static boolean g(Activity activity) {
        if (activity == null) {
            return false;
        }
        String name = activity.getClass().getName();
        if (name.contains("UnityPlayerActivity") || name.contains("Cocos2dxActivity") || name.contains("NativeActivity") || name.contains("GameActivity")) {
            return true;
        }
        try {
            ApplicationInfo applicationInfo = activity.getApplicationInfo();
            return applicationInfo != null && ((Build.VERSION.SDK_INT >= 26 && applicationInfo.category == 0) || (applicationInfo.flags & RustResolvedAsset.MAX_HTML_BYTES) != 0);
        } catch (Throwable th) {
        }
    }

    private static boolean ho(Activity activity) {
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
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    private static pr hn(Activity activity, String str) {
        WeakHashMap<Activity, pr> weakHashMap = aj;
        pr prVar = weakHashMap.get(activity);
        if (prVar == null) {
            pr prVar2 = new pr(str);
            weakHashMap.put(activity, prVar2);
            return prVar2;
        }
        if (!TextUtils.isEmpty(str)) {
            prVar.pr = str;
            return prVar;
        }
        return prVar;
    }

    private static void nt(Activity activity) {
        if (activity == null) {
            return;
        }
        aj.remove(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean yb(Activity activity) {
        if (hn.x() != 1) {
            return false;
        }
        if (w == -1 && activity != null) {
            com.byazt.zq.hn hnVarPr = com.byazt.sd.hw.pr();
            if (hnVarPr == null) {
                return true;
            }
            try {
                if (hnVarPr.hw("no_tab_global", false)) {
                    long jHw = hnVarPr.hw("no_tab_global_version", -1L);
                    long jK = k(activity);
                    if (jK > 0 && jHw > 0 && jHw != jK) {
                        hnVarPr.pr("no_tab_global", false);
                        hnVarPr.pr("no_tab_global_class_count", 0);
                        w = 1;
                    } else {
                        w = 0;
                    }
                } else {
                    w = 1;
                }
            } catch (Throwable th) {
                w = 1;
            }
        }
        return w != 0;
    }

    private static boolean x(String str) {
        Set<String> setYd;
        String strFw = fw(str);
        boolean zC = false;
        if (TextUtils.isEmpty(strFw)) {
            return false;
        }
        Map<String, Boolean> map = hw;
        Boolean bool = map.get(strFw);
        if (bool != null) {
            bool.booleanValue();
            return bool.booleanValue();
        }
        com.byazt.is.w wVarHw = a.hw();
        if (wVarHw != null && (setYd = wVarHw.yd()) != null && setYd.contains(strFw)) {
            zC = true;
        }
        if (!zC) {
            zC = c(strFw);
        }
        map.put(strFw, Boolean.valueOf(zC));
        return zC;
    }

    private static boolean c(String str) {
        try {
            String strPr = com.byazt.cb.hn.pr(str.toLowerCase());
            return strPr != null && pr.contains(strPr);
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean uc(String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        String str2 = null;
        for (String str3 : x()) {
            if (lowerCase.contains(str3)) {
                str2 = str3;
                break;
            }
        }
        if (str2 == null) {
            return false;
        }
        return true;
    }

    private static boolean c() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i = 0;
        for (pr prVar : aj.values()) {
            if (prVar != null && prVar.hn > 0 && prVar.c == 0 && prVar.x < prVar.hn && jCurrentTimeMillis - prVar.hn < 86400000) {
                i++;
            }
        }
        return i <= 2;
    }

    private static String fw(String str) {
        if (str == null) {
            return "";
        }
        int iLastIndexOf = str.lastIndexOf(46);
        return iLastIndexOf >= 0 ? str.substring(iLastIndexOf + 1) : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String lb(Activity activity) {
        if (activity == null) {
            return "";
        }
        try {
            Object objPr = w.pr(activity);
            if (objPr == null) {
                return activity.getClass().getName();
            }
            return objPr.getClass().getName();
        } catch (Throwable th) {
            return activity.getClass().getName();
        }
    }

    private static View qa(Activity activity) {
        if (activity == null) {
            return null;
        }
        try {
            if (activity.getWindow() != null) {
                return activity.getWindow().getDecorView();
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    private static void a(Activity activity) {
        pr prVar = aj.get(activity);
        if (prVar == null) {
            return;
        }
        View viewQa = qa(activity);
        if (viewQa != null) {
            if (prVar.vk != null) {
                viewQa.removeCallbacks(prVar.vk);
            }
            if (prVar.w != null) {
                viewQa.removeCallbacks(prVar.w);
            }
            if (prVar.k != null) {
                viewQa.removeCallbacks(prVar.k);
            }
        }
        prVar.vk = null;
        prVar.w = null;
        prVar.k = null;
        prVar.zo = false;
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID, 766})
    private static final class pr {
        public long aj;
        public long c;
        public int fw;
        public long hn;
        public long hw;
        public Runnable k;
        public String pr;
        public boolean uc;
        public Runnable vk;
        public Runnable w;
        public long x;
        public boolean zo;

        public pr(String str) {
            this.pr = str;
        }
    }
}
