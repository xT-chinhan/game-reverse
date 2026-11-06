package com.byazt.i;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.util.List;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_COST_TIME, 13})
public class w implements com.byazt.m.fs {
    @Override // com.byazt.m.fs
    public com.byazt.m.x n(String str, List<com.byazt.wm.s> list) throws IOException {
        OkHttpClient okHttpClientUm = com.byazt.xv.s.um();
        if (okHttpClientUm == null) {
            throw new IOException("can't get httpClient");
        }
        Request.Builder builderHead = new Request.Builder().url(str).head();
        if (list != null && list.size() > 0) {
            for (com.byazt.wm.s sVar : list) {
                builderHead.addHeader(sVar.n(), com.byazt.ta.w.x(sVar.qg()));
            }
        }
        final Call callNewCall = okHttpClientUm.newCall(builderHead.build());
        final Response responseExecute = callNewCall.execute();
        if (responseExecute == null) {
            throw new IOException("can't get response");
        }
        if (com.byazt.ta.n.n(2097152)) {
            responseExecute.close();
        }
        return new com.byazt.m.x() { // from class: com.byazt.i.w.1
            @Override // com.byazt.m.x
            public String n(String str2) {
                return responseExecute.header(str2);
            }

            @Override // com.byazt.m.x
            public int qg() throws IOException {
                return responseExecute.code();
            }

            @Override // com.byazt.m.x
            public void s() {
                Call call = callNewCall;
                if (call == null || call.isCanceled()) {
                    return;
                }
                callNewCall.cancel();
            }
        };
    }
}
