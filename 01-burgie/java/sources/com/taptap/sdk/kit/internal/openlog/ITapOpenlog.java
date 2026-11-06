package com.taptap.sdk.kit.internal.openlog;

import com.taptap.sdk.db.constant.Common;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: ITapOpenlog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\bH&J&\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\bH&¨\u0006\n"}, d2 = {"Lcom/taptap/sdk/kit/internal/openlog/ITapOpenlog;", "", "reportBusinessLog", "", "customProject", "", "action", Common.Predefined.PROPERTIES, "", "reportTechnicalLog", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface ITapOpenlog {
    void reportBusinessLog(String customProject, String action, Map<String, String> properties);

    void reportTechnicalLog(String action, Map<String, String> properties);

    /* JADX INFO: compiled from: ITapOpenlog.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void reportBusinessLog$default(ITapOpenlog iTapOpenlog, String str, String str2, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportBusinessLog");
            }
            if ((i & 1) != 0) {
                str = "";
            }
            iTapOpenlog.reportBusinessLog(str, str2, map);
        }
    }
}
