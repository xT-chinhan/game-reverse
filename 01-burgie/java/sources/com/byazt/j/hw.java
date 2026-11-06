package com.byazt.j;

import android.content.Context;
import com.byazt.i.x;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 505, 13})
public class hw extends pr {
    public final File pr;

    public void pr() {
        com.byazt.a.pr.pr(new Runnable() { // from class: com.byazt.j.hw.1
            @Override // java.lang.Runnable
            public void run() {
                hw.this.hw();
            }
        });
    }

    public void hw() {
        com.byazt.i.hn.pr().hw();
        Context context = x.getContext();
        if (context != null) {
            com.byazt.d.hn.pr(context).pr(1);
        }
        for (File file : this.pr.listFiles()) {
            try {
                file.delete();
            } catch (Throwable th) {
            }
        }
    }

    @Override // com.byazt.j.pr
    public File hn(String str) {
        return c(str);
    }

    @Override // com.byazt.j.pr
    public File x(String str) {
        return c(str);
    }

    public File c(String str) {
        return new File(this.pr, str);
    }
}
