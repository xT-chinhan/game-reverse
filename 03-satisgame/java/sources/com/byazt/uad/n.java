package com.byazt.uad;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_NO_BUFFERING_UPDATE, 19})
public final class n {
    public static volatile Handler l;
    public static final Object n = new Object();
    public static final Map<q, String> qg = new WeakHashMap();
    public static final Map<String, Map<q, Set<String>>> s = new HashMap();
    public static final Map<String, LinkedList<C0362n>> q = new HashMap();
    public static volatile boolean w = false;

    private n() {
    }

    public static void n(boolean z) {
        w = z;
    }

    public static void n(String str, q qVar) {
        if (TextUtils.isEmpty(str) || qVar == null) {
            return;
        }
        synchronized (n) {
            Map<q, String> map = qg;
            String str2 = map.get(qVar);
            if (!TextUtils.isEmpty(str2) && !TextUtils.equals(str2, str)) {
                qg(str2, qVar);
            }
            map.put(qVar, str);
            qg(str);
        }
    }

    public static void n(q qVar, String str) {
        String str2;
        if (qVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (n) {
            String str3 = qg.get(qVar);
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            Map<q, Set<String>> mapQg = qg(str3);
            Set<String> hashSet = mapQg.get(qVar);
            if (hashSet == null) {
                hashSet = new HashSet<>();
                mapQg.put(qVar, hashSet);
            }
            hashSet.add(str);
            if (w) {
                LinkedList<C0362n> linkedList = q.get(str3);
                ArrayList<C0362n> arrayList = null;
                if (linkedList == null || linkedList.isEmpty()) {
                    str2 = null;
                } else {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    ArrayList arrayList2 = new ArrayList();
                    for (C0362n c0362n : linkedList) {
                        if (c0362n != null && jUptimeMillis - c0362n.w <= 300000 && TextUtils.equals(c0362n.q, str) && c0362n.n() != qVar) {
                            arrayList2.add(c0362n);
                        }
                    }
                    if (arrayList2.isEmpty()) {
                        str2 = null;
                    } else {
                        str2 = ((C0362n) arrayList2.get(0)).s;
                        arrayList = arrayList2;
                    }
                }
                if (arrayList == null) {
                    return;
                }
                for (C0362n c0362n2 : arrayList) {
                    qVar.n(c0362n2.s != null ? c0362n2.s : str2, c0362n2.q, c0362n2.l);
                }
            }
        }
    }

    public static void qg(q qVar, String str) {
        if (qVar == null) {
            return;
        }
        synchronized (n) {
            String str2 = qg.get(qVar);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            Map<q, Set<String>> map = s.get(str2);
            if (map == null) {
                return;
            }
            if (TextUtils.isEmpty(str)) {
                map.remove(qVar);
                n(str2, map);
                return;
            }
            Set<String> set = map.get(qVar);
            if (set == null) {
                return;
            }
            set.remove(str);
            if (set.isEmpty()) {
                map.remove(qVar);
            }
            n(str2, map);
        }
    }

    public static void n(q qVar, String str, String str2, Object obj) {
        Set set;
        if (qVar == null || TextUtils.isEmpty(str2)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        synchronized (n) {
            String str3 = qg.get(qVar);
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            Map<q, Set<String>> map = s.get(str3);
            if (map != null && !map.isEmpty()) {
                for (Map.Entry entry : new ArrayList(map.entrySet())) {
                    q qVar2 = (q) entry.getKey();
                    if (qVar2 != null && qVar2 != qVar && (set = (Set) entry.getValue()) != null && set.contains(str2)) {
                        arrayList.add(qVar2);
                    }
                }
            }
            if (w) {
                n(str3, n(str3, qVar, str, str2, obj));
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((q) it.next()).n(str, str2, obj);
            }
        }
    }

    public static void n(String str, String str2, String str3, Object obj) {
        Set set;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3) || !w) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        synchronized (n) {
            qg(str);
            Map<q, Set<String>> map = s.get(str);
            if (map != null && !map.isEmpty()) {
                for (Map.Entry entry : new ArrayList(map.entrySet())) {
                    q qVar = (q) entry.getKey();
                    if (qVar != null && (set = (Set) entry.getValue()) != null && set.contains(str3)) {
                        arrayList.add(qVar);
                    }
                }
            }
            n(str, n(str, null, str2, str3, obj));
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((q) it.next()).n(str2, str3, obj);
        }
    }

