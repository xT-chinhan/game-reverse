package com.byazt.af;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SAVED_HOST_TIME, 21})
public class x {
    public static volatile x l = null;
    public static final String n = "x";
    public final CopyOnWriteArraySet<String> qg = new CopyOnWriteArraySet<>();
    public final List<WeakReference<fs>> s = new ArrayList(1);
    public final List<fs> q = new ArrayList(1);

    public static x n() {
        if (l == null) {
            synchronized (x.class) {
                if (l == null) {
                    l = new x();
                }
            }
        }
        return l;
    }

    private x() {
        qg();
    }

    private void qg() {
        s();
    }

    private void s() {
        PackageInfo packageInfo;
        String[] strArr;
        Context context = com.byazt.nf.rv.getContext();
        if (context == null) {
            return;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo(packageName, 4096)) != null && (strArr = packageInfo.requestedPermissions) != null && strArr.length != 0) {
                for (int i = 0; i < strArr.length; i++) {
                    if (!TextUtils.isEmpty(strArr[i])) {
                        this.qg.add(strArr[i]);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private synchronized void n(String[] strArr, fs fsVar) {
        if (fsVar == null) {
            return;
        }
        fsVar.n(strArr);
        this.q.add(fsVar);
        this.s.add(new WeakReference<>(fsVar));
    }

    private synchronized void n(fs fsVar) {
        Iterator<WeakReference<fs>> it = this.s.iterator();
        while (it.hasNext()) {
            WeakReference<fs> next = it.next();
            if (next.get() == fsVar || next.get() == null) {
                it.remove();
            }
        }
        Iterator<fs> it2 = this.q.iterator();
        while (it2.hasNext()) {
            if (it2.next() == fsVar) {
                it2.remove();
            }
        }
    }

    public boolean n(Context context, String str) {
        if (context == null) {
            return false;
        }
        if (com.byazt.ehw.rv.a()) {
            return l.n(context, str) && s.n(context, str) == 0;
        }
        return s.n(context, str) == 0;
    }

    public boolean qg(Context context, String str) {
        if (context == null) {
            return false;
        }
        if (com.byazt.ehw.rv.a()) {
            return l.n(context, str) && s.n(context, str) == 0;
        }
        return s.n(context, str) == 0;
    }

    public synchronized void n(Activity activity, String[] strArr, fs fsVar) {
        if (activity == null) {
            return;
        }
        try {
            n(strArr, fsVar);
            List<String> listS = s(activity, strArr, fsVar);
            if (listS.isEmpty()) {
                n(fsVar);
            } else {
                s.requestPermissions(activity, (String[]) listS.toArray(new String[listS.size()]), 1);
            }
        } catch (Throwable unused) {
        }
    }

    private void qg(Activity activity, String[] strArr, fs fsVar) {
        boolean zN;
        for (String str : strArr) {
            if (fsVar != null) {
                try {
                    if (!this.qg.contains(str)) {
                        zN = fsVar.n(str, w.NOT_FOUND);
                    } else if (s.n(activity, str) != 0) {
                        zN = fsVar.n(str, w.DENIED);
                    } else {
                        zN = fsVar.n(str, w.GRANTED);
                    }
                    if (zN) {
                        break;
                    }
                } catch (Throwable unused) {
                    continue;
                }
            }
        }
        n(fsVar);
    }

    private List<String> s(Activity activity, String[] strArr, fs fsVar) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (this.qg.contains(str)) {
                if (!n(activity, str)) {
                    arrayList.add(str);
                } else if (fsVar != null) {
                    fsVar.n(str, w.GRANTED);
                }
            } else if (fsVar != null) {
                fsVar.n(str, w.NOT_FOUND);
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
                if ((iArr[i] == -1 || (com.byazt.ehw.rv.a() && !l.n(activity, str))) && iArr[i] != -1) {
                    iArr[i] = -1;
                }
            }
            n(strArr, iArr, (String[]) null);
        } catch (Throwable unused) {
        }
    }

    private void n(String[] strArr, int[] iArr, String[] strArr2) {
        int i;
        try {
            int length = strArr.length;
            if (iArr.length < length) {
                length = iArr.length;
            }
            Iterator<WeakReference<fs>> it = this.s.iterator();
            while (it.hasNext()) {
                fs fsVar = it.next().get();
                while (i < length) {
                    i = (fsVar == null || fsVar.n(strArr[i], iArr[i])) ? 0 : i + 1;
                    it.remove();
                    break;
                }
            }
            Iterator<fs> it2 = this.q.iterator();
            while (it2.hasNext()) {
                it2.next();
                it2.remove();
            }
        } catch (Throwable unused) {
        }
    }
}
