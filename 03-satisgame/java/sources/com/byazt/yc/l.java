package com.byazt.yc;

import android.text.TextUtils;
import com.byazt.ws.tj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 965, 18})
public class l {
    public static final Map<String, n> n = new ConcurrentHashMap();

    @com.byazt.cp.n(n = {0, 1, 965, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    public static class n {
        public int l;
        public String n;
        public Set<String> q;
        public int qg;
        public Set<String> s;
    }

    public static void n(JSONArray jSONArray) {
        int iOptInt;
        if (jSONArray == null || jSONArray.length() <= 0) {
            n.clear();
            return;
        }
        n.clear();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString("id");
                if (!TextUtils.isEmpty(strOptString)) {
                    n nVar = new n();
                    int iOptInt2 = jSONObjectOptJSONObject.optInt("t");
                    nVar.n = strOptString;
                    nVar.qg = iOptInt2;
                    if (iOptInt2 == 1) {
                        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("a");
                        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                            nVar.q = new HashSet();
                            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                                nVar.q.add(jSONArrayOptJSONArray.optString(i2));
                            }
                            n.put(strOptString, nVar);
                        }
                    } else if (iOptInt2 == 2) {
                        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("r");
                        if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                            nVar.s = new HashSet();
                            for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                                nVar.s.add(jSONArrayOptJSONArray2.optString(i3));
                            }
                            n.put(strOptString, nVar);
                        }
                    } else if ((iOptInt2 == 3 || iOptInt2 == 4) && (iOptInt = jSONObjectOptJSONObject.optInt("c", -1)) != -1) {
                        nVar.l = iOptInt;
                        n.put(strOptString, nVar);
                    }
                }
            }
        }
    }

    public static n n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return n.get(str);
    }

    private static String qg(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        str.hashCode();
        switch (str) {
            case "pangle":
                return "376434";
            case "sigmob":
                return "476747";
            case "ks":
                return "575683";
            case "gdt":
                return "384735";
            case "baidu":
                return "476385";
            case "unity":
                return "846469";
            case "mintegral":
                return "765380";
            default:
                return str;
        }
    }

    private static boolean n(n nVar, double d, String str, String str2) {
        if (!n.isEmpty() && nVar != null) {
            int i = nVar.qg;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4 && d > 0.0d && d <= nVar.l) {
                            return true;
                        }
                    } else if (d > 0.0d && d >= nVar.l) {
                        return true;
                    }
                } else if (nVar.s.contains(str2)) {
                    return true;
                }
            } else if (nVar.q.contains(qg(str))) {
                return true;
            }
        }
        return false;
    }

    public static n n(com.byazt.qn.qg qgVar, tj tjVar) {
        if (n.isEmpty()) {
            return null;
        }
        Map<String, Object> mapAn = qgVar.an();
        Object obj = mapAn.get("on_shield");
        Object obj2 = mapAn.get("id_list");
        if ((obj instanceof Integer) && (obj2 instanceof List) && tjVar != null && ((Integer) obj).intValue() == 1) {
            ArrayList<n> arrayList = new ArrayList();
            try {
                Iterator it = ((List) obj2).iterator();
                boolean z = false;
                boolean z2 = false;
                while (it.hasNext()) {
                    n nVarN = n((String) it.next());
                    if (nVarN != null) {
                        if (nVarN.qg == 3) {
                            if (!z) {
                                arrayList.add(nVarN);
                                z = true;
                            }
                        } else if (nVarN.qg != 4) {
                            arrayList.add(nVarN);
                        } else if (!z2) {
                            arrayList.add(nVarN);
                            z2 = true;
                        }
                    }
                }
                Collections.sort(arrayList, new Comparator<n>() { // from class: com.byazt.yc.l.1
                    @Override // java.util.Comparator
                    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
                    public int compare(n nVar, n nVar2) {
                        return nVar.qg - nVar2.qg;
                    }
                });
            } catch (Throwable unused) {
            }
            if (!arrayList.isEmpty()) {
                n(arrayList);
                for (n nVar : arrayList) {
                    if (n(nVar, tjVar.m(), tjVar.hd(), tjVar.cd())) {
                        return nVar;
                    }
                }
            }
        }
        return null;
    }

    private static void n(List<n> list) {
        if (list.size() >= 2) {
            int size = list.size();
            int i = size - 1;
            if (list.get(i).qg != 4) {
                return;
            }
            int i2 = size - 2;
            if (list.get(i2).qg == 3 && list.get(i2).l <= list.get(i).l) {
                list.remove(list.size() - 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
