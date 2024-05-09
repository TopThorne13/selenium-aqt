pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Cleanup') {
            steps {
                sh 'rm -rf Reports Screenshots'
            }
        }
    }
}