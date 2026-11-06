package com.byazt.za;

import com.byazt.ca.ho;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 857, 13})
public class hw extends pr {
    public volatile boolean hn;
    public int hw;
    public int pr;

    public hw(int i, int i2) {
        this.pr = 15;
        this.hw = 3;
        if (i <= 0) {
            throw new IllegalArgumentException("Max count must be positive number!");
        }
        this.pr = i;
        this.hw = i2;
    }

    @Override // com.byazt.za.pr
    public boolean pr(long j, int i) {
        return i <= this.pr;
    }

    @Override // com.byazt.za.pr
    public boolean pr(File file, long j, int i) {
        return i <= this.hw;
    }

    @Override // com.byazt.za.pr
    public void pr(List<File> list) {
        if (this.hn) {
            x(list);
            this.hn = false;
        } else {
            hn(list);
        }
    }

    private void hn(List<File> list) {
        long jHw = hw(list);
        int size = list.size();
        if (!pr(jHw, size)) {
            for (File file : list) {
                long length = file.length();
                if (file.delete()) {
                    size--;
                    jHw -= length;
                }
                if (pr(file, jHw, size)) {
                    return;
                }
            }
        }
    }

    private void x(List<File> list) {
        long jHw;
        int size;
        boolean zPr;
        if (list == null) {
            return;
        }
        try {
            if (list.size() == 0 || (zPr = pr((jHw = hw(list)), (size = list.size())))) {
                return;
            }
            TreeMap treeMap = new TreeMap();
            for (File file : list) {
                treeMap.put(Long.valueOf(file.lastModified()), file);
            }
            for (Map.Entry entry : treeMap.entrySet()) {
                if (entry != null && !zPr) {
                    ho.hw("splashLoadAd", "LRUDeleteFile deleting fileTime ".concat(String.valueOf(((Long) entry.getKey()).longValue())));
                    File file2 = (File) entry.getValue();
                    long length = file2.length();
                    if (!file2.delete()) {
                        ho.hw("splashLoadAd", "Error deleting file " + file2 + " for trimming cache");
                    } else {
                        size--;
                        jHw -= length;
                    }
                    if (pr(file2, jHw, size)) {
                        return;
                    }
                }
            }
        } catch (Throwable th) {
        }
    }
}
