pipeline {
  agent any
  stages {
    stage('Build') {
      parallel {
        stage('Build') {
          steps {
            echo 'This is Build stage'
          }
        }

        stage('Checkout') {
          steps {
            echo 'This checkout'
          }
        }

      }
    }

    stage('Test') {
      steps {
        echo 'This is Test'
      }
    }

    stage('Deploy') {
      steps {
        echo 'This is Deploy'
      }
    }

  }
}