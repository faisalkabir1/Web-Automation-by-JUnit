# Web Automation Project using JUnit & Selenium

This project contains automated test scripts for:

1. Webform Automation for Digital Unite
2. Webform Automation for WP Everest Demo
3. Web Scraping from DSE (Dhaka Stock Exchange) Live Share Price Table

---
### 🚀 Technologies Used

- **Java** – Core programming language for automation
- **JUnit 5** – Test framework used for structuring and running tests
- **Selenium WebDriver** – For browser automation and web interaction
- **Gradle** – Build automation tool
- **IntelliJ IDEA** – Preferred IDE for development
---

## ✅ Test Case Descriptions

### 1️⃣ Digital Unite Webform

🔗 **Link**: [Digital Unite Practice Form](https://www.digitalunite.com/practice-webform-learners)

📋 **Steps**:

- Fill out all required fields
- Upload a file (`test.jpg` – under 2MB)
- Submit the form
- Assert: **"Thank you for your submission!"**

🎬 **Demo Video**:

https://github.com/user-attachments/assets/61e7c02c-d006-4dfd-b062-b214e28f9bb7



📸 **Report Screenshot**: ![img_2](https://github.com/user-attachments/assets/6200ed7f-c5ca-4b42-b589-299127104ed8)


---

### 2️⃣ WP Everest Guest Registration

🔗 **Link**: [WP Everest Demo Form](https://demo.wpeverest.com/user-registration/guest-registration-form/)

📋 **Steps**:

- Fill in: Firstname, Lastname, Email, Gender, DOB, Nationality, Phone, Country (Bangladesh), Agree to T&C
- Submit the form
- Assert successful registration

🎬 **Demo Video**: 

https://github.com/user-attachments/assets/789dd104-3b78-4afa-8dae-40b9eb085c9a



📸 **Report Screenshot**: ![img_1](https://github.com/user-attachments/assets/5cb15384-e9d1-4f85-8271-d22035cd1c88)


---

### 3️⃣ DSE Share Price Table Scraping

🔗 **Link**: [DSE Live Share Price Table](https://dsebd.org/latest_share_price_scroll_by_value.php)

📋 **Steps**:

- Scrape all the cell values (excluding floating header)
- Print values in console
- Save them into `ScrapedData.txt`

🎬 **Demo Video**:

https://github.com/user-attachments/assets/a79110f2-3bba-4c27-8696-290014b0237e



📸 **Report Screenshot**: ![img](https://github.com/user-attachments/assets/b0275af6-9bc8-4952-b618-64f1b0468470)


---

## 🧪 How to Run

Make sure you have:

- **Java 17**
- **Gradle Wrapper**
- **Installed all required dependencies which are added in ``build.gradle`` file**

To run tests:

```bash
./gradlew test

🧪 Run on Windows

```cmd
gradlew.bat test
```

### 🛡️ .gitignore Setup

To avoid pushing unnecessary files, include the following in your `.gitignore`:

```gitignore
.gradle
.idea
build
gradle
logs
```

### 🧑‍💻 Author

**Faisal Kabir**  
SQA Engineer | Automation Tester | Email: ```onlyfaisalkabir@gmail.com```
