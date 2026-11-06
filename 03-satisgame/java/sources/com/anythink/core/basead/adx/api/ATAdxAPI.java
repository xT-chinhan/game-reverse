package com.anythink.core.basead.adx.api;

import android.content.Context;
import com.anythink.core.basead.a.a;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ATAdxAPI {
    public static final String KEY_A_WF_INFO = "key_a_wf_info";

    public static void getAdxAdapterConfig(Context context, String str, Map<String, Object> map, ATAdxAdapterConfigListener aTAdxAdapterConfigListener) {
        a.a().a(context, str, map, aTAdxAdapterConfigListener);
    }
}
