pipeline {
    agent any
    tools {
        maven 'my_maven'
    }
    stages {
        stage('Code Compilation') {
            steps {
                echo 'Checking out git repo'
                git url: 'https://github.com/yhanna19/jenkins-project.git'
                echo 'Building code'
                sh 'mvn compile war:war'
            }
        }
        stage('Code Testing'){
            steps{
                echo "Testing Code"
                sh "mvn test"
                junit 'target/surefire-reports/*.xml'
            }
        }
        stage('Deployment'){
            steps{
                echo "Deploying Code"
            }
        }
    }
}
