package com.anythink.core.common.n.b.a.f;

import com.anythink.core.common.n.c.n;
import com.anythink.core.common.n.c.v;
import com.anythink.core.common.n.c.w;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface a {
    public static final a a = new a() { // from class: com.anythink.core.common.n.b.a.f.a.1
        @Override // com.anythink.core.common.n.b.a.f.a
        public final w a(File file) {
            return n.a(file);
        }

        @Override // com.anythink.core.common.n.b.a.f.a
        public final v b(File file) {
            try {
                return n.b(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return n.b(file);
            }
        }

        @Override // com.anythink.core.common.n.b.a.f.a
        public final v c(File file) {
            try {
                return n.c(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return n.c(file);
            }
        }

        @Override // com.anythink.core.common.n.b.a.f.a
        public final void d(File file) throws IOException {
            if (!file.delete() && file.exists()) {
                throw new IOException("failed to delete ".concat(String.valueOf(file)));
            }
        }

        @Override // com.anythink.core.common.n.b.a.f.a
        public final boolean e(File file) {
            return file.exists();
        }

        @Override // com.anythink.core.common.n.b.a.f.a
        public final long f(File file) {
            return file.length();
        }

        @Override // com.anythink.core.common.n.b.a.f.a
        public final void a(File file, File file2) throws IOException {
            d(file2);
            if (!file.renameTo(file2)) {
                throw new IOException("failed to rename " + file + " to " + file2);
            }
        }

        @Override // com.anythink.core.common.n.b.a.f.a
        public final void g(File file) throws IOException {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                throw new IOException("not a readable directory: ".concat(String.valueOf(file)));
            }
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    g(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete ".concat(String.valueOf(file2)));
                }
            }
        }
    };

    w a(File file);

    void a(File file, File file2);

    v b(File file);

    v c(File file);

    void d(File file);

    boolean e(File file);

    long f(File file);

    void g(File file);
}
