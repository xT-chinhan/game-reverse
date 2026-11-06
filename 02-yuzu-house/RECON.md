# 02 — Yuzu House (柚松屋)  `com.yuzuhouse.test` v2.175.0

## Engine / loại game
**KHÔNG phải Unity.** Đây là app **HTML5 / JavaScript** chạy trong WebView Android (một con pet/avatar ảo + dress-up). Toàn bộ game nằm trong 1 file `assets/index.html` (42MB).
- `classes.dex` chỉ 56KB = lớp vỏ WebView + cầu nối native `YuzuAndroid` (float pet lên màn hình, camera/mic, "live" mode).
- `assets/android-bridge.js` = cầu JS↔Android (`CottonPetHost`, `CottonMultiplePets`, `YuzuAndroid.floatPet/resizePet/configurePetGroup`).
- Ký APK: tên signer YUZUTEST (v1).

## Cấu trúc index.html (42MB)
- 37 thẻ `<script>`, 22 khối có nội dung → tách sẵn ra `js/block_*.js`.
- 2 bundle chính: `block_06.js` (18.6MB) + `block_16.js` (18.3MB) — minified, build bằng bundler (Vite/esbuild style; có polyfill `define`/`structuredClone`).
- **47% file là ảnh base64 nhúng** (602 ảnh `data:image`) + 1 font `data:font`.
- `translate(` trong code là phép biến đổi canvas/ma trận, **KHÔNG phải i18n**. → Game **không có hệ thống đa ngôn ngữ**; chữ Trung là **literal nằm thẳng trong JS**.

## Reverse bằng REA
- `analyze_javascript_application` trên thư mục `js/`: parse 22 file, 90.001 AST node, dựng semantic graph (call-flow 6.166, data-flow 33.740, object-flow…). Evidence: `evidence.json` (90MB, 2 record).
- Truy vấn sâu hơn: `inspect_analysis_view` với `parent_evidence_id` trong evidence.json (kind javascript / javascript-routes).

## Việt hóa — cách làm
Text tiếng Trung là chuỗi literal rải trong các `block_*.js`. Đã trích sẵn:
- `out/cn-strings.txt` — 2.321 cụm CJK (kèm số lần xuất hiện).
- `out/cn-quoted-literals.txt` — 1.933 chuỗi CJK nằm trong dấu nháy (nhãn UI trực tiếp, ưu tiên dịch cái này).

Quy trình đề xuất:
1. Dịch `cn-quoted-literals.txt` → bảng Trung→Việt.
2. Thay chuỗi trong các `block_*.js` (ưu tiên 06/16/19/01/05 — nơi tập trung CJK).
3. Ghép lại thành `index.html` (chèn từng block về đúng vị trí `<script>`), đóng lại APK + ký.
4. **Font:** chỉ có 1 font nhúng — phải kiểm nó có glyph dấu tiếng Việt chưa; nhiều khả năng chưa → cần thay font hỗ trợ Việt, nếu không "ă â ê ô ơ ư đ" sẽ lỗi.

## Lưu ý
- Game chủ yếu offline/DOM; chưa thấy endpoint mạng (request family = 0). An toàn để sửa tĩnh.
- `index.html` gốc 42MB đã xoá khỏi `extract/` để tiết kiệm ổ; dựng lại từ `js/` + APK gốc khi cần.

Trạng thái: reverse xong, đã có dữ liệu để Việt hóa. Chưa sửa gì.
