package com.byazt.rn;

import com.byazt.du.k;
import com.byazt.du.lb;
import com.byazt.du.qa;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public interface pr {
    public static final pr pr = new pr() { // from class: com.byazt.rn.pr.1
        @Override // com.byazt.rn.pr
        public qa pr(File file) throws FileNotFoundException {
            return k.pr(file);
        }

        @Override // com.byazt.rn.pr
        public lb hw(File file) throws FileNotFoundException {
            try {
                return k.hw(file);
            } catch (FileNotFoundException e) {
                file.getParentFile().mkdirs();
                return k.hw(file);
            }
        }

        @Override // com.byazt.rn.pr
        public lb hn(File file) throws FileNotFoundException {
            try {
                return k.hn(file);
            } catch (FileNotFoundException e) {
                file.getParentFile().mkdirs();
                return k.hn(file);
            }
        }

        @Override // com.byazt.rn.pr
        public void delete(File file) throws IOException {
            if (!file.delete() && file.exists()) {
                throw new IOException("failed to delete ".concat(String.valueOf(file)));
            }
        }

        @Override // com.byazt.rn.pr
        public boolean x(File file) {
            return file.exists();
        }

        @Override // com.byazt.rn.pr
        public long c(File file) {
            return file.length();
        }

        @Override // com.byazt.rn.pr
        public void pr(File file, File file2) throws IOException {
            delete(file2);
            if (!file.renameTo(file2)) {
                throw new IOException("failed to rename " + file + " to " + file2);
            }
        }

        @Override // com.byazt.rn.pr
        public void uc(File file) throws IOException {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                throw new IOException("not a readable directory: ".concat(String.valueOf(file)));
            }
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    uc(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete ".concat(String.valueOf(file2)));
                }
            }
        }
    };

    long c(File file);

    void delete(File file) throws IOException;

    lb hn(File file) throws FileNotFoundException;

    lb hw(File file) throws FileNotFoundException;

    qa pr(File file) throws FileNotFoundException;

    void pr(File file, File file2) throws IOException;

    void uc(File file) throws IOException;

    boolean x(File file);
}
