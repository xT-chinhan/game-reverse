package com.byazt.bp;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.d.b.e;
import com.byazt.qk.oa;
import com.byazt.qk.rv;
import com.byazt.qn.qg;
import com.byazt.qp.q;
import com.byazt.qyu.PluginConstants;
import com.byazt.rb.l;
import com.byazt.vf.k;
import com.byazt.vy.a;
import com.byazt.vy.cy;
import com.byazt.vy.hu;
import com.byazt.ws.fs;
import com.byazt.ws.tj;
import com.byazt.ws.w;
import com.byazt.ws.x;
import com.byazt.yc.s;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.api.core.RequestParamsUtils;
import com.qq.e.comm.pi.ACTD;
import com.smartdigimkt.sdk.api.SDMAdConst;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 835, 19})
public class n {
    public static volatile n n;

    /* JADX INFO: renamed from: com.byazt.bp.n$n, reason: collision with other inner class name */
    public interface InterfaceC0146n {
        void n(com.byazt.mj.n nVar);

        void n(x xVar);
    }

    public static int n(int i) {
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return (i == 3 || i == 4 || i == 7 || i == 8) ? 5 : 3;
        }
        return 4;
    }

    private String n(Map<String, com.byazt.nw.n> map, Context context, qg qgVar, tj tjVar, Map<String, Object> map2) {
        if (qgVar == null || tjVar == null) {
            com.byazt.rb.qg.qg("serverBiddingRequest", "adSlot is null or waterFallConfig is null can not get server bidding token");
            return "";
        }
        if (TextUtils.equals("baidu", tjVar.k())) {
            com.byazt.dd.qg qgVarN = com.byazt.dd.qg.n(tjVar, (com.byazt.ow.n) null);
            com.byazt.nw.n nVarN = s.n(qgVarN, qgVar, (com.byazt.nw.qg) null);
            if (nVarN == null) {
                return "";
            }
            try {
                map.put(String.format("%1$s_%2$s_%3$s", qgVar.n(), qgVar.a(), tjVar.cd()), nVarN);
                return nVarN.n(context, qgVarN, qgVar);
            } catch (Throwable unused) {
                return "";
            }
        }
        return com.byazt.ya.n.n(map2, tjVar.k());
    }

    public static n n() {
        if (n == null) {
            synchronized (n.class) {
                if (n == null) {
                    n = new n();
                }
            }
        }
        return n;
    }

    public void n(Map<String, com.byazt.nw.n> map, Context context, com.byazt.vp.s sVar, final InterfaceC0146n interfaceC0146n) {
        JSONObject jSONObject;
        rv rvVar;
        qg qgVar = sVar.n;
        List<tj> list = sVar.qg;
        List<com.byazt.sg.s> list2 = sVar.s;
        com.byazt.ws.qg qgVar2 = sVar.q;
        int i = sVar.l;
        boolean z = sVar.w;
        final long j = sVar.x;
        JSONObject jSONObject2 = new JSONObject();
        rv rvVarQ = com.byazt.phf.s.q(com.byazt.qt.s.s());
        String strFs = com.byazt.qt.n.d().fs();
        if (!TextUtils.isEmpty(strFs)) {
            rvVarQ.n("X-Tt-Env", strFs);
            rvVarQ.n("x-use-ppe", "1");
        }
        rvVarQ.n(RequestParamsUtils.USER_AGENT_KEY, com.byazt.sg.qg.n);
        final boolean z2 = !com.byazt.qt.qg.n().fs();
        if (z2) {
            rvVarQ.n("x-pglcypher", "4");
            rvVarQ.n(hu.qg(n(map, context, qgVar, list, list2, qgVar2, i, z, jSONObject2, false, j)));
            com.byazt.zo.x.n(jSONObject2, "0-encrypt", j);
            if (rvVarQ.s() != null) {
                hu.n(com.byazt.qt.s.s(), rvVarQ.s(), true);
            }
            rvVar = rvVarQ;
            jSONObject = jSONObject2;
        } else {
            String strN = n(map, context, qgVar, list, list2, qgVar2, i, z, jSONObject2, true, j);
            com.byazt.zo.x.n(jSONObject, "0-encrypt", j);
            rvVar = rvVarQ;
            rvVar.qg(strN);
            if (rvVar.s() != null) {
                jSONObject = jSONObject2;
                hu.n(com.byazt.qt.s.s(), rvVar.s(), true);
            }
        }
        jSONObject = jSONObject2;
        final JSONObject jSONObject3 = jSONObject;
        rvVar.n(new com.byazt.qk.x() { // from class: com.byazt.bp.n.1
            /* JADX WARN: Code duplicated, block: B:39:0x00fd  */
            @Override // com.byazt.qk.x
            public void n(oa oaVar) {
                JSONObject jSONObject4;
                com.byazt.zo.x.n(jSONObject3, "0-net", j);
                if (oaVar != null) {
                    int iN = oaVar.n();
                    if (hu.n(oaVar)) {
                        hu.n(com.byazt.qt.s.s(), oaVar.q(), false);
                        String strN2 = hu.n(oaVar.q());
                        com.byazt.zo.x.n(jSONObject3, "0-decrypt", j);
                        if (!TextUtils.isEmpty(strN2)) {
                            try {
                                n.this.n(new JSONObject(strN2), jSONObject3, interfaceC0146n, z2, j);
                                return;
                            } catch (Throwable th) {
                                n.this.n(81014, th.getMessage(), interfaceC0146n, z2);
                                return;
                            }
                        }
                        com.byazt.rb.qg.q("ServerBiddingHelper", "Server Bidding Request onResponse...response v4 is empty");
                        n.this.n(iN, "response is empty", interfaceC0146n, z2);
                        return;
                    }
                    if (!TextUtils.isEmpty(oaVar.fs())) {
                        try {
                            hu.n(com.byazt.qt.s.s(), oaVar.fs(), false);
                            JSONObject jSONObjectL = oaVar.l();
                            int iOptInt = jSONObjectL.optInt("cypher", -1);
                            String strOptString = jSONObjectL.optString("message");
                            if (iOptInt >= 0 && !TextUtils.isEmpty(strOptString)) {
                                if (iOptInt == 2) {
                                    String strN3 = hu.n(strOptString);
                                    com.byazt.zo.x.n(jSONObject3, "0-decrypt", j);
                                    if (TextUtils.isEmpty(strN3)) {
                                        jSONObject4 = null;
                                    } else {
                                        try {
                                            jSONObject4 = new JSONObject(strN3);
                                        } catch (Throwable th2) {
                                            com.byazt.rb.qg.n("ServerBiddingHelper", ">>>>> server bidding data error: " + th2.toString());
                                            jSONObject4 = null;
                                        }
                                    }
                                } else if (iOptInt == 1) {
                                    String strQg = com.byazt.vy.n.qg(strOptString, com.byazt.vy.qg.n());
                                    com.byazt.zo.x.n(jSONObject3, "0-decrypt", j);
                                    if (TextUtils.isEmpty(strQg)) {
                                        jSONObject4 = null;
                                    } else {
                                        try {
                                            jSONObject4 = new JSONObject(strQg);
                                        } catch (Throwable th3) {
                                            com.byazt.rb.qg.n("ServerBiddingHelper", "server bidding data error: ", th3);
                                            jSONObject4 = null;
                                        }
                                    }
                                } else if (iOptInt == 0) {
                                    jSONObject4 = new JSONObject(strOptString);
                                } else {
                                    jSONObject4 = null;
                                }
                                n.this.n(jSONObject4, jSONObject3, interfaceC0146n, z2, j);
                                return;
                            }
                            int iOptInt2 = jSONObjectL.optInt("status_code", -2);
                            int iOptInt3 = jSONObjectL.optInt(MediationConstant.KEY_REASON, -2);
                            String strOptString2 = jSONObjectL.optString(SDMAdConst.NETWORK_CUSTOM_KEY.DESC);
                            com.byazt.rb.qg.q("ServerBiddingHelper", "Server Bidding onResponse error ");
                            n.this.n(iOptInt2, "reason is " + iOptInt3 + "，desc is " + strOptString2, interfaceC0146n, z2);
                            return;
                        } catch (Throwable th4) {
                            n.this.n(81006, th4.getMessage(), interfaceC0146n, z2);
                            return;
                        }
                    }
                    com.byazt.rb.qg.q("ServerBiddingHelper", "Server Bidding Request onResponse...response is empty");
                    n.this.n(iN, "response is empty", interfaceC0146n, z2);
                    return;
                }
                com.byazt.rb.qg.q("ServerBiddingHelper", "Server Bidding Request onResponse...response is null");
                n.this.n(-1, "response is null", interfaceC0146n, z2);
            }

            @Override // com.byazt.qk.x
            public void n(int i2, String str, Throwable th) {
                int i3 = th instanceof SocketTimeoutException ? 44405 : 44404;
                com.byazt.rb.qg.q("ServerBiddingHelper", "Server Bidding Request onError...errorCode=".concat(String.valueOf(i3)));
                n.this.n(i3, "request fail " + th.getMessage(), interfaceC0146n, z2);
            }
        });
    }

    private void n(boolean z, long j) {
        a.n(z ? "v4Enc_exchange" : "v2Enc_exchange", true, j, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, String str, InterfaceC0146n interfaceC0146n, boolean z) {
        a.n(z ? "v4Enc_exchange" : "v2Enc_exchange", false, 0L, "code = " + i + "，msg = " + str);
        n(interfaceC0146n, new com.byazt.mj.n(i, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(JSONObject jSONObject, JSONObject jSONObject2, InterfaceC0146n interfaceC0146n, boolean z, long j) {
        String str;
        JSONArray jSONArray;
        String str2;
        long jElapsedRealtime = SystemClock.elapsedRealtime() - j;
        String str3 = "ServerBiddingHelper";
        if (jSONObject != null) {
            if (!TextUtils.isEmpty(jSONObject.toString())) {
                x xVar = new x();
                xVar.n(jSONObject2);
                xVar.s(jSONObject.optString("request_id"));
                xVar.l(jSONObject.optString("server_bidding_extra"));
                xVar.q(jSONObject.optString("server_request_id"));
                fs fsVar = new fs();
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("winner");
                String str4 = e.a.h;
                if (jSONObjectOptJSONObject != null) {
                    fsVar.qg(jSONObjectOptJSONObject.optInt("req_bidding_type"));
                    fsVar.s(jSONObjectOptJSONObject.optString(e.a.h));
                    fsVar.q(jSONObjectOptJSONObject.optString("load_price"));
                    fsVar.tj(jSONObjectOptJSONObject.optString("adm"));
                    fsVar.l(jSONObjectOptJSONObject.optString(TapEventParamConstants.PARAM_NAME));
                    fsVar.x(jSONObjectOptJSONObject.optString("app_id"));
                    fsVar.w(jSONObjectOptJSONObject.optString("slot_id"));
                    fsVar.fs(jSONObjectOptJSONObject.optString("win_callback", null));
                    fsVar.rv(jSONObjectOptJSONObject.optString("fail_callback", null));
                    fsVar.n(jSONObjectOptJSONObject.optInt("pricing_type", 1));
                    xVar.n(fsVar);
                }
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("winners");
                if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                    str = str3;
                } else {
                    ArrayList arrayList = new ArrayList();
                    int i = 0;
                    while (i < jSONArrayOptJSONArray.length()) {
                        try {
                            fs fsVar2 = new fs();
                            JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                            jSONArray = jSONArrayOptJSONArray;
                            try {
                                fsVar2.qg(jSONObjectOptJSONObject2.optInt("req_bidding_type"));
                                fsVar2.s(jSONObjectOptJSONObject2.optString(str4));
                                fsVar2.q(jSONObjectOptJSONObject2.optString("load_price"));
                                fsVar2.tj(jSONObjectOptJSONObject2.optString("adm"));
                                fsVar2.l(jSONObjectOptJSONObject2.optString(TapEventParamConstants.PARAM_NAME));
                                fsVar2.x(jSONObjectOptJSONObject2.optString("app_id"));
                                fsVar2.w(jSONObjectOptJSONObject2.optString("slot_id"));
                                str4 = str4;
                                try {
                                    fsVar2.fs(jSONObjectOptJSONObject2.optString("win_callback", null));
                                    fsVar2.rv(jSONObjectOptJSONObject2.optString("fail_callback", null));
                                    fsVar2.n(jSONObjectOptJSONObject2.optString("m_aid", null));
                                    fsVar2.qg(jSONObjectOptJSONObject2.optString("ad_extra", null));
                                    try {
                                        fsVar2.n(jSONObjectOptJSONObject2.optInt("pricing_type", 1));
                                        arrayList.add(fsVar2);
                                        str2 = str3;
                                    } catch (Throwable th) {
                                        th = th;
                                        str2 = str3;
                                        com.byazt.rb.qg.n(str2, "new invalid_non_server_bidding_results winners parse error: " + th.toString());
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                str2 = str3;
                                com.byazt.rb.qg.n(str2, "new invalid_non_server_bidding_results winners parse error: " + th.toString());
                                i++;
                                str3 = str2;
                                str4 = str4;
                                jSONArrayOptJSONArray = jSONArray;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            jSONArray = jSONArrayOptJSONArray;
                        }
                        i++;
                        str3 = str2;
                        str4 = str4;
                        jSONArrayOptJSONArray = jSONArray;
                    }
                    str = str3;
                    xVar.n(arrayList);
                }
                JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("auto_detail");
                if (jSONObjectOptJSONObject3 != null) {
                    xVar.n(jSONObjectOptJSONObject3.optString("est_price"));
                    xVar.n(jSONObjectOptJSONObject3.optInt("est_price_source"));
                    xVar.qg(jSONObjectOptJSONObject3.optString("bidding_ecpm"));
                }
                JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("waterfall");
                if (jSONObjectOptJSONObject4 != null) {
                    x.n nVar = new x.n();
                    nVar.n(jSONObjectOptJSONObject4.optString("version"));
                    JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject4.optJSONArray("adn_rit_conf");
                    ArrayList arrayList2 = new ArrayList();
                    if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                        for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                            try {
                                JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray2.optJSONObject(i2);
                                tj tjVar = new tj();
                                tjVar.s(jSONObjectOptJSONObject5.optString(MediationConstant.EXTRA_ADN_NAME));
                                tjVar.l(jSONObjectOptJSONObject5.optString("adn_slot_id"));
                                arrayList2.add(tjVar);
                            } catch (Throwable th5) {
                                com.byazt.rb.qg.n(str, "new waterfallListJson parse error: " + th5.toString());
                            }
                        }
                    }
                    nVar.n(arrayList2);
                    xVar.n(nVar);
                }
                JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("invalid_non_server_bidding_results");
                ArrayList arrayList3 = new ArrayList();
                if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                    for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                        try {
                            JSONObject jSONObjectOptJSONObject6 = jSONArrayOptJSONArray3.optJSONObject(i3);
                            w wVar = new w();
                            wVar.n(jSONObjectOptJSONObject6.optString(TapEventParamConstants.PARAM_NAME));
                            wVar.qg(jSONObjectOptJSONObject6.optString("slot_id"));
                            wVar.n(jSONObjectOptJSONObject6.optInt("req_bidding_type"));
                            wVar.qg(jSONObjectOptJSONObject6.optInt("error_code"));
                            wVar.s(jSONObjectOptJSONObject6.optString("error_msg"));
                            wVar.q(jSONObjectOptJSONObject6.optString("level_tag"));
                            arrayList3.add(wVar);
                        } catch (Throwable th6) {
                            com.byazt.rb.qg.n(str, "new invalid_non_server_bidding_results parse error: " + th6.toString());
                        }
                    }
                    xVar.qg(arrayList3);
                }
                com.byazt.zo.x.n(jSONObject2, "0-parse", j);
                n(interfaceC0146n, xVar);
                n(z, jElapsedRealtime);
                return;
            }
            com.byazt.rb.qg.q("ServerBiddingHelper", "Server Bidding Request onResponse..data.string is null ");
            n(-1, "data.string is null", interfaceC0146n, z);
            return;
        }
        com.byazt.rb.qg.q("ServerBiddingHelper", "Server Bidding Request onResponse...data is null");
        n(-1, "data is null", interfaceC0146n, z);
    }

    private void n(x xVar, String str) {
        JSONObject jSONObject;
        if (xVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            int iOptInt = jSONObject2.optInt("cypher", -1);
            String strOptString = jSONObject2.optString("message");
            if (iOptInt < 0 || TextUtils.isEmpty(strOptString)) {
                com.byazt.rb.qg.q("ServerBiddingHelper", "m_meta onResponse error ");
                return;
            }
            JSONObject jSONObject3 = null;
            if (iOptInt == 4) {
                k kVarS = com.byazt.cl.s.s();
                String strQg = kVarS != null ? kVarS.qg(strOptString) : null;
                if (!TextUtils.isEmpty(strQg)) {
                    try {
                        jSONObject = new JSONObject(strQg);
                        jSONObject3 = jSONObject;
                    } catch (Throwable th) {
                        com.byazt.rb.qg.n("ServerBiddingHelper", ">>>>> m_meta data 4 error: " + th.toString());
                    }
                }
            } else if (iOptInt == 2) {
                String strN = hu.n(strOptString);
                if (!TextUtils.isEmpty(strN)) {
                    try {
                        jSONObject = new JSONObject(strN);
                        jSONObject3 = jSONObject;
                    } catch (Throwable th2) {
                        com.byazt.rb.qg.n("ServerBiddingHelper", ">>>>> m_meta data 2 error: " + th2.toString());
                    }
                }
            } else if (iOptInt == 1) {
                String strQg2 = com.byazt.vy.n.qg(strOptString, com.byazt.vy.qg.n());
                if (!TextUtils.isEmpty(strQg2)) {
                    try {
                        jSONObject = new JSONObject(strQg2);
                        jSONObject3 = jSONObject;
                    } catch (Throwable th3) {
                        com.byazt.rb.qg.n("ServerBiddingHelper", "m_meta data 1 error: ", th3);
                    }
                }
            } else if (iOptInt == 0) {
                jSONObject3 = new JSONObject(strOptString);
            }
            if (jSONObject3 != null) {
                if (!TextUtils.isEmpty(jSONObject3.toString())) {
                    xVar.s(jSONObject3.optString("request_id"));
                    xVar.l(jSONObject3.optString("server_bidding_extra"));
                    xVar.q(jSONObject3.optString("server_request_id"));
                    return;
                }
                com.byazt.rb.qg.q("ServerBiddingHelper", "m_meta..data.string is null ");
                return;
            }
            com.byazt.rb.qg.q("ServerBiddingHelper", "m_meta...data is null");
        } catch (Throwable th4) {
            com.byazt.rb.qg.q("ServerBiddingHelper", "m_meta onResponse throwable ：".concat(String.valueOf(th4.toString())));
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00ca  */
    private fs n(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("m_adm");
        Object objOpt = jSONObject.opt("extra_data_and_no_parse");
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        try {
            JSONObject jSONObject3 = new JSONObject(strOptString);
            int iOptInt = jSONObject3.optInt("cypher", -1);
            String strOptString2 = jSONObject3.optString("message");
            if (iOptInt < 0 || TextUtils.isEmpty(strOptString2)) {
                com.byazt.rb.qg.q("ServerBiddingHelper", "adm winner data onResponse error ");
                return null;
            }
            if (iOptInt == 4) {
                k kVarS = com.byazt.cl.s.s();
                String strQg = kVarS != null ? kVarS.qg(strOptString2) : null;
                if (TextUtils.isEmpty(strQg)) {
                    jSONObject2 = null;
                } else {
                    try {
                        jSONObject2 = new JSONObject(strQg);
                    } catch (Throwable th) {
                        com.byazt.rb.qg.n("ServerBiddingHelper", ">>>>> adm winner data 4 error: " + th.toString());
                        jSONObject2 = null;
                    }
                }
            } else if (iOptInt == 2) {
                String strN = hu.n(strOptString2);
                if (TextUtils.isEmpty(strN)) {
                    jSONObject2 = null;
                } else {
                    try {
                        jSONObject2 = new JSONObject(strN);
                    } catch (Throwable th2) {
                        com.byazt.rb.qg.n("ServerBiddingHelper", ">>>>> adm winner data 2 error: " + th2.toString());
                        jSONObject2 = null;
                    }
                }
            } else if (iOptInt == 1) {
                String strQg2 = com.byazt.vy.n.qg(strOptString2, com.byazt.vy.qg.n());
                if (TextUtils.isEmpty(strQg2)) {
                    jSONObject2 = null;
                } else {
                    try {
                        jSONObject2 = new JSONObject(strQg2);
                    } catch (Throwable th3) {
                        com.byazt.rb.qg.n("ServerBiddingHelper", ">>>>> adm winner data error: " + th3.toString());
                        jSONObject2 = null;
                    }
                }
            } else if (iOptInt == 0) {
                jSONObject2 = new JSONObject(strOptString2);
            } else {
                jSONObject2 = null;
            }
            if (jSONObject2 != null) {
                if (!TextUtils.isEmpty(jSONObject2.toString())) {
                    fs fsVar = new fs();
                    fsVar.qg(jSONObject2.optInt("req_bidding_type"));
                    fsVar.s(jSONObject2.optString(e.a.h));
                    fsVar.q(jSONObject2.optString("load_price"));
                    fsVar.tj(jSONObject2.optString("adm"));
                    fsVar.l(jSONObject2.optString(TapEventParamConstants.PARAM_NAME));
                    fsVar.x(jSONObject2.optString("app_id"));
                    fsVar.w(jSONObject2.optString("slot_id"));
                    fsVar.fs(jSONObject2.optString("win_callback", null));
                    fsVar.rv(jSONObject2.optString("fail_callback", null));
                    fsVar.n(jSONObject2.optString("m_aid", null));
                    fsVar.qg(jSONObject2.optString("ad_extra", null));
                    fsVar.n(jSONObject2.optInt("pricing_type", 1));
                    fsVar.n(objOpt);
                    return fsVar;
                }
                com.byazt.rb.qg.q("ServerBiddingHelper", "adm winner data.string is null ");
                return null;
            }
            com.byazt.rb.qg.q("ServerBiddingHelper", "adm winner data is null");
            return null;
        } catch (Throwable th4) {
            com.byazt.rb.qg.q("ServerBiddingHelper", "adm winner onResponse throwable ：".concat(String.valueOf(th4.toString())));
            return null;
        }
    }

    public void n(String str, InterfaceC0146n interfaceC0146n) {
        if (!TextUtils.isEmpty(str)) {
            try {
                x xVar = new x();
                JSONObject jSONObject = new JSONObject(str);
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("items");
                String strOptString = jSONObject.optString("m_meta");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        try {
                            fs fsVarN = n(jSONArrayOptJSONArray.optJSONObject(i));
                            if (fsVarN != null) {
                                arrayList.add(fsVarN);
                            }
                        } catch (Throwable th) {
                            com.byazt.rb.qg.n("ServerBiddingHelper", "new invalid_non_server_bidding_results winners parse error: " + th.toString());
                        }
                    }
                    xVar.n(arrayList);
                }
                n(xVar, strOptString);
                n(interfaceC0146n, xVar);
                return;
            } catch (Throwable th2) {
                String string = th2.toString();
                com.byazt.rb.qg.q("ServerBiddingHelper", "Server Bidding onResponse throwable ：".concat(String.valueOf(string)));
                if (TextUtils.isEmpty(string)) {
                    string = com.byazt.mj.n.n(-1);
                }
                n(interfaceC0146n, new com.byazt.mj.n(-1, string));
                return;
            }
        }
        com.byazt.rb.qg.q("ServerBiddingHelper", "Server Bidding Request onResponse...response is invalid");
        n(interfaceC0146n, new com.byazt.mj.n(-1, "response is invalid"));
    }

    private void n(final InterfaceC0146n interfaceC0146n, final com.byazt.mj.n nVar) {
        l.n(new Runnable() { // from class: com.byazt.bp.n.2
            @Override // java.lang.Runnable
            public void run() {
                InterfaceC0146n interfaceC0146n2 = interfaceC0146n;
                if (interfaceC0146n2 != null) {
                    interfaceC0146n2.n(nVar);
                }
            }
        });
    }

    private void n(final InterfaceC0146n interfaceC0146n, final x xVar) {
        l.n(new Runnable() { // from class: com.byazt.bp.n.3
            @Override // java.lang.Runnable
            public void run() {
                InterfaceC0146n interfaceC0146n2 = interfaceC0146n;
                if (interfaceC0146n2 != null) {
                    interfaceC0146n2.n(xVar);
                }
            }
        });
    }

    private JSONObject qg() {
        if (TextUtils.isEmpty(com.byazt.qt.qg.n().py())) {
            return null;
        }
        try {
            return new JSONObject(com.byazt.qt.qg.n().py());
        } catch (Exception unused) {
            return null;
        }
    }

    private JSONObject n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public String n(Map<String, com.byazt.nw.n> map, Context context, qg qgVar, List<tj> list, com.byazt.ws.qg qgVar2, int i, boolean z, JSONObject jSONObject) {
        if (context == null) {
            return "";
        }
        String strN = n(map, context, qgVar, list, null, qgVar2, i, z, jSONObject, false, SystemClock.elapsedRealtime());
        k kVarS = com.byazt.cl.s.s();
        if (kVarS != null) {
            String strN2 = kVarS.n(strN);
            if (TextUtils.isEmpty(strN2)) {
                return "";
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("message", strN2);
                jSONObject2.put("cypher", 4);
                return jSONObject2.toString();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 16461. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    private java.lang.String n(java.util.Map<java.lang.String, com.byazt.nw.n> r37, android.content.Context r38, com.byazt.qn.qg r39, java.util.List<com.byazt.ws.tj> r40, java.util.List<com.byazt.sg.s> r41, com.byazt.ws.qg r42, int r43, boolean r44, org.json.JSONObject r45, boolean r46, long r47) {
        /*
            Method dump skipped, instruction units count: 1646
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.byazt.bp.n.n(java.util.Map, android.content.Context, com.byazt.qn.qg, java.util.List, java.util.List, com.byazt.ws.qg, int, boolean, org.json.JSONObject, boolean, long):java.lang.String");
    }

    private String n(qg qgVar, tj tjVar) {
        String strN = qgVar != null ? qgVar.n() : null;
        if (tjVar != null) {
            return (strN + "_") + tjVar.cd();
        }
        return strN;
    }

    private String n(JSONObject jSONObject, boolean z, boolean z2) {
        if (!z2) {
            if (jSONObject == null) {
                return null;
            }
            try {
                jSONObject.putOpt("token_type", Integer.valueOf(z ? 1 : 0));
            } catch (Exception unused) {
            }
            return jSONObject.toString();
        }
        JSONObject jSONObjectN = hu.n(jSONObject);
        if (jSONObjectN == null) {
            return null;
        }
        try {
            jSONObjectN.putOpt("token_type", Integer.valueOf(z ? 1 : 0));
        } catch (Exception unused2) {
        }
        return jSONObjectN.toString();
    }

    private JSONObject n(qg qgVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("request_id", qgVar.n());
            jSONObject.put("ad_sdk_version", com.byazt.sg.qg.n());
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, com.byazt.sg.qg.s());
            jSONObject.put("source_type", com.anythink.core.common.f.a.C0017a.c);
            jSONObject.put(com.anythink.core.common.f.a.C0017a.c, s());
            JSONObject jSONObjectN = cy.n(com.byazt.qt.qg.getContext());
            if (jSONObjectN != null && qgVar.ln() > 0) {
                jSONObjectN.put("orientation", qgVar.ln());
            }
            jSONObject.put("device", jSONObjectN);
            jSONObject.put("ua", com.byazt.sg.qg.n);
            jSONObject.put("ip", com.byazt.ehw.w.n());
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(qg(qgVar));
            jSONObject.put("adslots", jSONArray);
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject.put("ts", jCurrentTimeMillis);
            String strConcat = "";
            if (qgVar.a() != null && qgVar.n() != null) {
                strConcat = String.valueOf(jCurrentTimeMillis).concat(qgVar.a()).concat(qgVar.n());
            }
            jSONObject.put("req_sign", com.byazt.vy.w.n(strConcat));
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private JSONObject qg(qg qgVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            int iUm = qgVar.um();
            jSONObject.put("id", qgVar.a());
            jSONObject.put("adtype", iUm);
            jSONObject.put("pos", n(iUm));
            if (com.byazt.nf.tj.l < 7500) {
                n(jSONObject, "accepted_size", qgVar.ou(), qgVar.wm());
            } else {
                n(jSONObject, "accepted_size", com.byazt.mj.l.n(com.byazt.qt.qg.getContext(), qgVar.oa()), com.byazt.mj.l.n(com.byazt.qt.qg.getContext(), qgVar.sz()));
            }
            jSONObject.put("is_support_dpl", qgVar.hu());
            int iM = qgVar.m();
            int i = 1;
            if (iM <= 0) {
                iM = 1;
            }
            if (iM > 3) {
                iM = 3;
            }
            if (iUm != 7 && iUm != 8) {
                i = iM;
            }
            jSONObject.put("ad_count", i);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private void n(JSONObject jSONObject, String str, int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject2.put("width", i);
            jSONObject2.put("height", i2);
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }

    private void qg(JSONObject jSONObject) {
        try {
            jSONObject.put("package_name", hu.n());
            jSONObject.put("version_code", hu.qg());
            jSONObject.put("version", hu.s());
        } catch (Exception unused) {
        }
    }

    private void s(JSONObject jSONObject) {
        com.byazt.hsi.n nVarQ;
        com.byazt.vf.oa oaVar = (com.byazt.vf.oa) q.n("device_info_new");
        if (oaVar == null || (nVarQ = oaVar.q(!com.byazt.ehw.n.qg())) == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("latitude", nVarQ.n());
            jSONObject2.put("longitude", nVarQ.qg());
            jSONObject.put("geo", jSONObject2);
        } catch (Exception unused) {
        }
    }

    private String qg(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            com.byazt.sbw.n nVarN = com.byazt.ya.n.n(str);
            if (nVarN != null) {
                return nVarN.s();
            }
            com.byazt.ju.q qVarN = com.byazt.ya.qg.n().n(str);
            if (qVarN == null) {
                return null;
            }
            return qVarN.qg();
        } catch (Throwable th) {
            com.byazt.rb.qg.q("TTMediationSDK_SDK_Init", "GDT SDK 初始化失败。。 e=" + th.toString());
            return null;
        }
    }

    private JSONObject s() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ACTD.APPID_KEY, com.byazt.qt.n.d().oa());
            jSONObject.put(TapEventParamConstants.PARAM_NAME, com.byazt.qt.n.d().um());
            qg(jSONObject);
            s(jSONObject);
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
