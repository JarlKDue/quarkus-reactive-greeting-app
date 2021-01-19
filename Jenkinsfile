pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v $HOME/.m2:/root/.m2'
        }
    }
    tools {
        maven 'Maven 3.6.3'
    }
    stages {
        stage('Build') {
            steps {
                sh 'gradlew build'
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
                sh 'docker -v'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
