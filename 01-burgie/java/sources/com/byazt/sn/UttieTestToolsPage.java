package com.byazt.sn;

import com.byazt.vzx.pr;

/* JADX INFO: loaded from: classes2.dex */
@pr(pr = {0, 1, 1519, 1810})
public class UttieTestToolsPage extends BaseToolPage {
    public boolean pr;

    @Override // com.byazt.sn.BaseToolPage
    public String getPageTitle() {
        return "Uttie调试";
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.pr = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.pr = true;
    }
}
