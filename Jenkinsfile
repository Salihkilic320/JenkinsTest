def githubLink 'https://github.com/Salihkilic320/JenkinsTest.git'
def mailAdres 'mark.benjamins@student.nhlstenden.com'
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
    //Parameterize your Build
    parameters
    {
        //string(name: 'VERSION', defaultValue: '', description: '')
        //choice(name: 'VERSION', choice:  ['1.0', '1.1', '1.2'], description: '')
        //booleanParam(name: 'executeTest', defaultValue: true, description: '')
    }
    // Access build tools for your projects
    tools
    {
        // maven 'Maven'
        // gradle
        // jdk
    }
    // Stage = Where the works happens
    stages 
    { 
         // Get the code from github
        stage('GetCodeFromGit') 
        {
            checkout
            (
                [
                    $class: 'GitSCM', branches: [[name: '*/master']], 
                    doGenerateSubmoduleConfigurations: false, 
                    extensions: [], 
                    submoduleCfg: [], 
                    userRemoteConfigs: [[credentialsId: 'github', url: "${githubLink}"]]
                ]
            )
            // Condition wen to run the specific code
            when
            {
                expression
                {
                    //params.executeTest == true
                    //BRANCH_NAME == 'master' || CODE_CHANGE == true
                }
            }
            // Steps the code need to follow
            steps 
            {
                echo 'Get the code from git..'
                // if je een ${} waarde echo doet gebruik dan altijd "" in plaats van ''
                echo "The version is ${NEW_VERSION}"
                // Goofy script code lijkt op js in HTML
                script
                {
                    
                }
            }
        }
        // Checkout the code frome github     
        stage('CheckoutCode') 
        {
            steps 
            {
                echo 'Checking out the code..'
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
            }
        }
        // Build the code
        stage('Build') 
        {
            steps 
            {
                echo 'Building the code..'
                //sh 'make'
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
                    mail to: mark.benjamins@student.nhlstenden.com, subject: 'The Pipeline succes :)'
                    mail to: "${mailAdres}", subject: 'The Pipeline succes :)'
                    echo 'Dit is een melding voor de user als je dit leest werkt alles WEL succesvol'
                }
                // Execute only wen failure
                failure
                {
                    mail to: mark.benjamins@student.nhlstenden.com, subject: 'The Pipeline failed :('
                    mail to: "${mailAdres}", subject: 'The Pipeline failed :('
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
