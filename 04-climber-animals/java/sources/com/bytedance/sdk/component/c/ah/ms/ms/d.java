package com.bytedance.sdk.component.c.ah.ms.ms;

import com.anythink.basead.exoplayer.b;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
final class d {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    static final Charset f1170ms = Charset.forName(b.i);
    static final Charset xr = Charset.forName("UTF-8");

    static void ms(File file) throws IOException {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            throw new IOException("not a readable directory: ".concat(String.valueOf(file)));
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                ms(file2);
            }
            if (!file2.delete()) {
                throw new IOException("failed to delete file: ".concat(String.valueOf(file2)));
            }
        }
    }
}
