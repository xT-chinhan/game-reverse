package com.anythink.core.api;

import android.content.Context;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public abstract class IOfferClickHandler implements Serializable {
    public abstract boolean startDataFetchApp(Context context, w wVar, x xVar, String str);
}
