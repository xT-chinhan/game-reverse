package com.byazt.ms;

import android.content.Context;
import com.bykv.vk.component.ttvideo.TTVideoEngine;
import com.bykv.vk.component.ttvideo.log.VideoEventEngineUploader;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLLog;
import com.bykv.vk.component.ttvideo.utils.TTVideoEngineLog;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 835, 37})
public class pr {
    public static volatile boolean pr = false;
    public static final AtomicBoolean hw = new AtomicBoolean(false);

    public static void pr(Context context, String str, int i, String[] strArr, long[] jArr, VideoEventEngineUploader videoEventEngineUploader) {
        if (!pr) {
            try {
                TTVideoEngine.setCacheInfoLists(strArr, jArr);
                TTVideoEngine.setStringValue(0, str);
                TTVideoEngine.setIntValue(1, i);
                TTVideoEngine.setIntValue(11, 5);
                TTVideoEngine.setIntValue(2, 10);
                TTVideoEngine.setIntValue(3, 10);
                TTVideoEngine.setIntValue(4, 3);
                TTVideoEngine.setVideoEventUploader(videoEventEngineUploader);
            } catch (Exception e) {
            }
            pr = true;
        }
    }

    public static void pr(boolean z) {
        if (!z) {
            TTVideoEngineLog.turnOn(1, 0);
        } else {
            TTVideoEngineLog.turnOn(1, 1);
            AVMDLLog.turnOn(1, 1);
        }
    }

    public static TTVideoEngine pr(Context context) throws Exception {
        if (!hw.getAndSet(true)) {
            TTVideoEngine.startDataLoader(context);
        }
        TTVideoEngine tTVideoEngine = new TTVideoEngine(context, 0);
        tTVideoEngine.setIntOption(160, 1);
        tTVideoEngine.setIntOption(11, 10);
        tTVideoEngine.setIntOption(12, 10);
        tTVideoEngine.setMaxRetryCount(2);
        tTVideoEngine.setScreenOnWhilePlaying(true);
        return tTVideoEngine;
    }
}
