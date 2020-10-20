pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh '''pipeline {
    agent { docker { image \'node:6.3\' } }
    stages {
        stage(\'build\') {
            steps {
                sh \'npm --version\'
            }
        }
    }
}'''
        }
      }

      stage('test') {
        environment {
          CI = 'true'
        }
        steps {
          sh './jenkins/scripts/test.sh'
        }
      }

    }
  }