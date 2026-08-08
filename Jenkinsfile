pipeline {
    agent any

    tools {
        maven 'Maven1'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build with Maven') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('sonarqube') {
                    bat 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:sonar -Dsonar.projectKey=studentclass'
                }
            }
        }
        stage('Docker Build') {
            steps {
                bat 'docker build -t imayak/studentclass:latest .'
            }
        }

        stage('Docker Push') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'e61773e0-39dd-446a-b739-3ea6a7417004',
                    usernameVariable: 'DOCKER_USERNAME',
                    passwordVariable: 'DOCKER_PASSWORD'
                )]) {
                    bat 'docker login -u %DOCKER_USERNAME% -p %DOCKER_PASSWORD%'
                    bat 'docker push imayak/studentclass:latest'
                    }
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