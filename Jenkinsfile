
pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh "chmod +x gradlew"
                sh "./gradlew build"
                sh "cp build/libs/admsystems-1.0-SNAPSHOT.jar ~/Documents/2.jar"
            }
        }
    }
}


