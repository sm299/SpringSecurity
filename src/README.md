Here’s a **clear servlet container flow diagram for Spring Web (Spring MVC)** along with explanation 👇

---

# 🧩 Servlet Container Flow (Spring Web)

```
Client (Browser / Postman)
        │
        ▼
Servlet Container (Tomcat)
        │
        ▼
DispatcherServlet (Front Controller)
        │
        ▼
Handler Mapping
        │
        ▼
Controller (@Controller / @RestController)
        │
        ▼
Service Layer (Business Logic)
        │
        ▼
Repository Layer (JPA / Hibernate)
        │
        ▼
Database
        │
        ▲
        │
Response (JSON / View)
        │
        ▲
View Resolver (if MVC)
        │
        ▲
DispatcherServlet
        │
        ▲
Servlet Container
        │
        ▲
Client
```

---

# 🧠 Step-by-step explanation

### 1. Client Request

* Comes from browser / API tool

---

### 2. Servlet Container

👉 Example: Apache Tomcat

* Receives HTTP request
* Passes it to Spring

---

### 3. DispatcherServlet (🔥 Core of Spring MVC)

* Front Controller
* Handles ALL incoming requests

---

### 4. Handler Mapping

* Finds which controller method should handle request

---

### 5. Controller

```java
@GetMapping("/users")
public List<User> getUsers() { }
```

* Entry point of your code

---

### 6. Service Layer

* Business logic
* Example: validations, calculations

---

### 7. Repository Layer

* Uses JPA → Hibernate
* Talks to DB

---

### 8. Database

* MySQL / H2 / etc.

---

### 9. Response Flow

* Controller returns:

  * JSON (REST API)
  * View name (MVC)

---

### 10. View Resolver (only for MVC)

* Maps view name → HTML/JSP

---

# 🧠 Key components to remember

* **Servlet Container** → runs your app
* **DispatcherServlet** → central brain
* **Controller** → handles requests
* **Service** → logic
* **Repository** → DB access

---

# 🎯 One-line summary

👉
**Client → Servlet Container → DispatcherServlet → Controller → Service → Repository → DB → Response**<br>


NOW, before Dispatcher servlet, inside servlet container , there comes a filter chain, through which the req gets passed. This mainly holds the security part. These filters can be customized as well.<br>

## CSRF Full Form:
👉 Cross-Site Request Forgery<br>

### What is it (short):
CSRF is a web attack where a logged-in user's browser is tricked into sending unwanted requests to a trusted site — like transferring money or changing a password — without the user's consent.<br>

🛡️ Prevent using CSRF tokens, SameSite cookies, or custom headers.<br>

Now the question comes as , if HTTP by default is stateless, which means each request sent is completely independent, it doesn't remember any past request, then how come this CSRF happens.<br>
If anyone goes to the page source at the logout page, one parameter named "_csrf" is present which is holding the value of an authenticated user. If that can be accessed, anyone can do update. Now another thing is, in presence of Spring security , any POST mapping of data update can't be done only by using username, password. CSRF token will be needed as well.<br>

This CSRF token can be disabled if needed means CSRF check can be disabled at the server side.<br>
Else , samesite srict can be used , which will make sure that no other site can access it.<br>

### Session Creation Policy

```
| Policy      | Creates Session  | Uses Existing Session | Typical Use Case   |
| ----------- | ---------------- | --------------------- | ------------------ |
| ALWAYS      | ✅ Yes            | ✅ Yes                 | Rare               |
| IF_REQUIRED | ⚠️ Only if needed | ✅ Yes                 | Web apps (default) |
| NEVER       | ❌ No             | ✅ Yes                 | Hybrid apps        |
| STATELESS   | ❌ No             | ❌ No                  | REST APIs (JWT)    |

```


