let backEndURL = 'http://localhost:8080/'
localStorage.setItem("beURL", backEndURL)

let checkisKhuHoi = document.getElementById("la-khu-hoi")
let ngayVeInputBox = document.getElementById("ngay-ve-input");

checkisKhuHoi.addEventListener('change', function () {
    if (this.checked) {
        ngayVeInputBox.disabled = false;
    } else {
        ngayVeInputBox.disabled = true;
    }
});


// cap nhật cái mà chọn tỉnh á
fetch(localStorage.getItem('beURL') + 'getDanhSachDiemBay', {
    method: "GET"
}).then(response => {
    if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
    }
    return response.json()
}).then(data => {
    document.querySelectorAll('.chon-diem').forEach(element => {
        for (let i = 0; i < data.length; i++) {
            newOption = document.createElement('option');
            newOption.value = data[i].id;
            newOption.text = data[i].diaDiem;
            element.appendChild(newOption)
        }
    });

})
//sumitform timf kiem
document.getElementById('form-find-chuyen-bay').addEventListener('submit', function (e) {
    e.preventDefault();
    fetch(localStorage.getItem('beURL') + 'getDanhSachChuyenBay', {
        method: "GET"
    }).then(
        response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json()
        }
    ).then(data =>{
        window.location.href = '/timChuyenBay.html';
        
    } )


})