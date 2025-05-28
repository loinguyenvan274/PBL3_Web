import { findByCustomerId, findByFromDate } from '../../../APIs/booking.js';

let selectedBooking;

export default async function loadBookedView() {
    selectedBooking = null;

    const searchBtn = document.getElementById("search-btn");
    const searchCustomerIdInput = document.getElementById("search-customer-id");
    const fromDateInput = document.getElementById("from-date");
    const toDateInput = document.getElementById("to-date");
    
    fromDateInput.addEventListener('change', function() {
        toDateInput.min = fromDateInput.value;
        if(toDateInput.value && toDateInput.value < fromDateInput.value) {
            toDateInput.value = '';
        }
    });
    const closeDetailBtn = document.getElementById("close-detail-btn");
    const bookingDetailContainer = document.getElementById("booking-detail-container");

    // Xử lý tìm kiếm
    searchBtn.addEventListener("click", async () => {
        // const customerId = searchCustomerIdInput.value;
        const fromDate = fromDateInput.value;
        const toDate = toDateInput.value;

        let bookings = [];
        // if (customerId) {
        //     bookings = await findByCustomerId(customerId);
        // } else if (fromDate && toDate) {
            bookings = await findByFromDate(fromDate, toDate);
        // }

        loadBookingsTable(bookings);
    });

    // Xử lý đóng form chi tiết
    closeDetailBtn.addEventListener("click", () => {
        bookingDetailContainer.classList.add("hidden");
    });

    // Xử lý click ngoài form chi tiết
    bookingDetailContainer.addEventListener("click", (e) => {
        if (e.target === bookingDetailContainer) {
            bookingDetailContainer.classList.add("hidden");
        }
    });

    // Load dữ liệu ban đầu
    loadBookingsTable([]);
}

// Load danh sách đơn đặt vé vào bảng
function loadBookingsTable(bookings) {
    const table = document.getElementById("booking-table-body");
    table.innerHTML = '';

    bookings.forEach(booking => {
        const row = document.createElement("tr");
        row.className = "bg-blue-100 hover:bg-amber-100";
        row.setAttribute("booking", JSON.stringify(booking));

        row.innerHTML = `
            <td class="border px-2 py-1">${booking.id || ""}</td>
            <td class="border px-2 py-1">${booking.customerWhoBought?.fullName || ""}</td>
            <td class="border px-2 py-1">${formatDate(booking.paymentDate) || ""}</td>
            <td class="border px-2 py-1">${booking.paymentMethod || ""}</td>
            <td class="border px-2 py-1">${formatPrice(booking.totalPrice) || ""}</td>
        `;

        row.addEventListener("click", () => {
            table.querySelectorAll("tr").forEach(r => {
                r.classList.remove("bg-amber-300");
                r.classList.add("bg-blue-100");
            });
            selectedBooking = JSON.parse(row.getAttribute("booking"));
            row.classList.remove("bg-blue-100");
            row.classList.add("bg-amber-300");
            showBookingDetail(selectedBooking);
        });

        table.appendChild(row);
    });
}

// Hiển thị chi tiết đơn đặt vé
function showBookingDetail(booking) {
    const container = document.getElementById("booking-detail-container");
    const customerInfo = document.getElementById("customer-info");
    const paymentInfo = document.getElementById("payment-info");

    // Hiển thị thông tin khách hàng
    customerInfo.innerHTML = `
        <p><strong>Họ tên:</strong> ${booking.customerWhoBought?.fullName || ""}</p>
        <p><strong>Email:</strong> ${booking.customerWhoBought?.email || ""}</p>
        <p><strong>Số điện thoại:</strong> ${booking.customerWhoBought?.phone || ""}</p>
        <p><strong>Địa chỉ:</strong> ${booking.customerWhoBought?.address || ""}</p>
    `;

    // Hiển thị thông tin thanh toán
    paymentInfo.innerHTML = `
        <p><strong>Ngày thanh toán:</strong> ${formatDate(booking.paymentDate) || ""}</p>
        <p><strong>Phương thức thanh toán:</strong> ${booking.paymentMethod || ""}</p>
        <p><strong>Tổng tiền:</strong> ${formatPrice(booking.totalPrice) || ""}</p>
    `;

    container.classList.remove("hidden");
}

// Format ngày tháng
function formatDate(timestamp) {
    if (!timestamp) return "";
    const date = new Date(timestamp);
    return date.toLocaleDateString('vi-VN', {
        year: 'numeric',
        month: '2-digit',
        day: '2-digit',
        hour: '2-digit',
        minute: '2-digit'
    });
}

// Format giá tiền
function formatPrice(price) {
    if (!price) return "";
    return new Intl.NumberFormat('vi-VN', {
        style: 'currency',
        currency: 'VND'
    }).format(price);
}
