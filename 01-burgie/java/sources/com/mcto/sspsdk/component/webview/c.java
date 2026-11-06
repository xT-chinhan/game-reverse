package com.mcto.sspsdk.component.webview;

import android.content.DialogInterface;
import com.mcto.sspsdk.internal.fc;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements DialogInterface.OnClickListener {
    public final /* synthetic */ QyWebViewPanel a;

    public c(QyWebViewPanel qyWebViewPanel) {
        this.a = qyWebViewPanel;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.a.e.c() == 1) {
            fc.a(this.a.b, "已添加下载管理器中");
        } else {
            this.a.a(2);
        }
    }
}
