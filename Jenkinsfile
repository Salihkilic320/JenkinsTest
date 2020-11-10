//def githubLink 'https://github.com/Salihkilic320/JenkinsTest.git'
// Pipline = Must be top-level
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
            // Steps the code need to follow
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
            }
        }
        // Checkout the code frome github     
        stage('CheckoutCode') 
        {
            steps 
            {
                // ToDo zoek op hoe je de code taal checkt
                echo 'Checking out the code..'
                withMaven(maven : 'maven_3_5_0') 
                {
                    sh 'mvn clean compile'
                }
            }
        }
        // Test het code frome github     
        stage('Test') 
        {
            steps
            {
                echo 'Testing the code..'
                /* `make check` returns non-zero on test failures,
                * using `true` to allow the Pipeline to continue nonetheless
                */
                //sh 'make check || true' 
                withMaven(maven : 'maven_3_5_0') 
                {
                    sh 'mvn test'
                }
            }
        }
        // Build the code
        stage('Build') 
        {
            steps 
            {
                echo 'Building the code..'
                //sh 'make'
                maven(maven : 'maven_3_5_0') 
                {
                    sh 'mvn deploy'
                }
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
            }
        }
        // Notify user
        stage('NotifyUser') 
        {
            steps 
            {
                echo 'Notify the user...'
                // Execut only wen succes
                success
                {
                    echo 'Dit is een melding voor de user als je dit leest werkt alles WEL succesvol'
                }
                // Execute only wen failure
                failure
                {
                    echo 'Dit is een melding voor de user als je dit leest werkt alles NIET succesvol'
                }
            }
        }
    }
    // After the code ends execute this code
    post
    {
        // Execute always
        // Example message to the user
        always
        {
            echo 'De code is uitgevoerd en de test is klaar'
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
