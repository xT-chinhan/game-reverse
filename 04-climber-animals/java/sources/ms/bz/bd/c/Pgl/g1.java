package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.util.Log;
import com.bytedance.sdk.openadsdk.api.plugin.xr;
import java.io.File;
import java.util.HashSet;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public final class g1 {
    protected final e1.pgla ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected final HashSet f4833ms = new HashSet();
    protected final e1.pblb xr;

    protected g1(e1.pblb pblbVar, pbld pbldVar) {
        this.xr = pblbVar;
        this.ah = pbldVar;
    }

    public final void ms(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        }
        String.format(Locale.US, "Beginning load of %s...", "Pglbizssdk_ml");
        ms(context, "Pglbizssdk_ml", null);
    }

    private void ms(Context context, String str, String str2) {
        File file;
        File file2;
        if (this.f4833ms.contains(str)) {
            String.format(Locale.US, "%s already loaded previously!", str);
            return;
        }
        try {
            ((s1) this.xr).getClass();
            com.bytedance.sdk.openadsdk.op.c.ms(str);
            this.f4833ms.add(str);
            String.format(Locale.US, "%s (%s) was loaded normally!", str, str2);
        } catch (UnsatisfiedLinkError e) {
            Object[] objArr = {Log.getStackTraceString(e)};
            Locale locale = Locale.US;
            String.format(locale, "Loading the library normally failed: %s", objArr);
            String.format(locale, "%s (%s) was not loaded normally, re-linking...", str, str2);
            ((s1) this.xr).getClass();
            String strMapLibraryName = (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str);
            if (str2 == null || str2.length() == 0) {
                file = new File(xr.ms(context, "lib", 0), strMapLibraryName);
            } else {
                file = new File(xr.ms(context, "lib", 0), strMapLibraryName + com.anythink.core.common.d.j.z + str2);
            }
            File file3 = file;
            if (!file3.exists()) {
                File fileMs = xr.ms(context, "lib", 0);
                ((s1) this.xr).getClass();
                String strMapLibraryName2 = (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str);
                if (str2 == null || str2.length() == 0) {
                    file2 = new File(xr.ms(context, "lib", 0), strMapLibraryName2);
                } else {
                    file2 = new File(xr.ms(context, "lib", 0), strMapLibraryName2 + com.anythink.core.common.d.j.z + str2);
                }
                ((s1) this.xr).getClass();
                File[] fileArrListFiles = fileMs.listFiles(new f1((str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str)));
                if (fileArrListFiles != null) {
                    for (File file4 : fileArrListFiles) {
                        if (!file4.getAbsolutePath().equals(file2.getAbsolutePath())) {
                            file4.delete();
                        }
                    }
                }
                e1.pgla pglaVar = this.ah;
                String[] strArrMs = ((s1) this.xr).ms();
                ((s1) this.xr).getClass();
                ((pbld) pglaVar).ms(context, strArrMs, (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str), file3, this);
            }
            e1.pblb pblbVar = this.xr;
            String absolutePath = file3.getAbsolutePath();
            ((s1) pblbVar).getClass();
            System.load(absolutePath);
            this.f4833ms.add(str);
            String.format(Locale.US, "%s (%s) was re-linked!", str, str2);
        }
    }
}
