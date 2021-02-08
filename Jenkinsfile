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
                sh 'mvn compile'
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
                sh 'mvn package -DskipTests'
                deploy adapters: [tomcat9(credentialsId: '2dc55763-9fb8-45bc-bc9a-783d8f11f416', path: '', url: 'http://ec2-54-208-23-216.compute-1.amazonaws.com:8080')], contextPath: 'app', war: 'target/*.war'
                }
        }
    }
}
