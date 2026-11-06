package com.byazt.kq;

import android.webkit.JavascriptInterface;
import com.byazt.ee.z;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_INDEX_CACHE, 121})
public class x {
    public WeakReference<z> pr;

    public x(z zVar) {
        this.pr = new WeakReference<>(zVar);
    }

    public void pr(z zVar) {
        this.pr = new WeakReference<>(zVar);
    }

    @JavascriptInterface
    public void invokeMethod(String str) {
        WeakReference<z> weakReference = this.pr;
        if (weakReference != null && weakReference.get() != null) {
            this.pr.get().invokeMethod(str);
        }
    }
}
