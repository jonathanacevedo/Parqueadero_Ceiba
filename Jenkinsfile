  
pipeline {
    //Donde se va a ejecutar el Pipeline
    agent {
        label 'Slave_Induccion'
    }
    
    //Opciones especÃ­ficas de Pipeline dentro del Pipeline
    options {
        //Mantener artefactos y salida de consola para el # especÃ­fico de ejecucionesrecientes del Pipeline.
        buildDiscarder(logRotator(numToKeepStr: '3'))
        //No permitir ejecuciones concurrentes de Pipeline
        disableConcurrentBuilds()
    }
    
    //Una secciÃ³n que define las herramientas para â€œautoinstalarâ€� y poner en la PATH
    tools {
        jdk 'JDK8_Centos'
        //Preinstalada en la ConfiguraciÃ³n del Master
        gradle 'Gradle4.5_Centos'
        //Preinstalada en la ConfiguraciÃ³n del Master
    }
    
    //AquÃ­ comienzan los â€œitemsâ€� del Pipeline
    stages{
        stage('Checkout') {
            steps{ 
                echo "------------>Checkout<------------"
                checkout([$class: 'GitSCM',
                         branches: [[name: '*/master']],
                         doGenerateSubmoduleConfigurations: false,
                         extensions: [],
                         gitTool:'Git_Centos',
                         submoduleCfg: [],
                         userRemoteConfigs: [[credentialsId:'GitHub_jonathanacevedo',
                         url:'https://github.com/jonathanacevedo/Parqueadero_Ceiba']]])
            }  
        }
        stage('Unit Tests') {
            steps{
                echo "------------>Unit Tests<------------"
                sh 'gradle --b ./infraestructura/build.gradle test'
                sh 'gradle --b ./aplicacion/build.gradle test'
                sh 'gradle --b ./dominio/build.gradle test'
            }
        }
        stage('Integration Tests') {
            steps {
                echo "------------>Integration Tests<------------"
            }
        }
        stage('Static Code Analysis') {
            steps{
                echo '------------>AnÃ¡lisis de cÃ³digo estÃ¡tico<------------'
                withSonarQubeEnv('Sonar') {
                    sh "${tool name: 'SonarScanner',type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner"}
            }
        }
    
        stage('Build') {
            steps {
                echo "------------>Build<------------"
                sh 'gradle --b ./infraestructura/build.gradle build -x test'
                sh 'gradle --b ./aplicacion/build.gradle build -x test'
                sh 'gradle --b ./dominio/build.gradle build -x test'
            } 
        }
    }
  
    post {
          always {
              echo 'This will always run'
          }
          success {
              echo 'This will run only if successful'
              junit '**/build/test-results/test/*.xml'
          }
          failure {
            echo 'This will run only if failed'
            mail (to: 'jonathan.payares@ceiba.com.co',
                  subject: "FailedPipeline:${currentBuild.fullDisplayName}",
                  body: "Something is wrongwith ${env.BUILD_URL}")
          }
          unstable {
              echo 'This will run only if the run was marked as unstable'
          }
          changed {
              echo 'This will run only if the state of the Pipeline has changed'
              echo 'For example, if the Pipeline was previously failing but is now successful'
          }
      }
}