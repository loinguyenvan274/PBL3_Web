import { login } from '../APIs/auth.js';

 function togglePassword() {
    const passwordInput = document.getElementById('password');
    const showPasswordCheckbox = document.getElementById('show-password');
    
    if (showPasswordCheckbox.checked) {
        passwordInput.type = 'text';
    } else {
        passwordInput.type = 'password';
    }
}
window.togglePassword = togglePassword;

// Handle form submission
document.querySelector('form').addEventListener('submit', async function(e) {
    e.preventDefault();
    const memberId = document.getElementById('member-id').value;
    const password = document.getElementById('password').value;

    if (!memberId || !password) {
        alert('Vui lòng nhập đủ thông tin!');
        return;
    }
    const res = await login(memberId, password);
    console.log(res);
    if (res.status === 200) {
        alert('Đăng nhập thành công!');
        window.location.href = '/admin/';
    } else {
        alert('Đăng nhập thất bại!');
    }
    
    // Here you would normally send the data to your server
})


