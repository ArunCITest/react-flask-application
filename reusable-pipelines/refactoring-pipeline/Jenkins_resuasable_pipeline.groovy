pipeline{
    agent any
    environment{
    VERSION= '0.1.0'
    RELEASE_VERSION= 'R.2'

    }

    stages{
        stage("Audit Tools"){
            steps{
                sh '''
                    git -version
                    java -version
                    mvn -version
                '''
            }      
        }

        stage("Unit Test"){
            steps{
                dir('./java-tomcat-sample'){
                    sh '''
                        echo "Executing unit test"
                        mvn test
                    '''
                }
            }
        }

        stage('Build'){
            steps{
                sh '''
                    echo "Building version: ${VERSION} and suffix: ${RELEASE_VERSION}
                    echo "Mention your application build code here"
                    mvn -f  java-tomcat-sample/pom.xml clean package
                '''
            }
        }
    }
}



     