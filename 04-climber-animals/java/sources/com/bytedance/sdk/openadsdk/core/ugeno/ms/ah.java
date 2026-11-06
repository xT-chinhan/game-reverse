package com.bytedance.sdk.openadsdk.core.ugeno.ms;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.ugeno.express.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends d {
    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.d, com.bytedance.sdk.component.adexpress.xr.d
    public int ah() {
        return 8;
    }

    public ah(Context context, lm lmVar, com.bytedance.sdk.openadsdk.core.ugeno.express.xr xrVar, ViewGroup viewGroup) {
        super(context, lmVar, xrVar, viewGroup);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.d
    protected JSONObject ms() {
        return u();
    }

    private JSONObject u() {
        try {
            return new JSONObject(ms.ms(this.c, this.ab).ms(this.c));
        } catch (Throwable th) {
            sl.ms(th);
            return null;
        }
    }
}
