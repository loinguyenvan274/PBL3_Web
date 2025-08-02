window.addEventListener('load', () => {
  initTilte();
  createForms();
});
setHandleSumitForm();


function initTilte() {
  const searchFormData = JSON.parse(sessionStorage.getItem('search-form-data'));
  if (!searchFormData) return;

  const { isRoundTrip, beginLocation, endLocation, departureDate, returnDate, adultNumber, childNumber, infantNumber } = searchFormData;

  // const totalPassengers = Number(adultNumber) + Number(childNumber) + Number(infantNumber);
  const totalPassengers = Number(adultNumber);

  const formatDate = (dateStr) => {
    const date = new Date(dateStr);
    return date.toLocaleDateString('vi-VN', {
      weekday: 'short',
      day: 'numeric',
      month: 'numeric'
    });
  };

  const flightInfo = document.querySelector('.flight-info');
  flightInfo.innerHTML = `
      <div class="flight-route">
        <div class="route-item">
          <div class="city-code">${beginLocation.nameCode}</div>
          <div class="city-name">${beginLocation.name}</div>
        </div>
        <div class="route-item">
          <div class="city-code">${endLocation.nameCode}</div>
          <div class="city-name">${endLocation.name}</div>
        </div>
      </div>
      
      <div class="flight-date">
        <div class="date-label">Chuyến đi</div>
        <div class="date-value">${formatDate(departureDate)}</div>
      </div>
      
      ${isRoundTrip ? `
      <div class="flight-date">
        <div class="date-label">Chuyến về</div>
        <div class="date-value">${formatDate(returnDate)}</div>
      </div>` : ''}
      
      <div class="passengers">
        <span class="passenger-label">Hành khách</span>
        <span class="passenger-count">${totalPassengers}</span>
      </div>
      
      `;
  // <div class="booking-info">THÔNG TIN ĐẶT CHỖ</div>

}
function createFormForPerson(title, formNumber) {
  if (formNumber <= 0) return;

  const parentNode = document.querySelector('.customer-form')
  for (i = 1; i <= formNumber; i++) {
    const newDiv = document.createElement('div');
    newDiv.className = 'container-form thong-tin-khach-hang';
    newDiv.innerHTML = `

    <h2 class="section-title">${title + ' ' + i} (người được mua hộ)</h2>  
      <div class="form-row">
        <label class="form-label required">Họ và tên (như trong CCCD/hộ chiếu)</label>
        <input name="fullName" type="text" class="form-input" placeholder="Nhập tên đệm và tên" required>
      </div>      
      <div class="form-row">
          <label class="form-label required">Ngày sinh</label>
          <input name="birthDate" type="date" class="form-input" placeholder="dd/mm/yyyy" required>
          <div class="date-format">Định dạng là Ngày / Tháng / Năm</div>
        </div>
        <div class="form-row">
          <label class="form-label required">Giới tính</label>
          <select name="gender" class="form-input" required>
            <option value="" disabled selected>Chọn giới tính</option>
            <option value="male">Nam</option>
            <option value="female">Nữ</option>
          </select>
        </div>
        <div class="form-row">
          <label class="form-label ">Số điện thoại (nếu có)</label>
          <input name="phone" type="tel" class="form-input" placeholder="Nhập số điện thoại">
        </div>
        <div class="form-row">
          <label class="form-label ">Email (nếu có)</label>
          <input name="email" type="email" class="form-input" placeholder="Nhập email">
        </div>
        <div class="form-row">
          <label class="form-label ">Căn cước công dân/hộ chiếu (nếu có)</label>
          <input name="idCard" type="tel" class="form-input" placeholder="Nhập số căn cước công dân/hộ chiếu">
        </div>
       
    `
    parentNode.appendChild(newDiv)
  }
}
function createFormForMainPerson() {

  const parentNode = document.querySelector('.customer-form')

  const newDiv = document.createElement('div');
  newDiv.className = 'container-form thong-tin-khach-hang';
  newDiv.innerHTML = `

    <h2 class="section-title">Hành khách đại diện mua</h2>  
      <div class="form-row">
        <label class="form-label required">Họ và tên (như trong CCCD/hộ chiếu)</label>
        <input name="fullName" type="text" class="form-input" placeholder="Nhập tên đệm và tên" required>
      </div>      
      <div class="form-row">
          <label class="form-label required">Ngày sinh</label>
          <input name="birthDate" type="date" class="form-input" placeholder="dd/mm/yyyy" required>
          <div class="date-format">Định dạng là Ngày / Tháng / Năm</div>
        </div>
        <div class="form-row">
          <label class="form-label required" >Giới tính</label>
          <select name="gender" class="form-input" required>
           <option value="" disabled selected>Chọn giới tính</option>
            <option value="MALE">Nam</option>
            <option value="FEMALE">Nữ</option>
          </select>
        </div>
        <div class="form-row">
          <label class="form-label required">Số điện thoại</label>
          <input name="phone" type="tel" class="form-input" placeholder="Nhập số điện thoại" required>
        </div>
        <div class="form-row">
          <label class="form-label required">Email</label>
          <input name="email" type="email" class="form-input" placeholder="Nhập email" required>
        </div>
        <div class="form-row">
          <label class="form-label required">Căn cước công dân/hộ chiếu</label>
          <input name="idCard" type="tel" class="form-input" placeholder="Nhập số căn cước công dân/hộ chiếu" required>
        </div>
    `
  parentNode.appendChild(newDiv)

}
function createForms() {
  const searchFormData = JSON.parse(sessionStorage.getItem('search-form-data'));
  const { adultNumber, childNumber, infantNumber } = searchFormData;
  createFormForMainPerson();
  createFormForPerson('Hành khách', adultNumber - 1);
  // createFormForPerson('Trẻ em', childNumber);
  // createFormForPerson('Trẻ em dưới hai tuổi', infantNumber);
}
function setHandleSumitForm() {
  document.getElementById('infor-customer-form').addEventListener('submit', function (e) {
    e.preventDefault();

    if (!isValidSubmit()) {
      return;
    }

    const customerForms = document.querySelectorAll('.thong-tin-khach-hang');
    const customerData = [];

    customerForms.forEach(form => {
      const fullName = form.querySelector('input[name="fullName"]')?.value || '';
      const dayOfBirth = form.querySelector('input[name="birthDate"]')?.value || '';
      const sex = form.querySelector('select[name="gender"]')?.value || '';
      const phone = form.querySelector('input[name="phone"]')?.value || '';
      const email = form.querySelector('input[name="email"]')?.value || '';
      const cardNumber = form.querySelector('input[name="idCard"]')?.value || '';
      const address = form.querySelector('input[name="address"]')?.value || '';

      customerData.push({
        fullName,
        phone,
        email,
        cardNumber,
        address,
        sex: sex.toUpperCase(),
        dayOfBirth,
        userType: "CUSTOMER"
      });
    });

    sessionStorage.setItem('customerData', JSON.stringify(customerData));
    window.location.href = 'chonDichVu.html';
  });
}

function isValidSubmit() {
  let valid = true;
  const checkAttributes = [
    { selector: 'input[name="phone"]', label: 'số điện thoại' },
    { selector: 'input[name="email"]', label: 'email' },
    { selector: 'input[name="idCard"]', label: 'CMND/CCCD' }
  ];

  checkAttributes.forEach(({ selector, label }) => {
    const duplicated = findDuplicateInputs(selector);
    if (duplicated) {
      duplicated.input1.style.boxShadow = "none";
      duplicated.input1.style.border = "1px solid red";
      duplicated.input2.style.boxShadow = "none";
      duplicated.input2.style.border = "1px solid red";
      valid = false;
      alert('Không thể để hai khách hàng trùng ' + label);
    }
  });

  return valid;
}


function findDuplicateInputs(selector) {
  const map = {};
  let result = null;

  document.querySelectorAll(selector).forEach(input => {
    const value = input.value.trim();
    if (!value) return;

    if (map[value]) {
      result = {
        input1: map[value],
        input2: input
      };
    } else {
      map[value] = input;
    }
  });

  return result;
}
