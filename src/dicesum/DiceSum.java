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
    private DieRoll r1; // Thêm biến r1 bị thiếu
    private DieRoll r2;

    /**
     * Constructor cho DiceSum, khởi tạo hai đối tượng DieRoll.
     * Refactor:
     * - Sửa lỗi cú pháp: Loại bỏ dấu gạch ngang trong tên constructor (Dice-Sum -> DiceSum).
     * - Sửa lỗi gán: Thêm toán tử '=' cho r2.
     * - Thêm kiểm tra null để tránh lỗi runtime.
     */
    public DiceSum(DieRoll r1, DieRoll r2) {
        super(0);
        if (r1 == null || r2 == null) {
            throw new IllegalArgumentException("DieRoll không được null");
        }
        this.r1 = r1;
        this.r2 = r2;
    }

    /**
     * Thực hiện tung xúc xắc và trả về kết quả tổng hợp.
     * Refactor: Định dạng lại mã cho rõ ràng hơn.
     */
    
    @Override
    public RollResult makeRoll() {
        RollResult result1 = r1.makeRoll();
        RollResult result2 = r2.makeRoll();
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