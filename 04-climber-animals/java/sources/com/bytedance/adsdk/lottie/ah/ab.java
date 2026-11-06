package com.bytedance.adsdk.lottie.ah;

import android.util.Pair;
import com.anythink.core.common.d.j;
import com.anythink.dlopt.common.a.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class ab {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final ka f138ms;

    public ab(ka kaVar) {
        this.f138ms = kaVar;
    }

    Pair<ah, InputStream> ms(String str) {
        ah ahVar;
        try {
            File fileXr = xr(str);
            if (fileXr == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(fileXr);
            if (fileXr.getAbsolutePath().endsWith(".zip")) {
                ahVar = ah.ZIP;
            } else {
                ahVar = ah.JSON;
            }
            com.bytedance.adsdk.lottie.ka.ka.ms("Cache hit for " + str + " at " + fileXr.getAbsolutePath());
            return new Pair<>(ahVar, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    File ms(String str, InputStream inputStream, ah ahVar) throws IOException {
        File file = new File(ms(), ms(str, ahVar, true));
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

    void ms(String str, ah ahVar) {
        File file = new File(ms(), ms(str, ahVar, true));
        File file2 = new File(file.getAbsolutePath().replace(a.f, ""));
        boolean zRenameTo = file.renameTo(file2);
        com.bytedance.adsdk.lottie.ka.ka.ms("Copying temp file to real file (" + file2 + ")");
        if (zRenameTo) {
            return;
        }
        com.bytedance.adsdk.lottie.ka.ka.xr("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + j.z);
    }

    private File xr(String str) throws FileNotFoundException {
        File file = new File(ms(), ms(str, ah.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(ms(), ms(str, ah.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    private File ms() {
        File fileMs = this.f138ms.ms();
        if (fileMs.isFile()) {
            fileMs.delete();
        }
        if (!fileMs.exists()) {
            fileMs.mkdirs();
        }
        return fileMs;
    }

    private static String ms(String str, ah ahVar, boolean z) {
        return "lottie_cache_" + str.replaceAll("\\W+", "") + (z ? ahVar.ms() : ahVar.ah);
    }
}
