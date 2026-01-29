# Upgrade Guide: JDK 17 and SonarQube 9.9/10.x

This document describes the changes made to upgrade the sonar-swift plugin to JDK 17 and SonarQube 9.9/10.x compatibility.

## Overview

**From:** JDK 8 + SonarQube 7.9  
**To:** JDK 17 + SonarQube 9.9/10.x

## Changes Made

### 1. Java Version Upgrade (JDK 8 → JDK 17)

#### Maven Compiler Plugin
```xml
<!-- Updated from -->
<plugin>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.6.2</version>
    <configuration>
        <source>1.8</source>
        <target>1.8</target>
    </configuration>
</plugin>

<!-- To -->
<plugin>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.11.0</version>
    <configuration>
        <source>17</source>
        <target>17</target>
        <release>17</release>
    </configuration>
</plugin>
```

#### Project Encoding
Added UTF-8 encoding properties to ensure consistent builds:
```xml
<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
```

### 2. SonarQube API Upgrade (7.9 → 9.9)

#### Version Properties
```xml
<!-- Updated from -->
<sonarQubeMinVersion>7.9</sonarQubeMinVersion>
<sonar.version>7.9</sonar.version>
<sonar-packaging-maven-plugin.version>1.16</sonar-packaging-maven-plugin.version>

<!-- To -->
<sonarQubeMinVersion>9.9</sonarQubeMinVersion>
<sonar.version>9.9.0.65466</sonar.version>
<sonar-packaging-maven-plugin.version>1.21.0.505</sonar-packaging-maven-plugin.version>
```

### 3. Dependency Updates

All dependencies were updated to Java 17 compatible versions:

| Dependency | Old Version | New Version | Notes |
|------------|-------------|-------------|-------|
| JUnit | 4.10 | 4.13.2 | Security fixes |
| Mockito | 1.10.19 | 4.11.0 | Java 17 compatible |
| AssertJ | 3.5.2 | 3.24.2 | Modern assertions |
| Guava | 17.0 | 32.1.3-jre | Java 17 optimized |
| Logback | 1.2.9 | 1.4.14 | Java 17 compatible |
| SLF4J | 1.7.21 | 2.0.9 | Modern logging |
| Ant | 1.6 | 1.10.14 | Modern build tool |
| Orchestrator | 3.24.0.1993 | 3.40.0.183 | SQ 9.9 compatible |

### 4. Ant Dependency Fix

Fixed the Ant dependency groupId across all modules:

```xml
<!-- Changed from -->
<dependency>
    <groupId>ant</groupId>
    <artifactId>ant</artifactId>
</dependency>

<!-- To -->
<dependency>
    <groupId>org.apache.ant</groupId>
    <artifactId>ant</artifactId>
</dependency>
```

This change was applied to:
- `pom.xml` (root)
- `commons/pom.xml`
- `swiftlang/pom.xml`
- `objclang/pom.xml`
- `javalang/pom.xml`
- `sonar-swift-plugin/pom.xml`

## Code Changes Required

### Profile Importers (Deprecated in SonarQube 8.x, Removed in 9.x)

The following classes use deprecated `ProfileImporter` API and need to be removed:

**Files to Remove or Update:**
- `SwiftLintProfileImporter.java`
- `TailorProfileImporter.java`
- `OCLintProfileImporter.java`
- `FauxPasProfileImporter.java`
- `InferProfileImporter.java` (ObjectiveC)
- `InferProfileImporter.java` (Java)

**Removal from SwiftPlugin.java:**
```java
// Remove these registrations from SwiftPlugin.define():
SwiftLintProfileImporter.class,
TailorProfileImporter.class,
OCLintProfileImporter.class,
FauxPasProfileImporter.class,
InferProfileImporter.class,
```

**Alternative:** Quality profiles should be defined in JSON format in `src/main/resources/org/sonar/l10n/<language>/` directory.

### API Changes to Check

1. **Sensor API**: Should be compatible (we use modern API)
2. **Rules Definition**: Should be compatible (we use modern API)
3. **Language API**: Should be compatible (extends AbstractLanguage)
4. **PropertyDefinition**: Already using modern API (migrated from @Property)

## Upgrading to SonarQube 10.x

To target SonarQube 10.x instead of 9.9, update these versions in `pom.xml`:

```xml
<sonarQubeMinVersion>10.0</sonarQubeMinVersion>
<sonar.version>10.4.0.87286</sonar.version>
<sonar-packaging-maven-plugin.version>1.23.0.740</sonar-packaging-maven-plugin.version>
```

