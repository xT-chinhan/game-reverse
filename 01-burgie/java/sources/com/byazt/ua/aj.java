package com.byazt.ua;

import android.view.View;
import android.widget.AbsListView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID, 61})
public final class aj {
    public static boolean c;
    public static Method hn;
    public static volatile Class<?> hw;
    public static volatile Class<?> pr;
    public static boolean x;

    public static void pr(JSONObject jSONObject, View view, int i) {
        if (jSONObject == null || view == null) {
            return;
        }
        int i2 = 0;
        View view2 = view;
        while (view2 != null) {
            int i3 = i2 + 1;
            if (i2 < i) {
                try {
                    String name = view2.getClass().getName();
                    if (pr(view2)) {
                        jSONObject.put("list_component_type", name);
                        jSONObject.put("adapter_position", pr(view2, hw(view2, view)));
                        return;
                    } else if (view2 instanceof AbsListView) {
                        jSONObject.put("list_component_type", name);
                        jSONObject.put("adapter_position", ((AbsListView) view2).getPositionForView(view));
                        return;
                    } else {
                        Object parent = view2.getParent();
                        view2 = parent instanceof View ? (View) parent : null;
                        i2 = i3;
                    }
                } catch (Throwable th) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private static boolean pr(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            Class<?> cls = pr;
            if (cls == null) {
                try {
                    cls = Class.forName("androidx.recyclerview.widget.RecyclerView");
                    pr = cls;
                } catch (Throwable th) {
                }
            }
            if (cls != null && cls.isInstance(obj)) {
                return true;
            }
            Class<?> cls2 = hw;
            if (cls2 == null) {
                try {
                    cls2 = Class.forName("android.support.v7.widget.RecyclerView");
                    hw = cls2;
                } catch (Throwable th2) {
                }
            }
            if (cls2 == null || !cls2.isInstance(obj)) {
                obj.getClass().getMethod("getChildAdapterPosition", View.class);
                return true;
            }
            return true;
        } catch (Throwable th3) {
            return false;
        }
    }

    private static Integer pr(Object obj, View view) {
        if (!x && !c) {
            try {
                try {
                    hn = obj.getClass().getMethod("getChildAdapterPosition", View.class);
                } catch (NoSuchMethodException e) {
                    c = true;
                }
                x = true;
            } catch (Throwable th) {
                x = true;
                throw th;
            }
        }
        Method method = hn;
        if (method == null || c) {
            return null;
        }
        try {
            Object objInvoke = method.invoke(obj, view);
            if (objInvoke instanceof Integer) {
                return (Integer) objInvoke;
            }
        } catch (Throwable th2) {
            c = true;
            hn = null;
        }
        return null;
    }

    private static View hw(Object obj, View view) {
        if (obj == null || view == null) {
            return view;
        }
        View view2 = view;
        while (view2 != null) {
            Object parent = view2.getParent();
            if (parent == obj) {
                return view2;
            }
            view2 = parent instanceof View ? (View) parent : null;
        }
        return view;
    }
}
