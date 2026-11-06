package com.byazt.fn;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 157, 13})
public abstract class hw implements ny {
    public boolean pr = false;

    @Override // com.byazt.fn.ny
    public void pr(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.pr = true;
    }

    @Override // com.byazt.fn.ny
    public boolean pr() {
        return this.pr;
    }
}
