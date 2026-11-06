package com.mcto.sspsdk.feedback;

import com.mcto.sspsdk.internal.fc;
import com.mcto.sspsdk.internal.w3;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements w3 {
    public final /* synthetic */ FeedBackActivity a;

    public a(FeedBackActivity feedBackActivity) {
        this.a = feedBackActivity;
    }

    @Override // com.mcto.sspsdk.internal.w3
    public final void a(Object obj) {
        String str = (String) obj;
        fc.a(this.a, str == null ? "提交成功" : str);
        if (str == null) {
            this.a.finish();
        } else {
            this.a.a.set(false);
            this.a.b.setText("提交");
        }
    }
}
