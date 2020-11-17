pipeline {
    environment {
registry = "50350423/springbootapp"
registryCredential = 'dockerhib_id'
dockerImage = '${registry}:${BUILD_NUMBER}'
}
	agent any
	stages{ 
		stage('clone and clean repo'){
	           steps {
				sh " rm -rf CD_Project"
				sh " git clone https://github.com/moheddinehamila/CD_Project"	 
		          	sh "mvn clean -f CD_Project"
			 }		}
		 
		stage('Deploy'){
		   steps {

			sh "mvn package -f CD_Project"
			script {
			    docker.build("$dockerImage" , 'CD_Project/.') 
	}
}
		    
		}
		stage('Deploy Image') {
  steps{    script {
      docker.withRegistry( '', registryCredential ) {
         sh "docker push $dockerImage"
      }
      sh " docker run  -p 8067:8080   $dockerImage "
    }
  }
}

	}
}
