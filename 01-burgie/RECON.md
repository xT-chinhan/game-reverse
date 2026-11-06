# 01 — Burgie (伯吉的温馨厨房)  `com.hnyg.bjdwxcf.topon` v1.0.4

## Engine
**Unity IL2CPP v31 KHÔNG mã hoá**. arm64-v8a + armeabi-v7a. Game nấu ăn/quán burger.
- SDK: **MARSDK** (nền tảng 火星云 Martian) lo đăng nhập/thanh toán/quảng cáo; TapTap 4.10.9, Umeng, Dirichlet Ad (Pangle/GDT/iQiyi). Ký APK v1.

## Dump (REA inspect_il2cpp_metadata)
- 61 assembly, 10.449 type, 82.853 method (74.688 RVA), 14.497 string literal.
- `evidence.json`. `out/`: `dump.cs`, `Assembly-CSharp.cs` (572 class game), `script.json` (RVA→tên), `strings.txt`.
- Java (jadx): `java/sources/` (10.049 class). Config SDK: `java/resources/assets/mar_developer_config.properties`.

## Kinh tế game (client-side, đã decompile Kuna)
- `UnlockableSystem`: `AddCoins`@`0x16d34f4`, `SustractCoins`@`0x16d2bb0`, `IsUnlocked`@`0x16d31bc`, `HasUnlockedEverything`@`0x16d3864`. Coin = int trong RAM (field 0x40). Mốc achievement ở 1000/2000/5000 coin.
- `SaveManager` + `SaveLoadFile` (`Serialize/TryDeserialize`@`0x16b4828`), `EncryptionKeys` (getter `localEncryptionKey`/`webEncryptionKey`).
- `AdRewardSystem` (coupon xem quảng cáo), `CDKCanvas` (nhập mã CDK).
- Thanh toán `MARProxy.getOrder/parseOrderResult` → server MARSDK (IAP server-side, không bẻ).

## Việt hóa
Có `LanguageManager` + `Translation` + `Languages`. Chưa xác nhận có sẵn tiếng Việt (khác 03/05). Text trong il2cpp string literals / TextAsset. Kiểm `LanguageManager` để biết nguồn chữ + font.

## Sửa nội dung = Cách 1 (patch .so) — xem `NOTE-cach1-patch.md`
Patch tĩnh `libil2cpp.so` tại RVA (chặn trừ coin / ép unlock) rồi repack + ký lại. Không cần Android.

## Trạng thái
Reverse sâu xong (game đầu tiên, làm mẫu). Đã chốt Cách 1, chưa patch.
