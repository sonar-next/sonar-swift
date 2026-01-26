#!/bin/sh
#
# Swift SonarQube Plugin - Enables analysis of Swift and Objective-C projects into SonarQube.
# Copyright © 2015 Backelite (${email})
#
# This program is free software: you can redistribute it and/or modify
# it under the terms of the GNU Lesser General Public License as published by
# the Free Software Foundation, either version 3 of the License, or
# (at your option) any later version.
#
# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU Lesser General Public License for more details.
#
# You should have received a copy of the GNU Lesser General Public License
# along with this program.  If not, see <http://www.gnu.org/licenses/>.
#

# Build and install snapshot plugin in Sonar

# Build first and check status
mvn clean license:format install
if [ "$?" != 0 ]; then
	echo "ERROR - Java build failed!" 1>&2
	exit $?
fi

# Run shell surefire
#shelltest src/test/shell --execdir --diff
#if [ "$?" != 0 ]; then
#	echo "ERROR - Shell surefire failed!" 1>&2
#	exit $?
#fi

# Deploy new version of plugin in Sonar dir
rm sonar-swift-plugin/target/*sources.jar
rm $SONARQUBE_HOME/extensions/plugins/backelite-sonar-swift*
cp sonar-swift-plugin/target/backelite*.jar $SONARQUBE_HOME/extensions/plugins
rm $SONARQUBE_HOME/extensions/plugins/*sources.jar

# macOS + Java SecurityManager: allow WatchService to load the JDK's native nio library.
# Without this, SonarQube's embedded Elasticsearch can crash at startup with:
# AccessControlException ("java.lang.RuntimePermission" "loadLibrary.nio")
if [ "$(uname)" = "Darwin" ] && [ -n "${SONARQUBE_HOME:-}" ]; then
	for policy in \
		"$SONARQUBE_HOME/elasticsearch/config/java.policy" \
		"$SONARQUBE_HOME/conf/es.policy" \
		"$SONARQUBE_HOME/conf/java.policy"
	do
		if [ -f "$policy" ] && ! grep -q "loadLibrary.nio" "$policy"; then
			echo "Patching Java policy to allow loadLibrary.nio: $policy" 1>&2
			printf '\n// Added by sonar-swift build-and-deploy.sh for macOS WatchService\ngrant {\n  permission java.lang.RuntimePermission \"loadLibrary.nio\";\n};\n' >>"$policy"
		fi
	done
fi

# Stop/start Sonar
unset GEM_PATH GEM_HOME
$SONARQUBE_HOME/bin/macosx-universal-64/sonar.sh stop
$SONARQUBE_HOME/bin/macosx-universal-64/sonar.sh start
