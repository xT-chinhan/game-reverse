package com.tapsdk.tapad.e;

import com.tapsdk.tapad.internal.utils.TapADLogger;
import com.tapsdk.tapad.internal.utils.q;
import com.tapsdk.tapad.internal.utils.u;
import com.tapsdk.tapad.model.entities.AdInfo;
import com.tapsdk.tapad.model.entities.MaterialInfo;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Function;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes3.dex */
public class n {
    private static final double a = 1.048576E8d;

    class a implements Function<String, AdInfo> {
        final /* synthetic */ AdInfo a;

        a(AdInfo adInfo) {
            this.a = adInfo;
        }

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdInfo apply(String str) throws Exception {
            AdInfo adInfo = this.a;
            adInfo.cachedVideoUri = str;
            return adInfo;
        }
    }

    class b implements ObservableOnSubscribe<String> {
        final /* synthetic */ AdInfo a;

        b(AdInfo adInfo) {
            this.a = adInfo;
        }

        /* JADX WARN: Code duplicated, block: B:49:0x010c A[Catch: all -> 0x011e, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x011e, blocks: (B:19:0x0092, B:49:0x010c, B:59:0x011d, B:58:0x011a, B:20:0x009a, B:22:0x00a0, B:24:0x00a6, B:26:0x00b0, B:34:0x00c1, B:47:0x0107, B:37:0x00d7, B:38:0x00e4, B:46:0x0104, B:39:0x00e8, B:41:0x00f1, B:44:0x00f8, B:52:0x0111, B:55:0x0115), top: B:75:0x0092, inners: #0, #1, #3 }] */
        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
            String str;
            TapADLogger.d("CacheVideo Begin to cache video");
            MaterialInfo materialInfo = this.a.materialInfo;
            if (materialInfo == null || materialInfo.materialType == 1 || materialInfo.videoInfoList.size() == 0) {
                observableEmitter.onNext("");
            } else {
                String str2 = this.a.materialInfo.videoInfoList.get(0).videoUrl;
                String strA = u.a(str2);
                TapADLogger.d("CacheVideo  cache file name:" + strA);
                if (strA.contains("mp4")) {
                    String strB = q.b(str2);
                    String strA2 = com.tapsdk.tapad.internal.i.c.a(strB, strA);
                    TapADLogger.e("CacheVideo check cache exists result:" + strA2);
                    if (strA2.length() <= 0) {
                        try {
                            Response responseExecute = new OkHttpClient.Builder().build().newCall(new Request.Builder().url(str2).build()).execute();
                            try {
                                try {
                                    if (!responseExecute.isSuccessful() || responseExecute.body() == null) {
                                        str = "CacheVideo failed to download file:";
                                    } else {
                                        String strHeader = responseExecute.header("Content-Length");
                                        double d = strHeader != null ? Double.parseDouble(strHeader) : 0.0d;
                                        if (d > 0.0d && d <= n.a) {
                                            try {
                                                String strA3 = com.tapsdk.tapad.internal.i.c.a(responseExecute.body().bytes(), strB, strA);
                                                TapADLogger.e("CacheVideo Cache success");
                                                observableEmitter.onNext(strA3);
                                            } catch (IOException e) {
                                                str = "CacheVideo Cache fail " + e;
                                                TapADLogger.e(str);
                                                observableEmitter.onNext("");
                                            }
                                            observableEmitter.onComplete();
                                            if (responseExecute != null) {
                                                responseExecute.close();
                                            }
                                            return;
                                        }
                                        str = "CacheVideo fail content length is " + (d == 0.0d ? 0 : "too large");
                                    }
                                    TapADLogger.e(str);
                                    observableEmitter.onNext("");
                                    observableEmitter.onComplete();
                                    if (responseExecute != null) {
                                        responseExecute.close();
                                    }
                                } catch (Throwable th) {
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        if (responseExecute != null) {
                                            try {
                                                responseExecute.close();
                                            } catch (Throwable th3) {
                                                th.addSuppressed(th3);
                                            }
                                        }
                                        throw th2;
                                    }
                                }
                            } finally {
                                observableEmitter.onNext("");
                                observableEmitter.onComplete();
                            }
                        } catch (Throwable unused) {
                            observableEmitter.onNext("");
                            observableEmitter.onComplete();
                        }
                        return;
                    }
                    observableEmitter.onNext(strA2);
                } else {
                    TapADLogger.e("CacheVideo Cache fail This File doesn't support cache");
                    observableEmitter.onNext("");
                }
            }
            observableEmitter.onComplete();
        }
    }

    public Observable<AdInfo> a(AdInfo adInfo) {
        return Observable.create(new b(adInfo)).map(new a(adInfo));
    }
}
