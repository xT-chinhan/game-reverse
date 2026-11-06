package com.bytedance.sdk.component.ah.xr.ms.c;

import com.bytedance.sdk.component.ah.ms.qv;
import com.bytedance.sdk.component.ah.ms.sl;
import com.bytedance.sdk.component.ah.ms.y;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public interface ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final ms f1068ms = new ms() { // from class: com.bytedance.sdk.component.ah.xr.ms.c.ms.1
        @Override // com.bytedance.sdk.component.ah.xr.ms.c.ms
        public y ms(File file) throws FileNotFoundException {
            return sl.ms(file);
        }

        @Override // com.bytedance.sdk.component.ah.xr.ms.c.ms
        public qv xr(File file) throws FileNotFoundException {
            try {
                return sl.xr(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return sl.xr(file);
            }
        }

        @Override // com.bytedance.sdk.component.ah.xr.ms.c.ms
        public qv ah(File file) throws FileNotFoundException {
            try {
                return sl.ah(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return sl.ah(file);
            }
        }

        @Override // com.bytedance.sdk.component.ah.xr.ms.c.ms
        public void delete(File file) throws IOException {
            if (!file.delete() && file.exists()) {
                throw new IOException("failed to delete ".concat(String.valueOf(file)));
            }
        }

        @Override // com.bytedance.sdk.component.ah.xr.ms.c.ms
        public boolean d(File file) {
            return file.exists();
        }

        @Override // com.bytedance.sdk.component.ah.xr.ms.c.ms
        public long ka(File file) {
            return file.length();
        }

        @Override // com.bytedance.sdk.component.ah.xr.ms.c.ms
        public void ms(File file, File file2) throws IOException {
            delete(file2);
            if (!file.renameTo(file2)) {
                throw new IOException("failed to rename " + file + " to " + file2);
            }
        }

        @Override // com.bytedance.sdk.component.ah.xr.ms.c.ms
        public void c(File file) throws IOException {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                throw new IOException("not a readable directory: ".concat(String.valueOf(file)));
            }
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    c(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete ".concat(String.valueOf(file2)));
                }
            }
        }
    };

    qv ah(File file) throws FileNotFoundException;

    void c(File file) throws IOException;

    boolean d(File file);

    void delete(File file) throws IOException;

    long ka(File file);

    y ms(File file) throws FileNotFoundException;

    void ms(File file, File file2) throws IOException;

    qv xr(File file) throws FileNotFoundException;
}
