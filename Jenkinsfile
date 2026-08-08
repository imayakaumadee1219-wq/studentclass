pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build with Maven') {
    tools {
        maven 'Maven1'
    }
    steps {
        bat 'mvn clean package -DskipTests'
    }
}

        stage('Check Docker') {
            steps {
                bat 'docker --version'
                bat 'docker ps'
            }
        }
    }
}