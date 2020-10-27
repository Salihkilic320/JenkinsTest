pipeline {
  agent any
  stages {
    stage('GetCodeFromGit') {
      steps {
        echo 'Get the code from git..'
        echo "The version is ${NEW_VERSION}"
      }
    }

    stage('CheckoutCode') {
      steps {
        echo 'Checking out the code..'
      }
    }

    stage('Test') {
      steps {
        echo 'Testing the code..'
      }
    }

    stage('Build') {
      steps {
        echo 'Building the code..'
      }
    }

    stage('UnitTest') {
      steps {
        echo 'UnitTesting...'
      }
    }

    stage('NotifyUser') {
      steps {
        echo 'notify the user...'
      }
    }

  }
  environment {
    NEW_VERSION = '1.0'
  }
  post {
    always {
      echo 'De code is uitgevoerd en de test is klaar'
    }

    success {
      echo 'Dit is een melding die je alleen krijgt als alles WEL succesvol is'
    }

    failure {
      echo 'Dit is een melding die je alleen krijgt als alles NIET succesvol is'
    }

  }
}