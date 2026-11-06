package com.taptap.sdk.login.impl.data.model;

import com.taptap.sdk.initializer.api.model.RegionType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: Actions.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/taptap/sdk/login/impl/data/model/Actions;", "", "(Ljava/lang/String;I)V", "action", "", "getAction", "()Ljava/lang/String;", "regionType", "Lcom/taptap/sdk/initializer/api/model/RegionType;", "getRegionType", "()Lcom/taptap/sdk/initializer/api/model/RegionType;", "CN", "GLOBAL", "Companion", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public enum Actions {
    CN { // from class: com.taptap.sdk.login.impl.data.model.Actions.CN
        @Override // com.taptap.sdk.login.impl.data.model.Actions
        public String getAction() {
            return "com.taptap.sdk.action";
        }

        @Override // com.taptap.sdk.login.impl.data.model.Actions
        public RegionType getRegionType() {
            return RegionType.CN;
        }
    },
    GLOBAL { // from class: com.taptap.sdk.login.impl.data.model.Actions.GLOBAL
        @Override // com.taptap.sdk.login.impl.data.model.Actions
        public String getAction() {
            return "com.taptap.global.sdk.action";
        }

        @Override // com.taptap.sdk.login.impl.data.model.Actions
        public RegionType getRegionType() {
            return RegionType.GLOBAL;
        }
    };


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* synthetic */ Actions(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String getAction();

    public abstract RegionType getRegionType();

    /* JADX INFO: compiled from: Actions.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/taptap/sdk/login/impl/data/model/Actions$Companion;", "", "()V", "from", "Lcom/taptap/sdk/login/impl/data/model/Actions;", "regionType", "Lcom/taptap/sdk/initializer/api/model/RegionType;", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Actions from(RegionType regionType) {
            Intrinsics.checkNotNullParameter(regionType, "regionType");
            Actions[] actionsArrValues = Actions.values();
            int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(actionsArrValues.length), 16);
            Map destination$iv$iv = new LinkedHashMap(capacity$iv);
            for (Actions actions : actionsArrValues) {
                destination$iv$iv.put(actions.getRegionType(), actions);
            }
            Object obj = destination$iv$iv.get(regionType);
            if (obj != null) {
                return (Actions) obj;
            }
            throw new IllegalStateException(("No matching action for region type: " + regionType).toString());
        }
    }
}
