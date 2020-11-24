pipeline 
{ 
    // Agent = Where to execute "any" 
    agent any 
    // Place to store your variable 
    environment
    {
        NEW_VERSION = '1.0'
    }
    // Stage = Where the works happens
    stages 
    { 
         // Get the code from github
        stage('GetCodeFromGit') 
        {
            steps 
            {
                checkout([ $class: 'GitSCM', branches: [[name: '*/master']], 
                    doGenerateSubmoduleConfigurations: false, 
                    extensions: [], 
                    submoduleCfg: [], 
                    userRemoteConfigs: [[credentialsId: 'github', 
                    url: 'https://github.com/Salihkilic320/JenkinsTest.git']]])
                echo 'Get the code from git..'
                // if je een ${} waarde echo doet gebruik dan altijd "" in plaats van ''
                echo "The version is ${NEW_VERSION}"
                // Goofy script code lijkt op js in HTML
                //script
                //{
                    
                //}
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
                git 'https://github.com/Salihkilic320/JenkinsTest.git'
                //sh './mvnw clean compile'
                bat 'mvnw clean compile'
            }
        }
        // Test by using the Unit test
        stage('UnitTest')
        {
            steps
            {
                echo 'UnitTesting...'
                // the file to use the unit test
                //junit '**/target/*.xml'

                //sh './mvnw test'
                bat 'mvnw test'
            }
            post
            {
                always
                {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
///////////////////////////////////

        // Notify user
        //stage('NotifyUser') 
        //{
            //steps 
            //{
                //echo 'Notify the user...'
                // Execut only wen succes
                //success
                //{
                    //echo 'Dit is een melding voor de user als je dit leest werkt alles WEL succesvol'
                //}
                // Execute only wen failure
                //failure
                //{
                    //echo 'Dit is een melding voor de user als je dit leest werkt alles NIET succesvol'
                //}
            //}
        //}
    }
    // After the code ends execute this code
    post
    {
        // Execute always
        // Example message to the user
        always
        {
            echo 'De code is uitgevoerd en de test is klaar'
            emailext body: 'A Test EMail', recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], subject: 'Test'
        }
        // Execut only wen succes
        success
        {
            echo 'Dit is een melding die je alleen krijgt als alles WEL succesvol is'
        }
        // Execute only wen failure
        failure
        {
            echo 'Dit is een melding die je alleen krijgt als alles NIET succesvol is'
        }
    }
}
