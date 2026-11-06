package com.byazt.jro;

import com.byazt.yl.s;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2130, 26})
public final class qg {
    public final ConcurrentHashMap<String, n> n = new ConcurrentHashMap<>();

    public com.byazt.yl.qg n(s sVar) {
        n nVar;
        File fileS = s(sVar);
        if (fileS == null || sVar == null || sVar.qg() <= 0) {
            throw new IllegalArgumentException("FileStore config is invalid");
        }
        String absolutePath = fileS.getAbsolutePath();
        n nVar2 = this.n.get(absolutePath);
        if (nVar2 != null) {
            return nVar2;
        }
        synchronized (this.n) {
            nVar = this.n.get(absolutePath);
            if (nVar == null) {
                nVar = new n(fileS, sVar.qg());
                this.n.put(absolutePath, nVar);
            }
        }
        return nVar;
    }

    public boolean qg(s sVar) {
        File fileS = s(sVar);
        if (fileS == null) {
            return false;
        }
        n nVarRemove = this.n.remove(fileS.getAbsolutePath());
        if (nVarRemove != null) {
            return nVarRemove.l();
        }
        return n(fileS);
    }

    private File s(s sVar) {
        if (sVar == null) {
            return null;
        }
        return sVar.n();
    }

    private boolean n(File file) {
        if (!file.exists()) {
            return true;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory() && !n(file2)) {
                    return false;
                }
                if (!file2.isDirectory() && !file2.delete()) {
                    return false;
                }
            }
        }
        return file.delete() || !file.exists();
    }
}
