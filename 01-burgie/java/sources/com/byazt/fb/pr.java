package com.byazt.fb;

import android.content.Context;
import com.byazt.ihe.m;
import com.byazt.ihe.vk;
import com.bykv.vk.component.ttvideo.DataLoaderHelper;
import com.bykv.vk.component.ttvideo.IPreLoaderItemCallBackListener;
import com.bykv.vk.component.ttvideo.PreLoaderItemCallBackInfo;
import com.bykv.vk.component.ttvideo.PreloaderURLItem;
import com.bykv.vk.component.ttvideo.TTVideoEngine;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1206, 37})
public class pr implements vk {
    public static Object c = new Object();
    public static volatile int pr = 0;
    public static volatile int hw = 0;
    public static volatile int hn = 0;
    public static volatile int x = 0;

    /* JADX WARN: Code duplicated, block: B:18:0x0061  */
    @Override // com.byazt.ihe.vk
    public void pr(Context context, final m mVar, final vk.pr prVar) {
        long j;
        int i;
        long jFw = mVar.fw();
        if (!mVar.yb()) {
            j = jFw;
        } else {
            j = 2147483647L;
        }
        DataLoaderHelper.DataLoaderCacheInfo cacheInfoByFilePath = TTVideoEngine.getCacheInfoByFilePath(mVar.fo(), mVar.c());
        Object[] objArr = {"TTMediaPlayer execVideoPreload: sourceType = ", 0, " preloadSize = ", Long.valueOf(j)};
        if (cacheInfoByFilePath != null) {
            if (j == 2147483647L) {
                if (cacheInfoByFilePath.mCacheSizeFromZero >= mVar.nt() || cacheInfoByFilePath.mCacheSizeFromZero >= cacheInfoByFilePath.mMediaSize) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else if (cacheInfoByFilePath.mCacheSizeFromZero >= j) {
                i = 1;
            } else {
                i = 0;
            }
            Object[] objArr2 = {"TTMediaPlayer execVideoPreload: cacheInfo.mCacheSizeFromZero = ", Long.valueOf(cacheInfoByFilePath.mCacheSizeFromZero), " cacheInfo.mMediaSize = ", Long.valueOf(cacheInfoByFilePath.mMediaSize), " sourceType = ", Integer.valueOf(i)};
        } else {
            i = 0;
        }
        mVar.aj(i);
        PreloaderURLItem preloaderURLItem = new PreloaderURLItem(mVar.fo(), null, j, new String[]{mVar.ny()}, mVar.c());
        preloaderURLItem.setCallBackListener(new IPreLoaderItemCallBackListener() { // from class: com.byazt.fb.pr.1
            @Override // com.bykv.vk.component.ttvideo.IPreLoaderItemCallBackListener
            public void preloadItemInfo(PreLoaderItemCallBackInfo preLoaderItemCallBackInfo) {
                synchronized (pr.c) {
                    try {
                        if (preLoaderItemCallBackInfo == null) {
                            return;
                        }
                        int key = preLoaderItemCallBackInfo.getKey();
                        Object[] objArr3 = {"TTMediaPlayer execVideoPreload: callback key =", Integer.valueOf(key), "  fileHash =", mVar.fo()};
                        switch (key) {
                            case 2:
                                vk.pr prVar2 = prVar;
                                if (prVar2 != null) {
                                    prVar2.hw(mVar, preLoaderItemCallBackInfo.getKey());
                                }
                                pr.hw++;
                                break;
                            case 3:
                                vk.pr prVar3 = prVar;
                                if (prVar3 != null) {
                                    prVar3.pr(mVar, preLoaderItemCallBackInfo.getKey(), "error");
                                }
                                pr.hn++;
                                break;
                            case 5:
                                vk.pr prVar4 = prVar;
                                if (prVar4 != null) {
                                    prVar4.pr(mVar, preLoaderItemCallBackInfo.getKey());
                                }
                                pr.x++;
                                break;
                        }
                        Object[] objArr4 = {"preloadItemInfo:  preTime = ", Integer.valueOf(pr.pr), "  callback =", Integer.valueOf(pr.hw + pr.hn + pr.x), "  callback2 =", Integer.valueOf(pr.hw), "  callback3=", Integer.valueOf(pr.hn), "  callback5 =", Integer.valueOf(pr.x)};
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
        Object[] objArr3 = {"TTMediaPlayer execVideoPreload start: fileName = ", mVar.fo(), " url =", mVar.ny(), " isH265=", Boolean.valueOf(mVar.a()), " presize=", Integer.valueOf(mVar.fw()), " path=", mVar.c()};
        synchronized (c) {
            pr++;
        }
        TTVideoEngine.addTask(preloaderURLItem);
        Object[] objArr4 = {"TTMediaPlayer execVideoPreload end: fileName = ", mVar.fo()};
    }
}
