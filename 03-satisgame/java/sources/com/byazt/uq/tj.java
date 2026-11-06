package com.byazt.uq;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.anythink.core.common.f.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import kotlin.jvm.internal.LongCompanionObject;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_CHECK_SILENCE_INTERVAL, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public final class tj {
    public static void n(long j, cp.n nVar, int i) {
        if (nVar == null || i <= 0) {
            return;
        }
        String str = nVar.n;
        String str2 = nVar.qg;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        n();
        String str3 = nVar.s != null ? nVar.s : "";
        String str4 = nVar.q != null ? nVar.q : "";
        ContentValues contentValues = new ContentValues();
        contentValues.put(a.C0017a.k, Long.valueOf(j));
        contentValues.put("load_component_id", str);
        contentValues.put("s_page_name", str3);
        contentValues.put("s_t_name", str4);
        contentValues.put("show_id", str2);
        contentValues.put("show_count", Integer.valueOf(i));
        contentValues.put(com.anythink.core.common.f.k.a.g, Long.valueOf(System.currentTimeMillis()));
        if (com.byazt.xp.n.update(com.byazt.nf.rv.getContext(), "hty_show", contentValues, "day=? AND load_component_id=? AND s_page_name=? AND s_t_name=?", new String[]{String.valueOf(j), str, str3, str4}) <= 0) {
            com.byazt.xp.n.insert(com.byazt.nf.rv.getContext(), "hty_show", contentValues);
        }
    }

    private static long[] n(long[] jArr, int i, long j) {
        if (jArr == null || jArr.length == 0 || i <= 0) {
            return new long[0];
        }
        int iMin = Math.min(jArr.length, i);
        long[] jArr2 = new long[iMin];
        int i2 = 0;
        int i3 = 0;
        for (long j2 : jArr) {
            if (j2 < j) {
                if (i2 < iMin) {
                    jArr2[i2] = j2;
                    if (j2 < jArr2[i3]) {
                        i3 = i2;
                    }
                    i2++;
                } else if (j2 > jArr2[i3]) {
                    jArr2[i3] = j2;
                    int i4 = 0;
                    for (int i5 = 1; i5 < iMin; i5++) {
                        if (jArr2[i5] < jArr2[i4]) {
                            i4 = i5;
                        }
                    }
                    i3 = i4;
                }
            }
        }
        if (i2 == iMin) {
            return jArr2;
        }
        long[] jArr3 = new long[i2];
        System.arraycopy(jArr2, 0, jArr3, 0, i2);
        return jArr3;
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_CHECK_SILENCE_INTERVAL, 855})
    public static final class n {
        public final Map<String, ArrayList<cp.n>> n;
        public final Map<String, ArrayList<cp.n>> qg;

        public n(Map<String, ArrayList<cp.n>> map, Map<String, ArrayList<cp.n>> map2) {
            this.n = map;
            this.qg = map2;
        }
    }

    public static n n(int i, long j) {
        long[] jArr;
        long[] jArrQg;
        n();
        if (i <= 0) {
            jArr = new long[0];
        } else {
            long[] jArrN = n(cp.qg(), i, j);
            if (jArrN.length != 0 || (jArrQg = qg(i, j)) == null || jArrQg.length <= 0) {
                jArr = jArrN;
            } else {
                ArrayList arrayList = new ArrayList(jArrQg.length);
                for (long j2 : jArrQg) {
                    arrayList.add(Long.valueOf(j2));
                }
                cp.n(arrayList, i);
                jArr = jArrQg;
            }
        }
        long[] jArr2 = new long[jArr.length + 1];
        jArr2[0] = j;
        System.arraycopy(jArr, 0, jArr2, 1, jArr.length);
        return n(n(jArr2), qg(jArr2), j);
    }

    private static n n(String str, String[] strArr, long j) throws Throwable {
        Cursor cursor;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        try {
            Cursor cursorQuery = com.byazt.xp.n.query(com.byazt.nf.rv.getContext(), "hty_show", null, str, strArr, null, null, null);
            try {
                if (cursorQuery == null) {
                    throw new IllegalStateException("history_show query failed");
                }
                int columnIndex = cursorQuery.getColumnIndex(a.C0017a.k);
                int columnIndex2 = cursorQuery.getColumnIndex("load_component_id");
                int columnIndex3 = cursorQuery.getColumnIndex("s_page_name");
                int columnIndex4 = cursorQuery.getColumnIndex("s_t_name");
                int columnIndex5 = cursorQuery.getColumnIndex("show_id");
                int columnIndex6 = cursorQuery.getColumnIndex("show_count");
                while (cursorQuery.moveToNext()) {
                    long j2 = columnIndex >= 0 ? cursorQuery.getLong(columnIndex) : -1L;
                    String string = columnIndex2 >= 0 ? cursorQuery.getString(columnIndex2) : null;
                    String string2 = columnIndex3 >= 0 ? cursorQuery.getString(columnIndex3) : "";
                    String string3 = columnIndex4 >= 0 ? cursorQuery.getString(columnIndex4) : "";
                    String string4 = columnIndex5 >= 0 ? cursorQuery.getString(columnIndex5) : null;
                    int i = columnIndex;
                    int i2 = columnIndex2;
                    int i3 = columnIndex6 >= 0 ? cursorQuery.getInt(columnIndex6) : 0;
                    int i4 = columnIndex3;
                    oa.q("queryByWhereSplit,row=(" + j2 + "," + string + "," + string2 + "," + string3 + "," + string4 + "," + i3 + ")");
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string4) && i3 > 0) {
                        Map map3 = j2 == j ? map : map2;
                        Map map4 = (Map) map3.get(string);
                        if (map4 == null) {
                            map4 = new HashMap();
                            map3.put(string, map4);
                        }
                        cp.n nVar = (cp.n) map4.get(string4);
                        map4.put(string4, new cp.n(string, string4, string2, string3, nVar == null ? i3 : nVar.l + i3));
                    }
                    columnIndex = i;
                    columnIndex2 = i2;
                    columnIndex3 = i4;
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return new n(n(map), n(map2));
            } catch (Throwable th) {
                th = th;
                cursor = cursorQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    private static Map<String, ArrayList<cp.n>> n(Map<String, Map<String, cp.n>> map) {
        HashMap map2 = new HashMap();
        for (Map.Entry<String, Map<String, cp.n>> entry : map.entrySet()) {
            map2.put(entry.getKey(), new ArrayList(entry.getValue().values()));
        }
        return map2;
    }

    public static void n(int i) throws Throwable {
        n();
        if (i <= 0) {
            com.byazt.xp.n.delete(com.byazt.nf.rv.getContext(), "hty_show", null, null);
            return;
        }
        long[] jArrQg = qg(i, LongCompanionObject.MAX_VALUE);
        if (jArrQg == null || jArrQg.length == 0) {
            return;
        }
        com.byazt.xp.n.delete(com.byazt.nf.rv.getContext(), "hty_show", "day NOT IN " + qg(jArrQg.length), qg(jArrQg));
    }

    private static long[] qg(int i, long j) throws Throwable {
        Cursor cursor = null;
        try {
            int i2 = 0;
            Cursor cursorQuery = com.byazt.xp.n.query(com.byazt.nf.rv.getContext(), "hty_show", new String[]{a.C0017a.k}, "day<?", new String[]{String.valueOf(j)}, a.C0017a.k, null, "day DESC");
            if (cursorQuery == null) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return null;
            }
            try {
                LinkedHashSet linkedHashSet = new LinkedHashSet(Math.max(i * 2, 8));
                while (cursorQuery.moveToNext() && (!linkedHashSet.add(Long.valueOf(cursorQuery.getLong(0))) || linkedHashSet.size() < i)) {
                }
                long[] jArr = new long[linkedHashSet.size()];
                Iterator it = linkedHashSet.iterator();
                while (it.hasNext()) {
                    int i3 = i2 + 1;
                    jArr[i2] = ((Long) it.next()).longValue();
                    i2 = i3;
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return jArr;
            } catch (Throwable th) {
                th = th;
                cursor = cursorQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static String n(long[] jArr) {
        return "day IN " + qg(jArr.length);
    }

    private static String qg(int i) {
        StringBuilder sb = new StringBuilder((i * 2) + 2);
        sb.append('(');
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(AbstractJsonLexerKt.COMMA);
            }
            sb.append('?');
        }
        sb.append(')');
        return sb.toString();
    }

    private static String[] qg(long[] jArr) {
        String[] strArr = new String[jArr.length];
        for (int i = 0; i < jArr.length; i++) {
            strArr[i] = String.valueOf(jArr[i]);
        }
        return strArr;
    }

    private static void n() {
        com.byazt.xp.n.n(com.byazt.nf.rv.getContext(), "CREATE TABLE IF NOT EXISTS hty_show (day INTEGER,load_component_id TEXT,s_page_name TEXT,s_t_name TEXT,show_id TEXT,show_count INTEGER,update_time INTEGER,PRIMARY KEY(day,load_component_id,s_page_name,s_t_name))", "hty_show");
        Cursor cursorQuery = com.byazt.xp.n.query(com.byazt.nf.rv.getContext(), "hty_show", new String[]{a.C0017a.k}, "1=0", null, null, null, null);
        if (cursorQuery != null) {
            cursorQuery.close();
        }
    }
}
