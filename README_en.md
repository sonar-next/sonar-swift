# SonarQube iOS Plugin

## 中文：[中文说明](README.md)

## Introduction
Static analysis is a way of inspecting project code without running it, scanning for bugs (e.g : NullPointerException), vulnerabilities, codesmell (e.g : too many lines of code in a method), and inspecting repositories for information such as code duplication, comment rate, comment lines, number of lines of code, complexity, etc. Static code scanning can be performed before code goes live, and is widely used as an inexpensive way to do so. Static code scanning can be performed before the code goes live, and is widely used in CI pipelines due to its low implementation cost.

SonarQube is a static analysis service, https://www.sonarqube.org/, that supports code scanning in all major languages, and its community version is open-sourced on GitHub at https://github.com/SonarSource/sonarqube. However, for some Languages that are not supported by the community versions, such as Objective-C and Swift, are the two languages that we hope to address with static code scanning and analysis.

SonarQube is a full-fledged static analysis service that provides plugin functionality to import results from third-party scanning tools into SonarQube for display. Import of Facebook Infer scan results.

The repository is an iOS static analysis plugin for SonarQube, supporting Objective-C and Swift languages, and supports importing scan analysis results from SwiftLint, Infer, OCLint, Lizard, and Fauxpas tools.

![](docs/quality-profiles.png)
![](docs/quality-profiles-infer.png)
![](docs/infer-bug.png)

## Rule Best Practices
We invited other colleagues within the company to review the existing inference rules, and selected some rules to scan for your reference.
### [Rule Introduction](docs/rule.md)

## Introduction of supported tools
### Infer
Infer is a static analysis tool from Facebook that supports C/C++/Java language scanning.

Link: https://github.com/facebook/infer

### Swiftlint
Swiftlint is a static analysis tool that examines Swift code styles and regulations, basically based on GitHub's Swift Code Style Guide.

Link: https://github.com/realm/SwiftLint

### lizard
The lizard can analyze the circle complexity of Objective-C, generate xml files, and import them into SonarQube's results.

Link: https://github.com/terryyin/lizard

### OCLint
OCLint is a static analysis tool for C/C++/Objective-C. It differs from Infer in that it focuses more on scanning for code specification problems, so we classify the OCLint part of the problem as `codesmell`.

Link: https://github.com/oclint/oclint

### Fauxpas
`Faux Pas` is a commercial software that supports scanning and analysis of Objective-C languages.

Link: http://fauxpasapp.com/

### Download
https://github.com/tal-tech/sonar-swift/releases

### Installation
Place the jar file in the `extensions/plugins/` directory in the SonarQube installation directory, and then restart SonarQube.

## Usage
Refer to the following script to use

1. Execute `xcodebuild` and output the log to the file.

2. Use xcpretty to export logs to json format.

3. Perform infer analysis, configure and ignore third-party code directories, and import the json compilation log you just created.

4. Execute swiftlint and output the result to a file.

5. Output in xml format using lizard

6. Run SonarScanner and fill in the report path.

## Reference Execution Scripts

```shell
xcodebuild clean build -workspace app.xcworkspace -scheme scheme -destination 'generic/platform=iOS' COMPILER_INDEX_STORE_ENABLE=NO | tee xcodebuild.log > /dev/null
xcpretty -r json-compilation-database -o compile_commands.json < xcodebuild.log > /dev/null
# --skip-analysis-in-path is to ignore scanned directories
infer run --skip-analysis-in-path Pods --compilation-database compile_commands.json

# Optional, if swift language is used
swiftlint lint > swiftlint.txt

lizard --xml > lizard-report.xml
sonar-scanner -Dsonar.host.url=http://sonarqube -Dsonar.projectKey=app -Dsonar.sources=. -Dsonar.swift.swiftlint.report=swiftlint.txt -Dsonar.swift.lizard.report=lizard-report.xml -Dsonar.swift.infer.report=infer-out/report.json
```

## requirement

The scan must be run on the macOS operating system.


## Contact 
![](docs/wechat.jpg)
