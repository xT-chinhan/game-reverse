package com.onevcat.uniwebview;

import com.unity3d.player.UnityPlayer;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.onevcat.uniwebview.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0713f implements c2 {
    @Override // com.onevcat.uniwebview.c2
    public final void a(String name, d2 method, Y1 payload) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(payload, "payload");
        HashMap map = new HashMap();
        map.put("identifier", payload.a);
        map.put("resultCode", payload.b);
        map.put("data", payload.c);
        JSONObject jSONObject = payload.d;
        if (jSONObject != null) {
            map.put("extra", String.valueOf(jSONObject));
        }
        String string = new JSONObject(map).toString();
        Intrinsics.checkNotNullExpressionValue(string, "obj.toString()");
        a(name, method, string);
    }

    @Override // com.onevcat.uniwebview.c2
    public final void a(String name, d2 method, String parameters) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        UnityPlayer.UnitySendMessage("UniWebViewAndroidStaticListener", "OnJavaMessage", name + '@' + method.name() + '@' + parameters);
    }
}
