package com.anythink.core.bridge;

import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATSDKGlobalSetting;
import com.anythink.core.bridge.entity.d;
import com.anythink.core.bridge.entity.e;
import com.anythink.core.bridge.entity.f;
import com.anythink.core.bridge.entity.g;
import com.anythink.core.common.d.s;
import com.anythink.core.common.h.by;
import com.anythink.core.common.h.x;
import com.anythink.core.common.u.l;
import com.anythink.core.common.u.o;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final String a = "lphl";
    public static final String b = "pdf";
    public static final String c = "zlilbqdph";
    public static final String d = "lpvl";

    private static void a(Map<String, Object> map, by byVar, x xVar, JSONObject jSONObject) {
        try {
            map.put(a.C0010a.d, jSONObject);
            s sVarB = s.b();
            e eVar = new e();
            g gVar = new g(xVar);
            f fVar = new f();
            com.anythink.core.bridge.entity.c cVar = new com.anythink.core.bridge.entity.c();
            if (byVar != null && byVar.Y() != null) {
                cVar = byVar.Y().z();
            }
            eVar.a(gVar);
            eVar.a(fVar);
            eVar.a(cVar);
            map.put(a.C0010a.c, c.a(eVar));
            d dVar = new d();
            dVar.e(l.i());
            dVar.b(l.H());
            map.put(a.C0010a.a, c.a(dVar));
            com.anythink.core.bridge.entity.a aVar = new com.anythink.core.bridge.entity.a();
            aVar.a();
            aVar.a(o.a());
            aVar.b(s.b().p());
            aVar.c(s.b().q());
            map.put(a.C0010a.b, c.a(aVar));
            Object objQ = sVarB.Q();
            if (objQ != null) {
                map.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_USER_DEVICE_INFO, objQ);
            }
            String[] strArrF = sVarB.f();
            if (strArrF != null && strArrF.length > 0) {
                map.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_DENNY_DEVICE_INFO, strArrF);
            }
            map.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_APP_ID, sVarB.p());
            map.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_APP_KEY, sVarB.q());
            map.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_PLACEMENT_ID, xVar.a);
            map.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_SYSTEM_DEV_FRAMEWORK_TYPE, l.l());
            Object objT = sVarB.t();
            if (objT != null) {
                map.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_LOCATION, objT);
            }
            map.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_WX_INSTALL_STATUS, Boolean.valueOf(sVarB.s()));
            map.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_DELAY_INSPECT_TIME, Long.valueOf(ATSDKGlobalSetting.mDelayInspectTime));
            map.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_INSPECT_INTERVAL, Long.valueOf(ATSDKGlobalSetting.mInspectInterval));
            map.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_ENABLE_GET_RUNNING_APP_PROCESSES, Boolean.valueOf(!ATSDKGlobalSetting.isDenyApi_getRunningAppProcesses()));
            map.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_ENABLE_GET_DEVICE_INFO_IN_BG, Boolean.valueOf(ATSDKGlobalSetting.enableGetDeviceInfoInBg));
            map.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_EXCLUDE_PKG_LIST, s.b().k());
        } catch (Throwable unused) {
        }
    }
}
