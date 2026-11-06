package com.mcto.sspsdk.internal;

import android.content.Intent;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.C;
import com.mcto.sspsdk.component.webview.QyWebViewDataBean;
import com.mcto.sspsdk.ssp.activity.QyDetailPageActivityNew;

/* JADX INFO: loaded from: classes2.dex */
public final class o5 implements View.OnClickListener {
    public final /* synthetic */ String a;

    public o5(String str) {
        this.a = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(jd.a, QyDetailPageActivityNew.class);
        intent.setAction("android.intent.action.VIEW");
        QyWebViewDataBean qyWebViewDataBean = new QyWebViewDataBean();
        qyWebViewDataBean.a(this.a);
        qyWebViewDataBean.o();
        intent.putExtra("dataBean", qyWebViewDataBean);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        try {
            jd.a.startActivity(intent);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
