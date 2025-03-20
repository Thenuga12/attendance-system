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
