package com.byazt.ua;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID, 250})
public final class k {
    public static final int[] pr = new int[2];

    public static void pr(JSONObject jSONObject, View view, int i, boolean z) {
        if (jSONObject == null || view == null) {
            return;
        }
        try {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) parent;
                jSONObject.put("container_class", viewGroup.getClass().getName());
                jSONObject.put("container_width_height", viewGroup.getWidth() + " X " + viewGroup.getHeight());
            }
            int[] iArr = pr;
            int i2 = 0;
            iArr[0] = 0;
            iArr[1] = 0;
            view.getLocationOnScreen(iArr);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("left", iArr[0]);
            jSONObject2.put("top", iArr[1]);
            jSONObject2.put("right", iArr[0] + view.getWidth());
            jSONObject2.put("bottom", iArr[1] + view.getHeight());
            jSONObject.put("screen_rect", jSONObject2.toString());
            StringBuilder sb = new StringBuilder();
            View view2 = view;
            while (view2 != null) {
                int i3 = i2 + 1;
                if (i2 >= i) {
                    break;
                }
                if (sb.length() > 0) {
                    sb.append(" > ");
                }
                sb.append(view2.getClass().getName());
                Object parent2 = view2.getParent();
                view2 = parent2 instanceof View ? (View) parent2 : null;
                i2 = i3;
            }
            if (sb.length() > 0) {
                jSONObject.put("view_tree_path", sb.toString());
                jSONObject.put("view_tree_path_hash", com.byazt.ca.c.hw(sb.toString()));
            } else {
                jSONObject.put("view_tree_path", " ");
                jSONObject.put("view_tree_path_hash", " ");
            }
            if (z) {
                aj.pr(jSONObject, view, i);
            }
        } catch (Throwable th) {
        }
    }
}
