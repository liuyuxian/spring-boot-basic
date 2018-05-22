pipeline {
    agent any

    environment {
        NameSpace='jimmy-ali'
    }

    stages {
        stage('Checkout') {
            steps {
                git poll: true, url: 'https://github.com/eserhjm/spring-boot-basic.git'
            }
        }

        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }

        stage('Sonar') {
            steps {
                sh './gradlew sonarqube'
            }
        }

        stage('Build') {
            steps {
                sh './gradlew build'
            }
        }

        stage('Deploy') {
            steps {
                sh 'whoami'
                withCredentials([sshUserPrivateKey(credentialsId: "training_pem", keyFileVariable: 'keyfile')]) {
                    sh "ssh -i $keyfile ubuntu@172.31.12.139 mkdir -p /home/ubuntu/works/$NameSpace"
                    sh "scp -i $keyfile ./build/libs/demo-0.0.1-SNAPSHOT.jar ubuntu@172.31.12.139:/home/ubuntu/works/$NameSpace/demo.jar"
                    sh "ssh -i $keyfile ubuntu@172.31.12.139 'ls /home/ubuntu/works/$NameSpace'"
                    sh "ssh -i $keyfile ubuntu@172.31.12.139 'kill -9 \$(lsof -t -i:8899) 2>&1 &'"
                    sh "ssh -i $keyfile ubuntu@172.31.12.139 'nohup java -jar -Dserver.port=8899 /home/ubuntu/works/$NameSpace/demo.jar > demo.log 2>&1 &'"
                }
            }
        }

        stage('Deploy Test') {
            steps {
                withCredentials([sshUserPrivateKey(credentialsId: "training_pem", keyFileVariable: 'keyfile')]) {
                    sh "ssh -i $keyfile ubuntu@172.31.12.139 'wget http://ec2-52-80-133-153.cn-north-1.compute.amazonaws.com.cn:8899/version'"
                }
            }
        }

    }

}