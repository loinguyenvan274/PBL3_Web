let checkisKhuHoi = document.getElementById("la-khu-hoi")
let ngayVeInputBox = document.getElementById("ngayve");

checkisKhuHoi.addEventListener('change', function () {
    if (this.checked) {
        ngayVeInputBox.disabled = false;
    } else {
        ngayVeInputBox.disabled = true;
    }
});


// cap nhật cái mà chọn tỉnh á
fetch(localStorage.getItem('beURL') + 'Shared/getAllLocation', {
    method: "GET"
}).then(response => {
    if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
    }
    return response.json()
}).then(data => {
    document.querySelectorAll('.chon-diem').forEach(element => {
        for (let i = 0; i < data.length; i++) {
            const newOption = document.createElement('option');
            newOption.value = data[i].id;
            newOption.text = data[i].name;
            newOption.dataset.obj = JSON.stringify(data[i])
            element.appendChild(newOption)
        }
    });

})

const ngaydiInput = document.getElementById('ngaydi');
const ngayveInput = document.getElementById('ngayve');
ngayveInput.addEventListener('change', function () {
    if (ngayveInput.value < ngaydiInput.value) {
        alert('Ngày về phải lớn hơn hoặc bằng ngày đi.');
        ngayveInput.value = '';
    }
});

//sumitform tìm kiếm rồi chuyển trang.
document.getElementById('form-find-chuyen-bay').addEventListener('submit', function (e) {
    e.preventDefault();
     f = e.target.elements;

    sessionStorage.setItem('search-form-data', JSON.stringify({
        isRoundTrip: f['la-khu-hoi'].checked,
        beginLocation :JSON.parse( f['diemkhoihanh'].selectedOptions[0].dataset.obj),
        endLocation: JSON.parse( f['diemden'].selectedOptions[0].dataset.obj),
        departureDate: f['ngaydi'].value,
        returnDate: f['ngayve'].value,  
        adultNumber: f['nguoilon'].value,
        childNumber: f['treemtuhaituoi'].value,
        infantNumber: f['treemduoihaituoi'].value
    }));
    window.location.href = '/danhSachChuyenBay.html';
});
