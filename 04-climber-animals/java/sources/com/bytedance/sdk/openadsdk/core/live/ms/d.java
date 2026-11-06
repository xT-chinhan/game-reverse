package com.bytedance.sdk.openadsdk.core.live.ms;

import android.content.Context;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface d {
    String ab();

    long ah();

    int b_(lm lmVar);

    boolean c();

    void d();

    void d(lm lmVar);

    int ka();

    int ms(Context context, lm lmVar, Map<String, Object> map);

    int ms(com.bytedance.sdk.openadsdk.core.live.xr.xr xrVar, boolean z);

    int ms(lm lmVar, ah ahVar, String str);

    int ms(String str);

    void ms();

    void ms(Bridge bridge);

    void ms(com.bytedance.sdk.openadsdk.ub.d dVar);

    void ms(String str, lm lmVar, long j);

    void ms(String str, boolean z);

    boolean ms(lm lmVar);

    boolean ms(String str, int i);

    JSONObject x();

    int xr();

    int xr(Context context, lm lmVar, Map<String, Object> map);
}
