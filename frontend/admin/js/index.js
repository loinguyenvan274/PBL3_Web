import loadPlane from '../contents/dom/plane.js';
import loadFlightJS from '../contents/dom/flight.js';
import loadAccountView from '../contents/dom/account_view.js';
import loadRoleView from '../contents/dom/roleView.js';
import loadUserView from '../contents/dom/user_view.js';
import loadCreateBookingView from '../contents/dom/create_booking_view.js';
import loadBookedView from '../contents/dom/booked_view.js';
import { logout } from '../../APIs/auth.js';
const barButtons = {
    planeBarBtn: {
        html: 'contents/plane.html',
        jsFunction: loadPlane
    },
    flightBarBtn: {
        html: 'contents/flight.html',
        jsFunction: loadFlightJS

    },
    accountBarBtn: {
        html: 'contents/accountView.html',
        jsFunction: loadAccountView,
    },
    roleBarBtn: {
        html: 'contents/roleView.html',
        jsFunction: loadRoleView,
    },
    userBarBtn: {
        html: 'contents/user_view.html',
        jsFunction: loadUserView,
    },
    createBookingBarBtn: {
        html: 'contents/create_booking_view.html',
        jsFunction: loadCreateBookingView,
    },
    viewBookedBarBtn: {
        html: 'contents/booked_view.html',
        jsFunction: loadBookedView,
    }
}


async function setContent(key) {
    const mainContent = document.getElementById('main-content');
    mainContent.innerHTML = await getHTMLFromFile(barButtons[key].html);
    //load js
    barButtons[key].jsFunction();
}


async function getHTMLFromFile(filePath) {
    const data = await fetch(filePath);
    return await data.text();

}
window.addEventListener('load', () => {
    setContent('planeBarBtn');
})
window.setContent = setContent;

window.addEventListener('error', function (event) {
    console.error("Lỗi xảy ra:");
    console.log("Message:", event.message);
    console.log("File:", event.filename);
    console.log("Line:", event.lineno);
    console.log("Column:", event.colno);
    console.log("Error Object:", event.error);
});

window.addEventListener('unhandledrejection', function (event) {
    console.error("Lỗi Promise không được bắt:");
    console.log("Reason:", event.reason);
    if (event.reason.response.data.code == 'LOGIN_REQUIRED') {
        showNotification('Vui lòng đăng nhập lại');
        // window.location.href = '/login/';
    } else {

        console.log("event.reason -----", event.reason);
        if (event.reason.response.data != null) {
            showNotification('Lỗi: ' + event.reason.response.data.message);
        } else if (event.reason.response != null) {
            showNotification('Lỗi: ' + event.reason.response.data);
        }

    }
});

function showNotification(message) {
    const container = document.getElementById('notification-container');
    const box = document.createElement('div');
    box.style.background = '#005a9e';
    box.style.color = '#fff';
    box.style.padding = '16px 24px';
    box.style.borderRadius = '10px';
    box.style.boxShadow = '0 2px 8px rgba(0,0,0,0.15)';
    box.style.marginBottom = '10px';
    box.style.fontSize = '16px';
    box.style.display = 'flex';
    box.style.alignItems = 'center';
    box.innerHTML = `<span style="margin-right: 8px;">&#9432;</span> <b>Notice</b><br><span> ${message}</span>`;
    container.appendChild(box);

    setTimeout(() => {
        box.remove();
    }, 3000);
}

async function logoutApp() {
    await logout();
    window.location.href = '/login/';
}
window.logoutApp = logoutApp;