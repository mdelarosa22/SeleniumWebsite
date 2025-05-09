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

        success {
            emailext (
                to: 'maytedesantiago@gmail.com',
                subject: "✅ Éxito: Job ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: "La ejecución fue exitosa. Ver detalles en ${env.BUILD_URL}",
                mimeType: 'text/plain'
            )
        }

        failure {
            emailext (
                to: 'maytedesantiago@gmail.com',
                subject: "❌ Falla: Job ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: "Falló la ejecución. Verifica el log: ${env.BUILD_URL}",
                mimeType: 'text/plain'
            )
        }
    }
}