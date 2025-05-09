pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        gradle "Gradle"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/mdelarosa22/SeleniumWebsite.git'
            }
        }

        stage('Clean') {
            steps {
                bat 'gradlew.bat clean'  // Usa sh si estás en Linux
            }
        }

        stage('Test - @Navigation') {
            steps {
                bat 'gradlew.bat test -Dcucumber.options="--tags @Navigation"'
            }
        }    
    }

    post{
        always{
            echo "Siempre voy a aparecer"
        }
    }
}