    public static void n(q qVar) {
        if (qVar == null) {
            return;
        }
        synchronized (n) {
            String strRemove = qg.remove(qVar);
            if (TextUtils.isEmpty(strRemove)) {
                return;
            }
            qg(strRemove, qVar);
        }
    }

    public static void n(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (n) {
            Map<q, Set<String>> mapRemove = s.remove(str);
            if (mapRemove != null && !mapRemove.isEmpty()) {
                Iterator it = new ArrayList(mapRemove.keySet()).iterator();
                while (it.hasNext()) {
                    qg.remove((q) it.next());
                }
            }
            LinkedList<C0362n> linkedListRemove = q.remove(str);
            if (linkedListRemove != null) {
                Iterator<C0362n> it2 = linkedListRemove.iterator();
                while (it2.hasNext()) {
                    n(it2.next());
                }
            }
        }
    }

    private static Map<q, Set<String>> qg(String str) {
        Map<String, Map<q, Set<String>>> map = s;
        Map<q, Set<String>> map2 = map.get(str);
        if (map2 != null) {
            return map2;
        }
        WeakHashMap weakHashMap = new WeakHashMap();
        map.put(str, weakHashMap);
        return weakHashMap;
    }

    private static void qg(String str, q qVar) {
        Map<q, Set<String>> map = s.get(str);
        if (map == null) {
            return;
        }
        map.remove(qVar);
        n(str, map);
    }

    private static void n(String str, Map<q, Set<String>> map) {
        if (map == null || !map.isEmpty()) {
            return;
        }
        s.remove(str);
        LinkedList<C0362n> linkedListRemove = q.remove(str);
        if (linkedListRemove != null) {
            Iterator<C0362n> it = linkedListRemove.iterator();
            while (it.hasNext()) {
                n(it.next());
            }
        }
    }

    private static C0362n n(String str, q qVar, String str2, String str3, Object obj) {
        Map<String, LinkedList<C0362n>> map = q;
        LinkedList<C0362n> linkedList = map.get(str);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            map.put(str, linkedList);
        }
        while (linkedList.size() >= 64) {
            n(linkedList.pollFirst());
        }
        C0362n c0362n = new C0362n(str, qVar, str2, str3, obj, SystemClock.uptimeMillis());
        linkedList.addLast(c0362n);
        return c0362n;
    }

    private static void n(final String str, final C0362n c0362n) {
        Handler handlerS;
        if (c0362n == null || TextUtils.isEmpty(str) || (handlerS = s()) == null) {
            return;
        }
        c0362n.x = new Runnable() { // from class: com.byazt.uad.n.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (n.n) {
                    LinkedList linkedList = (LinkedList) n.q.get(str);
                    if (linkedList == null) {
                        return;
                    }
                    linkedList.remove(c0362n);
                    if (linkedList.isEmpty()) {
                        n.q.remove(str);
                    }
                }
            }
        };
        handlerS.postDelayed(c0362n.x, 300000L);
    }

    private static void n(C0362n c0362n) {
        if (c0362n == null || c0362n.x == null) {
            return;
        }
        Handler handlerS = s();
        if (handlerS != null) {
            handlerS.removeCallbacks(c0362n.x);
        }
        c0362n.x = null;
    }

    private static Handler s() {
        Looper mainLooper;
        if (l == null) {
            synchronized (n.class) {
                if (l == null && (mainLooper = Looper.getMainLooper()) != null) {
                    l = new Handler(mainLooper);
                }
            }
        }
        return l;
    }

    /* JADX INFO: renamed from: com.byazt.uad.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_NO_BUFFERING_UPDATE, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    private static final class C0362n {
        public final Object l;
        public final String n;
        public final String q;
        public final WeakReference<q> qg;
        public final String s;
        public final long w;
        public Runnable x;

        public C0362n(String str, q qVar, String str2, String str3, Object obj, long j) {
            this.n = str;
            this.qg = qVar == null ? null : new WeakReference<>(qVar);
            this.s = str2;
            this.q = str3;
            this.l = obj;
            this.w = j;
        }

        public q n() {
            WeakReference<q> weakReference = this.qg;
            if (weakReference == null) {
                return null;
            }
            return weakReference.get();
        }
    }
}