## Build Requirements

### Prerequisites
- **JDK 17** or higher
- **Maven 3.6+** (3.9+ recommended)
- Access to SonarSource Maven repository (for SonarQube dependencies)

### Maven Repository Configuration

SonarQube artifacts are not available in Maven Central. You need access to the SonarSource repository:

```xml
<repositories>
    <repository>
        <id>sonar</id>
        <url>http://repository.sonarsource.org/content/repositories/sonar</url>
    </repository>
</repositories>
```

### Build Commands

```bash
# Clean build
mvn clean compile

# Run tests
mvn test

# Package plugin
mvn package

# Install to local repository
mvn install
```

## Testing Checklist

After completing the upgrade:

- [ ] **Compile:** `mvn clean compile` succeeds
- [ ] **Tests:** `mvn test` passes all tests
- [ ] **Package:** `mvn package` creates plugin JAR
- [ ] **Manifest:** Verify `Sonar-Version` in JAR manifest
- [ ] **Install:** Test in SonarQube 9.9 (or 10.x)
- [ ] **Scan:** Run analysis with all sensors (SwiftLint, Infer, OCLint, etc.)
- [ ] **Rules:** Verify all rules are loaded
- [ ] **Profiles:** Check quality profiles work
- [ ] **Coverage:** Test coverage reporting
- [ ] **Complexity:** Test complexity metrics

## Known Issues and Workarounds

### Issue 1: SonarSource Repository Access

**Problem:** SonarQube dependencies are not in Maven Central  
**Workaround:** Configure SonarSource repository in settings.xml or pom.xml

### Issue 2: Profile Importers Removed

**Problem:** ProfileImporter API removed in SonarQube 9.x  
**Solution:** Remove importer classes, use JSON profile definitions instead

### Issue 3: Java Module System

**Problem:** Some dependencies may have module-info.class conflicts  
**Workaround:** Use maven-shade-plugin to exclude module-info.class files

## Migration Path

### Option 1: Direct to 9.9 (Recommended)
1. Apply all changes from this guide
2. Remove ProfileImporter classes
3. Test in SonarQube 9.9

### Option 2: Staged Upgrade
1. **Stage 1:** Upgrade to Java 17 only (keep SQ 7.9)
   - Update compiler plugin
   - Update dependencies
   - Keep `sonar.version=7.9`
2. **Stage 2:** Upgrade to SonarQube 8.9
   - Update to `sonar.version=8.9.0.43852`
   - Test ProfileImporters (deprecated but still work)
3. **Stage 3:** Upgrade to SonarQube 9.9
   - Update to `sonar.version=9.9.0.65466`
   - Remove ProfileImporter classes

### Option 3: Direct to 10.x (Latest)
1. Apply all changes
2. Use SonarQube 10.x versions
3. Remove ProfileImporter classes
4. Test thoroughly

## Verification

After upgrade, verify in SonarQube UI:
1. Plugin appears in Administration > Marketplace > Installed
2. Swift and Objective-C languages are recognized
3. Rules are available for each tool (SwiftLint, Infer, OCLint, etc.)
4. Quality profiles contain rules
5. Analysis completes successfully
6. Issues are reported correctly
7. Coverage metrics display
8. Complexity metrics display

## Rollback

If issues arise, you can rollback by:
1. Revert to previous commit
2. Or manually change versions back to Java 8 + SonarQube 7.9

## Support and Resources

- [SonarQube Plugin API Documentation](https://docs.sonarqube.org/latest/extend/developing-plugin/)
- [SonarQube 9.9 Release Notes](https://docs.sonarqube.org/9.9/setup/upgrade-notes/)
- [SonarQube 10.0 Release Notes](https://docs.sonarqube.org/latest/setup/upgrade-notes/)
- [Java 17 Migration Guide](https://docs.oracle.com/en/java/javase/17/migrate/getting-started.html)

## Contributing

When contributing to this upgrade:
1. Test on both SonarQube 9.9 and 10.x
2. Verify all sensors still work
3. Update tests if API changes affect them
4. Document any breaking changes
5. Update SONARQUBE_COMPATIBILITY.md

## Status

**Current Status:** ⚠️ Partial - Build configuration complete, code changes pending  
**Last Updated:** 2026-01-29  
**Next Steps:** Remove ProfileImporter classes and test with SonarQube 9.9/10.x
