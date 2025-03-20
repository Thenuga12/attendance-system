const API_URL = "http://localhost:8080/auth/login";
async function login() {
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    const response = await fetch(API_URL, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ username, password })
    });
if (response.ok) {
        const token = await response.text();
        localStorage.setItem("jwt", token);
        localStorage.setItem("username", username);
        window.location.href = "home.html";
    } else {
        document.getElementById("error-msg").innerText = "Invalid username or password!";
    }

       if (!username || !password) {
            alert("Username and password cannot be empty.");
            return;
        }
}
document.addEventListener("DOMContentLoaded", function () {
    checkAuth();
    const username = localStorage.getItem("username");
    if (username && document.getElementById("username-display")) {
        document.getElementById("username-display").innerText = username;
    }
});

function checkAuth() {
    const token = localStorage.getItem("jwt");
    const currentPage = window.location.pathname;

    if (!token && currentPage.includes("home.html")) {
        window.location.href = "login.html";
    }
 }

 function logout() {
     localStorage.removeItem("jwt");
     localStorage.removeItem("username");
     window.location.href = "login.html";
 }
  if (!token && window.location.pathname.includes("home.html")) {
          window.location.href = "login.html";
      }

  if (token && window.location.pathname.includes("login.html")) {
              window.location.href = "home.html";
      }
