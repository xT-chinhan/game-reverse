package com.byazt.bw;

import android.text.TextUtils;
import com.anythink.core.common.f.a;
import com.byazt.ho.BaseConstants;
import com.byazt.ws.tj;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1399, 8})
public class s {
    private static boolean n(int i) {
        return i == 0 || i == 1 || i == 2;
    }

    private static boolean qg(int i) {
        return i == 3 || i == 4 || i == 5 || i == 6 || i == 7 || i == 8 || i == 9;
    }

    public static void n(String str, String str2, String str3) {
        if (com.byazt.qt.qg.n().pe() != null) {
            com.byazt.wo.s.n().insert(str, str2, str3, "show");
        }
    }

    public static void qg(String str, String str2, String str3) {
        if (com.byazt.qt.qg.n().pe() != null) {
            com.byazt.wo.s.n().insert(str, str2, str3, "send");
        }
    }

    public static void s(String str, String str2, String str3) {
        if (com.byazt.qt.qg.n().pe() != null) {
            com.byazt.wo.s.n().insert(str, str2, str3, "fill");
        }
    }

    public static void n(String str, int i) {
        if (com.byazt.qt.qg.n().pe() == null || TextUtils.isEmpty(str)) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - ((long) (i * BaseConstants.Time.HOUR));
        com.byazt.rb.qg.qg("TMe", "---预缓存优化删除存储的过期数据 primeRit = " + str + " startTime = " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(jCurrentTimeMillis)));
        com.byazt.wo.s.n().n(str, jCurrentTimeMillis);
    }

    /* JADX WARN: Code duplicated, block: B:52:0x01c5  */
    public static com.byazt.ws.qg n(com.byazt.qn.qg qgVar, com.byazt.ws.qg qgVar2) {
        com.byazt.ws.qg qgVar3;
        HashMap map;
        int i;
        String str;
        String str2;
        Iterator<tj> it;
        n nVar;
        qg qgVarPe = com.byazt.qt.qg.n().pe();
        com.byazt.rb.qg.qg("TMe", "----预缓存优化判断是否可以发起预缓存开始");
        if (qgVar == null) {
            return null;
        }
        com.byazt.rb.qg.qg("TMe", "待检测的 behaviorState = " + qgVar.fs());
        int iN = n(qgVar2, qgVarPe, qgVar.fs());
        HashSet hashSet = new HashSet();
        if (iN == 200) {
            List<tj> listY = qgVar2.y();
            HashSet<String> hashSet2 = new HashSet();
            Iterator<tj> it2 = listY.iterator();
            while (true) {
                str = " adnrit = ";
                str2 = "adnName = ";
                if (!it2.hasNext()) {
                    break;
                }
                tj next = it2.next();
                com.byazt.rb.qg.qg("TMe", "adnName = " + next.hd() + " adnrit = " + next.cd());
                hashSet2.add(next.hd());
            }
            LinkedList linkedList = new LinkedList();
            HashMap map2 = new HashMap();
            Iterator<tj> it3 = listY.iterator();
            while (it3.hasNext()) {
                tj next2 = it3.next();
                if (next2 != null) {
                    n nVar2 = (n) map2.get(next2.hd());
                    if (nVar2 == null) {
                        String strHd = next2.hd();
                        String strF = qgVar2.f();
                        int iRi = qgVar2.ri();
                        double dN = qgVarPe.n(strHd, strF);
                        double dQg = qgVarPe.qg(strHd, strF);
                        it = it3;
                        if (dN == 0.0d && dQg == 0.0d) {
                            com.byazt.rb.qg.qg("TMe", "没有配置规则，直接添加到adn list中 adnName = " + next2.hd() + " adnRit " + next2.cd());
                            linkedList.add(next2);
                            it3 = it;
                        } else {
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            List<com.byazt.wo.qg> listQuery = com.byazt.wo.s.n().query(strHd, strF, jCurrentTimeMillis - ((long) (iRi * BaseConstants.Time.HOUR)), jCurrentTimeMillis);
                            if (listQuery != null && listQuery.size() != 0) {
                                Iterator<com.byazt.wo.qg> it4 = listQuery.iterator();
                                int i2 = 0;
                                int i3 = 0;
                                int i4 = 0;
                                while (it4.hasNext()) {
                                    com.byazt.wo.qg next3 = it4.next();
                                    Iterator<com.byazt.wo.qg> it5 = it4;
                                    if (TextUtils.equals(next3.n(), "send")) {
                                        i4++;
                                    } else if (TextUtils.equals(next3.n(), "fill")) {
                                        i2++;
                                    } else if (TextUtils.equals(next3.n(), "show")) {
                                        i3++;
                                    }
                                    it4 = it5;
                                }
                                str = str;
                                n nVar3 = new n(i2 != 0 ? ((double) i3) / ((double) i2) : 0.0d, i4 != 0 ? ((double) i2) / ((double) i4) : 0.0d, dN, dQg, qgVarPe.n(), qgVarPe.w());
                                nVar3.qg(i2);
                                nVar3.n(i4);
                                nVar3.s(i3);
                                map2.put(next2.hd(), nVar3);
                                nVar = nVar3;
                            } else {
                                com.byazt.rb.qg.qg("TMe", "数据库里没有查询到数据，直接添加到adn list中 adnName = " + next2.hd() + " adnRit " + next2.cd());
                                linkedList.add(next2);
                            }
                            if (nVar != null) {
                                nVar.n(next2.hd());
                                nVar.qg(next2.cd());
                                com.byazt.rb.qg.qg("TMe", "compareData ".concat(String.valueOf(nVar)));
                            }
                            if (nVar != null && nVar.n()) {
                                linkedList.add(next2);
                            }
                        }
                    } else {
                        it = it3;
                    }
                    nVar = nVar2;
                    if (nVar != null) {
                        nVar.n(next2.hd());
                        nVar.qg(next2.cd());
                        com.byazt.rb.qg.qg("TMe", "compareData ".concat(String.valueOf(nVar)));
                    }
                    if (nVar != null) {
                        linkedList.add(next2);
                    }
                } else {
                    str = str;
                    str2 = str2;
                    it = it3;
                }
                str = str;
                it3 = it;
                str2 = str2;
            }
            String str3 = str;
            String str4 = str2;
            com.byazt.rb.qg.qg("TMe", "筛选掉代码位 后留下的代码位 ------- ");
            HashSet hashSet3 = new HashSet();
            for (tj tjVar : linkedList) {
                com.byazt.rb.qg.qg("TMe", str4 + tjVar.hd() + str3 + tjVar.cd());
                hashSet3.add(tjVar.hd());
            }
            for (String str5 : hashSet2) {
                if (!hashSet3.contains(str5)) {
                    hashSet.add(str5);
                }
            }
            int i5 = listY.size() == linkedList.size() ? 11 : 10;
            com.byazt.ws.qg qgVarClone = qgVar2.clone();
            qgVarClone.n(linkedList);
            if (qgVarClone.sz()) {
                qgVarClone.qg(linkedList);
            } else {
                qgVarClone.n(linkedList);
            }
            i = i5;
            qgVar3 = qgVarClone;
            map = map2;
        } else {
            qgVar3 = null;
            map = null;
            i = iN;
        }
        if (qgVar3 == null) {
            n(qgVar, qgVar2, qgVarPe, i, hashSet, map);
        } else {
            n(qgVar, qgVar3, qgVarPe, i, hashSet, map);
        }
        if (qgVar2 != null) {
            n(qgVar.a(), qgVar2.ri());
        }
        return qgVar3;
    }

    private static int n(com.byazt.ws.qg qgVar, qg qgVar2, int i) {
        if (!com.byazt.qt.qg.n().ri()) {
            return 0;
        }
        if (qgVar2 == null || qgVar2.l() == null) {
            return 1;
        }
        if (!qgVar2.n(i)) {
            return 2;
        }
        if (qgVar2.qg() == 0) {
            return 3;
        }
        if (qgVar2.n() == 0) {
            return 4;
        }
        if (!qgVar2.x()) {
            return 5;
        }
        if (qgVar == null || !qgVar2.n(qgVar.f())) {
            return 6;
        }
        if (qgVar.ri() == 0) {
            return 7;
        }
        if (n(qgVar, qgVar2)) {
            return n(qgVar) ? 9 : 200;
        }
        return 8;
    }

    private static boolean n(com.byazt.ws.qg qgVar, qg qgVar2) {
        if (qgVar == null || qgVar.y() == null || qgVar2 == null) {
            return false;
        }
        for (tj tjVar : qgVar.y()) {
            double dN = qgVar2.n(tjVar.hd(), qgVar.f());
            double dQg = qgVar2.qg(tjVar.hd(), qgVar.f());
            if (dN != 0.0d || dQg != 0.0d) {
                return true;
            }
        }
        return false;
    }

    private static boolean n(com.byazt.ws.qg qgVar) {
        if (qgVar == null) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        List<com.byazt.wo.qg> listQuery = com.byazt.wo.s.n().query("", qgVar.f(), jCurrentTimeMillis - (((long) qgVar.ri()) * 3600000), jCurrentTimeMillis);
        return listQuery == null || listQuery.isEmpty();
    }

    private static void n(com.byazt.qn.qg qgVar, com.byazt.ws.qg qgVar2, qg qgVar3, int i, Set<String> set, Map<String, n> map) {
        if (qgVar.rv() != null) {
            com.byazt.rb.qg.qg("TMe", "预缓存优化存在埋点数据 无需重新存储");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", i);
            if (n(i)) {
                qgVar.n(jSONObject);
                return;
            }
            jSONObject.put("perform", n(i, qgVar3, map));
            if (qg(i)) {
                qgVar.n(jSONObject);
                return;
            }
            jSONObject.put("behavior_state", n(qgVar3));
            jSONObject.put("condition", qgVar3.qg());
            if (qgVar2 != null) {
                try {
                    jSONObject.put("behavior_ttl", qgVar2.ri());
                } catch (JSONException unused) {
                }
            }
            if (set != null && set.size() != 0) {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                jSONObject.put("filtered_adn", jSONArray);
            }
            qgVar.n(jSONObject);
        } catch (JSONException unused2) {
        }
    }

    private static JSONArray n(qg qgVar) {
        JSONArray jSONArray = new JSONArray();
        if (qgVar != null && qgVar.n != null) {
            Iterator<Integer> it = qgVar.n.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
        }
        return jSONArray;
    }

    private static JSONObject n(int i, qg qgVar, Map<String, n> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(a.C0017a.o, qgVar.s());
        jSONObject.put("rule_timestamp", qgVar.q());
        if (qg(i)) {
            return jSONObject;
        }
        jSONObject.put("condition", qgVar.n());
        jSONObject.put("rule_inuse", (i == 10 || i == 11) ? 1 : 0);
        if (map != null) {
            try {
                DecimalFormat decimalFormat = new DecimalFormat("#0.000");
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = new JSONObject();
                for (Map.Entry<String, n> entry : map.entrySet()) {
                    n value = entry.getValue();
                    if (value != null) {
                        jSONObject3.put(entry.getKey(), decimalFormat.format(value.qg()));
                        jSONObject4.put(entry.getKey(), decimalFormat.format(value.s()));
                    }
                }
                jSONObject2.put("ssr", jSONObject3);
                jSONObject2.put("srr", jSONObject4);
                jSONObject.put("res", jSONObject2);
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }
}
