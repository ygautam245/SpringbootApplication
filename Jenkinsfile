pipeline {
agent any



environment{
mvnHome=tool name: 'maven', type: 'maven'



mvnCmd = "${mvnHome}/bin/mvn"
}



stages {
stage('Build') {
steps {
// Get some code from a GitHub repository
git 'https://github.com/ygautam245/SpringbootApplication.git'
bat "${mvnCmd} clean package"
}



}

stage("Running"){
steps {
bat "taskkill /F /PID 7020"


bat "${mvnCmd} spring-boot:run"
}
}
}
}
