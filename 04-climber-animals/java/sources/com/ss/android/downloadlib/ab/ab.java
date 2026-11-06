package com.ss.android.downloadlib.ab;

import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class ab {
    public static long ms(File file) {
        if (file == null || !file.exists()) {
            return 0L;
        }
        return ms(file, file.lastModified(), 0);
    }

    private static long ms(File file, long j, int i) {
        File[] fileArrListFiles;
        if (file != null && file.exists()) {
            j = Math.max(j, file.lastModified());
            int i2 = i + 1;
            if (i2 >= 50) {
                return j;
            }
            if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                for (File file2 : fileArrListFiles) {
                    j = Math.max(j, ms(file2, j, i2));
                }
            }
        }
        return j;
    }
}
