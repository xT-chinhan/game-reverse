package com.byazt.ca;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ANSWER_RECV_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ALGORITHM})
public class ve {
    public static final HashMap<Class<?>, Class<?>> hn;
    public static Map<String, Method> hw = new HashMap();
    public static final Class<?>[] pr;

    static {
        HashMap<Class<?>, Class<?>> map = new HashMap<>();
        hn = map;
        map.put(Boolean.TYPE, Boolean.class);
        map.put(Byte.TYPE, Byte.class);
        map.put(Character.TYPE, Character.class);
        map.put(Short.TYPE, Short.class);
        map.put(Integer.TYPE, Integer.class);
        map.put(Long.TYPE, Long.class);
        map.put(Double.TYPE, Double.class);
        map.put(Float.TYPE, Float.class);
        map.put(Void.TYPE, Void.class);
        pr = new Class[0];
    }

    public static int pr(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
