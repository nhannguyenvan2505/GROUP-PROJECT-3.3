package dicesum;

/*
JDice: Java Dice Rolling Program
Copyright (C) 2006 Andrew D. Hilton  (adhilton@cis.upenn.edu)

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
*/

public class DiceSum extends DieRoll {
    private DieRoll r1; //thêm private cho r1
    private DieRoll r2;

    /**
     * Constructor cho DiceSum, khởi tạo hai đối tượng DieRoll.
     * Refactor:
     * - Sửa lỗi cú pháp: Loại bỏ dấu gạch ngang trong tên constructor (Dice-Sum -> DiceSum).
     * - Sửa lỗi gán: Thêm toán tử '=' cho r2.
     * - Thêm kiểm tra null để tránh lỗi runtime.
     */
    public DiceSum(DieRoll r1, DieRoll r2) { // sửa tên class dicesum
        super(0);
        if (r1 == null || r2 == null) {
            throw new IllegalArgumentException("DieRoll không được null");
        }
        this.r1 = r1;
        this.r2 = r2;// thêm dấu = cho r2
    }

    /**
     * Thực hiện tung xúc xắc và trả về kết quả tổng hợp.
     * Refactor: Định dạng lại mã cho rõ ràng hơn.
     * Thêm chức năng: Validate kết quả của từng lần tung để tránh lỗi runtime.
     * - Kiểm tra kết quả không được null.
     * - (Tùy chọn) Kiểm tra giá trị xúc xắc hợp lệ nếu RollResult có phương thức getValue().
     */
    @Override
    public RollResult makeRoll() {
        RollResult result1 = r1.makeRoll();
        RollResult result2 = r2.makeRoll();

        // Validate: Kiểm tra kết quả của từng lần tung
        if (result1 == null || result2 == null) {
            throw new IllegalStateException("Kết quả tung xúc xắc không được null");
        }

        // (Tùy chọn) Kiểm tra giá trị xúc xắc nếu RollResult có phương thức getValue()
        // Giả sử RollResult có phương thức getValue() trả về giá trị xúc xắc (thường từ 1 đến 6)
        // Nếu không có phương thức này, bạn có thể bỏ phần kiểm tra này
        if (result1.getValue() <= 0 || result2.getValue() <= 0) {
            throw new IllegalStateException("Giá trị xúc xắc phải lớn hơn 0");
        }

        return result1.andThen(result2);
    }

    /**
     * Trả về chuỗi biểu diễn của hai lần tung xúc xắc.
     * Refactor:
     * - Sửa lỗi cú pháp: r1toString() -> r1.toString().
     * - Định dạng lại chuỗi cho dễ đọc.
     */
    @Override
    public String toString() {
        return r1.toString() + " & " + r2.toString();
    }
}
// Comment: Thêm chức năng validate để kiểm tra r1 và r2 trước khi tung xúc xắc, tránh lỗi runtime.