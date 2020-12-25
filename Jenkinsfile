node  {
        
  stage ('Checkout') {
   git branch: '${gitBranch}', credentialsId: 'git-ssdc-kube', url: '${gitUrl}'
  }
  
  withMaven(maven: 'M3') {
     
      stage('maven package') {
       sh "mvn clean package"
      }

//      stage('sonar scan') {
//       sh "mvn -Dsonar.projectKey=${sonarProjectKey} -Dsonar.projectName=${sonarProjectName} sonar:sonar"
//     }

      stage('docker build') {
       sh "mvn -DimageName=${imageName} -DimageVersion=${imageVersion} dockerfile:build dockerfile:push"
      }

  }
  
}