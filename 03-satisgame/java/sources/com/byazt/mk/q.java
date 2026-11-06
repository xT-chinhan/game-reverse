package com.byazt.mk;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.byazt.vy.um;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1141, 5})
public class q {
    public static q q;
    public final Set<String> n = new HashSet(1);
    public final List<l> qg = new ArrayList(1);
    public final List<WeakReference<l>> s = new ArrayList(1);

    public static q n() {
        if (q == null) {
            q = new q();
        }
        return q;
    }

    private q() {
        qg();
    }

    private void qg() {
        PackageInfo packageInfo;
        String[] strArr;
        Context context = com.byazt.qt.qg.getContext();
        if (context == null) {
            return;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo(packageName, 4096)) != null && (strArr = packageInfo.requestedPermissions) != null && strArr.length != 0) {
                for (int i = 0; i < strArr.length; i++) {
                    if (!TextUtils.isEmpty(strArr[i])) {
                        this.n.add(strArr[i]);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private synchronized void n(String[] strArr, l lVar) {
        if (lVar != null) {
            lVar.n(strArr);
            this.qg.add(lVar);
            this.s.add(new WeakReference<>(lVar));
        }
    }

    private synchronized void n(l lVar) {
        Iterator<WeakReference<l>> it = this.s.iterator();
        while (it.hasNext()) {
            WeakReference<l> next = it.next();
            if (next.get() == lVar || next.get() == null) {
                it.remove();
            }
        }
        Iterator<l> it2 = this.qg.iterator();
        while (it2.hasNext()) {
            if (it2.next() == lVar) {
                it2.remove();
            }
        }
    }

    public synchronized boolean n(Context context, String str) {
        if (context == null) {
            return false;
        }
        if (um.l()) {
            return com.byazt.af.l.n(context, str) && (qg.n(context, str) == 0 || !this.n.contains(str));
        }
        return qg.n(context, str) == 0 || !this.n.contains(str);
    }

    public synchronized void n(Activity activity, String[] strArr, l lVar) {
        if (activity != null) {
            try {
                n(strArr, lVar);
                List<String> listS = s(activity, strArr, lVar);
                if (listS.isEmpty()) {
                    n(lVar);
                } else {
                    qg.requestPermissions(activity, (String[]) listS.toArray(new String[listS.size()]), 1);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void qg(Activity activity, String[] strArr, l lVar) {
        boolean zN;
        for (String str : strArr) {
            if (lVar != null) {
                try {
                    if (!this.n.contains(str)) {
                        zN = lVar.n(str, s.NOT_FOUND);
                    } else if (qg.n(activity, str) != 0) {
                        zN = lVar.n(str, s.DENIED);
                    } else {
                        zN = lVar.n(str, s.GRANTED);
                    }
                    if (zN) {
                        break;
                    }
                } catch (Throwable unused) {
                    continue;
                }
            }
        }
        n(lVar);
    }

    private List<String> s(Activity activity, String[] strArr, l lVar) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (this.n.contains(str)) {
                if (!n(activity, str)) {
                    arrayList.add(str);
                } else if (lVar != null) {
                    lVar.n(str, s.GRANTED);
                }
            } else if (lVar != null) {
                lVar.n(str, s.NOT_FOUND);
            }
        }
        return arrayList;
    }

    public synchronized void n(Activity activity, String[] strArr, int[] iArr) {
        try {
            new ArrayList(3);
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                String str = strArr[i];
                if ((iArr[i] == -1 || (um.l() && !com.byazt.af.l.n(activity, str))) && iArr[i] != -1) {
                    iArr[i] = -1;
                }
            }
            n(strArr, iArr);
        } catch (Throwable unused) {
        }
    }

    private void n(String[] strArr, int[] iArr) {
        int i;
        try {
            int length = strArr.length;
            if (iArr.length < length) {
                length = iArr.length;
            }
            Iterator<WeakReference<l>> it = this.s.iterator();
            while (it.hasNext()) {
                l lVar = it.next().get();
                while (i < length) {
                    i = (lVar == null || lVar.n(strArr[i], iArr[i])) ? 0 : i + 1;
                    it.remove();
                    break;
                }
            }
            Iterator<l> it2 = this.qg.iterator();
            while (it2.hasNext()) {
                it2.next();
                it2.remove();
            }
        } catch (Throwable unused) {
        }
    }
}
