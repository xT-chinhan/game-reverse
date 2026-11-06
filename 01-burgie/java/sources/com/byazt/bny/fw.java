package com.byazt.bny;

import android.util.Pair;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1753, 62})
public class fw {
    public final c pr;

    public fw(c cVar) {
        this.pr = cVar;
    }

    public Pair<hn, InputStream> pr(String str) {
        hn hnVar;
        try {
            File fileHw = hw(str);
            if (fileHw == null) {
                return null;
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(fileHw);
                if (fileHw.getAbsolutePath().endsWith(".zip")) {
                    hnVar = hn.ZIP;
                } else {
                    hnVar = hn.JSON;
                }
                com.byazt.ptr.uc.pr("Cache hit for " + str + " at " + fileHw.getAbsolutePath());
                return new Pair<>(hnVar, fileInputStream);
            } catch (FileNotFoundException e) {
                return null;
            }
        } catch (FileNotFoundException e2) {
            return null;
        }
    }

    public File pr(String str, InputStream inputStream, hn hnVar) throws IOException {
        File file = new File(pr(), pr(str, hnVar, true));
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

    public void pr(String str, hn hnVar) {
        File file = new File(pr(), pr(str, hnVar, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean zRenameTo = file.renameTo(file2);
        com.byazt.ptr.uc.pr("Copying temp file to real file (" + file2 + ")");
        if (!zRenameTo) {
            com.byazt.ptr.uc.hw("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
        }
    }

    private File hw(String str) throws FileNotFoundException {
        File file = new File(pr(), pr(str, hn.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(pr(), pr(str, hn.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    private File pr() {
        File filePr = this.pr.pr();
        if (filePr.isFile()) {
            filePr.delete();
        }
        if (!filePr.exists()) {
            filePr.mkdirs();
        }
        return filePr;
    }

    private static String pr(String str, hn hnVar, boolean z) {
        return "lottie_cache_" + str.replaceAll("\\W+", "") + (z ? hnVar.pr() : hnVar.hn);
    }
}
