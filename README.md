 # DemoQA Form Automation 📘



**🚀 Seamlessly automate form submission on DemoQA!**

This project ensures a smooth user experience by automating form filling, validation, and submission checks using **Selenide + JUnit.** Say goodbye to manual form entry! ✅


**🚀 Features**

**✅ Auto-fills the form ✍️**

**✅ Validates entered data 🔍**

**✅ Handles file uploads 📤**

**✅ Verifies submission results 🎯**

## 🛠 Technologies Used

**🖥️ Java (JDK 11+)**

**🌐 Selenide (Concise Selenium Wrapper)**

**🧪 JUnit 5 (Test Framework)**

**⚙️ Gradle (Build Automation Tool)**

## 📥 Installation & Running Tests

## 🔹 1. Clone the repository:

```

git clone https://github.com/your-username/demoqa-test.git
cd demoqa-test

```

## 🔹 2. Install dependencies:

```

./gradlew build

```

## 🔹 3. Run the tests:

```
./gradlew test

```

Or execute a specific test:

```

./gradlew test --tests DemoqaTest.FillPracticeFormTest

```

## 🧪 Project Structure

```

demoqa-test
│── src
│   ├── test
│   │   ├── java
│   │   │   ├── DemoqaTest.java   # Main test class
│   ├── resources
│   │   ├── testfile.png      # Test file for upload
│── build.gradle                   # Gradle configuration
│── README.md                       # This file

```
## ⚡ Example Test

```

@Test
void FillPracticeFormTest() {
    open("/automation-practice-form");
    $("#firstName").setValue("John");
    $("#lastName").setValue("Doe");
    $("#userEmail").setValue("johndoe@example.com");
    $("label[for='gender-radio-1']").click();
    $("#userNumber").setValue("1234567890");
    $("#submit").click();
    
    $(".modal-content").shouldBe(visible);
    $x("//td[text()='Student Name']/following-sibling::td")
        .shouldHave(text("John Doe"));
}

```

## 🛠 Configuration

Fine-tune testing behavior with the following configuration:

```
@BeforeAll
static void beforeAll(){
    Configuration.browserSize = "1920x1080";
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.pageLoadStrategy = "eager";
    Configuration.holdBrowserOpen = true;
    Configuration.timeout = 5000;
}

```

 🛑 Set Configuration.holdBrowserOpen = false if you don't want to keep the browser open after test execution.

# 📌 Additional Resources

- 📖 Selenide Documentation

- 📖 JUnit 5 Guide

- 📖 Gradle Documentation


<img src="https://media3.giphy.com/media/v1.Y2lkPTc5MGI3NjExbGc3dXBvdDJ6OGVhaGhrb2wwNmRrc25zM2VhYjZvMDZqNTVobHIzdCZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9Zw/po3NDGWuAE33qmWqe3/giphy.gif" alt="Rock Paper Scissors Gameplay" width="400"/>







🎯 Thank you for visiting! Happy testing! 🏆
