package com.bytedance.sdk.openadsdk.core.ch;

import com.bytedance.sdk.component.utils.sl;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends ms {
    private volatile boolean ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f2044ms;
    private int xr;

    public xr(int i, int i2) {
        this.f2044ms = 15;
        this.xr = 3;
        if (i <= 0) {
            throw new IllegalArgumentException("Max count must be positive number!");
        }
        this.f2044ms = i;
        this.xr = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ch.ms
    protected boolean ms(long j, int i) {
        return i <= this.f2044ms;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ch.ms
    protected boolean ms(File file, long j, int i) {
        return i <= this.xr;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ch.ms
    protected void ms(List<File> list) {
        if (this.ah) {
            d(list);
            this.ah = false;
        } else {
            ah(list);
        }
    }

    private void ah(List<File> list) {
        long jXr = xr(list);
        int size = list.size();
        if (ms(jXr, size)) {
            return;
        }
        for (File file : list) {
            long length = file.length();
            if (file.delete()) {
                size--;
                jXr -= length;
                sl.ms("TotalCountLruDiskFile", "Cache file " + file + " is deleted because it exceeds cache limit");
            } else {
                sl.ms("TotalCountLruDiskFile", "Error deleting file " + file + " for trimming cache");
            }
            if (ms(file, jXr, size)) {
                return;
            }
        }
    }

    private void d(List<File> list) {
        if (list != null) {
            try {
                if (list.size() == 0) {
                    return;
                }
                long jXr = xr(list);
                int size = list.size();
                boolean zMs = ms(jXr, size);
                if (zMs) {
                    sl.ms("splashLoadAd", "不满足删除条件，不执行删除操作(true)".concat(String.valueOf(zMs)));
                    return;
                }
                TreeMap treeMap = new TreeMap();
                for (File file : list) {
                    treeMap.put(Long.valueOf(file.lastModified()), file);
                }
                for (Map.Entry entry : treeMap.entrySet()) {
                    if (entry != null && !zMs) {
                        sl.d("splashLoadAd", "LRUDeleteFile deleting fileTime ".concat(String.valueOf(((Long) entry.getKey()).longValue())));
                        File file2 = (File) entry.getValue();
                        long length = file2.length();
                        if (file2.delete()) {
                            size--;
                            jXr -= length;
                            sl.ms("splashLoadAd", "删除 一个 Cache file 当前总个数：".concat(String.valueOf(size)));
                        } else {
                            sl.d("splashLoadAd", "Error deleting file " + file2 + " for trimming cache");
                        }
                        if (ms(file2, jXr, size)) {
                            sl.ms("splashLoadAd", "停止删除 当前总个数 totalCount：" + size + " 最大值存储上限个数 maxCount " + this.f2044ms + " 最小个数 " + this.xr);
                            return;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
