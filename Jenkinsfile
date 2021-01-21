pipeline {
    environment{
            registry = "test"
            registryCredential = "test"
    }
    agent any
    
    stages {
        stage("Parallel Testing"){
            parallel    {
                stage('Build') {
                    steps {
                        sleep 5
                        sh './gradlew clean build'
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
            steps{
                sh 'docker build -t jkd/quarkus-reactive-greeting .'
            }
        }
        stage('Remove Old Image'){
            steps{
                sh 'docker rm $(docker stop $(docker ps -a -q --filter ancestor=jkd/quarkus-reactive-greeting --format="{{.ID}}"))'
            }
        }
            stage('Deploy New Image'){
                steps{
                sh 'docker run -d -p 8083:8080 jkd/quarkus-reactive-greeting'
                }
        }
    }
}
