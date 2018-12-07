node {
    def mvnHome
    stage('Preparation') { // for display purposes x
        // Get some code from a GitHub repository
        git branch: 'develop', url: 'https://github.com/ryhofix/springTest.git'
        // Get the Maven tool.
        // ** NOTE: This 'M3' Maven tool must be configured
        // **       in the global configuration.
        mvnHome = tool 'M3'
    }
    stage('Build') {
        configFileProvider([configFile(fileId: 'mvn_nexus', variable: 'MAVEN_SETTINGS')]) {
            // some block
            sh "'${mvnHome}/bin/mvn' -s $MAVEN_SETTINGS -B -DskipTests clean deploy"
        }

    }
}
