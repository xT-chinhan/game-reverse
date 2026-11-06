package com.byazt.wt;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapsdk.tapad.group.constants.Constants;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT})
public final class n {
    public static final ConcurrentHashMap<ViewGroup, Object> pr = new ConcurrentHashMap<>();
    public static final Object hw = new Object();
    public static volatile boolean hn = false;

    private n() {
    }

    public static void pr(WeakReference<ViewGroup> weakReference, com.byazt.az.hn hnVar) {
        if (weakReference == null || hnVar == null) {
            return;
        }
        ViewGroup viewGroup = weakReference.get();
        if (!com.byazt.sd.ww.pr(viewGroup)) {
            pr(viewGroup, false);
            return;
        }
        pr.put(viewGroup, hnVar);
        if (hn) {
            pr(viewGroup, false);
            return;
        }
        synchronized (n.class) {
            if (hn) {
                pr(viewGroup, false);
            } else {
                hn = true;
                com.byazt.sd.lb.uc().postDelayed(new Runnable() { // from class: com.byazt.wt.n.1
                    @Override // java.lang.Runnable
                    public void run() {
                        n.hn();
                    }
                }, 50L);
            }
        }
    }

    public static boolean pr(View view) {
        if (view == null) {
            return false;
        }
        Object tag = view.getTag(2114387349);
        if (tag instanceof Map) {
            Object obj = ((Map) tag).get("is_shake_efficient");
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
        }
        return false;
    }

