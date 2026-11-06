package com.bytedance.sdk.component.sl.xr;

import android.content.Context;
import com.bykv.vk.component.ttvideo.TTVideoEngine;
import com.bykv.vk.component.ttvideo.log.VideoEventEngineUploader;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLLog;
import com.bykv.vk.component.ttvideo.utils.TTVideoEngineLog;
import com.bytedance.sdk.component.utils.sl;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile boolean f1334ms = false;
    private static final AtomicBoolean xr = new AtomicBoolean(false);

    public static void ms(Context context, String str, int i, String[] strArr, long[] jArr, VideoEventEngineUploader videoEventEngineUploader) {
        if (f1334ms) {
            return;
        }
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
            sl.ms(e);
        }
        f1334ms = true;
    }

    public static void ms(boolean z) {
        if (z) {
            TTVideoEngineLog.turnOn(1, 1);
            AVMDLLog.turnOn(1, 1);
        } else {
            TTVideoEngineLog.turnOn(1, 0);
        }
    }

    public static TTVideoEngine ms(Context context) throws Exception {
        if (!xr.getAndSet(true)) {
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
