pipeline {
    environment{
            registry = "test"
            registryCredential = "test"
    }
    agent {
          docker { image 'maven:latest' }
    }
    
    stages {
        stage("Parallel Testing"){
            parallel    {
                stage('Build') {
                    steps {
                        sleep 5
                        sh 'mvn -v'
                    }
                }
                stage('Unit Test') {
                    steps {
                        sleep 11
                        echo "Finished Unit Testing"
                    }
                }
                stage('Integration Test') {
                    steps {
                        sleep 24
                        echo "Finished Integration Testing"
                    }
                }
                stage('Performance Test') {
                    steps {
                        sleep 35
                        echo "Finished Performance Testing"
                    }
                }
                stage('Code Report Generation'){
                    steps {
                        sleep 15
                        echo "Code Report Generated"
                    }
                }
            }
        }
        stage('Build Docker Image'){
                agent any
            steps{
                sh 'docker --version'
            }
        }
    }
}
