package com.mcto.sspsdk.internal;

import android.content.Intent;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.C;
import com.mcto.sspsdk.feedback.FeedBackActivity;

/* JADX INFO: loaded from: classes2.dex */
public final class m5 implements View.OnClickListener {
    public int a = 0;

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.a;
        this.a = i + 1;
        if (i > 10) {
            this.a = 0;
            try {
                Intent intent = new Intent();
                intent.setFlags(C.ENCODING_PCM_MU_LAW);
                intent.setClass(view.getContext(), FeedBackActivity.class);
                jd.a.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
