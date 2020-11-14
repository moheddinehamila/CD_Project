pipeline {
	agent any
	stages{
		stage('clone and clean repo'){
	           steps {
				sh " rm -rf CD_Project"
				sh " git clone https://github.com/moheddinehamila/CD_Project"
				 
		          	sh "mvn clean -f CD_Project"
			 }

		}
		 
		stage('Deploy'){
		   steps {

			sh "mvn package -f CD_Project"
			sh "docker build -t 50350423/Springbootapplication"
			sh "docker run -name=springbootapp -itd -p 8099:8080 "
			 
		}

	}
}
}
