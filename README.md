# 🧪 Selenium Tooltip Automation Framework

<div align="center">

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=java)
![Selenium](https://img.shields.io/badge/Selenium-4.35.0-43B02A?style=for-the-badge&logo=selenium)
![TestNG](https://img.shields.io/badge/TestNG-7.x-FF6B35?style=for-the-badge&logo=testng)
![Maven](https://img.shields.io/badge/Maven-3.8+-C71A36?style=for-the-badge&logo=apache-maven)
![Status](https://img.shields.io/badge/Status-✅%20Completed-28a745?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)

**A Production-Ready Automation Framework for Bootstrap Tooltips with Advanced Error Handling**

[Features](#-features) • [Installation](#-installation) • [Usage](#-usage) • [Architecture](#-architecture) • [Contributing](#-contributing)

</div>

---

## 🎯 Project Overview

This repository demonstrates a **enterprise-grade Selenium WebDriver automation framework** specifically designed to automate and validate **Bootstrap tooltips** with real-world practices and patterns.

### 🔗 Live Application Under Test
👉 **[Practice Application](https://practice.expandtesting.com/tooltips)**

### Why This Project?
- 🏆 **Real-world complexity**: Dynamic DOM elements, hover interactions, stale element handling
- 🎓 **Best practices**: POM, listeners, utilities, structured architecture
- 🚀 **Production-ready**: Retry logic, explicit waits, comprehensive error handling
- 📊 **Interview-friendly**: Great portfolio piece for SDET roles

---

## ✨ Core Features

| Feature | Description | Status |
|---------|-------------|--------|
| 🖱️ **Hover Automation** | Dynamic tooltip triggering via mouse hover actions | ✅ |
| 📸 **Auto Screenshot on Failure** | ITestListener captures failures automatically | ✅ |
| 📷 **Manual Screenshot Support** | Programmatic screenshot capture on demand | ✅ |
| 🏗️ **Page Object Model** | Scalable, maintainable test architecture | ✅ |
| ⏳ **Explicit Waits** | Intelligent WebDriverWait for dynamic elements | ✅ |
| 🔄 **Retry Logic** | StaleElementReferenceException handling | ✅ |
| 🧪 **TestNG Integration** | Parallel execution, listeners, reporting | ✅ |
| 📦 **Maven Build** | Automated compilation and execution | ✅ |
| 🎯 **Java 21 Compatible** | Modern Java features and optimizations | ✅ |

---

## 📊 Tooltips Automated

```
┌─────────────────────────────────────────────────────────┐
│  ✅ Tooltip on Top       │  ✅ Tooltip on End           │
│  ✅ Tooltip on Bottom    │  ✅ Tooltip on Start         │
│  ✅ Tooltip with HTML    │                              │
└─────────────────────────────────────────────────────────┘
```

Each tooltip is **triggered via mouse hover** and **validated against dynamically rendered text**.

---

## 📁 Project Structure

```
selenium-tooltip-demo/
│
├── 📄 pom.xml
├── 📄 README.md
│
└── src/test/java/com/practice/
    │
    ├── 🏗️ base/
    │   └── BaseTest.java                    # WebDriver initialization & teardown
    │
    ├── 📄 pages/
    │   └── TooltipsPage.java                # Page Object Model for tooltips
    │
    ├── 🧪 tests/
    │   ├── TooltipsTest.java                # Test cases & validations
    │   └── ScreenshotListener.java          # Automatic screenshot on failure
    │
    ├── 🛠️ utils/
    │   └── ScreenshotUtil.java              # Screenshot capture utility
    │
    └── 📸 target/screenshots/               # Auto-generated screenshots
```

---

## 🚀 Installation

### Prerequisites
- ✅ Java 21+
- ✅ Maven 3.8+
- ✅ Chrome/Chromium Browser
- ✅ Git

### Step 1️⃣: Clone Repository
```bash
git clone https://github.com/yourusername/selenium-tooltip-demo.git
cd selenium-tooltip-demo
```

### Step 2️⃣: Install Dependencies
```bash
mvn clean install
```

### Step 3️⃣: Verify Setup
```bash
mvn -version
java -version
```

---

## 🧪 Usage

### ▶️ Run All Tests
```bash
mvn test
```

### ▶️ Run Specific Test
```bash
mvn test -Dtest=TooltipsTest
```

### ▶️ Run from IDE
**Eclipse/IntelliJ:**
1. Right-click `TooltipsTest.java`
2. Select `Run as` → `TestNG Test`
3. View results in console

### 📊 View Screenshots
```bash
ls target/screenshots/
```

---

## 🧠 Technical Implementation

### Problem: Dynamic Bootstrap Tooltips
```
❌ Challenges:
   • Tooltips created/destroyed on hover (Dynamic DOM)
   • StaleElementReferenceException
   • Timing issues with element visibility
```

### ✅ Our Solution
```
✅ Strategies Implemented:
   ├─ Re-locate tooltip after hover
   ├─ Explicit WebDriverWait (10s timeout)
   ├─ Retry mechanism (3 attempts)
   ├─ Action chains for hover simulation
   └─ Scroll to element before interaction
```

### Code Example: Robust Tooltip Handling
```java
// ✅ Handle dynamic DOM elements
public String getTooltipText(WebElement trigger) {
    Actions actions = new Actions(driver);
    actions.moveToElement(trigger).perform();
    
    // Re-locate tooltip after hover
    WebElement tooltip = wait.until(
        ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector("[role='tooltip']")
        )
    );
    
    return tooltip.getText();
}
```

---

## 📊 Sample Test Execution

```
[INFO] -------------------------------------------------------
[INFO] Running com.practice.tests.TooltipsTest
[INFO] -------------------------------------------------------

✅ testTooltipOnTop ..................... PASSED
   → Tooltip Text: "Tooltip on top"
   → Screenshot: target/screenshots/tooltip_top.png

✅ testTooltipOnEnd ..................... PASSED
   → Tooltip Text: "Tooltip on end"

✅ testTooltipOnBottom .................. PASSED
   → Tooltip Text: "Tooltip on bottom"

✅ testTooltipOnStart ................... PASSED
   → Tooltip Text: "Tooltip on start"

✅ testTooltipWithHTML .................. PASSED
   → Tooltip Text: "Tooltip with HTML"

✅ testManualScreenshot ................. PASSED
   → Screenshot: target/screenshots/success_example.png

[INFO] -------------------------------------------------------
[INFO] Tests run: 6, Failures: 0, Skipped: 0
[INFO] -------------------------------------------------------
[INFO] BUILD SUCCESS
```

---

## 🏗️ Architecture & Design Patterns

### 🔷 Page Object Model (POM)
```
TooltipsPage.java
├── Page elements (locators)
├── Page methods (actions)
└── Interaction logic
```

### 🔷 Base Test Class
```
BaseTest.java
├── WebDriver initialization
├── Browser setup
└── Teardown & cleanup
```

### 🔷 Listener Pattern
```
ScreenshotListener.java
├── ITestListener implementation
├── onTestFailure() → Auto screenshot
└── onTestSuccess() → Log success
```

### 🔷 Utility Classes
```
ScreenshotUtil.java
├── takeScreenshot()
├── File management
└── Timestamp handling
```

---

## 🎓 Key Learning Outcomes

After studying this project, you'll understand:

| Concept | Coverage |
|---------|----------|
| 🖱️ **Selenium Actions API** | Hover, mouse movement, interactions |
| ⏳ **Explicit Waits** | ExpectedConditions, WebDriverWait |
| 🏛️ **Design Patterns** | Page Object Model, Listener, Utility |
| 🧪 **TestNG Features** | Annotations, listeners, test execution |
| 🖼️ **Screenshot Capture** | Failure diagnostics, TakesScreenshot |
| 🔄 **Error Handling** | Retry logic, stale element handling |
| 📦 **Maven** | POM, dependencies, plugins, build lifecycle |
| 🐛 **Debugging** | Logs, screenshots, console output |

---

## 🎯 Perfect For

- ✅ **QA Automation Engineers** → Learn production patterns
- ✅ **SDET Interviews** → Impress with real-world solutions
- ✅ **Portfolio Projects** → Showcase your skills on GitHub
- ✅ **Selenium Learning** → Advanced concepts with examples
- ✅ **Framework Design** → Scalable architecture reference

---

## 🔧 Configuration

### Browser Setup
Edit `BaseTest.java` to change browsers:

```java
// Chrome (default)
options = new ChromeOptions();

// Firefox
options = new FirefoxOptions();

// Edge
options = new EdgeOptions();
```

### Timeout Settings
```java
// Modify in BaseTest.java
Duration timeout = Duration.ofSeconds(10);  // Change as needed
```

### Headless Mode
```java
options.addArguments("--headless");
```

---

## 📋 Dependencies

```xml
<dependencies>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.35.0</version>
    </dependency>
    
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.x</version>
    </dependency>
</dependencies>
```

---

## 🤝 Contributing

We love contributions! Here's how:

1. 🍴 **Fork** the repository
2. 🌿 **Create** a feature branch (`git checkout -b feature/amazing-feature`)
3. 💻 **Commit** changes (`git commit -m 'Add amazing feature'`)
4. 🚀 **Push** to branch (`git push origin feature/amazing-feature`)
5. 📤 **Create** a Pull Request

### Enhancement Ideas
- 🎨 Add Extent Reports
- 🎥 Implement visual testing
- ⚙️ CI/CD pipeline integration
- 🌍 Cross-browser testing
- 📱 Mobile automation

---

## 📚 Resources & Documentation

- 🔗 [Selenium Documentation](https://www.selenium.dev/documentation/)
- 🔗 [TestNG Documentation](https://testng.org/doc/)
- 🔗 [Maven Documentation](https://maven.apache.org/guides/)
- 🔗 [Bootstrap Tooltips](https://getbootstrap.com/docs/5.0/components/tooltips/)

---

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 👨‍💻 Author

**Saran Kumar**

🔗 Automation Engineer | Selenium | Cypress | API | Framework Designer

- 🌐 [GitHub](https://github.com/yourusername)
- 💼 [LinkedIn](https://linkedin.com/in/yourprofile)
- 📧 Email: your.email@example.com

---

## ⭐ Show Your Support

If this project helped you, please:

- ⭐ **Star** this repository
- 🍴 **Fork** it
- 💬 **Share** with your network
- 🐛 **Report** issues
- 💡 **Suggest** improvements

<div align="center">

### Made with ❤️ by Saran Kumar

**Happy Testing! 🚀**

</div>
