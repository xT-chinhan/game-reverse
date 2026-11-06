package com.byazt.uf;

import android.util.Pair;
import com.anythink.core.common.d.i;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 886, 21})
public class x {
    public final l n;

    public x(l lVar) {
        this.n = lVar;
    }

    public Pair<s, InputStream> n(String str) {
        s sVar;
        try {
            File fileQg = qg(str);
            if (fileQg == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(fileQg);
            if (fileQg.getAbsolutePath().endsWith(".zip")) {
                sVar = s.ZIP;
            } else {
                sVar = s.JSON;
            }
            com.byazt.nu.w.n("Cache hit for " + str + " at " + fileQg.getAbsolutePath());
            return new Pair<>(sVar, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    public File n(String str, InputStream inputStream, s sVar) throws IOException {
        File file = new File(n(), n(str, sVar, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i != -1) {
                        fileOutputStream.write(bArr, 0, i);
                    } else {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        inputStream.close();
                        return file;
                    }
                }
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        } catch (Throwable th2) {
            inputStream.close();
            throw th2;
        }
    }

    public void n(String str, s sVar) {
        File file = new File(n(), n(str, sVar, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean zRenameTo = file.renameTo(file2);
        com.byazt.nu.w.n("Copying temp file to real file (" + file2 + ")");
        if (zRenameTo) {
            return;
        }
        com.byazt.nu.w.qg("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + i.E);
    }

    private File qg(String str) throws FileNotFoundException {
        File file = new File(n(), n(str, s.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(n(), n(str, s.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    private File n() {
        File fileN = this.n.n();
        if (fileN.isFile()) {
            fileN.delete();
        }
        if (!fileN.exists()) {
            fileN.mkdirs();
        }
        return fileN;
    }

    private static String n(String str, s sVar, boolean z) {
        return "lottie_cache_" + str.replaceAll("\\W+", "") + (z ? sVar.n() : sVar.s);
    }
}
