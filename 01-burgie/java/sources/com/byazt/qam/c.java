package com.byazt.qam;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.byazt.sd.a;
import com.byazt.wt.z;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1745, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public static final String pr = c.class.getSimpleName();
    public static volatile c c = null;
    public final CopyOnWriteArraySet<String> hw = new CopyOnWriteArraySet<>();
    public final List<WeakReference<uc>> hn = new ArrayList(1);
    public final List<uc> x = new ArrayList(1);

    public static c pr() {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c();
                }
            }
        }
        return c;
    }

    private c() {
        hw();
    }

    private void hw() {
        hn();
    }

    private void hn() {
        PackageInfo packageInfo;
        String[] strArr;
        Context context = a.getContext();
        if (context == null) {
            return;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo(packageName, 4096)) != null && (strArr = packageInfo.requestedPermissions) != null && strArr.length != 0) {
                for (int i = 0; i < strArr.length; i++) {
                    if (!TextUtils.isEmpty(strArr[i])) {
                        this.hw.add(strArr[i]);
                    }
                }
            }
        } catch (Throwable th) {
        }
    }

    private synchronized void pr(String[] strArr, uc ucVar) {
        if (ucVar == null) {
            return;
        }
        ucVar.pr(strArr);
        this.x.add(ucVar);
        this.hn.add(new WeakReference<>(ucVar));
    }

    private synchronized void pr(uc ucVar) {
        Iterator<WeakReference<uc>> it = this.hn.iterator();
        while (it.hasNext()) {
            WeakReference<uc> next = it.next();
            if (next.get() == ucVar || next.get() == null) {
                it.remove();
            }
        }
        Iterator<uc> it2 = this.x.iterator();
        while (it2.hasNext()) {
            if (it2.next() == ucVar) {
                it2.remove();
            }
        }
    }

    public boolean pr(Context context, String str) {
        if (context == null) {
            return false;
        }
        if (z.a()) {
            return hn.pr(context, str) && hw.pr(context, str) == 0;
        }
        return hw.pr(context, str) == 0;
    }

    public boolean hw(Context context, String str) {
        if (context == null) {
            return false;
        }
        if (z.a()) {
            return hn.pr(context, str) && hw.pr(context, str) == 0;
        }
        return hw.pr(context, str) == 0;
    }

    public synchronized void pr(Activity activity, String[] strArr, uc ucVar) {
        if (activity == null) {
            return;
        }
        try {
            pr(strArr, ucVar);
            if (Build.VERSION.SDK_INT < 23) {
                hw(activity, strArr, ucVar);
                return;
            }
            List<String> listHn = hn(activity, strArr, ucVar);
            if (listHn.isEmpty()) {
                pr(ucVar);
            } else {
                hw.requestPermissions(activity, (String[]) listHn.toArray(new String[listHn.size()]), 1);
            }
        } catch (Throwable th) {
        }
    }

    private void hw(Activity activity, String[] strArr, uc ucVar) {
        boolean zPr;
        for (String str : strArr) {
            if (ucVar != null) {
                try {
                    if (!this.hw.contains(str)) {
                        zPr = ucVar.pr(str, x.NOT_FOUND);
                    } else if (hw.pr(activity, str) != 0) {
                        zPr = ucVar.pr(str, x.DENIED);
                    } else {
                        zPr = ucVar.pr(str, x.GRANTED);
                    }
                    if (zPr) {
                        break;
                    }
                } catch (Throwable th) {
                }
            }
        }
        pr(ucVar);
    }

    private List<String> hn(Activity activity, String[] strArr, uc ucVar) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (!this.hw.contains(str)) {
                if (ucVar != null) {
                    ucVar.pr(str, x.NOT_FOUND);
                }
            } else if (!pr(activity, str)) {
                arrayList.add(str);
            } else if (ucVar != null) {
                ucVar.pr(str, x.GRANTED);
            }
        }
        return arrayList;
    }

    public synchronized void pr(Activity activity, String[] strArr, int[] iArr) {
        try {
            new ArrayList(3);
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                String str = strArr[i];
                if ((iArr[i] == -1 || (z.a() && !hn.pr(activity, str))) && iArr[i] != -1) {
                    iArr[i] = -1;
                }
            }
            pr(strArr, iArr, (String[]) null);
        } catch (Throwable th) {
        }
    }

    private void pr(String[] strArr, int[] iArr, String[] strArr2) {
        int i;
        try {
            int length = strArr.length;
            if (iArr.length < length) {
                length = iArr.length;
            }
            Iterator<WeakReference<uc>> it = this.hn.iterator();
            while (it.hasNext()) {
                uc ucVar = it.next().get();
                while (i < length) {
                    i = (ucVar == null || ucVar.pr(strArr[i], iArr[i])) ? 0 : i + 1;
                    it.remove();
                    break;
                }
            }
            Iterator<uc> it2 = this.x.iterator();
            while (it2.hasNext()) {
                it2.next();
                it2.remove();
            }
        } catch (Throwable th) {
        }
    }
}
