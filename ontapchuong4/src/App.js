import React, { useState } from "react";

//1. Tạo lớp sản phẩm
class Product {
  constructor(id, name, price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }
}

//2. Lớp Cart
class Cart {
  constructor(code) {
    this.code = code;
    this.items = [];
  }
  addItem(product, qty) {
    if (qty <= 0) return;
    const existing = this.items.find(item => item.product.id === product.id);
    if (existing) {
      existing.qty += qty;
    } else {
      this.items.push({ product, qty });
    }
  }
  total() {
    return this.items.reduce((sum, item) => sum + item.product.price * item.qty, 0);
  }
  showCart() {
    let output = `=== CHI TIẾT GIỎ HÀNG (${this.code}) ===\n`
    this.items.forEach(item => {
      const lineTotal = item.product.price * item.qty;
      output += `- ${item.product.name} (Mã: ${item.product.id}) | Giá: ${item.product.price}đ | SL: ${item.qty} | Thành tiền: ${lineTotal}đ\n`;

    });
    output += `\n=> TỔNG TIỀN CỦA GIỎ HÀNG: ${this.total()}đ\n`;
    return output;
  }
}

//3. Giao diện hiển thị
export default function App() {
  const [resultDisplay, setResultDisplay] = useState('');
  const runTest = () => {

    const p1 = new Product("SP01", "Bút bi Thiên Long", 5000);
    const p2 = new Product("SP02", "Vở kẻ ngang Campus", 10000);
    const p3 = new Product("SP03", "Thước kẻ 20cm Thiên Long", 7000);

    const cart1 = new Cart("Cart_01");
    cart1.addItem(p1, 2);
    cart1.addItem(p2, 3);
    cart1.addItem(p1, 3);

    let log = "--- Trạng thái CART1 ban đầu ---\n";
    log += cart1.showCart() + "\n"
    const cart2 = cart1;
    cart2.addItem(p3, 5);
    log += "--- Sau khi them thước kẻ vào CART2, in ra CART1 ---\n";
    log += cart1.showCart() + "\n"
    log += "==========================================\n";
    log += "LỜI GIẢI THÍCH KẾT QUẢ:\n";
    log += "Hiện tượng: Khi thêm sản phẩm mới vào cart2, giỏ hàng cart1 cũng bị thay đổi theo (xuất hiện thêm Thước kẻ).\n\n";
    log += "Nguyên nhân: Trong JavaScript, Object (đối tượng) là kiểu dữ liệu tham chiếu (Reference Type). \n";
    log += "Câu lệnh 'cart2 = cart1' không tạo ra một bản sao mới của giỏ hàng, mà chỉ gán địa chỉ bộ nhớ của cart1 cho biến cart2. \n";
    log += "Lúc này, cả cart1 và cart2 cùng trỏ chung vào một đối tượng duy nhất trong bộ nhớ. Do đó, mọi thao tác thay đổi dữ liệu thông qua cart2 cũng chính là thay đổi dữ liệu của cart1 và ngược lại.";
    setResultDisplay(log);
  };

  return (
    <div style={{ padding: '30px', fontFamily: 'Arial, sans-serif', maxWidth: '800px', margin: '0 auto' }}>
      <h2 style={{ color: '#2c3e50' }}>Bài ôn tập chương 4: OOP</h2>
      <p style={{ color: '#555' }}>
        Sinh viên: <strong>Trần Đăng Dương</strong>
      </p>
      <button onClick={runTest} style={{
        padding: '10px 20px',
        backgroundColor: '#3498db',
        color: 'white',
        border: 'none',
        borderRadius: '5px',
        cursor: 'pointer',
        fontWeight: 'bold',
        fontSize: '16px',
        marginBottom: '20px',
      }}>Chạy TEST lớp Cart</button>
      {resultDisplay && (
        <pre style={{
          backgroundColor: '#282c34',
          color: '#abb2bf',
          padding: '20px',
          borderRadius: '8px',
          whiteSpace: 'pre-wrap',
          lineHeight: '1.5',
          fontSize: '15px',
        }}>{resultDisplay}</pre>
      )}
    </div>
  );
}
