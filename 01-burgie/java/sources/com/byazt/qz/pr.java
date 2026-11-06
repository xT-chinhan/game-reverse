package com.byazt.qz;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1192, 37})
public class pr implements com.byazt.to.hw, com.byazt.to.pr {
    public final boolean hw = false;
    public final com.byazt.cr.hn pr;

    public pr(com.byazt.cr.hn hnVar) {
        this.pr = hnVar;
    }

    @Override // com.byazt.to.pr
    public Map<String, Object> pr(File file) {
        if (file.getName().endsWith(".prop")) {
            return new hw(this.pr, this.hw).pr(file);
        }
        File file2 = new File(file.getParent(), file.getName() + ".prop");
        if (file2.exists() && file2.length() > 0) {
            return new hw(this.pr, this.hw).pr(file2);
        }
        if (file.getName().endsWith("xml")) {
            if (c.pr()) {
                return new c(this.pr, this.hw).pr(file);
            }
            return new uc(this.pr, this.hw).pr(file);
        }
        return new ConcurrentHashMap();
    }

    @Override // com.byazt.to.hw
    public void pr(Map<String, Object> map, File file) throws Throwable {
        if (!file.getName().endsWith(".prop")) {
            file = new File(file.getParent(), file.getName() + ".prop");
        }
        file.setReadable(true, false);
        new hw(this.pr, this.hw).pr(map, file);
    }
}
