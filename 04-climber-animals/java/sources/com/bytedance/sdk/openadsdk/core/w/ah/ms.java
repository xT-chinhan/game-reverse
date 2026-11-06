package com.bytedance.sdk.openadsdk.core.w.ah;

import android.content.Context;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.component.utils.u;
import com.bytedance.sdk.openadsdk.ats.ah;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.w.ny;
import com.bytedance.sdk.openadsdk.core.w.x;
import com.bytedance.sdk.openadsdk.core.w.xr;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends ny implements xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile ms f3676ms;
    private AtomicBoolean xr = new AtomicBoolean(false);

    @Override // com.bytedance.sdk.openadsdk.core.w.xr
    public String ms() {
        return "network";
    }

    @Override // com.bytedance.sdk.openadsdk.core.w.ny
    public void ms(int i, x xVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.w.ny
    public JSONObject xr(Context context) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.w.ny
    public boolean xr() {
        return true;
    }

    private ms() {
    }

    public static ms ah() {
        if (f3676ms == null) {
            synchronized (ms.class) {
                if (f3676ms == null) {
                    f3676ms = new ms();
                }
            }
        }
        return f3676ms;
    }

    @Override // com.bytedance.sdk.openadsdk.core.w.xr
    public String ms(String str) {
        return ah.xr(ms()).xr(d(), "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.w.xr
    public void ms(String str, String str2) {
        ah.xr(ms()).ms(str, str2);
    }

    public static String d() {
        return "q_" + Calendar.getInstance().get(11) + (u.d(re.getContext()) ? IAdInterListener.AdReqParam.WIDTH : "c");
    }
}
