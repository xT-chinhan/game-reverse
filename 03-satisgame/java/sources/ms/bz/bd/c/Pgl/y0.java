package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.util.Log;
import com.byazt.qyu.qg;
import java.io.File;
import java.util.HashSet;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class y0 {
    protected final HashSet n = new HashSet();
    protected final w0.pblb qg;
    protected final w0.pgla s;

    protected y0(w0.pblb pblbVar, pblb pblbVar2) {
        this.qg = pblbVar;
        this.s = pblbVar2;
    }

    public final void n(Context context) throws Throwable {
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        }
        String.format(Locale.US, "Beginning load of %s...", "Pglbizssdk_ml");
        n(context, "Pglbizssdk_ml", null);
    }

    private void n(Context context, String str, String str2) throws Throwable {
        File file;
        File file2;
        if (this.n.contains(str)) {
            String.format(Locale.US, "%s already loaded previously!", str);
            return;
        }
        try {
            ((m1) this.qg).getClass();
            com.byazt.xhd.s.n(str);
            this.n.add(str);
            String.format(Locale.US, "%s (%s) was loaded normally!", str, str2);
        } catch (UnsatisfiedLinkError e) {
            Object[] objArr = {Log.getStackTraceString(e)};
            Locale locale = Locale.US;
            String.format(locale, "Loading the library normally failed: %s", objArr);
            String.format(locale, "%s (%s) was not loaded normally, re-linking...", str, str2);
            ((m1) this.qg).getClass();
            String strMapLibraryName = (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str);
            if (str2 == null || str2.length() == 0) {
                file = new File(qg.n(context, "lib", 0), strMapLibraryName);
            } else {
                file = new File(qg.n(context, "lib", 0), strMapLibraryName + com.anythink.core.common.d.i.E + str2);
            }
            File file3 = file;
            if (!file3.exists()) {
                File fileN = qg.n(context, "lib", 0);
                ((m1) this.qg).getClass();
                String strMapLibraryName2 = (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str);
                if (str2 == null || str2.length() == 0) {
                    file2 = new File(qg.n(context, "lib", 0), strMapLibraryName2);
                } else {
                    file2 = new File(qg.n(context, "lib", 0), strMapLibraryName2 + com.anythink.core.common.d.i.E + str2);
                }
                ((m1) this.qg).getClass();
                File[] fileArrListFiles = fileN.listFiles(new x0((str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str)));
                if (fileArrListFiles != null) {
                    for (File file4 : fileArrListFiles) {
                        if (!file4.getAbsolutePath().equals(file2.getAbsolutePath())) {
                            file4.delete();
                        }
                    }
                }
                w0.pgla pglaVar = this.s;
                String[] strArrN = ((m1) this.qg).n();
                ((m1) this.qg).getClass();
                ((pblb) pglaVar).n(context, strArrN, (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str), file3, this);
            }
            w0.pblb pblbVar = this.qg;
            String absolutePath = file3.getAbsolutePath();
            ((m1) pblbVar).getClass();
            System.load(absolutePath);
            this.n.add(str);
            String.format(Locale.US, "%s (%s) was re-linked!", str, str2);
        }
    }
}
