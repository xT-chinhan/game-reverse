package com.byazt.uq;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.LongCompanionObject;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_CHECK_SILENCE_INTERVAL, 29})
public final class cp {
    public static volatile HashSet<Long> fs;
    public static volatile Map<String, ArrayList<n>> w;
    public static final Map<String, ArrayList<n>> n = new ConcurrentHashMap();
    public static final Map<String, ArrayList<n>> qg = new ConcurrentHashMap();
    public static final AtomicBoolean s = new AtomicBoolean(false);
    public static final AtomicBoolean q = new AtomicBoolean(false);
    public static volatile long l = n(System.currentTimeMillis());
    public static final com.byazt.gwu.s x = com.byazt.lk.l.n(com.byazt.vyf.s.cy().ou(), "stage_f_show");

    private cp() {
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_CHECK_SILENCE_INTERVAL, 570})
    public static final class n {
        public final int l;
        public final String n;
        public final String q;
        public final String qg;
        public final String s;

        public n(String str, String str2, String str3, String str4, int i) {
            this.n = str;
            this.qg = str2;
            this.s = str3;
            this.q = str4;
            this.l = i;
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_CHECK_SILENCE_INTERVAL, 2449})
    public static final class qg {
        public final String n;
        public final int qg;

        private qg(String str, int i) {
            this.n = str;
            this.qg = i;
        }
    }

    private static void fs() {
        if (n(System.currentTimeMillis()) == l) {
            return;
        }
        synchronized (cp.class) {
            long jN = n(System.currentTimeMillis());
            if (jN == l) {
                return;
            }
            Map<String, ArrayList<n>> map = qg;
            Map<String, ArrayList<n>> map2 = n;
            s(map, s(map2));
            map2.clear();
            l = jN;
            q.set(false);
            n(s.l());
            tj();
        }
    }

    private static void n(final int i) {
        try {
            com.byazt.ag.qg.n(new com.byazt.qit.x("hty_clean") { // from class: com.byazt.uq.cp.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        tj.n(i);
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static void n(String str, String str2, String str3, String str4) {
        final n nVar;
        oa.qg("step1/3 recordShow,loadCompId=" + str + ",showId=" + str2 + ",showPageName=" + str3 + ",showTabName=" + str4);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            fs();
            final long j = l;
            ArrayList<n> arrayListN = n(n, str);
            String strQg = qg(str3);
            String strQg2 = qg(str4);
            synchronized (arrayListN) {
                int iN = n(arrayListN, str2);
                if (iN >= 0) {
                    nVar = new n(str, str2, strQg, strQg2, arrayListN.get(iN).l + 1);
                    arrayListN.set(iN, nVar);
                } else {
                    nVar = new n(str, str2, strQg, strQg2, 1);
                    arrayListN.add(nVar);
                }
            }
            com.byazt.ag.qg.n(new com.byazt.qit.x("hty_show") { // from class: com.byazt.uq.cp.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        long j2 = j;
                        n nVar2 = nVar;
                        tj.n(j2, nVar2, nVar2.l);
                        oa.qg("step2/3 recordShow,saveDayCount->hty_show=(" + j + "," + nVar.n + "," + nVar.s + "," + nVar.q + "," + nVar.qg + "," + nVar.l + ")");
                        cp.n(j, s.l());
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static void n() {
        if (!q.get() && s.compareAndSet(false, true)) {
            final long j = l;
            final int iMax = Math.max(s.l() - 1, 0);
            try {
                com.byazt.ag.qg.n(new com.byazt.qit.x("hty_show_load") { // from class: com.byazt.uq.cp.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            oa.q("ensureHistoryLoaded,start,winDays=" + s.l() + ",loadDay=" + j + ",historyDaysLimit=" + iMax);
                            tj.n nVarN = tj.n(iMax, j);
                            Map<String, ArrayList<n>> map = nVarN.qg;
                            Map<String, ArrayList<n>> map2 = nVarN.n;
                            oa.q("ensureHistoryLoaded,queryRecentDaysSplit,history=" + oa.n(map) + ",currentDay=" + oa.n(map2));
                            synchronized (cp.class) {
                                try {
                                    if (j == cp.l) {
                                        cp.qg.clear();
                                        cp.q(cp.qg, map);
                                        cp.qg(map2);
                                        cp.q.set(true);
                                    } else {
                                        cp.s(cp.qg, map);
                                        cp.s(cp.qg, map2);
                                        cp.q.set(false);
                                    }
                                } finally {
                                    cp.s.set(false);
                                }
                            }
                            cp.cp();
                        } catch (Throwable unused) {
                            cp.q.set(true);
                        }
                    }
                });
            } catch (Throwable unused) {
                s.set(false);
                q.set(true);
            }
        }
    }

    private static void rv() throws JSONException {
        Map<String, ArrayList<n>> mapS = s(qg);
        HashMap map = new HashMap();
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry<String, ArrayList<n>> entry : mapS.entrySet()) {
            String key = entry.getKey();
            ArrayList<n> value = entry.getValue();
            if (!TextUtils.isEmpty(key) && value != null && !value.isEmpty()) {
                JSONArray jSONArray2 = new JSONArray();
                ArrayList arrayList = new ArrayList(value.size());
                for (n nVar : value) {
                    if (nVar != null && !TextUtils.isEmpty(nVar.qg) && nVar.l > 0) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("show_id", nVar.qg);
                        jSONObject.put("s_page_name", nVar.s);
                        jSONObject.put("s_t_name", nVar.q);
                        jSONObject.put("cnt", nVar.l);
                        jSONArray2.put(jSONObject);
                        arrayList.add(nVar);
                    }
                }
                if (jSONArray2.length() > 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("load_component_id", key);
                    jSONObject2.put("buckets", jSONArray2);
                    jSONArray.put(jSONObject2);
                    map.put(key, arrayList);
                }
            }
        }
        oa.s("step3/3 saveSpSnapshot,show_list=" + jSONArray);
        x.n("show_list", jSONArray.toString());
        w = map;
    }

    private static void tj() {
        com.byazt.ag.qg.n(new com.byazt.qit.x("hty_sp_save") { // from class: com.byazt.uq.cp.4
            @Override // java.lang.Runnable
            public void run() {
                cp.cp();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cp() {
        try {
            rv();
        } catch (Throwable unused) {
        }
    }

    public static void n(long j, int i) {
        if (i <= 0) {
            return;
        }
        try {
            HashSet<Long> hashSetD = d();
            synchronized (hashSetD) {
                if (hashSetD.add(Long.valueOf(j))) {
                    n(hashSetD, i);
                    x.n("has_days", n(hashSetD));
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static HashSet<Long> d() {
        HashSet<Long> hashSet = fs;
        if (hashSet != null) {
            return hashSet;
        }
        synchronized (cp.class) {
            HashSet<Long> hashSet2 = fs;
            if (hashSet2 != null) {
                return hashSet2;
            }
            HashSet<Long> hashSetOa = oa();
            fs = hashSetOa;
            return hashSetOa;
        }
    }

    private static HashSet<Long> oa() {
        HashSet<Long> hashSet = new HashSet<>();
        try {
            JSONArray jSONArray = new JSONArray(x.qg("has_days", "[]"));
            for (int i = 0; i < jSONArray.length(); i++) {
                hashSet.add(Long.valueOf(jSONArray.optLong(i, 0L)));
            }
        } catch (Throwable unused) {
        }
        return hashSet;
    }

    private static void n(HashSet<Long> hashSet, int i) {
        while (hashSet.size() > i) {
            long jLongValue = LongCompanionObject.MAX_VALUE;
            for (Long l2 : hashSet) {
                if (l2 != null && l2.longValue() < jLongValue) {
                    jLongValue = l2.longValue();
                }
            }
            hashSet.remove(Long.valueOf(jLongValue));
        }
    }

    private static String n(HashSet<Long> hashSet) {
        StringBuilder sb = new StringBuilder((hashSet.size() * 8) + 2);
        sb.append(AbstractJsonLexerKt.BEGIN_LIST);
        boolean z = true;
        for (Long l2 : hashSet) {
            if (l2 != null) {
                if (!z) {
                    sb.append(AbstractJsonLexerKt.COMMA);
                }
                sb.append(l2.longValue());
                z = false;
            }
        }
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }

    public static long[] qg() {
        HashSet<Long> hashSetD = d();
        synchronized (hashSetD) {
            int size = hashSetD.size();
            long[] jArr = new long[size];
            int i = 0;
            for (Long l2 : hashSetD) {
                if (l2 != null) {
                    jArr[i] = l2.longValue();
                    i++;
                }
            }
            if (i == size) {
                return jArr;
            }
            long[] jArr2 = new long[i];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            return jArr2;
        }
    }

    public static void n(Collection<Long> collection, int i) {
        if (i <= 0 || collection == null) {
            return;
        }
        try {
            HashSet<Long> hashSetD = d();
            synchronized (hashSetD) {
                try {
                    hashSetD.clear();
                    for (Long l2 : collection) {
                        if (l2 != null) {
                            hashSetD.add(l2);
                        }
                    }
                    n(hashSetD, i);
                    x.n("has_days", n(hashSetD));
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static Map<String, ArrayList<n>> sz() {
        JSONArray jSONArrayOptJSONArray;
        Map<String, ArrayList<n>> map = w;
        if (map != null) {
            return map;
        }
        HashMap map2 = new HashMap();
        try {
            JSONArray jSONArray = new JSONArray(x.qg("show_list", "[]"));
            int i = 0;
            int i2 = 0;
            while (i2 < jSONArray.length()) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString("load_component_id", "");
                    if (!TextUtils.isEmpty(strOptString) && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("buckets")) != null && jSONArrayOptJSONArray.length() > 0) {
                        ArrayList arrayList = new ArrayList(jSONArrayOptJSONArray.length());
                        int i3 = i;
                        while (i3 < jSONArrayOptJSONArray.length()) {
                            JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i3);
                            if (jSONObjectOptJSONObject2 != null) {
                                String strOptString2 = jSONObjectOptJSONObject2.optString("show_id", "");
                                int iOptInt = jSONObjectOptJSONObject2.optInt("cnt", i);
                                if (!TextUtils.isEmpty(strOptString2) && iOptInt > 0) {
                                    arrayList.add(new n(strOptString, strOptString2, jSONObjectOptJSONObject2.optString("s_page_name", " "), jSONObjectOptJSONObject2.optString("s_t_name", " "), iOptInt));
                                }
                            }
                            i3++;
                            i = 0;
                        }
                        if (!arrayList.isEmpty()) {
                            map2.put(strOptString, arrayList);
                        }
                    }
                }
                i2++;
                i = 0;
            }
        } catch (Throwable unused) {
        }
        w = map2;
        return map2;
    }

    public static qg n(String str) {
        ArrayList<n> arrayList;
        oa.n("step2/5 buildShowListSnapshotForRequest,loadCompId=" + str);
        fs();
        boolean z = true;
        i = 1;
        int i = 1;
        boolean z2 = !q.get();
        n();
        if (TextUtils.isEmpty(str)) {
            if (!z2 && !s.get()) {
                i = 0;
            }
            return new qg("", i);
        }
        Map<String, ArrayList<n>> map = n;
        ArrayList<n> arrayListQg = qg(map, str);
        Map<String, ArrayList<n>> map2 = qg;
        ArrayList<n> arrayListQg2 = qg(map2, str);
        boolean z3 = !arrayListQg.isEmpty();
        boolean z4 = !arrayListQg2.isEmpty();
        oa.n("step2/5 buildShowListSnapshotForRequest,bucketCheck,loadCompId=" + str + ",currentBuckets=" + arrayListQg.size() + ",otherBuckets=" + arrayListQg2.size() + ",currentDayKeys=" + map.keySet() + ",otherDayKeys=" + map2.keySet());
        if (z4 || (arrayList = sz().get(str)) == null || arrayList.isEmpty()) {
            z = false;
        } else {
            arrayListQg2 = new ArrayList<>(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        n((ArrayList<n>) arrayList2, arrayListQg2);
        n((ArrayList<n>) arrayList2, arrayListQg);
        String strN = n((ArrayList<n>) arrayList2);
        oa.n("step3/5 buildShowListSnapshotForRequest,showFeatLt=" + strN);
        return new qg(strN, n(strN.isEmpty(), z3, z4, z, z2));
    }

    private static int n(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        if (z) {
            return (z5 || s.get()) ? 1 : 0;
        }
        if (z2 && z3 && !z4) {
            return 3;
        }
        if (z2 && z4) {
            return 6;
        }
        if (z2) {
            return 2;
        }
        if (!z3 || z4) {
            return z4 ? 5 : 0;
        }
        return 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(Map<String, ArrayList<n>> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, ArrayList<n>> entry : map.entrySet()) {
            String key = entry.getKey();
            ArrayList<n> value = entry.getValue();
            if (!TextUtils.isEmpty(key) && value != null && !value.isEmpty()) {
                ArrayList<n> arrayListN = n(n, key);
                synchronized (arrayListN) {
                    for (n nVar : value) {
                        if (nVar != null && !TextUtils.isEmpty(nVar.qg) && nVar.l > 0) {
                            int iN = n(arrayListN, nVar.qg);
                            if (iN < 0) {
                                arrayListN.add(nVar);
                            } else {
                                arrayListN.set(iN, new n(key, nVar.qg, nVar.s, nVar.q, Math.max(arrayListN.get(iN).l, nVar.l)));
                            }
                        }
                    }
                }
            }
        }
    }

    private static String n(ArrayList<n> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return "";
        }
        Iterator<n> it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            n next = it.next();
            i += (next == null || next.l <= 0) ? 0 : next.l;
        }
        if (i <= 0) {
            return "";
        }
        double d = 1.0d / ((double) i);
        StringBuilder sb = new StringBuilder(arrayList.size() * 32);
        boolean z = true;
        for (n nVar : arrayList) {
            if (nVar != null && nVar.l > 0) {
                if (!z) {
                    sb.append(AbstractJsonLexerKt.COMMA);
                }
                n(sb, nVar.qg).append('_');
                n(sb, nVar.s).append('_');
                n(sb, nVar.q).append('_');
                n(sb, ((double) nVar.l) * d).append('_');
                sb.append(nVar.l);
                z = false;
            }
        }
        return sb.toString();
    }

    private static StringBuilder n(StringBuilder sb, double d) {
        int i = (int) ((d * 100.0d) + 0.5d);
        if (i >= 100) {
            return sb.append("1.00");
        }
        sb.append("0.");
        if (i < 10) {
            sb.append('0');
        }
        return sb.append(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s(Map<String, ArrayList<n>> map, Map<String, ArrayList<n>> map2) {
        if (map == null || map2 == null || map2.isEmpty()) {
            return;
        }
        for (Map.Entry<String, ArrayList<n>> entry : map2.entrySet()) {
            String key = entry.getKey();
            ArrayList<n> value = entry.getValue();
            if (!TextUtils.isEmpty(key) && value != null && !value.isEmpty()) {
                ArrayList<n> arrayList = map.get(key);
                if (arrayList == null) {
                    arrayList = new ArrayList<>(value.size());
                    map.put(key, arrayList);
                }
                synchronized (arrayList) {
                    n(arrayList, value);
                }
            }
        }
    }

    private static void n(ArrayList<n> arrayList, ArrayList<n> arrayList2) {
        if (arrayList == null || arrayList2 == null || arrayList2.isEmpty()) {
            return;
        }
        for (n nVar : arrayList2) {
            if (nVar != null && !TextUtils.isEmpty(nVar.qg) && nVar.l > 0) {
                int iN = n(arrayList, nVar.qg);
                if (iN < 0) {
                    arrayList.add(nVar);
                } else {
                    n nVar2 = arrayList.get(iN);
                    arrayList.set(iN, new n(nVar2.n, nVar2.qg, nVar.s, nVar.q, nVar2.l + nVar.l));
                }
            }
        }
    }

    private static ArrayList<n> n(Map<String, ArrayList<n>> map, String str) {
        ArrayList<n> arrayList = map.get(str);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList<n> arrayList2 = new ArrayList<>();
        ArrayList<n> arrayListPutIfAbsent = map.putIfAbsent(str, arrayList2);
        return arrayListPutIfAbsent != null ? arrayListPutIfAbsent : arrayList2;
    }

    private static ArrayList<n> qg(Map<String, ArrayList<n>> map, String str) {
        ArrayList<n> arrayList;
        ArrayList<n> arrayList2 = map.get(str);
        if (arrayList2 == null || arrayList2.isEmpty()) {
            return new ArrayList<>();
        }
        synchronized (arrayList2) {
            arrayList = new ArrayList<>(arrayList2);
        }
        return arrayList;
    }

    private static Map<String, ArrayList<n>> s(Map<String, ArrayList<n>> map) {
        HashMap map2 = new HashMap();
        for (Map.Entry<String, ArrayList<n>> entry : map.entrySet()) {
            String key = entry.getKey();
            ArrayList<n> value = entry.getValue();
            if (!TextUtils.isEmpty(key) && value != null && !value.isEmpty()) {
                synchronized (value) {
                    map2.put(key, new ArrayList(value));
                }
            }
        }
        return map2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(Map<String, ArrayList<n>> map, Map<String, ArrayList<n>> map2) {
        if (map == null || map2 == null) {
            return;
        }
        for (Map.Entry<String, ArrayList<n>> entry : map2.entrySet()) {
            String key = entry.getKey();
            ArrayList<n> value = entry.getValue();
            if (!TextUtils.isEmpty(key) && value != null && !value.isEmpty()) {
                map.put(key, new ArrayList<>(value));
            }
        }
    }

    private static int n(ArrayList<n> arrayList, String str) {
        if (arrayList != null && !TextUtils.isEmpty(str)) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                n nVar = arrayList.get(i);
                if (nVar != null && str.equals(nVar.qg)) {
                    return i;
                }
            }
        }
        return -1;
    }

    private static String qg(String str) {
        return TextUtils.isEmpty(str) ? " " : str;
    }

    private static long n(long j) {
        return (j + ((long) TimeZone.getDefault().getOffset(j))) / 86400000;
    }

    public static StringBuilder n(StringBuilder sb, String str) {
        if (str == null) {
            return sb.append(AbstractJsonLexerKt.NULL);
        }
        int length = str.length();
        if (length == 0) {
            return sb.append(AbstractJsonLexerKt.NULL);
        }
        if (length == 1 && str.charAt(0) == ' ') {
            return sb.append(AbstractJsonLexerKt.NULL);
        }
        sb.append(str);
        return sb;
    }
}
