package com.byazt.ts;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.util.List;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, 5})
public class uc implements com.byazt.edb.zo {
    @Override // com.byazt.edb.zo
    public com.byazt.edb.fw pr(String str, List<com.byazt.auw.hn> list) throws IOException {
        OkHttpClient okHttpClientQa = com.byazt.lj.hn.qa();
        if (okHttpClientQa == null) {
            throw new IOException("can't get httpClient");
        }
        Request.Builder builderHead = new Request.Builder().url(str).head();
        if (list != null && list.size() > 0) {
            for (com.byazt.auw.hn hnVar : list) {
                builderHead.addHeader(hnVar.pr(), com.byazt.tuy.uc.fw(hnVar.hw()));
            }
        }
        final Call callNewCall = okHttpClientQa.newCall(builderHead.build());
        final Response responseExecute = callNewCall.execute();
        if (responseExecute == null) {
            throw new IOException("can't get response");
        }
        if (com.byazt.tuy.pr.pr(2097152)) {
            responseExecute.close();
        }
        return new com.byazt.edb.fw() { // from class: com.byazt.ts.uc.1
            @Override // com.byazt.edb.fw
            public String pr(String str2) {
                return responseExecute.header(str2);
            }

            @Override // com.byazt.edb.fw
            public int hw() throws IOException {
                return responseExecute.code();
            }

            @Override // com.byazt.edb.fw
            public void hn() {
                Call call = callNewCall;
                if (call != null && !call.isCanceled()) {
                    callNewCall.cancel();
                }
            }
        };
    }
}
