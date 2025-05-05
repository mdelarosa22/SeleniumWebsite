pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        gradle "Gradle"
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/mdelarosa22/SeleniumWebsite.git'

                // Run Gradle clean
                sh "gradle clean"

            }
        }
        stage("Imprimir"){
            steps{
                echo "Test"
            }        
        }
    }
}