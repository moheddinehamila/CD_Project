pipeline {
    environment {
	registry = "50350423/springbootapp"
	registryCredential = 'dockerhib_id'
	dockerImage = '${registry}:${BUILD_NUMBER}'
	    }
    agent any
    stages{ 
	stage('clone & clean repo'){
	   steps {
		sh " rm -rf CD_Project"
		sh " git clone https://github.com/moheddinehamila/CD_Project"	 
		sh "mvn clean -f CD_Project"
		 }		
	}

	stage('Create JAR file & Build docker image'){
	   steps {
		sh "mvn package -f CD_Project"
		script {docker.build("$dockerImage" , 'CD_Project/.')}
		 } 
	}
	    
	stage('Push docker Image to dockerHub') {
	   steps{    
		script {
			docker.withRegistry( '', registryCredential ) {
         			sh "docker push $dockerImage"}
    			}
  		}
	}
	    
 	stage('Run Container on EC2 using Ansible') {
           steps{
    		ansiblePlaybook credentialsId: 'private-key', 
    		disableHostKeyChecking: true, installation: 'ansible', 
    		inventory: 'CD_Project/ansible/configs',
    		playbook: 'CD_Project/ansible/playbook.yaml',
    		extras: '--extra-vars image_name=$dockerImage'
		echo 'You can test the application using this link==> http://ec2-54-174-159-41.compute-1.amazonaws.com/'   
  		}
		}
    }
}
