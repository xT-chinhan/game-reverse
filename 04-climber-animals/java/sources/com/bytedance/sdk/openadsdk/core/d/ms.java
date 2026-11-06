package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.re;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static AtomicBoolean f2457ms;

    /* JADX WARN: Code duplicated, block: B:14:0x0040  */
    public static boolean ms() {
        boolean z;
        try {
            AtomicBoolean atomicBoolean = f2457ms;
            if (atomicBoolean != null) {
                return atomicBoolean.get();
            }
            File file = new File(com.bytedance.sdk.openadsdk.api.plugin.xr.ms(re.getContext()).getParent(), "/pangle_p/com.byted.pangle");
            file.getAbsolutePath();
            if (file.exists()) {
                final StringBuilder sb = new StringBuilder("^version-(\\d+)$");
                file.listFiles();
                File[] fileArrListFiles = file.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.core.d.ms.1
                    @Override // java.io.FileFilter
                    public boolean accept(File file2) {
                        if (file2 == null) {
                            return false;
                        }
                        try {
                            int i = g.xr;
                            Matcher matcher = Pattern.compile(sb.toString()).matcher(file2.getName());
                            String strGroup = matcher.find() ? matcher.group() : "";
                            return (TextUtils.isEmpty(strGroup) ? 0 : Integer.parseInt(strGroup.substring(8))) > i;
                        } catch (Exception e) {
                            sl.ms(e);
                            return file2.getName().matches(sb.toString());
                        }
                    }
                });
                if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                    z = false;
                } else {
                    z = true;
                }
            } else {
                z = false;
            }
            ms(z);
            return z;
        } catch (Throwable th) {
            sl.ms(th);
            return false;
        }
    }

    public static void ms(boolean z) {
        if (f2457ms == null) {
            f2457ms = new AtomicBoolean();
        }
        f2457ms.set(z);
        ch.ub().u();
    }

    public static boolean xr() {
        return ka() && !com.bytedance.sdk.openadsdk.core.ah.ah.ms().x() && ms();
    }

    public static boolean ah() {
        boolean z = g.f2500ms;
        return false;
    }

    public static int d() {
        return g.f2500ms ? 1 : 0;
    }

    public static boolean ka() {
        return g.f2500ms;
    }

    public static boolean c() {
        return ka() && ch.ub().cv();
    }

    public static boolean ab() {
        return com.bytedance.sdk.openadsdk.core.ah.ah.ms().ny();
    }
}
