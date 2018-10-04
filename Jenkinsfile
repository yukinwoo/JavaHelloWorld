pipeline {
    agent any
    
    stages {
        stage('Pull Code') {
            steps {
                echo "Pull latest codes from SCM repository ..."
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '821ad9ce-dd67-4b03-9cc6-293e9cb919d6', url: 'https://github.com/yukinwoo/JavaHelloWorld.git']]])
            }
        }
        
        stage('Build') {
            steps {
                echo "Start to build ..."
                sh 'pwd'
                sh "./gradlew build"
            }    
        }
        
        stage('UT Report') {
            steps {
                echo "Publich unit test report ..."
                publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'build/reports/tests/test', reportFiles: 'index.html', reportName: 'HTML Report', reportTitles: ''])

            }
        }
        
        stage('Deploy') {
            environment {
                JENKINS_NODE_COOKIE = "dontkillme"
            }
            steps {
                echo "Start to deploy app ..."
                sh "./gradlew appRun &"
            }
        }
    }
}
