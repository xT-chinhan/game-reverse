package com.byazt.hmw;

import com.byazt.wa.cd;
import com.byazt.wa.d;
import com.byazt.wa.um;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface n {
    public static final n n = new n() { // from class: com.byazt.hmw.n.1
        @Override // com.byazt.hmw.n
        public um n(File file) throws FileNotFoundException {
            return d.n(file);
        }

        @Override // com.byazt.hmw.n
        public cd qg(File file) throws FileNotFoundException {
            try {
                return d.qg(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return d.qg(file);
            }
        }

        @Override // com.byazt.hmw.n
        public cd s(File file) throws FileNotFoundException {
            try {
                return d.s(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return d.s(file);
            }
        }

        @Override // com.byazt.hmw.n
        public void delete(File file) throws IOException {
            if (!file.delete() && file.exists()) {
                throw new IOException("failed to delete ".concat(String.valueOf(file)));
            }
        }

        @Override // com.byazt.hmw.n
        public boolean q(File file) {
            return file.exists();
        }

        @Override // com.byazt.hmw.n
        public long l(File file) {
            return file.length();
        }

        @Override // com.byazt.hmw.n
        public void n(File file, File file2) throws IOException {
            delete(file2);
            if (!file.renameTo(file2)) {
                throw new IOException("failed to rename " + file + " to " + file2);
            }
        }

        @Override // com.byazt.hmw.n
        public void w(File file) throws IOException {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                throw new IOException("not a readable directory: ".concat(String.valueOf(file)));
            }
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    w(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete ".concat(String.valueOf(file2)));
                }
            }
        }
    };

    void delete(File file) throws IOException;

    long l(File file);

    um n(File file) throws FileNotFoundException;

    void n(File file, File file2) throws IOException;

    boolean q(File file);

    cd qg(File file) throws FileNotFoundException;

    cd s(File file) throws FileNotFoundException;

    void w(File file) throws IOException;
}
