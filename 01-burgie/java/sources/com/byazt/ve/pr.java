package com.byazt.ve;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.ExitInstallListener;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ALGORITHM, 37})
public class pr implements Function<SparseArray<Object>, Object> {
    public final ExitInstallListener pr;

    public pr(ExitInstallListener exitInstallListener) {
        this.pr = exitInstallListener;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.pr == null) {
            return null;
        }
        switch (com.byazt.ij.hn.pr(sparseArray).hw().intValue(-99999987)) {
            case 223101:
                this.pr.onExitInstall();
            default:
                return null;
        }
    }
}
