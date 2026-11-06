package com.bytedance.sdk.openadsdk.core.w.d;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.h.aq;
import com.anythink.core.common.m.e;
import com.bytedance.sdk.component.ch.ab;
import com.bytedance.sdk.openadsdk.ats.ah;
import com.bytedance.sdk.openadsdk.core.ah.d;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.w.ny;
import com.bytedance.sdk.openadsdk.core.w.x;
import com.bytedance.sdk.openadsdk.core.w.xr;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends ny implements xr {
    private static volatile ms xr;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private AtomicBoolean f3679ms = new AtomicBoolean(false);

    @Override // com.bytedance.sdk.openadsdk.core.w.xr
    public String ms() {
        return "splash";
    }

    private ms() {
    }

    public static ms ah() {
        if (xr == null) {
            synchronized (ms.class) {
                if (xr == null) {
                    xr = new ms();
                }
            }
        }
        return xr;
    }

    @Override // com.bytedance.sdk.openadsdk.core.w.ny
    public void ms(int i, x xVar) {
        if (ch.ub().xn()) {
            try {
                xVar.ah().isSuccess();
                Field[] declaredFields = xVar.ah().getClass().getDeclaredFields();
                for (int i2 = 0; i2 < declaredFields.length; i2++) {
                    declaredFields[i2].setAccessible(true);
                    declaredFields[i2].get(xVar.ah());
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.w.ny
    public JSONObject xr(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("business_name", e.Y);
            jSONObject.put(aq.h, 2);
            jSONObject.put("general_params", new JSONObject());
        } catch (Exception e) {
            e.getMessage();
        }
        return jSONObject;
    }

    @Override // com.bytedance.sdk.openadsdk.core.w.ny
    public boolean xr() {
        return com.bytedance.sdk.openadsdk.core.w.ch.ah();
    }

    public void d() {
        ab.xr(new com.bytedance.sdk.component.ch.ny("pity_splopt") { // from class: com.bytedance.sdk.openadsdk.core.w.d.ms.1
            @Override // java.lang.Runnable
            public void run() {
                ms.this.c();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            AtomicBoolean atomicBoolean = this.f3679ms;
            if (atomicBoolean == null || atomicBoolean.getAndSet(true)) {
                return;
            }
            ms(re.getContext());
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public static void ka() {
        ah().d();
    }

    @Override // com.bytedance.sdk.openadsdk.core.w.xr
    public String ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if ("spl_load_strategy".equalsIgnoreCase(str)) {
            return d.ms().b();
        }
        return ah.xr(ms()).xr(str, "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.w.xr
    public void ms(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if ("spl_load_strategy".equalsIgnoreCase(str)) {
            d.ms().ao(str2);
        } else {
            ah.xr(ms()).ms(str, str2);
        }
    }
}
