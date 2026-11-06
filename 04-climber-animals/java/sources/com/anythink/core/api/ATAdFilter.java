package com.anythink.core.api;

import android.util.Log;
import android.util.Pair;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.ca;
import com.anythink.core.common.v.ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/* JADX INFO: loaded from: classes.dex */
public abstract class ATAdFilter {
    private static final String KEY_BIDDING_TYPE = "biddingType";
    private static final String KEY_E_CPM = "e_cpm";
    private static final String KEY_NETWORK_ID = "networkId";
    private static final String KEY_NETWORK_PLACEMENT_ID = "networkPlacementId";
    private static final String TAG = "anythink_ad_filter";
    private final Stack<Map<String, Object>> stack = new Stack<>();

    interface b {
        Pair<Boolean, AdError> filter(Map<String, Object> map, ca caVar);
    }

    public ATAdFilter filterNetworkIds(List<String> list) {
        return filter(KEY_NETWORK_ID, list);
    }

    public ATAdFilter filterNetworkPlacementIds(List<String> list) {
        return filter(KEY_NETWORK_PLACEMENT_ID, list);
    }

    public ATAdFilter filterBidTypes(List<String> list) {
        return filter(KEY_BIDDING_TYPE, list);
    }

    public ATAdFilter filterAdPrice(ATWaterfallFilter.PriceInterval priceInterval) {
        return filter(KEY_E_CPM, priceInterval);
    }

    private synchronized ATAdFilter filter(String str, Object obj) {
        Map<String, Object> mapPop = !this.stack.isEmpty() ? this.stack.pop() : null;
        if (mapPop == null) {
            mapPop = new HashMap<>();
        }
        mapPop.put(str, obj);
        this.stack.push(mapPop);
        return this;
    }

    public synchronized ATAdFilter orFilter() {
        this.stack.push(new HashMap());
        return this;
    }

