# Playwright Java
echo "# PlaywrightJava" >> README.md
  git init
  git add README.md
  git commit -m "first commit"
  git branch -M main
  git remote add origin git@github.com:elysium306/PlaywrightJava.git
  git push -u origin main
  
### …or push an existing repository from the command line
  git remote add origin git@github.com:elysium306/PlaywrightJava.git
  git branch -M main
  git push -u origin main
  

### 

### How to run codegen from CLI
mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexecargs="codegen <website url>"

### JSON Data binding Maven dependencies:
jackson-databind(https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind)[com.fasterxml.jackson.core]

- Then use ObjectMapper instance, and JsonNode instance to get the resonse body, and validate the response