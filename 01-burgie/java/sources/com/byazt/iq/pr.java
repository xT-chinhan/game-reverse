package com.byazt.iq;

import android.text.TextUtils;
import com.byazt.ca.uc;
import com.byazt.mp.hn;
import com.byazt.sd.a;
import com.byazt.sd.iu;
import com.byazt.sd.zo;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1612, 37})
public class pr {
    public static AtomicBoolean pr;

    /* JADX WARN: Code duplicated, block: B:14:0x0041  */
    public static boolean pr() {
        boolean z;
        try {
            AtomicBoolean atomicBoolean = pr;
            if (atomicBoolean != null) {
                return atomicBoolean.get();
            }
            File file = new File(uc.pr(a.getContext(), false, null).getParent(), "/pangle_p/com.byted.pangle");
            file.getAbsolutePath();
            if (!file.exists()) {
                z = false;
            } else {
                final StringBuilder sb = new StringBuilder("^version-(\\d+)$");
                file.listFiles();
                File[] fileArrListFiles = file.listFiles(new FileFilter() { // from class: com.byazt.iq.pr.1
                    @Override // java.io.FileFilter
                    public boolean accept(File file2) {
                        if (file2 == null) {
                            return false;
                        }
                        try {
                            int i = iu.x;
                            Matcher matcher = Pattern.compile(sb.toString()).matcher(file2.getName());
                            String strGroup = matcher.find() ? matcher.group() : "";
                            return (TextUtils.isEmpty(strGroup) ? 0 : Integer.parseInt(strGroup.substring(8))) > i;
                        } catch (Exception e) {
                            return file2.getName().matches(sb.toString());
                        }
                    }
                });
                if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                    z = false;
                } else {
                    z = true;
                }
            }
            pr(z);
            return z;
        } catch (Throwable th) {
            return false;
        }
    }

    public static void pr(boolean z) {
        if (pr == null) {
            pr = new AtomicBoolean();
        }
        pr.set(z);
        zo.nt().ho();
    }

    public static boolean hw() {
        return uc() && x() && pr();
    }

    public static boolean hn() {
        boolean z = iu.hn;
        return false;
    }

    public static boolean x() {
        return hn.pr().aj() == 0;
    }

    public static int c() {
        return iu.hn ? 1 : 0;
    }

    public static boolean uc() {
        return iu.hn;
    }

    public static boolean fw() {
        return uc() && zo.nt().y();
    }

    public static boolean zo() {
        return hn.pr().vk();
    }
}
