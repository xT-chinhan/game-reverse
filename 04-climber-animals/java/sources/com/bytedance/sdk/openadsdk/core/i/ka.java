package com.bytedance.sdk.openadsdk.core.i;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.jw.w;
import com.bytedance.sdk.openadsdk.core.re;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes2.dex */
public class ka {
    private static volatile ka ka = null;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final String f2665ms = "ka";
    private final CopyOnWriteArraySet<String> xr = new CopyOnWriteArraySet<>();
    private final List<WeakReference<c>> ah = new ArrayList(1);
    private final List<c> d = new ArrayList(1);

    public static ka ms() {
        if (ka == null) {
            synchronized (ka.class) {
                if (ka == null) {
                    ka = new ka();
                }
            }
        }
        return ka;
    }

    private ka() {
        xr();
    }

    private void xr() {
        ah();
    }

    private void ah() {
        PackageInfo packageInfo;
        String[] strArr;
        Context context = re.getContext();
        if (context == null) {
            return;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo(packageName, 4096)) != null && (strArr = packageInfo.requestedPermissions) != null && strArr.length != 0) {
                for (int i = 0; i < strArr.length; i++) {
                    if (!TextUtils.isEmpty(strArr[i])) {
                        this.xr.add(strArr[i]);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private synchronized void ms(String[] strArr, c cVar) {
        if (cVar == null) {
            return;
        }
        cVar.ms(strArr);
        this.d.add(cVar);
        this.ah.add(new WeakReference<>(cVar));
    }

    private synchronized void ms(c cVar) {
        Iterator<WeakReference<c>> it = this.ah.iterator();
        while (it.hasNext()) {
            WeakReference<c> next = it.next();
            if (next.get() == cVar || next.get() == null) {
                it.remove();
            }
        }
        Iterator<c> it2 = this.d.iterator();
        while (it2.hasNext()) {
            if (it2.next() == cVar) {
                it2.remove();
            }
        }
    }

    public boolean ms(Context context, String str) {
        if (context == null) {
            return false;
        }
        if (w.ao()) {
            return ah.ms(context, str) && xr.ms(context, str) == 0;
        }
        return xr.ms(context, str) == 0;
    }

    public synchronized void ms(Activity activity, String[] strArr, c cVar) {
        if (activity == null) {
            return;
        }
        try {
            ms(strArr, cVar);
            List<String> listAh = ah(activity, strArr, cVar);
            if (listAh.isEmpty()) {
                ms(cVar);
            } else {
                xr.requestPermissions(activity, (String[]) listAh.toArray(new String[listAh.size()]), 1);
            }
        } catch (Throwable th) {
            sl.ms(th);
        }
    }

    private void xr(Activity activity, String[] strArr, c cVar) {
        boolean zMs;
        for (String str : strArr) {
            if (cVar != null) {
                try {
                    if (!this.xr.contains(str)) {
                        zMs = cVar.ms(str, d.NOT_FOUND);
                    } else if (xr.ms(activity, str) != 0) {
                        zMs = cVar.ms(str, d.DENIED);
                    } else {
                        zMs = cVar.ms(str, d.GRANTED);
                    }
                    if (zMs) {
                        break;
                    }
                } catch (Throwable th) {
                    sl.ms(th);
                }
            }
        }
        ms(cVar);
    }

    private List<String> ah(Activity activity, String[] strArr, c cVar) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (this.xr.contains(str)) {
                if (!ms(activity, str)) {
                    arrayList.add(str);
                } else if (cVar != null) {
                    cVar.ms(str, d.GRANTED);
                }
            } else if (cVar != null) {
                cVar.ms(str, d.NOT_FOUND);
            }
        }
        return arrayList;
    }

    public synchronized void ms(Activity activity, String[] strArr, int[] iArr) {
        try {
            new ArrayList(3);
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                String str = strArr[i];
                if ((iArr[i] == -1 || (w.ao() && !ah.ms(activity, str))) && iArr[i] != -1) {
                    iArr[i] = -1;
                }
            }
            ms(strArr, iArr, (String[]) null);
        } catch (Throwable th) {
            sl.ms(th);
        }
    }

    private void ms(String[] strArr, int[] iArr, String[] strArr2) {
        int i;
        try {
            int length = strArr.length;
            if (iArr.length < length) {
                length = iArr.length;
            }
            Iterator<WeakReference<c>> it = this.ah.iterator();
            while (it.hasNext()) {
                c cVar = it.next().get();
                while (i < length) {
                    i = (cVar == null || cVar.ms(strArr[i], iArr[i])) ? 0 : i + 1;
                    it.remove();
                    break;
                }
            }
            Iterator<c> it2 = this.d.iterator();
            while (it2.hasNext()) {
                it2.next();
                it2.remove();
            }
        } catch (Throwable th) {
            sl.ms(th);
        }
    }
}
