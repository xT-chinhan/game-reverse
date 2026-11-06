package com.tapsdk.tapad.e;

import com.tapsdk.tapad.constants.Constants;
import com.tapsdk.tapad.internal.network.ResponseBean;
import com.tapsdk.tapad.model.entities.ApkInfoDetails;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    class a implements Function<ResponseBean<com.tapsdk.tapad.model.entities.a>, ApkInfoDetails> {
        a() {
        }

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ApkInfoDetails apply(ResponseBean<com.tapsdk.tapad.model.entities.a> responseBean) throws Exception {
            com.tapsdk.tapad.model.entities.a aVar = responseBean.data;
            if (aVar != null) {
                return aVar.b;
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: com.tapsdk.tapad.e.b$b, reason: collision with other inner class name */
    class C0588b extends com.tapsdk.tapad.internal.network.c.c<ResponseBean<com.tapsdk.tapad.model.entities.a>> {
        C0588b() {
        }
    }

    public Observable<ApkInfoDetails> a(String str) {
        return com.tapsdk.tapad.a.a().a(Constants.b.b).b(new C0588b(), str).map(new a());
    }
}
