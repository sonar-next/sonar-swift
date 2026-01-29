# SonarQube API Compatibility

## Current Status

**Plugin Version:** 1.8.0  
**Minimum SonarQube Version:** 9.9 LTS (upgrade in progress)  
**Java Version:** 17  
**Tested With:** Upgrade to Java 17 completed, SonarQube 9.9/10.x testing pending  
**Build Target:** SonarQube API 9.9.0.65466

## SonarQube Version Clarification

There is **no SonarQube version 25**. SonarQube uses a different versioning scheme:

- **6.7 LTS** (May 2017)
- **7.9 LTS** (July 2019) ← **Current plugin target**
- **8.9 LTS** (February 2021)
- **9.9 LTS** (February 2023)
- **10.x** (Latest, 2024+)

If you are referring to "SonarQube 25," you might mean:
- SonarQube 10.x (latest LTS version)
- An internal build or API version number
- A misunderstanding of the version numbering

## Compatibility with Modern SonarQube Versions

### SonarQube 8.x Compatibility

The plugin may work with SonarQube 8.x with Java 17:
- ✅ PropertyDefinition API is compatible (we use the modern API)
- ✅ Sensor API is stable
- ✅ Rules Definition API is compatible
- ⚠️ ProfileImporter deprecated (still works but with warnings)

**Status:** Not tested, upgrade to 9.9+ recommended

### SonarQube 9.x Compatibility

Upgraded to support SonarQube 9.9 LTS:
- ✅ Java 17 support
- ✅ Updated dependencies
- ✅ Modern API usage
- ❌ ProfileImporter removed (requires code changes)

**Status:** Code upgrade complete, testing pending

**Required Changes:**
- Remove ProfileImporter classes (deprecated and removed in 9.x)
- Use JSON-based quality profile definitions instead

### SonarQube 10.x Compatibility

To use SonarQube 10.x:
- ✅ Java 17 required (completed)
- ✅ Updated build configuration (completed)
- ⚠️ Update sonar.version to 10.4.0.87286
- ❌ Additional API changes may be needed
- ❌ Testing required

**Status:** Ready for upgrade from 9.9 baseline

**Changes Needed:**
```xml
<sonarQubeMinVersion>10.0</sonarQubeMinVersion>
<sonar.version>10.4.0.87286</sonar.version>
<sonar-packaging-maven-plugin.version>1.23.0.740</sonar-packaging-maven-plugin.version>
```

## API Features Currently Used

The plugin uses these SonarQube APIs:
- **Plugin API:** `org.sonar.api.Plugin`
- **PropertyDefinition:** Modern configuration API (already migrated from deprecated `@Property`)
- **Sensor API:** `org.sonar.api.batch.sensor.Sensor`
- **Rules Definition:** `org.sonar.api.server.rule.RulesDefinition`
- **Profile Importers:** Quality profile import API
- **Language API:** `org.sonar.api.resources.AbstractLanguage`
- **CPD Analyzer:** Copy-Paste Detection
- **Test Coverage:** Coverage sensor API

## How to Upgrade to Newer SonarQube Versions

To upgrade the plugin for compatibility with newer SonarQube versions:

1. **Update version numbers** in `pom.xml`:
   ```xml
   <sonarQubeMinVersion>X.X</sonarQubeMinVersion>
   <sonar.version>X.X.X.XXXXX</sonar.version>
   <sonar-orchestrator.version>X.X.X.XXXX</sonar-orchestrator.version>
   ```

2. **Check for deprecated APIs:**
   ```bash
   mvn compile 2>&1 | grep -i "deprecated"
   ```

3. **Update deprecated code:**
   - Review SonarQube release notes for breaking changes
   - Update any deprecated API calls
   - Update tests if testing API changed

4. **Test thoroughly:**
   ```bash
   mvn clean test
   mvn package
   ```

5. **Verify plugin functionality:**
   - Install in target SonarQube version
   - Run analysis on test projects
   - Verify rules, profiles, and sensors work correctly

## Recommendation

For production use, we recommend:
- **SonarQube 9.9 LTS** - Current upgrade target, requires ProfileImporter removal ⚠️
- **SonarQube 10.x** - Ready for upgrade after 9.9 validation
- **Java 17** - Now required for all versions ✅

## Upgrade Guide

For detailed upgrade instructions, see [UPGRADE_GUIDE.md](UPGRADE_GUIDE.md)

## Known Limitations

- Plugin now requires Java 17 (no longer supports Java 8)
- ProfileImporter API removed in SonarQube 9.x (code changes required)
- SonarQube dependencies not available in Maven Central (requires SonarSource repository access)
- Some test dependencies may need updates for newer SonarQube versions

## Change Log

### Version 1.8.0 (In Progress)
- ✅ Upgraded to Java 17
- ✅ Updated Maven compiler plugin to 3.11.0
- ✅ Updated all dependencies to Java 17 compatible versions
- ✅ Updated SonarQube API target to 9.9.0.65466
- ⚠️ ProfileImporter removal pending
- ⚠️ Testing with SonarQube 9.9/10.x pending

### Version 1.7.0 (Previous)
- Upgraded from SonarQube 6.7 to 7.9
- Replaced @Property annotations with PropertyDefinition
- Added StaxMate dependencies

## Further Information

For SonarQube API documentation:
- [Plugin API Documentation (Latest)](https://docs.sonarqube.org/latest/extend/developing-plugin/) - Note: Shows latest version docs
- [Plugin API Documentation (7.9)](https://docs.sonarqube.org/7.9/extend/developing-plugin/) - Specific to current target version
- [SonarQube Release Notes](https://www.sonarqube.org/downloads/)
- [API Javadoc (7.9)](https://javadoc.io/doc/org.sonarsource.sonarqube/sonar-plugin-api/7.9)

## Questions or Issues?

If you need support for a specific SonarQube version, please:
1. Specify the exact SonarQube version number (e.g., 9.9, 10.3)
2. Describe any error messages or compatibility issues
3. Indicate if this is for production use or testing
