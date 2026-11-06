package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.util.Log;
import com.byazt.mg.hw;
import com.byazt.zp.fw;
import java.io.File;
import java.util.HashSet;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class y0 {
    protected final w0.pgla hn;
    protected final w0.pblb hw;
    protected final HashSet pr = new HashSet();

    protected y0(w0.pblb pblbVar, pblb pblbVar2) {
        this.hw = pblbVar;
        this.hn = pblbVar2;
    }

    public final void pr(Context context) throws Throwable {
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        }
        if ("Pglbizssdk_ml".length() == 0) {
            throw new IllegalArgumentException("Given library is either null or empty");
        }
        String.format(Locale.US, "Beginning load of %s...", "Pglbizssdk_ml");
        pr(context, "Pglbizssdk_ml", null);
    }

    private void pr(Context context, String str, String str2) throws Throwable {
        File file;
        File file2;
        if (this.pr.contains(str)) {
            String.format(Locale.US, "%s already loaded previously!", str);
            return;
        }
        try {
            ((m1) this.hw).getClass();
            fw.pr(str);
            this.pr.add(str);
            String.format(Locale.US, "%s (%s) was loaded normally!", str, str2);
        } catch (UnsatisfiedLinkError e) {
            Object[] objArr = {Log.getStackTraceString(e)};
            Locale locale = Locale.US;
            String.format(locale, "Loading the library normally failed: %s", objArr);
            String.format(locale, "%s (%s) was not loaded normally, re-linking...", str, str2);
            ((m1) this.hw).getClass();
            String strMapLibraryName = (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str);
            if (str2 == null || str2.length() == 0) {
                file = new File(hw.pr(context, "lib", 0), strMapLibraryName);
            } else {
                file = new File(hw.pr(context, "lib", 0), strMapLibraryName + "." + str2);
            }
            if (!file.exists()) {
                File filePr = hw.pr(context, "lib", 0);
                ((m1) this.hw).getClass();
                String strMapLibraryName2 = (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str);
                if (str2 == null || str2.length() == 0) {
                    file2 = new File(hw.pr(context, "lib", 0), strMapLibraryName2);
                } else {
                    file2 = new File(hw.pr(context, "lib", 0), strMapLibraryName2 + "." + str2);
                }
                ((m1) this.hw).getClass();
                File[] fileArrListFiles = filePr.listFiles(new x0((str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str)));
                if (fileArrListFiles != null) {
                    for (File file3 : fileArrListFiles) {
                        if (!file3.getAbsolutePath().equals(file2.getAbsolutePath())) {
                            file3.delete();
                        }
                    }
                }
                w0.pgla pglaVar = this.hn;
                String[] strArrPr = ((m1) this.hw).pr();
                ((m1) this.hw).getClass();
                ((pblb) pglaVar).pr(context, strArrPr, (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str), file, this);
            }
            w0.pblb pblbVar = this.hw;
            String absolutePath = file.getAbsolutePath();
            ((m1) pblbVar).getClass();
            System.load(absolutePath);
            this.pr.add(str);
            String.format(Locale.US, "%s (%s) was re-linked!", str, str2);
        }
    }
}
