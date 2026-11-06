package com.byazt.pa;

import com.byazt.tk.k;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2192, 8})
public class s extends n {
    public int n;
    public int qg;
    public volatile boolean s;

    public s(int i, int i2) {
        this.n = 15;
        this.qg = 3;
        if (i <= 0) {
            throw new IllegalArgumentException("Max count must be positive number!");
        }
        this.n = i;
        this.qg = i2;
    }

    @Override // com.byazt.pa.n
    public boolean n(long j, int i) {
        return i <= this.n;
    }

    @Override // com.byazt.pa.n
    public boolean n(File file, long j, int i) {
        return i <= this.qg;
    }

    @Override // com.byazt.pa.n
    public void n(List<File> list) {
        if (this.s) {
            q(list);
            this.s = false;
        } else {
            s(list);
        }
    }

    private void s(List<File> list) {
        long jQg = qg(list);
        int size = list.size();
        if (n(jQg, size)) {
            return;
        }
        for (File file : list) {
            long length = file.length();
            if (file.delete()) {
                size--;
                jQg -= length;
            }
            if (n(file, jQg, size)) {
                return;
            }
        }
    }

    private void q(List<File> list) {
        long jQg;
        int size;
        boolean zN;
        if (list != null) {
            try {
                if (list.size() == 0 || (zN = n((jQg = qg(list)), (size = list.size())))) {
                    return;
                }
                TreeMap treeMap = new TreeMap();
                for (File file : list) {
                    treeMap.put(Long.valueOf(file.lastModified()), file);
                }
                for (Map.Entry entry : treeMap.entrySet()) {
                    if (entry != null && !zN) {
                        k.qg("splashLoadAd", "LRUDeleteFile deleting fileTime ".concat(String.valueOf(((Long) entry.getKey()).longValue())));
                        File file2 = (File) entry.getValue();
                        long length = file2.length();
                        if (file2.delete()) {
                            size--;
                            jQg -= length;
                        } else {
                            k.qg("splashLoadAd", "Error deleting file " + file2 + " for trimming cache");
                        }
                        if (n(file2, jQg, size)) {
                            return;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
