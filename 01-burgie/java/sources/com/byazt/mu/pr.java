package com.byazt.mu;

import com.byazt.dd.c;
import com.byazt.ki.hw;
import com.mar.sdk.MARCode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1843, 37})
public class pr {
    public final Map<String, List<C0137pr>> pr = new HashMap();

    /* JADX INFO: renamed from: com.byazt.mu.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 1843, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    public static class C0137pr {
        public final c hn;
        public final Map<String, Object> hw;
        public final String pr;
        public final hw x;

        public C0137pr(String str, Map<String, Object> map, c cVar, hw hwVar) {
            Map<String, Object> mapUnmodifiableMap;
            this.pr = str;
            if (map == null) {
                mapUnmodifiableMap = Collections.emptyMap();
            } else {
                mapUnmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(map));
            }
            this.hw = mapUnmodifiableMap;
            this.hn = cVar;
            this.x = hwVar;
        }

        public Map<String, Object> pr() {
            return this.hw;
        }

        public c hw() {
            return this.hn;
        }

        public hw hn() {
            return this.x;
        }

        public String x() {
            Object obj;
            String strHn;
            hw hwVar = this.x;
            if (hwVar != null && (strHn = hwVar.hn()) != null && !strHn.isEmpty()) {
                return strHn;
            }
            Map<String, Object> map = this.hw;
            if (map != null && (obj = map.get("framework")) != null) {
                String strValueOf = String.valueOf(obj);
                if (!strValueOf.isEmpty()) {
                    return strValueOf;
                }
                return "ugen";
            }
            return "ugen";
        }

        public String toString() {
            StringBuilder sbAppend = new StringBuilder("Registration{name='").append(this.pr).append("', params=").append(this.hw).append(", listener=");
            c cVar = this.hn;
            String strPr = AbstractJsonLexerKt.NULL;
            StringBuilder sbAppend2 = sbAppend.append(cVar == null ? AbstractJsonLexerKt.NULL : "set").append(", definition=");
            hw hwVar = this.x;
            if (hwVar != null) {
                strPr = hwVar.pr();
            }
            return sbAppend2.append(strPr).append(AbstractJsonLexerKt.END_OBJ).toString();
        }
    }

    public synchronized C0137pr pr(String str, String str2, Map<String, Object> map, c cVar) {
        if (str != null) {
            if (!str.isEmpty()) {
                String strPr = pr(map);
                Map<String, Object> mapHw = hw(map);
                hw hwVarPr = hw.x().pr(com.byazt.ki.pr.pr(str)).hw(str).hn(str2).pr(mapHw).x(strPr).pr(cVar).pr();
                if (str2 != null && str2.startsWith("Lottie://")) {
                    str = str2;
                }
                C0137pr c0137pr = new C0137pr(str, mapHw, cVar, hwVarPr);
                List<C0137pr> arrayList = this.pr.get(str);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.pr.put(str, arrayList);
                }
                arrayList.add(c0137pr);
                arrayList.size();
                return c0137pr;
            }
        }
        return null;
    }

    private static String pr(Map<String, Object> map) {
        Object obj;
        if (map == null || (obj = map.get("framework")) == null) {
            return null;
        }
        String strValueOf = String.valueOf(obj);
        if (strValueOf.isEmpty()) {
            return null;
        }
        return strValueOf;
    }

    private static Map<String, Object> hw(Map<String, Object> map) {
        if (map == null || !map.containsKey("framework")) {
            return map;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.remove("framework");
        return linkedHashMap;
    }

    public synchronized List<C0137pr> pr(String str) {
        List<C0137pr> list = this.pr.get(str);
        if (list != null && !list.isEmpty()) {
            return Collections.unmodifiableList(new ArrayList(list));
        }
        return Collections.emptyList();
    }
}