    private static void pr(ViewGroup viewGroup, boolean z) {
        if (viewGroup == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("is_shake_efficient", Boolean.valueOf(z));
        Object tag = viewGroup.getTag(2114387349);
        if (tag != null) {
            try {
                if (!(tag instanceof HashMap)) {
                    return;
                }
            } catch (Throwable th) {
                com.byazt.ca.ho.hw("TTShakeChecker", th.getMessage());
                pr(2114387349, th.getMessage());
                return;
            }
        }
        viewGroup.setTag(2114387349, map);
    }

    public static void pr(final int i, final String str) {
        com.byazt.xk.hw.pr().pr("stats_shake_tag_key", new com.byazt.ttf.pr() { // from class: com.byazt.wt.n.2
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("shake_tag", i);
                    jSONObject2.put(Constants.ERROR_MSG_FIELD, str);
                } catch (Throwable th) {
                }
                return jSONObject2;
            }
        });
    }

    public static void pr(WeakReference<ViewGroup> weakReference, float f, float f2, long j) {
        if (weakReference == null) {
            return;
        }
        ViewGroup viewGroup = weakReference.get();
        if (!com.byazt.sd.ww.pr(viewGroup) || !pr(f, f2, j)) {
            return;
        }
        pr.put(viewGroup, hw);
        if (hn) {
            return;
        }
        synchronized (n.class) {
            if (hn) {
                return;
            }
            hn = true;
            com.byazt.sd.lb.uc().postDelayed(new Runnable() { // from class: com.byazt.wt.n.3
                @Override // java.lang.Runnable
                public void run() {
                    n.x();
                }
            }, 50L);
        }
    }

    private static boolean pr(float f, float f2, long j) {
        if (f == -1.0f) {
            return true;
        }
        if (f < 0.0f) {
            return false;
        }
        if (f == 0.0f && f2 == 2.1474836E9f) {
            return true;
        }
        if (f2 <= f) {
            return false;
        }
        float fCurrentTimeMillis = (System.currentTimeMillis() - j) / 1000.0f;
        return fCurrentTimeMillis >= f && fCurrentTimeMillis <= f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:42:0x009d  */
    public static void hn() {
        int i;
        int i2;
        ConcurrentHashMap<ViewGroup, Object> concurrentHashMap = pr;
        if (concurrentHashMap.isEmpty()) {
            return;
        }
        int iUc = er.uc(com.byazt.sd.a.getContext());
        int i3 = Integer.MAX_VALUE;
        ViewGroup viewGroup = null;
        ViewGroup viewGroup2 = null;
        for (ViewGroup viewGroup3 : concurrentHashMap.keySet()) {
            if (viewGroup3 != null) {
                Rect rect = new Rect();
                if (!viewGroup3.getGlobalVisibleRect(rect)) {
                    pr.remove(viewGroup3);
                } else if (!com.byazt.sd.ww.pr(viewGroup3)) {
                    pr.remove(viewGroup3);
                } else {
                    int i4 = iUc / 2;
                    if (rect.bottom > i4) {
                        i = Integer.MAX_VALUE;
                    } else {
                        i = i4 - rect.bottom;
                    }
                    if (rect.top < i4) {
                        i2 = Integer.MAX_VALUE;
                    } else {
                        i2 = rect.top - i4;
                    }
                    if (rect.bottom > i4 && rect.top < i4) {
                        viewGroup = viewGroup3;
                        break;
                    }
                    int iMin = Math.min(i2, i);
                    if (iMin < i3) {
                        viewGroup = viewGroup3;
                        i3 = iMin;
                    } else if (iMin == i3) {
                        viewGroup2 = viewGroup3;
                    }
                }
            }
        }
        if (viewGroup == null) {
            return;
        }
        if (viewGroup2 != null) {
            Rect rect2 = new Rect();
            viewGroup.getGlobalVisibleRect(rect2);
            Rect rect3 = new Rect();
            viewGroup2.getGlobalVisibleRect(rect3);
            if (rect2.top >= rect3.top) {
                viewGroup2 = viewGroup;
            }
        } else {
            viewGroup2 = viewGroup;
        }
        ConcurrentHashMap<ViewGroup, Object> concurrentHashMap2 = pr;
        com.byazt.az.hn hnVar = concurrentHashMap2.get(viewGroup2) instanceof com.byazt.az.hn ? (com.byazt.az.hn) concurrentHashMap2.get(viewGroup2) : null;
        pr(viewGroup2, true);
        concurrentHashMap2.clear();
        hn = false;
        if (hnVar != null) {
            hnVar.pr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:41:0x009d  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c5  */
    public static void x() {
        com.byazt.az.pr prVar;
        int i;
        int i2;
        ConcurrentHashMap<ViewGroup, Object> concurrentHashMap = pr;
        if (concurrentHashMap.isEmpty()) {
            return;
        }
        int iUc = er.uc(com.byazt.sd.a.getContext());
        int i3 = Integer.MAX_VALUE;
        ViewGroup viewGroup = null;
        ViewGroup viewGroup2 = null;
        for (ViewGroup viewGroup3 : concurrentHashMap.keySet()) {
            if (viewGroup3 != null) {
                Rect rect = new Rect();
                if (!viewGroup3.getGlobalVisibleRect(rect)) {
                    pr.remove(viewGroup3);
                } else if (!com.byazt.sd.ww.pr(viewGroup3)) {
                    pr.remove(viewGroup3);
                } else {
                    int i4 = iUc / 2;
                    if (rect.bottom > i4) {
                        i = Integer.MAX_VALUE;
                    } else {
                        i = i4 - rect.bottom;
                    }
                    if (rect.top < i4) {
                        i2 = Integer.MAX_VALUE;
                    } else {
                        i2 = rect.top - i4;
                    }
                    if (rect.bottom > i4 && rect.top < i4) {
                        viewGroup = viewGroup3;
                        break;
                    }
                    int iMin = Math.min(i2, i);
                    if (iMin < i3) {
                        viewGroup = viewGroup3;
                        i3 = iMin;
                    } else if (iMin == i3) {
                        viewGroup2 = viewGroup3;
                    }
                }
            }
        }
        if (viewGroup == null) {
            return;
        }
        if (viewGroup2 != null) {
            Rect rect2 = new Rect();
            viewGroup.getGlobalVisibleRect(rect2);
            Rect rect3 = new Rect();
            viewGroup2.getGlobalVisibleRect(rect3);
            if (rect2.top >= rect3.top) {
                viewGroup2 = viewGroup;
            }
        } else {
            viewGroup2 = viewGroup;
        }
        for (int i5 = 0; i5 < viewGroup2.getChildCount(); i5++) {
            Object tag = viewGroup2.getChildAt(i5).getTag(2114387349);
            if (tag instanceof Map) {
                Object obj = ((Map) tag).get("click_listener");
                if (obj instanceof com.byazt.az.pr) {
                    prVar = (com.byazt.az.pr) obj;
                } else {
                    prVar = null;
                }
            } else {
                prVar = null;
            }
            if (prVar != null) {
                HashMap map = new HashMap();
                map.put("click_type", 2);
                com.byazt.yx.pr prVar2 = (com.byazt.yx.pr) prVar.pr(com.byazt.yx.pr.class);
                prVar2.pr(map);
                prVar2.pr();
                prVar.onClick(viewGroup2);
                break;
            }
        }
        pr.clear();
        hn = false;
    }
}
