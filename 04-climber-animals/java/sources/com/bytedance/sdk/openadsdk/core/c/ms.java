package com.bytedance.sdk.openadsdk.core.c;

import android.text.TextUtils;
import com.anythink.basead.webtemplet.a.b;
import com.anythink.core.common.d.j;
import com.bytedance.sdk.component.ch.ab;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.component.ny.xr.d;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.m;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.re.ka;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements com.bytedance.sdk.openadsdk.core.jw.ms.xr {
    private static final HashSet c;
    private static final String d = "com.bytedance.sdk.openadsdk.core.c.ms";
    private static HashMap<String, Long> ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile ms f2033ms;
    private com.bytedance.sdk.openadsdk.core.jw.ms ah;
    private CopyOnWriteArrayList<JSONObject> xr = new CopyOnWriteArrayList<>();

    @Override // com.bytedance.sdk.openadsdk.core.jw.ms.xr
    public void xr() {
    }

    static {
        String name = ms.class.getName();
        ka = new HashMap<>();
        c = new HashSet(Arrays.asList("dalvik.system.VMStack.getThreadStackTrace", "java.lang.Thread.getStackTrace", name));
    }

    public static ms ah() {
        if (f2033ms == null) {
            synchronized (ms.class) {
                if (f2033ms == null) {
                    f2033ms = new ms();
                }
            }
        }
        return f2033ms;
    }

    private ms() {
        com.bytedance.sdk.openadsdk.core.jw.ms msVarD = ch.ub().d();
        this.ah = msVarD;
        if (msVarD != null) {
            msVarD.xr(this);
        }
    }

    public void ms(int i, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        if (xrVar == null) {
            return;
        }
        ms(i, xrVar.d());
    }

    private boolean ms(Long l) {
        return !ms(new Date(), new Date(l.longValue()));
    }

    private boolean ms(Date date, Date date2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        return ((calendar.get(1) == calendar2.get(1)) && calendar.get(2) == calendar2.get(2)) && calendar.get(5) == calendar2.get(5);
    }

    private boolean ms(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Long l = ka.get(str);
            if (l != null && l.longValue() != 0) {
                if (!ms(l)) {
                    return false;
                }
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis > 0) {
                    ka.put(str, Long.valueOf(jCurrentTimeMillis));
                }
            }
            return true;
        } catch (Throwable th) {
            sl.xr("callstack error:" + th.getMessage());
            return true;
        }
    }

    public void ms(final int i, final String str) {
        if (xr.ms() && ms(str)) {
            final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            ab.ms(new ny("callChainStatistic") { // from class: com.bytedance.sdk.openadsdk.core.c.ms.1
                @Override // java.lang.Runnable
                public void run() {
                    ms.this.xr.add(ms.this.ms(i, str, stackTrace));
                    if (ms.this.xr.size() < 3) {
                        return;
                    }
                    try {
                        ms.this.d();
                    } catch (OutOfMemoryError e) {
                        sl.ms(e);
                    }
                }
            }, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        CopyOnWriteArrayList<JSONObject> copyOnWriteArrayList = this.xr;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<JSONObject> it = this.xr.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stats_list", jSONArray);
        } catch (JSONException e) {
            sl.ms(e);
        }
        this.xr.clear();
        String strCh = f.ch("/api/ad/union/sdk/callstack/batch/");
        m mVar = new m(ka.ms().xr().c());
        mVar.ms(strCh);
        mVar.ah(jSONObject, "callstack");
        mVar.ms(new com.bytedance.sdk.component.ny.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.c.ms.2
            @Override // com.bytedance.sdk.component.ny.ms.ms
            public void ms(d dVar, com.bytedance.sdk.component.ny.xr xrVar) {
                if (xrVar != null) {
                    sl.ms("CallChainStatistic", Boolean.valueOf(xrVar.x()), xrVar.d());
                } else {
                    sl.ms("CallChainStatistic", "NetResponse is null");
                }
            }

            @Override // com.bytedance.sdk.component.ny.ms.ms
            public void ms(d dVar, IOException iOException) {
                sl.ms("CallChainStatistic", iOException.getMessage());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject ms(int i, String str, Object obj) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("rit", str);
            jSONObject.put("appid", ch.ub().t());
            jSONObject.put("app_version", f.sl());
            jSONObject.put("ad_sdk_version", g.ah);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "6.9.2.3");
            jSONObject.put("adtype", i);
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put("callstack", ms(obj));
            jSONObject.put("type", "callstack");
            jSONObject.put(b.c.d, com.bytedance.sdk.openadsdk.core.ah.ms.ms(re.getContext(), i));
        } catch (JSONException e) {
            sl.ms(e);
        }
        return jSONObject;
    }

    private JSONArray ms(Object obj) {
        JSONArray jSONArray = new JSONArray();
        if (obj == null) {
            return jSONArray;
        }
        for (StackTraceElement stackTraceElement : (StackTraceElement[]) obj) {
            if (stackTraceElement != null && !c.contains(stackTraceElement.getClassName() + j.z + stackTraceElement.getMethodName())) {
                String className = stackTraceElement.getClassName();
                if (className != null && className.startsWith("android.app")) {
                    break;
                }
                jSONArray.put(stackTraceElement.toString());
            }
        }
        return jSONArray;
    }

    @Override // com.bytedance.sdk.openadsdk.core.jw.ms.xr
    public void ms() {
        if (ch.ub().cv()) {
            return;
        }
        d();
    }
}
