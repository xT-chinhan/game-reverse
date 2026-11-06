package com.bytedance.pangle.transform;

import androidx.fragment.app.FragmentActivity;
import com.byazt.cp.n;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
public class HostPartUtils {
    public Class fragmentActivityClazz;

    @n(n = {0, 55, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_RENDER_STALL, 2423, 2424})
    private static class SingletonHolder {
        public static final HostPartUtils INSTANCE = new HostPartUtils();

        private SingletonHolder() {
        }
    }

    public HostPartUtils() {
        try {
            this.fragmentActivityClazz = FragmentActivity.class;
        } catch (Throwable unused) {
        }
    }

    public static final Class getFragmentActivityClass() {
        return SingletonHolder.INSTANCE.fragmentActivityClazz;
    }

    public static FragmentActivity getFragmentActivity(Object obj, String str) {
        return (FragmentActivity) ZeusTransformUtils._getActivity(obj, str);
    }
}
