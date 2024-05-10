pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                script {
                    try {
                        bat 'mvn test'
                    } catch (e) {
                        unstable('Testing failed now')
                        echo 'Tests failed'
                    }
                }
            }
        }
        stage('Cleanup') {
            steps {
                bat 'rmdir /s /q Reports Screenshots'
            }
        }
    }
}