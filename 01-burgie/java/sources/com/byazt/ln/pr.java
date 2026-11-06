package com.byazt.ln;

import android.content.Context;
import android.view.View;
import com.byazt.hg.of;
import com.byazt.hg.vk;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 573, 37})
public abstract class pr {
    public vk hn;
    public Context hw;
    public of pr;
    public View x;

    public abstract int pr(Map<String, Object> map, hn hnVar);

    public void pr(vk vkVar) {
        this.hn = vkVar;
    }

    public void pr(View view) {
        this.x = view;
    }
}
