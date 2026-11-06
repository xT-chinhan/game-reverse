package com.byazt.aa;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.CompoundButton;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 668, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public static boolean hw;
    public static Field pr;

    public static Drawable pr(CompoundButton compoundButton) {
        if (Build.VERSION.SDK_INT >= 23) {
            return compoundButton.getButtonDrawable();
        }
        if (!hw) {
            try {
                Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                pr = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            hw = true;
        }
        Field field = pr;
        if (field != null) {
            try {
                return (Drawable) field.get(compoundButton);
            } catch (IllegalAccessException e2) {
                pr = null;
            }
        }
        return null;
    }
}
