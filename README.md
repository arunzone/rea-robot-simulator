# Toy robot simulator

## Prerequisite

maven 3.6.2 Jdk 14

---
## How to use?

### Run test
<blockquote>
mvn clean verify
</blockquote>

#### Coverage report
Code coverage report is available in
<blockquote>
target/site/jacoco/index.html
</blockquote>

---

## Quality

### Findbugs

`mvn findbugs:gui`

### checkstyle

`mvn checkstyle::check`

### pmd

`mvn pmd::pmd`

---

### Practices

Had pre-commit git hook which run `mvn clean verify` before pushing so every push ensure better quality code   
Used `jacoco` code coverage tool to fail build when code coverage is compromised
