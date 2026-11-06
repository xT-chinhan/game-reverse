package com.byazt.mty;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 669, 19})
public class n implements com.byazt.uyg.n, com.byazt.uyg.qg {
    public final com.byazt.eau.s n;
    public final boolean qg = false;

    public n(com.byazt.eau.s sVar) {
        this.n = sVar;
    }

    @Override // com.byazt.uyg.n
    public Map<String, Object> n(File file) {
        if (file.getName().endsWith(".prop")) {
            return new qg(this.n, this.qg).n(file);
        }
        File file2 = new File(file.getParent(), file.getName() + ".prop");
        if (file2.exists() && file2.length() > 0) {
            return new qg(this.n, this.qg).n(file2);
        }
        if (file.getName().endsWith("xml")) {
            if (l.n()) {
                return new l(this.n, this.qg).n(file);
            }
            return new w(this.n, this.qg).n(file);
        }
        return new ConcurrentHashMap();
    }

    @Override // com.byazt.uyg.qg
    public void n(Map<String, Object> map, File file) throws IOException {
        if (!file.getName().endsWith(".prop")) {
            file = new File(file.getParent(), file.getName() + ".prop");
        }
        file.setReadable(true, false);
        new qg(this.n, this.qg).n(map, file);
    }
}
