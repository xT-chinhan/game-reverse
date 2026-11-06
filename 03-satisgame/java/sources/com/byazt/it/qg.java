package com.byazt.it;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.byazt.ws.tj;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 879, 26})
public class qg {
    public static final Map<String, Boolean> n = new ConcurrentHashMap();

    public static final synchronized void n(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        n.put(str, Boolean.TRUE);
    }

    public static final synchronized boolean qg(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Boolean bool = n.get(str);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static synchronized void n(Context context, List<com.byazt.ws.n> list) {
        if (list != null) {
            for (com.byazt.ws.n nVar : list) {
                final com.byazt.or.qg qgVarQ = nVar.q();
                try {
                    if (!qg(nVar.w())) {
                        n(context, qgVarQ, new com.byazt.ju.s() { // from class: com.byazt.it.qg.1
                            @Override // com.byazt.ju.s
                            public void n() {
                                com.byazt.ya.n.n(qgVarQ.qg(), (Pair<Boolean, String>) new Pair(Boolean.TRUE, ""));
                            }

                            @Override // com.byazt.ju.s
                            public void n(com.byazt.mj.n nVar2) {
                                if (nVar2 != null) {
                                    com.byazt.ya.n.n(qgVarQ.qg(), (Pair<Boolean, String>) new Pair(Boolean.FALSE, "errorCode = " + nVar2.n + " errorMessage = " + nVar2.qg));
                                }
                            }
                        });
                        n(nVar.w());
                    }
                } catch (Exception e) {
                    com.byazt.ya.n.n(qgVarQ.qg(), (Pair<Boolean, String>) new Pair(Boolean.FALSE, e.toString()));
                    com.byazt.gp.s.n(qgVarQ.qg(), (com.byazt.sg.s) null, (com.byazt.qn.qg) null, (tj) null, new com.byazt.mj.n(49013, e.toString()));
                }
            }
            return;
        }
        com.byazt.gp.s.n("", (com.byazt.sg.s) null, (com.byazt.qn.qg) null, (tj) null, new com.byazt.mj.n(49013, "获取的自定义Adapter总配置为null"));
    }

    private static com.byazt.sbw.n n(com.byazt.or.qg qgVar, com.byazt.ju.s sVar) {
        com.byazt.sbw.n nVarN = com.byazt.ya.n.q().n(qgVar.qg());
        if (nVarN != null) {
            return nVarN;
        }
        com.byazt.sbw.n nVar = new com.byazt.sbw.n();
        com.byazt.ya.n.q().n(qgVar.qg(), nVar);
        return nVar;
    }

    private static void n(Context context, com.byazt.or.qg qgVar, com.byazt.ju.s sVar) throws Exception {
        if (qgVar == null || TextUtils.isEmpty(qgVar.s())) {
            if (qgVar == null) {
                throw new Exception("自定义ADN初始化失败，获取的自定义Adapter单条配置为null");
            }
            throw new Exception("自定义ADN初始化失败，获取的自定义Adapter单条配置初始化类名为空");
        }
        com.byazt.sbw.n nVarN = n(qgVar, sVar);
        if (nVarN != null) {
            if (!nVarN.qg()) {
                n(context, qgVar, nVarN);
            }
            sVar.n();
            return;
        }
        throw new Exception("GMCustomAdapterConfiguration is null");
    }

    private static void n(Context context, com.byazt.or.qg qgVar, com.byazt.sbw.n nVar) {
        if (context == null) {
            com.byazt.gp.s.n(qgVar.qg(), (com.byazt.sg.s) null, (com.byazt.qn.qg) null, (tj) null, new com.byazt.mj.n(49013, "context为null"));
            return;
        }
        try {
            nVar.n(context.getApplicationContext(), qgVar, com.byazt.qt.n.d().m());
        } catch (Exception e) {
            com.byazt.gp.s.n(qgVar.qg(), (com.byazt.sg.s) null, (com.byazt.qn.qg) null, (tj) null, new com.byazt.mj.n(49013, "调用自定义Adapter初始化方法出现异常 " + e.getClass().getName()));
        }
    }

    public static synchronized void n(Context context, String str) {
        if (!qg(str)) {
            n(context, com.byazt.ir.s.n().qg());
        }
    }
}
