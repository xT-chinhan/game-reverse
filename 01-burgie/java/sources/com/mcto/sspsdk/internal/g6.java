package com.mcto.sspsdk.internal;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class g6 implements Runnable {
    public final /* synthetic */ Context a;

    public g6(Context context) {
        this.a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        File[] fileArrListFiles;
        File fileB = ij.b(this.a);
        if (fileB.exists() && (fileArrListFiles = fileB.listFiles()) != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            int i = 0;
            for (File file : fileArrListFiles) {
                if ((file.getName().endsWith(".tmp") || jCurrentTimeMillis - file.lastModified() > 864000000) && file.delete()) {
                    i++;
                }
            }
            if (i > 0) {
                new StringBuilder("清理过期字体/临时文件数量：").append(i);
            }
        }
    }
}
