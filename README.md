# SonarQube iOS 代码扫描插件

## 介绍
本仓库作为 SonarQube 的iOS插件，支持导入 SwiftLint 的问题，支持导入 Infer 的报告。
基于 https://github.com/Idean/sonar-swift 二次开发。

## 安装
将 jar 文件放置到 SonarQube 的安装目录下的 `extensions/plugins/` 目录下，然后重启 SonarQube 

## 使用方式
参考以下脚本使用
```shell script
xcodebuild clean build -workspace app.xcworkspace -scheme scheme -destination 'generic/platform=iOS' COMPILER_INDEX_STORE_ENABLE=NO | tee xcodebuild.log > /dev/null
xcpretty -r json-compilation-database -o compile_commands.json < xcodebuild.log > /dev/null
# --skip-analysis-in-path 是忽略扫描目录
infer run --skip-analysis-in-path Pods --compilation-database compile_commands.json

# 可选，如果有 swift 语言使用
swiftlint lint > swiftlint.txt
lizard --xml
sonar-scanner -Dsonar.host.url=http://sonarqube -Dsonar.projectKey=app -Dsonar.sources=. -Dsonar.swift.swiftlint.report=swiftlint.txt -Dsonar.swift.lizard.report=lizard-report.xml -Dsonar.swift.infer.report=infer-out/report.json
```