    public final AdError doFilter(ca caVar) {
        if (caVar == null) {
            return null;
        }
        try {
            if (this.stack.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList(this.stack);
            for (int i = 0; i < arrayList.size(); i++) {
                Map map = (Map) arrayList.get(i);
                if (map == null || map.isEmpty()) {
                    if (t.b().F()) {
                        Log.e(TAG, "doFilter start filterData useless filterCondition" + i + ":" + caVar);
                    }
                } else if (caVar.c == 1 && map.containsKey(KEY_E_CPM)) {
                    if (t.b().F()) {
                        Log.e(TAG, "doFilter start filterData continue:" + i + ":" + caVar);
                    }
                } else {
                    ab.b(TAG, "doFilter start filterData:" + i + ":" + caVar);
                    AdError adErrorFilter = new a(map, caVar).filter();
                    if (adErrorFilter != null) {
                        if (t.b().F()) {
                            Log.e(TAG, "doFilter  filter reason:".concat(String.valueOf(adErrorFilter)));
                        }
                        return adErrorFilter;
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    static class a {
        Map<String, Object> filterCondition;
        ca filterData;
        List<b> list;

        public a(Map<String, Object> map, ca caVar) {
            this.filterCondition = map;
            this.filterData = caVar;
            ArrayList arrayList = new ArrayList();
            this.list = arrayList;
            arrayList.add(new e());
            this.list.add(new d());
            this.list.add(new f());
            this.list.add(new c());
        }

        public final AdError filter() {
            ArrayList arrayList = new ArrayList();
            List<b> list = this.list;
            if (list == null || list.isEmpty()) {
                return null;
            }
            Iterator<b> it = this.list.iterator();
            int i = 0;
            while (it.hasNext()) {
                Pair<Boolean, AdError> pairFilter = it.next().filter(this.filterCondition, this.filterData);
                if (pairFilter != null && pairFilter.first != null && ((Boolean) pairFilter.first).booleanValue()) {
                    i++;
                    if (pairFilter.second != null) {
                        arrayList.add((AdError) pairFilter.second);
                    }
                }
            }
            if (arrayList.isEmpty() || arrayList.size() != i) {
                return null;
            }
            return (AdError) arrayList.get(arrayList.size() - 1);
        }
    }

    static class e implements b {
        e() {
        }

        @Override // com.anythink.core.api.ATAdFilter.b
        public final Pair<Boolean, AdError> filter(Map<String, Object> map, ca caVar) {
            try {
                Object obj = map.get(ATAdFilter.KEY_NETWORK_ID);
                if (obj != null && caVar != null && (obj instanceof List)) {
                    List list = (List) obj;
                    if (!list.isEmpty()) {
                        if (list.contains(caVar.a)) {
                            return new Pair<>(Boolean.TRUE, ErrorCode.getErrorCode(ErrorCode.networkFirmIdFilterSourceError, "", "Filter by network firm id."));
                        }
                        return new Pair<>(Boolean.TRUE, null);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new Pair<>(Boolean.FALSE, null);
        }
    }

    static class d implements b {
        d() {
        }

        @Override // com.anythink.core.api.ATAdFilter.b
        public final Pair<Boolean, AdError> filter(Map<String, Object> map, ca caVar) {
            try {
                Object obj = map.get(ATAdFilter.KEY_BIDDING_TYPE);
                if (obj != null && caVar != null && (obj instanceof List)) {
                    List list = (List) obj;
                    if (!list.isEmpty()) {
                        if (list.contains(caVar.b())) {
                            return new Pair<>(Boolean.TRUE, ErrorCode.getErrorCode(ErrorCode.adSourceLoadBidTypeFilterError, "", "Filter by bid type."));
                        }
                        return new Pair<>(Boolean.TRUE, null);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new Pair<>(Boolean.FALSE, null);
        }
    }

    static class f implements b {
        f() {
        }

        @Override // com.anythink.core.api.ATAdFilter.b
        public final Pair<Boolean, AdError> filter(Map<String, Object> map, ca caVar) {
            ATWaterfallFilter.PriceInterval priceInterval;
            ATAdConst.CURRENCY scurrency;
            double rmbChangeToUsdRate;
            try {
                Object obj = map.get(ATAdFilter.KEY_E_CPM);
                if (obj != null && caVar != null && (obj instanceof ATWaterfallFilter.PriceInterval) && (scurrency = (priceInterval = (ATWaterfallFilter.PriceInterval) obj).getScurrency()) != null) {
                    if (scurrency == ATAdConst.CURRENCY.RMB) {
                        rmbChangeToUsdRate = ATSDKUtils.getRmbChangeToUsdRate();
                    } else {
                        rmbChangeToUsdRate = scurrency == ATAdConst.CURRENCY.RMB_CENT ? ATSDKUtils.getRmbChangeToUsdRate() * 100.0d : 1.0d;
                    }
                    ab.b(ATAdFilter.TAG, "filter price coefficient:".concat(String.valueOf(rmbChangeToUsdRate)));
                    if (rmbChangeToUsdRate != 0.0d) {
                        if (priceInterval.getMorePrice() != null && priceInterval.getLessPrice() != null) {
                            ab.b(ATAdFilter.TAG, "filter price getMorePrice:" + (priceInterval.getMorePrice().doubleValue() * rmbChangeToUsdRate));
                            ab.b(ATAdFilter.TAG, "filter price getLessPrice:" + (priceInterval.getLessPrice().doubleValue() * rmbChangeToUsdRate));
                            ab.b(ATAdFilter.TAG, "filter price getPrice:" + caVar.a());
                            if (priceInterval.getMorePrice().doubleValue() == priceInterval.getLessPrice().doubleValue()) {
                                if (caVar.a() == priceInterval.getMorePrice().doubleValue() * rmbChangeToUsdRate) {
                                    return new Pair<>(Boolean.TRUE, ErrorCode.getErrorCode(ErrorCode.adSourceLoadPriceFilterError, "", "Filter by bid price."));
                                }
                                return new Pair<>(Boolean.TRUE, null);
                            }
                            if (priceInterval.getLessPrice().doubleValue() <= priceInterval.getMorePrice().doubleValue()) {
                                if (t.b().F()) {
                                    Log.e(ATAdFilter.TAG, "filter price min and max is exception:" + priceInterval.getLessPrice() + ":" + priceInterval.getMorePrice());
                                }
                                return new Pair<>(Boolean.TRUE, null);
                            }
                            if (caVar.a() >= priceInterval.getMorePrice().doubleValue() * rmbChangeToUsdRate && caVar.a() <= priceInterval.getLessPrice().doubleValue() * rmbChangeToUsdRate) {
                                return new Pair<>(Boolean.TRUE, ErrorCode.getErrorCode(ErrorCode.adSourceLoadPriceFilterError, "", "Filter by bid price."));
                            }
                            return new Pair<>(Boolean.TRUE, null);
                        }
                        if (priceInterval.getMorePrice() != null) {
                            ab.b(ATAdFilter.TAG, "filter price getMorePrice:" + (priceInterval.getMorePrice().doubleValue() * rmbChangeToUsdRate));
                            ab.b(ATAdFilter.TAG, "filter price getPrice:" + caVar.a());
                            if (caVar.a() >= priceInterval.getMorePrice().doubleValue() * rmbChangeToUsdRate) {
                                return new Pair<>(Boolean.TRUE, ErrorCode.getErrorCode(ErrorCode.adSourceLoadPriceFilterError, "", "Filter by bid price."));
                            }
                            return new Pair<>(Boolean.TRUE, null);
                        }
                        if (priceInterval.getLessPrice() != null) {
                            ab.b(ATAdFilter.TAG, "filter price getLessPrice:" + (priceInterval.getLessPrice().doubleValue() * rmbChangeToUsdRate));
                            ab.b(ATAdFilter.TAG, "filter price getPrice:" + caVar.a());
                            if (caVar.a() > 0.0d && caVar.a() <= priceInterval.getLessPrice().doubleValue() * rmbChangeToUsdRate) {
                                return new Pair<>(Boolean.TRUE, ErrorCode.getErrorCode(ErrorCode.adSourceLoadPriceFilterError, "", "Filter by bid price."));
                            }
                            return new Pair<>(Boolean.TRUE, null);
                        }
                    } else if (t.b().F()) {
                        Log.e(ATAdFilter.TAG, "filter price coefficient is exception:".concat(String.valueOf(rmbChangeToUsdRate)));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new Pair<>(Boolean.FALSE, null);
        }
    }

    static class c implements b {
        c() {
        }

        @Override // com.anythink.core.api.ATAdFilter.b
        public final Pair<Boolean, AdError> filter(Map<String, Object> map, ca caVar) {
            try {
                Object obj = map.get(ATAdFilter.KEY_NETWORK_PLACEMENT_ID);
                if (obj != null && caVar != null && (obj instanceof List)) {
                    List list = (List) obj;
                    if (!list.isEmpty()) {
                        if (list.contains(caVar.b)) {
                            return new Pair<>(Boolean.TRUE, ErrorCode.getErrorCode(ErrorCode.adSourceLoadUnitFilterError, "", "Filter by network adUnitId."));
                        }
                        return new Pair<>(Boolean.TRUE, null);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new Pair<>(Boolean.FALSE, null);
        }
    }
}
