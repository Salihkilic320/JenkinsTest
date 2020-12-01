pipeline 
{ 
    // Agent = Where to execute "any" 
    agent any

    // Place to store your variable 
    environment
    {
        NEW_VERSION = '1.1'
    }

    // Make the github link into a parameter
    parameters
    {
        string(name: 'GIT', defaultValue: 'https://github.com/Salihkilic320/JenkinsTest.git', description: 'Link to gtihub repository')
    }

    // Stage = Where the works happens
    stages 
    { 
         // Get the code from github
        stage('GetCodeFromGit') 
        {
            steps 
            {
                checkout(
                        [ $class: 'GitSCM', branches: [[name: '*/master']], 
                        doGenerateSubmoduleConfigurations: false, 
                        extensions: [], 
                        submoduleCfg: [], 
                        userRemoteConfigs: [[credentialsId: 'github', 
                        url: "${params.GIT}"]]]
                        )
                
                echo 'Get the code from git..'
            
                // if je een ${} waarde echo doet gebruik dan altijd "" in plaats van ''
                echo "The version is ${NEW_VERSION}"
            }
        }

// https://opsmatters.com/videos/6-how-run-junit-tests-java-project-jenkins
// https://youtu.be/muQmkzNL7B0
// https://gist.github.com/coralogix-resources/6aa50dc8d697adbdcb56b57c90ece3aa
// https://github.com/coralogix-resources/java-rest-api-calculator/tree/master/src/main
        stage('Build')
        {
            steps
            {
                echo 'Build the code..'
                git "${params.GIT}"
                bat 'mvn clean compile'
            }
        }

        // Test by using the Unit test
        stage('UnitTest')
        {
            steps
            {
                echo 'UnitTesting...'
                // the file to use the unit test
                junit '**/src/test/java/DelivererTest.java'
                junit '**/src/test/javaDepotTest.java'
                bat 'mvn test'
            }
            //post
            //{
                //always
                //{
                    //junit '**/target/surefire-reports/TEST-*.xml'
                //}
            //}
        }
    }
///////////////////////////////////

    // After the code ends execute this code
    post
    {
        // Execute always
        always
        {
            echo 'De code is uitgevoerd en de test is klaar'
        }

        // Execut only when succes
        success
        {
            echo 'Dit is een melding die je alleen krijgt als alles WEL succesvol is'

            emailext(
                    subject: "STARTED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'", 
                    body: '''<p><font size="8" color="green">Build Succesfull!</font></p>
                    <p>Check console output at &QUOT;<a href='${BUILD_URL}consoleText'>${JOB_NAME} [${BUILD_NUMBER}]</a>&QUOT;</p>''',
                    recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']]
                    )
        }

        // Execute only when failure
        failure
        {
            echo 'Dit is een melding die je alleen krijgt als alles NIET succesvol is'

            emailext(
                    subject: "STARTED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'", 
                    body: '''<p><font size="8" color="red">Build Failure!</font></p>
                    <p>Check console output at &QUOT;<a href='${BUILD_URL}consoleText'>${JOB_NAME} [${BUILD_NUMBER}]</a>&QUOT;</p>''',
                    recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']]
                    )
        }
    }
}
