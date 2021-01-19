pipeline {
    agent any
    tools {
        maven 'Maven 3.6.3'
    }
    stages {
        stage('Build') {
            steps {
                bat 'gradlew build'
            }
            post {
                success {
                echo 'Successfully build program..'
                }
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                bat 'docker -v'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
